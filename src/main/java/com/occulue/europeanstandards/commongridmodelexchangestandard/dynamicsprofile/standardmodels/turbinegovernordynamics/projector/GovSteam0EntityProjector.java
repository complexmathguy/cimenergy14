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
 * Projector for GovSteam0 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovSteam0Aggregate
 *
 * @author your_name_here
 */
@Component("govSteam0-entity-projector")
public class GovSteam0EntityProjector {

  // core constructor
  public GovSteam0EntityProjector(GovSteam0Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovSteam0
   *
   * @param	entity GovSteam0
   */
  public GovSteam0 create(GovSteam0 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovSteam0
   *
   * @param	entity GovSteam0
   */
  public GovSteam0 update(GovSteam0 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovSteam0
   *
   * @param	id		UUID
   */
  public GovSteam0 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovSteam0 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Dt
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteam0
   */
  public GovSteam0 assignDt(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dt as " + assignment.toString());

    GovSteam0 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dt to the parent entity
    // ------------------------------------------
    parentEntity.setDt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dt
   *
   * @param	parentId		UUID
   * @return	GovSteam0
   */
  public GovSteam0 unAssignDt(UUID parentId) {
    GovSteam0 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dt on the parent entithy
    // ------------------------------------------
    parentEntity.setDt(null);

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
   * @return	GovSteam0
   */
  public GovSteam0 assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovSteam0 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam0
   */
  public GovSteam0 unAssignMwbase(UUID parentId) {
    GovSteam0 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam0
   */
  public GovSteam0 assignR(UUID parentId, PU assignment) {
    LOGGER.info("assigning R as " + assignment.toString());

    GovSteam0 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam0
   */
  public GovSteam0 unAssignR(UUID parentId) {
    GovSteam0 parentEntity = repository.findById(parentId).get();

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
   * Assign a T1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteam0
   */
  public GovSteam0 assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    GovSteam0 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam0
   */
  public GovSteam0 unAssignT1(UUID parentId) {
    GovSteam0 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam0
   */
  public GovSteam0 assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    GovSteam0 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam0
   */
  public GovSteam0 unAssignT2(UUID parentId) {
    GovSteam0 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam0
   */
  public GovSteam0 assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    GovSteam0 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam0
   */
  public GovSteam0 unAssignT3(UUID parentId) {
    GovSteam0 parentEntity = repository.findById(parentId).get();

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
   * Assign a Vmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteam0
   */
  public GovSteam0 assignVmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmax as " + assignment.toString());

    GovSteam0 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam0
   */
  public GovSteam0 unAssignVmax(UUID parentId) {
    GovSteam0 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteam0
   */
  public GovSteam0 assignVmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmin as " + assignment.toString());

    GovSteam0 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteam0
   */
  public GovSteam0 unAssignVmin(UUID parentId) {
    GovSteam0 parentEntity = repository.findById(parentId).get();

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

  /**
   * Method to retrieve the GovSteam0 via an FindGovSteam0Query
   *
   * @return query FindGovSteam0Query
   */
  @SuppressWarnings("unused")
  public GovSteam0 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovSteam0 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovSteam0s
   *
   * @param query FindAllGovSteam0Query
   * @return List<GovSteam0>
   */
  @SuppressWarnings("unused")
  public List<GovSteam0> findAll(FindAllGovSteam0Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovSteam0 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovSteam0Repository repository;

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

  private static final Logger LOGGER = Logger.getLogger(GovSteam0EntityProjector.class.getName());
}
