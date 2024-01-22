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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for FossilFuel as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by FossilFuelAggregate
 *
 * @author your_name_here
 */
@Component("fossilFuel-entity-projector")
public class FossilFuelEntityProjector {

  // core constructor
  public FossilFuelEntityProjector(FossilFuelRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a FossilFuel
   *
   * @param	entity FossilFuel
   */
  public FossilFuel create(FossilFuel entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a FossilFuel
   *
   * @param	entity FossilFuel
   */
  public FossilFuel update(FossilFuel entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a FossilFuel
   *
   * @param	id		UUID
   */
  public FossilFuel delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    FossilFuel entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the FossilFuels
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	FossilFuel
   */
  public FossilFuel addToFossilFuels(UUID parentId, FossilFuel addTo) {
    LOGGER.info("handling AssignFossilFuelsToFossilFuelEvent - ");

    FossilFuel parentEntity = repository.findById(parentId).get();
    FossilFuel child = FossilFuelProjector.find(addTo.getFossilFuelId());

    parentEntity.getFossilFuels().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the FossilFuels
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	FossilFuel
   */
  public FossilFuel removeFromFossilFuels(UUID parentId, FossilFuel removeFrom) {
    LOGGER.info("handling RemoveFossilFuelsFromFossilFuelEvent ");

    FossilFuel parentEntity = repository.findById(parentId).get();
    FossilFuel child = FossilFuelProjector.find(removeFrom.getFossilFuelId());

    parentEntity.getFossilFuels().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the FossilFuel via an FindFossilFuelQuery
   *
   * @return query FindFossilFuelQuery
   */
  @SuppressWarnings("unused")
  public FossilFuel find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a FossilFuel - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all FossilFuels
   *
   * @param query FindAllFossilFuelQuery
   * @return List<FossilFuel>
   */
  @SuppressWarnings("unused")
  public List<FossilFuel> findAll(FindAllFossilFuelQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all FossilFuel - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final FossilFuelRepository repository;

  @Autowired
  @Qualifier(value = "fossilFuel-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production
          .projector.FossilFuelEntityProjector
      FossilFuelProjector;

  private static final Logger LOGGER = Logger.getLogger(FossilFuelEntityProjector.class.getName());
}
