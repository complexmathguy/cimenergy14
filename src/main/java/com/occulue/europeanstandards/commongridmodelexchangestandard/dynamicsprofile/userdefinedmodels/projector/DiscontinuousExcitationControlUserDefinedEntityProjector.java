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
 * Projector for DiscontinuousExcitationControlUserDefined as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DiscontinuousExcitationControlUserDefinedAggregate
 *
 * @author your_name_here
 */
@Component("discontinuousExcitationControlUserDefined-entity-projector")
public class DiscontinuousExcitationControlUserDefinedEntityProjector {

  // core constructor
  public DiscontinuousExcitationControlUserDefinedEntityProjector(
      DiscontinuousExcitationControlUserDefinedRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DiscontinuousExcitationControlUserDefined
   *
   * @param	entity DiscontinuousExcitationControlUserDefined
   */
  public DiscontinuousExcitationControlUserDefined create(
      DiscontinuousExcitationControlUserDefined entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DiscontinuousExcitationControlUserDefined
   *
   * @param	entity DiscontinuousExcitationControlUserDefined
   */
  public DiscontinuousExcitationControlUserDefined update(
      DiscontinuousExcitationControlUserDefined entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DiscontinuousExcitationControlUserDefined
   *
   * @param	id		UUID
   */
  public DiscontinuousExcitationControlUserDefined delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DiscontinuousExcitationControlUserDefined entity = repository.findById(id).get();

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
   * @return	DiscontinuousExcitationControlUserDefined
   */
  public DiscontinuousExcitationControlUserDefined assignProprietary(
      UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Proprietary as " + assignment.toString());

    DiscontinuousExcitationControlUserDefined parentEntity = repository.findById(parentId).get();
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
   * @return	DiscontinuousExcitationControlUserDefined
   */
  public DiscontinuousExcitationControlUserDefined unAssignProprietary(UUID parentId) {
    DiscontinuousExcitationControlUserDefined parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the DiscontinuousExcitationControlUserDefined via an
   * FindDiscontinuousExcitationControlUserDefinedQuery
   *
   * @return query FindDiscontinuousExcitationControlUserDefinedQuery
   */
  @SuppressWarnings("unused")
  public DiscontinuousExcitationControlUserDefined find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find a DiscontinuousExcitationControlUserDefined - {0}",
          exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DiscontinuousExcitationControlUserDefineds
   *
   * @param query FindAllDiscontinuousExcitationControlUserDefinedQuery
   * @return List<DiscontinuousExcitationControlUserDefined>
   */
  @SuppressWarnings("unused")
  public List<DiscontinuousExcitationControlUserDefined> findAll(
      FindAllDiscontinuousExcitationControlUserDefinedQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING,
          "Failed to find all DiscontinuousExcitationControlUserDefined - {0}",
          exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DiscontinuousExcitationControlUserDefinedRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(DiscontinuousExcitationControlUserDefinedEntityProjector.class.getName());
}
