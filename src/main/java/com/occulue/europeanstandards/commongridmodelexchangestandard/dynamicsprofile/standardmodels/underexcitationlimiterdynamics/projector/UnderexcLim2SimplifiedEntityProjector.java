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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for UnderexcLim2Simplified as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by UnderexcLim2SimplifiedAggregate
 *
 * @author your_name_here
 */
@Component("underexcLim2Simplified-entity-projector")
public class UnderexcLim2SimplifiedEntityProjector {

  // core constructor
  public UnderexcLim2SimplifiedEntityProjector(UnderexcLim2SimplifiedRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a UnderexcLim2Simplified
   *
   * @param	entity UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified create(UnderexcLim2Simplified entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a UnderexcLim2Simplified
   *
   * @param	entity UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified update(UnderexcLim2Simplified entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a UnderexcLim2Simplified
   *
   * @param	id		UUID
   */
  public UnderexcLim2Simplified delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    UnderexcLim2Simplified entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Kui
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified assignKui(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kui as " + assignment.toString());

    UnderexcLim2Simplified parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kui to the parent entity
    // ------------------------------------------
    parentEntity.setKui(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kui
   *
   * @param	parentId		UUID
   * @return	UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified unAssignKui(UUID parentId) {
    UnderexcLim2Simplified parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kui on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kui on the parent entithy
    // ------------------------------------------
    parentEntity.setKui(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a P0
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified assignP0(UUID parentId, PU assignment) {
    LOGGER.info("assigning P0 as " + assignment.toString());

    UnderexcLim2Simplified parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P0 to the parent entity
    // ------------------------------------------
    parentEntity.setP0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P0
   *
   * @param	parentId		UUID
   * @return	UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified unAssignP0(UUID parentId) {
    UnderexcLim2Simplified parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P0 on the parent entithy
    // ------------------------------------------
    parentEntity.setP0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a P1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified assignP1(UUID parentId, PU assignment) {
    LOGGER.info("assigning P1 as " + assignment.toString());

    UnderexcLim2Simplified parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P1 to the parent entity
    // ------------------------------------------
    parentEntity.setP1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P1
   *
   * @param	parentId		UUID
   * @return	UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified unAssignP1(UUID parentId) {
    UnderexcLim2Simplified parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P1 on the parent entithy
    // ------------------------------------------
    parentEntity.setP1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Q0
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified assignQ0(UUID parentId, PU assignment) {
    LOGGER.info("assigning Q0 as " + assignment.toString());

    UnderexcLim2Simplified parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Q0 to the parent entity
    // ------------------------------------------
    parentEntity.setQ0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Q0
   *
   * @param	parentId		UUID
   * @return	UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified unAssignQ0(UUID parentId) {
    UnderexcLim2Simplified parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Q0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Q0 on the parent entithy
    // ------------------------------------------
    parentEntity.setQ0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Q1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified assignQ1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Q1 as " + assignment.toString());

    UnderexcLim2Simplified parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Q1 to the parent entity
    // ------------------------------------------
    parentEntity.setQ1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Q1
   *
   * @param	parentId		UUID
   * @return	UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified unAssignQ1(UUID parentId) {
    UnderexcLim2Simplified parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Q1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Q1 on the parent entithy
    // ------------------------------------------
    parentEntity.setQ1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vuimax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified assignVuimax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vuimax as " + assignment.toString());

    UnderexcLim2Simplified parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vuimax to the parent entity
    // ------------------------------------------
    parentEntity.setVuimax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vuimax
   *
   * @param	parentId		UUID
   * @return	UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified unAssignVuimax(UUID parentId) {
    UnderexcLim2Simplified parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vuimax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vuimax on the parent entithy
    // ------------------------------------------
    parentEntity.setVuimax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vuimin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified assignVuimin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vuimin as " + assignment.toString());

    UnderexcLim2Simplified parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vuimin to the parent entity
    // ------------------------------------------
    parentEntity.setVuimin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vuimin
   *
   * @param	parentId		UUID
   * @return	UnderexcLim2Simplified
   */
  public UnderexcLim2Simplified unAssignVuimin(UUID parentId) {
    UnderexcLim2Simplified parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vuimin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vuimin on the parent entithy
    // ------------------------------------------
    parentEntity.setVuimin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the UnderexcLim2Simplified via an FindUnderexcLim2SimplifiedQuery
   *
   * @return query FindUnderexcLim2SimplifiedQuery
   */
  @SuppressWarnings("unused")
  public UnderexcLim2Simplified find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a UnderexcLim2Simplified - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all UnderexcLim2Simplifieds
   *
   * @param query FindAllUnderexcLim2SimplifiedQuery
   * @return List<UnderexcLim2Simplified>
   */
  @SuppressWarnings("unused")
  public List<UnderexcLim2Simplified> findAll(FindAllUnderexcLim2SimplifiedQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all UnderexcLim2Simplified - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final UnderexcLim2SimplifiedRepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  private static final Logger LOGGER =
      Logger.getLogger(UnderexcLim2SimplifiedEntityProjector.class.getName());
}
