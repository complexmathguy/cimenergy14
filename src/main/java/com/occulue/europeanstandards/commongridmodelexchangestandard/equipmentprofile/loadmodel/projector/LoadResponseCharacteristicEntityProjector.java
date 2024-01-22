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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for LoadResponseCharacteristic as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by LoadResponseCharacteristicAggregate
 *
 * @author your_name_here
 */
@Component("loadResponseCharacteristic-entity-projector")
public class LoadResponseCharacteristicEntityProjector {

  // core constructor
  public LoadResponseCharacteristicEntityProjector(
      LoadResponseCharacteristicRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a LoadResponseCharacteristic
   *
   * @param	entity LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic create(LoadResponseCharacteristic entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a LoadResponseCharacteristic
   *
   * @param	entity LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic update(LoadResponseCharacteristic entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a LoadResponseCharacteristic
   *
   * @param	id		UUID
   */
  public LoadResponseCharacteristic delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    LoadResponseCharacteristic entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a ExponentModel
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic assignExponentModel(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning ExponentModel as " + assignment.toString());

    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the ExponentModel to the parent entity
    // ------------------------------------------
    parentEntity.setExponentModel(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ExponentModel
   *
   * @param	parentId		UUID
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic unAssignExponentModel(UUID parentId) {
    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ExponentModel on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ExponentModel on the parent entithy
    // ------------------------------------------
    parentEntity.setExponentModel(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a PConstantCurrent
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic assignPConstantCurrent(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning PConstantCurrent as " + assignment.toString());

    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the PConstantCurrent to the parent entity
    // ------------------------------------------
    parentEntity.setPConstantCurrent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PConstantCurrent
   *
   * @param	parentId		UUID
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic unAssignPConstantCurrent(UUID parentId) {
    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PConstantCurrent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PConstantCurrent on the parent entithy
    // ------------------------------------------
    parentEntity.setPConstantCurrent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a PConstantImpedance
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic assignPConstantImpedance(
      UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning PConstantImpedance as " + assignment.toString());

    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the PConstantImpedance to the parent entity
    // ------------------------------------------
    parentEntity.setPConstantImpedance(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PConstantImpedance
   *
   * @param	parentId		UUID
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic unAssignPConstantImpedance(UUID parentId) {
    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PConstantImpedance on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PConstantImpedance on the parent entithy
    // ------------------------------------------
    parentEntity.setPConstantImpedance(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a PConstantPower
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic assignPConstantPower(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning PConstantPower as " + assignment.toString());

    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the PConstantPower to the parent entity
    // ------------------------------------------
    parentEntity.setPConstantPower(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PConstantPower
   *
   * @param	parentId		UUID
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic unAssignPConstantPower(UUID parentId) {
    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PConstantPower on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PConstantPower on the parent entithy
    // ------------------------------------------
    parentEntity.setPConstantPower(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a PFrequencyExponent
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic assignPFrequencyExponent(
      UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning PFrequencyExponent as " + assignment.toString());

    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the PFrequencyExponent to the parent entity
    // ------------------------------------------
    parentEntity.setPFrequencyExponent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PFrequencyExponent
   *
   * @param	parentId		UUID
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic unAssignPFrequencyExponent(UUID parentId) {
    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PFrequencyExponent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PFrequencyExponent on the parent entithy
    // ------------------------------------------
    parentEntity.setPFrequencyExponent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a PVoltageExponent
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic assignPVoltageExponent(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning PVoltageExponent as " + assignment.toString());

    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the PVoltageExponent to the parent entity
    // ------------------------------------------
    parentEntity.setPVoltageExponent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PVoltageExponent
   *
   * @param	parentId		UUID
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic unAssignPVoltageExponent(UUID parentId) {
    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PVoltageExponent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PVoltageExponent on the parent entithy
    // ------------------------------------------
    parentEntity.setPVoltageExponent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a QConstantCurrent
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic assignQConstantCurrent(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning QConstantCurrent as " + assignment.toString());

    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the QConstantCurrent to the parent entity
    // ------------------------------------------
    parentEntity.setQConstantCurrent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the QConstantCurrent
   *
   * @param	parentId		UUID
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic unAssignQConstantCurrent(UUID parentId) {
    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning QConstantCurrent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the QConstantCurrent on the parent entithy
    // ------------------------------------------
    parentEntity.setQConstantCurrent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a QConstantImpedance
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic assignQConstantImpedance(
      UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning QConstantImpedance as " + assignment.toString());

    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the QConstantImpedance to the parent entity
    // ------------------------------------------
    parentEntity.setQConstantImpedance(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the QConstantImpedance
   *
   * @param	parentId		UUID
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic unAssignQConstantImpedance(UUID parentId) {
    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning QConstantImpedance on " + parentEntity.toString());

    // ------------------------------------------
    // null out the QConstantImpedance on the parent entithy
    // ------------------------------------------
    parentEntity.setQConstantImpedance(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a QConstantPower
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic assignQConstantPower(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning QConstantPower as " + assignment.toString());

    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the QConstantPower to the parent entity
    // ------------------------------------------
    parentEntity.setQConstantPower(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the QConstantPower
   *
   * @param	parentId		UUID
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic unAssignQConstantPower(UUID parentId) {
    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning QConstantPower on " + parentEntity.toString());

    // ------------------------------------------
    // null out the QConstantPower on the parent entithy
    // ------------------------------------------
    parentEntity.setQConstantPower(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a QFrequencyExponent
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic assignQFrequencyExponent(
      UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning QFrequencyExponent as " + assignment.toString());

    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the QFrequencyExponent to the parent entity
    // ------------------------------------------
    parentEntity.setQFrequencyExponent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the QFrequencyExponent
   *
   * @param	parentId		UUID
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic unAssignQFrequencyExponent(UUID parentId) {
    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning QFrequencyExponent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the QFrequencyExponent on the parent entithy
    // ------------------------------------------
    parentEntity.setQFrequencyExponent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a QVoltageExponent
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic assignQVoltageExponent(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning QVoltageExponent as " + assignment.toString());

    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the QVoltageExponent to the parent entity
    // ------------------------------------------
    parentEntity.setQVoltageExponent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the QVoltageExponent
   *
   * @param	parentId		UUID
   * @return	LoadResponseCharacteristic
   */
  public LoadResponseCharacteristic unAssignQVoltageExponent(UUID parentId) {
    LoadResponseCharacteristic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning QVoltageExponent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the QVoltageExponent on the parent entithy
    // ------------------------------------------
    parentEntity.setQVoltageExponent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the LoadResponseCharacteristic via an FindLoadResponseCharacteristicQuery
   *
   * @return query FindLoadResponseCharacteristicQuery
   */
  @SuppressWarnings("unused")
  public LoadResponseCharacteristic find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a LoadResponseCharacteristic - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all LoadResponseCharacteristics
   *
   * @param query FindAllLoadResponseCharacteristicQuery
   * @return List<LoadResponseCharacteristic>
   */
  @SuppressWarnings("unused")
  public List<LoadResponseCharacteristic> findAll(FindAllLoadResponseCharacteristicQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all LoadResponseCharacteristic - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final LoadResponseCharacteristicRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  private static final Logger LOGGER =
      Logger.getLogger(LoadResponseCharacteristicEntityProjector.class.getName());
}
