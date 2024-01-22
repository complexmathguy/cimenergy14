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
 * Projector for ExcAC6A as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcAC6AAggregate
 *
 * @author your_name_here
 */
@Component("excAC6A-entity-projector")
public class ExcAC6AEntityProjector {

  // core constructor
  public ExcAC6AEntityProjector(ExcAC6ARepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcAC6A
   *
   * @param	entity ExcAC6A
   */
  public ExcAC6A create(ExcAC6A entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcAC6A
   *
   * @param	entity ExcAC6A
   */
  public ExcAC6A update(ExcAC6A entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcAC6A
   *
   * @param	id		UUID
   */
  public ExcAC6A delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcAC6A entity = repository.findById(id).get();

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
   * @return	ExcAC6A
   */
  public ExcAC6A assignKa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignKa(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAC6A
   */
  public ExcAC6A assignKc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kc as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignKc(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAC6A
   */
  public ExcAC6A assignKd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kd as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignKd(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAC6A
   */
  public ExcAC6A assignKe(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ke as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignKe(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * Assign a Kh
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAC6A
   */
  public ExcAC6A assignKh(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kh as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignKh(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * Assign a Ks
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAC6A
   */
  public ExcAC6A assignKs(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ks as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignKs(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * Assign a Seve1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcAC6A
   */
  public ExcAC6A assignSeve1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Seve1 as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignSeve1(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAC6A
   */
  public ExcAC6A assignSeve2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Seve2 as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignSeve2(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAC6A
   */
  public ExcAC6A assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignTa(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAC6A
   */
  public ExcAC6A assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignTb(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAC6A
   */
  public ExcAC6A assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignTc(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAC6A
   */
  public ExcAC6A assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignTe(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * Assign a Th
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAC6A
   */
  public ExcAC6A assignTh(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Th as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Th to the parent entity
    // ------------------------------------------
    parentEntity.setTh(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Th
   *
   * @param	parentId		UUID
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignTh(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Th on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Th on the parent entithy
    // ------------------------------------------
    parentEntity.setTh(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tj
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAC6A
   */
  public ExcAC6A assignTj(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tj as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tj to the parent entity
    // ------------------------------------------
    parentEntity.setTj(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tj
   *
   * @param	parentId		UUID
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignTj(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tj on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tj on the parent entithy
    // ------------------------------------------
    parentEntity.setTj(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tk
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAC6A
   */
  public ExcAC6A assignTk(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tk as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tk to the parent entity
    // ------------------------------------------
    parentEntity.setTk(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tk
   *
   * @param	parentId		UUID
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignTk(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tk on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tk on the parent entithy
    // ------------------------------------------
    parentEntity.setTk(null);

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
   * @return	ExcAC6A
   */
  public ExcAC6A assignVamax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vamax as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignVamax(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAC6A
   */
  public ExcAC6A assignVamin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vamin as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignVamin(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAC6A
   */
  public ExcAC6A assignVe1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ve1 as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignVe1(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAC6A
   */
  public ExcAC6A assignVe2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ve2 as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignVe2(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * Assign a Vfelim
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAC6A
   */
  public ExcAC6A assignVfelim(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vfelim as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vfelim to the parent entity
    // ------------------------------------------
    parentEntity.setVfelim(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vfelim
   *
   * @param	parentId		UUID
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignVfelim(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vfelim on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vfelim on the parent entithy
    // ------------------------------------------
    parentEntity.setVfelim(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vhmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAC6A
   */
  public ExcAC6A assignVhmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vhmax as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vhmax to the parent entity
    // ------------------------------------------
    parentEntity.setVhmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vhmax
   *
   * @param	parentId		UUID
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignVhmax(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vhmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vhmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVhmax(null);

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
   * @return	ExcAC6A
   */
  public ExcAC6A assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignVrmax(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAC6A
   */
  public ExcAC6A assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcAC6A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAC6A
   */
  public ExcAC6A unAssignVrmin(UUID parentId) {
    ExcAC6A parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the ExcAC6A via an FindExcAC6AQuery
   *
   * @return query FindExcAC6AQuery
   */
  @SuppressWarnings("unused")
  public ExcAC6A find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcAC6A - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcAC6As
   *
   * @param query FindAllExcAC6AQuery
   * @return List<ExcAC6A>
   */
  @SuppressWarnings("unused")
  public List<ExcAC6A> findAll(FindAllExcAC6AQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcAC6A - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcAC6ARepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcAC6AEntityProjector.class.getName());
}
