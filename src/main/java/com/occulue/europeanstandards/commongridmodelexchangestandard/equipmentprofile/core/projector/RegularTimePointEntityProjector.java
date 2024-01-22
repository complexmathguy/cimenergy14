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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for RegularTimePoint as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by RegularTimePointAggregate
 *
 * @author your_name_here
 */
@Component("regularTimePoint-entity-projector")
public class RegularTimePointEntityProjector {

  // core constructor
  public RegularTimePointEntityProjector(RegularTimePointRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a RegularTimePoint
   *
   * @param	entity RegularTimePoint
   */
  public RegularTimePoint create(RegularTimePoint entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a RegularTimePoint
   *
   * @param	entity RegularTimePoint
   */
  public RegularTimePoint update(RegularTimePoint entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a RegularTimePoint
   *
   * @param	id		UUID
   */
  public RegularTimePoint delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    RegularTimePoint entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a SequenceNumber
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	RegularTimePoint
   */
  public RegularTimePoint assignSequenceNumber(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning SequenceNumber as " + assignment.toString());

    RegularTimePoint parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the SequenceNumber to the parent entity
    // ------------------------------------------
    parentEntity.setSequenceNumber(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SequenceNumber
   *
   * @param	parentId		UUID
   * @return	RegularTimePoint
   */
  public RegularTimePoint unAssignSequenceNumber(UUID parentId) {
    RegularTimePoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SequenceNumber on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SequenceNumber on the parent entithy
    // ------------------------------------------
    parentEntity.setSequenceNumber(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Value1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	RegularTimePoint
   */
  public RegularTimePoint assignValue1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Value1 as " + assignment.toString());

    RegularTimePoint parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Value1 to the parent entity
    // ------------------------------------------
    parentEntity.setValue1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Value1
   *
   * @param	parentId		UUID
   * @return	RegularTimePoint
   */
  public RegularTimePoint unAssignValue1(UUID parentId) {
    RegularTimePoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Value1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Value1 on the parent entithy
    // ------------------------------------------
    parentEntity.setValue1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Value2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	RegularTimePoint
   */
  public RegularTimePoint assignValue2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Value2 as " + assignment.toString());

    RegularTimePoint parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Value2 to the parent entity
    // ------------------------------------------
    parentEntity.setValue2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Value2
   *
   * @param	parentId		UUID
   * @return	RegularTimePoint
   */
  public RegularTimePoint unAssignValue2(UUID parentId) {
    RegularTimePoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Value2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Value2 on the parent entithy
    // ------------------------------------------
    parentEntity.setValue2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the TimePoints
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	RegularTimePoint
   */
  public RegularTimePoint addToTimePoints(UUID parentId, RegularTimePoint addTo) {
    LOGGER.info("handling AssignTimePointsToRegularTimePointEvent - ");

    RegularTimePoint parentEntity = repository.findById(parentId).get();
    RegularTimePoint child = RegularTimePointProjector.find(addTo.getRegularTimePointId());

    parentEntity.getTimePoints().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the TimePoints
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	RegularTimePoint
   */
  public RegularTimePoint removeFromTimePoints(UUID parentId, RegularTimePoint removeFrom) {
    LOGGER.info("handling RemoveTimePointsFromRegularTimePointEvent ");

    RegularTimePoint parentEntity = repository.findById(parentId).get();
    RegularTimePoint child = RegularTimePointProjector.find(removeFrom.getRegularTimePointId());

    parentEntity.getTimePoints().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the RegularTimePoint via an FindRegularTimePointQuery
   *
   * @return query FindRegularTimePointQuery
   */
  @SuppressWarnings("unused")
  public RegularTimePoint find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a RegularTimePoint - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all RegularTimePoints
   *
   * @param query FindAllRegularTimePointQuery
   * @return List<RegularTimePoint>
   */
  @SuppressWarnings("unused")
  public List<RegularTimePoint> findAll(FindAllRegularTimePointQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all RegularTimePoint - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final RegularTimePointRepository repository;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "regularTimePoint-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.projector
          .RegularTimePointEntityProjector
      RegularTimePointProjector;

  private static final Logger LOGGER =
      Logger.getLogger(RegularTimePointEntityProjector.class.getName());
}
