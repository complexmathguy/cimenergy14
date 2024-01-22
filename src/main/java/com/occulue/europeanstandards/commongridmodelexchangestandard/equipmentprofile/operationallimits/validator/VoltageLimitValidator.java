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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class VoltageLimitValidator {

  /** default constructor */
  protected VoltageLimitValidator() {}

  /** factory method */
  public static VoltageLimitValidator getInstance() {
    return new VoltageLimitValidator();
  }

  /** handles creation validation for a VoltageLimit */
  public void validate(CreateVoltageLimitCommand voltageLimit) throws Exception {
    Assert.notNull(voltageLimit, "CreateVoltageLimitCommand should not be null");
    //		Assert.isNull( voltageLimit.getVoltageLimitId(), "CreateVoltageLimitCommand identifier
    // should be null" );
  }

  /** handles update validation for a VoltageLimit */
  public void validate(UpdateVoltageLimitCommand voltageLimit) throws Exception {
    Assert.notNull(voltageLimit, "UpdateVoltageLimitCommand should not be null");
    Assert.notNull(
        voltageLimit.getVoltageLimitId(),
        "UpdateVoltageLimitCommand identifier should not be null");
  }

  /** handles delete validation for a VoltageLimit */
  public void validate(DeleteVoltageLimitCommand voltageLimit) throws Exception {
    Assert.notNull(voltageLimit, "{commandAlias} should not be null");
    Assert.notNull(
        voltageLimit.getVoltageLimitId(),
        "DeleteVoltageLimitCommand identifier should not be null");
  }

  /** handles fetchOne validation for a VoltageLimit */
  public void validate(VoltageLimitFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "VoltageLimitFetchOneSummary should not be null");
    Assert.notNull(
        summary.getVoltageLimitId(), "VoltageLimitFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a VoltageLimit
   *
   * @param command AssignValueToVoltageLimitCommand
   */
  public void validate(AssignValueToVoltageLimitCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToVoltageLimitCommand should not be null");
    Assert.notNull(
        command.getVoltageLimitId(),
        "AssignValueToVoltageLimitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToVoltageLimitCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a VoltageLimit
   *
   * @param command UnAssignValueFromVoltageLimitCommand
   */
  public void validate(UnAssignValueFromVoltageLimitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromVoltageLimitCommand should not be null");
    Assert.notNull(
        command.getVoltageLimitId(),
        "UnAssignValueFromVoltageLimitCommand identifier should not be null");
  }
}
