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
 * Projector for GovHydro1 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovHydro1Aggregate
 *
 * @author your_name_here
 */
@Component("govHydro1-entity-projector")
public class GovHydro1EntityProjector {

  // core constructor
  public GovHydro1EntityProjector(GovHydro1Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovHydro1
   *
   * @param	entity GovHydro1
   */
  public GovHydro1 create(GovHydro1 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovHydro1
   *
   * @param	entity GovHydro1
   */
  public GovHydro1 update(GovHydro1 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovHydro1
   *
   * @param	id		UUID
   */
  public GovHydro1 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovHydro1 entity = repository.findById(id).get();

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
   * @return	GovHydro1
   */
  public GovHydro1 assignAt(UUID parentId, PU assignment) {
    LOGGER.info("assigning At as " + assignment.toString());

    GovHydro1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro1
   */
  public GovHydro1 unAssignAt(UUID parentId) {
    GovHydro1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Dturb
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro1
   */
  public GovHydro1 assignDturb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dturb as " + assignment.toString());

    GovHydro1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro1
   */
  public GovHydro1 unAssignDturb(UUID parentId) {
    GovHydro1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Gmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro1
   */
  public GovHydro1 assignGmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gmax as " + assignment.toString());

    GovHydro1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro1
   */
  public GovHydro1 unAssignGmax(UUID parentId) {
    GovHydro1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro1
   */
  public GovHydro1 assignGmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gmin as " + assignment.toString());

    GovHydro1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro1
   */
  public GovHydro1 unAssignGmin(UUID parentId) {
    GovHydro1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Hdam
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro1
   */
  public GovHydro1 assignHdam(UUID parentId, PU assignment) {
    LOGGER.info("assigning Hdam as " + assignment.toString());

    GovHydro1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro1
   */
  public GovHydro1 unAssignHdam(UUID parentId) {
    GovHydro1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro1
   */
  public GovHydro1 assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovHydro1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro1
   */
  public GovHydro1 unAssignMwbase(UUID parentId) {
    GovHydro1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Qnl
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro1
   */
  public GovHydro1 assignQnl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Qnl as " + assignment.toString());

    GovHydro1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro1
   */
  public GovHydro1 unAssignQnl(UUID parentId) {
    GovHydro1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Rperm
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydro1
   */
  public GovHydro1 assignRperm(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rperm as " + assignment.toString());

    GovHydro1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro1
   */
  public GovHydro1 unAssignRperm(UUID parentId) {
    GovHydro1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro1
   */
  public GovHydro1 assignRtemp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rtemp as " + assignment.toString());

    GovHydro1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro1
   */
  public GovHydro1 unAssignRtemp(UUID parentId) {
    GovHydro1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tf
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydro1
   */
  public GovHydro1 assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    GovHydro1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro1
   */
  public GovHydro1 unAssignTf(UUID parentId) {
    GovHydro1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tg
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydro1
   */
  public GovHydro1 assignTg(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tg as " + assignment.toString());

    GovHydro1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro1
   */
  public GovHydro1 unAssignTg(UUID parentId) {
    GovHydro1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tr
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydro1
   */
  public GovHydro1 assignTr(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tr as " + assignment.toString());

    GovHydro1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro1
   */
  public GovHydro1 unAssignTr(UUID parentId) {
    GovHydro1 parentEntity = repository.findById(parentId).get();

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
   * @return	GovHydro1
   */
  public GovHydro1 assignTw(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw as " + assignment.toString());

    GovHydro1 parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydro1
   */
  public GovHydro1 unAssignTw(UUID parentId) {
    GovHydro1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Velm
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovHydro1
   */
  public GovHydro1 assignVelm(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Velm as " + assignment.toString());

    GovHydro1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Velm to the parent entity
    // ------------------------------------------
    parentEntity.setVelm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Velm
   *
   * @param	parentId		UUID
   * @return	GovHydro1
   */
  public GovHydro1 unAssignVelm(UUID parentId) {
    GovHydro1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Velm on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Velm on the parent entithy
    // ------------------------------------------
    parentEntity.setVelm(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovHydro1 via an FindGovHydro1Query
   *
   * @return query FindGovHydro1Query
   */
  @SuppressWarnings("unused")
  public GovHydro1 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovHydro1 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovHydro1s
   *
   * @param query FindAllGovHydro1Query
   * @return List<GovHydro1>
   */
  @SuppressWarnings("unused")
  public List<GovHydro1> findAll(FindAllGovHydro1Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovHydro1 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovHydro1Repository repository;

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
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  private static final Logger LOGGER = Logger.getLogger(GovHydro1EntityProjector.class.getName());
}
