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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for StateVariablesVersion as outlined for the CQRS pattern. All event handling and
 * query handling related to StateVariablesVersion are invoked here and dispersed as an event to be
 * handled elsewhere.
 *
 * <p>Commands are handled by StateVariablesVersionAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("stateVariablesVersion")
@Component("stateVariablesVersion-projector")
public class StateVariablesVersionProjector extends StateVariablesVersionEntityProjector {

  // core constructor
  public StateVariablesVersionProjector(
      StateVariablesVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateStateVariablesVersionEvent
   */
  @EventHandler(payloadType = CreateStateVariablesVersionEvent.class)
  public void handle(CreateStateVariablesVersionEvent event) {
    LOGGER.info("handling CreateStateVariablesVersionEvent - " + event);
    StateVariablesVersion entity = new StateVariablesVersion();
    entity.setStateVariablesVersionId(event.getStateVariablesVersionId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event UpdateStateVariablesVersionEvent
   */
  @EventHandler(payloadType = UpdateStateVariablesVersionEvent.class)
  public void handle(UpdateStateVariablesVersionEvent event) {
    LOGGER.info("handling UpdateStateVariablesVersionEvent - " + event);

    StateVariablesVersion entity = new StateVariablesVersion();
    entity.setStateVariablesVersionId(event.getStateVariablesVersionId());
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
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event DeleteStateVariablesVersionEvent
   */
  @EventHandler(payloadType = DeleteStateVariablesVersionEvent.class)
  public void handle(DeleteStateVariablesVersionEvent event) {
    LOGGER.info("handling DeleteStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    StateVariablesVersion entity = delete(event.getStateVariablesVersionId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event AssignBaseUMLToStateVariablesVersionEvent
   */
  @EventHandler(payloadType = AssignBaseUMLToStateVariablesVersionEvent.class)
  public void handle(AssignBaseUMLToStateVariablesVersionEvent event) {
    LOGGER.info("handling AssignBaseUMLToStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    StateVariablesVersion entity =
        assignBaseUML(event.getStateVariablesVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event UnAssignBaseUMLFromStateVariablesVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseUMLFromStateVariablesVersionEvent.class)
  public void handle(UnAssignBaseUMLFromStateVariablesVersionEvent event) {
    LOGGER.info("handling UnAssignBaseUMLFromStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    StateVariablesVersion entity = unAssignBaseUML(event.getStateVariablesVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event AssignBaseURIToStateVariablesVersionEvent
   */
  @EventHandler(payloadType = AssignBaseURIToStateVariablesVersionEvent.class)
  public void handle(AssignBaseURIToStateVariablesVersionEvent event) {
    LOGGER.info("handling AssignBaseURIToStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    StateVariablesVersion entity =
        assignBaseURI(event.getStateVariablesVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event UnAssignBaseURIFromStateVariablesVersionEvent
   */
  @EventHandler(payloadType = UnAssignBaseURIFromStateVariablesVersionEvent.class)
  public void handle(UnAssignBaseURIFromStateVariablesVersionEvent event) {
    LOGGER.info("handling UnAssignBaseURIFromStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    StateVariablesVersion entity = unAssignBaseURI(event.getStateVariablesVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event AssignDateToStateVariablesVersionEvent
   */
  @EventHandler(payloadType = AssignDateToStateVariablesVersionEvent.class)
  public void handle(AssignDateToStateVariablesVersionEvent event) {
    LOGGER.info("handling AssignDateToStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    StateVariablesVersion entity =
        assignDate(event.getStateVariablesVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event UnAssignDateFromStateVariablesVersionEvent
   */
  @EventHandler(payloadType = UnAssignDateFromStateVariablesVersionEvent.class)
  public void handle(UnAssignDateFromStateVariablesVersionEvent event) {
    LOGGER.info("handling UnAssignDateFromStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    StateVariablesVersion entity = unAssignDate(event.getStateVariablesVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event AssignDifferenceModelURIToStateVariablesVersionEvent
   */
  @EventHandler(payloadType = AssignDifferenceModelURIToStateVariablesVersionEvent.class)
  public void handle(AssignDifferenceModelURIToStateVariablesVersionEvent event) {
    LOGGER.info("handling AssignDifferenceModelURIToStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    StateVariablesVersion entity =
        assignDifferenceModelURI(event.getStateVariablesVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event UnAssignDifferenceModelURIFromStateVariablesVersionEvent
   */
  @EventHandler(payloadType = UnAssignDifferenceModelURIFromStateVariablesVersionEvent.class)
  public void handle(UnAssignDifferenceModelURIFromStateVariablesVersionEvent event) {
    LOGGER.info("handling UnAssignDifferenceModelURIFromStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    StateVariablesVersion entity = unAssignDifferenceModelURI(event.getStateVariablesVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event AssignEntsoeUMLToStateVariablesVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeUMLToStateVariablesVersionEvent.class)
  public void handle(AssignEntsoeUMLToStateVariablesVersionEvent event) {
    LOGGER.info("handling AssignEntsoeUMLToStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    StateVariablesVersion entity =
        assignEntsoeUML(event.getStateVariablesVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeUMLFromStateVariablesVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeUMLFromStateVariablesVersionEvent.class)
  public void handle(UnAssignEntsoeUMLFromStateVariablesVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeUMLFromStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    StateVariablesVersion entity = unAssignEntsoeUML(event.getStateVariablesVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event AssignEntsoeURIToStateVariablesVersionEvent
   */
  @EventHandler(payloadType = AssignEntsoeURIToStateVariablesVersionEvent.class)
  public void handle(AssignEntsoeURIToStateVariablesVersionEvent event) {
    LOGGER.info("handling AssignEntsoeURIToStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    StateVariablesVersion entity =
        assignEntsoeURI(event.getStateVariablesVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event UnAssignEntsoeURIFromStateVariablesVersionEvent
   */
  @EventHandler(payloadType = UnAssignEntsoeURIFromStateVariablesVersionEvent.class)
  public void handle(UnAssignEntsoeURIFromStateVariablesVersionEvent event) {
    LOGGER.info("handling UnAssignEntsoeURIFromStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    StateVariablesVersion entity = unAssignEntsoeURI(event.getStateVariablesVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event AssignModelDescriptionURIToStateVariablesVersionEvent
   */
  @EventHandler(payloadType = AssignModelDescriptionURIToStateVariablesVersionEvent.class)
  public void handle(AssignModelDescriptionURIToStateVariablesVersionEvent event) {
    LOGGER.info("handling AssignModelDescriptionURIToStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    StateVariablesVersion entity =
        assignModelDescriptionURI(event.getStateVariablesVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event UnAssignModelDescriptionURIFromStateVariablesVersionEvent
   */
  @EventHandler(payloadType = UnAssignModelDescriptionURIFromStateVariablesVersionEvent.class)
  public void handle(UnAssignModelDescriptionURIFromStateVariablesVersionEvent event) {
    LOGGER.info("handling UnAssignModelDescriptionURIFromStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    StateVariablesVersion entity = unAssignModelDescriptionURI(event.getStateVariablesVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event AssignNamespaceRDFToStateVariablesVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceRDFToStateVariablesVersionEvent.class)
  public void handle(AssignNamespaceRDFToStateVariablesVersionEvent event) {
    LOGGER.info("handling AssignNamespaceRDFToStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    StateVariablesVersion entity =
        assignNamespaceRDF(event.getStateVariablesVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceRDFFromStateVariablesVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceRDFFromStateVariablesVersionEvent.class)
  public void handle(UnAssignNamespaceRDFFromStateVariablesVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceRDFFromStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    StateVariablesVersion entity = unAssignNamespaceRDF(event.getStateVariablesVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event AssignNamespaceUMLToStateVariablesVersionEvent
   */
  @EventHandler(payloadType = AssignNamespaceUMLToStateVariablesVersionEvent.class)
  public void handle(AssignNamespaceUMLToStateVariablesVersionEvent event) {
    LOGGER.info("handling AssignNamespaceUMLToStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    StateVariablesVersion entity =
        assignNamespaceUML(event.getStateVariablesVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event UnAssignNamespaceUMLFromStateVariablesVersionEvent
   */
  @EventHandler(payloadType = UnAssignNamespaceUMLFromStateVariablesVersionEvent.class)
  public void handle(UnAssignNamespaceUMLFromStateVariablesVersionEvent event) {
    LOGGER.info("handling UnAssignNamespaceUMLFromStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    StateVariablesVersion entity = unAssignNamespaceUML(event.getStateVariablesVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event AssignShortNameToStateVariablesVersionEvent
   */
  @EventHandler(payloadType = AssignShortNameToStateVariablesVersionEvent.class)
  public void handle(AssignShortNameToStateVariablesVersionEvent event) {
    LOGGER.info("handling AssignShortNameToStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    StateVariablesVersion entity =
        assignShortName(event.getStateVariablesVersionId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /*
   * @param	event UnAssignShortNameFromStateVariablesVersionEvent
   */
  @EventHandler(payloadType = UnAssignShortNameFromStateVariablesVersionEvent.class)
  public void handle(UnAssignShortNameFromStateVariablesVersionEvent event) {
    LOGGER.info("handling UnAssignShortNameFromStateVariablesVersionEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    StateVariablesVersion entity = unAssignShortName(event.getStateVariablesVersionId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindStateVariablesVersion(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllStateVariablesVersion(entity);
  }

  /**
   * Method to retrieve the StateVariablesVersion via an StateVariablesVersionPrimaryKey.
   *
   * @param id Long
   * @return StateVariablesVersion
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public StateVariablesVersion handle(FindStateVariablesVersionQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getStateVariablesVersionId());
  }

  /**
   * Method to retrieve a collection of all StateVariablesVersions
   *
   * @param query FindAllStateVariablesVersionQuery
   * @return List<StateVariablesVersion>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<StateVariablesVersion> handle(FindAllStateVariablesVersionQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindStateVariablesVersion, but only if the id matches
   *
   * @param entity StateVariablesVersion
   */
  protected void emitFindStateVariablesVersion(StateVariablesVersion entity) {
    LOGGER.info("handling emitFindStateVariablesVersion");

    queryUpdateEmitter.emit(
        FindStateVariablesVersionQuery.class,
        query ->
            query
                .getFilter()
                .getStateVariablesVersionId()
                .equals(entity.getStateVariablesVersionId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllStateVariablesVersion
   *
   * @param entity StateVariablesVersion
   */
  protected void emitFindAllStateVariablesVersion(StateVariablesVersion entity) {
    LOGGER.info("handling emitFindAllStateVariablesVersion");

    queryUpdateEmitter.emit(FindAllStateVariablesVersionQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(StateVariablesVersionProjector.class.getName());
}
