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

public class ActivePowerValidator {

  /** default constructor */
  protected ActivePowerValidator() {}

  /** factory method */
  public static ActivePowerValidator getInstance() {
    return new ActivePowerValidator();
  }

  /** handles creation validation for a ActivePower */
  public void validate(CreateActivePowerCommand activePower) throws Exception {
    Assert.notNull(activePower, "CreateActivePowerCommand should not be null");
    //		Assert.isNull( activePower.getActivePowerId(), "CreateActivePowerCommand identifier should
    // be null" );
  }

  /** handles update validation for a ActivePower */
  public void validate(UpdateActivePowerCommand activePower) throws Exception {
    Assert.notNull(activePower, "UpdateActivePowerCommand should not be null");
    Assert.notNull(
        activePower.getActivePowerId(), "UpdateActivePowerCommand identifier should not be null");
  }

  /** handles delete validation for a ActivePower */
  public void validate(DeleteActivePowerCommand activePower) throws Exception {
    Assert.notNull(activePower, "{commandAlias} should not be null");
    Assert.notNull(
        activePower.getActivePowerId(), "DeleteActivePowerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ActivePower */
  public void validate(ActivePowerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ActivePowerFetchOneSummary should not be null");
    Assert.notNull(
        summary.getActivePowerId(), "ActivePowerFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a ActivePower
   *
   * @param command AssignValueToActivePowerCommand
   */
  public void validate(AssignValueToActivePowerCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToActivePowerCommand should not be null");
    Assert.notNull(
        command.getActivePowerId(),
        "AssignValueToActivePowerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToActivePowerCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a ActivePower
   *
   * @param command UnAssignValueFromActivePowerCommand
   */
  public void validate(UnAssignValueFromActivePowerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromActivePowerCommand should not be null");
    Assert.notNull(
        command.getActivePowerId(),
        "UnAssignValueFromActivePowerCommand identifier should not be null");
  }
}
