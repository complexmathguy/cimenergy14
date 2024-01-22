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

public class VoltageValidator {

  /** default constructor */
  protected VoltageValidator() {}

  /** factory method */
  public static VoltageValidator getInstance() {
    return new VoltageValidator();
  }

  /** handles creation validation for a Voltage */
  public void validate(CreateVoltageCommand voltage) throws Exception {
    Assert.notNull(voltage, "CreateVoltageCommand should not be null");
    //		Assert.isNull( voltage.getVoltageId(), "CreateVoltageCommand identifier should be null" );
  }

  /** handles update validation for a Voltage */
  public void validate(UpdateVoltageCommand voltage) throws Exception {
    Assert.notNull(voltage, "UpdateVoltageCommand should not be null");
    Assert.notNull(voltage.getVoltageId(), "UpdateVoltageCommand identifier should not be null");
  }

  /** handles delete validation for a Voltage */
  public void validate(DeleteVoltageCommand voltage) throws Exception {
    Assert.notNull(voltage, "{commandAlias} should not be null");
    Assert.notNull(voltage.getVoltageId(), "DeleteVoltageCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Voltage */
  public void validate(VoltageFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "VoltageFetchOneSummary should not be null");
    Assert.notNull(summary.getVoltageId(), "VoltageFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a Voltage
   *
   * @param command AssignValueToVoltageCommand
   */
  public void validate(AssignValueToVoltageCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToVoltageCommand should not be null");
    Assert.notNull(
        command.getVoltageId(), "AssignValueToVoltageCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToVoltageCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a Voltage
   *
   * @param command UnAssignValueFromVoltageCommand
   */
  public void validate(UnAssignValueFromVoltageCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromVoltageCommand should not be null");
    Assert.notNull(
        command.getVoltageId(), "UnAssignValueFromVoltageCommand identifier should not be null");
  }
}
