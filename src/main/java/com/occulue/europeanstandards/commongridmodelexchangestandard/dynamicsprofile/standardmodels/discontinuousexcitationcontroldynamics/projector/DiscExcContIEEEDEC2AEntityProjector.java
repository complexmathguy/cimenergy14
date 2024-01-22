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
 * Projector for DiscExcContIEEEDEC2A as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DiscExcContIEEEDEC2AAggregate
 *
 * @author your_name_here
 */
@Component("discExcContIEEEDEC2A-entity-projector")
public class DiscExcContIEEEDEC2AEntityProjector {

  // core constructor
  public DiscExcContIEEEDEC2AEntityProjector(DiscExcContIEEEDEC2ARepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DiscExcContIEEEDEC2A
   *
   * @param	entity DiscExcContIEEEDEC2A
   */
  public DiscExcContIEEEDEC2A create(DiscExcContIEEEDEC2A entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DiscExcContIEEEDEC2A
   *
   * @param	entity DiscExcContIEEEDEC2A
   */
  public DiscExcContIEEEDEC2A update(DiscExcContIEEEDEC2A entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DiscExcContIEEEDEC2A
   *
   * @param	id		UUID
   */
  public DiscExcContIEEEDEC2A delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DiscExcContIEEEDEC2A entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Td1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	DiscExcContIEEEDEC2A
   */
  public DiscExcContIEEEDEC2A assignTd1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Td1 as " + assignment.toString());

    DiscExcContIEEEDEC2A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Td1 to the parent entity
    // ------------------------------------------
    parentEntity.setTd1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Td1
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC2A
   */
  public DiscExcContIEEEDEC2A unAssignTd1(UUID parentId) {
    DiscExcContIEEEDEC2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Td1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Td1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTd1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Td2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	DiscExcContIEEEDEC2A
   */
  public DiscExcContIEEEDEC2A assignTd2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Td2 as " + assignment.toString());

    DiscExcContIEEEDEC2A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Td2 to the parent entity
    // ------------------------------------------
    parentEntity.setTd2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Td2
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC2A
   */
  public DiscExcContIEEEDEC2A unAssignTd2(UUID parentId) {
    DiscExcContIEEEDEC2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Td2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Td2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTd2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vdmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC2A
   */
  public DiscExcContIEEEDEC2A assignVdmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vdmax as " + assignment.toString());

    DiscExcContIEEEDEC2A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vdmax to the parent entity
    // ------------------------------------------
    parentEntity.setVdmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vdmax
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC2A
   */
  public DiscExcContIEEEDEC2A unAssignVdmax(UUID parentId) {
    DiscExcContIEEEDEC2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vdmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vdmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVdmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vdmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC2A
   */
  public DiscExcContIEEEDEC2A assignVdmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vdmin as " + assignment.toString());

    DiscExcContIEEEDEC2A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vdmin to the parent entity
    // ------------------------------------------
    parentEntity.setVdmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vdmin
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC2A
   */
  public DiscExcContIEEEDEC2A unAssignVdmin(UUID parentId) {
    DiscExcContIEEEDEC2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vdmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vdmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVdmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vk
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC2A
   */
  public DiscExcContIEEEDEC2A assignVk(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vk as " + assignment.toString());

    DiscExcContIEEEDEC2A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vk to the parent entity
    // ------------------------------------------
    parentEntity.setVk(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vk
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC2A
   */
  public DiscExcContIEEEDEC2A unAssignVk(UUID parentId) {
    DiscExcContIEEEDEC2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vk on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vk on the parent entithy
    // ------------------------------------------
    parentEntity.setVk(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the DiscExcContIEEEDEC2A via an FindDiscExcContIEEEDEC2AQuery
   *
   * @return query FindDiscExcContIEEEDEC2AQuery
   */
  @SuppressWarnings("unused")
  public DiscExcContIEEEDEC2A find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DiscExcContIEEEDEC2A - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DiscExcContIEEEDEC2As
   *
   * @param query FindAllDiscExcContIEEEDEC2AQuery
   * @return List<DiscExcContIEEEDEC2A>
   */
  @SuppressWarnings("unused")
  public List<DiscExcContIEEEDEC2A> findAll(FindAllDiscExcContIEEEDEC2AQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DiscExcContIEEEDEC2A - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DiscExcContIEEEDEC2ARepository repository;

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
      Logger.getLogger(DiscExcContIEEEDEC2AEntityProjector.class.getName());
}
