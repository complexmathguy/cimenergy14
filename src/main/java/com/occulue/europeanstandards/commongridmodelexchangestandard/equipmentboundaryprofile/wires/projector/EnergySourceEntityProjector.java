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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for EnergySource as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by EnergySourceAggregate
 *
 * @author your_name_here
 */
@Component("energySource-entity-projector")
public class EnergySourceEntityProjector {

  // core constructor
  public EnergySourceEntityProjector(EnergySourceRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a EnergySource
   *
   * @param	entity EnergySource
   */
  public EnergySource create(EnergySource entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a EnergySource
   *
   * @param	entity EnergySource
   */
  public EnergySource update(EnergySource entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a EnergySource
   *
   * @param	id		UUID
   */
  public EnergySource delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    EnergySource entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the EnergySource
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	EnergySource
   */
  public EnergySource addToEnergySource(UUID parentId, EnergySource addTo) {
    LOGGER.info("handling AssignEnergySourceToEnergySourceEvent - ");

    EnergySource parentEntity = repository.findById(parentId).get();
    EnergySource child = EnergySourceProjector.find(addTo.getEnergySourceId());

    parentEntity.getEnergySource().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the EnergySource
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	EnergySource
   */
  public EnergySource removeFromEnergySource(UUID parentId, EnergySource removeFrom) {
    LOGGER.info("handling RemoveEnergySourceFromEnergySourceEvent ");

    EnergySource parentEntity = repository.findById(parentId).get();
    EnergySource child = EnergySourceProjector.find(removeFrom.getEnergySourceId());

    parentEntity.getEnergySource().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the EnergySource via an FindEnergySourceQuery
   *
   * @return query FindEnergySourceQuery
   */
  @SuppressWarnings("unused")
  public EnergySource find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a EnergySource - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all EnergySources
   *
   * @param query FindAllEnergySourceQuery
   * @return List<EnergySource>
   */
  @SuppressWarnings("unused")
  public List<EnergySource> findAll(FindAllEnergySourceQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all EnergySource - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final EnergySourceRepository repository;

  @Autowired
  @Qualifier(value = "energySource-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires
          .projector.EnergySourceEntityProjector
      EnergySourceProjector;

  private static final Logger LOGGER =
      Logger.getLogger(EnergySourceEntityProjector.class.getName());
}
