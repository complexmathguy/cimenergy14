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
 * Projector for ReactivePower as outlined for the CQRS pattern. All event handling and query
 * handling related to ReactivePower are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by ReactivePowerAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("reactivePower")
@Component("reactivePower-projector")
public class ReactivePowerProjector extends ReactivePowerEntityProjector {

  // core constructor
  public ReactivePowerProjector(
      ReactivePowerRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateReactivePowerEvent
   */
  @EventHandler(payloadType = CreateReactivePowerEvent.class)
  public void handle(CreateReactivePowerEvent event) {
    LOGGER.info("handling CreateReactivePowerEvent - " + event);
    ReactivePower entity = new ReactivePower();
    entity.setReactivePowerId(event.getReactivePowerId());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllReactivePower(entity);
  }

  /*
   * @param	event UpdateReactivePowerEvent
   */
  @EventHandler(payloadType = UpdateReactivePowerEvent.class)
  public void handle(UpdateReactivePowerEvent event) {
    LOGGER.info("handling UpdateReactivePowerEvent - " + event);

    ReactivePower entity = new ReactivePower();
    entity.setReactivePowerId(event.getReactivePowerId());
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
    emitFindReactivePower(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllReactivePower(entity);
  }

  /*
   * @param	event DeleteReactivePowerEvent
   */
  @EventHandler(payloadType = DeleteReactivePowerEvent.class)
  public void handle(DeleteReactivePowerEvent event) {
    LOGGER.info("handling DeleteReactivePowerEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ReactivePower entity = delete(event.getReactivePowerId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllReactivePower(entity);
  }

  /*
   * @param	event AssignValueToReactivePowerEvent
   */
  @EventHandler(payloadType = AssignValueToReactivePowerEvent.class)
  public void handle(AssignValueToReactivePowerEvent event) {
    LOGGER.info("handling AssignValueToReactivePowerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ReactivePower entity = assignValue(event.getReactivePowerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindReactivePower(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllReactivePower(entity);
  }

  /*
   * @param	event UnAssignValueFromReactivePowerEvent
   */
  @EventHandler(payloadType = UnAssignValueFromReactivePowerEvent.class)
  public void handle(UnAssignValueFromReactivePowerEvent event) {
    LOGGER.info("handling UnAssignValueFromReactivePowerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ReactivePower entity = unAssignValue(event.getReactivePowerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindReactivePower(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllReactivePower(entity);
  }

  /**
   * Method to retrieve the ReactivePower via an ReactivePowerPrimaryKey.
   *
   * @param id Long
   * @return ReactivePower
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ReactivePower handle(FindReactivePowerQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getReactivePowerId());
  }

  /**
   * Method to retrieve a collection of all ReactivePowers
   *
   * @param query FindAllReactivePowerQuery
   * @return List<ReactivePower>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ReactivePower> handle(FindAllReactivePowerQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindReactivePower, but only if the id matches
   *
   * @param entity ReactivePower
   */
  protected void emitFindReactivePower(ReactivePower entity) {
    LOGGER.info("handling emitFindReactivePower");

    queryUpdateEmitter.emit(
        FindReactivePowerQuery.class,
        query -> query.getFilter().getReactivePowerId().equals(entity.getReactivePowerId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllReactivePower
   *
   * @param entity ReactivePower
   */
  protected void emitFindAllReactivePower(ReactivePower entity) {
    LOGGER.info("handling emitFindAllReactivePower");

    queryUpdateEmitter.emit(FindAllReactivePowerQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ReactivePowerProjector.class.getName());
}
