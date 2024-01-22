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
 * Projector for WindAeroLinearIEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindAeroLinearIECAggregate
 *
 * @author your_name_here
 */
@Component("windAeroLinearIEC-entity-projector")
public class WindAeroLinearIECEntityProjector {

  // core constructor
  public WindAeroLinearIECEntityProjector(WindAeroLinearIECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindAeroLinearIEC
   *
   * @param	entity WindAeroLinearIEC
   */
  public WindAeroLinearIEC create(WindAeroLinearIEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindAeroLinearIEC
   *
   * @param	entity WindAeroLinearIEC
   */
  public WindAeroLinearIEC update(WindAeroLinearIEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindAeroLinearIEC
   *
   * @param	id		UUID
   */
  public WindAeroLinearIEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindAeroLinearIEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Dpomega
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindAeroLinearIEC
   */
  public WindAeroLinearIEC assignDpomega(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dpomega as " + assignment.toString());

    WindAeroLinearIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dpomega to the parent entity
    // ------------------------------------------
    parentEntity.setDpomega(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dpomega
   *
   * @param	parentId		UUID
   * @return	WindAeroLinearIEC
   */
  public WindAeroLinearIEC unAssignDpomega(UUID parentId) {
    WindAeroLinearIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dpomega on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dpomega on the parent entithy
    // ------------------------------------------
    parentEntity.setDpomega(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dptheta
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindAeroLinearIEC
   */
  public WindAeroLinearIEC assignDptheta(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dptheta as " + assignment.toString());

    WindAeroLinearIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dptheta to the parent entity
    // ------------------------------------------
    parentEntity.setDptheta(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dptheta
   *
   * @param	parentId		UUID
   * @return	WindAeroLinearIEC
   */
  public WindAeroLinearIEC unAssignDptheta(UUID parentId) {
    WindAeroLinearIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dptheta on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dptheta on the parent entithy
    // ------------------------------------------
    parentEntity.setDptheta(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Omegazero
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindAeroLinearIEC
   */
  public WindAeroLinearIEC assignOmegazero(UUID parentId, PU assignment) {
    LOGGER.info("assigning Omegazero as " + assignment.toString());

    WindAeroLinearIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Omegazero to the parent entity
    // ------------------------------------------
    parentEntity.setOmegazero(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Omegazero
   *
   * @param	parentId		UUID
   * @return	WindAeroLinearIEC
   */
  public WindAeroLinearIEC unAssignOmegazero(UUID parentId) {
    WindAeroLinearIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Omegazero on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Omegazero on the parent entithy
    // ------------------------------------------
    parentEntity.setOmegazero(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pavail
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindAeroLinearIEC
   */
  public WindAeroLinearIEC assignPavail(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pavail as " + assignment.toString());

    WindAeroLinearIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pavail to the parent entity
    // ------------------------------------------
    parentEntity.setPavail(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pavail
   *
   * @param	parentId		UUID
   * @return	WindAeroLinearIEC
   */
  public WindAeroLinearIEC unAssignPavail(UUID parentId) {
    WindAeroLinearIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pavail on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pavail on the parent entithy
    // ------------------------------------------
    parentEntity.setPavail(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Thetazero
   *
   * @param	parentId	UUID
   * @param	assignment 	AngleDegrees
   * @return	WindAeroLinearIEC
   */
  public WindAeroLinearIEC assignThetazero(UUID parentId, AngleDegrees assignment) {
    LOGGER.info("assigning Thetazero as " + assignment.toString());

    WindAeroLinearIEC parentEntity = repository.findById(parentId).get();
    assignment = AngleDegreesProjector.find(assignment.getAngleDegreesId());

    // ------------------------------------------
    // assign the Thetazero to the parent entity
    // ------------------------------------------
    parentEntity.setThetazero(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Thetazero
   *
   * @param	parentId		UUID
   * @return	WindAeroLinearIEC
   */
  public WindAeroLinearIEC unAssignThetazero(UUID parentId) {
    WindAeroLinearIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Thetazero on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Thetazero on the parent entithy
    // ------------------------------------------
    parentEntity.setThetazero(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindAeroLinearIEC via an FindWindAeroLinearIECQuery
   *
   * @return query FindWindAeroLinearIECQuery
   */
  @SuppressWarnings("unused")
  public WindAeroLinearIEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindAeroLinearIEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindAeroLinearIECs
   *
   * @param query FindAllWindAeroLinearIECQuery
   * @return List<WindAeroLinearIEC>
   */
  @SuppressWarnings("unused")
  public List<WindAeroLinearIEC> findAll(FindAllWindAeroLinearIECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all WindAeroLinearIEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindAeroLinearIECRepository repository;

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

  private static final Logger LOGGER =
      Logger.getLogger(WindAeroLinearIECEntityProjector.class.getName());
}
