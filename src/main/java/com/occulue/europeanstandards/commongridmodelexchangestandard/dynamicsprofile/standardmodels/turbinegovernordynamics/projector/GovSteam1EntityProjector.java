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
 * Projector for GovSteam1 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovSteam1Aggregate
 *
 * @author your_name_here
 */
@Component("govSteam1-entity-projector")
public class GovSteam1EntityProjector {

  // core constructor
  public GovSteam1EntityProjector(GovSteam1Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovSteam1
   *
   * @param	entity GovSteam1
   */
  public GovSteam1 create(GovSteam1 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovSteam1
   *
   * @param	entity GovSteam1
   */
  public GovSteam1 update(GovSteam1 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovSteam1
   *
   * @param	id		UUID
   */
  public GovSteam1 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovSteam1 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Db1
   *
   * @param	parentId	UUID
   * @param	assignment 	Frequency
   * @return	GovSteam1
   */
  public GovSteam1 assignDb1(UUID parentId, Frequency assignment) {
    LOGGER.info("assigning Db1 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignDb1(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignDb2(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Db2 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignDb2(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignEps(UUID parentId, Frequency assignment) {
    LOGGER.info("assigning Eps as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignEps(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignGv1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv1 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignGv1(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignGv2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv2 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignGv2(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignGv3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv3 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignGv3(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignGv4(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv4 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignGv4(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignGv5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv5 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignGv5(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignGv6(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv6 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignGv6(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * Assign a K
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteam1
   */
  public GovSteam1 assignK(UUID parentId, PU assignment) {
    LOGGER.info("assigning K as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignK(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	Simple_Float
   * @return	GovSteam1
   */
  public GovSteam1 assignK1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K1 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignK1(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	Simple_Float
   * @return	GovSteam1
   */
  public GovSteam1 assignK2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K2 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignK2(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	Simple_Float
   * @return	GovSteam1
   */
  public GovSteam1 assignK3(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K3 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignK3(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	Simple_Float
   * @return	GovSteam1
   */
  public GovSteam1 assignK4(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K4 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignK4(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * Assign a K5
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteam1
   */
  public GovSteam1 assignK5(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K5 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignK5(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * Assign a K6
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteam1
   */
  public GovSteam1 assignK6(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K6 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the K6 to the parent entity
    // ------------------------------------------
    parentEntity.setK6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K6
   *
   * @param	parentId		UUID
   * @return	GovSteam1
   */
  public GovSteam1 unAssignK6(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K6 on the parent entithy
    // ------------------------------------------
    parentEntity.setK6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a K7
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteam1
   */
  public GovSteam1 assignK7(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K7 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the K7 to the parent entity
    // ------------------------------------------
    parentEntity.setK7(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K7
   *
   * @param	parentId		UUID
   * @return	GovSteam1
   */
  public GovSteam1 unAssignK7(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K7 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K7 on the parent entithy
    // ------------------------------------------
    parentEntity.setK7(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a K8
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteam1
   */
  public GovSteam1 assignK8(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K8 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the K8 to the parent entity
    // ------------------------------------------
    parentEntity.setK8(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K8
   *
   * @param	parentId		UUID
   * @return	GovSteam1
   */
  public GovSteam1 unAssignK8(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K8 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K8 on the parent entithy
    // ------------------------------------------
    parentEntity.setK8(null);

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
   * @return	GovSteam1
   */
  public GovSteam1 assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignMwbase(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignPgv1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv1 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignPgv1(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignPgv2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv2 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignPgv2(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignPgv3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv3 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignPgv3(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignPgv4(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv4 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignPgv4(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignPgv5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv5 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignPgv5(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignPgv6(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv6 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignPgv6(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignPmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmax as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignPmax(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignPmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmin as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignPmin(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Sdb1
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	GovSteam1
   */
  public GovSteam1 assignSdb1(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Sdb1 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Sdb1 to the parent entity
    // ------------------------------------------
    parentEntity.setSdb1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Sdb1
   *
   * @param	parentId		UUID
   * @return	GovSteam1
   */
  public GovSteam1 unAssignSdb1(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Sdb1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Sdb1 on the parent entithy
    // ------------------------------------------
    parentEntity.setSdb1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Sdb2
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	GovSteam1
   */
  public GovSteam1 assignSdb2(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Sdb2 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Sdb2 to the parent entity
    // ------------------------------------------
    parentEntity.setSdb2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Sdb2
   *
   * @param	parentId		UUID
   * @return	GovSteam1
   */
  public GovSteam1 unAssignSdb2(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Sdb2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Sdb2 on the parent entithy
    // ------------------------------------------
    parentEntity.setSdb2(null);

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
   * @return	GovSteam1
   */
  public GovSteam1 assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignT1(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignT2(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignT3(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignT4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignT4(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignT5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T5 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignT5(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignT6(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T6 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignT6(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignT7(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T7 as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignT7(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Uc
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteam1
   */
  public GovSteam1 assignUc(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Uc as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignUc(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam1
   */
  public GovSteam1 assignUo(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Uo as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam1
   */
  public GovSteam1 unAssignUo(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

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

  /*
   * Assign a Valve
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	GovSteam1
   */
  public GovSteam1 assignValve(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Valve as " + assignment.toString());

    GovSteam1 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Valve to the parent entity
    // ------------------------------------------
    parentEntity.setValve(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Valve
   *
   * @param	parentId		UUID
   * @return	GovSteam1
   */
  public GovSteam1 unAssignValve(UUID parentId) {
    GovSteam1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Valve on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Valve on the parent entithy
    // ------------------------------------------
    parentEntity.setValve(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovSteam1 via an FindGovSteam1Query
   *
   * @return query FindGovSteam1Query
   */
  @SuppressWarnings("unused")
  public GovSteam1 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovSteam1 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovSteam1s
   *
   * @param query FindAllGovSteam1Query
   * @return List<GovSteam1>
   */
  @SuppressWarnings("unused")
  public List<GovSteam1> findAll(FindAllGovSteam1Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovSteam1 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovSteam1Repository repository;

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
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

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

  private static final Logger LOGGER = Logger.getLogger(GovSteam1EntityProjector.class.getName());
}
