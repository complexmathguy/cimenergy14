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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype1dynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype1dynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for PFVArControllerType1Dynamics as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PFVArControllerType1DynamicsAggregate
 *
 * @author your_name_here
 */
@Component("pFVArControllerType1Dynamics-entity-projector")
public class PFVArControllerType1DynamicsEntityProjector {

  // core constructor
  public PFVArControllerType1DynamicsEntityProjector(
      PFVArControllerType1DynamicsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PFVArControllerType1Dynamics
   *
   * @param	entity PFVArControllerType1Dynamics
   */
  public PFVArControllerType1Dynamics create(PFVArControllerType1Dynamics entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PFVArControllerType1Dynamics
   *
   * @param	entity PFVArControllerType1Dynamics
   */
  public PFVArControllerType1Dynamics update(PFVArControllerType1Dynamics entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PFVArControllerType1Dynamics
   *
   * @param	id		UUID
   */
  public PFVArControllerType1Dynamics delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PFVArControllerType1Dynamics entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a PFVArControllerType1Dynamics
   *
   * @param	parentId	UUID
   * @param	assignment 	PFVArControllerType1Dynamics
   * @return	PFVArControllerType1Dynamics
   */
  public PFVArControllerType1Dynamics assignPFVArControllerType1Dynamics(
      UUID parentId, PFVArControllerType1Dynamics assignment) {
    LOGGER.info("assigning PFVArControllerType1Dynamics as " + assignment.toString());

    PFVArControllerType1Dynamics parentEntity = repository.findById(parentId).get();
    assignment =
        PFVArControllerType1DynamicsProjector.find(assignment.getPFVArControllerType1DynamicsId());

    // ------------------------------------------
    // assign the PFVArControllerType1Dynamics to the parent entity
    // ------------------------------------------
    parentEntity.setPFVArControllerType1Dynamics(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PFVArControllerType1Dynamics
   *
   * @param	parentId		UUID
   * @return	PFVArControllerType1Dynamics
   */
  public PFVArControllerType1Dynamics unAssignPFVArControllerType1Dynamics(UUID parentId) {
    PFVArControllerType1Dynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PFVArControllerType1Dynamics on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PFVArControllerType1Dynamics on the parent entithy
    // ------------------------------------------
    parentEntity.setPFVArControllerType1Dynamics(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PFVArControllerType1Dynamics via an
   * FindPFVArControllerType1DynamicsQuery
   *
   * @return query FindPFVArControllerType1DynamicsQuery
   */
  @SuppressWarnings("unused")
  public PFVArControllerType1Dynamics find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a PFVArControllerType1Dynamics - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PFVArControllerType1Dynamicss
   *
   * @param query FindAllPFVArControllerType1DynamicsQuery
   * @return List<PFVArControllerType1Dynamics>
   */
  @SuppressWarnings("unused")
  public List<PFVArControllerType1Dynamics> findAll(
      FindAllPFVArControllerType1DynamicsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all PFVArControllerType1Dynamics - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PFVArControllerType1DynamicsRepository repository;

  @Autowired
  @Qualifier(value = "pFVArControllerType1Dynamics-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .pfvarcontrollertype1dynamics.projector.PFVArControllerType1DynamicsEntityProjector
      PFVArControllerType1DynamicsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(PFVArControllerType1DynamicsEntityProjector.class.getName());
}
