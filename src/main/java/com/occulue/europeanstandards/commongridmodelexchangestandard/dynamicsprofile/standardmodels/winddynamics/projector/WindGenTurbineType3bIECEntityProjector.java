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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for WindGenTurbineType3bIEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindGenTurbineType3bIECAggregate
 *
 * @author your_name_here
 */
@Component("windGenTurbineType3bIEC-entity-projector")
public class WindGenTurbineType3bIECEntityProjector {

  // core constructor
  public WindGenTurbineType3bIECEntityProjector(WindGenTurbineType3bIECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindGenTurbineType3bIEC
   *
   * @param	entity WindGenTurbineType3bIEC
   */
  public WindGenTurbineType3bIEC create(WindGenTurbineType3bIEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindGenTurbineType3bIEC
   *
   * @param	entity WindGenTurbineType3bIEC
   */
  public WindGenTurbineType3bIEC update(WindGenTurbineType3bIEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindGenTurbineType3bIEC
   *
   * @param	id		UUID
   */
  public WindGenTurbineType3bIEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindGenTurbineType3bIEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Fducw
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindGenTurbineType3bIEC
   */
  public WindGenTurbineType3bIEC assignFducw(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Fducw as " + assignment.toString());

    WindGenTurbineType3bIEC parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Fducw to the parent entity
    // ------------------------------------------
    parentEntity.setFducw(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Fducw
   *
   * @param	parentId		UUID
   * @return	WindGenTurbineType3bIEC
   */
  public WindGenTurbineType3bIEC unAssignFducw(UUID parentId) {
    WindGenTurbineType3bIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Fducw on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Fducw on the parent entithy
    // ------------------------------------------
    parentEntity.setFducw(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mwtcwp
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	WindGenTurbineType3bIEC
   */
  public WindGenTurbineType3bIEC assignMwtcwp(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Mwtcwp as " + assignment.toString());

    WindGenTurbineType3bIEC parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Mwtcwp to the parent entity
    // ------------------------------------------
    parentEntity.setMwtcwp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mwtcwp
   *
   * @param	parentId		UUID
   * @return	WindGenTurbineType3bIEC
   */
  public WindGenTurbineType3bIEC unAssignMwtcwp(UUID parentId) {
    WindGenTurbineType3bIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mwtcwp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mwtcwp on the parent entithy
    // ------------------------------------------
    parentEntity.setMwtcwp(null);

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
   * @return	WindGenTurbineType3bIEC
   */
  public WindGenTurbineType3bIEC assignTg(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tg as " + assignment.toString());

    WindGenTurbineType3bIEC parentEntity = repository.findById(parentId).get();
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
   * @return	WindGenTurbineType3bIEC
   */
  public WindGenTurbineType3bIEC unAssignTg(UUID parentId) {
    WindGenTurbineType3bIEC parentEntity = repository.findById(parentId).get();

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
   * Assign a Two
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindGenTurbineType3bIEC
   */
  public WindGenTurbineType3bIEC assignTwo(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Two as " + assignment.toString());

    WindGenTurbineType3bIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Two to the parent entity
    // ------------------------------------------
    parentEntity.setTwo(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Two
   *
   * @param	parentId		UUID
   * @return	WindGenTurbineType3bIEC
   */
  public WindGenTurbineType3bIEC unAssignTwo(UUID parentId) {
    WindGenTurbineType3bIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Two on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Two on the parent entithy
    // ------------------------------------------
    parentEntity.setTwo(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xs
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindGenTurbineType3bIEC
   */
  public WindGenTurbineType3bIEC assignXs(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xs as " + assignment.toString());

    WindGenTurbineType3bIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xs to the parent entity
    // ------------------------------------------
    parentEntity.setXs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xs
   *
   * @param	parentId		UUID
   * @return	WindGenTurbineType3bIEC
   */
  public WindGenTurbineType3bIEC unAssignXs(UUID parentId) {
    WindGenTurbineType3bIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xs on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xs on the parent entithy
    // ------------------------------------------
    parentEntity.setXs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindGenTurbineType3bIEC via an FindWindGenTurbineType3bIECQuery
   *
   * @return query FindWindGenTurbineType3bIECQuery
   */
  @SuppressWarnings("unused")
  public WindGenTurbineType3bIEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindGenTurbineType3bIEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindGenTurbineType3bIECs
   *
   * @param query FindAllWindGenTurbineType3bIECQuery
   * @return List<WindGenTurbineType3bIEC>
   */
  @SuppressWarnings("unused")
  public List<WindGenTurbineType3bIEC> findAll(FindAllWindGenTurbineType3bIECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all WindGenTurbineType3bIEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindGenTurbineType3bIECRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType3bIECEntityProjector.class.getName());
}
