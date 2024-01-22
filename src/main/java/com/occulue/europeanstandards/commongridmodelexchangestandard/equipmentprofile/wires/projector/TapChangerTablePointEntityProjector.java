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
 * Projector for TapChangerTablePoint as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by TapChangerTablePointAggregate
 *
 * @author your_name_here
 */
@Component("tapChangerTablePoint-entity-projector")
public class TapChangerTablePointEntityProjector {

  // core constructor
  public TapChangerTablePointEntityProjector(TapChangerTablePointRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a TapChangerTablePoint
   *
   * @param	entity TapChangerTablePoint
   */
  public TapChangerTablePoint create(TapChangerTablePoint entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a TapChangerTablePoint
   *
   * @param	entity TapChangerTablePoint
   */
  public TapChangerTablePoint update(TapChangerTablePoint entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a TapChangerTablePoint
   *
   * @param	id		UUID
   */
  public TapChangerTablePoint delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    TapChangerTablePoint entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a B
   *
   * @param	parentId	UUID
   * @param	assignment 	PerCent
   * @return	TapChangerTablePoint
   */
  public TapChangerTablePoint assignB(UUID parentId, PerCent assignment) {
    LOGGER.info("assigning B as " + assignment.toString());

    TapChangerTablePoint parentEntity = repository.findById(parentId).get();
    assignment = PerCentProjector.find(assignment.getPerCentId());

    // ------------------------------------------
    // assign the B to the parent entity
    // ------------------------------------------
    parentEntity.setB(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the B
   *
   * @param	parentId		UUID
   * @return	TapChangerTablePoint
   */
  public TapChangerTablePoint unAssignB(UUID parentId) {
    TapChangerTablePoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning B on " + parentEntity.toString());

    // ------------------------------------------
    // null out the B on the parent entithy
    // ------------------------------------------
    parentEntity.setB(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a G
   *
   * @param	parentId	UUID
   * @param	assignment 	PerCent
   * @return	TapChangerTablePoint
   */
  public TapChangerTablePoint assignG(UUID parentId, PerCent assignment) {
    LOGGER.info("assigning G as " + assignment.toString());

    TapChangerTablePoint parentEntity = repository.findById(parentId).get();
    assignment = PerCentProjector.find(assignment.getPerCentId());

    // ------------------------------------------
    // assign the G to the parent entity
    // ------------------------------------------
    parentEntity.setG(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the G
   *
   * @param	parentId		UUID
   * @return	TapChangerTablePoint
   */
  public TapChangerTablePoint unAssignG(UUID parentId) {
    TapChangerTablePoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning G on " + parentEntity.toString());

    // ------------------------------------------
    // null out the G on the parent entithy
    // ------------------------------------------
    parentEntity.setG(null);

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
   * @param	assignment 	PerCent
   * @return	TapChangerTablePoint
   */
  public TapChangerTablePoint assignR(UUID parentId, PerCent assignment) {
    LOGGER.info("assigning R as " + assignment.toString());

    TapChangerTablePoint parentEntity = repository.findById(parentId).get();
    assignment = PerCentProjector.find(assignment.getPerCentId());

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
   * @return	TapChangerTablePoint
   */
  public TapChangerTablePoint unAssignR(UUID parentId) {
    TapChangerTablePoint parentEntity = repository.findById(parentId).get();

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
   * Assign a Ratio
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	TapChangerTablePoint
   */
  public TapChangerTablePoint assignRatio(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Ratio as " + assignment.toString());

    TapChangerTablePoint parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Ratio to the parent entity
    // ------------------------------------------
    parentEntity.setRatio(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ratio
   *
   * @param	parentId		UUID
   * @return	TapChangerTablePoint
   */
  public TapChangerTablePoint unAssignRatio(UUID parentId) {
    TapChangerTablePoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ratio on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ratio on the parent entithy
    // ------------------------------------------
    parentEntity.setRatio(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Step
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	TapChangerTablePoint
   */
  public TapChangerTablePoint assignStep(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning Step as " + assignment.toString());

    TapChangerTablePoint parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the Step to the parent entity
    // ------------------------------------------
    parentEntity.setStep(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Step
   *
   * @param	parentId		UUID
   * @return	TapChangerTablePoint
   */
  public TapChangerTablePoint unAssignStep(UUID parentId) {
    TapChangerTablePoint parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Step on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Step on the parent entithy
    // ------------------------------------------
    parentEntity.setStep(null);

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
   * @param	assignment 	PerCent
   * @return	TapChangerTablePoint
   */
  public TapChangerTablePoint assignX(UUID parentId, PerCent assignment) {
    LOGGER.info("assigning X as " + assignment.toString());

    TapChangerTablePoint parentEntity = repository.findById(parentId).get();
    assignment = PerCentProjector.find(assignment.getPerCentId());

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
   * @return	TapChangerTablePoint
   */
  public TapChangerTablePoint unAssignX(UUID parentId) {
    TapChangerTablePoint parentEntity = repository.findById(parentId).get();

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

  /**
   * Method to retrieve the TapChangerTablePoint via an FindTapChangerTablePointQuery
   *
   * @return query FindTapChangerTablePointQuery
   */
  @SuppressWarnings("unused")
  public TapChangerTablePoint find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a TapChangerTablePoint - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all TapChangerTablePoints
   *
   * @param query FindAllTapChangerTablePointQuery
   * @return List<TapChangerTablePoint>
   */
  @SuppressWarnings("unused")
  public List<TapChangerTablePoint> findAll(FindAllTapChangerTablePointQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all TapChangerTablePoint - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final TapChangerTablePointRepository repository;

  @Autowired
  @Qualifier(value = "perCent-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .PerCentEntityProjector
      PerCentProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .Simple_FloatEntityProjector
      Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  private static final Logger LOGGER =
      Logger.getLogger(TapChangerTablePointEntityProjector.class.getName());
}
