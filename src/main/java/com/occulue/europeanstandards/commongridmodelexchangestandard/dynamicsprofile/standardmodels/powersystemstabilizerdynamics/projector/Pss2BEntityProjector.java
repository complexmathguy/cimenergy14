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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for Pss2B as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by Pss2BAggregate
 *
 * @author your_name_here
 */
@Component("pss2B-entity-projector")
public class Pss2BEntityProjector {

  // core constructor
  public Pss2BEntityProjector(Pss2BRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Pss2B
   *
   * @param	entity Pss2B
   */
  public Pss2B create(Pss2B entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Pss2B
   *
   * @param	entity Pss2B
   */
  public Pss2B update(Pss2B entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Pss2B
   *
   * @param	id		UUID
   */
  public Pss2B delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Pss2B entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a A
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	Pss2B
   */
  public Pss2B assignA(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning A as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the A to the parent entity
    // ------------------------------------------
    parentEntity.setA(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignA(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A on the parent entithy
    // ------------------------------------------
    parentEntity.setA(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ks1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss2B
   */
  public Pss2B assignKs1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ks1 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ks1 to the parent entity
    // ------------------------------------------
    parentEntity.setKs1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ks1
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignKs1(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ks1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ks1 on the parent entithy
    // ------------------------------------------
    parentEntity.setKs1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ks2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss2B
   */
  public Pss2B assignKs2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ks2 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ks2 to the parent entity
    // ------------------------------------------
    parentEntity.setKs2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ks2
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignKs2(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ks2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ks2 on the parent entithy
    // ------------------------------------------
    parentEntity.setKs2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ks3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss2B
   */
  public Pss2B assignKs3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ks3 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ks3 to the parent entity
    // ------------------------------------------
    parentEntity.setKs3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ks3
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignKs3(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ks3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ks3 on the parent entithy
    // ------------------------------------------
    parentEntity.setKs3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ks4
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss2B
   */
  public Pss2B assignKs4(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ks4 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ks4 to the parent entity
    // ------------------------------------------
    parentEntity.setKs4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ks4
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignKs4(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ks4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ks4 on the parent entithy
    // ------------------------------------------
    parentEntity.setKs4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a M
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	Pss2B
   */
  public Pss2B assignM(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning M as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the M to the parent entity
    // ------------------------------------------
    parentEntity.setM(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the M
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignM(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning M on " + parentEntity.toString());

    // ------------------------------------------
    // null out the M on the parent entithy
    // ------------------------------------------
    parentEntity.setM(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a N
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	Pss2B
   */
  public Pss2B assignN(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning N as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the N to the parent entity
    // ------------------------------------------
    parentEntity.setN(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the N
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignN(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning N on " + parentEntity.toString());

    // ------------------------------------------
    // null out the N on the parent entithy
    // ------------------------------------------
    parentEntity.setN(null);

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
   * @return	Pss2B
   */
  public Pss2B assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2B
   */
  public Pss2B unAssignT1(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

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
   * Assign a T10
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss2B
   */
  public Pss2B assignT10(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T10 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T10 to the parent entity
    // ------------------------------------------
    parentEntity.setT10(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T10
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignT10(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T10 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T10 on the parent entithy
    // ------------------------------------------
    parentEntity.setT10(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T11
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss2B
   */
  public Pss2B assignT11(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T11 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T11 to the parent entity
    // ------------------------------------------
    parentEntity.setT11(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T11
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignT11(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T11 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T11 on the parent entithy
    // ------------------------------------------
    parentEntity.setT11(null);

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
   * @return	Pss2B
   */
  public Pss2B assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2B
   */
  public Pss2B unAssignT2(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

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
   * @return	Pss2B
   */
  public Pss2B assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2B
   */
  public Pss2B unAssignT3(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

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
   * @return	Pss2B
   */
  public Pss2B assignT4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2B
   */
  public Pss2B unAssignT4(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

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
   * Assign a T6
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss2B
   */
  public Pss2B assignT6(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T6 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2B
   */
  public Pss2B unAssignT6(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

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
   * Assign a T7
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss2B
   */
  public Pss2B assignT7(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T7 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T7 to the parent entity
    // ------------------------------------------
    parentEntity.setT7(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T7
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignT7(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T7 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T7 on the parent entithy
    // ------------------------------------------
    parentEntity.setT7(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T8
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss2B
   */
  public Pss2B assignT8(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T8 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T8 to the parent entity
    // ------------------------------------------
    parentEntity.setT8(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T8
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignT8(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T8 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T8 on the parent entithy
    // ------------------------------------------
    parentEntity.setT8(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T9
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss2B
   */
  public Pss2B assignT9(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T9 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T9 to the parent entity
    // ------------------------------------------
    parentEntity.setT9(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T9
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignT9(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T9 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T9 on the parent entithy
    // ------------------------------------------
    parentEntity.setT9(null);

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
   * @return	Pss2B
   */
  public Pss2B assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2B
   */
  public Pss2B unAssignTa(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

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
   * @return	Pss2B
   */
  public Pss2B assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2B
   */
  public Pss2B unAssignTb(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

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
   * Assign a Tw1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss2B
   */
  public Pss2B assignTw1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw1 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tw1 to the parent entity
    // ------------------------------------------
    parentEntity.setTw1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tw1
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignTw1(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tw1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tw1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTw1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tw2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss2B
   */
  public Pss2B assignTw2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw2 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tw2 to the parent entity
    // ------------------------------------------
    parentEntity.setTw2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tw2
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignTw2(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tw2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tw2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTw2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tw3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss2B
   */
  public Pss2B assignTw3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw3 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tw3 to the parent entity
    // ------------------------------------------
    parentEntity.setTw3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tw3
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignTw3(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tw3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tw3 on the parent entithy
    // ------------------------------------------
    parentEntity.setTw3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tw4
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss2B
   */
  public Pss2B assignTw4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw4 as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tw4 to the parent entity
    // ------------------------------------------
    parentEntity.setTw4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tw4
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignTw4(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tw4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tw4 on the parent entithy
    // ------------------------------------------
    parentEntity.setTw4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vsi1max
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss2B
   */
  public Pss2B assignVsi1max(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vsi1max as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vsi1max to the parent entity
    // ------------------------------------------
    parentEntity.setVsi1max(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vsi1max
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignVsi1max(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vsi1max on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vsi1max on the parent entithy
    // ------------------------------------------
    parentEntity.setVsi1max(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vsi1min
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss2B
   */
  public Pss2B assignVsi1min(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vsi1min as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vsi1min to the parent entity
    // ------------------------------------------
    parentEntity.setVsi1min(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vsi1min
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignVsi1min(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vsi1min on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vsi1min on the parent entithy
    // ------------------------------------------
    parentEntity.setVsi1min(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vsi2max
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss2B
   */
  public Pss2B assignVsi2max(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vsi2max as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vsi2max to the parent entity
    // ------------------------------------------
    parentEntity.setVsi2max(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vsi2max
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignVsi2max(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vsi2max on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vsi2max on the parent entithy
    // ------------------------------------------
    parentEntity.setVsi2max(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vsi2min
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss2B
   */
  public Pss2B assignVsi2min(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vsi2min as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vsi2min to the parent entity
    // ------------------------------------------
    parentEntity.setVsi2min(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vsi2min
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignVsi2min(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vsi2min on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vsi2min on the parent entithy
    // ------------------------------------------
    parentEntity.setVsi2min(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vstmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss2B
   */
  public Pss2B assignVstmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vstmax as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vstmax to the parent entity
    // ------------------------------------------
    parentEntity.setVstmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vstmax
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignVstmax(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vstmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vstmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVstmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vstmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss2B
   */
  public Pss2B assignVstmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vstmin as " + assignment.toString());

    Pss2B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vstmin to the parent entity
    // ------------------------------------------
    parentEntity.setVstmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vstmin
   *
   * @param	parentId		UUID
   * @return	Pss2B
   */
  public Pss2B unAssignVstmin(UUID parentId) {
    Pss2B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vstmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vstmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVstmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Pss2B via an FindPss2BQuery
   *
   * @return query FindPss2BQuery
   */
  @SuppressWarnings("unused")
  public Pss2B find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Pss2B - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Pss2Bs
   *
   * @param query FindAllPss2BQuery
   * @return List<Pss2B>
   */
  @SuppressWarnings("unused")
  public List<Pss2B> findAll(FindAllPss2BQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Pss2B - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final Pss2BRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(Pss2BEntityProjector.class.getName());
}
