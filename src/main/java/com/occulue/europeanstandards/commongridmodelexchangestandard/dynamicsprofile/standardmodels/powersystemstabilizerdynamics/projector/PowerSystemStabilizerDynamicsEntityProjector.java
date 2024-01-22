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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for PowerSystemStabilizerDynamics as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PowerSystemStabilizerDynamicsAggregate
 *
 * @author your_name_here
 */
@Component("powerSystemStabilizerDynamics-entity-projector")
public class PowerSystemStabilizerDynamicsEntityProjector {

  // core constructor
  public PowerSystemStabilizerDynamicsEntityProjector(
      PowerSystemStabilizerDynamicsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PowerSystemStabilizerDynamics
   *
   * @param	entity PowerSystemStabilizerDynamics
   */
  public PowerSystemStabilizerDynamics create(PowerSystemStabilizerDynamics entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PowerSystemStabilizerDynamics
   *
   * @param	entity PowerSystemStabilizerDynamics
   */
  public PowerSystemStabilizerDynamics update(PowerSystemStabilizerDynamics entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PowerSystemStabilizerDynamics
   *
   * @param	id		UUID
   */
  public PowerSystemStabilizerDynamics delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PowerSystemStabilizerDynamics entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a PowerSystemStabilizerDynamics
   *
   * @param	parentId	UUID
   * @param	assignment 	PowerSystemStabilizerDynamics
   * @return	PowerSystemStabilizerDynamics
   */
  public PowerSystemStabilizerDynamics assignPowerSystemStabilizerDynamics(
      UUID parentId, PowerSystemStabilizerDynamics assignment) {
    LOGGER.info("assigning PowerSystemStabilizerDynamics as " + assignment.toString());

    PowerSystemStabilizerDynamics parentEntity = repository.findById(parentId).get();
    assignment =
        PowerSystemStabilizerDynamicsProjector.find(
            assignment.getPowerSystemStabilizerDynamicsId());

    // ------------------------------------------
    // assign the PowerSystemStabilizerDynamics to the parent entity
    // ------------------------------------------
    parentEntity.setPowerSystemStabilizerDynamics(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PowerSystemStabilizerDynamics
   *
   * @param	parentId		UUID
   * @return	PowerSystemStabilizerDynamics
   */
  public PowerSystemStabilizerDynamics unAssignPowerSystemStabilizerDynamics(UUID parentId) {
    PowerSystemStabilizerDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PowerSystemStabilizerDynamics on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PowerSystemStabilizerDynamics on the parent entithy
    // ------------------------------------------
    parentEntity.setPowerSystemStabilizerDynamics(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PowerSystemStabilizerDynamics via an
   * FindPowerSystemStabilizerDynamicsQuery
   *
   * @return query FindPowerSystemStabilizerDynamicsQuery
   */
  @SuppressWarnings("unused")
  public PowerSystemStabilizerDynamics find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a PowerSystemStabilizerDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PowerSystemStabilizerDynamicss
   *
   * @param query FindAllPowerSystemStabilizerDynamicsQuery
   * @return List<PowerSystemStabilizerDynamics>
   */
  @SuppressWarnings("unused")
  public List<PowerSystemStabilizerDynamics> findAll(
      FindAllPowerSystemStabilizerDynamicsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find all PowerSystemStabilizerDynamics - {0}",
          exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PowerSystemStabilizerDynamicsRepository repository;

  @Autowired
  @Qualifier(value = "powerSystemStabilizerDynamics-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.PowerSystemStabilizerDynamicsEntityProjector
      PowerSystemStabilizerDynamicsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(PowerSystemStabilizerDynamicsEntityProjector.class.getName());
}
