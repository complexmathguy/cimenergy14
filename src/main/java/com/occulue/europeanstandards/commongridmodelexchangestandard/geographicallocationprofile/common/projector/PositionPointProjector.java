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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PositionPoint as outlined for the CQRS pattern. All event handling and query
 * handling related to PositionPoint are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by PositionPointAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("positionPoint")
@Component("positionPoint-projector")
public class PositionPointProjector extends PositionPointEntityProjector {

  // core constructor
  public PositionPointProjector(
      PositionPointRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePositionPointEvent
   */
  @EventHandler(payloadType = CreatePositionPointEvent.class)
  public void handle(CreatePositionPointEvent event) {
    LOGGER.info("handling CreatePositionPointEvent - " + event);
    PositionPoint entity = new PositionPoint();
    entity.setPositionPointId(event.getPositionPointId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPositionPoint(entity);
  }

  /*
   * @param	event UpdatePositionPointEvent
   */
  @EventHandler(payloadType = UpdatePositionPointEvent.class)
  public void handle(UpdatePositionPointEvent event) {
    LOGGER.info("handling UpdatePositionPointEvent - " + event);

    PositionPoint entity = new PositionPoint();
    entity.setPositionPointId(event.getPositionPointId());
    entity.setSequenceNumber(event.getSequenceNumber());
    entity.setXPosition(event.getXPosition());
    entity.setYPosition(event.getYPosition());
    entity.setZPosition(event.getZPosition());
    entity.setPositionPoints(event.getPositionPoints());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPositionPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPositionPoint(entity);
  }

  /*
   * @param	event DeletePositionPointEvent
   */
  @EventHandler(payloadType = DeletePositionPointEvent.class)
  public void handle(DeletePositionPointEvent event) {
    LOGGER.info("handling DeletePositionPointEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PositionPoint entity = delete(event.getPositionPointId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPositionPoint(entity);
  }

  /*
   * @param	event AssignSequenceNumberToPositionPointEvent
   */
  @EventHandler(payloadType = AssignSequenceNumberToPositionPointEvent.class)
  public void handle(AssignSequenceNumberToPositionPointEvent event) {
    LOGGER.info("handling AssignSequenceNumberToPositionPointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PositionPoint entity = assignSequenceNumber(event.getPositionPointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPositionPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPositionPoint(entity);
  }

  /*
   * @param	event UnAssignSequenceNumberFromPositionPointEvent
   */
  @EventHandler(payloadType = UnAssignSequenceNumberFromPositionPointEvent.class)
  public void handle(UnAssignSequenceNumberFromPositionPointEvent event) {
    LOGGER.info("handling UnAssignSequenceNumberFromPositionPointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PositionPoint entity = unAssignSequenceNumber(event.getPositionPointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPositionPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPositionPoint(entity);
  }

  /*
   * @param	event AssignXPositionToPositionPointEvent
   */
  @EventHandler(payloadType = AssignXPositionToPositionPointEvent.class)
  public void handle(AssignXPositionToPositionPointEvent event) {
    LOGGER.info("handling AssignXPositionToPositionPointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PositionPoint entity = assignXPosition(event.getPositionPointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPositionPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPositionPoint(entity);
  }

  /*
   * @param	event UnAssignXPositionFromPositionPointEvent
   */
  @EventHandler(payloadType = UnAssignXPositionFromPositionPointEvent.class)
  public void handle(UnAssignXPositionFromPositionPointEvent event) {
    LOGGER.info("handling UnAssignXPositionFromPositionPointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PositionPoint entity = unAssignXPosition(event.getPositionPointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPositionPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPositionPoint(entity);
  }

  /*
   * @param	event AssignYPositionToPositionPointEvent
   */
  @EventHandler(payloadType = AssignYPositionToPositionPointEvent.class)
  public void handle(AssignYPositionToPositionPointEvent event) {
    LOGGER.info("handling AssignYPositionToPositionPointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PositionPoint entity = assignYPosition(event.getPositionPointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPositionPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPositionPoint(entity);
  }

  /*
   * @param	event UnAssignYPositionFromPositionPointEvent
   */
  @EventHandler(payloadType = UnAssignYPositionFromPositionPointEvent.class)
  public void handle(UnAssignYPositionFromPositionPointEvent event) {
    LOGGER.info("handling UnAssignYPositionFromPositionPointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PositionPoint entity = unAssignYPosition(event.getPositionPointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPositionPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPositionPoint(entity);
  }

  /*
   * @param	event AssignZPositionToPositionPointEvent
   */
  @EventHandler(payloadType = AssignZPositionToPositionPointEvent.class)
  public void handle(AssignZPositionToPositionPointEvent event) {
    LOGGER.info("handling AssignZPositionToPositionPointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PositionPoint entity = assignZPosition(event.getPositionPointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPositionPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPositionPoint(entity);
  }

  /*
   * @param	event UnAssignZPositionFromPositionPointEvent
   */
  @EventHandler(payloadType = UnAssignZPositionFromPositionPointEvent.class)
  public void handle(UnAssignZPositionFromPositionPointEvent event) {
    LOGGER.info("handling UnAssignZPositionFromPositionPointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PositionPoint entity = unAssignZPosition(event.getPositionPointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPositionPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPositionPoint(entity);
  }

  /*
   * @param	event AssignPositionPointsToPositionPointEvent
   */
  @EventHandler(payloadType = AssignPositionPointsToPositionPointEvent.class)
  public void handle(AssignPositionPointsToPositionPointEvent event) {
    LOGGER.info("handling AssignPositionPointsToPositionPointEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    PositionPoint entity = addToPositionPoints(event.getPositionPointId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPositionPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPositionPoint(entity);
  }

  /*
   * @param	event RemovePositionPointsFromPositionPointEvent
   */
  @EventHandler(payloadType = RemovePositionPointsFromPositionPointEvent.class)
  public void handle(RemovePositionPointsFromPositionPointEvent event) {
    LOGGER.info("handling RemovePositionPointsFromPositionPointEvent - " + event);

    PositionPoint entity =
        removeFromPositionPoints(event.getPositionPointId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPositionPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPositionPoint(entity);
  }

  /**
   * Method to retrieve the PositionPoint via an PositionPointPrimaryKey.
   *
   * @param id Long
   * @return PositionPoint
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PositionPoint handle(FindPositionPointQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPositionPointId());
  }

  /**
   * Method to retrieve a collection of all PositionPoints
   *
   * @param query FindAllPositionPointQuery
   * @return List<PositionPoint>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PositionPoint> handle(FindAllPositionPointQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPositionPoint, but only if the id matches
   *
   * @param entity PositionPoint
   */
  protected void emitFindPositionPoint(PositionPoint entity) {
    LOGGER.info("handling emitFindPositionPoint");

    queryUpdateEmitter.emit(
        FindPositionPointQuery.class,
        query -> query.getFilter().getPositionPointId().equals(entity.getPositionPointId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPositionPoint
   *
   * @param entity PositionPoint
   */
  protected void emitFindAllPositionPoint(PositionPoint entity) {
    LOGGER.info("handling emitFindAllPositionPoint");

    queryUpdateEmitter.emit(FindAllPositionPointQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PositionPointProjector.class.getName());
}
