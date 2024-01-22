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
 * Projector for PhaseTapChangerLinear as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PhaseTapChangerLinearAggregate
 *
 * @author your_name_here
 */
@Component("phaseTapChangerLinear-entity-projector")
public class PhaseTapChangerLinearEntityProjector {

  // core constructor
  public PhaseTapChangerLinearEntityProjector(PhaseTapChangerLinearRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PhaseTapChangerLinear
   *
   * @param	entity PhaseTapChangerLinear
   */
  public PhaseTapChangerLinear create(PhaseTapChangerLinear entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PhaseTapChangerLinear
   *
   * @param	entity PhaseTapChangerLinear
   */
  public PhaseTapChangerLinear update(PhaseTapChangerLinear entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PhaseTapChangerLinear
   *
   * @param	id		UUID
   */
  public PhaseTapChangerLinear delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PhaseTapChangerLinear entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a StepPhaseShiftIncrement
   *
   * @param	parentId	UUID
   * @param	assignment 	AngleDegrees
   * @return	PhaseTapChangerLinear
   */
  public PhaseTapChangerLinear assignStepPhaseShiftIncrement(
      UUID parentId, AngleDegrees assignment) {
    LOGGER.info("assigning StepPhaseShiftIncrement as " + assignment.toString());

    PhaseTapChangerLinear parentEntity = repository.findById(parentId).get();
    assignment = AngleDegreesProjector.find(assignment.getAngleDegreesId());

    // ------------------------------------------
    // assign the StepPhaseShiftIncrement to the parent entity
    // ------------------------------------------
    parentEntity.setStepPhaseShiftIncrement(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the StepPhaseShiftIncrement
   *
   * @param	parentId		UUID
   * @return	PhaseTapChangerLinear
   */
  public PhaseTapChangerLinear unAssignStepPhaseShiftIncrement(UUID parentId) {
    PhaseTapChangerLinear parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning StepPhaseShiftIncrement on " + parentEntity.toString());

    // ------------------------------------------
    // null out the StepPhaseShiftIncrement on the parent entithy
    // ------------------------------------------
    parentEntity.setStepPhaseShiftIncrement(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a XMax
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	PhaseTapChangerLinear
   */
  public PhaseTapChangerLinear assignXMax(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning XMax as " + assignment.toString());

    PhaseTapChangerLinear parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the XMax to the parent entity
    // ------------------------------------------
    parentEntity.setXMax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the XMax
   *
   * @param	parentId		UUID
   * @return	PhaseTapChangerLinear
   */
  public PhaseTapChangerLinear unAssignXMax(UUID parentId) {
    PhaseTapChangerLinear parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning XMax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the XMax on the parent entithy
    // ------------------------------------------
    parentEntity.setXMax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a XMin
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	PhaseTapChangerLinear
   */
  public PhaseTapChangerLinear assignXMin(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning XMin as " + assignment.toString());

    PhaseTapChangerLinear parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the XMin to the parent entity
    // ------------------------------------------
    parentEntity.setXMin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the XMin
   *
   * @param	parentId		UUID
   * @return	PhaseTapChangerLinear
   */
  public PhaseTapChangerLinear unAssignXMin(UUID parentId) {
    PhaseTapChangerLinear parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning XMin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the XMin on the parent entithy
    // ------------------------------------------
    parentEntity.setXMin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PhaseTapChangerLinear via an FindPhaseTapChangerLinearQuery
   *
   * @return query FindPhaseTapChangerLinearQuery
   */
  @SuppressWarnings("unused")
  public PhaseTapChangerLinear find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PhaseTapChangerLinear - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PhaseTapChangerLinears
   *
   * @param query FindAllPhaseTapChangerLinearQuery
   * @return List<PhaseTapChangerLinear>
   */
  @SuppressWarnings("unused")
  public List<PhaseTapChangerLinear> findAll(FindAllPhaseTapChangerLinearQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PhaseTapChangerLinear - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PhaseTapChangerLinearRepository repository;

  @Autowired
  @Qualifier(value = "angleDegrees-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .AngleDegreesEntityProjector
      AngleDegreesProjector;

  @Autowired
  @Qualifier(value = "reactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactanceEntityProjector
      ReactanceProjector;

  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerLinearEntityProjector.class.getName());
}
