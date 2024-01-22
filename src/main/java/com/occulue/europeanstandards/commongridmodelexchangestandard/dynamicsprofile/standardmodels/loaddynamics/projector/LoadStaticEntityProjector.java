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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for LoadStatic as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by LoadStaticAggregate
 *
 * @author your_name_here
 */
@Component("loadStatic-entity-projector")
public class LoadStaticEntityProjector {

  // core constructor
  public LoadStaticEntityProjector(LoadStaticRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a LoadStatic
   *
   * @param	entity LoadStatic
   */
  public LoadStatic create(LoadStatic entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a LoadStatic
   *
   * @param	entity LoadStatic
   */
  public LoadStatic update(LoadStatic entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a LoadStatic
   *
   * @param	id		UUID
   */
  public LoadStatic delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    LoadStatic entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Ep1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignEp1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ep1 as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Ep1 to the parent entity
    // ------------------------------------------
    parentEntity.setEp1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ep1
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignEp1(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ep1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ep1 on the parent entithy
    // ------------------------------------------
    parentEntity.setEp1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ep2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignEp2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ep2 as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Ep2 to the parent entity
    // ------------------------------------------
    parentEntity.setEp2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ep2
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignEp2(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ep2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ep2 on the parent entithy
    // ------------------------------------------
    parentEntity.setEp2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ep3
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignEp3(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ep3 as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Ep3 to the parent entity
    // ------------------------------------------
    parentEntity.setEp3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ep3
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignEp3(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ep3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ep3 on the parent entithy
    // ------------------------------------------
    parentEntity.setEp3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Eq1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignEq1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Eq1 as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Eq1 to the parent entity
    // ------------------------------------------
    parentEntity.setEq1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Eq1
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignEq1(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Eq1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Eq1 on the parent entithy
    // ------------------------------------------
    parentEntity.setEq1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Eq2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignEq2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Eq2 as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Eq2 to the parent entity
    // ------------------------------------------
    parentEntity.setEq2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Eq2
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignEq2(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Eq2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Eq2 on the parent entithy
    // ------------------------------------------
    parentEntity.setEq2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Eq3
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignEq3(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Eq3 as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Eq3 to the parent entity
    // ------------------------------------------
    parentEntity.setEq3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Eq3
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignEq3(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Eq3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Eq3 on the parent entithy
    // ------------------------------------------
    parentEntity.setEq3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kp1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignKp1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kp1 as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kp1 to the parent entity
    // ------------------------------------------
    parentEntity.setKp1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kp1
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignKp1(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kp1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kp1 on the parent entithy
    // ------------------------------------------
    parentEntity.setKp1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kp2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignKp2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kp2 as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kp2 to the parent entity
    // ------------------------------------------
    parentEntity.setKp2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kp2
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignKp2(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kp2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kp2 on the parent entithy
    // ------------------------------------------
    parentEntity.setKp2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kp3
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignKp3(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kp3 as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kp3 to the parent entity
    // ------------------------------------------
    parentEntity.setKp3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kp3
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignKp3(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kp3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kp3 on the parent entithy
    // ------------------------------------------
    parentEntity.setKp3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kp4
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignKp4(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kp4 as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kp4 to the parent entity
    // ------------------------------------------
    parentEntity.setKp4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kp4
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignKp4(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kp4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kp4 on the parent entithy
    // ------------------------------------------
    parentEntity.setKp4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpf
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignKpf(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kpf as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kpf to the parent entity
    // ------------------------------------------
    parentEntity.setKpf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpf
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignKpf(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpf on the parent entithy
    // ------------------------------------------
    parentEntity.setKpf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kq1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignKq1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kq1 as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kq1 to the parent entity
    // ------------------------------------------
    parentEntity.setKq1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kq1
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignKq1(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kq1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kq1 on the parent entithy
    // ------------------------------------------
    parentEntity.setKq1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kq2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignKq2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kq2 as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kq2 to the parent entity
    // ------------------------------------------
    parentEntity.setKq2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kq2
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignKq2(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kq2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kq2 on the parent entithy
    // ------------------------------------------
    parentEntity.setKq2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kq3
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignKq3(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kq3 as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kq3 to the parent entity
    // ------------------------------------------
    parentEntity.setKq3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kq3
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignKq3(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kq3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kq3 on the parent entithy
    // ------------------------------------------
    parentEntity.setKq3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kq4
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignKq4(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kq4 as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kq4 to the parent entity
    // ------------------------------------------
    parentEntity.setKq4(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kq4
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignKq4(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kq4 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kq4 on the parent entithy
    // ------------------------------------------
    parentEntity.setKq4(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kqf
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadStatic
   */
  public LoadStatic assignKqf(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kqf as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kqf to the parent entity
    // ------------------------------------------
    parentEntity.setKqf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kqf
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignKqf(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kqf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kqf on the parent entithy
    // ------------------------------------------
    parentEntity.setKqf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a LoadStatic
   *
   * @param	parentId	UUID
   * @param	assignment 	LoadStatic
   * @return	LoadStatic
   */
  public LoadStatic assignLoadStatic(UUID parentId, LoadStatic assignment) {
    LOGGER.info("assigning LoadStatic as " + assignment.toString());

    LoadStatic parentEntity = repository.findById(parentId).get();
    assignment = LoadStaticProjector.find(assignment.getLoadStaticId());

    // ------------------------------------------
    // assign the LoadStatic to the parent entity
    // ------------------------------------------
    parentEntity.setLoadStatic(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the LoadStatic
   *
   * @param	parentId		UUID
   * @return	LoadStatic
   */
  public LoadStatic unAssignLoadStatic(UUID parentId) {
    LoadStatic parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning LoadStatic on " + parentEntity.toString());

    // ------------------------------------------
    // null out the LoadStatic on the parent entithy
    // ------------------------------------------
    parentEntity.setLoadStatic(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the LoadStatic via an FindLoadStaticQuery
   *
   * @return query FindLoadStaticQuery
   */
  @SuppressWarnings("unused")
  public LoadStatic find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a LoadStatic - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all LoadStatics
   *
   * @param query FindAllLoadStaticQuery
   * @return List<LoadStatic>
   */
  @SuppressWarnings("unused")
  public List<LoadStatic> findAll(FindAllLoadStaticQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all LoadStatic - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final LoadStaticRepository repository;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "loadStatic-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .loaddynamics.projector.LoadStaticEntityProjector
      LoadStaticProjector;

  private static final Logger LOGGER = Logger.getLogger(LoadStaticEntityProjector.class.getName());
}
