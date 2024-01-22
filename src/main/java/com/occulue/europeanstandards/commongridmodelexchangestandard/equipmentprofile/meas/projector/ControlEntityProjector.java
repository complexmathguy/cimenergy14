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
 * Projector for Control as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ControlAggregate
 *
 * @author your_name_here
 */
@Component("control-entity-projector")
public class ControlEntityProjector {

  // core constructor
  public ControlEntityProjector(ControlRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Control
   *
   * @param	entity Control
   */
  public Control create(Control entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Control
   *
   * @param	entity Control
   */
  public Control update(Control entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Control
   *
   * @param	id		UUID
   */
  public Control delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Control entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a ControlType
   *
   * @param	parentId	UUID
   * @param	assignment 	StringProxy
   * @return	Control
   */
  public Control assignControlType(UUID parentId, StringProxy assignment) {
    LOGGER.info("assigning ControlType as " + assignment.toString());

    Control parentEntity = repository.findById(parentId).get();
    assignment = StringProxyProjector.find(assignment.getStringProxyId());

    // ------------------------------------------
    // assign the ControlType to the parent entity
    // ------------------------------------------
    parentEntity.setControlType(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ControlType
   *
   * @param	parentId		UUID
   * @return	Control
   */
  public Control unAssignControlType(UUID parentId) {
    Control parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ControlType on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ControlType on the parent entithy
    // ------------------------------------------
    parentEntity.setControlType(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a OperationInProgress
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	Control
   */
  public Control assignOperationInProgress(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning OperationInProgress as " + assignment.toString());

    Control parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the OperationInProgress to the parent entity
    // ------------------------------------------
    parentEntity.setOperationInProgress(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the OperationInProgress
   *
   * @param	parentId		UUID
   * @return	Control
   */
  public Control unAssignOperationInProgress(UUID parentId) {
    Control parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning OperationInProgress on " + parentEntity.toString());

    // ------------------------------------------
    // null out the OperationInProgress on the parent entithy
    // ------------------------------------------
    parentEntity.setOperationInProgress(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a TimeStamp
   *
   * @param	parentId	UUID
   * @param	assignment 	DateTime
   * @return	Control
   */
  public Control assignTimeStamp(UUID parentId, DateTime assignment) {
    LOGGER.info("assigning TimeStamp as " + assignment.toString());

    Control parentEntity = repository.findById(parentId).get();
    assignment = DateTimeProjector.find(assignment.getDateTimeId());

    // ------------------------------------------
    // assign the TimeStamp to the parent entity
    // ------------------------------------------
    parentEntity.setTimeStamp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the TimeStamp
   *
   * @param	parentId		UUID
   * @return	Control
   */
  public Control unAssignTimeStamp(UUID parentId) {
    Control parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning TimeStamp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the TimeStamp on the parent entithy
    // ------------------------------------------
    parentEntity.setTimeStamp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the Controls
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	Control
   */
  public Control addToControls(UUID parentId, Control addTo) {
    LOGGER.info("handling AssignControlsToControlEvent - ");

    Control parentEntity = repository.findById(parentId).get();
    Control child = ControlProjector.find(addTo.getControlId());

    parentEntity.getControls().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the Controls
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	Control
   */
  public Control removeFromControls(UUID parentId, Control removeFrom) {
    LOGGER.info("handling RemoveControlsFromControlEvent ");

    Control parentEntity = repository.findById(parentId).get();
    Control child = ControlProjector.find(removeFrom.getControlId());

    parentEntity.getControls().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Control via an FindControlQuery
   *
   * @return query FindControlQuery
   */
  @SuppressWarnings("unused")
  public Control find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Control - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Controls
   *
   * @param query FindAllControlQuery
   * @return List<Control>
   */
  @SuppressWarnings("unused")
  public List<Control> findAll(FindAllControlQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Control - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ControlRepository repository;

  @Autowired
  @Qualifier(value = "stringProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .StringProxyEntityProjector
      StringProxyProjector;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "dateTime-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .DateTimeEntityProjector
      DateTimeProjector;

  @Autowired
  @Qualifier(value = "control-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector
          .ControlEntityProjector
      ControlProjector;

  private static final Logger LOGGER = Logger.getLogger(ControlEntityProjector.class.getName());
}
