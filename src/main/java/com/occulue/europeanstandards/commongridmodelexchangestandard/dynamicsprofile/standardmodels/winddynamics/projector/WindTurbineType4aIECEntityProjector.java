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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for WindTurbineType4aIEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindTurbineType4aIECAggregate
 *
 * @author your_name_here
 */
@Component("windTurbineType4aIEC-entity-projector")
public class WindTurbineType4aIECEntityProjector {

  // core constructor
  public WindTurbineType4aIECEntityProjector(WindTurbineType4aIECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindTurbineType4aIEC
   *
   * @param	entity WindTurbineType4aIEC
   */
  public WindTurbineType4aIEC create(WindTurbineType4aIEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindTurbineType4aIEC
   *
   * @param	entity WindTurbineType4aIEC
   */
  public WindTurbineType4aIEC update(WindTurbineType4aIEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindTurbineType4aIEC
   *
   * @param	id		UUID
   */
  public WindTurbineType4aIEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindTurbineType4aIEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a WindTurbineType4aIEC
   *
   * @param	parentId	UUID
   * @param	assignment 	WindTurbineType4aIEC
   * @return	WindTurbineType4aIEC
   */
  public WindTurbineType4aIEC assignWindTurbineType4aIEC(
      UUID parentId, WindTurbineType4aIEC assignment) {
    LOGGER.info("assigning WindTurbineType4aIEC as " + assignment.toString());

    WindTurbineType4aIEC parentEntity = repository.findById(parentId).get();
    assignment = WindTurbineType4aIECProjector.find(assignment.getWindTurbineType4aIECId());

    // ------------------------------------------
    // assign the WindTurbineType4aIEC to the parent entity
    // ------------------------------------------
    parentEntity.setWindTurbineType4aIEC(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the WindTurbineType4aIEC
   *
   * @param	parentId		UUID
   * @return	WindTurbineType4aIEC
   */
  public WindTurbineType4aIEC unAssignWindTurbineType4aIEC(UUID parentId) {
    WindTurbineType4aIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning WindTurbineType4aIEC on " + parentEntity.toString());

    // ------------------------------------------
    // null out the WindTurbineType4aIEC on the parent entithy
    // ------------------------------------------
    parentEntity.setWindTurbineType4aIEC(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindTurbineType4aIEC via an FindWindTurbineType4aIECQuery
   *
   * @return query FindWindTurbineType4aIECQuery
   */
  @SuppressWarnings("unused")
  public WindTurbineType4aIEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindTurbineType4aIEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindTurbineType4aIECs
   *
   * @param query FindAllWindTurbineType4aIECQuery
   * @return List<WindTurbineType4aIEC>
   */
  @SuppressWarnings("unused")
  public List<WindTurbineType4aIEC> findAll(FindAllWindTurbineType4aIECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all WindTurbineType4aIEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindTurbineType4aIECRepository repository;

  @Autowired
  @Qualifier(value = "windTurbineType4aIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindTurbineType4aIECEntityProjector
      WindTurbineType4aIECProjector;

  private static final Logger LOGGER =
      Logger.getLogger(WindTurbineType4aIECEntityProjector.class.getName());
}
