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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for StationSupply as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by StationSupplyAggregate
 *
 * @author your_name_here
 */
@Component("stationSupply-entity-projector")
public class StationSupplyEntityProjector {

  // core constructor
  public StationSupplyEntityProjector(StationSupplyRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a StationSupply
   *
   * @param	entity StationSupply
   */
  public StationSupply create(StationSupply entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a StationSupply
   *
   * @param	entity StationSupply
   */
  public StationSupply update(StationSupply entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a StationSupply
   *
   * @param	id		UUID
   */
  public StationSupply delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    StationSupply entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /**
   * Method to retrieve the StationSupply via an FindStationSupplyQuery
   *
   * @return query FindStationSupplyQuery
   */
  @SuppressWarnings("unused")
  public StationSupply find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a StationSupply - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all StationSupplys
   *
   * @param query FindAllStationSupplyQuery
   * @return List<StationSupply>
   */
  @SuppressWarnings("unused")
  public List<StationSupply> findAll(FindAllStationSupplyQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all StationSupply - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final StationSupplyRepository repository;

  private static final Logger LOGGER =
      Logger.getLogger(StationSupplyEntityProjector.class.getName());
}
