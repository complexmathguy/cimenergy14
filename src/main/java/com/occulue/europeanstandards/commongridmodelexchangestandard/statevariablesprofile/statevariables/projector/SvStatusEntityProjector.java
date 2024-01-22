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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for SvStatus as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SvStatusAggregate
 *
 * @author your_name_here
 */
@Component("svStatus-entity-projector")
public class SvStatusEntityProjector {

  // core constructor
  public SvStatusEntityProjector(SvStatusRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a SvStatus
   *
   * @param	entity SvStatus
   */
  public SvStatus create(SvStatus entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a SvStatus
   *
   * @param	entity SvStatus
   */
  public SvStatus update(SvStatus entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a SvStatus
   *
   * @param	id		UUID
   */
  public SvStatus delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    SvStatus entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a InService
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	SvStatus
   */
  public SvStatus assignInService(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning InService as " + assignment.toString());

    SvStatus parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the InService to the parent entity
    // ------------------------------------------
    parentEntity.setInService(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the InService
   *
   * @param	parentId		UUID
   * @return	SvStatus
   */
  public SvStatus unAssignInService(UUID parentId) {
    SvStatus parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning InService on " + parentEntity.toString());

    // ------------------------------------------
    // null out the InService on the parent entithy
    // ------------------------------------------
    parentEntity.setInService(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SvStatus
   *
   * @param	parentId	UUID
   * @param	assignment 	SvStatus
   * @return	SvStatus
   */
  public SvStatus assignSvStatus(UUID parentId, SvStatus assignment) {
    LOGGER.info("assigning SvStatus as " + assignment.toString());

    SvStatus parentEntity = repository.findById(parentId).get();
    assignment = SvStatusProjector.find(assignment.getSvStatusId());

    // ------------------------------------------
    // assign the SvStatus to the parent entity
    // ------------------------------------------
    parentEntity.setSvStatus(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SvStatus
   *
   * @param	parentId		UUID
   * @return	SvStatus
   */
  public SvStatus unAssignSvStatus(UUID parentId) {
    SvStatus parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SvStatus on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SvStatus on the parent entithy
    // ------------------------------------------
    parentEntity.setSvStatus(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the SvStatus via an FindSvStatusQuery
   *
   * @return query FindSvStatusQuery
   */
  @SuppressWarnings("unused")
  public SvStatus find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a SvStatus - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all SvStatuss
   *
   * @param query FindAllSvStatusQuery
   * @return List<SvStatus>
   */
  @SuppressWarnings("unused")
  public List<SvStatus> findAll(FindAllSvStatusQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all SvStatus - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SvStatusRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "svStatus-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables
          .projector.SvStatusEntityProjector
      SvStatusProjector;

  private static final Logger LOGGER = Logger.getLogger(SvStatusEntityProjector.class.getName());
}
