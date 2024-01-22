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
 * Projector for GovSteamFV3 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovSteamFV3Aggregate
 *
 * @author your_name_here
 */
@Component("govSteamFV3-entity-projector")
public class GovSteamFV3EntityProjector {

  // core constructor
  public GovSteamFV3EntityProjector(GovSteamFV3Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovSteamFV3
   *
   * @param	entity GovSteamFV3
   */
  public GovSteamFV3 create(GovSteamFV3 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovSteamFV3
   *
   * @param	entity GovSteamFV3
   */
  public GovSteamFV3 update(GovSteamFV3 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovSteamFV3
   *
   * @param	id		UUID
   */
  public GovSteamFV3 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovSteamFV3 entity = repository.findById(id).get();

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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignK(UUID parentId, PU assignment) {
    LOGGER.info("assigning K as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignK(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	PU
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignK1(UUID parentId, PU assignment) {
    LOGGER.info("assigning K1 as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignK1(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	PU
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignK2(UUID parentId, PU assignment) {
    LOGGER.info("assigning K2 as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignK2(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	PU
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignK3(UUID parentId, PU assignment) {
    LOGGER.info("assigning K3 as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignK3(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Mwbase
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignMwbase(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignPmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmax as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignPmax(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignPmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmin as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignPmin(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Prmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignPrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Prmax as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Prmax to the parent entity
    // ------------------------------------------
    parentEntity.setPrmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Prmax
   *
   * @param	parentId		UUID
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignPrmax(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Prmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Prmax on the parent entithy
    // ------------------------------------------
    parentEntity.setPrmax(null);

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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignT1(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignT2(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignT3(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignT4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4 as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignT4(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignT5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T5 as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignT5(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignT6(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T6 as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignT6(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Ta
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignTa(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignTb(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignTc(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Uc
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignUc(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Uc as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignUc(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 assignUo(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Uo as " + assignment.toString());

    GovSteamFV3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV3
   */
  public GovSteamFV3 unAssignUo(UUID parentId) {
    GovSteamFV3 parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the GovSteamFV3 via an FindGovSteamFV3Query
   *
   * @return query FindGovSteamFV3Query
   */
  @SuppressWarnings("unused")
  public GovSteamFV3 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovSteamFV3 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovSteamFV3s
   *
   * @param query FindAllGovSteamFV3Query
   * @return List<GovSteamFV3>
   */
  @SuppressWarnings("unused")
  public List<GovSteamFV3> findAll(FindAllGovSteamFV3Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovSteamFV3 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovSteamFV3Repository repository;

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

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  private static final Logger LOGGER = Logger.getLogger(GovSteamFV3EntityProjector.class.getName());
}
