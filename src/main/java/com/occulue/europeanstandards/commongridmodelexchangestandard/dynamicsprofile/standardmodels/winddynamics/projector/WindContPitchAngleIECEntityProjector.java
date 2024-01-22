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
 * Projector for WindContPitchAngleIEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindContPitchAngleIECAggregate
 *
 * @author your_name_here
 */
@Component("windContPitchAngleIEC-entity-projector")
public class WindContPitchAngleIECEntityProjector {

  // core constructor
  public WindContPitchAngleIECEntityProjector(WindContPitchAngleIECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindContPitchAngleIEC
   *
   * @param	entity WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC create(WindContPitchAngleIEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindContPitchAngleIEC
   *
   * @param	entity WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC update(WindContPitchAngleIEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindContPitchAngleIEC
   *
   * @param	id		UUID
   */
  public WindContPitchAngleIEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindContPitchAngleIEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Dthetamax
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC assignDthetamax(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Dthetamax as " + assignment.toString());

    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Dthetamax to the parent entity
    // ------------------------------------------
    parentEntity.setDthetamax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dthetamax
   *
   * @param	parentId		UUID
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC unAssignDthetamax(UUID parentId) {
    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dthetamax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dthetamax on the parent entithy
    // ------------------------------------------
    parentEntity.setDthetamax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dthetamin
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC assignDthetamin(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Dthetamin as " + assignment.toString());

    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Dthetamin to the parent entity
    // ------------------------------------------
    parentEntity.setDthetamin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dthetamin
   *
   * @param	parentId		UUID
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC unAssignDthetamin(UUID parentId) {
    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dthetamin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dthetamin on the parent entithy
    // ------------------------------------------
    parentEntity.setDthetamin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kic
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC assignKic(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kic as " + assignment.toString());

    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kic to the parent entity
    // ------------------------------------------
    parentEntity.setKic(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kic
   *
   * @param	parentId		UUID
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC unAssignKic(UUID parentId) {
    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kic on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kic on the parent entithy
    // ------------------------------------------
    parentEntity.setKic(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kiomega
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC assignKiomega(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kiomega as " + assignment.toString());

    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kiomega to the parent entity
    // ------------------------------------------
    parentEntity.setKiomega(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kiomega
   *
   * @param	parentId		UUID
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC unAssignKiomega(UUID parentId) {
    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kiomega on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kiomega on the parent entithy
    // ------------------------------------------
    parentEntity.setKiomega(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC assignKpc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpc as " + assignment.toString());

    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpc to the parent entity
    // ------------------------------------------
    parentEntity.setKpc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpc
   *
   * @param	parentId		UUID
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC unAssignKpc(UUID parentId) {
    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpc on the parent entithy
    // ------------------------------------------
    parentEntity.setKpc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpomega
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC assignKpomega(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpomega as " + assignment.toString());

    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpomega to the parent entity
    // ------------------------------------------
    parentEntity.setKpomega(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpomega
   *
   * @param	parentId		UUID
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC unAssignKpomega(UUID parentId) {
    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpomega on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpomega on the parent entithy
    // ------------------------------------------
    parentEntity.setKpomega(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC assignKpx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpx as " + assignment.toString());

    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpx to the parent entity
    // ------------------------------------------
    parentEntity.setKpx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpx
   *
   * @param	parentId		UUID
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC unAssignKpx(UUID parentId) {
    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpx on the parent entithy
    // ------------------------------------------
    parentEntity.setKpx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Thetamax
   *
   * @param	parentId	UUID
   * @param	assignment 	AngleDegrees
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC assignThetamax(UUID parentId, AngleDegrees assignment) {
    LOGGER.info("assigning Thetamax as " + assignment.toString());

    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();
    assignment = AngleDegreesProjector.find(assignment.getAngleDegreesId());

    // ------------------------------------------
    // assign the Thetamax to the parent entity
    // ------------------------------------------
    parentEntity.setThetamax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Thetamax
   *
   * @param	parentId		UUID
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC unAssignThetamax(UUID parentId) {
    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Thetamax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Thetamax on the parent entithy
    // ------------------------------------------
    parentEntity.setThetamax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Thetamin
   *
   * @param	parentId	UUID
   * @param	assignment 	AngleDegrees
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC assignThetamin(UUID parentId, AngleDegrees assignment) {
    LOGGER.info("assigning Thetamin as " + assignment.toString());

    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();
    assignment = AngleDegreesProjector.find(assignment.getAngleDegreesId());

    // ------------------------------------------
    // assign the Thetamin to the parent entity
    // ------------------------------------------
    parentEntity.setThetamin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Thetamin
   *
   * @param	parentId		UUID
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC unAssignThetamin(UUID parentId) {
    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Thetamin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Thetamin on the parent entithy
    // ------------------------------------------
    parentEntity.setThetamin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ttheta
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC assignTtheta(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ttheta as " + assignment.toString());

    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ttheta to the parent entity
    // ------------------------------------------
    parentEntity.setTtheta(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ttheta
   *
   * @param	parentId		UUID
   * @return	WindContPitchAngleIEC
   */
  public WindContPitchAngleIEC unAssignTtheta(UUID parentId) {
    WindContPitchAngleIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ttheta on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ttheta on the parent entithy
    // ------------------------------------------
    parentEntity.setTtheta(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindContPitchAngleIEC via an FindWindContPitchAngleIECQuery
   *
   * @return query FindWindContPitchAngleIECQuery
   */
  @SuppressWarnings("unused")
  public WindContPitchAngleIEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindContPitchAngleIEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindContPitchAngleIECs
   *
   * @param query FindAllWindContPitchAngleIECQuery
   * @return List<WindContPitchAngleIEC>
   */
  @SuppressWarnings("unused")
  public List<WindContPitchAngleIEC> findAll(FindAllWindContPitchAngleIECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all WindContPitchAngleIEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindContPitchAngleIECRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "angleDegrees-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .AngleDegreesEntityProjector
      AngleDegreesProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(WindContPitchAngleIECEntityProjector.class.getName());
}
