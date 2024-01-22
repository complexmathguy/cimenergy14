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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for DCLineSegment as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by DCLineSegmentAggregate
 *
 * @author your_name_here
 */
@Component("dCLineSegment-entity-projector")
public class DCLineSegmentEntityProjector {

  // core constructor
  public DCLineSegmentEntityProjector(DCLineSegmentRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a DCLineSegment
   *
   * @param	entity DCLineSegment
   */
  public DCLineSegment create(DCLineSegment entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a DCLineSegment
   *
   * @param	entity DCLineSegment
   */
  public DCLineSegment update(DCLineSegment entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a DCLineSegment
   *
   * @param	id		UUID
   */
  public DCLineSegment delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    DCLineSegment entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Capacitance
   *
   * @param	parentId	UUID
   * @param	assignment 	Capacitance
   * @return	DCLineSegment
   */
  public DCLineSegment assignCapacitance(UUID parentId, Capacitance assignment) {
    LOGGER.info("assigning Capacitance as " + assignment.toString());

    DCLineSegment parentEntity = repository.findById(parentId).get();
    assignment = CapacitanceProjector.find(assignment.getCapacitanceId());

    // ------------------------------------------
    // assign the Capacitance to the parent entity
    // ------------------------------------------
    parentEntity.setCapacitance(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Capacitance
   *
   * @param	parentId		UUID
   * @return	DCLineSegment
   */
  public DCLineSegment unAssignCapacitance(UUID parentId) {
    DCLineSegment parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Capacitance on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Capacitance on the parent entithy
    // ------------------------------------------
    parentEntity.setCapacitance(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Inductance
   *
   * @param	parentId	UUID
   * @param	assignment 	Inductance
   * @return	DCLineSegment
   */
  public DCLineSegment assignInductance(UUID parentId, Inductance assignment) {
    LOGGER.info("assigning Inductance as " + assignment.toString());

    DCLineSegment parentEntity = repository.findById(parentId).get();
    assignment = InductanceProjector.find(assignment.getInductanceId());

    // ------------------------------------------
    // assign the Inductance to the parent entity
    // ------------------------------------------
    parentEntity.setInductance(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Inductance
   *
   * @param	parentId		UUID
   * @return	DCLineSegment
   */
  public DCLineSegment unAssignInductance(UUID parentId) {
    DCLineSegment parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Inductance on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Inductance on the parent entithy
    // ------------------------------------------
    parentEntity.setInductance(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Length
   *
   * @param	parentId	UUID
   * @param	assignment 	Length
   * @return	DCLineSegment
   */
  public DCLineSegment assignLength(UUID parentId, Length assignment) {
    LOGGER.info("assigning Length as " + assignment.toString());

    DCLineSegment parentEntity = repository.findById(parentId).get();
    assignment = LengthProjector.find(assignment.getLengthId());

    // ------------------------------------------
    // assign the Length to the parent entity
    // ------------------------------------------
    parentEntity.setLength(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Length
   *
   * @param	parentId		UUID
   * @return	DCLineSegment
   */
  public DCLineSegment unAssignLength(UUID parentId) {
    DCLineSegment parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Length on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Length on the parent entithy
    // ------------------------------------------
    parentEntity.setLength(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Resistance
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	DCLineSegment
   */
  public DCLineSegment assignResistance(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning Resistance as " + assignment.toString());

    DCLineSegment parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the Resistance to the parent entity
    // ------------------------------------------
    parentEntity.setResistance(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Resistance
   *
   * @param	parentId		UUID
   * @return	DCLineSegment
   */
  public DCLineSegment unAssignResistance(UUID parentId) {
    DCLineSegment parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Resistance on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Resistance on the parent entithy
    // ------------------------------------------
    parentEntity.setResistance(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the DCLineSegments
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	DCLineSegment
   */
  public DCLineSegment addToDCLineSegments(UUID parentId, DCLineSegment addTo) {
    LOGGER.info("handling AssignDCLineSegmentsToDCLineSegmentEvent - ");

    DCLineSegment parentEntity = repository.findById(parentId).get();
    DCLineSegment child = DCLineSegmentProjector.find(addTo.getDCLineSegmentId());

    parentEntity.getDCLineSegments().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the DCLineSegments
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	DCLineSegment
   */
  public DCLineSegment removeFromDCLineSegments(UUID parentId, DCLineSegment removeFrom) {
    LOGGER.info("handling RemoveDCLineSegmentsFromDCLineSegmentEvent ");

    DCLineSegment parentEntity = repository.findById(parentId).get();
    DCLineSegment child = DCLineSegmentProjector.find(removeFrom.getDCLineSegmentId());

    parentEntity.getDCLineSegments().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the DCLineSegment via an FindDCLineSegmentQuery
   *
   * @return query FindDCLineSegmentQuery
   */
  @SuppressWarnings("unused")
  public DCLineSegment find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a DCLineSegment - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all DCLineSegments
   *
   * @param query FindAllDCLineSegmentQuery
   * @return List<DCLineSegment>
   */
  @SuppressWarnings("unused")
  public List<DCLineSegment> findAll(FindAllDCLineSegmentQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all DCLineSegment - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final DCLineSegmentRepository repository;

  @Autowired
  @Qualifier(value = "capacitance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .CapacitanceEntityProjector
      CapacitanceProjector;

  @Autowired
  @Qualifier(value = "inductance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .InductanceEntityProjector
      InductanceProjector;

  @Autowired
  @Qualifier(value = "length-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .LengthEntityProjector
      LengthProjector;

  @Autowired
  @Qualifier(value = "resistance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ResistanceEntityProjector
      ResistanceProjector;

  @Autowired
  @Qualifier(value = "dCLineSegment-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .DCLineSegmentEntityProjector
      DCLineSegmentProjector;

  private static final Logger LOGGER =
      Logger.getLogger(DCLineSegmentEntityProjector.class.getName());
}
