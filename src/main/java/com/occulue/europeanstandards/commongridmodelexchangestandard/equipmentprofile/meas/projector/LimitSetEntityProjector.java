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
 * Projector for LimitSet as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by LimitSetAggregate
 *
 * @author your_name_here
 */
@Component("limitSet-entity-projector")
public class LimitSetEntityProjector {

  // core constructor
  public LimitSetEntityProjector(LimitSetRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a LimitSet
   *
   * @param	entity LimitSet
   */
  public LimitSet create(LimitSet entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a LimitSet
   *
   * @param	entity LimitSet
   */
  public LimitSet update(LimitSet entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a LimitSet
   *
   * @param	id		UUID
   */
  public LimitSet delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    LimitSet entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a PercentageLimitsFlag
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	LimitSet
   */
  public LimitSet assignPercentageLimitsFlag(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning PercentageLimitsFlag as " + assignment.toString());

    LimitSet parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the PercentageLimitsFlag to the parent entity
    // ------------------------------------------
    parentEntity.setPercentageLimitsFlag(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PercentageLimitsFlag
   *
   * @param	parentId		UUID
   * @return	LimitSet
   */
  public LimitSet unAssignPercentageLimitsFlag(UUID parentId) {
    LimitSet parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PercentageLimitsFlag on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PercentageLimitsFlag on the parent entithy
    // ------------------------------------------
    parentEntity.setPercentageLimitsFlag(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the LimitSet via an FindLimitSetQuery
   *
   * @return query FindLimitSetQuery
   */
  @SuppressWarnings("unused")
  public LimitSet find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a LimitSet - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all LimitSets
   *
   * @param query FindAllLimitSetQuery
   * @return List<LimitSet>
   */
  @SuppressWarnings("unused")
  public List<LimitSet> findAll(FindAllLimitSetQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all LimitSet - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final LimitSetRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  private static final Logger LOGGER = Logger.getLogger(LimitSetEntityProjector.class.getName());
}
