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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for DiscExcContIEEEDEC1A as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DiscExcContIEEEDEC1AAggregate
 *
 * @author your_name_here
 */
@Component("discExcContIEEEDEC1A-entity-projector")
public class DiscExcContIEEEDEC1AEntityProjector {

  // core constructor
  public DiscExcContIEEEDEC1AEntityProjector(DiscExcContIEEEDEC1ARepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DiscExcContIEEEDEC1A
   *
   * @param	entity DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A create(DiscExcContIEEEDEC1A entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DiscExcContIEEEDEC1A
   *
   * @param	entity DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A update(DiscExcContIEEEDEC1A entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DiscExcContIEEEDEC1A
   *
   * @param	id		UUID
   */
  public DiscExcContIEEEDEC1A delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DiscExcContIEEEDEC1A entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Esc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignEsc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Esc as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Esc to the parent entity
    // ------------------------------------------
    parentEntity.setEsc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Esc
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignEsc(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Esc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Esc on the parent entithy
    // ------------------------------------------
    parentEntity.setEsc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kan
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignKan(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kan as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kan to the parent entity
    // ------------------------------------------
    parentEntity.setKan(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kan
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignKan(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kan on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kan on the parent entithy
    // ------------------------------------------
    parentEntity.setKan(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ketl
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignKetl(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ketl as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ketl to the parent entity
    // ------------------------------------------
    parentEntity.setKetl(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ketl
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignKetl(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ketl on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ketl on the parent entithy
    // ------------------------------------------
    parentEntity.setKetl(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tan
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignTan(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tan as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tan to the parent entity
    // ------------------------------------------
    parentEntity.setTan(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tan
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignTan(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tan on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tan on the parent entithy
    // ------------------------------------------
    parentEntity.setTan(null);

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
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignTd(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Td as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
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
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignTd(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

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
   * Assign a Tl1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignTl1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl1 as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
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
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignTl1(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

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
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignTl2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tl2 as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
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
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignTl2(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

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
   * Assign a Tw5
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignTw5(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tw5 as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tw5 to the parent entity
    // ------------------------------------------
    parentEntity.setTw5(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tw5
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignTw5(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tw5 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tw5 on the parent entithy
    // ------------------------------------------
    parentEntity.setTw5(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Value
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignValue(UUID parentId, PU assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Value to the parent entity
    // ------------------------------------------
    parentEntity.setValue(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Value
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignValue(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Value on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Value on the parent entithy
    // ------------------------------------------
    parentEntity.setValue(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vanmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignVanmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vanmax as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vanmax to the parent entity
    // ------------------------------------------
    parentEntity.setVanmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vanmax
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignVanmax(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vanmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vanmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVanmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vomax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignVomax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vomax as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vomax to the parent entity
    // ------------------------------------------
    parentEntity.setVomax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vomax
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignVomax(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vomax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vomax on the parent entithy
    // ------------------------------------------
    parentEntity.setVomax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vomin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignVomin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vomin as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vomin to the parent entity
    // ------------------------------------------
    parentEntity.setVomin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vomin
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignVomin(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vomin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vomin on the parent entithy
    // ------------------------------------------
    parentEntity.setVomin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vsmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignVsmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vsmax as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vsmax to the parent entity
    // ------------------------------------------
    parentEntity.setVsmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vsmax
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignVsmax(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vsmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vsmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVsmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vsmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignVsmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vsmin as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vsmin to the parent entity
    // ------------------------------------------
    parentEntity.setVsmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vsmin
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignVsmin(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vsmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vsmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVsmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vtc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignVtc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vtc as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vtc to the parent entity
    // ------------------------------------------
    parentEntity.setVtc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vtc
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignVtc(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vtc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vtc on the parent entithy
    // ------------------------------------------
    parentEntity.setVtc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vtlmt
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignVtlmt(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vtlmt as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vtlmt to the parent entity
    // ------------------------------------------
    parentEntity.setVtlmt(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vtlmt
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignVtlmt(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vtlmt on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vtlmt on the parent entithy
    // ------------------------------------------
    parentEntity.setVtlmt(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vtm
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignVtm(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vtm as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vtm to the parent entity
    // ------------------------------------------
    parentEntity.setVtm(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vtm
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignVtm(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vtm on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vtm on the parent entithy
    // ------------------------------------------
    parentEntity.setVtm(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vtn
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A assignVtn(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vtn as " + assignment.toString());

    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vtn to the parent entity
    // ------------------------------------------
    parentEntity.setVtn(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vtn
   *
   * @param	parentId		UUID
   * @return	DiscExcContIEEEDEC1A
   */
  public DiscExcContIEEEDEC1A unAssignVtn(UUID parentId) {
    DiscExcContIEEEDEC1A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vtn on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vtn on the parent entithy
    // ------------------------------------------
    parentEntity.setVtn(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the DiscExcContIEEEDEC1A via an FindDiscExcContIEEEDEC1AQuery
   *
   * @return query FindDiscExcContIEEEDEC1AQuery
   */
  @SuppressWarnings("unused")
  public DiscExcContIEEEDEC1A find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DiscExcContIEEEDEC1A - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DiscExcContIEEEDEC1As
   *
   * @param query FindAllDiscExcContIEEEDEC1AQuery
   * @return List<DiscExcContIEEEDEC1A>
   */
  @SuppressWarnings("unused")
  public List<DiscExcContIEEEDEC1A> findAll(FindAllDiscExcContIEEEDEC1AQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DiscExcContIEEEDEC1A - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DiscExcContIEEEDEC1ARepository repository;

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

  private static final Logger LOGGER =
      Logger.getLogger(DiscExcContIEEEDEC1AEntityProjector.class.getName());
}
