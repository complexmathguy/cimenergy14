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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for SvPowerFlow as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SvPowerFlowAggregate
 *
 * @author your_name_here
 */
@Component("svPowerFlow-entity-projector")
public class SvPowerFlowEntityProjector {

  // core constructor
  public SvPowerFlowEntityProjector(SvPowerFlowRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a SvPowerFlow
   *
   * @param	entity SvPowerFlow
   */
  public SvPowerFlow create(SvPowerFlow entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a SvPowerFlow
   *
   * @param	entity SvPowerFlow
   */
  public SvPowerFlow update(SvPowerFlow entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a SvPowerFlow
   *
   * @param	id		UUID
   */
  public SvPowerFlow delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    SvPowerFlow entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a P
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	SvPowerFlow
   */
  public SvPowerFlow assignP(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning P as " + assignment.toString());

    SvPowerFlow parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the P to the parent entity
    // ------------------------------------------
    parentEntity.setP(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P
   *
   * @param	parentId		UUID
   * @return	SvPowerFlow
   */
  public SvPowerFlow unAssignP(UUID parentId) {
    SvPowerFlow parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P on the parent entithy
    // ------------------------------------------
    parentEntity.setP(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Q
   *
   * @param	parentId	UUID
   * @param	assignment 	ReactivePower
   * @return	SvPowerFlow
   */
  public SvPowerFlow assignQ(UUID parentId, ReactivePower assignment) {
    LOGGER.info("assigning Q as " + assignment.toString());

    SvPowerFlow parentEntity = repository.findById(parentId).get();
    assignment = ReactivePowerProjector.find(assignment.getReactivePowerId());

    // ------------------------------------------
    // assign the Q to the parent entity
    // ------------------------------------------
    parentEntity.setQ(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Q
   *
   * @param	parentId		UUID
   * @return	SvPowerFlow
   */
  public SvPowerFlow unAssignQ(UUID parentId) {
    SvPowerFlow parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Q on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Q on the parent entithy
    // ------------------------------------------
    parentEntity.setQ(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SvPowerFlow
   *
   * @param	parentId	UUID
   * @param	assignment 	SvPowerFlow
   * @return	SvPowerFlow
   */
  public SvPowerFlow assignSvPowerFlow(UUID parentId, SvPowerFlow assignment) {
    LOGGER.info("assigning SvPowerFlow as " + assignment.toString());

    SvPowerFlow parentEntity = repository.findById(parentId).get();
    assignment = SvPowerFlowProjector.find(assignment.getSvPowerFlowId());

    // ------------------------------------------
    // assign the SvPowerFlow to the parent entity
    // ------------------------------------------
    parentEntity.setSvPowerFlow(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SvPowerFlow
   *
   * @param	parentId		UUID
   * @return	SvPowerFlow
   */
  public SvPowerFlow unAssignSvPowerFlow(UUID parentId) {
    SvPowerFlow parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SvPowerFlow on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SvPowerFlow on the parent entithy
    // ------------------------------------------
    parentEntity.setSvPowerFlow(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the SvPowerFlow via an FindSvPowerFlowQuery
   *
   * @return query FindSvPowerFlowQuery
   */
  @SuppressWarnings("unused")
  public SvPowerFlow find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a SvPowerFlow - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all SvPowerFlows
   *
   * @param query FindAllSvPowerFlowQuery
   * @return List<SvPowerFlow>
   */
  @SuppressWarnings("unused")
  public List<SvPowerFlow> findAll(FindAllSvPowerFlowQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all SvPowerFlow - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SvPowerFlowRepository repository;

  @Autowired
  @Qualifier(value = "activePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ActivePowerEntityProjector
      ActivePowerProjector;

  @Autowired
  @Qualifier(value = "reactivePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactivePowerEntityProjector
      ReactivePowerProjector;

  @Autowired
  @Qualifier(value = "svPowerFlow-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables
          .projector.SvPowerFlowEntityProjector
      SvPowerFlowProjector;

  private static final Logger LOGGER = Logger.getLogger(SvPowerFlowEntityProjector.class.getName());
}
