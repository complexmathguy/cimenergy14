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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for TapChanger as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by TapChangerAggregate
 *
 * @author your_name_here
 */
@Component("tapChanger-entity-projector")
public class TapChangerEntityProjector {

  // core constructor
  public TapChangerEntityProjector(TapChangerRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a TapChanger
   *
   * @param	entity TapChanger
   */
  public TapChanger create(TapChanger entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a TapChanger
   *
   * @param	entity TapChanger
   */
  public TapChanger update(TapChanger entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a TapChanger
   *
   * @param	id		UUID
   */
  public TapChanger delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    TapChanger entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a HighStep
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	TapChanger
   */
  public TapChanger assignHighStep(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning HighStep as " + assignment.toString());

    TapChanger parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the HighStep to the parent entity
    // ------------------------------------------
    parentEntity.setHighStep(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the HighStep
   *
   * @param	parentId		UUID
   * @return	TapChanger
   */
  public TapChanger unAssignHighStep(UUID parentId) {
    TapChanger parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning HighStep on " + parentEntity.toString());

    // ------------------------------------------
    // null out the HighStep on the parent entithy
    // ------------------------------------------
    parentEntity.setHighStep(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a LowStep
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	TapChanger
   */
  public TapChanger assignLowStep(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning LowStep as " + assignment.toString());

    TapChanger parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the LowStep to the parent entity
    // ------------------------------------------
    parentEntity.setLowStep(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the LowStep
   *
   * @param	parentId		UUID
   * @return	TapChanger
   */
  public TapChanger unAssignLowStep(UUID parentId) {
    TapChanger parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning LowStep on " + parentEntity.toString());

    // ------------------------------------------
    // null out the LowStep on the parent entithy
    // ------------------------------------------
    parentEntity.setLowStep(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a LtcFlag
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	TapChanger
   */
  public TapChanger assignLtcFlag(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning LtcFlag as " + assignment.toString());

    TapChanger parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the LtcFlag to the parent entity
    // ------------------------------------------
    parentEntity.setLtcFlag(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the LtcFlag
   *
   * @param	parentId		UUID
   * @return	TapChanger
   */
  public TapChanger unAssignLtcFlag(UUID parentId) {
    TapChanger parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning LtcFlag on " + parentEntity.toString());

    // ------------------------------------------
    // null out the LtcFlag on the parent entithy
    // ------------------------------------------
    parentEntity.setLtcFlag(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NeutralStep
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	TapChanger
   */
  public TapChanger assignNeutralStep(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning NeutralStep as " + assignment.toString());

    TapChanger parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the NeutralStep to the parent entity
    // ------------------------------------------
    parentEntity.setNeutralStep(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NeutralStep
   *
   * @param	parentId		UUID
   * @return	TapChanger
   */
  public TapChanger unAssignNeutralStep(UUID parentId) {
    TapChanger parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NeutralStep on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NeutralStep on the parent entithy
    // ------------------------------------------
    parentEntity.setNeutralStep(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NeutralU
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	TapChanger
   */
  public TapChanger assignNeutralU(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning NeutralU as " + assignment.toString());

    TapChanger parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the NeutralU to the parent entity
    // ------------------------------------------
    parentEntity.setNeutralU(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NeutralU
   *
   * @param	parentId		UUID
   * @return	TapChanger
   */
  public TapChanger unAssignNeutralU(UUID parentId) {
    TapChanger parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NeutralU on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NeutralU on the parent entithy
    // ------------------------------------------
    parentEntity.setNeutralU(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NormalStep
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	TapChanger
   */
  public TapChanger assignNormalStep(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning NormalStep as " + assignment.toString());

    TapChanger parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the NormalStep to the parent entity
    // ------------------------------------------
    parentEntity.setNormalStep(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NormalStep
   *
   * @param	parentId		UUID
   * @return	TapChanger
   */
  public TapChanger unAssignNormalStep(UUID parentId) {
    TapChanger parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NormalStep on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NormalStep on the parent entithy
    // ------------------------------------------
    parentEntity.setNormalStep(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the TapChanger
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	TapChanger
   */
  public TapChanger addToTapChanger(UUID parentId, TapChanger addTo) {
    LOGGER.info("handling AssignTapChangerToTapChangerEvent - ");

    TapChanger parentEntity = repository.findById(parentId).get();
    TapChanger child = TapChangerProjector.find(addTo.getTapChangerId());

    parentEntity.getTapChanger().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the TapChanger
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	TapChanger
   */
  public TapChanger removeFromTapChanger(UUID parentId, TapChanger removeFrom) {
    LOGGER.info("handling RemoveTapChangerFromTapChangerEvent ");

    TapChanger parentEntity = repository.findById(parentId).get();
    TapChanger child = TapChangerProjector.find(removeFrom.getTapChangerId());

    parentEntity.getTapChanger().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the TapChanger via an FindTapChangerQuery
   *
   * @return query FindTapChangerQuery
   */
  @SuppressWarnings("unused")
  public TapChanger find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a TapChanger - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all TapChangers
   *
   * @param query FindAllTapChangerQuery
   * @return List<TapChanger>
   */
  @SuppressWarnings("unused")
  public List<TapChanger> findAll(FindAllTapChangerQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all TapChanger - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final TapChangerRepository repository;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "voltage-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .VoltageEntityProjector
      VoltageProjector;

  @Autowired
  @Qualifier(value = "tapChanger-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .TapChangerEntityProjector
      TapChangerProjector;

  private static final Logger LOGGER = Logger.getLogger(TapChangerEntityProjector.class.getName());
}
