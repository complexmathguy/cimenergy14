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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for Location as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by LocationAggregate
 *
 * @author your_name_here
 */
@Component("location-entity-projector")
public class LocationEntityProjector {

  // core constructor
  public LocationEntityProjector(LocationRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Location
   *
   * @param	entity Location
   */
  public Location create(Location entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Location
   *
   * @param	entity Location
   */
  public Location update(Location entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Location
   *
   * @param	id		UUID
   */
  public Location delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Location entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Location
   *
   * @param	parentId	UUID
   * @param	assignment 	Location
   * @return	Location
   */
  public Location assignLocation(UUID parentId, Location assignment) {
    LOGGER.info("assigning Location as " + assignment.toString());

    Location parentEntity = repository.findById(parentId).get();
    assignment = LocationProjector.find(assignment.getLocationId());

    // ------------------------------------------
    // assign the Location to the parent entity
    // ------------------------------------------
    parentEntity.setLocation(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Location
   *
   * @param	parentId		UUID
   * @return	Location
   */
  public Location unAssignLocation(UUID parentId) {
    Location parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Location on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Location on the parent entithy
    // ------------------------------------------
    parentEntity.setLocation(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Location via an FindLocationQuery
   *
   * @return query FindLocationQuery
   */
  @SuppressWarnings("unused")
  public Location find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Location - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Locations
   *
   * @param query FindAllLocationQuery
   * @return List<Location>
   */
  @SuppressWarnings("unused")
  public List<Location> findAll(FindAllLocationQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Location - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final LocationRepository repository;

  @Autowired
  @Qualifier(value = "location-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common
          .projector.LocationEntityProjector
      LocationProjector;

  private static final Logger LOGGER = Logger.getLogger(LocationEntityProjector.class.getName());
}
