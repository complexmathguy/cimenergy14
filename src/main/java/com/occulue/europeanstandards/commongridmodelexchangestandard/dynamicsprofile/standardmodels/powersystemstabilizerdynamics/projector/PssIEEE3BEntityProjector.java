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
 * Projector for PssIEEE3B as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PssIEEE3BAggregate
 *
 * @author your_name_here
 */
@Component("pssIEEE3B-entity-projector")
public class PssIEEE3BEntityProjector {

  // core constructor
  public PssIEEE3BEntityProjector(PssIEEE3BRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PssIEEE3B
   *
   * @param	entity PssIEEE3B
   */
  public PssIEEE3B create(PssIEEE3B entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PssIEEE3B
   *
   * @param	entity PssIEEE3B
   */
  public PssIEEE3B update(PssIEEE3B entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PssIEEE3B
   *
   * @param	id		UUID
   */
  public PssIEEE3B delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PssIEEE3B entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a A1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignA1(UUID parentId, PU assignment) {
    LOGGER.info("assigning A1 as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A1 to the parent entity
    // ------------------------------------------
    parentEntity.setA1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A1
   *
   * @param	parentId		UUID
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignA1(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A1 on the parent entithy
    // ------------------------------------------
    parentEntity.setA1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a A2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignA2(UUID parentId, PU assignment) {
    LOGGER.info("assigning A2 as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A2 to the parent entity
    // ------------------------------------------
    parentEntity.setA2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A2
   *
   * @param	parentId		UUID
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignA2(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A2 on the parent entithy
    // ------------------------------------------
    parentEntity.setA2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a A3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignA3(UUID parentId, PU assignment) {
    LOGGER.info("assigning A3 as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A3 to the parent entity
    // ------------------------------------------
    parentEntity.setA3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A3
   *
   * @param	parentId		UUID
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignA3(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A3 on the parent entithy
    // ------------------------------------------
    parentEntity.setA3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a A4
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignA4(UUID parentId, PU assignment) {
    LOGGER.info("assigning A4 as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A4 to the parent entity
    // ------------------------------------------
    parentEntity.setA4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A4
   *
   * @param	parentId		UUID
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignA4(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A4 on the parent entithy
    // ------------------------------------------
    parentEntity.setA4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a A5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignA5(UUID parentId, PU assignment) {
    LOGGER.info("assigning A5 as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A5 to the parent entity
    // ------------------------------------------
    parentEntity.setA5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A5
   *
   * @param	parentId		UUID
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignA5(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A5 on the parent entithy
    // ------------------------------------------
    parentEntity.setA5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a A6
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignA6(UUID parentId, PU assignment) {
    LOGGER.info("assigning A6 as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A6 to the parent entity
    // ------------------------------------------
    parentEntity.setA6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A6
   *
   * @param	parentId		UUID
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignA6(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A6 on the parent entithy
    // ------------------------------------------
    parentEntity.setA6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a A7
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignA7(UUID parentId, PU assignment) {
    LOGGER.info("assigning A7 as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A7 to the parent entity
    // ------------------------------------------
    parentEntity.setA7(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A7
   *
   * @param	parentId		UUID
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignA7(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A7 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A7 on the parent entithy
    // ------------------------------------------
    parentEntity.setA7(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a A8
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignA8(UUID parentId, PU assignment) {
    LOGGER.info("assigning A8 as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the A8 to the parent entity
    // ------------------------------------------
    parentEntity.setA8(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A8
   *
   * @param	parentId		UUID
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignA8(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A8 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A8 on the parent entithy
    // ------------------------------------------
    parentEntity.setA8(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ks1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignKs1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ks1 as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ks1 to the parent entity
    // ------------------------------------------
    parentEntity.setKs1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ks1
   *
   * @param	parentId		UUID
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignKs1(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ks1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ks1 on the parent entithy
    // ------------------------------------------
    parentEntity.setKs1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ks2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignKs2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ks2 as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ks2 to the parent entity
    // ------------------------------------------
    parentEntity.setKs2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ks2
   *
   * @param	parentId		UUID
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignKs2(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ks2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ks2 on the parent entithy
    // ------------------------------------------
    parentEntity.setKs2(null);

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
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
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
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignT1(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

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
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
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
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignT2(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

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
   * Assign a Tw1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignTw1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw1 as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tw1 to the parent entity
    // ------------------------------------------
    parentEntity.setTw1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tw1
   *
   * @param	parentId		UUID
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignTw1(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tw1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tw1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTw1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tw2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignTw2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw2 as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tw2 to the parent entity
    // ------------------------------------------
    parentEntity.setTw2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tw2
   *
   * @param	parentId		UUID
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignTw2(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tw2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tw2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTw2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tw3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignTw3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw3 as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tw3 to the parent entity
    // ------------------------------------------
    parentEntity.setTw3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tw3
   *
   * @param	parentId		UUID
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignTw3(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tw3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tw3 on the parent entithy
    // ------------------------------------------
    parentEntity.setTw3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vstmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignVstmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vstmax as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vstmax to the parent entity
    // ------------------------------------------
    parentEntity.setVstmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vstmax
   *
   * @param	parentId		UUID
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignVstmax(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vstmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vstmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVstmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vstmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE3B
   */
  public PssIEEE3B assignVstmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vstmin as " + assignment.toString());

    PssIEEE3B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vstmin to the parent entity
    // ------------------------------------------
    parentEntity.setVstmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vstmin
   *
   * @param	parentId		UUID
   * @return	PssIEEE3B
   */
  public PssIEEE3B unAssignVstmin(UUID parentId) {
    PssIEEE3B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vstmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vstmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVstmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PssIEEE3B via an FindPssIEEE3BQuery
   *
   * @return query FindPssIEEE3BQuery
   */
  @SuppressWarnings("unused")
  public PssIEEE3B find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PssIEEE3B - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PssIEEE3Bs
   *
   * @param query FindAllPssIEEE3BQuery
   * @return List<PssIEEE3B>
   */
  @SuppressWarnings("unused")
  public List<PssIEEE3B> findAll(FindAllPssIEEE3BQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PssIEEE3B - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PssIEEE3BRepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(PssIEEE3BEntityProjector.class.getName());
}
