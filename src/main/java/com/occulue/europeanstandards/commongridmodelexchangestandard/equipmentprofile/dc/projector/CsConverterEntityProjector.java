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
 * Projector for CsConverter as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by CsConverterAggregate
 *
 * @author your_name_here
 */
@Component("csConverter-entity-projector")
public class CsConverterEntityProjector {

  // core constructor
  public CsConverterEntityProjector(CsConverterRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a CsConverter
   *
   * @param	entity CsConverter
   */
  public CsConverter create(CsConverter entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a CsConverter
   *
   * @param	entity CsConverter
   */
  public CsConverter update(CsConverter entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a CsConverter
   *
   * @param	id		UUID
   */
  public CsConverter delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    CsConverter entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a MaxAlpha
   *
   * @param	parentId	UUID
   * @param	assignment 	AngleDegrees
   * @return	CsConverter
   */
  public CsConverter assignMaxAlpha(UUID parentId, AngleDegrees assignment) {
    LOGGER.info("assigning MaxAlpha as " + assignment.toString());

    CsConverter parentEntity = repository.findById(parentId).get();
    assignment = AngleDegreesProjector.find(assignment.getAngleDegreesId());

    // ------------------------------------------
    // assign the MaxAlpha to the parent entity
    // ------------------------------------------
    parentEntity.setMaxAlpha(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaxAlpha
   *
   * @param	parentId		UUID
   * @return	CsConverter
   */
  public CsConverter unAssignMaxAlpha(UUID parentId) {
    CsConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaxAlpha on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaxAlpha on the parent entithy
    // ------------------------------------------
    parentEntity.setMaxAlpha(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MaxGamma
   *
   * @param	parentId	UUID
   * @param	assignment 	AngleDegrees
   * @return	CsConverter
   */
  public CsConverter assignMaxGamma(UUID parentId, AngleDegrees assignment) {
    LOGGER.info("assigning MaxGamma as " + assignment.toString());

    CsConverter parentEntity = repository.findById(parentId).get();
    assignment = AngleDegreesProjector.find(assignment.getAngleDegreesId());

    // ------------------------------------------
    // assign the MaxGamma to the parent entity
    // ------------------------------------------
    parentEntity.setMaxGamma(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaxGamma
   *
   * @param	parentId		UUID
   * @return	CsConverter
   */
  public CsConverter unAssignMaxGamma(UUID parentId) {
    CsConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaxGamma on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaxGamma on the parent entithy
    // ------------------------------------------
    parentEntity.setMaxGamma(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MaxIdc
   *
   * @param	parentId	UUID
   * @param	assignment 	CurrentFlow
   * @return	CsConverter
   */
  public CsConverter assignMaxIdc(UUID parentId, CurrentFlow assignment) {
    LOGGER.info("assigning MaxIdc as " + assignment.toString());

    CsConverter parentEntity = repository.findById(parentId).get();
    assignment = CurrentFlowProjector.find(assignment.getCurrentFlowId());

    // ------------------------------------------
    // assign the MaxIdc to the parent entity
    // ------------------------------------------
    parentEntity.setMaxIdc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaxIdc
   *
   * @param	parentId		UUID
   * @return	CsConverter
   */
  public CsConverter unAssignMaxIdc(UUID parentId) {
    CsConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaxIdc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaxIdc on the parent entithy
    // ------------------------------------------
    parentEntity.setMaxIdc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MinAlpha
   *
   * @param	parentId	UUID
   * @param	assignment 	AngleDegrees
   * @return	CsConverter
   */
  public CsConverter assignMinAlpha(UUID parentId, AngleDegrees assignment) {
    LOGGER.info("assigning MinAlpha as " + assignment.toString());

    CsConverter parentEntity = repository.findById(parentId).get();
    assignment = AngleDegreesProjector.find(assignment.getAngleDegreesId());

    // ------------------------------------------
    // assign the MinAlpha to the parent entity
    // ------------------------------------------
    parentEntity.setMinAlpha(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MinAlpha
   *
   * @param	parentId		UUID
   * @return	CsConverter
   */
  public CsConverter unAssignMinAlpha(UUID parentId) {
    CsConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MinAlpha on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MinAlpha on the parent entithy
    // ------------------------------------------
    parentEntity.setMinAlpha(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MinGamma
   *
   * @param	parentId	UUID
   * @param	assignment 	AngleDegrees
   * @return	CsConverter
   */
  public CsConverter assignMinGamma(UUID parentId, AngleDegrees assignment) {
    LOGGER.info("assigning MinGamma as " + assignment.toString());

    CsConverter parentEntity = repository.findById(parentId).get();
    assignment = AngleDegreesProjector.find(assignment.getAngleDegreesId());

    // ------------------------------------------
    // assign the MinGamma to the parent entity
    // ------------------------------------------
    parentEntity.setMinGamma(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MinGamma
   *
   * @param	parentId		UUID
   * @return	CsConverter
   */
  public CsConverter unAssignMinGamma(UUID parentId) {
    CsConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MinGamma on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MinGamma on the parent entithy
    // ------------------------------------------
    parentEntity.setMinGamma(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MinIdc
   *
   * @param	parentId	UUID
   * @param	assignment 	CurrentFlow
   * @return	CsConverter
   */
  public CsConverter assignMinIdc(UUID parentId, CurrentFlow assignment) {
    LOGGER.info("assigning MinIdc as " + assignment.toString());

    CsConverter parentEntity = repository.findById(parentId).get();
    assignment = CurrentFlowProjector.find(assignment.getCurrentFlowId());

    // ------------------------------------------
    // assign the MinIdc to the parent entity
    // ------------------------------------------
    parentEntity.setMinIdc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MinIdc
   *
   * @param	parentId		UUID
   * @return	CsConverter
   */
  public CsConverter unAssignMinIdc(UUID parentId) {
    CsConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MinIdc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MinIdc on the parent entithy
    // ------------------------------------------
    parentEntity.setMinIdc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a RatedIdc
   *
   * @param	parentId	UUID
   * @param	assignment 	CurrentFlow
   * @return	CsConverter
   */
  public CsConverter assignRatedIdc(UUID parentId, CurrentFlow assignment) {
    LOGGER.info("assigning RatedIdc as " + assignment.toString());

    CsConverter parentEntity = repository.findById(parentId).get();
    assignment = CurrentFlowProjector.find(assignment.getCurrentFlowId());

    // ------------------------------------------
    // assign the RatedIdc to the parent entity
    // ------------------------------------------
    parentEntity.setRatedIdc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RatedIdc
   *
   * @param	parentId		UUID
   * @return	CsConverter
   */
  public CsConverter unAssignRatedIdc(UUID parentId) {
    CsConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RatedIdc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RatedIdc on the parent entithy
    // ------------------------------------------
    parentEntity.setRatedIdc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the CsConverter via an FindCsConverterQuery
   *
   * @return query FindCsConverterQuery
   */
  @SuppressWarnings("unused")
  public CsConverter find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a CsConverter - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all CsConverters
   *
   * @param query FindAllCsConverterQuery
   * @return List<CsConverter>
   */
  @SuppressWarnings("unused")
  public List<CsConverter> findAll(FindAllCsConverterQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all CsConverter - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final CsConverterRepository repository;

  @Autowired
  @Qualifier(value = "angleDegrees-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .AngleDegreesEntityProjector
      AngleDegreesProjector;

  @Autowired
  @Qualifier(value = "currentFlow-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .CurrentFlowEntityProjector
      CurrentFlowProjector;

  private static final Logger LOGGER = Logger.getLogger(CsConverterEntityProjector.class.getName());
}
