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
 * Projector for GovHydroPID2 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovHydroPID2Aggregate
 *
 * @author your_name_here
 */
@Component("govHydroPID2-entity-projector")
public class GovHydroPID2EntityProjector {

  // core constructor
  public GovHydroPID2EntityProjector(GovHydroPID2Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovHydroPID2
   *
   * @param	entity GovHydroPID2
   */
  public GovHydroPID2 create(GovHydroPID2 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovHydroPID2
   *
   * @param	entity GovHydroPID2
   */
  public GovHydroPID2 update(GovHydroPID2 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovHydroPID2
   *
   * @param	id		UUID
   */
  public GovHydroPID2 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovHydroPID2 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Atw
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignAtw(UUID parentId, PU assignment) {
    LOGGER.info("assigning Atw as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Atw to the parent entity
    // ------------------------------------------
    parentEntity.setAtw(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Atw
   *
   * @param	parentId		UUID
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignAtw(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Atw on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Atw on the parent entithy
    // ------------------------------------------
    parentEntity.setAtw(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a D
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignD(UUID parentId, PU assignment) {
    LOGGER.info("assigning D as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignD(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

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
   * Assign a FeedbackSignal
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignFeedbackSignal(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning FeedbackSignal as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the FeedbackSignal to the parent entity
    // ------------------------------------------
    parentEntity.setFeedbackSignal(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the FeedbackSignal
   *
   * @param	parentId		UUID
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignFeedbackSignal(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning FeedbackSignal on " + parentEntity.toString());

    // ------------------------------------------
    // null out the FeedbackSignal on the parent entithy
    // ------------------------------------------
    parentEntity.setFeedbackSignal(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a G0
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignG0(UUID parentId, PU assignment) {
    LOGGER.info("assigning G0 as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the G0 to the parent entity
    // ------------------------------------------
    parentEntity.setG0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the G0
   *
   * @param	parentId		UUID
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignG0(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning G0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the G0 on the parent entithy
    // ------------------------------------------
    parentEntity.setG0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a G1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignG1(UUID parentId, PU assignment) {
    LOGGER.info("assigning G1 as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the G1 to the parent entity
    // ------------------------------------------
    parentEntity.setG1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the G1
   *
   * @param	parentId		UUID
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignG1(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning G1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the G1 on the parent entithy
    // ------------------------------------------
    parentEntity.setG1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a G2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignG2(UUID parentId, PU assignment) {
    LOGGER.info("assigning G2 as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the G2 to the parent entity
    // ------------------------------------------
    parentEntity.setG2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the G2
   *
   * @param	parentId		UUID
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignG2(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning G2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the G2 on the parent entithy
    // ------------------------------------------
    parentEntity.setG2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignGmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gmax as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gmax to the parent entity
    // ------------------------------------------
    parentEntity.setGmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gmax
   *
   * @param	parentId		UUID
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignGmax(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gmax on the parent entithy
    // ------------------------------------------
    parentEntity.setGmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignGmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gmin as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gmin to the parent entity
    // ------------------------------------------
    parentEntity.setGmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gmin
   *
   * @param	parentId		UUID
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignGmin(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gmin on the parent entithy
    // ------------------------------------------
    parentEntity.setGmin(null);

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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignKd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kd as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignKd(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	Simple_Float
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignKi(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignKi(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignKp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kp as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignKp(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignMwbase(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

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
   * Assign a P1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignP1(UUID parentId, PU assignment) {
    LOGGER.info("assigning P1 as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P1 to the parent entity
    // ------------------------------------------
    parentEntity.setP1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P1
   *
   * @param	parentId		UUID
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignP1(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P1 on the parent entithy
    // ------------------------------------------
    parentEntity.setP1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a P2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignP2(UUID parentId, PU assignment) {
    LOGGER.info("assigning P2 as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P2 to the parent entity
    // ------------------------------------------
    parentEntity.setP2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P2
   *
   * @param	parentId		UUID
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignP2(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P2 on the parent entithy
    // ------------------------------------------
    parentEntity.setP2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a P3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignP3(UUID parentId, PU assignment) {
    LOGGER.info("assigning P3 as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P3 to the parent entity
    // ------------------------------------------
    parentEntity.setP3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P3
   *
   * @param	parentId		UUID
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignP3(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P3 on the parent entithy
    // ------------------------------------------
    parentEntity.setP3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rperm
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignRperm(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rperm as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rperm to the parent entity
    // ------------------------------------------
    parentEntity.setRperm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rperm
   *
   * @param	parentId		UUID
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignRperm(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rperm on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rperm on the parent entithy
    // ------------------------------------------
    parentEntity.setRperm(null);

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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignTa(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignTb(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignTreg(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Treg as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignTreg(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignTw(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignTw(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	Simple_Float
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignVelmax(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Velmax as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignVelmax(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	Simple_Float
   * @return	GovHydroPID2
   */
  public GovHydroPID2 assignVelmin(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Velmin as " + assignment.toString());

    GovHydroPID2 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	GovHydroPID2
   */
  public GovHydroPID2 unAssignVelmin(UUID parentId) {
    GovHydroPID2 parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the GovHydroPID2 via an FindGovHydroPID2Query
   *
   * @return query FindGovHydroPID2Query
   */
  @SuppressWarnings("unused")
  public GovHydroPID2 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovHydroPID2 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovHydroPID2s
   *
   * @param query FindAllGovHydroPID2Query
   * @return List<GovHydroPID2>
   */
  @SuppressWarnings("unused")
  public List<GovHydroPID2> findAll(FindAllGovHydroPID2Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovHydroPID2 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovHydroPID2Repository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

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
      Logger.getLogger(GovHydroPID2EntityProjector.class.getName());
}
