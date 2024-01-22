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
 * Projector for LoadComposite as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by LoadCompositeAggregate
 *
 * @author your_name_here
 */
@Component("loadComposite-entity-projector")
public class LoadCompositeEntityProjector {

  // core constructor
  public LoadCompositeEntityProjector(LoadCompositeRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a LoadComposite
   *
   * @param	entity LoadComposite
   */
  public LoadComposite create(LoadComposite entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a LoadComposite
   *
   * @param	entity LoadComposite
   */
  public LoadComposite update(LoadComposite entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a LoadComposite
   *
   * @param	id		UUID
   */
  public LoadComposite delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    LoadComposite entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Epfd
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadComposite
   */
  public LoadComposite assignEpfd(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Epfd as " + assignment.toString());

    LoadComposite parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Epfd to the parent entity
    // ------------------------------------------
    parentEntity.setEpfd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Epfd
   *
   * @param	parentId		UUID
   * @return	LoadComposite
   */
  public LoadComposite unAssignEpfd(UUID parentId) {
    LoadComposite parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Epfd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Epfd on the parent entithy
    // ------------------------------------------
    parentEntity.setEpfd(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Epfs
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadComposite
   */
  public LoadComposite assignEpfs(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Epfs as " + assignment.toString());

    LoadComposite parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Epfs to the parent entity
    // ------------------------------------------
    parentEntity.setEpfs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Epfs
   *
   * @param	parentId		UUID
   * @return	LoadComposite
   */
  public LoadComposite unAssignEpfs(UUID parentId) {
    LoadComposite parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Epfs on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Epfs on the parent entithy
    // ------------------------------------------
    parentEntity.setEpfs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Epvd
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadComposite
   */
  public LoadComposite assignEpvd(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Epvd as " + assignment.toString());

    LoadComposite parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Epvd to the parent entity
    // ------------------------------------------
    parentEntity.setEpvd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Epvd
   *
   * @param	parentId		UUID
   * @return	LoadComposite
   */
  public LoadComposite unAssignEpvd(UUID parentId) {
    LoadComposite parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Epvd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Epvd on the parent entithy
    // ------------------------------------------
    parentEntity.setEpvd(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Epvs
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadComposite
   */
  public LoadComposite assignEpvs(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Epvs as " + assignment.toString());

    LoadComposite parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Epvs to the parent entity
    // ------------------------------------------
    parentEntity.setEpvs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Epvs
   *
   * @param	parentId		UUID
   * @return	LoadComposite
   */
  public LoadComposite unAssignEpvs(UUID parentId) {
    LoadComposite parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Epvs on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Epvs on the parent entithy
    // ------------------------------------------
    parentEntity.setEpvs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Eqfd
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadComposite
   */
  public LoadComposite assignEqfd(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Eqfd as " + assignment.toString());

    LoadComposite parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Eqfd to the parent entity
    // ------------------------------------------
    parentEntity.setEqfd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Eqfd
   *
   * @param	parentId		UUID
   * @return	LoadComposite
   */
  public LoadComposite unAssignEqfd(UUID parentId) {
    LoadComposite parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Eqfd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Eqfd on the parent entithy
    // ------------------------------------------
    parentEntity.setEqfd(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Eqfs
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadComposite
   */
  public LoadComposite assignEqfs(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Eqfs as " + assignment.toString());

    LoadComposite parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Eqfs to the parent entity
    // ------------------------------------------
    parentEntity.setEqfs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Eqfs
   *
   * @param	parentId		UUID
   * @return	LoadComposite
   */
  public LoadComposite unAssignEqfs(UUID parentId) {
    LoadComposite parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Eqfs on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Eqfs on the parent entithy
    // ------------------------------------------
    parentEntity.setEqfs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Eqvd
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadComposite
   */
  public LoadComposite assignEqvd(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Eqvd as " + assignment.toString());

    LoadComposite parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Eqvd to the parent entity
    // ------------------------------------------
    parentEntity.setEqvd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Eqvd
   *
   * @param	parentId		UUID
   * @return	LoadComposite
   */
  public LoadComposite unAssignEqvd(UUID parentId) {
    LoadComposite parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Eqvd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Eqvd on the parent entithy
    // ------------------------------------------
    parentEntity.setEqvd(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Eqvs
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadComposite
   */
  public LoadComposite assignEqvs(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Eqvs as " + assignment.toString());

    LoadComposite parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Eqvs to the parent entity
    // ------------------------------------------
    parentEntity.setEqvs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Eqvs
   *
   * @param	parentId		UUID
   * @return	LoadComposite
   */
  public LoadComposite unAssignEqvs(UUID parentId) {
    LoadComposite parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Eqvs on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Eqvs on the parent entithy
    // ------------------------------------------
    parentEntity.setEqvs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a H
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	LoadComposite
   */
  public LoadComposite assignH(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning H as " + assignment.toString());

    LoadComposite parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the H to the parent entity
    // ------------------------------------------
    parentEntity.setH(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the H
   *
   * @param	parentId		UUID
   * @return	LoadComposite
   */
  public LoadComposite unAssignH(UUID parentId) {
    LoadComposite parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning H on " + parentEntity.toString());

    // ------------------------------------------
    // null out the H on the parent entithy
    // ------------------------------------------
    parentEntity.setH(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Lfrac
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadComposite
   */
  public LoadComposite assignLfrac(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Lfrac as " + assignment.toString());

    LoadComposite parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Lfrac to the parent entity
    // ------------------------------------------
    parentEntity.setLfrac(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Lfrac
   *
   * @param	parentId		UUID
   * @return	LoadComposite
   */
  public LoadComposite unAssignLfrac(UUID parentId) {
    LoadComposite parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Lfrac on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Lfrac on the parent entithy
    // ------------------------------------------
    parentEntity.setLfrac(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pfrac
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	LoadComposite
   */
  public LoadComposite assignPfrac(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Pfrac as " + assignment.toString());

    LoadComposite parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Pfrac to the parent entity
    // ------------------------------------------
    parentEntity.setPfrac(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pfrac
   *
   * @param	parentId		UUID
   * @return	LoadComposite
   */
  public LoadComposite unAssignPfrac(UUID parentId) {
    LoadComposite parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pfrac on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pfrac on the parent entithy
    // ------------------------------------------
    parentEntity.setPfrac(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the LoadComposite via an FindLoadCompositeQuery
   *
   * @return query FindLoadCompositeQuery
   */
  @SuppressWarnings("unused")
  public LoadComposite find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a LoadComposite - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all LoadComposites
   *
   * @param query FindAllLoadCompositeQuery
   * @return List<LoadComposite>
   */
  @SuppressWarnings("unused")
  public List<LoadComposite> findAll(FindAllLoadCompositeQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all LoadComposite - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final LoadCompositeRepository repository;

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

  private static final Logger LOGGER =
      Logger.getLogger(LoadCompositeEntityProjector.class.getName());
}
