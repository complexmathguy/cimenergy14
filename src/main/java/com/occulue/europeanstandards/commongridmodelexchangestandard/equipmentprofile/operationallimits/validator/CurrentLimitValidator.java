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

public class CurrentLimitValidator {

  /** default constructor */
  protected CurrentLimitValidator() {}

  /** factory method */
  public static CurrentLimitValidator getInstance() {
    return new CurrentLimitValidator();
  }

  /** handles creation validation for a CurrentLimit */
  public void validate(CreateCurrentLimitCommand currentLimit) throws Exception {
    Assert.notNull(currentLimit, "CreateCurrentLimitCommand should not be null");
    //		Assert.isNull( currentLimit.getCurrentLimitId(), "CreateCurrentLimitCommand identifier
    // should be null" );
  }

  /** handles update validation for a CurrentLimit */
  public void validate(UpdateCurrentLimitCommand currentLimit) throws Exception {
    Assert.notNull(currentLimit, "UpdateCurrentLimitCommand should not be null");
    Assert.notNull(
        currentLimit.getCurrentLimitId(),
        "UpdateCurrentLimitCommand identifier should not be null");
  }

  /** handles delete validation for a CurrentLimit */
  public void validate(DeleteCurrentLimitCommand currentLimit) throws Exception {
    Assert.notNull(currentLimit, "{commandAlias} should not be null");
    Assert.notNull(
        currentLimit.getCurrentLimitId(),
        "DeleteCurrentLimitCommand identifier should not be null");
  }

  /** handles fetchOne validation for a CurrentLimit */
  public void validate(CurrentLimitFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "CurrentLimitFetchOneSummary should not be null");
    Assert.notNull(
        summary.getCurrentLimitId(), "CurrentLimitFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a CurrentLimit
   *
   * @param command AssignValueToCurrentLimitCommand
   */
  public void validate(AssignValueToCurrentLimitCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToCurrentLimitCommand should not be null");
    Assert.notNull(
        command.getCurrentLimitId(),
        "AssignValueToCurrentLimitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToCurrentLimitCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a CurrentLimit
   *
   * @param command UnAssignValueFromCurrentLimitCommand
   */
  public void validate(UnAssignValueFromCurrentLimitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromCurrentLimitCommand should not be null");
    Assert.notNull(
        command.getCurrentLimitId(),
        "UnAssignValueFromCurrentLimitCommand identifier should not be null");
  }
}
