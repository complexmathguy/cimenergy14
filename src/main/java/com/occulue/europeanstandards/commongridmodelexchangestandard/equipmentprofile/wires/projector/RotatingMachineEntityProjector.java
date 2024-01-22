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
 * Projector for RotatingMachine as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by RotatingMachineAggregate
 *
 * @author your_name_here
 */
@Component("rotatingMachine-entity-projector")
public class RotatingMachineEntityProjector {

  // core constructor
  public RotatingMachineEntityProjector(RotatingMachineRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a RotatingMachine
   *
   * @param	entity RotatingMachine
   */
  public RotatingMachine create(RotatingMachine entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a RotatingMachine
   *
   * @param	entity RotatingMachine
   */
  public RotatingMachine update(RotatingMachine entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a RotatingMachine
   *
   * @param	id		UUID
   */
  public RotatingMachine delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    RotatingMachine entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a RatedPowerFactor
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	RotatingMachine
   */
  public RotatingMachine assignRatedPowerFactor(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning RatedPowerFactor as " + assignment.toString());

    RotatingMachine parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the RatedPowerFactor to the parent entity
    // ------------------------------------------
    parentEntity.setRatedPowerFactor(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RatedPowerFactor
   *
   * @param	parentId		UUID
   * @return	RotatingMachine
   */
  public RotatingMachine unAssignRatedPowerFactor(UUID parentId) {
    RotatingMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RatedPowerFactor on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RatedPowerFactor on the parent entithy
    // ------------------------------------------
    parentEntity.setRatedPowerFactor(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a RatedS
   *
   * @param	parentId	UUID
   * @param	assignment 	ApparentPower
   * @return	RotatingMachine
   */
  public RotatingMachine assignRatedS(UUID parentId, ApparentPower assignment) {
    LOGGER.info("assigning RatedS as " + assignment.toString());

    RotatingMachine parentEntity = repository.findById(parentId).get();
    assignment = ApparentPowerProjector.find(assignment.getApparentPowerId());

    // ------------------------------------------
    // assign the RatedS to the parent entity
    // ------------------------------------------
    parentEntity.setRatedS(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RatedS
   *
   * @param	parentId		UUID
   * @return	RotatingMachine
   */
  public RotatingMachine unAssignRatedS(UUID parentId) {
    RotatingMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RatedS on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RatedS on the parent entithy
    // ------------------------------------------
    parentEntity.setRatedS(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a RatedU
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	RotatingMachine
   */
  public RotatingMachine assignRatedU(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning RatedU as " + assignment.toString());

    RotatingMachine parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the RatedU to the parent entity
    // ------------------------------------------
    parentEntity.setRatedU(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RatedU
   *
   * @param	parentId		UUID
   * @return	RotatingMachine
   */
  public RotatingMachine unAssignRatedU(UUID parentId) {
    RotatingMachine parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RatedU on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RatedU on the parent entithy
    // ------------------------------------------
    parentEntity.setRatedU(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the RotatingMachine
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	RotatingMachine
   */
  public RotatingMachine addToRotatingMachine(UUID parentId, RotatingMachine addTo) {
    LOGGER.info("handling AssignRotatingMachineToRotatingMachineEvent - ");

    RotatingMachine parentEntity = repository.findById(parentId).get();
    RotatingMachine child = RotatingMachineProjector.find(addTo.getRotatingMachineId());

    parentEntity.getRotatingMachine().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the RotatingMachine
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	RotatingMachine
   */
  public RotatingMachine removeFromRotatingMachine(UUID parentId, RotatingMachine removeFrom) {
    LOGGER.info("handling RemoveRotatingMachineFromRotatingMachineEvent ");

    RotatingMachine parentEntity = repository.findById(parentId).get();
    RotatingMachine child = RotatingMachineProjector.find(removeFrom.getRotatingMachineId());

    parentEntity.getRotatingMachine().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the RotatingMachine via an FindRotatingMachineQuery
   *
   * @return query FindRotatingMachineQuery
   */
  @SuppressWarnings("unused")
  public RotatingMachine find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a RotatingMachine - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all RotatingMachines
   *
   * @param query FindAllRotatingMachineQuery
   * @return List<RotatingMachine>
   */
  @SuppressWarnings("unused")
  public List<RotatingMachine> findAll(FindAllRotatingMachineQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all RotatingMachine - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final RotatingMachineRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "apparentPower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ApparentPowerEntityProjector
      ApparentPowerProjector;

  @Autowired
  @Qualifier(value = "voltage-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .VoltageEntityProjector
      VoltageProjector;

  @Autowired
  @Qualifier(value = "rotatingMachine-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .RotatingMachineEntityProjector
      RotatingMachineProjector;

  private static final Logger LOGGER =
      Logger.getLogger(RotatingMachineEntityProjector.class.getName());
}
