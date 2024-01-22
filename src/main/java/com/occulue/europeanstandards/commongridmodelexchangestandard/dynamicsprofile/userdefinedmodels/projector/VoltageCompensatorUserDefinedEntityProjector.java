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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for VoltageCompensatorUserDefined as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by VoltageCompensatorUserDefinedAggregate
 *
 * @author your_name_here
 */
@Component("voltageCompensatorUserDefined-entity-projector")
public class VoltageCompensatorUserDefinedEntityProjector {

  // core constructor
  public VoltageCompensatorUserDefinedEntityProjector(
      VoltageCompensatorUserDefinedRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a VoltageCompensatorUserDefined
   *
   * @param	entity VoltageCompensatorUserDefined
   */
  public VoltageCompensatorUserDefined create(VoltageCompensatorUserDefined entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a VoltageCompensatorUserDefined
   *
   * @param	entity VoltageCompensatorUserDefined
   */
  public VoltageCompensatorUserDefined update(VoltageCompensatorUserDefined entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a VoltageCompensatorUserDefined
   *
   * @param	id		UUID
   */
  public VoltageCompensatorUserDefined delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    VoltageCompensatorUserDefined entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Proprietary
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	VoltageCompensatorUserDefined
   */
  public VoltageCompensatorUserDefined assignProprietary(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Proprietary as " + assignment.toString());

    VoltageCompensatorUserDefined parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Proprietary to the parent entity
    // ------------------------------------------
    parentEntity.setProprietary(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Proprietary
   *
   * @param	parentId		UUID
   * @return	VoltageCompensatorUserDefined
   */
  public VoltageCompensatorUserDefined unAssignProprietary(UUID parentId) {
    VoltageCompensatorUserDefined parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Proprietary on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Proprietary on the parent entithy
    // ------------------------------------------
    parentEntity.setProprietary(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the VoltageCompensatorUserDefined via an
   * FindVoltageCompensatorUserDefinedQuery
   *
   * @return query FindVoltageCompensatorUserDefinedQuery
   */
  @SuppressWarnings("unused")
  public VoltageCompensatorUserDefined find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a VoltageCompensatorUserDefined - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all VoltageCompensatorUserDefineds
   *
   * @param query FindAllVoltageCompensatorUserDefinedQuery
   * @return List<VoltageCompensatorUserDefined>
   */
  @SuppressWarnings("unused")
  public List<VoltageCompensatorUserDefined> findAll(
      FindAllVoltageCompensatorUserDefinedQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find all VoltageCompensatorUserDefined - {0}",
          exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final VoltageCompensatorUserDefinedRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(VoltageCompensatorUserDefinedEntityProjector.class.getName());
}
