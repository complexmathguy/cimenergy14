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
 * Projector for ValueToAlias as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ValueToAliasAggregate
 *
 * @author your_name_here
 */
@Component("valueToAlias-entity-projector")
public class ValueToAliasEntityProjector {

  // core constructor
  public ValueToAliasEntityProjector(ValueToAliasRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ValueToAlias
   *
   * @param	entity ValueToAlias
   */
  public ValueToAlias create(ValueToAlias entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ValueToAlias
   *
   * @param	entity ValueToAlias
   */
  public ValueToAlias update(ValueToAlias entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ValueToAlias
   *
   * @param	id		UUID
   */
  public ValueToAlias delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ValueToAlias entity = repository.findById(id).get();

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
   * @return	ValueToAlias
   */
  public ValueToAlias assignValue(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    ValueToAlias parentEntity = repository.findById(parentId).get();
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
   * @return	ValueToAlias
   */
  public ValueToAlias unAssignValue(UUID parentId) {
    ValueToAlias parentEntity = repository.findById(parentId).get();

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
   * Add to the Values
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	ValueToAlias
   */
  public ValueToAlias addToValues(UUID parentId, ValueToAlias addTo) {
    LOGGER.info("handling AssignValuesToValueToAliasEvent - ");

    ValueToAlias parentEntity = repository.findById(parentId).get();
    ValueToAlias child = ValueToAliasProjector.find(addTo.getValueToAliasId());

    parentEntity.getValues().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the Values
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	ValueToAlias
   */
  public ValueToAlias removeFromValues(UUID parentId, ValueToAlias removeFrom) {
    LOGGER.info("handling RemoveValuesFromValueToAliasEvent ");

    ValueToAlias parentEntity = repository.findById(parentId).get();
    ValueToAlias child = ValueToAliasProjector.find(removeFrom.getValueToAliasId());

    parentEntity.getValues().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ValueToAlias via an FindValueToAliasQuery
   *
   * @return query FindValueToAliasQuery
   */
  @SuppressWarnings("unused")
  public ValueToAlias find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ValueToAlias - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ValueToAliass
   *
   * @param query FindAllValueToAliasQuery
   * @return List<ValueToAlias>
   */
  @SuppressWarnings("unused")
  public List<ValueToAlias> findAll(FindAllValueToAliasQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ValueToAlias - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ValueToAliasRepository repository;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "valueToAlias-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector
          .ValueToAliasEntityProjector
      ValueToAliasProjector;

  private static final Logger LOGGER =
      Logger.getLogger(ValueToAliasEntityProjector.class.getName());
}
