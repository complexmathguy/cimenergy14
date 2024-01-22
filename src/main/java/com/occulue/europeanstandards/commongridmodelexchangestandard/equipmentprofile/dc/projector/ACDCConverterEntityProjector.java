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
 * Projector for ACDCConverter as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ACDCConverterAggregate
 *
 * @author your_name_here
 */
@Component("aCDCConverter-entity-projector")
public class ACDCConverterEntityProjector {

  // core constructor
  public ACDCConverterEntityProjector(ACDCConverterRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ACDCConverter
   *
   * @param	entity ACDCConverter
   */
  public ACDCConverter create(ACDCConverter entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ACDCConverter
   *
   * @param	entity ACDCConverter
   */
  public ACDCConverter update(ACDCConverter entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ACDCConverter
   *
   * @param	id		UUID
   */
  public ACDCConverter delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ACDCConverter entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a BaseS
   *
   * @param	parentId	UUID
   * @param	assignment 	ApparentPower
   * @return	ACDCConverter
   */
  public ACDCConverter assignBaseS(UUID parentId, ApparentPower assignment) {
    LOGGER.info("assigning BaseS as " + assignment.toString());

    ACDCConverter parentEntity = repository.findById(parentId).get();
    assignment = ApparentPowerProjector.find(assignment.getApparentPowerId());

    // ------------------------------------------
    // assign the BaseS to the parent entity
    // ------------------------------------------
    parentEntity.setBaseS(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the BaseS
   *
   * @param	parentId		UUID
   * @return	ACDCConverter
   */
  public ACDCConverter unAssignBaseS(UUID parentId) {
    ACDCConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning BaseS on " + parentEntity.toString());

    // ------------------------------------------
    // null out the BaseS on the parent entithy
    // ------------------------------------------
    parentEntity.setBaseS(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a IdleLoss
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePower
   * @return	ACDCConverter
   */
  public ACDCConverter assignIdleLoss(UUID parentId, ActivePower assignment) {
    LOGGER.info("assigning IdleLoss as " + assignment.toString());

    ACDCConverter parentEntity = repository.findById(parentId).get();
    assignment = ActivePowerProjector.find(assignment.getActivePowerId());

    // ------------------------------------------
    // assign the IdleLoss to the parent entity
    // ------------------------------------------
    parentEntity.setIdleLoss(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the IdleLoss
   *
   * @param	parentId		UUID
   * @return	ACDCConverter
   */
  public ACDCConverter unAssignIdleLoss(UUID parentId) {
    ACDCConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning IdleLoss on " + parentEntity.toString());

    // ------------------------------------------
    // null out the IdleLoss on the parent entithy
    // ------------------------------------------
    parentEntity.setIdleLoss(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MaxUdc
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	ACDCConverter
   */
  public ACDCConverter assignMaxUdc(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning MaxUdc as " + assignment.toString());

    ACDCConverter parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the MaxUdc to the parent entity
    // ------------------------------------------
    parentEntity.setMaxUdc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MaxUdc
   *
   * @param	parentId		UUID
   * @return	ACDCConverter
   */
  public ACDCConverter unAssignMaxUdc(UUID parentId) {
    ACDCConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MaxUdc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MaxUdc on the parent entithy
    // ------------------------------------------
    parentEntity.setMaxUdc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a MinUdc
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	ACDCConverter
   */
  public ACDCConverter assignMinUdc(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning MinUdc as " + assignment.toString());

    ACDCConverter parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the MinUdc to the parent entity
    // ------------------------------------------
    parentEntity.setMinUdc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the MinUdc
   *
   * @param	parentId		UUID
   * @return	ACDCConverter
   */
  public ACDCConverter unAssignMinUdc(UUID parentId) {
    ACDCConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning MinUdc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the MinUdc on the parent entithy
    // ------------------------------------------
    parentEntity.setMinUdc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a NumberOfValves
   *
   * @param	parentId	UUID
   * @param	assignment 	IntegerProxy
   * @return	ACDCConverter
   */
  public ACDCConverter assignNumberOfValves(UUID parentId, IntegerProxy assignment) {
    LOGGER.info("assigning NumberOfValves as " + assignment.toString());

    ACDCConverter parentEntity = repository.findById(parentId).get();
    assignment = IntegerProxyProjector.find(assignment.getIntegerProxyId());

    // ------------------------------------------
    // assign the NumberOfValves to the parent entity
    // ------------------------------------------
    parentEntity.setNumberOfValves(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the NumberOfValves
   *
   * @param	parentId		UUID
   * @return	ACDCConverter
   */
  public ACDCConverter unAssignNumberOfValves(UUID parentId) {
    ACDCConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning NumberOfValves on " + parentEntity.toString());

    // ------------------------------------------
    // null out the NumberOfValves on the parent entithy
    // ------------------------------------------
    parentEntity.setNumberOfValves(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a RatedUdc
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	ACDCConverter
   */
  public ACDCConverter assignRatedUdc(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning RatedUdc as " + assignment.toString());

    ACDCConverter parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the RatedUdc to the parent entity
    // ------------------------------------------
    parentEntity.setRatedUdc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the RatedUdc
   *
   * @param	parentId		UUID
   * @return	ACDCConverter
   */
  public ACDCConverter unAssignRatedUdc(UUID parentId) {
    ACDCConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning RatedUdc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the RatedUdc on the parent entithy
    // ------------------------------------------
    parentEntity.setRatedUdc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ResistiveLoss
   *
   * @param	parentId	UUID
   * @param	assignment 	Resistance
   * @return	ACDCConverter
   */
  public ACDCConverter assignResistiveLoss(UUID parentId, Resistance assignment) {
    LOGGER.info("assigning ResistiveLoss as " + assignment.toString());

    ACDCConverter parentEntity = repository.findById(parentId).get();
    assignment = ResistanceProjector.find(assignment.getResistanceId());

    // ------------------------------------------
    // assign the ResistiveLoss to the parent entity
    // ------------------------------------------
    parentEntity.setResistiveLoss(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ResistiveLoss
   *
   * @param	parentId		UUID
   * @return	ACDCConverter
   */
  public ACDCConverter unAssignResistiveLoss(UUID parentId) {
    ACDCConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ResistiveLoss on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ResistiveLoss on the parent entithy
    // ------------------------------------------
    parentEntity.setResistiveLoss(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a SwitchingLoss
   *
   * @param	parentId	UUID
   * @param	assignment 	ActivePowerPerCurrentFlow
   * @return	ACDCConverter
   */
  public ACDCConverter assignSwitchingLoss(UUID parentId, ActivePowerPerCurrentFlow assignment) {
    LOGGER.info("assigning SwitchingLoss as " + assignment.toString());

    ACDCConverter parentEntity = repository.findById(parentId).get();
    assignment =
        ActivePowerPerCurrentFlowProjector.find(assignment.getActivePowerPerCurrentFlowId());

    // ------------------------------------------
    // assign the SwitchingLoss to the parent entity
    // ------------------------------------------
    parentEntity.setSwitchingLoss(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the SwitchingLoss
   *
   * @param	parentId		UUID
   * @return	ACDCConverter
   */
  public ACDCConverter unAssignSwitchingLoss(UUID parentId) {
    ACDCConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning SwitchingLoss on " + parentEntity.toString());

    // ------------------------------------------
    // null out the SwitchingLoss on the parent entithy
    // ------------------------------------------
    parentEntity.setSwitchingLoss(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a ValveU0
   *
   * @param	parentId	UUID
   * @param	assignment 	Voltage
   * @return	ACDCConverter
   */
  public ACDCConverter assignValveU0(UUID parentId, Voltage assignment) {
    LOGGER.info("assigning ValveU0 as " + assignment.toString());

    ACDCConverter parentEntity = repository.findById(parentId).get();
    assignment = VoltageProjector.find(assignment.getVoltageId());

    // ------------------------------------------
    // assign the ValveU0 to the parent entity
    // ------------------------------------------
    parentEntity.setValveU0(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the ValveU0
   *
   * @param	parentId		UUID
   * @return	ACDCConverter
   */
  public ACDCConverter unAssignValveU0(UUID parentId) {
    ACDCConverter parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning ValveU0 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the ValveU0 on the parent entithy
    // ------------------------------------------
    parentEntity.setValveU0(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Add to the ConverterDCSides
   *
   * @param	parentID	UUID
   * @param	addTo		childType
   * @return	ACDCConverter
   */
  public ACDCConverter addToConverterDCSides(UUID parentId, ACDCConverter addTo) {
    LOGGER.info("handling AssignConverterDCSidesToACDCConverterEvent - ");

    ACDCConverter parentEntity = repository.findById(parentId).get();
    ACDCConverter child = ACDCConverterProjector.find(addTo.getACDCConverterId());

    parentEntity.getConverterDCSides().add(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Remove from the ConverterDCSides
   *
   * @param	parentID	UUID
   * @param	removeFrom	childType
   * @return	ACDCConverter
   */
  public ACDCConverter removeFromConverterDCSides(UUID parentId, ACDCConverter removeFrom) {
    LOGGER.info("handling RemoveConverterDCSidesFromACDCConverterEvent ");

    ACDCConverter parentEntity = repository.findById(parentId).get();
    ACDCConverter child = ACDCConverterProjector.find(removeFrom.getACDCConverterId());

    parentEntity.getConverterDCSides().remove(child);

    // ------------------------------------------
    // save
    // ------------------------------------------
    update(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ACDCConverter via an FindACDCConverterQuery
   *
   * @return query FindACDCConverterQuery
   */
  @SuppressWarnings("unused")
  public ACDCConverter find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ACDCConverter - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ACDCConverters
   *
   * @param query FindAllACDCConverterQuery
   * @return List<ACDCConverter>
   */
  @SuppressWarnings("unused")
  public List<ACDCConverter> findAll(FindAllACDCConverterQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ACDCConverter - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ACDCConverterRepository repository;

  @Autowired
  @Qualifier(value = "apparentPower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ApparentPowerEntityProjector
      ApparentPowerProjector;

  @Autowired
  @Qualifier(value = "activePower-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ActivePowerEntityProjector
      ActivePowerProjector;

  @Autowired
  @Qualifier(value = "voltage-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .VoltageEntityProjector
      VoltageProjector;

  @Autowired
  @Qualifier(value = "integerProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .IntegerProxyEntityProjector
      IntegerProxyProjector;

  @Autowired
  @Qualifier(value = "resistance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ResistanceEntityProjector
      ResistanceProjector;

  @Autowired
  @Qualifier(value = "activePowerPerCurrentFlow-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .ActivePowerPerCurrentFlowEntityProjector
      ActivePowerPerCurrentFlowProjector;

  @Autowired
  @Qualifier(value = "aCDCConverter-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector
          .ACDCConverterEntityProjector
      ACDCConverterProjector;

  private static final Logger LOGGER =
      Logger.getLogger(ACDCConverterEntityProjector.class.getName());
}
