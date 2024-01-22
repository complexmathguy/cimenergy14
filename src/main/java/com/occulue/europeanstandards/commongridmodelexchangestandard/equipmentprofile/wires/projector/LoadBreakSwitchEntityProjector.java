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
 * Projector for LoadBreakSwitch as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by LoadBreakSwitchAggregate
 *
 * @author your_name_here
 */
@Component("loadBreakSwitch-entity-projector")
public class LoadBreakSwitchEntityProjector {

  // core constructor
  public LoadBreakSwitchEntityProjector(LoadBreakSwitchRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a LoadBreakSwitch
   *
   * @param	entity LoadBreakSwitch
   */
  public LoadBreakSwitch create(LoadBreakSwitch entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a LoadBreakSwitch
   *
   * @param	entity LoadBreakSwitch
   */
  public LoadBreakSwitch update(LoadBreakSwitch entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a LoadBreakSwitch
   *
   * @param	id		UUID
   */
  public LoadBreakSwitch delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    LoadBreakSwitch entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /**
   * Method to retrieve the LoadBreakSwitch via an FindLoadBreakSwitchQuery
   *
   * @return query FindLoadBreakSwitchQuery
   */
  @SuppressWarnings("unused")
  public LoadBreakSwitch find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a LoadBreakSwitch - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all LoadBreakSwitchs
   *
   * @param query FindAllLoadBreakSwitchQuery
   * @return List<LoadBreakSwitch>
   */
  @SuppressWarnings("unused")
  public List<LoadBreakSwitch> findAll(FindAllLoadBreakSwitchQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all LoadBreakSwitch - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final LoadBreakSwitchRepository repository;

  private static final Logger LOGGER =
      Logger.getLogger(LoadBreakSwitchEntityProjector.class.getName());
}
