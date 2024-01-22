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
 * Projector for OverexcitationLimiterUserDefined as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by OverexcitationLimiterUserDefinedAggregate
 *
 * @author your_name_here
 */
@Component("overexcitationLimiterUserDefined-entity-projector")
public class OverexcitationLimiterUserDefinedEntityProjector {

  // core constructor
  public OverexcitationLimiterUserDefinedEntityProjector(
      OverexcitationLimiterUserDefinedRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a OverexcitationLimiterUserDefined
   *
   * @param	entity OverexcitationLimiterUserDefined
   */
  public OverexcitationLimiterUserDefined create(OverexcitationLimiterUserDefined entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a OverexcitationLimiterUserDefined
   *
   * @param	entity OverexcitationLimiterUserDefined
   */
  public OverexcitationLimiterUserDefined update(OverexcitationLimiterUserDefined entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a OverexcitationLimiterUserDefined
   *
   * @param	id		UUID
   */
  public OverexcitationLimiterUserDefined delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    OverexcitationLimiterUserDefined entity = repository.findById(id).get();

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
   * @return	OverexcitationLimiterUserDefined
   */
  public OverexcitationLimiterUserDefined assignProprietary(
      UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Proprietary as " + assignment.toString());

    OverexcitationLimiterUserDefined parentEntity = repository.findById(parentId).get();
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
   * @return	OverexcitationLimiterUserDefined
   */
  public OverexcitationLimiterUserDefined unAssignProprietary(UUID parentId) {
    OverexcitationLimiterUserDefined parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the OverexcitationLimiterUserDefined via an
   * FindOverexcitationLimiterUserDefinedQuery
   *
   * @return query FindOverexcitationLimiterUserDefinedQuery
   */
  @SuppressWarnings("unused")
  public OverexcitationLimiterUserDefined find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find a OverexcitationLimiterUserDefined - {0}",
          exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all OverexcitationLimiterUserDefineds
   *
   * @param query FindAllOverexcitationLimiterUserDefinedQuery
   * @return List<OverexcitationLimiterUserDefined>
   */
  @SuppressWarnings("unused")
  public List<OverexcitationLimiterUserDefined> findAll(
      FindAllOverexcitationLimiterUserDefinedQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find all OverexcitationLimiterUserDefined - {0}",
          exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final OverexcitationLimiterUserDefinedRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(OverexcitationLimiterUserDefinedEntityProjector.class.getName());
}
