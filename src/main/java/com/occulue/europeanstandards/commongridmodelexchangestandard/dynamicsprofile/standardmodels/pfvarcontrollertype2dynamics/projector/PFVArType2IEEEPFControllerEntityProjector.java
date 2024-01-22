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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for PFVArType2IEEEPFController as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PFVArType2IEEEPFControllerAggregate
 *
 * @author your_name_here
 */
@Component("pFVArType2IEEEPFController-entity-projector")
public class PFVArType2IEEEPFControllerEntityProjector {

  // core constructor
  public PFVArType2IEEEPFControllerEntityProjector(
      PFVArType2IEEEPFControllerRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PFVArType2IEEEPFController
   *
   * @param	entity PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController create(PFVArType2IEEEPFController entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PFVArType2IEEEPFController
   *
   * @param	entity PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController update(PFVArType2IEEEPFController entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PFVArType2IEEEPFController
   *
   * @param	id		UUID
   */
  public PFVArType2IEEEPFController delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PFVArType2IEEEPFController entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Exlon
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController assignExlon(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Exlon as " + assignment.toString());

    PFVArType2IEEEPFController parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Exlon to the parent entity
    // ------------------------------------------
    parentEntity.setExlon(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Exlon
   *
   * @param	parentId		UUID
   * @return	PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController unAssignExlon(UUID parentId) {
    PFVArType2IEEEPFController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Exlon on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Exlon on the parent entithy
    // ------------------------------------------
    parentEntity.setExlon(null);

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
   * @return	PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController assignKi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    PFVArType2IEEEPFController parentEntity = repository.findById(parentId).get();
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
   * @return	PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController unAssignKi(UUID parentId) {
    PFVArType2IEEEPFController parentEntity = repository.findById(parentId).get();

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
   * @return	PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController assignKp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kp as " + assignment.toString());

    PFVArType2IEEEPFController parentEntity = repository.findById(parentId).get();
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
   * @return	PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController unAssignKp(UUID parentId) {
    PFVArType2IEEEPFController parentEntity = repository.findById(parentId).get();

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
   * Assign a Pfref
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController assignPfref(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pfref as " + assignment.toString());

    PFVArType2IEEEPFController parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pfref to the parent entity
    // ------------------------------------------
    parentEntity.setPfref(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pfref
   *
   * @param	parentId		UUID
   * @return	PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController unAssignPfref(UUID parentId) {
    PFVArType2IEEEPFController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pfref on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pfref on the parent entithy
    // ------------------------------------------
    parentEntity.setPfref(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vclmt
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController assignVclmt(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vclmt as " + assignment.toString());

    PFVArType2IEEEPFController parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vclmt to the parent entity
    // ------------------------------------------
    parentEntity.setVclmt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vclmt
   *
   * @param	parentId		UUID
   * @return	PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController unAssignVclmt(UUID parentId) {
    PFVArType2IEEEPFController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vclmt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vclmt on the parent entithy
    // ------------------------------------------
    parentEntity.setVclmt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vref
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController assignVref(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vref as " + assignment.toString());

    PFVArType2IEEEPFController parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vref to the parent entity
    // ------------------------------------------
    parentEntity.setVref(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vref
   *
   * @param	parentId		UUID
   * @return	PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController unAssignVref(UUID parentId) {
    PFVArType2IEEEPFController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vref on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vref on the parent entithy
    // ------------------------------------------
    parentEntity.setVref(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vs
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController assignVs(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Vs as " + assignment.toString());

    PFVArType2IEEEPFController parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Vs to the parent entity
    // ------------------------------------------
    parentEntity.setVs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vs
   *
   * @param	parentId		UUID
   * @return	PFVArType2IEEEPFController
   */
  public PFVArType2IEEEPFController unAssignVs(UUID parentId) {
    PFVArType2IEEEPFController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vs on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vs on the parent entithy
    // ------------------------------------------
    parentEntity.setVs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PFVArType2IEEEPFController via an FindPFVArType2IEEEPFControllerQuery
   *
   * @return query FindPFVArType2IEEEPFControllerQuery
   */
  @SuppressWarnings("unused")
  public PFVArType2IEEEPFController find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a PFVArType2IEEEPFController - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PFVArType2IEEEPFControllers
   *
   * @param query FindAllPFVArType2IEEEPFControllerQuery
   * @return List<PFVArType2IEEEPFController>
   */
  @SuppressWarnings("unused")
  public List<PFVArType2IEEEPFController> findAll(FindAllPFVArType2IEEEPFControllerQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all PFVArType2IEEEPFController - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PFVArType2IEEEPFControllerRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  private static final Logger LOGGER =
      Logger.getLogger(PFVArType2IEEEPFControllerEntityProjector.class.getName());
}
