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
 * Projector for EquivalentBranch as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by EquivalentBranchAggregate
 *
 * @author your_name_here
 */
@Component("equivalentBranch-entity-projector")
public class EquivalentBranchEntityProjector {

  // core constructor
  public EquivalentBranchEntityProjector(EquivalentBranchRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a EquivalentBranch
   *
   * @param	entity EquivalentBranch
   */
  public EquivalentBranch create(EquivalentBranch entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a EquivalentBranch
   *
   * @param	entity EquivalentBranch
   */
  public EquivalentBranch update(EquivalentBranch entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a EquivalentBranch
   *
   * @param	id		UUID
   */
  public EquivalentBranch delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    EquivalentBranch entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a NegativeR12
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignNegativeR12(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning NegativeR12 as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the NegativeR12 to the parent entity
    // ------------------------------------------
    parentEntity.setNegativeR12(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NegativeR12
   *
   * @param	parentId		UUID
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignNegativeR12(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NegativeR12 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NegativeR12 on the parent entithy
    // ------------------------------------------
    parentEntity.setNegativeR12(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NegativeR21
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignNegativeR21(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning NegativeR21 as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the NegativeR21 to the parent entity
    // ------------------------------------------
    parentEntity.setNegativeR21(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NegativeR21
   *
   * @param	parentId		UUID
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignNegativeR21(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NegativeR21 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NegativeR21 on the parent entithy
    // ------------------------------------------
    parentEntity.setNegativeR21(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NegativeX12
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignNegativeX12(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning NegativeX12 as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the NegativeX12 to the parent entity
    // ------------------------------------------
    parentEntity.setNegativeX12(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NegativeX12
   *
   * @param	parentId		UUID
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignNegativeX12(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NegativeX12 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NegativeX12 on the parent entithy
    // ------------------------------------------
    parentEntity.setNegativeX12(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NegativeX21
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignNegativeX21(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning NegativeX21 as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the NegativeX21 to the parent entity
    // ------------------------------------------
    parentEntity.setNegativeX21(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NegativeX21
   *
   * @param	parentId		UUID
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignNegativeX21(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NegativeX21 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NegativeX21 on the parent entithy
    // ------------------------------------------
    parentEntity.setNegativeX21(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a PositiveR12
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignPositiveR12(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning PositiveR12 as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the PositiveR12 to the parent entity
    // ------------------------------------------
    parentEntity.setPositiveR12(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PositiveR12
   *
   * @param	parentId		UUID
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignPositiveR12(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PositiveR12 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PositiveR12 on the parent entithy
    // ------------------------------------------
    parentEntity.setPositiveR12(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a PositiveR21
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignPositiveR21(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning PositiveR21 as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the PositiveR21 to the parent entity
    // ------------------------------------------
    parentEntity.setPositiveR21(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PositiveR21
   *
   * @param	parentId		UUID
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignPositiveR21(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PositiveR21 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PositiveR21 on the parent entithy
    // ------------------------------------------
    parentEntity.setPositiveR21(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a PositiveX12
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignPositiveX12(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning PositiveX12 as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the PositiveX12 to the parent entity
    // ------------------------------------------
    parentEntity.setPositiveX12(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PositiveX12
   *
   * @param	parentId		UUID
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignPositiveX12(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PositiveX12 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PositiveX12 on the parent entithy
    // ------------------------------------------
    parentEntity.setPositiveX12(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a PositiveX21
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignPositiveX21(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning PositiveX21 as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the PositiveX21 to the parent entity
    // ------------------------------------------
    parentEntity.setPositiveX21(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the PositiveX21
   *
   * @param	parentId		UUID
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignPositiveX21(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning PositiveX21 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the PositiveX21 on the parent entithy
    // ------------------------------------------
    parentEntity.setPositiveX21(null);

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
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignR(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning R as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
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
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignR(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

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
   * Assign a R21
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignR21(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning R21 as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the R21 to the parent entity
    // ------------------------------------------
    parentEntity.setR21(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R21
   *
   * @param	parentId		UUID
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignR21(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R21 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R21 on the parent entithy
    // ------------------------------------------
    parentEntity.setR21(null);

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
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignX(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning X as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
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
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignX(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

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
   * Assign a X21
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignX21(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning X21 as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the X21 to the parent entity
    // ------------------------------------------
    parentEntity.setX21(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X21
   *
   * @param	parentId		UUID
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignX21(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X21 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X21 on the parent entithy
    // ------------------------------------------
    parentEntity.setX21(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ZeroR12
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignZeroR12(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning ZeroR12 as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the ZeroR12 to the parent entity
    // ------------------------------------------
    parentEntity.setZeroR12(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ZeroR12
   *
   * @param	parentId		UUID
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignZeroR12(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ZeroR12 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ZeroR12 on the parent entithy
    // ------------------------------------------
    parentEntity.setZeroR12(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ZeroR21
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignZeroR21(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning ZeroR21 as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the ZeroR21 to the parent entity
    // ------------------------------------------
    parentEntity.setZeroR21(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ZeroR21
   *
   * @param	parentId		UUID
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignZeroR21(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ZeroR21 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ZeroR21 on the parent entithy
    // ------------------------------------------
    parentEntity.setZeroR21(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ZeroX12
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignZeroX12(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning ZeroX12 as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the ZeroX12 to the parent entity
    // ------------------------------------------
    parentEntity.setZeroX12(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ZeroX12
   *
   * @param	parentId		UUID
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignZeroX12(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ZeroX12 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ZeroX12 on the parent entithy
    // ------------------------------------------
    parentEntity.setZeroX12(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ZeroX21
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	EquivalentBranch
   */
  public EquivalentBranch assignZeroX21(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning ZeroX21 as " + assignment.toString());

    EquivalentBranch parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the ZeroX21 to the parent entity
    // ------------------------------------------
    parentEntity.setZeroX21(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ZeroX21
   *
   * @param	parentId		UUID
   * @return	EquivalentBranch
   */
  public EquivalentBranch unAssignZeroX21(UUID parentId) {
    EquivalentBranch parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ZeroX21 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ZeroX21 on the parent entithy
    // ------------------------------------------
    parentEntity.setZeroX21(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the EquivalentBranch via an FindEquivalentBranchQuery
   *
   * @return query FindEquivalentBranchQuery
   */
  @SuppressWarnings("unused")
  public EquivalentBranch find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a EquivalentBranch - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all EquivalentBranchs
   *
   * @param query FindAllEquivalentBranchQuery
   * @return List<EquivalentBranch>
   */
  @SuppressWarnings("unused")
  public List<EquivalentBranch> findAll(FindAllEquivalentBranchQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all EquivalentBranch - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final EquivalentBranchRepository repository;

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

  private static final Logger LOGGER =
      Logger.getLogger(EquivalentBranchEntityProjector.class.getName());
}
