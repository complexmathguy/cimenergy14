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
 * Projector for WindPlantIEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindPlantIECAggregate
 *
 * @author your_name_here
 */
@Component("windPlantIEC-entity-projector")
public class WindPlantIECEntityProjector {

  // core constructor
  public WindPlantIECEntityProjector(WindPlantIECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindPlantIEC
   *
   * @param	entity WindPlantIEC
   */
  public WindPlantIEC create(WindPlantIEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindPlantIEC
   *
   * @param	entity WindPlantIEC
   */
  public WindPlantIEC update(WindPlantIEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindPlantIEC
   *
   * @param	id		UUID
   */
  public WindPlantIEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindPlantIEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a WindPlantIEC
   *
   * @param	parentId	UUID
   * @param	assignment 	WindPlantIEC
   * @return	WindPlantIEC
   */
  public WindPlantIEC assignWindPlantIEC(UUID parentId, WindPlantIEC assignment) {
    LOGGER.info("assigning WindPlantIEC as " + assignment.toString());

    WindPlantIEC parentEntity = repository.findById(parentId).get();
    assignment = WindPlantIECProjector.find(assignment.getWindPlantIECId());

    // ------------------------------------------
    // assign the WindPlantIEC to the parent entity
    // ------------------------------------------
    parentEntity.setWindPlantIEC(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the WindPlantIEC
   *
   * @param	parentId		UUID
   * @return	WindPlantIEC
   */
  public WindPlantIEC unAssignWindPlantIEC(UUID parentId) {
    WindPlantIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning WindPlantIEC on " + parentEntity.toString());

    // ------------------------------------------
    // null out the WindPlantIEC on the parent entithy
    // ------------------------------------------
    parentEntity.setWindPlantIEC(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindPlantIEC via an FindWindPlantIECQuery
   *
   * @return query FindWindPlantIECQuery
   */
  @SuppressWarnings("unused")
  public WindPlantIEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindPlantIEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindPlantIECs
   *
   * @param query FindAllWindPlantIECQuery
   * @return List<WindPlantIEC>
   */
  @SuppressWarnings("unused")
  public List<WindPlantIEC> findAll(FindAllWindPlantIECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all WindPlantIEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindPlantIECRepository repository;

  @Autowired
  @Qualifier(value = "windPlantIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindPlantIECEntityProjector
      WindPlantIECProjector;

  private static final Logger LOGGER =
      Logger.getLogger(WindPlantIECEntityProjector.class.getName());
}
