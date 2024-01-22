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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for EquipmentBoundaryVersion as outlined for the CQRS pattern. All event handling and
 * query handling related to EquipmentBoundaryVersion are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by EquipmentBoundaryVersionAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("equipmentBoundaryVersion")
@Component("equipmentBoundaryVersion-projector")
public class EquipmentBoundaryVersionProjector extends EquipmentBoundaryVersionEntityProjector {

  // core constructor
  public EquipmentBoundaryVersionProjector(
      EquipmentBoundaryVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = CreateEquipmentBoundaryVersionEvent.class)
  public void handle(CreateEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling CreateEquipmentBoundaryVersionEvent - " + event);
    EquipmentBoundaryVersion entity = new EquipmentBoundaryVersion();
    entity.setEquipmentBoundaryVersionId(event.getEquipmentBoundaryVersionId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event UpdateEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = UpdateEquipmentBoundaryVersionEvent.class)
  public void handle(UpdateEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling UpdateEquipmentBoundaryVersionEvent - " + event);

    EquipmentBoundaryVersion entity = new EquipmentBoundaryVersion();
    entity.setEquipmentBoundaryVersionId(event.getEquipmentBoundaryVersionId());
    entity.setBaseUML(event.getBaseUML());
    entity.setBaseURI(event.getBaseURI());
    entity.setDate(event.getDate());
    entity.setDifferenceModelURI(event.getDifferenceModelURI());
    entity.setEntsoeUML(event.getEntsoeUML());
    entity.setEntsoeURIcore(event.getEntsoeURIcore());
    entity.setEntsoeURIoperation(event.getEntsoeURIoperation());
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
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event DeleteEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = DeleteEquipmentBoundaryVersionEvent.class)
  public void handle(DeleteEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling DeleteEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    EquipmentBoundaryVersion entity = delete(event.getEquipmentBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event AssignBaseUMLToEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignBaseUMLToEquipmentBoundaryVersionEvent.class)
  public void handle(AssignBaseUMLToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling AssignBaseUMLToEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentBoundaryVersion entity =
        assignBaseUML(event.getEquipmentBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignBaseUMLFromEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseUMLFromEquipmentBoundaryVersionEvent.class)
  public void handle(UnAssignBaseUMLFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignBaseUMLFromEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentBoundaryVersion entity = unAssignBaseUML(event.getEquipmentBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event AssignBaseURIToEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignBaseURIToEquipmentBoundaryVersionEvent.class)
  public void handle(AssignBaseURIToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling AssignBaseURIToEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentBoundaryVersion entity =
        assignBaseURI(event.getEquipmentBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignBaseURIFromEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseURIFromEquipmentBoundaryVersionEvent.class)
  public void handle(UnAssignBaseURIFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignBaseURIFromEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentBoundaryVersion entity = unAssignBaseURI(event.getEquipmentBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event AssignDateToEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignDateToEquipmentBoundaryVersionEvent.class)
  public void handle(AssignDateToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling AssignDateToEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentBoundaryVersion entity =
        assignDate(event.getEquipmentBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignDateFromEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignDateFromEquipmentBoundaryVersionEvent.class)
  public void handle(UnAssignDateFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignDateFromEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentBoundaryVersion entity = unAssignDate(event.getEquipmentBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event AssignDifferenceModelURIToEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignDifferenceModelURIToEquipmentBoundaryVersionEvent.class)
  public void handle(AssignDifferenceModelURIToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling AssignDifferenceModelURIToEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentBoundaryVersion entity =
        assignDifferenceModelURI(event.getEquipmentBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignDifferenceModelURIFromEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignDifferenceModelURIFromEquipmentBoundaryVersionEvent.class)
  public void handle(UnAssignDifferenceModelURIFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignDifferenceModelURIFromEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentBoundaryVersion entity =
        unAssignDifferenceModelURI(event.getEquipmentBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event AssignEntsoeUMLToEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeUMLToEquipmentBoundaryVersionEvent.class)
  public void handle(AssignEntsoeUMLToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling AssignEntsoeUMLToEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentBoundaryVersion entity =
        assignEntsoeUML(event.getEquipmentBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeUMLFromEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeUMLFromEquipmentBoundaryVersionEvent.class)
  public void handle(UnAssignEntsoeUMLFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeUMLFromEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentBoundaryVersion entity = unAssignEntsoeUML(event.getEquipmentBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event AssignEntsoeURIcoreToEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeURIcoreToEquipmentBoundaryVersionEvent.class)
  public void handle(AssignEntsoeURIcoreToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling AssignEntsoeURIcoreToEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentBoundaryVersion entity =
        assignEntsoeURIcore(event.getEquipmentBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionEvent.class)
  public void handle(UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentBoundaryVersion entity = unAssignEntsoeURIcore(event.getEquipmentBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event AssignEntsoeURIoperationToEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeURIoperationToEquipmentBoundaryVersionEvent.class)
  public void handle(AssignEntsoeURIoperationToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling AssignEntsoeURIoperationToEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentBoundaryVersion entity =
        assignEntsoeURIoperation(event.getEquipmentBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionEvent.class)
  public void handle(UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentBoundaryVersion entity =
        unAssignEntsoeURIoperation(event.getEquipmentBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event AssignModelDescriptionURIToEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignModelDescriptionURIToEquipmentBoundaryVersionEvent.class)
  public void handle(AssignModelDescriptionURIToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling AssignModelDescriptionURIToEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentBoundaryVersion entity =
        assignModelDescriptionURI(event.getEquipmentBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignModelDescriptionURIFromEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignModelDescriptionURIFromEquipmentBoundaryVersionEvent.class)
  public void handle(UnAssignModelDescriptionURIFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignModelDescriptionURIFromEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentBoundaryVersion entity =
        unAssignModelDescriptionURI(event.getEquipmentBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event AssignNamespaceRDFToEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceRDFToEquipmentBoundaryVersionEvent.class)
  public void handle(AssignNamespaceRDFToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling AssignNamespaceRDFToEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentBoundaryVersion entity =
        assignNamespaceRDF(event.getEquipmentBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceRDFFromEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceRDFFromEquipmentBoundaryVersionEvent.class)
  public void handle(UnAssignNamespaceRDFFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceRDFFromEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentBoundaryVersion entity = unAssignNamespaceRDF(event.getEquipmentBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event AssignNamespaceUMLToEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceUMLToEquipmentBoundaryVersionEvent.class)
  public void handle(AssignNamespaceUMLToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling AssignNamespaceUMLToEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentBoundaryVersion entity =
        assignNamespaceUML(event.getEquipmentBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceUMLFromEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceUMLFromEquipmentBoundaryVersionEvent.class)
  public void handle(UnAssignNamespaceUMLFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceUMLFromEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentBoundaryVersion entity = unAssignNamespaceUML(event.getEquipmentBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event AssignShortNameToEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignShortNameToEquipmentBoundaryVersionEvent.class)
  public void handle(AssignShortNameToEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling AssignShortNameToEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentBoundaryVersion entity =
        assignShortName(event.getEquipmentBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignShortNameFromEquipmentBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignShortNameFromEquipmentBoundaryVersionEvent.class)
  public void handle(UnAssignShortNameFromEquipmentBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignShortNameFromEquipmentBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentBoundaryVersion entity = unAssignShortName(event.getEquipmentBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentBoundaryVersion(entity);
  }

  /**
   * Method to retrieve the EquipmentBoundaryVersion via an EquipmentBoundaryVersionPrimaryKey.
   *
   * @param id Long
   * @return EquipmentBoundaryVersion
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public EquipmentBoundaryVersion handle(FindEquipmentBoundaryVersionQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getEquipmentBoundaryVersionId());
  }

  /**
   * Method to retrieve a collection of all EquipmentBoundaryVersions
   *
   * @param query FindAllEquipmentBoundaryVersionQuery
   * @return List<EquipmentBoundaryVersion>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<EquipmentBoundaryVersion> handle(FindAllEquipmentBoundaryVersionQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindEquipmentBoundaryVersion, but only if the id matches
   *
   * @param entity EquipmentBoundaryVersion
   */
  protected void emitFindEquipmentBoundaryVersion(EquipmentBoundaryVersion entity) {
    LOGGER.info("handling emitFindEquipmentBoundaryVersion");

    queryUpdateEmitter.emit(
        FindEquipmentBoundaryVersionQuery.class,
        query ->
            query
                .getFilter()
                .getEquipmentBoundaryVersionId()
                .equals(entity.getEquipmentBoundaryVersionId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllEquipmentBoundaryVersion
   *
   * @param entity EquipmentBoundaryVersion
   */
  protected void emitFindAllEquipmentBoundaryVersion(EquipmentBoundaryVersion entity) {
    LOGGER.info("handling emitFindAllEquipmentBoundaryVersion");

    queryUpdateEmitter.emit(FindAllEquipmentBoundaryVersionQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(EquipmentBoundaryVersionProjector.class.getName());
}
