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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for GovHydroWEH as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovHydroWEHAggregate
 *
 * @author your_name_here
 */
@Component("govHydroWEH-entity-projector")
public class GovHydroWEHEntityProjector {

  // core constructor
  public GovHydroWEHEntityProjector(GovHydroWEHRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovHydroWEH
   *
   * @param	entity GovHydroWEH
   */
  public GovHydroWEH create(GovHydroWEH entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovHydroWEH
   *
   * @param	entity GovHydroWEH
   */
  public GovHydroWEH update(GovHydroWEH entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovHydroWEH
   *
   * @param	id		UUID
   */
  public GovHydroWEH delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovHydroWEH entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Db
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignDb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Db as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Db to the parent entity
    // ------------------------------------------
    parentEntity.setDb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Db
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignDb(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Db on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Db on the parent entithy
    // ------------------------------------------
    parentEntity.setDb(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dicn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignDicn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dicn as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dicn to the parent entity
    // ------------------------------------------
    parentEntity.setDicn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dicn
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignDicn(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dicn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dicn on the parent entithy
    // ------------------------------------------
    parentEntity.setDicn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dpv
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignDpv(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dpv as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dpv to the parent entity
    // ------------------------------------------
    parentEntity.setDpv(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dpv
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignDpv(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dpv on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dpv on the parent entithy
    // ------------------------------------------
    parentEntity.setDpv(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dturb
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignDturb(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dturb as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dturb to the parent entity
    // ------------------------------------------
    parentEntity.setDturb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dturb
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignDturb(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dturb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dturb on the parent entithy
    // ------------------------------------------
    parentEntity.setDturb(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a FeedbackSignal
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFeedbackSignal(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning FeedbackSignal as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the FeedbackSignal to the parent entity
    // ------------------------------------------
    parentEntity.setFeedbackSignal(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the FeedbackSignal
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFeedbackSignal(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning FeedbackSignal on " + parentEntity.toString());

    // ------------------------------------------
    // null out the FeedbackSignal on the parent entithy
    // ------------------------------------------
    parentEntity.setFeedbackSignal(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fl1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFl1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fl1 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fl1 to the parent entity
    // ------------------------------------------
    parentEntity.setFl1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fl1
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFl1(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fl1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fl1 on the parent entithy
    // ------------------------------------------
    parentEntity.setFl1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fl2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFl2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fl2 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fl2 to the parent entity
    // ------------------------------------------
    parentEntity.setFl2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fl2
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFl2(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fl2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fl2 on the parent entithy
    // ------------------------------------------
    parentEntity.setFl2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fl3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFl3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fl3 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fl3 to the parent entity
    // ------------------------------------------
    parentEntity.setFl3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fl3
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFl3(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fl3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fl3 on the parent entithy
    // ------------------------------------------
    parentEntity.setFl3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fl4
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFl4(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fl4 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fl4 to the parent entity
    // ------------------------------------------
    parentEntity.setFl4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fl4
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFl4(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fl4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fl4 on the parent entithy
    // ------------------------------------------
    parentEntity.setFl4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fl5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFl5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fl5 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fl5 to the parent entity
    // ------------------------------------------
    parentEntity.setFl5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fl5
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFl5(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fl5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fl5 on the parent entithy
    // ------------------------------------------
    parentEntity.setFl5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fp1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFp1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fp1 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fp1 to the parent entity
    // ------------------------------------------
    parentEntity.setFp1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fp1
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFp1(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fp1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fp1 on the parent entithy
    // ------------------------------------------
    parentEntity.setFp1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fp10
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFp10(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fp10 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fp10 to the parent entity
    // ------------------------------------------
    parentEntity.setFp10(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fp10
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFp10(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fp10 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fp10 on the parent entithy
    // ------------------------------------------
    parentEntity.setFp10(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fp2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFp2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fp2 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fp2 to the parent entity
    // ------------------------------------------
    parentEntity.setFp2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fp2
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFp2(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fp2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fp2 on the parent entithy
    // ------------------------------------------
    parentEntity.setFp2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fp3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFp3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fp3 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fp3 to the parent entity
    // ------------------------------------------
    parentEntity.setFp3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fp3
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFp3(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fp3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fp3 on the parent entithy
    // ------------------------------------------
    parentEntity.setFp3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fp4
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFp4(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fp4 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fp4 to the parent entity
    // ------------------------------------------
    parentEntity.setFp4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fp4
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFp4(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fp4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fp4 on the parent entithy
    // ------------------------------------------
    parentEntity.setFp4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fp5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFp5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fp5 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fp5 to the parent entity
    // ------------------------------------------
    parentEntity.setFp5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fp5
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFp5(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fp5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fp5 on the parent entithy
    // ------------------------------------------
    parentEntity.setFp5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fp6
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFp6(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fp6 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fp6 to the parent entity
    // ------------------------------------------
    parentEntity.setFp6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fp6
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFp6(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fp6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fp6 on the parent entithy
    // ------------------------------------------
    parentEntity.setFp6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fp7
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFp7(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fp7 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fp7 to the parent entity
    // ------------------------------------------
    parentEntity.setFp7(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fp7
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFp7(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fp7 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fp7 on the parent entithy
    // ------------------------------------------
    parentEntity.setFp7(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fp8
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFp8(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fp8 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fp8 to the parent entity
    // ------------------------------------------
    parentEntity.setFp8(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fp8
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFp8(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fp8 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fp8 on the parent entithy
    // ------------------------------------------
    parentEntity.setFp8(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Fp9
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignFp9(UUID parentId, PU assignment) {
    LOGGER.info("assigning Fp9 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Fp9 to the parent entity
    // ------------------------------------------
    parentEntity.setFp9(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fp9
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignFp9(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fp9 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fp9 on the parent entithy
    // ------------------------------------------
    parentEntity.setFp9(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignGmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gmax as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gmax to the parent entity
    // ------------------------------------------
    parentEntity.setGmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gmax
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignGmax(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gmax on the parent entithy
    // ------------------------------------------
    parentEntity.setGmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignGmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gmin as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gmin to the parent entity
    // ------------------------------------------
    parentEntity.setGmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gmin
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignGmin(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gmin on the parent entithy
    // ------------------------------------------
    parentEntity.setGmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gtmxcl
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignGtmxcl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gtmxcl as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gtmxcl to the parent entity
    // ------------------------------------------
    parentEntity.setGtmxcl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gtmxcl
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignGtmxcl(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gtmxcl on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gtmxcl on the parent entithy
    // ------------------------------------------
    parentEntity.setGtmxcl(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gtmxop
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignGtmxop(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gtmxop as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gtmxop to the parent entity
    // ------------------------------------------
    parentEntity.setGtmxop(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gtmxop
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignGtmxop(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gtmxop on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gtmxop on the parent entithy
    // ------------------------------------------
    parentEntity.setGtmxop(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gv1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignGv1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv1 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gv1 to the parent entity
    // ------------------------------------------
    parentEntity.setGv1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gv1
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignGv1(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gv1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gv1 on the parent entithy
    // ------------------------------------------
    parentEntity.setGv1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gv2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignGv2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv2 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gv2 to the parent entity
    // ------------------------------------------
    parentEntity.setGv2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gv2
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignGv2(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gv2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gv2 on the parent entithy
    // ------------------------------------------
    parentEntity.setGv2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gv3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignGv3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv3 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gv3 to the parent entity
    // ------------------------------------------
    parentEntity.setGv3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gv3
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignGv3(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gv3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gv3 on the parent entithy
    // ------------------------------------------
    parentEntity.setGv3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gv4
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignGv4(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv4 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gv4 to the parent entity
    // ------------------------------------------
    parentEntity.setGv4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gv4
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignGv4(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gv4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gv4 on the parent entithy
    // ------------------------------------------
    parentEntity.setGv4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gv5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignGv5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Gv5 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Gv5 to the parent entity
    // ------------------------------------------
    parentEntity.setGv5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gv5
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignGv5(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gv5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gv5 on the parent entithy
    // ------------------------------------------
    parentEntity.setGv5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kd
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignKd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kd as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kd to the parent entity
    // ------------------------------------------
    parentEntity.setKd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kd
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignKd(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kd on the parent entithy
    // ------------------------------------------
    parentEntity.setKd(null);

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
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignKi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignKi(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

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
   * Assign a Kp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignKp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kp as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kp to the parent entity
    // ------------------------------------------
    parentEntity.setKp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kp
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignKp(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kp on the parent entithy
    // ------------------------------------------
    parentEntity.setKp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mwbase
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the Mwbase to the parent entity
    // ------------------------------------------
    parentEntity.setMwbase(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mwbase
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignMwbase(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mwbase on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mwbase on the parent entithy
    // ------------------------------------------
    parentEntity.setMwbase(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmss1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignPmss1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmss1 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmss1 to the parent entity
    // ------------------------------------------
    parentEntity.setPmss1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmss1
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignPmss1(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmss1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmss1 on the parent entithy
    // ------------------------------------------
    parentEntity.setPmss1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmss10
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignPmss10(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmss10 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmss10 to the parent entity
    // ------------------------------------------
    parentEntity.setPmss10(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmss10
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignPmss10(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmss10 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmss10 on the parent entithy
    // ------------------------------------------
    parentEntity.setPmss10(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmss2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignPmss2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmss2 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmss2 to the parent entity
    // ------------------------------------------
    parentEntity.setPmss2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmss2
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignPmss2(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmss2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmss2 on the parent entithy
    // ------------------------------------------
    parentEntity.setPmss2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmss3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignPmss3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmss3 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmss3 to the parent entity
    // ------------------------------------------
    parentEntity.setPmss3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmss3
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignPmss3(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmss3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmss3 on the parent entithy
    // ------------------------------------------
    parentEntity.setPmss3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmss4
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignPmss4(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmss4 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmss4 to the parent entity
    // ------------------------------------------
    parentEntity.setPmss4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmss4
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignPmss4(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmss4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmss4 on the parent entithy
    // ------------------------------------------
    parentEntity.setPmss4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmss5
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignPmss5(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmss5 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmss5 to the parent entity
    // ------------------------------------------
    parentEntity.setPmss5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmss5
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignPmss5(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmss5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmss5 on the parent entithy
    // ------------------------------------------
    parentEntity.setPmss5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmss6
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignPmss6(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmss6 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmss6 to the parent entity
    // ------------------------------------------
    parentEntity.setPmss6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmss6
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignPmss6(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmss6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmss6 on the parent entithy
    // ------------------------------------------
    parentEntity.setPmss6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmss7
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignPmss7(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmss7 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmss7 to the parent entity
    // ------------------------------------------
    parentEntity.setPmss7(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmss7
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignPmss7(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmss7 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmss7 on the parent entithy
    // ------------------------------------------
    parentEntity.setPmss7(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmss8
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignPmss8(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmss8 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmss8 to the parent entity
    // ------------------------------------------
    parentEntity.setPmss8(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmss8
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignPmss8(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmss8 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmss8 on the parent entithy
    // ------------------------------------------
    parentEntity.setPmss8(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmss9
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignPmss9(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmss9 as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmss9 to the parent entity
    // ------------------------------------------
    parentEntity.setPmss9(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmss9
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignPmss9(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmss9 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmss9 on the parent entithy
    // ------------------------------------------
    parentEntity.setPmss9(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rpg
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignRpg(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Rpg as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Rpg to the parent entity
    // ------------------------------------------
    parentEntity.setRpg(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rpg
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignRpg(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rpg on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rpg on the parent entithy
    // ------------------------------------------
    parentEntity.setRpg(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rpp
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignRpp(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Rpp as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Rpp to the parent entity
    // ------------------------------------------
    parentEntity.setRpp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rpp
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignRpp(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rpp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rpp on the parent entithy
    // ------------------------------------------
    parentEntity.setRpp(null);

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
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignTd(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Td as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignTd(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

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
   * Assign a Tdv
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignTdv(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tdv as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tdv to the parent entity
    // ------------------------------------------
    parentEntity.setTdv(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tdv
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignTdv(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tdv on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tdv on the parent entithy
    // ------------------------------------------
    parentEntity.setTdv(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tg
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignTg(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tg as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tg to the parent entity
    // ------------------------------------------
    parentEntity.setTg(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tg
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignTg(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tg on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tg on the parent entithy
    // ------------------------------------------
    parentEntity.setTg(null);

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
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignTp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tp as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignTp(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

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

  /*
   * Assign a Tpe
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignTpe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpe as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpe to the parent entity
    // ------------------------------------------
    parentEntity.setTpe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpe
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignTpe(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpe on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpe on the parent entithy
    // ------------------------------------------
    parentEntity.setTpe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tw
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydroWEH
   */
  public GovHydroWEH assignTw(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw as " + assignment.toString());

    GovHydroWEH parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tw to the parent entity
    // ------------------------------------------
    parentEntity.setTw(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tw
   *
   * @param	parentId		UUID
   * @return	GovHydroWEH
   */
  public GovHydroWEH unAssignTw(UUID parentId) {
    GovHydroWEH parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tw on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tw on the parent entithy
    // ------------------------------------------
    parentEntity.setTw(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovHydroWEH via an FindGovHydroWEHQuery
   *
   * @return query FindGovHydroWEHQuery
   */
  @SuppressWarnings("unused")
  public GovHydroWEH find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovHydroWEH - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovHydroWEHs
   *
   * @param query FindAllGovHydroWEHQuery
   * @return List<GovHydroWEH>
   */
  @SuppressWarnings("unused")
  public List<GovHydroWEH> findAll(FindAllGovHydroWEHQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovHydroWEH - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovHydroWEHRepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "activePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ActivePowerEntityProjector
      ActivePowerProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(GovHydroWEHEntityProjector.class.getName());
}
