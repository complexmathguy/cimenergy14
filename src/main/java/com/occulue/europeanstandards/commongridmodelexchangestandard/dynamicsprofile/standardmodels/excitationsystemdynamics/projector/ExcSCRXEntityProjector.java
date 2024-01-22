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
 * Projector for ExcSCRX as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcSCRXAggregate
 *
 * @author your_name_here
 */
@Component("excSCRX-entity-projector")
public class ExcSCRXEntityProjector {

  // core constructor
  public ExcSCRXEntityProjector(ExcSCRXRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcSCRX
   *
   * @param	entity ExcSCRX
   */
  public ExcSCRX create(ExcSCRX entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcSCRX
   *
   * @param	entity ExcSCRX
   */
  public ExcSCRX update(ExcSCRX entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcSCRX
   *
   * @param	id		UUID
   */
  public ExcSCRX delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcSCRX entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Cswitch
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcSCRX
   */
  public ExcSCRX assignCswitch(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Cswitch as " + assignment.toString());

    ExcSCRX parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Cswitch to the parent entity
    // ------------------------------------------
    parentEntity.setCswitch(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Cswitch
   *
   * @param	parentId		UUID
   * @return	ExcSCRX
   */
  public ExcSCRX unAssignCswitch(UUID parentId) {
    ExcSCRX parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Cswitch on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Cswitch on the parent entithy
    // ------------------------------------------
    parentEntity.setCswitch(null);

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
   * @return	ExcSCRX
   */
  public ExcSCRX assignEmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Emax as " + assignment.toString());

    ExcSCRX parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSCRX
   */
  public ExcSCRX unAssignEmax(UUID parentId) {
    ExcSCRX parentEntity = repository.findById(parentId).get();

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
   * @return	ExcSCRX
   */
  public ExcSCRX assignEmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Emin as " + assignment.toString());

    ExcSCRX parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSCRX
   */
  public ExcSCRX unAssignEmin(UUID parentId) {
    ExcSCRX parentEntity = repository.findById(parentId).get();

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
   * @return	ExcSCRX
   */
  public ExcSCRX assignK(UUID parentId, PU assignment) {
    LOGGER.info("assigning K as " + assignment.toString());

    ExcSCRX parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSCRX
   */
  public ExcSCRX unAssignK(UUID parentId) {
    ExcSCRX parentEntity = repository.findById(parentId).get();

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
   * Assign a Rcrfd
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcSCRX
   */
  public ExcSCRX assignRcrfd(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Rcrfd as " + assignment.toString());

    ExcSCRX parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Rcrfd to the parent entity
    // ------------------------------------------
    parentEntity.setRcrfd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rcrfd
   *
   * @param	parentId		UUID
   * @return	ExcSCRX
   */
  public ExcSCRX unAssignRcrfd(UUID parentId) {
    ExcSCRX parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rcrfd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rcrfd on the parent entithy
    // ------------------------------------------
    parentEntity.setRcrfd(null);

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
   * @return	ExcSCRX
   */
  public ExcSCRX assignTatb(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Tatb as " + assignment.toString());

    ExcSCRX parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSCRX
   */
  public ExcSCRX unAssignTatb(UUID parentId) {
    ExcSCRX parentEntity = repository.findById(parentId).get();

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
   * @return	ExcSCRX
   */
  public ExcSCRX assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    ExcSCRX parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSCRX
   */
  public ExcSCRX unAssignTb(UUID parentId) {
    ExcSCRX parentEntity = repository.findById(parentId).get();

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
   * Assign a Te
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcSCRX
   */
  public ExcSCRX assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcSCRX parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSCRX
   */
  public ExcSCRX unAssignTe(UUID parentId) {
    ExcSCRX parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the ExcSCRX via an FindExcSCRXQuery
   *
   * @return query FindExcSCRXQuery
   */
  @SuppressWarnings("unused")
  public ExcSCRX find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcSCRX - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcSCRXs
   *
   * @param query FindAllExcSCRXQuery
   * @return List<ExcSCRX>
   */
  @SuppressWarnings("unused")
  public List<ExcSCRX> findAll(FindAllExcSCRXQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcSCRX - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcSCRXRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

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

  private static final Logger LOGGER = Logger.getLogger(ExcSCRXEntityProjector.class.getName());
}
