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
 * Projector for GovHydroWPID as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovHydroWPIDAggregate
 *
 * @author your_name_here
 */
@Component("govHydroWPID-entity-projector")
public class GovHydroWPIDEntityProjector {

  // core constructor
  public GovHydroWPIDEntityProjector(GovHydroWPIDRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovHydroWPID
   *
   * @param	entity GovHydroWPID
   */
  public GovHydroWPID create(GovHydroWPID entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovHydroWPID
   *
   * @param	entity GovHydroWPID
   */
  public GovHydroWPID update(GovHydroWPID entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovHydroWPID
   *
   * @param	id		UUID
   */
  public GovHydroWPID delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovHydroWPID entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a D
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignD(UUID parentId, PU assignment) {
    LOGGER.info("assigning D as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the D to the parent entity
    // ------------------------------------------
    parentEntity.setD(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the D
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignD(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning D on " + parentEntity.toString());

    // ------------------------------------------
    // null out the D on the parent entithy
    // ------------------------------------------
    parentEntity.setD(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gatmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignGatmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gatmax as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gatmax to the parent entity
    // ------------------------------------------
    parentEntity.setGatmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gatmax
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignGatmax(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gatmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gatmax on the parent entithy
    // ------------------------------------------
    parentEntity.setGatmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gatmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignGatmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gatmin as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gatmin to the parent entity
    // ------------------------------------------
    parentEntity.setGatmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gatmin
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignGatmin(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gatmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gatmin on the parent entithy
    // ------------------------------------------
    parentEntity.setGatmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gv1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignGv1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv1 as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gv1 to the parent entity
    // ------------------------------------------
    parentEntity.setGv1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gv1
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignGv1(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gv1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gv1 on the parent entithy
    // ------------------------------------------
    parentEntity.setGv1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gv2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignGv2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv2 as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gv2 to the parent entity
    // ------------------------------------------
    parentEntity.setGv2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gv2
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignGv2(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gv2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gv2 on the parent entithy
    // ------------------------------------------
    parentEntity.setGv2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gv3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignGv3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv3 as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gv3 to the parent entity
    // ------------------------------------------
    parentEntity.setGv3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gv3
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignGv3(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gv3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gv3 on the parent entithy
    // ------------------------------------------
    parentEntity.setGv3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kd
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignKd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kd as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kd to the parent entity
    // ------------------------------------------
    parentEntity.setKd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kd
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignKd(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kd on the parent entithy
    // ------------------------------------------
    parentEntity.setKd(null);

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
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignKi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignKi(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignKp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kp as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignKp(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

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
   * Assign a Mwbase
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignMwbase(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

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
   * Assign a Pgv1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignPgv1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv1 as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pgv1 to the parent entity
    // ------------------------------------------
    parentEntity.setPgv1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pgv1
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignPgv1(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pgv1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pgv1 on the parent entithy
    // ------------------------------------------
    parentEntity.setPgv1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pgv2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignPgv2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv2 as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pgv2 to the parent entity
    // ------------------------------------------
    parentEntity.setPgv2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pgv2
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignPgv2(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pgv2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pgv2 on the parent entithy
    // ------------------------------------------
    parentEntity.setPgv2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pgv3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignPgv3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv3 as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pgv3 to the parent entity
    // ------------------------------------------
    parentEntity.setPgv3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pgv3
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignPgv3(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pgv3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pgv3 on the parent entithy
    // ------------------------------------------
    parentEntity.setPgv3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignPmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmax as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmax to the parent entity
    // ------------------------------------------
    parentEntity.setPmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmax
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignPmax(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmax on the parent entithy
    // ------------------------------------------
    parentEntity.setPmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignPmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmin as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmin to the parent entity
    // ------------------------------------------
    parentEntity.setPmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmin
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignPmin(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmin on the parent entithy
    // ------------------------------------------
    parentEntity.setPmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Reg
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignReg(UUID parentId, PU assignment) {
    LOGGER.info("assigning Reg as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Reg to the parent entity
    // ------------------------------------------
    parentEntity.setReg(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Reg
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignReg(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Reg on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Reg on the parent entithy
    // ------------------------------------------
    parentEntity.setReg(null);

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
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignTa(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignTb(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

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
   * Assign a Treg
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignTreg(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Treg as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Treg to the parent entity
    // ------------------------------------------
    parentEntity.setTreg(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Treg
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignTreg(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Treg on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Treg on the parent entithy
    // ------------------------------------------
    parentEntity.setTreg(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tw
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignTw(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tw to the parent entity
    // ------------------------------------------
    parentEntity.setTw(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tw
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignTw(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tw on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tw on the parent entithy
    // ------------------------------------------
    parentEntity.setTw(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Velmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignVelmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Velmax as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Velmax to the parent entity
    // ------------------------------------------
    parentEntity.setVelmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Velmax
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignVelmax(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Velmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Velmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVelmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Velmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWPID
   */
  public GovHydroWPID assignVelmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Velmin as " + assignment.toString());

    GovHydroWPID parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Velmin to the parent entity
    // ------------------------------------------
    parentEntity.setVelmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Velmin
   *
   * @param	parentId		UUID
   * @return	GovHydroWPID
   */
  public GovHydroWPID unAssignVelmin(UUID parentId) {
    GovHydroWPID parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Velmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Velmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVelmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovHydroWPID via an FindGovHydroWPIDQuery
   *
   * @return query FindGovHydroWPIDQuery
   */
  @SuppressWarnings("unused")
  public GovHydroWPID find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovHydroWPID - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovHydroWPIDs
   *
   * @param query FindAllGovHydroWPIDQuery
   * @return List<GovHydroWPID>
   */
  @SuppressWarnings("unused")
  public List<GovHydroWPID> findAll(FindAllGovHydroWPIDQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovHydroWPID - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovHydroWPIDRepository repository;

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

  private static final Logger LOGGER =
      Logger.getLogger(GovHydroWPIDEntityProjector.class.getName());
}
