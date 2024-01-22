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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcAVR2 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcAVR2Aggregate
 *
 * @author your_name_here
 */
@Component("excAVR2-entity-projector")
public class ExcAVR2EntityProjector {

  // core constructor
  public ExcAVR2EntityProjector(ExcAVR2Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcAVR2
   *
   * @param	entity ExcAVR2
   */
  public ExcAVR2 create(ExcAVR2 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcAVR2
   *
   * @param	entity ExcAVR2
   */
  public ExcAVR2 update(ExcAVR2 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcAVR2
   *
   * @param	id		UUID
   */
  public ExcAVR2 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcAVR2 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a E1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR2
   */
  public ExcAVR2 assignE1(UUID parentId, PU assignment) {
    LOGGER.info("assigning E1 as " + assignment.toString());

    ExcAVR2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the E1 to the parent entity
    // ------------------------------------------
    parentEntity.setE1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the E1
   *
   * @param	parentId		UUID
   * @return	ExcAVR2
   */
  public ExcAVR2 unAssignE1(UUID parentId) {
    ExcAVR2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning E1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the E1 on the parent entithy
    // ------------------------------------------
    parentEntity.setE1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a E2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR2
   */
  public ExcAVR2 assignE2(UUID parentId, PU assignment) {
    LOGGER.info("assigning E2 as " + assignment.toString());

    ExcAVR2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the E2 to the parent entity
    // ------------------------------------------
    parentEntity.setE2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the E2
   *
   * @param	parentId		UUID
   * @return	ExcAVR2
   */
  public ExcAVR2 unAssignE2(UUID parentId) {
    ExcAVR2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning E2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the E2 on the parent entithy
    // ------------------------------------------
    parentEntity.setE2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ka
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcAVR2
   */
  public ExcAVR2 assignKa(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    ExcAVR2 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Ka to the parent entity
    // ------------------------------------------
    parentEntity.setKa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ka
   *
   * @param	parentId		UUID
   * @return	ExcAVR2
   */
  public ExcAVR2 unAssignKa(UUID parentId) {
    ExcAVR2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ka on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ka on the parent entithy
    // ------------------------------------------
    parentEntity.setKa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kf
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcAVR2
   */
  public ExcAVR2 assignKf(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kf as " + assignment.toString());

    ExcAVR2 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kf to the parent entity
    // ------------------------------------------
    parentEntity.setKf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kf
   *
   * @param	parentId		UUID
   * @return	ExcAVR2
   */
  public ExcAVR2 unAssignKf(UUID parentId) {
    ExcAVR2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kf on the parent entithy
    // ------------------------------------------
    parentEntity.setKf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Se1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcAVR2
   */
  public ExcAVR2 assignSe1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Se1 as " + assignment.toString());

    ExcAVR2 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Se1 to the parent entity
    // ------------------------------------------
    parentEntity.setSe1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Se1
   *
   * @param	parentId		UUID
   * @return	ExcAVR2
   */
  public ExcAVR2 unAssignSe1(UUID parentId) {
    ExcAVR2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Se1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Se1 on the parent entithy
    // ------------------------------------------
    parentEntity.setSe1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Se2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcAVR2
   */
  public ExcAVR2 assignSe2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Se2 as " + assignment.toString());

    ExcAVR2 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Se2 to the parent entity
    // ------------------------------------------
    parentEntity.setSe2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Se2
   *
   * @param	parentId		UUID
   * @return	ExcAVR2
   */
  public ExcAVR2 unAssignSe2(UUID parentId) {
    ExcAVR2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Se2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Se2 on the parent entithy
    // ------------------------------------------
    parentEntity.setSe2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ta
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR2
   */
  public ExcAVR2 assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    ExcAVR2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ta to the parent entity
    // ------------------------------------------
    parentEntity.setTa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ta
   *
   * @param	parentId		UUID
   * @return	ExcAVR2
   */
  public ExcAVR2 unAssignTa(UUID parentId) {
    ExcAVR2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ta on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ta on the parent entithy
    // ------------------------------------------
    parentEntity.setTa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tb
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR2
   */
  public ExcAVR2 assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    ExcAVR2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tb to the parent entity
    // ------------------------------------------
    parentEntity.setTb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tb
   *
   * @param	parentId		UUID
   * @return	ExcAVR2
   */
  public ExcAVR2 unAssignTb(UUID parentId) {
    ExcAVR2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tb on the parent entithy
    // ------------------------------------------
    parentEntity.setTb(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Te
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR2
   */
  public ExcAVR2 assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcAVR2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Te to the parent entity
    // ------------------------------------------
    parentEntity.setTe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Te
   *
   * @param	parentId		UUID
   * @return	ExcAVR2
   */
  public ExcAVR2 unAssignTe(UUID parentId) {
    ExcAVR2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Te on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Te on the parent entithy
    // ------------------------------------------
    parentEntity.setTe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tf1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR2
   */
  public ExcAVR2 assignTf1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf1 as " + assignment.toString());

    ExcAVR2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tf1 to the parent entity
    // ------------------------------------------
    parentEntity.setTf1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tf1
   *
   * @param	parentId		UUID
   * @return	ExcAVR2
   */
  public ExcAVR2 unAssignTf1(UUID parentId) {
    ExcAVR2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tf1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tf1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTf1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tf2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR2
   */
  public ExcAVR2 assignTf2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf2 as " + assignment.toString());

    ExcAVR2 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tf2 to the parent entity
    // ------------------------------------------
    parentEntity.setTf2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tf2
   *
   * @param	parentId		UUID
   * @return	ExcAVR2
   */
  public ExcAVR2 unAssignTf2(UUID parentId) {
    ExcAVR2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tf2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tf2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTf2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vrmn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR2
   */
  public ExcAVR2 assignVrmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmn as " + assignment.toString());

    ExcAVR2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vrmn to the parent entity
    // ------------------------------------------
    parentEntity.setVrmn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vrmn
   *
   * @param	parentId		UUID
   * @return	ExcAVR2
   */
  public ExcAVR2 unAssignVrmn(UUID parentId) {
    ExcAVR2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vrmn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vrmn on the parent entithy
    // ------------------------------------------
    parentEntity.setVrmn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vrmx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR2
   */
  public ExcAVR2 assignVrmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmx as " + assignment.toString());

    ExcAVR2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vrmx to the parent entity
    // ------------------------------------------
    parentEntity.setVrmx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vrmx
   *
   * @param	parentId		UUID
   * @return	ExcAVR2
   */
  public ExcAVR2 unAssignVrmx(UUID parentId) {
    ExcAVR2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vrmx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vrmx on the parent entithy
    // ------------------------------------------
    parentEntity.setVrmx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExcAVR2 via an FindExcAVR2Query
   *
   * @return query FindExcAVR2Query
   */
  @SuppressWarnings("unused")
  public ExcAVR2 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcAVR2 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcAVR2s
   *
   * @param query FindAllExcAVR2Query
   * @return List<ExcAVR2>
   */
  @SuppressWarnings("unused")
  public List<ExcAVR2> findAll(FindAllExcAVR2Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcAVR2 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcAVR2Repository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcAVR2EntityProjector.class.getName());
}
