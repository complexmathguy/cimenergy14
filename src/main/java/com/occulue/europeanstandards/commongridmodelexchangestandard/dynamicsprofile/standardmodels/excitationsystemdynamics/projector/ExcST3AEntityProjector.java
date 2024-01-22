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
 * Projector for ExcST3A as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcST3AAggregate
 *
 * @author your_name_here
 */
@Component("excST3A-entity-projector")
public class ExcST3AEntityProjector {

  // core constructor
  public ExcST3AEntityProjector(ExcST3ARepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcST3A
   *
   * @param	entity ExcST3A
   */
  public ExcST3A create(ExcST3A entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcST3A
   *
   * @param	entity ExcST3A
   */
  public ExcST3A update(ExcST3A entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcST3A
   *
   * @param	id		UUID
   */
  public ExcST3A delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcST3A entity = repository.findById(id).get();

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
   * @return	ExcST3A
   */
  public ExcST3A assignEfdmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efdmax as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignEfdmax(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * Assign a Kc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST3A
   */
  public ExcST3A assignKc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kc as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignKc(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST3A
   */
  public ExcST3A assignKg(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kg as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignKg(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST3A
   */
  public ExcST3A assignKi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignKi(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * Assign a Kj
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST3A
   */
  public ExcST3A assignKj(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kj as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kj to the parent entity
    // ------------------------------------------
    parentEntity.setKj(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kj
   *
   * @param	parentId		UUID
   * @return	ExcST3A
   */
  public ExcST3A unAssignKj(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kj on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kj on the parent entithy
    // ------------------------------------------
    parentEntity.setKj(null);

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
   * @return	ExcST3A
   */
  public ExcST3A assignKm(UUID parentId, PU assignment) {
    LOGGER.info("assigning Km as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignKm(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST3A
   */
  public ExcST3A assignKp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kp as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignKp(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * Assign a Ks
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST3A
   */
  public ExcST3A assignKs(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ks as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ks to the parent entity
    // ------------------------------------------
    parentEntity.setKs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ks
   *
   * @param	parentId		UUID
   * @return	ExcST3A
   */
  public ExcST3A unAssignKs(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ks on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ks on the parent entithy
    // ------------------------------------------
    parentEntity.setKs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ks1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST3A
   */
  public ExcST3A assignKs1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ks1 as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ks1 to the parent entity
    // ------------------------------------------
    parentEntity.setKs1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ks1
   *
   * @param	parentId		UUID
   * @return	ExcST3A
   */
  public ExcST3A unAssignKs1(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ks1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ks1 on the parent entithy
    // ------------------------------------------
    parentEntity.setKs1(null);

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
   * @return	ExcST3A
   */
  public ExcST3A assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignTb(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST3A
   */
  public ExcST3A assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignTc(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST3A
   */
  public ExcST3A assignThetap(UUID parentId, AngleDegrees assignment) {
    LOGGER.info("assigning Thetap as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignThetap(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST3A
   */
  public ExcST3A assignTm(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tm as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignTm(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST3A
   */
  public ExcST3A assignVbmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vbmax as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignVbmax(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST3A
   */
  public ExcST3A assignVgmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vgmax as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignVgmax(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST3A
   */
  public ExcST3A assignVimax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vimax as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignVimax(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST3A
   */
  public ExcST3A assignVimin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vimin as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignVimin(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST3A
   */
  public ExcST3A assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignVrmax(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST3A
   */
  public ExcST3A assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignVrmin(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST3A
   */
  public ExcST3A assignXl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xl as " + assignment.toString());

    ExcST3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST3A
   */
  public ExcST3A unAssignXl(UUID parentId) {
    ExcST3A parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the ExcST3A via an FindExcST3AQuery
   *
   * @return query FindExcST3AQuery
   */
  @SuppressWarnings("unused")
  public ExcST3A find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcST3A - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcST3As
   *
   * @param query FindAllExcST3AQuery
   * @return List<ExcST3A>
   */
  @SuppressWarnings("unused")
  public List<ExcST3A> findAll(FindAllExcST3AQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcST3A - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcST3ARepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcST3AEntityProjector.class.getName());
}
