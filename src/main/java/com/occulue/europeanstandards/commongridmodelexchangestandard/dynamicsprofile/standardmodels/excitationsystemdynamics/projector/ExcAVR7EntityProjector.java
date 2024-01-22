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
 * Projector for ExcAVR7 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcAVR7Aggregate
 *
 * @author your_name_here
 */
@Component("excAVR7-entity-projector")
public class ExcAVR7EntityProjector {

  // core constructor
  public ExcAVR7EntityProjector(ExcAVR7Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcAVR7
   *
   * @param	entity ExcAVR7
   */
  public ExcAVR7 create(ExcAVR7 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcAVR7
   *
   * @param	entity ExcAVR7
   */
  public ExcAVR7 update(ExcAVR7 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcAVR7
   *
   * @param	id		UUID
   */
  public ExcAVR7 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcAVR7 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a A1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR7
   */
  public ExcAVR7 assignA1(UUID parentId, PU assignment) {
    LOGGER.info("assigning A1 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A1 to the parent entity
    // ------------------------------------------
    parentEntity.setA1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A1
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignA1(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A1 on the parent entithy
    // ------------------------------------------
    parentEntity.setA1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a A2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR7
   */
  public ExcAVR7 assignA2(UUID parentId, PU assignment) {
    LOGGER.info("assigning A2 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A2 to the parent entity
    // ------------------------------------------
    parentEntity.setA2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A2
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignA2(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A2 on the parent entithy
    // ------------------------------------------
    parentEntity.setA2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a A3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR7
   */
  public ExcAVR7 assignA3(UUID parentId, PU assignment) {
    LOGGER.info("assigning A3 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A3 to the parent entity
    // ------------------------------------------
    parentEntity.setA3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A3
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignA3(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A3 on the parent entithy
    // ------------------------------------------
    parentEntity.setA3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a A4
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR7
   */
  public ExcAVR7 assignA4(UUID parentId, PU assignment) {
    LOGGER.info("assigning A4 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A4 to the parent entity
    // ------------------------------------------
    parentEntity.setA4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A4
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignA4(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A4 on the parent entithy
    // ------------------------------------------
    parentEntity.setA4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a A5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR7
   */
  public ExcAVR7 assignA5(UUID parentId, PU assignment) {
    LOGGER.info("assigning A5 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A5 to the parent entity
    // ------------------------------------------
    parentEntity.setA5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A5
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignA5(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A5 on the parent entithy
    // ------------------------------------------
    parentEntity.setA5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a A6
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR7
   */
  public ExcAVR7 assignA6(UUID parentId, PU assignment) {
    LOGGER.info("assigning A6 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A6 to the parent entity
    // ------------------------------------------
    parentEntity.setA6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A6
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignA6(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A6 on the parent entithy
    // ------------------------------------------
    parentEntity.setA6(null);

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
   * @return	ExcAVR7
   */
  public ExcAVR7 assignK1(UUID parentId, PU assignment) {
    LOGGER.info("assigning K1 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignK1(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

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
   * Assign a K3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR7
   */
  public ExcAVR7 assignK3(UUID parentId, PU assignment) {
    LOGGER.info("assigning K3 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignK3(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

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
   * Assign a K5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR7
   */
  public ExcAVR7 assignK5(UUID parentId, PU assignment) {
    LOGGER.info("assigning K5 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the K5 to the parent entity
    // ------------------------------------------
    parentEntity.setK5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K5
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignK5(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K5 on the parent entithy
    // ------------------------------------------
    parentEntity.setK5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR7
   */
  public ExcAVR7 assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T1 to the parent entity
    // ------------------------------------------
    parentEntity.setT1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T1
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignT1(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T1 on the parent entithy
    // ------------------------------------------
    parentEntity.setT1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR7
   */
  public ExcAVR7 assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T2 to the parent entity
    // ------------------------------------------
    parentEntity.setT2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T2
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignT2(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T2 on the parent entithy
    // ------------------------------------------
    parentEntity.setT2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR7
   */
  public ExcAVR7 assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T3 to the parent entity
    // ------------------------------------------
    parentEntity.setT3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T3
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignT3(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T3 on the parent entithy
    // ------------------------------------------
    parentEntity.setT3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T4
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR7
   */
  public ExcAVR7 assignT4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T4 to the parent entity
    // ------------------------------------------
    parentEntity.setT4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T4
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignT4(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T4 on the parent entithy
    // ------------------------------------------
    parentEntity.setT4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T5
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR7
   */
  public ExcAVR7 assignT5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T5 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T5 to the parent entity
    // ------------------------------------------
    parentEntity.setT5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T5
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignT5(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T5 on the parent entithy
    // ------------------------------------------
    parentEntity.setT5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T6
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR7
   */
  public ExcAVR7 assignT6(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T6 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T6 to the parent entity
    // ------------------------------------------
    parentEntity.setT6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T6
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignT6(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T6 on the parent entithy
    // ------------------------------------------
    parentEntity.setT6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vmax1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR7
   */
  public ExcAVR7 assignVmax1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmax1 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vmax1 to the parent entity
    // ------------------------------------------
    parentEntity.setVmax1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vmax1
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignVmax1(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vmax1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vmax1 on the parent entithy
    // ------------------------------------------
    parentEntity.setVmax1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vmax3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR7
   */
  public ExcAVR7 assignVmax3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmax3 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vmax3 to the parent entity
    // ------------------------------------------
    parentEntity.setVmax3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vmax3
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignVmax3(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vmax3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vmax3 on the parent entithy
    // ------------------------------------------
    parentEntity.setVmax3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vmax5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR7
   */
  public ExcAVR7 assignVmax5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmax5 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vmax5 to the parent entity
    // ------------------------------------------
    parentEntity.setVmax5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vmax5
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignVmax5(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vmax5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vmax5 on the parent entithy
    // ------------------------------------------
    parentEntity.setVmax5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vmin1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR7
   */
  public ExcAVR7 assignVmin1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmin1 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vmin1 to the parent entity
    // ------------------------------------------
    parentEntity.setVmin1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vmin1
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignVmin1(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vmin1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vmin1 on the parent entithy
    // ------------------------------------------
    parentEntity.setVmin1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vmin3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR7
   */
  public ExcAVR7 assignVmin3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmin3 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vmin3 to the parent entity
    // ------------------------------------------
    parentEntity.setVmin3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vmin3
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignVmin3(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vmin3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vmin3 on the parent entithy
    // ------------------------------------------
    parentEntity.setVmin3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vmin5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR7
   */
  public ExcAVR7 assignVmin5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmin5 as " + assignment.toString());

    ExcAVR7 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vmin5 to the parent entity
    // ------------------------------------------
    parentEntity.setVmin5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vmin5
   *
   * @param	parentId		UUID
   * @return	ExcAVR7
   */
  public ExcAVR7 unAssignVmin5(UUID parentId) {
    ExcAVR7 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vmin5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vmin5 on the parent entithy
    // ------------------------------------------
    parentEntity.setVmin5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExcAVR7 via an FindExcAVR7Query
   *
   * @return query FindExcAVR7Query
   */
  @SuppressWarnings("unused")
  public ExcAVR7 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcAVR7 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcAVR7s
   *
   * @param query FindAllExcAVR7Query
   * @return List<ExcAVR7>
   */
  @SuppressWarnings("unused")
  public List<ExcAVR7> findAll(FindAllExcAVR7Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcAVR7 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcAVR7Repository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcAVR7EntityProjector.class.getName());
}
