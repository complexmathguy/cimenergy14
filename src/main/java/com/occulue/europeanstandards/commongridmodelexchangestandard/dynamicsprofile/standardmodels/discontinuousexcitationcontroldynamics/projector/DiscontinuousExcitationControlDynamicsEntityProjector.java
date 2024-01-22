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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for DiscontinuousExcitationControlDynamics as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DiscontinuousExcitationControlDynamicsAggregate
 *
 * @author your_name_here
 */
@Component("discontinuousExcitationControlDynamics-entity-projector")
public class DiscontinuousExcitationControlDynamicsEntityProjector {

  // core constructor
  public DiscontinuousExcitationControlDynamicsEntityProjector(
      DiscontinuousExcitationControlDynamicsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DiscontinuousExcitationControlDynamics
   *
   * @param	entity DiscontinuousExcitationControlDynamics
   */
  public DiscontinuousExcitationControlDynamics create(
      DiscontinuousExcitationControlDynamics entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DiscontinuousExcitationControlDynamics
   *
   * @param	entity DiscontinuousExcitationControlDynamics
   */
  public DiscontinuousExcitationControlDynamics update(
      DiscontinuousExcitationControlDynamics entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DiscontinuousExcitationControlDynamics
   *
   * @param	id		UUID
   */
  public DiscontinuousExcitationControlDynamics delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DiscontinuousExcitationControlDynamics entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a DiscontinuousExcitationControlDynamics
   *
   * @param	parentId	UUID
   * @param	assignment 	DiscontinuousExcitationControlDynamics
   * @return	DiscontinuousExcitationControlDynamics
   */
  public DiscontinuousExcitationControlDynamics assignDiscontinuousExcitationControlDynamics(
      UUID parentId, DiscontinuousExcitationControlDynamics assignment) {
    LOGGER.info("assigning DiscontinuousExcitationControlDynamics as " + assignment.toString());

    DiscontinuousExcitationControlDynamics parentEntity = repository.findById(parentId).get();
    assignment =
        DiscontinuousExcitationControlDynamicsProjector.find(
            assignment.getDiscontinuousExcitationControlDynamicsId());

    // ------------------------------------------
    // assign the DiscontinuousExcitationControlDynamics to the parent entity
    // ------------------------------------------
    parentEntity.setDiscontinuousExcitationControlDynamics(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the DiscontinuousExcitationControlDynamics
   *
   * @param	parentId		UUID
   * @return	DiscontinuousExcitationControlDynamics
   */
  public DiscontinuousExcitationControlDynamics unAssignDiscontinuousExcitationControlDynamics(
      UUID parentId) {
    DiscontinuousExcitationControlDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning DiscontinuousExcitationControlDynamics on " + parentEntity.toString());

    // ------------------------------------------
    // null out the DiscontinuousExcitationControlDynamics on the parent entithy
    // ------------------------------------------
    parentEntity.setDiscontinuousExcitationControlDynamics(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the DiscontinuousExcitationControlDynamics via an
   * FindDiscontinuousExcitationControlDynamicsQuery
   *
   * @return query FindDiscontinuousExcitationControlDynamicsQuery
   */
  @SuppressWarnings("unused")
  public DiscontinuousExcitationControlDynamics find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find a DiscontinuousExcitationControlDynamics - {0}",
          exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DiscontinuousExcitationControlDynamicss
   *
   * @param query FindAllDiscontinuousExcitationControlDynamicsQuery
   * @return List<DiscontinuousExcitationControlDynamics>
   */
  @SuppressWarnings("unused")
  public List<DiscontinuousExcitationControlDynamics> findAll(
      FindAllDiscontinuousExcitationControlDynamicsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find all DiscontinuousExcitationControlDynamics - {0}",
          exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DiscontinuousExcitationControlDynamicsRepository repository;

  @Autowired
  @Qualifier(value = "discontinuousExcitationControlDynamics-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .discontinuousexcitationcontroldynamics.projector
          .DiscontinuousExcitationControlDynamicsEntityProjector
      DiscontinuousExcitationControlDynamicsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(DiscontinuousExcitationControlDynamicsEntityProjector.class.getName());
}
