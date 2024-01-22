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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for DiscExcContIEEEDEC3A as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DiscExcContIEEEDEC3AAggregate
 *
 * @author your_name_here
 */
@Component("discExcContIEEEDEC3A-entity-projector")
public class DiscExcContIEEEDEC3AEntityProjector {

  // core constructor
  public DiscExcContIEEEDEC3AEntityProjector(DiscExcContIEEEDEC3ARepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DiscExcContIEEEDEC3A
   *
   * @param	entity DiscExcContIEEEDEC3A
   */
  public DiscExcContIEEEDEC3A create(DiscExcContIEEEDEC3A entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DiscExcContIEEEDEC3A
   *
   * @param	entity DiscExcContIEEEDEC3A
   */
  public DiscExcContIEEEDEC3A update(DiscExcContIEEEDEC3A entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DiscExcContIEEEDEC3A
   *
   * @param	id		UUID
   */
  public DiscExcContIEEEDEC3A delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DiscExcContIEEEDEC3A entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Tdr
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	DiscExcContIEEEDEC3A
   */
  public DiscExcContIEEEDEC3A assignTdr(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tdr as " + assignment.toString());

    DiscExcContIEEEDEC3A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tdr to the parent entity
    // ------------------------------------------
    parentEntity.setTdr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tdr
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC3A
   */
  public DiscExcContIEEEDEC3A unAssignTdr(UUID parentId) {
    DiscExcContIEEEDEC3A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tdr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tdr on the parent entithy
    // ------------------------------------------
    parentEntity.setTdr(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vtmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC3A
   */
  public DiscExcContIEEEDEC3A assignVtmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vtmin as " + assignment.toString());

    DiscExcContIEEEDEC3A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vtmin to the parent entity
    // ------------------------------------------
    parentEntity.setVtmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vtmin
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC3A
   */
  public DiscExcContIEEEDEC3A unAssignVtmin(UUID parentId) {
    DiscExcContIEEEDEC3A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vtmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vtmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVtmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the DiscExcContIEEEDEC3A via an FindDiscExcContIEEEDEC3AQuery
   *
   * @return query FindDiscExcContIEEEDEC3AQuery
   */
  @SuppressWarnings("unused")
  public DiscExcContIEEEDEC3A find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DiscExcContIEEEDEC3A - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DiscExcContIEEEDEC3As
   *
   * @param query FindAllDiscExcContIEEEDEC3AQuery
   * @return List<DiscExcContIEEEDEC3A>
   */
  @SuppressWarnings("unused")
  public List<DiscExcContIEEEDEC3A> findAll(FindAllDiscExcContIEEEDEC3AQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DiscExcContIEEEDEC3A - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DiscExcContIEEEDEC3ARepository repository;

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
      Logger.getLogger(DiscExcContIEEEDEC3AEntityProjector.class.getName());
}
