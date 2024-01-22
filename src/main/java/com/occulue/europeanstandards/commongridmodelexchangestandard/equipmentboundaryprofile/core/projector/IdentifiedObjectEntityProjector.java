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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for IdentifiedObject as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by IdentifiedObjectAggregate
 *
 * @author your_name_here
 */
@Component("identifiedObject-entity-projector")
public class IdentifiedObjectEntityProjector {

  // core constructor
  public IdentifiedObjectEntityProjector(IdentifiedObjectRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a IdentifiedObject
   *
   * @param	entity IdentifiedObject
   */
  public IdentifiedObject create(IdentifiedObject entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a IdentifiedObject
   *
   * @param	entity IdentifiedObject
   */
  public IdentifiedObject update(IdentifiedObject entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a IdentifiedObject
   *
   * @param	id		UUID
   */
  public IdentifiedObject delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    IdentifiedObject entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Description
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	IdentifiedObject
   */
  public IdentifiedObject assignDescription(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning Description as " + assignment.toString());

    IdentifiedObject parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the Description to the parent entity
    // ------------------------------------------
    parentEntity.setDescription(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Description
   *
   * @param	parentId		UUID
   * @return	IdentifiedObject
   */
  public IdentifiedObject unAssignDescription(UUID parentId) {
    IdentifiedObject parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Description on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Description on the parent entithy
    // ------------------------------------------
    parentEntity.setDescription(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a EnergyIdentCodeEic
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	IdentifiedObject
   */
  public IdentifiedObject assignEnergyIdentCodeEic(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning EnergyIdentCodeEic as " + assignment.toString());

    IdentifiedObject parentEntity = repository.findById(parentId).get();
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
   * @return	IdentifiedObject
   */
  public IdentifiedObject unAssignEnergyIdentCodeEic(UUID parentId) {
    IdentifiedObject parentEntity = repository.findById(parentId).get();

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
   * Assign a MRID
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	IdentifiedObject
   */
  public IdentifiedObject assignMRID(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning MRID as " + assignment.toString());

    IdentifiedObject parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the MRID to the parent entity
    // ------------------------------------------
    parentEntity.setMRID(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MRID
   *
   * @param	parentId		UUID
   * @return	IdentifiedObject
   */
  public IdentifiedObject unAssignMRID(UUID parentId) {
    IdentifiedObject parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MRID on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MRID on the parent entithy
    // ------------------------------------------
    parentEntity.setMRID(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Name
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	IdentifiedObject
   */
  public IdentifiedObject assignName(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning Name as " + assignment.toString());

    IdentifiedObject parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the Name to the parent entity
    // ------------------------------------------
    parentEntity.setName(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Name
   *
   * @param	parentId		UUID
   * @return	IdentifiedObject
   */
  public IdentifiedObject unAssignName(UUID parentId) {
    IdentifiedObject parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Name on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Name on the parent entithy
    // ------------------------------------------
    parentEntity.setName(null);

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
   * @return	IdentifiedObject
   */
  public IdentifiedObject assignShortName(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning ShortName as " + assignment.toString());

    IdentifiedObject parentEntity = repository.findById(parentId).get();
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
   * @return	IdentifiedObject
   */
  public IdentifiedObject unAssignShortName(UUID parentId) {
    IdentifiedObject parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the IdentifiedObject via an FindIdentifiedObjectQuery
   *
   * @return query FindIdentifiedObjectQuery
   */
  @SuppressWarnings("unused")
  public IdentifiedObject find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a IdentifiedObject - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all IdentifiedObjects
   *
   * @param query FindAllIdentifiedObjectQuery
   * @return List<IdentifiedObject>
   */
  @SuppressWarnings("unused")
  public List<IdentifiedObject> findAll(FindAllIdentifiedObjectQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all IdentifiedObject - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final IdentifiedObjectRepository repository;

  @Autowired
  @Qualifier(value = "stringProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .StringProxyEntityProjector
      StringProxyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(IdentifiedObjectEntityProjector.class.getName());
}
