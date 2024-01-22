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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for ProprietaryParameterDynamics as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ProprietaryParameterDynamicsAggregate
 *
 * @author your_name_here
 */
@Component("proprietaryParameterDynamics-entity-projector")
public class ProprietaryParameterDynamicsEntityProjector {

  // core constructor
  public ProprietaryParameterDynamicsEntityProjector(
      ProprietaryParameterDynamicsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ProprietaryParameterDynamics
   *
   * @param	entity ProprietaryParameterDynamics
   */
  public ProprietaryParameterDynamics create(ProprietaryParameterDynamics entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ProprietaryParameterDynamics
   *
   * @param	entity ProprietaryParameterDynamics
   */
  public ProprietaryParameterDynamics update(ProprietaryParameterDynamics entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ProprietaryParameterDynamics
   *
   * @param	id		UUID
   */
  public ProprietaryParameterDynamics delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ProprietaryParameterDynamics entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a BooleanParameterValue
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ProprietaryParameterDynamics
   */
  public ProprietaryParameterDynamics assignBooleanParameterValue(
      UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning BooleanParameterValue as " + assignment.toString());

    ProprietaryParameterDynamics parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the BooleanParameterValue to the parent entity
    // ------------------------------------------
    parentEntity.setBooleanParameterValue(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the BooleanParameterValue
   *
   * @param	parentId		UUID
   * @return	ProprietaryParameterDynamics
   */
  public ProprietaryParameterDynamics unAssignBooleanParameterValue(UUID parentId) {
    ProprietaryParameterDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning BooleanParameterValue on " + parentEntity.toString());

    // ------------------------------------------
    // null out the BooleanParameterValue on the parent entithy
    // ------------------------------------------
    parentEntity.setBooleanParameterValue(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a FloatParameterValue
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ProprietaryParameterDynamics
   */
  public ProprietaryParameterDynamics assignFloatParameterValue(
      UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning FloatParameterValue as " + assignment.toString());

    ProprietaryParameterDynamics parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the FloatParameterValue to the parent entity
    // ------------------------------------------
    parentEntity.setFloatParameterValue(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the FloatParameterValue
   *
   * @param	parentId		UUID
   * @return	ProprietaryParameterDynamics
   */
  public ProprietaryParameterDynamics unAssignFloatParameterValue(UUID parentId) {
    ProprietaryParameterDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning FloatParameterValue on " + parentEntity.toString());

    // ------------------------------------------
    // null out the FloatParameterValue on the parent entithy
    // ------------------------------------------
    parentEntity.setFloatParameterValue(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a IntegerParameterValue
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	ProprietaryParameterDynamics
   */
  public ProprietaryParameterDynamics assignIntegerParameterValue(
      UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning IntegerParameterValue as " + assignment.toString());

    ProprietaryParameterDynamics parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the IntegerParameterValue to the parent entity
    // ------------------------------------------
    parentEntity.setIntegerParameterValue(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the IntegerParameterValue
   *
   * @param	parentId		UUID
   * @return	ProprietaryParameterDynamics
   */
  public ProprietaryParameterDynamics unAssignIntegerParameterValue(UUID parentId) {
    ProprietaryParameterDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning IntegerParameterValue on " + parentEntity.toString());

    // ------------------------------------------
    // null out the IntegerParameterValue on the parent entithy
    // ------------------------------------------
    parentEntity.setIntegerParameterValue(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ParameterNumber
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	ProprietaryParameterDynamics
   */
  public ProprietaryParameterDynamics assignParameterNumber(
      UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning ParameterNumber as " + assignment.toString());

    ProprietaryParameterDynamics parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the ParameterNumber to the parent entity
    // ------------------------------------------
    parentEntity.setParameterNumber(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ParameterNumber
   *
   * @param	parentId		UUID
   * @return	ProprietaryParameterDynamics
   */
  public ProprietaryParameterDynamics unAssignParameterNumber(UUID parentId) {
    ProprietaryParameterDynamics parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ParameterNumber on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ParameterNumber on the parent entithy
    // ------------------------------------------
    parentEntity.setParameterNumber(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the ProprietaryParameterDynamics
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	ProprietaryParameterDynamics
   */
  public ProprietaryParameterDynamics addToProprietaryParameterDynamics(
      UUID parentId, ProprietaryParameterDynamics addTo) {
    LOGGER.info(
        "handling AssignProprietaryParameterDynamicsToProprietaryParameterDynamicsEvent - ");

    ProprietaryParameterDynamics parentEntity = repository.findById(parentId).get();
    ProprietaryParameterDynamics child =
        ProprietaryParameterDynamicsProjector.find(addTo.getProprietaryParameterDynamicsId());

    parentEntity.getProprietaryParameterDynamics().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the ProprietaryParameterDynamics
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	ProprietaryParameterDynamics
   */
  public ProprietaryParameterDynamics removeFromProprietaryParameterDynamics(
      UUID parentId, ProprietaryParameterDynamics removeFrom) {
    LOGGER.info(
        "handling RemoveProprietaryParameterDynamicsFromProprietaryParameterDynamicsEvent ");

    ProprietaryParameterDynamics parentEntity = repository.findById(parentId).get();
    ProprietaryParameterDynamics child =
        ProprietaryParameterDynamicsProjector.find(removeFrom.getProprietaryParameterDynamicsId());

    parentEntity.getProprietaryParameterDynamics().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ProprietaryParameterDynamics via an
   * FindProprietaryParameterDynamicsQuery
   *
   * @return query FindProprietaryParameterDynamicsQuery
   */
  @SuppressWarnings("unused")
  public ProprietaryParameterDynamics find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find a ProprietaryParameterDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ProprietaryParameterDynamicss
   *
   * @param query FindAllProprietaryParameterDynamicsQuery
   * @return List<ProprietaryParameterDynamics>
   */
  @SuppressWarnings("unused")
  public List<ProprietaryParameterDynamics> findAll(
      FindAllProprietaryParameterDynamicsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(
          Level.WARNING, "Failed to find all ProprietaryParameterDynamics - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ProprietaryParameterDynamicsRepository repository;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .BooleanProxyEntityProjector
      BooleanProxyProjector;

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

  @Autowired
  @Qualifier(value = "proprietaryParameterDynamics-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels
          .projector.ProprietaryParameterDynamicsEntityProjector
      ProprietaryParameterDynamicsProjector;

  private static final Logger LOGGER =
      Logger.getLogger(ProprietaryParameterDynamicsEntityProjector.class.getName());
}
