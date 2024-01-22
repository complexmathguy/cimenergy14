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
 * Projector for EarthFaultCompensator as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by EarthFaultCompensatorAggregate
 *
 * @author your_name_here
 */
@Component("earthFaultCompensator-entity-projector")
public class EarthFaultCompensatorEntityProjector {

  // core constructor
  public EarthFaultCompensatorEntityProjector(EarthFaultCompensatorRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a EarthFaultCompensator
   *
   * @param	entity EarthFaultCompensator
   */
  public EarthFaultCompensator create(EarthFaultCompensator entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a EarthFaultCompensator
   *
   * @param	entity EarthFaultCompensator
   */
  public EarthFaultCompensator update(EarthFaultCompensator entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a EarthFaultCompensator
   *
   * @param	id		UUID
   */
  public EarthFaultCompensator delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    EarthFaultCompensator entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a R
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	EarthFaultCompensator
   */
  public EarthFaultCompensator assignR(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning R as " + assignment.toString());

    EarthFaultCompensator parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the R to the parent entity
    // ------------------------------------------
    parentEntity.setR(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R
   *
   * @param	parentId		UUID
   * @return	EarthFaultCompensator
   */
  public EarthFaultCompensator unAssignR(UUID parentId) {
    EarthFaultCompensator parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R on the parent entithy
    // ------------------------------------------
    parentEntity.setR(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the EarthFaultCompensator via an FindEarthFaultCompensatorQuery
   *
   * @return query FindEarthFaultCompensatorQuery
   */
  @SuppressWarnings("unused")
  public EarthFaultCompensator find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a EarthFaultCompensator - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all EarthFaultCompensators
   *
   * @param query FindAllEarthFaultCompensatorQuery
   * @return List<EarthFaultCompensator>
   */
  @SuppressWarnings("unused")
  public List<EarthFaultCompensator> findAll(FindAllEarthFaultCompensatorQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all EarthFaultCompensator - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final EarthFaultCompensatorRepository repository;

  @Autowired
  @Qualifier(value = "resistance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ResistanceEntityProjector
      ResistanceProjector;

  private static final Logger LOGGER =
      Logger.getLogger(EarthFaultCompensatorEntityProjector.class.getName());
}
