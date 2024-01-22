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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for LoadResponseCharacteristic as outlined for the CQRS pattern. All event handling and
 * query handling related to LoadResponseCharacteristic are invoked here and dispersed as an event
 * to be handled elsewhere.
 *
 * <p>Commands are handled by LoadResponseCharacteristicAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("loadResponseCharacteristic")
@Component("loadResponseCharacteristic-projector")
public class LoadResponseCharacteristicProjector extends LoadResponseCharacteristicEntityProjector {

  // core constructor
  public LoadResponseCharacteristicProjector(
      LoadResponseCharacteristicRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = CreateLoadResponseCharacteristicEvent.class)
  public void handle(CreateLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling CreateLoadResponseCharacteristicEvent - " + event);
    LoadResponseCharacteristic entity = new LoadResponseCharacteristic();
    entity.setLoadResponseCharacteristicId(event.getLoadResponseCharacteristicId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event UpdateLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = UpdateLoadResponseCharacteristicEvent.class)
  public void handle(UpdateLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling UpdateLoadResponseCharacteristicEvent - " + event);

    LoadResponseCharacteristic entity = new LoadResponseCharacteristic();
    entity.setLoadResponseCharacteristicId(event.getLoadResponseCharacteristicId());
    entity.setExponentModel(event.getExponentModel());
    entity.setPConstantCurrent(event.getPConstantCurrent());
    entity.setPConstantImpedance(event.getPConstantImpedance());
    entity.setPConstantPower(event.getPConstantPower());
    entity.setPFrequencyExponent(event.getPFrequencyExponent());
    entity.setPVoltageExponent(event.getPVoltageExponent());
    entity.setQConstantCurrent(event.getQConstantCurrent());
    entity.setQConstantImpedance(event.getQConstantImpedance());
    entity.setQConstantPower(event.getQConstantPower());
    entity.setQFrequencyExponent(event.getQFrequencyExponent());
    entity.setQVoltageExponent(event.getQVoltageExponent());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event DeleteLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = DeleteLoadResponseCharacteristicEvent.class)
  public void handle(DeleteLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling DeleteLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    LoadResponseCharacteristic entity = delete(event.getLoadResponseCharacteristicId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event AssignExponentModelToLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = AssignExponentModelToLoadResponseCharacteristicEvent.class)
  public void handle(AssignExponentModelToLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling AssignExponentModelToLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        assignExponentModel(event.getLoadResponseCharacteristicId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event UnAssignExponentModelFromLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = UnAssignExponentModelFromLoadResponseCharacteristicEvent.class)
  public void handle(UnAssignExponentModelFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling UnAssignExponentModelFromLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        unAssignExponentModel(event.getLoadResponseCharacteristicId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event AssignPConstantCurrentToLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = AssignPConstantCurrentToLoadResponseCharacteristicEvent.class)
  public void handle(AssignPConstantCurrentToLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling AssignPConstantCurrentToLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        assignPConstantCurrent(event.getLoadResponseCharacteristicId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event UnAssignPConstantCurrentFromLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = UnAssignPConstantCurrentFromLoadResponseCharacteristicEvent.class)
  public void handle(UnAssignPConstantCurrentFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling UnAssignPConstantCurrentFromLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        unAssignPConstantCurrent(event.getLoadResponseCharacteristicId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event AssignPConstantImpedanceToLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = AssignPConstantImpedanceToLoadResponseCharacteristicEvent.class)
  public void handle(AssignPConstantImpedanceToLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling AssignPConstantImpedanceToLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        assignPConstantImpedance(event.getLoadResponseCharacteristicId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event UnAssignPConstantImpedanceFromLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = UnAssignPConstantImpedanceFromLoadResponseCharacteristicEvent.class)
  public void handle(UnAssignPConstantImpedanceFromLoadResponseCharacteristicEvent event) {
    LOGGER.info(
        "handling UnAssignPConstantImpedanceFromLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        unAssignPConstantImpedance(event.getLoadResponseCharacteristicId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event AssignPConstantPowerToLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = AssignPConstantPowerToLoadResponseCharacteristicEvent.class)
  public void handle(AssignPConstantPowerToLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling AssignPConstantPowerToLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        assignPConstantPower(event.getLoadResponseCharacteristicId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event UnAssignPConstantPowerFromLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = UnAssignPConstantPowerFromLoadResponseCharacteristicEvent.class)
  public void handle(UnAssignPConstantPowerFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling UnAssignPConstantPowerFromLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        unAssignPConstantPower(event.getLoadResponseCharacteristicId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event AssignPFrequencyExponentToLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = AssignPFrequencyExponentToLoadResponseCharacteristicEvent.class)
  public void handle(AssignPFrequencyExponentToLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling AssignPFrequencyExponentToLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        assignPFrequencyExponent(event.getLoadResponseCharacteristicId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event UnAssignPFrequencyExponentFromLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = UnAssignPFrequencyExponentFromLoadResponseCharacteristicEvent.class)
  public void handle(UnAssignPFrequencyExponentFromLoadResponseCharacteristicEvent event) {
    LOGGER.info(
        "handling UnAssignPFrequencyExponentFromLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        unAssignPFrequencyExponent(event.getLoadResponseCharacteristicId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event AssignPVoltageExponentToLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = AssignPVoltageExponentToLoadResponseCharacteristicEvent.class)
  public void handle(AssignPVoltageExponentToLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling AssignPVoltageExponentToLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        assignPVoltageExponent(event.getLoadResponseCharacteristicId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event UnAssignPVoltageExponentFromLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = UnAssignPVoltageExponentFromLoadResponseCharacteristicEvent.class)
  public void handle(UnAssignPVoltageExponentFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling UnAssignPVoltageExponentFromLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        unAssignPVoltageExponent(event.getLoadResponseCharacteristicId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event AssignQConstantCurrentToLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = AssignQConstantCurrentToLoadResponseCharacteristicEvent.class)
  public void handle(AssignQConstantCurrentToLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling AssignQConstantCurrentToLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        assignQConstantCurrent(event.getLoadResponseCharacteristicId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event UnAssignQConstantCurrentFromLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = UnAssignQConstantCurrentFromLoadResponseCharacteristicEvent.class)
  public void handle(UnAssignQConstantCurrentFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling UnAssignQConstantCurrentFromLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        unAssignQConstantCurrent(event.getLoadResponseCharacteristicId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event AssignQConstantImpedanceToLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = AssignQConstantImpedanceToLoadResponseCharacteristicEvent.class)
  public void handle(AssignQConstantImpedanceToLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling AssignQConstantImpedanceToLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        assignQConstantImpedance(event.getLoadResponseCharacteristicId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event UnAssignQConstantImpedanceFromLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = UnAssignQConstantImpedanceFromLoadResponseCharacteristicEvent.class)
  public void handle(UnAssignQConstantImpedanceFromLoadResponseCharacteristicEvent event) {
    LOGGER.info(
        "handling UnAssignQConstantImpedanceFromLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        unAssignQConstantImpedance(event.getLoadResponseCharacteristicId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event AssignQConstantPowerToLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = AssignQConstantPowerToLoadResponseCharacteristicEvent.class)
  public void handle(AssignQConstantPowerToLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling AssignQConstantPowerToLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        assignQConstantPower(event.getLoadResponseCharacteristicId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event UnAssignQConstantPowerFromLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = UnAssignQConstantPowerFromLoadResponseCharacteristicEvent.class)
  public void handle(UnAssignQConstantPowerFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling UnAssignQConstantPowerFromLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        unAssignQConstantPower(event.getLoadResponseCharacteristicId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event AssignQFrequencyExponentToLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = AssignQFrequencyExponentToLoadResponseCharacteristicEvent.class)
  public void handle(AssignQFrequencyExponentToLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling AssignQFrequencyExponentToLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        assignQFrequencyExponent(event.getLoadResponseCharacteristicId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event UnAssignQFrequencyExponentFromLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = UnAssignQFrequencyExponentFromLoadResponseCharacteristicEvent.class)
  public void handle(UnAssignQFrequencyExponentFromLoadResponseCharacteristicEvent event) {
    LOGGER.info(
        "handling UnAssignQFrequencyExponentFromLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        unAssignQFrequencyExponent(event.getLoadResponseCharacteristicId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event AssignQVoltageExponentToLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = AssignQVoltageExponentToLoadResponseCharacteristicEvent.class)
  public void handle(AssignQVoltageExponentToLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling AssignQVoltageExponentToLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        assignQVoltageExponent(event.getLoadResponseCharacteristicId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /*
   * @param	event UnAssignQVoltageExponentFromLoadResponseCharacteristicEvent
   */
  @EventHandler(payloadType = UnAssignQVoltageExponentFromLoadResponseCharacteristicEvent.class)
  public void handle(UnAssignQVoltageExponentFromLoadResponseCharacteristicEvent event) {
    LOGGER.info("handling UnAssignQVoltageExponentFromLoadResponseCharacteristicEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    LoadResponseCharacteristic entity =
        unAssignQVoltageExponent(event.getLoadResponseCharacteristicId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindLoadResponseCharacteristic(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllLoadResponseCharacteristic(entity);
  }

  /**
   * Method to retrieve the LoadResponseCharacteristic via an LoadResponseCharacteristicPrimaryKey.
   *
   * @param id Long
   * @return LoadResponseCharacteristic
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public LoadResponseCharacteristic handle(FindLoadResponseCharacteristicQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getLoadResponseCharacteristicId());
  }

  /**
   * Method to retrieve a collection of all LoadResponseCharacteristics
   *
   * @param query FindAllLoadResponseCharacteristicQuery
   * @return List<LoadResponseCharacteristic>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<LoadResponseCharacteristic> handle(FindAllLoadResponseCharacteristicQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindLoadResponseCharacteristic, but only if the id matches
   *
   * @param entity LoadResponseCharacteristic
   */
  protected void emitFindLoadResponseCharacteristic(LoadResponseCharacteristic entity) {
    LOGGER.info("handling emitFindLoadResponseCharacteristic");

    queryUpdateEmitter.emit(
        FindLoadResponseCharacteristicQuery.class,
        query ->
            query
                .getFilter()
                .getLoadResponseCharacteristicId()
                .equals(entity.getLoadResponseCharacteristicId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllLoadResponseCharacteristic
   *
   * @param entity LoadResponseCharacteristic
   */
  protected void emitFindAllLoadResponseCharacteristic(LoadResponseCharacteristic entity) {
    LOGGER.info("handling emitFindAllLoadResponseCharacteristic");

    queryUpdateEmitter.emit(FindAllLoadResponseCharacteristicQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(LoadResponseCharacteristicProjector.class.getName());
}
