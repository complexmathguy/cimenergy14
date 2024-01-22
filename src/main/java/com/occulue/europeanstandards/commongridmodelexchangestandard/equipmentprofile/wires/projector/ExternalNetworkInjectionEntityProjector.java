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
 * Projector for ExternalNetworkInjection as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExternalNetworkInjectionAggregate
 *
 * @author your_name_here
 */
@Component("externalNetworkInjection-entity-projector")
public class ExternalNetworkInjectionEntityProjector {

  // core constructor
  public ExternalNetworkInjectionEntityProjector(ExternalNetworkInjectionRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExternalNetworkInjection
   *
   * @param	entity ExternalNetworkInjection
   */
  public ExternalNetworkInjection create(ExternalNetworkInjection entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExternalNetworkInjection
   *
   * @param	entity ExternalNetworkInjection
   */
  public ExternalNetworkInjection update(ExternalNetworkInjection entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExternalNetworkInjection
   *
   * @param	id		UUID
   */
  public ExternalNetworkInjection delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExternalNetworkInjection entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a GovernorSCD
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePowerPerFrequency
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection assignGovernorSCD(
      UUID parentId, ActivePowerPerFrequency assignment) {
    LOGGER.info("assigning GovernorSCD as " + assignment.toString());

    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerPerFrequencyProjector.find(assignment.getActivePowerPerFrequencyId());

    // ------------------------------------------
    // assign the GovernorSCD to the parent entity
    // ------------------------------------------
    parentEntity.setGovernorSCD(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the GovernorSCD
   *
   * @param	parentId		UUID
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection unAssignGovernorSCD(UUID parentId) {
    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning GovernorSCD on " + parentEntity.toString());

    // ------------------------------------------
    // null out the GovernorSCD on the parent entithy
    // ------------------------------------------
    parentEntity.setGovernorSCD(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a IkSecond
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection assignIkSecond(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning IkSecond as " + assignment.toString());

    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the IkSecond to the parent entity
    // ------------------------------------------
    parentEntity.setIkSecond(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the IkSecond
   *
   * @param	parentId		UUID
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection unAssignIkSecond(UUID parentId) {
    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning IkSecond on " + parentEntity.toString());

    // ------------------------------------------
    // null out the IkSecond on the parent entithy
    // ------------------------------------------
    parentEntity.setIkSecond(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MaxInitialSymShCCurrent
   *
   * @param	parentId	UUID
   * @param	assignment 	CurrentFlow
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection assignMaxInitialSymShCCurrent(
      UUID parentId, CurrentFlow assignment) {
    LOGGER.info("assigning MaxInitialSymShCCurrent as " + assignment.toString());

    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();
    assignment = CurrentFlowProjector.find(assignment.getCurrentFlowId());

    // ------------------------------------------
    // assign the MaxInitialSymShCCurrent to the parent entity
    // ------------------------------------------
    parentEntity.setMaxInitialSymShCCurrent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaxInitialSymShCCurrent
   *
   * @param	parentId		UUID
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection unAssignMaxInitialSymShCCurrent(UUID parentId) {
    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaxInitialSymShCCurrent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaxInitialSymShCCurrent on the parent entithy
    // ------------------------------------------
    parentEntity.setMaxInitialSymShCCurrent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MaxP
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection assignMaxP(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning MaxP as " + assignment.toString());

    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the MaxP to the parent entity
    // ------------------------------------------
    parentEntity.setMaxP(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaxP
   *
   * @param	parentId		UUID
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection unAssignMaxP(UUID parentId) {
    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaxP on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaxP on the parent entithy
    // ------------------------------------------
    parentEntity.setMaxP(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MaxQ
   *
   * @param	parentId	UUID
   * @param	assignment 	ReactivePower
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection assignMaxQ(UUID parentId, ReactivePower assignment) {
    LOGGER.info("assigning MaxQ as " + assignment.toString());

    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();
    assignment = ReactivePowerProjector.find(assignment.getReactivePowerId());

    // ------------------------------------------
    // assign the MaxQ to the parent entity
    // ------------------------------------------
    parentEntity.setMaxQ(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaxQ
   *
   * @param	parentId		UUID
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection unAssignMaxQ(UUID parentId) {
    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaxQ on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaxQ on the parent entithy
    // ------------------------------------------
    parentEntity.setMaxQ(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MaxR0ToX0Ratio
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection assignMaxR0ToX0Ratio(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning MaxR0ToX0Ratio as " + assignment.toString());

    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the MaxR0ToX0Ratio to the parent entity
    // ------------------------------------------
    parentEntity.setMaxR0ToX0Ratio(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaxR0ToX0Ratio
   *
   * @param	parentId		UUID
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection unAssignMaxR0ToX0Ratio(UUID parentId) {
    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaxR0ToX0Ratio on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaxR0ToX0Ratio on the parent entithy
    // ------------------------------------------
    parentEntity.setMaxR0ToX0Ratio(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MaxR1ToX1Ratio
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection assignMaxR1ToX1Ratio(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning MaxR1ToX1Ratio as " + assignment.toString());

    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the MaxR1ToX1Ratio to the parent entity
    // ------------------------------------------
    parentEntity.setMaxR1ToX1Ratio(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaxR1ToX1Ratio
   *
   * @param	parentId		UUID
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection unAssignMaxR1ToX1Ratio(UUID parentId) {
    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaxR1ToX1Ratio on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaxR1ToX1Ratio on the parent entithy
    // ------------------------------------------
    parentEntity.setMaxR1ToX1Ratio(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MaxZ0ToZ1Ratio
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection assignMaxZ0ToZ1Ratio(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning MaxZ0ToZ1Ratio as " + assignment.toString());

    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the MaxZ0ToZ1Ratio to the parent entity
    // ------------------------------------------
    parentEntity.setMaxZ0ToZ1Ratio(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaxZ0ToZ1Ratio
   *
   * @param	parentId		UUID
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection unAssignMaxZ0ToZ1Ratio(UUID parentId) {
    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaxZ0ToZ1Ratio on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaxZ0ToZ1Ratio on the parent entithy
    // ------------------------------------------
    parentEntity.setMaxZ0ToZ1Ratio(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MinInitialSymShCCurrent
   *
   * @param	parentId	UUID
   * @param	assignment 	CurrentFlow
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection assignMinInitialSymShCCurrent(
      UUID parentId, CurrentFlow assignment) {
    LOGGER.info("assigning MinInitialSymShCCurrent as " + assignment.toString());

    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();
    assignment = CurrentFlowProjector.find(assignment.getCurrentFlowId());

    // ------------------------------------------
    // assign the MinInitialSymShCCurrent to the parent entity
    // ------------------------------------------
    parentEntity.setMinInitialSymShCCurrent(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MinInitialSymShCCurrent
   *
   * @param	parentId		UUID
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection unAssignMinInitialSymShCCurrent(UUID parentId) {
    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MinInitialSymShCCurrent on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MinInitialSymShCCurrent on the parent entithy
    // ------------------------------------------
    parentEntity.setMinInitialSymShCCurrent(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MinP
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection assignMinP(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning MinP as " + assignment.toString());

    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the MinP to the parent entity
    // ------------------------------------------
    parentEntity.setMinP(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MinP
   *
   * @param	parentId		UUID
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection unAssignMinP(UUID parentId) {
    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MinP on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MinP on the parent entithy
    // ------------------------------------------
    parentEntity.setMinP(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MinQ
   *
   * @param	parentId	UUID
   * @param	assignment 	ReactivePower
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection assignMinQ(UUID parentId, ReactivePower assignment) {
    LOGGER.info("assigning MinQ as " + assignment.toString());

    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();
    assignment = ReactivePowerProjector.find(assignment.getReactivePowerId());

    // ------------------------------------------
    // assign the MinQ to the parent entity
    // ------------------------------------------
    parentEntity.setMinQ(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MinQ
   *
   * @param	parentId		UUID
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection unAssignMinQ(UUID parentId) {
    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MinQ on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MinQ on the parent entithy
    // ------------------------------------------
    parentEntity.setMinQ(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MinR0ToX0Ratio
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection assignMinR0ToX0Ratio(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning MinR0ToX0Ratio as " + assignment.toString());

    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the MinR0ToX0Ratio to the parent entity
    // ------------------------------------------
    parentEntity.setMinR0ToX0Ratio(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MinR0ToX0Ratio
   *
   * @param	parentId		UUID
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection unAssignMinR0ToX0Ratio(UUID parentId) {
    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MinR0ToX0Ratio on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MinR0ToX0Ratio on the parent entithy
    // ------------------------------------------
    parentEntity.setMinR0ToX0Ratio(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MinR1ToX1Ratio
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection assignMinR1ToX1Ratio(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning MinR1ToX1Ratio as " + assignment.toString());

    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the MinR1ToX1Ratio to the parent entity
    // ------------------------------------------
    parentEntity.setMinR1ToX1Ratio(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MinR1ToX1Ratio
   *
   * @param	parentId		UUID
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection unAssignMinR1ToX1Ratio(UUID parentId) {
    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MinR1ToX1Ratio on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MinR1ToX1Ratio on the parent entithy
    // ------------------------------------------
    parentEntity.setMinR1ToX1Ratio(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MinZ0ToZ1Ratio
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection assignMinZ0ToZ1Ratio(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning MinZ0ToZ1Ratio as " + assignment.toString());

    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the MinZ0ToZ1Ratio to the parent entity
    // ------------------------------------------
    parentEntity.setMinZ0ToZ1Ratio(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MinZ0ToZ1Ratio
   *
   * @param	parentId		UUID
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection unAssignMinZ0ToZ1Ratio(UUID parentId) {
    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MinZ0ToZ1Ratio on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MinZ0ToZ1Ratio on the parent entithy
    // ------------------------------------------
    parentEntity.setMinZ0ToZ1Ratio(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a VoltageFactor
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection assignVoltageFactor(UUID parentId, PU assignment) {
    LOGGER.info("assigning VoltageFactor as " + assignment.toString());

    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the VoltageFactor to the parent entity
    // ------------------------------------------
    parentEntity.setVoltageFactor(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the VoltageFactor
   *
   * @param	parentId		UUID
   * @return	ExternalNetworkInjection
   */
  public ExternalNetworkInjection unAssignVoltageFactor(UUID parentId) {
    ExternalNetworkInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning VoltageFactor on " + parentEntity.toString());

    // ------------------------------------------
    // null out the VoltageFactor on the parent entithy
    // ------------------------------------------
    parentEntity.setVoltageFactor(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExternalNetworkInjection via an FindExternalNetworkInjectionQuery
   *
   * @return query FindExternalNetworkInjectionQuery
   */
  @SuppressWarnings("unused")
  public ExternalNetworkInjection find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a ExternalNetworkInjection - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExternalNetworkInjections
   *
   * @param query FindAllExternalNetworkInjectionQuery
   * @return List<ExternalNetworkInjection>
   */
  @SuppressWarnings("unused")
  public List<ExternalNetworkInjection> findAll(FindAllExternalNetworkInjectionQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all ExternalNetworkInjection - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExternalNetworkInjectionRepository repository;

  @Autowired
  @Qualifier(value = "activePowerPerFrequency-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ActivePowerPerFrequencyEntityProjector
      ActivePowerPerFrequencyProjector;

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
  @Qualifier(value = "activePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ActivePowerEntityProjector
      ActivePowerProjector;

  @Autowired
  @Qualifier(value = "reactivePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactivePowerEntityProjector
      ReactivePowerProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  private static final Logger LOGGER =
      Logger.getLogger(ExternalNetworkInjectionEntityProjector.class.getName());
}
