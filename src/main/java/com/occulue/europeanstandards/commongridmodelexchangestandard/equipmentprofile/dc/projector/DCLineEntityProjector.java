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
 * Projector for DCLine as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DCLineAggregate
 *
 * @author your_name_here
 */
@Component("dCLine-entity-projector")
public class DCLineEntityProjector {

  // core constructor
  public DCLineEntityProjector(DCLineRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DCLine
   *
   * @param	entity DCLine
   */
  public DCLine create(DCLine entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DCLine
   *
   * @param	entity DCLine
   */
  public DCLine update(DCLine entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DCLine
   *
   * @param	id		UUID
   */
  public DCLine delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DCLine entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the DCLines
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	DCLine
   */
  public DCLine addToDCLines(UUID parentId, DCLine addTo) {
    LOGGER.info("handling AssignDCLinesToDCLineEvent - ");

    DCLine parentEntity = repository.findById(parentId).get();
    DCLine child = DCLineProjector.find(addTo.getDCLineId());

    parentEntity.getDCLines().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the DCLines
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	DCLine
   */
  public DCLine removeFromDCLines(UUID parentId, DCLine removeFrom) {
    LOGGER.info("handling RemoveDCLinesFromDCLineEvent ");

    DCLine parentEntity = repository.findById(parentId).get();
    DCLine child = DCLineProjector.find(removeFrom.getDCLineId());

    parentEntity.getDCLines().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the DCLine via an FindDCLineQuery
   *
   * @return query FindDCLineQuery
   */
  @SuppressWarnings("unused")
  public DCLine find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DCLine - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DCLines
   *
   * @param query FindAllDCLineQuery
   * @return List<DCLine>
   */
  @SuppressWarnings("unused")
  public List<DCLine> findAll(FindAllDCLineQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DCLine - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DCLineRepository repository;

  @Autowired
  @Qualifier(value = "dCLine-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .DCLineEntityProjector
      DCLineProjector;

  private static final Logger LOGGER = Logger.getLogger(DCLineEntityProjector.class.getName());
}
