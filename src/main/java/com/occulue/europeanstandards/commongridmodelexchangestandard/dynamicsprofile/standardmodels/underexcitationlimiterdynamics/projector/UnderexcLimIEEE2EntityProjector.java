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
 * Projector for UnderexcLimIEEE2 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by UnderexcLimIEEE2Aggregate
 *
 * @author your_name_here
 */
@Component("underexcLimIEEE2-entity-projector")
public class UnderexcLimIEEE2EntityProjector {

  // core constructor
  public UnderexcLimIEEE2EntityProjector(UnderexcLimIEEE2Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a UnderexcLimIEEE2
   *
   * @param	entity UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 create(UnderexcLimIEEE2 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a UnderexcLimIEEE2
   *
   * @param	entity UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 update(UnderexcLimIEEE2 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a UnderexcLimIEEE2
   *
   * @param	id		UUID
   */
  public UnderexcLimIEEE2 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    UnderexcLimIEEE2 entity = repository.findById(id).get();

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
   * @param	assignment 	Simple_Float
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignK1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K1 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignK1(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	Simple_Float
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignK2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K2 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignK2(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Kfb
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignKfb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kfb as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kfb to the parent entity
    // ------------------------------------------
    parentEntity.setKfb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kfb
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignKfb(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kfb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kfb on the parent entithy
    // ------------------------------------------
    parentEntity.setKfb(null);

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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignKuf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kuf as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignKuf(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignKui(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kui as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignKui(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignKul(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kul as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignKul(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

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
   * Assign a P0
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignP0(UUID parentId, PU assignment) {
    LOGGER.info("assigning P0 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P0 to the parent entity
    // ------------------------------------------
    parentEntity.setP0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P0
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignP0(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P0 on the parent entithy
    // ------------------------------------------
    parentEntity.setP0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a P1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignP1(UUID parentId, PU assignment) {
    LOGGER.info("assigning P1 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P1 to the parent entity
    // ------------------------------------------
    parentEntity.setP1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P1
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignP1(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P1 on the parent entithy
    // ------------------------------------------
    parentEntity.setP1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a P10
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignP10(UUID parentId, PU assignment) {
    LOGGER.info("assigning P10 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P10 to the parent entity
    // ------------------------------------------
    parentEntity.setP10(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P10
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignP10(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P10 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P10 on the parent entithy
    // ------------------------------------------
    parentEntity.setP10(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a P2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignP2(UUID parentId, PU assignment) {
    LOGGER.info("assigning P2 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P2 to the parent entity
    // ------------------------------------------
    parentEntity.setP2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P2
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignP2(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P2 on the parent entithy
    // ------------------------------------------
    parentEntity.setP2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a P3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignP3(UUID parentId, PU assignment) {
    LOGGER.info("assigning P3 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P3 to the parent entity
    // ------------------------------------------
    parentEntity.setP3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P3
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignP3(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P3 on the parent entithy
    // ------------------------------------------
    parentEntity.setP3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a P4
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignP4(UUID parentId, PU assignment) {
    LOGGER.info("assigning P4 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P4 to the parent entity
    // ------------------------------------------
    parentEntity.setP4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P4
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignP4(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P4 on the parent entithy
    // ------------------------------------------
    parentEntity.setP4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a P5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignP5(UUID parentId, PU assignment) {
    LOGGER.info("assigning P5 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P5 to the parent entity
    // ------------------------------------------
    parentEntity.setP5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P5
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignP5(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P5 on the parent entithy
    // ------------------------------------------
    parentEntity.setP5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a P6
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignP6(UUID parentId, PU assignment) {
    LOGGER.info("assigning P6 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P6 to the parent entity
    // ------------------------------------------
    parentEntity.setP6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P6
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignP6(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P6 on the parent entithy
    // ------------------------------------------
    parentEntity.setP6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a P7
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignP7(UUID parentId, PU assignment) {
    LOGGER.info("assigning P7 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P7 to the parent entity
    // ------------------------------------------
    parentEntity.setP7(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P7
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignP7(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P7 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P7 on the parent entithy
    // ------------------------------------------
    parentEntity.setP7(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a P8
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignP8(UUID parentId, PU assignment) {
    LOGGER.info("assigning P8 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P8 to the parent entity
    // ------------------------------------------
    parentEntity.setP8(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P8
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignP8(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P8 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P8 on the parent entithy
    // ------------------------------------------
    parentEntity.setP8(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a P9
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignP9(UUID parentId, PU assignment) {
    LOGGER.info("assigning P9 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the P9 to the parent entity
    // ------------------------------------------
    parentEntity.setP9(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the P9
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignP9(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning P9 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the P9 on the parent entithy
    // ------------------------------------------
    parentEntity.setP9(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Q0
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignQ0(UUID parentId, PU assignment) {
    LOGGER.info("assigning Q0 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Q0 to the parent entity
    // ------------------------------------------
    parentEntity.setQ0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Q0
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignQ0(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Q0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Q0 on the parent entithy
    // ------------------------------------------
    parentEntity.setQ0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Q1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignQ1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Q1 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Q1 to the parent entity
    // ------------------------------------------
    parentEntity.setQ1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Q1
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignQ1(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Q1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Q1 on the parent entithy
    // ------------------------------------------
    parentEntity.setQ1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Q10
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignQ10(UUID parentId, PU assignment) {
    LOGGER.info("assigning Q10 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Q10 to the parent entity
    // ------------------------------------------
    parentEntity.setQ10(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Q10
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignQ10(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Q10 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Q10 on the parent entithy
    // ------------------------------------------
    parentEntity.setQ10(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Q2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignQ2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Q2 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Q2 to the parent entity
    // ------------------------------------------
    parentEntity.setQ2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Q2
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignQ2(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Q2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Q2 on the parent entithy
    // ------------------------------------------
    parentEntity.setQ2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Q3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignQ3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Q3 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Q3 to the parent entity
    // ------------------------------------------
    parentEntity.setQ3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Q3
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignQ3(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Q3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Q3 on the parent entithy
    // ------------------------------------------
    parentEntity.setQ3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Q4
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignQ4(UUID parentId, PU assignment) {
    LOGGER.info("assigning Q4 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Q4 to the parent entity
    // ------------------------------------------
    parentEntity.setQ4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Q4
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignQ4(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Q4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Q4 on the parent entithy
    // ------------------------------------------
    parentEntity.setQ4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Q5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignQ5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Q5 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Q5 to the parent entity
    // ------------------------------------------
    parentEntity.setQ5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Q5
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignQ5(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Q5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Q5 on the parent entithy
    // ------------------------------------------
    parentEntity.setQ5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Q6
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignQ6(UUID parentId, PU assignment) {
    LOGGER.info("assigning Q6 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Q6 to the parent entity
    // ------------------------------------------
    parentEntity.setQ6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Q6
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignQ6(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Q6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Q6 on the parent entithy
    // ------------------------------------------
    parentEntity.setQ6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Q7
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignQ7(UUID parentId, PU assignment) {
    LOGGER.info("assigning Q7 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Q7 to the parent entity
    // ------------------------------------------
    parentEntity.setQ7(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Q7
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignQ7(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Q7 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Q7 on the parent entithy
    // ------------------------------------------
    parentEntity.setQ7(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Q8
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignQ8(UUID parentId, PU assignment) {
    LOGGER.info("assigning Q8 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Q8 to the parent entity
    // ------------------------------------------
    parentEntity.setQ8(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Q8
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignQ8(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Q8 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Q8 on the parent entithy
    // ------------------------------------------
    parentEntity.setQ8(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Q9
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignQ9(UUID parentId, PU assignment) {
    LOGGER.info("assigning Q9 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Q9 to the parent entity
    // ------------------------------------------
    parentEntity.setQ9(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Q9
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignQ9(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Q9 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Q9 on the parent entithy
    // ------------------------------------------
    parentEntity.setQ9(null);

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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignTu1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tu1 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignTu1(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignTu2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tu2 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignTu2(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignTu3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tu3 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignTu3(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignTu4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tu4 as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignTu4(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tul
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignTul(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tul as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tul to the parent entity
    // ------------------------------------------
    parentEntity.setTul(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tul
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignTul(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tul on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tul on the parent entithy
    // ------------------------------------------
    parentEntity.setTul(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tup
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignTup(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tup as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tup to the parent entity
    // ------------------------------------------
    parentEntity.setTup(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tup
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignTup(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tup on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tup on the parent entithy
    // ------------------------------------------
    parentEntity.setTup(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tuq
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignTuq(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tuq as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tuq to the parent entity
    // ------------------------------------------
    parentEntity.setTuq(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tuq
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignTuq(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tuq on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tuq on the parent entithy
    // ------------------------------------------
    parentEntity.setTuq(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tuv
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignTuv(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tuv as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tuv to the parent entity
    // ------------------------------------------
    parentEntity.setTuv(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tuv
   *
   * @param	parentId		UUID
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignTuv(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tuv on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tuv on the parent entithy
    // ------------------------------------------
    parentEntity.setTuv(null);

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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignVuimax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vuimax as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignVuimax(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignVuimin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vuimin as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignVuimin(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignVulmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vulmax as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignVulmax(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 assignVulmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vulmin as " + assignment.toString());

    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();
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
   * @return	UnderexcLimIEEE2
   */
  public UnderexcLimIEEE2 unAssignVulmin(UUID parentId) {
    UnderexcLimIEEE2 parentEntity = repository.findById(parentId).get();

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

  /**
   * Method to retrieve the UnderexcLimIEEE2 via an FindUnderexcLimIEEE2Query
   *
   * @return query FindUnderexcLimIEEE2Query
   */
  @SuppressWarnings("unused")
  public UnderexcLimIEEE2 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a UnderexcLimIEEE2 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all UnderexcLimIEEE2s
   *
   * @param query FindAllUnderexcLimIEEE2Query
   * @return List<UnderexcLimIEEE2>
   */
  @SuppressWarnings("unused")
  public List<UnderexcLimIEEE2> findAll(FindAllUnderexcLimIEEE2Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all UnderexcLimIEEE2 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final UnderexcLimIEEE2Repository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

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
      Logger.getLogger(UnderexcLimIEEE2EntityProjector.class.getName());
}
