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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcIEEEST7B as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcIEEEST7BAggregate
 *
 * @author your_name_here
 */
@Component("excIEEEST7B-entity-projector")
public class ExcIEEEST7BEntityProjector {

  // core constructor
  public ExcIEEEST7BEntityProjector(ExcIEEEST7BRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcIEEEST7B
   *
   * @param	entity ExcIEEEST7B
   */
  public ExcIEEEST7B create(ExcIEEEST7B entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcIEEEST7B
   *
   * @param	entity ExcIEEEST7B
   */
  public ExcIEEEST7B update(ExcIEEEST7B entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcIEEEST7B
   *
   * @param	id		UUID
   */
  public ExcIEEEST7B delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcIEEEST7B entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Kh
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B assignKh(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kh as " + assignment.toString());

    ExcIEEEST7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kh to the parent entity
    // ------------------------------------------
    parentEntity.setKh(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kh
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B unAssignKh(UUID parentId) {
    ExcIEEEST7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kh on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kh on the parent entithy
    // ------------------------------------------
    parentEntity.setKh(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kia
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B assignKia(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kia as " + assignment.toString());

    ExcIEEEST7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kia to the parent entity
    // ------------------------------------------
    parentEntity.setKia(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kia
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B unAssignKia(UUID parentId) {
    ExcIEEEST7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kia on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kia on the parent entithy
    // ------------------------------------------
    parentEntity.setKia(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kl
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B assignKl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kl as " + assignment.toString());

    ExcIEEEST7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kl to the parent entity
    // ------------------------------------------
    parentEntity.setKl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kl
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B unAssignKl(UUID parentId) {
    ExcIEEEST7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kl on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kl on the parent entithy
    // ------------------------------------------
    parentEntity.setKl(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpa
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B assignKpa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpa as " + assignment.toString());

    ExcIEEEST7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpa to the parent entity
    // ------------------------------------------
    parentEntity.setKpa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpa
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B unAssignKpa(UUID parentId) {
    ExcIEEEST7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpa on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpa on the parent entithy
    // ------------------------------------------
    parentEntity.setKpa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tb
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    ExcIEEEST7B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tb to the parent entity
    // ------------------------------------------
    parentEntity.setTb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tb
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B unAssignTb(UUID parentId) {
    ExcIEEEST7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tb on the parent entithy
    // ------------------------------------------
    parentEntity.setTb(null);

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
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    ExcIEEEST7B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B unAssignTc(UUID parentId) {
    ExcIEEEST7B parentEntity = repository.findById(parentId).get();

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
   * Assign a Tf
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    ExcIEEEST7B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tf to the parent entity
    // ------------------------------------------
    parentEntity.setTf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tf
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B unAssignTf(UUID parentId) {
    ExcIEEEST7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tf on the parent entithy
    // ------------------------------------------
    parentEntity.setTf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tg
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B assignTg(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tg as " + assignment.toString());

    ExcIEEEST7B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tg to the parent entity
    // ------------------------------------------
    parentEntity.setTg(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tg
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B unAssignTg(UUID parentId) {
    ExcIEEEST7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tg on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tg on the parent entithy
    // ------------------------------------------
    parentEntity.setTg(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tia
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B assignTia(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tia as " + assignment.toString());

    ExcIEEEST7B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tia to the parent entity
    // ------------------------------------------
    parentEntity.setTia(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tia
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B unAssignTia(UUID parentId) {
    ExcIEEEST7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tia on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tia on the parent entithy
    // ------------------------------------------
    parentEntity.setTia(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B assignVmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmax as " + assignment.toString());

    ExcIEEEST7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vmax to the parent entity
    // ------------------------------------------
    parentEntity.setVmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vmax
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B unAssignVmax(UUID parentId) {
    ExcIEEEST7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B assignVmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmin as " + assignment.toString());

    ExcIEEEST7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vmin to the parent entity
    // ------------------------------------------
    parentEntity.setVmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vmin
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B unAssignVmin(UUID parentId) {
    ExcIEEEST7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vrmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcIEEEST7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vrmax to the parent entity
    // ------------------------------------------
    parentEntity.setVrmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vrmax
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B unAssignVrmax(UUID parentId) {
    ExcIEEEST7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vrmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vrmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVrmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vrmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcIEEEST7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vrmin to the parent entity
    // ------------------------------------------
    parentEntity.setVrmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vrmin
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST7B
   */
  public ExcIEEEST7B unAssignVrmin(UUID parentId) {
    ExcIEEEST7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vrmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vrmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVrmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExcIEEEST7B via an FindExcIEEEST7BQuery
   *
   * @return query FindExcIEEEST7BQuery
   */
  @SuppressWarnings("unused")
  public ExcIEEEST7B find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcIEEEST7B - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEST7Bs
   *
   * @param query FindAllExcIEEEST7BQuery
   * @return List<ExcIEEEST7B>
   */
  @SuppressWarnings("unused")
  public List<ExcIEEEST7B> findAll(FindAllExcIEEEST7BQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcIEEEST7B - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcIEEEST7BRepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST7BEntityProjector.class.getName());
}
