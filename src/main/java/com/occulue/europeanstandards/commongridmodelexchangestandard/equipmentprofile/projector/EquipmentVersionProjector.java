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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for EquipmentVersion as outlined for the CQRS pattern. All event handling and query
 * handling related to EquipmentVersion are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by EquipmentVersionAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("equipmentVersion")
@Component("equipmentVersion-projector")
public class EquipmentVersionProjector extends EquipmentVersionEntityProjector {

  // core constructor
  public EquipmentVersionProjector(
      EquipmentVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateEquipmentVersionEvent
   */
  @EventHandler(payloadType = CreateEquipmentVersionEvent.class)
  public void handle(CreateEquipmentVersionEvent event) {
    LOGGER.info("handling CreateEquipmentVersionEvent - " + event);
    EquipmentVersion entity = new EquipmentVersion();
    entity.setEquipmentVersionId(event.getEquipmentVersionId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event UpdateEquipmentVersionEvent
   */
  @EventHandler(payloadType = UpdateEquipmentVersionEvent.class)
  public void handle(UpdateEquipmentVersionEvent event) {
    LOGGER.info("handling UpdateEquipmentVersionEvent - " + event);

    EquipmentVersion entity = new EquipmentVersion();
    entity.setEquipmentVersionId(event.getEquipmentVersionId());
    entity.setBaseUML(event.getBaseUML());
    entity.setBaseURIcore(event.getBaseURIcore());
    entity.setBaseURIoperation(event.getBaseURIoperation());
    entity.setBaseURIshortCircuit(event.getBaseURIshortCircuit());
    entity.setDate(event.getDate());
    entity.setDifferenceModelURI(event.getDifferenceModelURI());
    entity.setEntsoeUML(event.getEntsoeUML());
    entity.setEntsoeURIcore(event.getEntsoeURIcore());
    entity.setEntsoeURIoperation(event.getEntsoeURIoperation());
    entity.setEntsoeURIshortCircuit(event.getEntsoeURIshortCircuit());
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
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event DeleteEquipmentVersionEvent
   */
  @EventHandler(payloadType = DeleteEquipmentVersionEvent.class)
  public void handle(DeleteEquipmentVersionEvent event) {
    LOGGER.info("handling DeleteEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    EquipmentVersion entity = delete(event.getEquipmentVersionId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event AssignBaseUMLToEquipmentVersionEvent
   */
  @EventHandler(payloadType = AssignBaseUMLToEquipmentVersionEvent.class)
  public void handle(AssignBaseUMLToEquipmentVersionEvent event) {
    LOGGER.info("handling AssignBaseUMLToEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentVersion entity = assignBaseUML(event.getEquipmentVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event UnAssignBaseUMLFromEquipmentVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseUMLFromEquipmentVersionEvent.class)
  public void handle(UnAssignBaseUMLFromEquipmentVersionEvent event) {
    LOGGER.info("handling UnAssignBaseUMLFromEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentVersion entity = unAssignBaseUML(event.getEquipmentVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event AssignBaseURIcoreToEquipmentVersionEvent
   */
  @EventHandler(payloadType = AssignBaseURIcoreToEquipmentVersionEvent.class)
  public void handle(AssignBaseURIcoreToEquipmentVersionEvent event) {
    LOGGER.info("handling AssignBaseURIcoreToEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentVersion entity =
        assignBaseURIcore(event.getEquipmentVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event UnAssignBaseURIcoreFromEquipmentVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseURIcoreFromEquipmentVersionEvent.class)
  public void handle(UnAssignBaseURIcoreFromEquipmentVersionEvent event) {
    LOGGER.info("handling UnAssignBaseURIcoreFromEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentVersion entity = unAssignBaseURIcore(event.getEquipmentVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event AssignBaseURIoperationToEquipmentVersionEvent
   */
  @EventHandler(payloadType = AssignBaseURIoperationToEquipmentVersionEvent.class)
  public void handle(AssignBaseURIoperationToEquipmentVersionEvent event) {
    LOGGER.info("handling AssignBaseURIoperationToEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentVersion entity =
        assignBaseURIoperation(event.getEquipmentVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event UnAssignBaseURIoperationFromEquipmentVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseURIoperationFromEquipmentVersionEvent.class)
  public void handle(UnAssignBaseURIoperationFromEquipmentVersionEvent event) {
    LOGGER.info("handling UnAssignBaseURIoperationFromEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentVersion entity = unAssignBaseURIoperation(event.getEquipmentVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event AssignBaseURIshortCircuitToEquipmentVersionEvent
   */
  @EventHandler(payloadType = AssignBaseURIshortCircuitToEquipmentVersionEvent.class)
  public void handle(AssignBaseURIshortCircuitToEquipmentVersionEvent event) {
    LOGGER.info("handling AssignBaseURIshortCircuitToEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentVersion entity =
        assignBaseURIshortCircuit(event.getEquipmentVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event UnAssignBaseURIshortCircuitFromEquipmentVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseURIshortCircuitFromEquipmentVersionEvent.class)
  public void handle(UnAssignBaseURIshortCircuitFromEquipmentVersionEvent event) {
    LOGGER.info("handling UnAssignBaseURIshortCircuitFromEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentVersion entity = unAssignBaseURIshortCircuit(event.getEquipmentVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event AssignDateToEquipmentVersionEvent
   */
  @EventHandler(payloadType = AssignDateToEquipmentVersionEvent.class)
  public void handle(AssignDateToEquipmentVersionEvent event) {
    LOGGER.info("handling AssignDateToEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentVersion entity = assignDate(event.getEquipmentVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event UnAssignDateFromEquipmentVersionEvent
   */
  @EventHandler(payloadType = UnAssignDateFromEquipmentVersionEvent.class)
  public void handle(UnAssignDateFromEquipmentVersionEvent event) {
    LOGGER.info("handling UnAssignDateFromEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentVersion entity = unAssignDate(event.getEquipmentVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event AssignDifferenceModelURIToEquipmentVersionEvent
   */
  @EventHandler(payloadType = AssignDifferenceModelURIToEquipmentVersionEvent.class)
  public void handle(AssignDifferenceModelURIToEquipmentVersionEvent event) {
    LOGGER.info("handling AssignDifferenceModelURIToEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentVersion entity =
        assignDifferenceModelURI(event.getEquipmentVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event UnAssignDifferenceModelURIFromEquipmentVersionEvent
   */
  @EventHandler(payloadType = UnAssignDifferenceModelURIFromEquipmentVersionEvent.class)
  public void handle(UnAssignDifferenceModelURIFromEquipmentVersionEvent event) {
    LOGGER.info("handling UnAssignDifferenceModelURIFromEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentVersion entity = unAssignDifferenceModelURI(event.getEquipmentVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event AssignEntsoeUMLToEquipmentVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeUMLToEquipmentVersionEvent.class)
  public void handle(AssignEntsoeUMLToEquipmentVersionEvent event) {
    LOGGER.info("handling AssignEntsoeUMLToEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentVersion entity = assignEntsoeUML(event.getEquipmentVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeUMLFromEquipmentVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeUMLFromEquipmentVersionEvent.class)
  public void handle(UnAssignEntsoeUMLFromEquipmentVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeUMLFromEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentVersion entity = unAssignEntsoeUML(event.getEquipmentVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event AssignEntsoeURIcoreToEquipmentVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeURIcoreToEquipmentVersionEvent.class)
  public void handle(AssignEntsoeURIcoreToEquipmentVersionEvent event) {
    LOGGER.info("handling AssignEntsoeURIcoreToEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentVersion entity =
        assignEntsoeURIcore(event.getEquipmentVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeURIcoreFromEquipmentVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeURIcoreFromEquipmentVersionEvent.class)
  public void handle(UnAssignEntsoeURIcoreFromEquipmentVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeURIcoreFromEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentVersion entity = unAssignEntsoeURIcore(event.getEquipmentVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event AssignEntsoeURIoperationToEquipmentVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeURIoperationToEquipmentVersionEvent.class)
  public void handle(AssignEntsoeURIoperationToEquipmentVersionEvent event) {
    LOGGER.info("handling AssignEntsoeURIoperationToEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentVersion entity =
        assignEntsoeURIoperation(event.getEquipmentVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeURIoperationFromEquipmentVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeURIoperationFromEquipmentVersionEvent.class)
  public void handle(UnAssignEntsoeURIoperationFromEquipmentVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeURIoperationFromEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentVersion entity = unAssignEntsoeURIoperation(event.getEquipmentVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event AssignEntsoeURIshortCircuitToEquipmentVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeURIshortCircuitToEquipmentVersionEvent.class)
  public void handle(AssignEntsoeURIshortCircuitToEquipmentVersionEvent event) {
    LOGGER.info("handling AssignEntsoeURIshortCircuitToEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentVersion entity =
        assignEntsoeURIshortCircuit(event.getEquipmentVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeURIshortCircuitFromEquipmentVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeURIshortCircuitFromEquipmentVersionEvent.class)
  public void handle(UnAssignEntsoeURIshortCircuitFromEquipmentVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeURIshortCircuitFromEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentVersion entity = unAssignEntsoeURIshortCircuit(event.getEquipmentVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event AssignModelDescriptionURIToEquipmentVersionEvent
   */
  @EventHandler(payloadType = AssignModelDescriptionURIToEquipmentVersionEvent.class)
  public void handle(AssignModelDescriptionURIToEquipmentVersionEvent event) {
    LOGGER.info("handling AssignModelDescriptionURIToEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentVersion entity =
        assignModelDescriptionURI(event.getEquipmentVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event UnAssignModelDescriptionURIFromEquipmentVersionEvent
   */
  @EventHandler(payloadType = UnAssignModelDescriptionURIFromEquipmentVersionEvent.class)
  public void handle(UnAssignModelDescriptionURIFromEquipmentVersionEvent event) {
    LOGGER.info("handling UnAssignModelDescriptionURIFromEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentVersion entity = unAssignModelDescriptionURI(event.getEquipmentVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event AssignNamespaceRDFToEquipmentVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceRDFToEquipmentVersionEvent.class)
  public void handle(AssignNamespaceRDFToEquipmentVersionEvent event) {
    LOGGER.info("handling AssignNamespaceRDFToEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentVersion entity =
        assignNamespaceRDF(event.getEquipmentVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceRDFFromEquipmentVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceRDFFromEquipmentVersionEvent.class)
  public void handle(UnAssignNamespaceRDFFromEquipmentVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceRDFFromEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentVersion entity = unAssignNamespaceRDF(event.getEquipmentVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event AssignNamespaceUMLToEquipmentVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceUMLToEquipmentVersionEvent.class)
  public void handle(AssignNamespaceUMLToEquipmentVersionEvent event) {
    LOGGER.info("handling AssignNamespaceUMLToEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentVersion entity =
        assignNamespaceUML(event.getEquipmentVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceUMLFromEquipmentVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceUMLFromEquipmentVersionEvent.class)
  public void handle(UnAssignNamespaceUMLFromEquipmentVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceUMLFromEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentVersion entity = unAssignNamespaceUML(event.getEquipmentVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event AssignShortNameToEquipmentVersionEvent
   */
  @EventHandler(payloadType = AssignShortNameToEquipmentVersionEvent.class)
  public void handle(AssignShortNameToEquipmentVersionEvent event) {
    LOGGER.info("handling AssignShortNameToEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquipmentVersion entity = assignShortName(event.getEquipmentVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /*
   * @param	event UnAssignShortNameFromEquipmentVersionEvent
   */
  @EventHandler(payloadType = UnAssignShortNameFromEquipmentVersionEvent.class)
  public void handle(UnAssignShortNameFromEquipmentVersionEvent event) {
    LOGGER.info("handling UnAssignShortNameFromEquipmentVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquipmentVersion entity = unAssignShortName(event.getEquipmentVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquipmentVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquipmentVersion(entity);
  }

  /**
   * Method to retrieve the EquipmentVersion via an EquipmentVersionPrimaryKey.
   *
   * @param id Long
   * @return EquipmentVersion
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public EquipmentVersion handle(FindEquipmentVersionQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getEquipmentVersionId());
  }

  /**
   * Method to retrieve a collection of all EquipmentVersions
   *
   * @param query FindAllEquipmentVersionQuery
   * @return List<EquipmentVersion>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<EquipmentVersion> handle(FindAllEquipmentVersionQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindEquipmentVersion, but only if the id matches
   *
   * @param entity EquipmentVersion
   */
  protected void emitFindEquipmentVersion(EquipmentVersion entity) {
    LOGGER.info("handling emitFindEquipmentVersion");

    queryUpdateEmitter.emit(
        FindEquipmentVersionQuery.class,
        query -> query.getFilter().getEquipmentVersionId().equals(entity.getEquipmentVersionId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllEquipmentVersion
   *
   * @param entity EquipmentVersion
   */
  protected void emitFindAllEquipmentVersion(EquipmentVersion entity) {
    LOGGER.info("handling emitFindAllEquipmentVersion");

    queryUpdateEmitter.emit(FindAllEquipmentVersionQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(EquipmentVersionProjector.class.getName());
}
