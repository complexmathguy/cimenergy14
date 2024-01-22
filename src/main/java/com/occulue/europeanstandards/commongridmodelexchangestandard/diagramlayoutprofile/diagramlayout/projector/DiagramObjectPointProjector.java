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
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for DiagramObjectPoint as outlined for the CQRS pattern. All event handling and query
 * handling related to DiagramObjectPoint are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by DiagramObjectPointAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("diagramObjectPoint")
@Component("diagramObjectPoint-projector")
public class DiagramObjectPointProjector extends DiagramObjectPointEntityProjector {

  // core constructor
  public DiagramObjectPointProjector(
      DiagramObjectPointRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateDiagramObjectPointEvent
   */
  @EventHandler(payloadType = CreateDiagramObjectPointEvent.class)
  public void handle(CreateDiagramObjectPointEvent event) {
    LOGGER.info("handling CreateDiagramObjectPointEvent - " + event);
    DiagramObjectPoint entity = new DiagramObjectPoint();
    entity.setDiagramObjectPointId(event.getDiagramObjectPointId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObjectPoint(entity);
  }

  /*
   * @param	event UpdateDiagramObjectPointEvent
   */
  @EventHandler(payloadType = UpdateDiagramObjectPointEvent.class)
  public void handle(UpdateDiagramObjectPointEvent event) {
    LOGGER.info("handling UpdateDiagramObjectPointEvent - " + event);

    DiagramObjectPoint entity = new DiagramObjectPoint();
    entity.setDiagramObjectPointId(event.getDiagramObjectPointId());
    entity.setSequenceNumber(event.getSequenceNumber());
    entity.setXPosition(event.getXPosition());
    entity.setYPosition(event.getYPosition());
    entity.setZPosition(event.getZPosition());
    entity.setDiagramObjectPoints(event.getDiagramObjectPoints());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObjectPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObjectPoint(entity);
  }

  /*
   * @param	event DeleteDiagramObjectPointEvent
   */
  @EventHandler(payloadType = DeleteDiagramObjectPointEvent.class)
  public void handle(DeleteDiagramObjectPointEvent event) {
    LOGGER.info("handling DeleteDiagramObjectPointEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    DiagramObjectPoint entity = delete(event.getDiagramObjectPointId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObjectPoint(entity);
  }

  /*
   * @param	event AssignSequenceNumberToDiagramObjectPointEvent
   */
  @EventHandler(payloadType = AssignSequenceNumberToDiagramObjectPointEvent.class)
  public void handle(AssignSequenceNumberToDiagramObjectPointEvent event) {
    LOGGER.info("handling AssignSequenceNumberToDiagramObjectPointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramObjectPoint entity =
        assignSequenceNumber(event.getDiagramObjectPointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObjectPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObjectPoint(entity);
  }

  /*
   * @param	event UnAssignSequenceNumberFromDiagramObjectPointEvent
   */
  @EventHandler(payloadType = UnAssignSequenceNumberFromDiagramObjectPointEvent.class)
  public void handle(UnAssignSequenceNumberFromDiagramObjectPointEvent event) {
    LOGGER.info("handling UnAssignSequenceNumberFromDiagramObjectPointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramObjectPoint entity = unAssignSequenceNumber(event.getDiagramObjectPointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObjectPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObjectPoint(entity);
  }

  /*
   * @param	event AssignXPositionToDiagramObjectPointEvent
   */
  @EventHandler(payloadType = AssignXPositionToDiagramObjectPointEvent.class)
  public void handle(AssignXPositionToDiagramObjectPointEvent event) {
    LOGGER.info("handling AssignXPositionToDiagramObjectPointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramObjectPoint entity =
        assignXPosition(event.getDiagramObjectPointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObjectPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObjectPoint(entity);
  }

  /*
   * @param	event UnAssignXPositionFromDiagramObjectPointEvent
   */
  @EventHandler(payloadType = UnAssignXPositionFromDiagramObjectPointEvent.class)
  public void handle(UnAssignXPositionFromDiagramObjectPointEvent event) {
    LOGGER.info("handling UnAssignXPositionFromDiagramObjectPointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramObjectPoint entity = unAssignXPosition(event.getDiagramObjectPointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObjectPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObjectPoint(entity);
  }

  /*
   * @param	event AssignYPositionToDiagramObjectPointEvent
   */
  @EventHandler(payloadType = AssignYPositionToDiagramObjectPointEvent.class)
  public void handle(AssignYPositionToDiagramObjectPointEvent event) {
    LOGGER.info("handling AssignYPositionToDiagramObjectPointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramObjectPoint entity =
        assignYPosition(event.getDiagramObjectPointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObjectPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObjectPoint(entity);
  }

  /*
   * @param	event UnAssignYPositionFromDiagramObjectPointEvent
   */
  @EventHandler(payloadType = UnAssignYPositionFromDiagramObjectPointEvent.class)
  public void handle(UnAssignYPositionFromDiagramObjectPointEvent event) {
    LOGGER.info("handling UnAssignYPositionFromDiagramObjectPointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramObjectPoint entity = unAssignYPosition(event.getDiagramObjectPointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObjectPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObjectPoint(entity);
  }

  /*
   * @param	event AssignZPositionToDiagramObjectPointEvent
   */
  @EventHandler(payloadType = AssignZPositionToDiagramObjectPointEvent.class)
  public void handle(AssignZPositionToDiagramObjectPointEvent event) {
    LOGGER.info("handling AssignZPositionToDiagramObjectPointEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramObjectPoint entity =
        assignZPosition(event.getDiagramObjectPointId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObjectPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObjectPoint(entity);
  }

  /*
   * @param	event UnAssignZPositionFromDiagramObjectPointEvent
   */
  @EventHandler(payloadType = UnAssignZPositionFromDiagramObjectPointEvent.class)
  public void handle(UnAssignZPositionFromDiagramObjectPointEvent event) {
    LOGGER.info("handling UnAssignZPositionFromDiagramObjectPointEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramObjectPoint entity = unAssignZPosition(event.getDiagramObjectPointId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObjectPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObjectPoint(entity);
  }

  /*
   * @param	event AssignDiagramObjectPointsToDiagramObjectPointEvent
   */
  @EventHandler(payloadType = AssignDiagramObjectPointsToDiagramObjectPointEvent.class)
  public void handle(AssignDiagramObjectPointsToDiagramObjectPointEvent event) {
    LOGGER.info("handling AssignDiagramObjectPointsToDiagramObjectPointEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    DiagramObjectPoint entity =
        addToDiagramObjectPoints(event.getDiagramObjectPointId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObjectPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObjectPoint(entity);
  }

  /*
   * @param	event RemoveDiagramObjectPointsFromDiagramObjectPointEvent
   */
  @EventHandler(payloadType = RemoveDiagramObjectPointsFromDiagramObjectPointEvent.class)
  public void handle(RemoveDiagramObjectPointsFromDiagramObjectPointEvent event) {
    LOGGER.info("handling RemoveDiagramObjectPointsFromDiagramObjectPointEvent - " + event);

    DiagramObjectPoint entity =
        removeFromDiagramObjectPoints(event.getDiagramObjectPointId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObjectPoint(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObjectPoint(entity);
  }

  /**
   * Method to retrieve the DiagramObjectPoint via an DiagramObjectPointPrimaryKey.
   *
   * @param id Long
   * @return DiagramObjectPoint
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public DiagramObjectPoint handle(FindDiagramObjectPointQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getDiagramObjectPointId());
  }

  /**
   * Method to retrieve a collection of all DiagramObjectPoints
   *
   * @param query FindAllDiagramObjectPointQuery
   * @return List<DiagramObjectPoint>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<DiagramObjectPoint> handle(FindAllDiagramObjectPointQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindDiagramObjectPoint, but only if the id matches
   *
   * @param entity DiagramObjectPoint
   */
  protected void emitFindDiagramObjectPoint(DiagramObjectPoint entity) {
    LOGGER.info("handling emitFindDiagramObjectPoint");

    queryUpdateEmitter.emit(
        FindDiagramObjectPointQuery.class,
        query ->
            query.getFilter().getDiagramObjectPointId().equals(entity.getDiagramObjectPointId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllDiagramObjectPoint
   *
   * @param entity DiagramObjectPoint
   */
  protected void emitFindAllDiagramObjectPoint(DiagramObjectPoint entity) {
    LOGGER.info("handling emitFindAllDiagramObjectPoint");

    queryUpdateEmitter.emit(FindAllDiagramObjectPointQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(DiagramObjectPointProjector.class.getName());
}
