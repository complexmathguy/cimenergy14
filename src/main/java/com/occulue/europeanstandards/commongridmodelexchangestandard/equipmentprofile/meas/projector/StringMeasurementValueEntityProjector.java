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
 * Projector for StringMeasurementValue as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by StringMeasurementValueAggregate
 *
 * @author your_name_here
 */
@Component("stringMeasurementValue-entity-projector")
public class StringMeasurementValueEntityProjector {

  // core constructor
  public StringMeasurementValueEntityProjector(StringMeasurementValueRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a StringMeasurementValue
   *
   * @param	entity StringMeasurementValue
   */
  public StringMeasurementValue create(StringMeasurementValue entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a StringMeasurementValue
   *
   * @param	entity StringMeasurementValue
   */
  public StringMeasurementValue update(StringMeasurementValue entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a StringMeasurementValue
   *
   * @param	id		UUID
   */
  public StringMeasurementValue delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    StringMeasurementValue entity = repository.findById(id).get();

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
   * @param	assignment 	StringProxy
   * @return	StringMeasurementValue
   */
  public StringMeasurementValue assignValue(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    StringMeasurementValue parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

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
   * @return	StringMeasurementValue
   */
  public StringMeasurementValue unAssignValue(UUID parentId) {
    StringMeasurementValue parentEntity = repository.findById(parentId).get();

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
   * Add to the StringMeasurementValues
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	StringMeasurementValue
   */
  public StringMeasurementValue addToStringMeasurementValues(
      UUID parentId, StringMeasurementValue addTo) {
    LOGGER.info("handling AssignStringMeasurementValuesToStringMeasurementValueEvent - ");

    StringMeasurementValue parentEntity = repository.findById(parentId).get();
    StringMeasurementValue child =
        StringMeasurementValueProjector.find(addTo.getStringMeasurementValueId());

    parentEntity.getStringMeasurementValues().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the StringMeasurementValues
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	StringMeasurementValue
   */
  public StringMeasurementValue removeFromStringMeasurementValues(
      UUID parentId, StringMeasurementValue removeFrom) {
    LOGGER.info("handling RemoveStringMeasurementValuesFromStringMeasurementValueEvent ");

    StringMeasurementValue parentEntity = repository.findById(parentId).get();
    StringMeasurementValue child =
        StringMeasurementValueProjector.find(removeFrom.getStringMeasurementValueId());

    parentEntity.getStringMeasurementValues().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the StringMeasurementValue via an FindStringMeasurementValueQuery
   *
   * @return query FindStringMeasurementValueQuery
   */
  @SuppressWarnings("unused")
  public StringMeasurementValue find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a StringMeasurementValue - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all StringMeasurementValues
   *
   * @param query FindAllStringMeasurementValueQuery
   * @return List<StringMeasurementValue>
   */
  @SuppressWarnings("unused")
  public List<StringMeasurementValue> findAll(FindAllStringMeasurementValueQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all StringMeasurementValue - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final StringMeasurementValueRepository repository;

  @Autowired
  @Qualifier(value = "stringProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .StringProxyEntityProjector
      StringProxyProjector;

  @Autowired
  @Qualifier(value = "stringMeasurementValue-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector
          .StringMeasurementValueEntityProjector
      StringMeasurementValueProjector;

  private static final Logger LOGGER =
      Logger.getLogger(StringMeasurementValueEntityProjector.class.getName());
}
