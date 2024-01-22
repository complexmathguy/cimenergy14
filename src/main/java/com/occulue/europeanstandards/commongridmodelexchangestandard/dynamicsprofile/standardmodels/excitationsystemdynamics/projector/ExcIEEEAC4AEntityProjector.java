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
 * Projector for ExcIEEEAC4A as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcIEEEAC4AAggregate
 *
 * @author your_name_here
 */
@Component("excIEEEAC4A-entity-projector")
public class ExcIEEEAC4AEntityProjector {

  // core constructor
  public ExcIEEEAC4AEntityProjector(ExcIEEEAC4ARepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcIEEEAC4A
   *
   * @param	entity ExcIEEEAC4A
   */
  public ExcIEEEAC4A create(ExcIEEEAC4A entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcIEEEAC4A
   *
   * @param	entity ExcIEEEAC4A
   */
  public ExcIEEEAC4A update(ExcIEEEAC4A entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcIEEEAC4A
   *
   * @param	id		UUID
   */
  public ExcIEEEAC4A delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcIEEEAC4A entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Ka
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A assignKa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ka to the parent entity
    // ------------------------------------------
    parentEntity.setKa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ka
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A unAssignKa(UUID parentId) {
    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ka on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ka on the parent entithy
    // ------------------------------------------
    parentEntity.setKa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A assignKc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kc as " + assignment.toString());

    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kc to the parent entity
    // ------------------------------------------
    parentEntity.setKc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kc
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A unAssignKc(UUID parentId) {
    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kc on the parent entithy
    // ------------------------------------------
    parentEntity.setKc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ta
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ta to the parent entity
    // ------------------------------------------
    parentEntity.setTa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ta
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A unAssignTa(UUID parentId) {
    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ta on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ta on the parent entithy
    // ------------------------------------------
    parentEntity.setTa(null);

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
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A unAssignTb(UUID parentId) {
    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A unAssignTc(UUID parentId) {
    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();

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
   * Assign a Vimax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A assignVimax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vimax as " + assignment.toString());

    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vimax to the parent entity
    // ------------------------------------------
    parentEntity.setVimax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vimax
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A unAssignVimax(UUID parentId) {
    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vimax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vimax on the parent entithy
    // ------------------------------------------
    parentEntity.setVimax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vimin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A assignVimin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vimin as " + assignment.toString());

    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vimin to the parent entity
    // ------------------------------------------
    parentEntity.setVimin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vimin
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A unAssignVimin(UUID parentId) {
    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vimin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vimin on the parent entithy
    // ------------------------------------------
    parentEntity.setVimin(null);

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
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A unAssignVrmax(UUID parentId) {
    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC4A
   */
  public ExcIEEEAC4A unAssignVrmin(UUID parentId) {
    ExcIEEEAC4A parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the ExcIEEEAC4A via an FindExcIEEEAC4AQuery
   *
   * @return query FindExcIEEEAC4AQuery
   */
  @SuppressWarnings("unused")
  public ExcIEEEAC4A find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcIEEEAC4A - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEAC4As
   *
   * @param query FindAllExcIEEEAC4AQuery
   * @return List<ExcIEEEAC4A>
   */
  @SuppressWarnings("unused")
  public List<ExcIEEEAC4A> findAll(FindAllExcIEEEAC4AQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcIEEEAC4A - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcIEEEAC4ARepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC4AEntityProjector.class.getName());
}
