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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for GeographicalLocationVersion as outlined for the CQRS pattern. All event handling
 * and query handling related to GeographicalLocationVersion are invoked here and dispersed as an
 * event to be handled elsewhere.
 *
 * <p>Commands are handled by GeographicalLocationVersionAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("geographicalLocationVersion")
@Component("geographicalLocationVersion-projector")
public class GeographicalLocationVersionProjector
    extends GeographicalLocationVersionEntityProjector {

  // core constructor
  public GeographicalLocationVersionProjector(
      GeographicalLocationVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = CreateGeographicalLocationVersionEvent.class)
  public void handle(CreateGeographicalLocationVersionEvent event) {
    LOGGER.info("handling CreateGeographicalLocationVersionEvent - " + event);
    GeographicalLocationVersion entity = new GeographicalLocationVersion();
    entity.setGeographicalLocationVersionId(event.getGeographicalLocationVersionId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event UpdateGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = UpdateGeographicalLocationVersionEvent.class)
  public void handle(UpdateGeographicalLocationVersionEvent event) {
    LOGGER.info("handling UpdateGeographicalLocationVersionEvent - " + event);

    GeographicalLocationVersion entity = new GeographicalLocationVersion();
    entity.setGeographicalLocationVersionId(event.getGeographicalLocationVersionId());
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
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event DeleteGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = DeleteGeographicalLocationVersionEvent.class)
  public void handle(DeleteGeographicalLocationVersionEvent event) {
    LOGGER.info("handling DeleteGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GeographicalLocationVersion entity = delete(event.getGeographicalLocationVersionId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event AssignBaseUMLToGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = AssignBaseUMLToGeographicalLocationVersionEvent.class)
  public void handle(AssignBaseUMLToGeographicalLocationVersionEvent event) {
    LOGGER.info("handling AssignBaseUMLToGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeographicalLocationVersion entity =
        assignBaseUML(event.getGeographicalLocationVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event UnAssignBaseUMLFromGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseUMLFromGeographicalLocationVersionEvent.class)
  public void handle(UnAssignBaseUMLFromGeographicalLocationVersionEvent event) {
    LOGGER.info("handling UnAssignBaseUMLFromGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeographicalLocationVersion entity = unAssignBaseUML(event.getGeographicalLocationVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event AssignBaseURIToGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = AssignBaseURIToGeographicalLocationVersionEvent.class)
  public void handle(AssignBaseURIToGeographicalLocationVersionEvent event) {
    LOGGER.info("handling AssignBaseURIToGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeographicalLocationVersion entity =
        assignBaseURI(event.getGeographicalLocationVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event UnAssignBaseURIFromGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseURIFromGeographicalLocationVersionEvent.class)
  public void handle(UnAssignBaseURIFromGeographicalLocationVersionEvent event) {
    LOGGER.info("handling UnAssignBaseURIFromGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeographicalLocationVersion entity = unAssignBaseURI(event.getGeographicalLocationVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event AssignDateToGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = AssignDateToGeographicalLocationVersionEvent.class)
  public void handle(AssignDateToGeographicalLocationVersionEvent event) {
    LOGGER.info("handling AssignDateToGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeographicalLocationVersion entity =
        assignDate(event.getGeographicalLocationVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event UnAssignDateFromGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = UnAssignDateFromGeographicalLocationVersionEvent.class)
  public void handle(UnAssignDateFromGeographicalLocationVersionEvent event) {
    LOGGER.info("handling UnAssignDateFromGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeographicalLocationVersion entity = unAssignDate(event.getGeographicalLocationVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event AssignDifferenceModelURIToGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = AssignDifferenceModelURIToGeographicalLocationVersionEvent.class)
  public void handle(AssignDifferenceModelURIToGeographicalLocationVersionEvent event) {
    LOGGER.info("handling AssignDifferenceModelURIToGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeographicalLocationVersion entity =
        assignDifferenceModelURI(event.getGeographicalLocationVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event UnAssignDifferenceModelURIFromGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = UnAssignDifferenceModelURIFromGeographicalLocationVersionEvent.class)
  public void handle(UnAssignDifferenceModelURIFromGeographicalLocationVersionEvent event) {
    LOGGER.info(
        "handling UnAssignDifferenceModelURIFromGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeographicalLocationVersion entity =
        unAssignDifferenceModelURI(event.getGeographicalLocationVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event AssignEntsoeUMLToGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeUMLToGeographicalLocationVersionEvent.class)
  public void handle(AssignEntsoeUMLToGeographicalLocationVersionEvent event) {
    LOGGER.info("handling AssignEntsoeUMLToGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeographicalLocationVersion entity =
        assignEntsoeUML(event.getGeographicalLocationVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeUMLFromGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeUMLFromGeographicalLocationVersionEvent.class)
  public void handle(UnAssignEntsoeUMLFromGeographicalLocationVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeUMLFromGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeographicalLocationVersion entity =
        unAssignEntsoeUML(event.getGeographicalLocationVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event AssignEntsoeURIToGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeURIToGeographicalLocationVersionEvent.class)
  public void handle(AssignEntsoeURIToGeographicalLocationVersionEvent event) {
    LOGGER.info("handling AssignEntsoeURIToGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeographicalLocationVersion entity =
        assignEntsoeURI(event.getGeographicalLocationVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeURIFromGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeURIFromGeographicalLocationVersionEvent.class)
  public void handle(UnAssignEntsoeURIFromGeographicalLocationVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeURIFromGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeographicalLocationVersion entity =
        unAssignEntsoeURI(event.getGeographicalLocationVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event AssignModelDescriptionURIToGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = AssignModelDescriptionURIToGeographicalLocationVersionEvent.class)
  public void handle(AssignModelDescriptionURIToGeographicalLocationVersionEvent event) {
    LOGGER.info("handling AssignModelDescriptionURIToGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeographicalLocationVersion entity =
        assignModelDescriptionURI(event.getGeographicalLocationVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event UnAssignModelDescriptionURIFromGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = UnAssignModelDescriptionURIFromGeographicalLocationVersionEvent.class)
  public void handle(UnAssignModelDescriptionURIFromGeographicalLocationVersionEvent event) {
    LOGGER.info(
        "handling UnAssignModelDescriptionURIFromGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeographicalLocationVersion entity =
        unAssignModelDescriptionURI(event.getGeographicalLocationVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event AssignNamespaceRDFToGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceRDFToGeographicalLocationVersionEvent.class)
  public void handle(AssignNamespaceRDFToGeographicalLocationVersionEvent event) {
    LOGGER.info("handling AssignNamespaceRDFToGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeographicalLocationVersion entity =
        assignNamespaceRDF(event.getGeographicalLocationVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceRDFFromGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceRDFFromGeographicalLocationVersionEvent.class)
  public void handle(UnAssignNamespaceRDFFromGeographicalLocationVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceRDFFromGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeographicalLocationVersion entity =
        unAssignNamespaceRDF(event.getGeographicalLocationVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event AssignNamespaceUMLToGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceUMLToGeographicalLocationVersionEvent.class)
  public void handle(AssignNamespaceUMLToGeographicalLocationVersionEvent event) {
    LOGGER.info("handling AssignNamespaceUMLToGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeographicalLocationVersion entity =
        assignNamespaceUML(event.getGeographicalLocationVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceUMLFromGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceUMLFromGeographicalLocationVersionEvent.class)
  public void handle(UnAssignNamespaceUMLFromGeographicalLocationVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceUMLFromGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeographicalLocationVersion entity =
        unAssignNamespaceUML(event.getGeographicalLocationVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event AssignShortNameToGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = AssignShortNameToGeographicalLocationVersionEvent.class)
  public void handle(AssignShortNameToGeographicalLocationVersionEvent event) {
    LOGGER.info("handling AssignShortNameToGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GeographicalLocationVersion entity =
        assignShortName(event.getGeographicalLocationVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /*
   * @param	event UnAssignShortNameFromGeographicalLocationVersionEvent
   */
  @EventHandler(payloadType = UnAssignShortNameFromGeographicalLocationVersionEvent.class)
  public void handle(UnAssignShortNameFromGeographicalLocationVersionEvent event) {
    LOGGER.info("handling UnAssignShortNameFromGeographicalLocationVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GeographicalLocationVersion entity =
        unAssignShortName(event.getGeographicalLocationVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGeographicalLocationVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGeographicalLocationVersion(entity);
  }

  /**
   * Method to retrieve the GeographicalLocationVersion via an
   * GeographicalLocationVersionPrimaryKey.
   *
   * @param id Long
   * @return GeographicalLocationVersion
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GeographicalLocationVersion handle(FindGeographicalLocationVersionQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGeographicalLocationVersionId());
  }

  /**
   * Method to retrieve a collection of all GeographicalLocationVersions
   *
   * @param query FindAllGeographicalLocationVersionQuery
   * @return List<GeographicalLocationVersion>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GeographicalLocationVersion> handle(FindAllGeographicalLocationVersionQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGeographicalLocationVersion, but only if the id
   * matches
   *
   * @param entity GeographicalLocationVersion
   */
  protected void emitFindGeographicalLocationVersion(GeographicalLocationVersion entity) {
    LOGGER.info("handling emitFindGeographicalLocationVersion");

    queryUpdateEmitter.emit(
        FindGeographicalLocationVersionQuery.class,
        query ->
            query
                .getFilter()
                .getGeographicalLocationVersionId()
                .equals(entity.getGeographicalLocationVersionId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGeographicalLocationVersion
   *
   * @param entity GeographicalLocationVersion
   */
  protected void emitFindAllGeographicalLocationVersion(GeographicalLocationVersion entity) {
    LOGGER.info("handling emitFindAllGeographicalLocationVersion");

    queryUpdateEmitter.emit(FindAllGeographicalLocationVersionQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(GeographicalLocationVersionProjector.class.getName());
}
