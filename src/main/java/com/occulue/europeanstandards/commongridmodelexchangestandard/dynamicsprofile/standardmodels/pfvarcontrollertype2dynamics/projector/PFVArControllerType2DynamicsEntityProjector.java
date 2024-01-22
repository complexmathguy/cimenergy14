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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for PFVArControllerType2Dynamics as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PFVArControllerType2DynamicsAggregate
 *
 * @author your_name_here
 */
@Component("pFVArControllerType2Dynamics-entity-projector")
public class PFVArControllerType2DynamicsEntityProjector {

  // core constructor
  public PFVArControllerType2DynamicsEntityProjector(
      PFVArControllerType2DynamicsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PFVArControllerType2Dynamics
   *
   * @param	entity PFVArControllerType2Dynamics
   */
  public PFVArControllerType2Dynamics create(PFVArControllerType2Dynamics entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PFVArControllerType2Dynamics
   *
   * @param	entity PFVArControllerType2Dynamics
   */
  public PFVArControllerType2Dynamics update(PFVArControllerType2Dynamics entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PFVArControllerType2Dynamics
   *
   * @param	id		UUID
   */
  public PFVArControllerType2Dynamics delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PFVArControllerType2Dynamics entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a PFVArControllerType2Dynamics
   *
   * @param	parentId	UUID
   * @param	assignment 	PFVArControllerType2Dynamics
   * @return	PFVArControllerType2Dynamics
   */
  public PFVArControllerType2Dynamics assignPFVArControllerType2Dynamics(
      UUID parentId, PFVArControllerType2Dynamics assignment) {
    LOGGER.info("assigning PFVArControllerType2Dynamics as " + assignment.toString());

    PFVArControllerType2Dynamics parentEntity = repository.findById(parentId).get();
    assignment =
        PFVArControllerType2DynamicsProjector.find(assignment.getPFVArControllerType2DynamicsId());

    // ------------------------------------------
    // assign the PFVArControllerType2Dynamics to the parent entity
    // ------------------------------------------
    parentEntity.setPFVArControllerType2Dynamics(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PFVArControllerType2Dynamics
   *
   * @param	parentId		UUID
   * @return	PFVArControllerType2Dynamics
   */
  public PFVArControllerType2Dynamics unAssignPFVArControllerType2Dynamics(UUID parentId) {
    PFVArControllerType2Dynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PFVArControllerType2Dynamics on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PFVArControllerType2Dynamics on the parent entithy
    // ------------------------------------------
    parentEntity.setPFVArControllerType2Dynamics(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PFVArControllerType2Dynamics via an
   * FindPFVArControllerType2DynamicsQuery
   *
   * @return query FindPFVArControllerType2DynamicsQuery
   */
  @SuppressWarnings("unused")
  public PFVArControllerType2Dynamics find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a PFVArControllerType2Dynamics - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PFVArControllerType2Dynamicss
   *
   * @param query FindAllPFVArControllerType2DynamicsQuery
   * @return List<PFVArControllerType2Dynamics>
   */
  @SuppressWarnings("unused")
  public List<PFVArControllerType2Dynamics> findAll(
      FindAllPFVArControllerType2DynamicsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all PFVArControllerType2Dynamics - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PFVArControllerType2DynamicsRepository repository;

  @Autowired
  @Qualifier(value = "pFVArControllerType2Dynamics-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .pfvarcontrollertype2dynamics.projector.PFVArControllerType2DynamicsEntityProjector
      PFVArControllerType2DynamicsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(PFVArControllerType2DynamicsEntityProjector.class.getName());
}
