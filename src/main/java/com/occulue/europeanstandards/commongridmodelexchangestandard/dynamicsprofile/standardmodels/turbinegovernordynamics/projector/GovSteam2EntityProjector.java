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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for GovSteam2 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovSteam2Aggregate
 *
 * @author your_name_here
 */
@Component("govSteam2-entity-projector")
public class GovSteam2EntityProjector {

  // core constructor
  public GovSteam2EntityProjector(GovSteam2Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovSteam2
   *
   * @param	entity GovSteam2
   */
  public GovSteam2 create(GovSteam2 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovSteam2
   *
   * @param	entity GovSteam2
   */
  public GovSteam2 update(GovSteam2 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovSteam2
   *
   * @param	id		UUID
   */
  public GovSteam2 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovSteam2 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Dbf
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteam2
   */
  public GovSteam2 assignDbf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dbf as " + assignment.toString());

    GovSteam2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dbf to the parent entity
    // ------------------------------------------
    parentEntity.setDbf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dbf
   *
   * @param	parentId		UUID
   * @return	GovSteam2
   */
  public GovSteam2 unAssignDbf(UUID parentId) {
    GovSteam2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dbf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dbf on the parent entithy
    // ------------------------------------------
    parentEntity.setDbf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a K
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteam2
   */
  public GovSteam2 assignK(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning K as " + assignment.toString());

    GovSteam2 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the K to the parent entity
    // ------------------------------------------
    parentEntity.setK(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the K
   *
   * @param	parentId		UUID
   * @return	GovSteam2
   */
  public GovSteam2 unAssignK(UUID parentId) {
    GovSteam2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning K on " + parentEntity.toString());

    // ------------------------------------------
    // null out the K on the parent entithy
    // ------------------------------------------
    parentEntity.setK(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mnef
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteam2
   */
  public GovSteam2 assignMnef(UUID parentId, PU assignment) {
    LOGGER.info("assigning Mnef as " + assignment.toString());

    GovSteam2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Mnef to the parent entity
    // ------------------------------------------
    parentEntity.setMnef(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mnef
   *
   * @param	parentId		UUID
   * @return	GovSteam2
   */
  public GovSteam2 unAssignMnef(UUID parentId) {
    GovSteam2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mnef on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mnef on the parent entithy
    // ------------------------------------------
    parentEntity.setMnef(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mxef
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteam2
   */
  public GovSteam2 assignMxef(UUID parentId, PU assignment) {
    LOGGER.info("assigning Mxef as " + assignment.toString());

    GovSteam2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Mxef to the parent entity
    // ------------------------------------------
    parentEntity.setMxef(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mxef
   *
   * @param	parentId		UUID
   * @return	GovSteam2
   */
  public GovSteam2 unAssignMxef(UUID parentId) {
    GovSteam2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mxef on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mxef on the parent entithy
    // ------------------------------------------
    parentEntity.setMxef(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteam2
   */
  public GovSteam2 assignPmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmax as " + assignment.toString());

    GovSteam2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmax to the parent entity
    // ------------------------------------------
    parentEntity.setPmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmax
   *
   * @param	parentId		UUID
   * @return	GovSteam2
   */
  public GovSteam2 unAssignPmax(UUID parentId) {
    GovSteam2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmax on the parent entithy
    // ------------------------------------------
    parentEntity.setPmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteam2
   */
  public GovSteam2 assignPmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmin as " + assignment.toString());

    GovSteam2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmin to the parent entity
    // ------------------------------------------
    parentEntity.setPmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmin
   *
   * @param	parentId		UUID
   * @return	GovSteam2
   */
  public GovSteam2 unAssignPmin(UUID parentId) {
    GovSteam2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmin on the parent entithy
    // ------------------------------------------
    parentEntity.setPmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteam2
   */
  public GovSteam2 assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    GovSteam2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T1 to the parent entity
    // ------------------------------------------
    parentEntity.setT1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T1
   *
   * @param	parentId		UUID
   * @return	GovSteam2
   */
  public GovSteam2 unAssignT1(UUID parentId) {
    GovSteam2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T1 on the parent entithy
    // ------------------------------------------
    parentEntity.setT1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteam2
   */
  public GovSteam2 assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    GovSteam2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T2 to the parent entity
    // ------------------------------------------
    parentEntity.setT2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T2
   *
   * @param	parentId		UUID
   * @return	GovSteam2
   */
  public GovSteam2 unAssignT2(UUID parentId) {
    GovSteam2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T2 on the parent entithy
    // ------------------------------------------
    parentEntity.setT2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovSteam2 via an FindGovSteam2Query
   *
   * @return query FindGovSteam2Query
   */
  @SuppressWarnings("unused")
  public GovSteam2 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovSteam2 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovSteam2s
   *
   * @param query FindAllGovSteam2Query
   * @return List<GovSteam2>
   */
  @SuppressWarnings("unused")
  public List<GovSteam2> findAll(FindAllGovSteam2Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovSteam2 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovSteam2Repository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(GovSteam2EntityProjector.class.getName());
}
