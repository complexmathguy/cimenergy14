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
 * Projector for GovSteamEU as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovSteamEUAggregate
 *
 * @author your_name_here
 */
@Component("govSteamEU-entity-projector")
public class GovSteamEUEntityProjector {

  // core constructor
  public GovSteamEUEntityProjector(GovSteamEURepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovSteamEU
   *
   * @param	entity GovSteamEU
   */
  public GovSteamEU create(GovSteamEU entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovSteamEU
   *
   * @param	entity GovSteamEU
   */
  public GovSteamEU update(GovSteamEU entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovSteamEU
   *
   * @param	id		UUID
   */
  public GovSteamEU delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovSteamEU entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Chc
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteamEU
   */
  public GovSteamEU assignChc(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Chc as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Chc to the parent entity
    // ------------------------------------------
    parentEntity.setChc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Chc
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignChc(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Chc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Chc on the parent entithy
    // ------------------------------------------
    parentEntity.setChc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Cho
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovSteamEU
   */
  public GovSteamEU assignCho(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Cho as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Cho to the parent entity
    // ------------------------------------------
    parentEntity.setCho(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Cho
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignCho(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Cho on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Cho on the parent entithy
    // ------------------------------------------
    parentEntity.setCho(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Cic
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignCic(UUID parentId, PU assignment) {
    LOGGER.info("assigning Cic as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Cic to the parent entity
    // ------------------------------------------
    parentEntity.setCic(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Cic
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignCic(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Cic on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Cic on the parent entithy
    // ------------------------------------------
    parentEntity.setCic(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Cio
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignCio(UUID parentId, PU assignment) {
    LOGGER.info("assigning Cio as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Cio to the parent entity
    // ------------------------------------------
    parentEntity.setCio(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Cio
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignCio(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Cio on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Cio on the parent entithy
    // ------------------------------------------
    parentEntity.setCio(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Db1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignDb1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Db1 as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Db1 to the parent entity
    // ------------------------------------------
    parentEntity.setDb1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Db1
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignDb1(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Db1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Db1 on the parent entithy
    // ------------------------------------------
    parentEntity.setDb1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Db2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignDb2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Db2 as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Db2 to the parent entity
    // ------------------------------------------
    parentEntity.setDb2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Db2
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignDb2(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Db2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Db2 on the parent entithy
    // ------------------------------------------
    parentEntity.setDb2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Hhpmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignHhpmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Hhpmax as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Hhpmax to the parent entity
    // ------------------------------------------
    parentEntity.setHhpmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Hhpmax
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignHhpmax(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Hhpmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Hhpmax on the parent entithy
    // ------------------------------------------
    parentEntity.setHhpmax(null);

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
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignKe(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ke as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

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
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignKe(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

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
   * Assign a Kfcor
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignKfcor(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kfcor as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kfcor to the parent entity
    // ------------------------------------------
    parentEntity.setKfcor(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kfcor
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignKfcor(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kfcor on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kfcor on the parent entithy
    // ------------------------------------------
    parentEntity.setKfcor(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Khp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignKhp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Khp as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Khp to the parent entity
    // ------------------------------------------
    parentEntity.setKhp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Khp
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignKhp(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Khp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Khp on the parent entithy
    // ------------------------------------------
    parentEntity.setKhp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Klp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignKlp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Klp as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Klp to the parent entity
    // ------------------------------------------
    parentEntity.setKlp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Klp
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignKlp(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Klp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Klp on the parent entithy
    // ------------------------------------------
    parentEntity.setKlp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kwcor
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignKwcor(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kwcor as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kwcor to the parent entity
    // ------------------------------------------
    parentEntity.setKwcor(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kwcor
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignKwcor(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kwcor on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kwcor on the parent entithy
    // ------------------------------------------
    parentEntity.setKwcor(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Mwbase
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	GovSteamEU
   */
  public GovSteamEU assignMwbase(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning Mwbase as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the Mwbase to the parent entity
    // ------------------------------------------
    parentEntity.setMwbase(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Mwbase
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignMwbase(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Mwbase on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Mwbase on the parent entithy
    // ------------------------------------------
    parentEntity.setMwbase(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Pmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignPmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Pmax as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Pmax to the parent entity
    // ------------------------------------------
    parentEntity.setPmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Pmax
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignPmax(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Pmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Pmax on the parent entithy
    // ------------------------------------------
    parentEntity.setPmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Prhmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignPrhmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Prhmax as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Prhmax to the parent entity
    // ------------------------------------------
    parentEntity.setPrhmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Prhmax
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignPrhmax(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Prhmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Prhmax on the parent entithy
    // ------------------------------------------
    parentEntity.setPrhmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Simx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignSimx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Simx as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Simx to the parent entity
    // ------------------------------------------
    parentEntity.setSimx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Simx
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignSimx(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Simx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Simx on the parent entithy
    // ------------------------------------------
    parentEntity.setSimx(null);

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
   * @return	GovSteamEU
   */
  public GovSteamEU assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignTb(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

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
   * Assign a Tdp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamEU
   */
  public GovSteamEU assignTdp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tdp as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tdp to the parent entity
    // ------------------------------------------
    parentEntity.setTdp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tdp
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignTdp(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tdp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tdp on the parent entithy
    // ------------------------------------------
    parentEntity.setTdp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ten
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamEU
   */
  public GovSteamEU assignTen(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ten as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ten to the parent entity
    // ------------------------------------------
    parentEntity.setTen(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ten
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignTen(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ten on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ten on the parent entithy
    // ------------------------------------------
    parentEntity.setTen(null);

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
   * @return	GovSteamEU
   */
  public GovSteamEU assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
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
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignTf(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

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
   * Assign a Tfp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamEU
   */
  public GovSteamEU assignTfp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tfp as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tfp to the parent entity
    // ------------------------------------------
    parentEntity.setTfp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tfp
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignTfp(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tfp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tfp on the parent entithy
    // ------------------------------------------
    parentEntity.setTfp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Thp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamEU
   */
  public GovSteamEU assignThp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Thp as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Thp to the parent entity
    // ------------------------------------------
    parentEntity.setThp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Thp
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignThp(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Thp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Thp on the parent entithy
    // ------------------------------------------
    parentEntity.setThp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tip
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamEU
   */
  public GovSteamEU assignTip(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tip as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tip to the parent entity
    // ------------------------------------------
    parentEntity.setTip(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tip
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignTip(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tip on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tip on the parent entithy
    // ------------------------------------------
    parentEntity.setTip(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tlp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamEU
   */
  public GovSteamEU assignTlp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tlp as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tlp to the parent entity
    // ------------------------------------------
    parentEntity.setTlp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tlp
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignTlp(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tlp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tlp on the parent entithy
    // ------------------------------------------
    parentEntity.setTlp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamEU
   */
  public GovSteamEU assignTp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tp as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tp to the parent entity
    // ------------------------------------------
    parentEntity.setTp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tp
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignTp(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tp on the parent entithy
    // ------------------------------------------
    parentEntity.setTp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Trh
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamEU
   */
  public GovSteamEU assignTrh(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Trh as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Trh to the parent entity
    // ------------------------------------------
    parentEntity.setTrh(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Trh
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignTrh(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Trh on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Trh on the parent entithy
    // ------------------------------------------
    parentEntity.setTrh(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tvhp
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamEU
   */
  public GovSteamEU assignTvhp(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tvhp as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tvhp to the parent entity
    // ------------------------------------------
    parentEntity.setTvhp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tvhp
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignTvhp(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tvhp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tvhp on the parent entithy
    // ------------------------------------------
    parentEntity.setTvhp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tvip
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamEU
   */
  public GovSteamEU assignTvip(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tvip as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tvip to the parent entity
    // ------------------------------------------
    parentEntity.setTvip(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tvip
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignTvip(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tvip on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tvip on the parent entithy
    // ------------------------------------------
    parentEntity.setTvip(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tw
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovSteamEU
   */
  public GovSteamEU assignTw(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tw to the parent entity
    // ------------------------------------------
    parentEntity.setTw(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tw
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignTw(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tw on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tw on the parent entithy
    // ------------------------------------------
    parentEntity.setTw(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Wfmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignWfmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Wfmax as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Wfmax to the parent entity
    // ------------------------------------------
    parentEntity.setWfmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Wfmax
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignWfmax(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Wfmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Wfmax on the parent entithy
    // ------------------------------------------
    parentEntity.setWfmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Wfmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignWfmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Wfmin as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Wfmin to the parent entity
    // ------------------------------------------
    parentEntity.setWfmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Wfmin
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignWfmin(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Wfmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Wfmin on the parent entithy
    // ------------------------------------------
    parentEntity.setWfmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Wmax1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignWmax1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Wmax1 as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Wmax1 to the parent entity
    // ------------------------------------------
    parentEntity.setWmax1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Wmax1
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignWmax1(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Wmax1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Wmax1 on the parent entithy
    // ------------------------------------------
    parentEntity.setWmax1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Wmax2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignWmax2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Wmax2 as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Wmax2 to the parent entity
    // ------------------------------------------
    parentEntity.setWmax2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Wmax2
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignWmax2(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Wmax2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Wmax2 on the parent entithy
    // ------------------------------------------
    parentEntity.setWmax2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Wwmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignWwmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Wwmax as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Wwmax to the parent entity
    // ------------------------------------------
    parentEntity.setWwmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Wwmax
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignWwmax(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Wwmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Wwmax on the parent entithy
    // ------------------------------------------
    parentEntity.setWwmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Wwmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovSteamEU
   */
  public GovSteamEU assignWwmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Wwmin as " + assignment.toString());

    GovSteamEU parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Wwmin to the parent entity
    // ------------------------------------------
    parentEntity.setWwmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Wwmin
   *
   * @param	parentId		UUID
   * @return	GovSteamEU
   */
  public GovSteamEU unAssignWwmin(UUID parentId) {
    GovSteamEU parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Wwmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Wwmin on the parent entithy
    // ------------------------------------------
    parentEntity.setWwmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovSteamEU via an FindGovSteamEUQuery
   *
   * @return query FindGovSteamEUQuery
   */
  @SuppressWarnings("unused")
  public GovSteamEU find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovSteamEU - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovSteamEUs
   *
   * @param query FindAllGovSteamEUQuery
   * @return List<GovSteamEU>
   */
  @SuppressWarnings("unused")
  public List<GovSteamEU> findAll(FindAllGovSteamEUQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovSteamEU - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovSteamEURepository repository;

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
  @Qualifier(value = "activePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ActivePowerEntityProjector
      ActivePowerProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(GovSteamEUEntityProjector.class.getName());
}
