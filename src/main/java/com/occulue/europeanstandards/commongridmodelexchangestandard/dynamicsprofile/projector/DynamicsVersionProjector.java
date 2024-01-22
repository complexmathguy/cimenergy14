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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for DynamicsVersion as outlined for the CQRS pattern. All event handling and query
 * handling related to DynamicsVersion are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by DynamicsVersionAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("dynamicsVersion")
@Component("dynamicsVersion-projector")
public class DynamicsVersionProjector extends DynamicsVersionEntityProjector {

  // core constructor
  public DynamicsVersionProjector(
      DynamicsVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateDynamicsVersionEvent
   */
  @EventHandler(payloadType = CreateDynamicsVersionEvent.class)
  public void handle(CreateDynamicsVersionEvent event) {
    LOGGER.info("handling CreateDynamicsVersionEvent - " + event);
    DynamicsVersion entity = new DynamicsVersion();
    entity.setDynamicsVersionId(event.getDynamicsVersionId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event UpdateDynamicsVersionEvent
   */
  @EventHandler(payloadType = UpdateDynamicsVersionEvent.class)
  public void handle(UpdateDynamicsVersionEvent event) {
    LOGGER.info("handling UpdateDynamicsVersionEvent - " + event);

    DynamicsVersion entity = new DynamicsVersion();
    entity.setDynamicsVersionId(event.getDynamicsVersionId());
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
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event DeleteDynamicsVersionEvent
   */
  @EventHandler(payloadType = DeleteDynamicsVersionEvent.class)
  public void handle(DeleteDynamicsVersionEvent event) {
    LOGGER.info("handling DeleteDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    DynamicsVersion entity = delete(event.getDynamicsVersionId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event AssignBaseUMLToDynamicsVersionEvent
   */
  @EventHandler(payloadType = AssignBaseUMLToDynamicsVersionEvent.class)
  public void handle(AssignBaseUMLToDynamicsVersionEvent event) {
    LOGGER.info("handling AssignBaseUMLToDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DynamicsVersion entity = assignBaseUML(event.getDynamicsVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event UnAssignBaseUMLFromDynamicsVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseUMLFromDynamicsVersionEvent.class)
  public void handle(UnAssignBaseUMLFromDynamicsVersionEvent event) {
    LOGGER.info("handling UnAssignBaseUMLFromDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DynamicsVersion entity = unAssignBaseUML(event.getDynamicsVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event AssignBaseURIToDynamicsVersionEvent
   */
  @EventHandler(payloadType = AssignBaseURIToDynamicsVersionEvent.class)
  public void handle(AssignBaseURIToDynamicsVersionEvent event) {
    LOGGER.info("handling AssignBaseURIToDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DynamicsVersion entity = assignBaseURI(event.getDynamicsVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event UnAssignBaseURIFromDynamicsVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseURIFromDynamicsVersionEvent.class)
  public void handle(UnAssignBaseURIFromDynamicsVersionEvent event) {
    LOGGER.info("handling UnAssignBaseURIFromDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DynamicsVersion entity = unAssignBaseURI(event.getDynamicsVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event AssignDateToDynamicsVersionEvent
   */
  @EventHandler(payloadType = AssignDateToDynamicsVersionEvent.class)
  public void handle(AssignDateToDynamicsVersionEvent event) {
    LOGGER.info("handling AssignDateToDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DynamicsVersion entity = assignDate(event.getDynamicsVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event UnAssignDateFromDynamicsVersionEvent
   */
  @EventHandler(payloadType = UnAssignDateFromDynamicsVersionEvent.class)
  public void handle(UnAssignDateFromDynamicsVersionEvent event) {
    LOGGER.info("handling UnAssignDateFromDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DynamicsVersion entity = unAssignDate(event.getDynamicsVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event AssignDifferenceModelURIToDynamicsVersionEvent
   */
  @EventHandler(payloadType = AssignDifferenceModelURIToDynamicsVersionEvent.class)
  public void handle(AssignDifferenceModelURIToDynamicsVersionEvent event) {
    LOGGER.info("handling AssignDifferenceModelURIToDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DynamicsVersion entity =
        assignDifferenceModelURI(event.getDynamicsVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event UnAssignDifferenceModelURIFromDynamicsVersionEvent
   */
  @EventHandler(payloadType = UnAssignDifferenceModelURIFromDynamicsVersionEvent.class)
  public void handle(UnAssignDifferenceModelURIFromDynamicsVersionEvent event) {
    LOGGER.info("handling UnAssignDifferenceModelURIFromDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DynamicsVersion entity = unAssignDifferenceModelURI(event.getDynamicsVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event AssignEntsoeUMLToDynamicsVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeUMLToDynamicsVersionEvent.class)
  public void handle(AssignEntsoeUMLToDynamicsVersionEvent event) {
    LOGGER.info("handling AssignEntsoeUMLToDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DynamicsVersion entity = assignEntsoeUML(event.getDynamicsVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeUMLFromDynamicsVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeUMLFromDynamicsVersionEvent.class)
  public void handle(UnAssignEntsoeUMLFromDynamicsVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeUMLFromDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DynamicsVersion entity = unAssignEntsoeUML(event.getDynamicsVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event AssignEntsoeURIToDynamicsVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeURIToDynamicsVersionEvent.class)
  public void handle(AssignEntsoeURIToDynamicsVersionEvent event) {
    LOGGER.info("handling AssignEntsoeURIToDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DynamicsVersion entity = assignEntsoeURI(event.getDynamicsVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeURIFromDynamicsVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeURIFromDynamicsVersionEvent.class)
  public void handle(UnAssignEntsoeURIFromDynamicsVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeURIFromDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DynamicsVersion entity = unAssignEntsoeURI(event.getDynamicsVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event AssignModelDescriptionURIToDynamicsVersionEvent
   */
  @EventHandler(payloadType = AssignModelDescriptionURIToDynamicsVersionEvent.class)
  public void handle(AssignModelDescriptionURIToDynamicsVersionEvent event) {
    LOGGER.info("handling AssignModelDescriptionURIToDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DynamicsVersion entity =
        assignModelDescriptionURI(event.getDynamicsVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event UnAssignModelDescriptionURIFromDynamicsVersionEvent
   */
  @EventHandler(payloadType = UnAssignModelDescriptionURIFromDynamicsVersionEvent.class)
  public void handle(UnAssignModelDescriptionURIFromDynamicsVersionEvent event) {
    LOGGER.info("handling UnAssignModelDescriptionURIFromDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DynamicsVersion entity = unAssignModelDescriptionURI(event.getDynamicsVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event AssignNamespaceRDFToDynamicsVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceRDFToDynamicsVersionEvent.class)
  public void handle(AssignNamespaceRDFToDynamicsVersionEvent event) {
    LOGGER.info("handling AssignNamespaceRDFToDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DynamicsVersion entity =
        assignNamespaceRDF(event.getDynamicsVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceRDFFromDynamicsVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceRDFFromDynamicsVersionEvent.class)
  public void handle(UnAssignNamespaceRDFFromDynamicsVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceRDFFromDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DynamicsVersion entity = unAssignNamespaceRDF(event.getDynamicsVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event AssignNamespaceUMLToDynamicsVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceUMLToDynamicsVersionEvent.class)
  public void handle(AssignNamespaceUMLToDynamicsVersionEvent event) {
    LOGGER.info("handling AssignNamespaceUMLToDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DynamicsVersion entity =
        assignNamespaceUML(event.getDynamicsVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceUMLFromDynamicsVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceUMLFromDynamicsVersionEvent.class)
  public void handle(UnAssignNamespaceUMLFromDynamicsVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceUMLFromDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DynamicsVersion entity = unAssignNamespaceUML(event.getDynamicsVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event AssignShortNameToDynamicsVersionEvent
   */
  @EventHandler(payloadType = AssignShortNameToDynamicsVersionEvent.class)
  public void handle(AssignShortNameToDynamicsVersionEvent event) {
    LOGGER.info("handling AssignShortNameToDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    DynamicsVersion entity = assignShortName(event.getDynamicsVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /*
   * @param	event UnAssignShortNameFromDynamicsVersionEvent
   */
  @EventHandler(payloadType = UnAssignShortNameFromDynamicsVersionEvent.class)
  public void handle(UnAssignShortNameFromDynamicsVersionEvent event) {
    LOGGER.info("handling UnAssignShortNameFromDynamicsVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    DynamicsVersion entity = unAssignShortName(event.getDynamicsVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindDynamicsVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllDynamicsVersion(entity);
  }

  /**
   * Method to retrieve the DynamicsVersion via an DynamicsVersionPrimaryKey.
   *
   * @param id Long
   * @return DynamicsVersion
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public DynamicsVersion handle(FindDynamicsVersionQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getDynamicsVersionId());
  }

  /**
   * Method to retrieve a collection of all DynamicsVersions
   *
   * @param query FindAllDynamicsVersionQuery
   * @return List<DynamicsVersion>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<DynamicsVersion> handle(FindAllDynamicsVersionQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindDynamicsVersion, but only if the id matches
   *
   * @param entity DynamicsVersion
   */
  protected void emitFindDynamicsVersion(DynamicsVersion entity) {
    LOGGER.info("handling emitFindDynamicsVersion");

    queryUpdateEmitter.emit(
        FindDynamicsVersionQuery.class,
        query -> query.getFilter().getDynamicsVersionId().equals(entity.getDynamicsVersionId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllDynamicsVersion
   *
   * @param entity DynamicsVersion
   */
  protected void emitFindAllDynamicsVersion(DynamicsVersion entity) {
    LOGGER.info("handling emitFindAllDynamicsVersion");

    queryUpdateEmitter.emit(FindAllDynamicsVersionQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(DynamicsVersionProjector.class.getName());
}
