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
 * Projector for Pss2ST as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by Pss2STAggregate
 *
 * @author your_name_here
 */
@Component("pss2ST-entity-projector")
public class Pss2STEntityProjector {

  // core constructor
  public Pss2STEntityProjector(Pss2STRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Pss2ST
   *
   * @param	entity Pss2ST
   */
  public Pss2ST create(Pss2ST entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Pss2ST
   *
   * @param	entity Pss2ST
   */
  public Pss2ST update(Pss2ST entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Pss2ST
   *
   * @param	id		UUID
   */
  public Pss2ST delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Pss2ST entity = repository.findById(id).get();

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
   * @return	Pss2ST
   */
  public Pss2ST assignK1(UUID parentId, PU assignment) {
    LOGGER.info("assigning K1 as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2ST
   */
  public Pss2ST unAssignK1(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

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
   * @return	Pss2ST
   */
  public Pss2ST assignK2(UUID parentId, PU assignment) {
    LOGGER.info("assigning K2 as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2ST
   */
  public Pss2ST unAssignK2(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

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
   * Assign a Lsmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss2ST
   */
  public Pss2ST assignLsmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Lsmax as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Lsmax to the parent entity
    // ------------------------------------------
    parentEntity.setLsmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Lsmax
   *
   * @param	parentId		UUID
   * @return	Pss2ST
   */
  public Pss2ST unAssignLsmax(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Lsmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Lsmax on the parent entithy
    // ------------------------------------------
    parentEntity.setLsmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Lsmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss2ST
   */
  public Pss2ST assignLsmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Lsmin as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Lsmin to the parent entity
    // ------------------------------------------
    parentEntity.setLsmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Lsmin
   *
   * @param	parentId		UUID
   * @return	Pss2ST
   */
  public Pss2ST unAssignLsmin(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Lsmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Lsmin on the parent entithy
    // ------------------------------------------
    parentEntity.setLsmin(null);

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
   * @return	Pss2ST
   */
  public Pss2ST assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2ST
   */
  public Pss2ST unAssignT1(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

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
   * @return	Pss2ST
   */
  public Pss2ST assignT10(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T10 as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2ST
   */
  public Pss2ST unAssignT10(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

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
   * @return	Pss2ST
   */
  public Pss2ST assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2ST
   */
  public Pss2ST unAssignT2(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

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
   * @return	Pss2ST
   */
  public Pss2ST assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2ST
   */
  public Pss2ST unAssignT3(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

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
   * @return	Pss2ST
   */
  public Pss2ST assignT4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4 as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2ST
   */
  public Pss2ST unAssignT4(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

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
   * @return	Pss2ST
   */
  public Pss2ST assignT5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T5 as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2ST
   */
  public Pss2ST unAssignT5(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

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
   * @return	Pss2ST
   */
  public Pss2ST assignT6(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T6 as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2ST
   */
  public Pss2ST unAssignT6(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

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
   * @return	Pss2ST
   */
  public Pss2ST assignT7(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T7 as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2ST
   */
  public Pss2ST unAssignT7(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

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
   * @return	Pss2ST
   */
  public Pss2ST assignT8(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T8 as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2ST
   */
  public Pss2ST unAssignT8(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

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
   * @return	Pss2ST
   */
  public Pss2ST assignT9(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T9 as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2ST
   */
  public Pss2ST unAssignT9(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

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
   * @return	Pss2ST
   */
  public Pss2ST assignVcl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vcl as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2ST
   */
  public Pss2ST unAssignVcl(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

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
   * @return	Pss2ST
   */
  public Pss2ST assignVcu(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vcu as " + assignment.toString());

    Pss2ST parentEntity = repository.findById(parentId).get();
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
   * @return	Pss2ST
   */
  public Pss2ST unAssignVcu(UUID parentId) {
    Pss2ST parentEntity = repository.findById(parentId).get();

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

  /**
   * Method to retrieve the Pss2ST via an FindPss2STQuery
   *
   * @return query FindPss2STQuery
   */
  @SuppressWarnings("unused")
  public Pss2ST find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Pss2ST - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Pss2STs
   *
   * @param query FindAllPss2STQuery
   * @return List<Pss2ST>
   */
  @SuppressWarnings("unused")
  public List<Pss2ST> findAll(FindAllPss2STQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Pss2ST - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final Pss2STRepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(Pss2STEntityProjector.class.getName());
}
