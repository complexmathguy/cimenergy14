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
 * Projector for DiagramObject as outlined for the CQRS pattern. All event handling and query
 * handling related to DiagramObject are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by DiagramObjectAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("diagramObject")
@Component("diagramObject-projector")
public class DiagramObjectProjector extends DiagramObjectEntityProjector {

  // core constructor
  public DiagramObjectProjector(
      DiagramObjectRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateDiagramObjectEvent
   */
  @EventHandler(payloadType = CreateDiagramObjectEvent.class)
  public void handle(CreateDiagramObjectEvent event) {
    LOGGER.info("handling CreateDiagramObjectEvent - " + event);
    DiagramObject entity = new DiagramObject();
    entity.setDiagramObjectId(event.getDiagramObjectId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event UpdateDiagramObjectEvent
   */
  @EventHandler(payloadType = UpdateDiagramObjectEvent.class)
  public void handle(UpdateDiagramObjectEvent event) {
    LOGGER.info("handling UpdateDiagramObjectEvent - " + event);

    DiagramObject entity = new DiagramObject();
    entity.setDiagramObjectId(event.getDiagramObjectId());
    entity.setDrawingOrder(event.getDrawingOrder());
    entity.setPolygonFlag(event.getPolygonFlag());
    entity.setOffsetX(event.getOffsetX());
    entity.setOffsetY(event.getOffsetY());
    entity.setRotation(event.getRotation());
    entity.setStyledObjects(event.getStyledObjects());
    entity.setDiagramElements(event.getDiagramElements());
    entity.setDiagramObjects(event.getDiagramObjects());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event DeleteDiagramObjectEvent
   */
  @EventHandler(payloadType = DeleteDiagramObjectEvent.class)
  public void handle(DeleteDiagramObjectEvent event) {
    LOGGER.info("handling DeleteDiagramObjectEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    DiagramObject entity = delete(event.getDiagramObjectId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event AssignDrawingOrderToDiagramObjectEvent
   */
  @EventHandler(payloadType = AssignDrawingOrderToDiagramObjectEvent.class)
  public void handle(AssignDrawingOrderToDiagramObjectEvent event) {
    LOGGER.info("handling AssignDrawingOrderToDiagramObjectEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramObject entity = assignDrawingOrder(event.getDiagramObjectId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event UnAssignDrawingOrderFromDiagramObjectEvent
   */
  @EventHandler(payloadType = UnAssignDrawingOrderFromDiagramObjectEvent.class)
  public void handle(UnAssignDrawingOrderFromDiagramObjectEvent event) {
    LOGGER.info("handling UnAssignDrawingOrderFromDiagramObjectEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramObject entity = unAssignDrawingOrder(event.getDiagramObjectId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event AssignPolygonFlagToDiagramObjectEvent
   */
  @EventHandler(payloadType = AssignPolygonFlagToDiagramObjectEvent.class)
  public void handle(AssignPolygonFlagToDiagramObjectEvent event) {
    LOGGER.info("handling AssignPolygonFlagToDiagramObjectEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramObject entity = assignPolygonFlag(event.getDiagramObjectId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event UnAssignPolygonFlagFromDiagramObjectEvent
   */
  @EventHandler(payloadType = UnAssignPolygonFlagFromDiagramObjectEvent.class)
  public void handle(UnAssignPolygonFlagFromDiagramObjectEvent event) {
    LOGGER.info("handling UnAssignPolygonFlagFromDiagramObjectEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramObject entity = unAssignPolygonFlag(event.getDiagramObjectId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event AssignOffsetXToDiagramObjectEvent
   */
  @EventHandler(payloadType = AssignOffsetXToDiagramObjectEvent.class)
  public void handle(AssignOffsetXToDiagramObjectEvent event) {
    LOGGER.info("handling AssignOffsetXToDiagramObjectEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramObject entity = assignOffsetX(event.getDiagramObjectId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event UnAssignOffsetXFromDiagramObjectEvent
   */
  @EventHandler(payloadType = UnAssignOffsetXFromDiagramObjectEvent.class)
  public void handle(UnAssignOffsetXFromDiagramObjectEvent event) {
    LOGGER.info("handling UnAssignOffsetXFromDiagramObjectEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramObject entity = unAssignOffsetX(event.getDiagramObjectId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event AssignOffsetYToDiagramObjectEvent
   */
  @EventHandler(payloadType = AssignOffsetYToDiagramObjectEvent.class)
  public void handle(AssignOffsetYToDiagramObjectEvent event) {
    LOGGER.info("handling AssignOffsetYToDiagramObjectEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramObject entity = assignOffsetY(event.getDiagramObjectId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event UnAssignOffsetYFromDiagramObjectEvent
   */
  @EventHandler(payloadType = UnAssignOffsetYFromDiagramObjectEvent.class)
  public void handle(UnAssignOffsetYFromDiagramObjectEvent event) {
    LOGGER.info("handling UnAssignOffsetYFromDiagramObjectEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramObject entity = unAssignOffsetY(event.getDiagramObjectId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event AssignRotationToDiagramObjectEvent
   */
  @EventHandler(payloadType = AssignRotationToDiagramObjectEvent.class)
  public void handle(AssignRotationToDiagramObjectEvent event) {
    LOGGER.info("handling AssignRotationToDiagramObjectEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramObject entity = assignRotation(event.getDiagramObjectId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event UnAssignRotationFromDiagramObjectEvent
   */
  @EventHandler(payloadType = UnAssignRotationFromDiagramObjectEvent.class)
  public void handle(UnAssignRotationFromDiagramObjectEvent event) {
    LOGGER.info("handling UnAssignRotationFromDiagramObjectEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramObject entity = unAssignRotation(event.getDiagramObjectId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event AssignStyledObjectsToDiagramObjectEvent
   */
  @EventHandler(payloadType = AssignStyledObjectsToDiagramObjectEvent.class)
  public void handle(AssignStyledObjectsToDiagramObjectEvent event) {
    LOGGER.info("handling AssignStyledObjectsToDiagramObjectEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    DiagramObject entity = addToStyledObjects(event.getDiagramObjectId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event RemoveStyledObjectsFromDiagramObjectEvent
   */
  @EventHandler(payloadType = RemoveStyledObjectsFromDiagramObjectEvent.class)
  public void handle(RemoveStyledObjectsFromDiagramObjectEvent event) {
    LOGGER.info("handling RemoveStyledObjectsFromDiagramObjectEvent - " + event);

    DiagramObject entity =
        removeFromStyledObjects(event.getDiagramObjectId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event AssignDiagramElementsToDiagramObjectEvent
   */
  @EventHandler(payloadType = AssignDiagramElementsToDiagramObjectEvent.class)
  public void handle(AssignDiagramElementsToDiagramObjectEvent event) {
    LOGGER.info("handling AssignDiagramElementsToDiagramObjectEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    DiagramObject entity = addToDiagramElements(event.getDiagramObjectId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event RemoveDiagramElementsFromDiagramObjectEvent
   */
  @EventHandler(payloadType = RemoveDiagramElementsFromDiagramObjectEvent.class)
  public void handle(RemoveDiagramElementsFromDiagramObjectEvent event) {
    LOGGER.info("handling RemoveDiagramElementsFromDiagramObjectEvent - " + event);

    DiagramObject entity =
        removeFromDiagramElements(event.getDiagramObjectId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event AssignDiagramObjectsToDiagramObjectEvent
   */
  @EventHandler(payloadType = AssignDiagramObjectsToDiagramObjectEvent.class)
  public void handle(AssignDiagramObjectsToDiagramObjectEvent event) {
    LOGGER.info("handling AssignDiagramObjectsToDiagramObjectEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    DiagramObject entity = addToDiagramObjects(event.getDiagramObjectId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /*
   * @param	event RemoveDiagramObjectsFromDiagramObjectEvent
   */
  @EventHandler(payloadType = RemoveDiagramObjectsFromDiagramObjectEvent.class)
  public void handle(RemoveDiagramObjectsFromDiagramObjectEvent event) {
    LOGGER.info("handling RemoveDiagramObjectsFromDiagramObjectEvent - " + event);

    DiagramObject entity =
        removeFromDiagramObjects(event.getDiagramObjectId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramObject(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramObject(entity);
  }

  /**
   * Method to retrieve the DiagramObject via an DiagramObjectPrimaryKey.
   *
   * @param id Long
   * @return DiagramObject
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public DiagramObject handle(FindDiagramObjectQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getDiagramObjectId());
  }

  /**
   * Method to retrieve a collection of all DiagramObjects
   *
   * @param query FindAllDiagramObjectQuery
   * @return List<DiagramObject>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<DiagramObject> handle(FindAllDiagramObjectQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindDiagramObject, but only if the id matches
   *
   * @param entity DiagramObject
   */
  protected void emitFindDiagramObject(DiagramObject entity) {
    LOGGER.info("handling emitFindDiagramObject");

    queryUpdateEmitter.emit(
        FindDiagramObjectQuery.class,
        query -> query.getFilter().getDiagramObjectId().equals(entity.getDiagramObjectId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllDiagramObject
   *
   * @param entity DiagramObject
   */
  protected void emitFindAllDiagramObject(DiagramObject entity) {
    LOGGER.info("handling emitFindAllDiagramObject");

    queryUpdateEmitter.emit(FindAllDiagramObjectQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(DiagramObjectProjector.class.getName());
}
