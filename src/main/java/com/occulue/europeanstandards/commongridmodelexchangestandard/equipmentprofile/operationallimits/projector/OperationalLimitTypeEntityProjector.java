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
 * Projector for OperationalLimitType as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by OperationalLimitTypeAggregate
 *
 * @author your_name_here
 */
@Component("operationalLimitType-entity-projector")
public class OperationalLimitTypeEntityProjector {

  // core constructor
  public OperationalLimitTypeEntityProjector(OperationalLimitTypeRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a OperationalLimitType
   *
   * @param	entity OperationalLimitType
   */
  public OperationalLimitType create(OperationalLimitType entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a OperationalLimitType
   *
   * @param	entity OperationalLimitType
   */
  public OperationalLimitType update(OperationalLimitType entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a OperationalLimitType
   *
   * @param	id		UUID
   */
  public OperationalLimitType delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    OperationalLimitType entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a AcceptableDuration
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	OperationalLimitType
   */
  public OperationalLimitType assignAcceptableDuration(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning AcceptableDuration as " + assignment.toString());

    OperationalLimitType parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the AcceptableDuration to the parent entity
    // ------------------------------------------
    parentEntity.setAcceptableDuration(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the AcceptableDuration
   *
   * @param	parentId		UUID
   * @return	OperationalLimitType
   */
  public OperationalLimitType unAssignAcceptableDuration(UUID parentId) {
    OperationalLimitType parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning AcceptableDuration on " + parentEntity.toString());

    // ------------------------------------------
    // null out the AcceptableDuration on the parent entithy
    // ------------------------------------------
    parentEntity.setAcceptableDuration(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the OperationalLimitType via an FindOperationalLimitTypeQuery
   *
   * @return query FindOperationalLimitTypeQuery
   */
  @SuppressWarnings("unused")
  public OperationalLimitType find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a OperationalLimitType - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all OperationalLimitTypes
   *
   * @param query FindAllOperationalLimitTypeQuery
   * @return List<OperationalLimitType>
   */
  @SuppressWarnings("unused")
  public List<OperationalLimitType> findAll(FindAllOperationalLimitTypeQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all OperationalLimitType - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final OperationalLimitTypeRepository repository;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(OperationalLimitTypeEntityProjector.class.getName());
}
