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
 * Projector for ExcIEEEST4B as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcIEEEST4BAggregate
 *
 * @author your_name_here
 */
@Component("excIEEEST4B-entity-projector")
public class ExcIEEEST4BEntityProjector {

  // core constructor
  public ExcIEEEST4BEntityProjector(ExcIEEEST4BRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcIEEEST4B
   *
   * @param	entity ExcIEEEST4B
   */
  public ExcIEEEST4B create(ExcIEEEST4B entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcIEEEST4B
   *
   * @param	entity ExcIEEEST4B
   */
  public ExcIEEEST4B update(ExcIEEEST4B entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcIEEEST4B
   *
   * @param	id		UUID
   */
  public ExcIEEEST4B delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcIEEEST4B entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Kc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignKc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kc as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignKc(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

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
   * Assign a Kg
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignKg(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kg as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignKg(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

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
   * Assign a Ki
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignKi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignKi(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

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
   * Assign a Kim
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignKim(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kim as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kim to the parent entity
    // ------------------------------------------
    parentEntity.setKim(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kim
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignKim(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kim on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kim on the parent entithy
    // ------------------------------------------
    parentEntity.setKim(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kir
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignKir(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kir as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kir to the parent entity
    // ------------------------------------------
    parentEntity.setKir(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kir
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignKir(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kir on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kir on the parent entithy
    // ------------------------------------------
    parentEntity.setKir(null);

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
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignKp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kp as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignKp(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

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
   * Assign a Kpm
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignKpm(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpm as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpm to the parent entity
    // ------------------------------------------
    parentEntity.setKpm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpm
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignKpm(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpm on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpm on the parent entithy
    // ------------------------------------------
    parentEntity.setKpm(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignKpr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpr as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpr to the parent entity
    // ------------------------------------------
    parentEntity.setKpr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpr
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignKpr(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpr on the parent entithy
    // ------------------------------------------
    parentEntity.setKpr(null);

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
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignTa(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

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
   * Assign a Thetap
   *
   * @param	parentId	UUID
   * @param	assignment 	AngleDegrees
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignThetap(UUID parentId, AngleDegrees assignment) {
    LOGGER.info("assigning Thetap as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
    assignment = AngleDegreesProjector.find(assignment.getAngleDegreesId());

    // ------------------------------------------
    // assign the Thetap to the parent entity
    // ------------------------------------------
    parentEntity.setThetap(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Thetap
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignThetap(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Thetap on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Thetap on the parent entithy
    // ------------------------------------------
    parentEntity.setThetap(null);

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
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignVbmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vbmax as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignVbmax(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

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
   * Assign a Vmmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignVmmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmmax as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vmmax to the parent entity
    // ------------------------------------------
    parentEntity.setVmmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vmmax
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignVmmax(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vmmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vmmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVmmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vmmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignVmmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmmin as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vmmin to the parent entity
    // ------------------------------------------
    parentEntity.setVmmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vmmin
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignVmmin(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vmmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vmmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVmmin(null);

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
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignVrmax(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignVrmin(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

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

  /*
   * Assign a Xl
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B assignXl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xl as " + assignment.toString());

    ExcIEEEST4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xl to the parent entity
    // ------------------------------------------
    parentEntity.setXl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xl
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST4B
   */
  public ExcIEEEST4B unAssignXl(UUID parentId) {
    ExcIEEEST4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xl on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xl on the parent entithy
    // ------------------------------------------
    parentEntity.setXl(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExcIEEEST4B via an FindExcIEEEST4BQuery
   *
   * @return query FindExcIEEEST4BQuery
   */
  @SuppressWarnings("unused")
  public ExcIEEEST4B find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcIEEEST4B - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEST4Bs
   *
   * @param query FindAllExcIEEEST4BQuery
   * @return List<ExcIEEEST4B>
   */
  @SuppressWarnings("unused")
  public List<ExcIEEEST4B> findAll(FindAllExcIEEEST4BQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcIEEEST4B - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcIEEEST4BRepository repository;

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

  @Autowired
  @Qualifier(value = "angleDegrees-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .AngleDegreesEntityProjector
      AngleDegreesProjector;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST4BEntityProjector.class.getName());
}
