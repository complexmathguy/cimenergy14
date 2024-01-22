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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for LoadGenericNonLinear as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by LoadGenericNonLinearAggregate
 *
 * @author your_name_here
 */
@Component("loadGenericNonLinear-entity-projector")
public class LoadGenericNonLinearEntityProjector {

  // core constructor
  public LoadGenericNonLinearEntityProjector(LoadGenericNonLinearRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a LoadGenericNonLinear
   *
   * @param	entity LoadGenericNonLinear
   */
  public LoadGenericNonLinear create(LoadGenericNonLinear entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a LoadGenericNonLinear
   *
   * @param	entity LoadGenericNonLinear
   */
  public LoadGenericNonLinear update(LoadGenericNonLinear entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a LoadGenericNonLinear
   *
   * @param	id		UUID
   */
  public LoadGenericNonLinear delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    LoadGenericNonLinear entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Bs
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear assignBs(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Bs as " + assignment.toString());

    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Bs to the parent entity
    // ------------------------------------------
    parentEntity.setBs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bs
   *
   * @param	parentId		UUID
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear unAssignBs(UUID parentId) {
    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bs on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bs on the parent entithy
    // ------------------------------------------
    parentEntity.setBs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Bt
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear assignBt(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Bt as " + assignment.toString());

    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Bt to the parent entity
    // ------------------------------------------
    parentEntity.setBt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bt
   *
   * @param	parentId		UUID
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear unAssignBt(UUID parentId) {
    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bt on the parent entithy
    // ------------------------------------------
    parentEntity.setBt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ls
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear assignLs(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ls as " + assignment.toString());

    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Ls to the parent entity
    // ------------------------------------------
    parentEntity.setLs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ls
   *
   * @param	parentId		UUID
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear unAssignLs(UUID parentId) {
    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ls on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ls on the parent entithy
    // ------------------------------------------
    parentEntity.setLs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Lt
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear assignLt(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Lt as " + assignment.toString());

    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Lt to the parent entity
    // ------------------------------------------
    parentEntity.setLt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Lt
   *
   * @param	parentId		UUID
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear unAssignLt(UUID parentId) {
    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Lt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Lt on the parent entithy
    // ------------------------------------------
    parentEntity.setLt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pt
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear assignPt(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Pt as " + assignment.toString());

    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Pt to the parent entity
    // ------------------------------------------
    parentEntity.setPt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pt
   *
   * @param	parentId		UUID
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear unAssignPt(UUID parentId) {
    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pt on the parent entithy
    // ------------------------------------------
    parentEntity.setPt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Qt
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear assignQt(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Qt as " + assignment.toString());

    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Qt to the parent entity
    // ------------------------------------------
    parentEntity.setQt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Qt
   *
   * @param	parentId		UUID
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear unAssignQt(UUID parentId) {
    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Qt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Qt on the parent entithy
    // ------------------------------------------
    parentEntity.setQt(null);

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
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear assignTp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tp as " + assignment.toString());

    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();
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
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear unAssignTp(UUID parentId) {
    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();

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
   * Assign a Tq
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear assignTq(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tq as " + assignment.toString());

    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tq to the parent entity
    // ------------------------------------------
    parentEntity.setTq(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tq
   *
   * @param	parentId		UUID
   * @return	LoadGenericNonLinear
   */
  public LoadGenericNonLinear unAssignTq(UUID parentId) {
    LoadGenericNonLinear parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tq on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tq on the parent entithy
    // ------------------------------------------
    parentEntity.setTq(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the LoadGenericNonLinear via an FindLoadGenericNonLinearQuery
   *
   * @return query FindLoadGenericNonLinearQuery
   */
  @SuppressWarnings("unused")
  public LoadGenericNonLinear find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a LoadGenericNonLinear - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all LoadGenericNonLinears
   *
   * @param query FindAllLoadGenericNonLinearQuery
   * @return List<LoadGenericNonLinear>
   */
  @SuppressWarnings("unused")
  public List<LoadGenericNonLinear> findAll(FindAllLoadGenericNonLinearQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all LoadGenericNonLinear - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final LoadGenericNonLinearRepository repository;

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

  private static final Logger LOGGER =
      Logger.getLogger(LoadGenericNonLinearEntityProjector.class.getName());
}
