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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for EquivalentInjection as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by EquivalentInjectionAggregate
 *
 * @author your_name_here
 */
@Component("equivalentInjection-entity-projector")
public class EquivalentInjectionEntityProjector {

  // core constructor
  public EquivalentInjectionEntityProjector(EquivalentInjectionRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a EquivalentInjection
   *
   * @param	entity EquivalentInjection
   */
  public EquivalentInjection create(EquivalentInjection entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a EquivalentInjection
   *
   * @param	entity EquivalentInjection
   */
  public EquivalentInjection update(EquivalentInjection entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a EquivalentInjection
   *
   * @param	id		UUID
   */
  public EquivalentInjection delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    EquivalentInjection entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a MaxP
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	EquivalentInjection
   */
  public EquivalentInjection assignMaxP(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning MaxP as " + assignment.toString());

    EquivalentInjection parentEntity = repository.findById(parentId).get();
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
   * @return	EquivalentInjection
   */
  public EquivalentInjection unAssignMaxP(UUID parentId) {
    EquivalentInjection parentEntity = repository.findById(parentId).get();

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
   * @return	EquivalentInjection
   */
  public EquivalentInjection assignMaxQ(UUID parentId, ReactivePower assignment) {
    LOGGER.info("assigning MaxQ as " + assignment.toString());

    EquivalentInjection parentEntity = repository.findById(parentId).get();
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
   * @return	EquivalentInjection
   */
  public EquivalentInjection unAssignMaxQ(UUID parentId) {
    EquivalentInjection parentEntity = repository.findById(parentId).get();

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
   * Assign a MinP
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	EquivalentInjection
   */
  public EquivalentInjection assignMinP(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning MinP as " + assignment.toString());

    EquivalentInjection parentEntity = repository.findById(parentId).get();
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
   * @return	EquivalentInjection
   */
  public EquivalentInjection unAssignMinP(UUID parentId) {
    EquivalentInjection parentEntity = repository.findById(parentId).get();

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
   * @return	EquivalentInjection
   */
  public EquivalentInjection assignMinQ(UUID parentId, ReactivePower assignment) {
    LOGGER.info("assigning MinQ as " + assignment.toString());

    EquivalentInjection parentEntity = repository.findById(parentId).get();
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
   * @return	EquivalentInjection
   */
  public EquivalentInjection unAssignMinQ(UUID parentId) {
    EquivalentInjection parentEntity = repository.findById(parentId).get();

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
   * Assign a R
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	EquivalentInjection
   */
  public EquivalentInjection assignR(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning R as " + assignment.toString());

    EquivalentInjection parentEntity = repository.findById(parentId).get();
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
   * @return	EquivalentInjection
   */
  public EquivalentInjection unAssignR(UUID parentId) {
    EquivalentInjection parentEntity = repository.findById(parentId).get();

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
   * @return	EquivalentInjection
   */
  public EquivalentInjection assignR0(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning R0 as " + assignment.toString());

    EquivalentInjection parentEntity = repository.findById(parentId).get();
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
   * @return	EquivalentInjection
   */
  public EquivalentInjection unAssignR0(UUID parentId) {
    EquivalentInjection parentEntity = repository.findById(parentId).get();

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
   * Assign a R2
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	EquivalentInjection
   */
  public EquivalentInjection assignR2(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning R2 as " + assignment.toString());

    EquivalentInjection parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the R2 to the parent entity
    // ------------------------------------------
    parentEntity.setR2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R2
   *
   * @param	parentId		UUID
   * @return	EquivalentInjection
   */
  public EquivalentInjection unAssignR2(UUID parentId) {
    EquivalentInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R2 on the parent entithy
    // ------------------------------------------
    parentEntity.setR2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a RegulationCapability
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	EquivalentInjection
   */
  public EquivalentInjection assignRegulationCapability(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning RegulationCapability as " + assignment.toString());

    EquivalentInjection parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the RegulationCapability to the parent entity
    // ------------------------------------------
    parentEntity.setRegulationCapability(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RegulationCapability
   *
   * @param	parentId		UUID
   * @return	EquivalentInjection
   */
  public EquivalentInjection unAssignRegulationCapability(UUID parentId) {
    EquivalentInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RegulationCapability on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RegulationCapability on the parent entithy
    // ------------------------------------------
    parentEntity.setRegulationCapability(null);

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
   * @return	EquivalentInjection
   */
  public EquivalentInjection assignX(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning X as " + assignment.toString());

    EquivalentInjection parentEntity = repository.findById(parentId).get();
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
   * @return	EquivalentInjection
   */
  public EquivalentInjection unAssignX(UUID parentId) {
    EquivalentInjection parentEntity = repository.findById(parentId).get();

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
   * @return	EquivalentInjection
   */
  public EquivalentInjection assignX0(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning X0 as " + assignment.toString());

    EquivalentInjection parentEntity = repository.findById(parentId).get();
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
   * @return	EquivalentInjection
   */
  public EquivalentInjection unAssignX0(UUID parentId) {
    EquivalentInjection parentEntity = repository.findById(parentId).get();

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

  /*
   * Assign a X2
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	EquivalentInjection
   */
  public EquivalentInjection assignX2(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning X2 as " + assignment.toString());

    EquivalentInjection parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the X2 to the parent entity
    // ------------------------------------------
    parentEntity.setX2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X2
   *
   * @param	parentId		UUID
   * @return	EquivalentInjection
   */
  public EquivalentInjection unAssignX2(UUID parentId) {
    EquivalentInjection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X2 on the parent entithy
    // ------------------------------------------
    parentEntity.setX2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the EquivalentInjection
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	EquivalentInjection
   */
  public EquivalentInjection addToEquivalentInjection(UUID parentId, EquivalentInjection addTo) {
    LOGGER.info("handling AssignEquivalentInjectionToEquivalentInjectionEvent - ");

    EquivalentInjection parentEntity = repository.findById(parentId).get();
    EquivalentInjection child = EquivalentInjectionProjector.find(addTo.getEquivalentInjectionId());

    parentEntity.getEquivalentInjection().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the EquivalentInjection
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	EquivalentInjection
   */
  public EquivalentInjection removeFromEquivalentInjection(
      UUID parentId, EquivalentInjection removeFrom) {
    LOGGER.info("handling RemoveEquivalentInjectionFromEquivalentInjectionEvent ");

    EquivalentInjection parentEntity = repository.findById(parentId).get();
    EquivalentInjection child =
        EquivalentInjectionProjector.find(removeFrom.getEquivalentInjectionId());

    parentEntity.getEquivalentInjection().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the EquivalentInjection via an FindEquivalentInjectionQuery
   *
   * @return query FindEquivalentInjectionQuery
   */
  @SuppressWarnings("unused")
  public EquivalentInjection find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a EquivalentInjection - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all EquivalentInjections
   *
   * @param query FindAllEquivalentInjectionQuery
   * @return List<EquivalentInjection>
   */
  @SuppressWarnings("unused")
  public List<EquivalentInjection> findAll(FindAllEquivalentInjectionQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all EquivalentInjection - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final EquivalentInjectionRepository repository;

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
  @Qualifier(value = "reactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactanceEntityProjector
      ReactanceProjector;

  @Autowired
  @Qualifier(value = "equivalentInjection-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents
          .projector.EquivalentInjectionEntityProjector
      EquivalentInjectionProjector;

  private static final Logger LOGGER =
      Logger.getLogger(EquivalentInjectionEntityProjector.class.getName());
}
