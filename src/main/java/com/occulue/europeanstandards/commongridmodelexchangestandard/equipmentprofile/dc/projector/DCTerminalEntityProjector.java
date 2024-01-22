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
 * Projector for DCTerminal as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DCTerminalAggregate
 *
 * @author your_name_here
 */
@Component("dCTerminal-entity-projector")
public class DCTerminalEntityProjector {

  // core constructor
  public DCTerminalEntityProjector(DCTerminalRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DCTerminal
   *
   * @param	entity DCTerminal
   */
  public DCTerminal create(DCTerminal entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DCTerminal
   *
   * @param	entity DCTerminal
   */
  public DCTerminal update(DCTerminal entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DCTerminal
   *
   * @param	id		UUID
   */
  public DCTerminal delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DCTerminal entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the DCTerminals
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	DCTerminal
   */
  public DCTerminal addToDCTerminals(UUID parentId, DCTerminal addTo) {
    LOGGER.info("handling AssignDCTerminalsToDCTerminalEvent - ");

    DCTerminal parentEntity = repository.findById(parentId).get();
    DCTerminal child = DCTerminalProjector.find(addTo.getDCTerminalId());

    parentEntity.getDCTerminals().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the DCTerminals
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	DCTerminal
   */
  public DCTerminal removeFromDCTerminals(UUID parentId, DCTerminal removeFrom) {
    LOGGER.info("handling RemoveDCTerminalsFromDCTerminalEvent ");

    DCTerminal parentEntity = repository.findById(parentId).get();
    DCTerminal child = DCTerminalProjector.find(removeFrom.getDCTerminalId());

    parentEntity.getDCTerminals().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the DCTerminal via an FindDCTerminalQuery
   *
   * @return query FindDCTerminalQuery
   */
  @SuppressWarnings("unused")
  public DCTerminal find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DCTerminal - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DCTerminals
   *
   * @param query FindAllDCTerminalQuery
   * @return List<DCTerminal>
   */
  @SuppressWarnings("unused")
  public List<DCTerminal> findAll(FindAllDCTerminalQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DCTerminal - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DCTerminalRepository repository;

  @Autowired
  @Qualifier(value = "dCTerminal-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .DCTerminalEntityProjector
      DCTerminalProjector;

  private static final Logger LOGGER = Logger.getLogger(DCTerminalEntityProjector.class.getName());
}
