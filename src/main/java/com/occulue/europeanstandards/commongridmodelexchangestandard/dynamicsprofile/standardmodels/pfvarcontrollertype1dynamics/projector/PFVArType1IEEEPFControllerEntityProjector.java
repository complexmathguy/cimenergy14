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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype1dynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype1dynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for PFVArType1IEEEPFController as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PFVArType1IEEEPFControllerAggregate
 *
 * @author your_name_here
 */
@Component("pFVArType1IEEEPFController-entity-projector")
public class PFVArType1IEEEPFControllerEntityProjector {

  // core constructor
  public PFVArType1IEEEPFControllerEntityProjector(
      PFVArType1IEEEPFControllerRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PFVArType1IEEEPFController
   *
   * @param	entity PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController create(PFVArType1IEEEPFController entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PFVArType1IEEEPFController
   *
   * @param	entity PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController update(PFVArType1IEEEPFController entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PFVArType1IEEEPFController
   *
   * @param	id		UUID
   */
  public PFVArType1IEEEPFController delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PFVArType1IEEEPFController entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Ovex
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController assignOvex(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Ovex as " + assignment.toString());

    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Ovex to the parent entity
    // ------------------------------------------
    parentEntity.setOvex(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ovex
   *
   * @param	parentId		UUID
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController unAssignOvex(UUID parentId) {
    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ovex on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ovex on the parent entithy
    // ------------------------------------------
    parentEntity.setOvex(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpfc
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController assignTpfc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpfc as " + assignment.toString());

    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpfc to the parent entity
    // ------------------------------------------
    parentEntity.setTpfc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpfc
   *
   * @param	parentId		UUID
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController unAssignTpfc(UUID parentId) {
    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpfc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpfc on the parent entithy
    // ------------------------------------------
    parentEntity.setTpfc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vitmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController assignVitmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vitmin as " + assignment.toString());

    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vitmin to the parent entity
    // ------------------------------------------
    parentEntity.setVitmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vitmin
   *
   * @param	parentId		UUID
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController unAssignVitmin(UUID parentId) {
    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vitmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vitmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVitmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vpf
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController assignVpf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vpf as " + assignment.toString());

    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vpf to the parent entity
    // ------------------------------------------
    parentEntity.setVpf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vpf
   *
   * @param	parentId		UUID
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController unAssignVpf(UUID parentId) {
    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vpf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vpf on the parent entithy
    // ------------------------------------------
    parentEntity.setVpf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vpfcbw
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController assignVpfcbw(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Vpfcbw as " + assignment.toString());

    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Vpfcbw to the parent entity
    // ------------------------------------------
    parentEntity.setVpfcbw(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vpfcbw
   *
   * @param	parentId		UUID
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController unAssignVpfcbw(UUID parentId) {
    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vpfcbw on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vpfcbw on the parent entithy
    // ------------------------------------------
    parentEntity.setVpfcbw(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vpfref
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController assignVpfref(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vpfref as " + assignment.toString());

    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vpfref to the parent entity
    // ------------------------------------------
    parentEntity.setVpfref(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vpfref
   *
   * @param	parentId		UUID
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController unAssignVpfref(UUID parentId) {
    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vpfref on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vpfref on the parent entithy
    // ------------------------------------------
    parentEntity.setVpfref(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vvtmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController assignVvtmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vvtmax as " + assignment.toString());

    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vvtmax to the parent entity
    // ------------------------------------------
    parentEntity.setVvtmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vvtmax
   *
   * @param	parentId		UUID
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController unAssignVvtmax(UUID parentId) {
    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vvtmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vvtmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVvtmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vvtmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController assignVvtmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vvtmin as " + assignment.toString());

    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vvtmin to the parent entity
    // ------------------------------------------
    parentEntity.setVvtmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vvtmin
   *
   * @param	parentId		UUID
   * @return	PFVArType1IEEEPFController
   */
  public PFVArType1IEEEPFController unAssignVvtmin(UUID parentId) {
    PFVArType1IEEEPFController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vvtmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vvtmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVvtmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PFVArType1IEEEPFController via an FindPFVArType1IEEEPFControllerQuery
   *
   * @return query FindPFVArType1IEEEPFControllerQuery
   */
  @SuppressWarnings("unused")
  public PFVArType1IEEEPFController find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a PFVArType1IEEEPFController - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PFVArType1IEEEPFControllers
   *
   * @param query FindAllPFVArType1IEEEPFControllerQuery
   * @return List<PFVArType1IEEEPFController>
   */
  @SuppressWarnings("unused")
  public List<PFVArType1IEEEPFController> findAll(FindAllPFVArType1IEEEPFControllerQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all PFVArType1IEEEPFController - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PFVArType1IEEEPFControllerRepository repository;

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

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  private static final Logger LOGGER =
      Logger.getLogger(PFVArType1IEEEPFControllerEntityProjector.class.getName());
}
