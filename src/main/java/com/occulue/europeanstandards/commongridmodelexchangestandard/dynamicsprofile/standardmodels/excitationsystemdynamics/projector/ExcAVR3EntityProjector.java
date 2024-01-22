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
 * Projector for ExcAVR3 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcAVR3Aggregate
 *
 * @author your_name_here
 */
@Component("excAVR3-entity-projector")
public class ExcAVR3EntityProjector {

  // core constructor
  public ExcAVR3EntityProjector(ExcAVR3Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcAVR3
   *
   * @param	entity ExcAVR3
   */
  public ExcAVR3 create(ExcAVR3 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcAVR3
   *
   * @param	entity ExcAVR3
   */
  public ExcAVR3 update(ExcAVR3 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcAVR3
   *
   * @param	id		UUID
   */
  public ExcAVR3 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcAVR3 entity = repository.findById(id).get();

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
   * @return	ExcAVR3
   */
  public ExcAVR3 assignE1(UUID parentId, PU assignment) {
    LOGGER.info("assigning E1 as " + assignment.toString());

    ExcAVR3 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR3
   */
  public ExcAVR3 unAssignE1(UUID parentId) {
    ExcAVR3 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR3
   */
  public ExcAVR3 assignE2(UUID parentId, PU assignment) {
    LOGGER.info("assigning E2 as " + assignment.toString());

    ExcAVR3 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR3
   */
  public ExcAVR3 unAssignE2(UUID parentId) {
    ExcAVR3 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR3
   */
  public ExcAVR3 assignKa(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    ExcAVR3 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR3
   */
  public ExcAVR3 unAssignKa(UUID parentId) {
    ExcAVR3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Se1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcAVR3
   */
  public ExcAVR3 assignSe1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Se1 as " + assignment.toString());

    ExcAVR3 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR3
   */
  public ExcAVR3 unAssignSe1(UUID parentId) {
    ExcAVR3 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR3
   */
  public ExcAVR3 assignSe2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Se2 as " + assignment.toString());

    ExcAVR3 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR3
   */
  public ExcAVR3 unAssignSe2(UUID parentId) {
    ExcAVR3 parentEntity = repository.findById(parentId).get();

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
   * Assign a T1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR3
   */
  public ExcAVR3 assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    ExcAVR3 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR3
   */
  public ExcAVR3 unAssignT1(UUID parentId) {
    ExcAVR3 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR3
   */
  public ExcAVR3 assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    ExcAVR3 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR3
   */
  public ExcAVR3 unAssignT2(UUID parentId) {
    ExcAVR3 parentEntity = repository.findById(parentId).get();

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

  /*
   * Assign a T3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR3
   */
  public ExcAVR3 assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    ExcAVR3 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T3 to the parent entity
    // ------------------------------------------
    parentEntity.setT3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T3
   *
   * @param	parentId		UUID
   * @return	ExcAVR3
   */
  public ExcAVR3 unAssignT3(UUID parentId) {
    ExcAVR3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T3 on the parent entithy
    // ------------------------------------------
    parentEntity.setT3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T4
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR3
   */
  public ExcAVR3 assignT4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4 as " + assignment.toString());

    ExcAVR3 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T4 to the parent entity
    // ------------------------------------------
    parentEntity.setT4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T4
   *
   * @param	parentId		UUID
   * @return	ExcAVR3
   */
  public ExcAVR3 unAssignT4(UUID parentId) {
    ExcAVR3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T4 on the parent entithy
    // ------------------------------------------
    parentEntity.setT4(null);

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
   * @return	ExcAVR3
   */
  public ExcAVR3 assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcAVR3 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR3
   */
  public ExcAVR3 unAssignTe(UUID parentId) {
    ExcAVR3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Vrmn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR3
   */
  public ExcAVR3 assignVrmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmn as " + assignment.toString());

    ExcAVR3 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR3
   */
  public ExcAVR3 unAssignVrmn(UUID parentId) {
    ExcAVR3 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR3
   */
  public ExcAVR3 assignVrmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmx as " + assignment.toString());

    ExcAVR3 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR3
   */
  public ExcAVR3 unAssignVrmx(UUID parentId) {
    ExcAVR3 parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the ExcAVR3 via an FindExcAVR3Query
   *
   * @return query FindExcAVR3Query
   */
  @SuppressWarnings("unused")
  public ExcAVR3 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcAVR3 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcAVR3s
   *
   * @param query FindAllExcAVR3Query
   * @return List<ExcAVR3>
   */
  @SuppressWarnings("unused")
  public List<ExcAVR3> findAll(FindAllExcAVR3Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcAVR3 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcAVR3Repository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcAVR3EntityProjector.class.getName());
}
