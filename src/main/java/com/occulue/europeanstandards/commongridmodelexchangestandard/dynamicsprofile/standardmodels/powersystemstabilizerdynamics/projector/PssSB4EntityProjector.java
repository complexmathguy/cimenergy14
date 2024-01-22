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
 * Projector for PssSB4 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PssSB4Aggregate
 *
 * @author your_name_here
 */
@Component("pssSB4-entity-projector")
public class PssSB4EntityProjector {

  // core constructor
  public PssSB4EntityProjector(PssSB4Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PssSB4
   *
   * @param	entity PssSB4
   */
  public PssSB4 create(PssSB4 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PssSB4
   *
   * @param	entity PssSB4
   */
  public PssSB4 update(PssSB4 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PssSB4
   *
   * @param	id		UUID
   */
  public PssSB4 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PssSB4 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Kx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssSB4
   */
  public PssSB4 assignKx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kx as " + assignment.toString());

    PssSB4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kx to the parent entity
    // ------------------------------------------
    parentEntity.setKx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kx
   *
   * @param	parentId		UUID
   * @return	PssSB4
   */
  public PssSB4 unAssignKx(UUID parentId) {
    PssSB4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kx on the parent entithy
    // ------------------------------------------
    parentEntity.setKx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ta
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssSB4
   */
  public PssSB4 assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    PssSB4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ta to the parent entity
    // ------------------------------------------
    parentEntity.setTa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ta
   *
   * @param	parentId		UUID
   * @return	PssSB4
   */
  public PssSB4 unAssignTa(UUID parentId) {
    PssSB4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ta on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ta on the parent entithy
    // ------------------------------------------
    parentEntity.setTa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tb
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssSB4
   */
  public PssSB4 assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    PssSB4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tb to the parent entity
    // ------------------------------------------
    parentEntity.setTb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tb
   *
   * @param	parentId		UUID
   * @return	PssSB4
   */
  public PssSB4 unAssignTb(UUID parentId) {
    PssSB4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tb on the parent entithy
    // ------------------------------------------
    parentEntity.setTb(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tc
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssSB4
   */
  public PssSB4 assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    PssSB4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tc to the parent entity
    // ------------------------------------------
    parentEntity.setTc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tc
   *
   * @param	parentId		UUID
   * @return	PssSB4
   */
  public PssSB4 unAssignTc(UUID parentId) {
    PssSB4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tc on the parent entithy
    // ------------------------------------------
    parentEntity.setTc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Td
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssSB4
   */
  public PssSB4 assignTd(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Td as " + assignment.toString());

    PssSB4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Td to the parent entity
    // ------------------------------------------
    parentEntity.setTd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Td
   *
   * @param	parentId		UUID
   * @return	PssSB4
   */
  public PssSB4 unAssignTd(UUID parentId) {
    PssSB4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Td on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Td on the parent entithy
    // ------------------------------------------
    parentEntity.setTd(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Te
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssSB4
   */
  public PssSB4 assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    PssSB4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Te to the parent entity
    // ------------------------------------------
    parentEntity.setTe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Te
   *
   * @param	parentId		UUID
   * @return	PssSB4
   */
  public PssSB4 unAssignTe(UUID parentId) {
    PssSB4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Te on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Te on the parent entithy
    // ------------------------------------------
    parentEntity.setTe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssSB4
   */
  public PssSB4 assignTt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tt as " + assignment.toString());

    PssSB4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tt to the parent entity
    // ------------------------------------------
    parentEntity.setTt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tt
   *
   * @param	parentId		UUID
   * @return	PssSB4
   */
  public PssSB4 unAssignTt(UUID parentId) {
    PssSB4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tt on the parent entithy
    // ------------------------------------------
    parentEntity.setTt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tx1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssSB4
   */
  public PssSB4 assignTx1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tx1 as " + assignment.toString());

    PssSB4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tx1 to the parent entity
    // ------------------------------------------
    parentEntity.setTx1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tx1
   *
   * @param	parentId		UUID
   * @return	PssSB4
   */
  public PssSB4 unAssignTx1(UUID parentId) {
    PssSB4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tx1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tx1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTx1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tx2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssSB4
   */
  public PssSB4 assignTx2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tx2 as " + assignment.toString());

    PssSB4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tx2 to the parent entity
    // ------------------------------------------
    parentEntity.setTx2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tx2
   *
   * @param	parentId		UUID
   * @return	PssSB4
   */
  public PssSB4 unAssignTx2(UUID parentId) {
    PssSB4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tx2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tx2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTx2(null);

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
   * @return	PssSB4
   */
  public PssSB4 assignVsmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vsmax as " + assignment.toString());

    PssSB4 parentEntity = repository.findById(parentId).get();
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
   * @return	PssSB4
   */
  public PssSB4 unAssignVsmax(UUID parentId) {
    PssSB4 parentEntity = repository.findById(parentId).get();

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
   * @return	PssSB4
   */
  public PssSB4 assignVsmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vsmin as " + assignment.toString());

    PssSB4 parentEntity = repository.findById(parentId).get();
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
   * @return	PssSB4
   */
  public PssSB4 unAssignVsmin(UUID parentId) {
    PssSB4 parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the PssSB4 via an FindPssSB4Query
   *
   * @return query FindPssSB4Query
   */
  @SuppressWarnings("unused")
  public PssSB4 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PssSB4 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PssSB4s
   *
   * @param query FindAllPssSB4Query
   * @return List<PssSB4>
   */
  @SuppressWarnings("unused")
  public List<PssSB4> findAll(FindAllPssSB4Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PssSB4 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PssSB4Repository repository;

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

  private static final Logger LOGGER = Logger.getLogger(PssSB4EntityProjector.class.getName());
}
