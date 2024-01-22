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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for RotatingMachineDynamics as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by RotatingMachineDynamicsAggregate
 *
 * @author your_name_here
 */
@Component("rotatingMachineDynamics-entity-projector")
public class RotatingMachineDynamicsEntityProjector {

  // core constructor
  public RotatingMachineDynamicsEntityProjector(RotatingMachineDynamicsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a RotatingMachineDynamics
   *
   * @param	entity RotatingMachineDynamics
   */
  public RotatingMachineDynamics create(RotatingMachineDynamics entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a RotatingMachineDynamics
   *
   * @param	entity RotatingMachineDynamics
   */
  public RotatingMachineDynamics update(RotatingMachineDynamics entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a RotatingMachineDynamics
   *
   * @param	id		UUID
   */
  public RotatingMachineDynamics delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    RotatingMachineDynamics entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Damping
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	RotatingMachineDynamics
   */
  public RotatingMachineDynamics assignDamping(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Damping as " + assignment.toString());

    RotatingMachineDynamics parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Damping to the parent entity
    // ------------------------------------------
    parentEntity.setDamping(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Damping
   *
   * @param	parentId		UUID
   * @return	RotatingMachineDynamics
   */
  public RotatingMachineDynamics unAssignDamping(UUID parentId) {
    RotatingMachineDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Damping on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Damping on the parent entithy
    // ------------------------------------------
    parentEntity.setDamping(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Inertia
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	RotatingMachineDynamics
   */
  public RotatingMachineDynamics assignInertia(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Inertia as " + assignment.toString());

    RotatingMachineDynamics parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Inertia to the parent entity
    // ------------------------------------------
    parentEntity.setInertia(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Inertia
   *
   * @param	parentId		UUID
   * @return	RotatingMachineDynamics
   */
  public RotatingMachineDynamics unAssignInertia(UUID parentId) {
    RotatingMachineDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Inertia on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Inertia on the parent entithy
    // ------------------------------------------
    parentEntity.setInertia(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SaturationFactor
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	RotatingMachineDynamics
   */
  public RotatingMachineDynamics assignSaturationFactor(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning SaturationFactor as " + assignment.toString());

    RotatingMachineDynamics parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the SaturationFactor to the parent entity
    // ------------------------------------------
    parentEntity.setSaturationFactor(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SaturationFactor
   *
   * @param	parentId		UUID
   * @return	RotatingMachineDynamics
   */
  public RotatingMachineDynamics unAssignSaturationFactor(UUID parentId) {
    RotatingMachineDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SaturationFactor on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SaturationFactor on the parent entithy
    // ------------------------------------------
    parentEntity.setSaturationFactor(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SaturationFactor120
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	RotatingMachineDynamics
   */
  public RotatingMachineDynamics assignSaturationFactor120(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning SaturationFactor120 as " + assignment.toString());

    RotatingMachineDynamics parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the SaturationFactor120 to the parent entity
    // ------------------------------------------
    parentEntity.setSaturationFactor120(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SaturationFactor120
   *
   * @param	parentId		UUID
   * @return	RotatingMachineDynamics
   */
  public RotatingMachineDynamics unAssignSaturationFactor120(UUID parentId) {
    RotatingMachineDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SaturationFactor120 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SaturationFactor120 on the parent entithy
    // ------------------------------------------
    parentEntity.setSaturationFactor120(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a StatorLeakageReactance
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	RotatingMachineDynamics
   */
  public RotatingMachineDynamics assignStatorLeakageReactance(UUID parentId, PU assignment) {
    LOGGER.info("assigning StatorLeakageReactance as " + assignment.toString());

    RotatingMachineDynamics parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the StatorLeakageReactance to the parent entity
    // ------------------------------------------
    parentEntity.setStatorLeakageReactance(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the StatorLeakageReactance
   *
   * @param	parentId		UUID
   * @return	RotatingMachineDynamics
   */
  public RotatingMachineDynamics unAssignStatorLeakageReactance(UUID parentId) {
    RotatingMachineDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning StatorLeakageReactance on " + parentEntity.toString());

    // ------------------------------------------
    // null out the StatorLeakageReactance on the parent entithy
    // ------------------------------------------
    parentEntity.setStatorLeakageReactance(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a StatorResistance
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	RotatingMachineDynamics
   */
  public RotatingMachineDynamics assignStatorResistance(UUID parentId, PU assignment) {
    LOGGER.info("assigning StatorResistance as " + assignment.toString());

    RotatingMachineDynamics parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the StatorResistance to the parent entity
    // ------------------------------------------
    parentEntity.setStatorResistance(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the StatorResistance
   *
   * @param	parentId		UUID
   * @return	RotatingMachineDynamics
   */
  public RotatingMachineDynamics unAssignStatorResistance(UUID parentId) {
    RotatingMachineDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning StatorResistance on " + parentEntity.toString());

    // ------------------------------------------
    // null out the StatorResistance on the parent entithy
    // ------------------------------------------
    parentEntity.setStatorResistance(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the RotatingMachineDynamics via an FindRotatingMachineDynamicsQuery
   *
   * @return query FindRotatingMachineDynamicsQuery
   */
  @SuppressWarnings("unused")
  public RotatingMachineDynamics find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a RotatingMachineDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all RotatingMachineDynamicss
   *
   * @param query FindAllRotatingMachineDynamicsQuery
   * @return List<RotatingMachineDynamics>
   */
  @SuppressWarnings("unused")
  public List<RotatingMachineDynamics> findAll(FindAllRotatingMachineDynamicsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all RotatingMachineDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final RotatingMachineDynamicsRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  private static final Logger LOGGER =
      Logger.getLogger(RotatingMachineDynamicsEntityProjector.class.getName());
}
