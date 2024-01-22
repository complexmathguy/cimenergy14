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
 * Projector for ExcST6B as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcST6BAggregate
 *
 * @author your_name_here
 */
@Component("excST6B-entity-projector")
public class ExcST6BEntityProjector {

  // core constructor
  public ExcST6BEntityProjector(ExcST6BRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcST6B
   *
   * @param	entity ExcST6B
   */
  public ExcST6B create(ExcST6B entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcST6B
   *
   * @param	entity ExcST6B
   */
  public ExcST6B update(ExcST6B entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcST6B
   *
   * @param	id		UUID
   */
  public ExcST6B delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcST6B entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Ilr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST6B
   */
  public ExcST6B assignIlr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ilr as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ilr to the parent entity
    // ------------------------------------------
    parentEntity.setIlr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ilr
   *
   * @param	parentId		UUID
   * @return	ExcST6B
   */
  public ExcST6B unAssignIlr(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ilr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ilr on the parent entithy
    // ------------------------------------------
    parentEntity.setIlr(null);

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
   * @param	assignment 	BooleanProxy
   * @return	ExcST6B
   */
  public ExcST6B assignK1(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning K1 as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

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
   * @return	ExcST6B
   */
  public ExcST6B unAssignK1(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

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
   * Assign a Kcl
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST6B
   */
  public ExcST6B assignKcl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kcl as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kcl to the parent entity
    // ------------------------------------------
    parentEntity.setKcl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kcl
   *
   * @param	parentId		UUID
   * @return	ExcST6B
   */
  public ExcST6B unAssignKcl(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kcl on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kcl on the parent entithy
    // ------------------------------------------
    parentEntity.setKcl(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kff
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST6B
   */
  public ExcST6B assignKff(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kff as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kff to the parent entity
    // ------------------------------------------
    parentEntity.setKff(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kff
   *
   * @param	parentId		UUID
   * @return	ExcST6B
   */
  public ExcST6B unAssignKff(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kff on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kff on the parent entithy
    // ------------------------------------------
    parentEntity.setKff(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kg
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST6B
   */
  public ExcST6B assignKg(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kg as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kg to the parent entity
    // ------------------------------------------
    parentEntity.setKg(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kg
   *
   * @param	parentId		UUID
   * @return	ExcST6B
   */
  public ExcST6B unAssignKg(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kg on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kg on the parent entithy
    // ------------------------------------------
    parentEntity.setKg(null);

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
   * @return	ExcST6B
   */
  public ExcST6B assignKia(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kia as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST6B
   */
  public ExcST6B unAssignKia(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

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
   * Assign a Klr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST6B
   */
  public ExcST6B assignKlr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Klr as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Klr to the parent entity
    // ------------------------------------------
    parentEntity.setKlr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Klr
   *
   * @param	parentId		UUID
   * @return	ExcST6B
   */
  public ExcST6B unAssignKlr(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Klr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Klr on the parent entithy
    // ------------------------------------------
    parentEntity.setKlr(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Km
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST6B
   */
  public ExcST6B assignKm(UUID parentId, PU assignment) {
    LOGGER.info("assigning Km as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Km to the parent entity
    // ------------------------------------------
    parentEntity.setKm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Km
   *
   * @param	parentId		UUID
   * @return	ExcST6B
   */
  public ExcST6B unAssignKm(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Km on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Km on the parent entithy
    // ------------------------------------------
    parentEntity.setKm(null);

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
   * @return	ExcST6B
   */
  public ExcST6B assignKpa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpa as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST6B
   */
  public ExcST6B unAssignKpa(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

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
   * Assign a Kvd
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST6B
   */
  public ExcST6B assignKvd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kvd as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kvd to the parent entity
    // ------------------------------------------
    parentEntity.setKvd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kvd
   *
   * @param	parentId		UUID
   * @return	ExcST6B
   */
  public ExcST6B unAssignKvd(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kvd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kvd on the parent entithy
    // ------------------------------------------
    parentEntity.setKvd(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tg
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcST6B
   */
  public ExcST6B assignTg(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tg as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tg to the parent entity
    // ------------------------------------------
    parentEntity.setTg(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tg
   *
   * @param	parentId		UUID
   * @return	ExcST6B
   */
  public ExcST6B unAssignTg(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tg on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tg on the parent entithy
    // ------------------------------------------
    parentEntity.setTg(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ts
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcST6B
   */
  public ExcST6B assignTs(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ts as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ts to the parent entity
    // ------------------------------------------
    parentEntity.setTs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ts
   *
   * @param	parentId		UUID
   * @return	ExcST6B
   */
  public ExcST6B unAssignTs(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ts on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ts on the parent entithy
    // ------------------------------------------
    parentEntity.setTs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tvd
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcST6B
   */
  public ExcST6B assignTvd(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tvd as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tvd to the parent entity
    // ------------------------------------------
    parentEntity.setTvd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tvd
   *
   * @param	parentId		UUID
   * @return	ExcST6B
   */
  public ExcST6B unAssignTvd(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tvd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tvd on the parent entithy
    // ------------------------------------------
    parentEntity.setTvd(null);

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
   * @return	ExcST6B
   */
  public ExcST6B assignVamax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vamax as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST6B
   */
  public ExcST6B unAssignVamax(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST6B
   */
  public ExcST6B assignVamin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vamin as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST6B
   */
  public ExcST6B unAssignVamin(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

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
   * Assign a Vilim
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcST6B
   */
  public ExcST6B assignVilim(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Vilim as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Vilim to the parent entity
    // ------------------------------------------
    parentEntity.setVilim(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vilim
   *
   * @param	parentId		UUID
   * @return	ExcST6B
   */
  public ExcST6B unAssignVilim(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vilim on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vilim on the parent entithy
    // ------------------------------------------
    parentEntity.setVilim(null);

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
   * @return	ExcST6B
   */
  public ExcST6B assignVimax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vimax as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST6B
   */
  public ExcST6B unAssignVimax(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

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
   * Assign a Vimin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST6B
   */
  public ExcST6B assignVimin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vimin as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vimin to the parent entity
    // ------------------------------------------
    parentEntity.setVimin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vimin
   *
   * @param	parentId		UUID
   * @return	ExcST6B
   */
  public ExcST6B unAssignVimin(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vimin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vimin on the parent entithy
    // ------------------------------------------
    parentEntity.setVimin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vmult
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcST6B
   */
  public ExcST6B assignVmult(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Vmult as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Vmult to the parent entity
    // ------------------------------------------
    parentEntity.setVmult(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vmult
   *
   * @param	parentId		UUID
   * @return	ExcST6B
   */
  public ExcST6B unAssignVmult(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vmult on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vmult on the parent entithy
    // ------------------------------------------
    parentEntity.setVmult(null);

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
   * @return	ExcST6B
   */
  public ExcST6B assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST6B
   */
  public ExcST6B unAssignVrmax(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST6B
   */
  public ExcST6B assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST6B
   */
  public ExcST6B unAssignVrmin(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

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
   * @return	ExcST6B
   */
  public ExcST6B assignXc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xc as " + assignment.toString());

    ExcST6B parentEntity = repository.findById(parentId).get();
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
   * @return	ExcST6B
   */
  public ExcST6B unAssignXc(UUID parentId) {
    ExcST6B parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the ExcST6B via an FindExcST6BQuery
   *
   * @return query FindExcST6BQuery
   */
  @SuppressWarnings("unused")
  public ExcST6B find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcST6B - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcST6Bs
   *
   * @param query FindAllExcST6BQuery
   * @return List<ExcST6B>
   */
  @SuppressWarnings("unused")
  public List<ExcST6B> findAll(FindAllExcST6BQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcST6B - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcST6BRepository repository;

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
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(ExcST6BEntityProjector.class.getName());
}
