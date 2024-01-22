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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for GroundingImpedance as outlined for the CQRS pattern. All event handling and query
 * handling related to GroundingImpedance are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by GroundingImpedanceAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("groundingImpedance")
@Component("groundingImpedance-projector")
public class GroundingImpedanceProjector extends GroundingImpedanceEntityProjector {

  // core constructor
  public GroundingImpedanceProjector(
      GroundingImpedanceRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGroundingImpedanceEvent
   */
  @EventHandler(payloadType = CreateGroundingImpedanceEvent.class)
  public void handle(CreateGroundingImpedanceEvent event) {
    LOGGER.info("handling CreateGroundingImpedanceEvent - " + event);
    GroundingImpedance entity = new GroundingImpedance();
    entity.setGroundingImpedanceId(event.getGroundingImpedanceId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGroundingImpedance(entity);
  }

  /*
   * @param	event UpdateGroundingImpedanceEvent
   */
  @EventHandler(payloadType = UpdateGroundingImpedanceEvent.class)
  public void handle(UpdateGroundingImpedanceEvent event) {
    LOGGER.info("handling UpdateGroundingImpedanceEvent - " + event);

    GroundingImpedance entity = new GroundingImpedance();
    entity.setGroundingImpedanceId(event.getGroundingImpedanceId());
    entity.setX(event.getX());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGroundingImpedance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGroundingImpedance(entity);
  }

  /*
   * @param	event DeleteGroundingImpedanceEvent
   */
  @EventHandler(payloadType = DeleteGroundingImpedanceEvent.class)
  public void handle(DeleteGroundingImpedanceEvent event) {
    LOGGER.info("handling DeleteGroundingImpedanceEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GroundingImpedance entity = delete(event.getGroundingImpedanceId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGroundingImpedance(entity);
  }

  /*
   * @param	event AssignXToGroundingImpedanceEvent
   */
  @EventHandler(payloadType = AssignXToGroundingImpedanceEvent.class)
  public void handle(AssignXToGroundingImpedanceEvent event) {
    LOGGER.info("handling AssignXToGroundingImpedanceEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GroundingImpedance entity = assignX(event.getGroundingImpedanceId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGroundingImpedance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGroundingImpedance(entity);
  }

  /*
   * @param	event UnAssignXFromGroundingImpedanceEvent
   */
  @EventHandler(payloadType = UnAssignXFromGroundingImpedanceEvent.class)
  public void handle(UnAssignXFromGroundingImpedanceEvent event) {
    LOGGER.info("handling UnAssignXFromGroundingImpedanceEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GroundingImpedance entity = unAssignX(event.getGroundingImpedanceId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGroundingImpedance(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGroundingImpedance(entity);
  }

  /**
   * Method to retrieve the GroundingImpedance via an GroundingImpedancePrimaryKey.
   *
   * @param id Long
   * @return GroundingImpedance
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GroundingImpedance handle(FindGroundingImpedanceQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGroundingImpedanceId());
  }

  /**
   * Method to retrieve a collection of all GroundingImpedances
   *
   * @param query FindAllGroundingImpedanceQuery
   * @return List<GroundingImpedance>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GroundingImpedance> handle(FindAllGroundingImpedanceQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGroundingImpedance, but only if the id matches
   *
   * @param entity GroundingImpedance
   */
  protected void emitFindGroundingImpedance(GroundingImpedance entity) {
    LOGGER.info("handling emitFindGroundingImpedance");

    queryUpdateEmitter.emit(
        FindGroundingImpedanceQuery.class,
        query ->
            query.getFilter().getGroundingImpedanceId().equals(entity.getGroundingImpedanceId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGroundingImpedance
   *
   * @param entity GroundingImpedance
   */
  protected void emitFindAllGroundingImpedance(GroundingImpedance entity) {
    LOGGER.info("handling emitFindAllGroundingImpedance");

    queryUpdateEmitter.emit(FindAllGroundingImpedanceQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(GroundingImpedanceProjector.class.getName());
}
