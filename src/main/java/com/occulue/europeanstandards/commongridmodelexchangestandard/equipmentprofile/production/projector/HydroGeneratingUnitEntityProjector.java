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
 * Projector for HydroGeneratingUnit as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by HydroGeneratingUnitAggregate
 *
 * @author your_name_here
 */
@Component("hydroGeneratingUnit-entity-projector")
public class HydroGeneratingUnitEntityProjector {

  // core constructor
  public HydroGeneratingUnitEntityProjector(HydroGeneratingUnitRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a HydroGeneratingUnit
   *
   * @param	entity HydroGeneratingUnit
   */
  public HydroGeneratingUnit create(HydroGeneratingUnit entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a HydroGeneratingUnit
   *
   * @param	entity HydroGeneratingUnit
   */
  public HydroGeneratingUnit update(HydroGeneratingUnit entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a HydroGeneratingUnit
   *
   * @param	id		UUID
   */
  public HydroGeneratingUnit delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    HydroGeneratingUnit entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the HydroGeneratingUnits
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	HydroGeneratingUnit
   */
  public HydroGeneratingUnit addToHydroGeneratingUnits(UUID parentId, HydroGeneratingUnit addTo) {
    LOGGER.info("handling AssignHydroGeneratingUnitsToHydroGeneratingUnitEvent - ");

    HydroGeneratingUnit parentEntity = repository.findById(parentId).get();
    HydroGeneratingUnit child = HydroGeneratingUnitProjector.find(addTo.getHydroGeneratingUnitId());

    parentEntity.getHydroGeneratingUnits().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the HydroGeneratingUnits
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	HydroGeneratingUnit
   */
  public HydroGeneratingUnit removeFromHydroGeneratingUnits(
      UUID parentId, HydroGeneratingUnit removeFrom) {
    LOGGER.info("handling RemoveHydroGeneratingUnitsFromHydroGeneratingUnitEvent ");

    HydroGeneratingUnit parentEntity = repository.findById(parentId).get();
    HydroGeneratingUnit child =
        HydroGeneratingUnitProjector.find(removeFrom.getHydroGeneratingUnitId());

    parentEntity.getHydroGeneratingUnits().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the HydroGeneratingUnit via an FindHydroGeneratingUnitQuery
   *
   * @return query FindHydroGeneratingUnitQuery
   */
  @SuppressWarnings("unused")
  public HydroGeneratingUnit find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a HydroGeneratingUnit - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all HydroGeneratingUnits
   *
   * @param query FindAllHydroGeneratingUnitQuery
   * @return List<HydroGeneratingUnit>
   */
  @SuppressWarnings("unused")
  public List<HydroGeneratingUnit> findAll(FindAllHydroGeneratingUnitQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all HydroGeneratingUnit - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final HydroGeneratingUnitRepository repository;

  @Autowired
  @Qualifier(value = "hydroGeneratingUnit-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production
          .projector.HydroGeneratingUnitEntityProjector
      HydroGeneratingUnitProjector;

  private static final Logger LOGGER =
      Logger.getLogger(HydroGeneratingUnitEntityProjector.class.getName());
}
