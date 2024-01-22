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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for VAdjIEEE as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by VAdjIEEEAggregate
 *
 * @author your_name_here
 */
@Component("vAdjIEEE-entity-projector")
public class VAdjIEEEEntityProjector {

  // core constructor
  public VAdjIEEEEntityProjector(VAdjIEEERepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a VAdjIEEE
   *
   * @param	entity VAdjIEEE
   */
  public VAdjIEEE create(VAdjIEEE entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a VAdjIEEE
   *
   * @param	entity VAdjIEEE
   */
  public VAdjIEEE update(VAdjIEEE entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a VAdjIEEE
   *
   * @param	id		UUID
   */
  public VAdjIEEE delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    VAdjIEEE entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Adjslew
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	VAdjIEEE
   */
  public VAdjIEEE assignAdjslew(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Adjslew as " + assignment.toString());

    VAdjIEEE parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Adjslew to the parent entity
    // ------------------------------------------
    parentEntity.setAdjslew(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Adjslew
   *
   * @param	parentId		UUID
   * @return	VAdjIEEE
   */
  public VAdjIEEE unAssignAdjslew(UUID parentId) {
    VAdjIEEE parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Adjslew on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Adjslew on the parent entithy
    // ------------------------------------------
    parentEntity.setAdjslew(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Taoff
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	VAdjIEEE
   */
  public VAdjIEEE assignTaoff(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Taoff as " + assignment.toString());

    VAdjIEEE parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Taoff to the parent entity
    // ------------------------------------------
    parentEntity.setTaoff(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Taoff
   *
   * @param	parentId		UUID
   * @return	VAdjIEEE
   */
  public VAdjIEEE unAssignTaoff(UUID parentId) {
    VAdjIEEE parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Taoff on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Taoff on the parent entithy
    // ------------------------------------------
    parentEntity.setTaoff(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Taon
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	VAdjIEEE
   */
  public VAdjIEEE assignTaon(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Taon as " + assignment.toString());

    VAdjIEEE parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Taon to the parent entity
    // ------------------------------------------
    parentEntity.setTaon(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Taon
   *
   * @param	parentId		UUID
   * @return	VAdjIEEE
   */
  public VAdjIEEE unAssignTaon(UUID parentId) {
    VAdjIEEE parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Taon on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Taon on the parent entithy
    // ------------------------------------------
    parentEntity.setTaon(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vadjf
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	VAdjIEEE
   */
  public VAdjIEEE assignVadjf(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Vadjf as " + assignment.toString());

    VAdjIEEE parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Vadjf to the parent entity
    // ------------------------------------------
    parentEntity.setVadjf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vadjf
   *
   * @param	parentId		UUID
   * @return	VAdjIEEE
   */
  public VAdjIEEE unAssignVadjf(UUID parentId) {
    VAdjIEEE parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vadjf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vadjf on the parent entithy
    // ------------------------------------------
    parentEntity.setVadjf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vadjmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	VAdjIEEE
   */
  public VAdjIEEE assignVadjmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vadjmax as " + assignment.toString());

    VAdjIEEE parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vadjmax to the parent entity
    // ------------------------------------------
    parentEntity.setVadjmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vadjmax
   *
   * @param	parentId		UUID
   * @return	VAdjIEEE
   */
  public VAdjIEEE unAssignVadjmax(UUID parentId) {
    VAdjIEEE parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vadjmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vadjmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVadjmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vadjmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	VAdjIEEE
   */
  public VAdjIEEE assignVadjmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vadjmin as " + assignment.toString());

    VAdjIEEE parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vadjmin to the parent entity
    // ------------------------------------------
    parentEntity.setVadjmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vadjmin
   *
   * @param	parentId		UUID
   * @return	VAdjIEEE
   */
  public VAdjIEEE unAssignVadjmin(UUID parentId) {
    VAdjIEEE parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vadjmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vadjmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVadjmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the VAdjIEEE via an FindVAdjIEEEQuery
   *
   * @return query FindVAdjIEEEQuery
   */
  @SuppressWarnings("unused")
  public VAdjIEEE find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a VAdjIEEE - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all VAdjIEEEs
   *
   * @param query FindAllVAdjIEEEQuery
   * @return List<VAdjIEEE>
   */
  @SuppressWarnings("unused")
  public List<VAdjIEEE> findAll(FindAllVAdjIEEEQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all VAdjIEEE - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final VAdjIEEERepository repository;

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

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  private static final Logger LOGGER = Logger.getLogger(VAdjIEEEEntityProjector.class.getName());
}
