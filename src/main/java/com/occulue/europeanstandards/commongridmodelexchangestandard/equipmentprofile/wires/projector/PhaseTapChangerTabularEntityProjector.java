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
 * Projector for PhaseTapChangerTabular as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PhaseTapChangerTabularAggregate
 *
 * @author your_name_here
 */
@Component("phaseTapChangerTabular-entity-projector")
public class PhaseTapChangerTabularEntityProjector {

  // core constructor
  public PhaseTapChangerTabularEntityProjector(PhaseTapChangerTabularRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PhaseTapChangerTabular
   *
   * @param	entity PhaseTapChangerTabular
   */
  public PhaseTapChangerTabular create(PhaseTapChangerTabular entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PhaseTapChangerTabular
   *
   * @param	entity PhaseTapChangerTabular
   */
  public PhaseTapChangerTabular update(PhaseTapChangerTabular entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PhaseTapChangerTabular
   *
   * @param	id		UUID
   */
  public PhaseTapChangerTabular delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PhaseTapChangerTabular entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the PhaseTapChangerTabular
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	PhaseTapChangerTabular
   */
  public PhaseTapChangerTabular addToPhaseTapChangerTabular(
      UUID parentId, PhaseTapChangerTabular addTo) {
    LOGGER.info("handling AssignPhaseTapChangerTabularToPhaseTapChangerTabularEvent - ");

    PhaseTapChangerTabular parentEntity = repository.findById(parentId).get();
    PhaseTapChangerTabular child =
        PhaseTapChangerTabularProjector.find(addTo.getPhaseTapChangerTabularId());

    parentEntity.getPhaseTapChangerTabular().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the PhaseTapChangerTabular
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	PhaseTapChangerTabular
   */
  public PhaseTapChangerTabular removeFromPhaseTapChangerTabular(
      UUID parentId, PhaseTapChangerTabular removeFrom) {
    LOGGER.info("handling RemovePhaseTapChangerTabularFromPhaseTapChangerTabularEvent ");

    PhaseTapChangerTabular parentEntity = repository.findById(parentId).get();
    PhaseTapChangerTabular child =
        PhaseTapChangerTabularProjector.find(removeFrom.getPhaseTapChangerTabularId());

    parentEntity.getPhaseTapChangerTabular().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the PhaseTapChangerTabular via an FindPhaseTapChangerTabularQuery
   *
   * @return query FindPhaseTapChangerTabularQuery
   */
  @SuppressWarnings("unused")
  public PhaseTapChangerTabular find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PhaseTapChangerTabular - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PhaseTapChangerTabulars
   *
   * @param query FindAllPhaseTapChangerTabularQuery
   * @return List<PhaseTapChangerTabular>
   */
  @SuppressWarnings("unused")
  public List<PhaseTapChangerTabular> findAll(FindAllPhaseTapChangerTabularQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all PhaseTapChangerTabular - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PhaseTapChangerTabularRepository repository;

  @Autowired
  @Qualifier(value = "phaseTapChangerTabular-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .PhaseTapChangerTabularEntityProjector
      PhaseTapChangerTabularProjector;

  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerTabularEntityProjector.class.getName());
}
