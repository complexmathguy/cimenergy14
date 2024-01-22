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
 * Projector for GovGASTWD as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovGASTWDAggregate
 *
 * @author your_name_here
 */
@Component("govGASTWD-entity-projector")
public class GovGASTWDEntityProjector {

  // core constructor
  public GovGASTWDEntityProjector(GovGASTWDRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovGASTWD
   *
   * @param	entity GovGASTWD
   */
  public GovGASTWD create(GovGASTWD entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovGASTWD
   *
   * @param	entity GovGASTWD
   */
  public GovGASTWD update(GovGASTWD entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovGASTWD
   *
   * @param	id		UUID
   */
  public GovGASTWD delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovGASTWD entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a A
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovGASTWD
   */
  public GovGASTWD assignA(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning A as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the A to the parent entity
    // ------------------------------------------
    parentEntity.setA(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignA(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A on the parent entithy
    // ------------------------------------------
    parentEntity.setA(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Af1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGASTWD
   */
  public GovGASTWD assignAf1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Af1 as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Af1 to the parent entity
    // ------------------------------------------
    parentEntity.setAf1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Af1
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignAf1(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Af1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Af1 on the parent entithy
    // ------------------------------------------
    parentEntity.setAf1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Af2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGASTWD
   */
  public GovGASTWD assignAf2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Af2 as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Af2 to the parent entity
    // ------------------------------------------
    parentEntity.setAf2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Af2
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignAf2(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Af2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Af2 on the parent entithy
    // ------------------------------------------
    parentEntity.setAf2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a B
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovGASTWD
   */
  public GovGASTWD assignB(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning B as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the B to the parent entity
    // ------------------------------------------
    parentEntity.setB(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignB(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B on the parent entithy
    // ------------------------------------------
    parentEntity.setB(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Bf1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGASTWD
   */
  public GovGASTWD assignBf1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Bf1 as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Bf1 to the parent entity
    // ------------------------------------------
    parentEntity.setBf1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bf1
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignBf1(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bf1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bf1 on the parent entithy
    // ------------------------------------------
    parentEntity.setBf1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Bf2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGASTWD
   */
  public GovGASTWD assignBf2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Bf2 as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Bf2 to the parent entity
    // ------------------------------------------
    parentEntity.setBf2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bf2
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignBf2(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bf2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bf2 on the parent entithy
    // ------------------------------------------
    parentEntity.setBf2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a C
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovGASTWD
   */
  public GovGASTWD assignC(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning C as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the C to the parent entity
    // ------------------------------------------
    parentEntity.setC(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the C
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignC(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning C on " + parentEntity.toString());

    // ------------------------------------------
    // null out the C on the parent entithy
    // ------------------------------------------
    parentEntity.setC(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Cf2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGASTWD
   */
  public GovGASTWD assignCf2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Cf2 as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Cf2 to the parent entity
    // ------------------------------------------
    parentEntity.setCf2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Cf2
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignCf2(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Cf2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Cf2 on the parent entithy
    // ------------------------------------------
    parentEntity.setCf2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ecr
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGASTWD
   */
  public GovGASTWD assignEcr(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ecr as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ecr to the parent entity
    // ------------------------------------------
    parentEntity.setEcr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ecr
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignEcr(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ecr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ecr on the parent entithy
    // ------------------------------------------
    parentEntity.setEcr(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Etd
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGASTWD
   */
  public GovGASTWD assignEtd(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Etd as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Etd to the parent entity
    // ------------------------------------------
    parentEntity.setEtd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Etd
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignEtd(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Etd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Etd on the parent entithy
    // ------------------------------------------
    parentEntity.setEtd(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a K3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGASTWD
   */
  public GovGASTWD assignK3(UUID parentId, PU assignment) {
    LOGGER.info("assigning K3 as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the K3 to the parent entity
    // ------------------------------------------
    parentEntity.setK3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K3
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignK3(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K3 on the parent entithy
    // ------------------------------------------
    parentEntity.setK3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a K4
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGASTWD
   */
  public GovGASTWD assignK4(UUID parentId, PU assignment) {
    LOGGER.info("assigning K4 as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the K4 to the parent entity
    // ------------------------------------------
    parentEntity.setK4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K4
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignK4(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K4 on the parent entithy
    // ------------------------------------------
    parentEntity.setK4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a K5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGASTWD
   */
  public GovGASTWD assignK5(UUID parentId, PU assignment) {
    LOGGER.info("assigning K5 as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the K5 to the parent entity
    // ------------------------------------------
    parentEntity.setK5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K5
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignK5(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K5 on the parent entithy
    // ------------------------------------------
    parentEntity.setK5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a K6
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGASTWD
   */
  public GovGASTWD assignK6(UUID parentId, PU assignment) {
    LOGGER.info("assigning K6 as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the K6 to the parent entity
    // ------------------------------------------
    parentEntity.setK6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K6
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignK6(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K6 on the parent entithy
    // ------------------------------------------
    parentEntity.setK6(null);

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
   * @return	GovGASTWD
   */
  public GovGASTWD assignKd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kd as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
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
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignKd(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

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
   * Assign a Kdroop
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGASTWD
   */
  public GovGASTWD assignKdroop(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kdroop as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kdroop to the parent entity
    // ------------------------------------------
    parentEntity.setKdroop(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kdroop
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignKdroop(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kdroop on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kdroop on the parent entithy
    // ------------------------------------------
    parentEntity.setKdroop(null);

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
   * @return	GovGASTWD
   */
  public GovGASTWD assignKf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
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
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignKf(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

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
   * @return	GovGASTWD
   */
  public GovGASTWD assignKi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
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
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignKi(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

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
   * @return	GovGASTWD
   */
  public GovGASTWD assignKp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kp as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
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
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignKp(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

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
   * @return	GovGASTWD
   */
  public GovGASTWD assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
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
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignMwbase(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

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
   * Assign a T
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGASTWD
   */
  public GovGASTWD assignT(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T to the parent entity
    // ------------------------------------------
    parentEntity.setT(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignT(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T on the parent entithy
    // ------------------------------------------
    parentEntity.setT(null);

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
   * @return	GovGASTWD
   */
  public GovGASTWD assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
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
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignT3(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

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
   * Assign a T4
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGASTWD
   */
  public GovGASTWD assignT4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4 as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T4 to the parent entity
    // ------------------------------------------
    parentEntity.setT4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T4
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignT4(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T4 on the parent entithy
    // ------------------------------------------
    parentEntity.setT4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T5
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGASTWD
   */
  public GovGASTWD assignT5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T5 as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T5 to the parent entity
    // ------------------------------------------
    parentEntity.setT5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T5
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignT5(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T5 on the parent entithy
    // ------------------------------------------
    parentEntity.setT5(null);

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
   * @param	assignment 	Temperature
   * @return	GovGASTWD
   */
  public GovGASTWD assignTc(UUID parentId, Temperature assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = TemperatureProjector.find(assignment.getTemperatureId());

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
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignTc(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

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
   * Assign a Tcd
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGASTWD
   */
  public GovGASTWD assignTcd(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tcd as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tcd to the parent entity
    // ------------------------------------------
    parentEntity.setTcd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tcd
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignTcd(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tcd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tcd on the parent entithy
    // ------------------------------------------
    parentEntity.setTcd(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Td
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGASTWD
   */
  public GovGASTWD assignTd(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Td as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Td to the parent entity
    // ------------------------------------------
    parentEntity.setTd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Td
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignTd(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Td on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Td on the parent entithy
    // ------------------------------------------
    parentEntity.setTd(null);

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
   * @return	GovGASTWD
   */
  public GovGASTWD assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
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
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignTf(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

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
   * Assign a Tmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGASTWD
   */
  public GovGASTWD assignTmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Tmax as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Tmax to the parent entity
    // ------------------------------------------
    parentEntity.setTmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tmax
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignTmax(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tmax on the parent entithy
    // ------------------------------------------
    parentEntity.setTmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGASTWD
   */
  public GovGASTWD assignTmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Tmin as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Tmin to the parent entity
    // ------------------------------------------
    parentEntity.setTmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tmin
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignTmin(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tmin on the parent entithy
    // ------------------------------------------
    parentEntity.setTmin(null);

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
   * @param	assignment 	Temperature
   * @return	GovGASTWD
   */
  public GovGASTWD assignTr(UUID parentId, Temperature assignment) {
    LOGGER.info("assigning Tr as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = TemperatureProjector.find(assignment.getTemperatureId());

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
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignTr(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

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

  /*
   * Assign a Trate
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GovGASTWD
   */
  public GovGASTWD assignTrate(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Trate as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the Trate to the parent entity
    // ------------------------------------------
    parentEntity.setTrate(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Trate
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignTrate(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Trate on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Trate on the parent entithy
    // ------------------------------------------
    parentEntity.setTrate(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGASTWD
   */
  public GovGASTWD assignTt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tt as " + assignment.toString());

    GovGASTWD parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tt to the parent entity
    // ------------------------------------------
    parentEntity.setTt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tt
   *
   * @param	parentId		UUID
   * @return	GovGASTWD
   */
  public GovGASTWD unAssignTt(UUID parentId) {
    GovGASTWD parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tt on the parent entithy
    // ------------------------------------------
    parentEntity.setTt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovGASTWD via an FindGovGASTWDQuery
   *
   * @return query FindGovGASTWDQuery
   */
  @SuppressWarnings("unused")
  public GovGASTWD find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovGASTWD - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovGASTWDs
   *
   * @param query FindAllGovGASTWDQuery
   * @return List<GovGASTWD>
   */
  @SuppressWarnings("unused")
  public List<GovGASTWD> findAll(FindAllGovGASTWDQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovGASTWD - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovGASTWDRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

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
  @Qualifier(value = "activePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ActivePowerEntityProjector
      ActivePowerProjector;

  @Autowired
  @Qualifier(value = "temperature-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .TemperatureEntityProjector
      TemperatureProjector;

  private static final Logger LOGGER = Logger.getLogger(GovGASTWDEntityProjector.class.getName());
}
