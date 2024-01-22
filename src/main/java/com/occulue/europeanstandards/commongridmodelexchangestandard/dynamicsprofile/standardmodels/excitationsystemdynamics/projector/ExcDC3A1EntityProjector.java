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
 * Projector for ExcDC3A1 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcDC3A1Aggregate
 *
 * @author your_name_here
 */
@Component("excDC3A1-entity-projector")
public class ExcDC3A1EntityProjector {

  // core constructor
  public ExcDC3A1EntityProjector(ExcDC3A1Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcDC3A1
   *
   * @param	entity ExcDC3A1
   */
  public ExcDC3A1 create(ExcDC3A1 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcDC3A1
   *
   * @param	entity ExcDC3A1
   */
  public ExcDC3A1 update(ExcDC3A1 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcDC3A1
   *
   * @param	id		UUID
   */
  public ExcDC3A1 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcDC3A1 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Exclim
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcDC3A1
   */
  public ExcDC3A1 assignExclim(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Exclim as " + assignment.toString());

    ExcDC3A1 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Exclim to the parent entity
    // ------------------------------------------
    parentEntity.setExclim(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Exclim
   *
   * @param	parentId		UUID
   * @return	ExcDC3A1
   */
  public ExcDC3A1 unAssignExclim(UUID parentId) {
    ExcDC3A1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Exclim on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Exclim on the parent entithy
    // ------------------------------------------
    parentEntity.setExclim(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ka
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcDC3A1
   */
  public ExcDC3A1 assignKa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    ExcDC3A1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcDC3A1
   */
  public ExcDC3A1 unAssignKa(UUID parentId) {
    ExcDC3A1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Ke
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcDC3A1
   */
  public ExcDC3A1 assignKe(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ke as " + assignment.toString());

    ExcDC3A1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

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
   * @return	ExcDC3A1
   */
  public ExcDC3A1 unAssignKe(UUID parentId) {
    ExcDC3A1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Kf
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcDC3A1
   */
  public ExcDC3A1 assignKf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf as " + assignment.toString());

    ExcDC3A1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kf to the parent entity
    // ------------------------------------------
    parentEntity.setKf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kf
   *
   * @param	parentId		UUID
   * @return	ExcDC3A1
   */
  public ExcDC3A1 unAssignKf(UUID parentId) {
    ExcDC3A1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kf on the parent entithy
    // ------------------------------------------
    parentEntity.setKf(null);

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
   * @param	assignment 	PU
   * @return	ExcDC3A1
   */
  public ExcDC3A1 assignKi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    ExcDC3A1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

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
   * @return	ExcDC3A1
   */
  public ExcDC3A1 unAssignKi(UUID parentId) {
    ExcDC3A1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Kp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcDC3A1
   */
  public ExcDC3A1 assignKp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kp as " + assignment.toString());

    ExcDC3A1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kp to the parent entity
    // ------------------------------------------
    parentEntity.setKp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kp
   *
   * @param	parentId		UUID
   * @return	ExcDC3A1
   */
  public ExcDC3A1 unAssignKp(UUID parentId) {
    ExcDC3A1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kp on the parent entithy
    // ------------------------------------------
    parentEntity.setKp(null);

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
   * @return	ExcDC3A1
   */
  public ExcDC3A1 assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    ExcDC3A1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcDC3A1
   */
  public ExcDC3A1 unAssignTa(UUID parentId) {
    ExcDC3A1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Te
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcDC3A1
   */
  public ExcDC3A1 assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcDC3A1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcDC3A1
   */
  public ExcDC3A1 unAssignTe(UUID parentId) {
    ExcDC3A1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tf
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcDC3A1
   */
  public ExcDC3A1 assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    ExcDC3A1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcDC3A1
   */
  public ExcDC3A1 unAssignTf(UUID parentId) {
    ExcDC3A1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Vb1max
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcDC3A1
   */
  public ExcDC3A1 assignVb1max(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vb1max as " + assignment.toString());

    ExcDC3A1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vb1max to the parent entity
    // ------------------------------------------
    parentEntity.setVb1max(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vb1max
   *
   * @param	parentId		UUID
   * @return	ExcDC3A1
   */
  public ExcDC3A1 unAssignVb1max(UUID parentId) {
    ExcDC3A1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vb1max on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vb1max on the parent entithy
    // ------------------------------------------
    parentEntity.setVb1max(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vblim
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcDC3A1
   */
  public ExcDC3A1 assignVblim(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Vblim as " + assignment.toString());

    ExcDC3A1 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Vblim to the parent entity
    // ------------------------------------------
    parentEntity.setVblim(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vblim
   *
   * @param	parentId		UUID
   * @return	ExcDC3A1
   */
  public ExcDC3A1 unAssignVblim(UUID parentId) {
    ExcDC3A1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vblim on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vblim on the parent entithy
    // ------------------------------------------
    parentEntity.setVblim(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vbmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcDC3A1
   */
  public ExcDC3A1 assignVbmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vbmax as " + assignment.toString());

    ExcDC3A1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vbmax to the parent entity
    // ------------------------------------------
    parentEntity.setVbmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vbmax
   *
   * @param	parentId		UUID
   * @return	ExcDC3A1
   */
  public ExcDC3A1 unAssignVbmax(UUID parentId) {
    ExcDC3A1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vbmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vbmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVbmax(null);

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
   * @return	ExcDC3A1
   */
  public ExcDC3A1 assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcDC3A1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcDC3A1
   */
  public ExcDC3A1 unAssignVrmax(UUID parentId) {
    ExcDC3A1 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcDC3A1
   */
  public ExcDC3A1 assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcDC3A1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcDC3A1
   */
  public ExcDC3A1 unAssignVrmin(UUID parentId) {
    ExcDC3A1 parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the ExcDC3A1 via an FindExcDC3A1Query
   *
   * @return query FindExcDC3A1Query
   */
  @SuppressWarnings("unused")
  public ExcDC3A1 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcDC3A1 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcDC3A1s
   *
   * @param query FindAllExcDC3A1Query
   * @return List<ExcDC3A1>
   */
  @SuppressWarnings("unused")
  public List<ExcDC3A1> findAll(FindAllExcDC3A1Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcDC3A1 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcDC3A1Repository repository;

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
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(ExcDC3A1EntityProjector.class.getName());
}
