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
 * Projector for PFVArType1IEEEVArController as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PFVArType1IEEEVArControllerAggregate
 *
 * @author your_name_here
 */
@Component("pFVArType1IEEEVArController-entity-projector")
public class PFVArType1IEEEVArControllerEntityProjector {

  // core constructor
  public PFVArType1IEEEVArControllerEntityProjector(
      PFVArType1IEEEVArControllerRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PFVArType1IEEEVArController
   *
   * @param	entity PFVArType1IEEEVArController
   */
  public PFVArType1IEEEVArController create(PFVArType1IEEEVArController entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PFVArType1IEEEVArController
   *
   * @param	entity PFVArType1IEEEVArController
   */
  public PFVArType1IEEEVArController update(PFVArType1IEEEVArController entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PFVArType1IEEEVArController
   *
   * @param	id		UUID
   */
  public PFVArType1IEEEVArController delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PFVArType1IEEEVArController entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Tvarc
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	PFVArType1IEEEVArController
   */
  public PFVArType1IEEEVArController assignTvarc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tvarc as " + assignment.toString());

    PFVArType1IEEEVArController parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tvarc to the parent entity
    // ------------------------------------------
    parentEntity.setTvarc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tvarc
   *
   * @param	parentId		UUID
   * @return	PFVArType1IEEEVArController
   */
  public PFVArType1IEEEVArController unAssignTvarc(UUID parentId) {
    PFVArType1IEEEVArController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tvarc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tvarc on the parent entithy
    // ------------------------------------------
    parentEntity.setTvarc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vvar
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PFVArType1IEEEVArController
   */
  public PFVArType1IEEEVArController assignVvar(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vvar as " + assignment.toString());

    PFVArType1IEEEVArController parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vvar to the parent entity
    // ------------------------------------------
    parentEntity.setVvar(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vvar
   *
   * @param	parentId		UUID
   * @return	PFVArType1IEEEVArController
   */
  public PFVArType1IEEEVArController unAssignVvar(UUID parentId) {
    PFVArType1IEEEVArController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vvar on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vvar on the parent entithy
    // ------------------------------------------
    parentEntity.setVvar(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vvarcbw
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	PFVArType1IEEEVArController
   */
  public PFVArType1IEEEVArController assignVvarcbw(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Vvarcbw as " + assignment.toString());

    PFVArType1IEEEVArController parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Vvarcbw to the parent entity
    // ------------------------------------------
    parentEntity.setVvarcbw(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vvarcbw
   *
   * @param	parentId		UUID
   * @return	PFVArType1IEEEVArController
   */
  public PFVArType1IEEEVArController unAssignVvarcbw(UUID parentId) {
    PFVArType1IEEEVArController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vvarcbw on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vvarcbw on the parent entithy
    // ------------------------------------------
    parentEntity.setVvarcbw(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vvarref
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	PFVArType1IEEEVArController
   */
  public PFVArType1IEEEVArController assignVvarref(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vvarref as " + assignment.toString());

    PFVArType1IEEEVArController parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vvarref to the parent entity
    // ------------------------------------------
    parentEntity.setVvarref(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vvarref
   *
   * @param	parentId		UUID
   * @return	PFVArType1IEEEVArController
   */
  public PFVArType1IEEEVArController unAssignVvarref(UUID parentId) {
    PFVArType1IEEEVArController parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vvarref on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vvarref on the parent entithy
    // ------------------------------------------
    parentEntity.setVvarref(null);

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
   * @return	PFVArType1IEEEVArController
   */
  public PFVArType1IEEEVArController assignVvtmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vvtmax as " + assignment.toString());

    PFVArType1IEEEVArController parentEntity = repository.findById(parentId).get();
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
   * @return	PFVArType1IEEEVArController
   */
  public PFVArType1IEEEVArController unAssignVvtmax(UUID parentId) {
    PFVArType1IEEEVArController parentEntity = repository.findById(parentId).get();

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
   * @return	PFVArType1IEEEVArController
   */
  public PFVArType1IEEEVArController assignVvtmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vvtmin as " + assignment.toString());

    PFVArType1IEEEVArController parentEntity = repository.findById(parentId).get();
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
   * @return	PFVArType1IEEEVArController
   */
  public PFVArType1IEEEVArController unAssignVvtmin(UUID parentId) {
    PFVArType1IEEEVArController parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the PFVArType1IEEEVArController via an FindPFVArType1IEEEVArControllerQuery
   *
   * @return query FindPFVArType1IEEEVArControllerQuery
   */
  @SuppressWarnings("unused")
  public PFVArType1IEEEVArController find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a PFVArType1IEEEVArController - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PFVArType1IEEEVArControllers
   *
   * @param query FindAllPFVArType1IEEEVArControllerQuery
   * @return List<PFVArType1IEEEVArController>
   */
  @SuppressWarnings("unused")
  public List<PFVArType1IEEEVArController> findAll(FindAllPFVArType1IEEEVArControllerQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all PFVArType1IEEEVArController - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PFVArType1IEEEVArControllerRepository repository;

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
      Logger.getLogger(PFVArType1IEEEVArControllerEntityProjector.class.getName());
}
