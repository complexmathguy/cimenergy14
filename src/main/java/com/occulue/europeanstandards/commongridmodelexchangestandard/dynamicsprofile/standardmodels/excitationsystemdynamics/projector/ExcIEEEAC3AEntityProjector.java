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
 * Projector for ExcIEEEAC3A as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcIEEEAC3AAggregate
 *
 * @author your_name_here
 */
@Component("excIEEEAC3A-entity-projector")
public class ExcIEEEAC3AEntityProjector {

  // core constructor
  public ExcIEEEAC3AEntityProjector(ExcIEEEAC3ARepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcIEEEAC3A
   *
   * @param	entity ExcIEEEAC3A
   */
  public ExcIEEEAC3A create(ExcIEEEAC3A entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcIEEEAC3A
   *
   * @param	entity ExcIEEEAC3A
   */
  public ExcIEEEAC3A update(ExcIEEEAC3A entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcIEEEAC3A
   *
   * @param	id		UUID
   */
  public ExcIEEEAC3A delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcIEEEAC3A entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Efdn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignEfdn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efdn as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efdn to the parent entity
    // ------------------------------------------
    parentEntity.setEfdn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efdn
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignEfdn(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efdn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efdn on the parent entithy
    // ------------------------------------------
    parentEntity.setEfdn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ka
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignKa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignKa(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * Assign a Kc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignKc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kc as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignKc(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignKd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kd as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignKd(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignKe(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ke as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignKe(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignKf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignKf(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * Assign a Kn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignKn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kn as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kn to the parent entity
    // ------------------------------------------
    parentEntity.setKn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kn
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignKn(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kn on the parent entithy
    // ------------------------------------------
    parentEntity.setKn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignKr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kr as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kr to the parent entity
    // ------------------------------------------
    parentEntity.setKr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kr
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignKr(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kr on the parent entithy
    // ------------------------------------------
    parentEntity.setKr(null);

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignSeve1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Seve1 as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignSeve1(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignSeve2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Seve2 as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignSeve2(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignTa(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignTb(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignTc(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignTe(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignTf(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignVamax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vamax as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignVamax(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignVamin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vamin as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignVamin(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignVe1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ve1 as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignVe1(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignVe2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ve2 as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignVe2(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignVemin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vemin as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignVemin(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A assignVfemax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vfemax as " + assignment.toString());

    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEAC3A
   */
  public ExcIEEEAC3A unAssignVfemax(UUID parentId) {
    ExcIEEEAC3A parentEntity = repository.findById(parentId).get();

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

  /**
   * Method to retrieve the ExcIEEEAC3A via an FindExcIEEEAC3AQuery
   *
   * @return query FindExcIEEEAC3AQuery
   */
  @SuppressWarnings("unused")
  public ExcIEEEAC3A find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcIEEEAC3A - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEAC3As
   *
   * @param query FindAllExcIEEEAC3AQuery
   * @return List<ExcIEEEAC3A>
   */
  @SuppressWarnings("unused")
  public List<ExcIEEEAC3A> findAll(FindAllExcIEEEAC3AQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcIEEEAC3A - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcIEEEAC3ARepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC3AEntityProjector.class.getName());
}
