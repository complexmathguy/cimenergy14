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
 * Projector for Pss1A as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by Pss1AAggregate
 *
 * @author your_name_here
 */
@Component("pss1A-entity-projector")
public class Pss1AEntityProjector {

  // core constructor
  public Pss1AEntityProjector(Pss1ARepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Pss1A
   *
   * @param	entity Pss1A
   */
  public Pss1A create(Pss1A entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Pss1A
   *
   * @param	entity Pss1A
   */
  public Pss1A update(Pss1A entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Pss1A
   *
   * @param	id		UUID
   */
  public Pss1A delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Pss1A entity = repository.findById(id).get();

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
   * @return	Pss1A
   */
  public Pss1A assignA1(UUID parentId, PU assignment) {
    LOGGER.info("assigning A1 as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1A
   */
  public Pss1A unAssignA1(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * @return	Pss1A
   */
  public Pss1A assignA2(UUID parentId, PU assignment) {
    LOGGER.info("assigning A2 as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1A
   */
  public Pss1A unAssignA2(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * @return	Pss1A
   */
  public Pss1A assignA3(UUID parentId, PU assignment) {
    LOGGER.info("assigning A3 as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1A
   */
  public Pss1A unAssignA3(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * @return	Pss1A
   */
  public Pss1A assignA4(UUID parentId, PU assignment) {
    LOGGER.info("assigning A4 as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1A
   */
  public Pss1A unAssignA4(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * @return	Pss1A
   */
  public Pss1A assignA5(UUID parentId, PU assignment) {
    LOGGER.info("assigning A5 as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1A
   */
  public Pss1A unAssignA5(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * @return	Pss1A
   */
  public Pss1A assignA6(UUID parentId, PU assignment) {
    LOGGER.info("assigning A6 as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1A
   */
  public Pss1A unAssignA6(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * Assign a A7
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss1A
   */
  public Pss1A assignA7(UUID parentId, PU assignment) {
    LOGGER.info("assigning A7 as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A7 to the parent entity
    // ------------------------------------------
    parentEntity.setA7(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A7
   *
   * @param	parentId		UUID
   * @return	Pss1A
   */
  public Pss1A unAssignA7(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A7 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A7 on the parent entithy
    // ------------------------------------------
    parentEntity.setA7(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a A8
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss1A
   */
  public Pss1A assignA8(UUID parentId, PU assignment) {
    LOGGER.info("assigning A8 as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A8 to the parent entity
    // ------------------------------------------
    parentEntity.setA8(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A8
   *
   * @param	parentId		UUID
   * @return	Pss1A
   */
  public Pss1A unAssignA8(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A8 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A8 on the parent entithy
    // ------------------------------------------
    parentEntity.setA8(null);

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
   * @param	assignment 	BooleanProxy
   * @return	Pss1A
   */
  public Pss1A assignKd(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Kd as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

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
   * @return	Pss1A
   */
  public Pss1A unAssignKd(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * Assign a Ks
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss1A
   */
  public Pss1A assignKs(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ks as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1A
   */
  public Pss1A unAssignKs(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * Assign a T1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss1A
   */
  public Pss1A assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1A
   */
  public Pss1A unAssignT1(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * @return	Pss1A
   */
  public Pss1A assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1A
   */
  public Pss1A unAssignT2(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * @return	Pss1A
   */
  public Pss1A assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1A
   */
  public Pss1A unAssignT3(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * @return	Pss1A
   */
  public Pss1A assignT4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4 as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1A
   */
  public Pss1A unAssignT4(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * @return	Pss1A
   */
  public Pss1A assignT5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T5 as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1A
   */
  public Pss1A unAssignT5(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * @return	Pss1A
   */
  public Pss1A assignT6(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T6 as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1A
   */
  public Pss1A unAssignT6(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * Assign a Tdelay
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss1A
   */
  public Pss1A assignTdelay(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tdelay as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tdelay to the parent entity
    // ------------------------------------------
    parentEntity.setTdelay(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tdelay
   *
   * @param	parentId		UUID
   * @return	Pss1A
   */
  public Pss1A unAssignTdelay(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tdelay on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tdelay on the parent entithy
    // ------------------------------------------
    parentEntity.setTdelay(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vcl
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss1A
   */
  public Pss1A assignVcl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vcl as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vcl to the parent entity
    // ------------------------------------------
    parentEntity.setVcl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vcl
   *
   * @param	parentId		UUID
   * @return	Pss1A
   */
  public Pss1A unAssignVcl(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vcl on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vcl on the parent entithy
    // ------------------------------------------
    parentEntity.setVcl(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vcu
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss1A
   */
  public Pss1A assignVcu(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vcu as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vcu to the parent entity
    // ------------------------------------------
    parentEntity.setVcu(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vcu
   *
   * @param	parentId		UUID
   * @return	Pss1A
   */
  public Pss1A unAssignVcu(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vcu on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vcu on the parent entithy
    // ------------------------------------------
    parentEntity.setVcu(null);

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
   * @return	Pss1A
   */
  public Pss1A assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1A
   */
  public Pss1A unAssignVrmax(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * @return	Pss1A
   */
  public Pss1A assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    Pss1A parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1A
   */
  public Pss1A unAssignVrmin(UUID parentId) {
    Pss1A parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the Pss1A via an FindPss1AQuery
   *
   * @return query FindPss1AQuery
   */
  @SuppressWarnings("unused")
  public Pss1A find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Pss1A - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Pss1As
   *
   * @param query FindAllPss1AQuery
   * @return List<Pss1A>
   */
  @SuppressWarnings("unused")
  public List<Pss1A> findAll(FindAllPss1AQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Pss1A - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final Pss1ARepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(Pss1AEntityProjector.class.getName());
}
