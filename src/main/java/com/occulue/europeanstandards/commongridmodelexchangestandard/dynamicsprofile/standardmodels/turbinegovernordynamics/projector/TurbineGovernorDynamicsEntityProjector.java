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
 * Projector for TurbineGovernorDynamics as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by TurbineGovernorDynamicsAggregate
 *
 * @author your_name_here
 */
@Component("turbineGovernorDynamics-entity-projector")
public class TurbineGovernorDynamicsEntityProjector {

  // core constructor
  public TurbineGovernorDynamicsEntityProjector(TurbineGovernorDynamicsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a TurbineGovernorDynamics
   *
   * @param	entity TurbineGovernorDynamics
   */
  public TurbineGovernorDynamics create(TurbineGovernorDynamics entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a TurbineGovernorDynamics
   *
   * @param	entity TurbineGovernorDynamics
   */
  public TurbineGovernorDynamics update(TurbineGovernorDynamics entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a TurbineGovernorDynamics
   *
   * @param	id		UUID
   */
  public TurbineGovernorDynamics delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    TurbineGovernorDynamics entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a TurbineGovernorDynamics
   *
   * @param	parentId	UUID
   * @param	assignment 	TurbineGovernorDynamics
   * @return	TurbineGovernorDynamics
   */
  public TurbineGovernorDynamics assignTurbineGovernorDynamics(
      UUID parentId, TurbineGovernorDynamics assignment) {
    LOGGER.info("assigning TurbineGovernorDynamics as " + assignment.toString());

    TurbineGovernorDynamics parentEntity = repository.findById(parentId).get();
    assignment = TurbineGovernorDynamicsProjector.find(assignment.getTurbineGovernorDynamicsId());

    // ------------------------------------------
    // assign the TurbineGovernorDynamics to the parent entity
    // ------------------------------------------
    parentEntity.setTurbineGovernorDynamics(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the TurbineGovernorDynamics
   *
   * @param	parentId		UUID
   * @return	TurbineGovernorDynamics
   */
  public TurbineGovernorDynamics unAssignTurbineGovernorDynamics(UUID parentId) {
    TurbineGovernorDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning TurbineGovernorDynamics on " + parentEntity.toString());

    // ------------------------------------------
    // null out the TurbineGovernorDynamics on the parent entithy
    // ------------------------------------------
    parentEntity.setTurbineGovernorDynamics(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the TurbineGovernorDynamics via an FindTurbineGovernorDynamicsQuery
   *
   * @return query FindTurbineGovernorDynamicsQuery
   */
  @SuppressWarnings("unused")
  public TurbineGovernorDynamics find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a TurbineGovernorDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all TurbineGovernorDynamicss
   *
   * @param query FindAllTurbineGovernorDynamicsQuery
   * @return List<TurbineGovernorDynamics>
   */
  @SuppressWarnings("unused")
  public List<TurbineGovernorDynamics> findAll(FindAllTurbineGovernorDynamicsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all TurbineGovernorDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final TurbineGovernorDynamicsRepository repository;

  @Autowired
  @Qualifier(value = "turbineGovernorDynamics-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.TurbineGovernorDynamicsEntityProjector
      TurbineGovernorDynamicsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(TurbineGovernorDynamicsEntityProjector.class.getName());
}
