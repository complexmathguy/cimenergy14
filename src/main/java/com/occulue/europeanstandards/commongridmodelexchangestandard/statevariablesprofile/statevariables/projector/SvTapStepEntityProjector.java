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
 * Projector for SvTapStep as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SvTapStepAggregate
 *
 * @author your_name_here
 */
@Component("svTapStep-entity-projector")
public class SvTapStepEntityProjector {

  // core constructor
  public SvTapStepEntityProjector(SvTapStepRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a SvTapStep
   *
   * @param	entity SvTapStep
   */
  public SvTapStep create(SvTapStep entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a SvTapStep
   *
   * @param	entity SvTapStep
   */
  public SvTapStep update(SvTapStep entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a SvTapStep
   *
   * @param	id		UUID
   */
  public SvTapStep delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    SvTapStep entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Position
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	SvTapStep
   */
  public SvTapStep assignPosition(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Position as " + assignment.toString());

    SvTapStep parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Position to the parent entity
    // ------------------------------------------
    parentEntity.setPosition(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Position
   *
   * @param	parentId		UUID
   * @return	SvTapStep
   */
  public SvTapStep unAssignPosition(UUID parentId) {
    SvTapStep parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Position on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Position on the parent entithy
    // ------------------------------------------
    parentEntity.setPosition(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SvTapStep
   *
   * @param	parentId	UUID
   * @param	assignment 	SvTapStep
   * @return	SvTapStep
   */
  public SvTapStep assignSvTapStep(UUID parentId, SvTapStep assignment) {
    LOGGER.info("assigning SvTapStep as " + assignment.toString());

    SvTapStep parentEntity = repository.findById(parentId).get();
    assignment = SvTapStepProjector.find(assignment.getSvTapStepId());

    // ------------------------------------------
    // assign the SvTapStep to the parent entity
    // ------------------------------------------
    parentEntity.setSvTapStep(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SvTapStep
   *
   * @param	parentId		UUID
   * @return	SvTapStep
   */
  public SvTapStep unAssignSvTapStep(UUID parentId) {
    SvTapStep parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SvTapStep on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SvTapStep on the parent entithy
    // ------------------------------------------
    parentEntity.setSvTapStep(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the SvTapStep via an FindSvTapStepQuery
   *
   * @return query FindSvTapStepQuery
   */
  @SuppressWarnings("unused")
  public SvTapStep find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a SvTapStep - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all SvTapSteps
   *
   * @param query FindAllSvTapStepQuery
   * @return List<SvTapStep>
   */
  @SuppressWarnings("unused")
  public List<SvTapStep> findAll(FindAllSvTapStepQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all SvTapStep - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SvTapStepRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "svTapStep-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables
          .projector.SvTapStepEntityProjector
      SvTapStepProjector;

  private static final Logger LOGGER = Logger.getLogger(SvTapStepEntityProjector.class.getName());
}
