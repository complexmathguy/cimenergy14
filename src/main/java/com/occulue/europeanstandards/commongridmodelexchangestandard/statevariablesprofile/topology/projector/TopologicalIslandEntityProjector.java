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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.topology.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.topology.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for TopologicalIsland as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by TopologicalIslandAggregate
 *
 * @author your_name_here
 */
@Component("topologicalIsland-entity-projector")
public class TopologicalIslandEntityProjector {

  // core constructor
  public TopologicalIslandEntityProjector(TopologicalIslandRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a TopologicalIsland
   *
   * @param	entity TopologicalIsland
   */
  public TopologicalIsland create(TopologicalIsland entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a TopologicalIsland
   *
   * @param	entity TopologicalIsland
   */
  public TopologicalIsland update(TopologicalIsland entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a TopologicalIsland
   *
   * @param	id		UUID
   */
  public TopologicalIsland delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    TopologicalIsland entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a TopologicalIsland
   *
   * @param	parentId	UUID
   * @param	assignment 	TopologicalIsland
   * @return	TopologicalIsland
   */
  public TopologicalIsland assignTopologicalIsland(UUID parentId, TopologicalIsland assignment) {
    LOGGER.info("assigning TopologicalIsland as " + assignment.toString());

    TopologicalIsland parentEntity = repository.findById(parentId).get();
    assignment = TopologicalIslandProjector.find(assignment.getTopologicalIslandId());

    // ------------------------------------------
    // assign the TopologicalIsland to the parent entity
    // ------------------------------------------
    parentEntity.setTopologicalIsland(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the TopologicalIsland
   *
   * @param	parentId		UUID
   * @return	TopologicalIsland
   */
  public TopologicalIsland unAssignTopologicalIsland(UUID parentId) {
    TopologicalIsland parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning TopologicalIsland on " + parentEntity.toString());

    // ------------------------------------------
    // null out the TopologicalIsland on the parent entithy
    // ------------------------------------------
    parentEntity.setTopologicalIsland(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a AngleRefTopologicalIsland
   *
   * @param	parentId	UUID
   * @param	assignment 	TopologicalIsland
   * @return	TopologicalIsland
   */
  public TopologicalIsland assignAngleRefTopologicalIsland(
      UUID parentId, TopologicalIsland assignment) {
    LOGGER.info("assigning AngleRefTopologicalIsland as " + assignment.toString());

    TopologicalIsland parentEntity = repository.findById(parentId).get();
    assignment = TopologicalIslandProjector.find(assignment.getTopologicalIslandId());

    // ------------------------------------------
    // assign the AngleRefTopologicalIsland to the parent entity
    // ------------------------------------------
    parentEntity.setAngleRefTopologicalIsland(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the AngleRefTopologicalIsland
   *
   * @param	parentId		UUID
   * @return	TopologicalIsland
   */
  public TopologicalIsland unAssignAngleRefTopologicalIsland(UUID parentId) {
    TopologicalIsland parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning AngleRefTopologicalIsland on " + parentEntity.toString());

    // ------------------------------------------
    // null out the AngleRefTopologicalIsland on the parent entithy
    // ------------------------------------------
    parentEntity.setAngleRefTopologicalIsland(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the TopologicalIsland via an FindTopologicalIslandQuery
   *
   * @return query FindTopologicalIslandQuery
   */
  @SuppressWarnings("unused")
  public TopologicalIsland find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a TopologicalIsland - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all TopologicalIslands
   *
   * @param query FindAllTopologicalIslandQuery
   * @return List<TopologicalIsland>
   */
  @SuppressWarnings("unused")
  public List<TopologicalIsland> findAll(FindAllTopologicalIslandQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all TopologicalIsland - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final TopologicalIslandRepository repository;

  @Autowired
  @Qualifier(value = "topologicalIsland-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.topology
          .projector.TopologicalIslandEntityProjector
      TopologicalIslandProjector;

  private static final Logger LOGGER =
      Logger.getLogger(TopologicalIslandEntityProjector.class.getName());
}
