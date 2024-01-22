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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for SwitchProxy as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SwitchProxyAggregate
 *
 * @author your_name_here
 */
@Component("switchProxy-entity-projector")
public class SwitchProxyEntityProjector {

  // core constructor
  public SwitchProxyEntityProjector(SwitchProxyRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a SwitchProxy
   *
   * @param	entity SwitchProxy
   */
  public SwitchProxy create(SwitchProxy entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a SwitchProxy
   *
   * @param	entity SwitchProxy
   */
  public SwitchProxy update(SwitchProxy entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a SwitchProxy
   *
   * @param	id		UUID
   */
  public SwitchProxy delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    SwitchProxy entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a NormalOpen
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	SwitchProxy
   */
  public SwitchProxy assignNormalOpen(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning NormalOpen as " + assignment.toString());

    SwitchProxy parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the NormalOpen to the parent entity
    // ------------------------------------------
    parentEntity.setNormalOpen(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NormalOpen
   *
   * @param	parentId		UUID
   * @return	SwitchProxy
   */
  public SwitchProxy unAssignNormalOpen(UUID parentId) {
    SwitchProxy parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NormalOpen on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NormalOpen on the parent entithy
    // ------------------------------------------
    parentEntity.setNormalOpen(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a RatedCurrent
   *
   * @param	parentId	UUID
   * @param	assignment 	CurrentFlow
   * @return	SwitchProxy
   */
  public SwitchProxy assignRatedCurrent(UUID parentId, CurrentFlow assignment) {
    LOGGER.info("assigning RatedCurrent as " + assignment.toString());

    SwitchProxy parentEntity = repository.findById(parentId).get();
    assignment = CurrentFlowProjector.find(assignment.getCurrentFlowId());

    // ------------------------------------------
    // assign the RatedCurrent to the parent entity
    // ------------------------------------------
    parentEntity.setRatedCurrent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RatedCurrent
   *
   * @param	parentId		UUID
   * @return	SwitchProxy
   */
  public SwitchProxy unAssignRatedCurrent(UUID parentId) {
    SwitchProxy parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RatedCurrent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RatedCurrent on the parent entithy
    // ------------------------------------------
    parentEntity.setRatedCurrent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Retained
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	SwitchProxy
   */
  public SwitchProxy assignRetained(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Retained as " + assignment.toString());

    SwitchProxy parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Retained to the parent entity
    // ------------------------------------------
    parentEntity.setRetained(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Retained
   *
   * @param	parentId		UUID
   * @return	SwitchProxy
   */
  public SwitchProxy unAssignRetained(UUID parentId) {
    SwitchProxy parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Retained on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Retained on the parent entithy
    // ------------------------------------------
    parentEntity.setRetained(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the SwitchProxy via an FindSwitchProxyQuery
   *
   * @return query FindSwitchProxyQuery
   */
  @SuppressWarnings("unused")
  public SwitchProxy find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a SwitchProxy - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all SwitchProxys
   *
   * @param query FindAllSwitchProxyQuery
   * @return List<SwitchProxy>
   */
  @SuppressWarnings("unused")
  public List<SwitchProxy> findAll(FindAllSwitchProxyQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all SwitchProxy - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SwitchProxyRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "currentFlow-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .CurrentFlowEntityProjector
      CurrentFlowProjector;

  private static final Logger LOGGER = Logger.getLogger(SwitchProxyEntityProjector.class.getName());
}
