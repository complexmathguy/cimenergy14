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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for WindContQIEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindContQIECAggregate
 *
 * @author your_name_here
 */
@Component("windContQIEC-entity-projector")
public class WindContQIECEntityProjector {

  // core constructor
  public WindContQIECEntityProjector(WindContQIECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindContQIEC
   *
   * @param	entity WindContQIEC
   */
  public WindContQIEC create(WindContQIEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindContQIEC
   *
   * @param	entity WindContQIEC
   */
  public WindContQIEC update(WindContQIEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindContQIEC
   *
   * @param	id		UUID
   */
  public WindContQIEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindContQIEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Iqh1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignIqh1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Iqh1 as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Iqh1 to the parent entity
    // ------------------------------------------
    parentEntity.setIqh1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Iqh1
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignIqh1(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Iqh1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Iqh1 on the parent entithy
    // ------------------------------------------
    parentEntity.setIqh1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Iqmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignIqmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Iqmax as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Iqmax to the parent entity
    // ------------------------------------------
    parentEntity.setIqmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Iqmax
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignIqmax(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Iqmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Iqmax on the parent entithy
    // ------------------------------------------
    parentEntity.setIqmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Iqmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignIqmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Iqmin as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Iqmin to the parent entity
    // ------------------------------------------
    parentEntity.setIqmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Iqmin
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignIqmin(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Iqmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Iqmin on the parent entithy
    // ------------------------------------------
    parentEntity.setIqmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Iqpost
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignIqpost(UUID parentId, PU assignment) {
    LOGGER.info("assigning Iqpost as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Iqpost to the parent entity
    // ------------------------------------------
    parentEntity.setIqpost(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Iqpost
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignIqpost(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Iqpost on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Iqpost on the parent entithy
    // ------------------------------------------
    parentEntity.setIqpost(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kiq
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignKiq(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kiq as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kiq to the parent entity
    // ------------------------------------------
    parentEntity.setKiq(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kiq
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignKiq(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kiq on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kiq on the parent entithy
    // ------------------------------------------
    parentEntity.setKiq(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kiu
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignKiu(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kiu as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kiu to the parent entity
    // ------------------------------------------
    parentEntity.setKiu(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kiu
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignKiu(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kiu on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kiu on the parent entithy
    // ------------------------------------------
    parentEntity.setKiu(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpq
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignKpq(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpq as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpq to the parent entity
    // ------------------------------------------
    parentEntity.setKpq(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpq
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignKpq(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpq on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpq on the parent entithy
    // ------------------------------------------
    parentEntity.setKpq(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpu
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignKpu(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpu as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpu to the parent entity
    // ------------------------------------------
    parentEntity.setKpu(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpu
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignKpu(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpu on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpu on the parent entithy
    // ------------------------------------------
    parentEntity.setKpu(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kqv
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignKqv(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kqv as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kqv to the parent entity
    // ------------------------------------------
    parentEntity.setKqv(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kqv
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignKqv(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kqv on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kqv on the parent entithy
    // ------------------------------------------
    parentEntity.setKqv(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Qmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignQmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Qmax as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Qmax to the parent entity
    // ------------------------------------------
    parentEntity.setQmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Qmax
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignQmax(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Qmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Qmax on the parent entithy
    // ------------------------------------------
    parentEntity.setQmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Qmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignQmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Qmin as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Qmin to the parent entity
    // ------------------------------------------
    parentEntity.setQmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Qmin
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignQmin(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Qmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Qmin on the parent entithy
    // ------------------------------------------
    parentEntity.setQmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rdroop
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignRdroop(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rdroop as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rdroop to the parent entity
    // ------------------------------------------
    parentEntity.setRdroop(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rdroop
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignRdroop(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rdroop on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rdroop on the parent entithy
    // ------------------------------------------
    parentEntity.setRdroop(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tiq
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContQIEC
   */
  public WindContQIEC assignTiq(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tiq as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tiq to the parent entity
    // ------------------------------------------
    parentEntity.setTiq(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tiq
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignTiq(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tiq on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tiq on the parent entithy
    // ------------------------------------------
    parentEntity.setTiq(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpfilt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContQIEC
   */
  public WindContQIEC assignTpfilt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpfilt as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpfilt to the parent entity
    // ------------------------------------------
    parentEntity.setTpfilt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpfilt
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignTpfilt(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpfilt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpfilt on the parent entithy
    // ------------------------------------------
    parentEntity.setTpfilt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpost
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContQIEC
   */
  public WindContQIEC assignTpost(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpost as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpost to the parent entity
    // ------------------------------------------
    parentEntity.setTpost(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpost
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignTpost(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpost on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpost on the parent entithy
    // ------------------------------------------
    parentEntity.setTpost(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tqord
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContQIEC
   */
  public WindContQIEC assignTqord(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tqord as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tqord to the parent entity
    // ------------------------------------------
    parentEntity.setTqord(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tqord
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignTqord(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tqord on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tqord on the parent entithy
    // ------------------------------------------
    parentEntity.setTqord(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tufilt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContQIEC
   */
  public WindContQIEC assignTufilt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tufilt as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tufilt to the parent entity
    // ------------------------------------------
    parentEntity.setTufilt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tufilt
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignTufilt(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tufilt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tufilt on the parent entithy
    // ------------------------------------------
    parentEntity.setTufilt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Udb1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignUdb1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Udb1 as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Udb1 to the parent entity
    // ------------------------------------------
    parentEntity.setUdb1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Udb1
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignUdb1(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Udb1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Udb1 on the parent entithy
    // ------------------------------------------
    parentEntity.setUdb1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Udb2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignUdb2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Udb2 as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Udb2 to the parent entity
    // ------------------------------------------
    parentEntity.setUdb2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Udb2
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignUdb2(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Udb2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Udb2 on the parent entithy
    // ------------------------------------------
    parentEntity.setUdb2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Umax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignUmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Umax as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Umax to the parent entity
    // ------------------------------------------
    parentEntity.setUmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Umax
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignUmax(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Umax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Umax on the parent entithy
    // ------------------------------------------
    parentEntity.setUmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Umin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignUmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Umin as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Umin to the parent entity
    // ------------------------------------------
    parentEntity.setUmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Umin
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignUmin(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Umin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Umin on the parent entithy
    // ------------------------------------------
    parentEntity.setUmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Uqdip
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignUqdip(UUID parentId, PU assignment) {
    LOGGER.info("assigning Uqdip as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Uqdip to the parent entity
    // ------------------------------------------
    parentEntity.setUqdip(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Uqdip
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignUqdip(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Uqdip on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Uqdip on the parent entithy
    // ------------------------------------------
    parentEntity.setUqdip(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Uref0
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignUref0(UUID parentId, PU assignment) {
    LOGGER.info("assigning Uref0 as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Uref0 to the parent entity
    // ------------------------------------------
    parentEntity.setUref0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Uref0
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignUref0(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Uref0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Uref0 on the parent entithy
    // ------------------------------------------
    parentEntity.setUref0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xdroop
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContQIEC
   */
  public WindContQIEC assignXdroop(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xdroop as " + assignment.toString());

    WindContQIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xdroop to the parent entity
    // ------------------------------------------
    parentEntity.setXdroop(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xdroop
   *
   * @param	parentId		UUID
   * @return	WindContQIEC
   */
  public WindContQIEC unAssignXdroop(UUID parentId) {
    WindContQIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xdroop on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xdroop on the parent entithy
    // ------------------------------------------
    parentEntity.setXdroop(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindContQIEC via an FindWindContQIECQuery
   *
   * @return query FindWindContQIECQuery
   */
  @SuppressWarnings("unused")
  public WindContQIEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindContQIEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindContQIECs
   *
   * @param query FindAllWindContQIECQuery
   * @return List<WindContQIEC>
   */
  @SuppressWarnings("unused")
  public List<WindContQIEC> findAll(FindAllWindContQIECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all WindContQIEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindContQIECRepository repository;

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

  private static final Logger LOGGER =
      Logger.getLogger(WindContQIECEntityProjector.class.getName());
}
