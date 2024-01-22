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
 * Projector for ApparentPower as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ApparentPowerAggregate
 *
 * @author your_name_here
 */
@Component("apparentPower-entity-projector")
public class ApparentPowerEntityProjector {

  // core constructor
  public ApparentPowerEntityProjector(ApparentPowerRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ApparentPower
   *
   * @param	entity ApparentPower
   */
  public ApparentPower create(ApparentPower entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ApparentPower
   *
   * @param	entity ApparentPower
   */
  public ApparentPower update(ApparentPower entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ApparentPower
   *
   * @param	id		UUID
   */
  public ApparentPower delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ApparentPower entity = repository.findById(id).get();

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
   * @return	ApparentPower
   */
  public ApparentPower assignValue(UUID parentId, FloatProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    ApparentPower parentEntity = repository.findById(parentId).get();
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
   * @return	ApparentPower
   */
  public ApparentPower unAssignValue(UUID parentId) {
    ApparentPower parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the ApparentPower via an FindApparentPowerQuery
   *
   * @return query FindApparentPowerQuery
   */
  @SuppressWarnings("unused")
  public ApparentPower find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ApparentPower - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ApparentPowers
   *
   * @param query FindAllApparentPowerQuery
   * @return List<ApparentPower>
   */
  @SuppressWarnings("unused")
  public List<ApparentPower> findAll(FindAllApparentPowerQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ApparentPower - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ApparentPowerRepository repository;

  @Autowired
  @Qualifier(value = "floatProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .FloatProxyEntityProjector
      FloatProxyProjector;

  @Autowired
  @Qualifier(value = "aCDCConverter-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .ACDCConverterEntityProjector
      ACDCConverterProjector;

  @Autowired
  @Qualifier(value = "powerTransformerEnd-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .PowerTransformerEndEntityProjector
      PowerTransformerEndProjector;

  @Autowired
  @Qualifier(value = "excSK-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcSKEntityProjector
      ExcSKProjector;

  private static final Logger LOGGER =
      Logger.getLogger(ApparentPowerEntityProjector.class.getName());
}
