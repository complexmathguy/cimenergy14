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
 * Projector for WindContCurrLimIEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindContCurrLimIECAggregate
 *
 * @author your_name_here
 */
@Component("windContCurrLimIEC-entity-projector")
public class WindContCurrLimIECEntityProjector {

  // core constructor
  public WindContCurrLimIECEntityProjector(WindContCurrLimIECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindContCurrLimIEC
   *
   * @param	entity WindContCurrLimIEC
   */
  public WindContCurrLimIEC create(WindContCurrLimIEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindContCurrLimIEC
   *
   * @param	entity WindContCurrLimIEC
   */
  public WindContCurrLimIEC update(WindContCurrLimIEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindContCurrLimIEC
   *
   * @param	id		UUID
   */
  public WindContCurrLimIEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindContCurrLimIEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Imax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContCurrLimIEC
   */
  public WindContCurrLimIEC assignImax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Imax as " + assignment.toString());

    WindContCurrLimIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Imax to the parent entity
    // ------------------------------------------
    parentEntity.setImax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Imax
   *
   * @param	parentId		UUID
   * @return	WindContCurrLimIEC
   */
  public WindContCurrLimIEC unAssignImax(UUID parentId) {
    WindContCurrLimIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Imax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Imax on the parent entithy
    // ------------------------------------------
    parentEntity.setImax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Imaxdip
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContCurrLimIEC
   */
  public WindContCurrLimIEC assignImaxdip(UUID parentId, PU assignment) {
    LOGGER.info("assigning Imaxdip as " + assignment.toString());

    WindContCurrLimIEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Imaxdip to the parent entity
    // ------------------------------------------
    parentEntity.setImaxdip(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Imaxdip
   *
   * @param	parentId		UUID
   * @return	WindContCurrLimIEC
   */
  public WindContCurrLimIEC unAssignImaxdip(UUID parentId) {
    WindContCurrLimIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Imaxdip on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Imaxdip on the parent entithy
    // ------------------------------------------
    parentEntity.setImaxdip(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mdfslim
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	WindContCurrLimIEC
   */
  public WindContCurrLimIEC assignMdfslim(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Mdfslim as " + assignment.toString());

    WindContCurrLimIEC parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Mdfslim to the parent entity
    // ------------------------------------------
    parentEntity.setMdfslim(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mdfslim
   *
   * @param	parentId		UUID
   * @return	WindContCurrLimIEC
   */
  public WindContCurrLimIEC unAssignMdfslim(UUID parentId) {
    WindContCurrLimIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mdfslim on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mdfslim on the parent entithy
    // ------------------------------------------
    parentEntity.setMdfslim(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mqpri
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	WindContCurrLimIEC
   */
  public WindContCurrLimIEC assignMqpri(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Mqpri as " + assignment.toString());

    WindContCurrLimIEC parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Mqpri to the parent entity
    // ------------------------------------------
    parentEntity.setMqpri(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mqpri
   *
   * @param	parentId		UUID
   * @return	WindContCurrLimIEC
   */
  public WindContCurrLimIEC unAssignMqpri(UUID parentId) {
    WindContCurrLimIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mqpri on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mqpri on the parent entithy
    // ------------------------------------------
    parentEntity.setMqpri(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tufilt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContCurrLimIEC
   */
  public WindContCurrLimIEC assignTufilt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tufilt as " + assignment.toString());

    WindContCurrLimIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tufilt to the parent entity
    // ------------------------------------------
    parentEntity.setTufilt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tufilt
   *
   * @param	parentId		UUID
   * @return	WindContCurrLimIEC
   */
  public WindContCurrLimIEC unAssignTufilt(UUID parentId) {
    WindContCurrLimIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tufilt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tufilt on the parent entithy
    // ------------------------------------------
    parentEntity.setTufilt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindContCurrLimIEC via an FindWindContCurrLimIECQuery
   *
   * @return query FindWindContCurrLimIECQuery
   */
  @SuppressWarnings("unused")
  public WindContCurrLimIEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindContCurrLimIEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindContCurrLimIECs
   *
   * @param query FindAllWindContCurrLimIECQuery
   * @return List<WindContCurrLimIEC>
   */
  @SuppressWarnings("unused")
  public List<WindContCurrLimIEC> findAll(FindAllWindContCurrLimIECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all WindContCurrLimIEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindContCurrLimIECRepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

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

  private static final Logger LOGGER =
      Logger.getLogger(WindContCurrLimIECEntityProjector.class.getName());
}
