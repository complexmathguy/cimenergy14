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
 * Projector for ExcELIN2 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcELIN2Aggregate
 *
 * @author your_name_here
 */
@Component("excELIN2-entity-projector")
public class ExcELIN2EntityProjector {

  // core constructor
  public ExcELIN2EntityProjector(ExcELIN2Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcELIN2
   *
   * @param	entity ExcELIN2
   */
  public ExcELIN2 create(ExcELIN2 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcELIN2
   *
   * @param	entity ExcELIN2
   */
  public ExcELIN2 update(ExcELIN2 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcELIN2
   *
   * @param	id		UUID
   */
  public ExcELIN2 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcELIN2 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Efdbas
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignEfdbas(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efdbas as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efdbas to the parent entity
    // ------------------------------------------
    parentEntity.setEfdbas(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efdbas
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignEfdbas(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efdbas on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efdbas on the parent entithy
    // ------------------------------------------
    parentEntity.setEfdbas(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Iefmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignIefmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Iefmax as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Iefmax to the parent entity
    // ------------------------------------------
    parentEntity.setIefmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Iefmax
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignIefmax(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Iefmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Iefmax on the parent entithy
    // ------------------------------------------
    parentEntity.setIefmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Iefmax2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignIefmax2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Iefmax2 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Iefmax2 to the parent entity
    // ------------------------------------------
    parentEntity.setIefmax2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Iefmax2
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignIefmax2(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Iefmax2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Iefmax2 on the parent entithy
    // ------------------------------------------
    parentEntity.setIefmax2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Iefmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignIefmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Iefmin as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Iefmin to the parent entity
    // ------------------------------------------
    parentEntity.setIefmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Iefmin
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignIefmin(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Iefmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Iefmin on the parent entithy
    // ------------------------------------------
    parentEntity.setIefmin(null);

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
   * @return	ExcELIN2
   */
  public ExcELIN2 assignK1(UUID parentId, PU assignment) {
    LOGGER.info("assigning K1 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignK1(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

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
   * Assign a K1ec
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignK1ec(UUID parentId, PU assignment) {
    LOGGER.info("assigning K1ec as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the K1ec to the parent entity
    // ------------------------------------------
    parentEntity.setK1ec(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K1ec
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignK1ec(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K1ec on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K1ec on the parent entithy
    // ------------------------------------------
    parentEntity.setK1ec(null);

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
   * @return	ExcELIN2
   */
  public ExcELIN2 assignK2(UUID parentId, PU assignment) {
    LOGGER.info("assigning K2 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignK2(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcELIN2
   */
  public ExcELIN2 assignK3(UUID parentId, PU assignment) {
    LOGGER.info("assigning K3 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignK3(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignK4(UUID parentId, PU assignment) {
    LOGGER.info("assigning K4 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

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
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignK4(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Kd1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignKd1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kd1 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kd1 to the parent entity
    // ------------------------------------------
    parentEntity.setKd1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kd1
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignKd1(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kd1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kd1 on the parent entithy
    // ------------------------------------------
    parentEntity.setKd1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ke2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignKe2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ke2 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ke2 to the parent entity
    // ------------------------------------------
    parentEntity.setKe2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ke2
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignKe2(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ke2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ke2 on the parent entithy
    // ------------------------------------------
    parentEntity.setKe2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ketb
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignKetb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ketb as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ketb to the parent entity
    // ------------------------------------------
    parentEntity.setKetb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ketb
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignKetb(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ketb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ketb on the parent entithy
    // ------------------------------------------
    parentEntity.setKetb(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pid1max
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignPid1max(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pid1max as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pid1max to the parent entity
    // ------------------------------------------
    parentEntity.setPid1max(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pid1max
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignPid1max(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pid1max on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pid1max on the parent entithy
    // ------------------------------------------
    parentEntity.setPid1max(null);

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
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignSeve1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Seve1 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

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
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignSeve1(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignSeve2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Seve2 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

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
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignSeve2(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tb1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcELIN2
   */
  public ExcELIN2 assignTb1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb1 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignTb1(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Te
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcELIN2
   */
  public ExcELIN2 assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignTe(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Te2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcELIN2
   */
  public ExcELIN2 assignTe2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te2 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Te2 to the parent entity
    // ------------------------------------------
    parentEntity.setTe2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Te2
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignTe2(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Te2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Te2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTe2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignTi1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ti1 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ti1 to the parent entity
    // ------------------------------------------
    parentEntity.setTi1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti1
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignTi1(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTi1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcELIN2
   */
  public ExcELIN2 assignTi3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti3 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti3 to the parent entity
    // ------------------------------------------
    parentEntity.setTi3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti3
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignTi3(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti3 on the parent entithy
    // ------------------------------------------
    parentEntity.setTi3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti4
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcELIN2
   */
  public ExcELIN2 assignTi4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti4 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti4 to the parent entity
    // ------------------------------------------
    parentEntity.setTi4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti4
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignTi4(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti4 on the parent entithy
    // ------------------------------------------
    parentEntity.setTi4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tr4
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcELIN2
   */
  public ExcELIN2 assignTr4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tr4 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tr4 to the parent entity
    // ------------------------------------------
    parentEntity.setTr4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tr4
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignTr4(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tr4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tr4 on the parent entithy
    // ------------------------------------------
    parentEntity.setTr4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Upmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignUpmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Upmax as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Upmax to the parent entity
    // ------------------------------------------
    parentEntity.setUpmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Upmax
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignUpmax(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Upmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Upmax on the parent entithy
    // ------------------------------------------
    parentEntity.setUpmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Upmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignUpmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Upmin as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Upmin to the parent entity
    // ------------------------------------------
    parentEntity.setUpmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Upmin
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignUpmin(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Upmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Upmin on the parent entithy
    // ------------------------------------------
    parentEntity.setUpmin(null);

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
   * @return	ExcELIN2
   */
  public ExcELIN2 assignVe1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ve1 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignVe1(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcELIN2
   */
  public ExcELIN2 assignVe2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ve2 as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignVe2(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Xp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcELIN2
   */
  public ExcELIN2 assignXp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xp as " + assignment.toString());

    ExcELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xp to the parent entity
    // ------------------------------------------
    parentEntity.setXp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xp
   *
   * @param	parentId		UUID
   * @return	ExcELIN2
   */
  public ExcELIN2 unAssignXp(UUID parentId) {
    ExcELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xp on the parent entithy
    // ------------------------------------------
    parentEntity.setXp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExcELIN2 via an FindExcELIN2Query
   *
   * @return query FindExcELIN2Query
   */
  @SuppressWarnings("unused")
  public ExcELIN2 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcELIN2 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcELIN2s
   *
   * @param query FindAllExcELIN2Query
   * @return List<ExcELIN2>
   */
  @SuppressWarnings("unused")
  public List<ExcELIN2> findAll(FindAllExcELIN2Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcELIN2 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcELIN2Repository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcELIN2EntityProjector.class.getName());
}
