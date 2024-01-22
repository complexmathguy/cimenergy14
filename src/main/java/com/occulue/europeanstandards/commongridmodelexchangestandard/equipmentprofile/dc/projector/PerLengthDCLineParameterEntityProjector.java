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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for PerLengthDCLineParameter as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PerLengthDCLineParameterAggregate
 *
 * @author your_name_here
 */
@Component("perLengthDCLineParameter-entity-projector")
public class PerLengthDCLineParameterEntityProjector {

  // core constructor
  public PerLengthDCLineParameterEntityProjector(PerLengthDCLineParameterRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PerLengthDCLineParameter
   *
   * @param	entity PerLengthDCLineParameter
   */
  public PerLengthDCLineParameter create(PerLengthDCLineParameter entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PerLengthDCLineParameter
   *
   * @param	entity PerLengthDCLineParameter
   */
  public PerLengthDCLineParameter update(PerLengthDCLineParameter entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PerLengthDCLineParameter
   *
   * @param	id		UUID
   */
  public PerLengthDCLineParameter delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PerLengthDCLineParameter entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Capacitance
   *
   * @param	parentId	UUID
   * @param	assignment 	CapacitancePerLength
   * @return	PerLengthDCLineParameter
   */
  public PerLengthDCLineParameter assignCapacitance(
      UUID parentId, CapacitancePerLength assignment) {
    LOGGER.info("assigning Capacitance as " + assignment.toString());

    PerLengthDCLineParameter parentEntity = repository.findById(parentId).get();
    assignment = CapacitancePerLengthProjector.find(assignment.getCapacitancePerLengthId());

    // ------------------------------------------
    // assign the Capacitance to the parent entity
    // ------------------------------------------
    parentEntity.setCapacitance(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Capacitance
   *
   * @param	parentId		UUID
   * @return	PerLengthDCLineParameter
   */
  public PerLengthDCLineParameter unAssignCapacitance(UUID parentId) {
    PerLengthDCLineParameter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Capacitance on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Capacitance on the parent entithy
    // ------------------------------------------
    parentEntity.setCapacitance(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Inductance
   *
   * @param	parentId	UUID
   * @param	assignment 	InductancePerLength
   * @return	PerLengthDCLineParameter
   */
  public PerLengthDCLineParameter assignInductance(UUID parentId, InductancePerLength assignment) {
    LOGGER.info("assigning Inductance as " + assignment.toString());

    PerLengthDCLineParameter parentEntity = repository.findById(parentId).get();
    assignment = InductancePerLengthProjector.find(assignment.getInductancePerLengthId());

    // ------------------------------------------
    // assign the Inductance to the parent entity
    // ------------------------------------------
    parentEntity.setInductance(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Inductance
   *
   * @param	parentId		UUID
   * @return	PerLengthDCLineParameter
   */
  public PerLengthDCLineParameter unAssignInductance(UUID parentId) {
    PerLengthDCLineParameter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Inductance on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Inductance on the parent entithy
    // ------------------------------------------
    parentEntity.setInductance(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Resistance
   *
   * @param	parentId	UUID
   * @param	assignment 	ResistancePerLength
   * @return	PerLengthDCLineParameter
   */
  public PerLengthDCLineParameter assignResistance(UUID parentId, ResistancePerLength assignment) {
    LOGGER.info("assigning Resistance as " + assignment.toString());

    PerLengthDCLineParameter parentEntity = repository.findById(parentId).get();
    assignment = ResistancePerLengthProjector.find(assignment.getResistancePerLengthId());

    // ------------------------------------------
    // assign the Resistance to the parent entity
    // ------------------------------------------
    parentEntity.setResistance(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Resistance
   *
   * @param	parentId		UUID
   * @return	PerLengthDCLineParameter
   */
  public PerLengthDCLineParameter unAssignResistance(UUID parentId) {
    PerLengthDCLineParameter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Resistance on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Resistance on the parent entithy
    // ------------------------------------------
    parentEntity.setResistance(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PerLengthDCLineParameter via an FindPerLengthDCLineParameterQuery
   *
   * @return query FindPerLengthDCLineParameterQuery
   */
  @SuppressWarnings("unused")
  public PerLengthDCLineParameter find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a PerLengthDCLineParameter - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PerLengthDCLineParameters
   *
   * @param query FindAllPerLengthDCLineParameterQuery
   * @return List<PerLengthDCLineParameter>
   */
  @SuppressWarnings("unused")
  public List<PerLengthDCLineParameter> findAll(FindAllPerLengthDCLineParameterQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all PerLengthDCLineParameter - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PerLengthDCLineParameterRepository repository;

  @Autowired
  @Qualifier(value = "capacitancePerLength-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .CapacitancePerLengthEntityProjector
      CapacitancePerLengthProjector;

  @Autowired
  @Qualifier(value = "inductancePerLength-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .InductancePerLengthEntityProjector
      InductancePerLengthProjector;

  @Autowired
  @Qualifier(value = "resistancePerLength-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ResistancePerLengthEntityProjector
      ResistancePerLengthProjector;

  private static final Logger LOGGER =
      Logger.getLogger(PerLengthDCLineParameterEntityProjector.class.getName());
}
