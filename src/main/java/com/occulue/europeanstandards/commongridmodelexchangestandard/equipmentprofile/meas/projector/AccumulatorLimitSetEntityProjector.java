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
 * Projector for AccumulatorLimitSet as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by AccumulatorLimitSetAggregate
 *
 * @author your_name_here
 */
@Component("accumulatorLimitSet-entity-projector")
public class AccumulatorLimitSetEntityProjector {

  // core constructor
  public AccumulatorLimitSetEntityProjector(AccumulatorLimitSetRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a AccumulatorLimitSet
   *
   * @param	entity AccumulatorLimitSet
   */
  public AccumulatorLimitSet create(AccumulatorLimitSet entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a AccumulatorLimitSet
   *
   * @param	entity AccumulatorLimitSet
   */
  public AccumulatorLimitSet update(AccumulatorLimitSet entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a AccumulatorLimitSet
   *
   * @param	id		UUID
   */
  public AccumulatorLimitSet delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    AccumulatorLimitSet entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the LimitSets
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	AccumulatorLimitSet
   */
  public AccumulatorLimitSet addToLimitSets(UUID parentId, AccumulatorLimitSet addTo) {
    LOGGER.info("handling AssignLimitSetsToAccumulatorLimitSetEvent - ");

    AccumulatorLimitSet parentEntity = repository.findById(parentId).get();
    AccumulatorLimitSet child = AccumulatorLimitSetProjector.find(addTo.getAccumulatorLimitSetId());

    parentEntity.getLimitSets().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the LimitSets
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	AccumulatorLimitSet
   */
  public AccumulatorLimitSet removeFromLimitSets(UUID parentId, AccumulatorLimitSet removeFrom) {
    LOGGER.info("handling RemoveLimitSetsFromAccumulatorLimitSetEvent ");

    AccumulatorLimitSet parentEntity = repository.findById(parentId).get();
    AccumulatorLimitSet child =
        AccumulatorLimitSetProjector.find(removeFrom.getAccumulatorLimitSetId());

    parentEntity.getLimitSets().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the AccumulatorLimitSet via an FindAccumulatorLimitSetQuery
   *
   * @return query FindAccumulatorLimitSetQuery
   */
  @SuppressWarnings("unused")
  public AccumulatorLimitSet find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a AccumulatorLimitSet - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all AccumulatorLimitSets
   *
   * @param query FindAllAccumulatorLimitSetQuery
   * @return List<AccumulatorLimitSet>
   */
  @SuppressWarnings("unused")
  public List<AccumulatorLimitSet> findAll(FindAllAccumulatorLimitSetQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all AccumulatorLimitSet - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final AccumulatorLimitSetRepository repository;

  @Autowired
  @Qualifier(value = "accumulatorLimitSet-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector
          .AccumulatorLimitSetEntityProjector
      AccumulatorLimitSetProjector;

  private static final Logger LOGGER =
      Logger.getLogger(AccumulatorLimitSetEntityProjector.class.getName());
}
