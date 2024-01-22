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
 * Projector for ExcIEEEST6B as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcIEEEST6BAggregate
 *
 * @author your_name_here
 */
@Component("excIEEEST6B-entity-projector")
public class ExcIEEEST6BEntityProjector {

  // core constructor
  public ExcIEEEST6BEntityProjector(ExcIEEEST6BRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcIEEEST6B
   *
   * @param	entity ExcIEEEST6B
   */
  public ExcIEEEST6B create(ExcIEEEST6B entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcIEEEST6B
   *
   * @param	entity ExcIEEEST6B
   */
  public ExcIEEEST6B update(ExcIEEEST6B entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcIEEEST6B
   *
   * @param	id		UUID
   */
  public ExcIEEEST6B delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcIEEEST6B entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Ilr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B assignIlr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ilr as " + assignment.toString());

    ExcIEEEST6B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ilr to the parent entity
    // ------------------------------------------
    parentEntity.setIlr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ilr
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B unAssignIlr(UUID parentId) {
    ExcIEEEST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ilr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ilr on the parent entithy
    // ------------------------------------------
    parentEntity.setIlr(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kci
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B assignKci(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kci as " + assignment.toString());

    ExcIEEEST6B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kci to the parent entity
    // ------------------------------------------
    parentEntity.setKci(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kci
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B unAssignKci(UUID parentId) {
    ExcIEEEST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kci on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kci on the parent entithy
    // ------------------------------------------
    parentEntity.setKci(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kff
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B assignKff(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kff as " + assignment.toString());

    ExcIEEEST6B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kff to the parent entity
    // ------------------------------------------
    parentEntity.setKff(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kff
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B unAssignKff(UUID parentId) {
    ExcIEEEST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kff on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kff on the parent entithy
    // ------------------------------------------
    parentEntity.setKff(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kg
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B assignKg(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kg as " + assignment.toString());

    ExcIEEEST6B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kg to the parent entity
    // ------------------------------------------
    parentEntity.setKg(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kg
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B unAssignKg(UUID parentId) {
    ExcIEEEST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kg on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kg on the parent entithy
    // ------------------------------------------
    parentEntity.setKg(null);

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
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B assignKia(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kia as " + assignment.toString());

    ExcIEEEST6B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B unAssignKia(UUID parentId) {
    ExcIEEEST6B parentEntity = repository.findById(parentId).get();

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
   * Assign a Klr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B assignKlr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Klr as " + assignment.toString());

    ExcIEEEST6B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Klr to the parent entity
    // ------------------------------------------
    parentEntity.setKlr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Klr
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B unAssignKlr(UUID parentId) {
    ExcIEEEST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Klr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Klr on the parent entithy
    // ------------------------------------------
    parentEntity.setKlr(null);

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
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B assignKm(UUID parentId, PU assignment) {
    LOGGER.info("assigning Km as " + assignment.toString());

    ExcIEEEST6B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B unAssignKm(UUID parentId) {
    ExcIEEEST6B parentEntity = repository.findById(parentId).get();

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
   * Assign a Kpa
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B assignKpa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpa as " + assignment.toString());

    ExcIEEEST6B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B unAssignKpa(UUID parentId) {
    ExcIEEEST6B parentEntity = repository.findById(parentId).get();

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
   * Assign a Tg
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B assignTg(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tg as " + assignment.toString());

    ExcIEEEST6B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B unAssignTg(UUID parentId) {
    ExcIEEEST6B parentEntity = repository.findById(parentId).get();

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
   * Assign a Vamax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B assignVamax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vamax as " + assignment.toString());

    ExcIEEEST6B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vamax to the parent entity
    // ------------------------------------------
    parentEntity.setVamax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vamax
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B unAssignVamax(UUID parentId) {
    ExcIEEEST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vamax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vamax on the parent entithy
    // ------------------------------------------
    parentEntity.setVamax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vamin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B assignVamin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vamin as " + assignment.toString());

    ExcIEEEST6B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vamin to the parent entity
    // ------------------------------------------
    parentEntity.setVamin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vamin
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B unAssignVamin(UUID parentId) {
    ExcIEEEST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vamin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vamin on the parent entithy
    // ------------------------------------------
    parentEntity.setVamin(null);

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
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcIEEEST6B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B unAssignVrmax(UUID parentId) {
    ExcIEEEST6B parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcIEEEST6B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST6B
   */
  public ExcIEEEST6B unAssignVrmin(UUID parentId) {
    ExcIEEEST6B parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the ExcIEEEST6B via an FindExcIEEEST6BQuery
   *
   * @return query FindExcIEEEST6BQuery
   */
  @SuppressWarnings("unused")
  public ExcIEEEST6B find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcIEEEST6B - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEST6Bs
   *
   * @param query FindAllExcIEEEST6BQuery
   * @return List<ExcIEEEST6B>
   */
  @SuppressWarnings("unused")
  public List<ExcIEEEST6B> findAll(FindAllExcIEEEST6BQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcIEEEST6B - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcIEEEST6BRepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST6BEntityProjector.class.getName());
}
