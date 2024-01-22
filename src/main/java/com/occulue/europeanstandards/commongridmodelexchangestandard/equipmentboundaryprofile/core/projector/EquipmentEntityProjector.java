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
 * Projector for Equipment as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by EquipmentAggregate
 *
 * @author your_name_here
 */
@Component("equipment-entity-projector")
public class EquipmentEntityProjector {

  // core constructor
  public EquipmentEntityProjector(EquipmentRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Equipment
   *
   * @param	entity Equipment
   */
  public Equipment create(Equipment entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Equipment
   *
   * @param	entity Equipment
   */
  public Equipment update(Equipment entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Equipment
   *
   * @param	id		UUID
   */
  public Equipment delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Equipment entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the Equipments
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	Equipment
   */
  public Equipment addToEquipments(UUID parentId, Equipment addTo) {
    LOGGER.info("handling AssignEquipmentsToEquipmentEvent - ");

    Equipment parentEntity = repository.findById(parentId).get();
    Equipment child = EquipmentProjector.find(addTo.getEquipmentId());

    parentEntity.getEquipments().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the Equipments
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	Equipment
   */
  public Equipment removeFromEquipments(UUID parentId, Equipment removeFrom) {
    LOGGER.info("handling RemoveEquipmentsFromEquipmentEvent ");

    Equipment parentEntity = repository.findById(parentId).get();
    Equipment child = EquipmentProjector.find(removeFrom.getEquipmentId());

    parentEntity.getEquipments().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Equipment via an FindEquipmentQuery
   *
   * @return query FindEquipmentQuery
   */
  @SuppressWarnings("unused")
  public Equipment find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Equipment - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Equipments
   *
   * @param query FindAllEquipmentQuery
   * @return List<Equipment>
   */
  @SuppressWarnings("unused")
  public List<Equipment> findAll(FindAllEquipmentQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Equipment - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final EquipmentRepository repository;

  @Autowired
  @Qualifier(value = "equipment-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core
          .projector.EquipmentEntityProjector
      EquipmentProjector;

  private static final Logger LOGGER = Logger.getLogger(EquipmentEntityProjector.class.getName());
}
