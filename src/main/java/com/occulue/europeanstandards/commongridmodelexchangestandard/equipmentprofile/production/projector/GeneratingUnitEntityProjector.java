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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for GeneratingUnit as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GeneratingUnitAggregate
 *
 * @author your_name_here
 */
@Component("generatingUnit-entity-projector")
public class GeneratingUnitEntityProjector {

  // core constructor
  public GeneratingUnitEntityProjector(GeneratingUnitRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GeneratingUnit
   *
   * @param	entity GeneratingUnit
   */
  public GeneratingUnit create(GeneratingUnit entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GeneratingUnit
   *
   * @param	entity GeneratingUnit
   */
  public GeneratingUnit update(GeneratingUnit entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GeneratingUnit
   *
   * @param	id		UUID
   */
  public GeneratingUnit delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GeneratingUnit entity = repository.findById(id).get();

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
   * @param	assignment 	PerCent
   * @return	GeneratingUnit
   */
  public GeneratingUnit assignGovernorSCD(UUID parentId, PerCent assignment) {
    LOGGER.info("assigning GovernorSCD as " + assignment.toString());

    GeneratingUnit parentEntity = repository.findById(parentId).get();
    assignment = PerCentProjector.find(assignment.getPerCentId());

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
   * @return	GeneratingUnit
   */
  public GeneratingUnit unAssignGovernorSCD(UUID parentId) {
    GeneratingUnit parentEntity = repository.findById(parentId).get();

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
   * Assign a InitialP
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GeneratingUnit
   */
  public GeneratingUnit assignInitialP(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning InitialP as " + assignment.toString());

    GeneratingUnit parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the InitialP to the parent entity
    // ------------------------------------------
    parentEntity.setInitialP(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the InitialP
   *
   * @param	parentId		UUID
   * @return	GeneratingUnit
   */
  public GeneratingUnit unAssignInitialP(UUID parentId) {
    GeneratingUnit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning InitialP on " + parentEntity.toString());

    // ------------------------------------------
    // null out the InitialP on the parent entithy
    // ------------------------------------------
    parentEntity.setInitialP(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a LongPF
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GeneratingUnit
   */
  public GeneratingUnit assignLongPF(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning LongPF as " + assignment.toString());

    GeneratingUnit parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the LongPF to the parent entity
    // ------------------------------------------
    parentEntity.setLongPF(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the LongPF
   *
   * @param	parentId		UUID
   * @return	GeneratingUnit
   */
  public GeneratingUnit unAssignLongPF(UUID parentId) {
    GeneratingUnit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning LongPF on " + parentEntity.toString());

    // ------------------------------------------
    // null out the LongPF on the parent entithy
    // ------------------------------------------
    parentEntity.setLongPF(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MaximumAllowableSpinningReserve
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GeneratingUnit
   */
  public GeneratingUnit assignMaximumAllowableSpinningReserve(
      UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning MaximumAllowableSpinningReserve as " + assignment.toString());

    GeneratingUnit parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the MaximumAllowableSpinningReserve to the parent entity
    // ------------------------------------------
    parentEntity.setMaximumAllowableSpinningReserve(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaximumAllowableSpinningReserve
   *
   * @param	parentId		UUID
   * @return	GeneratingUnit
   */
  public GeneratingUnit unAssignMaximumAllowableSpinningReserve(UUID parentId) {
    GeneratingUnit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaximumAllowableSpinningReserve on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaximumAllowableSpinningReserve on the parent entithy
    // ------------------------------------------
    parentEntity.setMaximumAllowableSpinningReserve(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MaxOperatingP
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GeneratingUnit
   */
  public GeneratingUnit assignMaxOperatingP(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning MaxOperatingP as " + assignment.toString());

    GeneratingUnit parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the MaxOperatingP to the parent entity
    // ------------------------------------------
    parentEntity.setMaxOperatingP(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaxOperatingP
   *
   * @param	parentId		UUID
   * @return	GeneratingUnit
   */
  public GeneratingUnit unAssignMaxOperatingP(UUID parentId) {
    GeneratingUnit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaxOperatingP on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaxOperatingP on the parent entithy
    // ------------------------------------------
    parentEntity.setMaxOperatingP(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MinOperatingP
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GeneratingUnit
   */
  public GeneratingUnit assignMinOperatingP(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning MinOperatingP as " + assignment.toString());

    GeneratingUnit parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the MinOperatingP to the parent entity
    // ------------------------------------------
    parentEntity.setMinOperatingP(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MinOperatingP
   *
   * @param	parentId		UUID
   * @return	GeneratingUnit
   */
  public GeneratingUnit unAssignMinOperatingP(UUID parentId) {
    GeneratingUnit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MinOperatingP on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MinOperatingP on the parent entithy
    // ------------------------------------------
    parentEntity.setMinOperatingP(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NominalP
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GeneratingUnit
   */
  public GeneratingUnit assignNominalP(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning NominalP as " + assignment.toString());

    GeneratingUnit parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the NominalP to the parent entity
    // ------------------------------------------
    parentEntity.setNominalP(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NominalP
   *
   * @param	parentId		UUID
   * @return	GeneratingUnit
   */
  public GeneratingUnit unAssignNominalP(UUID parentId) {
    GeneratingUnit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NominalP on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NominalP on the parent entithy
    // ------------------------------------------
    parentEntity.setNominalP(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a RatedGrossMaxP
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GeneratingUnit
   */
  public GeneratingUnit assignRatedGrossMaxP(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning RatedGrossMaxP as " + assignment.toString());

    GeneratingUnit parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the RatedGrossMaxP to the parent entity
    // ------------------------------------------
    parentEntity.setRatedGrossMaxP(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RatedGrossMaxP
   *
   * @param	parentId		UUID
   * @return	GeneratingUnit
   */
  public GeneratingUnit unAssignRatedGrossMaxP(UUID parentId) {
    GeneratingUnit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RatedGrossMaxP on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RatedGrossMaxP on the parent entithy
    // ------------------------------------------
    parentEntity.setRatedGrossMaxP(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a RatedGrossMinP
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GeneratingUnit
   */
  public GeneratingUnit assignRatedGrossMinP(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning RatedGrossMinP as " + assignment.toString());

    GeneratingUnit parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the RatedGrossMinP to the parent entity
    // ------------------------------------------
    parentEntity.setRatedGrossMinP(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RatedGrossMinP
   *
   * @param	parentId		UUID
   * @return	GeneratingUnit
   */
  public GeneratingUnit unAssignRatedGrossMinP(UUID parentId) {
    GeneratingUnit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RatedGrossMinP on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RatedGrossMinP on the parent entithy
    // ------------------------------------------
    parentEntity.setRatedGrossMinP(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a RatedNetMaxP
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GeneratingUnit
   */
  public GeneratingUnit assignRatedNetMaxP(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning RatedNetMaxP as " + assignment.toString());

    GeneratingUnit parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the RatedNetMaxP to the parent entity
    // ------------------------------------------
    parentEntity.setRatedNetMaxP(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RatedNetMaxP
   *
   * @param	parentId		UUID
   * @return	GeneratingUnit
   */
  public GeneratingUnit unAssignRatedNetMaxP(UUID parentId) {
    GeneratingUnit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RatedNetMaxP on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RatedNetMaxP on the parent entithy
    // ------------------------------------------
    parentEntity.setRatedNetMaxP(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ShortPF
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GeneratingUnit
   */
  public GeneratingUnit assignShortPF(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning ShortPF as " + assignment.toString());

    GeneratingUnit parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the ShortPF to the parent entity
    // ------------------------------------------
    parentEntity.setShortPF(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ShortPF
   *
   * @param	parentId		UUID
   * @return	GeneratingUnit
   */
  public GeneratingUnit unAssignShortPF(UUID parentId) {
    GeneratingUnit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ShortPF on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ShortPF on the parent entithy
    // ------------------------------------------
    parentEntity.setShortPF(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a StartupCost
   *
   * @param	parentId	UUID
   * @param	assignment 	Money
   * @return	GeneratingUnit
   */
  public GeneratingUnit assignStartupCost(UUID parentId, Money assignment) {
    LOGGER.info("assigning StartupCost as " + assignment.toString());

    GeneratingUnit parentEntity = repository.findById(parentId).get();
    assignment = MoneyProjector.find(assignment.getMoneyId());

    // ------------------------------------------
    // assign the StartupCost to the parent entity
    // ------------------------------------------
    parentEntity.setStartupCost(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the StartupCost
   *
   * @param	parentId		UUID
   * @return	GeneratingUnit
   */
  public GeneratingUnit unAssignStartupCost(UUID parentId) {
    GeneratingUnit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning StartupCost on " + parentEntity.toString());

    // ------------------------------------------
    // null out the StartupCost on the parent entithy
    // ------------------------------------------
    parentEntity.setStartupCost(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a TotalEfficiency
   *
   * @param	parentId	UUID
   * @param	assignment 	PerCent
   * @return	GeneratingUnit
   */
  public GeneratingUnit assignTotalEfficiency(UUID parentId, PerCent assignment) {
    LOGGER.info("assigning TotalEfficiency as " + assignment.toString());

    GeneratingUnit parentEntity = repository.findById(parentId).get();
    assignment = PerCentProjector.find(assignment.getPerCentId());

    // ------------------------------------------
    // assign the TotalEfficiency to the parent entity
    // ------------------------------------------
    parentEntity.setTotalEfficiency(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the TotalEfficiency
   *
   * @param	parentId		UUID
   * @return	GeneratingUnit
   */
  public GeneratingUnit unAssignTotalEfficiency(UUID parentId) {
    GeneratingUnit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning TotalEfficiency on " + parentEntity.toString());

    // ------------------------------------------
    // null out the TotalEfficiency on the parent entithy
    // ------------------------------------------
    parentEntity.setTotalEfficiency(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a VariableCost
   *
   * @param	parentId	UUID
   * @param	assignment 	Money
   * @return	GeneratingUnit
   */
  public GeneratingUnit assignVariableCost(UUID parentId, Money assignment) {
    LOGGER.info("assigning VariableCost as " + assignment.toString());

    GeneratingUnit parentEntity = repository.findById(parentId).get();
    assignment = MoneyProjector.find(assignment.getMoneyId());

    // ------------------------------------------
    // assign the VariableCost to the parent entity
    // ------------------------------------------
    parentEntity.setVariableCost(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the VariableCost
   *
   * @param	parentId		UUID
   * @return	GeneratingUnit
   */
  public GeneratingUnit unAssignVariableCost(UUID parentId) {
    GeneratingUnit parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning VariableCost on " + parentEntity.toString());

    // ------------------------------------------
    // null out the VariableCost on the parent entithy
    // ------------------------------------------
    parentEntity.setVariableCost(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GeneratingUnit via an FindGeneratingUnitQuery
   *
   * @return query FindGeneratingUnitQuery
   */
  @SuppressWarnings("unused")
  public GeneratingUnit find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GeneratingUnit - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GeneratingUnits
   *
   * @param query FindAllGeneratingUnitQuery
   * @return List<GeneratingUnit>
   */
  @SuppressWarnings("unused")
  public List<GeneratingUnit> findAll(FindAllGeneratingUnitQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GeneratingUnit - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GeneratingUnitRepository repository;

  @Autowired
  @Qualifier(value = "perCent-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PerCentEntityProjector
      PerCentProjector;

  @Autowired
  @Qualifier(value = "activePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ActivePowerEntityProjector
      ActivePowerProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "money-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .MoneyEntityProjector
      MoneyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(GeneratingUnitEntityProjector.class.getName());
}
