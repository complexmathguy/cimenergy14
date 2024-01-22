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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for TurbLCFB1 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by TurbLCFB1Aggregate
 *
 * @author your_name_here
 */
@Component("turbLCFB1-entity-projector")
public class TurbLCFB1EntityProjector {

  // core constructor
  public TurbLCFB1EntityProjector(TurbLCFB1Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a TurbLCFB1
   *
   * @param	entity TurbLCFB1
   */
  public TurbLCFB1 create(TurbLCFB1 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a TurbLCFB1
   *
   * @param	entity TurbLCFB1
   */
  public TurbLCFB1 update(TurbLCFB1 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a TurbLCFB1
   *
   * @param	id		UUID
   */
  public TurbLCFB1 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    TurbLCFB1 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Db
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	TurbLCFB1
   */
  public TurbLCFB1 assignDb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Db as " + assignment.toString());

    TurbLCFB1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Db to the parent entity
    // ------------------------------------------
    parentEntity.setDb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Db
   *
   * @param	parentId		UUID
   * @return	TurbLCFB1
   */
  public TurbLCFB1 unAssignDb(UUID parentId) {
    TurbLCFB1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Db on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Db on the parent entithy
    // ------------------------------------------
    parentEntity.setDb(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Emax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	TurbLCFB1
   */
  public TurbLCFB1 assignEmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Emax as " + assignment.toString());

    TurbLCFB1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Emax to the parent entity
    // ------------------------------------------
    parentEntity.setEmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Emax
   *
   * @param	parentId		UUID
   * @return	TurbLCFB1
   */
  public TurbLCFB1 unAssignEmax(UUID parentId) {
    TurbLCFB1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Emax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Emax on the parent entithy
    // ------------------------------------------
    parentEntity.setEmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fb
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	TurbLCFB1
   */
  public TurbLCFB1 assignFb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fb as " + assignment.toString());

    TurbLCFB1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fb to the parent entity
    // ------------------------------------------
    parentEntity.setFb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fb
   *
   * @param	parentId		UUID
   * @return	TurbLCFB1
   */
  public TurbLCFB1 unAssignFb(UUID parentId) {
    TurbLCFB1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fb on the parent entithy
    // ------------------------------------------
    parentEntity.setFb(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fbf
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	TurbLCFB1
   */
  public TurbLCFB1 assignFbf(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Fbf as " + assignment.toString());

    TurbLCFB1 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Fbf to the parent entity
    // ------------------------------------------
    parentEntity.setFbf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fbf
   *
   * @param	parentId		UUID
   * @return	TurbLCFB1
   */
  public TurbLCFB1 unAssignFbf(UUID parentId) {
    TurbLCFB1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fbf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fbf on the parent entithy
    // ------------------------------------------
    parentEntity.setFbf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Irmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	TurbLCFB1
   */
  public TurbLCFB1 assignIrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Irmax as " + assignment.toString());

    TurbLCFB1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Irmax to the parent entity
    // ------------------------------------------
    parentEntity.setIrmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Irmax
   *
   * @param	parentId		UUID
   * @return	TurbLCFB1
   */
  public TurbLCFB1 unAssignIrmax(UUID parentId) {
    TurbLCFB1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Irmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Irmax on the parent entithy
    // ------------------------------------------
    parentEntity.setIrmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ki
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	TurbLCFB1
   */
  public TurbLCFB1 assignKi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    TurbLCFB1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ki to the parent entity
    // ------------------------------------------
    parentEntity.setKi(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ki
   *
   * @param	parentId		UUID
   * @return	TurbLCFB1
   */
  public TurbLCFB1 unAssignKi(UUID parentId) {
    TurbLCFB1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ki on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ki on the parent entithy
    // ------------------------------------------
    parentEntity.setKi(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	TurbLCFB1
   */
  public TurbLCFB1 assignKp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kp as " + assignment.toString());

    TurbLCFB1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kp to the parent entity
    // ------------------------------------------
    parentEntity.setKp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kp
   *
   * @param	parentId		UUID
   * @return	TurbLCFB1
   */
  public TurbLCFB1 unAssignKp(UUID parentId) {
    TurbLCFB1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kp on the parent entithy
    // ------------------------------------------
    parentEntity.setKp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mwbase
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	TurbLCFB1
   */
  public TurbLCFB1 assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    TurbLCFB1 parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the Mwbase to the parent entity
    // ------------------------------------------
    parentEntity.setMwbase(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mwbase
   *
   * @param	parentId		UUID
   * @return	TurbLCFB1
   */
  public TurbLCFB1 unAssignMwbase(UUID parentId) {
    TurbLCFB1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mwbase on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mwbase on the parent entithy
    // ------------------------------------------
    parentEntity.setMwbase(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pbf
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	TurbLCFB1
   */
  public TurbLCFB1 assignPbf(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Pbf as " + assignment.toString());

    TurbLCFB1 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Pbf to the parent entity
    // ------------------------------------------
    parentEntity.setPbf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pbf
   *
   * @param	parentId		UUID
   * @return	TurbLCFB1
   */
  public TurbLCFB1 unAssignPbf(UUID parentId) {
    TurbLCFB1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pbf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pbf on the parent entithy
    // ------------------------------------------
    parentEntity.setPbf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmwset
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	TurbLCFB1
   */
  public TurbLCFB1 assignPmwset(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Pmwset as " + assignment.toString());

    TurbLCFB1 parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the Pmwset to the parent entity
    // ------------------------------------------
    parentEntity.setPmwset(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmwset
   *
   * @param	parentId		UUID
   * @return	TurbLCFB1
   */
  public TurbLCFB1 unAssignPmwset(UUID parentId) {
    TurbLCFB1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmwset on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmwset on the parent entithy
    // ------------------------------------------
    parentEntity.setPmwset(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SpeedReferenceGovernor
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	TurbLCFB1
   */
  public TurbLCFB1 assignSpeedReferenceGovernor(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning SpeedReferenceGovernor as " + assignment.toString());

    TurbLCFB1 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the SpeedReferenceGovernor to the parent entity
    // ------------------------------------------
    parentEntity.setSpeedReferenceGovernor(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SpeedReferenceGovernor
   *
   * @param	parentId		UUID
   * @return	TurbLCFB1
   */
  public TurbLCFB1 unAssignSpeedReferenceGovernor(UUID parentId) {
    TurbLCFB1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SpeedReferenceGovernor on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SpeedReferenceGovernor on the parent entithy
    // ------------------------------------------
    parentEntity.setSpeedReferenceGovernor(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpelec
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	TurbLCFB1
   */
  public TurbLCFB1 assignTpelec(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpelec as " + assignment.toString());

    TurbLCFB1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpelec to the parent entity
    // ------------------------------------------
    parentEntity.setTpelec(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpelec
   *
   * @param	parentId		UUID
   * @return	TurbLCFB1
   */
  public TurbLCFB1 unAssignTpelec(UUID parentId) {
    TurbLCFB1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpelec on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpelec on the parent entithy
    // ------------------------------------------
    parentEntity.setTpelec(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the TurbLCFB1 via an FindTurbLCFB1Query
   *
   * @return query FindTurbLCFB1Query
   */
  @SuppressWarnings("unused")
  public TurbLCFB1 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a TurbLCFB1 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all TurbLCFB1s
   *
   * @param query FindAllTurbLCFB1Query
   * @return List<TurbLCFB1>
   */
  @SuppressWarnings("unused")
  public List<TurbLCFB1> findAll(FindAllTurbLCFB1Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all TurbLCFB1 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final TurbLCFB1Repository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "activePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ActivePowerEntityProjector
      ActivePowerProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(TurbLCFB1EntityProjector.class.getName());
}
