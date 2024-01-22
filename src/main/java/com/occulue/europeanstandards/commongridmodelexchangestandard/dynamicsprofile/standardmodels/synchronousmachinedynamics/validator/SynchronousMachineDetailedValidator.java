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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class SynchronousMachineDetailedValidator {

  /** default constructor */
  protected SynchronousMachineDetailedValidator() {}

  /** factory method */
  public static SynchronousMachineDetailedValidator getInstance() {
    return new SynchronousMachineDetailedValidator();
  }

  /** handles creation validation for a SynchronousMachineDetailed */
  public void validate(CreateSynchronousMachineDetailedCommand synchronousMachineDetailed)
      throws Exception {
    Assert.notNull(
        synchronousMachineDetailed, "CreateSynchronousMachineDetailedCommand should not be null");
    //		Assert.isNull( synchronousMachineDetailed.getSynchronousMachineDetailedId(),
    // "CreateSynchronousMachineDetailedCommand identifier should be null" );
  }

  /** handles update validation for a SynchronousMachineDetailed */
  public void validate(UpdateSynchronousMachineDetailedCommand synchronousMachineDetailed)
      throws Exception {
    Assert.notNull(
        synchronousMachineDetailed, "UpdateSynchronousMachineDetailedCommand should not be null");
    Assert.notNull(
        synchronousMachineDetailed.getSynchronousMachineDetailedId(),
        "UpdateSynchronousMachineDetailedCommand identifier should not be null");
  }

  /** handles delete validation for a SynchronousMachineDetailed */
  public void validate(DeleteSynchronousMachineDetailedCommand synchronousMachineDetailed)
      throws Exception {
    Assert.notNull(synchronousMachineDetailed, "{commandAlias} should not be null");
    Assert.notNull(
        synchronousMachineDetailed.getSynchronousMachineDetailedId(),
        "DeleteSynchronousMachineDetailedCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SynchronousMachineDetailed */
  public void validate(SynchronousMachineDetailedFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SynchronousMachineDetailedFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSynchronousMachineDetailedId(),
        "SynchronousMachineDetailedFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign EfdBaseRatio validation for a SynchronousMachineDetailed
   *
   * @param command AssignEfdBaseRatioToSynchronousMachineDetailedCommand
   */
  public void validate(AssignEfdBaseRatioToSynchronousMachineDetailedCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignEfdBaseRatioToSynchronousMachineDetailedCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineDetailedId(),
        "AssignEfdBaseRatioToSynchronousMachineDetailedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEfdBaseRatioToSynchronousMachineDetailedCommand assignment should not be null");
  }

  /**
   * handles unassign EfdBaseRatio validation for a SynchronousMachineDetailed
   *
   * @param command UnAssignEfdBaseRatioFromSynchronousMachineDetailedCommand
   */
  public void validate(UnAssignEfdBaseRatioFromSynchronousMachineDetailedCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignEfdBaseRatioFromSynchronousMachineDetailedCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineDetailedId(),
        "UnAssignEfdBaseRatioFromSynchronousMachineDetailedCommand identifier should not be null");
  }
  /**
   * handles assign IfdBaseValue validation for a SynchronousMachineDetailed
   *
   * @param command AssignIfdBaseValueToSynchronousMachineDetailedCommand
   */
  public void validate(AssignIfdBaseValueToSynchronousMachineDetailedCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignIfdBaseValueToSynchronousMachineDetailedCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineDetailedId(),
        "AssignIfdBaseValueToSynchronousMachineDetailedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignIfdBaseValueToSynchronousMachineDetailedCommand assignment should not be null");
  }

  /**
   * handles unassign IfdBaseValue validation for a SynchronousMachineDetailed
   *
   * @param command UnAssignIfdBaseValueFromSynchronousMachineDetailedCommand
   */
  public void validate(UnAssignIfdBaseValueFromSynchronousMachineDetailedCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignIfdBaseValueFromSynchronousMachineDetailedCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineDetailedId(),
        "UnAssignIfdBaseValueFromSynchronousMachineDetailedCommand identifier should not be null");
  }
  /**
   * handles assign SaturationFactor120QAxis validation for a SynchronousMachineDetailed
   *
   * @param command AssignSaturationFactor120QAxisToSynchronousMachineDetailedCommand
   */
  public void validate(AssignSaturationFactor120QAxisToSynchronousMachineDetailedCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignSaturationFactor120QAxisToSynchronousMachineDetailedCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineDetailedId(),
        "AssignSaturationFactor120QAxisToSynchronousMachineDetailedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSaturationFactor120QAxisToSynchronousMachineDetailedCommand assignment should not be null");
  }

  /**
   * handles unassign SaturationFactor120QAxis validation for a SynchronousMachineDetailed
   *
   * @param command UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedCommand
   */
  public void validate(
      UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineDetailedId(),
        "UnAssignSaturationFactor120QAxisFromSynchronousMachineDetailedCommand identifier should not be null");
  }
  /**
   * handles assign SaturationFactorQAxis validation for a SynchronousMachineDetailed
   *
   * @param command AssignSaturationFactorQAxisToSynchronousMachineDetailedCommand
   */
  public void validate(AssignSaturationFactorQAxisToSynchronousMachineDetailedCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignSaturationFactorQAxisToSynchronousMachineDetailedCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineDetailedId(),
        "AssignSaturationFactorQAxisToSynchronousMachineDetailedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSaturationFactorQAxisToSynchronousMachineDetailedCommand assignment should not be null");
  }

  /**
   * handles unassign SaturationFactorQAxis validation for a SynchronousMachineDetailed
   *
   * @param command UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedCommand
   */
  public void validate(UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedCommand should not be null");
    Assert.notNull(
        command.getSynchronousMachineDetailedId(),
        "UnAssignSaturationFactorQAxisFromSynchronousMachineDetailedCommand identifier should not be null");
  }
}
