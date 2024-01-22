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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for ResistancePerLength as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ResistancePerLengthAggregate
 *
 * @author your_name_here
 */
@Component("resistancePerLength-entity-projector")
public class ResistancePerLengthEntityProjector {

  // core constructor
  public ResistancePerLengthEntityProjector(ResistancePerLengthRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ResistancePerLength
   *
   * @param	entity ResistancePerLength
   */
  public ResistancePerLength create(ResistancePerLength entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ResistancePerLength
   *
   * @param	entity ResistancePerLength
   */
  public ResistancePerLength update(ResistancePerLength entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ResistancePerLength
   *
   * @param	id		UUID
   */
  public ResistancePerLength delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ResistancePerLength entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Value
   *
   * @param	parentId	UUID
   * @param	assignment 	FloatProxy
   * @return	ResistancePerLength
   */
  public ResistancePerLength assignValue(UUID parentId, FloatProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    ResistancePerLength parentEntity = repository.findById(parentId).get();
    assignment = FloatProxyProjector.find(assignment.getFloatProxyId());

    // ------------------------------------------
    // assign the Value to the parent entity
    // ------------------------------------------
    parentEntity.setValue(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Value
   *
   * @param	parentId		UUID
   * @return	ResistancePerLength
   */
  public ResistancePerLength unAssignValue(UUID parentId) {
    ResistancePerLength parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Value on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Value on the parent entithy
    // ------------------------------------------
    parentEntity.setValue(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ResistancePerLength via an FindResistancePerLengthQuery
   *
   * @return query FindResistancePerLengthQuery
   */
  @SuppressWarnings("unused")
  public ResistancePerLength find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ResistancePerLength - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ResistancePerLengths
   *
   * @param query FindAllResistancePerLengthQuery
   * @return List<ResistancePerLength>
   */
  @SuppressWarnings("unused")
  public List<ResistancePerLength> findAll(FindAllResistancePerLengthQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ResistancePerLength - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ResistancePerLengthRepository repository;

  @Autowired
  @Qualifier(value = "floatProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .FloatProxyEntityProjector
      FloatProxyProjector;

  @Autowired
  @Qualifier(value = "perLengthDCLineParameter-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .PerLengthDCLineParameterEntityProjector
      PerLengthDCLineParameterProjector;

  private static final Logger LOGGER =
      Logger.getLogger(ResistancePerLengthEntityProjector.class.getName());
}
