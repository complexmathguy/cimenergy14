/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for Reactance as outlined for the CQRS pattern. All event handling and query handling
 * related to Reactance are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ReactanceAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("reactance")
@Component("reactance-projector")
public class ReactanceProjector extends ReactanceEntityProjector {

  // core constructor
  public ReactanceProjector(ReactanceRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateReactanceEvent
   */
  @EventHandler(payloadType = CreateReactanceEvent.class)
  public void handle(CreateReactanceEvent event) {
    LOGGER.info("handling CreateReactanceEvent - " + event);
    Reactance entity = new Reactance();
    entity.setReactanceId(event.getReactanceId());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllReactance(entity);
  }

  /*
   * @param	event UpdateReactanceEvent
   */
  @EventHandler(payloadType = UpdateReactanceEvent.class)
  public void handle(UpdateReactanceEvent event) {
    LOGGER.info("handling UpdateReactanceEvent - " + event);

    Reactance entity = new Reactance();
    entity.setReactanceId(event.getReactanceId());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());
    entity.setValue(event.getValue());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllReactance(entity);
  }

  /*
   * @param	event DeleteReactanceEvent
   */
  @EventHandler(payloadType = DeleteReactanceEvent.class)
  public void handle(DeleteReactanceEvent event) {
    LOGGER.info("handling DeleteReactanceEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    Reactance entity = delete(event.getReactanceId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllReactance(entity);
  }

  /*
   * @param	event AssignValueToReactanceEvent
   */
  @EventHandler(payloadType = AssignValueToReactanceEvent.class)
  public void handle(AssignValueToReactanceEvent event) {
    LOGGER.info("handling AssignValueToReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Reactance entity = assignValue(event.getReactanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllReactance(entity);
  }

  /*
   * @param	event UnAssignValueFromReactanceEvent
   */
  @EventHandler(payloadType = UnAssignValueFromReactanceEvent.class)
  public void handle(UnAssignValueFromReactanceEvent event) {
    LOGGER.info("handling UnAssignValueFromReactanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Reactance entity = unAssignValue(event.getReactanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindReactance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllReactance(entity);
  }

  /**
   * Method to retrieve the Reactance via an ReactancePrimaryKey.
   *
   * @param id Long
   * @return Reactance
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public Reactance handle(FindReactanceQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getReactanceId());
  }

  /**
   * Method to retrieve a collection of all Reactances
   *
   * @param query FindAllReactanceQuery
   * @return List<Reactance>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<Reactance> handle(FindAllReactanceQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindReactance, but only if the id matches
   *
   * @param entity Reactance
   */
  protected void emitFindReactance(Reactance entity) {
    LOGGER.info("handling emitFindReactance");

    queryUpdateEmitter.emit(
        FindReactanceQuery.class,
        query -> query.getFilter().getReactanceId().equals(entity.getReactanceId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllReactance
   *
   * @param entity Reactance
   */
  protected void emitFindAllReactance(Reactance entity) {
    LOGGER.info("handling emitFindAllReactance");

    queryUpdateEmitter.emit(FindAllReactanceQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ReactanceProjector.class.getName());
}
