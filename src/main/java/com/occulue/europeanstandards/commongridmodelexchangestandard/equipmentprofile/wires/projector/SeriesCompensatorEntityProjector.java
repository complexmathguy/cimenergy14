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
 * Projector for SeriesCompensator as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SeriesCompensatorAggregate
 *
 * @author your_name_here
 */
@Component("seriesCompensator-entity-projector")
public class SeriesCompensatorEntityProjector {

  // core constructor
  public SeriesCompensatorEntityProjector(SeriesCompensatorRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a SeriesCompensator
   *
   * @param	entity SeriesCompensator
   */
  public SeriesCompensator create(SeriesCompensator entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a SeriesCompensator
   *
   * @param	entity SeriesCompensator
   */
  public SeriesCompensator update(SeriesCompensator entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a SeriesCompensator
   *
   * @param	id		UUID
   */
  public SeriesCompensator delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    SeriesCompensator entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a R
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	SeriesCompensator
   */
  public SeriesCompensator assignR(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning R as " + assignment.toString());

    SeriesCompensator parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the R to the parent entity
    // ------------------------------------------
    parentEntity.setR(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R
   *
   * @param	parentId		UUID
   * @return	SeriesCompensator
   */
  public SeriesCompensator unAssignR(UUID parentId) {
    SeriesCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R on the parent entithy
    // ------------------------------------------
    parentEntity.setR(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a R0
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	SeriesCompensator
   */
  public SeriesCompensator assignR0(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning R0 as " + assignment.toString());

    SeriesCompensator parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the R0 to the parent entity
    // ------------------------------------------
    parentEntity.setR0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R0
   *
   * @param	parentId		UUID
   * @return	SeriesCompensator
   */
  public SeriesCompensator unAssignR0(UUID parentId) {
    SeriesCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R0 on the parent entithy
    // ------------------------------------------
    parentEntity.setR0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a VaristorPresent
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	SeriesCompensator
   */
  public SeriesCompensator assignVaristorPresent(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning VaristorPresent as " + assignment.toString());

    SeriesCompensator parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the VaristorPresent to the parent entity
    // ------------------------------------------
    parentEntity.setVaristorPresent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the VaristorPresent
   *
   * @param	parentId		UUID
   * @return	SeriesCompensator
   */
  public SeriesCompensator unAssignVaristorPresent(UUID parentId) {
    SeriesCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning VaristorPresent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the VaristorPresent on the parent entithy
    // ------------------------------------------
    parentEntity.setVaristorPresent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a VaristorRatedCurrent
   *
   * @param	parentId	UUID
   * @param	assignment 	CurrentFlow
   * @return	SeriesCompensator
   */
  public SeriesCompensator assignVaristorRatedCurrent(UUID parentId, CurrentFlow assignment) {
    LOGGER.info("assigning VaristorRatedCurrent as " + assignment.toString());

    SeriesCompensator parentEntity = repository.findById(parentId).get();
    assignment = CurrentFlowProjector.find(assignment.getCurrentFlowId());

    // ------------------------------------------
    // assign the VaristorRatedCurrent to the parent entity
    // ------------------------------------------
    parentEntity.setVaristorRatedCurrent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the VaristorRatedCurrent
   *
   * @param	parentId		UUID
   * @return	SeriesCompensator
   */
  public SeriesCompensator unAssignVaristorRatedCurrent(UUID parentId) {
    SeriesCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning VaristorRatedCurrent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the VaristorRatedCurrent on the parent entithy
    // ------------------------------------------
    parentEntity.setVaristorRatedCurrent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a VaristorVoltageThreshold
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	SeriesCompensator
   */
  public SeriesCompensator assignVaristorVoltageThreshold(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning VaristorVoltageThreshold as " + assignment.toString());

    SeriesCompensator parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the VaristorVoltageThreshold to the parent entity
    // ------------------------------------------
    parentEntity.setVaristorVoltageThreshold(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the VaristorVoltageThreshold
   *
   * @param	parentId		UUID
   * @return	SeriesCompensator
   */
  public SeriesCompensator unAssignVaristorVoltageThreshold(UUID parentId) {
    SeriesCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning VaristorVoltageThreshold on " + parentEntity.toString());

    // ------------------------------------------
    // null out the VaristorVoltageThreshold on the parent entithy
    // ------------------------------------------
    parentEntity.setVaristorVoltageThreshold(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a X
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	SeriesCompensator
   */
  public SeriesCompensator assignX(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning X as " + assignment.toString());

    SeriesCompensator parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the X to the parent entity
    // ------------------------------------------
    parentEntity.setX(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X
   *
   * @param	parentId		UUID
   * @return	SeriesCompensator
   */
  public SeriesCompensator unAssignX(UUID parentId) {
    SeriesCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X on the parent entithy
    // ------------------------------------------
    parentEntity.setX(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a X0
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	SeriesCompensator
   */
  public SeriesCompensator assignX0(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning X0 as " + assignment.toString());

    SeriesCompensator parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the X0 to the parent entity
    // ------------------------------------------
    parentEntity.setX0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X0
   *
   * @param	parentId		UUID
   * @return	SeriesCompensator
   */
  public SeriesCompensator unAssignX0(UUID parentId) {
    SeriesCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X0 on the parent entithy
    // ------------------------------------------
    parentEntity.setX0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the SeriesCompensator via an FindSeriesCompensatorQuery
   *
   * @return query FindSeriesCompensatorQuery
   */
  @SuppressWarnings("unused")
  public SeriesCompensator find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a SeriesCompensator - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all SeriesCompensators
   *
   * @param query FindAllSeriesCompensatorQuery
   * @return List<SeriesCompensator>
   */
  @SuppressWarnings("unused")
  public List<SeriesCompensator> findAll(FindAllSeriesCompensatorQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all SeriesCompensator - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SeriesCompensatorRepository repository;

  @Autowired
  @Qualifier(value = "resistance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ResistanceEntityProjector
      ResistanceProjector;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "currentFlow-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .CurrentFlowEntityProjector
      CurrentFlowProjector;

  @Autowired
  @Qualifier(value = "voltage-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .VoltageEntityProjector
      VoltageProjector;

  @Autowired
  @Qualifier(value = "reactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactanceEntityProjector
      ReactanceProjector;

  private static final Logger LOGGER =
      Logger.getLogger(SeriesCompensatorEntityProjector.class.getName());
}
