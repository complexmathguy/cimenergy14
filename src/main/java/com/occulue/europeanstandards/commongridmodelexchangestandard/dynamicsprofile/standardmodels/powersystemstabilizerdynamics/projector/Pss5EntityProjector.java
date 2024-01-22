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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for Pss5 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by Pss5Aggregate
 *
 * @author your_name_here
 */
@Component("pss5-entity-projector")
public class Pss5EntityProjector {

  // core constructor
  public Pss5EntityProjector(Pss5Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Pss5
   *
   * @param	entity Pss5
   */
  public Pss5 create(Pss5 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Pss5
   *
   * @param	entity Pss5
   */
  public Pss5 update(Pss5 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Pss5
   *
   * @param	id		UUID
   */
  public Pss5 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Pss5 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Ctw2
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	Pss5
   */
  public Pss5 assignCtw2(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Ctw2 as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Ctw2 to the parent entity
    // ------------------------------------------
    parentEntity.setCtw2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ctw2
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignCtw2(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ctw2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ctw2 on the parent entithy
    // ------------------------------------------
    parentEntity.setCtw2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Deadband
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss5
   */
  public Pss5 assignDeadband(UUID parentId, PU assignment) {
    LOGGER.info("assigning Deadband as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Deadband to the parent entity
    // ------------------------------------------
    parentEntity.setDeadband(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Deadband
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignDeadband(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Deadband on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Deadband on the parent entithy
    // ------------------------------------------
    parentEntity.setDeadband(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Isfreq
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	Pss5
   */
  public Pss5 assignIsfreq(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Isfreq as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Isfreq to the parent entity
    // ------------------------------------------
    parentEntity.setIsfreq(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Isfreq
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignIsfreq(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Isfreq on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Isfreq on the parent entithy
    // ------------------------------------------
    parentEntity.setIsfreq(null);

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
   * @return	Pss5
   */
  public Pss5 assignKf(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kf as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
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
   * @return	Pss5
   */
  public Pss5 unAssignKf(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

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
   * Assign a Kpe
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	Pss5
   */
  public Pss5 assignKpe(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kpe as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kpe to the parent entity
    // ------------------------------------------
    parentEntity.setKpe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpe
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignKpe(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpe on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpe on the parent entithy
    // ------------------------------------------
    parentEntity.setKpe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpss
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	Pss5
   */
  public Pss5 assignKpss(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kpss as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kpss to the parent entity
    // ------------------------------------------
    parentEntity.setKpss(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpss
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignKpss(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpss on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpss on the parent entithy
    // ------------------------------------------
    parentEntity.setKpss(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmm
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss5
   */
  public Pss5 assignPmm(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmm as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmm to the parent entity
    // ------------------------------------------
    parentEntity.setPmm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmm
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignPmm(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmm on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmm on the parent entithy
    // ------------------------------------------
    parentEntity.setPmm(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss5
   */
  public Pss5 assignTl1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl1 as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl1 to the parent entity
    // ------------------------------------------
    parentEntity.setTl1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl1
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignTl1(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss5
   */
  public Pss5 assignTl2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl2 as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl2 to the parent entity
    // ------------------------------------------
    parentEntity.setTl2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl2
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignTl2(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss5
   */
  public Pss5 assignTl3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl3 as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl3 to the parent entity
    // ------------------------------------------
    parentEntity.setTl3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl3
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignTl3(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl3 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tl4
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss5
   */
  public Pss5 assignTl4(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl4 as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tl4 to the parent entity
    // ------------------------------------------
    parentEntity.setTl4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tl4
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignTl4(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tl4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tl4 on the parent entithy
    // ------------------------------------------
    parentEntity.setTl4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpe
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss5
   */
  public Pss5 assignTpe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpe as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpe to the parent entity
    // ------------------------------------------
    parentEntity.setTpe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpe
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignTpe(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpe on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpe on the parent entithy
    // ------------------------------------------
    parentEntity.setTpe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tw1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss5
   */
  public Pss5 assignTw1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw1 as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tw1 to the parent entity
    // ------------------------------------------
    parentEntity.setTw1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tw1
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignTw1(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tw1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tw1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTw1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tw2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss5
   */
  public Pss5 assignTw2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw2 as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tw2 to the parent entity
    // ------------------------------------------
    parentEntity.setTw2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tw2
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignTw2(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tw2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tw2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTw2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vadat
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	Pss5
   */
  public Pss5 assignVadat(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Vadat as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Vadat to the parent entity
    // ------------------------------------------
    parentEntity.setVadat(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vadat
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignVadat(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vadat on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vadat on the parent entithy
    // ------------------------------------------
    parentEntity.setVadat(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vsmn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss5
   */
  public Pss5 assignVsmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vsmn as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vsmn to the parent entity
    // ------------------------------------------
    parentEntity.setVsmn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vsmn
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignVsmn(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vsmn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vsmn on the parent entithy
    // ------------------------------------------
    parentEntity.setVsmn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vsmx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	Pss5
   */
  public Pss5 assignVsmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vsmx as " + assignment.toString());

    Pss5 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vsmx to the parent entity
    // ------------------------------------------
    parentEntity.setVsmx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vsmx
   *
   * @param	parentId		UUID
   * @return	Pss5
   */
  public Pss5 unAssignVsmx(UUID parentId) {
    Pss5 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vsmx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vsmx on the parent entithy
    // ------------------------------------------
    parentEntity.setVsmx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the Pss5 via an FindPss5Query
   *
   * @return query FindPss5Query
   */
  @SuppressWarnings("unused")
  public Pss5 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Pss5 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Pss5s
   *
   * @param query FindAllPss5Query
   * @return List<Pss5>
   */
  @SuppressWarnings("unused")
  public List<Pss5> findAll(FindAllPss5Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Pss5 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final Pss5Repository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

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

  private static final Logger LOGGER = Logger.getLogger(Pss5EntityProjector.class.getName());
}
