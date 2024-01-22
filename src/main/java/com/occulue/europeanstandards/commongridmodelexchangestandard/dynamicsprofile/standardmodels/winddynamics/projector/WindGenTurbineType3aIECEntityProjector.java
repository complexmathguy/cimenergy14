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
 * Projector for WindGenTurbineType3aIEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindGenTurbineType3aIECAggregate
 *
 * @author your_name_here
 */
@Component("windGenTurbineType3aIEC-entity-projector")
public class WindGenTurbineType3aIECEntityProjector {

  // core constructor
  public WindGenTurbineType3aIECEntityProjector(WindGenTurbineType3aIECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindGenTurbineType3aIEC
   *
   * @param	entity WindGenTurbineType3aIEC
   */
  public WindGenTurbineType3aIEC create(WindGenTurbineType3aIEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindGenTurbineType3aIEC
   *
   * @param	entity WindGenTurbineType3aIEC
   */
  public WindGenTurbineType3aIEC update(WindGenTurbineType3aIEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindGenTurbineType3aIEC
   *
   * @param	id		UUID
   */
  public WindGenTurbineType3aIEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindGenTurbineType3aIEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Kpc
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindGenTurbineType3aIEC
   */
  public WindGenTurbineType3aIEC assignKpc(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kpc as " + assignment.toString());

    WindGenTurbineType3aIEC parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

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
   * @return	WindGenTurbineType3aIEC
   */
  public WindGenTurbineType3aIEC unAssignKpc(UUID parentId) {
    WindGenTurbineType3aIEC parentEntity = repository.findById(parentId).get();

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
   * Assign a Tic
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindGenTurbineType3aIEC
   */
  public WindGenTurbineType3aIEC assignTic(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tic as " + assignment.toString());

    WindGenTurbineType3aIEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tic to the parent entity
    // ------------------------------------------
    parentEntity.setTic(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tic
   *
   * @param	parentId		UUID
   * @return	WindGenTurbineType3aIEC
   */
  public WindGenTurbineType3aIEC unAssignTic(UUID parentId) {
    WindGenTurbineType3aIEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tic on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tic on the parent entithy
    // ------------------------------------------
    parentEntity.setTic(null);

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
   * @return	WindGenTurbineType3aIEC
   */
  public WindGenTurbineType3aIEC assignXs(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xs as " + assignment.toString());

    WindGenTurbineType3aIEC parentEntity = repository.findById(parentId).get();
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
   * @return	WindGenTurbineType3aIEC
   */
  public WindGenTurbineType3aIEC unAssignXs(UUID parentId) {
    WindGenTurbineType3aIEC parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the WindGenTurbineType3aIEC via an FindWindGenTurbineType3aIECQuery
   *
   * @return query FindWindGenTurbineType3aIECQuery
   */
  @SuppressWarnings("unused")
  public WindGenTurbineType3aIEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindGenTurbineType3aIEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindGenTurbineType3aIECs
   *
   * @param query FindAllWindGenTurbineType3aIECQuery
   * @return List<WindGenTurbineType3aIEC>
   */
  @SuppressWarnings("unused")
  public List<WindGenTurbineType3aIEC> findAll(FindAllWindGenTurbineType3aIECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all WindGenTurbineType3aIEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindGenTurbineType3aIECRepository repository;

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

  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType3aIECEntityProjector.class.getName());
}
