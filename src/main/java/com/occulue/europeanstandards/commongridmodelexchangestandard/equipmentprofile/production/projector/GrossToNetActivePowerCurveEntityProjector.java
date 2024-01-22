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
 * Projector for GrossToNetActivePowerCurve as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GrossToNetActivePowerCurveAggregate
 *
 * @author your_name_here
 */
@Component("grossToNetActivePowerCurve-entity-projector")
public class GrossToNetActivePowerCurveEntityProjector {

  // core constructor
  public GrossToNetActivePowerCurveEntityProjector(
      GrossToNetActivePowerCurveRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GrossToNetActivePowerCurve
   *
   * @param	entity GrossToNetActivePowerCurve
   */
  public GrossToNetActivePowerCurve create(GrossToNetActivePowerCurve entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GrossToNetActivePowerCurve
   *
   * @param	entity GrossToNetActivePowerCurve
   */
  public GrossToNetActivePowerCurve update(GrossToNetActivePowerCurve entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GrossToNetActivePowerCurve
   *
   * @param	id		UUID
   */
  public GrossToNetActivePowerCurve delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GrossToNetActivePowerCurve entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the GrossToNetActivePowerCurves
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	GrossToNetActivePowerCurve
   */
  public GrossToNetActivePowerCurve addToGrossToNetActivePowerCurves(
      UUID parentId, GrossToNetActivePowerCurve addTo) {
    LOGGER.info("handling AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveEvent - ");

    GrossToNetActivePowerCurve parentEntity = repository.findById(parentId).get();
    GrossToNetActivePowerCurve child =
        GrossToNetActivePowerCurveProjector.find(addTo.getGrossToNetActivePowerCurveId());

    parentEntity.getGrossToNetActivePowerCurves().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the GrossToNetActivePowerCurves
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	GrossToNetActivePowerCurve
   */
  public GrossToNetActivePowerCurve removeFromGrossToNetActivePowerCurves(
      UUID parentId, GrossToNetActivePowerCurve removeFrom) {
    LOGGER.info("handling RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveEvent ");

    GrossToNetActivePowerCurve parentEntity = repository.findById(parentId).get();
    GrossToNetActivePowerCurve child =
        GrossToNetActivePowerCurveProjector.find(removeFrom.getGrossToNetActivePowerCurveId());

    parentEntity.getGrossToNetActivePowerCurves().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GrossToNetActivePowerCurve via an FindGrossToNetActivePowerCurveQuery
   *
   * @return query FindGrossToNetActivePowerCurveQuery
   */
  @SuppressWarnings("unused")
  public GrossToNetActivePowerCurve find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a GrossToNetActivePowerCurve - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GrossToNetActivePowerCurves
   *
   * @param query FindAllGrossToNetActivePowerCurveQuery
   * @return List<GrossToNetActivePowerCurve>
   */
  @SuppressWarnings("unused")
  public List<GrossToNetActivePowerCurve> findAll(FindAllGrossToNetActivePowerCurveQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all GrossToNetActivePowerCurve - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GrossToNetActivePowerCurveRepository repository;

  @Autowired
  @Qualifier(value = "grossToNetActivePowerCurve-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production
          .projector.GrossToNetActivePowerCurveEntityProjector
      GrossToNetActivePowerCurveProjector;

  private static final Logger LOGGER =
      Logger.getLogger(GrossToNetActivePowerCurveEntityProjector.class.getName());
}
