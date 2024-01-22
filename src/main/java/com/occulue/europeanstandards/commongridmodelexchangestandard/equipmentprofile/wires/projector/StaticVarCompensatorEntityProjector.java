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
 * Projector for StaticVarCompensator as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by StaticVarCompensatorAggregate
 *
 * @author your_name_here
 */
@Component("staticVarCompensator-entity-projector")
public class StaticVarCompensatorEntityProjector {

  // core constructor
  public StaticVarCompensatorEntityProjector(StaticVarCompensatorRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a StaticVarCompensator
   *
   * @param	entity StaticVarCompensator
   */
  public StaticVarCompensator create(StaticVarCompensator entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a StaticVarCompensator
   *
   * @param	entity StaticVarCompensator
   */
  public StaticVarCompensator update(StaticVarCompensator entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a StaticVarCompensator
   *
   * @param	id		UUID
   */
  public StaticVarCompensator delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    StaticVarCompensator entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a CapacitiveRating
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	StaticVarCompensator
   */
  public StaticVarCompensator assignCapacitiveRating(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning CapacitiveRating as " + assignment.toString());

    StaticVarCompensator parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the CapacitiveRating to the parent entity
    // ------------------------------------------
    parentEntity.setCapacitiveRating(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the CapacitiveRating
   *
   * @param	parentId		UUID
   * @return	StaticVarCompensator
   */
  public StaticVarCompensator unAssignCapacitiveRating(UUID parentId) {
    StaticVarCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning CapacitiveRating on " + parentEntity.toString());

    // ------------------------------------------
    // null out the CapacitiveRating on the parent entithy
    // ------------------------------------------
    parentEntity.setCapacitiveRating(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a InductiveRating
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	StaticVarCompensator
   */
  public StaticVarCompensator assignInductiveRating(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning InductiveRating as " + assignment.toString());

    StaticVarCompensator parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the InductiveRating to the parent entity
    // ------------------------------------------
    parentEntity.setInductiveRating(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the InductiveRating
   *
   * @param	parentId		UUID
   * @return	StaticVarCompensator
   */
  public StaticVarCompensator unAssignInductiveRating(UUID parentId) {
    StaticVarCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning InductiveRating on " + parentEntity.toString());

    // ------------------------------------------
    // null out the InductiveRating on the parent entithy
    // ------------------------------------------
    parentEntity.setInductiveRating(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Slope
   *
   * @param	parentId	UUID
   * @param	assignment 	VoltagePerReactivePower
   * @return	StaticVarCompensator
   */
  public StaticVarCompensator assignSlope(UUID parentId, VoltagePerReactivePower assignment) {
    LOGGER.info("assigning Slope as " + assignment.toString());

    StaticVarCompensator parentEntity = repository.findById(parentId).get();
    assignment = VoltagePerReactivePowerProjector.find(assignment.getVoltagePerReactivePowerId());

    // ------------------------------------------
    // assign the Slope to the parent entity
    // ------------------------------------------
    parentEntity.setSlope(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Slope
   *
   * @param	parentId		UUID
   * @return	StaticVarCompensator
   */
  public StaticVarCompensator unAssignSlope(UUID parentId) {
    StaticVarCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Slope on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Slope on the parent entithy
    // ------------------------------------------
    parentEntity.setSlope(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a VoltageSetPoint
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	StaticVarCompensator
   */
  public StaticVarCompensator assignVoltageSetPoint(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning VoltageSetPoint as " + assignment.toString());

    StaticVarCompensator parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the VoltageSetPoint to the parent entity
    // ------------------------------------------
    parentEntity.setVoltageSetPoint(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the VoltageSetPoint
   *
   * @param	parentId		UUID
   * @return	StaticVarCompensator
   */
  public StaticVarCompensator unAssignVoltageSetPoint(UUID parentId) {
    StaticVarCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning VoltageSetPoint on " + parentEntity.toString());

    // ------------------------------------------
    // null out the VoltageSetPoint on the parent entithy
    // ------------------------------------------
    parentEntity.setVoltageSetPoint(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the StaticVarCompensator via an FindStaticVarCompensatorQuery
   *
   * @return query FindStaticVarCompensatorQuery
   */
  @SuppressWarnings("unused")
  public StaticVarCompensator find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a StaticVarCompensator - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all StaticVarCompensators
   *
   * @param query FindAllStaticVarCompensatorQuery
   * @return List<StaticVarCompensator>
   */
  @SuppressWarnings("unused")
  public List<StaticVarCompensator> findAll(FindAllStaticVarCompensatorQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all StaticVarCompensator - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final StaticVarCompensatorRepository repository;

  @Autowired
  @Qualifier(value = "reactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactanceEntityProjector
      ReactanceProjector;

  @Autowired
  @Qualifier(value = "voltagePerReactivePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .VoltagePerReactivePowerEntityProjector
      VoltagePerReactivePowerProjector;

  @Autowired
  @Qualifier(value = "voltage-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .VoltageEntityProjector
      VoltageProjector;

  private static final Logger LOGGER =
      Logger.getLogger(StaticVarCompensatorEntityProjector.class.getName());
}
