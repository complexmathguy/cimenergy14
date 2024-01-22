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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for CurrentLimit as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by CurrentLimitAggregate
 *
 * @author your_name_here
 */
@Component("currentLimit-entity-projector")
public class CurrentLimitEntityProjector {

  // core constructor
  public CurrentLimitEntityProjector(CurrentLimitRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a CurrentLimit
   *
   * @param	entity CurrentLimit
   */
  public CurrentLimit create(CurrentLimit entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a CurrentLimit
   *
   * @param	entity CurrentLimit
   */
  public CurrentLimit update(CurrentLimit entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a CurrentLimit
   *
   * @param	id		UUID
   */
  public CurrentLimit delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    CurrentLimit entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Value
   *
   * @param	parentId	UUID
   * @param	assignment 	CurrentFlow
   * @return	CurrentLimit
   */
  public CurrentLimit assignValue(UUID parentId, CurrentFlow assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    CurrentLimit parentEntity = repository.findById(parentId).get();
    assignment = CurrentFlowProjector.find(assignment.getCurrentFlowId());

    // ------------------------------------------
    // assign the Value to the parent entity
    // ------------------------------------------
    parentEntity.setValue(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Value
   *
   * @param	parentId		UUID
   * @return	CurrentLimit
   */
  public CurrentLimit unAssignValue(UUID parentId) {
    CurrentLimit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Value on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Value on the parent entithy
    // ------------------------------------------
    parentEntity.setValue(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the CurrentLimit via an FindCurrentLimitQuery
   *
   * @return query FindCurrentLimitQuery
   */
  @SuppressWarnings("unused")
  public CurrentLimit find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a CurrentLimit - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all CurrentLimits
   *
   * @param query FindAllCurrentLimitQuery
   * @return List<CurrentLimit>
   */
  @SuppressWarnings("unused")
  public List<CurrentLimit> findAll(FindAllCurrentLimitQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all CurrentLimit - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final CurrentLimitRepository repository;

  @Autowired
  @Qualifier(value = "currentFlow-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .CurrentFlowEntityProjector
      CurrentFlowProjector;

  private static final Logger LOGGER =
      Logger.getLogger(CurrentLimitEntityProjector.class.getName());
}
