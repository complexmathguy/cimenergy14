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
 * Projector for GovSteamIEEE1 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovSteamIEEE1Aggregate
 *
 * @author your_name_here
 */
@Component("govSteamIEEE1-entity-projector")
public class GovSteamIEEE1EntityProjector {

  // core constructor
  public GovSteamIEEE1EntityProjector(GovSteamIEEE1Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovSteamIEEE1
   *
   * @param	entity GovSteamIEEE1
   */
  public GovSteamIEEE1 create(GovSteamIEEE1 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovSteamIEEE1
   *
   * @param	entity GovSteamIEEE1
   */
  public GovSteamIEEE1 update(GovSteamIEEE1 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovSteamIEEE1
   *
   * @param	id		UUID
   */
  public GovSteamIEEE1 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovSteamIEEE1 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a K
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignK(UUID parentId, PU assignment) {
    LOGGER.info("assigning K as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignK(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

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
   * Assign a K1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignK1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K1 as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the K1 to the parent entity
    // ------------------------------------------
    parentEntity.setK1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K1
   *
   * @param	parentId		UUID
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignK1(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K1 on the parent entithy
    // ------------------------------------------
    parentEntity.setK1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a K2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignK2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K2 as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the K2 to the parent entity
    // ------------------------------------------
    parentEntity.setK2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K2
   *
   * @param	parentId		UUID
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignK2(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K2 on the parent entithy
    // ------------------------------------------
    parentEntity.setK2(null);

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
   * @param	assignment 	Simple_Float
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignK3(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K3 as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignK3(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	Simple_Float
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignK4(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K4 as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignK4(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	Simple_Float
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignK5(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K5 as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignK5(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	Simple_Float
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignK6(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K6 as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignK6(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

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
   * Assign a K7
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignK7(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K7 as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the K7 to the parent entity
    // ------------------------------------------
    parentEntity.setK7(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K7
   *
   * @param	parentId		UUID
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignK7(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K7 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K7 on the parent entithy
    // ------------------------------------------
    parentEntity.setK7(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a K8
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignK8(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K8 as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the K8 to the parent entity
    // ------------------------------------------
    parentEntity.setK8(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K8
   *
   * @param	parentId		UUID
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignK8(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K8 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K8 on the parent entithy
    // ------------------------------------------
    parentEntity.setK8(null);

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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignMwbase(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Pmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignPmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmax as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignPmax(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignPmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmin as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignPmin(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

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
   * Assign a T1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignT1(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignT2(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignT3(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignT4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4 as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignT4(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignT5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T5 as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignT5(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

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
   * Assign a T6
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignT6(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T6 as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T6 to the parent entity
    // ------------------------------------------
    parentEntity.setT6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T6
   *
   * @param	parentId		UUID
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignT6(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T6 on the parent entithy
    // ------------------------------------------
    parentEntity.setT6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T7
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignT7(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T7 as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T7 to the parent entity
    // ------------------------------------------
    parentEntity.setT7(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T7
   *
   * @param	parentId		UUID
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignT7(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T7 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T7 on the parent entithy
    // ------------------------------------------
    parentEntity.setT7(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Uc
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignUc(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Uc as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Uc to the parent entity
    // ------------------------------------------
    parentEntity.setUc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Uc
   *
   * @param	parentId		UUID
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignUc(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Uc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Uc on the parent entithy
    // ------------------------------------------
    parentEntity.setUc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Uo
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 assignUo(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Uo as " + assignment.toString());

    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Uo to the parent entity
    // ------------------------------------------
    parentEntity.setUo(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Uo
   *
   * @param	parentId		UUID
   * @return	GovSteamIEEE1
   */
  public GovSteamIEEE1 unAssignUo(UUID parentId) {
    GovSteamIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Uo on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Uo on the parent entithy
    // ------------------------------------------
    parentEntity.setUo(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovSteamIEEE1 via an FindGovSteamIEEE1Query
   *
   * @return query FindGovSteamIEEE1Query
   */
  @SuppressWarnings("unused")
  public GovSteamIEEE1 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovSteamIEEE1 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovSteamIEEE1s
   *
   * @param query FindAllGovSteamIEEE1Query
   * @return List<GovSteamIEEE1>
   */
  @SuppressWarnings("unused")
  public List<GovSteamIEEE1> findAll(FindAllGovSteamIEEE1Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovSteamIEEE1 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovSteamIEEE1Repository repository;

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
      Logger.getLogger(GovSteamIEEE1EntityProjector.class.getName());
}
