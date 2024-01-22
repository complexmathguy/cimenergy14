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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for GovGAST as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovGASTAggregate
 *
 * @author your_name_here
 */
@Component("govGAST-entity-projector")
public class GovGASTEntityProjector {

  // core constructor
  public GovGASTEntityProjector(GovGASTRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovGAST
   *
   * @param	entity GovGAST
   */
  public GovGAST create(GovGAST entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovGAST
   *
   * @param	entity GovGAST
   */
  public GovGAST update(GovGAST entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovGAST
   *
   * @param	id		UUID
   */
  public GovGAST delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovGAST entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a At
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGAST
   */
  public GovGAST assignAt(UUID parentId, PU assignment) {
    LOGGER.info("assigning At as " + assignment.toString());

    GovGAST parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the At to the parent entity
    // ------------------------------------------
    parentEntity.setAt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the At
   *
   * @param	parentId		UUID
   * @return	GovGAST
   */
  public GovGAST unAssignAt(UUID parentId) {
    GovGAST parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning At on " + parentEntity.toString());

    // ------------------------------------------
    // null out the At on the parent entithy
    // ------------------------------------------
    parentEntity.setAt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dturb
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGAST
   */
  public GovGAST assignDturb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dturb as " + assignment.toString());

    GovGAST parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dturb to the parent entity
    // ------------------------------------------
    parentEntity.setDturb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dturb
   *
   * @param	parentId		UUID
   * @return	GovGAST
   */
  public GovGAST unAssignDturb(UUID parentId) {
    GovGAST parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dturb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dturb on the parent entithy
    // ------------------------------------------
    parentEntity.setDturb(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kt
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGAST
   */
  public GovGAST assignKt(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kt as " + assignment.toString());

    GovGAST parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kt to the parent entity
    // ------------------------------------------
    parentEntity.setKt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kt
   *
   * @param	parentId		UUID
   * @return	GovGAST
   */
  public GovGAST unAssignKt(UUID parentId) {
    GovGAST parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kt on the parent entithy
    // ------------------------------------------
    parentEntity.setKt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mwbase
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GovGAST
   */
  public GovGAST assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovGAST parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the Mwbase to the parent entity
    // ------------------------------------------
    parentEntity.setMwbase(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mwbase
   *
   * @param	parentId		UUID
   * @return	GovGAST
   */
  public GovGAST unAssignMwbase(UUID parentId) {
    GovGAST parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mwbase on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mwbase on the parent entithy
    // ------------------------------------------
    parentEntity.setMwbase(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a R
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGAST
   */
  public GovGAST assignR(UUID parentId, PU assignment) {
    LOGGER.info("assigning R as " + assignment.toString());

    GovGAST parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the R to the parent entity
    // ------------------------------------------
    parentEntity.setR(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R
   *
   * @param	parentId		UUID
   * @return	GovGAST
   */
  public GovGAST unAssignR(UUID parentId) {
    GovGAST parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R on the parent entithy
    // ------------------------------------------
    parentEntity.setR(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST
   */
  public GovGAST assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    GovGAST parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T1 to the parent entity
    // ------------------------------------------
    parentEntity.setT1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T1
   *
   * @param	parentId		UUID
   * @return	GovGAST
   */
  public GovGAST unAssignT1(UUID parentId) {
    GovGAST parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T1 on the parent entithy
    // ------------------------------------------
    parentEntity.setT1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST
   */
  public GovGAST assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    GovGAST parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T2 to the parent entity
    // ------------------------------------------
    parentEntity.setT2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T2
   *
   * @param	parentId		UUID
   * @return	GovGAST
   */
  public GovGAST unAssignT2(UUID parentId) {
    GovGAST parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T2 on the parent entithy
    // ------------------------------------------
    parentEntity.setT2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST
   */
  public GovGAST assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    GovGAST parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T3 to the parent entity
    // ------------------------------------------
    parentEntity.setT3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T3
   *
   * @param	parentId		UUID
   * @return	GovGAST
   */
  public GovGAST unAssignT3(UUID parentId) {
    GovGAST parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T3 on the parent entithy
    // ------------------------------------------
    parentEntity.setT3(null);

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
   * @return	GovGAST
   */
  public GovGAST assignVmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmax as " + assignment.toString());

    GovGAST parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST
   */
  public GovGAST unAssignVmax(UUID parentId) {
    GovGAST parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST
   */
  public GovGAST assignVmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmin as " + assignment.toString());

    GovGAST parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST
   */
  public GovGAST unAssignVmin(UUID parentId) {
    GovGAST parentEntity = repository.findById(parentId).get();

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

  /**
   * Method to retrieve the GovGAST via an FindGovGASTQuery
   *
   * @return query FindGovGASTQuery
   */
  @SuppressWarnings("unused")
  public GovGAST find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovGAST - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovGASTs
   *
   * @param query FindAllGovGASTQuery
   * @return List<GovGAST>
   */
  @SuppressWarnings("unused")
  public List<GovGAST> findAll(FindAllGovGASTQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovGAST - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovGASTRepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "activePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ActivePowerEntityProjector
      ActivePowerProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(GovGASTEntityProjector.class.getName());
}
