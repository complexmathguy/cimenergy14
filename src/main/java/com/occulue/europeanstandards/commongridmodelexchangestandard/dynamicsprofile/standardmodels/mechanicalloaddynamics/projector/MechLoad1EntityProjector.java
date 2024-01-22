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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.mechanicalloaddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.mechanicalloaddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for MechLoad1 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by MechLoad1Aggregate
 *
 * @author your_name_here
 */
@Component("mechLoad1-entity-projector")
public class MechLoad1EntityProjector {

  // core constructor
  public MechLoad1EntityProjector(MechLoad1Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a MechLoad1
   *
   * @param	entity MechLoad1
   */
  public MechLoad1 create(MechLoad1 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a MechLoad1
   *
   * @param	entity MechLoad1
   */
  public MechLoad1 update(MechLoad1 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a MechLoad1
   *
   * @param	id		UUID
   */
  public MechLoad1 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    MechLoad1 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a A
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	MechLoad1
   */
  public MechLoad1 assignA(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning A as " + assignment.toString());

    MechLoad1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the A to the parent entity
    // ------------------------------------------
    parentEntity.setA(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the A
   *
   * @param	parentId		UUID
   * @return	MechLoad1
   */
  public MechLoad1 unAssignA(UUID parentId) {
    MechLoad1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning A on " + parentEntity.toString());

    // ------------------------------------------
    // null out the A on the parent entithy
    // ------------------------------------------
    parentEntity.setA(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a B
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	MechLoad1
   */
  public MechLoad1 assignB(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning B as " + assignment.toString());

    MechLoad1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the B to the parent entity
    // ------------------------------------------
    parentEntity.setB(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B
   *
   * @param	parentId		UUID
   * @return	MechLoad1
   */
  public MechLoad1 unAssignB(UUID parentId) {
    MechLoad1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B on the parent entithy
    // ------------------------------------------
    parentEntity.setB(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a D
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	MechLoad1
   */
  public MechLoad1 assignD(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning D as " + assignment.toString());

    MechLoad1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the D to the parent entity
    // ------------------------------------------
    parentEntity.setD(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the D
   *
   * @param	parentId		UUID
   * @return	MechLoad1
   */
  public MechLoad1 unAssignD(UUID parentId) {
    MechLoad1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning D on " + parentEntity.toString());

    // ------------------------------------------
    // null out the D on the parent entithy
    // ------------------------------------------
    parentEntity.setD(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a E
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	MechLoad1
   */
  public MechLoad1 assignE(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning E as " + assignment.toString());

    MechLoad1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the E to the parent entity
    // ------------------------------------------
    parentEntity.setE(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the E
   *
   * @param	parentId		UUID
   * @return	MechLoad1
   */
  public MechLoad1 unAssignE(UUID parentId) {
    MechLoad1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning E on " + parentEntity.toString());

    // ------------------------------------------
    // null out the E on the parent entithy
    // ------------------------------------------
    parentEntity.setE(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the MechLoad1 via an FindMechLoad1Query
   *
   * @return query FindMechLoad1Query
   */
  @SuppressWarnings("unused")
  public MechLoad1 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a MechLoad1 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all MechLoad1s
   *
   * @param query FindAllMechLoad1Query
   * @return List<MechLoad1>
   */
  @SuppressWarnings("unused")
  public List<MechLoad1> findAll(FindAllMechLoad1Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all MechLoad1 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final MechLoad1Repository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  private static final Logger LOGGER = Logger.getLogger(MechLoad1EntityProjector.class.getName());
}
