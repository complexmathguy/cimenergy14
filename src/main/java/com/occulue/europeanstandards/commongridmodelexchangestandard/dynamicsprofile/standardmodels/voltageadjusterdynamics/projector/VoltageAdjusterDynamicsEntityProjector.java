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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for VoltageAdjusterDynamics as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by VoltageAdjusterDynamicsAggregate
 *
 * @author your_name_here
 */
@Component("voltageAdjusterDynamics-entity-projector")
public class VoltageAdjusterDynamicsEntityProjector {

  // core constructor
  public VoltageAdjusterDynamicsEntityProjector(VoltageAdjusterDynamicsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a VoltageAdjusterDynamics
   *
   * @param	entity VoltageAdjusterDynamics
   */
  public VoltageAdjusterDynamics create(VoltageAdjusterDynamics entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a VoltageAdjusterDynamics
   *
   * @param	entity VoltageAdjusterDynamics
   */
  public VoltageAdjusterDynamics update(VoltageAdjusterDynamics entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a VoltageAdjusterDynamics
   *
   * @param	id		UUID
   */
  public VoltageAdjusterDynamics delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    VoltageAdjusterDynamics entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a VoltageAdjusterDynamics
   *
   * @param	parentId	UUID
   * @param	assignment 	VoltageAdjusterDynamics
   * @return	VoltageAdjusterDynamics
   */
  public VoltageAdjusterDynamics assignVoltageAdjusterDynamics(
      UUID parentId, VoltageAdjusterDynamics assignment) {
    LOGGER.info("assigning VoltageAdjusterDynamics as " + assignment.toString());

    VoltageAdjusterDynamics parentEntity = repository.findById(parentId).get();
    assignment = VoltageAdjusterDynamicsProjector.find(assignment.getVoltageAdjusterDynamicsId());

    // ------------------------------------------
    // assign the VoltageAdjusterDynamics to the parent entity
    // ------------------------------------------
    parentEntity.setVoltageAdjusterDynamics(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the VoltageAdjusterDynamics
   *
   * @param	parentId		UUID
   * @return	VoltageAdjusterDynamics
   */
  public VoltageAdjusterDynamics unAssignVoltageAdjusterDynamics(UUID parentId) {
    VoltageAdjusterDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning VoltageAdjusterDynamics on " + parentEntity.toString());

    // ------------------------------------------
    // null out the VoltageAdjusterDynamics on the parent entithy
    // ------------------------------------------
    parentEntity.setVoltageAdjusterDynamics(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the VoltageAdjusterDynamics via an FindVoltageAdjusterDynamicsQuery
   *
   * @return query FindVoltageAdjusterDynamicsQuery
   */
  @SuppressWarnings("unused")
  public VoltageAdjusterDynamics find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a VoltageAdjusterDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all VoltageAdjusterDynamicss
   *
   * @param query FindAllVoltageAdjusterDynamicsQuery
   * @return List<VoltageAdjusterDynamics>
   */
  @SuppressWarnings("unused")
  public List<VoltageAdjusterDynamics> findAll(FindAllVoltageAdjusterDynamicsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all VoltageAdjusterDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final VoltageAdjusterDynamicsRepository repository;

  @Autowired
  @Qualifier(value = "voltageAdjusterDynamics-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .voltageadjusterdynamics.projector.VoltageAdjusterDynamicsEntityProjector
      VoltageAdjusterDynamicsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(VoltageAdjusterDynamicsEntityProjector.class.getName());
}
