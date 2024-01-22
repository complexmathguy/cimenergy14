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
 * Projector for PowerTransformer as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PowerTransformerAggregate
 *
 * @author your_name_here
 */
@Component("powerTransformer-entity-projector")
public class PowerTransformerEntityProjector {

  // core constructor
  public PowerTransformerEntityProjector(PowerTransformerRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PowerTransformer
   *
   * @param	entity PowerTransformer
   */
  public PowerTransformer create(PowerTransformer entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PowerTransformer
   *
   * @param	entity PowerTransformer
   */
  public PowerTransformer update(PowerTransformer entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PowerTransformer
   *
   * @param	id		UUID
   */
  public PowerTransformer delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PowerTransformer entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a BeforeShCircuitHighestOperatingCurrent
   *
   * @param	parentId	UUID
   * @param	assignment 	CurrentFlow
   * @return	PowerTransformer
   */
  public PowerTransformer assignBeforeShCircuitHighestOperatingCurrent(
      UUID parentId, CurrentFlow assignment) {
    LOGGER.info("assigning BeforeShCircuitHighestOperatingCurrent as " + assignment.toString());

    PowerTransformer parentEntity = repository.findById(parentId).get();
    assignment = CurrentFlowProjector.find(assignment.getCurrentFlowId());

    // ------------------------------------------
    // assign the BeforeShCircuitHighestOperatingCurrent to the parent entity
    // ------------------------------------------
    parentEntity.setBeforeShCircuitHighestOperatingCurrent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the BeforeShCircuitHighestOperatingCurrent
   *
   * @param	parentId		UUID
   * @return	PowerTransformer
   */
  public PowerTransformer unAssignBeforeShCircuitHighestOperatingCurrent(UUID parentId) {
    PowerTransformer parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning BeforeShCircuitHighestOperatingCurrent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the BeforeShCircuitHighestOperatingCurrent on the parent entithy
    // ------------------------------------------
    parentEntity.setBeforeShCircuitHighestOperatingCurrent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a BeforeShCircuitHighestOperatingVoltage
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	PowerTransformer
   */
  public PowerTransformer assignBeforeShCircuitHighestOperatingVoltage(
      UUID parentId, Voltage assignment) {
    LOGGER.info("assigning BeforeShCircuitHighestOperatingVoltage as " + assignment.toString());

    PowerTransformer parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the BeforeShCircuitHighestOperatingVoltage to the parent entity
    // ------------------------------------------
    parentEntity.setBeforeShCircuitHighestOperatingVoltage(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the BeforeShCircuitHighestOperatingVoltage
   *
   * @param	parentId		UUID
   * @return	PowerTransformer
   */
  public PowerTransformer unAssignBeforeShCircuitHighestOperatingVoltage(UUID parentId) {
    PowerTransformer parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning BeforeShCircuitHighestOperatingVoltage on " + parentEntity.toString());

    // ------------------------------------------
    // null out the BeforeShCircuitHighestOperatingVoltage on the parent entithy
    // ------------------------------------------
    parentEntity.setBeforeShCircuitHighestOperatingVoltage(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a BeforeShortCircuitAnglePf
   *
   * @param	parentId	UUID
   * @param	assignment 	AngleDegrees
   * @return	PowerTransformer
   */
  public PowerTransformer assignBeforeShortCircuitAnglePf(UUID parentId, AngleDegrees assignment) {
    LOGGER.info("assigning BeforeShortCircuitAnglePf as " + assignment.toString());

    PowerTransformer parentEntity = repository.findById(parentId).get();
    assignment = AngleDegreesProjector.find(assignment.getAngleDegreesId());

    // ------------------------------------------
    // assign the BeforeShortCircuitAnglePf to the parent entity
    // ------------------------------------------
    parentEntity.setBeforeShortCircuitAnglePf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the BeforeShortCircuitAnglePf
   *
   * @param	parentId		UUID
   * @return	PowerTransformer
   */
  public PowerTransformer unAssignBeforeShortCircuitAnglePf(UUID parentId) {
    PowerTransformer parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning BeforeShortCircuitAnglePf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the BeforeShortCircuitAnglePf on the parent entithy
    // ------------------------------------------
    parentEntity.setBeforeShortCircuitAnglePf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a HighSideMinOperatingU
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	PowerTransformer
   */
  public PowerTransformer assignHighSideMinOperatingU(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning HighSideMinOperatingU as " + assignment.toString());

    PowerTransformer parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the HighSideMinOperatingU to the parent entity
    // ------------------------------------------
    parentEntity.setHighSideMinOperatingU(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the HighSideMinOperatingU
   *
   * @param	parentId		UUID
   * @return	PowerTransformer
   */
  public PowerTransformer unAssignHighSideMinOperatingU(UUID parentId) {
    PowerTransformer parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning HighSideMinOperatingU on " + parentEntity.toString());

    // ------------------------------------------
    // null out the HighSideMinOperatingU on the parent entithy
    // ------------------------------------------
    parentEntity.setHighSideMinOperatingU(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a PartOfGeneratorUnitFlag
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	PowerTransformer
   */
  public PowerTransformer assignPartOfGeneratorUnitFlag(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning PartOfGeneratorUnitFlag as " + assignment.toString());

    PowerTransformer parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the PartOfGeneratorUnitFlag to the parent entity
    // ------------------------------------------
    parentEntity.setPartOfGeneratorUnitFlag(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PartOfGeneratorUnitFlag
   *
   * @param	parentId		UUID
   * @return	PowerTransformer
   */
  public PowerTransformer unAssignPartOfGeneratorUnitFlag(UUID parentId) {
    PowerTransformer parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PartOfGeneratorUnitFlag on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PartOfGeneratorUnitFlag on the parent entithy
    // ------------------------------------------
    parentEntity.setPartOfGeneratorUnitFlag(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a OperationalValuesConsidered
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	PowerTransformer
   */
  public PowerTransformer assignOperationalValuesConsidered(
      UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning OperationalValuesConsidered as " + assignment.toString());

    PowerTransformer parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the OperationalValuesConsidered to the parent entity
    // ------------------------------------------
    parentEntity.setOperationalValuesConsidered(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the OperationalValuesConsidered
   *
   * @param	parentId		UUID
   * @return	PowerTransformer
   */
  public PowerTransformer unAssignOperationalValuesConsidered(UUID parentId) {
    PowerTransformer parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning OperationalValuesConsidered on " + parentEntity.toString());

    // ------------------------------------------
    // null out the OperationalValuesConsidered on the parent entithy
    // ------------------------------------------
    parentEntity.setOperationalValuesConsidered(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PowerTransformer via an FindPowerTransformerQuery
   *
   * @return query FindPowerTransformerQuery
   */
  @SuppressWarnings("unused")
  public PowerTransformer find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PowerTransformer - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PowerTransformers
   *
   * @param query FindAllPowerTransformerQuery
   * @return List<PowerTransformer>
   */
  @SuppressWarnings("unused")
  public List<PowerTransformer> findAll(FindAllPowerTransformerQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PowerTransformer - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PowerTransformerRepository repository;

  @Autowired
  @Qualifier(value = "currentFlow-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .CurrentFlowEntityProjector
      CurrentFlowProjector;

  @Autowired
  @Qualifier(value = "voltage-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .VoltageEntityProjector
      VoltageProjector;

  @Autowired
  @Qualifier(value = "angleDegrees-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .AngleDegreesEntityProjector
      AngleDegreesProjector;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(PowerTransformerEntityProjector.class.getName());
}
