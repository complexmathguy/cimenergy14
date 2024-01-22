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
 * Projector for NonlinearShuntCompensatorPoint as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by NonlinearShuntCompensatorPointAggregate
 *
 * @author your_name_here
 */
@Component("nonlinearShuntCompensatorPoint-entity-projector")
public class NonlinearShuntCompensatorPointEntityProjector {

  // core constructor
  public NonlinearShuntCompensatorPointEntityProjector(
      NonlinearShuntCompensatorPointRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a NonlinearShuntCompensatorPoint
   *
   * @param	entity NonlinearShuntCompensatorPoint
   */
  public NonlinearShuntCompensatorPoint create(NonlinearShuntCompensatorPoint entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a NonlinearShuntCompensatorPoint
   *
   * @param	entity NonlinearShuntCompensatorPoint
   */
  public NonlinearShuntCompensatorPoint update(NonlinearShuntCompensatorPoint entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a NonlinearShuntCompensatorPoint
   *
   * @param	id		UUID
   */
  public NonlinearShuntCompensatorPoint delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    NonlinearShuntCompensatorPoint entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a B
   *
   * @param	parentId	UUID
   * @param	assignment 	Susceptance
   * @return	NonlinearShuntCompensatorPoint
   */
  public NonlinearShuntCompensatorPoint assignB(UUID parentId, Susceptance assignment) {
    LOGGER.info("assigning B as " + assignment.toString());

    NonlinearShuntCompensatorPoint parentEntity = repository.findById(parentId).get();
    assignment = SusceptanceProjector.find(assignment.getSusceptanceId());

    // ------------------------------------------
    // assign the B to the parent entity
    // ------------------------------------------
    parentEntity.setB(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B
   *
   * @param	parentId		UUID
   * @return	NonlinearShuntCompensatorPoint
   */
  public NonlinearShuntCompensatorPoint unAssignB(UUID parentId) {
    NonlinearShuntCompensatorPoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B on the parent entithy
    // ------------------------------------------
    parentEntity.setB(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a B0
   *
   * @param	parentId	UUID
   * @param	assignment 	Susceptance
   * @return	NonlinearShuntCompensatorPoint
   */
  public NonlinearShuntCompensatorPoint assignB0(UUID parentId, Susceptance assignment) {
    LOGGER.info("assigning B0 as " + assignment.toString());

    NonlinearShuntCompensatorPoint parentEntity = repository.findById(parentId).get();
    assignment = SusceptanceProjector.find(assignment.getSusceptanceId());

    // ------------------------------------------
    // assign the B0 to the parent entity
    // ------------------------------------------
    parentEntity.setB0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B0
   *
   * @param	parentId		UUID
   * @return	NonlinearShuntCompensatorPoint
   */
  public NonlinearShuntCompensatorPoint unAssignB0(UUID parentId) {
    NonlinearShuntCompensatorPoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B0 on the parent entithy
    // ------------------------------------------
    parentEntity.setB0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a G
   *
   * @param	parentId	UUID
   * @param	assignment 	Conductance
   * @return	NonlinearShuntCompensatorPoint
   */
  public NonlinearShuntCompensatorPoint assignG(UUID parentId, Conductance assignment) {
    LOGGER.info("assigning G as " + assignment.toString());

    NonlinearShuntCompensatorPoint parentEntity = repository.findById(parentId).get();
    assignment = ConductanceProjector.find(assignment.getConductanceId());

    // ------------------------------------------
    // assign the G to the parent entity
    // ------------------------------------------
    parentEntity.setG(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the G
   *
   * @param	parentId		UUID
   * @return	NonlinearShuntCompensatorPoint
   */
  public NonlinearShuntCompensatorPoint unAssignG(UUID parentId) {
    NonlinearShuntCompensatorPoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning G on " + parentEntity.toString());

    // ------------------------------------------
    // null out the G on the parent entithy
    // ------------------------------------------
    parentEntity.setG(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a G0
   *
   * @param	parentId	UUID
   * @param	assignment 	Conductance
   * @return	NonlinearShuntCompensatorPoint
   */
  public NonlinearShuntCompensatorPoint assignG0(UUID parentId, Conductance assignment) {
    LOGGER.info("assigning G0 as " + assignment.toString());

    NonlinearShuntCompensatorPoint parentEntity = repository.findById(parentId).get();
    assignment = ConductanceProjector.find(assignment.getConductanceId());

    // ------------------------------------------
    // assign the G0 to the parent entity
    // ------------------------------------------
    parentEntity.setG0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the G0
   *
   * @param	parentId		UUID
   * @return	NonlinearShuntCompensatorPoint
   */
  public NonlinearShuntCompensatorPoint unAssignG0(UUID parentId) {
    NonlinearShuntCompensatorPoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning G0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the G0 on the parent entithy
    // ------------------------------------------
    parentEntity.setG0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SectionNumber
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	NonlinearShuntCompensatorPoint
   */
  public NonlinearShuntCompensatorPoint assignSectionNumber(
      UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning SectionNumber as " + assignment.toString());

    NonlinearShuntCompensatorPoint parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the SectionNumber to the parent entity
    // ------------------------------------------
    parentEntity.setSectionNumber(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SectionNumber
   *
   * @param	parentId		UUID
   * @return	NonlinearShuntCompensatorPoint
   */
  public NonlinearShuntCompensatorPoint unAssignSectionNumber(UUID parentId) {
    NonlinearShuntCompensatorPoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SectionNumber on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SectionNumber on the parent entithy
    // ------------------------------------------
    parentEntity.setSectionNumber(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the NonlinearShuntCompensatorPoints
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	NonlinearShuntCompensatorPoint
   */
  public NonlinearShuntCompensatorPoint addToNonlinearShuntCompensatorPoints(
      UUID parentId, NonlinearShuntCompensatorPoint addTo) {
    LOGGER.info(
        "handling AssignNonlinearShuntCompensatorPointsToNonlinearShuntCompensatorPointEvent - ");

    NonlinearShuntCompensatorPoint parentEntity = repository.findById(parentId).get();
    NonlinearShuntCompensatorPoint child =
        NonlinearShuntCompensatorPointProjector.find(addTo.getNonlinearShuntCompensatorPointId());

    parentEntity.getNonlinearShuntCompensatorPoints().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the NonlinearShuntCompensatorPoints
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	NonlinearShuntCompensatorPoint
   */
  public NonlinearShuntCompensatorPoint removeFromNonlinearShuntCompensatorPoints(
      UUID parentId, NonlinearShuntCompensatorPoint removeFrom) {
    LOGGER.info(
        "handling RemoveNonlinearShuntCompensatorPointsFromNonlinearShuntCompensatorPointEvent ");

    NonlinearShuntCompensatorPoint parentEntity = repository.findById(parentId).get();
    NonlinearShuntCompensatorPoint child =
        NonlinearShuntCompensatorPointProjector.find(
            removeFrom.getNonlinearShuntCompensatorPointId());

    parentEntity.getNonlinearShuntCompensatorPoints().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the NonlinearShuntCompensatorPoint via an
   * FindNonlinearShuntCompensatorPointQuery
   *
   * @return query FindNonlinearShuntCompensatorPointQuery
   */
  @SuppressWarnings("unused")
  public NonlinearShuntCompensatorPoint find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a NonlinearShuntCompensatorPoint - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all NonlinearShuntCompensatorPoints
   *
   * @param query FindAllNonlinearShuntCompensatorPointQuery
   * @return List<NonlinearShuntCompensatorPoint>
   */
  @SuppressWarnings("unused")
  public List<NonlinearShuntCompensatorPoint> findAll(
      FindAllNonlinearShuntCompensatorPointQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find all NonlinearShuntCompensatorPoint - {0}",
          exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final NonlinearShuntCompensatorPointRepository repository;

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

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "nonlinearShuntCompensatorPoint-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .NonlinearShuntCompensatorPointEntityProjector
      NonlinearShuntCompensatorPointProjector;

  private static final Logger LOGGER =
      Logger.getLogger(NonlinearShuntCompensatorPointEntityProjector.class.getName());
}
