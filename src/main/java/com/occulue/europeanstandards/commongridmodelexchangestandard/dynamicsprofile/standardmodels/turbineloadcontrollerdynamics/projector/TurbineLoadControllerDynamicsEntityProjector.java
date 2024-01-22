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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for TurbineLoadControllerDynamics as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by TurbineLoadControllerDynamicsAggregate
 *
 * @author your_name_here
 */
@Component("turbineLoadControllerDynamics-entity-projector")
public class TurbineLoadControllerDynamicsEntityProjector {

  // core constructor
  public TurbineLoadControllerDynamicsEntityProjector(
      TurbineLoadControllerDynamicsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a TurbineLoadControllerDynamics
   *
   * @param	entity TurbineLoadControllerDynamics
   */
  public TurbineLoadControllerDynamics create(TurbineLoadControllerDynamics entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a TurbineLoadControllerDynamics
   *
   * @param	entity TurbineLoadControllerDynamics
   */
  public TurbineLoadControllerDynamics update(TurbineLoadControllerDynamics entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a TurbineLoadControllerDynamics
   *
   * @param	id		UUID
   */
  public TurbineLoadControllerDynamics delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    TurbineLoadControllerDynamics entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a TurbineLoadControllerDynamics
   *
   * @param	parentId	UUID
   * @param	assignment 	TurbineLoadControllerDynamics
   * @return	TurbineLoadControllerDynamics
   */
  public TurbineLoadControllerDynamics assignTurbineLoadControllerDynamics(
      UUID parentId, TurbineLoadControllerDynamics assignment) {
    LOGGER.info("assigning TurbineLoadControllerDynamics as " + assignment.toString());

    TurbineLoadControllerDynamics parentEntity = repository.findById(parentId).get();
    assignment =
        TurbineLoadControllerDynamicsProjector.find(
            assignment.getTurbineLoadControllerDynamicsId());

    // ------------------------------------------
    // assign the TurbineLoadControllerDynamics to the parent entity
    // ------------------------------------------
    parentEntity.setTurbineLoadControllerDynamics(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the TurbineLoadControllerDynamics
   *
   * @param	parentId		UUID
   * @return	TurbineLoadControllerDynamics
   */
  public TurbineLoadControllerDynamics unAssignTurbineLoadControllerDynamics(UUID parentId) {
    TurbineLoadControllerDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning TurbineLoadControllerDynamics on " + parentEntity.toString());

    // ------------------------------------------
    // null out the TurbineLoadControllerDynamics on the parent entithy
    // ------------------------------------------
    parentEntity.setTurbineLoadControllerDynamics(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the TurbineLoadControllerDynamics via an
   * FindTurbineLoadControllerDynamicsQuery
   *
   * @return query FindTurbineLoadControllerDynamicsQuery
   */
  @SuppressWarnings("unused")
  public TurbineLoadControllerDynamics find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a TurbineLoadControllerDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all TurbineLoadControllerDynamicss
   *
   * @param query FindAllTurbineLoadControllerDynamicsQuery
   * @return List<TurbineLoadControllerDynamics>
   */
  @SuppressWarnings("unused")
  public List<TurbineLoadControllerDynamics> findAll(
      FindAllTurbineLoadControllerDynamicsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find all TurbineLoadControllerDynamics - {0}",
          exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final TurbineLoadControllerDynamicsRepository repository;

  @Autowired
  @Qualifier(value = "turbineLoadControllerDynamics-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbineloadcontrollerdynamics.projector.TurbineLoadControllerDynamicsEntityProjector
      TurbineLoadControllerDynamicsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(TurbineLoadControllerDynamicsEntityProjector.class.getName());
}
