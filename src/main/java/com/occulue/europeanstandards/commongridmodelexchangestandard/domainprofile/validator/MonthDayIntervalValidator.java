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

public class MonthDayIntervalValidator {

  /** default constructor */
  protected MonthDayIntervalValidator() {}

  /** factory method */
  public static MonthDayIntervalValidator getInstance() {
    return new MonthDayIntervalValidator();
  }

  /** handles creation validation for a MonthDayInterval */
  public void validate(CreateMonthDayIntervalCommand monthDayInterval) throws Exception {
    Assert.notNull(monthDayInterval, "CreateMonthDayIntervalCommand should not be null");
    //		Assert.isNull( monthDayInterval.getMonthDayIntervalId(), "CreateMonthDayIntervalCommand
    // identifier should be null" );
  }

  /** handles update validation for a MonthDayInterval */
  public void validate(UpdateMonthDayIntervalCommand monthDayInterval) throws Exception {
    Assert.notNull(monthDayInterval, "UpdateMonthDayIntervalCommand should not be null");
    Assert.notNull(
        monthDayInterval.getMonthDayIntervalId(),
        "UpdateMonthDayIntervalCommand identifier should not be null");
  }

  /** handles delete validation for a MonthDayInterval */
  public void validate(DeleteMonthDayIntervalCommand monthDayInterval) throws Exception {
    Assert.notNull(monthDayInterval, "{commandAlias} should not be null");
    Assert.notNull(
        monthDayInterval.getMonthDayIntervalId(),
        "DeleteMonthDayIntervalCommand identifier should not be null");
  }

  /** handles fetchOne validation for a MonthDayInterval */
  public void validate(MonthDayIntervalFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "MonthDayIntervalFetchOneSummary should not be null");
    Assert.notNull(
        summary.getMonthDayIntervalId(),
        "MonthDayIntervalFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign End validation for a MonthDayInterval
   *
   * @param command AssignEndToMonthDayIntervalCommand
   */
  public void validate(AssignEndToMonthDayIntervalCommand command) throws Exception {
    Assert.notNull(command, "AssignEndToMonthDayIntervalCommand should not be null");
    Assert.notNull(
        command.getMonthDayIntervalId(),
        "AssignEndToMonthDayIntervalCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEndToMonthDayIntervalCommand assignment should not be null");
  }

  /**
   * handles unassign End validation for a MonthDayInterval
   *
   * @param command UnAssignEndFromMonthDayIntervalCommand
   */
  public void validate(UnAssignEndFromMonthDayIntervalCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEndFromMonthDayIntervalCommand should not be null");
    Assert.notNull(
        command.getMonthDayIntervalId(),
        "UnAssignEndFromMonthDayIntervalCommand identifier should not be null");
  }
  /**
   * handles assign Start validation for a MonthDayInterval
   *
   * @param command AssignStartToMonthDayIntervalCommand
   */
  public void validate(AssignStartToMonthDayIntervalCommand command) throws Exception {
    Assert.notNull(command, "AssignStartToMonthDayIntervalCommand should not be null");
    Assert.notNull(
        command.getMonthDayIntervalId(),
        "AssignStartToMonthDayIntervalCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignStartToMonthDayIntervalCommand assignment should not be null");
  }

  /**
   * handles unassign Start validation for a MonthDayInterval
   *
   * @param command UnAssignStartFromMonthDayIntervalCommand
   */
  public void validate(UnAssignStartFromMonthDayIntervalCommand command) throws Exception {
    Assert.notNull(command, "UnAssignStartFromMonthDayIntervalCommand should not be null");
    Assert.notNull(
        command.getMonthDayIntervalId(),
        "UnAssignStartFromMonthDayIntervalCommand identifier should not be null");
  }
}
