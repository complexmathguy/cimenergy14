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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for PowerTransformerEnd as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PowerTransformerEndAggregate
 *
 * @author your_name_here
 */
@Component("powerTransformerEnd-entity-projector")
public class PowerTransformerEndEntityProjector {

  // core constructor
  public PowerTransformerEndEntityProjector(PowerTransformerEndRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PowerTransformerEnd
   *
   * @param	entity PowerTransformerEnd
   */
  public PowerTransformerEnd create(PowerTransformerEnd entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PowerTransformerEnd
   *
   * @param	entity PowerTransformerEnd
   */
  public PowerTransformerEnd update(PowerTransformerEnd entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PowerTransformerEnd
   *
   * @param	id		UUID
   */
  public PowerTransformerEnd delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PowerTransformerEnd entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a B
   *
   * @param	parentId	UUID
   * @param	assignment 	Susceptance
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd assignB(UUID parentId, Susceptance assignment) {
    LOGGER.info("assigning B as " + assignment.toString());

    PowerTransformerEnd parentEntity = repository.findById(parentId).get();
    assignment = SusceptanceProjector.find(assignment.getSusceptanceId());

    // ------------------------------------------
    // assign the B to the parent entity
    // ------------------------------------------
    parentEntity.setB(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B
   *
   * @param	parentId		UUID
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd unAssignB(UUID parentId) {
    PowerTransformerEnd parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B on the parent entithy
    // ------------------------------------------
    parentEntity.setB(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a B0
   *
   * @param	parentId	UUID
   * @param	assignment 	Susceptance
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd assignB0(UUID parentId, Susceptance assignment) {
    LOGGER.info("assigning B0 as " + assignment.toString());

    PowerTransformerEnd parentEntity = repository.findById(parentId).get();
    assignment = SusceptanceProjector.find(assignment.getSusceptanceId());

    // ------------------------------------------
    // assign the B0 to the parent entity
    // ------------------------------------------
    parentEntity.setB0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B0
   *
   * @param	parentId		UUID
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd unAssignB0(UUID parentId) {
    PowerTransformerEnd parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B0 on the parent entithy
    // ------------------------------------------
    parentEntity.setB0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a G
   *
   * @param	parentId	UUID
   * @param	assignment 	Conductance
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd assignG(UUID parentId, Conductance assignment) {
    LOGGER.info("assigning G as " + assignment.toString());

    PowerTransformerEnd parentEntity = repository.findById(parentId).get();
    assignment = ConductanceProjector.find(assignment.getConductanceId());

    // ------------------------------------------
    // assign the G to the parent entity
    // ------------------------------------------
    parentEntity.setG(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the G
   *
   * @param	parentId		UUID
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd unAssignG(UUID parentId) {
    PowerTransformerEnd parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning G on " + parentEntity.toString());

    // ------------------------------------------
    // null out the G on the parent entithy
    // ------------------------------------------
    parentEntity.setG(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a G0
   *
   * @param	parentId	UUID
   * @param	assignment 	Conductance
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd assignG0(UUID parentId, Conductance assignment) {
    LOGGER.info("assigning G0 as " + assignment.toString());

    PowerTransformerEnd parentEntity = repository.findById(parentId).get();
    assignment = ConductanceProjector.find(assignment.getConductanceId());

    // ------------------------------------------
    // assign the G0 to the parent entity
    // ------------------------------------------
    parentEntity.setG0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the G0
   *
   * @param	parentId		UUID
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd unAssignG0(UUID parentId) {
    PowerTransformerEnd parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning G0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the G0 on the parent entithy
    // ------------------------------------------
    parentEntity.setG0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a PhaseAngleClock
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd assignPhaseAngleClock(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning PhaseAngleClock as " + assignment.toString());

    PowerTransformerEnd parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the PhaseAngleClock to the parent entity
    // ------------------------------------------
    parentEntity.setPhaseAngleClock(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PhaseAngleClock
   *
   * @param	parentId		UUID
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd unAssignPhaseAngleClock(UUID parentId) {
    PowerTransformerEnd parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PhaseAngleClock on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PhaseAngleClock on the parent entithy
    // ------------------------------------------
    parentEntity.setPhaseAngleClock(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a R
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd assignR(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning R as " + assignment.toString());

    PowerTransformerEnd parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the R to the parent entity
    // ------------------------------------------
    parentEntity.setR(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R
   *
   * @param	parentId		UUID
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd unAssignR(UUID parentId) {
    PowerTransformerEnd parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R on the parent entithy
    // ------------------------------------------
    parentEntity.setR(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a R0
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd assignR0(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning R0 as " + assignment.toString());

    PowerTransformerEnd parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the R0 to the parent entity
    // ------------------------------------------
    parentEntity.setR0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R0
   *
   * @param	parentId		UUID
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd unAssignR0(UUID parentId) {
    PowerTransformerEnd parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R0 on the parent entithy
    // ------------------------------------------
    parentEntity.setR0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a RatedS
   *
   * @param	parentId	UUID
   * @param	assignment 	ApparentPower
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd assignRatedS(UUID parentId, ApparentPower assignment) {
    LOGGER.info("assigning RatedS as " + assignment.toString());

    PowerTransformerEnd parentEntity = repository.findById(parentId).get();
    assignment = ApparentPowerProjector.find(assignment.getApparentPowerId());

    // ------------------------------------------
    // assign the RatedS to the parent entity
    // ------------------------------------------
    parentEntity.setRatedS(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RatedS
   *
   * @param	parentId		UUID
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd unAssignRatedS(UUID parentId) {
    PowerTransformerEnd parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RatedS on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RatedS on the parent entithy
    // ------------------------------------------
    parentEntity.setRatedS(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a RatedU
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd assignRatedU(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning RatedU as " + assignment.toString());

    PowerTransformerEnd parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the RatedU to the parent entity
    // ------------------------------------------
    parentEntity.setRatedU(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RatedU
   *
   * @param	parentId		UUID
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd unAssignRatedU(UUID parentId) {
    PowerTransformerEnd parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RatedU on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RatedU on the parent entithy
    // ------------------------------------------
    parentEntity.setRatedU(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a X
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd assignX(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning X as " + assignment.toString());

    PowerTransformerEnd parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the X to the parent entity
    // ------------------------------------------
    parentEntity.setX(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X
   *
   * @param	parentId		UUID
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd unAssignX(UUID parentId) {
    PowerTransformerEnd parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X on the parent entithy
    // ------------------------------------------
    parentEntity.setX(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a X0
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd assignX0(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning X0 as " + assignment.toString());

    PowerTransformerEnd parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the X0 to the parent entity
    // ------------------------------------------
    parentEntity.setX0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X0
   *
   * @param	parentId		UUID
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd unAssignX0(UUID parentId) {
    PowerTransformerEnd parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X0 on the parent entithy
    // ------------------------------------------
    parentEntity.setX0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the PowerTransformerEnd
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd addToPowerTransformerEnd(UUID parentId, PowerTransformerEnd addTo) {
    LOGGER.info("handling AssignPowerTransformerEndToPowerTransformerEndEvent - ");

    PowerTransformerEnd parentEntity = repository.findById(parentId).get();
    PowerTransformerEnd child = PowerTransformerEndProjector.find(addTo.getPowerTransformerEndId());

    parentEntity.getPowerTransformerEnd().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the PowerTransformerEnd
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	PowerTransformerEnd
   */
  public PowerTransformerEnd removeFromPowerTransformerEnd(
      UUID parentId, PowerTransformerEnd removeFrom) {
    LOGGER.info("handling RemovePowerTransformerEndFromPowerTransformerEndEvent ");

    PowerTransformerEnd parentEntity = repository.findById(parentId).get();
    PowerTransformerEnd child =
        PowerTransformerEndProjector.find(removeFrom.getPowerTransformerEndId());

    parentEntity.getPowerTransformerEnd().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PowerTransformerEnd via an FindPowerTransformerEndQuery
   *
   * @return query FindPowerTransformerEndQuery
   */
  @SuppressWarnings("unused")
  public PowerTransformerEnd find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PowerTransformerEnd - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PowerTransformerEnds
   *
   * @param query FindAllPowerTransformerEndQuery
   * @return List<PowerTransformerEnd>
   */
  @SuppressWarnings("unused")
  public List<PowerTransformerEnd> findAll(FindAllPowerTransformerEndQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PowerTransformerEnd - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PowerTransformerEndRepository repository;

  @Autowired
  @Qualifier(value = "susceptance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SusceptanceEntityProjector
      SusceptanceProjector;

  @Autowired
  @Qualifier(value = "conductance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ConductanceEntityProjector
      ConductanceProjector;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "resistance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ResistanceEntityProjector
      ResistanceProjector;

  @Autowired
  @Qualifier(value = "apparentPower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ApparentPowerEntityProjector
      ApparentPowerProjector;

  @Autowired
  @Qualifier(value = "voltage-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .VoltageEntityProjector
      VoltageProjector;

  @Autowired
  @Qualifier(value = "reactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactanceEntityProjector
      ReactanceProjector;

  @Autowired
  @Qualifier(value = "powerTransformerEnd-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .PowerTransformerEndEntityProjector
      PowerTransformerEndProjector;

  private static final Logger LOGGER =
      Logger.getLogger(PowerTransformerEndEntityProjector.class.getName());
}
