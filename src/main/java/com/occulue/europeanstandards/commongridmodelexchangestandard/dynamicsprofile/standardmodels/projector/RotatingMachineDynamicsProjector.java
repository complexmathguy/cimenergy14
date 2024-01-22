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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for RotatingMachineDynamics as outlined for the CQRS pattern. All event handling and
 * query handling related to RotatingMachineDynamics are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by RotatingMachineDynamicsAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("rotatingMachineDynamics")
@Component("rotatingMachineDynamics-projector")
public class RotatingMachineDynamicsProjector extends RotatingMachineDynamicsEntityProjector {

  // core constructor
  public RotatingMachineDynamicsProjector(
      RotatingMachineDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateRotatingMachineDynamicsEvent
   */
  @EventHandler(payloadType = CreateRotatingMachineDynamicsEvent.class)
  public void handle(CreateRotatingMachineDynamicsEvent event) {
    LOGGER.info("handling CreateRotatingMachineDynamicsEvent - " + event);
    RotatingMachineDynamics entity = new RotatingMachineDynamics();
    entity.setRotatingMachineDynamicsId(event.getRotatingMachineDynamicsId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachineDynamics(entity);
  }

  /*
   * @param	event UpdateRotatingMachineDynamicsEvent
   */
  @EventHandler(payloadType = UpdateRotatingMachineDynamicsEvent.class)
  public void handle(UpdateRotatingMachineDynamicsEvent event) {
    LOGGER.info("handling UpdateRotatingMachineDynamicsEvent - " + event);

    RotatingMachineDynamics entity = new RotatingMachineDynamics();
    entity.setRotatingMachineDynamicsId(event.getRotatingMachineDynamicsId());
    entity.setDamping(event.getDamping());
    entity.setInertia(event.getInertia());
    entity.setSaturationFactor(event.getSaturationFactor());
    entity.setSaturationFactor120(event.getSaturationFactor120());
    entity.setStatorLeakageReactance(event.getStatorLeakageReactance());
    entity.setStatorResistance(event.getStatorResistance());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachineDynamics(entity);
  }

  /*
   * @param	event DeleteRotatingMachineDynamicsEvent
   */
  @EventHandler(payloadType = DeleteRotatingMachineDynamicsEvent.class)
  public void handle(DeleteRotatingMachineDynamicsEvent event) {
    LOGGER.info("handling DeleteRotatingMachineDynamicsEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    RotatingMachineDynamics entity = delete(event.getRotatingMachineDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachineDynamics(entity);
  }

  /*
   * @param	event AssignDampingToRotatingMachineDynamicsEvent
   */
  @EventHandler(payloadType = AssignDampingToRotatingMachineDynamicsEvent.class)
  public void handle(AssignDampingToRotatingMachineDynamicsEvent event) {
    LOGGER.info("handling AssignDampingToRotatingMachineDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    RotatingMachineDynamics entity =
        assignDamping(event.getRotatingMachineDynamicsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachineDynamics(entity);
  }

  /*
   * @param	event UnAssignDampingFromRotatingMachineDynamicsEvent
   */
  @EventHandler(payloadType = UnAssignDampingFromRotatingMachineDynamicsEvent.class)
  public void handle(UnAssignDampingFromRotatingMachineDynamicsEvent event) {
    LOGGER.info("handling UnAssignDampingFromRotatingMachineDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    RotatingMachineDynamics entity = unAssignDamping(event.getRotatingMachineDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachineDynamics(entity);
  }

  /*
   * @param	event AssignInertiaToRotatingMachineDynamicsEvent
   */
  @EventHandler(payloadType = AssignInertiaToRotatingMachineDynamicsEvent.class)
  public void handle(AssignInertiaToRotatingMachineDynamicsEvent event) {
    LOGGER.info("handling AssignInertiaToRotatingMachineDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    RotatingMachineDynamics entity =
        assignInertia(event.getRotatingMachineDynamicsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachineDynamics(entity);
  }

  /*
   * @param	event UnAssignInertiaFromRotatingMachineDynamicsEvent
   */
  @EventHandler(payloadType = UnAssignInertiaFromRotatingMachineDynamicsEvent.class)
  public void handle(UnAssignInertiaFromRotatingMachineDynamicsEvent event) {
    LOGGER.info("handling UnAssignInertiaFromRotatingMachineDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    RotatingMachineDynamics entity = unAssignInertia(event.getRotatingMachineDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachineDynamics(entity);
  }

  /*
   * @param	event AssignSaturationFactorToRotatingMachineDynamicsEvent
   */
  @EventHandler(payloadType = AssignSaturationFactorToRotatingMachineDynamicsEvent.class)
  public void handle(AssignSaturationFactorToRotatingMachineDynamicsEvent event) {
    LOGGER.info("handling AssignSaturationFactorToRotatingMachineDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    RotatingMachineDynamics entity =
        assignSaturationFactor(event.getRotatingMachineDynamicsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachineDynamics(entity);
  }

  /*
   * @param	event UnAssignSaturationFactorFromRotatingMachineDynamicsEvent
   */
  @EventHandler(payloadType = UnAssignSaturationFactorFromRotatingMachineDynamicsEvent.class)
  public void handle(UnAssignSaturationFactorFromRotatingMachineDynamicsEvent event) {
    LOGGER.info("handling UnAssignSaturationFactorFromRotatingMachineDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    RotatingMachineDynamics entity = unAssignSaturationFactor(event.getRotatingMachineDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachineDynamics(entity);
  }

  /*
   * @param	event AssignSaturationFactor120ToRotatingMachineDynamicsEvent
   */
  @EventHandler(payloadType = AssignSaturationFactor120ToRotatingMachineDynamicsEvent.class)
  public void handle(AssignSaturationFactor120ToRotatingMachineDynamicsEvent event) {
    LOGGER.info("handling AssignSaturationFactor120ToRotatingMachineDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    RotatingMachineDynamics entity =
        assignSaturationFactor120(event.getRotatingMachineDynamicsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachineDynamics(entity);
  }

  /*
   * @param	event UnAssignSaturationFactor120FromRotatingMachineDynamicsEvent
   */
  @EventHandler(payloadType = UnAssignSaturationFactor120FromRotatingMachineDynamicsEvent.class)
  public void handle(UnAssignSaturationFactor120FromRotatingMachineDynamicsEvent event) {
    LOGGER.info("handling UnAssignSaturationFactor120FromRotatingMachineDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    RotatingMachineDynamics entity =
        unAssignSaturationFactor120(event.getRotatingMachineDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachineDynamics(entity);
  }

  /*
   * @param	event AssignStatorLeakageReactanceToRotatingMachineDynamicsEvent
   */
  @EventHandler(payloadType = AssignStatorLeakageReactanceToRotatingMachineDynamicsEvent.class)
  public void handle(AssignStatorLeakageReactanceToRotatingMachineDynamicsEvent event) {
    LOGGER.info("handling AssignStatorLeakageReactanceToRotatingMachineDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    RotatingMachineDynamics entity =
        assignStatorLeakageReactance(event.getRotatingMachineDynamicsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachineDynamics(entity);
  }

  /*
   * @param	event UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsEvent
   */
  @EventHandler(payloadType = UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsEvent.class)
  public void handle(UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsEvent event) {
    LOGGER.info(
        "handling UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    RotatingMachineDynamics entity =
        unAssignStatorLeakageReactance(event.getRotatingMachineDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachineDynamics(entity);
  }

  /*
   * @param	event AssignStatorResistanceToRotatingMachineDynamicsEvent
   */
  @EventHandler(payloadType = AssignStatorResistanceToRotatingMachineDynamicsEvent.class)
  public void handle(AssignStatorResistanceToRotatingMachineDynamicsEvent event) {
    LOGGER.info("handling AssignStatorResistanceToRotatingMachineDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    RotatingMachineDynamics entity =
        assignStatorResistance(event.getRotatingMachineDynamicsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachineDynamics(entity);
  }

  /*
   * @param	event UnAssignStatorResistanceFromRotatingMachineDynamicsEvent
   */
  @EventHandler(payloadType = UnAssignStatorResistanceFromRotatingMachineDynamicsEvent.class)
  public void handle(UnAssignStatorResistanceFromRotatingMachineDynamicsEvent event) {
    LOGGER.info("handling UnAssignStatorResistanceFromRotatingMachineDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    RotatingMachineDynamics entity = unAssignStatorResistance(event.getRotatingMachineDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRotatingMachineDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRotatingMachineDynamics(entity);
  }

  /**
   * Method to retrieve the RotatingMachineDynamics via an RotatingMachineDynamicsPrimaryKey.
   *
   * @param id Long
   * @return RotatingMachineDynamics
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public RotatingMachineDynamics handle(FindRotatingMachineDynamicsQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getRotatingMachineDynamicsId());
  }

  /**
   * Method to retrieve a collection of all RotatingMachineDynamicss
   *
   * @param query FindAllRotatingMachineDynamicsQuery
   * @return List<RotatingMachineDynamics>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<RotatingMachineDynamics> handle(FindAllRotatingMachineDynamicsQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindRotatingMachineDynamics, but only if the id matches
   *
   * @param entity RotatingMachineDynamics
   */
  protected void emitFindRotatingMachineDynamics(RotatingMachineDynamics entity) {
    LOGGER.info("handling emitFindRotatingMachineDynamics");

    queryUpdateEmitter.emit(
        FindRotatingMachineDynamicsQuery.class,
        query ->
            query
                .getFilter()
                .getRotatingMachineDynamicsId()
                .equals(entity.getRotatingMachineDynamicsId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllRotatingMachineDynamics
   *
   * @param entity RotatingMachineDynamics
   */
  protected void emitFindAllRotatingMachineDynamics(RotatingMachineDynamics entity) {
    LOGGER.info("handling emitFindAllRotatingMachineDynamics");

    queryUpdateEmitter.emit(FindAllRotatingMachineDynamicsQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(RotatingMachineDynamicsProjector.class.getName());
}
