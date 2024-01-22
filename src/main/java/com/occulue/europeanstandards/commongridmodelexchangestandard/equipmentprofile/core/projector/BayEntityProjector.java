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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for Bay as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by BayAggregate
 *
 * @author your_name_here
 */
@Component("bay-entity-projector")
public class BayEntityProjector {

  // core constructor
  public BayEntityProjector(BayRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Bay
   *
   * @param	entity Bay
   */
  public Bay create(Bay entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Bay
   *
   * @param	entity Bay
   */
  public Bay update(Bay entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Bay
   *
   * @param	id		UUID
   */
  public Bay delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Bay entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the Bays
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	Bay
   */
  public Bay addToBays(UUID parentId, Bay addTo) {
    LOGGER.info("handling AssignBaysToBayEvent - ");

    Bay parentEntity = repository.findById(parentId).get();
    Bay child = BayProjector.find(addTo.getBayId());

    parentEntity.getBays().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the Bays
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	Bay
   */
  public Bay removeFromBays(UUID parentId, Bay removeFrom) {
    LOGGER.info("handling RemoveBaysFromBayEvent ");

    Bay parentEntity = repository.findById(parentId).get();
    Bay child = BayProjector.find(removeFrom.getBayId());

    parentEntity.getBays().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Bay via an FindBayQuery
   *
   * @return query FindBayQuery
   */
  @SuppressWarnings("unused")
  public Bay find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Bay - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Bays
   *
   * @param query FindAllBayQuery
   * @return List<Bay>
   */
  @SuppressWarnings("unused")
  public List<Bay> findAll(FindAllBayQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Bay - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final BayRepository repository;

  @Autowired
  @Qualifier(value = "bay-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.projector
          .BayEntityProjector
      BayProjector;

  private static final Logger LOGGER = Logger.getLogger(BayEntityProjector.class.getName());
}
