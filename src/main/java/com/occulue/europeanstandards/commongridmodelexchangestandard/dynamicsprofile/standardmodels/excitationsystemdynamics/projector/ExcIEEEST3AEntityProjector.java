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
 * Projector for ExcIEEEST3A as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcIEEEST3AAggregate
 *
 * @author your_name_here
 */
@Component("excIEEEST3A-entity-projector")
public class ExcIEEEST3AEntityProjector {

  // core constructor
  public ExcIEEEST3AEntityProjector(ExcIEEEST3ARepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcIEEEST3A
   *
   * @param	entity ExcIEEEST3A
   */
  public ExcIEEEST3A create(ExcIEEEST3A entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcIEEEST3A
   *
   * @param	entity ExcIEEEST3A
   */
  public ExcIEEEST3A update(ExcIEEEST3A entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcIEEEST3A
   *
   * @param	id		UUID
   */
  public ExcIEEEST3A delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcIEEEST3A entity = repository.findById(id).get();

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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignKa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignKa(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignKc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kc as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignKc(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignKg(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kg as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignKg(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignKi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignKi(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * Assign a Km
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignKm(UUID parentId, PU assignment) {
    LOGGER.info("assigning Km as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignKm(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * Assign a Kp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignKp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kp as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignKp(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignTa(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignTb(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignTc(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * Assign a Thetap
   *
   * @param	parentId	UUID
   * @param	assignment 	AngleDegrees
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignThetap(UUID parentId, AngleDegrees assignment) {
    LOGGER.info("assigning Thetap as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignThetap(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * Assign a Tm
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignTm(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tm as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tm to the parent entity
    // ------------------------------------------
    parentEntity.setTm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tm
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignTm(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tm on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tm on the parent entithy
    // ------------------------------------------
    parentEntity.setTm(null);

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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignVbmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vbmax as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignVbmax(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * Assign a Vgmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignVgmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vgmax as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vgmax to the parent entity
    // ------------------------------------------
    parentEntity.setVgmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vgmax
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignVgmax(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vgmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vgmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVgmax(null);

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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignVimax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vimax as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignVimax(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignVimin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vimin as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignVimin(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * Assign a Vmmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignVmmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmmax as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignVmmax(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignVmmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmmin as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignVmmin(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignVrmax(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignVrmin(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A assignXl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xl as " + assignment.toString());

    ExcIEEEST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST3A
   */
  public ExcIEEEST3A unAssignXl(UUID parentId) {
    ExcIEEEST3A parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the ExcIEEEST3A via an FindExcIEEEST3AQuery
   *
   * @return query FindExcIEEEST3AQuery
   */
  @SuppressWarnings("unused")
  public ExcIEEEST3A find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcIEEEST3A - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEST3As
   *
   * @param query FindAllExcIEEEST3AQuery
   * @return List<ExcIEEEST3A>
   */
  @SuppressWarnings("unused")
  public List<ExcIEEEST3A> findAll(FindAllExcIEEEST3AQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcIEEEST3A - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcIEEEST3ARepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST3AEntityProjector.class.getName());
}
