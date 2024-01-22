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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for Temperature as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by TemperatureAggregate
 *
 * @author your_name_here
 */
@Component("temperature-entity-projector")
public class TemperatureEntityProjector {

  // core constructor
  public TemperatureEntityProjector(TemperatureRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Temperature
   *
   * @param	entity Temperature
   */
  public Temperature create(Temperature entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Temperature
   *
   * @param	entity Temperature
   */
  public Temperature update(Temperature entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Temperature
   *
   * @param	id		UUID
   */
  public Temperature delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Temperature entity = repository.findById(id).get();

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
   * @param	assignment 	FloatProxy
   * @return	Temperature
   */
  public Temperature assignValue(UUID parentId, FloatProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    Temperature parentEntity = repository.findById(parentId).get();
    assignment = FloatProxyProjector.find(assignment.getFloatProxyId());

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
   * @return	Temperature
   */
  public Temperature unAssignValue(UUID parentId) {
    Temperature parentEntity = repository.findById(parentId).get();

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

  /**
   * Method to retrieve the Temperature via an FindTemperatureQuery
   *
   * @return query FindTemperatureQuery
   */
  @SuppressWarnings("unused")
  public Temperature find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Temperature - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Temperatures
   *
   * @param query FindAllTemperatureQuery
   * @return List<Temperature>
   */
  @SuppressWarnings("unused")
  public List<Temperature> findAll(FindAllTemperatureQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Temperature - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final TemperatureRepository repository;

  @Autowired
  @Qualifier(value = "floatProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .FloatProxyEntityProjector
      FloatProxyProjector;

  @Autowired
  @Qualifier(value = "aCLineSegment-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .ACLineSegmentEntityProjector
      ACLineSegmentProjector;

  @Autowired
  @Qualifier(value = "govGAST2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovGAST2EntityProjector
      GovGAST2Projector;

  @Autowired
  @Qualifier(value = "govGAST3-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovGAST3EntityProjector
      GovGAST3Projector;

  private static final Logger LOGGER = Logger.getLogger(TemperatureEntityProjector.class.getName());
}
