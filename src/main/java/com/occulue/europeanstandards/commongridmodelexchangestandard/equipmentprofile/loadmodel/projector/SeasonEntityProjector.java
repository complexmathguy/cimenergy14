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
 * Projector for Season as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SeasonAggregate
 *
 * @author your_name_here
 */
@Component("season-entity-projector")
public class SeasonEntityProjector {

  // core constructor
  public SeasonEntityProjector(SeasonRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Season
   *
   * @param	entity Season
   */
  public Season create(Season entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Season
   *
   * @param	entity Season
   */
  public Season update(Season entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Season
   *
   * @param	id		UUID
   */
  public Season delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Season entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a EndDate
   *
   * @param	parentId	UUID
   * @param	assignment 	MonthDay
   * @return	Season
   */
  public Season assignEndDate(UUID parentId, MonthDay assignment) {
    LOGGER.info("assigning EndDate as " + assignment.toString());

    Season parentEntity = repository.findById(parentId).get();
    assignment = MonthDayProjector.find(assignment.getMonthDayId());

    // ------------------------------------------
    // assign the EndDate to the parent entity
    // ------------------------------------------
    parentEntity.setEndDate(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the EndDate
   *
   * @param	parentId		UUID
   * @return	Season
   */
  public Season unAssignEndDate(UUID parentId) {
    Season parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning EndDate on " + parentEntity.toString());

    // ------------------------------------------
    // null out the EndDate on the parent entithy
    // ------------------------------------------
    parentEntity.setEndDate(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a StartDate
   *
   * @param	parentId	UUID
   * @param	assignment 	MonthDay
   * @return	Season
   */
  public Season assignStartDate(UUID parentId, MonthDay assignment) {
    LOGGER.info("assigning StartDate as " + assignment.toString());

    Season parentEntity = repository.findById(parentId).get();
    assignment = MonthDayProjector.find(assignment.getMonthDayId());

    // ------------------------------------------
    // assign the StartDate to the parent entity
    // ------------------------------------------
    parentEntity.setStartDate(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the StartDate
   *
   * @param	parentId		UUID
   * @return	Season
   */
  public Season unAssignStartDate(UUID parentId) {
    Season parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning StartDate on " + parentEntity.toString());

    // ------------------------------------------
    // null out the StartDate on the parent entithy
    // ------------------------------------------
    parentEntity.setStartDate(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Season via an FindSeasonQuery
   *
   * @return query FindSeasonQuery
   */
  @SuppressWarnings("unused")
  public Season find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Season - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Seasons
   *
   * @param query FindAllSeasonQuery
   * @return List<Season>
   */
  @SuppressWarnings("unused")
  public List<Season> findAll(FindAllSeasonQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Season - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SeasonRepository repository;

  @Autowired
  @Qualifier(value = "monthDay-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .MonthDayEntityProjector
      MonthDayProjector;

  private static final Logger LOGGER = Logger.getLogger(SeasonEntityProjector.class.getName());
}
