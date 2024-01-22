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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for MeasurementValueSource as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by MeasurementValueSourceAggregate
 *
 * @author your_name_here
 */
@Component("measurementValueSource-entity-projector")
public class MeasurementValueSourceEntityProjector {

  // core constructor
  public MeasurementValueSourceEntityProjector(MeasurementValueSourceRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a MeasurementValueSource
   *
   * @param	entity MeasurementValueSource
   */
  public MeasurementValueSource create(MeasurementValueSource entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a MeasurementValueSource
   *
   * @param	entity MeasurementValueSource
   */
  public MeasurementValueSource update(MeasurementValueSource entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a MeasurementValueSource
   *
   * @param	id		UUID
   */
  public MeasurementValueSource delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    MeasurementValueSource entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /**
   * Method to retrieve the MeasurementValueSource via an FindMeasurementValueSourceQuery
   *
   * @return query FindMeasurementValueSourceQuery
   */
  @SuppressWarnings("unused")
  public MeasurementValueSource find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a MeasurementValueSource - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all MeasurementValueSources
   *
   * @param query FindAllMeasurementValueSourceQuery
   * @return List<MeasurementValueSource>
   */
  @SuppressWarnings("unused")
  public List<MeasurementValueSource> findAll(FindAllMeasurementValueSourceQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all MeasurementValueSource - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final MeasurementValueSourceRepository repository;

  private static final Logger LOGGER =
      Logger.getLogger(MeasurementValueSourceEntityProjector.class.getName());
}
