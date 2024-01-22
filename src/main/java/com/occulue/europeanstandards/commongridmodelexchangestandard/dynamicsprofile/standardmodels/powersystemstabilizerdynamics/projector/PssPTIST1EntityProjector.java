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
 * Projector for PssPTIST1 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PssPTIST1Aggregate
 *
 * @author your_name_here
 */
@Component("pssPTIST1-entity-projector")
public class PssPTIST1EntityProjector {

  // core constructor
  public PssPTIST1EntityProjector(PssPTIST1Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PssPTIST1
   *
   * @param	entity PssPTIST1
   */
  public PssPTIST1 create(PssPTIST1 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PssPTIST1
   *
   * @param	entity PssPTIST1
   */
  public PssPTIST1 update(PssPTIST1 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PssPTIST1
   *
   * @param	id		UUID
   */
  public PssPTIST1 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PssPTIST1 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Dtc
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssPTIST1
   */
  public PssPTIST1 assignDtc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Dtc as " + assignment.toString());

    PssPTIST1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Dtc to the parent entity
    // ------------------------------------------
    parentEntity.setDtc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dtc
   *
   * @param	parentId		UUID
   * @return	PssPTIST1
   */
  public PssPTIST1 unAssignDtc(UUID parentId) {
    PssPTIST1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dtc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dtc on the parent entithy
    // ------------------------------------------
    parentEntity.setDtc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dtf
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssPTIST1
   */
  public PssPTIST1 assignDtf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Dtf as " + assignment.toString());

    PssPTIST1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Dtf to the parent entity
    // ------------------------------------------
    parentEntity.setDtf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dtf
   *
   * @param	parentId		UUID
   * @return	PssPTIST1
   */
  public PssPTIST1 unAssignDtf(UUID parentId) {
    PssPTIST1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dtf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dtf on the parent entithy
    // ------------------------------------------
    parentEntity.setDtf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dtp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssPTIST1
   */
  public PssPTIST1 assignDtp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Dtp as " + assignment.toString());

    PssPTIST1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Dtp to the parent entity
    // ------------------------------------------
    parentEntity.setDtp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dtp
   *
   * @param	parentId		UUID
   * @return	PssPTIST1
   */
  public PssPTIST1 unAssignDtp(UUID parentId) {
    PssPTIST1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dtp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dtp on the parent entithy
    // ------------------------------------------
    parentEntity.setDtp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a K
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssPTIST1
   */
  public PssPTIST1 assignK(UUID parentId, PU assignment) {
    LOGGER.info("assigning K as " + assignment.toString());

    PssPTIST1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the K to the parent entity
    // ------------------------------------------
    parentEntity.setK(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K
   *
   * @param	parentId		UUID
   * @return	PssPTIST1
   */
  public PssPTIST1 unAssignK(UUID parentId) {
    PssPTIST1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K on the parent entithy
    // ------------------------------------------
    parentEntity.setK(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a M
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssPTIST1
   */
  public PssPTIST1 assignM(UUID parentId, PU assignment) {
    LOGGER.info("assigning M as " + assignment.toString());

    PssPTIST1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the M to the parent entity
    // ------------------------------------------
    parentEntity.setM(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the M
   *
   * @param	parentId		UUID
   * @return	PssPTIST1
   */
  public PssPTIST1 unAssignM(UUID parentId) {
    PssPTIST1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning M on " + parentEntity.toString());

    // ------------------------------------------
    // null out the M on the parent entithy
    // ------------------------------------------
    parentEntity.setM(null);

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
   * @return	PssPTIST1
   */
  public PssPTIST1 assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    PssPTIST1 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST1
   */
  public PssPTIST1 unAssignT1(UUID parentId) {
    PssPTIST1 parentEntity = repository.findById(parentId).get();

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
   * Assign a T2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssPTIST1
   */
  public PssPTIST1 assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    PssPTIST1 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST1
   */
  public PssPTIST1 unAssignT2(UUID parentId) {
    PssPTIST1 parentEntity = repository.findById(parentId).get();

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
   * @return	PssPTIST1
   */
  public PssPTIST1 assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    PssPTIST1 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST1
   */
  public PssPTIST1 unAssignT3(UUID parentId) {
    PssPTIST1 parentEntity = repository.findById(parentId).get();

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
   * @return	PssPTIST1
   */
  public PssPTIST1 assignT4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4 as " + assignment.toString());

    PssPTIST1 parentEntity = repository.findById(parentId).get();
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
   * @return	PssPTIST1
   */
  public PssPTIST1 unAssignT4(UUID parentId) {
    PssPTIST1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tf
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssPTIST1
   */
  public PssPTIST1 assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    PssPTIST1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tf to the parent entity
    // ------------------------------------------
    parentEntity.setTf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tf
   *
   * @param	parentId		UUID
   * @return	PssPTIST1
   */
  public PssPTIST1 unAssignTf(UUID parentId) {
    PssPTIST1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tf on the parent entithy
    // ------------------------------------------
    parentEntity.setTf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssPTIST1
   */
  public PssPTIST1 assignTp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tp as " + assignment.toString());

    PssPTIST1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tp to the parent entity
    // ------------------------------------------
    parentEntity.setTp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tp
   *
   * @param	parentId		UUID
   * @return	PssPTIST1
   */
  public PssPTIST1 unAssignTp(UUID parentId) {
    PssPTIST1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tp on the parent entithy
    // ------------------------------------------
    parentEntity.setTp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PssPTIST1 via an FindPssPTIST1Query
   *
   * @return query FindPssPTIST1Query
   */
  @SuppressWarnings("unused")
  public PssPTIST1 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PssPTIST1 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PssPTIST1s
   *
   * @param query FindAllPssPTIST1Query
   * @return List<PssPTIST1>
   */
  @SuppressWarnings("unused")
  public List<PssPTIST1> findAll(FindAllPssPTIST1Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PssPTIST1 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PssPTIST1Repository repository;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  private static final Logger LOGGER = Logger.getLogger(PssPTIST1EntityProjector.class.getName());
}
