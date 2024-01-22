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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for Seconds as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by SecondsAggregate
 *
 * @author your_name_here
 */
@Component("seconds-entity-projector")
public class SecondsEntityProjector {

  // core constructor
  public SecondsEntityProjector(SecondsRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a Seconds
   *
   * @param	entity Seconds
   */
  public Seconds create(Seconds entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a Seconds
   *
   * @param	entity Seconds
   */
  public Seconds update(Seconds entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a Seconds
   *
   * @param	id		UUID
   */
  public Seconds delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    Seconds entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Value
   *
   * @param	parentId	UUID
   * @param	assignment 	FloatProxy
   * @return	Seconds
   */
  public Seconds assignValue(UUID parentId, FloatProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    Seconds parentEntity = repository.findById(parentId).get();
    assignment = FloatProxyProjector.find(assignment.getFloatProxyId());

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
   * @return	Seconds
   */
  public Seconds unAssignValue(UUID parentId) {
    Seconds parentEntity = repository.findById(parentId).get();

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

  /**
   * Method to retrieve the Seconds via an FindSecondsQuery
   *
   * @return query FindSecondsQuery
   */
  @SuppressWarnings("unused")
  public Seconds find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a Seconds - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all Secondss
   *
   * @param query FindAllSecondsQuery
   * @return List<Seconds>
   */
  @SuppressWarnings("unused")
  public List<Seconds> findAll(FindAllSecondsQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all Seconds - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final SecondsRepository repository;

  @Autowired
  @Qualifier(value = "floatProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .FloatProxyEntityProjector
      FloatProxyProjector;

  @Autowired
  @Qualifier(value = "regularIntervalSchedule-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.projector
          .RegularIntervalScheduleEntityProjector
      RegularIntervalScheduleProjector;

  @Autowired
  @Qualifier(value = "operationalLimitType-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits
          .projector.OperationalLimitTypeEntityProjector
      OperationalLimitTypeProjector;

  @Autowired
  @Qualifier(value = "shuntCompensator-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .ShuntCompensatorEntityProjector
      ShuntCompensatorProjector;

  @Autowired
  @Qualifier(value = "rotatingMachineDynamics-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .projector.RotatingMachineDynamicsEntityProjector
      RotatingMachineDynamicsProjector;

  @Autowired
  @Qualifier(value = "synchronousMachineTimeConstantReactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .synchronousmachinedynamics.projector
          .SynchronousMachineTimeConstantReactanceEntityProjector
      SynchronousMachineTimeConstantReactanceProjector;

  @Autowired
  @Qualifier(value = "asynchronousMachineTimeConstantReactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .asynchronousmachinedynamics.projector
          .AsynchronousMachineTimeConstantReactanceEntityProjector
      AsynchronousMachineTimeConstantReactanceProjector;

  @Autowired
  @Qualifier(value = "govHydroIEEE0-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydroIEEE0EntityProjector
      GovHydroIEEE0Projector;

  @Autowired
  @Qualifier(value = "govHydroIEEE2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydroIEEE2EntityProjector
      GovHydroIEEE2Projector;

  @Autowired
  @Qualifier(value = "govSteamIEEE1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovSteamIEEE1EntityProjector
      GovSteamIEEE1Projector;

  @Autowired
  @Qualifier(value = "govCT1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovCT1EntityProjector
      GovCT1Projector;

  @Autowired
  @Qualifier(value = "govGAST1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovGAST1EntityProjector
      GovGAST1Projector;

  @Autowired
  @Qualifier(value = "govGAST2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovGAST2EntityProjector
      GovGAST2Projector;

  @Autowired
  @Qualifier(value = "govGAST3-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovGAST3EntityProjector
      GovGAST3Projector;

  @Autowired
  @Qualifier(value = "govGAST4-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovGAST4EntityProjector
      GovGAST4Projector;

  @Autowired
  @Qualifier(value = "govHydro4-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydro4EntityProjector
      GovHydro4Projector;

  @Autowired
  @Qualifier(value = "govHydroDD-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydroDDEntityProjector
      GovHydroDDProjector;

  @Autowired
  @Qualifier(value = "govHydroFrancis-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydroFrancisEntityProjector
      GovHydroFrancisProjector;

  @Autowired
  @Qualifier(value = "govHydroPID2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydroPID2EntityProjector
      GovHydroPID2Projector;

  @Autowired
  @Qualifier(value = "govHydroR-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydroREntityProjector
      GovHydroRProjector;

  @Autowired
  @Qualifier(value = "govHydroWEH-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydroWEHEntityProjector
      GovHydroWEHProjector;

  @Autowired
  @Qualifier(value = "govSteamCC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovSteamCCEntityProjector
      GovSteamCCProjector;

  @Autowired
  @Qualifier(value = "govSteamEU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovSteamEUEntityProjector
      GovSteamEUProjector;

  @Autowired
  @Qualifier(value = "govSteamFV2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovSteamFV2EntityProjector
      GovSteamFV2Projector;

  @Autowired
  @Qualifier(value = "govSteamFV4-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovSteamFV4EntityProjector
      GovSteamFV4Projector;

  @Autowired
  @Qualifier(value = "govSteamSGO-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovSteamSGOEntityProjector
      GovSteamSGOProjector;

  @Autowired
  @Qualifier(value = "excIEEEAC1A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEAC1AEntityProjector
      ExcIEEEAC1AProjector;

  @Autowired
  @Qualifier(value = "excIEEEAC5A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEAC5AEntityProjector
      ExcIEEEAC5AProjector;

  @Autowired
  @Qualifier(value = "excIEEEAC6A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEAC6AEntityProjector
      ExcIEEEAC6AProjector;

  @Autowired
  @Qualifier(value = "excIEEEAC7B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEAC7BEntityProjector
      ExcIEEEAC7BProjector;

  @Autowired
  @Qualifier(value = "excIEEEST1A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEST1AEntityProjector
      ExcIEEEST1AProjector;

  @Autowired
  @Qualifier(value = "excIEEEST5B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEST5BEntityProjector
      ExcIEEEST5BProjector;

  @Autowired
  @Qualifier(value = "excIEEEST7B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEST7BEntityProjector
      ExcIEEEST7BProjector;

  @Autowired
  @Qualifier(value = "excAC3A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcAC3AEntityProjector
      ExcAC3AProjector;

  @Autowired
  @Qualifier(value = "excAVR4-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcAVR4EntityProjector
      ExcAVR4Projector;

  @Autowired
  @Qualifier(value = "excELIN1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcELIN1EntityProjector
      ExcELIN1Projector;

  @Autowired
  @Qualifier(value = "excELIN2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcELIN2EntityProjector
      ExcELIN2Projector;

  @Autowired
  @Qualifier(value = "excPIC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcPICEntityProjector
      ExcPICProjector;

  @Autowired
  @Qualifier(value = "excREXS-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcREXSEntityProjector
      ExcREXSProjector;

  @Autowired
  @Qualifier(value = "excST6B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcST6BEntityProjector
      ExcST6BProjector;

  @Autowired
  @Qualifier(value = "underexcLimIEEE1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .underexcitationlimiterdynamics.projector.UnderexcLimIEEE1EntityProjector
      UnderexcLimIEEE1Projector;

  @Autowired
  @Qualifier(value = "underexcLimIEEE2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .underexcitationlimiterdynamics.projector.UnderexcLimIEEE2EntityProjector
      UnderexcLimIEEE2Projector;

  @Autowired
  @Qualifier(value = "pssIEEE2B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.PssIEEE2BEntityProjector
      PssIEEE2BProjector;

  @Autowired
  @Qualifier(value = "pssIEEE4B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.PssIEEE4BEntityProjector
      PssIEEE4BProjector;

  @Autowired
  @Qualifier(value = "pss1A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.Pss1AEntityProjector
      Pss1AProjector;

  @Autowired
  @Qualifier(value = "pssELIN2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.PssELIN2EntityProjector
      PssELIN2Projector;

  @Autowired
  @Qualifier(value = "pssPTIST1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.PssPTIST1EntityProjector
      PssPTIST1Projector;

  @Autowired
  @Qualifier(value = "pssSB4-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.PssSB4EntityProjector
      PssSB4Projector;

  @Autowired
  @Qualifier(value = "discExcContIEEEDEC1A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .discontinuousexcitationcontroldynamics.projector.DiscExcContIEEEDEC1AEntityProjector
      DiscExcContIEEEDEC1AProjector;

  @Autowired
  @Qualifier(value = "discExcContIEEEDEC2A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .discontinuousexcitationcontroldynamics.projector.DiscExcContIEEEDEC2AEntityProjector
      DiscExcContIEEEDEC2AProjector;

  @Autowired
  @Qualifier(value = "pFVArType1IEEEPFController-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .pfvarcontrollertype1dynamics.projector.PFVArType1IEEEPFControllerEntityProjector
      PFVArType1IEEEPFControllerProjector;

  @Autowired
  @Qualifier(value = "pFVArType1IEEEVArController-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .pfvarcontrollertype1dynamics.projector.PFVArType1IEEEVArControllerEntityProjector
      PFVArType1IEEEVArControllerProjector;

  @Autowired
  @Qualifier(value = "vAdjIEEE-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .voltageadjusterdynamics.projector.VAdjIEEEEntityProjector
      VAdjIEEEProjector;

  @Autowired
  @Qualifier(value = "windContCurrLimIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindContCurrLimIECEntityProjector
      WindContCurrLimIECProjector;

  @Autowired
  @Qualifier(value = "windContPType3IEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindContPType3IECEntityProjector
      WindContPType3IECProjector;

  @Autowired
  @Qualifier(value = "windContPType4aIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindContPType4aIECEntityProjector
      WindContPType4aIECProjector;

  @Autowired
  @Qualifier(value = "windContPType4bIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindContPType4bIECEntityProjector
      WindContPType4bIECProjector;

  @Autowired
  @Qualifier(value = "windContPitchAngleIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindContPitchAngleIECEntityProjector
      WindContPitchAngleIECProjector;

  @Autowired
  @Qualifier(value = "windContQIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindContQIECEntityProjector
      WindContQIECProjector;

  @Autowired
  @Qualifier(value = "windGenTurbineType3aIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindGenTurbineType3aIECEntityProjector
      WindGenTurbineType3aIECProjector;

  @Autowired
  @Qualifier(value = "windGenTurbineType3bIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindGenTurbineType3bIECEntityProjector
      WindGenTurbineType3bIECProjector;

  @Autowired
  @Qualifier(value = "windMechIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindMechIECEntityProjector
      WindMechIECProjector;

  @Autowired
  @Qualifier(value = "windPlantFreqPcontrolIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindPlantFreqPcontrolIECEntityProjector
      WindPlantFreqPcontrolIECProjector;

  @Autowired
  @Qualifier(value = "windPlantReactiveControlIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindPlantReactiveControlIECEntityProjector
      WindPlantReactiveControlIECProjector;

  @Autowired
  @Qualifier(value = "windProtectionIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindProtectionIECEntityProjector
      WindProtectionIECProjector;

  @Autowired
  @Qualifier(value = "loadComposite-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .loaddynamics.projector.LoadCompositeEntityProjector
      LoadCompositeProjector;

  @Autowired
  @Qualifier(value = "loadGenericNonLinear-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .loaddynamics.projector.LoadGenericNonLinearEntityProjector
      LoadGenericNonLinearProjector;

  @Autowired
  @Qualifier(value = "loadMotor-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .loaddynamics.projector.LoadMotorEntityProjector
      LoadMotorProjector;

  private static final Logger LOGGER = Logger.getLogger(SecondsEntityProjector.class.getName());
}
