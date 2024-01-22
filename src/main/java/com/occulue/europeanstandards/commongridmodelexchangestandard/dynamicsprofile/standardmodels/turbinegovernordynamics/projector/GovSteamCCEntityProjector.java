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
 * Projector for GovSteamCC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovSteamCCAggregate
 *
 * @author your_name_here
 */
@Component("govSteamCC-entity-projector")
public class GovSteamCCEntityProjector {

  // core constructor
  public GovSteamCCEntityProjector(GovSteamCCRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovSteamCC
   *
   * @param	entity GovSteamCC
   */
  public GovSteamCC create(GovSteamCC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovSteamCC
   *
   * @param	entity GovSteamCC
   */
  public GovSteamCC update(GovSteamCC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovSteamCC
   *
   * @param	id		UUID
   */
  public GovSteamCC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovSteamCC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Dhp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamCC
   */
  public GovSteamCC assignDhp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dhp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dhp to the parent entity
    // ------------------------------------------
    parentEntity.setDhp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dhp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignDhp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dhp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dhp on the parent entithy
    // ------------------------------------------
    parentEntity.setDhp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dlp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamCC
   */
  public GovSteamCC assignDlp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dlp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dlp to the parent entity
    // ------------------------------------------
    parentEntity.setDlp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dlp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignDlp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dlp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dlp on the parent entithy
    // ------------------------------------------
    parentEntity.setDlp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fhp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamCC
   */
  public GovSteamCC assignFhp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fhp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fhp to the parent entity
    // ------------------------------------------
    parentEntity.setFhp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fhp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignFhp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fhp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fhp on the parent entithy
    // ------------------------------------------
    parentEntity.setFhp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Flp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamCC
   */
  public GovSteamCC assignFlp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Flp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Flp to the parent entity
    // ------------------------------------------
    parentEntity.setFlp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Flp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignFlp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Flp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Flp on the parent entithy
    // ------------------------------------------
    parentEntity.setFlp(null);

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
   * @return	GovSteamCC
   */
  public GovSteamCC assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignMwbase(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

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
   * Assign a Pmaxhp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamCC
   */
  public GovSteamCC assignPmaxhp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmaxhp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmaxhp to the parent entity
    // ------------------------------------------
    parentEntity.setPmaxhp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmaxhp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignPmaxhp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmaxhp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmaxhp on the parent entithy
    // ------------------------------------------
    parentEntity.setPmaxhp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmaxlp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamCC
   */
  public GovSteamCC assignPmaxlp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmaxlp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmaxlp to the parent entity
    // ------------------------------------------
    parentEntity.setPmaxlp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmaxlp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignPmaxlp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmaxlp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmaxlp on the parent entithy
    // ------------------------------------------
    parentEntity.setPmaxlp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rhp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamCC
   */
  public GovSteamCC assignRhp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rhp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rhp to the parent entity
    // ------------------------------------------
    parentEntity.setRhp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rhp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignRhp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rhp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rhp on the parent entithy
    // ------------------------------------------
    parentEntity.setRhp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rlp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamCC
   */
  public GovSteamCC assignRlp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rlp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rlp to the parent entity
    // ------------------------------------------
    parentEntity.setRlp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rlp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignRlp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rlp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rlp on the parent entithy
    // ------------------------------------------
    parentEntity.setRlp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T1hp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamCC
   */
  public GovSteamCC assignT1hp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1hp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T1hp to the parent entity
    // ------------------------------------------
    parentEntity.setT1hp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T1hp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignT1hp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T1hp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T1hp on the parent entithy
    // ------------------------------------------
    parentEntity.setT1hp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T1lp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamCC
   */
  public GovSteamCC assignT1lp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1lp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T1lp to the parent entity
    // ------------------------------------------
    parentEntity.setT1lp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T1lp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignT1lp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T1lp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T1lp on the parent entithy
    // ------------------------------------------
    parentEntity.setT1lp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T3hp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamCC
   */
  public GovSteamCC assignT3hp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3hp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T3hp to the parent entity
    // ------------------------------------------
    parentEntity.setT3hp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T3hp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignT3hp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T3hp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T3hp on the parent entithy
    // ------------------------------------------
    parentEntity.setT3hp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T3lp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamCC
   */
  public GovSteamCC assignT3lp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3lp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T3lp to the parent entity
    // ------------------------------------------
    parentEntity.setT3lp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T3lp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignT3lp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T3lp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T3lp on the parent entithy
    // ------------------------------------------
    parentEntity.setT3lp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T4hp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamCC
   */
  public GovSteamCC assignT4hp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4hp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T4hp to the parent entity
    // ------------------------------------------
    parentEntity.setT4hp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T4hp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignT4hp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T4hp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T4hp on the parent entithy
    // ------------------------------------------
    parentEntity.setT4hp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T4lp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamCC
   */
  public GovSteamCC assignT4lp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4lp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T4lp to the parent entity
    // ------------------------------------------
    parentEntity.setT4lp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T4lp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignT4lp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T4lp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T4lp on the parent entithy
    // ------------------------------------------
    parentEntity.setT4lp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T5hp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamCC
   */
  public GovSteamCC assignT5hp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T5hp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T5hp to the parent entity
    // ------------------------------------------
    parentEntity.setT5hp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T5hp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignT5hp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T5hp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T5hp on the parent entithy
    // ------------------------------------------
    parentEntity.setT5hp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T5lp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamCC
   */
  public GovSteamCC assignT5lp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T5lp as " + assignment.toString());

    GovSteamCC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T5lp to the parent entity
    // ------------------------------------------
    parentEntity.setT5lp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T5lp
   *
   * @param	parentId		UUID
   * @return	GovSteamCC
   */
  public GovSteamCC unAssignT5lp(UUID parentId) {
    GovSteamCC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T5lp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T5lp on the parent entithy
    // ------------------------------------------
    parentEntity.setT5lp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovSteamCC via an FindGovSteamCCQuery
   *
   * @return query FindGovSteamCCQuery
   */
  @SuppressWarnings("unused")
  public GovSteamCC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovSteamCC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovSteamCCs
   *
   * @param query FindAllGovSteamCCQuery
   * @return List<GovSteamCC>
   */
  @SuppressWarnings("unused")
  public List<GovSteamCC> findAll(FindAllGovSteamCCQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovSteamCC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovSteamCCRepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(GovSteamCCEntityProjector.class.getName());
}
