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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for BasicIntervalSchedule as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by BasicIntervalScheduleAggregate
 *
 * @author your_name_here
 */
@Component("basicIntervalSchedule-entity-projector")
public class BasicIntervalScheduleEntityProjector {

  // core constructor
  public BasicIntervalScheduleEntityProjector(BasicIntervalScheduleRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a BasicIntervalSchedule
   *
   * @param	entity BasicIntervalSchedule
   */
  public BasicIntervalSchedule create(BasicIntervalSchedule entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a BasicIntervalSchedule
   *
   * @param	entity BasicIntervalSchedule
   */
  public BasicIntervalSchedule update(BasicIntervalSchedule entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a BasicIntervalSchedule
   *
   * @param	id		UUID
   */
  public BasicIntervalSchedule delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    BasicIntervalSchedule entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a StartTime
   *
   * @param	parentId	UUID
   * @param	assignment 	DateTime
   * @return	BasicIntervalSchedule
   */
  public BasicIntervalSchedule assignStartTime(UUID parentId, DateTime assignment) {
    LOGGER.info("assigning StartTime as " + assignment.toString());

    BasicIntervalSchedule parentEntity = repository.findById(parentId).get();
    assignment = DateTimeProjector.find(assignment.getDateTimeId());

    // ------------------------------------------
    // assign the StartTime to the parent entity
    // ------------------------------------------
    parentEntity.setStartTime(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the StartTime
   *
   * @param	parentId		UUID
   * @return	BasicIntervalSchedule
   */
  public BasicIntervalSchedule unAssignStartTime(UUID parentId) {
    BasicIntervalSchedule parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning StartTime on " + parentEntity.toString());

    // ------------------------------------------
    // null out the StartTime on the parent entithy
    // ------------------------------------------
    parentEntity.setStartTime(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the BasicIntervalSchedule via an FindBasicIntervalScheduleQuery
   *
   * @return query FindBasicIntervalScheduleQuery
   */
  @SuppressWarnings("unused")
  public BasicIntervalSchedule find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a BasicIntervalSchedule - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all BasicIntervalSchedules
   *
   * @param query FindAllBasicIntervalScheduleQuery
   * @return List<BasicIntervalSchedule>
   */
  @SuppressWarnings("unused")
  public List<BasicIntervalSchedule> findAll(FindAllBasicIntervalScheduleQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all BasicIntervalSchedule - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final BasicIntervalScheduleRepository repository;

  @Autowired
  @Qualifier(value = "dateTime-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .DateTimeEntityProjector
      DateTimeProjector;

  private static final Logger LOGGER =
      Logger.getLogger(BasicIntervalScheduleEntityProjector.class.getName());
}
