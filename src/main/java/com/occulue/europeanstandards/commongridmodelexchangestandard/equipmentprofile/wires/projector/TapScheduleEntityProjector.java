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
 * Projector for TapSchedule as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by TapScheduleAggregate
 *
 * @author your_name_here
 */
@Component("tapSchedule-entity-projector")
public class TapScheduleEntityProjector {

  // core constructor
  public TapScheduleEntityProjector(TapScheduleRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a TapSchedule
   *
   * @param	entity TapSchedule
   */
  public TapSchedule create(TapSchedule entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a TapSchedule
   *
   * @param	entity TapSchedule
   */
  public TapSchedule update(TapSchedule entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a TapSchedule
   *
   * @param	id		UUID
   */
  public TapSchedule delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    TapSchedule entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the TapSchedules
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	TapSchedule
   */
  public TapSchedule addToTapSchedules(UUID parentId, TapSchedule addTo) {
    LOGGER.info("handling AssignTapSchedulesToTapScheduleEvent - ");

    TapSchedule parentEntity = repository.findById(parentId).get();
    TapSchedule child = TapScheduleProjector.find(addTo.getTapScheduleId());

    parentEntity.getTapSchedules().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the TapSchedules
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	TapSchedule
   */
  public TapSchedule removeFromTapSchedules(UUID parentId, TapSchedule removeFrom) {
    LOGGER.info("handling RemoveTapSchedulesFromTapScheduleEvent ");

    TapSchedule parentEntity = repository.findById(parentId).get();
    TapSchedule child = TapScheduleProjector.find(removeFrom.getTapScheduleId());

    parentEntity.getTapSchedules().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the TapSchedule via an FindTapScheduleQuery
   *
   * @return query FindTapScheduleQuery
   */
  @SuppressWarnings("unused")
  public TapSchedule find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a TapSchedule - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all TapSchedules
   *
   * @param query FindAllTapScheduleQuery
   * @return List<TapSchedule>
   */
  @SuppressWarnings("unused")
  public List<TapSchedule> findAll(FindAllTapScheduleQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all TapSchedule - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final TapScheduleRepository repository;

  @Autowired
  @Qualifier(value = "tapSchedule-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .TapScheduleEntityProjector
      TapScheduleProjector;

  private static final Logger LOGGER = Logger.getLogger(TapScheduleEntityProjector.class.getName());
}
