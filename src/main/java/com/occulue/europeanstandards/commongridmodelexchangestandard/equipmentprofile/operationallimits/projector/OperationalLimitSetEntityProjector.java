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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for OperationalLimitSet as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by OperationalLimitSetAggregate
 *
 * @author your_name_here
 */
@Component("operationalLimitSet-entity-projector")
public class OperationalLimitSetEntityProjector {

  // core constructor
  public OperationalLimitSetEntityProjector(OperationalLimitSetRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a OperationalLimitSet
   *
   * @param	entity OperationalLimitSet
   */
  public OperationalLimitSet create(OperationalLimitSet entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a OperationalLimitSet
   *
   * @param	entity OperationalLimitSet
   */
  public OperationalLimitSet update(OperationalLimitSet entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a OperationalLimitSet
   *
   * @param	id		UUID
   */
  public OperationalLimitSet delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    OperationalLimitSet entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the OperationalLimitSet
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	OperationalLimitSet
   */
  public OperationalLimitSet addToOperationalLimitSet(UUID parentId, OperationalLimitSet addTo) {
    LOGGER.info("handling AssignOperationalLimitSetToOperationalLimitSetEvent - ");

    OperationalLimitSet parentEntity = repository.findById(parentId).get();
    OperationalLimitSet child = OperationalLimitSetProjector.find(addTo.getOperationalLimitSetId());

    parentEntity.getOperationalLimitSet().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the OperationalLimitSet
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	OperationalLimitSet
   */
  public OperationalLimitSet removeFromOperationalLimitSet(
      UUID parentId, OperationalLimitSet removeFrom) {
    LOGGER.info("handling RemoveOperationalLimitSetFromOperationalLimitSetEvent ");

    OperationalLimitSet parentEntity = repository.findById(parentId).get();
    OperationalLimitSet child =
        OperationalLimitSetProjector.find(removeFrom.getOperationalLimitSetId());

    parentEntity.getOperationalLimitSet().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the OperationalLimitSet via an FindOperationalLimitSetQuery
   *
   * @return query FindOperationalLimitSetQuery
   */
  @SuppressWarnings("unused")
  public OperationalLimitSet find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a OperationalLimitSet - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all OperationalLimitSets
   *
   * @param query FindAllOperationalLimitSetQuery
   * @return List<OperationalLimitSet>
   */
  @SuppressWarnings("unused")
  public List<OperationalLimitSet> findAll(FindAllOperationalLimitSetQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all OperationalLimitSet - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final OperationalLimitSetRepository repository;

  @Autowired
  @Qualifier(value = "operationalLimitSet-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits
          .projector.OperationalLimitSetEntityProjector
      OperationalLimitSetProjector;

  private static final Logger LOGGER =
      Logger.getLogger(OperationalLimitSetEntityProjector.class.getName());
}
