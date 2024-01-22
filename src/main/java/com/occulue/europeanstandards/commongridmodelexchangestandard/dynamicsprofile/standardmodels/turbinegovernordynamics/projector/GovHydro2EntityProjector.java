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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for GovHydro2 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovHydro2Aggregate
 *
 * @author your_name_here
 */
@Component("govHydro2-entity-projector")
public class GovHydro2EntityProjector {

  // core constructor
  public GovHydro2EntityProjector(GovHydro2Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovHydro2
   *
   * @param	entity GovHydro2
   */
  public GovHydro2 create(GovHydro2 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovHydro2
   *
   * @param	entity GovHydro2
   */
  public GovHydro2 update(GovHydro2 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovHydro2
   *
   * @param	id		UUID
   */
  public GovHydro2 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovHydro2 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Aturb
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignAturb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Aturb as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Aturb to the parent entity
    // ------------------------------------------
    parentEntity.setAturb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Aturb
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignAturb(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Aturb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Aturb on the parent entithy
    // ------------------------------------------
    parentEntity.setAturb(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Bturb
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignBturb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Bturb as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Bturb to the parent entity
    // ------------------------------------------
    parentEntity.setBturb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bturb
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignBturb(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bturb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bturb on the parent entithy
    // ------------------------------------------
    parentEntity.setBturb(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Db1
   *
   * @param	parentId	UUID
   * @param	assignment 	Frequency
   * @return	GovHydro2
   */
  public GovHydro2 assignDb1(UUID parentId, Frequency assignment) {
    LOGGER.info("assigning Db1 as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = FrequencyProjector.find(assignment.getFrequencyId());

    // ------------------------------------------
    // assign the Db1 to the parent entity
    // ------------------------------------------
    parentEntity.setDb1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Db1
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignDb1(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Db1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Db1 on the parent entithy
    // ------------------------------------------
    parentEntity.setDb1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Db2
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GovHydro2
   */
  public GovHydro2 assignDb2(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Db2 as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the Db2 to the parent entity
    // ------------------------------------------
    parentEntity.setDb2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Db2
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignDb2(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Db2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Db2 on the parent entithy
    // ------------------------------------------
    parentEntity.setDb2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Eps
   *
   * @param	parentId	UUID
   * @param	assignment 	Frequency
   * @return	GovHydro2
   */
  public GovHydro2 assignEps(UUID parentId, Frequency assignment) {
    LOGGER.info("assigning Eps as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = FrequencyProjector.find(assignment.getFrequencyId());

    // ------------------------------------------
    // assign the Eps to the parent entity
    // ------------------------------------------
    parentEntity.setEps(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Eps
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignEps(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Eps on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Eps on the parent entithy
    // ------------------------------------------
    parentEntity.setEps(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gv1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignGv1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv1 as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gv1 to the parent entity
    // ------------------------------------------
    parentEntity.setGv1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gv1
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignGv1(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gv1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gv1 on the parent entithy
    // ------------------------------------------
    parentEntity.setGv1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gv2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignGv2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv2 as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gv2 to the parent entity
    // ------------------------------------------
    parentEntity.setGv2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gv2
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignGv2(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gv2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gv2 on the parent entithy
    // ------------------------------------------
    parentEntity.setGv2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gv3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignGv3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv3 as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gv3 to the parent entity
    // ------------------------------------------
    parentEntity.setGv3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gv3
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignGv3(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gv3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gv3 on the parent entithy
    // ------------------------------------------
    parentEntity.setGv3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gv4
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignGv4(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv4 as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gv4 to the parent entity
    // ------------------------------------------
    parentEntity.setGv4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gv4
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignGv4(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gv4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gv4 on the parent entithy
    // ------------------------------------------
    parentEntity.setGv4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gv5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignGv5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv5 as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gv5 to the parent entity
    // ------------------------------------------
    parentEntity.setGv5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gv5
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignGv5(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gv5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gv5 on the parent entithy
    // ------------------------------------------
    parentEntity.setGv5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gv6
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignGv6(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv6 as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gv6 to the parent entity
    // ------------------------------------------
    parentEntity.setGv6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gv6
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignGv6(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gv6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gv6 on the parent entithy
    // ------------------------------------------
    parentEntity.setGv6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kturb
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignKturb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kturb as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kturb to the parent entity
    // ------------------------------------------
    parentEntity.setKturb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kturb
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignKturb(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kturb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kturb on the parent entithy
    // ------------------------------------------
    parentEntity.setKturb(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mwbase
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GovHydro2
   */
  public GovHydro2 assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the Mwbase to the parent entity
    // ------------------------------------------
    parentEntity.setMwbase(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mwbase
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignMwbase(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mwbase on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mwbase on the parent entithy
    // ------------------------------------------
    parentEntity.setMwbase(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pgv1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignPgv1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv1 as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pgv1 to the parent entity
    // ------------------------------------------
    parentEntity.setPgv1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pgv1
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignPgv1(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pgv1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pgv1 on the parent entithy
    // ------------------------------------------
    parentEntity.setPgv1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pgv2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignPgv2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv2 as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pgv2 to the parent entity
    // ------------------------------------------
    parentEntity.setPgv2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pgv2
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignPgv2(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pgv2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pgv2 on the parent entithy
    // ------------------------------------------
    parentEntity.setPgv2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pgv3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignPgv3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv3 as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pgv3 to the parent entity
    // ------------------------------------------
    parentEntity.setPgv3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pgv3
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignPgv3(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pgv3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pgv3 on the parent entithy
    // ------------------------------------------
    parentEntity.setPgv3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pgv4
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignPgv4(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv4 as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pgv4 to the parent entity
    // ------------------------------------------
    parentEntity.setPgv4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pgv4
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignPgv4(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pgv4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pgv4 on the parent entithy
    // ------------------------------------------
    parentEntity.setPgv4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pgv5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignPgv5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv5 as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pgv5 to the parent entity
    // ------------------------------------------
    parentEntity.setPgv5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pgv5
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignPgv5(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pgv5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pgv5 on the parent entithy
    // ------------------------------------------
    parentEntity.setPgv5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pgv6
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignPgv6(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv6 as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pgv6 to the parent entity
    // ------------------------------------------
    parentEntity.setPgv6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pgv6
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignPgv6(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pgv6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pgv6 on the parent entithy
    // ------------------------------------------
    parentEntity.setPgv6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignPmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmax as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmax to the parent entity
    // ------------------------------------------
    parentEntity.setPmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmax
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignPmax(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmax on the parent entithy
    // ------------------------------------------
    parentEntity.setPmax(null);

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
   * @return	GovHydro2
   */
  public GovHydro2 assignPmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmin as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro2
   */
  public GovHydro2 unAssignPmin(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Rperm
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignRperm(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rperm as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rperm to the parent entity
    // ------------------------------------------
    parentEntity.setRperm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rperm
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignRperm(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rperm on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rperm on the parent entithy
    // ------------------------------------------
    parentEntity.setRperm(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rtemp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro2
   */
  public GovHydro2 assignRtemp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rtemp as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rtemp to the parent entity
    // ------------------------------------------
    parentEntity.setRtemp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rtemp
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignRtemp(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rtemp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rtemp on the parent entithy
    // ------------------------------------------
    parentEntity.setRtemp(null);

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
   * @return	GovHydro2
   */
  public GovHydro2 assignTg(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tg as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro2
   */
  public GovHydro2 unAssignTg(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydro2
   */
  public GovHydro2 assignTp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tp as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro2
   */
  public GovHydro2 unAssignTp(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro2
   */
  public GovHydro2 assignTr(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tr as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro2
   */
  public GovHydro2 unAssignTr(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tw
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydro2
   */
  public GovHydro2 assignTw(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tw to the parent entity
    // ------------------------------------------
    parentEntity.setTw(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tw
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignTw(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tw on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tw on the parent entithy
    // ------------------------------------------
    parentEntity.setTw(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Uc
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovHydro2
   */
  public GovHydro2 assignUc(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Uc as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Uc to the parent entity
    // ------------------------------------------
    parentEntity.setUc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Uc
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignUc(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Uc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Uc on the parent entithy
    // ------------------------------------------
    parentEntity.setUc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Uo
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovHydro2
   */
  public GovHydro2 assignUo(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Uo as " + assignment.toString());

    GovHydro2 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Uo to the parent entity
    // ------------------------------------------
    parentEntity.setUo(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Uo
   *
   * @param	parentId		UUID
   * @return	GovHydro2
   */
  public GovHydro2 unAssignUo(UUID parentId) {
    GovHydro2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Uo on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Uo on the parent entithy
    // ------------------------------------------
    parentEntity.setUo(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovHydro2 via an FindGovHydro2Query
   *
   * @return query FindGovHydro2Query
   */
  @SuppressWarnings("unused")
  public GovHydro2 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovHydro2 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovHydro2s
   *
   * @param query FindAllGovHydro2Query
   * @return List<GovHydro2>
   */
  @SuppressWarnings("unused")
  public List<GovHydro2> findAll(FindAllGovHydro2Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovHydro2 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovHydro2Repository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "frequency-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .FrequencyEntityProjector
      FrequencyProjector;

  @Autowired
  @Qualifier(value = "activePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ActivePowerEntityProjector
      ActivePowerProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  private static final Logger LOGGER = Logger.getLogger(GovHydro2EntityProjector.class.getName());
}
