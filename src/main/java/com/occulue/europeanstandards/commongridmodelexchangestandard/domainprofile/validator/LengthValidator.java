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

public class LengthValidator {

  /** default constructor */
  protected LengthValidator() {}

  /** factory method */
  public static LengthValidator getInstance() {
    return new LengthValidator();
  }

  /** handles creation validation for a Length */
  public void validate(CreateLengthCommand length) throws Exception {
    Assert.notNull(length, "CreateLengthCommand should not be null");
    //		Assert.isNull( length.getLengthId(), "CreateLengthCommand identifier should be null" );
  }

  /** handles update validation for a Length */
  public void validate(UpdateLengthCommand length) throws Exception {
    Assert.notNull(length, "UpdateLengthCommand should not be null");
    Assert.notNull(length.getLengthId(), "UpdateLengthCommand identifier should not be null");
  }

  /** handles delete validation for a Length */
  public void validate(DeleteLengthCommand length) throws Exception {
    Assert.notNull(length, "{commandAlias} should not be null");
    Assert.notNull(length.getLengthId(), "DeleteLengthCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Length */
  public void validate(LengthFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "LengthFetchOneSummary should not be null");
    Assert.notNull(summary.getLengthId(), "LengthFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a Length
   *
   * @param command AssignValueToLengthCommand
   */
  public void validate(AssignValueToLengthCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToLengthCommand should not be null");
    Assert.notNull(
        command.getLengthId(), "AssignValueToLengthCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToLengthCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a Length
   *
   * @param command UnAssignValueFromLengthCommand
   */
  public void validate(UnAssignValueFromLengthCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromLengthCommand should not be null");
    Assert.notNull(
        command.getLengthId(), "UnAssignValueFromLengthCommand identifier should not be null");
  }
}
