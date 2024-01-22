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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardinterconnections.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardinterconnections.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for RemoteInputSignal as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by RemoteInputSignalAggregate
 *
 * @author your_name_here
 */
@Component("remoteInputSignal-entity-projector")
public class RemoteInputSignalEntityProjector {

  // core constructor
  public RemoteInputSignalEntityProjector(RemoteInputSignalRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a RemoteInputSignal
   *
   * @param	entity RemoteInputSignal
   */
  public RemoteInputSignal create(RemoteInputSignal entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a RemoteInputSignal
   *
   * @param	entity RemoteInputSignal
   */
  public RemoteInputSignal update(RemoteInputSignal entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a RemoteInputSignal
   *
   * @param	id		UUID
   */
  public RemoteInputSignal delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    RemoteInputSignal entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the RemoteInputSignal
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	RemoteInputSignal
   */
  public RemoteInputSignal addToRemoteInputSignal(UUID parentId, RemoteInputSignal addTo) {
    LOGGER.info("handling AssignRemoteInputSignalToRemoteInputSignalEvent - ");

    RemoteInputSignal parentEntity = repository.findById(parentId).get();
    RemoteInputSignal child = RemoteInputSignalProjector.find(addTo.getRemoteInputSignalId());

    parentEntity.getRemoteInputSignal().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the RemoteInputSignal
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	RemoteInputSignal
   */
  public RemoteInputSignal removeFromRemoteInputSignal(
      UUID parentId, RemoteInputSignal removeFrom) {
    LOGGER.info("handling RemoveRemoteInputSignalFromRemoteInputSignalEvent ");

    RemoteInputSignal parentEntity = repository.findById(parentId).get();
    RemoteInputSignal child = RemoteInputSignalProjector.find(removeFrom.getRemoteInputSignalId());

    parentEntity.getRemoteInputSignal().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the RemoteInputSignal via an FindRemoteInputSignalQuery
   *
   * @return query FindRemoteInputSignalQuery
   */
  @SuppressWarnings("unused")
  public RemoteInputSignal find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a RemoteInputSignal - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all RemoteInputSignals
   *
   * @param query FindAllRemoteInputSignalQuery
   * @return List<RemoteInputSignal>
   */
  @SuppressWarnings("unused")
  public List<RemoteInputSignal> findAll(FindAllRemoteInputSignalQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all RemoteInputSignal - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final RemoteInputSignalRepository repository;

  @Autowired
  @Qualifier(value = "remoteInputSignal-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile
          .standardinterconnections.projector.RemoteInputSignalEntityProjector
      RemoteInputSignalProjector;

  private static final Logger LOGGER =
      Logger.getLogger(RemoteInputSignalEntityProjector.class.getName());
}
