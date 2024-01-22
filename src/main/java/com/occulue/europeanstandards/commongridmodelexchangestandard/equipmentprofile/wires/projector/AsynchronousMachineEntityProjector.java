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
 * Projector for AsynchronousMachine as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by AsynchronousMachineAggregate
 *
 * @author your_name_here
 */
@Component("asynchronousMachine-entity-projector")
public class AsynchronousMachineEntityProjector {

  // core constructor
  public AsynchronousMachineEntityProjector(AsynchronousMachineRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a AsynchronousMachine
   *
   * @param	entity AsynchronousMachine
   */
  public AsynchronousMachine create(AsynchronousMachine entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a AsynchronousMachine
   *
   * @param	entity AsynchronousMachine
   */
  public AsynchronousMachine update(AsynchronousMachine entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a AsynchronousMachine
   *
   * @param	id		UUID
   */
  public AsynchronousMachine delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    AsynchronousMachine entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a ConverterFedDrive
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine assignConverterFedDrive(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning ConverterFedDrive as " + assignment.toString());

    AsynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the ConverterFedDrive to the parent entity
    // ------------------------------------------
    parentEntity.setConverterFedDrive(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ConverterFedDrive
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine unAssignConverterFedDrive(UUID parentId) {
    AsynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ConverterFedDrive on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ConverterFedDrive on the parent entithy
    // ------------------------------------------
    parentEntity.setConverterFedDrive(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Efficiency
   *
   * @param	parentId	UUID
   * @param	assignment 	PerCent
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine assignEfficiency(UUID parentId, PerCent assignment) {
    LOGGER.info("assigning Efficiency as " + assignment.toString());

    AsynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = PerCentProjector.find(assignment.getPerCentId());

    // ------------------------------------------
    // assign the Efficiency to the parent entity
    // ------------------------------------------
    parentEntity.setEfficiency(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efficiency
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine unAssignEfficiency(UUID parentId) {
    AsynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efficiency on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efficiency on the parent entithy
    // ------------------------------------------
    parentEntity.setEfficiency(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a IaIrRatio
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine assignIaIrRatio(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning IaIrRatio as " + assignment.toString());

    AsynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the IaIrRatio to the parent entity
    // ------------------------------------------
    parentEntity.setIaIrRatio(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the IaIrRatio
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine unAssignIaIrRatio(UUID parentId) {
    AsynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning IaIrRatio on " + parentEntity.toString());

    // ------------------------------------------
    // null out the IaIrRatio on the parent entithy
    // ------------------------------------------
    parentEntity.setIaIrRatio(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NominalFrequency
   *
   * @param	parentId	UUID
   * @param	assignment 	Frequency
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine assignNominalFrequency(UUID parentId, Frequency assignment) {
    LOGGER.info("assigning NominalFrequency as " + assignment.toString());

    AsynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = FrequencyProjector.find(assignment.getFrequencyId());

    // ------------------------------------------
    // assign the NominalFrequency to the parent entity
    // ------------------------------------------
    parentEntity.setNominalFrequency(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NominalFrequency
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine unAssignNominalFrequency(UUID parentId) {
    AsynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NominalFrequency on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NominalFrequency on the parent entithy
    // ------------------------------------------
    parentEntity.setNominalFrequency(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NominalSpeed
   *
   * @param	parentId	UUID
   * @param	assignment 	RotationSpeed
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine assignNominalSpeed(UUID parentId, RotationSpeed assignment) {
    LOGGER.info("assigning NominalSpeed as " + assignment.toString());

    AsynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = RotationSpeedProjector.find(assignment.getRotationSpeedId());

    // ------------------------------------------
    // assign the NominalSpeed to the parent entity
    // ------------------------------------------
    parentEntity.setNominalSpeed(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NominalSpeed
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine unAssignNominalSpeed(UUID parentId) {
    AsynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NominalSpeed on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NominalSpeed on the parent entithy
    // ------------------------------------------
    parentEntity.setNominalSpeed(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a PolePairNumber
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine assignPolePairNumber(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning PolePairNumber as " + assignment.toString());

    AsynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the PolePairNumber to the parent entity
    // ------------------------------------------
    parentEntity.setPolePairNumber(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PolePairNumber
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine unAssignPolePairNumber(UUID parentId) {
    AsynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PolePairNumber on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PolePairNumber on the parent entithy
    // ------------------------------------------
    parentEntity.setPolePairNumber(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a RatedMechanicalPower
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine assignRatedMechanicalPower(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning RatedMechanicalPower as " + assignment.toString());

    AsynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the RatedMechanicalPower to the parent entity
    // ------------------------------------------
    parentEntity.setRatedMechanicalPower(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RatedMechanicalPower
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine unAssignRatedMechanicalPower(UUID parentId) {
    AsynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RatedMechanicalPower on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RatedMechanicalPower on the parent entithy
    // ------------------------------------------
    parentEntity.setRatedMechanicalPower(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Reversible
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine assignReversible(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Reversible as " + assignment.toString());

    AsynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Reversible to the parent entity
    // ------------------------------------------
    parentEntity.setReversible(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Reversible
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine unAssignReversible(UUID parentId) {
    AsynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Reversible on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Reversible on the parent entithy
    // ------------------------------------------
    parentEntity.setReversible(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a RxLockedRotorRatio
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine assignRxLockedRotorRatio(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning RxLockedRotorRatio as " + assignment.toString());

    AsynchronousMachine parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the RxLockedRotorRatio to the parent entity
    // ------------------------------------------
    parentEntity.setRxLockedRotorRatio(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RxLockedRotorRatio
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachine
   */
  public AsynchronousMachine unAssignRxLockedRotorRatio(UUID parentId) {
    AsynchronousMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RxLockedRotorRatio on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RxLockedRotorRatio on the parent entithy
    // ------------------------------------------
    parentEntity.setRxLockedRotorRatio(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the AsynchronousMachine via an FindAsynchronousMachineQuery
   *
   * @return query FindAsynchronousMachineQuery
   */
  @SuppressWarnings("unused")
  public AsynchronousMachine find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a AsynchronousMachine - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all AsynchronousMachines
   *
   * @param query FindAllAsynchronousMachineQuery
   * @return List<AsynchronousMachine>
   */
  @SuppressWarnings("unused")
  public List<AsynchronousMachine> findAll(FindAllAsynchronousMachineQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all AsynchronousMachine - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final AsynchronousMachineRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "perCent-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PerCentEntityProjector
      PerCentProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "frequency-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .FrequencyEntityProjector
      FrequencyProjector;

  @Autowired
  @Qualifier(value = "rotationSpeed-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .RotationSpeedEntityProjector
      RotationSpeedProjector;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "activePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ActivePowerEntityProjector
      ActivePowerProjector;

  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineEntityProjector.class.getName());
}
