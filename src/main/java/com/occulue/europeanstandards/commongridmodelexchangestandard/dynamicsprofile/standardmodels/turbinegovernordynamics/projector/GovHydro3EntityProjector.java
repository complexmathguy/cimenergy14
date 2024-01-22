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
 * Projector for GovHydro3 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovHydro3Aggregate
 *
 * @author your_name_here
 */
@Component("govHydro3-entity-projector")
public class GovHydro3EntityProjector {

  // core constructor
  public GovHydro3EntityProjector(GovHydro3Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovHydro3
   *
   * @param	entity GovHydro3
   */
  public GovHydro3 create(GovHydro3 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovHydro3
   *
   * @param	entity GovHydro3
   */
  public GovHydro3 update(GovHydro3 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovHydro3
   *
   * @param	id		UUID
   */
  public GovHydro3 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovHydro3 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a At
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro3
   */
  public GovHydro3 assignAt(UUID parentId, PU assignment) {
    LOGGER.info("assigning At as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the At to the parent entity
    // ------------------------------------------
    parentEntity.setAt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the At
   *
   * @param	parentId		UUID
   * @return	GovHydro3
   */
  public GovHydro3 unAssignAt(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning At on " + parentEntity.toString());

    // ------------------------------------------
    // null out the At on the parent entithy
    // ------------------------------------------
    parentEntity.setAt(null);

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
   * @return	GovHydro3
   */
  public GovHydro3 assignDb1(UUID parentId, Frequency assignment) {
    LOGGER.info("assigning Db1 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignDb1(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignDb2(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Db2 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignDb2(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Dturb
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro3
   */
  public GovHydro3 assignDturb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dturb as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dturb to the parent entity
    // ------------------------------------------
    parentEntity.setDturb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dturb
   *
   * @param	parentId		UUID
   * @return	GovHydro3
   */
  public GovHydro3 unAssignDturb(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dturb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dturb on the parent entithy
    // ------------------------------------------
    parentEntity.setDturb(null);

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
   * @return	GovHydro3
   */
  public GovHydro3 assignEps(UUID parentId, Frequency assignment) {
    LOGGER.info("assigning Eps as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignEps(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * Assign a GovernorControl
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	GovHydro3
   */
  public GovHydro3 assignGovernorControl(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning GovernorControl as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the GovernorControl to the parent entity
    // ------------------------------------------
    parentEntity.setGovernorControl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the GovernorControl
   *
   * @param	parentId		UUID
   * @return	GovHydro3
   */
  public GovHydro3 unAssignGovernorControl(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning GovernorControl on " + parentEntity.toString());

    // ------------------------------------------
    // null out the GovernorControl on the parent entithy
    // ------------------------------------------
    parentEntity.setGovernorControl(null);

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
   * @return	GovHydro3
   */
  public GovHydro3 assignGv1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv1 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignGv1(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignGv2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv2 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignGv2(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignGv3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv3 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignGv3(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignGv4(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv4 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignGv4(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignGv5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv5 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignGv5(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignGv6(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv6 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignGv6(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * Assign a H0
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro3
   */
  public GovHydro3 assignH0(UUID parentId, PU assignment) {
    LOGGER.info("assigning H0 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the H0 to the parent entity
    // ------------------------------------------
    parentEntity.setH0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the H0
   *
   * @param	parentId		UUID
   * @return	GovHydro3
   */
  public GovHydro3 unAssignH0(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning H0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the H0 on the parent entithy
    // ------------------------------------------
    parentEntity.setH0(null);

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
   * @return	GovHydro3
   */
  public GovHydro3 assignK1(UUID parentId, PU assignment) {
    LOGGER.info("assigning K1 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignK1(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignK2(UUID parentId, PU assignment) {
    LOGGER.info("assigning K2 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignK2(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Kg
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro3
   */
  public GovHydro3 assignKg(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kg as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignKg(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Ki
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro3
   */
  public GovHydro3 assignKi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignKi(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Mwbase
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GovHydro3
   */
  public GovHydro3 assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignMwbase(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignPgv1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv1 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignPgv1(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignPgv2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv2 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignPgv2(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignPgv3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv3 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignPgv3(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignPgv4(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv4 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignPgv4(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignPgv5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv5 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignPgv5(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignPgv6(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv6 as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignPgv6(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignPmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmax as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignPmax(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignPmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmin as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignPmin(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Qnl
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro3
   */
  public GovHydro3 assignQnl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Qnl as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Qnl to the parent entity
    // ------------------------------------------
    parentEntity.setQnl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Qnl
   *
   * @param	parentId		UUID
   * @return	GovHydro3
   */
  public GovHydro3 unAssignQnl(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Qnl on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Qnl on the parent entithy
    // ------------------------------------------
    parentEntity.setQnl(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Relec
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro3
   */
  public GovHydro3 assignRelec(UUID parentId, PU assignment) {
    LOGGER.info("assigning Relec as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Relec to the parent entity
    // ------------------------------------------
    parentEntity.setRelec(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Relec
   *
   * @param	parentId		UUID
   * @return	GovHydro3
   */
  public GovHydro3 unAssignRelec(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Relec on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Relec on the parent entithy
    // ------------------------------------------
    parentEntity.setRelec(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rgate
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro3
   */
  public GovHydro3 assignRgate(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rgate as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rgate to the parent entity
    // ------------------------------------------
    parentEntity.setRgate(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rgate
   *
   * @param	parentId		UUID
   * @return	GovHydro3
   */
  public GovHydro3 unAssignRgate(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rgate on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rgate on the parent entithy
    // ------------------------------------------
    parentEntity.setRgate(null);

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
   * @return	GovHydro3
   */
  public GovHydro3 assignTd(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Td as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignTd(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tf
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydro3
   */
  public GovHydro3 assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignTf(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro3
   */
  public GovHydro3 assignTp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tp as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignTp(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydro3
   */
  public GovHydro3 assignTt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tt as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tt to the parent entity
    // ------------------------------------------
    parentEntity.setTt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tt
   *
   * @param	parentId		UUID
   * @return	GovHydro3
   */
  public GovHydro3 unAssignTt(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tt on the parent entithy
    // ------------------------------------------
    parentEntity.setTt(null);

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
   * @return	GovHydro3
   */
  public GovHydro3 assignTw(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro3
   */
  public GovHydro3 unAssignTw(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Velcl
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovHydro3
   */
  public GovHydro3 assignVelcl(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Velcl as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Velcl to the parent entity
    // ------------------------------------------
    parentEntity.setVelcl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Velcl
   *
   * @param	parentId		UUID
   * @return	GovHydro3
   */
  public GovHydro3 unAssignVelcl(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Velcl on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Velcl on the parent entithy
    // ------------------------------------------
    parentEntity.setVelcl(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Velop
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovHydro3
   */
  public GovHydro3 assignVelop(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Velop as " + assignment.toString());

    GovHydro3 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Velop to the parent entity
    // ------------------------------------------
    parentEntity.setVelop(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Velop
   *
   * @param	parentId		UUID
   * @return	GovHydro3
   */
  public GovHydro3 unAssignVelop(UUID parentId) {
    GovHydro3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Velop on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Velop on the parent entithy
    // ------------------------------------------
    parentEntity.setVelop(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovHydro3 via an FindGovHydro3Query
   *
   * @return query FindGovHydro3Query
   */
  @SuppressWarnings("unused")
  public GovHydro3 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovHydro3 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovHydro3s
   *
   * @param query FindAllGovHydro3Query
   * @return List<GovHydro3>
   */
  @SuppressWarnings("unused")
  public List<GovHydro3> findAll(FindAllGovHydro3Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovHydro3 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovHydro3Repository repository;

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
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

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

  private static final Logger LOGGER = Logger.getLogger(GovHydro3EntityProjector.class.getName());
}
