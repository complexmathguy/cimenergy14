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
 * Projector for WindMechIEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindMechIECAggregate
 *
 * @author your_name_here
 */
@Component("windMechIEC-entity-projector")
public class WindMechIECEntityProjector {

  // core constructor
  public WindMechIECEntityProjector(WindMechIECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindMechIEC
   *
   * @param	entity WindMechIEC
   */
  public WindMechIEC create(WindMechIEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindMechIEC
   *
   * @param	entity WindMechIEC
   */
  public WindMechIEC update(WindMechIEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindMechIEC
   *
   * @param	id		UUID
   */
  public WindMechIEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindMechIEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Cdrt
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindMechIEC
   */
  public WindMechIEC assignCdrt(UUID parentId, PU assignment) {
    LOGGER.info("assigning Cdrt as " + assignment.toString());

    WindMechIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Cdrt to the parent entity
    // ------------------------------------------
    parentEntity.setCdrt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Cdrt
   *
   * @param	parentId		UUID
   * @return	WindMechIEC
   */
  public WindMechIEC unAssignCdrt(UUID parentId) {
    WindMechIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Cdrt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Cdrt on the parent entithy
    // ------------------------------------------
    parentEntity.setCdrt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Hgen
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindMechIEC
   */
  public WindMechIEC assignHgen(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Hgen as " + assignment.toString());

    WindMechIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Hgen to the parent entity
    // ------------------------------------------
    parentEntity.setHgen(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Hgen
   *
   * @param	parentId		UUID
   * @return	WindMechIEC
   */
  public WindMechIEC unAssignHgen(UUID parentId) {
    WindMechIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Hgen on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Hgen on the parent entithy
    // ------------------------------------------
    parentEntity.setHgen(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Hwtr
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindMechIEC
   */
  public WindMechIEC assignHwtr(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Hwtr as " + assignment.toString());

    WindMechIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Hwtr to the parent entity
    // ------------------------------------------
    parentEntity.setHwtr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Hwtr
   *
   * @param	parentId		UUID
   * @return	WindMechIEC
   */
  public WindMechIEC unAssignHwtr(UUID parentId) {
    WindMechIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Hwtr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Hwtr on the parent entithy
    // ------------------------------------------
    parentEntity.setHwtr(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kdrt
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindMechIEC
   */
  public WindMechIEC assignKdrt(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kdrt as " + assignment.toString());

    WindMechIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kdrt to the parent entity
    // ------------------------------------------
    parentEntity.setKdrt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kdrt
   *
   * @param	parentId		UUID
   * @return	WindMechIEC
   */
  public WindMechIEC unAssignKdrt(UUID parentId) {
    WindMechIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kdrt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kdrt on the parent entithy
    // ------------------------------------------
    parentEntity.setKdrt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindMechIEC via an FindWindMechIECQuery
   *
   * @return query FindWindMechIECQuery
   */
  @SuppressWarnings("unused")
  public WindMechIEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindMechIEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindMechIECs
   *
   * @param query FindAllWindMechIECQuery
   * @return List<WindMechIEC>
   */
  @SuppressWarnings("unused")
  public List<WindMechIEC> findAll(FindAllWindMechIECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all WindMechIEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindMechIECRepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(WindMechIECEntityProjector.class.getName());
}
