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

public class SecondsValidator {

  /** default constructor */
  protected SecondsValidator() {}

  /** factory method */
  public static SecondsValidator getInstance() {
    return new SecondsValidator();
  }

  /** handles creation validation for a Seconds */
  public void validate(CreateSecondsCommand seconds) throws Exception {
    Assert.notNull(seconds, "CreateSecondsCommand should not be null");
    //		Assert.isNull( seconds.getSecondsId(), "CreateSecondsCommand identifier should be null" );
  }

  /** handles update validation for a Seconds */
  public void validate(UpdateSecondsCommand seconds) throws Exception {
    Assert.notNull(seconds, "UpdateSecondsCommand should not be null");
    Assert.notNull(seconds.getSecondsId(), "UpdateSecondsCommand identifier should not be null");
  }

  /** handles delete validation for a Seconds */
  public void validate(DeleteSecondsCommand seconds) throws Exception {
    Assert.notNull(seconds, "{commandAlias} should not be null");
    Assert.notNull(seconds.getSecondsId(), "DeleteSecondsCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Seconds */
  public void validate(SecondsFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SecondsFetchOneSummary should not be null");
    Assert.notNull(summary.getSecondsId(), "SecondsFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a Seconds
   *
   * @param command AssignValueToSecondsCommand
   */
  public void validate(AssignValueToSecondsCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToSecondsCommand should not be null");
    Assert.notNull(
        command.getSecondsId(), "AssignValueToSecondsCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToSecondsCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a Seconds
   *
   * @param command UnAssignValueFromSecondsCommand
   */
  public void validate(UnAssignValueFromSecondsCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromSecondsCommand should not be null");
    Assert.notNull(
        command.getSecondsId(), "UnAssignValueFromSecondsCommand identifier should not be null");
  }
}
