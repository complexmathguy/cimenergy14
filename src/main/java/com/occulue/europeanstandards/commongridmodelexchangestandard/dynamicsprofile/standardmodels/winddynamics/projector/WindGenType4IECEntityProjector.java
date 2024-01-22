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
 * Projector for WindGenType4IEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindGenType4IECAggregate
 *
 * @author your_name_here
 */
@Component("windGenType4IEC-entity-projector")
public class WindGenType4IECEntityProjector {

  // core constructor
  public WindGenType4IECEntityProjector(WindGenType4IECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindGenType4IEC
   *
   * @param	entity WindGenType4IEC
   */
  public WindGenType4IEC create(WindGenType4IEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindGenType4IEC
   *
   * @param	entity WindGenType4IEC
   */
  public WindGenType4IEC update(WindGenType4IEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindGenType4IEC
   *
   * @param	id		UUID
   */
  public WindGenType4IEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindGenType4IEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Dipmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindGenType4IEC
   */
  public WindGenType4IEC assignDipmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dipmax as " + assignment.toString());

    WindGenType4IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dipmax to the parent entity
    // ------------------------------------------
    parentEntity.setDipmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dipmax
   *
   * @param	parentId		UUID
   * @return	WindGenType4IEC
   */
  public WindGenType4IEC unAssignDipmax(UUID parentId) {
    WindGenType4IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dipmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dipmax on the parent entithy
    // ------------------------------------------
    parentEntity.setDipmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Diqmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindGenType4IEC
   */
  public WindGenType4IEC assignDiqmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Diqmax as " + assignment.toString());

    WindGenType4IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Diqmax to the parent entity
    // ------------------------------------------
    parentEntity.setDiqmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Diqmax
   *
   * @param	parentId		UUID
   * @return	WindGenType4IEC
   */
  public WindGenType4IEC unAssignDiqmax(UUID parentId) {
    WindGenType4IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Diqmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Diqmax on the parent entithy
    // ------------------------------------------
    parentEntity.setDiqmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Diqmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindGenType4IEC
   */
  public WindGenType4IEC assignDiqmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Diqmin as " + assignment.toString());

    WindGenType4IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Diqmin to the parent entity
    // ------------------------------------------
    parentEntity.setDiqmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Diqmin
   *
   * @param	parentId		UUID
   * @return	WindGenType4IEC
   */
  public WindGenType4IEC unAssignDiqmin(UUID parentId) {
    WindGenType4IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Diqmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Diqmin on the parent entithy
    // ------------------------------------------
    parentEntity.setDiqmin(null);

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
   * @return	WindGenType4IEC
   */
  public WindGenType4IEC assignTg(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tg as " + assignment.toString());

    WindGenType4IEC parentEntity = repository.findById(parentId).get();
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
   * @return	WindGenType4IEC
   */
  public WindGenType4IEC unAssignTg(UUID parentId) {
    WindGenType4IEC parentEntity = repository.findById(parentId).get();

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

  /**
   * Method to retrieve the WindGenType4IEC via an FindWindGenType4IECQuery
   *
   * @return query FindWindGenType4IECQuery
   */
  @SuppressWarnings("unused")
  public WindGenType4IEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindGenType4IEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindGenType4IECs
   *
   * @param query FindAllWindGenType4IECQuery
   * @return List<WindGenType4IEC>
   */
  @SuppressWarnings("unused")
  public List<WindGenType4IEC> findAll(FindAllWindGenType4IECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all WindGenType4IEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindGenType4IECRepository repository;

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

  private static final Logger LOGGER =
      Logger.getLogger(WindGenType4IECEntityProjector.class.getName());
}
