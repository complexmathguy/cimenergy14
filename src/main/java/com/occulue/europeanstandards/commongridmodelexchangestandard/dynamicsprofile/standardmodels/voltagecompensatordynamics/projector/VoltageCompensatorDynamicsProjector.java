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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for VoltageCompensatorDynamics as outlined for the CQRS pattern. All event handling and
 * query handling related to VoltageCompensatorDynamics are invoked here and dispersed as an event
 * to be handled elsewhere.
 *
 * <p>Commands are handled by VoltageCompensatorDynamicsAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("voltageCompensatorDynamics")
@Component("voltageCompensatorDynamics-projector")
public class VoltageCompensatorDynamicsProjector extends VoltageCompensatorDynamicsEntityProjector {

  // core constructor
  public VoltageCompensatorDynamicsProjector(
      VoltageCompensatorDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateVoltageCompensatorDynamicsEvent
   */
  @EventHandler(payloadType = CreateVoltageCompensatorDynamicsEvent.class)
  public void handle(CreateVoltageCompensatorDynamicsEvent event) {
    LOGGER.info("handling CreateVoltageCompensatorDynamicsEvent - " + event);
    VoltageCompensatorDynamics entity = new VoltageCompensatorDynamics();
    entity.setVoltageCompensatorDynamicsId(event.getVoltageCompensatorDynamicsId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVoltageCompensatorDynamics(entity);
  }

  /*
   * @param	event UpdateVoltageCompensatorDynamicsEvent
   */
  @EventHandler(payloadType = UpdateVoltageCompensatorDynamicsEvent.class)
  public void handle(UpdateVoltageCompensatorDynamicsEvent event) {
    LOGGER.info("handling UpdateVoltageCompensatorDynamicsEvent - " + event);

    VoltageCompensatorDynamics entity = new VoltageCompensatorDynamics();
    entity.setVoltageCompensatorDynamicsId(event.getVoltageCompensatorDynamicsId());
    entity.setVoltageCompensatorDynamics(event.getVoltageCompensatorDynamics());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVoltageCompensatorDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVoltageCompensatorDynamics(entity);
  }

  /*
   * @param	event DeleteVoltageCompensatorDynamicsEvent
   */
  @EventHandler(payloadType = DeleteVoltageCompensatorDynamicsEvent.class)
  public void handle(DeleteVoltageCompensatorDynamicsEvent event) {
    LOGGER.info("handling DeleteVoltageCompensatorDynamicsEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    VoltageCompensatorDynamics entity = delete(event.getVoltageCompensatorDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVoltageCompensatorDynamics(entity);
  }

  /*
   * @param	event AssignVoltageCompensatorDynamicsToVoltageCompensatorDynamicsEvent
   */
  @EventHandler(
      payloadType = AssignVoltageCompensatorDynamicsToVoltageCompensatorDynamicsEvent.class)
  public void handle(AssignVoltageCompensatorDynamicsToVoltageCompensatorDynamicsEvent event) {
    LOGGER.info(
        "handling AssignVoltageCompensatorDynamicsToVoltageCompensatorDynamicsEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    VoltageCompensatorDynamics entity =
        assignVoltageCompensatorDynamics(
            event.getVoltageCompensatorDynamicsId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVoltageCompensatorDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVoltageCompensatorDynamics(entity);
  }

  /*
   * @param	event UnAssignVoltageCompensatorDynamicsFromVoltageCompensatorDynamicsEvent
   */
  @EventHandler(
      payloadType = UnAssignVoltageCompensatorDynamicsFromVoltageCompensatorDynamicsEvent.class)
  public void handle(UnAssignVoltageCompensatorDynamicsFromVoltageCompensatorDynamicsEvent event) {
    LOGGER.info(
        "handling UnAssignVoltageCompensatorDynamicsFromVoltageCompensatorDynamicsEvent - "
            + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    VoltageCompensatorDynamics entity =
        unAssignVoltageCompensatorDynamics(event.getVoltageCompensatorDynamicsId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVoltageCompensatorDynamics(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVoltageCompensatorDynamics(entity);
  }

  /**
   * Method to retrieve the VoltageCompensatorDynamics via an VoltageCompensatorDynamicsPrimaryKey.
   *
   * @param id Long
   * @return VoltageCompensatorDynamics
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public VoltageCompensatorDynamics handle(FindVoltageCompensatorDynamicsQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getVoltageCompensatorDynamicsId());
  }

  /**
   * Method to retrieve a collection of all VoltageCompensatorDynamicss
   *
   * @param query FindAllVoltageCompensatorDynamicsQuery
   * @return List<VoltageCompensatorDynamics>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<VoltageCompensatorDynamics> handle(FindAllVoltageCompensatorDynamicsQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindVoltageCompensatorDynamics, but only if the id matches
   *
   * @param entity VoltageCompensatorDynamics
   */
  protected void emitFindVoltageCompensatorDynamics(VoltageCompensatorDynamics entity) {
    LOGGER.info("handling emitFindVoltageCompensatorDynamics");

    queryUpdateEmitter.emit(
        FindVoltageCompensatorDynamicsQuery.class,
        query ->
            query
                .getFilter()
                .getVoltageCompensatorDynamicsId()
                .equals(entity.getVoltageCompensatorDynamicsId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllVoltageCompensatorDynamics
   *
   * @param entity VoltageCompensatorDynamics
   */
  protected void emitFindAllVoltageCompensatorDynamics(VoltageCompensatorDynamics entity) {
    LOGGER.info("handling emitFindAllVoltageCompensatorDynamics");

    queryUpdateEmitter.emit(FindAllVoltageCompensatorDynamicsQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(VoltageCompensatorDynamicsProjector.class.getName());
}
