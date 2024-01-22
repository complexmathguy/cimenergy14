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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for OverexcLim2 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by OverexcLim2Aggregate
 *
 * @author your_name_here
 */
@Component("overexcLim2-entity-projector")
public class OverexcLim2EntityProjector {

  // core constructor
  public OverexcLim2EntityProjector(OverexcLim2Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a OverexcLim2
   *
   * @param	entity OverexcLim2
   */
  public OverexcLim2 create(OverexcLim2 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a OverexcLim2
   *
   * @param	entity OverexcLim2
   */
  public OverexcLim2 update(OverexcLim2 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a OverexcLim2
   *
   * @param	id		UUID
   */
  public OverexcLim2 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    OverexcLim2 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Ifdlim
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLim2
   */
  public OverexcLim2 assignIfdlim(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ifdlim as " + assignment.toString());

    OverexcLim2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ifdlim to the parent entity
    // ------------------------------------------
    parentEntity.setIfdlim(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ifdlim
   *
   * @param	parentId		UUID
   * @return	OverexcLim2
   */
  public OverexcLim2 unAssignIfdlim(UUID parentId) {
    OverexcLim2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ifdlim on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ifdlim on the parent entithy
    // ------------------------------------------
    parentEntity.setIfdlim(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Koi
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLim2
   */
  public OverexcLim2 assignKoi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Koi as " + assignment.toString());

    OverexcLim2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Koi to the parent entity
    // ------------------------------------------
    parentEntity.setKoi(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Koi
   *
   * @param	parentId		UUID
   * @return	OverexcLim2
   */
  public OverexcLim2 unAssignKoi(UUID parentId) {
    OverexcLim2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Koi on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Koi on the parent entithy
    // ------------------------------------------
    parentEntity.setKoi(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Voimax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLim2
   */
  public OverexcLim2 assignVoimax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Voimax as " + assignment.toString());

    OverexcLim2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Voimax to the parent entity
    // ------------------------------------------
    parentEntity.setVoimax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Voimax
   *
   * @param	parentId		UUID
   * @return	OverexcLim2
   */
  public OverexcLim2 unAssignVoimax(UUID parentId) {
    OverexcLim2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Voimax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Voimax on the parent entithy
    // ------------------------------------------
    parentEntity.setVoimax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Voimin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLim2
   */
  public OverexcLim2 assignVoimin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Voimin as " + assignment.toString());

    OverexcLim2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Voimin to the parent entity
    // ------------------------------------------
    parentEntity.setVoimin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Voimin
   *
   * @param	parentId		UUID
   * @return	OverexcLim2
   */
  public OverexcLim2 unAssignVoimin(UUID parentId) {
    OverexcLim2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Voimin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Voimin on the parent entithy
    // ------------------------------------------
    parentEntity.setVoimin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the OverexcLim2 via an FindOverexcLim2Query
   *
   * @return query FindOverexcLim2Query
   */
  @SuppressWarnings("unused")
  public OverexcLim2 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a OverexcLim2 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all OverexcLim2s
   *
   * @param query FindAllOverexcLim2Query
   * @return List<OverexcLim2>
   */
  @SuppressWarnings("unused")
  public List<OverexcLim2> findAll(FindAllOverexcLim2Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all OverexcLim2 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final OverexcLim2Repository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  private static final Logger LOGGER = Logger.getLogger(OverexcLim2EntityProjector.class.getName());
}
