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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for DCGround as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DCGroundAggregate
 *
 * @author your_name_here
 */
@Component("dCGround-entity-projector")
public class DCGroundEntityProjector {

  // core constructor
  public DCGroundEntityProjector(DCGroundRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DCGround
   *
   * @param	entity DCGround
   */
  public DCGround create(DCGround entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DCGround
   *
   * @param	entity DCGround
   */
  public DCGround update(DCGround entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DCGround
   *
   * @param	id		UUID
   */
  public DCGround delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DCGround entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Inductance
   *
   * @param	parentId	UUID
   * @param	assignment 	Inductance
   * @return	DCGround
   */
  public DCGround assignInductance(UUID parentId, Inductance assignment) {
    LOGGER.info("assigning Inductance as " + assignment.toString());

    DCGround parentEntity = repository.findById(parentId).get();
    assignment = InductanceProjector.find(assignment.getInductanceId());

    // ------------------------------------------
    // assign the Inductance to the parent entity
    // ------------------------------------------
    parentEntity.setInductance(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Inductance
   *
   * @param	parentId		UUID
   * @return	DCGround
   */
  public DCGround unAssignInductance(UUID parentId) {
    DCGround parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Inductance on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Inductance on the parent entithy
    // ------------------------------------------
    parentEntity.setInductance(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a R
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	DCGround
   */
  public DCGround assignR(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning R as " + assignment.toString());

    DCGround parentEntity = repository.findById(parentId).get();
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
   * @return	DCGround
   */
  public DCGround unAssignR(UUID parentId) {
    DCGround parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the DCGround via an FindDCGroundQuery
   *
   * @return query FindDCGroundQuery
   */
  @SuppressWarnings("unused")
  public DCGround find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DCGround - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DCGrounds
   *
   * @param query FindAllDCGroundQuery
   * @return List<DCGround>
   */
  @SuppressWarnings("unused")
  public List<DCGround> findAll(FindAllDCGroundQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DCGround - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DCGroundRepository repository;

  @Autowired
  @Qualifier(value = "inductance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .InductanceEntityProjector
      InductanceProjector;

  @Autowired
  @Qualifier(value = "resistance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ResistanceEntityProjector
      ResistanceProjector;

  private static final Logger LOGGER = Logger.getLogger(DCGroundEntityProjector.class.getName());
}
