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

public class ApparentPowerLimitValidator {

  /** default constructor */
  protected ApparentPowerLimitValidator() {}

  /** factory method */
  public static ApparentPowerLimitValidator getInstance() {
    return new ApparentPowerLimitValidator();
  }

  /** handles creation validation for a ApparentPowerLimit */
  public void validate(CreateApparentPowerLimitCommand apparentPowerLimit) throws Exception {
    Assert.notNull(apparentPowerLimit, "CreateApparentPowerLimitCommand should not be null");
    //		Assert.isNull( apparentPowerLimit.getApparentPowerLimitId(),
    // "CreateApparentPowerLimitCommand identifier should be null" );
  }

  /** handles update validation for a ApparentPowerLimit */
  public void validate(UpdateApparentPowerLimitCommand apparentPowerLimit) throws Exception {
    Assert.notNull(apparentPowerLimit, "UpdateApparentPowerLimitCommand should not be null");
    Assert.notNull(
        apparentPowerLimit.getApparentPowerLimitId(),
        "UpdateApparentPowerLimitCommand identifier should not be null");
  }

  /** handles delete validation for a ApparentPowerLimit */
  public void validate(DeleteApparentPowerLimitCommand apparentPowerLimit) throws Exception {
    Assert.notNull(apparentPowerLimit, "{commandAlias} should not be null");
    Assert.notNull(
        apparentPowerLimit.getApparentPowerLimitId(),
        "DeleteApparentPowerLimitCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ApparentPowerLimit */
  public void validate(ApparentPowerLimitFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ApparentPowerLimitFetchOneSummary should not be null");
    Assert.notNull(
        summary.getApparentPowerLimitId(),
        "ApparentPowerLimitFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a ApparentPowerLimit
   *
   * @param command AssignValueToApparentPowerLimitCommand
   */
  public void validate(AssignValueToApparentPowerLimitCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToApparentPowerLimitCommand should not be null");
    Assert.notNull(
        command.getApparentPowerLimitId(),
        "AssignValueToApparentPowerLimitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValueToApparentPowerLimitCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a ApparentPowerLimit
   *
   * @param command UnAssignValueFromApparentPowerLimitCommand
   */
  public void validate(UnAssignValueFromApparentPowerLimitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromApparentPowerLimitCommand should not be null");
    Assert.notNull(
        command.getApparentPowerLimitId(),
        "UnAssignValueFromApparentPowerLimitCommand identifier should not be null");
  }
}
