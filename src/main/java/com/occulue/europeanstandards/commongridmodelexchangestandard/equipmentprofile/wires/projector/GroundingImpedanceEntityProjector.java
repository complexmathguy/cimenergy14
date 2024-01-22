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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for GroundingImpedance as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GroundingImpedanceAggregate
 *
 * @author your_name_here
 */
@Component("groundingImpedance-entity-projector")
public class GroundingImpedanceEntityProjector {

  // core constructor
  public GroundingImpedanceEntityProjector(GroundingImpedanceRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GroundingImpedance
   *
   * @param	entity GroundingImpedance
   */
  public GroundingImpedance create(GroundingImpedance entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GroundingImpedance
   *
   * @param	entity GroundingImpedance
   */
  public GroundingImpedance update(GroundingImpedance entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GroundingImpedance
   *
   * @param	id		UUID
   */
  public GroundingImpedance delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GroundingImpedance entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a X
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	GroundingImpedance
   */
  public GroundingImpedance assignX(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning X as " + assignment.toString());

    GroundingImpedance parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the X to the parent entity
    // ------------------------------------------
    parentEntity.setX(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X
   *
   * @param	parentId		UUID
   * @return	GroundingImpedance
   */
  public GroundingImpedance unAssignX(UUID parentId) {
    GroundingImpedance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X on the parent entithy
    // ------------------------------------------
    parentEntity.setX(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GroundingImpedance via an FindGroundingImpedanceQuery
   *
   * @return query FindGroundingImpedanceQuery
   */
  @SuppressWarnings("unused")
  public GroundingImpedance find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GroundingImpedance - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GroundingImpedances
   *
   * @param query FindAllGroundingImpedanceQuery
   * @return List<GroundingImpedance>
   */
  @SuppressWarnings("unused")
  public List<GroundingImpedance> findAll(FindAllGroundingImpedanceQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GroundingImpedance - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GroundingImpedanceRepository repository;

  @Autowired
  @Qualifier(value = "reactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactanceEntityProjector
      ReactanceProjector;

  private static final Logger LOGGER =
      Logger.getLogger(GroundingImpedanceEntityProjector.class.getName());
}
