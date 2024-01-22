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
 * Projector for SetPoint as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SetPointAggregate
 *
 * @author your_name_here
 */
@Component("setPoint-entity-projector")
public class SetPointEntityProjector {

  // core constructor
  public SetPointEntityProjector(SetPointRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a SetPoint
   *
   * @param	entity SetPoint
   */
  public SetPoint create(SetPoint entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a SetPoint
   *
   * @param	entity SetPoint
   */
  public SetPoint update(SetPoint entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a SetPoint
   *
   * @param	id		UUID
   */
  public SetPoint delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    SetPoint entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a NormalValue
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	SetPoint
   */
  public SetPoint assignNormalValue(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning NormalValue as " + assignment.toString());

    SetPoint parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the NormalValue to the parent entity
    // ------------------------------------------
    parentEntity.setNormalValue(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NormalValue
   *
   * @param	parentId		UUID
   * @return	SetPoint
   */
  public SetPoint unAssignNormalValue(UUID parentId) {
    SetPoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NormalValue on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NormalValue on the parent entithy
    // ------------------------------------------
    parentEntity.setNormalValue(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Value
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	SetPoint
   */
  public SetPoint assignValue(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    SetPoint parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Value to the parent entity
    // ------------------------------------------
    parentEntity.setValue(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Value
   *
   * @param	parentId		UUID
   * @return	SetPoint
   */
  public SetPoint unAssignValue(UUID parentId) {
    SetPoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Value on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Value on the parent entithy
    // ------------------------------------------
    parentEntity.setValue(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the SetPoint via an FindSetPointQuery
   *
   * @return query FindSetPointQuery
   */
  @SuppressWarnings("unused")
  public SetPoint find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a SetPoint - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all SetPoints
   *
   * @param query FindAllSetPointQuery
   * @return List<SetPoint>
   */
  @SuppressWarnings("unused")
  public List<SetPoint> findAll(FindAllSetPointQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all SetPoint - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SetPointRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  private static final Logger LOGGER = Logger.getLogger(SetPointEntityProjector.class.getName());
}
