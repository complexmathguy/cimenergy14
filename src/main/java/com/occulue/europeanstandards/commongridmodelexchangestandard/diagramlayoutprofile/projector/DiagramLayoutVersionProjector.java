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
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for DiagramLayoutVersion as outlined for the CQRS pattern. All event handling and query
 * handling related to DiagramLayoutVersion are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by DiagramLayoutVersionAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("diagramLayoutVersion")
@Component("diagramLayoutVersion-projector")
public class DiagramLayoutVersionProjector extends DiagramLayoutVersionEntityProjector {

  // core constructor
  public DiagramLayoutVersionProjector(
      DiagramLayoutVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = CreateDiagramLayoutVersionEvent.class)
  public void handle(CreateDiagramLayoutVersionEvent event) {
    LOGGER.info("handling CreateDiagramLayoutVersionEvent - " + event);
    DiagramLayoutVersion entity = new DiagramLayoutVersion();
    entity.setDiagramLayoutVersionId(event.getDiagramLayoutVersionId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event UpdateDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = UpdateDiagramLayoutVersionEvent.class)
  public void handle(UpdateDiagramLayoutVersionEvent event) {
    LOGGER.info("handling UpdateDiagramLayoutVersionEvent - " + event);

    DiagramLayoutVersion entity = new DiagramLayoutVersion();
    entity.setDiagramLayoutVersionId(event.getDiagramLayoutVersionId());
    entity.setBaseUML(event.getBaseUML());
    entity.setBaseURI(event.getBaseURI());
    entity.setDate(event.getDate());
    entity.setDifferenceModelURI(event.getDifferenceModelURI());
    entity.setEntsoeUML(event.getEntsoeUML());
    entity.setEntsoeURI(event.getEntsoeURI());
    entity.setModelDescriptionURI(event.getModelDescriptionURI());
    entity.setNamespaceRDF(event.getNamespaceRDF());
    entity.setNamespaceUML(event.getNamespaceUML());
    entity.setShortName(event.getShortName());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event DeleteDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = DeleteDiagramLayoutVersionEvent.class)
  public void handle(DeleteDiagramLayoutVersionEvent event) {
    LOGGER.info("handling DeleteDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    DiagramLayoutVersion entity = delete(event.getDiagramLayoutVersionId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event AssignBaseUMLToDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = AssignBaseUMLToDiagramLayoutVersionEvent.class)
  public void handle(AssignBaseUMLToDiagramLayoutVersionEvent event) {
    LOGGER.info("handling AssignBaseUMLToDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramLayoutVersion entity =
        assignBaseUML(event.getDiagramLayoutVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event UnAssignBaseUMLFromDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseUMLFromDiagramLayoutVersionEvent.class)
  public void handle(UnAssignBaseUMLFromDiagramLayoutVersionEvent event) {
    LOGGER.info("handling UnAssignBaseUMLFromDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramLayoutVersion entity = unAssignBaseUML(event.getDiagramLayoutVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event AssignBaseURIToDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = AssignBaseURIToDiagramLayoutVersionEvent.class)
  public void handle(AssignBaseURIToDiagramLayoutVersionEvent event) {
    LOGGER.info("handling AssignBaseURIToDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramLayoutVersion entity =
        assignBaseURI(event.getDiagramLayoutVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event UnAssignBaseURIFromDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseURIFromDiagramLayoutVersionEvent.class)
  public void handle(UnAssignBaseURIFromDiagramLayoutVersionEvent event) {
    LOGGER.info("handling UnAssignBaseURIFromDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramLayoutVersion entity = unAssignBaseURI(event.getDiagramLayoutVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event AssignDateToDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = AssignDateToDiagramLayoutVersionEvent.class)
  public void handle(AssignDateToDiagramLayoutVersionEvent event) {
    LOGGER.info("handling AssignDateToDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramLayoutVersion entity =
        assignDate(event.getDiagramLayoutVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event UnAssignDateFromDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = UnAssignDateFromDiagramLayoutVersionEvent.class)
  public void handle(UnAssignDateFromDiagramLayoutVersionEvent event) {
    LOGGER.info("handling UnAssignDateFromDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramLayoutVersion entity = unAssignDate(event.getDiagramLayoutVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event AssignDifferenceModelURIToDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = AssignDifferenceModelURIToDiagramLayoutVersionEvent.class)
  public void handle(AssignDifferenceModelURIToDiagramLayoutVersionEvent event) {
    LOGGER.info("handling AssignDifferenceModelURIToDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramLayoutVersion entity =
        assignDifferenceModelURI(event.getDiagramLayoutVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event UnAssignDifferenceModelURIFromDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = UnAssignDifferenceModelURIFromDiagramLayoutVersionEvent.class)
  public void handle(UnAssignDifferenceModelURIFromDiagramLayoutVersionEvent event) {
    LOGGER.info("handling UnAssignDifferenceModelURIFromDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramLayoutVersion entity = unAssignDifferenceModelURI(event.getDiagramLayoutVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event AssignEntsoeUMLToDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeUMLToDiagramLayoutVersionEvent.class)
  public void handle(AssignEntsoeUMLToDiagramLayoutVersionEvent event) {
    LOGGER.info("handling AssignEntsoeUMLToDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramLayoutVersion entity =
        assignEntsoeUML(event.getDiagramLayoutVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeUMLFromDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeUMLFromDiagramLayoutVersionEvent.class)
  public void handle(UnAssignEntsoeUMLFromDiagramLayoutVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeUMLFromDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramLayoutVersion entity = unAssignEntsoeUML(event.getDiagramLayoutVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event AssignEntsoeURIToDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeURIToDiagramLayoutVersionEvent.class)
  public void handle(AssignEntsoeURIToDiagramLayoutVersionEvent event) {
    LOGGER.info("handling AssignEntsoeURIToDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramLayoutVersion entity =
        assignEntsoeURI(event.getDiagramLayoutVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeURIFromDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeURIFromDiagramLayoutVersionEvent.class)
  public void handle(UnAssignEntsoeURIFromDiagramLayoutVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeURIFromDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramLayoutVersion entity = unAssignEntsoeURI(event.getDiagramLayoutVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event AssignModelDescriptionURIToDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = AssignModelDescriptionURIToDiagramLayoutVersionEvent.class)
  public void handle(AssignModelDescriptionURIToDiagramLayoutVersionEvent event) {
    LOGGER.info("handling AssignModelDescriptionURIToDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramLayoutVersion entity =
        assignModelDescriptionURI(event.getDiagramLayoutVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event UnAssignModelDescriptionURIFromDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = UnAssignModelDescriptionURIFromDiagramLayoutVersionEvent.class)
  public void handle(UnAssignModelDescriptionURIFromDiagramLayoutVersionEvent event) {
    LOGGER.info("handling UnAssignModelDescriptionURIFromDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramLayoutVersion entity = unAssignModelDescriptionURI(event.getDiagramLayoutVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event AssignNamespaceRDFToDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceRDFToDiagramLayoutVersionEvent.class)
  public void handle(AssignNamespaceRDFToDiagramLayoutVersionEvent event) {
    LOGGER.info("handling AssignNamespaceRDFToDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramLayoutVersion entity =
        assignNamespaceRDF(event.getDiagramLayoutVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceRDFFromDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceRDFFromDiagramLayoutVersionEvent.class)
  public void handle(UnAssignNamespaceRDFFromDiagramLayoutVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceRDFFromDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramLayoutVersion entity = unAssignNamespaceRDF(event.getDiagramLayoutVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event AssignNamespaceUMLToDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceUMLToDiagramLayoutVersionEvent.class)
  public void handle(AssignNamespaceUMLToDiagramLayoutVersionEvent event) {
    LOGGER.info("handling AssignNamespaceUMLToDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramLayoutVersion entity =
        assignNamespaceUML(event.getDiagramLayoutVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceUMLFromDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceUMLFromDiagramLayoutVersionEvent.class)
  public void handle(UnAssignNamespaceUMLFromDiagramLayoutVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceUMLFromDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramLayoutVersion entity = unAssignNamespaceUML(event.getDiagramLayoutVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event AssignShortNameToDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = AssignShortNameToDiagramLayoutVersionEvent.class)
  public void handle(AssignShortNameToDiagramLayoutVersionEvent event) {
    LOGGER.info("handling AssignShortNameToDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DiagramLayoutVersion entity =
        assignShortName(event.getDiagramLayoutVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /*
   * @param	event UnAssignShortNameFromDiagramLayoutVersionEvent
   */
  @EventHandler(payloadType = UnAssignShortNameFromDiagramLayoutVersionEvent.class)
  public void handle(UnAssignShortNameFromDiagramLayoutVersionEvent event) {
    LOGGER.info("handling UnAssignShortNameFromDiagramLayoutVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DiagramLayoutVersion entity = unAssignShortName(event.getDiagramLayoutVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDiagramLayoutVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDiagramLayoutVersion(entity);
  }

  /**
   * Method to retrieve the DiagramLayoutVersion via an DiagramLayoutVersionPrimaryKey.
   *
   * @param id Long
   * @return DiagramLayoutVersion
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public DiagramLayoutVersion handle(FindDiagramLayoutVersionQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getDiagramLayoutVersionId());
  }

  /**
   * Method to retrieve a collection of all DiagramLayoutVersions
   *
   * @param query FindAllDiagramLayoutVersionQuery
   * @return List<DiagramLayoutVersion>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<DiagramLayoutVersion> handle(FindAllDiagramLayoutVersionQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindDiagramLayoutVersion, but only if the id matches
   *
   * @param entity DiagramLayoutVersion
   */
  protected void emitFindDiagramLayoutVersion(DiagramLayoutVersion entity) {
    LOGGER.info("handling emitFindDiagramLayoutVersion");

    queryUpdateEmitter.emit(
        FindDiagramLayoutVersionQuery.class,
        query ->
            query
                .getFilter()
                .getDiagramLayoutVersionId()
                .equals(entity.getDiagramLayoutVersionId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllDiagramLayoutVersion
   *
   * @param entity DiagramLayoutVersion
   */
  protected void emitFindAllDiagramLayoutVersion(DiagramLayoutVersion entity) {
    LOGGER.info("handling emitFindAllDiagramLayoutVersion");

    queryUpdateEmitter.emit(FindAllDiagramLayoutVersionQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(DiagramLayoutVersionProjector.class.getName());
}
