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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.topologyprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for TopologyVersion as outlined for the CQRS pattern. All event handling and query
 * handling related to TopologyVersion are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by TopologyVersionAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("topologyVersion")
@Component("topologyVersion-projector")
public class TopologyVersionProjector extends TopologyVersionEntityProjector {

  // core constructor
  public TopologyVersionProjector(
      TopologyVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateTopologyVersionEvent
   */
  @EventHandler(payloadType = CreateTopologyVersionEvent.class)
  public void handle(CreateTopologyVersionEvent event) {
    LOGGER.info("handling CreateTopologyVersionEvent - " + event);
    TopologyVersion entity = new TopologyVersion();
    entity.setTopologyVersionId(event.getTopologyVersionId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event UpdateTopologyVersionEvent
   */
  @EventHandler(payloadType = UpdateTopologyVersionEvent.class)
  public void handle(UpdateTopologyVersionEvent event) {
    LOGGER.info("handling UpdateTopologyVersionEvent - " + event);

    TopologyVersion entity = new TopologyVersion();
    entity.setTopologyVersionId(event.getTopologyVersionId());
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
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event DeleteTopologyVersionEvent
   */
  @EventHandler(payloadType = DeleteTopologyVersionEvent.class)
  public void handle(DeleteTopologyVersionEvent event) {
    LOGGER.info("handling DeleteTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    TopologyVersion entity = delete(event.getTopologyVersionId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event AssignBaseUMLToTopologyVersionEvent
   */
  @EventHandler(payloadType = AssignBaseUMLToTopologyVersionEvent.class)
  public void handle(AssignBaseUMLToTopologyVersionEvent event) {
    LOGGER.info("handling AssignBaseUMLToTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyVersion entity = assignBaseUML(event.getTopologyVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event UnAssignBaseUMLFromTopologyVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseUMLFromTopologyVersionEvent.class)
  public void handle(UnAssignBaseUMLFromTopologyVersionEvent event) {
    LOGGER.info("handling UnAssignBaseUMLFromTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyVersion entity = unAssignBaseUML(event.getTopologyVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event AssignBaseURIToTopologyVersionEvent
   */
  @EventHandler(payloadType = AssignBaseURIToTopologyVersionEvent.class)
  public void handle(AssignBaseURIToTopologyVersionEvent event) {
    LOGGER.info("handling AssignBaseURIToTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyVersion entity = assignBaseURI(event.getTopologyVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event UnAssignBaseURIFromTopologyVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseURIFromTopologyVersionEvent.class)
  public void handle(UnAssignBaseURIFromTopologyVersionEvent event) {
    LOGGER.info("handling UnAssignBaseURIFromTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyVersion entity = unAssignBaseURI(event.getTopologyVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event AssignDateToTopologyVersionEvent
   */
  @EventHandler(payloadType = AssignDateToTopologyVersionEvent.class)
  public void handle(AssignDateToTopologyVersionEvent event) {
    LOGGER.info("handling AssignDateToTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyVersion entity = assignDate(event.getTopologyVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event UnAssignDateFromTopologyVersionEvent
   */
  @EventHandler(payloadType = UnAssignDateFromTopologyVersionEvent.class)
  public void handle(UnAssignDateFromTopologyVersionEvent event) {
    LOGGER.info("handling UnAssignDateFromTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyVersion entity = unAssignDate(event.getTopologyVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event AssignDifferenceModelURIToTopologyVersionEvent
   */
  @EventHandler(payloadType = AssignDifferenceModelURIToTopologyVersionEvent.class)
  public void handle(AssignDifferenceModelURIToTopologyVersionEvent event) {
    LOGGER.info("handling AssignDifferenceModelURIToTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyVersion entity =
        assignDifferenceModelURI(event.getTopologyVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event UnAssignDifferenceModelURIFromTopologyVersionEvent
   */
  @EventHandler(payloadType = UnAssignDifferenceModelURIFromTopologyVersionEvent.class)
  public void handle(UnAssignDifferenceModelURIFromTopologyVersionEvent event) {
    LOGGER.info("handling UnAssignDifferenceModelURIFromTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyVersion entity = unAssignDifferenceModelURI(event.getTopologyVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event AssignEntsoeUMLToTopologyVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeUMLToTopologyVersionEvent.class)
  public void handle(AssignEntsoeUMLToTopologyVersionEvent event) {
    LOGGER.info("handling AssignEntsoeUMLToTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyVersion entity = assignEntsoeUML(event.getTopologyVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeUMLFromTopologyVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeUMLFromTopologyVersionEvent.class)
  public void handle(UnAssignEntsoeUMLFromTopologyVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeUMLFromTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyVersion entity = unAssignEntsoeUML(event.getTopologyVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event AssignEntsoeURIToTopologyVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeURIToTopologyVersionEvent.class)
  public void handle(AssignEntsoeURIToTopologyVersionEvent event) {
    LOGGER.info("handling AssignEntsoeURIToTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyVersion entity = assignEntsoeURI(event.getTopologyVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeURIFromTopologyVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeURIFromTopologyVersionEvent.class)
  public void handle(UnAssignEntsoeURIFromTopologyVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeURIFromTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyVersion entity = unAssignEntsoeURI(event.getTopologyVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event AssignModelDescriptionURIToTopologyVersionEvent
   */
  @EventHandler(payloadType = AssignModelDescriptionURIToTopologyVersionEvent.class)
  public void handle(AssignModelDescriptionURIToTopologyVersionEvent event) {
    LOGGER.info("handling AssignModelDescriptionURIToTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyVersion entity =
        assignModelDescriptionURI(event.getTopologyVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event UnAssignModelDescriptionURIFromTopologyVersionEvent
   */
  @EventHandler(payloadType = UnAssignModelDescriptionURIFromTopologyVersionEvent.class)
  public void handle(UnAssignModelDescriptionURIFromTopologyVersionEvent event) {
    LOGGER.info("handling UnAssignModelDescriptionURIFromTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyVersion entity = unAssignModelDescriptionURI(event.getTopologyVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event AssignNamespaceRDFToTopologyVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceRDFToTopologyVersionEvent.class)
  public void handle(AssignNamespaceRDFToTopologyVersionEvent event) {
    LOGGER.info("handling AssignNamespaceRDFToTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyVersion entity =
        assignNamespaceRDF(event.getTopologyVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceRDFFromTopologyVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceRDFFromTopologyVersionEvent.class)
  public void handle(UnAssignNamespaceRDFFromTopologyVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceRDFFromTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyVersion entity = unAssignNamespaceRDF(event.getTopologyVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event AssignNamespaceUMLToTopologyVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceUMLToTopologyVersionEvent.class)
  public void handle(AssignNamespaceUMLToTopologyVersionEvent event) {
    LOGGER.info("handling AssignNamespaceUMLToTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyVersion entity =
        assignNamespaceUML(event.getTopologyVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceUMLFromTopologyVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceUMLFromTopologyVersionEvent.class)
  public void handle(UnAssignNamespaceUMLFromTopologyVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceUMLFromTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyVersion entity = unAssignNamespaceUML(event.getTopologyVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event AssignShortNameToTopologyVersionEvent
   */
  @EventHandler(payloadType = AssignShortNameToTopologyVersionEvent.class)
  public void handle(AssignShortNameToTopologyVersionEvent event) {
    LOGGER.info("handling AssignShortNameToTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyVersion entity = assignShortName(event.getTopologyVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /*
   * @param	event UnAssignShortNameFromTopologyVersionEvent
   */
  @EventHandler(payloadType = UnAssignShortNameFromTopologyVersionEvent.class)
  public void handle(UnAssignShortNameFromTopologyVersionEvent event) {
    LOGGER.info("handling UnAssignShortNameFromTopologyVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyVersion entity = unAssignShortName(event.getTopologyVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyVersion(entity);
  }

  /**
   * Method to retrieve the TopologyVersion via an TopologyVersionPrimaryKey.
   *
   * @param id Long
   * @return TopologyVersion
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public TopologyVersion handle(FindTopologyVersionQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getTopologyVersionId());
  }

  /**
   * Method to retrieve a collection of all TopologyVersions
   *
   * @param query FindAllTopologyVersionQuery
   * @return List<TopologyVersion>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<TopologyVersion> handle(FindAllTopologyVersionQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindTopologyVersion, but only if the id matches
   *
   * @param entity TopologyVersion
   */
  protected void emitFindTopologyVersion(TopologyVersion entity) {
    LOGGER.info("handling emitFindTopologyVersion");

    queryUpdateEmitter.emit(
        FindTopologyVersionQuery.class,
        query -> query.getFilter().getTopologyVersionId().equals(entity.getTopologyVersionId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllTopologyVersion
   *
   * @param entity TopologyVersion
   */
  protected void emitFindAllTopologyVersion(TopologyVersion entity) {
    LOGGER.info("handling emitFindAllTopologyVersion");

    queryUpdateEmitter.emit(FindAllTopologyVersionQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(TopologyVersionProjector.class.getName());
}
