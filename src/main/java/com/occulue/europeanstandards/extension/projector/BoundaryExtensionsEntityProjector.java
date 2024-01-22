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
 * Projector for BoundaryExtensions as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by BoundaryExtensionsAggregate
 *
 * @author your_name_here
 */
@Component("boundaryExtensions-entity-projector")
public class BoundaryExtensionsEntityProjector {

  // core constructor
  public BoundaryExtensionsEntityProjector(BoundaryExtensionsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a BoundaryExtensions
   *
   * @param	entity BoundaryExtensions
   */
  public BoundaryExtensions create(BoundaryExtensions entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a BoundaryExtensions
   *
   * @param	entity BoundaryExtensions
   */
  public BoundaryExtensions update(BoundaryExtensions entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a BoundaryExtensions
   *
   * @param	id		UUID
   */
  public BoundaryExtensions delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    BoundaryExtensions entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a BoundaryPoint
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	BoundaryExtensions
   */
  public BoundaryExtensions assignBoundaryPoint(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning BoundaryPoint as " + assignment.toString());

    BoundaryExtensions parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the BoundaryPoint to the parent entity
    // ------------------------------------------
    parentEntity.setBoundaryPoint(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the BoundaryPoint
   *
   * @param	parentId		UUID
   * @return	BoundaryExtensions
   */
  public BoundaryExtensions unAssignBoundaryPoint(UUID parentId) {
    BoundaryExtensions parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning BoundaryPoint on " + parentEntity.toString());

    // ------------------------------------------
    // null out the BoundaryPoint on the parent entithy
    // ------------------------------------------
    parentEntity.setBoundaryPoint(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a FromEndIsoCode
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	BoundaryExtensions
   */
  public BoundaryExtensions assignFromEndIsoCode(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning FromEndIsoCode as " + assignment.toString());

    BoundaryExtensions parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the FromEndIsoCode to the parent entity
    // ------------------------------------------
    parentEntity.setFromEndIsoCode(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the FromEndIsoCode
   *
   * @param	parentId		UUID
   * @return	BoundaryExtensions
   */
  public BoundaryExtensions unAssignFromEndIsoCode(UUID parentId) {
    BoundaryExtensions parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning FromEndIsoCode on " + parentEntity.toString());

    // ------------------------------------------
    // null out the FromEndIsoCode on the parent entithy
    // ------------------------------------------
    parentEntity.setFromEndIsoCode(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a FromEndName
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	BoundaryExtensions
   */
  public BoundaryExtensions assignFromEndName(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning FromEndName as " + assignment.toString());

    BoundaryExtensions parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the FromEndName to the parent entity
    // ------------------------------------------
    parentEntity.setFromEndName(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the FromEndName
   *
   * @param	parentId		UUID
   * @return	BoundaryExtensions
   */
  public BoundaryExtensions unAssignFromEndName(UUID parentId) {
    BoundaryExtensions parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning FromEndName on " + parentEntity.toString());

    // ------------------------------------------
    // null out the FromEndName on the parent entithy
    // ------------------------------------------
    parentEntity.setFromEndName(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a FromEndNameTso
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	BoundaryExtensions
   */
  public BoundaryExtensions assignFromEndNameTso(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning FromEndNameTso as " + assignment.toString());

    BoundaryExtensions parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the FromEndNameTso to the parent entity
    // ------------------------------------------
    parentEntity.setFromEndNameTso(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the FromEndNameTso
   *
   * @param	parentId		UUID
   * @return	BoundaryExtensions
   */
  public BoundaryExtensions unAssignFromEndNameTso(UUID parentId) {
    BoundaryExtensions parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning FromEndNameTso on " + parentEntity.toString());

    // ------------------------------------------
    // null out the FromEndNameTso on the parent entithy
    // ------------------------------------------
    parentEntity.setFromEndNameTso(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ToEndIsoCode
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	BoundaryExtensions
   */
  public BoundaryExtensions assignToEndIsoCode(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning ToEndIsoCode as " + assignment.toString());

    BoundaryExtensions parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the ToEndIsoCode to the parent entity
    // ------------------------------------------
    parentEntity.setToEndIsoCode(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ToEndIsoCode
   *
   * @param	parentId		UUID
   * @return	BoundaryExtensions
   */
  public BoundaryExtensions unAssignToEndIsoCode(UUID parentId) {
    BoundaryExtensions parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ToEndIsoCode on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ToEndIsoCode on the parent entithy
    // ------------------------------------------
    parentEntity.setToEndIsoCode(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ToEndName
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	BoundaryExtensions
   */
  public BoundaryExtensions assignToEndName(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning ToEndName as " + assignment.toString());

    BoundaryExtensions parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the ToEndName to the parent entity
    // ------------------------------------------
    parentEntity.setToEndName(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ToEndName
   *
   * @param	parentId		UUID
   * @return	BoundaryExtensions
   */
  public BoundaryExtensions unAssignToEndName(UUID parentId) {
    BoundaryExtensions parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ToEndName on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ToEndName on the parent entithy
    // ------------------------------------------
    parentEntity.setToEndName(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ToEndNameTso
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	BoundaryExtensions
   */
  public BoundaryExtensions assignToEndNameTso(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning ToEndNameTso as " + assignment.toString());

    BoundaryExtensions parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the ToEndNameTso to the parent entity
    // ------------------------------------------
    parentEntity.setToEndNameTso(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ToEndNameTso
   *
   * @param	parentId		UUID
   * @return	BoundaryExtensions
   */
  public BoundaryExtensions unAssignToEndNameTso(UUID parentId) {
    BoundaryExtensions parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ToEndNameTso on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ToEndNameTso on the parent entithy
    // ------------------------------------------
    parentEntity.setToEndNameTso(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the BoundaryExtensions via an FindBoundaryExtensionsQuery
   *
   * @return query FindBoundaryExtensionsQuery
   */
  @SuppressWarnings("unused")
  public BoundaryExtensions find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a BoundaryExtensions - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all BoundaryExtensionss
   *
   * @param query FindAllBoundaryExtensionsQuery
   * @return List<BoundaryExtensions>
   */
  @SuppressWarnings("unused")
  public List<BoundaryExtensions> findAll(FindAllBoundaryExtensionsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all BoundaryExtensions - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final BoundaryExtensionsRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "stringProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .StringProxyEntityProjector
      StringProxyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(BoundaryExtensionsEntityProjector.class.getName());
}
