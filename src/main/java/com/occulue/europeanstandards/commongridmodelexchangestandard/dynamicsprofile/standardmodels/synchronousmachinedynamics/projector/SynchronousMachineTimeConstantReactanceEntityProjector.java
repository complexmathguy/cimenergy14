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
 * Projector for SynchronousMachineTimeConstantReactance as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SynchronousMachineTimeConstantReactanceAggregate
 *
 * @author your_name_here
 */
@Component("synchronousMachineTimeConstantReactance-entity-projector")
public class SynchronousMachineTimeConstantReactanceEntityProjector {

  // core constructor
  public SynchronousMachineTimeConstantReactanceEntityProjector(
      SynchronousMachineTimeConstantReactanceRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a SynchronousMachineTimeConstantReactance
   *
   * @param	entity SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance create(
      SynchronousMachineTimeConstantReactance entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a SynchronousMachineTimeConstantReactance
   *
   * @param	entity SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance update(
      SynchronousMachineTimeConstantReactance entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a SynchronousMachineTimeConstantReactance
   *
   * @param	id		UUID
   */
  public SynchronousMachineTimeConstantReactance delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    SynchronousMachineTimeConstantReactance entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Ks
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance assignKs(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ks as " + assignment.toString());

    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Ks to the parent entity
    // ------------------------------------------
    parentEntity.setKs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ks
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance unAssignKs(UUID parentId) {
    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ks on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ks on the parent entithy
    // ------------------------------------------
    parentEntity.setKs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tc
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tc to the parent entity
    // ------------------------------------------
    parentEntity.setTc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tc
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance unAssignTc(UUID parentId) {
    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tc on the parent entithy
    // ------------------------------------------
    parentEntity.setTc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpdo
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance assignTpdo(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpdo as " + assignment.toString());

    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpdo to the parent entity
    // ------------------------------------------
    parentEntity.setTpdo(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpdo
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance unAssignTpdo(UUID parentId) {
    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpdo on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpdo on the parent entithy
    // ------------------------------------------
    parentEntity.setTpdo(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tppdo
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance assignTppdo(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tppdo as " + assignment.toString());

    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tppdo to the parent entity
    // ------------------------------------------
    parentEntity.setTppdo(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tppdo
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance unAssignTppdo(UUID parentId) {
    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tppdo on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tppdo on the parent entithy
    // ------------------------------------------
    parentEntity.setTppdo(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tppqo
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance assignTppqo(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tppqo as " + assignment.toString());

    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tppqo to the parent entity
    // ------------------------------------------
    parentEntity.setTppqo(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tppqo
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance unAssignTppqo(UUID parentId) {
    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tppqo on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tppqo on the parent entithy
    // ------------------------------------------
    parentEntity.setTppqo(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpqo
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance assignTpqo(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpqo as " + assignment.toString());

    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpqo to the parent entity
    // ------------------------------------------
    parentEntity.setTpqo(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpqo
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance unAssignTpqo(UUID parentId) {
    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpqo on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpqo on the parent entithy
    // ------------------------------------------
    parentEntity.setTpqo(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a XDirectSubtrans
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance assignXDirectSubtrans(
      UUID parentId, PU assignment) {
    LOGGER.info("assigning XDirectSubtrans as " + assignment.toString());

    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the XDirectSubtrans to the parent entity
    // ------------------------------------------
    parentEntity.setXDirectSubtrans(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the XDirectSubtrans
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance unAssignXDirectSubtrans(UUID parentId) {
    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning XDirectSubtrans on " + parentEntity.toString());

    // ------------------------------------------
    // null out the XDirectSubtrans on the parent entithy
    // ------------------------------------------
    parentEntity.setXDirectSubtrans(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a XDirectSync
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance assignXDirectSync(UUID parentId, PU assignment) {
    LOGGER.info("assigning XDirectSync as " + assignment.toString());

    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the XDirectSync to the parent entity
    // ------------------------------------------
    parentEntity.setXDirectSync(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the XDirectSync
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance unAssignXDirectSync(UUID parentId) {
    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning XDirectSync on " + parentEntity.toString());

    // ------------------------------------------
    // null out the XDirectSync on the parent entithy
    // ------------------------------------------
    parentEntity.setXDirectSync(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a XDirectTrans
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance assignXDirectTrans(UUID parentId, PU assignment) {
    LOGGER.info("assigning XDirectTrans as " + assignment.toString());

    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the XDirectTrans to the parent entity
    // ------------------------------------------
    parentEntity.setXDirectTrans(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the XDirectTrans
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance unAssignXDirectTrans(UUID parentId) {
    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning XDirectTrans on " + parentEntity.toString());

    // ------------------------------------------
    // null out the XDirectTrans on the parent entithy
    // ------------------------------------------
    parentEntity.setXDirectTrans(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a XQuadSubtrans
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance assignXQuadSubtrans(UUID parentId, PU assignment) {
    LOGGER.info("assigning XQuadSubtrans as " + assignment.toString());

    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the XQuadSubtrans to the parent entity
    // ------------------------------------------
    parentEntity.setXQuadSubtrans(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the XQuadSubtrans
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance unAssignXQuadSubtrans(UUID parentId) {
    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning XQuadSubtrans on " + parentEntity.toString());

    // ------------------------------------------
    // null out the XQuadSubtrans on the parent entithy
    // ------------------------------------------
    parentEntity.setXQuadSubtrans(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a XQuadSync
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance assignXQuadSync(UUID parentId, PU assignment) {
    LOGGER.info("assigning XQuadSync as " + assignment.toString());

    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the XQuadSync to the parent entity
    // ------------------------------------------
    parentEntity.setXQuadSync(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the XQuadSync
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance unAssignXQuadSync(UUID parentId) {
    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning XQuadSync on " + parentEntity.toString());

    // ------------------------------------------
    // null out the XQuadSync on the parent entithy
    // ------------------------------------------
    parentEntity.setXQuadSync(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a XQuadTrans
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance assignXQuadTrans(UUID parentId, PU assignment) {
    LOGGER.info("assigning XQuadTrans as " + assignment.toString());

    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the XQuadTrans to the parent entity
    // ------------------------------------------
    parentEntity.setXQuadTrans(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the XQuadTrans
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineTimeConstantReactance
   */
  public SynchronousMachineTimeConstantReactance unAssignXQuadTrans(UUID parentId) {
    SynchronousMachineTimeConstantReactance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning XQuadTrans on " + parentEntity.toString());

    // ------------------------------------------
    // null out the XQuadTrans on the parent entithy
    // ------------------------------------------
    parentEntity.setXQuadTrans(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the SynchronousMachineTimeConstantReactance via an
   * FindSynchronousMachineTimeConstantReactanceQuery
   *
   * @return query FindSynchronousMachineTimeConstantReactanceQuery
   */
  @SuppressWarnings("unused")
  public SynchronousMachineTimeConstantReactance find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find a SynchronousMachineTimeConstantReactance - {0}",
          exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all SynchronousMachineTimeConstantReactances
   *
   * @param query FindAllSynchronousMachineTimeConstantReactanceQuery
   * @return List<SynchronousMachineTimeConstantReactance>
   */
  @SuppressWarnings("unused")
  public List<SynchronousMachineTimeConstantReactance> findAll(
      FindAllSynchronousMachineTimeConstantReactanceQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find all SynchronousMachineTimeConstantReactance - {0}",
          exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SynchronousMachineTimeConstantReactanceRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

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
      Logger.getLogger(SynchronousMachineTimeConstantReactanceEntityProjector.class.getName());
}
