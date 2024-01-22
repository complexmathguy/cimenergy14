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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for GovGAST4 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovGAST4Aggregate
 *
 * @author your_name_here
 */
@Component("govGAST4-entity-projector")
public class GovGAST4EntityProjector {

  // core constructor
  public GovGAST4EntityProjector(GovGAST4Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovGAST4
   *
   * @param	entity GovGAST4
   */
  public GovGAST4 create(GovGAST4 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovGAST4
   *
   * @param	entity GovGAST4
   */
  public GovGAST4 update(GovGAST4 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovGAST4
   *
   * @param	id		UUID
   */
  public GovGAST4 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovGAST4 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Bp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGAST4
   */
  public GovGAST4 assignBp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Bp as " + assignment.toString());

    GovGAST4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Bp to the parent entity
    // ------------------------------------------
    parentEntity.setBp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bp
   *
   * @param	parentId		UUID
   * @return	GovGAST4
   */
  public GovGAST4 unAssignBp(UUID parentId) {
    GovGAST4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bp on the parent entithy
    // ------------------------------------------
    parentEntity.setBp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ktm
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGAST4
   */
  public GovGAST4 assignKtm(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ktm as " + assignment.toString());

    GovGAST4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ktm to the parent entity
    // ------------------------------------------
    parentEntity.setKtm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ktm
   *
   * @param	parentId		UUID
   * @return	GovGAST4
   */
  public GovGAST4 unAssignKtm(UUID parentId) {
    GovGAST4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ktm on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ktm on the parent entithy
    // ------------------------------------------
    parentEntity.setKtm(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mnef
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGAST4
   */
  public GovGAST4 assignMnef(UUID parentId, PU assignment) {
    LOGGER.info("assigning Mnef as " + assignment.toString());

    GovGAST4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Mnef to the parent entity
    // ------------------------------------------
    parentEntity.setMnef(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mnef
   *
   * @param	parentId		UUID
   * @return	GovGAST4
   */
  public GovGAST4 unAssignMnef(UUID parentId) {
    GovGAST4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mnef on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mnef on the parent entithy
    // ------------------------------------------
    parentEntity.setMnef(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mxef
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGAST4
   */
  public GovGAST4 assignMxef(UUID parentId, PU assignment) {
    LOGGER.info("assigning Mxef as " + assignment.toString());

    GovGAST4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Mxef to the parent entity
    // ------------------------------------------
    parentEntity.setMxef(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mxef
   *
   * @param	parentId		UUID
   * @return	GovGAST4
   */
  public GovGAST4 unAssignMxef(UUID parentId) {
    GovGAST4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mxef on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mxef on the parent entithy
    // ------------------------------------------
    parentEntity.setMxef(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rymn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGAST4
   */
  public GovGAST4 assignRymn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rymn as " + assignment.toString());

    GovGAST4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rymn to the parent entity
    // ------------------------------------------
    parentEntity.setRymn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rymn
   *
   * @param	parentId		UUID
   * @return	GovGAST4
   */
  public GovGAST4 unAssignRymn(UUID parentId) {
    GovGAST4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rymn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rymn on the parent entithy
    // ------------------------------------------
    parentEntity.setRymn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rymx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGAST4
   */
  public GovGAST4 assignRymx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rymx as " + assignment.toString());

    GovGAST4 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rymx to the parent entity
    // ------------------------------------------
    parentEntity.setRymx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rymx
   *
   * @param	parentId		UUID
   * @return	GovGAST4
   */
  public GovGAST4 unAssignRymx(UUID parentId) {
    GovGAST4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rymx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rymx on the parent entithy
    // ------------------------------------------
    parentEntity.setRymx(null);

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
   * @return	GovGAST4
   */
  public GovGAST4 assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    GovGAST4 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST4
   */
  public GovGAST4 unAssignTa(UUID parentId) {
    GovGAST4 parentEntity = repository.findById(parentId).get();

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
   * Assign a Tc
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST4
   */
  public GovGAST4 assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    GovGAST4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tc to the parent entity
    // ------------------------------------------
    parentEntity.setTc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tc
   *
   * @param	parentId		UUID
   * @return	GovGAST4
   */
  public GovGAST4 unAssignTc(UUID parentId) {
    GovGAST4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tc on the parent entithy
    // ------------------------------------------
    parentEntity.setTc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tcm
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST4
   */
  public GovGAST4 assignTcm(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tcm as " + assignment.toString());

    GovGAST4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tcm to the parent entity
    // ------------------------------------------
    parentEntity.setTcm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tcm
   *
   * @param	parentId		UUID
   * @return	GovGAST4
   */
  public GovGAST4 unAssignTcm(UUID parentId) {
    GovGAST4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tcm on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tcm on the parent entithy
    // ------------------------------------------
    parentEntity.setTcm(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tm
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST4
   */
  public GovGAST4 assignTm(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tm as " + assignment.toString());

    GovGAST4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tm to the parent entity
    // ------------------------------------------
    parentEntity.setTm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tm
   *
   * @param	parentId		UUID
   * @return	GovGAST4
   */
  public GovGAST4 unAssignTm(UUID parentId) {
    GovGAST4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tm on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tm on the parent entithy
    // ------------------------------------------
    parentEntity.setTm(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tv
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST4
   */
  public GovGAST4 assignTv(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tv as " + assignment.toString());

    GovGAST4 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tv to the parent entity
    // ------------------------------------------
    parentEntity.setTv(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tv
   *
   * @param	parentId		UUID
   * @return	GovGAST4
   */
  public GovGAST4 unAssignTv(UUID parentId) {
    GovGAST4 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tv on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tv on the parent entithy
    // ------------------------------------------
    parentEntity.setTv(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovGAST4 via an FindGovGAST4Query
   *
   * @return query FindGovGAST4Query
   */
  @SuppressWarnings("unused")
  public GovGAST4 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovGAST4 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovGAST4s
   *
   * @param query FindAllGovGAST4Query
   * @return List<GovGAST4>
   */
  @SuppressWarnings("unused")
  public List<GovGAST4> findAll(FindAllGovGAST4Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovGAST4 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovGAST4Repository repository;

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

  private static final Logger LOGGER = Logger.getLogger(GovGAST4EntityProjector.class.getName());
}
