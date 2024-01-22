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
 * Projector for PssPTIST3 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PssPTIST3Aggregate
 *
 * @author your_name_here
 */
@Component("pssPTIST3-entity-projector")
public class PssPTIST3EntityProjector {

  // core constructor
  public PssPTIST3EntityProjector(PssPTIST3Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PssPTIST3
   *
   * @param	entity PssPTIST3
   */
  public PssPTIST3 create(PssPTIST3 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PssPTIST3
   *
   * @param	entity PssPTIST3
   */
  public PssPTIST3 update(PssPTIST3 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PssPTIST3
   *
   * @param	id		UUID
   */
  public PssPTIST3 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PssPTIST3 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a A0
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssPTIST3
   */
  public PssPTIST3 assignA0(UUID parentId, PU assignment) {
    LOGGER.info("assigning A0 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A0 to the parent entity
    // ------------------------------------------
    parentEntity.setA0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A0
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignA0(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A0 on the parent entithy
    // ------------------------------------------
    parentEntity.setA0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a A1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssPTIST3
   */
  public PssPTIST3 assignA1(UUID parentId, PU assignment) {
    LOGGER.info("assigning A1 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignA1(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

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
   * @return	PssPTIST3
   */
  public PssPTIST3 assignA2(UUID parentId, PU assignment) {
    LOGGER.info("assigning A2 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignA2(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

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
   * @return	PssPTIST3
   */
  public PssPTIST3 assignA3(UUID parentId, PU assignment) {
    LOGGER.info("assigning A3 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignA3(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

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
   * @return	PssPTIST3
   */
  public PssPTIST3 assignA4(UUID parentId, PU assignment) {
    LOGGER.info("assigning A4 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignA4(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

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
   * @return	PssPTIST3
   */
  public PssPTIST3 assignA5(UUID parentId, PU assignment) {
    LOGGER.info("assigning A5 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignA5(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Al
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssPTIST3
   */
  public PssPTIST3 assignAl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Al as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Al to the parent entity
    // ------------------------------------------
    parentEntity.setAl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Al
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignAl(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Al on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Al on the parent entithy
    // ------------------------------------------
    parentEntity.setAl(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Athres
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssPTIST3
   */
  public PssPTIST3 assignAthres(UUID parentId, PU assignment) {
    LOGGER.info("assigning Athres as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Athres to the parent entity
    // ------------------------------------------
    parentEntity.setAthres(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Athres
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignAthres(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Athres on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Athres on the parent entithy
    // ------------------------------------------
    parentEntity.setAthres(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a B0
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssPTIST3
   */
  public PssPTIST3 assignB0(UUID parentId, PU assignment) {
    LOGGER.info("assigning B0 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the B0 to the parent entity
    // ------------------------------------------
    parentEntity.setB0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B0
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignB0(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B0 on the parent entithy
    // ------------------------------------------
    parentEntity.setB0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a B1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssPTIST3
   */
  public PssPTIST3 assignB1(UUID parentId, PU assignment) {
    LOGGER.info("assigning B1 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the B1 to the parent entity
    // ------------------------------------------
    parentEntity.setB1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B1
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignB1(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B1 on the parent entithy
    // ------------------------------------------
    parentEntity.setB1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a B2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssPTIST3
   */
  public PssPTIST3 assignB2(UUID parentId, PU assignment) {
    LOGGER.info("assigning B2 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the B2 to the parent entity
    // ------------------------------------------
    parentEntity.setB2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B2
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignB2(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B2 on the parent entithy
    // ------------------------------------------
    parentEntity.setB2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a B3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssPTIST3
   */
  public PssPTIST3 assignB3(UUID parentId, PU assignment) {
    LOGGER.info("assigning B3 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the B3 to the parent entity
    // ------------------------------------------
    parentEntity.setB3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B3
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignB3(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B3 on the parent entithy
    // ------------------------------------------
    parentEntity.setB3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a B4
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssPTIST3
   */
  public PssPTIST3 assignB4(UUID parentId, PU assignment) {
    LOGGER.info("assigning B4 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the B4 to the parent entity
    // ------------------------------------------
    parentEntity.setB4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B4
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignB4(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B4 on the parent entithy
    // ------------------------------------------
    parentEntity.setB4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a B5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssPTIST3
   */
  public PssPTIST3 assignB5(UUID parentId, PU assignment) {
    LOGGER.info("assigning B5 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the B5 to the parent entity
    // ------------------------------------------
    parentEntity.setB5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B5
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignB5(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B5 on the parent entithy
    // ------------------------------------------
    parentEntity.setB5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dl
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssPTIST3
   */
  public PssPTIST3 assignDl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dl as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dl to the parent entity
    // ------------------------------------------
    parentEntity.setDl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dl
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignDl(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dl on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dl on the parent entithy
    // ------------------------------------------
    parentEntity.setDl(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dtc
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssPTIST3
   */
  public PssPTIST3 assignDtc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Dtc as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Dtc to the parent entity
    // ------------------------------------------
    parentEntity.setDtc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dtc
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignDtc(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dtc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dtc on the parent entithy
    // ------------------------------------------
    parentEntity.setDtc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dtf
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssPTIST3
   */
  public PssPTIST3 assignDtf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Dtf as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Dtf to the parent entity
    // ------------------------------------------
    parentEntity.setDtf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dtf
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignDtf(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dtf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dtf on the parent entithy
    // ------------------------------------------
    parentEntity.setDtf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dtp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssPTIST3
   */
  public PssPTIST3 assignDtp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Dtp as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Dtp to the parent entity
    // ------------------------------------------
    parentEntity.setDtp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dtp
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignDtp(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dtp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dtp on the parent entithy
    // ------------------------------------------
    parentEntity.setDtp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Isw
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	PssPTIST3
   */
  public PssPTIST3 assignIsw(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Isw as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Isw to the parent entity
    // ------------------------------------------
    parentEntity.setIsw(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Isw
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignIsw(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Isw on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Isw on the parent entithy
    // ------------------------------------------
    parentEntity.setIsw(null);

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
   * @return	PssPTIST3
   */
  public PssPTIST3 assignK(UUID parentId, PU assignment) {
    LOGGER.info("assigning K as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignK(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Lthres
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssPTIST3
   */
  public PssPTIST3 assignLthres(UUID parentId, PU assignment) {
    LOGGER.info("assigning Lthres as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Lthres to the parent entity
    // ------------------------------------------
    parentEntity.setLthres(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Lthres
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignLthres(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Lthres on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Lthres on the parent entithy
    // ------------------------------------------
    parentEntity.setLthres(null);

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
   * @param	assignment 	PU
   * @return	PssPTIST3
   */
  public PssPTIST3 assignM(UUID parentId, PU assignment) {
    LOGGER.info("assigning M as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

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
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignM(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Nav
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	PssPTIST3
   */
  public PssPTIST3 assignNav(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Nav as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Nav to the parent entity
    // ------------------------------------------
    parentEntity.setNav(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Nav
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignNav(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Nav on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Nav on the parent entithy
    // ------------------------------------------
    parentEntity.setNav(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ncl
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	PssPTIST3
   */
  public PssPTIST3 assignNcl(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ncl as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Ncl to the parent entity
    // ------------------------------------------
    parentEntity.setNcl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ncl
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignNcl(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ncl on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ncl on the parent entithy
    // ------------------------------------------
    parentEntity.setNcl(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ncr
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	PssPTIST3
   */
  public PssPTIST3 assignNcr(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ncr as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Ncr to the parent entity
    // ------------------------------------------
    parentEntity.setNcr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ncr
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignNcr(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ncr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ncr on the parent entithy
    // ------------------------------------------
    parentEntity.setNcr(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssPTIST3
   */
  public PssPTIST3 assignPmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmin as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmin to the parent entity
    // ------------------------------------------
    parentEntity.setPmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmin
   *
   * @param	parentId		UUID
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignPmin(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmin on the parent entithy
    // ------------------------------------------
    parentEntity.setPmin(null);

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
   * @return	PssPTIST3
   */
  public PssPTIST3 assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignT1(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

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
   * @return	PssPTIST3
   */
  public PssPTIST3 assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignT2(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

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
   * @return	PssPTIST3
   */
  public PssPTIST3 assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignT3(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

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
   * @return	PssPTIST3
   */
  public PssPTIST3 assignT4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignT4(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

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
   * @return	PssPTIST3
   */
  public PssPTIST3 assignT5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T5 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignT5(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

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
   * @return	PssPTIST3
   */
  public PssPTIST3 assignT6(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T6 as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignT6(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tf
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssPTIST3
   */
  public PssPTIST3 assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignTf(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssPTIST3
   */
  public PssPTIST3 assignTp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tp as " + assignment.toString());

    PssPTIST3 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST3
   */
  public PssPTIST3 unAssignTp(UUID parentId) {
    PssPTIST3 parentEntity = repository.findById(parentId).get();

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

  /**
   * Method to retrieve the PssPTIST3 via an FindPssPTIST3Query
   *
   * @return query FindPssPTIST3Query
   */
  @SuppressWarnings("unused")
  public PssPTIST3 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PssPTIST3 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PssPTIST3s
   *
   * @param query FindAllPssPTIST3Query
   * @return List<PssPTIST3>
   */
  @SuppressWarnings("unused")
  public List<PssPTIST3> findAll(FindAllPssPTIST3Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PssPTIST3 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PssPTIST3Repository repository;

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

  private static final Logger LOGGER = Logger.getLogger(PssPTIST3EntityProjector.class.getName());
}
