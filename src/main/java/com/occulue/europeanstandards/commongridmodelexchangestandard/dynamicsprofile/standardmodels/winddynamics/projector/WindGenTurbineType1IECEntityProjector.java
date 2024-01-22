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
 * Projector for WindGenTurbineType1IEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindGenTurbineType1IECAggregate
 *
 * @author your_name_here
 */
@Component("windGenTurbineType1IEC-entity-projector")
public class WindGenTurbineType1IECEntityProjector {

  // core constructor
  public WindGenTurbineType1IECEntityProjector(WindGenTurbineType1IECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindGenTurbineType1IEC
   *
   * @param	entity WindGenTurbineType1IEC
   */
  public WindGenTurbineType1IEC create(WindGenTurbineType1IEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindGenTurbineType1IEC
   *
   * @param	entity WindGenTurbineType1IEC
   */
  public WindGenTurbineType1IEC update(WindGenTurbineType1IEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindGenTurbineType1IEC
   *
   * @param	id		UUID
   */
  public WindGenTurbineType1IEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindGenTurbineType1IEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a WindGenTurbineType1IEC
   *
   * @param	parentId	UUID
   * @param	assignment 	WindGenTurbineType1IEC
   * @return	WindGenTurbineType1IEC
   */
  public WindGenTurbineType1IEC assignWindGenTurbineType1IEC(
      UUID parentId, WindGenTurbineType1IEC assignment) {
    LOGGER.info("assigning WindGenTurbineType1IEC as " + assignment.toString());

    WindGenTurbineType1IEC parentEntity = repository.findById(parentId).get();
    assignment = WindGenTurbineType1IECProjector.find(assignment.getWindGenTurbineType1IECId());

    // ------------------------------------------
    // assign the WindGenTurbineType1IEC to the parent entity
    // ------------------------------------------
    parentEntity.setWindGenTurbineType1IEC(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the WindGenTurbineType1IEC
   *
   * @param	parentId		UUID
   * @return	WindGenTurbineType1IEC
   */
  public WindGenTurbineType1IEC unAssignWindGenTurbineType1IEC(UUID parentId) {
    WindGenTurbineType1IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning WindGenTurbineType1IEC on " + parentEntity.toString());

    // ------------------------------------------
    // null out the WindGenTurbineType1IEC on the parent entithy
    // ------------------------------------------
    parentEntity.setWindGenTurbineType1IEC(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindGenTurbineType1IEC via an FindWindGenTurbineType1IECQuery
   *
   * @return query FindWindGenTurbineType1IECQuery
   */
  @SuppressWarnings("unused")
  public WindGenTurbineType1IEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindGenTurbineType1IEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindGenTurbineType1IECs
   *
   * @param query FindAllWindGenTurbineType1IECQuery
   * @return List<WindGenTurbineType1IEC>
   */
  @SuppressWarnings("unused")
  public List<WindGenTurbineType1IEC> findAll(FindAllWindGenTurbineType1IECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all WindGenTurbineType1IEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindGenTurbineType1IECRepository repository;

  @Autowired
  @Qualifier(value = "windGenTurbineType1IEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindGenTurbineType1IECEntityProjector
      WindGenTurbineType1IECProjector;

  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType1IECEntityProjector.class.getName());
}
