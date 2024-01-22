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
 * Projector for GovSteamFV2 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovSteamFV2Aggregate
 *
 * @author your_name_here
 */
@Component("govSteamFV2-entity-projector")
public class GovSteamFV2EntityProjector {

  // core constructor
  public GovSteamFV2EntityProjector(GovSteamFV2Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovSteamFV2
   *
   * @param	entity GovSteamFV2
   */
  public GovSteamFV2 create(GovSteamFV2 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovSteamFV2
   *
   * @param	entity GovSteamFV2
   */
  public GovSteamFV2 update(GovSteamFV2 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovSteamFV2
   *
   * @param	id		UUID
   */
  public GovSteamFV2 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovSteamFV2 entity = repository.findById(id).get();

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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 assignDt(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dt as " + assignment.toString());

    GovSteamFV2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 unAssignDt(UUID parentId) {
    GovSteamFV2 parentEntity = repository.findById(parentId).get();

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
   * Assign a K
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV2
   */
  public GovSteamFV2 assignK(UUID parentId, PU assignment) {
    LOGGER.info("assigning K as " + assignment.toString());

    GovSteamFV2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 unAssignK(UUID parentId) {
    GovSteamFV2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Mwbase
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GovSteamFV2
   */
  public GovSteamFV2 assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovSteamFV2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 unAssignMwbase(UUID parentId) {
    GovSteamFV2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 assignR(UUID parentId, PU assignment) {
    LOGGER.info("assigning R as " + assignment.toString());

    GovSteamFV2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 unAssignR(UUID parentId) {
    GovSteamFV2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    GovSteamFV2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 unAssignT1(UUID parentId) {
    GovSteamFV2 parentEntity = repository.findById(parentId).get();

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
   * Assign a T3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamFV2
   */
  public GovSteamFV2 assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    GovSteamFV2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 unAssignT3(UUID parentId) {
    GovSteamFV2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Ta
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamFV2
   */
  public GovSteamFV2 assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    GovSteamFV2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 unAssignTa(UUID parentId) {
    GovSteamFV2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    GovSteamFV2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 unAssignTb(UUID parentId) {
    GovSteamFV2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    GovSteamFV2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 unAssignTc(UUID parentId) {
    GovSteamFV2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Ti
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamFV2
   */
  public GovSteamFV2 assignTi(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti as " + assignment.toString());

    GovSteamFV2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti to the parent entity
    // ------------------------------------------
    parentEntity.setTi(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti
   *
   * @param	parentId		UUID
   * @return	GovSteamFV2
   */
  public GovSteamFV2 unAssignTi(UUID parentId) {
    GovSteamFV2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti on the parent entithy
    // ------------------------------------------
    parentEntity.setTi(null);

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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 assignTt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tt as " + assignment.toString());

    GovSteamFV2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 unAssignTt(UUID parentId) {
    GovSteamFV2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Vmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamFV2
   */
  public GovSteamFV2 assignVmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmax as " + assignment.toString());

    GovSteamFV2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 unAssignVmax(UUID parentId) {
    GovSteamFV2 parentEntity = repository.findById(parentId).get();

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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 assignVmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vmin as " + assignment.toString());

    GovSteamFV2 parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamFV2
   */
  public GovSteamFV2 unAssignVmin(UUID parentId) {
    GovSteamFV2 parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the GovSteamFV2 via an FindGovSteamFV2Query
   *
   * @return query FindGovSteamFV2Query
   */
  @SuppressWarnings("unused")
  public GovSteamFV2 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovSteamFV2 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovSteamFV2s
   *
   * @param query FindAllGovSteamFV2Query
   * @return List<GovSteamFV2>
   */
  @SuppressWarnings("unused")
  public List<GovSteamFV2> findAll(FindAllGovSteamFV2Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovSteamFV2 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovSteamFV2Repository repository;

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

  private static final Logger LOGGER = Logger.getLogger(GovSteamFV2EntityProjector.class.getName());
}
