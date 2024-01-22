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
 * Projector for AnalogValue as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by AnalogValueAggregate
 *
 * @author your_name_here
 */
@Component("analogValue-entity-projector")
public class AnalogValueEntityProjector {

  // core constructor
  public AnalogValueEntityProjector(AnalogValueRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a AnalogValue
   *
   * @param	entity AnalogValue
   */
  public AnalogValue create(AnalogValue entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a AnalogValue
   *
   * @param	entity AnalogValue
   */
  public AnalogValue update(AnalogValue entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a AnalogValue
   *
   * @param	id		UUID
   */
  public AnalogValue delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    AnalogValue entity = repository.findById(id).get();

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
   * @return	AnalogValue
   */
  public AnalogValue assignValue(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    AnalogValue parentEntity = repository.findById(parentId).get();
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
   * @return	AnalogValue
   */
  public AnalogValue unAssignValue(UUID parentId) {
    AnalogValue parentEntity = repository.findById(parentId).get();

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
   * Add to the AnalogValues
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	AnalogValue
   */
  public AnalogValue addToAnalogValues(UUID parentId, AnalogValue addTo) {
    LOGGER.info("handling AssignAnalogValuesToAnalogValueEvent - ");

    AnalogValue parentEntity = repository.findById(parentId).get();
    AnalogValue child = AnalogValueProjector.find(addTo.getAnalogValueId());

    parentEntity.getAnalogValues().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the AnalogValues
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	AnalogValue
   */
  public AnalogValue removeFromAnalogValues(UUID parentId, AnalogValue removeFrom) {
    LOGGER.info("handling RemoveAnalogValuesFromAnalogValueEvent ");

    AnalogValue parentEntity = repository.findById(parentId).get();
    AnalogValue child = AnalogValueProjector.find(removeFrom.getAnalogValueId());

    parentEntity.getAnalogValues().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the AnalogValue via an FindAnalogValueQuery
   *
   * @return query FindAnalogValueQuery
   */
  @SuppressWarnings("unused")
  public AnalogValue find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a AnalogValue - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all AnalogValues
   *
   * @param query FindAllAnalogValueQuery
   * @return List<AnalogValue>
   */
  @SuppressWarnings("unused")
  public List<AnalogValue> findAll(FindAllAnalogValueQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all AnalogValue - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final AnalogValueRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "analogValue-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector
          .AnalogValueEntityProjector
      AnalogValueProjector;

  private static final Logger LOGGER = Logger.getLogger(AnalogValueEntityProjector.class.getName());
}
