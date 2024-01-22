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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for PerCent as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PerCentAggregate
 *
 * @author your_name_here
 */
@Component("perCent-entity-projector")
public class PerCentEntityProjector {

  // core constructor
  public PerCentEntityProjector(PerCentRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PerCent
   *
   * @param	entity PerCent
   */
  public PerCent create(PerCent entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PerCent
   *
   * @param	entity PerCent
   */
  public PerCent update(PerCent entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PerCent
   *
   * @param	id		UUID
   */
  public PerCent delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PerCent entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Value
   *
   * @param	parentId	UUID
   * @param	assignment 	FloatProxy
   * @return	PerCent
   */
  public PerCent assignValue(UUID parentId, FloatProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    PerCent parentEntity = repository.findById(parentId).get();
    assignment = FloatProxyProjector.find(assignment.getFloatProxyId());

    // ------------------------------------------
    // assign the Value to the parent entity
    // ------------------------------------------
    parentEntity.setValue(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Value
   *
   * @param	parentId		UUID
   * @return	PerCent
   */
  public PerCent unAssignValue(UUID parentId) {
    PerCent parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Value on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Value on the parent entithy
    // ------------------------------------------
    parentEntity.setValue(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PerCent via an FindPerCentQuery
   *
   * @return query FindPerCentQuery
   */
  @SuppressWarnings("unused")
  public PerCent find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PerCent - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PerCents
   *
   * @param query FindAllPerCentQuery
   * @return List<PerCent>
   */
  @SuppressWarnings("unused")
  public List<PerCent> findAll(FindAllPerCentQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PerCent - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PerCentRepository repository;

  @Autowired
  @Qualifier(value = "floatProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .FloatProxyEntityProjector
      FloatProxyProjector;

  @Autowired
  @Qualifier(value = "measurementValue-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector
          .MeasurementValueEntityProjector
      MeasurementValueProjector;

  @Autowired
  @Qualifier(value = "generatingUnit-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production
          .projector.GeneratingUnitEntityProjector
      GeneratingUnitProjector;

  @Autowired
  @Qualifier(value = "asynchronousMachine-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .AsynchronousMachineEntityProjector
      AsynchronousMachineProjector;

  @Autowired
  @Qualifier(value = "energyConsumer-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .EnergyConsumerEntityProjector
      EnergyConsumerProjector;

  @Autowired
  @Qualifier(value = "phaseTapChangerNonLinear-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .PhaseTapChangerNonLinearEntityProjector
      PhaseTapChangerNonLinearProjector;

  @Autowired
  @Qualifier(value = "ratioTapChanger-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .RatioTapChangerEntityProjector
      RatioTapChangerProjector;

  @Autowired
  @Qualifier(value = "synchronousMachine-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .SynchronousMachineEntityProjector
      SynchronousMachineProjector;

  @Autowired
  @Qualifier(value = "tapChangerTablePoint-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .TapChangerTablePointEntityProjector
      TapChangerTablePointProjector;

  private static final Logger LOGGER = Logger.getLogger(PerCentEntityProjector.class.getName());
}
