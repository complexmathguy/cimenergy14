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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for WindContPType4aIEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindContPType4aIECAggregate
 *
 * @author your_name_here
 */
@Component("windContPType4aIEC-entity-projector")
public class WindContPType4aIECEntityProjector {

  // core constructor
  public WindContPType4aIECEntityProjector(WindContPType4aIECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindContPType4aIEC
   *
   * @param	entity WindContPType4aIEC
   */
  public WindContPType4aIEC create(WindContPType4aIEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindContPType4aIEC
   *
   * @param	entity WindContPType4aIEC
   */
  public WindContPType4aIEC update(WindContPType4aIEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindContPType4aIEC
   *
   * @param	id		UUID
   */
  public WindContPType4aIEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindContPType4aIEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Dpmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPType4aIEC
   */
  public WindContPType4aIEC assignDpmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dpmax as " + assignment.toString());

    WindContPType4aIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dpmax to the parent entity
    // ------------------------------------------
    parentEntity.setDpmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dpmax
   *
   * @param	parentId		UUID
   * @return	WindContPType4aIEC
   */
  public WindContPType4aIEC unAssignDpmax(UUID parentId) {
    WindContPType4aIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dpmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dpmax on the parent entithy
    // ------------------------------------------
    parentEntity.setDpmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpord
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContPType4aIEC
   */
  public WindContPType4aIEC assignTpord(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpord as " + assignment.toString());

    WindContPType4aIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpord to the parent entity
    // ------------------------------------------
    parentEntity.setTpord(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpord
   *
   * @param	parentId		UUID
   * @return	WindContPType4aIEC
   */
  public WindContPType4aIEC unAssignTpord(UUID parentId) {
    WindContPType4aIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpord on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpord on the parent entithy
    // ------------------------------------------
    parentEntity.setTpord(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tufilt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContPType4aIEC
   */
  public WindContPType4aIEC assignTufilt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tufilt as " + assignment.toString());

    WindContPType4aIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tufilt to the parent entity
    // ------------------------------------------
    parentEntity.setTufilt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tufilt
   *
   * @param	parentId		UUID
   * @return	WindContPType4aIEC
   */
  public WindContPType4aIEC unAssignTufilt(UUID parentId) {
    WindContPType4aIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tufilt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tufilt on the parent entithy
    // ------------------------------------------
    parentEntity.setTufilt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindContPType4aIEC via an FindWindContPType4aIECQuery
   *
   * @return query FindWindContPType4aIECQuery
   */
  @SuppressWarnings("unused")
  public WindContPType4aIEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindContPType4aIEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindContPType4aIECs
   *
   * @param query FindAllWindContPType4aIECQuery
   * @return List<WindContPType4aIEC>
   */
  @SuppressWarnings("unused")
  public List<WindContPType4aIEC> findAll(FindAllWindContPType4aIECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all WindContPType4aIEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindContPType4aIECRepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(WindContPType4aIECEntityProjector.class.getName());
}
