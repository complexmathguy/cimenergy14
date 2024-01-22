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
 * Projector for GovHydro4 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovHydro4Aggregate
 *
 * @author your_name_here
 */
@Component("govHydro4-entity-projector")
public class GovHydro4EntityProjector {

  // core constructor
  public GovHydro4EntityProjector(GovHydro4Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovHydro4
   *
   * @param	entity GovHydro4
   */
  public GovHydro4 create(GovHydro4 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovHydro4
   *
   * @param	entity GovHydro4
   */
  public GovHydro4 update(GovHydro4 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovHydro4
   *
   * @param	id		UUID
   */
  public GovHydro4 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovHydro4 entity = repository.findById(id).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignAt(UUID parentId, PU assignment) {
    LOGGER.info("assigning At as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignAt(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * Assign a Bgv0
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro4
   */
  public GovHydro4 assignBgv0(UUID parentId, PU assignment) {
    LOGGER.info("assigning Bgv0 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Bgv0 to the parent entity
    // ------------------------------------------
    parentEntity.setBgv0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bgv0
   *
   * @param	parentId		UUID
   * @return	GovHydro4
   */
  public GovHydro4 unAssignBgv0(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bgv0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bgv0 on the parent entithy
    // ------------------------------------------
    parentEntity.setBgv0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Bgv1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro4
   */
  public GovHydro4 assignBgv1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Bgv1 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Bgv1 to the parent entity
    // ------------------------------------------
    parentEntity.setBgv1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bgv1
   *
   * @param	parentId		UUID
   * @return	GovHydro4
   */
  public GovHydro4 unAssignBgv1(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bgv1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bgv1 on the parent entithy
    // ------------------------------------------
    parentEntity.setBgv1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Bgv2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro4
   */
  public GovHydro4 assignBgv2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Bgv2 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Bgv2 to the parent entity
    // ------------------------------------------
    parentEntity.setBgv2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bgv2
   *
   * @param	parentId		UUID
   * @return	GovHydro4
   */
  public GovHydro4 unAssignBgv2(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bgv2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bgv2 on the parent entithy
    // ------------------------------------------
    parentEntity.setBgv2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Bgv3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro4
   */
  public GovHydro4 assignBgv3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Bgv3 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Bgv3 to the parent entity
    // ------------------------------------------
    parentEntity.setBgv3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bgv3
   *
   * @param	parentId		UUID
   * @return	GovHydro4
   */
  public GovHydro4 unAssignBgv3(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bgv3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bgv3 on the parent entithy
    // ------------------------------------------
    parentEntity.setBgv3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Bgv4
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro4
   */
  public GovHydro4 assignBgv4(UUID parentId, PU assignment) {
    LOGGER.info("assigning Bgv4 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Bgv4 to the parent entity
    // ------------------------------------------
    parentEntity.setBgv4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bgv4
   *
   * @param	parentId		UUID
   * @return	GovHydro4
   */
  public GovHydro4 unAssignBgv4(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bgv4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bgv4 on the parent entithy
    // ------------------------------------------
    parentEntity.setBgv4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Bgv5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro4
   */
  public GovHydro4 assignBgv5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Bgv5 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Bgv5 to the parent entity
    // ------------------------------------------
    parentEntity.setBgv5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bgv5
   *
   * @param	parentId		UUID
   * @return	GovHydro4
   */
  public GovHydro4 unAssignBgv5(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bgv5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bgv5 on the parent entithy
    // ------------------------------------------
    parentEntity.setBgv5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Bmax
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovHydro4
   */
  public GovHydro4 assignBmax(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Bmax as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Bmax to the parent entity
    // ------------------------------------------
    parentEntity.setBmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bmax
   *
   * @param	parentId		UUID
   * @return	GovHydro4
   */
  public GovHydro4 unAssignBmax(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bmax on the parent entithy
    // ------------------------------------------
    parentEntity.setBmax(null);

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
   * @return	GovHydro4
   */
  public GovHydro4 assignDb1(UUID parentId, Frequency assignment) {
    LOGGER.info("assigning Db1 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignDb1(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignDb2(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Db2 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignDb2(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignDturb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dturb as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignDturb(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignEps(UUID parentId, Frequency assignment) {
    LOGGER.info("assigning Eps as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignEps(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * Assign a Gmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro4
   */
  public GovHydro4 assignGmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gmax as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gmax to the parent entity
    // ------------------------------------------
    parentEntity.setGmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gmax
   *
   * @param	parentId		UUID
   * @return	GovHydro4
   */
  public GovHydro4 unAssignGmax(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gmax on the parent entithy
    // ------------------------------------------
    parentEntity.setGmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro4
   */
  public GovHydro4 assignGmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gmin as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gmin to the parent entity
    // ------------------------------------------
    parentEntity.setGmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gmin
   *
   * @param	parentId		UUID
   * @return	GovHydro4
   */
  public GovHydro4 unAssignGmin(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gmin on the parent entithy
    // ------------------------------------------
    parentEntity.setGmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gv0
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro4
   */
  public GovHydro4 assignGv0(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv0 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gv0 to the parent entity
    // ------------------------------------------
    parentEntity.setGv0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gv0
   *
   * @param	parentId		UUID
   * @return	GovHydro4
   */
  public GovHydro4 unAssignGv0(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gv0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gv0 on the parent entithy
    // ------------------------------------------
    parentEntity.setGv0(null);

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
   * @return	GovHydro4
   */
  public GovHydro4 assignGv1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv1 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignGv1(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignGv2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv2 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignGv2(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignGv3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv3 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignGv3(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignGv4(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv4 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignGv4(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignGv5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv5 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignGv5(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * Assign a Hdam
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro4
   */
  public GovHydro4 assignHdam(UUID parentId, PU assignment) {
    LOGGER.info("assigning Hdam as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Hdam to the parent entity
    // ------------------------------------------
    parentEntity.setHdam(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Hdam
   *
   * @param	parentId		UUID
   * @return	GovHydro4
   */
  public GovHydro4 unAssignHdam(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Hdam on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Hdam on the parent entithy
    // ------------------------------------------
    parentEntity.setHdam(null);

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
   * @return	GovHydro4
   */
  public GovHydro4 assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignMwbase(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * Assign a Pgv0
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro4
   */
  public GovHydro4 assignPgv0(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv0 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pgv0 to the parent entity
    // ------------------------------------------
    parentEntity.setPgv0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pgv0
   *
   * @param	parentId		UUID
   * @return	GovHydro4
   */
  public GovHydro4 unAssignPgv0(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pgv0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pgv0 on the parent entithy
    // ------------------------------------------
    parentEntity.setPgv0(null);

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
   * @return	GovHydro4
   */
  public GovHydro4 assignPgv1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv1 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignPgv1(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignPgv2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv2 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignPgv2(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignPgv3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv3 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignPgv3(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignPgv4(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv4 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignPgv4(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignPgv5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pgv5 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignPgv5(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * Assign a Qn1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro4
   */
  public GovHydro4 assignQn1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Qn1 as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Qn1 to the parent entity
    // ------------------------------------------
    parentEntity.setQn1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Qn1
   *
   * @param	parentId		UUID
   * @return	GovHydro4
   */
  public GovHydro4 unAssignQn1(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Qn1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Qn1 on the parent entithy
    // ------------------------------------------
    parentEntity.setQn1(null);

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
   * @param	assignment 	Seconds
   * @return	GovHydro4
   */
  public GovHydro4 assignRperm(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Rperm as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignRperm(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	Seconds
   * @return	GovHydro4
   */
  public GovHydro4 assignRtemp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Rtemp as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignRtemp(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tblade
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydro4
   */
  public GovHydro4 assignTblade(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tblade as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tblade to the parent entity
    // ------------------------------------------
    parentEntity.setTblade(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tblade
   *
   * @param	parentId		UUID
   * @return	GovHydro4
   */
  public GovHydro4 unAssignTblade(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tblade on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tblade on the parent entithy
    // ------------------------------------------
    parentEntity.setTblade(null);

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
   * @return	GovHydro4
   */
  public GovHydro4 assignTg(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tg as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignTg(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignTp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tp as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignTp(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignTr(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tr as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignTr(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignTw(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignTw(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignUc(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Uc as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignUc(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro4
   */
  public GovHydro4 assignUo(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Uo as " + assignment.toString());

    GovHydro4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro4
   */
  public GovHydro4 unAssignUo(UUID parentId) {
    GovHydro4 parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the GovHydro4 via an FindGovHydro4Query
   *
   * @return query FindGovHydro4Query
   */
  @SuppressWarnings("unused")
  public GovHydro4 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovHydro4 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovHydro4s
   *
   * @param query FindAllGovHydro4Query
   * @return List<GovHydro4>
   */
  @SuppressWarnings("unused")
  public List<GovHydro4> findAll(FindAllGovHydro4Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovHydro4 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovHydro4Repository repository;

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

  private static final Logger LOGGER = Logger.getLogger(GovHydro4EntityProjector.class.getName());
}
