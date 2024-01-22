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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for VCompIEEEType1 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by VCompIEEEType1Aggregate
 *
 * @author your_name_here
 */
@Component("vCompIEEEType1-entity-projector")
public class VCompIEEEType1EntityProjector {

  // core constructor
  public VCompIEEEType1EntityProjector(VCompIEEEType1Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a VCompIEEEType1
   *
   * @param	entity VCompIEEEType1
   */
  public VCompIEEEType1 create(VCompIEEEType1 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a VCompIEEEType1
   *
   * @param	entity VCompIEEEType1
   */
  public VCompIEEEType1 update(VCompIEEEType1 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a VCompIEEEType1
   *
   * @param	id		UUID
   */
  public VCompIEEEType1 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    VCompIEEEType1 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Rc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	VCompIEEEType1
   */
  public VCompIEEEType1 assignRc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rc as " + assignment.toString());

    VCompIEEEType1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rc to the parent entity
    // ------------------------------------------
    parentEntity.setRc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rc
   *
   * @param	parentId		UUID
   * @return	VCompIEEEType1
   */
  public VCompIEEEType1 unAssignRc(UUID parentId) {
    VCompIEEEType1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rc on the parent entithy
    // ------------------------------------------
    parentEntity.setRc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tr
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	VCompIEEEType1
   */
  public VCompIEEEType1 assignTr(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tr as " + assignment.toString());

    VCompIEEEType1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tr to the parent entity
    // ------------------------------------------
    parentEntity.setTr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tr
   *
   * @param	parentId		UUID
   * @return	VCompIEEEType1
   */
  public VCompIEEEType1 unAssignTr(UUID parentId) {
    VCompIEEEType1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tr on the parent entithy
    // ------------------------------------------
    parentEntity.setTr(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	VCompIEEEType1
   */
  public VCompIEEEType1 assignXc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xc as " + assignment.toString());

    VCompIEEEType1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xc to the parent entity
    // ------------------------------------------
    parentEntity.setXc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xc
   *
   * @param	parentId		UUID
   * @return	VCompIEEEType1
   */
  public VCompIEEEType1 unAssignXc(UUID parentId) {
    VCompIEEEType1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xc on the parent entithy
    // ------------------------------------------
    parentEntity.setXc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the VCompIEEEType1 via an FindVCompIEEEType1Query
   *
   * @return query FindVCompIEEEType1Query
   */
  @SuppressWarnings("unused")
  public VCompIEEEType1 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a VCompIEEEType1 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all VCompIEEEType1s
   *
   * @param query FindAllVCompIEEEType1Query
   * @return List<VCompIEEEType1>
   */
  @SuppressWarnings("unused")
  public List<VCompIEEEType1> findAll(FindAllVCompIEEEType1Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all VCompIEEEType1 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final VCompIEEEType1Repository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(VCompIEEEType1EntityProjector.class.getName());
}
