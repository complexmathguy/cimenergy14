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
 * Projector for ExcAVR4 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcAVR4Aggregate
 *
 * @author your_name_here
 */
@Component("excAVR4-entity-projector")
public class ExcAVR4EntityProjector {

  // core constructor
  public ExcAVR4EntityProjector(ExcAVR4Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcAVR4
   *
   * @param	entity ExcAVR4
   */
  public ExcAVR4 create(ExcAVR4 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcAVR4
   *
   * @param	entity ExcAVR4
   */
  public ExcAVR4 update(ExcAVR4 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcAVR4
   *
   * @param	id		UUID
   */
  public ExcAVR4 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcAVR4 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Imul
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcAVR4
   */
  public ExcAVR4 assignImul(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Imul as " + assignment.toString());

    ExcAVR4 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Imul to the parent entity
    // ------------------------------------------
    parentEntity.setImul(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Imul
   *
   * @param	parentId		UUID
   * @return	ExcAVR4
   */
  public ExcAVR4 unAssignImul(UUID parentId) {
    ExcAVR4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Imul on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Imul on the parent entithy
    // ------------------------------------------
    parentEntity.setImul(null);

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
   * @return	ExcAVR4
   */
  public ExcAVR4 assignKa(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    ExcAVR4 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR4
   */
  public ExcAVR4 unAssignKa(UUID parentId) {
    ExcAVR4 parentEntity = repository.findById(parentId).get();

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
   * Assign a Ke
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcAVR4
   */
  public ExcAVR4 assignKe(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ke as " + assignment.toString());

    ExcAVR4 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Ke to the parent entity
    // ------------------------------------------
    parentEntity.setKe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ke
   *
   * @param	parentId		UUID
   * @return	ExcAVR4
   */
  public ExcAVR4 unAssignKe(UUID parentId) {
    ExcAVR4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ke on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ke on the parent entithy
    // ------------------------------------------
    parentEntity.setKe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kif
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcAVR4
   */
  public ExcAVR4 assignKif(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kif as " + assignment.toString());

    ExcAVR4 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kif to the parent entity
    // ------------------------------------------
    parentEntity.setKif(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kif
   *
   * @param	parentId		UUID
   * @return	ExcAVR4
   */
  public ExcAVR4 unAssignKif(UUID parentId) {
    ExcAVR4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kif on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kif on the parent entithy
    // ------------------------------------------
    parentEntity.setKif(null);

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
   * @return	ExcAVR4
   */
  public ExcAVR4 assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    ExcAVR4 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR4
   */
  public ExcAVR4 unAssignT1(UUID parentId) {
    ExcAVR4 parentEntity = repository.findById(parentId).get();

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
   * Assign a T1if
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR4
   */
  public ExcAVR4 assignT1if(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1if as " + assignment.toString());

    ExcAVR4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T1if to the parent entity
    // ------------------------------------------
    parentEntity.setT1if(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T1if
   *
   * @param	parentId		UUID
   * @return	ExcAVR4
   */
  public ExcAVR4 unAssignT1if(UUID parentId) {
    ExcAVR4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T1if on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T1if on the parent entithy
    // ------------------------------------------
    parentEntity.setT1if(null);

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
   * @return	ExcAVR4
   */
  public ExcAVR4 assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    ExcAVR4 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR4
   */
  public ExcAVR4 unAssignT2(UUID parentId) {
    ExcAVR4 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR4
   */
  public ExcAVR4 assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    ExcAVR4 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR4
   */
  public ExcAVR4 unAssignT3(UUID parentId) {
    ExcAVR4 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR4
   */
  public ExcAVR4 assignT4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4 as " + assignment.toString());

    ExcAVR4 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR4
   */
  public ExcAVR4 unAssignT4(UUID parentId) {
    ExcAVR4 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tif
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcAVR4
   */
  public ExcAVR4 assignTif(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tif as " + assignment.toString());

    ExcAVR4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tif to the parent entity
    // ------------------------------------------
    parentEntity.setTif(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tif
   *
   * @param	parentId		UUID
   * @return	ExcAVR4
   */
  public ExcAVR4 unAssignTif(UUID parentId) {
    ExcAVR4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tif on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tif on the parent entithy
    // ------------------------------------------
    parentEntity.setTif(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vfmn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR4
   */
  public ExcAVR4 assignVfmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vfmn as " + assignment.toString());

    ExcAVR4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vfmn to the parent entity
    // ------------------------------------------
    parentEntity.setVfmn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vfmn
   *
   * @param	parentId		UUID
   * @return	ExcAVR4
   */
  public ExcAVR4 unAssignVfmn(UUID parentId) {
    ExcAVR4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vfmn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vfmn on the parent entithy
    // ------------------------------------------
    parentEntity.setVfmn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vfmx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcAVR4
   */
  public ExcAVR4 assignVfmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vfmx as " + assignment.toString());

    ExcAVR4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vfmx to the parent entity
    // ------------------------------------------
    parentEntity.setVfmx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vfmx
   *
   * @param	parentId		UUID
   * @return	ExcAVR4
   */
  public ExcAVR4 unAssignVfmx(UUID parentId) {
    ExcAVR4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vfmx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vfmx on the parent entithy
    // ------------------------------------------
    parentEntity.setVfmx(null);

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
   * @return	ExcAVR4
   */
  public ExcAVR4 assignVrmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmn as " + assignment.toString());

    ExcAVR4 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR4
   */
  public ExcAVR4 unAssignVrmn(UUID parentId) {
    ExcAVR4 parentEntity = repository.findById(parentId).get();

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
   * @return	ExcAVR4
   */
  public ExcAVR4 assignVrmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmx as " + assignment.toString());

    ExcAVR4 parentEntity = repository.findById(parentId).get();
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
   * @return	ExcAVR4
   */
  public ExcAVR4 unAssignVrmx(UUID parentId) {
    ExcAVR4 parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the ExcAVR4 via an FindExcAVR4Query
   *
   * @return query FindExcAVR4Query
   */
  @SuppressWarnings("unused")
  public ExcAVR4 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcAVR4 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcAVR4s
   *
   * @param query FindAllExcAVR4Query
   * @return List<ExcAVR4>
   */
  @SuppressWarnings("unused")
  public List<ExcAVR4> findAll(FindAllExcAVR4Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcAVR4 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcAVR4Repository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

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

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  private static final Logger LOGGER = Logger.getLogger(ExcAVR4EntityProjector.class.getName());
}
