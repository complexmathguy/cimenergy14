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
 * Projector for GovSteamFV4 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovSteamFV4Aggregate
 *
 * @author your_name_here
 */
@Component("govSteamFV4-entity-projector")
public class GovSteamFV4EntityProjector {

  // core constructor
  public GovSteamFV4EntityProjector(GovSteamFV4Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovSteamFV4
   *
   * @param	entity GovSteamFV4
   */
  public GovSteamFV4 create(GovSteamFV4 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovSteamFV4
   *
   * @param	entity GovSteamFV4
   */
  public GovSteamFV4 update(GovSteamFV4 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovSteamFV4
   *
   * @param	id		UUID
   */
  public GovSteamFV4 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovSteamFV4 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Cpsmn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignCpsmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Cpsmn as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Cpsmn to the parent entity
    // ------------------------------------------
    parentEntity.setCpsmn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Cpsmn
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignCpsmn(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Cpsmn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Cpsmn on the parent entithy
    // ------------------------------------------
    parentEntity.setCpsmn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Cpsmx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignCpsmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Cpsmx as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Cpsmx to the parent entity
    // ------------------------------------------
    parentEntity.setCpsmx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Cpsmx
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignCpsmx(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Cpsmx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Cpsmx on the parent entithy
    // ------------------------------------------
    parentEntity.setCpsmx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Crmn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignCrmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Crmn as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Crmn to the parent entity
    // ------------------------------------------
    parentEntity.setCrmn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Crmn
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignCrmn(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Crmn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Crmn on the parent entithy
    // ------------------------------------------
    parentEntity.setCrmn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Crmx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignCrmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Crmx as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Crmx to the parent entity
    // ------------------------------------------
    parentEntity.setCrmx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Crmx
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignCrmx(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Crmx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Crmx on the parent entithy
    // ------------------------------------------
    parentEntity.setCrmx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kdc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignKdc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kdc as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kdc to the parent entity
    // ------------------------------------------
    parentEntity.setKdc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kdc
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignKdc(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kdc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kdc on the parent entithy
    // ------------------------------------------
    parentEntity.setKdc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kf1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignKf1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf1 as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kf1 to the parent entity
    // ------------------------------------------
    parentEntity.setKf1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kf1
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignKf1(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kf1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kf1 on the parent entithy
    // ------------------------------------------
    parentEntity.setKf1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kf3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignKf3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf3 as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kf3 to the parent entity
    // ------------------------------------------
    parentEntity.setKf3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kf3
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignKf3(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kf3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kf3 on the parent entithy
    // ------------------------------------------
    parentEntity.setKf3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Khp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignKhp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Khp as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Khp to the parent entity
    // ------------------------------------------
    parentEntity.setKhp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Khp
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignKhp(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Khp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Khp on the parent entithy
    // ------------------------------------------
    parentEntity.setKhp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kic
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignKic(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kic as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kic to the parent entity
    // ------------------------------------------
    parentEntity.setKic(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kic
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignKic(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kic on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kic on the parent entithy
    // ------------------------------------------
    parentEntity.setKic(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kip
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignKip(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kip as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kip to the parent entity
    // ------------------------------------------
    parentEntity.setKip(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kip
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignKip(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kip on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kip on the parent entithy
    // ------------------------------------------
    parentEntity.setKip(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kit
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignKit(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kit as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kit to the parent entity
    // ------------------------------------------
    parentEntity.setKit(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kit
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignKit(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kit on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kit on the parent entithy
    // ------------------------------------------
    parentEntity.setKit(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kmp1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignKmp1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kmp1 as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kmp1 to the parent entity
    // ------------------------------------------
    parentEntity.setKmp1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kmp1
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignKmp1(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kmp1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kmp1 on the parent entithy
    // ------------------------------------------
    parentEntity.setKmp1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kmp2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignKmp2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kmp2 as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kmp2 to the parent entity
    // ------------------------------------------
    parentEntity.setKmp2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kmp2
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignKmp2(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kmp2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kmp2 on the parent entithy
    // ------------------------------------------
    parentEntity.setKmp2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignKpc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpc as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpc to the parent entity
    // ------------------------------------------
    parentEntity.setKpc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpc
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignKpc(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpc on the parent entithy
    // ------------------------------------------
    parentEntity.setKpc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignKpp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpp as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpp to the parent entity
    // ------------------------------------------
    parentEntity.setKpp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpp
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignKpp(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpp on the parent entithy
    // ------------------------------------------
    parentEntity.setKpp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpt
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignKpt(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpt as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpt to the parent entity
    // ------------------------------------------
    parentEntity.setKpt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpt
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignKpt(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpt on the parent entithy
    // ------------------------------------------
    parentEntity.setKpt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Krc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignKrc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Krc as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Krc to the parent entity
    // ------------------------------------------
    parentEntity.setKrc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Krc
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignKrc(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Krc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Krc on the parent entithy
    // ------------------------------------------
    parentEntity.setKrc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ksh
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignKsh(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ksh as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ksh to the parent entity
    // ------------------------------------------
    parentEntity.setKsh(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ksh
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignKsh(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ksh on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ksh on the parent entithy
    // ------------------------------------------
    parentEntity.setKsh(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Lpi
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignLpi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Lpi as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Lpi to the parent entity
    // ------------------------------------------
    parentEntity.setLpi(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Lpi
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignLpi(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Lpi on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Lpi on the parent entithy
    // ------------------------------------------
    parentEntity.setLpi(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Lps
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignLps(UUID parentId, PU assignment) {
    LOGGER.info("assigning Lps as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Lps to the parent entity
    // ------------------------------------------
    parentEntity.setLps(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Lps
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignLps(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Lps on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Lps on the parent entithy
    // ------------------------------------------
    parentEntity.setLps(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mnef
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignMnef(UUID parentId, PU assignment) {
    LOGGER.info("assigning Mnef as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Mnef to the parent entity
    // ------------------------------------------
    parentEntity.setMnef(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mnef
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignMnef(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mnef on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mnef on the parent entithy
    // ------------------------------------------
    parentEntity.setMnef(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mxef
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignMxef(UUID parentId, PU assignment) {
    LOGGER.info("assigning Mxef as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Mxef to the parent entity
    // ------------------------------------------
    parentEntity.setMxef(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mxef
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignMxef(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mxef on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mxef on the parent entithy
    // ------------------------------------------
    parentEntity.setMxef(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pr1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignPr1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pr1 as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pr1 to the parent entity
    // ------------------------------------------
    parentEntity.setPr1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pr1
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignPr1(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pr1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pr1 on the parent entithy
    // ------------------------------------------
    parentEntity.setPr1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pr2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignPr2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pr2 as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pr2 to the parent entity
    // ------------------------------------------
    parentEntity.setPr2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pr2
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignPr2(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pr2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pr2 on the parent entithy
    // ------------------------------------------
    parentEntity.setPr2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Psmn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignPsmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Psmn as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Psmn to the parent entity
    // ------------------------------------------
    parentEntity.setPsmn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Psmn
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignPsmn(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Psmn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Psmn on the parent entithy
    // ------------------------------------------
    parentEntity.setPsmn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rsmimn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignRsmimn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rsmimn as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rsmimn to the parent entity
    // ------------------------------------------
    parentEntity.setRsmimn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rsmimn
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignRsmimn(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rsmimn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rsmimn on the parent entithy
    // ------------------------------------------
    parentEntity.setRsmimn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rsmimx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignRsmimx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rsmimx as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rsmimx to the parent entity
    // ------------------------------------------
    parentEntity.setRsmimx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rsmimx
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignRsmimx(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rsmimx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rsmimx on the parent entithy
    // ------------------------------------------
    parentEntity.setRsmimx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rvgmn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignRvgmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rvgmn as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rvgmn to the parent entity
    // ------------------------------------------
    parentEntity.setRvgmn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rvgmn
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignRvgmn(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rvgmn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rvgmn on the parent entithy
    // ------------------------------------------
    parentEntity.setRvgmn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rvgmx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignRvgmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rvgmx as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rvgmx to the parent entity
    // ------------------------------------------
    parentEntity.setRvgmx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rvgmx
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignRvgmx(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rvgmx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rvgmx on the parent entithy
    // ------------------------------------------
    parentEntity.setRvgmx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Srmn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignSrmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Srmn as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Srmn to the parent entity
    // ------------------------------------------
    parentEntity.setSrmn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Srmn
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignSrmn(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Srmn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Srmn on the parent entithy
    // ------------------------------------------
    parentEntity.setSrmn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Srmx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignSrmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Srmx as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Srmx to the parent entity
    // ------------------------------------------
    parentEntity.setSrmx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Srmx
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignSrmx(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Srmx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Srmx on the parent entithy
    // ------------------------------------------
    parentEntity.setSrmx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Srsmp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignSrsmp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Srsmp as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Srsmp to the parent entity
    // ------------------------------------------
    parentEntity.setSrsmp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Srsmp
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignSrsmp(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Srsmp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Srsmp on the parent entithy
    // ------------------------------------------
    parentEntity.setSrsmp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Svmn
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignSvmn(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Svmn as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Svmn to the parent entity
    // ------------------------------------------
    parentEntity.setSvmn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Svmn
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignSvmn(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Svmn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Svmn on the parent entithy
    // ------------------------------------------
    parentEntity.setSvmn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Svmx
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignSvmx(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Svmx as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Svmx to the parent entity
    // ------------------------------------------
    parentEntity.setSvmx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Svmx
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignSvmx(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Svmx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Svmx on the parent entithy
    // ------------------------------------------
    parentEntity.setSvmx(null);

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
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignTa(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tam
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignTam(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tam as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tam to the parent entity
    // ------------------------------------------
    parentEntity.setTam(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tam
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignTam(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tam on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tam on the parent entithy
    // ------------------------------------------
    parentEntity.setTam(null);

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
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignTc(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tcm
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignTcm(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tcm as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tcm to the parent entity
    // ------------------------------------------
    parentEntity.setTcm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tcm
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignTcm(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tcm on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tcm on the parent entithy
    // ------------------------------------------
    parentEntity.setTcm(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tdc
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignTdc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tdc as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tdc to the parent entity
    // ------------------------------------------
    parentEntity.setTdc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tdc
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignTdc(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tdc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tdc on the parent entithy
    // ------------------------------------------
    parentEntity.setTdc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tf1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignTf1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf1 as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tf1 to the parent entity
    // ------------------------------------------
    parentEntity.setTf1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tf1
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignTf1(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tf1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tf1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTf1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tf2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignTf2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf2 as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tf2 to the parent entity
    // ------------------------------------------
    parentEntity.setTf2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tf2
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignTf2(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tf2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tf2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTf2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Thp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignThp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Thp as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Thp to the parent entity
    // ------------------------------------------
    parentEntity.setThp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Thp
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignThp(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Thp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Thp on the parent entithy
    // ------------------------------------------
    parentEntity.setThp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tmp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignTmp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tmp as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tmp to the parent entity
    // ------------------------------------------
    parentEntity.setTmp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tmp
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignTmp(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tmp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tmp on the parent entithy
    // ------------------------------------------
    parentEntity.setTmp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Trh
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignTrh(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Trh as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Trh to the parent entity
    // ------------------------------------------
    parentEntity.setTrh(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Trh
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignTrh(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Trh on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Trh on the parent entithy
    // ------------------------------------------
    parentEntity.setTrh(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tv
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignTv(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tv as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tv to the parent entity
    // ------------------------------------------
    parentEntity.setTv(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tv
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignTv(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tv on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tv on the parent entithy
    // ------------------------------------------
    parentEntity.setTv(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ty
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignTy(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ty as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ty to the parent entity
    // ------------------------------------------
    parentEntity.setTy(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ty
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignTy(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ty on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ty on the parent entithy
    // ------------------------------------------
    parentEntity.setTy(null);

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
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignY(UUID parentId, PU assignment) {
    LOGGER.info("assigning Y as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

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
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignY(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

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
   * Assign a Yhpmn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignYhpmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Yhpmn as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Yhpmn to the parent entity
    // ------------------------------------------
    parentEntity.setYhpmn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Yhpmn
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignYhpmn(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Yhpmn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Yhpmn on the parent entithy
    // ------------------------------------------
    parentEntity.setYhpmn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Yhpmx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignYhpmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Yhpmx as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Yhpmx to the parent entity
    // ------------------------------------------
    parentEntity.setYhpmx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Yhpmx
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignYhpmx(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Yhpmx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Yhpmx on the parent entithy
    // ------------------------------------------
    parentEntity.setYhpmx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ympmn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignYmpmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ympmn as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ympmn to the parent entity
    // ------------------------------------------
    parentEntity.setYmpmn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ympmn
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignYmpmn(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ympmn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ympmn on the parent entithy
    // ------------------------------------------
    parentEntity.setYmpmn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ympmx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV4
   */
  public GovSteamFV4 assignYmpmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ympmx as " + assignment.toString());

    GovSteamFV4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ympmx to the parent entity
    // ------------------------------------------
    parentEntity.setYmpmx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ympmx
   *
   * @param	parentId		UUID
   * @return	GovSteamFV4
   */
  public GovSteamFV4 unAssignYmpmx(UUID parentId) {
    GovSteamFV4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ympmx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ympmx on the parent entithy
    // ------------------------------------------
    parentEntity.setYmpmx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovSteamFV4 via an FindGovSteamFV4Query
   *
   * @return query FindGovSteamFV4Query
   */
  @SuppressWarnings("unused")
  public GovSteamFV4 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovSteamFV4 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovSteamFV4s
   *
   * @param query FindAllGovSteamFV4Query
   * @return List<GovSteamFV4>
   */
  @SuppressWarnings("unused")
  public List<GovSteamFV4> findAll(FindAllGovSteamFV4Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovSteamFV4 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovSteamFV4Repository repository;

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
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(GovSteamFV4EntityProjector.class.getName());
}
