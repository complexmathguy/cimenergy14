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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for PssWECC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PssWECCAggregate
 *
 * @author your_name_here
 */
@Component("pssWECC-entity-projector")
public class PssWECCEntityProjector {

  // core constructor
  public PssWECCEntityProjector(PssWECCRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PssWECC
   *
   * @param	entity PssWECC
   */
  public PssWECC create(PssWECC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PssWECC
   *
   * @param	entity PssWECC
   */
  public PssWECC update(PssWECC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PssWECC
   *
   * @param	id		UUID
   */
  public PssWECC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PssWECC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a K1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssWECC
   */
  public PssWECC assignK1(UUID parentId, PU assignment) {
    LOGGER.info("assigning K1 as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the K1 to the parent entity
    // ------------------------------------------
    parentEntity.setK1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K1
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignK1(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K1 on the parent entithy
    // ------------------------------------------
    parentEntity.setK1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a K2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssWECC
   */
  public PssWECC assignK2(UUID parentId, PU assignment) {
    LOGGER.info("assigning K2 as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the K2 to the parent entity
    // ------------------------------------------
    parentEntity.setK2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K2
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignK2(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K2 on the parent entithy
    // ------------------------------------------
    parentEntity.setK2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssWECC
   */
  public PssWECC assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T1 to the parent entity
    // ------------------------------------------
    parentEntity.setT1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T1
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignT1(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T1 on the parent entithy
    // ------------------------------------------
    parentEntity.setT1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T10
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssWECC
   */
  public PssWECC assignT10(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T10 as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T10 to the parent entity
    // ------------------------------------------
    parentEntity.setT10(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T10
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignT10(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T10 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T10 on the parent entithy
    // ------------------------------------------
    parentEntity.setT10(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssWECC
   */
  public PssWECC assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T2 to the parent entity
    // ------------------------------------------
    parentEntity.setT2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T2
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignT2(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T2 on the parent entithy
    // ------------------------------------------
    parentEntity.setT2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssWECC
   */
  public PssWECC assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T3 to the parent entity
    // ------------------------------------------
    parentEntity.setT3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T3
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignT3(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T3 on the parent entithy
    // ------------------------------------------
    parentEntity.setT3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T4
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssWECC
   */
  public PssWECC assignT4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4 as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T4 to the parent entity
    // ------------------------------------------
    parentEntity.setT4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T4
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignT4(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T4 on the parent entithy
    // ------------------------------------------
    parentEntity.setT4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T5
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssWECC
   */
  public PssWECC assignT5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T5 as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T5 to the parent entity
    // ------------------------------------------
    parentEntity.setT5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T5
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignT5(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T5 on the parent entithy
    // ------------------------------------------
    parentEntity.setT5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T6
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssWECC
   */
  public PssWECC assignT6(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T6 as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T6 to the parent entity
    // ------------------------------------------
    parentEntity.setT6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T6
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignT6(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T6 on the parent entithy
    // ------------------------------------------
    parentEntity.setT6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T7
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssWECC
   */
  public PssWECC assignT7(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T7 as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T7 to the parent entity
    // ------------------------------------------
    parentEntity.setT7(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T7
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignT7(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T7 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T7 on the parent entithy
    // ------------------------------------------
    parentEntity.setT7(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T8
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssWECC
   */
  public PssWECC assignT8(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T8 as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T8 to the parent entity
    // ------------------------------------------
    parentEntity.setT8(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T8
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignT8(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T8 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T8 on the parent entithy
    // ------------------------------------------
    parentEntity.setT8(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T9
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssWECC
   */
  public PssWECC assignT9(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T9 as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T9 to the parent entity
    // ------------------------------------------
    parentEntity.setT9(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T9
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignT9(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T9 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T9 on the parent entithy
    // ------------------------------------------
    parentEntity.setT9(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vcl
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssWECC
   */
  public PssWECC assignVcl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vcl as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vcl to the parent entity
    // ------------------------------------------
    parentEntity.setVcl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vcl
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignVcl(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vcl on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vcl on the parent entithy
    // ------------------------------------------
    parentEntity.setVcl(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vcu
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssWECC
   */
  public PssWECC assignVcu(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vcu as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vcu to the parent entity
    // ------------------------------------------
    parentEntity.setVcu(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vcu
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignVcu(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vcu on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vcu on the parent entithy
    // ------------------------------------------
    parentEntity.setVcu(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vsmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssWECC
   */
  public PssWECC assignVsmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vsmax as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vsmax to the parent entity
    // ------------------------------------------
    parentEntity.setVsmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vsmax
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignVsmax(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vsmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vsmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVsmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vsmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssWECC
   */
  public PssWECC assignVsmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vsmin as " + assignment.toString());

    PssWECC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vsmin to the parent entity
    // ------------------------------------------
    parentEntity.setVsmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vsmin
   *
   * @param	parentId		UUID
   * @return	PssWECC
   */
  public PssWECC unAssignVsmin(UUID parentId) {
    PssWECC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vsmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vsmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVsmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PssWECC via an FindPssWECCQuery
   *
   * @return query FindPssWECCQuery
   */
  @SuppressWarnings("unused")
  public PssWECC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PssWECC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PssWECCs
   *
   * @param query FindAllPssWECCQuery
   * @return List<PssWECC>
   */
  @SuppressWarnings("unused")
  public List<PssWECC> findAll(FindAllPssWECCQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PssWECC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PssWECCRepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(PssWECCEntityProjector.class.getName());
}
