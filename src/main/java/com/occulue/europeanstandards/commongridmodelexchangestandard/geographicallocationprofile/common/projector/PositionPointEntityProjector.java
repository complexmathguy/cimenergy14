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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for PositionPoint as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PositionPointAggregate
 *
 * @author your_name_here
 */
@Component("positionPoint-entity-projector")
public class PositionPointEntityProjector {

  // core constructor
  public PositionPointEntityProjector(PositionPointRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PositionPoint
   *
   * @param	entity PositionPoint
   */
  public PositionPoint create(PositionPoint entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PositionPoint
   *
   * @param	entity PositionPoint
   */
  public PositionPoint update(PositionPoint entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PositionPoint
   *
   * @param	id		UUID
   */
  public PositionPoint delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PositionPoint entity = repository.findById(id).get();

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
   * @return	PositionPoint
   */
  public PositionPoint assignSequenceNumber(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning SequenceNumber as " + assignment.toString());

    PositionPoint parentEntity = repository.findById(parentId).get();
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
   * @return	PositionPoint
   */
  public PositionPoint unAssignSequenceNumber(UUID parentId) {
    PositionPoint parentEntity = repository.findById(parentId).get();

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
   * Assign a XPosition
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	PositionPoint
   */
  public PositionPoint assignXPosition(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning XPosition as " + assignment.toString());

    PositionPoint parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the XPosition to the parent entity
    // ------------------------------------------
    parentEntity.setXPosition(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the XPosition
   *
   * @param	parentId		UUID
   * @return	PositionPoint
   */
  public PositionPoint unAssignXPosition(UUID parentId) {
    PositionPoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning XPosition on " + parentEntity.toString());

    // ------------------------------------------
    // null out the XPosition on the parent entithy
    // ------------------------------------------
    parentEntity.setXPosition(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a YPosition
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	PositionPoint
   */
  public PositionPoint assignYPosition(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning YPosition as " + assignment.toString());

    PositionPoint parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the YPosition to the parent entity
    // ------------------------------------------
    parentEntity.setYPosition(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the YPosition
   *
   * @param	parentId		UUID
   * @return	PositionPoint
   */
  public PositionPoint unAssignYPosition(UUID parentId) {
    PositionPoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning YPosition on " + parentEntity.toString());

    // ------------------------------------------
    // null out the YPosition on the parent entithy
    // ------------------------------------------
    parentEntity.setYPosition(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ZPosition
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	PositionPoint
   */
  public PositionPoint assignZPosition(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning ZPosition as " + assignment.toString());

    PositionPoint parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the ZPosition to the parent entity
    // ------------------------------------------
    parentEntity.setZPosition(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ZPosition
   *
   * @param	parentId		UUID
   * @return	PositionPoint
   */
  public PositionPoint unAssignZPosition(UUID parentId) {
    PositionPoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ZPosition on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ZPosition on the parent entithy
    // ------------------------------------------
    parentEntity.setZPosition(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the PositionPoints
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	PositionPoint
   */
  public PositionPoint addToPositionPoints(UUID parentId, PositionPoint addTo) {
    LOGGER.info("handling AssignPositionPointsToPositionPointEvent - ");

    PositionPoint parentEntity = repository.findById(parentId).get();
    PositionPoint child = PositionPointProjector.find(addTo.getPositionPointId());

    parentEntity.getPositionPoints().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the PositionPoints
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	PositionPoint
   */
  public PositionPoint removeFromPositionPoints(UUID parentId, PositionPoint removeFrom) {
    LOGGER.info("handling RemovePositionPointsFromPositionPointEvent ");

    PositionPoint parentEntity = repository.findById(parentId).get();
    PositionPoint child = PositionPointProjector.find(removeFrom.getPositionPointId());

    parentEntity.getPositionPoints().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PositionPoint via an FindPositionPointQuery
   *
   * @return query FindPositionPointQuery
   */
  @SuppressWarnings("unused")
  public PositionPoint find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PositionPoint - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PositionPoints
   *
   * @param query FindAllPositionPointQuery
   * @return List<PositionPoint>
   */
  @SuppressWarnings("unused")
  public List<PositionPoint> findAll(FindAllPositionPointQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PositionPoint - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PositionPointRepository repository;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "stringProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .StringProxyEntityProjector
      StringProxyProjector;

  @Autowired
  @Qualifier(value = "positionPoint-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common
          .projector.PositionPointEntityProjector
      PositionPointProjector;

  private static final Logger LOGGER =
      Logger.getLogger(PositionPointEntityProjector.class.getName());
}
