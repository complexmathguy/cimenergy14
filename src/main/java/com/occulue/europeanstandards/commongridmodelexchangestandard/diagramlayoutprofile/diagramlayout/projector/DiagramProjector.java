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
 * Projector for Diagram as outlined for the CQRS pattern. All event handling and query handling
 * related to Diagram are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by DiagramAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("diagram")
@Component("diagram-projector")
public class DiagramProjector extends DiagramEntityProjector {

  // core constructor
  public DiagramProjector(DiagramRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateDiagramEvent
   */
  @EventHandler(payloadType = CreateDiagramEvent.class)
  public void handle(CreateDiagramEvent event) {
    LOGGER.info("handling CreateDiagramEvent - " + event);
    Diagram entity = new Diagram();
    entity.setDiagramId(event.getDiagramId());
    entity.setOrientation(event.getOrientation());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagram(entity);
  }

  /*
   * @param	event UpdateDiagramEvent
   */
  @EventHandler(payloadType = UpdateDiagramEvent.class)
  public void handle(UpdateDiagramEvent event) {
    LOGGER.info("handling UpdateDiagramEvent - " + event);

    Diagram entity = new Diagram();
    entity.setDiagramId(event.getDiagramId());
    entity.setOrientation(event.getOrientation());
    entity.setX1InitialView(event.getX1InitialView());
    entity.setX2InitialView(event.getX2InitialView());
    entity.setY1InitialView(event.getY1InitialView());
    entity.setY2InitialView(event.getY2InitialView());
    entity.setDiagram(event.getDiagram());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagram(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagram(entity);
  }

  /*
   * @param	event DeleteDiagramEvent
   */
  @EventHandler(payloadType = DeleteDiagramEvent.class)
  public void handle(DeleteDiagramEvent event) {
    LOGGER.info("handling DeleteDiagramEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    Diagram entity = delete(event.getDiagramId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagram(entity);
  }

  /*
   * @param	event AssignX1InitialViewToDiagramEvent
   */
  @EventHandler(payloadType = AssignX1InitialViewToDiagramEvent.class)
  public void handle(AssignX1InitialViewToDiagramEvent event) {
    LOGGER.info("handling AssignX1InitialViewToDiagramEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Diagram entity = assignX1InitialView(event.getDiagramId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagram(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagram(entity);
  }

  /*
   * @param	event UnAssignX1InitialViewFromDiagramEvent
   */
  @EventHandler(payloadType = UnAssignX1InitialViewFromDiagramEvent.class)
  public void handle(UnAssignX1InitialViewFromDiagramEvent event) {
    LOGGER.info("handling UnAssignX1InitialViewFromDiagramEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Diagram entity = unAssignX1InitialView(event.getDiagramId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagram(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagram(entity);
  }

  /*
   * @param	event AssignX2InitialViewToDiagramEvent
   */
  @EventHandler(payloadType = AssignX2InitialViewToDiagramEvent.class)
  public void handle(AssignX2InitialViewToDiagramEvent event) {
    LOGGER.info("handling AssignX2InitialViewToDiagramEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Diagram entity = assignX2InitialView(event.getDiagramId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagram(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagram(entity);
  }

  /*
   * @param	event UnAssignX2InitialViewFromDiagramEvent
   */
  @EventHandler(payloadType = UnAssignX2InitialViewFromDiagramEvent.class)
  public void handle(UnAssignX2InitialViewFromDiagramEvent event) {
    LOGGER.info("handling UnAssignX2InitialViewFromDiagramEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Diagram entity = unAssignX2InitialView(event.getDiagramId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagram(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagram(entity);
  }

  /*
   * @param	event AssignY1InitialViewToDiagramEvent
   */
  @EventHandler(payloadType = AssignY1InitialViewToDiagramEvent.class)
  public void handle(AssignY1InitialViewToDiagramEvent event) {
    LOGGER.info("handling AssignY1InitialViewToDiagramEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Diagram entity = assignY1InitialView(event.getDiagramId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagram(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagram(entity);
  }

  /*
   * @param	event UnAssignY1InitialViewFromDiagramEvent
   */
  @EventHandler(payloadType = UnAssignY1InitialViewFromDiagramEvent.class)
  public void handle(UnAssignY1InitialViewFromDiagramEvent event) {
    LOGGER.info("handling UnAssignY1InitialViewFromDiagramEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Diagram entity = unAssignY1InitialView(event.getDiagramId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagram(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagram(entity);
  }

  /*
   * @param	event AssignY2InitialViewToDiagramEvent
   */
  @EventHandler(payloadType = AssignY2InitialViewToDiagramEvent.class)
  public void handle(AssignY2InitialViewToDiagramEvent event) {
    LOGGER.info("handling AssignY2InitialViewToDiagramEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    Diagram entity = assignY2InitialView(event.getDiagramId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagram(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagram(entity);
  }

  /*
   * @param	event UnAssignY2InitialViewFromDiagramEvent
   */
  @EventHandler(payloadType = UnAssignY2InitialViewFromDiagramEvent.class)
  public void handle(UnAssignY2InitialViewFromDiagramEvent event) {
    LOGGER.info("handling UnAssignY2InitialViewFromDiagramEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    Diagram entity = unAssignY2InitialView(event.getDiagramId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagram(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagram(entity);
  }

  /*
   * @param	event AssignDiagramToDiagramEvent
   */
  @EventHandler(payloadType = AssignDiagramToDiagramEvent.class)
  public void handle(AssignDiagramToDiagramEvent event) {
    LOGGER.info("handling AssignDiagramToDiagramEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    Diagram entity = addToDiagram(event.getDiagramId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagram(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagram(entity);
  }

  /*
   * @param	event RemoveDiagramFromDiagramEvent
   */
  @EventHandler(payloadType = RemoveDiagramFromDiagramEvent.class)
  public void handle(RemoveDiagramFromDiagramEvent event) {
    LOGGER.info("handling RemoveDiagramFromDiagramEvent - " + event);

    Diagram entity = removeFromDiagram(event.getDiagramId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagram(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagram(entity);
  }

  /**
   * Method to retrieve the Diagram via an DiagramPrimaryKey.
   *
   * @param id Long
   * @return Diagram
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public Diagram handle(FindDiagramQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getDiagramId());
  }

  /**
   * Method to retrieve a collection of all Diagrams
   *
   * @param query FindAllDiagramQuery
   * @return List<Diagram>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<Diagram> handle(FindAllDiagramQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindDiagram, but only if the id matches
   *
   * @param entity Diagram
   */
  protected void emitFindDiagram(Diagram entity) {
    LOGGER.info("handling emitFindDiagram");

    queryUpdateEmitter.emit(
        FindDiagramQuery.class,
        query -> query.getFilter().getDiagramId().equals(entity.getDiagramId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllDiagram
   *
   * @param entity Diagram
   */
  protected void emitFindAllDiagram(Diagram entity) {
    LOGGER.info("handling emitFindAllDiagram");

    queryUpdateEmitter.emit(FindAllDiagramQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(DiagramProjector.class.getName());
}
