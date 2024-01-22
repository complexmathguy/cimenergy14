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
 * Projector for ExcAVR1 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcAVR1Aggregate
 *
 * @author your_name_here
 */
@Component("excAVR1-entity-projector")
public class ExcAVR1EntityProjector {

  // core constructor
  public ExcAVR1EntityProjector(ExcAVR1Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcAVR1
   *
   * @param	entity ExcAVR1
   */
  public ExcAVR1 create(ExcAVR1 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcAVR1
   *
   * @param	entity ExcAVR1
   */
  public ExcAVR1 update(ExcAVR1 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcAVR1
   *
   * @param	id		UUID
   */
  public ExcAVR1 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcAVR1 entity = repository.findById(id).get();

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
   * @return	ExcAVR1
   */
  public ExcAVR1 assignE1(UUID parentId, PU assignment) {
    LOGGER.info("assigning E1 as " + assignment.toString());

    ExcAVR1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR1
   */
  public ExcAVR1 unAssignE1(UUID parentId) {
    ExcAVR1 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR1
   */
  public ExcAVR1 assignE2(UUID parentId, PU assignment) {
    LOGGER.info("assigning E2 as " + assignment.toString());

    ExcAVR1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR1
   */
  public ExcAVR1 unAssignE2(UUID parentId) {
    ExcAVR1 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR1
   */
  public ExcAVR1 assignKa(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    ExcAVR1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR1
   */
  public ExcAVR1 unAssignKa(UUID parentId) {
    ExcAVR1 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR1
   */
  public ExcAVR1 assignKf(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kf as " + assignment.toString());

    ExcAVR1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR1
   */
  public ExcAVR1 unAssignKf(UUID parentId) {
    ExcAVR1 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR1
   */
  public ExcAVR1 assignSe1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Se1 as " + assignment.toString());

    ExcAVR1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR1
   */
  public ExcAVR1 unAssignSe1(UUID parentId) {
    ExcAVR1 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR1
   */
  public ExcAVR1 assignSe2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Se2 as " + assignment.toString());

    ExcAVR1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR1
   */
  public ExcAVR1 unAssignSe2(UUID parentId) {
    ExcAVR1 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR1
   */
  public ExcAVR1 assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    ExcAVR1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR1
   */
  public ExcAVR1 unAssignTa(UUID parentId) {
    ExcAVR1 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR1
   */
  public ExcAVR1 assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    ExcAVR1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR1
   */
  public ExcAVR1 unAssignTb(UUID parentId) {
    ExcAVR1 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR1
   */
  public ExcAVR1 assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcAVR1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR1
   */
  public ExcAVR1 unAssignTe(UUID parentId) {
    ExcAVR1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tf
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR1
   */
  public ExcAVR1 assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    ExcAVR1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tf to the parent entity
    // ------------------------------------------
    parentEntity.setTf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tf
   *
   * @param	parentId		UUID
   * @return	ExcAVR1
   */
  public ExcAVR1 unAssignTf(UUID parentId) {
    ExcAVR1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tf on the parent entithy
    // ------------------------------------------
    parentEntity.setTf(null);

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
   * @return	ExcAVR1
   */
  public ExcAVR1 assignVrmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmn as " + assignment.toString());

    ExcAVR1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR1
   */
  public ExcAVR1 unAssignVrmn(UUID parentId) {
    ExcAVR1 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR1
   */
  public ExcAVR1 assignVrmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmx as " + assignment.toString());

    ExcAVR1 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR1
   */
  public ExcAVR1 unAssignVrmx(UUID parentId) {
    ExcAVR1 parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the ExcAVR1 via an FindExcAVR1Query
   *
   * @return query FindExcAVR1Query
   */
  @SuppressWarnings("unused")
  public ExcAVR1 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcAVR1 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcAVR1s
   *
   * @param query FindAllExcAVR1Query
   * @return List<ExcAVR1>
   */
  @SuppressWarnings("unused")
  public List<ExcAVR1> findAll(FindAllExcAVR1Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcAVR1 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcAVR1Repository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcAVR1EntityProjector.class.getName());
}
