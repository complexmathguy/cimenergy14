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
 * Projector for SwitchSchedule as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SwitchScheduleAggregate
 *
 * @author your_name_here
 */
@Component("switchSchedule-entity-projector")
public class SwitchScheduleEntityProjector {

  // core constructor
  public SwitchScheduleEntityProjector(SwitchScheduleRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a SwitchSchedule
   *
   * @param	entity SwitchSchedule
   */
  public SwitchSchedule create(SwitchSchedule entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a SwitchSchedule
   *
   * @param	entity SwitchSchedule
   */
  public SwitchSchedule update(SwitchSchedule entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a SwitchSchedule
   *
   * @param	id		UUID
   */
  public SwitchSchedule delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    SwitchSchedule entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the SwitchSchedules
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	SwitchSchedule
   */
  public SwitchSchedule addToSwitchSchedules(UUID parentId, SwitchSchedule addTo) {
    LOGGER.info("handling AssignSwitchSchedulesToSwitchScheduleEvent - ");

    SwitchSchedule parentEntity = repository.findById(parentId).get();
    SwitchSchedule child = SwitchScheduleProjector.find(addTo.getSwitchScheduleId());

    parentEntity.getSwitchSchedules().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the SwitchSchedules
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	SwitchSchedule
   */
  public SwitchSchedule removeFromSwitchSchedules(UUID parentId, SwitchSchedule removeFrom) {
    LOGGER.info("handling RemoveSwitchSchedulesFromSwitchScheduleEvent ");

    SwitchSchedule parentEntity = repository.findById(parentId).get();
    SwitchSchedule child = SwitchScheduleProjector.find(removeFrom.getSwitchScheduleId());

    parentEntity.getSwitchSchedules().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the SwitchSchedule via an FindSwitchScheduleQuery
   *
   * @return query FindSwitchScheduleQuery
   */
  @SuppressWarnings("unused")
  public SwitchSchedule find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a SwitchSchedule - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all SwitchSchedules
   *
   * @param query FindAllSwitchScheduleQuery
   * @return List<SwitchSchedule>
   */
  @SuppressWarnings("unused")
  public List<SwitchSchedule> findAll(FindAllSwitchScheduleQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all SwitchSchedule - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SwitchScheduleRepository repository;

  @Autowired
  @Qualifier(value = "switchSchedule-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .SwitchScheduleEntityProjector
      SwitchScheduleProjector;

  private static final Logger LOGGER =
      Logger.getLogger(SwitchScheduleEntityProjector.class.getName());
}
