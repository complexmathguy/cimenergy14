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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for NonConformLoad as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by NonConformLoadAggregate
 *
 * @author your_name_here
 */
@Component("nonConformLoad-entity-projector")
public class NonConformLoadEntityProjector {

  // core constructor
  public NonConformLoadEntityProjector(NonConformLoadRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a NonConformLoad
   *
   * @param	entity NonConformLoad
   */
  public NonConformLoad create(NonConformLoad entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a NonConformLoad
   *
   * @param	entity NonConformLoad
   */
  public NonConformLoad update(NonConformLoad entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a NonConformLoad
   *
   * @param	id		UUID
   */
  public NonConformLoad delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    NonConformLoad entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the EnergyConsumers
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	NonConformLoad
   */
  public NonConformLoad addToEnergyConsumers(UUID parentId, NonConformLoad addTo) {
    LOGGER.info("handling AssignEnergyConsumersToNonConformLoadEvent - ");

    NonConformLoad parentEntity = repository.findById(parentId).get();
    NonConformLoad child = NonConformLoadProjector.find(addTo.getNonConformLoadId());

    parentEntity.getEnergyConsumers().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the EnergyConsumers
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	NonConformLoad
   */
  public NonConformLoad removeFromEnergyConsumers(UUID parentId, NonConformLoad removeFrom) {
    LOGGER.info("handling RemoveEnergyConsumersFromNonConformLoadEvent ");

    NonConformLoad parentEntity = repository.findById(parentId).get();
    NonConformLoad child = NonConformLoadProjector.find(removeFrom.getNonConformLoadId());

    parentEntity.getEnergyConsumers().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the NonConformLoad via an FindNonConformLoadQuery
   *
   * @return query FindNonConformLoadQuery
   */
  @SuppressWarnings("unused")
  public NonConformLoad find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a NonConformLoad - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all NonConformLoads
   *
   * @param query FindAllNonConformLoadQuery
   * @return List<NonConformLoad>
   */
  @SuppressWarnings("unused")
  public List<NonConformLoad> findAll(FindAllNonConformLoadQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all NonConformLoad - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final NonConformLoadRepository repository;

  @Autowired
  @Qualifier(value = "nonConformLoad-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.projector
          .NonConformLoadEntityProjector
      NonConformLoadProjector;

  private static final Logger LOGGER =
      Logger.getLogger(NonConformLoadEntityProjector.class.getName());
}
