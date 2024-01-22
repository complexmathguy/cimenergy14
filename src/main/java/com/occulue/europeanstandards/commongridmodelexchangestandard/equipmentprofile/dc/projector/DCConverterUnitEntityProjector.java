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
 * Projector for DCConverterUnit as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DCConverterUnitAggregate
 *
 * @author your_name_here
 */
@Component("dCConverterUnit-entity-projector")
public class DCConverterUnitEntityProjector {

  // core constructor
  public DCConverterUnitEntityProjector(DCConverterUnitRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DCConverterUnit
   *
   * @param	entity DCConverterUnit
   */
  public DCConverterUnit create(DCConverterUnit entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DCConverterUnit
   *
   * @param	entity DCConverterUnit
   */
  public DCConverterUnit update(DCConverterUnit entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DCConverterUnit
   *
   * @param	id		UUID
   */
  public DCConverterUnit delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DCConverterUnit entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Add to the DCConverterUnit
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	DCConverterUnit
   */
  public DCConverterUnit addToDCConverterUnit(UUID parentId, DCConverterUnit addTo) {
    LOGGER.info("handling AssignDCConverterUnitToDCConverterUnitEvent - ");

    DCConverterUnit parentEntity = repository.findById(parentId).get();
    DCConverterUnit child = DCConverterUnitProjector.find(addTo.getDCConverterUnitId());

    parentEntity.getDCConverterUnit().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the DCConverterUnit
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	DCConverterUnit
   */
  public DCConverterUnit removeFromDCConverterUnit(UUID parentId, DCConverterUnit removeFrom) {
    LOGGER.info("handling RemoveDCConverterUnitFromDCConverterUnitEvent ");

    DCConverterUnit parentEntity = repository.findById(parentId).get();
    DCConverterUnit child = DCConverterUnitProjector.find(removeFrom.getDCConverterUnitId());

    parentEntity.getDCConverterUnit().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the DCConverterUnit via an FindDCConverterUnitQuery
   *
   * @return query FindDCConverterUnitQuery
   */
  @SuppressWarnings("unused")
  public DCConverterUnit find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DCConverterUnit - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DCConverterUnits
   *
   * @param query FindAllDCConverterUnitQuery
   * @return List<DCConverterUnit>
   */
  @SuppressWarnings("unused")
  public List<DCConverterUnit> findAll(FindAllDCConverterUnitQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DCConverterUnit - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DCConverterUnitRepository repository;

  @Autowired
  @Qualifier(value = "dCConverterUnit-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .DCConverterUnitEntityProjector
      DCConverterUnitProjector;

  private static final Logger LOGGER =
      Logger.getLogger(DCConverterUnitEntityProjector.class.getName());
}
