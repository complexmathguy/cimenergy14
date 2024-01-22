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
 * Projector for PetersenCoil as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PetersenCoilAggregate
 *
 * @author your_name_here
 */
@Component("petersenCoil-entity-projector")
public class PetersenCoilEntityProjector {

  // core constructor
  public PetersenCoilEntityProjector(PetersenCoilRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PetersenCoil
   *
   * @param	entity PetersenCoil
   */
  public PetersenCoil create(PetersenCoil entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PetersenCoil
   *
   * @param	entity PetersenCoil
   */
  public PetersenCoil update(PetersenCoil entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PetersenCoil
   *
   * @param	id		UUID
   */
  public PetersenCoil delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PetersenCoil entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a NominalU
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	PetersenCoil
   */
  public PetersenCoil assignNominalU(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning NominalU as " + assignment.toString());

    PetersenCoil parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the NominalU to the parent entity
    // ------------------------------------------
    parentEntity.setNominalU(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NominalU
   *
   * @param	parentId		UUID
   * @return	PetersenCoil
   */
  public PetersenCoil unAssignNominalU(UUID parentId) {
    PetersenCoil parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NominalU on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NominalU on the parent entithy
    // ------------------------------------------
    parentEntity.setNominalU(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a OffsetCurrent
   *
   * @param	parentId	UUID
   * @param	assignment 	CurrentFlow
   * @return	PetersenCoil
   */
  public PetersenCoil assignOffsetCurrent(UUID parentId, CurrentFlow assignment) {
    LOGGER.info("assigning OffsetCurrent as " + assignment.toString());

    PetersenCoil parentEntity = repository.findById(parentId).get();
    assignment = CurrentFlowProjector.find(assignment.getCurrentFlowId());

    // ------------------------------------------
    // assign the OffsetCurrent to the parent entity
    // ------------------------------------------
    parentEntity.setOffsetCurrent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the OffsetCurrent
   *
   * @param	parentId		UUID
   * @return	PetersenCoil
   */
  public PetersenCoil unAssignOffsetCurrent(UUID parentId) {
    PetersenCoil parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning OffsetCurrent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the OffsetCurrent on the parent entithy
    // ------------------------------------------
    parentEntity.setOffsetCurrent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a PositionCurrent
   *
   * @param	parentId	UUID
   * @param	assignment 	CurrentFlow
   * @return	PetersenCoil
   */
  public PetersenCoil assignPositionCurrent(UUID parentId, CurrentFlow assignment) {
    LOGGER.info("assigning PositionCurrent as " + assignment.toString());

    PetersenCoil parentEntity = repository.findById(parentId).get();
    assignment = CurrentFlowProjector.find(assignment.getCurrentFlowId());

    // ------------------------------------------
    // assign the PositionCurrent to the parent entity
    // ------------------------------------------
    parentEntity.setPositionCurrent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PositionCurrent
   *
   * @param	parentId		UUID
   * @return	PetersenCoil
   */
  public PetersenCoil unAssignPositionCurrent(UUID parentId) {
    PetersenCoil parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PositionCurrent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PositionCurrent on the parent entithy
    // ------------------------------------------
    parentEntity.setPositionCurrent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a XGroundMax
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	PetersenCoil
   */
  public PetersenCoil assignXGroundMax(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning XGroundMax as " + assignment.toString());

    PetersenCoil parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the XGroundMax to the parent entity
    // ------------------------------------------
    parentEntity.setXGroundMax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the XGroundMax
   *
   * @param	parentId		UUID
   * @return	PetersenCoil
   */
  public PetersenCoil unAssignXGroundMax(UUID parentId) {
    PetersenCoil parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning XGroundMax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the XGroundMax on the parent entithy
    // ------------------------------------------
    parentEntity.setXGroundMax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a XGroundMin
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	PetersenCoil
   */
  public PetersenCoil assignXGroundMin(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning XGroundMin as " + assignment.toString());

    PetersenCoil parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the XGroundMin to the parent entity
    // ------------------------------------------
    parentEntity.setXGroundMin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the XGroundMin
   *
   * @param	parentId		UUID
   * @return	PetersenCoil
   */
  public PetersenCoil unAssignXGroundMin(UUID parentId) {
    PetersenCoil parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning XGroundMin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the XGroundMin on the parent entithy
    // ------------------------------------------
    parentEntity.setXGroundMin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a XGroundNominal
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	PetersenCoil
   */
  public PetersenCoil assignXGroundNominal(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning XGroundNominal as " + assignment.toString());

    PetersenCoil parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the XGroundNominal to the parent entity
    // ------------------------------------------
    parentEntity.setXGroundNominal(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the XGroundNominal
   *
   * @param	parentId		UUID
   * @return	PetersenCoil
   */
  public PetersenCoil unAssignXGroundNominal(UUID parentId) {
    PetersenCoil parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning XGroundNominal on " + parentEntity.toString());

    // ------------------------------------------
    // null out the XGroundNominal on the parent entithy
    // ------------------------------------------
    parentEntity.setXGroundNominal(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PetersenCoil via an FindPetersenCoilQuery
   *
   * @return query FindPetersenCoilQuery
   */
  @SuppressWarnings("unused")
  public PetersenCoil find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PetersenCoil - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PetersenCoils
   *
   * @param query FindAllPetersenCoilQuery
   * @return List<PetersenCoil>
   */
  @SuppressWarnings("unused")
  public List<PetersenCoil> findAll(FindAllPetersenCoilQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PetersenCoil - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PetersenCoilRepository repository;

  @Autowired
  @Qualifier(value = "voltage-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .VoltageEntityProjector
      VoltageProjector;

  @Autowired
  @Qualifier(value = "currentFlow-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .CurrentFlowEntityProjector
      CurrentFlowProjector;

  @Autowired
  @Qualifier(value = "reactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactanceEntityProjector
      ReactanceProjector;

  private static final Logger LOGGER =
      Logger.getLogger(PetersenCoilEntityProjector.class.getName());
}
