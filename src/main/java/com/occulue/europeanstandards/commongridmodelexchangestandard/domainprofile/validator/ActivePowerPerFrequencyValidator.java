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

public class ActivePowerPerFrequencyValidator {

  /** default constructor */
  protected ActivePowerPerFrequencyValidator() {}

  /** factory method */
  public static ActivePowerPerFrequencyValidator getInstance() {
    return new ActivePowerPerFrequencyValidator();
  }

  /** handles creation validation for a ActivePowerPerFrequency */
  public void validate(CreateActivePowerPerFrequencyCommand activePowerPerFrequency)
      throws Exception {
    Assert.notNull(
        activePowerPerFrequency, "CreateActivePowerPerFrequencyCommand should not be null");
    //		Assert.isNull( activePowerPerFrequency.getActivePowerPerFrequencyId(),
    // "CreateActivePowerPerFrequencyCommand identifier should be null" );
  }

  /** handles update validation for a ActivePowerPerFrequency */
  public void validate(UpdateActivePowerPerFrequencyCommand activePowerPerFrequency)
      throws Exception {
    Assert.notNull(
        activePowerPerFrequency, "UpdateActivePowerPerFrequencyCommand should not be null");
    Assert.notNull(
        activePowerPerFrequency.getActivePowerPerFrequencyId(),
        "UpdateActivePowerPerFrequencyCommand identifier should not be null");
  }

  /** handles delete validation for a ActivePowerPerFrequency */
  public void validate(DeleteActivePowerPerFrequencyCommand activePowerPerFrequency)
      throws Exception {
    Assert.notNull(activePowerPerFrequency, "{commandAlias} should not be null");
    Assert.notNull(
        activePowerPerFrequency.getActivePowerPerFrequencyId(),
        "DeleteActivePowerPerFrequencyCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ActivePowerPerFrequency */
  public void validate(ActivePowerPerFrequencyFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ActivePowerPerFrequencyFetchOneSummary should not be null");
    Assert.notNull(
        summary.getActivePowerPerFrequencyId(),
        "ActivePowerPerFrequencyFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a ActivePowerPerFrequency
   *
   * @param command AssignValueToActivePowerPerFrequencyCommand
   */
  public void validate(AssignValueToActivePowerPerFrequencyCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToActivePowerPerFrequencyCommand should not be null");
    Assert.notNull(
        command.getActivePowerPerFrequencyId(),
        "AssignValueToActivePowerPerFrequencyCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValueToActivePowerPerFrequencyCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a ActivePowerPerFrequency
   *
   * @param command UnAssignValueFromActivePowerPerFrequencyCommand
   */
  public void validate(UnAssignValueFromActivePowerPerFrequencyCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromActivePowerPerFrequencyCommand should not be null");
    Assert.notNull(
        command.getActivePowerPerFrequencyId(),
        "UnAssignValueFromActivePowerPerFrequencyCommand identifier should not be null");
  }
}
