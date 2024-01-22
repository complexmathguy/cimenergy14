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
 * Projector for Pss1 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by Pss1Aggregate
 *
 * @author your_name_here
 */
@Component("pss1-entity-projector")
public class Pss1EntityProjector {

  // core constructor
  public Pss1EntityProjector(Pss1Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Pss1
   *
   * @param	entity Pss1
   */
  public Pss1 create(Pss1 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Pss1
   *
   * @param	entity Pss1
   */
  public Pss1 update(Pss1 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Pss1
   *
   * @param	id		UUID
   */
  public Pss1 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Pss1 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Kf
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	Pss1
   */
  public Pss1 assignKf(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kf as " + assignment.toString());

    Pss1 parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1
   */
  public Pss1 unAssignKf(UUID parentId) {
    Pss1 parentEntity = repository.findById(parentId).get();

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
   * @return	Pss1
   */
  public Pss1 assignKpe(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kpe as " + assignment.toString());

    Pss1 parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1
   */
  public Pss1 unAssignKpe(UUID parentId) {
    Pss1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Ks
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	Pss1
   */
  public Pss1 assignKs(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ks as " + assignment.toString());

    Pss1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Ks to the parent entity
    // ------------------------------------------
    parentEntity.setKs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ks
   *
   * @param	parentId		UUID
   * @return	Pss1
   */
  public Pss1 unAssignKs(UUID parentId) {
    Pss1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ks on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ks on the parent entithy
    // ------------------------------------------
    parentEntity.setKs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kw
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	Pss1
   */
  public Pss1 assignKw(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kw as " + assignment.toString());

    Pss1 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kw to the parent entity
    // ------------------------------------------
    parentEntity.setKw(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kw
   *
   * @param	parentId		UUID
   * @return	Pss1
   */
  public Pss1 unAssignKw(UUID parentId) {
    Pss1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kw on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kw on the parent entithy
    // ------------------------------------------
    parentEntity.setKw(null);

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
   * @return	Pss1
   */
  public Pss1 assignPmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmin as " + assignment.toString());

    Pss1 parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1
   */
  public Pss1 unAssignPmin(UUID parentId) {
    Pss1 parentEntity = repository.findById(parentId).get();

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
   * Assign a T10
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss1
   */
  public Pss1 assignT10(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T10 as " + assignment.toString());

    Pss1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T10 to the parent entity
    // ------------------------------------------
    parentEntity.setT10(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T10
   *
   * @param	parentId		UUID
   * @return	Pss1
   */
  public Pss1 unAssignT10(UUID parentId) {
    Pss1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T10 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T10 on the parent entithy
    // ------------------------------------------
    parentEntity.setT10(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T5
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss1
   */
  public Pss1 assignT5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T5 as " + assignment.toString());

    Pss1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T5 to the parent entity
    // ------------------------------------------
    parentEntity.setT5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T5
   *
   * @param	parentId		UUID
   * @return	Pss1
   */
  public Pss1 unAssignT5(UUID parentId) {
    Pss1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T5 on the parent entithy
    // ------------------------------------------
    parentEntity.setT5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T6
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss1
   */
  public Pss1 assignT6(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T6 as " + assignment.toString());

    Pss1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T6 to the parent entity
    // ------------------------------------------
    parentEntity.setT6(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T6
   *
   * @param	parentId		UUID
   * @return	Pss1
   */
  public Pss1 unAssignT6(UUID parentId) {
    Pss1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T6 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T6 on the parent entithy
    // ------------------------------------------
    parentEntity.setT6(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T7
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss1
   */
  public Pss1 assignT7(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T7 as " + assignment.toString());

    Pss1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T7 to the parent entity
    // ------------------------------------------
    parentEntity.setT7(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T7
   *
   * @param	parentId		UUID
   * @return	Pss1
   */
  public Pss1 unAssignT7(UUID parentId) {
    Pss1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T7 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T7 on the parent entithy
    // ------------------------------------------
    parentEntity.setT7(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T8
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss1
   */
  public Pss1 assignT8(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T8 as " + assignment.toString());

    Pss1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T8 to the parent entity
    // ------------------------------------------
    parentEntity.setT8(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T8
   *
   * @param	parentId		UUID
   * @return	Pss1
   */
  public Pss1 unAssignT8(UUID parentId) {
    Pss1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T8 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T8 on the parent entithy
    // ------------------------------------------
    parentEntity.setT8(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a T9
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	Pss1
   */
  public Pss1 assignT9(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning T9 as " + assignment.toString());

    Pss1 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the T9 to the parent entity
    // ------------------------------------------
    parentEntity.setT9(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the T9
   *
   * @param	parentId		UUID
   * @return	Pss1
   */
  public Pss1 unAssignT9(UUID parentId) {
    Pss1 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning T9 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the T9 on the parent entithy
    // ------------------------------------------
    parentEntity.setT9(null);

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
   * @return	Pss1
   */
  public Pss1 assignTpe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpe as " + assignment.toString());

    Pss1 parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1
   */
  public Pss1 unAssignTpe(UUID parentId) {
    Pss1 parentEntity = repository.findById(parentId).get();

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
   * Assign a Vadat
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	Pss1
   */
  public Pss1 assignVadat(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Vadat as " + assignment.toString());

    Pss1 parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1
   */
  public Pss1 unAssignVadat(UUID parentId) {
    Pss1 parentEntity = repository.findById(parentId).get();

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
   * @return	Pss1
   */
  public Pss1 assignVsmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vsmn as " + assignment.toString());

    Pss1 parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1
   */
  public Pss1 unAssignVsmn(UUID parentId) {
    Pss1 parentEntity = repository.findById(parentId).get();

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
   * @return	Pss1
   */
  public Pss1 assignVsmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vsmx as " + assignment.toString());

    Pss1 parentEntity = repository.findById(parentId).get();
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
   * @return	Pss1
   */
  public Pss1 unAssignVsmx(UUID parentId) {
    Pss1 parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the Pss1 via an FindPss1Query
   *
   * @return query FindPss1Query
   */
  @SuppressWarnings("unused")
  public Pss1 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Pss1 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Pss1s
   *
   * @param query FindAllPss1Query
   * @return List<Pss1>
   */
  @SuppressWarnings("unused")
  public List<Pss1> findAll(FindAllPss1Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Pss1 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final Pss1Repository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

  private static final Logger LOGGER = Logger.getLogger(Pss1EntityProjector.class.getName());
}
