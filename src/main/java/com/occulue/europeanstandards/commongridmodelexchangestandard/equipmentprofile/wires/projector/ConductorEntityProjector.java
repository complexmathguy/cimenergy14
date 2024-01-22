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
 * Projector for Conductor as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ConductorAggregate
 *
 * @author your_name_here
 */
@Component("conductor-entity-projector")
public class ConductorEntityProjector {

  // core constructor
  public ConductorEntityProjector(ConductorRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Conductor
   *
   * @param	entity Conductor
   */
  public Conductor create(Conductor entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Conductor
   *
   * @param	entity Conductor
   */
  public Conductor update(Conductor entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Conductor
   *
   * @param	id		UUID
   */
  public Conductor delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Conductor entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Length
   *
   * @param	parentId	UUID
   * @param	assignment 	Length
   * @return	Conductor
   */
  public Conductor assignLength(UUID parentId, Length assignment) {
    LOGGER.info("assigning Length as " + assignment.toString());

    Conductor parentEntity = repository.findById(parentId).get();
    assignment = LengthProjector.find(assignment.getLengthId());

    // ------------------------------------------
    // assign the Length to the parent entity
    // ------------------------------------------
    parentEntity.setLength(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Length
   *
   * @param	parentId		UUID
   * @return	Conductor
   */
  public Conductor unAssignLength(UUID parentId) {
    Conductor parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Length on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Length on the parent entithy
    // ------------------------------------------
    parentEntity.setLength(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Conductor via an FindConductorQuery
   *
   * @return query FindConductorQuery
   */
  @SuppressWarnings("unused")
  public Conductor find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Conductor - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Conductors
   *
   * @param query FindAllConductorQuery
   * @return List<Conductor>
   */
  @SuppressWarnings("unused")
  public List<Conductor> findAll(FindAllConductorQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Conductor - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ConductorRepository repository;

  @Autowired
  @Qualifier(value = "length-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .LengthEntityProjector
      LengthProjector;

  private static final Logger LOGGER = Logger.getLogger(ConductorEntityProjector.class.getName());
}
