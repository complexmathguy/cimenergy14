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
 * Projector for UnderexcLimX1 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by UnderexcLimX1Aggregate
 *
 * @author your_name_here
 */
@Component("underexcLimX1-entity-projector")
public class UnderexcLimX1EntityProjector {

  // core constructor
  public UnderexcLimX1EntityProjector(UnderexcLimX1Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a UnderexcLimX1
   *
   * @param	entity UnderexcLimX1
   */
  public UnderexcLimX1 create(UnderexcLimX1 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a UnderexcLimX1
   *
   * @param	entity UnderexcLimX1
   */
  public UnderexcLimX1 update(UnderexcLimX1 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a UnderexcLimX1
   *
   * @param	id		UUID
   */
  public UnderexcLimX1 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    UnderexcLimX1 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a K
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimX1
   */
  public UnderexcLimX1 assignK(UUID parentId, PU assignment) {
    LOGGER.info("assigning K as " + assignment.toString());

    UnderexcLimX1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the K to the parent entity
    // ------------------------------------------
    parentEntity.setK(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K
   *
   * @param	parentId		UUID
   * @return	UnderexcLimX1
   */
  public UnderexcLimX1 unAssignK(UUID parentId) {
    UnderexcLimX1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K on the parent entithy
    // ------------------------------------------
    parentEntity.setK(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kf2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimX1
   */
  public UnderexcLimX1 assignKf2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf2 as " + assignment.toString());

    UnderexcLimX1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kf2 to the parent entity
    // ------------------------------------------
    parentEntity.setKf2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kf2
   *
   * @param	parentId		UUID
   * @return	UnderexcLimX1
   */
  public UnderexcLimX1 unAssignKf2(UUID parentId) {
    UnderexcLimX1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kf2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kf2 on the parent entithy
    // ------------------------------------------
    parentEntity.setKf2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Km
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimX1
   */
  public UnderexcLimX1 assignKm(UUID parentId, PU assignment) {
    LOGGER.info("assigning Km as " + assignment.toString());

    UnderexcLimX1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Km to the parent entity
    // ------------------------------------------
    parentEntity.setKm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Km
   *
   * @param	parentId		UUID
   * @return	UnderexcLimX1
   */
  public UnderexcLimX1 unAssignKm(UUID parentId) {
    UnderexcLimX1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Km on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Km on the parent entithy
    // ------------------------------------------
    parentEntity.setKm(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Melmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimX1
   */
  public UnderexcLimX1 assignMelmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Melmax as " + assignment.toString());

    UnderexcLimX1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Melmax to the parent entity
    // ------------------------------------------
    parentEntity.setMelmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Melmax
   *
   * @param	parentId		UUID
   * @return	UnderexcLimX1
   */
  public UnderexcLimX1 unAssignMelmax(UUID parentId) {
    UnderexcLimX1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Melmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Melmax on the parent entithy
    // ------------------------------------------
    parentEntity.setMelmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tf2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	UnderexcLimX1
   */
  public UnderexcLimX1 assignTf2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf2 as " + assignment.toString());

    UnderexcLimX1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tf2 to the parent entity
    // ------------------------------------------
    parentEntity.setTf2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tf2
   *
   * @param	parentId		UUID
   * @return	UnderexcLimX1
   */
  public UnderexcLimX1 unAssignTf2(UUID parentId) {
    UnderexcLimX1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tf2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tf2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTf2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tm
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	UnderexcLimX1
   */
  public UnderexcLimX1 assignTm(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tm as " + assignment.toString());

    UnderexcLimX1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tm to the parent entity
    // ------------------------------------------
    parentEntity.setTm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tm
   *
   * @param	parentId		UUID
   * @return	UnderexcLimX1
   */
  public UnderexcLimX1 unAssignTm(UUID parentId) {
    UnderexcLimX1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tm on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tm on the parent entithy
    // ------------------------------------------
    parentEntity.setTm(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the UnderexcLimX1 via an FindUnderexcLimX1Query
   *
   * @return query FindUnderexcLimX1Query
   */
  @SuppressWarnings("unused")
  public UnderexcLimX1 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a UnderexcLimX1 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all UnderexcLimX1s
   *
   * @param query FindAllUnderexcLimX1Query
   * @return List<UnderexcLimX1>
   */
  @SuppressWarnings("unused")
  public List<UnderexcLimX1> findAll(FindAllUnderexcLimX1Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all UnderexcLimX1 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final UnderexcLimX1Repository repository;

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
      Logger.getLogger(UnderexcLimX1EntityProjector.class.getName());
}
