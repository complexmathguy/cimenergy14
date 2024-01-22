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
 * Projector for MeasurementValue as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by MeasurementValueAggregate
 *
 * @author your_name_here
 */
@Component("measurementValue-entity-projector")
public class MeasurementValueEntityProjector {

  // core constructor
  public MeasurementValueEntityProjector(MeasurementValueRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a MeasurementValue
   *
   * @param	entity MeasurementValue
   */
  public MeasurementValue create(MeasurementValue entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a MeasurementValue
   *
   * @param	entity MeasurementValue
   */
  public MeasurementValue update(MeasurementValue entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a MeasurementValue
   *
   * @param	id		UUID
   */
  public MeasurementValue delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    MeasurementValue entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a SensorAccuracy
   *
   * @param	parentId	UUID
   * @param	assignment 	PerCent
   * @return	MeasurementValue
   */
  public MeasurementValue assignSensorAccuracy(UUID parentId, PerCent assignment) {
    LOGGER.info("assigning SensorAccuracy as " + assignment.toString());

    MeasurementValue parentEntity = repository.findById(parentId).get();
    assignment = PerCentProjector.find(assignment.getPerCentId());

    // ------------------------------------------
    // assign the SensorAccuracy to the parent entity
    // ------------------------------------------
    parentEntity.setSensorAccuracy(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SensorAccuracy
   *
   * @param	parentId		UUID
   * @return	MeasurementValue
   */
  public MeasurementValue unAssignSensorAccuracy(UUID parentId) {
    MeasurementValue parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SensorAccuracy on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SensorAccuracy on the parent entithy
    // ------------------------------------------
    parentEntity.setSensorAccuracy(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a TimeStamp
   *
   * @param	parentId	UUID
   * @param	assignment 	DateTime
   * @return	MeasurementValue
   */
  public MeasurementValue assignTimeStamp(UUID parentId, DateTime assignment) {
    LOGGER.info("assigning TimeStamp as " + assignment.toString());

    MeasurementValue parentEntity = repository.findById(parentId).get();
    assignment = DateTimeProjector.find(assignment.getDateTimeId());

    // ------------------------------------------
    // assign the TimeStamp to the parent entity
    // ------------------------------------------
    parentEntity.setTimeStamp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the TimeStamp
   *
   * @param	parentId		UUID
   * @return	MeasurementValue
   */
  public MeasurementValue unAssignTimeStamp(UUID parentId) {
    MeasurementValue parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning TimeStamp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the TimeStamp on the parent entithy
    // ------------------------------------------
    parentEntity.setTimeStamp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the MeasurementValues
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	MeasurementValue
   */
  public MeasurementValue addToMeasurementValues(UUID parentId, MeasurementValue addTo) {
    LOGGER.info("handling AssignMeasurementValuesToMeasurementValueEvent - ");

    MeasurementValue parentEntity = repository.findById(parentId).get();
    MeasurementValue child = MeasurementValueProjector.find(addTo.getMeasurementValueId());

    parentEntity.getMeasurementValues().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the MeasurementValues
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	MeasurementValue
   */
  public MeasurementValue removeFromMeasurementValues(UUID parentId, MeasurementValue removeFrom) {
    LOGGER.info("handling RemoveMeasurementValuesFromMeasurementValueEvent ");

    MeasurementValue parentEntity = repository.findById(parentId).get();
    MeasurementValue child = MeasurementValueProjector.find(removeFrom.getMeasurementValueId());

    parentEntity.getMeasurementValues().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the MeasurementValue via an FindMeasurementValueQuery
   *
   * @return query FindMeasurementValueQuery
   */
  @SuppressWarnings("unused")
  public MeasurementValue find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a MeasurementValue - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all MeasurementValues
   *
   * @param query FindAllMeasurementValueQuery
   * @return List<MeasurementValue>
   */
  @SuppressWarnings("unused")
  public List<MeasurementValue> findAll(FindAllMeasurementValueQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all MeasurementValue - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final MeasurementValueRepository repository;

  @Autowired
  @Qualifier(value = "perCent-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PerCentEntityProjector
      PerCentProjector;

  @Autowired
  @Qualifier(value = "dateTime-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .DateTimeEntityProjector
      DateTimeProjector;

  @Autowired
  @Qualifier(value = "measurementValue-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector
          .MeasurementValueEntityProjector
      MeasurementValueProjector;

  private static final Logger LOGGER =
      Logger.getLogger(MeasurementValueEntityProjector.class.getName());
}
