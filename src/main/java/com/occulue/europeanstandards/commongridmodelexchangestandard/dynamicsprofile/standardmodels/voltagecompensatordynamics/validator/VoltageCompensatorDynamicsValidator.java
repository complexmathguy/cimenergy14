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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class VoltageCompensatorDynamicsValidator {

  /** default constructor */
  protected VoltageCompensatorDynamicsValidator() {}

  /** factory method */
  public static VoltageCompensatorDynamicsValidator getInstance() {
    return new VoltageCompensatorDynamicsValidator();
  }

  /** handles creation validation for a VoltageCompensatorDynamics */
  public void validate(CreateVoltageCompensatorDynamicsCommand voltageCompensatorDynamics)
      throws Exception {
    Assert.notNull(
        voltageCompensatorDynamics, "CreateVoltageCompensatorDynamicsCommand should not be null");
    //		Assert.isNull( voltageCompensatorDynamics.getVoltageCompensatorDynamicsId(),
    // "CreateVoltageCompensatorDynamicsCommand identifier should be null" );
  }

  /** handles update validation for a VoltageCompensatorDynamics */
  public void validate(UpdateVoltageCompensatorDynamicsCommand voltageCompensatorDynamics)
      throws Exception {
    Assert.notNull(
        voltageCompensatorDynamics, "UpdateVoltageCompensatorDynamicsCommand should not be null");
    Assert.notNull(
        voltageCompensatorDynamics.getVoltageCompensatorDynamicsId(),
        "UpdateVoltageCompensatorDynamicsCommand identifier should not be null");
  }

  /** handles delete validation for a VoltageCompensatorDynamics */
  public void validate(DeleteVoltageCompensatorDynamicsCommand voltageCompensatorDynamics)
      throws Exception {
    Assert.notNull(voltageCompensatorDynamics, "{commandAlias} should not be null");
    Assert.notNull(
        voltageCompensatorDynamics.getVoltageCompensatorDynamicsId(),
        "DeleteVoltageCompensatorDynamicsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a VoltageCompensatorDynamics */
  public void validate(VoltageCompensatorDynamicsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "VoltageCompensatorDynamicsFetchOneSummary should not be null");
    Assert.notNull(
        summary.getVoltageCompensatorDynamicsId(),
        "VoltageCompensatorDynamicsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign VoltageCompensatorDynamics validation for a VoltageCompensatorDynamics
   *
   * @param command AssignVoltageCompensatorDynamicsToVoltageCompensatorDynamicsCommand
   */
  public void validate(AssignVoltageCompensatorDynamicsToVoltageCompensatorDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignVoltageCompensatorDynamicsToVoltageCompensatorDynamicsCommand should not be null");
    Assert.notNull(
        command.getVoltageCompensatorDynamicsId(),
        "AssignVoltageCompensatorDynamicsToVoltageCompensatorDynamicsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVoltageCompensatorDynamicsToVoltageCompensatorDynamicsCommand assignment should not be null");
  }

  /**
   * handles unassign VoltageCompensatorDynamics validation for a VoltageCompensatorDynamics
   *
   * @param command UnAssignVoltageCompensatorDynamicsFromVoltageCompensatorDynamicsCommand
   */
  public void validate(
      UnAssignVoltageCompensatorDynamicsFromVoltageCompensatorDynamicsCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignVoltageCompensatorDynamicsFromVoltageCompensatorDynamicsCommand should not be null");
    Assert.notNull(
        command.getVoltageCompensatorDynamicsId(),
        "UnAssignVoltageCompensatorDynamicsFromVoltageCompensatorDynamicsCommand identifier should not be null");
  }
}
