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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.asynchronousmachinedynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.asynchronousmachinedynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for AsynchronousMachineTimeConstantReactance as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by AsynchronousMachineTimeConstantReactanceAggregate
 *
 * @author your_name_here
 */
@Component("asynchronousMachineTimeConstantReactance-entity-projector")
public class AsynchronousMachineTimeConstantReactanceEntityProjector {

  // core constructor
  public AsynchronousMachineTimeConstantReactanceEntityProjector(
      AsynchronousMachineTimeConstantReactanceRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a AsynchronousMachineTimeConstantReactance
   *
   * @param	entity AsynchronousMachineTimeConstantReactance
   */
  public AsynchronousMachineTimeConstantReactance create(
      AsynchronousMachineTimeConstantReactance entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a AsynchronousMachineTimeConstantReactance
   *
   * @param	entity AsynchronousMachineTimeConstantReactance
   */
  public AsynchronousMachineTimeConstantReactance update(
      AsynchronousMachineTimeConstantReactance entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a AsynchronousMachineTimeConstantReactance
   *
   * @param	id		UUID
   */
  public AsynchronousMachineTimeConstantReactance delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    AsynchronousMachineTimeConstantReactance entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Tpo
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	AsynchronousMachineTimeConstantReactance
   */
  public AsynchronousMachineTimeConstantReactance assignTpo(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpo as " + assignment.toString());

    AsynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpo to the parent entity
    // ------------------------------------------
    parentEntity.setTpo(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpo
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachineTimeConstantReactance
   */
  public AsynchronousMachineTimeConstantReactance unAssignTpo(UUID parentId) {
    AsynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpo on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpo on the parent entithy
    // ------------------------------------------
    parentEntity.setTpo(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tppo
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	AsynchronousMachineTimeConstantReactance
   */
  public AsynchronousMachineTimeConstantReactance assignTppo(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tppo as " + assignment.toString());

    AsynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tppo to the parent entity
    // ------------------------------------------
    parentEntity.setTppo(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tppo
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachineTimeConstantReactance
   */
  public AsynchronousMachineTimeConstantReactance unAssignTppo(UUID parentId) {
    AsynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tppo on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tppo on the parent entithy
    // ------------------------------------------
    parentEntity.setTppo(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	AsynchronousMachineTimeConstantReactance
   */
  public AsynchronousMachineTimeConstantReactance assignXp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xp as " + assignment.toString());

    AsynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xp to the parent entity
    // ------------------------------------------
    parentEntity.setXp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xp
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachineTimeConstantReactance
   */
  public AsynchronousMachineTimeConstantReactance unAssignXp(UUID parentId) {
    AsynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xp on the parent entithy
    // ------------------------------------------
    parentEntity.setXp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xpp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	AsynchronousMachineTimeConstantReactance
   */
  public AsynchronousMachineTimeConstantReactance assignXpp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xpp as " + assignment.toString());

    AsynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xpp to the parent entity
    // ------------------------------------------
    parentEntity.setXpp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xpp
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachineTimeConstantReactance
   */
  public AsynchronousMachineTimeConstantReactance unAssignXpp(UUID parentId) {
    AsynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xpp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xpp on the parent entithy
    // ------------------------------------------
    parentEntity.setXpp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xs
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	AsynchronousMachineTimeConstantReactance
   */
  public AsynchronousMachineTimeConstantReactance assignXs(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xs as " + assignment.toString());

    AsynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xs to the parent entity
    // ------------------------------------------
    parentEntity.setXs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xs
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachineTimeConstantReactance
   */
  public AsynchronousMachineTimeConstantReactance unAssignXs(UUID parentId) {
    AsynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xs on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xs on the parent entithy
    // ------------------------------------------
    parentEntity.setXs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the AsynchronousMachineTimeConstantReactance via an
   * FindAsynchronousMachineTimeConstantReactanceQuery
   *
   * @return query FindAsynchronousMachineTimeConstantReactanceQuery
   */
  @SuppressWarnings("unused")
  public AsynchronousMachineTimeConstantReactance find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find a AsynchronousMachineTimeConstantReactance - {0}",
          exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all AsynchronousMachineTimeConstantReactances
   *
   * @param query FindAllAsynchronousMachineTimeConstantReactanceQuery
   * @return List<AsynchronousMachineTimeConstantReactance>
   */
  @SuppressWarnings("unused")
  public List<AsynchronousMachineTimeConstantReactance> findAll(
      FindAllAsynchronousMachineTimeConstantReactanceQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find all AsynchronousMachineTimeConstantReactance - {0}",
          exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final AsynchronousMachineTimeConstantReactanceRepository repository;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineTimeConstantReactanceEntityProjector.class.getName());
}
