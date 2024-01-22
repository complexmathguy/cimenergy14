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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcitationSystemDynamics as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcitationSystemDynamicsAggregate
 *
 * @author your_name_here
 */
@Component("excitationSystemDynamics-entity-projector")
public class ExcitationSystemDynamicsEntityProjector {

  // core constructor
  public ExcitationSystemDynamicsEntityProjector(ExcitationSystemDynamicsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcitationSystemDynamics
   *
   * @param	entity ExcitationSystemDynamics
   */
  public ExcitationSystemDynamics create(ExcitationSystemDynamics entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcitationSystemDynamics
   *
   * @param	entity ExcitationSystemDynamics
   */
  public ExcitationSystemDynamics update(ExcitationSystemDynamics entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcitationSystemDynamics
   *
   * @param	id		UUID
   */
  public ExcitationSystemDynamics delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcitationSystemDynamics entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a ExcitationSystemDynamics
   *
   * @param	parentId	UUID
   * @param	assignment 	ExcitationSystemDynamics
   * @return	ExcitationSystemDynamics
   */
  public ExcitationSystemDynamics assignExcitationSystemDynamics(
      UUID parentId, ExcitationSystemDynamics assignment) {
    LOGGER.info("assigning ExcitationSystemDynamics as " + assignment.toString());

    ExcitationSystemDynamics parentEntity = repository.findById(parentId).get();
    assignment = ExcitationSystemDynamicsProjector.find(assignment.getExcitationSystemDynamicsId());

    // ------------------------------------------
    // assign the ExcitationSystemDynamics to the parent entity
    // ------------------------------------------
    parentEntity.setExcitationSystemDynamics(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ExcitationSystemDynamics
   *
   * @param	parentId		UUID
   * @return	ExcitationSystemDynamics
   */
  public ExcitationSystemDynamics unAssignExcitationSystemDynamics(UUID parentId) {
    ExcitationSystemDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ExcitationSystemDynamics on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ExcitationSystemDynamics on the parent entithy
    // ------------------------------------------
    parentEntity.setExcitationSystemDynamics(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExcitationSystemDynamics via an FindExcitationSystemDynamicsQuery
   *
   * @return query FindExcitationSystemDynamicsQuery
   */
  @SuppressWarnings("unused")
  public ExcitationSystemDynamics find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a ExcitationSystemDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcitationSystemDynamicss
   *
   * @param query FindAllExcitationSystemDynamicsQuery
   * @return List<ExcitationSystemDynamics>
   */
  @SuppressWarnings("unused")
  public List<ExcitationSystemDynamics> findAll(FindAllExcitationSystemDynamicsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all ExcitationSystemDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcitationSystemDynamicsRepository repository;

  @Autowired
  @Qualifier(value = "excitationSystemDynamics-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcitationSystemDynamicsEntityProjector
      ExcitationSystemDynamicsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(ExcitationSystemDynamicsEntityProjector.class.getName());
}
