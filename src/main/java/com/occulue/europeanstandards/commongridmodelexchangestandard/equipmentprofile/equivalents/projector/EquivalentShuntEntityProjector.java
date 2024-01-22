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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for EquivalentShunt as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by EquivalentShuntAggregate
 *
 * @author your_name_here
 */
@Component("equivalentShunt-entity-projector")
public class EquivalentShuntEntityProjector {

  // core constructor
  public EquivalentShuntEntityProjector(EquivalentShuntRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a EquivalentShunt
   *
   * @param	entity EquivalentShunt
   */
  public EquivalentShunt create(EquivalentShunt entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a EquivalentShunt
   *
   * @param	entity EquivalentShunt
   */
  public EquivalentShunt update(EquivalentShunt entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a EquivalentShunt
   *
   * @param	id		UUID
   */
  public EquivalentShunt delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    EquivalentShunt entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a B
   *
   * @param	parentId	UUID
   * @param	assignment 	Susceptance
   * @return	EquivalentShunt
   */
  public EquivalentShunt assignB(UUID parentId, Susceptance assignment) {
    LOGGER.info("assigning B as " + assignment.toString());

    EquivalentShunt parentEntity = repository.findById(parentId).get();
    assignment = SusceptanceProjector.find(assignment.getSusceptanceId());

    // ------------------------------------------
    // assign the B to the parent entity
    // ------------------------------------------
    parentEntity.setB(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B
   *
   * @param	parentId		UUID
   * @return	EquivalentShunt
   */
  public EquivalentShunt unAssignB(UUID parentId) {
    EquivalentShunt parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B on the parent entithy
    // ------------------------------------------
    parentEntity.setB(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a G
   *
   * @param	parentId	UUID
   * @param	assignment 	Conductance
   * @return	EquivalentShunt
   */
  public EquivalentShunt assignG(UUID parentId, Conductance assignment) {
    LOGGER.info("assigning G as " + assignment.toString());

    EquivalentShunt parentEntity = repository.findById(parentId).get();
    assignment = ConductanceProjector.find(assignment.getConductanceId());

    // ------------------------------------------
    // assign the G to the parent entity
    // ------------------------------------------
    parentEntity.setG(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the G
   *
   * @param	parentId		UUID
   * @return	EquivalentShunt
   */
  public EquivalentShunt unAssignG(UUID parentId) {
    EquivalentShunt parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning G on " + parentEntity.toString());

    // ------------------------------------------
    // null out the G on the parent entithy
    // ------------------------------------------
    parentEntity.setG(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the EquivalentShunt via an FindEquivalentShuntQuery
   *
   * @return query FindEquivalentShuntQuery
   */
  @SuppressWarnings("unused")
  public EquivalentShunt find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a EquivalentShunt - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all EquivalentShunts
   *
   * @param query FindAllEquivalentShuntQuery
   * @return List<EquivalentShunt>
   */
  @SuppressWarnings("unused")
  public List<EquivalentShunt> findAll(FindAllEquivalentShuntQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all EquivalentShunt - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final EquivalentShuntRepository repository;

  @Autowired
  @Qualifier(value = "susceptance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SusceptanceEntityProjector
      SusceptanceProjector;

  @Autowired
  @Qualifier(value = "conductance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ConductanceEntityProjector
      ConductanceProjector;

  private static final Logger LOGGER =
      Logger.getLogger(EquivalentShuntEntityProjector.class.getName());
}
