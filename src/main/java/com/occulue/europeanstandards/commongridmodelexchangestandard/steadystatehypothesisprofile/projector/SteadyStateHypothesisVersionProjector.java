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
package com.occulue.europeanstandards.commongridmodelexchangestandard.steadystatehypothesisprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.steadystatehypothesisprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for SteadyStateHypothesisVersion as outlined for the CQRS pattern. All event handling
 * and query handling related to SteadyStateHypothesisVersion are invoked here and dispersed as an
 * event to be handled elsewhere.
 *
 * <p>Commands are handled by SteadyStateHypothesisVersionAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("steadyStateHypothesisVersion")
@Component("steadyStateHypothesisVersion-projector")
public class SteadyStateHypothesisVersionProjector
    extends SteadyStateHypothesisVersionEntityProjector {

  // core constructor
  public SteadyStateHypothesisVersionProjector(
      SteadyStateHypothesisVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = CreateSteadyStateHypothesisVersionEvent.class)
  public void handle(CreateSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling CreateSteadyStateHypothesisVersionEvent - " + event);
    SteadyStateHypothesisVersion entity = new SteadyStateHypothesisVersion();
    entity.setSteadyStateHypothesisVersionId(event.getSteadyStateHypothesisVersionId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event UpdateSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = UpdateSteadyStateHypothesisVersionEvent.class)
  public void handle(UpdateSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling UpdateSteadyStateHypothesisVersionEvent - " + event);

    SteadyStateHypothesisVersion entity = new SteadyStateHypothesisVersion();
    entity.setSteadyStateHypothesisVersionId(event.getSteadyStateHypothesisVersionId());
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
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event DeleteSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = DeleteSteadyStateHypothesisVersionEvent.class)
  public void handle(DeleteSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling DeleteSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    SteadyStateHypothesisVersion entity = delete(event.getSteadyStateHypothesisVersionId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event AssignBaseUMLToSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = AssignBaseUMLToSteadyStateHypothesisVersionEvent.class)
  public void handle(AssignBaseUMLToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling AssignBaseUMLToSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        assignBaseUML(event.getSteadyStateHypothesisVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event UnAssignBaseUMLFromSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseUMLFromSteadyStateHypothesisVersionEvent.class)
  public void handle(UnAssignBaseUMLFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling UnAssignBaseUMLFromSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        unAssignBaseUML(event.getSteadyStateHypothesisVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event AssignBaseURIToSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = AssignBaseURIToSteadyStateHypothesisVersionEvent.class)
  public void handle(AssignBaseURIToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling AssignBaseURIToSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        assignBaseURI(event.getSteadyStateHypothesisVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event UnAssignBaseURIFromSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseURIFromSteadyStateHypothesisVersionEvent.class)
  public void handle(UnAssignBaseURIFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling UnAssignBaseURIFromSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        unAssignBaseURI(event.getSteadyStateHypothesisVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event AssignDateToSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = AssignDateToSteadyStateHypothesisVersionEvent.class)
  public void handle(AssignDateToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling AssignDateToSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        assignDate(event.getSteadyStateHypothesisVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event UnAssignDateFromSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = UnAssignDateFromSteadyStateHypothesisVersionEvent.class)
  public void handle(UnAssignDateFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling UnAssignDateFromSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SteadyStateHypothesisVersion entity = unAssignDate(event.getSteadyStateHypothesisVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event AssignDifferenceModelURIToSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = AssignDifferenceModelURIToSteadyStateHypothesisVersionEvent.class)
  public void handle(AssignDifferenceModelURIToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling AssignDifferenceModelURIToSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        assignDifferenceModelURI(event.getSteadyStateHypothesisVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionEvent.class)
  public void handle(UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info(
        "handling UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        unAssignDifferenceModelURI(event.getSteadyStateHypothesisVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event AssignEntsoeUMLToSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeUMLToSteadyStateHypothesisVersionEvent.class)
  public void handle(AssignEntsoeUMLToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling AssignEntsoeUMLToSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        assignEntsoeUML(event.getSteadyStateHypothesisVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeUMLFromSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeUMLFromSteadyStateHypothesisVersionEvent.class)
  public void handle(UnAssignEntsoeUMLFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeUMLFromSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        unAssignEntsoeUML(event.getSteadyStateHypothesisVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event AssignEntsoeURIToSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeURIToSteadyStateHypothesisVersionEvent.class)
  public void handle(AssignEntsoeURIToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling AssignEntsoeURIToSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        assignEntsoeURI(event.getSteadyStateHypothesisVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeURIFromSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeURIFromSteadyStateHypothesisVersionEvent.class)
  public void handle(UnAssignEntsoeURIFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeURIFromSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        unAssignEntsoeURI(event.getSteadyStateHypothesisVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event AssignModelDescriptionURIToSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = AssignModelDescriptionURIToSteadyStateHypothesisVersionEvent.class)
  public void handle(AssignModelDescriptionURIToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling AssignModelDescriptionURIToSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        assignModelDescriptionURI(event.getSteadyStateHypothesisVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionEvent
   */
  @EventHandler(
      payloadType = UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionEvent.class)
  public void handle(UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info(
        "handling UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        unAssignModelDescriptionURI(event.getSteadyStateHypothesisVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event AssignNamespaceRDFToSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceRDFToSteadyStateHypothesisVersionEvent.class)
  public void handle(AssignNamespaceRDFToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling AssignNamespaceRDFToSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        assignNamespaceRDF(event.getSteadyStateHypothesisVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceRDFFromSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceRDFFromSteadyStateHypothesisVersionEvent.class)
  public void handle(UnAssignNamespaceRDFFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceRDFFromSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        unAssignNamespaceRDF(event.getSteadyStateHypothesisVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event AssignNamespaceUMLToSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceUMLToSteadyStateHypothesisVersionEvent.class)
  public void handle(AssignNamespaceUMLToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling AssignNamespaceUMLToSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        assignNamespaceUML(event.getSteadyStateHypothesisVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceUMLFromSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceUMLFromSteadyStateHypothesisVersionEvent.class)
  public void handle(UnAssignNamespaceUMLFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceUMLFromSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        unAssignNamespaceUML(event.getSteadyStateHypothesisVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event AssignShortNameToSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = AssignShortNameToSteadyStateHypothesisVersionEvent.class)
  public void handle(AssignShortNameToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling AssignShortNameToSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        assignShortName(event.getSteadyStateHypothesisVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /*
   * @param	event UnAssignShortNameFromSteadyStateHypothesisVersionEvent
   */
  @EventHandler(payloadType = UnAssignShortNameFromSteadyStateHypothesisVersionEvent.class)
  public void handle(UnAssignShortNameFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("handling UnAssignShortNameFromSteadyStateHypothesisVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SteadyStateHypothesisVersion entity =
        unAssignShortName(event.getSteadyStateHypothesisVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSteadyStateHypothesisVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSteadyStateHypothesisVersion(entity);
  }

  /**
   * Method to retrieve the SteadyStateHypothesisVersion via an
   * SteadyStateHypothesisVersionPrimaryKey.
   *
   * @param id Long
   * @return SteadyStateHypothesisVersion
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public SteadyStateHypothesisVersion handle(FindSteadyStateHypothesisVersionQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getSteadyStateHypothesisVersionId());
  }

  /**
   * Method to retrieve a collection of all SteadyStateHypothesisVersions
   *
   * @param query FindAllSteadyStateHypothesisVersionQuery
   * @return List<SteadyStateHypothesisVersion>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<SteadyStateHypothesisVersion> handle(FindAllSteadyStateHypothesisVersionQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindSteadyStateHypothesisVersion, but only if the id
   * matches
   *
   * @param entity SteadyStateHypothesisVersion
   */
  protected void emitFindSteadyStateHypothesisVersion(SteadyStateHypothesisVersion entity) {
    LOGGER.info("handling emitFindSteadyStateHypothesisVersion");

    queryUpdateEmitter.emit(
        FindSteadyStateHypothesisVersionQuery.class,
        query ->
            query
                .getFilter()
                .getSteadyStateHypothesisVersionId()
                .equals(entity.getSteadyStateHypothesisVersionId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllSteadyStateHypothesisVersion
   *
   * @param entity SteadyStateHypothesisVersion
   */
  protected void emitFindAllSteadyStateHypothesisVersion(SteadyStateHypothesisVersion entity) {
    LOGGER.info("handling emitFindAllSteadyStateHypothesisVersion");

    queryUpdateEmitter.emit(FindAllSteadyStateHypothesisVersionQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(SteadyStateHypothesisVersionProjector.class.getName());
}
