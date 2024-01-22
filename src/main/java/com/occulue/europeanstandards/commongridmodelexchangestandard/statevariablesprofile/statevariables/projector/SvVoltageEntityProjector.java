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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for SvVoltage as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SvVoltageAggregate
 *
 * @author your_name_here
 */
@Component("svVoltage-entity-projector")
public class SvVoltageEntityProjector {

  // core constructor
  public SvVoltageEntityProjector(SvVoltageRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a SvVoltage
   *
   * @param	entity SvVoltage
   */
  public SvVoltage create(SvVoltage entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a SvVoltage
   *
   * @param	entity SvVoltage
   */
  public SvVoltage update(SvVoltage entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a SvVoltage
   *
   * @param	id		UUID
   */
  public SvVoltage delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    SvVoltage entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Angle
   *
   * @param	parentId	UUID
   * @param	assignment 	AngleDegrees
   * @return	SvVoltage
   */
  public SvVoltage assignAngle(UUID parentId, AngleDegrees assignment) {
    LOGGER.info("assigning Angle as " + assignment.toString());

    SvVoltage parentEntity = repository.findById(parentId).get();
    assignment = AngleDegreesProjector.find(assignment.getAngleDegreesId());

    // ------------------------------------------
    // assign the Angle to the parent entity
    // ------------------------------------------
    parentEntity.setAngle(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Angle
   *
   * @param	parentId		UUID
   * @return	SvVoltage
   */
  public SvVoltage unAssignAngle(UUID parentId) {
    SvVoltage parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Angle on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Angle on the parent entithy
    // ------------------------------------------
    parentEntity.setAngle(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a V
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	SvVoltage
   */
  public SvVoltage assignV(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning V as " + assignment.toString());

    SvVoltage parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the V to the parent entity
    // ------------------------------------------
    parentEntity.setV(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the V
   *
   * @param	parentId		UUID
   * @return	SvVoltage
   */
  public SvVoltage unAssignV(UUID parentId) {
    SvVoltage parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning V on " + parentEntity.toString());

    // ------------------------------------------
    // null out the V on the parent entithy
    // ------------------------------------------
    parentEntity.setV(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SvVoltage
   *
   * @param	parentId	UUID
   * @param	assignment 	SvVoltage
   * @return	SvVoltage
   */
  public SvVoltage assignSvVoltage(UUID parentId, SvVoltage assignment) {
    LOGGER.info("assigning SvVoltage as " + assignment.toString());

    SvVoltage parentEntity = repository.findById(parentId).get();
    assignment = SvVoltageProjector.find(assignment.getSvVoltageId());

    // ------------------------------------------
    // assign the SvVoltage to the parent entity
    // ------------------------------------------
    parentEntity.setSvVoltage(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SvVoltage
   *
   * @param	parentId		UUID
   * @return	SvVoltage
   */
  public SvVoltage unAssignSvVoltage(UUID parentId) {
    SvVoltage parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SvVoltage on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SvVoltage on the parent entithy
    // ------------------------------------------
    parentEntity.setSvVoltage(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the SvVoltage via an FindSvVoltageQuery
   *
   * @return query FindSvVoltageQuery
   */
  @SuppressWarnings("unused")
  public SvVoltage find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a SvVoltage - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all SvVoltages
   *
   * @param query FindAllSvVoltageQuery
   * @return List<SvVoltage>
   */
  @SuppressWarnings("unused")
  public List<SvVoltage> findAll(FindAllSvVoltageQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all SvVoltage - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SvVoltageRepository repository;

  @Autowired
  @Qualifier(value = "angleDegrees-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .AngleDegreesEntityProjector
      AngleDegreesProjector;

  @Autowired
  @Qualifier(value = "voltage-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .VoltageEntityProjector
      VoltageProjector;

  @Autowired
  @Qualifier(value = "svVoltage-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables
          .projector.SvVoltageEntityProjector
      SvVoltageProjector;

  private static final Logger LOGGER = Logger.getLogger(SvVoltageEntityProjector.class.getName());
}
