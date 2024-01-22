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
 * Projector for GovGAST3 as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovGAST3Aggregate
 *
 * @author your_name_here
 */
@Component("govGAST3-entity-projector")
public class GovGAST3EntityProjector {

  // core constructor
  public GovGAST3EntityProjector(GovGAST3Repository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovGAST3
   *
   * @param	entity GovGAST3
   */
  public GovGAST3 create(GovGAST3 entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovGAST3
   *
   * @param	entity GovGAST3
   */
  public GovGAST3 update(GovGAST3 entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovGAST3
   *
   * @param	id		UUID
   */
  public GovGAST3 delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovGAST3 entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Bca
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovGAST3
   */
  public GovGAST3 assignBca(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Bca as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Bca to the parent entity
    // ------------------------------------------
    parentEntity.setBca(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bca
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignBca(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bca on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bca on the parent entithy
    // ------------------------------------------
    parentEntity.setBca(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Bp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGAST3
   */
  public GovGAST3 assignBp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Bp as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST3
   */
  public GovGAST3 unAssignBp(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Dtc
   *
   * @param	parentId	UUID
   * @param	assignment 	Temperature
   * @return	GovGAST3
   */
  public GovGAST3 assignDtc(UUID parentId, Temperature assignment) {
    LOGGER.info("assigning Dtc as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = TemperatureProjector.find(assignment.getTemperatureId());

    // ------------------------------------------
    // assign the Dtc to the parent entity
    // ------------------------------------------
    parentEntity.setDtc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Dtc
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignDtc(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Dtc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Dtc on the parent entithy
    // ------------------------------------------
    parentEntity.setDtc(null);

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
   * @return	GovGAST3
   */
  public GovGAST3 assignKa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST3
   */
  public GovGAST3 unAssignKa(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Kac
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovGAST3
   */
  public GovGAST3 assignKac(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kac as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kac to the parent entity
    // ------------------------------------------
    parentEntity.setKac(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kac
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignKac(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kac on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kac on the parent entithy
    // ------------------------------------------
    parentEntity.setKac(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kca
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovGAST3
   */
  public GovGAST3 assignKca(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Kca as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Kca to the parent entity
    // ------------------------------------------
    parentEntity.setKca(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kca
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignKca(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kca on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kca on the parent entithy
    // ------------------------------------------
    parentEntity.setKca(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ksi
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovGAST3
   */
  public GovGAST3 assignKsi(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ksi as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Ksi to the parent entity
    // ------------------------------------------
    parentEntity.setKsi(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ksi
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignKsi(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ksi on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ksi on the parent entithy
    // ------------------------------------------
    parentEntity.setKsi(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ky
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovGAST3
   */
  public GovGAST3 assignKy(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ky as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Ky to the parent entity
    // ------------------------------------------
    parentEntity.setKy(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ky
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignKy(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ky on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ky on the parent entithy
    // ------------------------------------------
    parentEntity.setKy(null);

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
   * @return	GovGAST3
   */
  public GovGAST3 assignMnef(UUID parentId, PU assignment) {
    LOGGER.info("assigning Mnef as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST3
   */
  public GovGAST3 unAssignMnef(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

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
   * @return	GovGAST3
   */
  public GovGAST3 assignMxef(UUID parentId, PU assignment) {
    LOGGER.info("assigning Mxef as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST3
   */
  public GovGAST3 unAssignMxef(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Rcmn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGAST3
   */
  public GovGAST3 assignRcmn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rcmn as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rcmn to the parent entity
    // ------------------------------------------
    parentEntity.setRcmn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rcmn
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignRcmn(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rcmn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rcmn on the parent entithy
    // ------------------------------------------
    parentEntity.setRcmn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Rcmx
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovGAST3
   */
  public GovGAST3 assignRcmx(UUID parentId, PU assignment) {
    LOGGER.info("assigning Rcmx as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Rcmx to the parent entity
    // ------------------------------------------
    parentEntity.setRcmx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Rcmx
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignRcmx(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Rcmx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Rcmx on the parent entithy
    // ------------------------------------------
    parentEntity.setRcmx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tac
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST3
   */
  public GovGAST3 assignTac(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tac as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tac to the parent entity
    // ------------------------------------------
    parentEntity.setTac(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tac
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignTac(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tac on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tac on the parent entithy
    // ------------------------------------------
    parentEntity.setTac(null);

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
   * @return	GovGAST3
   */
  public GovGAST3 assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
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
   * @return	GovGAST3
   */
  public GovGAST3 unAssignTc(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

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
   * Assign a Td
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST3
   */
  public GovGAST3 assignTd(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Td as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Td to the parent entity
    // ------------------------------------------
    parentEntity.setTd(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Td
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignTd(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Td on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Td on the parent entithy
    // ------------------------------------------
    parentEntity.setTd(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tfen
   *
   * @param	parentId	UUID
   * @param	assignment 	Temperature
   * @return	GovGAST3
   */
  public GovGAST3 assignTfen(UUID parentId, Temperature assignment) {
    LOGGER.info("assigning Tfen as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = TemperatureProjector.find(assignment.getTemperatureId());

    // ------------------------------------------
    // assign the Tfen to the parent entity
    // ------------------------------------------
    parentEntity.setTfen(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tfen
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignTfen(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tfen on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tfen on the parent entithy
    // ------------------------------------------
    parentEntity.setTfen(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tg
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST3
   */
  public GovGAST3 assignTg(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tg as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tg to the parent entity
    // ------------------------------------------
    parentEntity.setTg(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tg
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignTg(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tg on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tg on the parent entithy
    // ------------------------------------------
    parentEntity.setTg(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tsi
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST3
   */
  public GovGAST3 assignTsi(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tsi as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tsi to the parent entity
    // ------------------------------------------
    parentEntity.setTsi(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tsi
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignTsi(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tsi on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tsi on the parent entithy
    // ------------------------------------------
    parentEntity.setTsi(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tt
   *
   * @param	parentId	UUID
   * @param	assignment 	Temperature
   * @return	GovGAST3
   */
  public GovGAST3 assignTt(UUID parentId, Temperature assignment) {
    LOGGER.info("assigning Tt as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = TemperatureProjector.find(assignment.getTemperatureId());

    // ------------------------------------------
    // assign the Tt to the parent entity
    // ------------------------------------------
    parentEntity.setTt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tt
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignTt(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tt on the parent entithy
    // ------------------------------------------
    parentEntity.setTt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ttc
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST3
   */
  public GovGAST3 assignTtc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ttc as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ttc to the parent entity
    // ------------------------------------------
    parentEntity.setTtc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ttc
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignTtc(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ttc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ttc on the parent entithy
    // ------------------------------------------
    parentEntity.setTtc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ty
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovGAST3
   */
  public GovGAST3 assignTy(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ty as " + assignment.toString());

    GovGAST3 parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ty to the parent entity
    // ------------------------------------------
    parentEntity.setTy(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ty
   *
   * @param	parentId		UUID
   * @return	GovGAST3
   */
  public GovGAST3 unAssignTy(UUID parentId) {
    GovGAST3 parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ty on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ty on the parent entithy
    // ------------------------------------------
    parentEntity.setTy(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovGAST3 via an FindGovGAST3Query
   *
   * @return query FindGovGAST3Query
   */
  @SuppressWarnings("unused")
  public GovGAST3 find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovGAST3 - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovGAST3s
   *
   * @param query FindAllGovGAST3Query
   * @return List<GovGAST3>
   */
  @SuppressWarnings("unused")
  public List<GovGAST3> findAll(FindAllGovGAST3Query query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovGAST3 - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovGAST3Repository repository;

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
  @Qualifier(value = "temperature-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .TemperatureEntityProjector
      TemperatureProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SecondsEntityProjector
      SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(GovGAST3EntityProjector.class.getName());
}
