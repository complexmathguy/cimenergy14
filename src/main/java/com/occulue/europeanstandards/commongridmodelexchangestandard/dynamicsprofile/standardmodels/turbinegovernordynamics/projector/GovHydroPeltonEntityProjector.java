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
 * Projector for GovHydroPelton as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by GovHydroPeltonAggregate
 *
 * @author your_name_here
 */
@Component("govHydroPelton-entity-projector")
public class GovHydroPeltonEntityProjector {

  // core constructor
  public GovHydroPeltonEntityProjector(GovHydroPeltonRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a GovHydroPelton
   *
   * @param	entity GovHydroPelton
   */
  public GovHydroPelton create(GovHydroPelton entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a GovHydroPelton
   *
   * @param	entity GovHydroPelton
   */
  public GovHydroPelton update(GovHydroPelton entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a GovHydroPelton
   *
   * @param	id		UUID
   */
  public GovHydroPelton delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    GovHydroPelton entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Av0
   *
   * @param	parentId	UUID
   * @param	assignment 	Area
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignAv0(UUID parentId, Area assignment) {
    LOGGER.info("assigning Av0 as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = AreaProjector.find(assignment.getAreaId());

    // ------------------------------------------
    // assign the Av0 to the parent entity
    // ------------------------------------------
    parentEntity.setAv0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Av0
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignAv0(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Av0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Av0 on the parent entithy
    // ------------------------------------------
    parentEntity.setAv0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Av1
   *
   * @param	parentId	UUID
   * @param	assignment 	Area
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignAv1(UUID parentId, Area assignment) {
    LOGGER.info("assigning Av1 as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = AreaProjector.find(assignment.getAreaId());

    // ------------------------------------------
    // assign the Av1 to the parent entity
    // ------------------------------------------
    parentEntity.setAv1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Av1
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignAv1(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Av1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Av1 on the parent entithy
    // ------------------------------------------
    parentEntity.setAv1(null);

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
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignBp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Bp as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignBp(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

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
   * Assign a Db1
   *
   * @param	parentId	UUID
   * @param	assignment 	Frequency
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignDb1(UUID parentId, Frequency assignment) {
    LOGGER.info("assigning Db1 as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = FrequencyProjector.find(assignment.getFrequencyId());

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
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignDb1(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

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
   * @param	assignment 	Frequency
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignDb2(UUID parentId, Frequency assignment) {
    LOGGER.info("assigning Db2 as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = FrequencyProjector.find(assignment.getFrequencyId());

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
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignDb2(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

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
   * Assign a H1
   *
   * @param	parentId	UUID
   * @param	assignment 	Length
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignH1(UUID parentId, Length assignment) {
    LOGGER.info("assigning H1 as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = LengthProjector.find(assignment.getLengthId());

    // ------------------------------------------
    // assign the H1 to the parent entity
    // ------------------------------------------
    parentEntity.setH1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the H1
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignH1(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning H1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the H1 on the parent entithy
    // ------------------------------------------
    parentEntity.setH1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a H2
   *
   * @param	parentId	UUID
   * @param	assignment 	Length
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignH2(UUID parentId, Length assignment) {
    LOGGER.info("assigning H2 as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = LengthProjector.find(assignment.getLengthId());

    // ------------------------------------------
    // assign the H2 to the parent entity
    // ------------------------------------------
    parentEntity.setH2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the H2
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignH2(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning H2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the H2 on the parent entithy
    // ------------------------------------------
    parentEntity.setH2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Hn
   *
   * @param	parentId	UUID
   * @param	assignment 	Length
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignHn(UUID parentId, Length assignment) {
    LOGGER.info("assigning Hn as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = LengthProjector.find(assignment.getLengthId());

    // ------------------------------------------
    // assign the Hn to the parent entity
    // ------------------------------------------
    parentEntity.setHn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Hn
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignHn(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Hn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Hn on the parent entithy
    // ------------------------------------------
    parentEntity.setHn(null);

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
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignKc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kc as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignKc(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

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
   * Assign a Kg
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignKg(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kg as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kg to the parent entity
    // ------------------------------------------
    parentEntity.setKg(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kg
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignKg(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kg on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kg on the parent entithy
    // ------------------------------------------
    parentEntity.setKg(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Qc0
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignQc0(UUID parentId, PU assignment) {
    LOGGER.info("assigning Qc0 as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Qc0 to the parent entity
    // ------------------------------------------
    parentEntity.setQc0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Qc0
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignQc0(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Qc0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Qc0 on the parent entithy
    // ------------------------------------------
    parentEntity.setQc0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Qn
   *
   * @param	parentId	UUID
   * @param	assignment 	VolumeFlowRate
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignQn(UUID parentId, VolumeFlowRate assignment) {
    LOGGER.info("assigning Qn as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = VolumeFlowRateProjector.find(assignment.getVolumeFlowRateId());

    // ------------------------------------------
    // assign the Qn to the parent entity
    // ------------------------------------------
    parentEntity.setQn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Qn
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignQn(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Qn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Qn on the parent entithy
    // ------------------------------------------
    parentEntity.setQn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SimplifiedPelton
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignSimplifiedPelton(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning SimplifiedPelton as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the SimplifiedPelton to the parent entity
    // ------------------------------------------
    parentEntity.setSimplifiedPelton(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SimplifiedPelton
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignSimplifiedPelton(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SimplifiedPelton on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SimplifiedPelton on the parent entithy
    // ------------------------------------------
    parentEntity.setSimplifiedPelton(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a StaticCompensating
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignStaticCompensating(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning StaticCompensating as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the StaticCompensating to the parent entity
    // ------------------------------------------
    parentEntity.setStaticCompensating(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the StaticCompensating
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignStaticCompensating(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning StaticCompensating on " + parentEntity.toString());

    // ------------------------------------------
    // null out the StaticCompensating on the parent entithy
    // ------------------------------------------
    parentEntity.setStaticCompensating(null);

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
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignTa(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

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
   * Assign a Ts
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignTs(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ts as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ts to the parent entity
    // ------------------------------------------
    parentEntity.setTs(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ts
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignTs(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ts on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ts on the parent entithy
    // ------------------------------------------
    parentEntity.setTs(null);

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
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignTv(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tv as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
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
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignTv(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

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

  /*
   * Assign a Twnc
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignTwnc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Twnc as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Twnc to the parent entity
    // ------------------------------------------
    parentEntity.setTwnc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Twnc
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignTwnc(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Twnc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Twnc on the parent entithy
    // ------------------------------------------
    parentEntity.setTwnc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Twng
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignTwng(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Twng as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Twng to the parent entity
    // ------------------------------------------
    parentEntity.setTwng(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Twng
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignTwng(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Twng on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Twng on the parent entithy
    // ------------------------------------------
    parentEntity.setTwng(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tx
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignTx(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tx as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tx to the parent entity
    // ------------------------------------------
    parentEntity.setTx(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tx
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignTx(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tx on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tx on the parent entithy
    // ------------------------------------------
    parentEntity.setTx(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Va
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignVa(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Va as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Va to the parent entity
    // ------------------------------------------
    parentEntity.setVa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Va
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignVa(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Va on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Va on the parent entithy
    // ------------------------------------------
    parentEntity.setVa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Valvmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignValvmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Valvmax as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Valvmax to the parent entity
    // ------------------------------------------
    parentEntity.setValvmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Valvmax
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignValvmax(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Valvmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Valvmax on the parent entithy
    // ------------------------------------------
    parentEntity.setValvmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Valvmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignValvmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Valvmin as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Valvmin to the parent entity
    // ------------------------------------------
    parentEntity.setValvmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Valvmin
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignValvmin(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Valvmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Valvmin on the parent entithy
    // ------------------------------------------
    parentEntity.setValvmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vav
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignVav(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vav as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vav to the parent entity
    // ------------------------------------------
    parentEntity.setVav(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vav
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignVav(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vav on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vav on the parent entithy
    // ------------------------------------------
    parentEntity.setVav(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vc
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignVc(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Vc as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Vc to the parent entity
    // ------------------------------------------
    parentEntity.setVc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vc
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignVc(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vc on the parent entithy
    // ------------------------------------------
    parentEntity.setVc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vcv
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignVcv(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vcv as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vcv to the parent entity
    // ------------------------------------------
    parentEntity.setVcv(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vcv
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignVcv(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vcv on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vcv on the parent entithy
    // ------------------------------------------
    parentEntity.setVcv(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a WaterTunnelSurgeChamberSimulation
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignWaterTunnelSurgeChamberSimulation(
      UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning WaterTunnelSurgeChamberSimulation as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the WaterTunnelSurgeChamberSimulation to the parent entity
    // ------------------------------------------
    parentEntity.setWaterTunnelSurgeChamberSimulation(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the WaterTunnelSurgeChamberSimulation
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignWaterTunnelSurgeChamberSimulation(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning WaterTunnelSurgeChamberSimulation on " + parentEntity.toString());

    // ------------------------------------------
    // null out the WaterTunnelSurgeChamberSimulation on the parent entithy
    // ------------------------------------------
    parentEntity.setWaterTunnelSurgeChamberSimulation(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Zsfc
   *
   * @param	parentId	UUID
   * @param	assignment 	Length
   * @return	GovHydroPelton
   */
  public GovHydroPelton assignZsfc(UUID parentId, Length assignment) {
    LOGGER.info("assigning Zsfc as " + assignment.toString());

    GovHydroPelton parentEntity = repository.findById(parentId).get();
    assignment = LengthProjector.find(assignment.getLengthId());

    // ------------------------------------------
    // assign the Zsfc to the parent entity
    // ------------------------------------------
    parentEntity.setZsfc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Zsfc
   *
   * @param	parentId		UUID
   * @return	GovHydroPelton
   */
  public GovHydroPelton unAssignZsfc(UUID parentId) {
    GovHydroPelton parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Zsfc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Zsfc on the parent entithy
    // ------------------------------------------
    parentEntity.setZsfc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the GovHydroPelton via an FindGovHydroPeltonQuery
   *
   * @return query FindGovHydroPeltonQuery
   */
  @SuppressWarnings("unused")
  public GovHydroPelton find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a GovHydroPelton - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all GovHydroPeltons
   *
   * @param query FindAllGovHydroPeltonQuery
   * @return List<GovHydroPelton>
   */
  @SuppressWarnings("unused")
  public List<GovHydroPelton> findAll(FindAllGovHydroPeltonQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all GovHydroPelton - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final GovHydroPeltonRepository repository;

  @Autowired
  @Qualifier(value = "area-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .AreaEntityProjector
      AreaProjector;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PUEntityProjector
      PUProjector;

  @Autowired
  @Qualifier(value = "frequency-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .FrequencyEntityProjector
      FrequencyProjector;

  @Autowired
  @Qualifier(value = "length-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .LengthEntityProjector
      LengthProjector;

  @Autowired
  @Qualifier(value = "volumeFlowRate-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .VolumeFlowRateEntityProjector
      VolumeFlowRateProjector;

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
      Logger.getLogger(GovHydroPeltonEntityProjector.class.getName());
}
