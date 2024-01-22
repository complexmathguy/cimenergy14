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

public class ActivePowerLimitValidator {

  /** default constructor */
  protected ActivePowerLimitValidator() {}

  /** factory method */
  public static ActivePowerLimitValidator getInstance() {
    return new ActivePowerLimitValidator();
  }

  /** handles creation validation for a ActivePowerLimit */
  public void validate(CreateActivePowerLimitCommand activePowerLimit) throws Exception {
    Assert.notNull(activePowerLimit, "CreateActivePowerLimitCommand should not be null");
    //		Assert.isNull( activePowerLimit.getActivePowerLimitId(), "CreateActivePowerLimitCommand
    // identifier should be null" );
  }

  /** handles update validation for a ActivePowerLimit */
  public void validate(UpdateActivePowerLimitCommand activePowerLimit) throws Exception {
    Assert.notNull(activePowerLimit, "UpdateActivePowerLimitCommand should not be null");
    Assert.notNull(
        activePowerLimit.getActivePowerLimitId(),
        "UpdateActivePowerLimitCommand identifier should not be null");
  }

  /** handles delete validation for a ActivePowerLimit */
  public void validate(DeleteActivePowerLimitCommand activePowerLimit) throws Exception {
    Assert.notNull(activePowerLimit, "{commandAlias} should not be null");
    Assert.notNull(
        activePowerLimit.getActivePowerLimitId(),
        "DeleteActivePowerLimitCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ActivePowerLimit */
  public void validate(ActivePowerLimitFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ActivePowerLimitFetchOneSummary should not be null");
    Assert.notNull(
        summary.getActivePowerLimitId(),
        "ActivePowerLimitFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a ActivePowerLimit
   *
   * @param command AssignValueToActivePowerLimitCommand
   */
  public void validate(AssignValueToActivePowerLimitCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToActivePowerLimitCommand should not be null");
    Assert.notNull(
        command.getActivePowerLimitId(),
        "AssignValueToActivePowerLimitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValueToActivePowerLimitCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a ActivePowerLimit
   *
   * @param command UnAssignValueFromActivePowerLimitCommand
   */
  public void validate(UnAssignValueFromActivePowerLimitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromActivePowerLimitCommand should not be null");
    Assert.notNull(
        command.getActivePowerLimitId(),
        "UnAssignValueFromActivePowerLimitCommand identifier should not be null");
  }
}
