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
import org.springframework.stereotype.Component;

/**
 * Projector for PhaseTapChangerTable as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PhaseTapChangerTableAggregate
 *
 * @author your_name_here
 */
@Component("phaseTapChangerTable-entity-projector")
public class PhaseTapChangerTableEntityProjector {

  // core constructor
  public PhaseTapChangerTableEntityProjector(PhaseTapChangerTableRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PhaseTapChangerTable
   *
   * @param	entity PhaseTapChangerTable
   */
  public PhaseTapChangerTable create(PhaseTapChangerTable entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PhaseTapChangerTable
   *
   * @param	entity PhaseTapChangerTable
   */
  public PhaseTapChangerTable update(PhaseTapChangerTable entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PhaseTapChangerTable
   *
   * @param	id		UUID
   */
  public PhaseTapChangerTable delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PhaseTapChangerTable entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /**
   * Method to retrieve the PhaseTapChangerTable via an FindPhaseTapChangerTableQuery
   *
   * @return query FindPhaseTapChangerTableQuery
   */
  @SuppressWarnings("unused")
  public PhaseTapChangerTable find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PhaseTapChangerTable - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PhaseTapChangerTables
   *
   * @param query FindAllPhaseTapChangerTableQuery
   * @return List<PhaseTapChangerTable>
   */
  @SuppressWarnings("unused")
  public List<PhaseTapChangerTable> findAll(FindAllPhaseTapChangerTableQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PhaseTapChangerTable - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PhaseTapChangerTableRepository repository;

  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerTableEntityProjector.class.getName());
}
