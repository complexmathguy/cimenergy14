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
 * Projector for ExcIEEEAC2A as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcIEEEAC2AAggregate
 *
 * @author your_name_here
 */
@Component("excIEEEAC2A-entity-projector")
public class ExcIEEEAC2AEntityProjector {

  // core constructor
  public ExcIEEEAC2AEntityProjector(ExcIEEEAC2ARepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcIEEEAC2A
   *
   * @param	entity ExcIEEEAC2A
   */
  public ExcIEEEAC2A create(ExcIEEEAC2A entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcIEEEAC2A
   *
   * @param	entity ExcIEEEAC2A
   */
  public ExcIEEEAC2A update(ExcIEEEAC2A entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcIEEEAC2A
   *
   * @param	id		UUID
   */
  public ExcIEEEAC2A delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcIEEEAC2A entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Ka
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignKa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ka to the parent entity
    // ------------------------------------------
    parentEntity.setKa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ka
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignKa(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ka on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ka on the parent entithy
    // ------------------------------------------
    parentEntity.setKa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kb
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignKb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kb as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kb to the parent entity
    // ------------------------------------------
    parentEntity.setKb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kb
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignKb(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kb on the parent entithy
    // ------------------------------------------
    parentEntity.setKb(null);

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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignKc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kc as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignKc(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignKd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kd as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignKd(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignKe(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ke as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignKe(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * Assign a Kf
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignKf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignKf(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignKh(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kh as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignKh(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * Assign a Seve1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignSeve1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Seve1 as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignSeve1(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignSeve2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Seve2 as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignSeve2(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * Assign a Ta
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignTa(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignTb(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignTc(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * Assign a Te
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignTe(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignTf(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignVamax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vamax as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignVamax(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignVamin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vamin as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignVamin(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignVe1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ve1 as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignVe1(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignVe2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ve2 as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignVe2(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * Assign a Vfemax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignVfemax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vfemax as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignVfemax(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignVrmax(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC2A
   */
  public ExcIEEEAC2A unAssignVrmin(UUID parentId) {
    ExcIEEEAC2A parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the ExcIEEEAC2A via an FindExcIEEEAC2AQuery
   *
   * @return query FindExcIEEEAC2AQuery
   */
  @SuppressWarnings("unused")
  public ExcIEEEAC2A find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcIEEEAC2A - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEAC2As
   *
   * @param query FindAllExcIEEEAC2AQuery
   * @return List<ExcIEEEAC2A>
   */
  @SuppressWarnings("unused")
  public List<ExcIEEEAC2A> findAll(FindAllExcIEEEAC2AQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcIEEEAC2A - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcIEEEAC2ARepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC2AEntityProjector.class.getName());
}
