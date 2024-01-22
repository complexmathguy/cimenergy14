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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for WindContPType3IEC as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by WindContPType3IECAggregate
 *
 * @author your_name_here
 */
@Component("windContPType3IEC-entity-projector")
public class WindContPType3IECEntityProjector {

  // core constructor
  public WindContPType3IECEntityProjector(WindContPType3IECRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a WindContPType3IEC
   *
   * @param	entity WindContPType3IEC
   */
  public WindContPType3IEC create(WindContPType3IEC entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a WindContPType3IEC
   *
   * @param	entity WindContPType3IEC
   */
  public WindContPType3IEC update(WindContPType3IEC entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a WindContPType3IEC
   *
   * @param	id		UUID
   */
  public WindContPType3IEC delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    WindContPType3IEC entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Dpmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignDpmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dpmax as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dpmax to the parent entity
    // ------------------------------------------
    parentEntity.setDpmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dpmax
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignDpmax(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dpmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dpmax on the parent entithy
    // ------------------------------------------
    parentEntity.setDpmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Dtrisemaxlvrt
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignDtrisemaxlvrt(UUID parentId, PU assignment) {
    LOGGER.info("assigning Dtrisemaxlvrt as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Dtrisemaxlvrt to the parent entity
    // ------------------------------------------
    parentEntity.setDtrisemaxlvrt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dtrisemaxlvrt
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignDtrisemaxlvrt(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dtrisemaxlvrt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dtrisemaxlvrt on the parent entithy
    // ------------------------------------------
    parentEntity.setDtrisemaxlvrt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kdtd
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignKdtd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kdtd as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kdtd to the parent entity
    // ------------------------------------------
    parentEntity.setKdtd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kdtd
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignKdtd(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kdtd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kdtd on the parent entithy
    // ------------------------------------------
    parentEntity.setKdtd(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kip
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignKip(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kip as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kip to the parent entity
    // ------------------------------------------
    parentEntity.setKip(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kip
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignKip(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kip on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kip on the parent entithy
    // ------------------------------------------
    parentEntity.setKip(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kpp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignKpp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kpp as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kpp to the parent entity
    // ------------------------------------------
    parentEntity.setKpp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kpp
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignKpp(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kpp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kpp on the parent entithy
    // ------------------------------------------
    parentEntity.setKpp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mplvrt
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignMplvrt(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Mplvrt as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Mplvrt to the parent entity
    // ------------------------------------------
    parentEntity.setMplvrt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mplvrt
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignMplvrt(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mplvrt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mplvrt on the parent entithy
    // ------------------------------------------
    parentEntity.setMplvrt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Omegaoffset
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignOmegaoffset(UUID parentId, PU assignment) {
    LOGGER.info("assigning Omegaoffset as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Omegaoffset to the parent entity
    // ------------------------------------------
    parentEntity.setOmegaoffset(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Omegaoffset
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignOmegaoffset(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Omegaoffset on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Omegaoffset on the parent entithy
    // ------------------------------------------
    parentEntity.setOmegaoffset(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pdtdmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignPdtdmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pdtdmax as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pdtdmax to the parent entity
    // ------------------------------------------
    parentEntity.setPdtdmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pdtdmax
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignPdtdmax(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pdtdmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pdtdmax on the parent entithy
    // ------------------------------------------
    parentEntity.setPdtdmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rramp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignRramp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rramp as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rramp to the parent entity
    // ------------------------------------------
    parentEntity.setRramp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rramp
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignRramp(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rramp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rramp on the parent entithy
    // ------------------------------------------
    parentEntity.setRramp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tdvs
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignTdvs(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tdvs as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tdvs to the parent entity
    // ------------------------------------------
    parentEntity.setTdvs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tdvs
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignTdvs(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tdvs on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tdvs on the parent entithy
    // ------------------------------------------
    parentEntity.setTdvs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Temin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignTemin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Temin as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Temin to the parent entity
    // ------------------------------------------
    parentEntity.setTemin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Temin
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignTemin(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Temin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Temin on the parent entithy
    // ------------------------------------------
    parentEntity.setTemin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tomegafilt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignTomegafilt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tomegafilt as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tomegafilt to the parent entity
    // ------------------------------------------
    parentEntity.setTomegafilt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tomegafilt
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignTomegafilt(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tomegafilt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tomegafilt on the parent entithy
    // ------------------------------------------
    parentEntity.setTomegafilt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpfilt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignTpfilt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tpfilt as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tpfilt to the parent entity
    // ------------------------------------------
    parentEntity.setTpfilt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpfilt
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignTpfilt(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpfilt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpfilt on the parent entithy
    // ------------------------------------------
    parentEntity.setTpfilt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tpord
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignTpord(UUID parentId, PU assignment) {
    LOGGER.info("assigning Tpord as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Tpord to the parent entity
    // ------------------------------------------
    parentEntity.setTpord(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tpord
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignTpord(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tpord on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tpord on the parent entithy
    // ------------------------------------------
    parentEntity.setTpord(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tufilt
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignTufilt(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tufilt as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tufilt to the parent entity
    // ------------------------------------------
    parentEntity.setTufilt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tufilt
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignTufilt(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tufilt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tufilt on the parent entithy
    // ------------------------------------------
    parentEntity.setTufilt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tuscale
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignTuscale(UUID parentId, PU assignment) {
    LOGGER.info("assigning Tuscale as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Tuscale to the parent entity
    // ------------------------------------------
    parentEntity.setTuscale(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tuscale
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignTuscale(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tuscale on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tuscale on the parent entithy
    // ------------------------------------------
    parentEntity.setTuscale(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Twref
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignTwref(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Twref as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Twref to the parent entity
    // ------------------------------------------
    parentEntity.setTwref(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Twref
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignTwref(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Twref on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Twref on the parent entithy
    // ------------------------------------------
    parentEntity.setTwref(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Udvs
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignUdvs(UUID parentId, PU assignment) {
    LOGGER.info("assigning Udvs as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Udvs to the parent entity
    // ------------------------------------------
    parentEntity.setUdvs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Udvs
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignUdvs(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Udvs on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Udvs on the parent entithy
    // ------------------------------------------
    parentEntity.setUdvs(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Updip
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignUpdip(UUID parentId, PU assignment) {
    LOGGER.info("assigning Updip as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Updip to the parent entity
    // ------------------------------------------
    parentEntity.setUpdip(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Updip
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignUpdip(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Updip on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Updip on the parent entithy
    // ------------------------------------------
    parentEntity.setUpdip(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Wdtd
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignWdtd(UUID parentId, PU assignment) {
    LOGGER.info("assigning Wdtd as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Wdtd to the parent entity
    // ------------------------------------------
    parentEntity.setWdtd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Wdtd
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignWdtd(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Wdtd on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Wdtd on the parent entithy
    // ------------------------------------------
    parentEntity.setWdtd(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Zeta
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC assignZeta(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Zeta as " + assignment.toString());

    WindContPType3IEC parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Zeta to the parent entity
    // ------------------------------------------
    parentEntity.setZeta(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Zeta
   *
   * @param	parentId		UUID
   * @return	WindContPType3IEC
   */
  public WindContPType3IEC unAssignZeta(UUID parentId) {
    WindContPType3IEC parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Zeta on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Zeta on the parent entithy
    // ------------------------------------------
    parentEntity.setZeta(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the WindContPType3IEC via an FindWindContPType3IECQuery
   *
   * @return query FindWindContPType3IECQuery
   */
  @SuppressWarnings("unused")
  public WindContPType3IEC find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a WindContPType3IEC - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all WindContPType3IECs
   *
   * @param query FindAllWindContPType3IECQuery
   * @return List<WindContPType3IEC>
   */
  @SuppressWarnings("unused")
  public List<WindContPType3IEC> findAll(FindAllWindContPType3IECQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all WindContPType3IEC - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final WindContPType3IECRepository repository;

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

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  private static final Logger LOGGER =
      Logger.getLogger(WindContPType3IECEntityProjector.class.getName());
}
