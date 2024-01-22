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
 * Projector for ExcIEEEAC7B as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcIEEEAC7BAggregate
 *
 * @author your_name_here
 */
@Component("excIEEEAC7B-entity-projector")
public class ExcIEEEAC7BEntityProjector {

  // core constructor
  public ExcIEEEAC7BEntityProjector(ExcIEEEAC7BRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcIEEEAC7B
   *
   * @param	entity ExcIEEEAC7B
   */
  public ExcIEEEAC7B create(ExcIEEEAC7B entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcIEEEAC7B
   *
   * @param	entity ExcIEEEAC7B
   */
  public ExcIEEEAC7B update(ExcIEEEAC7B entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcIEEEAC7B
   *
   * @param	id		UUID
   */
  public ExcIEEEAC7B delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcIEEEAC7B entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Kc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignKc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kc as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignKc(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignKd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kd as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignKd(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

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
   * Assign a Kdr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignKdr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kdr as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kdr to the parent entity
    // ------------------------------------------
    parentEntity.setKdr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kdr
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignKdr(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kdr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kdr on the parent entithy
    // ------------------------------------------
    parentEntity.setKdr(null);

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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignKe(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ke as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignKe(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

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
   * Assign a Kf1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignKf1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf1 as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignKf1(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

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
   * Assign a Kf2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignKf2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf2 as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kf2 to the parent entity
    // ------------------------------------------
    parentEntity.setKf2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kf2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignKf2(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kf2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kf2 on the parent entithy
    // ------------------------------------------
    parentEntity.setKf2(null);

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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignKf3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf3 as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignKf3(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

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
   * Assign a Kia
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignKia(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kia as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kia to the parent entity
    // ------------------------------------------
    parentEntity.setKia(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kia
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignKia(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kia on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kia on the parent entithy
    // ------------------------------------------
    parentEntity.setKia(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kir
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignKir(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kir as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kir to the parent entity
    // ------------------------------------------
    parentEntity.setKir(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kir
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignKir(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kir on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kir on the parent entithy
    // ------------------------------------------
    parentEntity.setKir(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kl
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignKl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kl as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kl to the parent entity
    // ------------------------------------------
    parentEntity.setKl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kl
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignKl(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kl on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kl on the parent entithy
    // ------------------------------------------
    parentEntity.setKl(null);

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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignKp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kp as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignKp(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

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
   * Assign a Kpa
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignKpa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpa as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpa to the parent entity
    // ------------------------------------------
    parentEntity.setKpa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpa
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignKpa(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpa on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpa on the parent entithy
    // ------------------------------------------
    parentEntity.setKpa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignKpr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpr as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpr to the parent entity
    // ------------------------------------------
    parentEntity.setKpr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpr
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignKpr(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpr on the parent entithy
    // ------------------------------------------
    parentEntity.setKpr(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Seve1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignSeve1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Seve1 as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Seve1 to the parent entity
    // ------------------------------------------
    parentEntity.setSeve1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Seve1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignSeve1(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Seve1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Seve1 on the parent entithy
    // ------------------------------------------
    parentEntity.setSeve1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Seve2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignSeve2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Seve2 as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Seve2 to the parent entity
    // ------------------------------------------
    parentEntity.setSeve2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Seve2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignSeve2(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Seve2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Seve2 on the parent entithy
    // ------------------------------------------
    parentEntity.setSeve2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tdr
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignTdr(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tdr as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tdr to the parent entity
    // ------------------------------------------
    parentEntity.setTdr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tdr
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignTdr(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tdr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tdr on the parent entithy
    // ------------------------------------------
    parentEntity.setTdr(null);

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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignTe(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignTf(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

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
   * Assign a Vamax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignVamax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vamax as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vamax to the parent entity
    // ------------------------------------------
    parentEntity.setVamax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vamax
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignVamax(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vamax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vamax on the parent entithy
    // ------------------------------------------
    parentEntity.setVamax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vamin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignVamin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vamin as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vamin to the parent entity
    // ------------------------------------------
    parentEntity.setVamin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vamin
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignVamin(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vamin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vamin on the parent entithy
    // ------------------------------------------
    parentEntity.setVamin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ve1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignVe1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ve1 as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ve1 to the parent entity
    // ------------------------------------------
    parentEntity.setVe1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ve1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignVe1(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ve1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ve1 on the parent entithy
    // ------------------------------------------
    parentEntity.setVe1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ve2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignVe2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ve2 as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ve2 to the parent entity
    // ------------------------------------------
    parentEntity.setVe2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ve2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignVe2(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ve2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ve2 on the parent entithy
    // ------------------------------------------
    parentEntity.setVe2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vemin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignVemin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vemin as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vemin to the parent entity
    // ------------------------------------------
    parentEntity.setVemin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vemin
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignVemin(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vemin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vemin on the parent entithy
    // ------------------------------------------
    parentEntity.setVemin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vfemax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignVfemax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vfemax as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vfemax to the parent entity
    // ------------------------------------------
    parentEntity.setVfemax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vfemax
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignVfemax(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vfemax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vfemax on the parent entithy
    // ------------------------------------------
    parentEntity.setVfemax(null);

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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignVrmax(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC7B
   */
  public ExcIEEEAC7B unAssignVrmin(UUID parentId) {
    ExcIEEEAC7B parentEntity = repository.findById(parentId).get();

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

  /**
   * Method to retrieve the ExcIEEEAC7B via an FindExcIEEEAC7BQuery
   *
   * @return query FindExcIEEEAC7BQuery
   */
  @SuppressWarnings("unused")
  public ExcIEEEAC7B find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcIEEEAC7B - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEAC7Bs
   *
   * @param query FindAllExcIEEEAC7BQuery
   * @return List<ExcIEEEAC7B>
   */
  @SuppressWarnings("unused")
  public List<ExcIEEEAC7B> findAll(FindAllExcIEEEAC7BQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcIEEEAC7B - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcIEEEAC7BRepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC7BEntityProjector.class.getName());
}
