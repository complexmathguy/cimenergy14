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
 * Projector for ConformLoadSchedule as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ConformLoadScheduleAggregate
 *
 * @author your_name_here
 */
@Component("conformLoadSchedule-entity-projector")
public class ConformLoadScheduleEntityProjector {

  // core constructor
  public ConformLoadScheduleEntityProjector(ConformLoadScheduleRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ConformLoadSchedule
   *
   * @param	entity ConformLoadSchedule
   */
  public ConformLoadSchedule create(ConformLoadSchedule entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ConformLoadSchedule
   *
   * @param	entity ConformLoadSchedule
   */
  public ConformLoadSchedule update(ConformLoadSchedule entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ConformLoadSchedule
   *
   * @param	id		UUID
   */
  public ConformLoadSchedule delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ConformLoadSchedule entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the ConformLoadSchedules
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	ConformLoadSchedule
   */
  public ConformLoadSchedule addToConformLoadSchedules(UUID parentId, ConformLoadSchedule addTo) {
    LOGGER.info("handling AssignConformLoadSchedulesToConformLoadScheduleEvent - ");

    ConformLoadSchedule parentEntity = repository.findById(parentId).get();
    ConformLoadSchedule child = ConformLoadScheduleProjector.find(addTo.getConformLoadScheduleId());

    parentEntity.getConformLoadSchedules().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the ConformLoadSchedules
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	ConformLoadSchedule
   */
  public ConformLoadSchedule removeFromConformLoadSchedules(
      UUID parentId, ConformLoadSchedule removeFrom) {
    LOGGER.info("handling RemoveConformLoadSchedulesFromConformLoadScheduleEvent ");

    ConformLoadSchedule parentEntity = repository.findById(parentId).get();
    ConformLoadSchedule child =
        ConformLoadScheduleProjector.find(removeFrom.getConformLoadScheduleId());

    parentEntity.getConformLoadSchedules().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ConformLoadSchedule via an FindConformLoadScheduleQuery
   *
   * @return query FindConformLoadScheduleQuery
   */
  @SuppressWarnings("unused")
  public ConformLoadSchedule find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ConformLoadSchedule - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ConformLoadSchedules
   *
   * @param query FindAllConformLoadScheduleQuery
   * @return List<ConformLoadSchedule>
   */
  @SuppressWarnings("unused")
  public List<ConformLoadSchedule> findAll(FindAllConformLoadScheduleQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ConformLoadSchedule - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ConformLoadScheduleRepository repository;

  @Autowired
  @Qualifier(value = "conformLoadSchedule-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.projector
          .ConformLoadScheduleEntityProjector
      ConformLoadScheduleProjector;

  private static final Logger LOGGER =
      Logger.getLogger(ConformLoadScheduleEntityProjector.class.getName());
}
