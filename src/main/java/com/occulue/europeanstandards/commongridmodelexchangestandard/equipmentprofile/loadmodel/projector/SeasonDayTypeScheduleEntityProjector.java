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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for SeasonDayTypeSchedule as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SeasonDayTypeScheduleAggregate
 *
 * @author your_name_here
 */
@Component("seasonDayTypeSchedule-entity-projector")
public class SeasonDayTypeScheduleEntityProjector {

  // core constructor
  public SeasonDayTypeScheduleEntityProjector(SeasonDayTypeScheduleRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a SeasonDayTypeSchedule
   *
   * @param	entity SeasonDayTypeSchedule
   */
  public SeasonDayTypeSchedule create(SeasonDayTypeSchedule entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a SeasonDayTypeSchedule
   *
   * @param	entity SeasonDayTypeSchedule
   */
  public SeasonDayTypeSchedule update(SeasonDayTypeSchedule entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a SeasonDayTypeSchedule
   *
   * @param	id		UUID
   */
  public SeasonDayTypeSchedule delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    SeasonDayTypeSchedule entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the SeasonDayTypeSchedules
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	SeasonDayTypeSchedule
   */
  public SeasonDayTypeSchedule addToSeasonDayTypeSchedules(
      UUID parentId, SeasonDayTypeSchedule addTo) {
    LOGGER.info("handling AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleEvent - ");

    SeasonDayTypeSchedule parentEntity = repository.findById(parentId).get();
    SeasonDayTypeSchedule child =
        SeasonDayTypeScheduleProjector.find(addTo.getSeasonDayTypeScheduleId());

    parentEntity.getSeasonDayTypeSchedules().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the SeasonDayTypeSchedules
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	SeasonDayTypeSchedule
   */
  public SeasonDayTypeSchedule removeFromSeasonDayTypeSchedules(
      UUID parentId, SeasonDayTypeSchedule removeFrom) {
    LOGGER.info("handling RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleEvent ");

    SeasonDayTypeSchedule parentEntity = repository.findById(parentId).get();
    SeasonDayTypeSchedule child =
        SeasonDayTypeScheduleProjector.find(removeFrom.getSeasonDayTypeScheduleId());

    parentEntity.getSeasonDayTypeSchedules().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the SeasonDayTypeSchedule via an FindSeasonDayTypeScheduleQuery
   *
   * @return query FindSeasonDayTypeScheduleQuery
   */
  @SuppressWarnings("unused")
  public SeasonDayTypeSchedule find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a SeasonDayTypeSchedule - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all SeasonDayTypeSchedules
   *
   * @param query FindAllSeasonDayTypeScheduleQuery
   * @return List<SeasonDayTypeSchedule>
   */
  @SuppressWarnings("unused")
  public List<SeasonDayTypeSchedule> findAll(FindAllSeasonDayTypeScheduleQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all SeasonDayTypeSchedule - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SeasonDayTypeScheduleRepository repository;

  @Autowired
  @Qualifier(value = "seasonDayTypeSchedule-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.projector
          .SeasonDayTypeScheduleEntityProjector
      SeasonDayTypeScheduleProjector;

  private static final Logger LOGGER =
      Logger.getLogger(SeasonDayTypeScheduleEntityProjector.class.getName());
}
