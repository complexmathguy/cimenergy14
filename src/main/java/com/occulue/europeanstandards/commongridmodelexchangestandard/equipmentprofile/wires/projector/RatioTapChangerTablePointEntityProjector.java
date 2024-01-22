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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for RatioTapChangerTablePoint as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by RatioTapChangerTablePointAggregate
 *
 * @author your_name_here
 */
@Component("ratioTapChangerTablePoint-entity-projector")
public class RatioTapChangerTablePointEntityProjector {

  // core constructor
  public RatioTapChangerTablePointEntityProjector(RatioTapChangerTablePointRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a RatioTapChangerTablePoint
   *
   * @param	entity RatioTapChangerTablePoint
   */
  public RatioTapChangerTablePoint create(RatioTapChangerTablePoint entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a RatioTapChangerTablePoint
   *
   * @param	entity RatioTapChangerTablePoint
   */
  public RatioTapChangerTablePoint update(RatioTapChangerTablePoint entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a RatioTapChangerTablePoint
   *
   * @param	id		UUID
   */
  public RatioTapChangerTablePoint delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    RatioTapChangerTablePoint entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the RatioTapChangerTablePoint
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	RatioTapChangerTablePoint
   */
  public RatioTapChangerTablePoint addToRatioTapChangerTablePoint(
      UUID parentId, RatioTapChangerTablePoint addTo) {
    LOGGER.info("handling AssignRatioTapChangerTablePointToRatioTapChangerTablePointEvent - ");

    RatioTapChangerTablePoint parentEntity = repository.findById(parentId).get();
    RatioTapChangerTablePoint child =
        RatioTapChangerTablePointProjector.find(addTo.getRatioTapChangerTablePointId());

    parentEntity.getRatioTapChangerTablePoint().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the RatioTapChangerTablePoint
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	RatioTapChangerTablePoint
   */
  public RatioTapChangerTablePoint removeFromRatioTapChangerTablePoint(
      UUID parentId, RatioTapChangerTablePoint removeFrom) {
    LOGGER.info("handling RemoveRatioTapChangerTablePointFromRatioTapChangerTablePointEvent ");

    RatioTapChangerTablePoint parentEntity = repository.findById(parentId).get();
    RatioTapChangerTablePoint child =
        RatioTapChangerTablePointProjector.find(removeFrom.getRatioTapChangerTablePointId());

    parentEntity.getRatioTapChangerTablePoint().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the RatioTapChangerTablePoint via an FindRatioTapChangerTablePointQuery
   *
   * @return query FindRatioTapChangerTablePointQuery
   */
  @SuppressWarnings("unused")
  public RatioTapChangerTablePoint find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a RatioTapChangerTablePoint - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all RatioTapChangerTablePoints
   *
   * @param query FindAllRatioTapChangerTablePointQuery
   * @return List<RatioTapChangerTablePoint>
   */
  @SuppressWarnings("unused")
  public List<RatioTapChangerTablePoint> findAll(FindAllRatioTapChangerTablePointQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all RatioTapChangerTablePoint - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final RatioTapChangerTablePointRepository repository;

  @Autowired
  @Qualifier(value = "ratioTapChangerTablePoint-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .RatioTapChangerTablePointEntityProjector
      RatioTapChangerTablePointProjector;

  private static final Logger LOGGER =
      Logger.getLogger(RatioTapChangerTablePointEntityProjector.class.getName());
}
