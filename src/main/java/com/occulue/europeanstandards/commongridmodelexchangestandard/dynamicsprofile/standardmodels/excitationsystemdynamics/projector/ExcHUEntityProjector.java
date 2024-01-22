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
 * Projector for ExcHU as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcHUAggregate
 *
 * @author your_name_here
 */
@Component("excHU-entity-projector")
public class ExcHUEntityProjector {

  // core constructor
  public ExcHUEntityProjector(ExcHURepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcHU
   *
   * @param	entity ExcHU
   */
  public ExcHU create(ExcHU entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcHU
   *
   * @param	entity ExcHU
   */
  public ExcHU update(ExcHU entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcHU
   *
   * @param	id		UUID
   */
  public ExcHU delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcHU entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Ae
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcHU
   */
  public ExcHU assignAe(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ae as " + assignment.toString());

    ExcHU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ae to the parent entity
    // ------------------------------------------
    parentEntity.setAe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ae
   *
   * @param	parentId		UUID
   * @return	ExcHU
   */
  public ExcHU unAssignAe(UUID parentId) {
    ExcHU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ae on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ae on the parent entithy
    // ------------------------------------------
    parentEntity.setAe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ai
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcHU
   */
  public ExcHU assignAi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ai as " + assignment.toString());

    ExcHU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ai to the parent entity
    // ------------------------------------------
    parentEntity.setAi(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ai
   *
   * @param	parentId		UUID
   * @return	ExcHU
   */
  public ExcHU unAssignAi(UUID parentId) {
    ExcHU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ai on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ai on the parent entithy
    // ------------------------------------------
    parentEntity.setAi(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Atr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcHU
   */
  public ExcHU assignAtr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Atr as " + assignment.toString());

    ExcHU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Atr to the parent entity
    // ------------------------------------------
    parentEntity.setAtr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Atr
   *
   * @param	parentId		UUID
   * @return	ExcHU
   */
  public ExcHU unAssignAtr(UUID parentId) {
    ExcHU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Atr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Atr on the parent entithy
    // ------------------------------------------
    parentEntity.setAtr(null);

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
   * @return	ExcHU
   */
  public ExcHU assignEmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Emax as " + assignment.toString());

    ExcHU parentEntity = repository.findById(parentId).get();
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
   * @return	ExcHU
   */
  public ExcHU unAssignEmax(UUID parentId) {
    ExcHU parentEntity = repository.findById(parentId).get();

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
   * Assign a Emin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcHU
   */
  public ExcHU assignEmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Emin as " + assignment.toString());

    ExcHU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Emin to the parent entity
    // ------------------------------------------
    parentEntity.setEmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Emin
   *
   * @param	parentId		UUID
   * @return	ExcHU
   */
  public ExcHU unAssignEmin(UUID parentId) {
    ExcHU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Emin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Emin on the parent entithy
    // ------------------------------------------
    parentEntity.setEmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Imax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcHU
   */
  public ExcHU assignImax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Imax as " + assignment.toString());

    ExcHU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Imax to the parent entity
    // ------------------------------------------
    parentEntity.setImax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Imax
   *
   * @param	parentId		UUID
   * @return	ExcHU
   */
  public ExcHU unAssignImax(UUID parentId) {
    ExcHU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Imax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Imax on the parent entithy
    // ------------------------------------------
    parentEntity.setImax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Imin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcHU
   */
  public ExcHU assignImin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Imin as " + assignment.toString());

    ExcHU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Imin to the parent entity
    // ------------------------------------------
    parentEntity.setImin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Imin
   *
   * @param	parentId		UUID
   * @return	ExcHU
   */
  public ExcHU unAssignImin(UUID parentId) {
    ExcHU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Imin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Imin on the parent entithy
    // ------------------------------------------
    parentEntity.setImin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ke
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcHU
   */
  public ExcHU assignKe(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ke as " + assignment.toString());

    ExcHU parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Ke to the parent entity
    // ------------------------------------------
    parentEntity.setKe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ke
   *
   * @param	parentId		UUID
   * @return	ExcHU
   */
  public ExcHU unAssignKe(UUID parentId) {
    ExcHU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ke on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ke on the parent entithy
    // ------------------------------------------
    parentEntity.setKe(null);

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
   * @param	assignment 	Simple_Float
   * @return	ExcHU
   */
  public ExcHU assignKi(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    ExcHU parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	ExcHU
   */
  public ExcHU unAssignKi(UUID parentId) {
    ExcHU parentEntity = repository.findById(parentId).get();

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
   * Assign a Te
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcHU
   */
  public ExcHU assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcHU parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Te to the parent entity
    // ------------------------------------------
    parentEntity.setTe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Te
   *
   * @param	parentId		UUID
   * @return	ExcHU
   */
  public ExcHU unAssignTe(UUID parentId) {
    ExcHU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Te on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Te on the parent entithy
    // ------------------------------------------
    parentEntity.setTe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcHU
   */
  public ExcHU assignTi(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti as " + assignment.toString());

    ExcHU parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti to the parent entity
    // ------------------------------------------
    parentEntity.setTi(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti
   *
   * @param	parentId		UUID
   * @return	ExcHU
   */
  public ExcHU unAssignTi(UUID parentId) {
    ExcHU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti on the parent entithy
    // ------------------------------------------
    parentEntity.setTi(null);

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
   * @return	ExcHU
   */
  public ExcHU assignTr(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tr as " + assignment.toString());

    ExcHU parentEntity = repository.findById(parentId).get();
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
   * @return	ExcHU
   */
  public ExcHU unAssignTr(UUID parentId) {
    ExcHU parentEntity = repository.findById(parentId).get();

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

  /**
   * Method to retrieve the ExcHU via an FindExcHUQuery
   *
   * @return query FindExcHUQuery
   */
  @SuppressWarnings("unused")
  public ExcHU find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcHU - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcHUs
   *
   * @param query FindAllExcHUQuery
   * @return List<ExcHU>
   */
  @SuppressWarnings("unused")
  public List<ExcHU> findAll(FindAllExcHUQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcHU - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcHURepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(ExcHUEntityProjector.class.getName());
}
