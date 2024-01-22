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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for Quality61850 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by Quality61850Aggregate
 *
 * @author your_name_here
 */
@Component("quality61850-entity-projector")
public class Quality61850EntityProjector {

  // core constructor
  public Quality61850EntityProjector(Quality61850Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Quality61850
   *
   * @param	entity Quality61850
   */
  public Quality61850 create(Quality61850 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Quality61850
   *
   * @param	entity Quality61850
   */
  public Quality61850 update(Quality61850 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Quality61850
   *
   * @param	id		UUID
   */
  public Quality61850 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Quality61850 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a BadReference
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	Quality61850
   */
  public Quality61850 assignBadReference(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning BadReference as " + assignment.toString());

    Quality61850 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the BadReference to the parent entity
    // ------------------------------------------
    parentEntity.setBadReference(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the BadReference
   *
   * @param	parentId		UUID
   * @return	Quality61850
   */
  public Quality61850 unAssignBadReference(UUID parentId) {
    Quality61850 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning BadReference on " + parentEntity.toString());

    // ------------------------------------------
    // null out the BadReference on the parent entithy
    // ------------------------------------------
    parentEntity.setBadReference(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a EstimatorReplaced
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	Quality61850
   */
  public Quality61850 assignEstimatorReplaced(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning EstimatorReplaced as " + assignment.toString());

    Quality61850 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the EstimatorReplaced to the parent entity
    // ------------------------------------------
    parentEntity.setEstimatorReplaced(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the EstimatorReplaced
   *
   * @param	parentId		UUID
   * @return	Quality61850
   */
  public Quality61850 unAssignEstimatorReplaced(UUID parentId) {
    Quality61850 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning EstimatorReplaced on " + parentEntity.toString());

    // ------------------------------------------
    // null out the EstimatorReplaced on the parent entithy
    // ------------------------------------------
    parentEntity.setEstimatorReplaced(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Failure
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	Quality61850
   */
  public Quality61850 assignFailure(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Failure as " + assignment.toString());

    Quality61850 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Failure to the parent entity
    // ------------------------------------------
    parentEntity.setFailure(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Failure
   *
   * @param	parentId		UUID
   * @return	Quality61850
   */
  public Quality61850 unAssignFailure(UUID parentId) {
    Quality61850 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Failure on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Failure on the parent entithy
    // ------------------------------------------
    parentEntity.setFailure(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a OldData
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	Quality61850
   */
  public Quality61850 assignOldData(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning OldData as " + assignment.toString());

    Quality61850 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the OldData to the parent entity
    // ------------------------------------------
    parentEntity.setOldData(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the OldData
   *
   * @param	parentId		UUID
   * @return	Quality61850
   */
  public Quality61850 unAssignOldData(UUID parentId) {
    Quality61850 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning OldData on " + parentEntity.toString());

    // ------------------------------------------
    // null out the OldData on the parent entithy
    // ------------------------------------------
    parentEntity.setOldData(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a OperatorBlocked
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	Quality61850
   */
  public Quality61850 assignOperatorBlocked(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning OperatorBlocked as " + assignment.toString());

    Quality61850 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the OperatorBlocked to the parent entity
    // ------------------------------------------
    parentEntity.setOperatorBlocked(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the OperatorBlocked
   *
   * @param	parentId		UUID
   * @return	Quality61850
   */
  public Quality61850 unAssignOperatorBlocked(UUID parentId) {
    Quality61850 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning OperatorBlocked on " + parentEntity.toString());

    // ------------------------------------------
    // null out the OperatorBlocked on the parent entithy
    // ------------------------------------------
    parentEntity.setOperatorBlocked(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Oscillatory
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	Quality61850
   */
  public Quality61850 assignOscillatory(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Oscillatory as " + assignment.toString());

    Quality61850 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Oscillatory to the parent entity
    // ------------------------------------------
    parentEntity.setOscillatory(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Oscillatory
   *
   * @param	parentId		UUID
   * @return	Quality61850
   */
  public Quality61850 unAssignOscillatory(UUID parentId) {
    Quality61850 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Oscillatory on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Oscillatory on the parent entithy
    // ------------------------------------------
    parentEntity.setOscillatory(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a OutOfRange
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	Quality61850
   */
  public Quality61850 assignOutOfRange(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning OutOfRange as " + assignment.toString());

    Quality61850 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the OutOfRange to the parent entity
    // ------------------------------------------
    parentEntity.setOutOfRange(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the OutOfRange
   *
   * @param	parentId		UUID
   * @return	Quality61850
   */
  public Quality61850 unAssignOutOfRange(UUID parentId) {
    Quality61850 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning OutOfRange on " + parentEntity.toString());

    // ------------------------------------------
    // null out the OutOfRange on the parent entithy
    // ------------------------------------------
    parentEntity.setOutOfRange(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a OverFlow
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	Quality61850
   */
  public Quality61850 assignOverFlow(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning OverFlow as " + assignment.toString());

    Quality61850 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the OverFlow to the parent entity
    // ------------------------------------------
    parentEntity.setOverFlow(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the OverFlow
   *
   * @param	parentId		UUID
   * @return	Quality61850
   */
  public Quality61850 unAssignOverFlow(UUID parentId) {
    Quality61850 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning OverFlow on " + parentEntity.toString());

    // ------------------------------------------
    // null out the OverFlow on the parent entithy
    // ------------------------------------------
    parentEntity.setOverFlow(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Suspect
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	Quality61850
   */
  public Quality61850 assignSuspect(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Suspect as " + assignment.toString());

    Quality61850 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Suspect to the parent entity
    // ------------------------------------------
    parentEntity.setSuspect(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Suspect
   *
   * @param	parentId		UUID
   * @return	Quality61850
   */
  public Quality61850 unAssignSuspect(UUID parentId) {
    Quality61850 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Suspect on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Suspect on the parent entithy
    // ------------------------------------------
    parentEntity.setSuspect(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Test
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	Quality61850
   */
  public Quality61850 assignTest(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Test as " + assignment.toString());

    Quality61850 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Test to the parent entity
    // ------------------------------------------
    parentEntity.setTest(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Test
   *
   * @param	parentId		UUID
   * @return	Quality61850
   */
  public Quality61850 unAssignTest(UUID parentId) {
    Quality61850 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Test on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Test on the parent entithy
    // ------------------------------------------
    parentEntity.setTest(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Quality61850 via an FindQuality61850Query
   *
   * @return query FindQuality61850Query
   */
  @SuppressWarnings("unused")
  public Quality61850 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Quality61850 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Quality61850s
   *
   * @param query FindAllQuality61850Query
   * @return List<Quality61850>
   */
  @SuppressWarnings("unused")
  public List<Quality61850> findAll(FindAllQuality61850Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Quality61850 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final Quality61850Repository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(Quality61850EntityProjector.class.getName());
}
