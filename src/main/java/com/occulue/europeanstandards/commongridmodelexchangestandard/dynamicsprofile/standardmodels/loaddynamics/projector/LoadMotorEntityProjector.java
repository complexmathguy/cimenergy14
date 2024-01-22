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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for LoadMotor as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by LoadMotorAggregate
 *
 * @author your_name_here
 */
@Component("loadMotor-entity-projector")
public class LoadMotorEntityProjector {

  // core constructor
  public LoadMotorEntityProjector(LoadMotorRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a LoadMotor
   *
   * @param	entity LoadMotor
   */
  public LoadMotor create(LoadMotor entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a LoadMotor
   *
   * @param	entity LoadMotor
   */
  public LoadMotor update(LoadMotor entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a LoadMotor
   *
   * @param	id		UUID
   */
  public LoadMotor delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    LoadMotor entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a D
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadMotor
   */
  public LoadMotor assignD(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning D as " + assignment.toString());

    LoadMotor parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the D to the parent entity
    // ------------------------------------------
    parentEntity.setD(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the D
   *
   * @param	parentId		UUID
   * @return	LoadMotor
   */
  public LoadMotor unAssignD(UUID parentId) {
    LoadMotor parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning D on " + parentEntity.toString());

    // ------------------------------------------
    // null out the D on the parent entithy
    // ------------------------------------------
    parentEntity.setD(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a H
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	LoadMotor
   */
  public LoadMotor assignH(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning H as " + assignment.toString());

    LoadMotor parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the H to the parent entity
    // ------------------------------------------
    parentEntity.setH(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the H
   *
   * @param	parentId		UUID
   * @return	LoadMotor
   */
  public LoadMotor unAssignH(UUID parentId) {
    LoadMotor parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning H on " + parentEntity.toString());

    // ------------------------------------------
    // null out the H on the parent entithy
    // ------------------------------------------
    parentEntity.setH(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Lfac
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadMotor
   */
  public LoadMotor assignLfac(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Lfac as " + assignment.toString());

    LoadMotor parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Lfac to the parent entity
    // ------------------------------------------
    parentEntity.setLfac(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Lfac
   *
   * @param	parentId		UUID
   * @return	LoadMotor
   */
  public LoadMotor unAssignLfac(UUID parentId) {
    LoadMotor parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Lfac on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Lfac on the parent entithy
    // ------------------------------------------
    parentEntity.setLfac(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Lp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	LoadMotor
   */
  public LoadMotor assignLp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Lp as " + assignment.toString());

    LoadMotor parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Lp to the parent entity
    // ------------------------------------------
    parentEntity.setLp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Lp
   *
   * @param	parentId		UUID
   * @return	LoadMotor
   */
  public LoadMotor unAssignLp(UUID parentId) {
    LoadMotor parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Lp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Lp on the parent entithy
    // ------------------------------------------
    parentEntity.setLp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Lpp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	LoadMotor
   */
  public LoadMotor assignLpp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Lpp as " + assignment.toString());

    LoadMotor parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Lpp to the parent entity
    // ------------------------------------------
    parentEntity.setLpp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Lpp
   *
   * @param	parentId		UUID
   * @return	LoadMotor
   */
  public LoadMotor unAssignLpp(UUID parentId) {
    LoadMotor parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Lpp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Lpp on the parent entithy
    // ------------------------------------------
    parentEntity.setLpp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ls
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	LoadMotor
   */
  public LoadMotor assignLs(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ls as " + assignment.toString());

    LoadMotor parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ls to the parent entity
    // ------------------------------------------
    parentEntity.setLs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ls
   *
   * @param	parentId		UUID
   * @return	LoadMotor
   */
  public LoadMotor unAssignLs(UUID parentId) {
    LoadMotor parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ls on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ls on the parent entithy
    // ------------------------------------------
    parentEntity.setLs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pfrac
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadMotor
   */
  public LoadMotor assignPfrac(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Pfrac as " + assignment.toString());

    LoadMotor parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Pfrac to the parent entity
    // ------------------------------------------
    parentEntity.setPfrac(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pfrac
   *
   * @param	parentId		UUID
   * @return	LoadMotor
   */
  public LoadMotor unAssignPfrac(UUID parentId) {
    LoadMotor parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pfrac on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pfrac on the parent entithy
    // ------------------------------------------
    parentEntity.setPfrac(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ra
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	LoadMotor
   */
  public LoadMotor assignRa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ra as " + assignment.toString());

    LoadMotor parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ra to the parent entity
    // ------------------------------------------
    parentEntity.setRa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ra
   *
   * @param	parentId		UUID
   * @return	LoadMotor
   */
  public LoadMotor unAssignRa(UUID parentId) {
    LoadMotor parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ra on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ra on the parent entithy
    // ------------------------------------------
    parentEntity.setRa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tbkr
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	LoadMotor
   */
  public LoadMotor assignTbkr(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tbkr as " + assignment.toString());

    LoadMotor parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tbkr to the parent entity
    // ------------------------------------------
    parentEntity.setTbkr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tbkr
   *
   * @param	parentId		UUID
   * @return	LoadMotor
   */
  public LoadMotor unAssignTbkr(UUID parentId) {
    LoadMotor parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tbkr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tbkr on the parent entithy
    // ------------------------------------------
    parentEntity.setTbkr(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpo
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	LoadMotor
   */
  public LoadMotor assignTpo(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpo as " + assignment.toString());

    LoadMotor parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpo to the parent entity
    // ------------------------------------------
    parentEntity.setTpo(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpo
   *
   * @param	parentId		UUID
   * @return	LoadMotor
   */
  public LoadMotor unAssignTpo(UUID parentId) {
    LoadMotor parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpo on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpo on the parent entithy
    // ------------------------------------------
    parentEntity.setTpo(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tppo
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	LoadMotor
   */
  public LoadMotor assignTppo(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tppo as " + assignment.toString());

    LoadMotor parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tppo to the parent entity
    // ------------------------------------------
    parentEntity.setTppo(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tppo
   *
   * @param	parentId		UUID
   * @return	LoadMotor
   */
  public LoadMotor unAssignTppo(UUID parentId) {
    LoadMotor parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tppo on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tppo on the parent entithy
    // ------------------------------------------
    parentEntity.setTppo(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tv
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	LoadMotor
   */
  public LoadMotor assignTv(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tv as " + assignment.toString());

    LoadMotor parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tv to the parent entity
    // ------------------------------------------
    parentEntity.setTv(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tv
   *
   * @param	parentId		UUID
   * @return	LoadMotor
   */
  public LoadMotor unAssignTv(UUID parentId) {
    LoadMotor parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tv on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tv on the parent entithy
    // ------------------------------------------
    parentEntity.setTv(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vt
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	LoadMotor
   */
  public LoadMotor assignVt(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vt as " + assignment.toString());

    LoadMotor parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vt to the parent entity
    // ------------------------------------------
    parentEntity.setVt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vt
   *
   * @param	parentId		UUID
   * @return	LoadMotor
   */
  public LoadMotor unAssignVt(UUID parentId) {
    LoadMotor parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vt on the parent entithy
    // ------------------------------------------
    parentEntity.setVt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a LoadMotor
   *
   * @param	parentId	UUID
   * @param	assignment 	LoadMotor
   * @return	LoadMotor
   */
  public LoadMotor assignLoadMotor(UUID parentId, LoadMotor assignment) {
    LOGGER.info("assigning LoadMotor as " + assignment.toString());

    LoadMotor parentEntity = repository.findById(parentId).get();
    assignment = LoadMotorProjector.find(assignment.getLoadMotorId());

    // ------------------------------------------
    // assign the LoadMotor to the parent entity
    // ------------------------------------------
    parentEntity.setLoadMotor(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the LoadMotor
   *
   * @param	parentId		UUID
   * @return	LoadMotor
   */
  public LoadMotor unAssignLoadMotor(UUID parentId) {
    LoadMotor parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning LoadMotor on " + parentEntity.toString());

    // ------------------------------------------
    // null out the LoadMotor on the parent entithy
    // ------------------------------------------
    parentEntity.setLoadMotor(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the LoadMotor via an FindLoadMotorQuery
   *
   * @return query FindLoadMotorQuery
   */
  @SuppressWarnings("unused")
  public LoadMotor find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a LoadMotor - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all LoadMotors
   *
   * @param query FindAllLoadMotorQuery
   * @return List<LoadMotor>
   */
  @SuppressWarnings("unused")
  public List<LoadMotor> findAll(FindAllLoadMotorQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all LoadMotor - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final LoadMotorRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "loadMotor-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .loaddynamics.projector.LoadMotorEntityProjector
      LoadMotorProjector;

  private static final Logger LOGGER = Logger.getLogger(LoadMotorEntityProjector.class.getName());
}
