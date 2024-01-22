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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for AsynchronousMachine as outlined for the CQRS pattern. All event handling and query
 * handling related to AsynchronousMachine are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by AsynchronousMachineAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("asynchronousMachine")
@Component("asynchronousMachine-projector")
public class AsynchronousMachineProjector extends AsynchronousMachineEntityProjector {

  // core constructor
  public AsynchronousMachineProjector(
      AsynchronousMachineRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateAsynchronousMachineEvent
   */
  @EventHandler(payloadType = CreateAsynchronousMachineEvent.class)
  public void handle(CreateAsynchronousMachineEvent event) {
    LOGGER.info("handling CreateAsynchronousMachineEvent - " + event);
    AsynchronousMachine entity = new AsynchronousMachine();
    entity.setAsynchronousMachineId(event.getAsynchronousMachineId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event UpdateAsynchronousMachineEvent
   */
  @EventHandler(payloadType = UpdateAsynchronousMachineEvent.class)
  public void handle(UpdateAsynchronousMachineEvent event) {
    LOGGER.info("handling UpdateAsynchronousMachineEvent - " + event);

    AsynchronousMachine entity = new AsynchronousMachine();
    entity.setAsynchronousMachineId(event.getAsynchronousMachineId());
    entity.setConverterFedDrive(event.getConverterFedDrive());
    entity.setEfficiency(event.getEfficiency());
    entity.setIaIrRatio(event.getIaIrRatio());
    entity.setNominalFrequency(event.getNominalFrequency());
    entity.setNominalSpeed(event.getNominalSpeed());
    entity.setPolePairNumber(event.getPolePairNumber());
    entity.setRatedMechanicalPower(event.getRatedMechanicalPower());
    entity.setReversible(event.getReversible());
    entity.setRxLockedRotorRatio(event.getRxLockedRotorRatio());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event DeleteAsynchronousMachineEvent
   */
  @EventHandler(payloadType = DeleteAsynchronousMachineEvent.class)
  public void handle(DeleteAsynchronousMachineEvent event) {
    LOGGER.info("handling DeleteAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    AsynchronousMachine entity = delete(event.getAsynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event AssignConverterFedDriveToAsynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignConverterFedDriveToAsynchronousMachineEvent.class)
  public void handle(AssignConverterFedDriveToAsynchronousMachineEvent event) {
    LOGGER.info("handling AssignConverterFedDriveToAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachine entity =
        assignConverterFedDrive(event.getAsynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignConverterFedDriveFromAsynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignConverterFedDriveFromAsynchronousMachineEvent.class)
  public void handle(UnAssignConverterFedDriveFromAsynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignConverterFedDriveFromAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachine entity = unAssignConverterFedDrive(event.getAsynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event AssignEfficiencyToAsynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignEfficiencyToAsynchronousMachineEvent.class)
  public void handle(AssignEfficiencyToAsynchronousMachineEvent event) {
    LOGGER.info("handling AssignEfficiencyToAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachine entity =
        assignEfficiency(event.getAsynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignEfficiencyFromAsynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignEfficiencyFromAsynchronousMachineEvent.class)
  public void handle(UnAssignEfficiencyFromAsynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignEfficiencyFromAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachine entity = unAssignEfficiency(event.getAsynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event AssignIaIrRatioToAsynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignIaIrRatioToAsynchronousMachineEvent.class)
  public void handle(AssignIaIrRatioToAsynchronousMachineEvent event) {
    LOGGER.info("handling AssignIaIrRatioToAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachine entity =
        assignIaIrRatio(event.getAsynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignIaIrRatioFromAsynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignIaIrRatioFromAsynchronousMachineEvent.class)
  public void handle(UnAssignIaIrRatioFromAsynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignIaIrRatioFromAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachine entity = unAssignIaIrRatio(event.getAsynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event AssignNominalFrequencyToAsynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignNominalFrequencyToAsynchronousMachineEvent.class)
  public void handle(AssignNominalFrequencyToAsynchronousMachineEvent event) {
    LOGGER.info("handling AssignNominalFrequencyToAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachine entity =
        assignNominalFrequency(event.getAsynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignNominalFrequencyFromAsynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignNominalFrequencyFromAsynchronousMachineEvent.class)
  public void handle(UnAssignNominalFrequencyFromAsynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignNominalFrequencyFromAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachine entity = unAssignNominalFrequency(event.getAsynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event AssignNominalSpeedToAsynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignNominalSpeedToAsynchronousMachineEvent.class)
  public void handle(AssignNominalSpeedToAsynchronousMachineEvent event) {
    LOGGER.info("handling AssignNominalSpeedToAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachine entity =
        assignNominalSpeed(event.getAsynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignNominalSpeedFromAsynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignNominalSpeedFromAsynchronousMachineEvent.class)
  public void handle(UnAssignNominalSpeedFromAsynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignNominalSpeedFromAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachine entity = unAssignNominalSpeed(event.getAsynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event AssignPolePairNumberToAsynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignPolePairNumberToAsynchronousMachineEvent.class)
  public void handle(AssignPolePairNumberToAsynchronousMachineEvent event) {
    LOGGER.info("handling AssignPolePairNumberToAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachine entity =
        assignPolePairNumber(event.getAsynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignPolePairNumberFromAsynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignPolePairNumberFromAsynchronousMachineEvent.class)
  public void handle(UnAssignPolePairNumberFromAsynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignPolePairNumberFromAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachine entity = unAssignPolePairNumber(event.getAsynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event AssignRatedMechanicalPowerToAsynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignRatedMechanicalPowerToAsynchronousMachineEvent.class)
  public void handle(AssignRatedMechanicalPowerToAsynchronousMachineEvent event) {
    LOGGER.info("handling AssignRatedMechanicalPowerToAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachine entity =
        assignRatedMechanicalPower(event.getAsynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignRatedMechanicalPowerFromAsynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignRatedMechanicalPowerFromAsynchronousMachineEvent.class)
  public void handle(UnAssignRatedMechanicalPowerFromAsynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignRatedMechanicalPowerFromAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachine entity = unAssignRatedMechanicalPower(event.getAsynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event AssignReversibleToAsynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignReversibleToAsynchronousMachineEvent.class)
  public void handle(AssignReversibleToAsynchronousMachineEvent event) {
    LOGGER.info("handling AssignReversibleToAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachine entity =
        assignReversible(event.getAsynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignReversibleFromAsynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignReversibleFromAsynchronousMachineEvent.class)
  public void handle(UnAssignReversibleFromAsynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignReversibleFromAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachine entity = unAssignReversible(event.getAsynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event AssignRxLockedRotorRatioToAsynchronousMachineEvent
   */
  @EventHandler(payloadType = AssignRxLockedRotorRatioToAsynchronousMachineEvent.class)
  public void handle(AssignRxLockedRotorRatioToAsynchronousMachineEvent event) {
    LOGGER.info("handling AssignRxLockedRotorRatioToAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    AsynchronousMachine entity =
        assignRxLockedRotorRatio(event.getAsynchronousMachineId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /*
   * @param	event UnAssignRxLockedRotorRatioFromAsynchronousMachineEvent
   */
  @EventHandler(payloadType = UnAssignRxLockedRotorRatioFromAsynchronousMachineEvent.class)
  public void handle(UnAssignRxLockedRotorRatioFromAsynchronousMachineEvent event) {
    LOGGER.info("handling UnAssignRxLockedRotorRatioFromAsynchronousMachineEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    AsynchronousMachine entity = unAssignRxLockedRotorRatio(event.getAsynchronousMachineId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindAsynchronousMachine(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllAsynchronousMachine(entity);
  }

  /**
   * Method to retrieve the AsynchronousMachine via an AsynchronousMachinePrimaryKey.
   *
   * @param id Long
   * @return AsynchronousMachine
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public AsynchronousMachine handle(FindAsynchronousMachineQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getAsynchronousMachineId());
  }

  /**
   * Method to retrieve a collection of all AsynchronousMachines
   *
   * @param query FindAllAsynchronousMachineQuery
   * @return List<AsynchronousMachine>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<AsynchronousMachine> handle(FindAllAsynchronousMachineQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindAsynchronousMachine, but only if the id matches
   *
   * @param entity AsynchronousMachine
   */
  protected void emitFindAsynchronousMachine(AsynchronousMachine entity) {
    LOGGER.info("handling emitFindAsynchronousMachine");

    queryUpdateEmitter.emit(
        FindAsynchronousMachineQuery.class,
        query ->
            query.getFilter().getAsynchronousMachineId().equals(entity.getAsynchronousMachineId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllAsynchronousMachine
   *
   * @param entity AsynchronousMachine
   */
  protected void emitFindAllAsynchronousMachine(AsynchronousMachine entity) {
    LOGGER.info("handling emitFindAllAsynchronousMachine");

    queryUpdateEmitter.emit(FindAllAsynchronousMachineQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineProjector.class.getName());
}
