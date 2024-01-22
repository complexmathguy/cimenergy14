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
 * Projector for ExcBBC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcBBCAggregate
 *
 * @author your_name_here
 */
@Component("excBBC-entity-projector")
public class ExcBBCEntityProjector {

  // core constructor
  public ExcBBCEntityProjector(ExcBBCRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcBBC
   *
   * @param	entity ExcBBC
   */
  public ExcBBC create(ExcBBC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcBBC
   *
   * @param	entity ExcBBC
   */
  public ExcBBC update(ExcBBC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcBBC
   *
   * @param	id		UUID
   */
  public ExcBBC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcBBC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Efdmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcBBC
   */
  public ExcBBC assignEfdmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efdmax as " + assignment.toString());

    ExcBBC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efdmax to the parent entity
    // ------------------------------------------
    parentEntity.setEfdmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efdmax
   *
   * @param	parentId		UUID
   * @return	ExcBBC
   */
  public ExcBBC unAssignEfdmax(UUID parentId) {
    ExcBBC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efdmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efdmax on the parent entithy
    // ------------------------------------------
    parentEntity.setEfdmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Efdmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcBBC
   */
  public ExcBBC assignEfdmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efdmin as " + assignment.toString());

    ExcBBC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efdmin to the parent entity
    // ------------------------------------------
    parentEntity.setEfdmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efdmin
   *
   * @param	parentId		UUID
   * @return	ExcBBC
   */
  public ExcBBC unAssignEfdmin(UUID parentId) {
    ExcBBC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efdmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efdmin on the parent entithy
    // ------------------------------------------
    parentEntity.setEfdmin(null);

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
   * @param	assignment 	PU
   * @return	ExcBBC
   */
  public ExcBBC assignK(UUID parentId, PU assignment) {
    LOGGER.info("assigning K as " + assignment.toString());

    ExcBBC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

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
   * @return	ExcBBC
   */
  public ExcBBC unAssignK(UUID parentId) {
    ExcBBC parentEntity = repository.findById(parentId).get();

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
   * Assign a SwitchIt
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcBBC
   */
  public ExcBBC assignSwitchIt(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning SwitchIt as " + assignment.toString());

    ExcBBC parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the SwitchIt to the parent entity
    // ------------------------------------------
    parentEntity.setSwitchIt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SwitchIt
   *
   * @param	parentId		UUID
   * @return	ExcBBC
   */
  public ExcBBC unAssignSwitchIt(UUID parentId) {
    ExcBBC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SwitchIt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SwitchIt on the parent entithy
    // ------------------------------------------
    parentEntity.setSwitchIt(null);

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
   * @return	ExcBBC
   */
  public ExcBBC assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    ExcBBC parentEntity = repository.findById(parentId).get();
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
   * @return	ExcBBC
   */
  public ExcBBC unAssignT1(UUID parentId) {
    ExcBBC parentEntity = repository.findById(parentId).get();

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
   * @return	ExcBBC
   */
  public ExcBBC assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    ExcBBC parentEntity = repository.findById(parentId).get();
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
   * @return	ExcBBC
   */
  public ExcBBC unAssignT2(UUID parentId) {
    ExcBBC parentEntity = repository.findById(parentId).get();

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
   * @return	ExcBBC
   */
  public ExcBBC assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    ExcBBC parentEntity = repository.findById(parentId).get();
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
   * @return	ExcBBC
   */
  public ExcBBC unAssignT3(UUID parentId) {
    ExcBBC parentEntity = repository.findById(parentId).get();

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
   * @return	ExcBBC
   */
  public ExcBBC assignT4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T4 as " + assignment.toString());

    ExcBBC parentEntity = repository.findById(parentId).get();
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
   * @return	ExcBBC
   */
  public ExcBBC unAssignT4(UUID parentId) {
    ExcBBC parentEntity = repository.findById(parentId).get();

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
   * Assign a Vrmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcBBC
   */
  public ExcBBC assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcBBC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vrmax to the parent entity
    // ------------------------------------------
    parentEntity.setVrmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vrmax
   *
   * @param	parentId		UUID
   * @return	ExcBBC
   */
  public ExcBBC unAssignVrmax(UUID parentId) {
    ExcBBC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vrmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vrmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVrmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vrmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcBBC
   */
  public ExcBBC assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcBBC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vrmin to the parent entity
    // ------------------------------------------
    parentEntity.setVrmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vrmin
   *
   * @param	parentId		UUID
   * @return	ExcBBC
   */
  public ExcBBC unAssignVrmin(UUID parentId) {
    ExcBBC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vrmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vrmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVrmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Xe
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcBBC
   */
  public ExcBBC assignXe(UUID parentId, PU assignment) {
    LOGGER.info("assigning Xe as " + assignment.toString());

    ExcBBC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Xe to the parent entity
    // ------------------------------------------
    parentEntity.setXe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Xe
   *
   * @param	parentId		UUID
   * @return	ExcBBC
   */
  public ExcBBC unAssignXe(UUID parentId) {
    ExcBBC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Xe on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Xe on the parent entithy
    // ------------------------------------------
    parentEntity.setXe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExcBBC via an FindExcBBCQuery
   *
   * @return query FindExcBBCQuery
   */
  @SuppressWarnings("unused")
  public ExcBBC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcBBC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcBBCs
   *
   * @param query FindAllExcBBCQuery
   * @return List<ExcBBC>
   */
  @SuppressWarnings("unused")
  public List<ExcBBC> findAll(FindAllExcBBCQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcBBC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcBBCRepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(ExcBBCEntityProjector.class.getName());
}
