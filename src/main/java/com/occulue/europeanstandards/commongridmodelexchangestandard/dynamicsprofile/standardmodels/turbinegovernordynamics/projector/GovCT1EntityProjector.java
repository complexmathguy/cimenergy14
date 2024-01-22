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
 * Projector for GovCT1 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovCT1Aggregate
 *
 * @author your_name_here
 */
@Component("govCT1-entity-projector")
public class GovCT1EntityProjector {

  // core constructor
  public GovCT1EntityProjector(GovCT1Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovCT1
   *
   * @param	entity GovCT1
   */
  public GovCT1 create(GovCT1 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovCT1
   *
   * @param	entity GovCT1
   */
  public GovCT1 update(GovCT1 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovCT1
   *
   * @param	id		UUID
   */
  public GovCT1 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovCT1 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Aset
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovCT1
   */
  public GovCT1 assignAset(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Aset as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Aset to the parent entity
    // ------------------------------------------
    parentEntity.setAset(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Aset
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignAset(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Aset on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Aset on the parent entithy
    // ------------------------------------------
    parentEntity.setAset(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Db
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignDb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Db as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Db to the parent entity
    // ------------------------------------------
    parentEntity.setDb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Db
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignDb(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Db on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Db on the parent entithy
    // ------------------------------------------
    parentEntity.setDb(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dm
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignDm(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dm as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dm to the parent entity
    // ------------------------------------------
    parentEntity.setDm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dm
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignDm(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dm on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dm on the parent entithy
    // ------------------------------------------
    parentEntity.setDm(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ka
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignKa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ka to the parent entity
    // ------------------------------------------
    parentEntity.setKa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ka
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignKa(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ka on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ka on the parent entithy
    // ------------------------------------------
    parentEntity.setKa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kdgov
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignKdgov(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kdgov as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kdgov to the parent entity
    // ------------------------------------------
    parentEntity.setKdgov(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kdgov
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignKdgov(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kdgov on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kdgov on the parent entithy
    // ------------------------------------------
    parentEntity.setKdgov(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kigov
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignKigov(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kigov as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kigov to the parent entity
    // ------------------------------------------
    parentEntity.setKigov(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kigov
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignKigov(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kigov on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kigov on the parent entithy
    // ------------------------------------------
    parentEntity.setKigov(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kiload
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignKiload(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kiload as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kiload to the parent entity
    // ------------------------------------------
    parentEntity.setKiload(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kiload
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignKiload(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kiload on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kiload on the parent entithy
    // ------------------------------------------
    parentEntity.setKiload(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kimw
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignKimw(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kimw as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kimw to the parent entity
    // ------------------------------------------
    parentEntity.setKimw(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kimw
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignKimw(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kimw on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kimw on the parent entithy
    // ------------------------------------------
    parentEntity.setKimw(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpgov
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignKpgov(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpgov as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpgov to the parent entity
    // ------------------------------------------
    parentEntity.setKpgov(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpgov
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignKpgov(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpgov on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpgov on the parent entithy
    // ------------------------------------------
    parentEntity.setKpgov(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpload
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignKpload(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpload as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpload to the parent entity
    // ------------------------------------------
    parentEntity.setKpload(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpload
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignKpload(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpload on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpload on the parent entithy
    // ------------------------------------------
    parentEntity.setKpload(null);

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
   * @return	GovCT1
   */
  public GovCT1 assignKturb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kturb as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovCT1
   */
  public GovCT1 unAssignKturb(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Ldref
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignLdref(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ldref as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ldref to the parent entity
    // ------------------------------------------
    parentEntity.setLdref(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ldref
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignLdref(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ldref on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ldref on the parent entithy
    // ------------------------------------------
    parentEntity.setLdref(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Maxerr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignMaxerr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Maxerr as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Maxerr to the parent entity
    // ------------------------------------------
    parentEntity.setMaxerr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Maxerr
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignMaxerr(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Maxerr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Maxerr on the parent entithy
    // ------------------------------------------
    parentEntity.setMaxerr(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Minerr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignMinerr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Minerr as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Minerr to the parent entity
    // ------------------------------------------
    parentEntity.setMinerr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Minerr
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignMinerr(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Minerr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Minerr on the parent entithy
    // ------------------------------------------
    parentEntity.setMinerr(null);

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
   * @return	GovCT1
   */
  public GovCT1 assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovCT1
   */
  public GovCT1 unAssignMwbase(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

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
   * Assign a R
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignR(UUID parentId, PU assignment) {
    LOGGER.info("assigning R as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the R to the parent entity
    // ------------------------------------------
    parentEntity.setR(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignR(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R on the parent entithy
    // ------------------------------------------
    parentEntity.setR(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rclose
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovCT1
   */
  public GovCT1 assignRclose(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Rclose as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Rclose to the parent entity
    // ------------------------------------------
    parentEntity.setRclose(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rclose
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignRclose(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rclose on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rclose on the parent entithy
    // ------------------------------------------
    parentEntity.setRclose(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rdown
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignRdown(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rdown as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rdown to the parent entity
    // ------------------------------------------
    parentEntity.setRdown(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rdown
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignRdown(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rdown on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rdown on the parent entithy
    // ------------------------------------------
    parentEntity.setRdown(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ropen
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovCT1
   */
  public GovCT1 assignRopen(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ropen as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Ropen to the parent entity
    // ------------------------------------------
    parentEntity.setRopen(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ropen
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignRopen(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ropen on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ropen on the parent entithy
    // ------------------------------------------
    parentEntity.setRopen(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rup
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignRup(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rup as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rup to the parent entity
    // ------------------------------------------
    parentEntity.setRup(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rup
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignRup(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rup on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rup on the parent entithy
    // ------------------------------------------
    parentEntity.setRup(null);

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
   * @return	GovCT1
   */
  public GovCT1 assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovCT1
   */
  public GovCT1 unAssignTa(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tact
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovCT1
   */
  public GovCT1 assignTact(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tact as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tact to the parent entity
    // ------------------------------------------
    parentEntity.setTact(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tact
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignTact(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tact on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tact on the parent entithy
    // ------------------------------------------
    parentEntity.setTact(null);

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
   * @return	GovCT1
   */
  public GovCT1 assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovCT1
   */
  public GovCT1 unAssignTb(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tc
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovCT1
   */
  public GovCT1 assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tc to the parent entity
    // ------------------------------------------
    parentEntity.setTc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tc
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignTc(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tc on the parent entithy
    // ------------------------------------------
    parentEntity.setTc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tdgov
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovCT1
   */
  public GovCT1 assignTdgov(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tdgov as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tdgov to the parent entity
    // ------------------------------------------
    parentEntity.setTdgov(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tdgov
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignTdgov(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tdgov on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tdgov on the parent entithy
    // ------------------------------------------
    parentEntity.setTdgov(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Teng
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovCT1
   */
  public GovCT1 assignTeng(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Teng as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Teng to the parent entity
    // ------------------------------------------
    parentEntity.setTeng(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Teng
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignTeng(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Teng on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Teng on the parent entithy
    // ------------------------------------------
    parentEntity.setTeng(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tfload
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovCT1
   */
  public GovCT1 assignTfload(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tfload as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tfload to the parent entity
    // ------------------------------------------
    parentEntity.setTfload(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tfload
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignTfload(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tfload on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tfload on the parent entithy
    // ------------------------------------------
    parentEntity.setTfload(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpelec
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovCT1
   */
  public GovCT1 assignTpelec(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpelec as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpelec to the parent entity
    // ------------------------------------------
    parentEntity.setTpelec(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpelec
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignTpelec(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpelec on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpelec on the parent entithy
    // ------------------------------------------
    parentEntity.setTpelec(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tsa
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovCT1
   */
  public GovCT1 assignTsa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tsa as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tsa to the parent entity
    // ------------------------------------------
    parentEntity.setTsa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tsa
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignTsa(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tsa on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tsa on the parent entithy
    // ------------------------------------------
    parentEntity.setTsa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tsb
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovCT1
   */
  public GovCT1 assignTsb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tsb as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tsb to the parent entity
    // ------------------------------------------
    parentEntity.setTsb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tsb
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignTsb(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tsb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tsb on the parent entithy
    // ------------------------------------------
    parentEntity.setTsb(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignVmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmax as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vmax to the parent entity
    // ------------------------------------------
    parentEntity.setVmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vmax
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignVmax(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignVmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmin as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vmin to the parent entity
    // ------------------------------------------
    parentEntity.setVmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vmin
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignVmin(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Wfnl
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovCT1
   */
  public GovCT1 assignWfnl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Wfnl as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Wfnl to the parent entity
    // ------------------------------------------
    parentEntity.setWfnl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Wfnl
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignWfnl(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Wfnl on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Wfnl on the parent entithy
    // ------------------------------------------
    parentEntity.setWfnl(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Wfspd
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	GovCT1
   */
  public GovCT1 assignWfspd(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Wfspd as " + assignment.toString());

    GovCT1 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Wfspd to the parent entity
    // ------------------------------------------
    parentEntity.setWfspd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Wfspd
   *
   * @param	parentId		UUID
   * @return	GovCT1
   */
  public GovCT1 unAssignWfspd(UUID parentId) {
    GovCT1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Wfspd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Wfspd on the parent entithy
    // ------------------------------------------
    parentEntity.setWfspd(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovCT1 via an FindGovCT1Query
   *
   * @return query FindGovCT1Query
   */
  @SuppressWarnings("unused")
  public GovCT1 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovCT1 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovCT1s
   *
   * @param query FindAllGovCT1Query
   * @return List<GovCT1>
   */
  @SuppressWarnings("unused")
  public List<GovCT1> findAll(FindAllGovCT1Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovCT1 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovCT1Repository repository;

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
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  private static final Logger LOGGER = Logger.getLogger(GovCT1EntityProjector.class.getName());
}
