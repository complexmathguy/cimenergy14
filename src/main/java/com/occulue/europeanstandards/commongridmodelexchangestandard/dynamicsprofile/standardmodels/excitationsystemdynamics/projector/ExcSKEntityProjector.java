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
 * Projector for ExcSK as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcSKAggregate
 *
 * @author your_name_here
 */
@Component("excSK-entity-projector")
public class ExcSKEntityProjector {

  // core constructor
  public ExcSKEntityProjector(ExcSKRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcSK
   *
   * @param	entity ExcSK
   */
  public ExcSK create(ExcSK entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcSK
   *
   * @param	entity ExcSK
   */
  public ExcSK update(ExcSK entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcSK
   *
   * @param	id		UUID
   */
  public ExcSK delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcSK entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Efdmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignEfdmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efdmax as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efdmax to the parent entity
    // ------------------------------------------
    parentEntity.setEfdmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efdmax
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignEfdmax(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efdmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efdmax on the parent entithy
    // ------------------------------------------
    parentEntity.setEfdmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Efdmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignEfdmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efdmin as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efdmin to the parent entity
    // ------------------------------------------
    parentEntity.setEfdmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efdmin
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignEfdmin(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efdmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efdmin on the parent entithy
    // ------------------------------------------
    parentEntity.setEfdmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Emax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignEmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Emax as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Emax to the parent entity
    // ------------------------------------------
    parentEntity.setEmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Emax
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignEmax(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Emax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Emax on the parent entithy
    // ------------------------------------------
    parentEntity.setEmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Emin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignEmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Emin as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Emin to the parent entity
    // ------------------------------------------
    parentEntity.setEmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Emin
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignEmin(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Emin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Emin on the parent entithy
    // ------------------------------------------
    parentEntity.setEmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a K
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignK(UUID parentId, PU assignment) {
    LOGGER.info("assigning K as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSK
   */
  public ExcSK unAssignK(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

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
   * @return	ExcSK
   */
  public ExcSK assignK1(UUID parentId, PU assignment) {
    LOGGER.info("assigning K1 as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSK
   */
  public ExcSK unAssignK1(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

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
   * @return	ExcSK
   */
  public ExcSK assignK2(UUID parentId, PU assignment) {
    LOGGER.info("assigning K2 as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSK
   */
  public ExcSK unAssignK2(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

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
   * Assign a Kc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignKc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kc as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSK
   */
  public ExcSK unAssignKc(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

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
   * Assign a Kce
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignKce(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kce as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kce to the parent entity
    // ------------------------------------------
    parentEntity.setKce(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kce
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignKce(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kce on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kce on the parent entithy
    // ------------------------------------------
    parentEntity.setKce(null);

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
   * @return	ExcSK
   */
  public ExcSK assignKd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kd as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSK
   */
  public ExcSK unAssignKd(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

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
   * Assign a Kgob
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignKgob(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kgob as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kgob to the parent entity
    // ------------------------------------------
    parentEntity.setKgob(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kgob
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignKgob(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kgob on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kgob on the parent entithy
    // ------------------------------------------
    parentEntity.setKgob(null);

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
   * @return	ExcSK
   */
  public ExcSK assignKp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kp as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSK
   */
  public ExcSK unAssignKp(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

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
   * Assign a Kqi
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignKqi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kqi as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kqi to the parent entity
    // ------------------------------------------
    parentEntity.setKqi(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kqi
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignKqi(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kqi on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kqi on the parent entithy
    // ------------------------------------------
    parentEntity.setKqi(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kqob
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignKqob(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kqob as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kqob to the parent entity
    // ------------------------------------------
    parentEntity.setKqob(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kqob
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignKqob(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kqob on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kqob on the parent entithy
    // ------------------------------------------
    parentEntity.setKqob(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kqp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignKqp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kqp as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kqp to the parent entity
    // ------------------------------------------
    parentEntity.setKqp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kqp
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignKqp(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kqp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kqp on the parent entithy
    // ------------------------------------------
    parentEntity.setKqp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Nq
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignNq(UUID parentId, PU assignment) {
    LOGGER.info("assigning Nq as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Nq to the parent entity
    // ------------------------------------------
    parentEntity.setNq(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Nq
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignNq(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Nq on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Nq on the parent entithy
    // ------------------------------------------
    parentEntity.setNq(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Qconoff
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcSK
   */
  public ExcSK assignQconoff(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Qconoff as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Qconoff to the parent entity
    // ------------------------------------------
    parentEntity.setQconoff(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Qconoff
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignQconoff(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Qconoff on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Qconoff on the parent entithy
    // ------------------------------------------
    parentEntity.setQconoff(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Qz
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignQz(UUID parentId, PU assignment) {
    LOGGER.info("assigning Qz as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Qz to the parent entity
    // ------------------------------------------
    parentEntity.setQz(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Qz
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignQz(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Qz on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Qz on the parent entithy
    // ------------------------------------------
    parentEntity.setQz(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Remote
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcSK
   */
  public ExcSK assignRemote(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Remote as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Remote to the parent entity
    // ------------------------------------------
    parentEntity.setRemote(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Remote
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignRemote(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Remote on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Remote on the parent entithy
    // ------------------------------------------
    parentEntity.setRemote(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Sbase
   *
   * @param	parentId	UUID
   * @param	assignment 	ApparentPower
   * @return	ExcSK
   */
  public ExcSK assignSbase(UUID parentId, ApparentPower assignment) {
    LOGGER.info("assigning Sbase as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = ApparentPowerProjector.find(assignment.getApparentPowerId());

    // ------------------------------------------
    // assign the Sbase to the parent entity
    // ------------------------------------------
    parentEntity.setSbase(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Sbase
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignSbase(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Sbase on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Sbase on the parent entithy
    // ------------------------------------------
    parentEntity.setSbase(null);

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
   * @return	ExcSK
   */
  public ExcSK assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSK
   */
  public ExcSK unAssignTc(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

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
   * @return	ExcSK
   */
  public ExcSK assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSK
   */
  public ExcSK unAssignTe(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

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
   * Assign a Ti
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcSK
   */
  public ExcSK assignTi(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti to the parent entity
    // ------------------------------------------
    parentEntity.setTi(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignTi(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti on the parent entithy
    // ------------------------------------------
    parentEntity.setTi(null);

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
   * @return	ExcSK
   */
  public ExcSK assignTp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tp as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
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
   * @return	ExcSK
   */
  public ExcSK unAssignTp(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

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
   * Assign a Tr
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcSK
   */
  public ExcSK assignTr(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tr as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

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
   * @return	ExcSK
   */
  public ExcSK unAssignTr(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

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
   * Assign a Uimax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignUimax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Uimax as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Uimax to the parent entity
    // ------------------------------------------
    parentEntity.setUimax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Uimax
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignUimax(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Uimax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Uimax on the parent entithy
    // ------------------------------------------
    parentEntity.setUimax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Uimin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignUimin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Uimin as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Uimin to the parent entity
    // ------------------------------------------
    parentEntity.setUimin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Uimin
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignUimin(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Uimin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Uimin on the parent entithy
    // ------------------------------------------
    parentEntity.setUimin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Urmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignUrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Urmax as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Urmax to the parent entity
    // ------------------------------------------
    parentEntity.setUrmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Urmax
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignUrmax(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Urmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Urmax on the parent entithy
    // ------------------------------------------
    parentEntity.setUrmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Urmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignUrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Urmin as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Urmin to the parent entity
    // ------------------------------------------
    parentEntity.setUrmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Urmin
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignUrmin(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Urmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Urmin on the parent entithy
    // ------------------------------------------
    parentEntity.setUrmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vtmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignVtmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vtmax as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vtmax to the parent entity
    // ------------------------------------------
    parentEntity.setVtmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vtmax
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignVtmax(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vtmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vtmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVtmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vtmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignVtmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vtmin as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vtmin to the parent entity
    // ------------------------------------------
    parentEntity.setVtmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vtmin
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignVtmin(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vtmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vtmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVtmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Yp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcSK
   */
  public ExcSK assignYp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Yp as " + assignment.toString());

    ExcSK parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Yp to the parent entity
    // ------------------------------------------
    parentEntity.setYp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Yp
   *
   * @param	parentId		UUID
   * @return	ExcSK
   */
  public ExcSK unAssignYp(UUID parentId) {
    ExcSK parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Yp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Yp on the parent entithy
    // ------------------------------------------
    parentEntity.setYp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExcSK via an FindExcSKQuery
   *
   * @return query FindExcSKQuery
   */
  @SuppressWarnings("unused")
  public ExcSK find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcSK - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcSKs
   *
   * @param query FindAllExcSKQuery
   * @return List<ExcSK>
   */
  @SuppressWarnings("unused")
  public List<ExcSK> findAll(FindAllExcSKQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcSK - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcSKRepository repository;

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
  @Qualifier(value = "apparentPower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ApparentPowerEntityProjector
      ApparentPowerProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(ExcSKEntityProjector.class.getName());
}
