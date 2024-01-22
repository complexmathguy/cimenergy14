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
 * Projector for PU as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by PUAggregate
 *
 * @author your_name_here
 */
@Component("pU-entity-projector")
public class PUEntityProjector {

  // core constructor
  public PUEntityProjector(PURepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a PU
   *
   * @param	entity PU
   */
  public PU create(PU entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a PU
   *
   * @param	entity PU
   */
  public PU update(PU entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a PU
   *
   * @param	id		UUID
   */
  public PU delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    PU entity = repository.findById(id).get();

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
   * @return	PU
   */
  public PU assignValue(UUID parentId, FloatProxy assignment) {
    LOGGER.info("assigning Value as " + assignment.toString());

    PU parentEntity = repository.findById(parentId).get();
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
   * @return	PU
   */
  public PU unAssignValue(UUID parentId) {
    PU parentEntity = repository.findById(parentId).get();

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
   * Method to retrieve the PU via an FindPUQuery
   *
   * @return query FindPUQuery
   */
  @SuppressWarnings("unused")
  public PU find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a PU - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all PUs
   *
   * @param query FindAllPUQuery
   * @return List<PU>
   */
  @SuppressWarnings("unused")
  public List<PU> findAll(FindAllPUQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all PU - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final PURepository repository;

  @Autowired
  @Qualifier(value = "floatProxy-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector
          .FloatProxyEntityProjector
      FloatProxyProjector;

  @Autowired
  @Qualifier(value = "externalNetworkInjection-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .ExternalNetworkInjectionEntityProjector
      ExternalNetworkInjectionProjector;

  @Autowired
  @Qualifier(value = "synchronousMachine-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.projector
          .SynchronousMachineEntityProjector
      SynchronousMachineProjector;

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
  @Qualifier(value = "synchronousMachineEquivalentCircuit-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .synchronousmachinedynamics.projector.SynchronousMachineEquivalentCircuitEntityProjector
      SynchronousMachineEquivalentCircuitProjector;

  @Autowired
  @Qualifier(value = "asynchronousMachineTimeConstantReactance-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .asynchronousmachinedynamics.projector
          .AsynchronousMachineTimeConstantReactanceEntityProjector
      AsynchronousMachineTimeConstantReactanceProjector;

  @Autowired
  @Qualifier(value = "asynchronousMachineEquivalentCircuit-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .asynchronousmachinedynamics.projector.AsynchronousMachineEquivalentCircuitEntityProjector
      AsynchronousMachineEquivalentCircuitProjector;

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
  @Qualifier(value = "govCT1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovCT1EntityProjector
      GovCT1Projector;

  @Autowired
  @Qualifier(value = "govCT2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovCT2EntityProjector
      GovCT2Projector;

  @Autowired
  @Qualifier(value = "govGAST-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovGASTEntityProjector
      GovGASTProjector;

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
  @Qualifier(value = "govGASTWD-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovGASTWDEntityProjector
      GovGASTWDProjector;

  @Autowired
  @Qualifier(value = "govHydro1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydro1EntityProjector
      GovHydro1Projector;

  @Autowired
  @Qualifier(value = "govHydro3-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydro3EntityProjector
      GovHydro3Projector;

  @Autowired
  @Qualifier(value = "govHydro4-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydro4EntityProjector
      GovHydro4Projector;

  @Autowired
  @Qualifier(value = "govHydroFrancis-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydroFrancisEntityProjector
      GovHydroFrancisProjector;

  @Autowired
  @Qualifier(value = "govHydroPelton-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydroPeltonEntityProjector
      GovHydroPeltonProjector;

  @Autowired
  @Qualifier(value = "govHydroPID2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydroPID2EntityProjector
      GovHydroPID2Projector;

  @Autowired
  @Qualifier(value = "govHydroWEH-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydroWEHEntityProjector
      GovHydroWEHProjector;

  @Autowired
  @Qualifier(value = "govHydroWPID-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovHydroWPIDEntityProjector
      GovHydroWPIDProjector;

  @Autowired
  @Qualifier(value = "govSteam0-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovSteam0EntityProjector
      GovSteam0Projector;

  @Autowired
  @Qualifier(value = "govSteam2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovSteam2EntityProjector
      GovSteam2Projector;

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
  @Qualifier(value = "govSteamFV3-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovSteamFV3EntityProjector
      GovSteamFV3Projector;

  @Autowired
  @Qualifier(value = "govSteamFV4-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbinegovernordynamics.projector.GovSteamFV4EntityProjector
      GovSteamFV4Projector;

  @Autowired
  @Qualifier(value = "turbLCFB1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .turbineloadcontrollerdynamics.projector.TurbLCFB1EntityProjector
      TurbLCFB1Projector;

  @Autowired
  @Qualifier(value = "excIEEEAC1A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEAC1AEntityProjector
      ExcIEEEAC1AProjector;

  @Autowired
  @Qualifier(value = "excIEEEAC2A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEAC2AEntityProjector
      ExcIEEEAC2AProjector;

  @Autowired
  @Qualifier(value = "excIEEEAC3A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEAC3AEntityProjector
      ExcIEEEAC3AProjector;

  @Autowired
  @Qualifier(value = "excIEEEAC4A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEAC4AEntityProjector
      ExcIEEEAC4AProjector;

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
  @Qualifier(value = "excIEEEDC2A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEDC2AEntityProjector
      ExcIEEEDC2AProjector;

  @Autowired
  @Qualifier(value = "excIEEEDC3A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEDC3AEntityProjector
      ExcIEEEDC3AProjector;

  @Autowired
  @Qualifier(value = "excIEEEST1A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEST1AEntityProjector
      ExcIEEEST1AProjector;

  @Autowired
  @Qualifier(value = "excIEEEST2A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEST2AEntityProjector
      ExcIEEEST2AProjector;

  @Autowired
  @Qualifier(value = "excIEEEST3A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEST3AEntityProjector
      ExcIEEEST3AProjector;

  @Autowired
  @Qualifier(value = "excIEEEST4B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEST4BEntityProjector
      ExcIEEEST4BProjector;

  @Autowired
  @Qualifier(value = "excIEEEST6B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcIEEEST6BEntityProjector
      ExcIEEEST6BProjector;

  @Autowired
  @Qualifier(value = "excAC1A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcAC1AEntityProjector
      ExcAC1AProjector;

  @Autowired
  @Qualifier(value = "excAC2A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcAC2AEntityProjector
      ExcAC2AProjector;

  @Autowired
  @Qualifier(value = "excAC3A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcAC3AEntityProjector
      ExcAC3AProjector;

  @Autowired
  @Qualifier(value = "excAC8B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcAC8BEntityProjector
      ExcAC8BProjector;

  @Autowired
  @Qualifier(value = "excANS-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcANSEntityProjector
      ExcANSProjector;

  @Autowired
  @Qualifier(value = "excAVR1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcAVR1EntityProjector
      ExcAVR1Projector;

  @Autowired
  @Qualifier(value = "excAVR4-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcAVR4EntityProjector
      ExcAVR4Projector;

  @Autowired
  @Qualifier(value = "excAVR5-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcAVR5EntityProjector
      ExcAVR5Projector;

  @Autowired
  @Qualifier(value = "excAVR7-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcAVR7EntityProjector
      ExcAVR7Projector;

  @Autowired
  @Qualifier(value = "excBBC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcBBCEntityProjector
      ExcBBCProjector;

  @Autowired
  @Qualifier(value = "excDC1A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcDC1AEntityProjector
      ExcDC1AProjector;

  @Autowired
  @Qualifier(value = "excDC3A1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcDC3A1EntityProjector
      ExcDC3A1Projector;

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
  @Qualifier(value = "excHU-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcHUEntityProjector
      ExcHUProjector;

  @Autowired
  @Qualifier(value = "excOEX3T-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcOEX3TEntityProjector
      ExcOEX3TProjector;

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
  @Qualifier(value = "excSK-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcSKEntityProjector
      ExcSKProjector;

  @Autowired
  @Qualifier(value = "excST3A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcST3AEntityProjector
      ExcST3AProjector;

  @Autowired
  @Qualifier(value = "excST6B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .excitationsystemdynamics.projector.ExcST6BEntityProjector
      ExcST6BProjector;

  @Autowired
  @Qualifier(value = "overexcLimIEEE-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .overexcitationlimiterdynamics.projector.OverexcLimIEEEEntityProjector
      OverexcLimIEEEProjector;

  @Autowired
  @Qualifier(value = "overexcLim2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .overexcitationlimiterdynamics.projector.OverexcLim2EntityProjector
      OverexcLim2Projector;

  @Autowired
  @Qualifier(value = "overexcLimX1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .overexcitationlimiterdynamics.projector.OverexcLimX1EntityProjector
      OverexcLimX1Projector;

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
  @Qualifier(value = "underexcLimX1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .underexcitationlimiterdynamics.projector.UnderexcLimX1EntityProjector
      UnderexcLimX1Projector;

  @Autowired
  @Qualifier(value = "underexcLimX2-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .underexcitationlimiterdynamics.projector.UnderexcLimX2EntityProjector
      UnderexcLimX2Projector;

  @Autowired
  @Qualifier(value = "pssIEEE2B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.PssIEEE2BEntityProjector
      PssIEEE2BProjector;

  @Autowired
  @Qualifier(value = "pssIEEE3B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.PssIEEE3BEntityProjector
      PssIEEE3BProjector;

  @Autowired
  @Qualifier(value = "pssIEEE4B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.PssIEEE4BEntityProjector
      PssIEEE4BProjector;

  @Autowired
  @Qualifier(value = "pss1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.Pss1EntityProjector
      Pss1Projector;

  @Autowired
  @Qualifier(value = "pss1A-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.Pss1AEntityProjector
      Pss1AProjector;

  @Autowired
  @Qualifier(value = "pss2B-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.Pss2BEntityProjector
      Pss2BProjector;

  @Autowired
  @Qualifier(value = "pss2ST-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.Pss2STEntityProjector
      Pss2STProjector;

  @Autowired
  @Qualifier(value = "pss5-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.Pss5EntityProjector
      Pss5Projector;

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
  @Qualifier(value = "pssPTIST3-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.PssPTIST3EntityProjector
      PssPTIST3Projector;

  @Autowired
  @Qualifier(value = "pssSB4-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.PssSB4EntityProjector
      PssSB4Projector;

  @Autowired
  @Qualifier(value = "pssSH-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .powersystemstabilizerdynamics.projector.PssSHEntityProjector
      PssSHProjector;

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
  @Qualifier(value = "pFVArType2IEEEPFController-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .pfvarcontrollertype2dynamics.projector.PFVArType2IEEEPFControllerEntityProjector
      PFVArType2IEEEPFControllerProjector;

  @Autowired
  @Qualifier(value = "pFVArType2IEEEVArController-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .pfvarcontrollertype2dynamics.projector.PFVArType2IEEEVArControllerEntityProjector
      PFVArType2IEEEVArControllerProjector;

  @Autowired
  @Qualifier(value = "pFVArType2Common1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .pfvarcontrollertype2dynamics.projector.PFVArType2Common1EntityProjector
      PFVArType2Common1Projector;

  @Autowired
  @Qualifier(value = "vCompIEEEType1-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .voltagecompensatordynamics.projector.VCompIEEEType1EntityProjector
      VCompIEEEType1Projector;

  @Autowired
  @Qualifier(value = "genICompensationForGenJ-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .voltagecompensatordynamics.projector.GenICompensationForGenJEntityProjector
      GenICompensationForGenJProjector;

  @Autowired
  @Qualifier(value = "windAeroLinearIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindAeroLinearIECEntityProjector
      WindAeroLinearIECProjector;

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
  @Qualifier(value = "windContRotorRIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindContRotorRIECEntityProjector
      WindContRotorRIECProjector;

  @Autowired
  @Qualifier(value = "windGenTurbineType3IEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindGenTurbineType3IECEntityProjector
      WindGenTurbineType3IECProjector;

  @Autowired
  @Qualifier(value = "windGenType4IEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindGenType4IECEntityProjector
      WindGenType4IECProjector;

  @Autowired
  @Qualifier(value = "windMechIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindMechIECEntityProjector
      WindMechIECProjector;

  @Autowired
  @Qualifier(value = "windPitchContEmulIEC-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .winddynamics.projector.WindPitchContEmulIECEntityProjector
      WindPitchContEmulIECProjector;

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
  @Qualifier(value = "loadMotor-entity-projector")
  com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
          .loaddynamics.projector.LoadMotorEntityProjector
      LoadMotorProjector;

  private static final Logger LOGGER = Logger.getLogger(PUEntityProjector.class.getName());
}
