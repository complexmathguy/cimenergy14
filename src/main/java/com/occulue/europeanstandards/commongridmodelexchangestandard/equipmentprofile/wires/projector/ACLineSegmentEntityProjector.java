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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for ACLineSegment as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ACLineSegmentAggregate
 *
 * @author your_name_here
 */
@Component("aCLineSegment-entity-projector")
public class ACLineSegmentEntityProjector {

  // core constructor
  public ACLineSegmentEntityProjector(ACLineSegmentRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ACLineSegment
   *
   * @param	entity ACLineSegment
   */
  public ACLineSegment create(ACLineSegment entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ACLineSegment
   *
   * @param	entity ACLineSegment
   */
  public ACLineSegment update(ACLineSegment entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ACLineSegment
   *
   * @param	id		UUID
   */
  public ACLineSegment delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ACLineSegment entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a B0ch
   *
   * @param	parentId	UUID
   * @param	assignment 	Susceptance
   * @return	ACLineSegment
   */
  public ACLineSegment assignB0ch(UUID parentId, Susceptance assignment) {
    LOGGER.info("assigning B0ch as " + assignment.toString());

    ACLineSegment parentEntity = repository.findById(parentId).get();
    assignment = SusceptanceProjector.find(assignment.getSusceptanceId());

    // ------------------------------------------
    // assign the B0ch to the parent entity
    // ------------------------------------------
    parentEntity.setB0ch(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B0ch
   *
   * @param	parentId		UUID
   * @return	ACLineSegment
   */
  public ACLineSegment unAssignB0ch(UUID parentId) {
    ACLineSegment parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B0ch on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B0ch on the parent entithy
    // ------------------------------------------
    parentEntity.setB0ch(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Bch
   *
   * @param	parentId	UUID
   * @param	assignment 	Susceptance
   * @return	ACLineSegment
   */
  public ACLineSegment assignBch(UUID parentId, Susceptance assignment) {
    LOGGER.info("assigning Bch as " + assignment.toString());

    ACLineSegment parentEntity = repository.findById(parentId).get();
    assignment = SusceptanceProjector.find(assignment.getSusceptanceId());

    // ------------------------------------------
    // assign the Bch to the parent entity
    // ------------------------------------------
    parentEntity.setBch(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Bch
   *
   * @param	parentId		UUID
   * @return	ACLineSegment
   */
  public ACLineSegment unAssignBch(UUID parentId) {
    ACLineSegment parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Bch on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Bch on the parent entithy
    // ------------------------------------------
    parentEntity.setBch(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a G0ch
   *
   * @param	parentId	UUID
   * @param	assignment 	Conductance
   * @return	ACLineSegment
   */
  public ACLineSegment assignG0ch(UUID parentId, Conductance assignment) {
    LOGGER.info("assigning G0ch as " + assignment.toString());

    ACLineSegment parentEntity = repository.findById(parentId).get();
    assignment = ConductanceProjector.find(assignment.getConductanceId());

    // ------------------------------------------
    // assign the G0ch to the parent entity
    // ------------------------------------------
    parentEntity.setG0ch(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the G0ch
   *
   * @param	parentId		UUID
   * @return	ACLineSegment
   */
  public ACLineSegment unAssignG0ch(UUID parentId) {
    ACLineSegment parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning G0ch on " + parentEntity.toString());

    // ------------------------------------------
    // null out the G0ch on the parent entithy
    // ------------------------------------------
    parentEntity.setG0ch(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Gch
   *
   * @param	parentId	UUID
   * @param	assignment 	Conductance
   * @return	ACLineSegment
   */
  public ACLineSegment assignGch(UUID parentId, Conductance assignment) {
    LOGGER.info("assigning Gch as " + assignment.toString());

    ACLineSegment parentEntity = repository.findById(parentId).get();
    assignment = ConductanceProjector.find(assignment.getConductanceId());

    // ------------------------------------------
    // assign the Gch to the parent entity
    // ------------------------------------------
    parentEntity.setGch(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Gch
   *
   * @param	parentId		UUID
   * @return	ACLineSegment
   */
  public ACLineSegment unAssignGch(UUID parentId) {
    ACLineSegment parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Gch on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Gch on the parent entithy
    // ------------------------------------------
    parentEntity.setGch(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a R
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	ACLineSegment
   */
  public ACLineSegment assignR(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning R as " + assignment.toString());

    ACLineSegment parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the R to the parent entity
    // ------------------------------------------
    parentEntity.setR(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R
   *
   * @param	parentId		UUID
   * @return	ACLineSegment
   */
  public ACLineSegment unAssignR(UUID parentId) {
    ACLineSegment parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R on the parent entithy
    // ------------------------------------------
    parentEntity.setR(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a R0
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	ACLineSegment
   */
  public ACLineSegment assignR0(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning R0 as " + assignment.toString());

    ACLineSegment parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the R0 to the parent entity
    // ------------------------------------------
    parentEntity.setR0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the R0
   *
   * @param	parentId		UUID
   * @return	ACLineSegment
   */
  public ACLineSegment unAssignR0(UUID parentId) {
    ACLineSegment parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning R0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the R0 on the parent entithy
    // ------------------------------------------
    parentEntity.setR0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ShortCircuitEndTemperature
   *
   * @param	parentId	UUID
   * @param	assignment 	Temperature
   * @return	ACLineSegment
   */
  public ACLineSegment assignShortCircuitEndTemperature(UUID parentId, Temperature assignment) {
    LOGGER.info("assigning ShortCircuitEndTemperature as " + assignment.toString());

    ACLineSegment parentEntity = repository.findById(parentId).get();
    assignment = TemperatureProjector.find(assignment.getTemperatureId());

    // ------------------------------------------
    // assign the ShortCircuitEndTemperature to the parent entity
    // ------------------------------------------
    parentEntity.setShortCircuitEndTemperature(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ShortCircuitEndTemperature
   *
   * @param	parentId		UUID
   * @return	ACLineSegment
   */
  public ACLineSegment unAssignShortCircuitEndTemperature(UUID parentId) {
    ACLineSegment parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ShortCircuitEndTemperature on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ShortCircuitEndTemperature on the parent entithy
    // ------------------------------------------
    parentEntity.setShortCircuitEndTemperature(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a X
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	ACLineSegment
   */
  public ACLineSegment assignX(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning X as " + assignment.toString());

    ACLineSegment parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the X to the parent entity
    // ------------------------------------------
    parentEntity.setX(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X
   *
   * @param	parentId		UUID
   * @return	ACLineSegment
   */
  public ACLineSegment unAssignX(UUID parentId) {
    ACLineSegment parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X on the parent entithy
    // ------------------------------------------
    parentEntity.setX(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a X0
   *
   * @param	parentId	UUID
   * @param	assignment 	Reactance
   * @return	ACLineSegment
   */
  public ACLineSegment assignX0(UUID parentId, Reactance assignment) {
    LOGGER.info("assigning X0 as " + assignment.toString());

    ACLineSegment parentEntity = repository.findById(parentId).get();
    assignment = ReactanceProjector.find(assignment.getReactanceId());

    // ------------------------------------------
    // assign the X0 to the parent entity
    // ------------------------------------------
    parentEntity.setX0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the X0
   *
   * @param	parentId		UUID
   * @return	ACLineSegment
   */
  public ACLineSegment unAssignX0(UUID parentId) {
    ACLineSegment parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning X0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the X0 on the parent entithy
    // ------------------------------------------
    parentEntity.setX0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ACLineSegment via an FindACLineSegmentQuery
   *
   * @return query FindACLineSegmentQuery
   */
  @SuppressWarnings("unused")
  public ACLineSegment find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ACLineSegment - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ACLineSegments
   *
   * @param query FindAllACLineSegmentQuery
   * @return List<ACLineSegment>
   */
  @SuppressWarnings("unused")
  public List<ACLineSegment> findAll(FindAllACLineSegmentQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ACLineSegment - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ACLineSegmentRepository repository;

  @Autowired
  @Qualifier(value = "susceptance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .SusceptanceEntityProjector
      SusceptanceProjector;

  @Autowired
  @Qualifier(value = "conductance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ConductanceEntityProjector
      ConductanceProjector;

  @Autowired
  @Qualifier(value = "resistance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ResistanceEntityProjector
      ResistanceProjector;

  @Autowired
  @Qualifier(value = "temperature-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .TemperatureEntityProjector
      TemperatureProjector;

  @Autowired
  @Qualifier(value = "reactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ReactanceEntityProjector
      ReactanceProjector;

  private static final Logger LOGGER =
      Logger.getLogger(ACLineSegmentEntityProjector.class.getName());
}
