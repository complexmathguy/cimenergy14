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
 * Projector for PssIEEE4B as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PssIEEE4BAggregate
 *
 * @author your_name_here
 */
@Component("pssIEEE4B-entity-projector")
public class PssIEEE4BEntityProjector {

  // core constructor
  public PssIEEE4BEntityProjector(PssIEEE4BRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PssIEEE4B
   *
   * @param	entity PssIEEE4B
   */
  public PssIEEE4B create(PssIEEE4B entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PssIEEE4B
   *
   * @param	entity PssIEEE4B
   */
  public PssIEEE4B update(PssIEEE4B entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PssIEEE4B
   *
   * @param	id		UUID
   */
  public PssIEEE4B delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PssIEEE4B entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Bwh1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignBwh1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Bwh1 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Bwh1 to the parent entity
    // ------------------------------------------
    parentEntity.setBwh1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bwh1
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignBwh1(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bwh1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bwh1 on the parent entithy
    // ------------------------------------------
    parentEntity.setBwh1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Bwh2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignBwh2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Bwh2 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Bwh2 to the parent entity
    // ------------------------------------------
    parentEntity.setBwh2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bwh2
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignBwh2(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bwh2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bwh2 on the parent entithy
    // ------------------------------------------
    parentEntity.setBwh2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Bwl1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignBwl1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Bwl1 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Bwl1 to the parent entity
    // ------------------------------------------
    parentEntity.setBwl1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bwl1
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignBwl1(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bwl1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bwl1 on the parent entithy
    // ------------------------------------------
    parentEntity.setBwl1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Bwl2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignBwl2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Bwl2 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Bwl2 to the parent entity
    // ------------------------------------------
    parentEntity.setBwl2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bwl2
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignBwl2(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bwl2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bwl2 on the parent entithy
    // ------------------------------------------
    parentEntity.setBwl2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kh
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignKh(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kh as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kh to the parent entity
    // ------------------------------------------
    parentEntity.setKh(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kh
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignKh(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kh on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kh on the parent entithy
    // ------------------------------------------
    parentEntity.setKh(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kh1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignKh1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kh1 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kh1 to the parent entity
    // ------------------------------------------
    parentEntity.setKh1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kh1
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignKh1(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kh1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kh1 on the parent entithy
    // ------------------------------------------
    parentEntity.setKh1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kh11
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignKh11(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kh11 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kh11 to the parent entity
    // ------------------------------------------
    parentEntity.setKh11(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kh11
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignKh11(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kh11 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kh11 on the parent entithy
    // ------------------------------------------
    parentEntity.setKh11(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kh17
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignKh17(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kh17 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kh17 to the parent entity
    // ------------------------------------------
    parentEntity.setKh17(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kh17
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignKh17(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kh17 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kh17 on the parent entithy
    // ------------------------------------------
    parentEntity.setKh17(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kh2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignKh2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kh2 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kh2 to the parent entity
    // ------------------------------------------
    parentEntity.setKh2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kh2
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignKh2(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kh2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kh2 on the parent entithy
    // ------------------------------------------
    parentEntity.setKh2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ki
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignKi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ki to the parent entity
    // ------------------------------------------
    parentEntity.setKi(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ki
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignKi(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ki on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ki on the parent entithy
    // ------------------------------------------
    parentEntity.setKi(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ki1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignKi1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki1 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ki1 to the parent entity
    // ------------------------------------------
    parentEntity.setKi1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ki1
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignKi1(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ki1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ki1 on the parent entithy
    // ------------------------------------------
    parentEntity.setKi1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ki11
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignKi11(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki11 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ki11 to the parent entity
    // ------------------------------------------
    parentEntity.setKi11(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ki11
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignKi11(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ki11 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ki11 on the parent entithy
    // ------------------------------------------
    parentEntity.setKi11(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ki17
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignKi17(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki17 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ki17 to the parent entity
    // ------------------------------------------
    parentEntity.setKi17(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ki17
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignKi17(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ki17 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ki17 on the parent entithy
    // ------------------------------------------
    parentEntity.setKi17(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ki2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignKi2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki2 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ki2 to the parent entity
    // ------------------------------------------
    parentEntity.setKi2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ki2
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignKi2(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ki2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ki2 on the parent entithy
    // ------------------------------------------
    parentEntity.setKi2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kl
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignKl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kl as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kl to the parent entity
    // ------------------------------------------
    parentEntity.setKl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kl
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignKl(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kl on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kl on the parent entithy
    // ------------------------------------------
    parentEntity.setKl(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kl1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignKl1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kl1 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kl1 to the parent entity
    // ------------------------------------------
    parentEntity.setKl1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kl1
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignKl1(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kl1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kl1 on the parent entithy
    // ------------------------------------------
    parentEntity.setKl1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kl11
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignKl11(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kl11 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kl11 to the parent entity
    // ------------------------------------------
    parentEntity.setKl11(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kl11
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignKl11(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kl11 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kl11 on the parent entithy
    // ------------------------------------------
    parentEntity.setKl11(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kl17
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignKl17(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kl17 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kl17 to the parent entity
    // ------------------------------------------
    parentEntity.setKl17(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kl17
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignKl17(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kl17 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kl17 on the parent entithy
    // ------------------------------------------
    parentEntity.setKl17(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kl2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignKl2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kl2 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kl2 to the parent entity
    // ------------------------------------------
    parentEntity.setKl2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kl2
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignKl2(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kl2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kl2 on the parent entithy
    // ------------------------------------------
    parentEntity.setKl2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Omeganh1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignOmeganh1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Omeganh1 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Omeganh1 to the parent entity
    // ------------------------------------------
    parentEntity.setOmeganh1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Omeganh1
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignOmeganh1(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Omeganh1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Omeganh1 on the parent entithy
    // ------------------------------------------
    parentEntity.setOmeganh1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Omeganh2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignOmeganh2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Omeganh2 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Omeganh2 to the parent entity
    // ------------------------------------------
    parentEntity.setOmeganh2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Omeganh2
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignOmeganh2(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Omeganh2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Omeganh2 on the parent entithy
    // ------------------------------------------
    parentEntity.setOmeganh2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Omeganl1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignOmeganl1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Omeganl1 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Omeganl1 to the parent entity
    // ------------------------------------------
    parentEntity.setOmeganl1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Omeganl1
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignOmeganl1(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Omeganl1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Omeganl1 on the parent entithy
    // ------------------------------------------
    parentEntity.setOmeganl1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Omeganl2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignOmeganl2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Omeganl2 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Omeganl2 to the parent entity
    // ------------------------------------------
    parentEntity.setOmeganl2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Omeganl2
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignOmeganl2(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Omeganl2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Omeganl2 on the parent entithy
    // ------------------------------------------
    parentEntity.setOmeganl2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Th1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTh1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Th1 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Th1 to the parent entity
    // ------------------------------------------
    parentEntity.setTh1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Th1
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTh1(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Th1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Th1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTh1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Th10
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTh10(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Th10 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Th10 to the parent entity
    // ------------------------------------------
    parentEntity.setTh10(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Th10
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTh10(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Th10 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Th10 on the parent entithy
    // ------------------------------------------
    parentEntity.setTh10(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Th11
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTh11(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Th11 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Th11 to the parent entity
    // ------------------------------------------
    parentEntity.setTh11(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Th11
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTh11(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Th11 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Th11 on the parent entithy
    // ------------------------------------------
    parentEntity.setTh11(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Th12
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTh12(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Th12 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Th12 to the parent entity
    // ------------------------------------------
    parentEntity.setTh12(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Th12
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTh12(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Th12 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Th12 on the parent entithy
    // ------------------------------------------
    parentEntity.setTh12(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Th2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTh2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Th2 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Th2 to the parent entity
    // ------------------------------------------
    parentEntity.setTh2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Th2
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTh2(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Th2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Th2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTh2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Th3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTh3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Th3 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Th3 to the parent entity
    // ------------------------------------------
    parentEntity.setTh3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Th3
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTh3(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Th3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Th3 on the parent entithy
    // ------------------------------------------
    parentEntity.setTh3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Th4
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTh4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Th4 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Th4 to the parent entity
    // ------------------------------------------
    parentEntity.setTh4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Th4
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTh4(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Th4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Th4 on the parent entithy
    // ------------------------------------------
    parentEntity.setTh4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Th5
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTh5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Th5 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Th5 to the parent entity
    // ------------------------------------------
    parentEntity.setTh5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Th5
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTh5(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Th5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Th5 on the parent entithy
    // ------------------------------------------
    parentEntity.setTh5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Th6
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTh6(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Th6 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Th6 to the parent entity
    // ------------------------------------------
    parentEntity.setTh6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Th6
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTh6(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Th6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Th6 on the parent entithy
    // ------------------------------------------
    parentEntity.setTh6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Th7
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTh7(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Th7 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Th7 to the parent entity
    // ------------------------------------------
    parentEntity.setTh7(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Th7
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTh7(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Th7 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Th7 on the parent entithy
    // ------------------------------------------
    parentEntity.setTh7(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Th8
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTh8(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Th8 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Th8 to the parent entity
    // ------------------------------------------
    parentEntity.setTh8(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Th8
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTh8(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Th8 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Th8 on the parent entithy
    // ------------------------------------------
    parentEntity.setTh8(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Th9
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTh9(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Th9 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Th9 to the parent entity
    // ------------------------------------------
    parentEntity.setTh9(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Th9
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTh9(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Th9 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Th9 on the parent entithy
    // ------------------------------------------
    parentEntity.setTh9(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTi1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti1 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti1 to the parent entity
    // ------------------------------------------
    parentEntity.setTi1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti1
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTi1(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTi1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti10
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTi10(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti10 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti10 to the parent entity
    // ------------------------------------------
    parentEntity.setTi10(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti10
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTi10(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti10 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti10 on the parent entithy
    // ------------------------------------------
    parentEntity.setTi10(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti11
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTi11(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti11 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti11 to the parent entity
    // ------------------------------------------
    parentEntity.setTi11(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti11
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTi11(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti11 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti11 on the parent entithy
    // ------------------------------------------
    parentEntity.setTi11(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti12
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTi12(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti12 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti12 to the parent entity
    // ------------------------------------------
    parentEntity.setTi12(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti12
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTi12(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti12 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti12 on the parent entithy
    // ------------------------------------------
    parentEntity.setTi12(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTi2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti2 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti2 to the parent entity
    // ------------------------------------------
    parentEntity.setTi2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti2
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTi2(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTi2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTi3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti3 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti3 to the parent entity
    // ------------------------------------------
    parentEntity.setTi3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti3
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTi3(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti3 on the parent entithy
    // ------------------------------------------
    parentEntity.setTi3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti4
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTi4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti4 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti4 to the parent entity
    // ------------------------------------------
    parentEntity.setTi4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti4
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTi4(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti4 on the parent entithy
    // ------------------------------------------
    parentEntity.setTi4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti5
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTi5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti5 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti5 to the parent entity
    // ------------------------------------------
    parentEntity.setTi5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti5
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTi5(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti5 on the parent entithy
    // ------------------------------------------
    parentEntity.setTi5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti6
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTi6(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti6 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti6 to the parent entity
    // ------------------------------------------
    parentEntity.setTi6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti6
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTi6(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti6 on the parent entithy
    // ------------------------------------------
    parentEntity.setTi6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti7
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTi7(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti7 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti7 to the parent entity
    // ------------------------------------------
    parentEntity.setTi7(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti7
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTi7(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti7 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti7 on the parent entithy
    // ------------------------------------------
    parentEntity.setTi7(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti8
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTi8(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti8 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti8 to the parent entity
    // ------------------------------------------
    parentEntity.setTi8(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti8
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTi8(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti8 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti8 on the parent entithy
    // ------------------------------------------
    parentEntity.setTi8(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ti9
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTi9(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ti9 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ti9 to the parent entity
    // ------------------------------------------
    parentEntity.setTi9(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ti9
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTi9(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ti9 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ti9 on the parent entithy
    // ------------------------------------------
    parentEntity.setTi9(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTl1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl1 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl1 to the parent entity
    // ------------------------------------------
    parentEntity.setTl1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl1
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTl1(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl10
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTl10(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl10 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl10 to the parent entity
    // ------------------------------------------
    parentEntity.setTl10(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl10
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTl10(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl10 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl10 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl10(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl11
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTl11(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl11 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl11 to the parent entity
    // ------------------------------------------
    parentEntity.setTl11(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl11
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTl11(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl11 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl11 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl11(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl12
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTl12(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl12 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl12 to the parent entity
    // ------------------------------------------
    parentEntity.setTl12(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl12
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTl12(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl12 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl12 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl12(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTl2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl2 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl2 to the parent entity
    // ------------------------------------------
    parentEntity.setTl2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl2
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTl2(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTl3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl3 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl3 to the parent entity
    // ------------------------------------------
    parentEntity.setTl3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl3
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTl3(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl3 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl4
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTl4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl4 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl4 to the parent entity
    // ------------------------------------------
    parentEntity.setTl4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl4
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTl4(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl4 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl5
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTl5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl5 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl5 to the parent entity
    // ------------------------------------------
    parentEntity.setTl5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl5
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTl5(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl5 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl6
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTl6(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl6 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl6 to the parent entity
    // ------------------------------------------
    parentEntity.setTl6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl6
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTl6(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl6 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl7
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTl7(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl7 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl7 to the parent entity
    // ------------------------------------------
    parentEntity.setTl7(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl7
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTl7(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl7 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl7 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl7(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl8
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTl8(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl8 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl8 to the parent entity
    // ------------------------------------------
    parentEntity.setTl8(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl8
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTl8(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl8 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl8 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl8(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl9
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignTl9(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl9 as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl9 to the parent entity
    // ------------------------------------------
    parentEntity.setTl9(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl9
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignTl9(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl9 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl9 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl9(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vhmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignVhmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vhmax as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vhmax to the parent entity
    // ------------------------------------------
    parentEntity.setVhmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vhmax
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignVhmax(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vhmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vhmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVhmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vhmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignVhmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vhmin as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vhmin to the parent entity
    // ------------------------------------------
    parentEntity.setVhmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vhmin
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignVhmin(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vhmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vhmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVhmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vimax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignVimax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vimax as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vimax to the parent entity
    // ------------------------------------------
    parentEntity.setVimax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vimax
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignVimax(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vimax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vimax on the parent entithy
    // ------------------------------------------
    parentEntity.setVimax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vimin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignVimin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vimin as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vimin to the parent entity
    // ------------------------------------------
    parentEntity.setVimin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vimin
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignVimin(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vimin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vimin on the parent entithy
    // ------------------------------------------
    parentEntity.setVimin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vlmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignVlmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vlmax as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vlmax to the parent entity
    // ------------------------------------------
    parentEntity.setVlmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vlmax
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignVlmax(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vlmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vlmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVlmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vlmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignVlmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vlmin as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vlmin to the parent entity
    // ------------------------------------------
    parentEntity.setVlmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vlmin
   *
   * @param	parentId		UUID
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignVlmin(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vlmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vlmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVlmin(null);

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
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignVstmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vstmax as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
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
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignVstmax(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

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
   * @return	PssIEEE4B
   */
  public PssIEEE4B assignVstmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vstmin as " + assignment.toString());

    PssIEEE4B parentEntity = repository.findById(parentId).get();
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
   * @return	PssIEEE4B
   */
  public PssIEEE4B unAssignVstmin(UUID parentId) {
    PssIEEE4B parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the PssIEEE4B via an FindPssIEEE4BQuery
   *
   * @return query FindPssIEEE4BQuery
   */
  @SuppressWarnings("unused")
  public PssIEEE4B find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PssIEEE4B - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PssIEEE4Bs
   *
   * @param query FindAllPssIEEE4BQuery
   * @return List<PssIEEE4B>
   */
  @SuppressWarnings("unused")
  public List<PssIEEE4B> findAll(FindAllPssIEEE4BQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PssIEEE4B - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PssIEEE4BRepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(PssIEEE4BEntityProjector.class.getName());
}
