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
 * Projector for EnergyConsumer as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by EnergyConsumerAggregate
 *
 * @author your_name_here
 */
@Component("energyConsumer-entity-projector")
public class EnergyConsumerEntityProjector {

  // core constructor
  public EnergyConsumerEntityProjector(EnergyConsumerRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a EnergyConsumer
   *
   * @param	entity EnergyConsumer
   */
  public EnergyConsumer create(EnergyConsumer entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a EnergyConsumer
   *
   * @param	entity EnergyConsumer
   */
  public EnergyConsumer update(EnergyConsumer entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a EnergyConsumer
   *
   * @param	id		UUID
   */
  public EnergyConsumer delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    EnergyConsumer entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Pfixed
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	EnergyConsumer
   */
  public EnergyConsumer assignPfixed(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Pfixed as " + assignment.toString());

    EnergyConsumer parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the Pfixed to the parent entity
    // ------------------------------------------
    parentEntity.setPfixed(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pfixed
   *
   * @param	parentId		UUID
   * @return	EnergyConsumer
   */
  public EnergyConsumer unAssignPfixed(UUID parentId) {
    EnergyConsumer parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pfixed on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pfixed on the parent entithy
    // ------------------------------------------
    parentEntity.setPfixed(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a PfixedPct
   *
   * @param	parentId	UUID
   * @param	assignment 	PerCent
   * @return	EnergyConsumer
   */
  public EnergyConsumer assignPfixedPct(UUID parentId, PerCent assignment) {
    LOGGER.info("assigning PfixedPct as " + assignment.toString());

    EnergyConsumer parentEntity = repository.findById(parentId).get();
    assignment = PerCentProjector.find(assignment.getPerCentId());

    // ------------------------------------------
    // assign the PfixedPct to the parent entity
    // ------------------------------------------
    parentEntity.setPfixedPct(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PfixedPct
   *
   * @param	parentId		UUID
   * @return	EnergyConsumer
   */
  public EnergyConsumer unAssignPfixedPct(UUID parentId) {
    EnergyConsumer parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PfixedPct on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PfixedPct on the parent entithy
    // ------------------------------------------
    parentEntity.setPfixedPct(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Qfixed
   *
   * @param	parentId	UUID
   * @param	assignment 	ReactivePower
   * @return	EnergyConsumer
   */
  public EnergyConsumer assignQfixed(UUID parentId, ReactivePower assignment) {
    LOGGER.info("assigning Qfixed as " + assignment.toString());

    EnergyConsumer parentEntity = repository.findById(parentId).get();
    assignment = ReactivePowerProjector.find(assignment.getReactivePowerId());

    // ------------------------------------------
    // assign the Qfixed to the parent entity
    // ------------------------------------------
    parentEntity.setQfixed(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Qfixed
   *
   * @param	parentId		UUID
   * @return	EnergyConsumer
   */
  public EnergyConsumer unAssignQfixed(UUID parentId) {
    EnergyConsumer parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Qfixed on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Qfixed on the parent entithy
    // ------------------------------------------
    parentEntity.setQfixed(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a QfixedPct
   *
   * @param	parentId	UUID
   * @param	assignment 	PerCent
   * @return	EnergyConsumer
   */
  public EnergyConsumer assignQfixedPct(UUID parentId, PerCent assignment) {
    LOGGER.info("assigning QfixedPct as " + assignment.toString());

    EnergyConsumer parentEntity = repository.findById(parentId).get();
    assignment = PerCentProjector.find(assignment.getPerCentId());

    // ------------------------------------------
    // assign the QfixedPct to the parent entity
    // ------------------------------------------
    parentEntity.setQfixedPct(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the QfixedPct
   *
   * @param	parentId		UUID
   * @return	EnergyConsumer
   */
  public EnergyConsumer unAssignQfixedPct(UUID parentId) {
    EnergyConsumer parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning QfixedPct on " + parentEntity.toString());

    // ------------------------------------------
    // null out the QfixedPct on the parent entithy
    // ------------------------------------------
    parentEntity.setQfixedPct(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the EnergyConsumer
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	EnergyConsumer
   */
  public EnergyConsumer addToEnergyConsumer(UUID parentId, EnergyConsumer addTo) {
    LOGGER.info("handling AssignEnergyConsumerToEnergyConsumerEvent - ");

    EnergyConsumer parentEntity = repository.findById(parentId).get();
    EnergyConsumer child = EnergyConsumerProjector.find(addTo.getEnergyConsumerId());

    parentEntity.getEnergyConsumer().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the EnergyConsumer
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	EnergyConsumer
   */
  public EnergyConsumer removeFromEnergyConsumer(UUID parentId, EnergyConsumer removeFrom) {
    LOGGER.info("handling RemoveEnergyConsumerFromEnergyConsumerEvent ");

    EnergyConsumer parentEntity = repository.findById(parentId).get();
    EnergyConsumer child = EnergyConsumerProjector.find(removeFrom.getEnergyConsumerId());

    parentEntity.getEnergyConsumer().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the EnergyConsumer via an FindEnergyConsumerQuery
   *
   * @return query FindEnergyConsumerQuery
   */
  @SuppressWarnings("unused")
  public EnergyConsumer find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a EnergyConsumer - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all EnergyConsumers
   *
   * @param query FindAllEnergyConsumerQuery
   * @return List<EnergyConsumer>
   */
  @SuppressWarnings("unused")
  public List<EnergyConsumer> findAll(FindAllEnergyConsumerQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all EnergyConsumer - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final EnergyConsumerRepository repository;

  @Autowired
  @Qualifier(value = "activePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ActivePowerEntityProjector
      ActivePowerProjector;

  @Autowired
  @Qualifier(value = "perCent-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PerCentEntityProjector
      PerCentProjector;

  @Autowired
  @Qualifier(value = "reactivePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactivePowerEntityProjector
      ReactivePowerProjector;

  @Autowired
  @Qualifier(value = "energyConsumer-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .EnergyConsumerEntityProjector
      EnergyConsumerProjector;

  private static final Logger LOGGER =
      Logger.getLogger(EnergyConsumerEntityProjector.class.getName());
}
