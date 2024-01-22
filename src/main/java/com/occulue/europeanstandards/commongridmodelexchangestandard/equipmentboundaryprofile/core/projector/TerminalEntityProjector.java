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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for Terminal as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by TerminalAggregate
 *
 * @author your_name_here
 */
@Component("terminal-entity-projector")
public class TerminalEntityProjector {

  // core constructor
  public TerminalEntityProjector(TerminalRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Terminal
   *
   * @param	entity Terminal
   */
  public Terminal create(Terminal entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Terminal
   *
   * @param	entity Terminal
   */
  public Terminal update(Terminal entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Terminal
   *
   * @param	id		UUID
   */
  public Terminal delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Terminal entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the Terminals
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	Terminal
   */
  public Terminal addToTerminals(UUID parentId, Terminal addTo) {
    LOGGER.info("handling AssignTerminalsToTerminalEvent - ");

    Terminal parentEntity = repository.findById(parentId).get();
    Terminal child = TerminalProjector.find(addTo.getTerminalId());

    parentEntity.getTerminals().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the Terminals
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	Terminal
   */
  public Terminal removeFromTerminals(UUID parentId, Terminal removeFrom) {
    LOGGER.info("handling RemoveTerminalsFromTerminalEvent ");

    Terminal parentEntity = repository.findById(parentId).get();
    Terminal child = TerminalProjector.find(removeFrom.getTerminalId());

    parentEntity.getTerminals().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Terminal via an FindTerminalQuery
   *
   * @return query FindTerminalQuery
   */
  @SuppressWarnings("unused")
  public Terminal find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Terminal - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Terminals
   *
   * @param query FindAllTerminalQuery
   * @return List<Terminal>
   */
  @SuppressWarnings("unused")
  public List<Terminal> findAll(FindAllTerminalQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Terminal - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final TerminalRepository repository;

  @Autowired
  @Qualifier(value = "terminal-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core
          .projector.TerminalEntityProjector
      TerminalProjector;

  private static final Logger LOGGER = Logger.getLogger(TerminalEntityProjector.class.getName());
}
