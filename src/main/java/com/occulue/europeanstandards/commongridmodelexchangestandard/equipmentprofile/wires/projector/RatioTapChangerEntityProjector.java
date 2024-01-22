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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for RatioTapChanger as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by RatioTapChangerAggregate
 *
 * @author your_name_here
 */
@Component("ratioTapChanger-entity-projector")
public class RatioTapChangerEntityProjector {

  // core constructor
  public RatioTapChangerEntityProjector(RatioTapChangerRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a RatioTapChanger
   *
   * @param	entity RatioTapChanger
   */
  public RatioTapChanger create(RatioTapChanger entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a RatioTapChanger
   *
   * @param	entity RatioTapChanger
   */
  public RatioTapChanger update(RatioTapChanger entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a RatioTapChanger
   *
   * @param	id		UUID
   */
  public RatioTapChanger delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    RatioTapChanger entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a StepVoltageIncrement
   *
   * @param	parentId	UUID
   * @param	assignment 	PerCent
   * @return	RatioTapChanger
   */
  public RatioTapChanger assignStepVoltageIncrement(UUID parentId, PerCent assignment) {
    LOGGER.info("assigning StepVoltageIncrement as " + assignment.toString());

    RatioTapChanger parentEntity = repository.findById(parentId).get();
    assignment = PerCentProjector.find(assignment.getPerCentId());

    // ------------------------------------------
    // assign the StepVoltageIncrement to the parent entity
    // ------------------------------------------
    parentEntity.setStepVoltageIncrement(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the StepVoltageIncrement
   *
   * @param	parentId		UUID
   * @return	RatioTapChanger
   */
  public RatioTapChanger unAssignStepVoltageIncrement(UUID parentId) {
    RatioTapChanger parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning StepVoltageIncrement on " + parentEntity.toString());

    // ------------------------------------------
    // null out the StepVoltageIncrement on the parent entithy
    // ------------------------------------------
    parentEntity.setStepVoltageIncrement(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a RatioTapChanger
   *
   * @param	parentId	UUID
   * @param	assignment 	RatioTapChanger
   * @return	RatioTapChanger
   */
  public RatioTapChanger assignRatioTapChanger(UUID parentId, RatioTapChanger assignment) {
    LOGGER.info("assigning RatioTapChanger as " + assignment.toString());

    RatioTapChanger parentEntity = repository.findById(parentId).get();
    assignment = RatioTapChangerProjector.find(assignment.getRatioTapChangerId());

    // ------------------------------------------
    // assign the RatioTapChanger to the parent entity
    // ------------------------------------------
    parentEntity.setRatioTapChanger(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RatioTapChanger
   *
   * @param	parentId		UUID
   * @return	RatioTapChanger
   */
  public RatioTapChanger unAssignRatioTapChanger(UUID parentId) {
    RatioTapChanger parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RatioTapChanger on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RatioTapChanger on the parent entithy
    // ------------------------------------------
    parentEntity.setRatioTapChanger(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the RatioTapChanger via an FindRatioTapChangerQuery
   *
   * @return query FindRatioTapChangerQuery
   */
  @SuppressWarnings("unused")
  public RatioTapChanger find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a RatioTapChanger - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all RatioTapChangers
   *
   * @param query FindAllRatioTapChangerQuery
   * @return List<RatioTapChanger>
   */
  @SuppressWarnings("unused")
  public List<RatioTapChanger> findAll(FindAllRatioTapChangerQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all RatioTapChanger - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final RatioTapChangerRepository repository;

  @Autowired
  @Qualifier(value = "perCent-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PerCentEntityProjector
      PerCentProjector;

  @Autowired
  @Qualifier(value = "ratioTapChanger-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .RatioTapChangerEntityProjector
      RatioTapChangerProjector;

  private static final Logger LOGGER =
      Logger.getLogger(RatioTapChangerEntityProjector.class.getName());
}
