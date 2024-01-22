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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for WindProtectionIEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindProtectionIECAggregate
 *
 * @author your_name_here
 */
@Component("windProtectionIEC-entity-projector")
public class WindProtectionIECEntityProjector {

  // core constructor
  public WindProtectionIECEntityProjector(WindProtectionIECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindProtectionIEC
   *
   * @param	entity WindProtectionIEC
   */
  public WindProtectionIEC create(WindProtectionIEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindProtectionIEC
   *
   * @param	entity WindProtectionIEC
   */
  public WindProtectionIEC update(WindProtectionIEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindProtectionIEC
   *
   * @param	id		UUID
   */
  public WindProtectionIEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindProtectionIEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Fover
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC assignFover(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fover as " + assignment.toString());

    WindProtectionIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fover to the parent entity
    // ------------------------------------------
    parentEntity.setFover(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fover
   *
   * @param	parentId		UUID
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC unAssignFover(UUID parentId) {
    WindProtectionIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fover on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fover on the parent entithy
    // ------------------------------------------
    parentEntity.setFover(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Funder
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC assignFunder(UUID parentId, PU assignment) {
    LOGGER.info("assigning Funder as " + assignment.toString());

    WindProtectionIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Funder to the parent entity
    // ------------------------------------------
    parentEntity.setFunder(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Funder
   *
   * @param	parentId		UUID
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC unAssignFunder(UUID parentId) {
    WindProtectionIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Funder on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Funder on the parent entithy
    // ------------------------------------------
    parentEntity.setFunder(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tfover
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC assignTfover(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tfover as " + assignment.toString());

    WindProtectionIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tfover to the parent entity
    // ------------------------------------------
    parentEntity.setTfover(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tfover
   *
   * @param	parentId		UUID
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC unAssignTfover(UUID parentId) {
    WindProtectionIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tfover on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tfover on the parent entithy
    // ------------------------------------------
    parentEntity.setTfover(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tfunder
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC assignTfunder(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tfunder as " + assignment.toString());

    WindProtectionIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tfunder to the parent entity
    // ------------------------------------------
    parentEntity.setTfunder(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tfunder
   *
   * @param	parentId		UUID
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC unAssignTfunder(UUID parentId) {
    WindProtectionIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tfunder on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tfunder on the parent entithy
    // ------------------------------------------
    parentEntity.setTfunder(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tuover
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC assignTuover(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tuover as " + assignment.toString());

    WindProtectionIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tuover to the parent entity
    // ------------------------------------------
    parentEntity.setTuover(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tuover
   *
   * @param	parentId		UUID
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC unAssignTuover(UUID parentId) {
    WindProtectionIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tuover on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tuover on the parent entithy
    // ------------------------------------------
    parentEntity.setTuover(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tuunder
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC assignTuunder(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tuunder as " + assignment.toString());

    WindProtectionIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tuunder to the parent entity
    // ------------------------------------------
    parentEntity.setTuunder(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tuunder
   *
   * @param	parentId		UUID
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC unAssignTuunder(UUID parentId) {
    WindProtectionIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tuunder on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tuunder on the parent entithy
    // ------------------------------------------
    parentEntity.setTuunder(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Uover
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC assignUover(UUID parentId, PU assignment) {
    LOGGER.info("assigning Uover as " + assignment.toString());

    WindProtectionIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Uover to the parent entity
    // ------------------------------------------
    parentEntity.setUover(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Uover
   *
   * @param	parentId		UUID
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC unAssignUover(UUID parentId) {
    WindProtectionIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Uover on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Uover on the parent entithy
    // ------------------------------------------
    parentEntity.setUover(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Uunder
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC assignUunder(UUID parentId, PU assignment) {
    LOGGER.info("assigning Uunder as " + assignment.toString());

    WindProtectionIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Uunder to the parent entity
    // ------------------------------------------
    parentEntity.setUunder(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Uunder
   *
   * @param	parentId		UUID
   * @return	WindProtectionIEC
   */
  public WindProtectionIEC unAssignUunder(UUID parentId) {
    WindProtectionIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Uunder on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Uunder on the parent entithy
    // ------------------------------------------
    parentEntity.setUunder(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindProtectionIEC via an FindWindProtectionIECQuery
   *
   * @return query FindWindProtectionIECQuery
   */
  @SuppressWarnings("unused")
  public WindProtectionIEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindProtectionIEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindProtectionIECs
   *
   * @param query FindAllWindProtectionIECQuery
   * @return List<WindProtectionIEC>
   */
  @SuppressWarnings("unused")
  public List<WindProtectionIEC> findAll(FindAllWindProtectionIECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all WindProtectionIEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindProtectionIECRepository repository;

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
      Logger.getLogger(WindProtectionIECEntityProjector.class.getName());
}
