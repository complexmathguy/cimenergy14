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
 * Projector for DCSeriesDevice as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DCSeriesDeviceAggregate
 *
 * @author your_name_here
 */
@Component("dCSeriesDevice-entity-projector")
public class DCSeriesDeviceEntityProjector {

  // core constructor
  public DCSeriesDeviceEntityProjector(DCSeriesDeviceRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DCSeriesDevice
   *
   * @param	entity DCSeriesDevice
   */
  public DCSeriesDevice create(DCSeriesDevice entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DCSeriesDevice
   *
   * @param	entity DCSeriesDevice
   */
  public DCSeriesDevice update(DCSeriesDevice entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DCSeriesDevice
   *
   * @param	id		UUID
   */
  public DCSeriesDevice delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DCSeriesDevice entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Inductance
   *
   * @param	parentId	UUID
   * @param	assignment 	Inductance
   * @return	DCSeriesDevice
   */
  public DCSeriesDevice assignInductance(UUID parentId, Inductance assignment) {
    LOGGER.info("assigning Inductance as " + assignment.toString());

    DCSeriesDevice parentEntity = repository.findById(parentId).get();
    assignment = InductanceProjector.find(assignment.getInductanceId());

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
   * @return	DCSeriesDevice
   */
  public DCSeriesDevice unAssignInductance(UUID parentId) {
    DCSeriesDevice parentEntity = repository.findById(parentId).get();

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
   * Assign a RatedUdc
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	DCSeriesDevice
   */
  public DCSeriesDevice assignRatedUdc(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning RatedUdc as " + assignment.toString());

    DCSeriesDevice parentEntity = repository.findById(parentId).get();
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
   * @return	DCSeriesDevice
   */
  public DCSeriesDevice unAssignRatedUdc(UUID parentId) {
    DCSeriesDevice parentEntity = repository.findById(parentId).get();

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
   * @return	DCSeriesDevice
   */
  public DCSeriesDevice assignResistance(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning Resistance as " + assignment.toString());

    DCSeriesDevice parentEntity = repository.findById(parentId).get();
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
   * @return	DCSeriesDevice
   */
  public DCSeriesDevice unAssignResistance(UUID parentId) {
    DCSeriesDevice parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the DCSeriesDevice via an FindDCSeriesDeviceQuery
   *
   * @return query FindDCSeriesDeviceQuery
   */
  @SuppressWarnings("unused")
  public DCSeriesDevice find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DCSeriesDevice - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DCSeriesDevices
   *
   * @param query FindAllDCSeriesDeviceQuery
   * @return List<DCSeriesDevice>
   */
  @SuppressWarnings("unused")
  public List<DCSeriesDevice> findAll(FindAllDCSeriesDeviceQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DCSeriesDevice - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DCSeriesDeviceRepository repository;

  @Autowired
  @Qualifier(value = "inductance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .InductanceEntityProjector
      InductanceProjector;

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

  private static final Logger LOGGER =
      Logger.getLogger(DCSeriesDeviceEntityProjector.class.getName());
}
