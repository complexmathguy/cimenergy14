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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class VoltageAdjusterDynamicsValidator {

  /** default constructor */
  protected VoltageAdjusterDynamicsValidator() {}

  /** factory method */
  public static VoltageAdjusterDynamicsValidator getInstance() {
    return new VoltageAdjusterDynamicsValidator();
  }

  /** handles creation validation for a VoltageAdjusterDynamics */
  public void validate(CreateVoltageAdjusterDynamicsCommand voltageAdjusterDynamics)
      throws Exception {
    Assert.notNull(
        voltageAdjusterDynamics, "CreateVoltageAdjusterDynamicsCommand should not be null");
    //		Assert.isNull( voltageAdjusterDynamics.getVoltageAdjusterDynamicsId(),
    // "CreateVoltageAdjusterDynamicsCommand identifier should be null" );
  }

  /** handles update validation for a VoltageAdjusterDynamics */
  public void validate(UpdateVoltageAdjusterDynamicsCommand voltageAdjusterDynamics)
      throws Exception {
    Assert.notNull(
        voltageAdjusterDynamics, "UpdateVoltageAdjusterDynamicsCommand should not be null");
    Assert.notNull(
        voltageAdjusterDynamics.getVoltageAdjusterDynamicsId(),
        "UpdateVoltageAdjusterDynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a VoltageAdjusterDynamics */
  public void validate(DeleteVoltageAdjusterDynamicsCommand voltageAdjusterDynamics)
      throws Exception {
    Assert.notNull(voltageAdjusterDynamics, "{commandAlias} should not be null");
    Assert.notNull(
        voltageAdjusterDynamics.getVoltageAdjusterDynamicsId(),
        "DeleteVoltageAdjusterDynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a VoltageAdjusterDynamics */
  public void validate(VoltageAdjusterDynamicsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "VoltageAdjusterDynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getVoltageAdjusterDynamicsId(),
        "VoltageAdjusterDynamicsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign VoltageAdjusterDynamics validation for a VoltageAdjusterDynamics
   *
   * @param command AssignVoltageAdjusterDynamicsToVoltageAdjusterDynamicsCommand
   */
  public void validate(AssignVoltageAdjusterDynamicsToVoltageAdjusterDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignVoltageAdjusterDynamicsToVoltageAdjusterDynamicsCommand should not be null");
    Assert.notNull(
        command.getVoltageAdjusterDynamicsId(),
        "AssignVoltageAdjusterDynamicsToVoltageAdjusterDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVoltageAdjusterDynamicsToVoltageAdjusterDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign VoltageAdjusterDynamics validation for a VoltageAdjusterDynamics
   *
   * @param command UnAssignVoltageAdjusterDynamicsFromVoltageAdjusterDynamicsCommand
   */
  public void validate(UnAssignVoltageAdjusterDynamicsFromVoltageAdjusterDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignVoltageAdjusterDynamicsFromVoltageAdjusterDynamicsCommand should not be null");
    Assert.notNull(
        command.getVoltageAdjusterDynamicsId(),
        "UnAssignVoltageAdjusterDynamicsFromVoltageAdjusterDynamicsCommand identifier should not be null");
  }
}
