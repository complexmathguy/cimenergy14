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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for HydroPump as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by HydroPumpAggregate
 *
 * @author your_name_here
 */
@Component("hydroPump-entity-projector")
public class HydroPumpEntityProjector {

  // core constructor
  public HydroPumpEntityProjector(HydroPumpRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a HydroPump
   *
   * @param	entity HydroPump
   */
  public HydroPump create(HydroPump entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a HydroPump
   *
   * @param	entity HydroPump
   */
  public HydroPump update(HydroPump entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a HydroPump
   *
   * @param	id		UUID
   */
  public HydroPump delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    HydroPump entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a HydroPump
   *
   * @param	parentId	UUID
   * @param	assignment 	HydroPump
   * @return	HydroPump
   */
  public HydroPump assignHydroPump(UUID parentId, HydroPump assignment) {
    LOGGER.info("assigning HydroPump as " + assignment.toString());

    HydroPump parentEntity = repository.findById(parentId).get();
    assignment = HydroPumpProjector.find(assignment.getHydroPumpId());

    // ------------------------------------------
    // assign the HydroPump to the parent entity
    // ------------------------------------------
    parentEntity.setHydroPump(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the HydroPump
   *
   * @param	parentId		UUID
   * @return	HydroPump
   */
  public HydroPump unAssignHydroPump(UUID parentId) {
    HydroPump parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning HydroPump on " + parentEntity.toString());

    // ------------------------------------------
    // null out the HydroPump on the parent entithy
    // ------------------------------------------
    parentEntity.setHydroPump(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the HydroPumps
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	HydroPump
   */
  public HydroPump addToHydroPumps(UUID parentId, HydroPump addTo) {
    LOGGER.info("handling AssignHydroPumpsToHydroPumpEvent - ");

    HydroPump parentEntity = repository.findById(parentId).get();
    HydroPump child = HydroPumpProjector.find(addTo.getHydroPumpId());

    parentEntity.getHydroPumps().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the HydroPumps
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	HydroPump
   */
  public HydroPump removeFromHydroPumps(UUID parentId, HydroPump removeFrom) {
    LOGGER.info("handling RemoveHydroPumpsFromHydroPumpEvent ");

    HydroPump parentEntity = repository.findById(parentId).get();
    HydroPump child = HydroPumpProjector.find(removeFrom.getHydroPumpId());

    parentEntity.getHydroPumps().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the HydroPump via an FindHydroPumpQuery
   *
   * @return query FindHydroPumpQuery
   */
  @SuppressWarnings("unused")
  public HydroPump find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a HydroPump - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all HydroPumps
   *
   * @param query FindAllHydroPumpQuery
   * @return List<HydroPump>
   */
  @SuppressWarnings("unused")
  public List<HydroPump> findAll(FindAllHydroPumpQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all HydroPump - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final HydroPumpRepository repository;

  @Autowired
  @Qualifier(value = "hydroPump-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production
          .projector.HydroPumpEntityProjector
      HydroPumpProjector;

  private static final Logger LOGGER = Logger.getLogger(HydroPumpEntityProjector.class.getName());
}
