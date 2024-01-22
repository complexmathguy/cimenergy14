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
 * Projector for ExcREXS as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcREXSAggregate
 *
 * @author your_name_here
 */
@Component("excREXS-entity-projector")
public class ExcREXSEntityProjector {

  // core constructor
  public ExcREXSEntityProjector(ExcREXSRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcREXS
   *
   * @param	entity ExcREXS
   */
  public ExcREXS create(ExcREXS entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcREXS
   *
   * @param	entity ExcREXS
   */
  public ExcREXS update(ExcREXS entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcREXS
   *
   * @param	id		UUID
   */
  public ExcREXS delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcREXS entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a E1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignE1(UUID parentId, PU assignment) {
    LOGGER.info("assigning E1 as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the E1 to the parent entity
    // ------------------------------------------
    parentEntity.setE1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the E1
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignE1(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning E1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the E1 on the parent entithy
    // ------------------------------------------
    parentEntity.setE1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a E2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignE2(UUID parentId, PU assignment) {
    LOGGER.info("assigning E2 as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the E2 to the parent entity
    // ------------------------------------------
    parentEntity.setE2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the E2
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignE2(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning E2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the E2 on the parent entithy
    // ------------------------------------------
    parentEntity.setE2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Flimf
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignFlimf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Flimf as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Flimf to the parent entity
    // ------------------------------------------
    parentEntity.setFlimf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Flimf
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignFlimf(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Flimf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Flimf on the parent entithy
    // ------------------------------------------
    parentEntity.setFlimf(null);

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
   * @return	ExcREXS
   */
  public ExcREXS assignKc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kc as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcREXS
   */
  public ExcREXS unAssignKc(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

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
   * Assign a Kd
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignKd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kd as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcREXS
   */
  public ExcREXS unAssignKd(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

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
   * Assign a Ke
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignKe(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ke as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ke to the parent entity
    // ------------------------------------------
    parentEntity.setKe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ke
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignKe(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ke on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ke on the parent entithy
    // ------------------------------------------
    parentEntity.setKe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kefd
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignKefd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kefd as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kefd to the parent entity
    // ------------------------------------------
    parentEntity.setKefd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kefd
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignKefd(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kefd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kefd on the parent entithy
    // ------------------------------------------
    parentEntity.setKefd(null);

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
   * @param	assignment 	Seconds
   * @return	ExcREXS
   */
  public ExcREXS assignKf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Kf as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

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
   * @return	ExcREXS
   */
  public ExcREXS unAssignKf(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

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
   * Assign a Kh
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignKh(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kh as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kh to the parent entity
    // ------------------------------------------
    parentEntity.setKh(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kh
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignKh(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kh on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kh on the parent entithy
    // ------------------------------------------
    parentEntity.setKh(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kii
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignKii(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kii as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kii to the parent entity
    // ------------------------------------------
    parentEntity.setKii(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kii
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignKii(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kii on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kii on the parent entithy
    // ------------------------------------------
    parentEntity.setKii(null);

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
   * @return	ExcREXS
   */
  public ExcREXS assignKip(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kip as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcREXS
   */
  public ExcREXS unAssignKip(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

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
   * Assign a Ks
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignKs(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ks as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcREXS
   */
  public ExcREXS unAssignKs(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

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
   * Assign a Kvi
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignKvi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kvi as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kvi to the parent entity
    // ------------------------------------------
    parentEntity.setKvi(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kvi
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignKvi(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kvi on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kvi on the parent entithy
    // ------------------------------------------
    parentEntity.setKvi(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kvp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignKvp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kvp as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kvp to the parent entity
    // ------------------------------------------
    parentEntity.setKvp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kvp
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignKvp(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kvp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kvp on the parent entithy
    // ------------------------------------------
    parentEntity.setKvp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kvphz
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignKvphz(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kvphz as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kvphz to the parent entity
    // ------------------------------------------
    parentEntity.setKvphz(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kvphz
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignKvphz(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kvphz on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kvphz on the parent entithy
    // ------------------------------------------
    parentEntity.setKvphz(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Nvphz
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignNvphz(UUID parentId, PU assignment) {
    LOGGER.info("assigning Nvphz as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Nvphz to the parent entity
    // ------------------------------------------
    parentEntity.setNvphz(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Nvphz
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignNvphz(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Nvphz on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Nvphz on the parent entithy
    // ------------------------------------------
    parentEntity.setNvphz(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Se1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignSe1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Se1 as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Se1 to the parent entity
    // ------------------------------------------
    parentEntity.setSe1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Se1
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignSe1(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Se1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Se1 on the parent entithy
    // ------------------------------------------
    parentEntity.setSe1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Se2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignSe2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Se2 as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Se2 to the parent entity
    // ------------------------------------------
    parentEntity.setSe2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Se2
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignSe2(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Se2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Se2 on the parent entithy
    // ------------------------------------------
    parentEntity.setSe2(null);

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
   * @return	ExcREXS
   */
  public ExcREXS assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcREXS
   */
  public ExcREXS unAssignTa(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

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
   * Assign a Tb1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcREXS
   */
  public ExcREXS assignTb1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb1 as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tb1 to the parent entity
    // ------------------------------------------
    parentEntity.setTb1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tb1
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignTb1(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tb1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tb1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTb1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tb2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcREXS
   */
  public ExcREXS assignTb2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb2 as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tb2 to the parent entity
    // ------------------------------------------
    parentEntity.setTb2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tb2
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignTb2(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tb2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tb2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTb2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tc1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcREXS
   */
  public ExcREXS assignTc1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc1 as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tc1 to the parent entity
    // ------------------------------------------
    parentEntity.setTc1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tc1
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignTc1(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tc1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tc1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTc1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tc2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcREXS
   */
  public ExcREXS assignTc2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc2 as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tc2 to the parent entity
    // ------------------------------------------
    parentEntity.setTc2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tc2
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignTc2(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tc2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tc2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTc2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Te
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcREXS
   */
  public ExcREXS assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Te to the parent entity
    // ------------------------------------------
    parentEntity.setTe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Te
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignTe(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Te on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Te on the parent entithy
    // ------------------------------------------
    parentEntity.setTe(null);

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
   * @return	ExcREXS
   */
  public ExcREXS assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcREXS
   */
  public ExcREXS unAssignTf(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

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
   * Assign a Tf1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcREXS
   */
  public ExcREXS assignTf1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf1 as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcREXS
   */
  public ExcREXS unAssignTf1(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

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
   * @return	ExcREXS
   */
  public ExcREXS assignTf2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf2 as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcREXS
   */
  public ExcREXS unAssignTf2(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

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
   * Assign a Tp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcREXS
   */
  public ExcREXS assignTp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tp as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tp to the parent entity
    // ------------------------------------------
    parentEntity.setTp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tp
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignTp(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tp on the parent entithy
    // ------------------------------------------
    parentEntity.setTp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vcmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignVcmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vcmax as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vcmax to the parent entity
    // ------------------------------------------
    parentEntity.setVcmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vcmax
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignVcmax(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vcmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vcmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVcmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vfmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignVfmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vfmax as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vfmax to the parent entity
    // ------------------------------------------
    parentEntity.setVfmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vfmax
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignVfmax(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vfmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vfmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVfmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vfmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignVfmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vfmin as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vfmin to the parent entity
    // ------------------------------------------
    parentEntity.setVfmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vfmin
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignVfmin(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vfmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vfmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVfmin(null);

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
   * @return	ExcREXS
   */
  public ExcREXS assignVimax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vimax as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcREXS
   */
  public ExcREXS unAssignVimax(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

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
   * Assign a Vrmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcREXS
   */
  public ExcREXS unAssignVrmax(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

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
   * @return	ExcREXS
   */
  public ExcREXS assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
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
   * @return	ExcREXS
   */
  public ExcREXS unAssignVrmin(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

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
   * Assign a Xc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcREXS
   */
  public ExcREXS assignXc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xc as " + assignment.toString());

    ExcREXS parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xc to the parent entity
    // ------------------------------------------
    parentEntity.setXc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xc
   *
   * @param	parentId		UUID
   * @return	ExcREXS
   */
  public ExcREXS unAssignXc(UUID parentId) {
    ExcREXS parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xc on the parent entithy
    // ------------------------------------------
    parentEntity.setXc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExcREXS via an FindExcREXSQuery
   *
   * @return query FindExcREXSQuery
   */
  @SuppressWarnings("unused")
  public ExcREXS find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcREXS - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcREXSs
   *
   * @param query FindAllExcREXSQuery
   * @return List<ExcREXS>
   */
  @SuppressWarnings("unused")
  public List<ExcREXS> findAll(FindAllExcREXSQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcREXS - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcREXSRepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcREXSEntityProjector.class.getName());
}
