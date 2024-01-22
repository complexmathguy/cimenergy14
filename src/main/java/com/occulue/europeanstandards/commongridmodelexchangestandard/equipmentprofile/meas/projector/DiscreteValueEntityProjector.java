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
 * Projector for DiscreteValue as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DiscreteValueAggregate
 *
 * @author your_name_here
 */
@Component("discreteValue-entity-projector")
public class DiscreteValueEntityProjector {

  // core constructor
  public DiscreteValueEntityProjector(DiscreteValueRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DiscreteValue
   *
   * @param	entity DiscreteValue
   */
  public DiscreteValue create(DiscreteValue entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DiscreteValue
   *
   * @param	entity DiscreteValue
   */
  public DiscreteValue update(DiscreteValue entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DiscreteValue
   *
   * @param	id		UUID
   */
  public DiscreteValue delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DiscreteValue entity = repository.findById(id).get();

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
   * @param	assignment 	IntegerProxy
   * @return	DiscreteValue
   */
  public DiscreteValue assignValue(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    DiscreteValue parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

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
   * @return	DiscreteValue
   */
  public DiscreteValue unAssignValue(UUID parentId) {
    DiscreteValue parentEntity = repository.findById(parentId).get();

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
   * Add to the DiscreteValues
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	DiscreteValue
   */
  public DiscreteValue addToDiscreteValues(UUID parentId, DiscreteValue addTo) {
    LOGGER.info("handling AssignDiscreteValuesToDiscreteValueEvent - ");

    DiscreteValue parentEntity = repository.findById(parentId).get();
    DiscreteValue child = DiscreteValueProjector.find(addTo.getDiscreteValueId());

    parentEntity.getDiscreteValues().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the DiscreteValues
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	DiscreteValue
   */
  public DiscreteValue removeFromDiscreteValues(UUID parentId, DiscreteValue removeFrom) {
    LOGGER.info("handling RemoveDiscreteValuesFromDiscreteValueEvent ");

    DiscreteValue parentEntity = repository.findById(parentId).get();
    DiscreteValue child = DiscreteValueProjector.find(removeFrom.getDiscreteValueId());

    parentEntity.getDiscreteValues().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the DiscreteValue via an FindDiscreteValueQuery
   *
   * @return query FindDiscreteValueQuery
   */
  @SuppressWarnings("unused")
  public DiscreteValue find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DiscreteValue - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DiscreteValues
   *
   * @param query FindAllDiscreteValueQuery
   * @return List<DiscreteValue>
   */
  @SuppressWarnings("unused")
  public List<DiscreteValue> findAll(FindAllDiscreteValueQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DiscreteValue - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DiscreteValueRepository repository;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "discreteValue-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector
          .DiscreteValueEntityProjector
      DiscreteValueProjector;

  private static final Logger LOGGER =
      Logger.getLogger(DiscreteValueEntityProjector.class.getName());
}
