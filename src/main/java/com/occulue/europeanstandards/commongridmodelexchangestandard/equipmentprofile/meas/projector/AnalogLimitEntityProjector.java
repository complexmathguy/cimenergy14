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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for AnalogLimit as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by AnalogLimitAggregate
 *
 * @author your_name_here
 */
@Component("analogLimit-entity-projector")
public class AnalogLimitEntityProjector {

  // core constructor
  public AnalogLimitEntityProjector(AnalogLimitRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a AnalogLimit
   *
   * @param	entity AnalogLimit
   */
  public AnalogLimit create(AnalogLimit entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a AnalogLimit
   *
   * @param	entity AnalogLimit
   */
  public AnalogLimit update(AnalogLimit entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a AnalogLimit
   *
   * @param	id		UUID
   */
  public AnalogLimit delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    AnalogLimit entity = repository.findById(id).get();

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
   * @param	assignment 	Simple_Float
   * @return	AnalogLimit
   */
  public AnalogLimit assignValue(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    AnalogLimit parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	AnalogLimit
   */
  public AnalogLimit unAssignValue(UUID parentId) {
    AnalogLimit parentEntity = repository.findById(parentId).get();

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

  /*
   * Add to the Limits
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	AnalogLimit
   */
  public AnalogLimit addToLimits(UUID parentId, AnalogLimit addTo) {
    LOGGER.info("handling AssignLimitsToAnalogLimitEvent - ");

    AnalogLimit parentEntity = repository.findById(parentId).get();
    AnalogLimit child = AnalogLimitProjector.find(addTo.getAnalogLimitId());

    parentEntity.getLimits().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the Limits
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	AnalogLimit
   */
  public AnalogLimit removeFromLimits(UUID parentId, AnalogLimit removeFrom) {
    LOGGER.info("handling RemoveLimitsFromAnalogLimitEvent ");

    AnalogLimit parentEntity = repository.findById(parentId).get();
    AnalogLimit child = AnalogLimitProjector.find(removeFrom.getAnalogLimitId());

    parentEntity.getLimits().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the AnalogLimit via an FindAnalogLimitQuery
   *
   * @return query FindAnalogLimitQuery
   */
  @SuppressWarnings("unused")
  public AnalogLimit find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a AnalogLimit - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all AnalogLimits
   *
   * @param query FindAllAnalogLimitQuery
   * @return List<AnalogLimit>
   */
  @SuppressWarnings("unused")
  public List<AnalogLimit> findAll(FindAllAnalogLimitQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all AnalogLimit - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final AnalogLimitRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "analogLimit-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector
          .AnalogLimitEntityProjector
      AnalogLimitProjector;

  private static final Logger LOGGER = Logger.getLogger(AnalogLimitEntityProjector.class.getName());
}
