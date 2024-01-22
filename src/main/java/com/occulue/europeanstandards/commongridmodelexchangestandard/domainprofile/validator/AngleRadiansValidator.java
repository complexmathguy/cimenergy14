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

public class AngleRadiansValidator {

  /** default constructor */
  protected AngleRadiansValidator() {}

  /** factory method */
  public static AngleRadiansValidator getInstance() {
    return new AngleRadiansValidator();
  }

  /** handles creation validation for a AngleRadians */
  public void validate(CreateAngleRadiansCommand angleRadians) throws Exception {
    Assert.notNull(angleRadians, "CreateAngleRadiansCommand should not be null");
    //		Assert.isNull( angleRadians.getAngleRadiansId(), "CreateAngleRadiansCommand identifier
    // should be null" );
  }

  /** handles update validation for a AngleRadians */
  public void validate(UpdateAngleRadiansCommand angleRadians) throws Exception {
    Assert.notNull(angleRadians, "UpdateAngleRadiansCommand should not be null");
    Assert.notNull(
        angleRadians.getAngleRadiansId(),
        "UpdateAngleRadiansCommand identifier should not be null");
  }

  /** handles delete validation for a AngleRadians */
  public void validate(DeleteAngleRadiansCommand angleRadians) throws Exception {
    Assert.notNull(angleRadians, "{commandAlias} should not be null");
    Assert.notNull(
        angleRadians.getAngleRadiansId(),
        "DeleteAngleRadiansCommand identifier should not be null");
  }

  /** handles fetchOne validation for a AngleRadians */
  public void validate(AngleRadiansFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "AngleRadiansFetchOneSummary should not be null");
    Assert.notNull(
        summary.getAngleRadiansId(), "AngleRadiansFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a AngleRadians
   *
   * @param command AssignValueToAngleRadiansCommand
   */
  public void validate(AssignValueToAngleRadiansCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToAngleRadiansCommand should not be null");
    Assert.notNull(
        command.getAngleRadiansId(),
        "AssignValueToAngleRadiansCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToAngleRadiansCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a AngleRadians
   *
   * @param command UnAssignValueFromAngleRadiansCommand
   */
  public void validate(UnAssignValueFromAngleRadiansCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromAngleRadiansCommand should not be null");
    Assert.notNull(
        command.getAngleRadiansId(),
        "UnAssignValueFromAngleRadiansCommand identifier should not be null");
  }
}
