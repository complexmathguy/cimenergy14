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
 * Projector for CurrentFlow as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by CurrentFlowAggregate
 *
 * @author your_name_here
 */
@Component("currentFlow-entity-projector")
public class CurrentFlowEntityProjector {

  // core constructor
  public CurrentFlowEntityProjector(CurrentFlowRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a CurrentFlow
   *
   * @param	entity CurrentFlow
   */
  public CurrentFlow create(CurrentFlow entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a CurrentFlow
   *
   * @param	entity CurrentFlow
   */
  public CurrentFlow update(CurrentFlow entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a CurrentFlow
   *
   * @param	id		UUID
   */
  public CurrentFlow delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    CurrentFlow entity = repository.findById(id).get();

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
   * @return	CurrentFlow
   */
  public CurrentFlow assignValue(UUID parentId, FloatProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    CurrentFlow parentEntity = repository.findById(parentId).get();
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
   * @return	CurrentFlow
   */
  public CurrentFlow unAssignValue(UUID parentId) {
    CurrentFlow parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the CurrentFlow via an FindCurrentFlowQuery
   *
   * @return query FindCurrentFlowQuery
   */
  @SuppressWarnings("unused")
  public CurrentFlow find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a CurrentFlow - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all CurrentFlows
   *
   * @param query FindAllCurrentFlowQuery
   * @return List<CurrentFlow>
   */
  @SuppressWarnings("unused")
  public List<CurrentFlow> findAll(FindAllCurrentFlowQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all CurrentFlow - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final CurrentFlowRepository repository;

  @Autowired
  @Qualifier(value = "floatProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .FloatProxyEntityProjector
      FloatProxyProjector;

  @Autowired
  @Qualifier(value = "csConverter-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .CsConverterEntityProjector
      CsConverterProjector;

  @Autowired
  @Qualifier(value = "vsConverter-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .VsConverterEntityProjector
      VsConverterProjector;

  @Autowired
  @Qualifier(value = "busbarSection-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .BusbarSectionEntityProjector
      BusbarSectionProjector;

  @Autowired
  @Qualifier(value = "externalNetworkInjection-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .ExternalNetworkInjectionEntityProjector
      ExternalNetworkInjectionProjector;

  @Autowired
  @Qualifier(value = "petersenCoil-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .PetersenCoilEntityProjector
      PetersenCoilProjector;

  @Autowired
  @Qualifier(value = "powerTransformer-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .PowerTransformerEntityProjector
      PowerTransformerProjector;

  @Autowired
  @Qualifier(value = "seriesCompensator-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .SeriesCompensatorEntityProjector
      SeriesCompensatorProjector;

  @Autowired
  @Qualifier(value = "switchProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .SwitchProxyEntityProjector
      SwitchProxyProjector;

  @Autowired
  @Qualifier(value = "synchronousMachine-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .SynchronousMachineEntityProjector
      SynchronousMachineProjector;

  @Autowired
  @Qualifier(value = "synchronousMachineDetailed-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .synchronousmachinedynamics.projector.SynchronousMachineDetailedEntityProjector
      SynchronousMachineDetailedProjector;

  private static final Logger LOGGER = Logger.getLogger(CurrentFlowEntityProjector.class.getName());
}
