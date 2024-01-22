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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for RaiseLowerCommand as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by RaiseLowerCommandAggregate
 *
 * @author your_name_here
 */
@Component("raiseLowerCommand-entity-projector")
public class RaiseLowerCommandEntityProjector {

  // core constructor
  public RaiseLowerCommandEntityProjector(RaiseLowerCommandRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a RaiseLowerCommand
   *
   * @param	entity RaiseLowerCommand
   */
  public RaiseLowerCommand create(RaiseLowerCommand entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a RaiseLowerCommand
   *
   * @param	entity RaiseLowerCommand
   */
  public RaiseLowerCommand update(RaiseLowerCommand entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a RaiseLowerCommand
   *
   * @param	id		UUID
   */
  public RaiseLowerCommand delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    RaiseLowerCommand entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the RaiseLowerCommands
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	RaiseLowerCommand
   */
  public RaiseLowerCommand addToRaiseLowerCommands(UUID parentId, RaiseLowerCommand addTo) {
    LOGGER.info("handling AssignRaiseLowerCommandsToRaiseLowerCommandEvent - ");

    RaiseLowerCommand parentEntity = repository.findById(parentId).get();
    RaiseLowerCommand child = RaiseLowerCommandProjector.find(addTo.getRaiseLowerCommandId());

    parentEntity.getRaiseLowerCommands().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the RaiseLowerCommands
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	RaiseLowerCommand
   */
  public RaiseLowerCommand removeFromRaiseLowerCommands(
      UUID parentId, RaiseLowerCommand removeFrom) {
    LOGGER.info("handling RemoveRaiseLowerCommandsFromRaiseLowerCommandEvent ");

    RaiseLowerCommand parentEntity = repository.findById(parentId).get();
    RaiseLowerCommand child = RaiseLowerCommandProjector.find(removeFrom.getRaiseLowerCommandId());

    parentEntity.getRaiseLowerCommands().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the RaiseLowerCommand via an FindRaiseLowerCommandQuery
   *
   * @return query FindRaiseLowerCommandQuery
   */
  @SuppressWarnings("unused")
  public RaiseLowerCommand find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a RaiseLowerCommand - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all RaiseLowerCommands
   *
   * @param query FindAllRaiseLowerCommandQuery
   * @return List<RaiseLowerCommand>
   */
  @SuppressWarnings("unused")
  public List<RaiseLowerCommand> findAll(FindAllRaiseLowerCommandQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all RaiseLowerCommand - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final RaiseLowerCommandRepository repository;

  @Autowired
  @Qualifier(value = "raiseLowerCommand-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector
          .RaiseLowerCommandEntityProjector
      RaiseLowerCommandProjector;

  private static final Logger LOGGER =
      Logger.getLogger(RaiseLowerCommandEntityProjector.class.getName());
}
