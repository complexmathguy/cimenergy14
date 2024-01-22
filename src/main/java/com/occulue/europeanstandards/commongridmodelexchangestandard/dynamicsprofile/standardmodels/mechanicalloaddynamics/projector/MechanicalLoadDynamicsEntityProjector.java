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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.mechanicalloaddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.mechanicalloaddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for MechanicalLoadDynamics as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by MechanicalLoadDynamicsAggregate
 *
 * @author your_name_here
 */
@Component("mechanicalLoadDynamics-entity-projector")
public class MechanicalLoadDynamicsEntityProjector {

  // core constructor
  public MechanicalLoadDynamicsEntityProjector(MechanicalLoadDynamicsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a MechanicalLoadDynamics
   *
   * @param	entity MechanicalLoadDynamics
   */
  public MechanicalLoadDynamics create(MechanicalLoadDynamics entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a MechanicalLoadDynamics
   *
   * @param	entity MechanicalLoadDynamics
   */
  public MechanicalLoadDynamics update(MechanicalLoadDynamics entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a MechanicalLoadDynamics
   *
   * @param	id		UUID
   */
  public MechanicalLoadDynamics delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    MechanicalLoadDynamics entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a MechanicalLoadDynamics
   *
   * @param	parentId	UUID
   * @param	assignment 	MechanicalLoadDynamics
   * @return	MechanicalLoadDynamics
   */
  public MechanicalLoadDynamics assignMechanicalLoadDynamics(
      UUID parentId, MechanicalLoadDynamics assignment) {
    LOGGER.info("assigning MechanicalLoadDynamics as " + assignment.toString());

    MechanicalLoadDynamics parentEntity = repository.findById(parentId).get();
    assignment = MechanicalLoadDynamicsProjector.find(assignment.getMechanicalLoadDynamicsId());

    // ------------------------------------------
    // assign the MechanicalLoadDynamics to the parent entity
    // ------------------------------------------
    parentEntity.setMechanicalLoadDynamics(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MechanicalLoadDynamics
   *
   * @param	parentId		UUID
   * @return	MechanicalLoadDynamics
   */
  public MechanicalLoadDynamics unAssignMechanicalLoadDynamics(UUID parentId) {
    MechanicalLoadDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MechanicalLoadDynamics on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MechanicalLoadDynamics on the parent entithy
    // ------------------------------------------
    parentEntity.setMechanicalLoadDynamics(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the MechanicalLoadDynamics via an FindMechanicalLoadDynamicsQuery
   *
   * @return query FindMechanicalLoadDynamicsQuery
   */
  @SuppressWarnings("unused")
  public MechanicalLoadDynamics find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a MechanicalLoadDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all MechanicalLoadDynamicss
   *
   * @param query FindAllMechanicalLoadDynamicsQuery
   * @return List<MechanicalLoadDynamics>
   */
  @SuppressWarnings("unused")
  public List<MechanicalLoadDynamics> findAll(FindAllMechanicalLoadDynamicsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all MechanicalLoadDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final MechanicalLoadDynamicsRepository repository;

  @Autowired
  @Qualifier(value = "mechanicalLoadDynamics-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .mechanicalloaddynamics.projector.MechanicalLoadDynamicsEntityProjector
      MechanicalLoadDynamicsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(MechanicalLoadDynamicsEntityProjector.class.getName());
}
