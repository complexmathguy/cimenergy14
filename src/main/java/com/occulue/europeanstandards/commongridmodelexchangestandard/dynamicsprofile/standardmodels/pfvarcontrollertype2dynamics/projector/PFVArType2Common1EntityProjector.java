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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for PFVArType2Common1 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PFVArType2Common1Aggregate
 *
 * @author your_name_here
 */
@Component("pFVArType2Common1-entity-projector")
public class PFVArType2Common1EntityProjector {

  // core constructor
  public PFVArType2Common1EntityProjector(PFVArType2Common1Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PFVArType2Common1
   *
   * @param	entity PFVArType2Common1
   */
  public PFVArType2Common1 create(PFVArType2Common1 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PFVArType2Common1
   *
   * @param	entity PFVArType2Common1
   */
  public PFVArType2Common1 update(PFVArType2Common1 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PFVArType2Common1
   *
   * @param	id		UUID
   */
  public PFVArType2Common1 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PFVArType2Common1 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a J
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	PFVArType2Common1
   */
  public PFVArType2Common1 assignJ(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning J as " + assignment.toString());

    PFVArType2Common1 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the J to the parent entity
    // ------------------------------------------
    parentEntity.setJ(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the J
   *
   * @param	parentId		UUID
   * @return	PFVArType2Common1
   */
  public PFVArType2Common1 unAssignJ(UUID parentId) {
    PFVArType2Common1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning J on " + parentEntity.toString());

    // ------------------------------------------
    // null out the J on the parent entithy
    // ------------------------------------------
    parentEntity.setJ(null);

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
   * @return	PFVArType2Common1
   */
  public PFVArType2Common1 assignKi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    PFVArType2Common1 parentEntity = repository.findById(parentId).get();
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
   * @return	PFVArType2Common1
   */
  public PFVArType2Common1 unAssignKi(UUID parentId) {
    PFVArType2Common1 parentEntity = repository.findById(parentId).get();

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
   * @return	PFVArType2Common1
   */
  public PFVArType2Common1 assignKp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kp as " + assignment.toString());

    PFVArType2Common1 parentEntity = repository.findById(parentId).get();
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
   * @return	PFVArType2Common1
   */
  public PFVArType2Common1 unAssignKp(UUID parentId) {
    PFVArType2Common1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Max
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PFVArType2Common1
   */
  public PFVArType2Common1 assignMax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Max as " + assignment.toString());

    PFVArType2Common1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Max to the parent entity
    // ------------------------------------------
    parentEntity.setMax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Max
   *
   * @param	parentId		UUID
   * @return	PFVArType2Common1
   */
  public PFVArType2Common1 unAssignMax(UUID parentId) {
    PFVArType2Common1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Max on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Max on the parent entithy
    // ------------------------------------------
    parentEntity.setMax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ref
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PFVArType2Common1
   */
  public PFVArType2Common1 assignRef(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ref as " + assignment.toString());

    PFVArType2Common1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ref to the parent entity
    // ------------------------------------------
    parentEntity.setRef(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ref
   *
   * @param	parentId		UUID
   * @return	PFVArType2Common1
   */
  public PFVArType2Common1 unAssignRef(UUID parentId) {
    PFVArType2Common1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ref on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ref on the parent entithy
    // ------------------------------------------
    parentEntity.setRef(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PFVArType2Common1 via an FindPFVArType2Common1Query
   *
   * @return query FindPFVArType2Common1Query
   */
  @SuppressWarnings("unused")
  public PFVArType2Common1 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PFVArType2Common1 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PFVArType2Common1s
   *
   * @param query FindAllPFVArType2Common1Query
   * @return List<PFVArType2Common1>
   */
  @SuppressWarnings("unused")
  public List<PFVArType2Common1> findAll(FindAllPFVArType2Common1Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PFVArType2Common1 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PFVArType2Common1Repository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  private static final Logger LOGGER =
      Logger.getLogger(PFVArType2Common1EntityProjector.class.getName());
}
