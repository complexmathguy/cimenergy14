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
 * Projector for DCBaseTerminal as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DCBaseTerminalAggregate
 *
 * @author your_name_here
 */
@Component("dCBaseTerminal-entity-projector")
public class DCBaseTerminalEntityProjector {

  // core constructor
  public DCBaseTerminalEntityProjector(DCBaseTerminalRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DCBaseTerminal
   *
   * @param	entity DCBaseTerminal
   */
  public DCBaseTerminal create(DCBaseTerminal entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DCBaseTerminal
   *
   * @param	entity DCBaseTerminal
   */
  public DCBaseTerminal update(DCBaseTerminal entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DCBaseTerminal
   *
   * @param	id		UUID
   */
  public DCBaseTerminal delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DCBaseTerminal entity = repository.findById(id).get();

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
   * @return	DCBaseTerminal
   */
  public DCBaseTerminal addToDCTerminals(UUID parentId, DCBaseTerminal addTo) {
    LOGGER.info("handling AssignDCTerminalsToDCBaseTerminalEvent - ");

    DCBaseTerminal parentEntity = repository.findById(parentId).get();
    DCBaseTerminal child = DCBaseTerminalProjector.find(addTo.getDCBaseTerminalId());

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
   * @return	DCBaseTerminal
   */
  public DCBaseTerminal removeFromDCTerminals(UUID parentId, DCBaseTerminal removeFrom) {
    LOGGER.info("handling RemoveDCTerminalsFromDCBaseTerminalEvent ");

    DCBaseTerminal parentEntity = repository.findById(parentId).get();
    DCBaseTerminal child = DCBaseTerminalProjector.find(removeFrom.getDCBaseTerminalId());

    parentEntity.getDCTerminals().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the DCBaseTerminal via an FindDCBaseTerminalQuery
   *
   * @return query FindDCBaseTerminalQuery
   */
  @SuppressWarnings("unused")
  public DCBaseTerminal find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DCBaseTerminal - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DCBaseTerminals
   *
   * @param query FindAllDCBaseTerminalQuery
   * @return List<DCBaseTerminal>
   */
  @SuppressWarnings("unused")
  public List<DCBaseTerminal> findAll(FindAllDCBaseTerminalQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DCBaseTerminal - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DCBaseTerminalRepository repository;

  @Autowired
  @Qualifier(value = "dCBaseTerminal-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .DCBaseTerminalEntityProjector
      DCBaseTerminalProjector;

  private static final Logger LOGGER =
      Logger.getLogger(DCBaseTerminalEntityProjector.class.getName());
}
