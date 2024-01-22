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
 * Projector for ControlArea as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ControlAreaAggregate
 *
 * @author your_name_here
 */
@Component("controlArea-entity-projector")
public class ControlAreaEntityProjector {

  // core constructor
  public ControlAreaEntityProjector(ControlAreaRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ControlArea
   *
   * @param	entity ControlArea
   */
  public ControlArea create(ControlArea entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ControlArea
   *
   * @param	entity ControlArea
   */
  public ControlArea update(ControlArea entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ControlArea
   *
   * @param	id		UUID
   */
  public ControlArea delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ControlArea entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a ControlArea
   *
   * @param	parentId	UUID
   * @param	assignment 	ControlArea
   * @return	ControlArea
   */
  public ControlArea assignControlArea(UUID parentId, ControlArea assignment) {
    LOGGER.info("assigning ControlArea as " + assignment.toString());

    ControlArea parentEntity = repository.findById(parentId).get();
    assignment = ControlAreaProjector.find(assignment.getControlAreaId());

    // ------------------------------------------
    // assign the ControlArea to the parent entity
    // ------------------------------------------
    parentEntity.setControlArea(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ControlArea
   *
   * @param	parentId		UUID
   * @return	ControlArea
   */
  public ControlArea unAssignControlArea(UUID parentId) {
    ControlArea parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ControlArea on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ControlArea on the parent entithy
    // ------------------------------------------
    parentEntity.setControlArea(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ControlArea via an FindControlAreaQuery
   *
   * @return query FindControlAreaQuery
   */
  @SuppressWarnings("unused")
  public ControlArea find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ControlArea - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ControlAreas
   *
   * @param query FindAllControlAreaQuery
   * @return List<ControlArea>
   */
  @SuppressWarnings("unused")
  public List<ControlArea> findAll(FindAllControlAreaQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ControlArea - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ControlAreaRepository repository;

  @Autowired
  @Qualifier(value = "controlArea-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea
          .projector.ControlAreaEntityProjector
      ControlAreaProjector;

  private static final Logger LOGGER = Logger.getLogger(ControlAreaEntityProjector.class.getName());
}
