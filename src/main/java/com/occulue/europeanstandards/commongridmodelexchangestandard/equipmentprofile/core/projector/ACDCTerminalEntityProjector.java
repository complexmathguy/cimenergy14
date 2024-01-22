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
 * Projector for ACDCTerminal as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ACDCTerminalAggregate
 *
 * @author your_name_here
 */
@Component("aCDCTerminal-entity-projector")
public class ACDCTerminalEntityProjector {

  // core constructor
  public ACDCTerminalEntityProjector(ACDCTerminalRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ACDCTerminal
   *
   * @param	entity ACDCTerminal
   */
  public ACDCTerminal create(ACDCTerminal entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ACDCTerminal
   *
   * @param	entity ACDCTerminal
   */
  public ACDCTerminal update(ACDCTerminal entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ACDCTerminal
   *
   * @param	id		UUID
   */
  public ACDCTerminal delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ACDCTerminal entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a SequenceNumber
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	ACDCTerminal
   */
  public ACDCTerminal assignSequenceNumber(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning SequenceNumber as " + assignment.toString());

    ACDCTerminal parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the SequenceNumber to the parent entity
    // ------------------------------------------
    parentEntity.setSequenceNumber(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SequenceNumber
   *
   * @param	parentId		UUID
   * @return	ACDCTerminal
   */
  public ACDCTerminal unAssignSequenceNumber(UUID parentId) {
    ACDCTerminal parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SequenceNumber on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SequenceNumber on the parent entithy
    // ------------------------------------------
    parentEntity.setSequenceNumber(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the Terminal
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	ACDCTerminal
   */
  public ACDCTerminal addToTerminal(UUID parentId, ACDCTerminal addTo) {
    LOGGER.info("handling AssignTerminalToACDCTerminalEvent - ");

    ACDCTerminal parentEntity = repository.findById(parentId).get();
    ACDCTerminal child = ACDCTerminalProjector.find(addTo.getACDCTerminalId());

    parentEntity.getTerminal().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the Terminal
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	ACDCTerminal
   */
  public ACDCTerminal removeFromTerminal(UUID parentId, ACDCTerminal removeFrom) {
    LOGGER.info("handling RemoveTerminalFromACDCTerminalEvent ");

    ACDCTerminal parentEntity = repository.findById(parentId).get();
    ACDCTerminal child = ACDCTerminalProjector.find(removeFrom.getACDCTerminalId());

    parentEntity.getTerminal().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ACDCTerminal via an FindACDCTerminalQuery
   *
   * @return query FindACDCTerminalQuery
   */
  @SuppressWarnings("unused")
  public ACDCTerminal find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ACDCTerminal - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ACDCTerminals
   *
   * @param query FindAllACDCTerminalQuery
   * @return List<ACDCTerminal>
   */
  @SuppressWarnings("unused")
  public List<ACDCTerminal> findAll(FindAllACDCTerminalQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ACDCTerminal - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ACDCTerminalRepository repository;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "aCDCTerminal-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.projector
          .ACDCTerminalEntityProjector
      ACDCTerminalProjector;

  private static final Logger LOGGER =
      Logger.getLogger(ACDCTerminalEntityProjector.class.getName());
}
