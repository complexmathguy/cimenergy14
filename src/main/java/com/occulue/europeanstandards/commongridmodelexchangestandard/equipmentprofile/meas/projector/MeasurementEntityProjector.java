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
 * Projector for Measurement as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by MeasurementAggregate
 *
 * @author your_name_here
 */
@Component("measurement-entity-projector")
public class MeasurementEntityProjector {

  // core constructor
  public MeasurementEntityProjector(MeasurementRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Measurement
   *
   * @param	entity Measurement
   */
  public Measurement create(Measurement entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Measurement
   *
   * @param	entity Measurement
   */
  public Measurement update(Measurement entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Measurement
   *
   * @param	id		UUID
   */
  public Measurement delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Measurement entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a MeasurementType
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	Measurement
   */
  public Measurement assignMeasurementType(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning MeasurementType as " + assignment.toString());

    Measurement parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the MeasurementType to the parent entity
    // ------------------------------------------
    parentEntity.setMeasurementType(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MeasurementType
   *
   * @param	parentId		UUID
   * @return	Measurement
   */
  public Measurement unAssignMeasurementType(UUID parentId) {
    Measurement parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MeasurementType on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MeasurementType on the parent entithy
    // ------------------------------------------
    parentEntity.setMeasurementType(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the Measurements
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	Measurement
   */
  public Measurement addToMeasurements(UUID parentId, Measurement addTo) {
    LOGGER.info("handling AssignMeasurementsToMeasurementEvent - ");

    Measurement parentEntity = repository.findById(parentId).get();
    Measurement child = MeasurementProjector.find(addTo.getMeasurementId());

    parentEntity.getMeasurements().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the Measurements
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	Measurement
   */
  public Measurement removeFromMeasurements(UUID parentId, Measurement removeFrom) {
    LOGGER.info("handling RemoveMeasurementsFromMeasurementEvent ");

    Measurement parentEntity = repository.findById(parentId).get();
    Measurement child = MeasurementProjector.find(removeFrom.getMeasurementId());

    parentEntity.getMeasurements().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Measurement via an FindMeasurementQuery
   *
   * @return query FindMeasurementQuery
   */
  @SuppressWarnings("unused")
  public Measurement find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Measurement - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Measurements
   *
   * @param query FindAllMeasurementQuery
   * @return List<Measurement>
   */
  @SuppressWarnings("unused")
  public List<Measurement> findAll(FindAllMeasurementQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Measurement - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final MeasurementRepository repository;

  @Autowired
  @Qualifier(value = "stringProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .StringProxyEntityProjector
      StringProxyProjector;

  @Autowired
  @Qualifier(value = "measurement-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector
          .MeasurementEntityProjector
      MeasurementProjector;

  private static final Logger LOGGER = Logger.getLogger(MeasurementEntityProjector.class.getName());
}
