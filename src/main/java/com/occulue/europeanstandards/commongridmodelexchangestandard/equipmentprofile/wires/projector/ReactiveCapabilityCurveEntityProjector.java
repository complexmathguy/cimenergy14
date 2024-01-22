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
import org.springframework.stereotype.Component;

/**
 * Projector for ReactiveCapabilityCurve as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ReactiveCapabilityCurveAggregate
 *
 * @author your_name_here
 */
@Component("reactiveCapabilityCurve-entity-projector")
public class ReactiveCapabilityCurveEntityProjector {

  // core constructor
  public ReactiveCapabilityCurveEntityProjector(ReactiveCapabilityCurveRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ReactiveCapabilityCurve
   *
   * @param	entity ReactiveCapabilityCurve
   */
  public ReactiveCapabilityCurve create(ReactiveCapabilityCurve entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ReactiveCapabilityCurve
   *
   * @param	entity ReactiveCapabilityCurve
   */
  public ReactiveCapabilityCurve update(ReactiveCapabilityCurve entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ReactiveCapabilityCurve
   *
   * @param	id		UUID
   */
  public ReactiveCapabilityCurve delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ReactiveCapabilityCurve entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /**
   * Method to retrieve the ReactiveCapabilityCurve via an FindReactiveCapabilityCurveQuery
   *
   * @return query FindReactiveCapabilityCurveQuery
   */
  @SuppressWarnings("unused")
  public ReactiveCapabilityCurve find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ReactiveCapabilityCurve - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ReactiveCapabilityCurves
   *
   * @param query FindAllReactiveCapabilityCurveQuery
   * @return List<ReactiveCapabilityCurve>
   */
  @SuppressWarnings("unused")
  public List<ReactiveCapabilityCurve> findAll(FindAllReactiveCapabilityCurveQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all ReactiveCapabilityCurve - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ReactiveCapabilityCurveRepository repository;

  private static final Logger LOGGER =
      Logger.getLogger(ReactiveCapabilityCurveEntityProjector.class.getName());
}
