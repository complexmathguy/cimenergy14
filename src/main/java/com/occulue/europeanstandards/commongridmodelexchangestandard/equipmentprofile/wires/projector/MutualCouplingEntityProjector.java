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
 * Projector for MutualCoupling as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by MutualCouplingAggregate
 *
 * @author your_name_here
 */
@Component("mutualCoupling-entity-projector")
public class MutualCouplingEntityProjector {

  // core constructor
  public MutualCouplingEntityProjector(MutualCouplingRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a MutualCoupling
   *
   * @param	entity MutualCoupling
   */
  public MutualCoupling create(MutualCoupling entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a MutualCoupling
   *
   * @param	entity MutualCoupling
   */
  public MutualCoupling update(MutualCoupling entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a MutualCoupling
   *
   * @param	id		UUID
   */
  public MutualCoupling delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    MutualCoupling entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a B0ch
   *
   * @param	parentId	UUID
   * @param	assignment 	Susceptance
   * @return	MutualCoupling
   */
  public MutualCoupling assignB0ch(UUID parentId, Susceptance assignment) {
    LOGGER.info("assigning B0ch as " + assignment.toString());

    MutualCoupling parentEntity = repository.findById(parentId).get();
    assignment = SusceptanceProjector.find(assignment.getSusceptanceId());

    // ------------------------------------------
    // assign the B0ch to the parent entity
    // ------------------------------------------
    parentEntity.setB0ch(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B0ch
   *
   * @param	parentId		UUID
   * @return	MutualCoupling
   */
  public MutualCoupling unAssignB0ch(UUID parentId) {
    MutualCoupling parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B0ch on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B0ch on the parent entithy
    // ------------------------------------------
    parentEntity.setB0ch(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Distance11
   *
   * @param	parentId	UUID
   * @param	assignment 	Length
   * @return	MutualCoupling
   */
  public MutualCoupling assignDistance11(UUID parentId, Length assignment) {
    LOGGER.info("assigning Distance11 as " + assignment.toString());

    MutualCoupling parentEntity = repository.findById(parentId).get();
    assignment = LengthProjector.find(assignment.getLengthId());

    // ------------------------------------------
    // assign the Distance11 to the parent entity
    // ------------------------------------------
    parentEntity.setDistance11(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Distance11
   *
   * @param	parentId		UUID
   * @return	MutualCoupling
   */
  public MutualCoupling unAssignDistance11(UUID parentId) {
    MutualCoupling parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Distance11 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Distance11 on the parent entithy
    // ------------------------------------------
    parentEntity.setDistance11(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Distance12
   *
   * @param	parentId	UUID
   * @param	assignment 	Length
   * @return	MutualCoupling
   */
  public MutualCoupling assignDistance12(UUID parentId, Length assignment) {
    LOGGER.info("assigning Distance12 as " + assignment.toString());

    MutualCoupling parentEntity = repository.findById(parentId).get();
    assignment = LengthProjector.find(assignment.getLengthId());

    // ------------------------------------------
    // assign the Distance12 to the parent entity
    // ------------------------------------------
    parentEntity.setDistance12(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Distance12
   *
   * @param	parentId		UUID
   * @return	MutualCoupling
   */
  public MutualCoupling unAssignDistance12(UUID parentId) {
    MutualCoupling parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Distance12 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Distance12 on the parent entithy
    // ------------------------------------------
    parentEntity.setDistance12(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Distance21
   *
   * @param	parentId	UUID
   * @param	assignment 	Length
   * @return	MutualCoupling
   */
  public MutualCoupling assignDistance21(UUID parentId, Length assignment) {
    LOGGER.info("assigning Distance21 as " + assignment.toString());

    MutualCoupling parentEntity = repository.findById(parentId).get();
    assignment = LengthProjector.find(assignment.getLengthId());

    // ------------------------------------------
    // assign the Distance21 to the parent entity
    // ------------------------------------------
    parentEntity.setDistance21(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Distance21
   *
   * @param	parentId		UUID
   * @return	MutualCoupling
   */
  public MutualCoupling unAssignDistance21(UUID parentId) {
    MutualCoupling parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Distance21 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Distance21 on the parent entithy
    // ------------------------------------------
    parentEntity.setDistance21(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Distance22
   *
   * @param	parentId	UUID
   * @param	assignment 	Length
   * @return	MutualCoupling
   */
  public MutualCoupling assignDistance22(UUID parentId, Length assignment) {
    LOGGER.info("assigning Distance22 as " + assignment.toString());

    MutualCoupling parentEntity = repository.findById(parentId).get();
    assignment = LengthProjector.find(assignment.getLengthId());

    // ------------------------------------------
    // assign the Distance22 to the parent entity
    // ------------------------------------------
    parentEntity.setDistance22(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Distance22
   *
   * @param	parentId		UUID
   * @return	MutualCoupling
   */
  public MutualCoupling unAssignDistance22(UUID parentId) {
    MutualCoupling parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Distance22 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Distance22 on the parent entithy
    // ------------------------------------------
    parentEntity.setDistance22(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a G0ch
   *
   * @param	parentId	UUID
   * @param	assignment 	Conductance
   * @return	MutualCoupling
   */
  public MutualCoupling assignG0ch(UUID parentId, Conductance assignment) {
    LOGGER.info("assigning G0ch as " + assignment.toString());

    MutualCoupling parentEntity = repository.findById(parentId).get();
    assignment = ConductanceProjector.find(assignment.getConductanceId());

    // ------------------------------------------
    // assign the G0ch to the parent entity
    // ------------------------------------------
    parentEntity.setG0ch(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the G0ch
   *
   * @param	parentId		UUID
   * @return	MutualCoupling
   */
  public MutualCoupling unAssignG0ch(UUID parentId) {
    MutualCoupling parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning G0ch on " + parentEntity.toString());

    // ------------------------------------------
    // null out the G0ch on the parent entithy
    // ------------------------------------------
    parentEntity.setG0ch(null);

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
   * @return	MutualCoupling
   */
  public MutualCoupling assignR0(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning R0 as " + assignment.toString());

    MutualCoupling parentEntity = repository.findById(parentId).get();
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
   * @return	MutualCoupling
   */
  public MutualCoupling unAssignR0(UUID parentId) {
    MutualCoupling parentEntity = repository.findById(parentId).get();

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
   * Assign a X0
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	MutualCoupling
   */
  public MutualCoupling assignX0(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning X0 as " + assignment.toString());

    MutualCoupling parentEntity = repository.findById(parentId).get();
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
   * @return	MutualCoupling
   */
  public MutualCoupling unAssignX0(UUID parentId) {
    MutualCoupling parentEntity = repository.findById(parentId).get();

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
   * Add to the HasSecondMutualCoupling
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	MutualCoupling
   */
  public MutualCoupling addToHasSecondMutualCoupling(UUID parentId, MutualCoupling addTo) {
    LOGGER.info("handling AssignHasSecondMutualCouplingToMutualCouplingEvent - ");

    MutualCoupling parentEntity = repository.findById(parentId).get();
    MutualCoupling child = MutualCouplingProjector.find(addTo.getMutualCouplingId());

    parentEntity.getHasSecondMutualCoupling().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the HasSecondMutualCoupling
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	MutualCoupling
   */
  public MutualCoupling removeFromHasSecondMutualCoupling(
      UUID parentId, MutualCoupling removeFrom) {
    LOGGER.info("handling RemoveHasSecondMutualCouplingFromMutualCouplingEvent ");

    MutualCoupling parentEntity = repository.findById(parentId).get();
    MutualCoupling child = MutualCouplingProjector.find(removeFrom.getMutualCouplingId());

    parentEntity.getHasSecondMutualCoupling().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the HasFirstMutualCoupling
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	MutualCoupling
   */
  public MutualCoupling addToHasFirstMutualCoupling(UUID parentId, MutualCoupling addTo) {
    LOGGER.info("handling AssignHasFirstMutualCouplingToMutualCouplingEvent - ");

    MutualCoupling parentEntity = repository.findById(parentId).get();
    MutualCoupling child = MutualCouplingProjector.find(addTo.getMutualCouplingId());

    parentEntity.getHasFirstMutualCoupling().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the HasFirstMutualCoupling
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	MutualCoupling
   */
  public MutualCoupling removeFromHasFirstMutualCoupling(UUID parentId, MutualCoupling removeFrom) {
    LOGGER.info("handling RemoveHasFirstMutualCouplingFromMutualCouplingEvent ");

    MutualCoupling parentEntity = repository.findById(parentId).get();
    MutualCoupling child = MutualCouplingProjector.find(removeFrom.getMutualCouplingId());

    parentEntity.getHasFirstMutualCoupling().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the MutualCoupling via an FindMutualCouplingQuery
   *
   * @return query FindMutualCouplingQuery
   */
  @SuppressWarnings("unused")
  public MutualCoupling find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a MutualCoupling - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all MutualCouplings
   *
   * @param query FindAllMutualCouplingQuery
   * @return List<MutualCoupling>
   */
  @SuppressWarnings("unused")
  public List<MutualCoupling> findAll(FindAllMutualCouplingQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all MutualCoupling - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final MutualCouplingRepository repository;

  @Autowired
  @Qualifier(value = "susceptance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SusceptanceEntityProjector
      SusceptanceProjector;

  @Autowired
  @Qualifier(value = "length-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .LengthEntityProjector
      LengthProjector;

  @Autowired
  @Qualifier(value = "conductance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ConductanceEntityProjector
      ConductanceProjector;

  @Autowired
  @Qualifier(value = "resistance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ResistanceEntityProjector
      ResistanceProjector;

  @Autowired
  @Qualifier(value = "reactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactanceEntityProjector
      ReactanceProjector;

  @Autowired
  @Qualifier(value = "mutualCoupling-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .MutualCouplingEntityProjector
      MutualCouplingProjector;

  private static final Logger LOGGER =
      Logger.getLogger(MutualCouplingEntityProjector.class.getName());
}
