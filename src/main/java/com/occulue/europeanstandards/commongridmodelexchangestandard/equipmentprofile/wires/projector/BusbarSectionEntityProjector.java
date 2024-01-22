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
 * Projector for BusbarSection as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by BusbarSectionAggregate
 *
 * @author your_name_here
 */
@Component("busbarSection-entity-projector")
public class BusbarSectionEntityProjector {

  // core constructor
  public BusbarSectionEntityProjector(BusbarSectionRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a BusbarSection
   *
   * @param	entity BusbarSection
   */
  public BusbarSection create(BusbarSection entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a BusbarSection
   *
   * @param	entity BusbarSection
   */
  public BusbarSection update(BusbarSection entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a BusbarSection
   *
   * @param	id		UUID
   */
  public BusbarSection delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    BusbarSection entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a IpMax
   *
   * @param	parentId	UUID
   * @param	assignment 	CurrentFlow
   * @return	BusbarSection
   */
  public BusbarSection assignIpMax(UUID parentId, CurrentFlow assignment) {
    LOGGER.info("assigning IpMax as " + assignment.toString());

    BusbarSection parentEntity = repository.findById(parentId).get();
    assignment = CurrentFlowProjector.find(assignment.getCurrentFlowId());

    // ------------------------------------------
    // assign the IpMax to the parent entity
    // ------------------------------------------
    parentEntity.setIpMax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the IpMax
   *
   * @param	parentId		UUID
   * @return	BusbarSection
   */
  public BusbarSection unAssignIpMax(UUID parentId) {
    BusbarSection parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning IpMax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the IpMax on the parent entithy
    // ------------------------------------------
    parentEntity.setIpMax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the BusbarSection via an FindBusbarSectionQuery
   *
   * @return query FindBusbarSectionQuery
   */
  @SuppressWarnings("unused")
  public BusbarSection find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a BusbarSection - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all BusbarSections
   *
   * @param query FindAllBusbarSectionQuery
   * @return List<BusbarSection>
   */
  @SuppressWarnings("unused")
  public List<BusbarSection> findAll(FindAllBusbarSectionQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all BusbarSection - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final BusbarSectionRepository repository;

  @Autowired
  @Qualifier(value = "currentFlow-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .CurrentFlowEntityProjector
      CurrentFlowProjector;

  private static final Logger LOGGER =
      Logger.getLogger(BusbarSectionEntityProjector.class.getName());
}
