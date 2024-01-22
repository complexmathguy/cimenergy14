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
 * Projector for WindGenTurbineType3IEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindGenTurbineType3IECAggregate
 *
 * @author your_name_here
 */
@Component("windGenTurbineType3IEC-entity-projector")
public class WindGenTurbineType3IECEntityProjector {

  // core constructor
  public WindGenTurbineType3IECEntityProjector(WindGenTurbineType3IECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindGenTurbineType3IEC
   *
   * @param	entity WindGenTurbineType3IEC
   */
  public WindGenTurbineType3IEC create(WindGenTurbineType3IEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindGenTurbineType3IEC
   *
   * @param	entity WindGenTurbineType3IEC
   */
  public WindGenTurbineType3IEC update(WindGenTurbineType3IEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindGenTurbineType3IEC
   *
   * @param	id		UUID
   */
  public WindGenTurbineType3IEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindGenTurbineType3IEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Dipmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindGenTurbineType3IEC
   */
  public WindGenTurbineType3IEC assignDipmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dipmax as " + assignment.toString());

    WindGenTurbineType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dipmax to the parent entity
    // ------------------------------------------
    parentEntity.setDipmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dipmax
   *
   * @param	parentId		UUID
   * @return	WindGenTurbineType3IEC
   */
  public WindGenTurbineType3IEC unAssignDipmax(UUID parentId) {
    WindGenTurbineType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dipmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dipmax on the parent entithy
    // ------------------------------------------
    parentEntity.setDipmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Diqmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindGenTurbineType3IEC
   */
  public WindGenTurbineType3IEC assignDiqmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Diqmax as " + assignment.toString());

    WindGenTurbineType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Diqmax to the parent entity
    // ------------------------------------------
    parentEntity.setDiqmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Diqmax
   *
   * @param	parentId		UUID
   * @return	WindGenTurbineType3IEC
   */
  public WindGenTurbineType3IEC unAssignDiqmax(UUID parentId) {
    WindGenTurbineType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Diqmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Diqmax on the parent entithy
    // ------------------------------------------
    parentEntity.setDiqmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a WindGenTurbineType3IEC
   *
   * @param	parentId	UUID
   * @param	assignment 	WindGenTurbineType3IEC
   * @return	WindGenTurbineType3IEC
   */
  public WindGenTurbineType3IEC assignWindGenTurbineType3IEC(
      UUID parentId, WindGenTurbineType3IEC assignment) {
    LOGGER.info("assigning WindGenTurbineType3IEC as " + assignment.toString());

    WindGenTurbineType3IEC parentEntity = repository.findById(parentId).get();
    assignment = WindGenTurbineType3IECProjector.find(assignment.getWindGenTurbineType3IECId());

    // ------------------------------------------
    // assign the WindGenTurbineType3IEC to the parent entity
    // ------------------------------------------
    parentEntity.setWindGenTurbineType3IEC(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the WindGenTurbineType3IEC
   *
   * @param	parentId		UUID
   * @return	WindGenTurbineType3IEC
   */
  public WindGenTurbineType3IEC unAssignWindGenTurbineType3IEC(UUID parentId) {
    WindGenTurbineType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning WindGenTurbineType3IEC on " + parentEntity.toString());

    // ------------------------------------------
    // null out the WindGenTurbineType3IEC on the parent entithy
    // ------------------------------------------
    parentEntity.setWindGenTurbineType3IEC(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindGenTurbineType3IEC via an FindWindGenTurbineType3IECQuery
   *
   * @return query FindWindGenTurbineType3IECQuery
   */
  @SuppressWarnings("unused")
  public WindGenTurbineType3IEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindGenTurbineType3IEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindGenTurbineType3IECs
   *
   * @param query FindAllWindGenTurbineType3IECQuery
   * @return List<WindGenTurbineType3IEC>
   */
  @SuppressWarnings("unused")
  public List<WindGenTurbineType3IEC> findAll(FindAllWindGenTurbineType3IECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all WindGenTurbineType3IEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindGenTurbineType3IECRepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "windGenTurbineType3IEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindGenTurbineType3IECEntityProjector
      WindGenTurbineType3IECProjector;

  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType3IECEntityProjector.class.getName());
}
