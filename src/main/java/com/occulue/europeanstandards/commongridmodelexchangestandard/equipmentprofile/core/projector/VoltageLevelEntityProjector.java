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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for VoltageLevel as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by VoltageLevelAggregate
 *
 * @author your_name_here
 */
@Component("voltageLevel-entity-projector")
public class VoltageLevelEntityProjector {

  // core constructor
  public VoltageLevelEntityProjector(VoltageLevelRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a VoltageLevel
   *
   * @param	entity VoltageLevel
   */
  public VoltageLevel create(VoltageLevel entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a VoltageLevel
   *
   * @param	entity VoltageLevel
   */
  public VoltageLevel update(VoltageLevel entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a VoltageLevel
   *
   * @param	id		UUID
   */
  public VoltageLevel delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    VoltageLevel entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a HighVoltageLimit
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	VoltageLevel
   */
  public VoltageLevel assignHighVoltageLimit(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning HighVoltageLimit as " + assignment.toString());

    VoltageLevel parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the HighVoltageLimit to the parent entity
    // ------------------------------------------
    parentEntity.setHighVoltageLimit(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the HighVoltageLimit
   *
   * @param	parentId		UUID
   * @return	VoltageLevel
   */
  public VoltageLevel unAssignHighVoltageLimit(UUID parentId) {
    VoltageLevel parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning HighVoltageLimit on " + parentEntity.toString());

    // ------------------------------------------
    // null out the HighVoltageLimit on the parent entithy
    // ------------------------------------------
    parentEntity.setHighVoltageLimit(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a LowVoltageLimit
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	VoltageLevel
   */
  public VoltageLevel assignLowVoltageLimit(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning LowVoltageLimit as " + assignment.toString());

    VoltageLevel parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the LowVoltageLimit to the parent entity
    // ------------------------------------------
    parentEntity.setLowVoltageLimit(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the LowVoltageLimit
   *
   * @param	parentId		UUID
   * @return	VoltageLevel
   */
  public VoltageLevel unAssignLowVoltageLimit(UUID parentId) {
    VoltageLevel parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning LowVoltageLimit on " + parentEntity.toString());

    // ------------------------------------------
    // null out the LowVoltageLimit on the parent entithy
    // ------------------------------------------
    parentEntity.setLowVoltageLimit(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the VoltageLevel
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	VoltageLevel
   */
  public VoltageLevel addToVoltageLevel(UUID parentId, VoltageLevel addTo) {
    LOGGER.info("handling AssignVoltageLevelToVoltageLevelEvent - ");

    VoltageLevel parentEntity = repository.findById(parentId).get();
    VoltageLevel child = VoltageLevelProjector.find(addTo.getVoltageLevelId());

    parentEntity.getVoltageLevel().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the VoltageLevel
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	VoltageLevel
   */
  public VoltageLevel removeFromVoltageLevel(UUID parentId, VoltageLevel removeFrom) {
    LOGGER.info("handling RemoveVoltageLevelFromVoltageLevelEvent ");

    VoltageLevel parentEntity = repository.findById(parentId).get();
    VoltageLevel child = VoltageLevelProjector.find(removeFrom.getVoltageLevelId());

    parentEntity.getVoltageLevel().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the VoltageLevels
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	VoltageLevel
   */
  public VoltageLevel addToVoltageLevels(UUID parentId, VoltageLevel addTo) {
    LOGGER.info("handling AssignVoltageLevelsToVoltageLevelEvent - ");

    VoltageLevel parentEntity = repository.findById(parentId).get();
    VoltageLevel child = VoltageLevelProjector.find(addTo.getVoltageLevelId());

    parentEntity.getVoltageLevels().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the VoltageLevels
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	VoltageLevel
   */
  public VoltageLevel removeFromVoltageLevels(UUID parentId, VoltageLevel removeFrom) {
    LOGGER.info("handling RemoveVoltageLevelsFromVoltageLevelEvent ");

    VoltageLevel parentEntity = repository.findById(parentId).get();
    VoltageLevel child = VoltageLevelProjector.find(removeFrom.getVoltageLevelId());

    parentEntity.getVoltageLevels().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the VoltageLevel via an FindVoltageLevelQuery
   *
   * @return query FindVoltageLevelQuery
   */
  @SuppressWarnings("unused")
  public VoltageLevel find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a VoltageLevel - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all VoltageLevels
   *
   * @param query FindAllVoltageLevelQuery
   * @return List<VoltageLevel>
   */
  @SuppressWarnings("unused")
  public List<VoltageLevel> findAll(FindAllVoltageLevelQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all VoltageLevel - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final VoltageLevelRepository repository;

  @Autowired
  @Qualifier(value = "voltage-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .VoltageEntityProjector
      VoltageProjector;

  @Autowired
  @Qualifier(value = "voltageLevel-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.projector
          .VoltageLevelEntityProjector
      VoltageLevelProjector;

  private static final Logger LOGGER =
      Logger.getLogger(VoltageLevelEntityProjector.class.getName());
}
