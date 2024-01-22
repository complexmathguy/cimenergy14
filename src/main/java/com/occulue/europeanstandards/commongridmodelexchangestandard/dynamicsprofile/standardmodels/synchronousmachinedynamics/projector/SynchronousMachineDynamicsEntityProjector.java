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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for SynchronousMachineDynamics as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SynchronousMachineDynamicsAggregate
 *
 * @author your_name_here
 */
@Component("synchronousMachineDynamics-entity-projector")
public class SynchronousMachineDynamicsEntityProjector {

  // core constructor
  public SynchronousMachineDynamicsEntityProjector(
      SynchronousMachineDynamicsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a SynchronousMachineDynamics
   *
   * @param	entity SynchronousMachineDynamics
   */
  public SynchronousMachineDynamics create(SynchronousMachineDynamics entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a SynchronousMachineDynamics
   *
   * @param	entity SynchronousMachineDynamics
   */
  public SynchronousMachineDynamics update(SynchronousMachineDynamics entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a SynchronousMachineDynamics
   *
   * @param	id		UUID
   */
  public SynchronousMachineDynamics delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    SynchronousMachineDynamics entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a SynchronousMachineDynamics
   *
   * @param	parentId	UUID
   * @param	assignment 	SynchronousMachineDynamics
   * @return	SynchronousMachineDynamics
   */
  public SynchronousMachineDynamics assignSynchronousMachineDynamics(
      UUID parentId, SynchronousMachineDynamics assignment) {
    LOGGER.info("assigning SynchronousMachineDynamics as " + assignment.toString());

    SynchronousMachineDynamics parentEntity = repository.findById(parentId).get();
    assignment =
        SynchronousMachineDynamicsProjector.find(assignment.getSynchronousMachineDynamicsId());

    // ------------------------------------------
    // assign the SynchronousMachineDynamics to the parent entity
    // ------------------------------------------
    parentEntity.setSynchronousMachineDynamics(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SynchronousMachineDynamics
   *
   * @param	parentId		UUID
   * @return	SynchronousMachineDynamics
   */
  public SynchronousMachineDynamics unAssignSynchronousMachineDynamics(UUID parentId) {
    SynchronousMachineDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SynchronousMachineDynamics on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SynchronousMachineDynamics on the parent entithy
    // ------------------------------------------
    parentEntity.setSynchronousMachineDynamics(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the SynchronousMachineDynamics via an FindSynchronousMachineDynamicsQuery
   *
   * @return query FindSynchronousMachineDynamicsQuery
   */
  @SuppressWarnings("unused")
  public SynchronousMachineDynamics find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a SynchronousMachineDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all SynchronousMachineDynamicss
   *
   * @param query FindAllSynchronousMachineDynamicsQuery
   * @return List<SynchronousMachineDynamics>
   */
  @SuppressWarnings("unused")
  public List<SynchronousMachineDynamics> findAll(FindAllSynchronousMachineDynamicsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all SynchronousMachineDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SynchronousMachineDynamicsRepository repository;

  @Autowired
  @Qualifier(value = "synchronousMachineDynamics-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .synchronousmachinedynamics.projector.SynchronousMachineDynamicsEntityProjector
      SynchronousMachineDynamicsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineDynamicsEntityProjector.class.getName());
}
