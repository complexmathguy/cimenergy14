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
import org.springframework.stereotype.Component;

/**
 * Projector for EquipmentContainer as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by EquipmentContainerAggregate
 *
 * @author your_name_here
 */
@Component("equipmentContainer-entity-projector")
public class EquipmentContainerEntityProjector {

  // core constructor
  public EquipmentContainerEntityProjector(EquipmentContainerRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a EquipmentContainer
   *
   * @param	entity EquipmentContainer
   */
  public EquipmentContainer create(EquipmentContainer entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a EquipmentContainer
   *
   * @param	entity EquipmentContainer
   */
  public EquipmentContainer update(EquipmentContainer entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a EquipmentContainer
   *
   * @param	id		UUID
   */
  public EquipmentContainer delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    EquipmentContainer entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /**
   * Method to retrieve the EquipmentContainer via an FindEquipmentContainerQuery
   *
   * @return query FindEquipmentContainerQuery
   */
  @SuppressWarnings("unused")
  public EquipmentContainer find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a EquipmentContainer - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all EquipmentContainers
   *
   * @param query FindAllEquipmentContainerQuery
   * @return List<EquipmentContainer>
   */
  @SuppressWarnings("unused")
  public List<EquipmentContainer> findAll(FindAllEquipmentContainerQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all EquipmentContainer - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final EquipmentContainerRepository repository;

  private static final Logger LOGGER =
      Logger.getLogger(EquipmentContainerEntityProjector.class.getName());
}
