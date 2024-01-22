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
 * Projector for InductancePerLength as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by InductancePerLengthAggregate
 *
 * @author your_name_here
 */
@Component("inductancePerLength-entity-projector")
public class InductancePerLengthEntityProjector {

  // core constructor
  public InductancePerLengthEntityProjector(InductancePerLengthRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a InductancePerLength
   *
   * @param	entity InductancePerLength
   */
  public InductancePerLength create(InductancePerLength entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a InductancePerLength
   *
   * @param	entity InductancePerLength
   */
  public InductancePerLength update(InductancePerLength entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a InductancePerLength
   *
   * @param	id		UUID
   */
  public InductancePerLength delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    InductancePerLength entity = repository.findById(id).get();

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
   * @return	InductancePerLength
   */
  public InductancePerLength assignValue(UUID parentId, FloatProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    InductancePerLength parentEntity = repository.findById(parentId).get();
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
   * @return	InductancePerLength
   */
  public InductancePerLength unAssignValue(UUID parentId) {
    InductancePerLength parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the InductancePerLength via an FindInductancePerLengthQuery
   *
   * @return query FindInductancePerLengthQuery
   */
  @SuppressWarnings("unused")
  public InductancePerLength find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a InductancePerLength - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all InductancePerLengths
   *
   * @param query FindAllInductancePerLengthQuery
   * @return List<InductancePerLength>
   */
  @SuppressWarnings("unused")
  public List<InductancePerLength> findAll(FindAllInductancePerLengthQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all InductancePerLength - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final InductancePerLengthRepository repository;

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
      Logger.getLogger(InductancePerLengthEntityProjector.class.getName());
}
