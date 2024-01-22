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
 * Projector for GovGAST2 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovGAST2Aggregate
 *
 * @author your_name_here
 */
@Component("govGAST2-entity-projector")
public class GovGAST2EntityProjector {

  // core constructor
  public GovGAST2EntityProjector(GovGAST2Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovGAST2
   *
   * @param	entity GovGAST2
   */
  public GovGAST2 create(GovGAST2 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovGAST2
   *
   * @param	entity GovGAST2
   */
  public GovGAST2 update(GovGAST2 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovGAST2
   *
   * @param	id		UUID
   */
  public GovGAST2 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovGAST2 entity = repository.findById(id).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignA(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning A as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignA(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignAf1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Af1 as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignAf1(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignAf2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Af2 as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignAf2(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignB(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning B as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignB(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignBf1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Bf1 as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignBf1(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignBf2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Bf2 as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignBf2(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignC(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning C as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignC(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignCf2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Cf2 as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignCf2(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignEcr(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ecr as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignEcr(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignEtd(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Etd as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignEtd(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignK3(UUID parentId, PU assignment) {
    LOGGER.info("assigning K3 as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignK3(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignK4(UUID parentId, PU assignment) {
    LOGGER.info("assigning K4 as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignK4(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignK5(UUID parentId, PU assignment) {
    LOGGER.info("assigning K5 as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignK5(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignK6(UUID parentId, PU assignment) {
    LOGGER.info("assigning K6 as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignK6(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Kf
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGAST2
   */
  public GovGAST2 assignKf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignKf(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Mwbase
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GovGAST2
   */
  public GovGAST2 assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignMwbase(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignT(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignT(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignT3(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignT4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4 as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignT4(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignT5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T5 as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignT5(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignTc(UUID parentId, Temperature assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignTc(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignTcd(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tcd as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignTcd(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tf
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST2
   */
  public GovGAST2 assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignTf(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignTmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Tmax as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignTmax(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignTmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Tmin as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignTmin(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignTr(UUID parentId, Temperature assignment) {
    LOGGER.info("assigning Tr as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignTr(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignTrate(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Trate as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignTrate(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST2
   */
  public GovGAST2 assignTt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tt as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST2
   */
  public GovGAST2 unAssignTt(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

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

  /*
   * Assign a W
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGAST2
   */
  public GovGAST2 assignW(UUID parentId, PU assignment) {
    LOGGER.info("assigning W as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the W to the parent entity
    // ------------------------------------------
    parentEntity.setW(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the W
   *
   * @param	parentId		UUID
   * @return	GovGAST2
   */
  public GovGAST2 unAssignW(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning W on " + parentEntity.toString());

    // ------------------------------------------
    // null out the W on the parent entithy
    // ------------------------------------------
    parentEntity.setW(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a X
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST2
   */
  public GovGAST2 assignX(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning X as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the X to the parent entity
    // ------------------------------------------
    parentEntity.setX(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X
   *
   * @param	parentId		UUID
   * @return	GovGAST2
   */
  public GovGAST2 unAssignX(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X on the parent entithy
    // ------------------------------------------
    parentEntity.setX(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Y
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST2
   */
  public GovGAST2 assignY(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Y as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Y to the parent entity
    // ------------------------------------------
    parentEntity.setY(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Y
   *
   * @param	parentId		UUID
   * @return	GovGAST2
   */
  public GovGAST2 unAssignY(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Y on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Y on the parent entithy
    // ------------------------------------------
    parentEntity.setY(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Z
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	GovGAST2
   */
  public GovGAST2 assignZ(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Z as " + assignment.toString());

    GovGAST2 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Z to the parent entity
    // ------------------------------------------
    parentEntity.setZ(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Z
   *
   * @param	parentId		UUID
   * @return	GovGAST2
   */
  public GovGAST2 unAssignZ(UUID parentId) {
    GovGAST2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Z on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Z on the parent entithy
    // ------------------------------------------
    parentEntity.setZ(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovGAST2 via an FindGovGAST2Query
   *
   * @return query FindGovGAST2Query
   */
  @SuppressWarnings("unused")
  public GovGAST2 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovGAST2 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovGAST2s
   *
   * @param query FindAllGovGAST2Query
   * @return List<GovGAST2>
   */
  @SuppressWarnings("unused")
  public List<GovGAST2> findAll(FindAllGovGAST2Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovGAST2 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovGAST2Repository repository;

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

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  private static final Logger LOGGER = Logger.getLogger(GovGAST2EntityProjector.class.getName());
}
