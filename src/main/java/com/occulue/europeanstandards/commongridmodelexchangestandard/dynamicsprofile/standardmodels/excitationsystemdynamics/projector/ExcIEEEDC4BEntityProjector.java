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
 * Projector for ExcIEEEDC4B as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcIEEEDC4BAggregate
 *
 * @author your_name_here
 */
@Component("excIEEEDC4B-entity-projector")
public class ExcIEEEDC4BEntityProjector {

  // core constructor
  public ExcIEEEDC4BEntityProjector(ExcIEEEDC4BRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcIEEEDC4B
   *
   * @param	entity ExcIEEEDC4B
   */
  public ExcIEEEDC4B create(ExcIEEEDC4B entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcIEEEDC4B
   *
   * @param	entity ExcIEEEDC4B
   */
  public ExcIEEEDC4B update(ExcIEEEDC4B entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcIEEEDC4B
   *
   * @param	id		UUID
   */
  public ExcIEEEDC4B delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcIEEEDC4B entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Efd1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignEfd1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efd1 as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efd1 to the parent entity
    // ------------------------------------------
    parentEntity.setEfd1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efd1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignEfd1(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efd1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efd1 on the parent entithy
    // ------------------------------------------
    parentEntity.setEfd1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Efd2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignEfd2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efd2 as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efd2 to the parent entity
    // ------------------------------------------
    parentEntity.setEfd2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efd2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignEfd2(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efd2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efd2 on the parent entithy
    // ------------------------------------------
    parentEntity.setEfd2(null);

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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignKa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignKa(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

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
   * Assign a Kd
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignKd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kd as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignKd(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignKe(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ke as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignKe(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignKf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignKf(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignKi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignKi(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignKp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kp as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignKp(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

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
   * Assign a Oelin
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignOelin(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Oelin as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Oelin to the parent entity
    // ------------------------------------------
    parentEntity.setOelin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Oelin
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignOelin(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Oelin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Oelin on the parent entithy
    // ------------------------------------------
    parentEntity.setOelin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Seefd1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignSeefd1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Seefd1 as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Seefd1 to the parent entity
    // ------------------------------------------
    parentEntity.setSeefd1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Seefd1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignSeefd1(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Seefd1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Seefd1 on the parent entithy
    // ------------------------------------------
    parentEntity.setSeefd1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Seefd2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignSeefd2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Seefd2 as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Seefd2 to the parent entity
    // ------------------------------------------
    parentEntity.setSeefd2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Seefd2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignSeefd2(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Seefd2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Seefd2 on the parent entithy
    // ------------------------------------------
    parentEntity.setSeefd2(null);

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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignTa(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

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
   * Assign a Td
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignTd(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Td as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignTd(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

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
   * Assign a Te
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignTe(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignTf(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

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
   * Assign a Uelin
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignUelin(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Uelin as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Uelin to the parent entity
    // ------------------------------------------
    parentEntity.setUelin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Uelin
   *
   * @param	parentId		UUID
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignUelin(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Uelin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Uelin on the parent entithy
    // ------------------------------------------
    parentEntity.setUelin(null);

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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignVemin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vemin as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignVemin(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

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
   * Assign a Vrmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignVrmax(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEDC4B
   */
  public ExcIEEEDC4B unAssignVrmin(UUID parentId) {
    ExcIEEEDC4B parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the ExcIEEEDC4B via an FindExcIEEEDC4BQuery
   *
   * @return query FindExcIEEEDC4BQuery
   */
  @SuppressWarnings("unused")
  public ExcIEEEDC4B find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcIEEEDC4B - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEDC4Bs
   *
   * @param query FindAllExcIEEEDC4BQuery
   * @return List<ExcIEEEDC4B>
   */
  @SuppressWarnings("unused")
  public List<ExcIEEEDC4B> findAll(FindAllExcIEEEDC4BQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcIEEEDC4B - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcIEEEDC4BRepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

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

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC4BEntityProjector.class.getName());
}
