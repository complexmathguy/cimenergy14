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

public class AngleDegreesValidator {

  /** default constructor */
  protected AngleDegreesValidator() {}

  /** factory method */
  public static AngleDegreesValidator getInstance() {
    return new AngleDegreesValidator();
  }

  /** handles creation validation for a AngleDegrees */
  public void validate(CreateAngleDegreesCommand angleDegrees) throws Exception {
    Assert.notNull(angleDegrees, "CreateAngleDegreesCommand should not be null");
    //		Assert.isNull( angleDegrees.getAngleDegreesId(), "CreateAngleDegreesCommand identifier
    // should be null" );
  }

  /** handles update validation for a AngleDegrees */
  public void validate(UpdateAngleDegreesCommand angleDegrees) throws Exception {
    Assert.notNull(angleDegrees, "UpdateAngleDegreesCommand should not be null");
    Assert.notNull(
        angleDegrees.getAngleDegreesId(),
        "UpdateAngleDegreesCommand identifier should not be null");
  }

  /** handles delete validation for a AngleDegrees */
  public void validate(DeleteAngleDegreesCommand angleDegrees) throws Exception {
    Assert.notNull(angleDegrees, "{commandAlias} should not be null");
    Assert.notNull(
        angleDegrees.getAngleDegreesId(),
        "DeleteAngleDegreesCommand identifier should not be null");
  }

  /** handles fetchOne validation for a AngleDegrees */
  public void validate(AngleDegreesFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "AngleDegreesFetchOneSummary should not be null");
    Assert.notNull(
        summary.getAngleDegreesId(), "AngleDegreesFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a AngleDegrees
   *
   * @param command AssignValueToAngleDegreesCommand
   */
  public void validate(AssignValueToAngleDegreesCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToAngleDegreesCommand should not be null");
    Assert.notNull(
        command.getAngleDegreesId(),
        "AssignValueToAngleDegreesCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToAngleDegreesCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a AngleDegrees
   *
   * @param command UnAssignValueFromAngleDegreesCommand
   */
  public void validate(UnAssignValueFromAngleDegreesCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromAngleDegreesCommand should not be null");
    Assert.notNull(
        command.getAngleDegreesId(),
        "UnAssignValueFromAngleDegreesCommand identifier should not be null");
  }
}
