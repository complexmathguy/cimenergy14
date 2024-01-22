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
 * Projector for DCShunt as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DCShuntAggregate
 *
 * @author your_name_here
 */
@Component("dCShunt-entity-projector")
public class DCShuntEntityProjector {

  // core constructor
  public DCShuntEntityProjector(DCShuntRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DCShunt
   *
   * @param	entity DCShunt
   */
  public DCShunt create(DCShunt entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DCShunt
   *
   * @param	entity DCShunt
   */
  public DCShunt update(DCShunt entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DCShunt
   *
   * @param	id		UUID
   */
  public DCShunt delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DCShunt entity = repository.findById(id).get();

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
   * @param	assignment 	Capacitance
   * @return	DCShunt
   */
  public DCShunt assignCapacitance(UUID parentId, Capacitance assignment) {
    LOGGER.info("assigning Capacitance as " + assignment.toString());

    DCShunt parentEntity = repository.findById(parentId).get();
    assignment = CapacitanceProjector.find(assignment.getCapacitanceId());

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
   * @return	DCShunt
   */
  public DCShunt unAssignCapacitance(UUID parentId) {
    DCShunt parentEntity = repository.findById(parentId).get();

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
   * Assign a RatedUdc
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	DCShunt
   */
  public DCShunt assignRatedUdc(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning RatedUdc as " + assignment.toString());

    DCShunt parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the RatedUdc to the parent entity
    // ------------------------------------------
    parentEntity.setRatedUdc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RatedUdc
   *
   * @param	parentId		UUID
   * @return	DCShunt
   */
  public DCShunt unAssignRatedUdc(UUID parentId) {
    DCShunt parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RatedUdc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RatedUdc on the parent entithy
    // ------------------------------------------
    parentEntity.setRatedUdc(null);

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
   * @param	assignment 	Resistance
   * @return	DCShunt
   */
  public DCShunt assignResistance(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning Resistance as " + assignment.toString());

    DCShunt parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

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
   * @return	DCShunt
   */
  public DCShunt unAssignResistance(UUID parentId) {
    DCShunt parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the DCShunt via an FindDCShuntQuery
   *
   * @return query FindDCShuntQuery
   */
  @SuppressWarnings("unused")
  public DCShunt find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DCShunt - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DCShunts
   *
   * @param query FindAllDCShuntQuery
   * @return List<DCShunt>
   */
  @SuppressWarnings("unused")
  public List<DCShunt> findAll(FindAllDCShuntQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DCShunt - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DCShuntRepository repository;

  @Autowired
  @Qualifier(value = "capacitance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .CapacitanceEntityProjector
      CapacitanceProjector;

  @Autowired
  @Qualifier(value = "voltage-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .VoltageEntityProjector
      VoltageProjector;

  @Autowired
  @Qualifier(value = "resistance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ResistanceEntityProjector
      ResistanceProjector;

  private static final Logger LOGGER = Logger.getLogger(DCShuntEntityProjector.class.getName());
}
