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
package com.occulue.europeanstandards.extension.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.extension.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for ENTSOEIdentifiedObject as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ENTSOEIdentifiedObjectAggregate
 *
 * @author your_name_here
 */
@Component("eNTSOEIdentifiedObject-entity-projector")
public class ENTSOEIdentifiedObjectEntityProjector {

  // core constructor
  public ENTSOEIdentifiedObjectEntityProjector(ENTSOEIdentifiedObjectRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ENTSOEIdentifiedObject
   *
   * @param	entity ENTSOEIdentifiedObject
   */
  public ENTSOEIdentifiedObject create(ENTSOEIdentifiedObject entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ENTSOEIdentifiedObject
   *
   * @param	entity ENTSOEIdentifiedObject
   */
  public ENTSOEIdentifiedObject update(ENTSOEIdentifiedObject entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ENTSOEIdentifiedObject
   *
   * @param	id		UUID
   */
  public ENTSOEIdentifiedObject delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ENTSOEIdentifiedObject entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a EnergyIdentCodeEic
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	ENTSOEIdentifiedObject
   */
  public ENTSOEIdentifiedObject assignEnergyIdentCodeEic(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning EnergyIdentCodeEic as " + assignment.toString());

    ENTSOEIdentifiedObject parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the EnergyIdentCodeEic to the parent entity
    // ------------------------------------------
    parentEntity.setEnergyIdentCodeEic(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the EnergyIdentCodeEic
   *
   * @param	parentId		UUID
   * @return	ENTSOEIdentifiedObject
   */
  public ENTSOEIdentifiedObject unAssignEnergyIdentCodeEic(UUID parentId) {
    ENTSOEIdentifiedObject parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning EnergyIdentCodeEic on " + parentEntity.toString());

    // ------------------------------------------
    // null out the EnergyIdentCodeEic on the parent entithy
    // ------------------------------------------
    parentEntity.setEnergyIdentCodeEic(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ShortName
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	ENTSOEIdentifiedObject
   */
  public ENTSOEIdentifiedObject assignShortName(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning ShortName as " + assignment.toString());

    ENTSOEIdentifiedObject parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the ShortName to the parent entity
    // ------------------------------------------
    parentEntity.setShortName(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ShortName
   *
   * @param	parentId		UUID
   * @return	ENTSOEIdentifiedObject
   */
  public ENTSOEIdentifiedObject unAssignShortName(UUID parentId) {
    ENTSOEIdentifiedObject parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ShortName on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ShortName on the parent entithy
    // ------------------------------------------
    parentEntity.setShortName(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ENTSOEIdentifiedObject via an FindENTSOEIdentifiedObjectQuery
   *
   * @return query FindENTSOEIdentifiedObjectQuery
   */
  @SuppressWarnings("unused")
  public ENTSOEIdentifiedObject find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ENTSOEIdentifiedObject - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ENTSOEIdentifiedObjects
   *
   * @param query FindAllENTSOEIdentifiedObjectQuery
   * @return List<ENTSOEIdentifiedObject>
   */
  @SuppressWarnings("unused")
  public List<ENTSOEIdentifiedObject> findAll(FindAllENTSOEIdentifiedObjectQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all ENTSOEIdentifiedObject - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ENTSOEIdentifiedObjectRepository repository;

  @Autowired
  @Qualifier(value = "stringProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .StringProxyEntityProjector
      StringProxyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(ENTSOEIdentifiedObjectEntityProjector.class.getName());
}
