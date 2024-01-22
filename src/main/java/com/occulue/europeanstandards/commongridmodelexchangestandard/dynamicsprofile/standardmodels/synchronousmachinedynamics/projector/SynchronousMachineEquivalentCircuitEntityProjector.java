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
 * Projector for SynchronousMachineEquivalentCircuit as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SynchronousMachineEquivalentCircuitAggregate
 *
 * @author your_name_here
 */
@Component("synchronousMachineEquivalentCircuit-entity-projector")
public class SynchronousMachineEquivalentCircuitEntityProjector {

  // core constructor
  public SynchronousMachineEquivalentCircuitEntityProjector(
      SynchronousMachineEquivalentCircuitRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a SynchronousMachineEquivalentCircuit
   *
   * @param	entity SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit create(SynchronousMachineEquivalentCircuit entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a SynchronousMachineEquivalentCircuit
   *
   * @param	entity SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit update(SynchronousMachineEquivalentCircuit entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a SynchronousMachineEquivalentCircuit
   *
   * @param	id		UUID
   */
  public SynchronousMachineEquivalentCircuit delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    SynchronousMachineEquivalentCircuit entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a R1d
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit assignR1d(UUID parentId, PU assignment) {
    LOGGER.info("assigning R1d as " + assignment.toString());

    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the R1d to the parent entity
    // ------------------------------------------
    parentEntity.setR1d(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R1d
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit unAssignR1d(UUID parentId) {
    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R1d on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R1d on the parent entithy
    // ------------------------------------------
    parentEntity.setR1d(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a R1q
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit assignR1q(UUID parentId, PU assignment) {
    LOGGER.info("assigning R1q as " + assignment.toString());

    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the R1q to the parent entity
    // ------------------------------------------
    parentEntity.setR1q(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R1q
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit unAssignR1q(UUID parentId) {
    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R1q on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R1q on the parent entithy
    // ------------------------------------------
    parentEntity.setR1q(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a R2q
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit assignR2q(UUID parentId, PU assignment) {
    LOGGER.info("assigning R2q as " + assignment.toString());

    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the R2q to the parent entity
    // ------------------------------------------
    parentEntity.setR2q(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R2q
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit unAssignR2q(UUID parentId) {
    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R2q on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R2q on the parent entithy
    // ------------------------------------------
    parentEntity.setR2q(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rfd
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit assignRfd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rfd as " + assignment.toString());

    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rfd to the parent entity
    // ------------------------------------------
    parentEntity.setRfd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rfd
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit unAssignRfd(UUID parentId) {
    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rfd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rfd on the parent entithy
    // ------------------------------------------
    parentEntity.setRfd(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a X1d
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit assignX1d(UUID parentId, PU assignment) {
    LOGGER.info("assigning X1d as " + assignment.toString());

    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the X1d to the parent entity
    // ------------------------------------------
    parentEntity.setX1d(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X1d
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit unAssignX1d(UUID parentId) {
    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X1d on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X1d on the parent entithy
    // ------------------------------------------
    parentEntity.setX1d(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a X1q
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit assignX1q(UUID parentId, PU assignment) {
    LOGGER.info("assigning X1q as " + assignment.toString());

    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the X1q to the parent entity
    // ------------------------------------------
    parentEntity.setX1q(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X1q
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit unAssignX1q(UUID parentId) {
    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X1q on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X1q on the parent entithy
    // ------------------------------------------
    parentEntity.setX1q(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a X2q
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit assignX2q(UUID parentId, PU assignment) {
    LOGGER.info("assigning X2q as " + assignment.toString());

    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the X2q to the parent entity
    // ------------------------------------------
    parentEntity.setX2q(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X2q
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit unAssignX2q(UUID parentId) {
    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X2q on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X2q on the parent entithy
    // ------------------------------------------
    parentEntity.setX2q(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xad
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit assignXad(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xad as " + assignment.toString());

    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xad to the parent entity
    // ------------------------------------------
    parentEntity.setXad(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xad
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit unAssignXad(UUID parentId) {
    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xad on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xad on the parent entithy
    // ------------------------------------------
    parentEntity.setXad(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xaq
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit assignXaq(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xaq as " + assignment.toString());

    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xaq to the parent entity
    // ------------------------------------------
    parentEntity.setXaq(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xaq
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit unAssignXaq(UUID parentId) {
    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xaq on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xaq on the parent entithy
    // ------------------------------------------
    parentEntity.setXaq(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xf1d
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit assignXf1d(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xf1d as " + assignment.toString());

    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xf1d to the parent entity
    // ------------------------------------------
    parentEntity.setXf1d(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xf1d
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit unAssignXf1d(UUID parentId) {
    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xf1d on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xf1d on the parent entithy
    // ------------------------------------------
    parentEntity.setXf1d(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xfd
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit assignXfd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xfd as " + assignment.toString());

    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xfd to the parent entity
    // ------------------------------------------
    parentEntity.setXfd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xfd
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineEquivalentCircuit
   */
  public SynchronousMachineEquivalentCircuit unAssignXfd(UUID parentId) {
    SynchronousMachineEquivalentCircuit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xfd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xfd on the parent entithy
    // ------------------------------------------
    parentEntity.setXfd(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the SynchronousMachineEquivalentCircuit via an
   * FindSynchronousMachineEquivalentCircuitQuery
   *
   * @return query FindSynchronousMachineEquivalentCircuitQuery
   */
  @SuppressWarnings("unused")
  public SynchronousMachineEquivalentCircuit find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find a SynchronousMachineEquivalentCircuit - {0}",
          exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all SynchronousMachineEquivalentCircuits
   *
   * @param query FindAllSynchronousMachineEquivalentCircuitQuery
   * @return List<SynchronousMachineEquivalentCircuit>
   */
  @SuppressWarnings("unused")
  public List<SynchronousMachineEquivalentCircuit> findAll(
      FindAllSynchronousMachineEquivalentCircuitQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find all SynchronousMachineEquivalentCircuit - {0}",
          exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SynchronousMachineEquivalentCircuitRepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineEquivalentCircuitEntityProjector.class.getName());
}
