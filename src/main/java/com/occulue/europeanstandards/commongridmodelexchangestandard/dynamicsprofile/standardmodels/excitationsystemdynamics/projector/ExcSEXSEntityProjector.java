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
 * Projector for ExcSEXS as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcSEXSAggregate
 *
 * @author your_name_here
 */
@Component("excSEXS-entity-projector")
public class ExcSEXSEntityProjector {

  // core constructor
  public ExcSEXSEntityProjector(ExcSEXSRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcSEXS
   *
   * @param	entity ExcSEXS
   */
  public ExcSEXS create(ExcSEXS entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcSEXS
   *
   * @param	entity ExcSEXS
   */
  public ExcSEXS update(ExcSEXS entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcSEXS
   *
   * @param	id		UUID
   */
  public ExcSEXS delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcSEXS entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Efdmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSEXS
   */
  public ExcSEXS assignEfdmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efdmax as " + assignment.toString());

    ExcSEXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efdmax to the parent entity
    // ------------------------------------------
    parentEntity.setEfdmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efdmax
   *
   * @param	parentId		UUID
   * @return	ExcSEXS
   */
  public ExcSEXS unAssignEfdmax(UUID parentId) {
    ExcSEXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efdmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efdmax on the parent entithy
    // ------------------------------------------
    parentEntity.setEfdmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Efdmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSEXS
   */
  public ExcSEXS assignEfdmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efdmin as " + assignment.toString());

    ExcSEXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efdmin to the parent entity
    // ------------------------------------------
    parentEntity.setEfdmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efdmin
   *
   * @param	parentId		UUID
   * @return	ExcSEXS
   */
  public ExcSEXS unAssignEfdmin(UUID parentId) {
    ExcSEXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efdmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efdmin on the parent entithy
    // ------------------------------------------
    parentEntity.setEfdmin(null);

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
   * @return	ExcSEXS
   */
  public ExcSEXS assignEmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Emax as " + assignment.toString());

    ExcSEXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSEXS
   */
  public ExcSEXS unAssignEmax(UUID parentId) {
    ExcSEXS parentEntity = repository.findById(parentId).get();

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
   * @return	ExcSEXS
   */
  public ExcSEXS assignEmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Emin as " + assignment.toString());

    ExcSEXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSEXS
   */
  public ExcSEXS unAssignEmin(UUID parentId) {
    ExcSEXS parentEntity = repository.findById(parentId).get();

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
   * Assign a K
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSEXS
   */
  public ExcSEXS assignK(UUID parentId, PU assignment) {
    LOGGER.info("assigning K as " + assignment.toString());

    ExcSEXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSEXS
   */
  public ExcSEXS unAssignK(UUID parentId) {
    ExcSEXS parentEntity = repository.findById(parentId).get();

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
   * Assign a Kc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSEXS
   */
  public ExcSEXS assignKc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kc as " + assignment.toString());

    ExcSEXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSEXS
   */
  public ExcSEXS unAssignKc(UUID parentId) {
    ExcSEXS parentEntity = repository.findById(parentId).get();

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
   * Assign a Tatb
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcSEXS
   */
  public ExcSEXS assignTatb(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Tatb as " + assignment.toString());

    ExcSEXS parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Tatb to the parent entity
    // ------------------------------------------
    parentEntity.setTatb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tatb
   *
   * @param	parentId		UUID
   * @return	ExcSEXS
   */
  public ExcSEXS unAssignTatb(UUID parentId) {
    ExcSEXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tatb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tatb on the parent entithy
    // ------------------------------------------
    parentEntity.setTatb(null);

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
   * @return	ExcSEXS
   */
  public ExcSEXS assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    ExcSEXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSEXS
   */
  public ExcSEXS unAssignTb(UUID parentId) {
    ExcSEXS parentEntity = repository.findById(parentId).get();

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
   * @return	ExcSEXS
   */
  public ExcSEXS assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    ExcSEXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSEXS
   */
  public ExcSEXS unAssignTc(UUID parentId) {
    ExcSEXS parentEntity = repository.findById(parentId).get();

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
   * Assign a Te
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcSEXS
   */
  public ExcSEXS assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcSEXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSEXS
   */
  public ExcSEXS unAssignTe(UUID parentId) {
    ExcSEXS parentEntity = repository.findById(parentId).get();

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

  /**
   * Method to retrieve the ExcSEXS via an FindExcSEXSQuery
   *
   * @return query FindExcSEXSQuery
   */
  @SuppressWarnings("unused")
  public ExcSEXS find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcSEXS - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcSEXSs
   *
   * @param query FindAllExcSEXSQuery
   * @return List<ExcSEXS>
   */
  @SuppressWarnings("unused")
  public List<ExcSEXS> findAll(FindAllExcSEXSQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcSEXS - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcSEXSRepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcSEXSEntityProjector.class.getName());
}
