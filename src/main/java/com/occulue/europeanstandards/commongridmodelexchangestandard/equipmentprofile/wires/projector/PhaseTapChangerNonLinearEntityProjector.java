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
 * Projector for PhaseTapChangerNonLinear as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PhaseTapChangerNonLinearAggregate
 *
 * @author your_name_here
 */
@Component("phaseTapChangerNonLinear-entity-projector")
public class PhaseTapChangerNonLinearEntityProjector {

  // core constructor
  public PhaseTapChangerNonLinearEntityProjector(PhaseTapChangerNonLinearRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PhaseTapChangerNonLinear
   *
   * @param	entity PhaseTapChangerNonLinear
   */
  public PhaseTapChangerNonLinear create(PhaseTapChangerNonLinear entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PhaseTapChangerNonLinear
   *
   * @param	entity PhaseTapChangerNonLinear
   */
  public PhaseTapChangerNonLinear update(PhaseTapChangerNonLinear entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PhaseTapChangerNonLinear
   *
   * @param	id		UUID
   */
  public PhaseTapChangerNonLinear delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PhaseTapChangerNonLinear entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a VoltageStepIncrement
   *
   * @param	parentId	UUID
   * @param	assignment 	PerCent
   * @return	PhaseTapChangerNonLinear
   */
  public PhaseTapChangerNonLinear assignVoltageStepIncrement(UUID parentId, PerCent assignment) {
    LOGGER.info("assigning VoltageStepIncrement as " + assignment.toString());

    PhaseTapChangerNonLinear parentEntity = repository.findById(parentId).get();
    assignment = PerCentProjector.find(assignment.getPerCentId());

    // ------------------------------------------
    // assign the VoltageStepIncrement to the parent entity
    // ------------------------------------------
    parentEntity.setVoltageStepIncrement(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the VoltageStepIncrement
   *
   * @param	parentId		UUID
   * @return	PhaseTapChangerNonLinear
   */
  public PhaseTapChangerNonLinear unAssignVoltageStepIncrement(UUID parentId) {
    PhaseTapChangerNonLinear parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning VoltageStepIncrement on " + parentEntity.toString());

    // ------------------------------------------
    // null out the VoltageStepIncrement on the parent entithy
    // ------------------------------------------
    parentEntity.setVoltageStepIncrement(null);

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
   * @return	PhaseTapChangerNonLinear
   */
  public PhaseTapChangerNonLinear assignXMax(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning XMax as " + assignment.toString());

    PhaseTapChangerNonLinear parentEntity = repository.findById(parentId).get();
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
   * @return	PhaseTapChangerNonLinear
   */
  public PhaseTapChangerNonLinear unAssignXMax(UUID parentId) {
    PhaseTapChangerNonLinear parentEntity = repository.findById(parentId).get();

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
   * @return	PhaseTapChangerNonLinear
   */
  public PhaseTapChangerNonLinear assignXMin(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning XMin as " + assignment.toString());

    PhaseTapChangerNonLinear parentEntity = repository.findById(parentId).get();
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
   * @return	PhaseTapChangerNonLinear
   */
  public PhaseTapChangerNonLinear unAssignXMin(UUID parentId) {
    PhaseTapChangerNonLinear parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the PhaseTapChangerNonLinear via an FindPhaseTapChangerNonLinearQuery
   *
   * @return query FindPhaseTapChangerNonLinearQuery
   */
  @SuppressWarnings("unused")
  public PhaseTapChangerNonLinear find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a PhaseTapChangerNonLinear - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PhaseTapChangerNonLinears
   *
   * @param query FindAllPhaseTapChangerNonLinearQuery
   * @return List<PhaseTapChangerNonLinear>
   */
  @SuppressWarnings("unused")
  public List<PhaseTapChangerNonLinear> findAll(FindAllPhaseTapChangerNonLinearQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all PhaseTapChangerNonLinear - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PhaseTapChangerNonLinearRepository repository;

  @Autowired
  @Qualifier(value = "perCent-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PerCentEntityProjector
      PerCentProjector;

  @Autowired
  @Qualifier(value = "reactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactanceEntityProjector
      ReactanceProjector;

  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerNonLinearEntityProjector.class.getName());
}
