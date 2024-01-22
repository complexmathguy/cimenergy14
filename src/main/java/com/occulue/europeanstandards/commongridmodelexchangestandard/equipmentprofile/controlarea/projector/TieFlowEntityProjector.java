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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for TieFlow as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by TieFlowAggregate
 *
 * @author your_name_here
 */
@Component("tieFlow-entity-projector")
public class TieFlowEntityProjector {

  // core constructor
  public TieFlowEntityProjector(TieFlowRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a TieFlow
   *
   * @param	entity TieFlow
   */
  public TieFlow create(TieFlow entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a TieFlow
   *
   * @param	entity TieFlow
   */
  public TieFlow update(TieFlow entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a TieFlow
   *
   * @param	id		UUID
   */
  public TieFlow delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    TieFlow entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a PositiveFlowIn
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	TieFlow
   */
  public TieFlow assignPositiveFlowIn(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning PositiveFlowIn as " + assignment.toString());

    TieFlow parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the PositiveFlowIn to the parent entity
    // ------------------------------------------
    parentEntity.setPositiveFlowIn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PositiveFlowIn
   *
   * @param	parentId		UUID
   * @return	TieFlow
   */
  public TieFlow unAssignPositiveFlowIn(UUID parentId) {
    TieFlow parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PositiveFlowIn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PositiveFlowIn on the parent entithy
    // ------------------------------------------
    parentEntity.setPositiveFlowIn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the TieFlow
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	TieFlow
   */
  public TieFlow addToTieFlow(UUID parentId, TieFlow addTo) {
    LOGGER.info("handling AssignTieFlowToTieFlowEvent - ");

    TieFlow parentEntity = repository.findById(parentId).get();
    TieFlow child = TieFlowProjector.find(addTo.getTieFlowId());

    parentEntity.getTieFlow().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the TieFlow
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	TieFlow
   */
  public TieFlow removeFromTieFlow(UUID parentId, TieFlow removeFrom) {
    LOGGER.info("handling RemoveTieFlowFromTieFlowEvent ");

    TieFlow parentEntity = repository.findById(parentId).get();
    TieFlow child = TieFlowProjector.find(removeFrom.getTieFlowId());

    parentEntity.getTieFlow().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the TieFlow via an FindTieFlowQuery
   *
   * @return query FindTieFlowQuery
   */
  @SuppressWarnings("unused")
  public TieFlow find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a TieFlow - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all TieFlows
   *
   * @param query FindAllTieFlowQuery
   * @return List<TieFlow>
   */
  @SuppressWarnings("unused")
  public List<TieFlow> findAll(FindAllTieFlowQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all TieFlow - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final TieFlowRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "tieFlow-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea
          .projector.TieFlowEntityProjector
      TieFlowProjector;

  private static final Logger LOGGER = Logger.getLogger(TieFlowEntityProjector.class.getName());
}
