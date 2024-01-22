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
 * Projector for AsynchronousMachineEquivalentCircuit as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by AsynchronousMachineEquivalentCircuitAggregate
 *
 * @author your_name_here
 */
@Component("asynchronousMachineEquivalentCircuit-entity-projector")
public class AsynchronousMachineEquivalentCircuitEntityProjector {

  // core constructor
  public AsynchronousMachineEquivalentCircuitEntityProjector(
      AsynchronousMachineEquivalentCircuitRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a AsynchronousMachineEquivalentCircuit
   *
   * @param	entity AsynchronousMachineEquivalentCircuit
   */
  public AsynchronousMachineEquivalentCircuit create(AsynchronousMachineEquivalentCircuit entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a AsynchronousMachineEquivalentCircuit
   *
   * @param	entity AsynchronousMachineEquivalentCircuit
   */
  public AsynchronousMachineEquivalentCircuit update(AsynchronousMachineEquivalentCircuit entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a AsynchronousMachineEquivalentCircuit
   *
   * @param	id		UUID
   */
  public AsynchronousMachineEquivalentCircuit delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    AsynchronousMachineEquivalentCircuit entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Rr1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	AsynchronousMachineEquivalentCircuit
   */
  public AsynchronousMachineEquivalentCircuit assignRr1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rr1 as " + assignment.toString());

    AsynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rr1 to the parent entity
    // ------------------------------------------
    parentEntity.setRr1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rr1
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachineEquivalentCircuit
   */
  public AsynchronousMachineEquivalentCircuit unAssignRr1(UUID parentId) {
    AsynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rr1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rr1 on the parent entithy
    // ------------------------------------------
    parentEntity.setRr1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rr2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	AsynchronousMachineEquivalentCircuit
   */
  public AsynchronousMachineEquivalentCircuit assignRr2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rr2 as " + assignment.toString());

    AsynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rr2 to the parent entity
    // ------------------------------------------
    parentEntity.setRr2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rr2
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachineEquivalentCircuit
   */
  public AsynchronousMachineEquivalentCircuit unAssignRr2(UUID parentId) {
    AsynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rr2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rr2 on the parent entithy
    // ------------------------------------------
    parentEntity.setRr2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xlr1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	AsynchronousMachineEquivalentCircuit
   */
  public AsynchronousMachineEquivalentCircuit assignXlr1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xlr1 as " + assignment.toString());

    AsynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xlr1 to the parent entity
    // ------------------------------------------
    parentEntity.setXlr1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xlr1
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachineEquivalentCircuit
   */
  public AsynchronousMachineEquivalentCircuit unAssignXlr1(UUID parentId) {
    AsynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xlr1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xlr1 on the parent entithy
    // ------------------------------------------
    parentEntity.setXlr1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xlr2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	AsynchronousMachineEquivalentCircuit
   */
  public AsynchronousMachineEquivalentCircuit assignXlr2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xlr2 as " + assignment.toString());

    AsynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xlr2 to the parent entity
    // ------------------------------------------
    parentEntity.setXlr2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xlr2
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachineEquivalentCircuit
   */
  public AsynchronousMachineEquivalentCircuit unAssignXlr2(UUID parentId) {
    AsynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xlr2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xlr2 on the parent entithy
    // ------------------------------------------
    parentEntity.setXlr2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xm
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	AsynchronousMachineEquivalentCircuit
   */
  public AsynchronousMachineEquivalentCircuit assignXm(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xm as " + assignment.toString());

    AsynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xm to the parent entity
    // ------------------------------------------
    parentEntity.setXm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xm
   *
   * @param	parentId		UUID
   * @return	AsynchronousMachineEquivalentCircuit
   */
  public AsynchronousMachineEquivalentCircuit unAssignXm(UUID parentId) {
    AsynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xm on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xm on the parent entithy
    // ------------------------------------------
    parentEntity.setXm(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the AsynchronousMachineEquivalentCircuit via an
   * FindAsynchronousMachineEquivalentCircuitQuery
   *
   * @return query FindAsynchronousMachineEquivalentCircuitQuery
   */
  @SuppressWarnings("unused")
  public AsynchronousMachineEquivalentCircuit find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find a AsynchronousMachineEquivalentCircuit - {0}",
          exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all AsynchronousMachineEquivalentCircuits
   *
   * @param query FindAllAsynchronousMachineEquivalentCircuitQuery
   * @return List<AsynchronousMachineEquivalentCircuit>
   */
  @SuppressWarnings("unused")
  public List<AsynchronousMachineEquivalentCircuit> findAll(
      FindAllAsynchronousMachineEquivalentCircuitQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find all AsynchronousMachineEquivalentCircuit - {0}",
          exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final AsynchronousMachineEquivalentCircuitRepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineEquivalentCircuitEntityProjector.class.getName());
}
