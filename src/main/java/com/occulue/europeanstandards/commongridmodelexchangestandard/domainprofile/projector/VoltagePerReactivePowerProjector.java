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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for VoltagePerReactivePower as outlined for the CQRS pattern. All event handling and
 * query handling related to VoltagePerReactivePower are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by VoltagePerReactivePowerAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("voltagePerReactivePower")
@Component("voltagePerReactivePower-projector")
public class VoltagePerReactivePowerProjector extends VoltagePerReactivePowerEntityProjector {

  // core constructor
  public VoltagePerReactivePowerProjector(
      VoltagePerReactivePowerRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateVoltagePerReactivePowerEvent
   */
  @EventHandler(payloadType = CreateVoltagePerReactivePowerEvent.class)
  public void handle(CreateVoltagePerReactivePowerEvent event) {
    LOGGER.info("handling CreateVoltagePerReactivePowerEvent - " + event);
    VoltagePerReactivePower entity = new VoltagePerReactivePower();
    entity.setVoltagePerReactivePowerId(event.getVoltagePerReactivePowerId());
    entity.setDenominatorMultiplier(event.getDenominatorMultiplier());
    entity.setDenominatorUnit(event.getDenominatorUnit());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVoltagePerReactivePower(entity);
  }

  /*
   * @param	event UpdateVoltagePerReactivePowerEvent
   */
  @EventHandler(payloadType = UpdateVoltagePerReactivePowerEvent.class)
  public void handle(UpdateVoltagePerReactivePowerEvent event) {
    LOGGER.info("handling UpdateVoltagePerReactivePowerEvent - " + event);

    VoltagePerReactivePower entity = new VoltagePerReactivePower();
    entity.setVoltagePerReactivePowerId(event.getVoltagePerReactivePowerId());
    entity.setDenominatorMultiplier(event.getDenominatorMultiplier());
    entity.setDenominatorUnit(event.getDenominatorUnit());
    entity.setMultiplier(event.getMultiplier());
    entity.setUnit(event.getUnit());
    entity.setValue(event.getValue());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVoltagePerReactivePower(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVoltagePerReactivePower(entity);
  }

  /*
   * @param	event DeleteVoltagePerReactivePowerEvent
   */
  @EventHandler(payloadType = DeleteVoltagePerReactivePowerEvent.class)
  public void handle(DeleteVoltagePerReactivePowerEvent event) {
    LOGGER.info("handling DeleteVoltagePerReactivePowerEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    VoltagePerReactivePower entity = delete(event.getVoltagePerReactivePowerId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVoltagePerReactivePower(entity);
  }

  /*
   * @param	event AssignValueToVoltagePerReactivePowerEvent
   */
  @EventHandler(payloadType = AssignValueToVoltagePerReactivePowerEvent.class)
  public void handle(AssignValueToVoltagePerReactivePowerEvent event) {
    LOGGER.info("handling AssignValueToVoltagePerReactivePowerEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    VoltagePerReactivePower entity =
        assignValue(event.getVoltagePerReactivePowerId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVoltagePerReactivePower(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVoltagePerReactivePower(entity);
  }

  /*
   * @param	event UnAssignValueFromVoltagePerReactivePowerEvent
   */
  @EventHandler(payloadType = UnAssignValueFromVoltagePerReactivePowerEvent.class)
  public void handle(UnAssignValueFromVoltagePerReactivePowerEvent event) {
    LOGGER.info("handling UnAssignValueFromVoltagePerReactivePowerEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    VoltagePerReactivePower entity = unAssignValue(event.getVoltagePerReactivePowerId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindVoltagePerReactivePower(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllVoltagePerReactivePower(entity);
  }

  /**
   * Method to retrieve the VoltagePerReactivePower via an VoltagePerReactivePowerPrimaryKey.
   *
   * @param id Long
   * @return VoltagePerReactivePower
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public VoltagePerReactivePower handle(FindVoltagePerReactivePowerQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getVoltagePerReactivePowerId());
  }

  /**
   * Method to retrieve a collection of all VoltagePerReactivePowers
   *
   * @param query FindAllVoltagePerReactivePowerQuery
   * @return List<VoltagePerReactivePower>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<VoltagePerReactivePower> handle(FindAllVoltagePerReactivePowerQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindVoltagePerReactivePower, but only if the id matches
   *
   * @param entity VoltagePerReactivePower
   */
  protected void emitFindVoltagePerReactivePower(VoltagePerReactivePower entity) {
    LOGGER.info("handling emitFindVoltagePerReactivePower");

    queryUpdateEmitter.emit(
        FindVoltagePerReactivePowerQuery.class,
        query ->
            query
                .getFilter()
                .getVoltagePerReactivePowerId()
                .equals(entity.getVoltagePerReactivePowerId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllVoltagePerReactivePower
   *
   * @param entity VoltagePerReactivePower
   */
  protected void emitFindAllVoltagePerReactivePower(VoltagePerReactivePower entity) {
    LOGGER.info("handling emitFindAllVoltagePerReactivePower");

    queryUpdateEmitter.emit(FindAllVoltagePerReactivePowerQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(VoltagePerReactivePowerProjector.class.getName());
}
