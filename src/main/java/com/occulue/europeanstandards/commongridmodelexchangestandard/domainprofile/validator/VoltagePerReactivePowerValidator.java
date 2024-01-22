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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class VoltagePerReactivePowerValidator {

  /** default constructor */
  protected VoltagePerReactivePowerValidator() {}

  /** factory method */
  public static VoltagePerReactivePowerValidator getInstance() {
    return new VoltagePerReactivePowerValidator();
  }

  /** handles creation validation for a VoltagePerReactivePower */
  public void validate(CreateVoltagePerReactivePowerCommand voltagePerReactivePower)
      throws Exception {
    Assert.notNull(
        voltagePerReactivePower, "CreateVoltagePerReactivePowerCommand should not be null");
    //		Assert.isNull( voltagePerReactivePower.getVoltagePerReactivePowerId(),
    // "CreateVoltagePerReactivePowerCommand identifier should be null" );
  }

  /** handles update validation for a VoltagePerReactivePower */
  public void validate(UpdateVoltagePerReactivePowerCommand voltagePerReactivePower)
      throws Exception {
    Assert.notNull(
        voltagePerReactivePower, "UpdateVoltagePerReactivePowerCommand should not be null");
    Assert.notNull(
        voltagePerReactivePower.getVoltagePerReactivePowerId(),
        "UpdateVoltagePerReactivePowerCommand identifier should not be null");
  }

  /** handles delete validation for a VoltagePerReactivePower */
  public void validate(DeleteVoltagePerReactivePowerCommand voltagePerReactivePower)
      throws Exception {
    Assert.notNull(voltagePerReactivePower, "{commandAlias} should not be null");
    Assert.notNull(
        voltagePerReactivePower.getVoltagePerReactivePowerId(),
        "DeleteVoltagePerReactivePowerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a VoltagePerReactivePower */
  public void validate(VoltagePerReactivePowerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "VoltagePerReactivePowerFetchOneSummary should not be null");
    Assert.notNull(
        summary.getVoltagePerReactivePowerId(),
        "VoltagePerReactivePowerFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a VoltagePerReactivePower
   *
   * @param command AssignValueToVoltagePerReactivePowerCommand
   */
  public void validate(AssignValueToVoltagePerReactivePowerCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToVoltagePerReactivePowerCommand should not be null");
    Assert.notNull(
        command.getVoltagePerReactivePowerId(),
        "AssignValueToVoltagePerReactivePowerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValueToVoltagePerReactivePowerCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a VoltagePerReactivePower
   *
   * @param command UnAssignValueFromVoltagePerReactivePowerCommand
   */
  public void validate(UnAssignValueFromVoltagePerReactivePowerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromVoltagePerReactivePowerCommand should not be null");
    Assert.notNull(
        command.getVoltagePerReactivePowerId(),
        "UnAssignValueFromVoltagePerReactivePowerCommand identifier should not be null");
  }
}
