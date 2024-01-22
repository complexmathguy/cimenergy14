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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for UnderexcLimIEEE1 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by UnderexcLimIEEE1Aggregate
 *
 * @author your_name_here
 */
@Component("underexcLimIEEE1-entity-projector")
public class UnderexcLimIEEE1EntityProjector {

  // core constructor
  public UnderexcLimIEEE1EntityProjector(UnderexcLimIEEE1Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a UnderexcLimIEEE1
   *
   * @param	entity UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 create(UnderexcLimIEEE1 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a UnderexcLimIEEE1
   *
   * @param	entity UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 update(UnderexcLimIEEE1 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a UnderexcLimIEEE1
   *
   * @param	id		UUID
   */
  public UnderexcLimIEEE1 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    UnderexcLimIEEE1 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Kuc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 assignKuc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kuc as " + assignment.toString());

    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kuc to the parent entity
    // ------------------------------------------
    parentEntity.setKuc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kuc
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 unAssignKuc(UUID parentId) {
    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kuc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kuc on the parent entithy
    // ------------------------------------------
    parentEntity.setKuc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kuf
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 assignKuf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kuf as " + assignment.toString());

    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kuf to the parent entity
    // ------------------------------------------
    parentEntity.setKuf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kuf
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 unAssignKuf(UUID parentId) {
    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kuf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kuf on the parent entithy
    // ------------------------------------------
    parentEntity.setKuf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kui
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 assignKui(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kui as " + assignment.toString());

    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kui to the parent entity
    // ------------------------------------------
    parentEntity.setKui(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kui
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 unAssignKui(UUID parentId) {
    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kui on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kui on the parent entithy
    // ------------------------------------------
    parentEntity.setKui(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kul
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 assignKul(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kul as " + assignment.toString());

    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kul to the parent entity
    // ------------------------------------------
    parentEntity.setKul(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kul
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 unAssignKul(UUID parentId) {
    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kul on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kul on the parent entithy
    // ------------------------------------------
    parentEntity.setKul(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kur
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 assignKur(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kur as " + assignment.toString());

    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kur to the parent entity
    // ------------------------------------------
    parentEntity.setKur(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kur
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 unAssignKur(UUID parentId) {
    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kur on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kur on the parent entithy
    // ------------------------------------------
    parentEntity.setKur(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tu1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 assignTu1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tu1 as " + assignment.toString());

    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tu1 to the parent entity
    // ------------------------------------------
    parentEntity.setTu1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tu1
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 unAssignTu1(UUID parentId) {
    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tu1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tu1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTu1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tu2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 assignTu2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tu2 as " + assignment.toString());

    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tu2 to the parent entity
    // ------------------------------------------
    parentEntity.setTu2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tu2
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 unAssignTu2(UUID parentId) {
    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tu2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tu2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTu2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tu3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 assignTu3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tu3 as " + assignment.toString());

    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tu3 to the parent entity
    // ------------------------------------------
    parentEntity.setTu3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tu3
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 unAssignTu3(UUID parentId) {
    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tu3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tu3 on the parent entithy
    // ------------------------------------------
    parentEntity.setTu3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tu4
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 assignTu4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tu4 as " + assignment.toString());

    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tu4 to the parent entity
    // ------------------------------------------
    parentEntity.setTu4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tu4
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 unAssignTu4(UUID parentId) {
    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tu4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tu4 on the parent entithy
    // ------------------------------------------
    parentEntity.setTu4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vucmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 assignVucmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vucmax as " + assignment.toString());

    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vucmax to the parent entity
    // ------------------------------------------
    parentEntity.setVucmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vucmax
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 unAssignVucmax(UUID parentId) {
    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vucmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vucmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVucmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vuimax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 assignVuimax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vuimax as " + assignment.toString());

    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vuimax to the parent entity
    // ------------------------------------------
    parentEntity.setVuimax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vuimax
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 unAssignVuimax(UUID parentId) {
    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vuimax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vuimax on the parent entithy
    // ------------------------------------------
    parentEntity.setVuimax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vuimin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 assignVuimin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vuimin as " + assignment.toString());

    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vuimin to the parent entity
    // ------------------------------------------
    parentEntity.setVuimin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vuimin
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 unAssignVuimin(UUID parentId) {
    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vuimin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vuimin on the parent entithy
    // ------------------------------------------
    parentEntity.setVuimin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vulmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 assignVulmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vulmax as " + assignment.toString());

    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vulmax to the parent entity
    // ------------------------------------------
    parentEntity.setVulmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vulmax
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 unAssignVulmax(UUID parentId) {
    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vulmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vulmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVulmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vulmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 assignVulmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vulmin as " + assignment.toString());

    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vulmin to the parent entity
    // ------------------------------------------
    parentEntity.setVulmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vulmin
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 unAssignVulmin(UUID parentId) {
    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vulmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vulmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVulmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vurmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 assignVurmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vurmax as " + assignment.toString());

    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vurmax to the parent entity
    // ------------------------------------------
    parentEntity.setVurmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vurmax
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE1
   */
  public UnderexcLimIEEE1 unAssignVurmax(UUID parentId) {
    UnderexcLimIEEE1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vurmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vurmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVurmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the UnderexcLimIEEE1 via an FindUnderexcLimIEEE1Query
   *
   * @return query FindUnderexcLimIEEE1Query
   */
  @SuppressWarnings("unused")
  public UnderexcLimIEEE1 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a UnderexcLimIEEE1 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all UnderexcLimIEEE1s
   *
   * @param query FindAllUnderexcLimIEEE1Query
   * @return List<UnderexcLimIEEE1>
   */
  @SuppressWarnings("unused")
  public List<UnderexcLimIEEE1> findAll(FindAllUnderexcLimIEEE1Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all UnderexcLimIEEE1 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final UnderexcLimIEEE1Repository repository;

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

  private static final Logger LOGGER =
      Logger.getLogger(UnderexcLimIEEE1EntityProjector.class.getName());
}
