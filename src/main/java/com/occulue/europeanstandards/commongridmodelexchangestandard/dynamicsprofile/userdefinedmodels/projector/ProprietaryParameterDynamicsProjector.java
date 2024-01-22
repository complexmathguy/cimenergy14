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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ProprietaryParameterDynamics as outlined for the CQRS pattern. All event handling
 * and query handling related to ProprietaryParameterDynamics are invoked here and dispersed as an
 * event to be handled elsewhere.
 *
 * <p>Commands are handled by ProprietaryParameterDynamicsAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("proprietaryParameterDynamics")
@Component("proprietaryParameterDynamics-projector")
public class ProprietaryParameterDynamicsProjector
    extends ProprietaryParameterDynamicsEntityProjector {

  // core constructor
  public ProprietaryParameterDynamicsProjector(
      ProprietaryParameterDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateProprietaryParameterDynamicsEvent
   */
  @EventHandler(payloadType = CreateProprietaryParameterDynamicsEvent.class)
  public void handle(CreateProprietaryParameterDynamicsEvent event) {
    LOGGER.info("handling CreateProprietaryParameterDynamicsEvent - " + event);
    ProprietaryParameterDynamics entity = new ProprietaryParameterDynamics();
    entity.setProprietaryParameterDynamicsId(event.getProprietaryParameterDynamicsId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllProprietaryParameterDynamics(entity);
  }

  /*
   * @param	event UpdateProprietaryParameterDynamicsEvent
   */
  @EventHandler(payloadType = UpdateProprietaryParameterDynamicsEvent.class)
  public void handle(UpdateProprietaryParameterDynamicsEvent event) {
    LOGGER.info("handling UpdateProprietaryParameterDynamicsEvent - " + event);

    ProprietaryParameterDynamics entity = new ProprietaryParameterDynamics();
    entity.setProprietaryParameterDynamicsId(event.getProprietaryParameterDynamicsId());
    entity.setBooleanParameterValue(event.getBooleanParameterValue());
    entity.setFloatParameterValue(event.getFloatParameterValue());
    entity.setIntegerParameterValue(event.getIntegerParameterValue());
    entity.setParameterNumber(event.getParameterNumber());
    entity.setProprietaryParameterDynamics(event.getProprietaryParameterDynamics());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindProprietaryParameterDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllProprietaryParameterDynamics(entity);
  }

  /*
   * @param	event DeleteProprietaryParameterDynamicsEvent
   */
  @EventHandler(payloadType = DeleteProprietaryParameterDynamicsEvent.class)
  public void handle(DeleteProprietaryParameterDynamicsEvent event) {
    LOGGER.info("handling DeleteProprietaryParameterDynamicsEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ProprietaryParameterDynamics entity = delete(event.getProprietaryParameterDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllProprietaryParameterDynamics(entity);
  }

  /*
   * @param	event AssignBooleanParameterValueToProprietaryParameterDynamicsEvent
   */
  @EventHandler(payloadType = AssignBooleanParameterValueToProprietaryParameterDynamicsEvent.class)
  public void handle(AssignBooleanParameterValueToProprietaryParameterDynamicsEvent event) {
    LOGGER.info(
        "handling AssignBooleanParameterValueToProprietaryParameterDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ProprietaryParameterDynamics entity =
        assignBooleanParameterValue(
            event.getProprietaryParameterDynamicsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindProprietaryParameterDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllProprietaryParameterDynamics(entity);
  }

  /*
   * @param	event UnAssignBooleanParameterValueFromProprietaryParameterDynamicsEvent
   */
  @EventHandler(
      payloadType = UnAssignBooleanParameterValueFromProprietaryParameterDynamicsEvent.class)
  public void handle(UnAssignBooleanParameterValueFromProprietaryParameterDynamicsEvent event) {
    LOGGER.info(
        "handling UnAssignBooleanParameterValueFromProprietaryParameterDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ProprietaryParameterDynamics entity =
        unAssignBooleanParameterValue(event.getProprietaryParameterDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindProprietaryParameterDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllProprietaryParameterDynamics(entity);
  }

  /*
   * @param	event AssignFloatParameterValueToProprietaryParameterDynamicsEvent
   */
  @EventHandler(payloadType = AssignFloatParameterValueToProprietaryParameterDynamicsEvent.class)
  public void handle(AssignFloatParameterValueToProprietaryParameterDynamicsEvent event) {
    LOGGER.info("handling AssignFloatParameterValueToProprietaryParameterDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ProprietaryParameterDynamics entity =
        assignFloatParameterValue(event.getProprietaryParameterDynamicsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindProprietaryParameterDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllProprietaryParameterDynamics(entity);
  }

  /*
   * @param	event UnAssignFloatParameterValueFromProprietaryParameterDynamicsEvent
   */
  @EventHandler(
      payloadType = UnAssignFloatParameterValueFromProprietaryParameterDynamicsEvent.class)
  public void handle(UnAssignFloatParameterValueFromProprietaryParameterDynamicsEvent event) {
    LOGGER.info(
        "handling UnAssignFloatParameterValueFromProprietaryParameterDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ProprietaryParameterDynamics entity =
        unAssignFloatParameterValue(event.getProprietaryParameterDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindProprietaryParameterDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllProprietaryParameterDynamics(entity);
  }

  /*
   * @param	event AssignIntegerParameterValueToProprietaryParameterDynamicsEvent
   */
  @EventHandler(payloadType = AssignIntegerParameterValueToProprietaryParameterDynamicsEvent.class)
  public void handle(AssignIntegerParameterValueToProprietaryParameterDynamicsEvent event) {
    LOGGER.info(
        "handling AssignIntegerParameterValueToProprietaryParameterDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ProprietaryParameterDynamics entity =
        assignIntegerParameterValue(
            event.getProprietaryParameterDynamicsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindProprietaryParameterDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllProprietaryParameterDynamics(entity);
  }

  /*
   * @param	event UnAssignIntegerParameterValueFromProprietaryParameterDynamicsEvent
   */
  @EventHandler(
      payloadType = UnAssignIntegerParameterValueFromProprietaryParameterDynamicsEvent.class)
  public void handle(UnAssignIntegerParameterValueFromProprietaryParameterDynamicsEvent event) {
    LOGGER.info(
        "handling UnAssignIntegerParameterValueFromProprietaryParameterDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ProprietaryParameterDynamics entity =
        unAssignIntegerParameterValue(event.getProprietaryParameterDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindProprietaryParameterDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllProprietaryParameterDynamics(entity);
  }

  /*
   * @param	event AssignParameterNumberToProprietaryParameterDynamicsEvent
   */
  @EventHandler(payloadType = AssignParameterNumberToProprietaryParameterDynamicsEvent.class)
  public void handle(AssignParameterNumberToProprietaryParameterDynamicsEvent event) {
    LOGGER.info("handling AssignParameterNumberToProprietaryParameterDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ProprietaryParameterDynamics entity =
        assignParameterNumber(event.getProprietaryParameterDynamicsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindProprietaryParameterDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllProprietaryParameterDynamics(entity);
  }

  /*
   * @param	event UnAssignParameterNumberFromProprietaryParameterDynamicsEvent
   */
  @EventHandler(payloadType = UnAssignParameterNumberFromProprietaryParameterDynamicsEvent.class)
  public void handle(UnAssignParameterNumberFromProprietaryParameterDynamicsEvent event) {
    LOGGER.info("handling UnAssignParameterNumberFromProprietaryParameterDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ProprietaryParameterDynamics entity =
        unAssignParameterNumber(event.getProprietaryParameterDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindProprietaryParameterDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllProprietaryParameterDynamics(entity);
  }

  /*
   * @param	event AssignProprietaryParameterDynamicsToProprietaryParameterDynamicsEvent
   */
  @EventHandler(
      payloadType = AssignProprietaryParameterDynamicsToProprietaryParameterDynamicsEvent.class)
  public void handle(AssignProprietaryParameterDynamicsToProprietaryParameterDynamicsEvent event) {
    LOGGER.info(
        "handling AssignProprietaryParameterDynamicsToProprietaryParameterDynamicsEvent - "
            + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    ProprietaryParameterDynamics entity =
        addToProprietaryParameterDynamics(
            event.getProprietaryParameterDynamicsId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindProprietaryParameterDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllProprietaryParameterDynamics(entity);
  }

  /*
   * @param	event RemoveProprietaryParameterDynamicsFromProprietaryParameterDynamicsEvent
   */
  @EventHandler(
      payloadType = RemoveProprietaryParameterDynamicsFromProprietaryParameterDynamicsEvent.class)
  public void handle(
      RemoveProprietaryParameterDynamicsFromProprietaryParameterDynamicsEvent event) {
    LOGGER.info(
        "handling RemoveProprietaryParameterDynamicsFromProprietaryParameterDynamicsEvent - "
            + event);

    ProprietaryParameterDynamics entity =
        removeFromProprietaryParameterDynamics(
            event.getProprietaryParameterDynamicsId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindProprietaryParameterDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllProprietaryParameterDynamics(entity);
  }

  /**
   * Method to retrieve the ProprietaryParameterDynamics via an
   * ProprietaryParameterDynamicsPrimaryKey.
   *
   * @param id Long
   * @return ProprietaryParameterDynamics
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ProprietaryParameterDynamics handle(FindProprietaryParameterDynamicsQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getProprietaryParameterDynamicsId());
  }

  /**
   * Method to retrieve a collection of all ProprietaryParameterDynamicss
   *
   * @param query FindAllProprietaryParameterDynamicsQuery
   * @return List<ProprietaryParameterDynamics>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ProprietaryParameterDynamics> handle(FindAllProprietaryParameterDynamicsQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindProprietaryParameterDynamics, but only if the id
   * matches
   *
   * @param entity ProprietaryParameterDynamics
   */
  protected void emitFindProprietaryParameterDynamics(ProprietaryParameterDynamics entity) {
    LOGGER.info("handling emitFindProprietaryParameterDynamics");

    queryUpdateEmitter.emit(
        FindProprietaryParameterDynamicsQuery.class,
        query ->
            query
                .getFilter()
                .getProprietaryParameterDynamicsId()
                .equals(entity.getProprietaryParameterDynamicsId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllProprietaryParameterDynamics
   *
   * @param entity ProprietaryParameterDynamics
   */
  protected void emitFindAllProprietaryParameterDynamics(ProprietaryParameterDynamics entity) {
    LOGGER.info("handling emitFindAllProprietaryParameterDynamics");

    queryUpdateEmitter.emit(FindAllProprietaryParameterDynamicsQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(ProprietaryParameterDynamicsProjector.class.getName());
}
