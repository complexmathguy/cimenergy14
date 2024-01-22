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
 * Projector for PssELIN2 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PssELIN2Aggregate
 *
 * @author your_name_here
 */
@Component("pssELIN2-entity-projector")
public class PssELIN2EntityProjector {

  // core constructor
  public PssELIN2EntityProjector(PssELIN2Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PssELIN2
   *
   * @param	entity PssELIN2
   */
  public PssELIN2 create(PssELIN2 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PssELIN2
   *
   * @param	entity PssELIN2
   */
  public PssELIN2 update(PssELIN2 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PssELIN2
   *
   * @param	id		UUID
   */
  public PssELIN2 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PssELIN2 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Apss
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssELIN2
   */
  public PssELIN2 assignApss(UUID parentId, PU assignment) {
    LOGGER.info("assigning Apss as " + assignment.toString());

    PssELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Apss to the parent entity
    // ------------------------------------------
    parentEntity.setApss(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Apss
   *
   * @param	parentId		UUID
   * @return	PssELIN2
   */
  public PssELIN2 unAssignApss(UUID parentId) {
    PssELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Apss on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Apss on the parent entithy
    // ------------------------------------------
    parentEntity.setApss(null);

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
   * @return	PssELIN2
   */
  public PssELIN2 assignKs1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ks1 as " + assignment.toString());

    PssELIN2 parentEntity = repository.findById(parentId).get();
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
   * @return	PssELIN2
   */
  public PssELIN2 unAssignKs1(UUID parentId) {
    PssELIN2 parentEntity = repository.findById(parentId).get();

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
   * @return	PssELIN2
   */
  public PssELIN2 assignKs2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ks2 as " + assignment.toString());

    PssELIN2 parentEntity = repository.findById(parentId).get();
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
   * @return	PssELIN2
   */
  public PssELIN2 unAssignKs2(UUID parentId) {
    PssELIN2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Ppss
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssELIN2
   */
  public PssELIN2 assignPpss(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ppss as " + assignment.toString());

    PssELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ppss to the parent entity
    // ------------------------------------------
    parentEntity.setPpss(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ppss
   *
   * @param	parentId		UUID
   * @return	PssELIN2
   */
  public PssELIN2 unAssignPpss(UUID parentId) {
    PssELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ppss on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ppss on the parent entithy
    // ------------------------------------------
    parentEntity.setPpss(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Psslim
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssELIN2
   */
  public PssELIN2 assignPsslim(UUID parentId, PU assignment) {
    LOGGER.info("assigning Psslim as " + assignment.toString());

    PssELIN2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Psslim to the parent entity
    // ------------------------------------------
    parentEntity.setPsslim(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Psslim
   *
   * @param	parentId		UUID
   * @return	PssELIN2
   */
  public PssELIN2 unAssignPsslim(UUID parentId) {
    PssELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Psslim on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Psslim on the parent entithy
    // ------------------------------------------
    parentEntity.setPsslim(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ts1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssELIN2
   */
  public PssELIN2 assignTs1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ts1 as " + assignment.toString());

    PssELIN2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ts1 to the parent entity
    // ------------------------------------------
    parentEntity.setTs1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ts1
   *
   * @param	parentId		UUID
   * @return	PssELIN2
   */
  public PssELIN2 unAssignTs1(UUID parentId) {
    PssELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ts1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ts1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTs1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ts2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssELIN2
   */
  public PssELIN2 assignTs2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ts2 as " + assignment.toString());

    PssELIN2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ts2 to the parent entity
    // ------------------------------------------
    parentEntity.setTs2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ts2
   *
   * @param	parentId		UUID
   * @return	PssELIN2
   */
  public PssELIN2 unAssignTs2(UUID parentId) {
    PssELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ts2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ts2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTs2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ts3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssELIN2
   */
  public PssELIN2 assignTs3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ts3 as " + assignment.toString());

    PssELIN2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ts3 to the parent entity
    // ------------------------------------------
    parentEntity.setTs3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ts3
   *
   * @param	parentId		UUID
   * @return	PssELIN2
   */
  public PssELIN2 unAssignTs3(UUID parentId) {
    PssELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ts3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ts3 on the parent entithy
    // ------------------------------------------
    parentEntity.setTs3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ts4
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssELIN2
   */
  public PssELIN2 assignTs4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ts4 as " + assignment.toString());

    PssELIN2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ts4 to the parent entity
    // ------------------------------------------
    parentEntity.setTs4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ts4
   *
   * @param	parentId		UUID
   * @return	PssELIN2
   */
  public PssELIN2 unAssignTs4(UUID parentId) {
    PssELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ts4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ts4 on the parent entithy
    // ------------------------------------------
    parentEntity.setTs4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ts5
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssELIN2
   */
  public PssELIN2 assignTs5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ts5 as " + assignment.toString());

    PssELIN2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ts5 to the parent entity
    // ------------------------------------------
    parentEntity.setTs5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ts5
   *
   * @param	parentId		UUID
   * @return	PssELIN2
   */
  public PssELIN2 unAssignTs5(UUID parentId) {
    PssELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ts5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ts5 on the parent entithy
    // ------------------------------------------
    parentEntity.setTs5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ts6
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssELIN2
   */
  public PssELIN2 assignTs6(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ts6 as " + assignment.toString());

    PssELIN2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ts6 to the parent entity
    // ------------------------------------------
    parentEntity.setTs6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ts6
   *
   * @param	parentId		UUID
   * @return	PssELIN2
   */
  public PssELIN2 unAssignTs6(UUID parentId) {
    PssELIN2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ts6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ts6 on the parent entithy
    // ------------------------------------------
    parentEntity.setTs6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PssELIN2 via an FindPssELIN2Query
   *
   * @return query FindPssELIN2Query
   */
  @SuppressWarnings("unused")
  public PssELIN2 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PssELIN2 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PssELIN2s
   *
   * @param query FindAllPssELIN2Query
   * @return List<PssELIN2>
   */
  @SuppressWarnings("unused")
  public List<PssELIN2> findAll(FindAllPssELIN2Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PssELIN2 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PssELIN2Repository repository;

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

  private static final Logger LOGGER = Logger.getLogger(PssELIN2EntityProjector.class.getName());
}
