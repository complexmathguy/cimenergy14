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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for TopologyBoundaryVersion as outlined for the CQRS pattern. All event handling and
 * query handling related to TopologyBoundaryVersion are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by TopologyBoundaryVersionAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("topologyBoundaryVersion")
@Component("topologyBoundaryVersion-projector")
public class TopologyBoundaryVersionProjector extends TopologyBoundaryVersionEntityProjector {

  // core constructor
  public TopologyBoundaryVersionProjector(
      TopologyBoundaryVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = CreateTopologyBoundaryVersionEvent.class)
  public void handle(CreateTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling CreateTopologyBoundaryVersionEvent - " + event);
    TopologyBoundaryVersion entity = new TopologyBoundaryVersion();
    entity.setTopologyBoundaryVersionId(event.getTopologyBoundaryVersionId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event UpdateTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = UpdateTopologyBoundaryVersionEvent.class)
  public void handle(UpdateTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling UpdateTopologyBoundaryVersionEvent - " + event);

    TopologyBoundaryVersion entity = new TopologyBoundaryVersion();
    entity.setTopologyBoundaryVersionId(event.getTopologyBoundaryVersionId());
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
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event DeleteTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = DeleteTopologyBoundaryVersionEvent.class)
  public void handle(DeleteTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling DeleteTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    TopologyBoundaryVersion entity = delete(event.getTopologyBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event AssignBaseUMLToTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignBaseUMLToTopologyBoundaryVersionEvent.class)
  public void handle(AssignBaseUMLToTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling AssignBaseUMLToTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyBoundaryVersion entity =
        assignBaseUML(event.getTopologyBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignBaseUMLFromTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseUMLFromTopologyBoundaryVersionEvent.class)
  public void handle(UnAssignBaseUMLFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignBaseUMLFromTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyBoundaryVersion entity = unAssignBaseUML(event.getTopologyBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event AssignBaseURIToTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignBaseURIToTopologyBoundaryVersionEvent.class)
  public void handle(AssignBaseURIToTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling AssignBaseURIToTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyBoundaryVersion entity =
        assignBaseURI(event.getTopologyBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignBaseURIFromTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseURIFromTopologyBoundaryVersionEvent.class)
  public void handle(UnAssignBaseURIFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignBaseURIFromTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyBoundaryVersion entity = unAssignBaseURI(event.getTopologyBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event AssignDateToTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignDateToTopologyBoundaryVersionEvent.class)
  public void handle(AssignDateToTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling AssignDateToTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyBoundaryVersion entity =
        assignDate(event.getTopologyBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignDateFromTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignDateFromTopologyBoundaryVersionEvent.class)
  public void handle(UnAssignDateFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignDateFromTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyBoundaryVersion entity = unAssignDate(event.getTopologyBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event AssignDifferenceModelURIToTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignDifferenceModelURIToTopologyBoundaryVersionEvent.class)
  public void handle(AssignDifferenceModelURIToTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling AssignDifferenceModelURIToTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyBoundaryVersion entity =
        assignDifferenceModelURI(event.getTopologyBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignDifferenceModelURIFromTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignDifferenceModelURIFromTopologyBoundaryVersionEvent.class)
  public void handle(UnAssignDifferenceModelURIFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignDifferenceModelURIFromTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyBoundaryVersion entity =
        unAssignDifferenceModelURI(event.getTopologyBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event AssignEntsoeUMLToTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeUMLToTopologyBoundaryVersionEvent.class)
  public void handle(AssignEntsoeUMLToTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling AssignEntsoeUMLToTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyBoundaryVersion entity =
        assignEntsoeUML(event.getTopologyBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeUMLFromTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeUMLFromTopologyBoundaryVersionEvent.class)
  public void handle(UnAssignEntsoeUMLFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeUMLFromTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyBoundaryVersion entity = unAssignEntsoeUML(event.getTopologyBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event AssignEntsoeURIToTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeURIToTopologyBoundaryVersionEvent.class)
  public void handle(AssignEntsoeURIToTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling AssignEntsoeURIToTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyBoundaryVersion entity =
        assignEntsoeURI(event.getTopologyBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeURIFromTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeURIFromTopologyBoundaryVersionEvent.class)
  public void handle(UnAssignEntsoeURIFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeURIFromTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyBoundaryVersion entity = unAssignEntsoeURI(event.getTopologyBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event AssignModelDescriptionURIToTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignModelDescriptionURIToTopologyBoundaryVersionEvent.class)
  public void handle(AssignModelDescriptionURIToTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling AssignModelDescriptionURIToTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyBoundaryVersion entity =
        assignModelDescriptionURI(event.getTopologyBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignModelDescriptionURIFromTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignModelDescriptionURIFromTopologyBoundaryVersionEvent.class)
  public void handle(UnAssignModelDescriptionURIFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignModelDescriptionURIFromTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyBoundaryVersion entity =
        unAssignModelDescriptionURI(event.getTopologyBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event AssignNamespaceRDFToTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceRDFToTopologyBoundaryVersionEvent.class)
  public void handle(AssignNamespaceRDFToTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling AssignNamespaceRDFToTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyBoundaryVersion entity =
        assignNamespaceRDF(event.getTopologyBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceRDFFromTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceRDFFromTopologyBoundaryVersionEvent.class)
  public void handle(UnAssignNamespaceRDFFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceRDFFromTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyBoundaryVersion entity = unAssignNamespaceRDF(event.getTopologyBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event AssignNamespaceUMLToTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceUMLToTopologyBoundaryVersionEvent.class)
  public void handle(AssignNamespaceUMLToTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling AssignNamespaceUMLToTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyBoundaryVersion entity =
        assignNamespaceUML(event.getTopologyBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceUMLFromTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceUMLFromTopologyBoundaryVersionEvent.class)
  public void handle(UnAssignNamespaceUMLFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceUMLFromTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyBoundaryVersion entity = unAssignNamespaceUML(event.getTopologyBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event AssignShortNameToTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = AssignShortNameToTopologyBoundaryVersionEvent.class)
  public void handle(AssignShortNameToTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling AssignShortNameToTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TopologyBoundaryVersion entity =
        assignShortName(event.getTopologyBoundaryVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /*
   * @param	event UnAssignShortNameFromTopologyBoundaryVersionEvent
   */
  @EventHandler(payloadType = UnAssignShortNameFromTopologyBoundaryVersionEvent.class)
  public void handle(UnAssignShortNameFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("handling UnAssignShortNameFromTopologyBoundaryVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TopologyBoundaryVersion entity = unAssignShortName(event.getTopologyBoundaryVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTopologyBoundaryVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTopologyBoundaryVersion(entity);
  }

  /**
   * Method to retrieve the TopologyBoundaryVersion via an TopologyBoundaryVersionPrimaryKey.
   *
   * @param id Long
   * @return TopologyBoundaryVersion
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public TopologyBoundaryVersion handle(FindTopologyBoundaryVersionQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getTopologyBoundaryVersionId());
  }

  /**
   * Method to retrieve a collection of all TopologyBoundaryVersions
   *
   * @param query FindAllTopologyBoundaryVersionQuery
   * @return List<TopologyBoundaryVersion>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<TopologyBoundaryVersion> handle(FindAllTopologyBoundaryVersionQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindTopologyBoundaryVersion, but only if the id matches
   *
   * @param entity TopologyBoundaryVersion
   */
  protected void emitFindTopologyBoundaryVersion(TopologyBoundaryVersion entity) {
    LOGGER.info("handling emitFindTopologyBoundaryVersion");

    queryUpdateEmitter.emit(
        FindTopologyBoundaryVersionQuery.class,
        query ->
            query
                .getFilter()
                .getTopologyBoundaryVersionId()
                .equals(entity.getTopologyBoundaryVersionId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllTopologyBoundaryVersion
   *
   * @param entity TopologyBoundaryVersion
   */
  protected void emitFindAllTopologyBoundaryVersion(TopologyBoundaryVersion entity) {
    LOGGER.info("handling emitFindAllTopologyBoundaryVersion");

    queryUpdateEmitter.emit(FindAllTopologyBoundaryVersionQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(TopologyBoundaryVersionProjector.class.getName());
}
