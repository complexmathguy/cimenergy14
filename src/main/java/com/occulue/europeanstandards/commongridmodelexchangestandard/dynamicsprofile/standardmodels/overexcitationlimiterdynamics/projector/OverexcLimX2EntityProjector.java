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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for OverexcLimX2 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by OverexcLimX2Aggregate
 *
 * @author your_name_here
 */
@Component("overexcLimX2-entity-projector")
public class OverexcLimX2EntityProjector {

  // core constructor
  public OverexcLimX2EntityProjector(OverexcLimX2Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a OverexcLimX2
   *
   * @param	entity OverexcLimX2
   */
  public OverexcLimX2 create(OverexcLimX2 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a OverexcLimX2
   *
   * @param	entity OverexcLimX2
   */
  public OverexcLimX2 update(OverexcLimX2 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a OverexcLimX2
   *
   * @param	id		UUID
   */
  public OverexcLimX2 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    OverexcLimX2 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Efd1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLimX2
   */
  public OverexcLimX2 assignEfd1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efd1 as " + assignment.toString());

    OverexcLimX2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efd1 to the parent entity
    // ------------------------------------------
    parentEntity.setEfd1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efd1
   *
   * @param	parentId		UUID
   * @return	OverexcLimX2
   */
  public OverexcLimX2 unAssignEfd1(UUID parentId) {
    OverexcLimX2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efd1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efd1 on the parent entithy
    // ------------------------------------------
    parentEntity.setEfd1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Efd2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLimX2
   */
  public OverexcLimX2 assignEfd2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efd2 as " + assignment.toString());

    OverexcLimX2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efd2 to the parent entity
    // ------------------------------------------
    parentEntity.setEfd2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efd2
   *
   * @param	parentId		UUID
   * @return	OverexcLimX2
   */
  public OverexcLimX2 unAssignEfd2(UUID parentId) {
    OverexcLimX2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efd2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efd2 on the parent entithy
    // ------------------------------------------
    parentEntity.setEfd2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Efd3
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLimX2
   */
  public OverexcLimX2 assignEfd3(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efd3 as " + assignment.toString());

    OverexcLimX2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efd3 to the parent entity
    // ------------------------------------------
    parentEntity.setEfd3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efd3
   *
   * @param	parentId		UUID
   * @return	OverexcLimX2
   */
  public OverexcLimX2 unAssignEfd3(UUID parentId) {
    OverexcLimX2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efd3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efd3 on the parent entithy
    // ------------------------------------------
    parentEntity.setEfd3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Efddes
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLimX2
   */
  public OverexcLimX2 assignEfddes(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efddes as " + assignment.toString());

    OverexcLimX2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efddes to the parent entity
    // ------------------------------------------
    parentEntity.setEfddes(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efddes
   *
   * @param	parentId		UUID
   * @return	OverexcLimX2
   */
  public OverexcLimX2 unAssignEfddes(UUID parentId) {
    OverexcLimX2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efddes on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efddes on the parent entithy
    // ------------------------------------------
    parentEntity.setEfddes(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Efdrated
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLimX2
   */
  public OverexcLimX2 assignEfdrated(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efdrated as " + assignment.toString());

    OverexcLimX2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efdrated to the parent entity
    // ------------------------------------------
    parentEntity.setEfdrated(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efdrated
   *
   * @param	parentId		UUID
   * @return	OverexcLimX2
   */
  public OverexcLimX2 unAssignEfdrated(UUID parentId) {
    OverexcLimX2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efdrated on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efdrated on the parent entithy
    // ------------------------------------------
    parentEntity.setEfdrated(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kmx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLimX2
   */
  public OverexcLimX2 assignKmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kmx as " + assignment.toString());

    OverexcLimX2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kmx to the parent entity
    // ------------------------------------------
    parentEntity.setKmx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kmx
   *
   * @param	parentId		UUID
   * @return	OverexcLimX2
   */
  public OverexcLimX2 unAssignKmx(UUID parentId) {
    OverexcLimX2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kmx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kmx on the parent entithy
    // ------------------------------------------
    parentEntity.setKmx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a M
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	OverexcLimX2
   */
  public OverexcLimX2 assignM(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning M as " + assignment.toString());

    OverexcLimX2 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the M to the parent entity
    // ------------------------------------------
    parentEntity.setM(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the M
   *
   * @param	parentId		UUID
   * @return	OverexcLimX2
   */
  public OverexcLimX2 unAssignM(UUID parentId) {
    OverexcLimX2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning M on " + parentEntity.toString());

    // ------------------------------------------
    // null out the M on the parent entithy
    // ------------------------------------------
    parentEntity.setM(null);

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
   * @return	OverexcLimX2
   */
  public OverexcLimX2 assignT1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T1 as " + assignment.toString());

    OverexcLimX2 parentEntity = repository.findById(parentId).get();
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
   * @return	OverexcLimX2
   */
  public OverexcLimX2 unAssignT1(UUID parentId) {
    OverexcLimX2 parentEntity = repository.findById(parentId).get();

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
   * @return	OverexcLimX2
   */
  public OverexcLimX2 assignT2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T2 as " + assignment.toString());

    OverexcLimX2 parentEntity = repository.findById(parentId).get();
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
   * @return	OverexcLimX2
   */
  public OverexcLimX2 unAssignT2(UUID parentId) {
    OverexcLimX2 parentEntity = repository.findById(parentId).get();

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
   * @return	OverexcLimX2
   */
  public OverexcLimX2 assignT3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T3 as " + assignment.toString());

    OverexcLimX2 parentEntity = repository.findById(parentId).get();
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
   * @return	OverexcLimX2
   */
  public OverexcLimX2 unAssignT3(UUID parentId) {
    OverexcLimX2 parentEntity = repository.findById(parentId).get();

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
   * Assign a Vlow
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	OverexcLimX2
   */
  public OverexcLimX2 assignVlow(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vlow as " + assignment.toString());

    OverexcLimX2 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vlow to the parent entity
    // ------------------------------------------
    parentEntity.setVlow(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vlow
   *
   * @param	parentId		UUID
   * @return	OverexcLimX2
   */
  public OverexcLimX2 unAssignVlow(UUID parentId) {
    OverexcLimX2 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vlow on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vlow on the parent entithy
    // ------------------------------------------
    parentEntity.setVlow(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the OverexcLimX2 via an FindOverexcLimX2Query
   *
   * @return query FindOverexcLimX2Query
   */
  @SuppressWarnings("unused")
  public OverexcLimX2 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a OverexcLimX2 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all OverexcLimX2s
   *
   * @param query FindAllOverexcLimX2Query
   * @return List<OverexcLimX2>
   */
  @SuppressWarnings("unused")
  public List<OverexcLimX2> findAll(FindAllOverexcLimX2Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all OverexcLimX2 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final OverexcLimX2Repository repository;

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

  private static final Logger LOGGER =
      Logger.getLogger(OverexcLimX2EntityProjector.class.getName());
}
