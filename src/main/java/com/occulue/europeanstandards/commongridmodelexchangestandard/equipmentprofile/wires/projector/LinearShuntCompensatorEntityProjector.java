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
 * Projector for LinearShuntCompensator as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by LinearShuntCompensatorAggregate
 *
 * @author your_name_here
 */
@Component("linearShuntCompensator-entity-projector")
public class LinearShuntCompensatorEntityProjector {

  // core constructor
  public LinearShuntCompensatorEntityProjector(LinearShuntCompensatorRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a LinearShuntCompensator
   *
   * @param	entity LinearShuntCompensator
   */
  public LinearShuntCompensator create(LinearShuntCompensator entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a LinearShuntCompensator
   *
   * @param	entity LinearShuntCompensator
   */
  public LinearShuntCompensator update(LinearShuntCompensator entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a LinearShuntCompensator
   *
   * @param	id		UUID
   */
  public LinearShuntCompensator delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    LinearShuntCompensator entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a B0PerSection
   *
   * @param	parentId	UUID
   * @param	assignment 	Susceptance
   * @return	LinearShuntCompensator
   */
  public LinearShuntCompensator assignB0PerSection(UUID parentId, Susceptance assignment) {
    LOGGER.info("assigning B0PerSection as " + assignment.toString());

    LinearShuntCompensator parentEntity = repository.findById(parentId).get();
    assignment = SusceptanceProjector.find(assignment.getSusceptanceId());

    // ------------------------------------------
    // assign the B0PerSection to the parent entity
    // ------------------------------------------
    parentEntity.setB0PerSection(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B0PerSection
   *
   * @param	parentId		UUID
   * @return	LinearShuntCompensator
   */
  public LinearShuntCompensator unAssignB0PerSection(UUID parentId) {
    LinearShuntCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B0PerSection on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B0PerSection on the parent entithy
    // ------------------------------------------
    parentEntity.setB0PerSection(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a BPerSection
   *
   * @param	parentId	UUID
   * @param	assignment 	Susceptance
   * @return	LinearShuntCompensator
   */
  public LinearShuntCompensator assignBPerSection(UUID parentId, Susceptance assignment) {
    LOGGER.info("assigning BPerSection as " + assignment.toString());

    LinearShuntCompensator parentEntity = repository.findById(parentId).get();
    assignment = SusceptanceProjector.find(assignment.getSusceptanceId());

    // ------------------------------------------
    // assign the BPerSection to the parent entity
    // ------------------------------------------
    parentEntity.setBPerSection(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the BPerSection
   *
   * @param	parentId		UUID
   * @return	LinearShuntCompensator
   */
  public LinearShuntCompensator unAssignBPerSection(UUID parentId) {
    LinearShuntCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning BPerSection on " + parentEntity.toString());

    // ------------------------------------------
    // null out the BPerSection on the parent entithy
    // ------------------------------------------
    parentEntity.setBPerSection(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a G0PerSection
   *
   * @param	parentId	UUID
   * @param	assignment 	Conductance
   * @return	LinearShuntCompensator
   */
  public LinearShuntCompensator assignG0PerSection(UUID parentId, Conductance assignment) {
    LOGGER.info("assigning G0PerSection as " + assignment.toString());

    LinearShuntCompensator parentEntity = repository.findById(parentId).get();
    assignment = ConductanceProjector.find(assignment.getConductanceId());

    // ------------------------------------------
    // assign the G0PerSection to the parent entity
    // ------------------------------------------
    parentEntity.setG0PerSection(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the G0PerSection
   *
   * @param	parentId		UUID
   * @return	LinearShuntCompensator
   */
  public LinearShuntCompensator unAssignG0PerSection(UUID parentId) {
    LinearShuntCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning G0PerSection on " + parentEntity.toString());

    // ------------------------------------------
    // null out the G0PerSection on the parent entithy
    // ------------------------------------------
    parentEntity.setG0PerSection(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a GPerSection
   *
   * @param	parentId	UUID
   * @param	assignment 	Conductance
   * @return	LinearShuntCompensator
   */
  public LinearShuntCompensator assignGPerSection(UUID parentId, Conductance assignment) {
    LOGGER.info("assigning GPerSection as " + assignment.toString());

    LinearShuntCompensator parentEntity = repository.findById(parentId).get();
    assignment = ConductanceProjector.find(assignment.getConductanceId());

    // ------------------------------------------
    // assign the GPerSection to the parent entity
    // ------------------------------------------
    parentEntity.setGPerSection(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the GPerSection
   *
   * @param	parentId		UUID
   * @return	LinearShuntCompensator
   */
  public LinearShuntCompensator unAssignGPerSection(UUID parentId) {
    LinearShuntCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning GPerSection on " + parentEntity.toString());

    // ------------------------------------------
    // null out the GPerSection on the parent entithy
    // ------------------------------------------
    parentEntity.setGPerSection(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the LinearShuntCompensator via an FindLinearShuntCompensatorQuery
   *
   * @return query FindLinearShuntCompensatorQuery
   */
  @SuppressWarnings("unused")
  public LinearShuntCompensator find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a LinearShuntCompensator - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all LinearShuntCompensators
   *
   * @param query FindAllLinearShuntCompensatorQuery
   * @return List<LinearShuntCompensator>
   */
  @SuppressWarnings("unused")
  public List<LinearShuntCompensator> findAll(FindAllLinearShuntCompensatorQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all LinearShuntCompensator - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final LinearShuntCompensatorRepository repository;

  @Autowired
  @Qualifier(value = "susceptance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SusceptanceEntityProjector
      SusceptanceProjector;

  @Autowired
  @Qualifier(value = "conductance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ConductanceEntityProjector
      ConductanceProjector;

  private static final Logger LOGGER =
      Logger.getLogger(LinearShuntCompensatorEntityProjector.class.getName());
}
