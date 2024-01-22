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
 * Projector for ExcIEEEST1A as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcIEEEST1AAggregate
 *
 * @author your_name_here
 */
@Component("excIEEEST1A-entity-projector")
public class ExcIEEEST1AEntityProjector {

  // core constructor
  public ExcIEEEST1AEntityProjector(ExcIEEEST1ARepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcIEEEST1A
   *
   * @param	entity ExcIEEEST1A
   */
  public ExcIEEEST1A create(ExcIEEEST1A entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcIEEEST1A
   *
   * @param	entity ExcIEEEST1A
   */
  public ExcIEEEST1A update(ExcIEEEST1A entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcIEEEST1A
   *
   * @param	id		UUID
   */
  public ExcIEEEST1A delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcIEEEST1A entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Ilr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignIlr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ilr as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ilr to the parent entity
    // ------------------------------------------
    parentEntity.setIlr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ilr
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignIlr(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ilr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ilr on the parent entithy
    // ------------------------------------------
    parentEntity.setIlr(null);

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
   * @param	assignment 	PU
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignKa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

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
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignKa(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

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
   * Assign a Kc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignKc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kc as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kc to the parent entity
    // ------------------------------------------
    parentEntity.setKc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kc
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignKc(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kc on the parent entithy
    // ------------------------------------------
    parentEntity.setKc(null);

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
   * @param	assignment 	PU
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignKf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

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
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignKf(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

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
   * Assign a Klr
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignKlr(UUID parentId, PU assignment) {
    LOGGER.info("assigning Klr as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Klr to the parent entity
    // ------------------------------------------
    parentEntity.setKlr(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Klr
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignKlr(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Klr on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Klr on the parent entithy
    // ------------------------------------------
    parentEntity.setKlr(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pssin
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignPssin(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Pssin as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Pssin to the parent entity
    // ------------------------------------------
    parentEntity.setPssin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pssin
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignPssin(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pssin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pssin on the parent entithy
    // ------------------------------------------
    parentEntity.setPssin(null);

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
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignTa(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignTb(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

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
   * Assign a Tb1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignTb1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb1 as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tb1 to the parent entity
    // ------------------------------------------
    parentEntity.setTb1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tb1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignTb1(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tb1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tb1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTb1(null);

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
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignTc(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

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
   * Assign a Tc1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignTc1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc1 as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tc1 to the parent entity
    // ------------------------------------------
    parentEntity.setTc1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tc1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignTc1(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tc1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tc1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTc1(null);

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
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignTf(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

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
   * Assign a Vamax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignVamax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vamax as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vamax to the parent entity
    // ------------------------------------------
    parentEntity.setVamax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vamax
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignVamax(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vamax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vamax on the parent entithy
    // ------------------------------------------
    parentEntity.setVamax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vamin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignVamin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vamin as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vamin to the parent entity
    // ------------------------------------------
    parentEntity.setVamin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vamin
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignVamin(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vamin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vamin on the parent entithy
    // ------------------------------------------
    parentEntity.setVamin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vimax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignVimax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vimax as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vimax to the parent entity
    // ------------------------------------------
    parentEntity.setVimax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vimax
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignVimax(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vimax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vimax on the parent entithy
    // ------------------------------------------
    parentEntity.setVimax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vimin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignVimin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vimin as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vimin to the parent entity
    // ------------------------------------------
    parentEntity.setVimin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vimin
   *
   * @param	parentId		UUID
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignVimin(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vimin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vimin on the parent entithy
    // ------------------------------------------
    parentEntity.setVimin(null);

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
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignVrmax(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

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
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcIEEEST1A parentEntity = repository.findById(parentId).get();
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
   * @return	ExcIEEEST1A
   */
  public ExcIEEEST1A unAssignVrmin(UUID parentId) {
    ExcIEEEST1A parentEntity = repository.findById(parentId).get();

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

  /**
   * Method to retrieve the ExcIEEEST1A via an FindExcIEEEST1AQuery
   *
   * @return query FindExcIEEEST1AQuery
   */
  @SuppressWarnings("unused")
  public ExcIEEEST1A find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcIEEEST1A - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEST1As
   *
   * @param query FindAllExcIEEEST1AQuery
   * @return List<ExcIEEEST1A>
   */
  @SuppressWarnings("unused")
  public List<ExcIEEEST1A> findAll(FindAllExcIEEEST1AQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcIEEEST1A - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcIEEEST1ARepository repository;

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

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST1AEntityProjector.class.getName());
}
