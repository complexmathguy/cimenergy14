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
 * Projector for ShuntCompensator as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ShuntCompensatorAggregate
 *
 * @author your_name_here
 */
@Component("shuntCompensator-entity-projector")
public class ShuntCompensatorEntityProjector {

  // core constructor
  public ShuntCompensatorEntityProjector(ShuntCompensatorRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ShuntCompensator
   *
   * @param	entity ShuntCompensator
   */
  public ShuntCompensator create(ShuntCompensator entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ShuntCompensator
   *
   * @param	entity ShuntCompensator
   */
  public ShuntCompensator update(ShuntCompensator entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ShuntCompensator
   *
   * @param	id		UUID
   */
  public ShuntCompensator delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ShuntCompensator entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a AVRDelay
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ShuntCompensator
   */
  public ShuntCompensator assignAVRDelay(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning AVRDelay as " + assignment.toString());

    ShuntCompensator parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the AVRDelay to the parent entity
    // ------------------------------------------
    parentEntity.setAVRDelay(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the AVRDelay
   *
   * @param	parentId		UUID
   * @return	ShuntCompensator
   */
  public ShuntCompensator unAssignAVRDelay(UUID parentId) {
    ShuntCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning AVRDelay on " + parentEntity.toString());

    // ------------------------------------------
    // null out the AVRDelay on the parent entithy
    // ------------------------------------------
    parentEntity.setAVRDelay(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Grounded
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ShuntCompensator
   */
  public ShuntCompensator assignGrounded(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Grounded as " + assignment.toString());

    ShuntCompensator parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Grounded to the parent entity
    // ------------------------------------------
    parentEntity.setGrounded(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Grounded
   *
   * @param	parentId		UUID
   * @return	ShuntCompensator
   */
  public ShuntCompensator unAssignGrounded(UUID parentId) {
    ShuntCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Grounded on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Grounded on the parent entithy
    // ------------------------------------------
    parentEntity.setGrounded(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MaximumSections
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	ShuntCompensator
   */
  public ShuntCompensator assignMaximumSections(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning MaximumSections as " + assignment.toString());

    ShuntCompensator parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the MaximumSections to the parent entity
    // ------------------------------------------
    parentEntity.setMaximumSections(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaximumSections
   *
   * @param	parentId		UUID
   * @return	ShuntCompensator
   */
  public ShuntCompensator unAssignMaximumSections(UUID parentId) {
    ShuntCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaximumSections on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaximumSections on the parent entithy
    // ------------------------------------------
    parentEntity.setMaximumSections(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NomU
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	ShuntCompensator
   */
  public ShuntCompensator assignNomU(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning NomU as " + assignment.toString());

    ShuntCompensator parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the NomU to the parent entity
    // ------------------------------------------
    parentEntity.setNomU(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NomU
   *
   * @param	parentId		UUID
   * @return	ShuntCompensator
   */
  public ShuntCompensator unAssignNomU(UUID parentId) {
    ShuntCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NomU on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NomU on the parent entithy
    // ------------------------------------------
    parentEntity.setNomU(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NormalSections
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	ShuntCompensator
   */
  public ShuntCompensator assignNormalSections(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning NormalSections as " + assignment.toString());

    ShuntCompensator parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the NormalSections to the parent entity
    // ------------------------------------------
    parentEntity.setNormalSections(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NormalSections
   *
   * @param	parentId		UUID
   * @return	ShuntCompensator
   */
  public ShuntCompensator unAssignNormalSections(UUID parentId) {
    ShuntCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NormalSections on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NormalSections on the parent entithy
    // ------------------------------------------
    parentEntity.setNormalSections(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SwitchOnCount
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	ShuntCompensator
   */
  public ShuntCompensator assignSwitchOnCount(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning SwitchOnCount as " + assignment.toString());

    ShuntCompensator parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the SwitchOnCount to the parent entity
    // ------------------------------------------
    parentEntity.setSwitchOnCount(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SwitchOnCount
   *
   * @param	parentId		UUID
   * @return	ShuntCompensator
   */
  public ShuntCompensator unAssignSwitchOnCount(UUID parentId) {
    ShuntCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SwitchOnCount on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SwitchOnCount on the parent entithy
    // ------------------------------------------
    parentEntity.setSwitchOnCount(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SwitchOnDate
   *
   * @param	parentId	UUID
   * @param	assignment 	DateTime
   * @return	ShuntCompensator
   */
  public ShuntCompensator assignSwitchOnDate(UUID parentId, DateTime assignment) {
    LOGGER.info("assigning SwitchOnDate as " + assignment.toString());

    ShuntCompensator parentEntity = repository.findById(parentId).get();
    assignment = DateTimeProjector.find(assignment.getDateTimeId());

    // ------------------------------------------
    // assign the SwitchOnDate to the parent entity
    // ------------------------------------------
    parentEntity.setSwitchOnDate(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SwitchOnDate
   *
   * @param	parentId		UUID
   * @return	ShuntCompensator
   */
  public ShuntCompensator unAssignSwitchOnDate(UUID parentId) {
    ShuntCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SwitchOnDate on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SwitchOnDate on the parent entithy
    // ------------------------------------------
    parentEntity.setSwitchOnDate(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a VoltageSensitivity
   *
   * @param	parentId	UUID
   * @param	assignment 	VoltagePerReactivePower
   * @return	ShuntCompensator
   */
  public ShuntCompensator assignVoltageSensitivity(
      UUID parentId, VoltagePerReactivePower assignment) {
    LOGGER.info("assigning VoltageSensitivity as " + assignment.toString());

    ShuntCompensator parentEntity = repository.findById(parentId).get();
    assignment = VoltagePerReactivePowerProjector.find(assignment.getVoltagePerReactivePowerId());

    // ------------------------------------------
    // assign the VoltageSensitivity to the parent entity
    // ------------------------------------------
    parentEntity.setVoltageSensitivity(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the VoltageSensitivity
   *
   * @param	parentId		UUID
   * @return	ShuntCompensator
   */
  public ShuntCompensator unAssignVoltageSensitivity(UUID parentId) {
    ShuntCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning VoltageSensitivity on " + parentEntity.toString());

    // ------------------------------------------
    // null out the VoltageSensitivity on the parent entithy
    // ------------------------------------------
    parentEntity.setVoltageSensitivity(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ShuntCompensator via an FindShuntCompensatorQuery
   *
   * @return query FindShuntCompensatorQuery
   */
  @SuppressWarnings("unused")
  public ShuntCompensator find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ShuntCompensator - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ShuntCompensators
   *
   * @param query FindAllShuntCompensatorQuery
   * @return List<ShuntCompensator>
   */
  @SuppressWarnings("unused")
  public List<ShuntCompensator> findAll(FindAllShuntCompensatorQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ShuntCompensator - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ShuntCompensatorRepository repository;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "voltage-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .VoltageEntityProjector
      VoltageProjector;

  @Autowired
  @Qualifier(value = "dateTime-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .DateTimeEntityProjector
      DateTimeProjector;

  @Autowired
  @Qualifier(value = "voltagePerReactivePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .VoltagePerReactivePowerEntityProjector
      VoltagePerReactivePowerProjector;

  private static final Logger LOGGER =
      Logger.getLogger(ShuntCompensatorEntityProjector.class.getName());
}
