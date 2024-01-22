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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for Capacitance as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by CapacitanceAggregate
 *
 * @author your_name_here
 */
@Component("capacitance-entity-projector")
public class CapacitanceEntityProjector {

  // core constructor
  public CapacitanceEntityProjector(CapacitanceRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Capacitance
   *
   * @param	entity Capacitance
   */
  public Capacitance create(Capacitance entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Capacitance
   *
   * @param	entity Capacitance
   */
  public Capacitance update(Capacitance entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Capacitance
   *
   * @param	id		UUID
   */
  public Capacitance delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Capacitance entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Value
   *
   * @param	parentId	UUID
   * @param	assignment 	FloatProxy
   * @return	Capacitance
   */
  public Capacitance assignValue(UUID parentId, FloatProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    Capacitance parentEntity = repository.findById(parentId).get();
    assignment = FloatProxyProjector.find(assignment.getFloatProxyId());

    // ------------------------------------------
    // assign the Value to the parent entity
    // ------------------------------------------
    parentEntity.setValue(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Value
   *
   * @param	parentId		UUID
   * @return	Capacitance
   */
  public Capacitance unAssignValue(UUID parentId) {
    Capacitance parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Value on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Value on the parent entithy
    // ------------------------------------------
    parentEntity.setValue(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Capacitance via an FindCapacitanceQuery
   *
   * @return query FindCapacitanceQuery
   */
  @SuppressWarnings("unused")
  public Capacitance find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Capacitance - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Capacitances
   *
   * @param query FindAllCapacitanceQuery
   * @return List<Capacitance>
   */
  @SuppressWarnings("unused")
  public List<Capacitance> findAll(FindAllCapacitanceQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Capacitance - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final CapacitanceRepository repository;

  @Autowired
  @Qualifier(value = "floatProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .FloatProxyEntityProjector
      FloatProxyProjector;

  @Autowired
  @Qualifier(value = "dCLineSegment-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .DCLineSegmentEntityProjector
      DCLineSegmentProjector;

  private static final Logger LOGGER = Logger.getLogger(CapacitanceEntityProjector.class.getName());
}
