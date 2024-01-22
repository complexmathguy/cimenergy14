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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for SynchronousMachineDetailed as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SynchronousMachineDetailedAggregate
 *
 * @author your_name_here
 */
@Component("synchronousMachineDetailed-entity-projector")
public class SynchronousMachineDetailedEntityProjector {

  // core constructor
  public SynchronousMachineDetailedEntityProjector(
      SynchronousMachineDetailedRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a SynchronousMachineDetailed
   *
   * @param	entity SynchronousMachineDetailed
   */
  public SynchronousMachineDetailed create(SynchronousMachineDetailed entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a SynchronousMachineDetailed
   *
   * @param	entity SynchronousMachineDetailed
   */
  public SynchronousMachineDetailed update(SynchronousMachineDetailed entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a SynchronousMachineDetailed
   *
   * @param	id		UUID
   */
  public SynchronousMachineDetailed delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    SynchronousMachineDetailed entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a EfdBaseRatio
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	SynchronousMachineDetailed
   */
  public SynchronousMachineDetailed assignEfdBaseRatio(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning EfdBaseRatio as " + assignment.toString());

    SynchronousMachineDetailed parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the EfdBaseRatio to the parent entity
    // ------------------------------------------
    parentEntity.setEfdBaseRatio(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the EfdBaseRatio
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineDetailed
   */
  public SynchronousMachineDetailed unAssignEfdBaseRatio(UUID parentId) {
    SynchronousMachineDetailed parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning EfdBaseRatio on " + parentEntity.toString());

    // ------------------------------------------
    // null out the EfdBaseRatio on the parent entithy
    // ------------------------------------------
    parentEntity.setEfdBaseRatio(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a IfdBaseValue
   *
   * @param	parentId	UUID
   * @param	assignment 	CurrentFlow
   * @return	SynchronousMachineDetailed
   */
  public SynchronousMachineDetailed assignIfdBaseValue(UUID parentId, CurrentFlow assignment) {
    LOGGER.info("assigning IfdBaseValue as " + assignment.toString());

    SynchronousMachineDetailed parentEntity = repository.findById(parentId).get();
    assignment = CurrentFlowProjector.find(assignment.getCurrentFlowId());

    // ------------------------------------------
    // assign the IfdBaseValue to the parent entity
    // ------------------------------------------
    parentEntity.setIfdBaseValue(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the IfdBaseValue
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineDetailed
   */
  public SynchronousMachineDetailed unAssignIfdBaseValue(UUID parentId) {
    SynchronousMachineDetailed parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning IfdBaseValue on " + parentEntity.toString());

    // ------------------------------------------
    // null out the IfdBaseValue on the parent entithy
    // ------------------------------------------
    parentEntity.setIfdBaseValue(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SaturationFactor120QAxis
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	SynchronousMachineDetailed
   */
  public SynchronousMachineDetailed assignSaturationFactor120QAxis(
      UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning SaturationFactor120QAxis as " + assignment.toString());

    SynchronousMachineDetailed parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the SaturationFactor120QAxis to the parent entity
    // ------------------------------------------
    parentEntity.setSaturationFactor120QAxis(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SaturationFactor120QAxis
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineDetailed
   */
  public SynchronousMachineDetailed unAssignSaturationFactor120QAxis(UUID parentId) {
    SynchronousMachineDetailed parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SaturationFactor120QAxis on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SaturationFactor120QAxis on the parent entithy
    // ------------------------------------------
    parentEntity.setSaturationFactor120QAxis(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SaturationFactorQAxis
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	SynchronousMachineDetailed
   */
  public SynchronousMachineDetailed assignSaturationFactorQAxis(
      UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning SaturationFactorQAxis as " + assignment.toString());

    SynchronousMachineDetailed parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the SaturationFactorQAxis to the parent entity
    // ------------------------------------------
    parentEntity.setSaturationFactorQAxis(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SaturationFactorQAxis
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineDetailed
   */
  public SynchronousMachineDetailed unAssignSaturationFactorQAxis(UUID parentId) {
    SynchronousMachineDetailed parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SaturationFactorQAxis on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SaturationFactorQAxis on the parent entithy
    // ------------------------------------------
    parentEntity.setSaturationFactorQAxis(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the SynchronousMachineDetailed via an FindSynchronousMachineDetailedQuery
   *
   * @return query FindSynchronousMachineDetailedQuery
   */
  @SuppressWarnings("unused")
  public SynchronousMachineDetailed find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a SynchronousMachineDetailed - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all SynchronousMachineDetaileds
   *
   * @param query FindAllSynchronousMachineDetailedQuery
   * @return List<SynchronousMachineDetailed>
   */
  @SuppressWarnings("unused")
  public List<SynchronousMachineDetailed> findAll(FindAllSynchronousMachineDetailedQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all SynchronousMachineDetailed - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SynchronousMachineDetailedRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "currentFlow-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .CurrentFlowEntityProjector
      CurrentFlowProjector;

  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineDetailedEntityProjector.class.getName());
}
