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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class RegularIntervalScheduleValidator {

  /** default constructor */
  protected RegularIntervalScheduleValidator() {}

  /** factory method */
  public static RegularIntervalScheduleValidator getInstance() {
    return new RegularIntervalScheduleValidator();
  }

  /** handles creation validation for a RegularIntervalSchedule */
  public void validate(CreateRegularIntervalScheduleCommand regularIntervalSchedule)
      throws Exception {
    Assert.notNull(
        regularIntervalSchedule, "CreateRegularIntervalScheduleCommand should not be null");
    //		Assert.isNull( regularIntervalSchedule.getRegularIntervalScheduleId(),
    // "CreateRegularIntervalScheduleCommand identifier should be null" );
  }

  /** handles update validation for a RegularIntervalSchedule */
  public void validate(UpdateRegularIntervalScheduleCommand regularIntervalSchedule)
      throws Exception {
    Assert.notNull(
        regularIntervalSchedule, "UpdateRegularIntervalScheduleCommand should not be null");
    Assert.notNull(
        regularIntervalSchedule.getRegularIntervalScheduleId(),
        "UpdateRegularIntervalScheduleCommand identifier should not be null");
  }

  /** handles delete validation for a RegularIntervalSchedule */
  public void validate(DeleteRegularIntervalScheduleCommand regularIntervalSchedule)
      throws Exception {
    Assert.notNull(regularIntervalSchedule, "{commandAlias} should not be null");
    Assert.notNull(
        regularIntervalSchedule.getRegularIntervalScheduleId(),
        "DeleteRegularIntervalScheduleCommand identifier should not be null");
  }

  /** handles fetchOne validation for a RegularIntervalSchedule */
  public void validate(RegularIntervalScheduleFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "RegularIntervalScheduleFetchOneSummary should not be null");
    Assert.notNull(
        summary.getRegularIntervalScheduleId(),
        "RegularIntervalScheduleFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign EndTime validation for a RegularIntervalSchedule
   *
   * @param command AssignEndTimeToRegularIntervalScheduleCommand
   */
  public void validate(AssignEndTimeToRegularIntervalScheduleCommand command) throws Exception {
    Assert.notNull(command, "AssignEndTimeToRegularIntervalScheduleCommand should not be null");
    Assert.notNull(
        command.getRegularIntervalScheduleId(),
        "AssignEndTimeToRegularIntervalScheduleCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEndTimeToRegularIntervalScheduleCommand assignment should not be null");
  }

  /**
   * handles unassign EndTime validation for a RegularIntervalSchedule
   *
   * @param command UnAssignEndTimeFromRegularIntervalScheduleCommand
   */
  public void validate(UnAssignEndTimeFromRegularIntervalScheduleCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEndTimeFromRegularIntervalScheduleCommand should not be null");
    Assert.notNull(
        command.getRegularIntervalScheduleId(),
        "UnAssignEndTimeFromRegularIntervalScheduleCommand identifier should not be null");
  }
  /**
   * handles assign TimeStep validation for a RegularIntervalSchedule
   *
   * @param command AssignTimeStepToRegularIntervalScheduleCommand
   */
  public void validate(AssignTimeStepToRegularIntervalScheduleCommand command) throws Exception {
    Assert.notNull(command, "AssignTimeStepToRegularIntervalScheduleCommand should not be null");
    Assert.notNull(
        command.getRegularIntervalScheduleId(),
        "AssignTimeStepToRegularIntervalScheduleCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTimeStepToRegularIntervalScheduleCommand assignment should not be null");
  }

  /**
   * handles unassign TimeStep validation for a RegularIntervalSchedule
   *
   * @param command UnAssignTimeStepFromRegularIntervalScheduleCommand
   */
  public void validate(UnAssignTimeStepFromRegularIntervalScheduleCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignTimeStepFromRegularIntervalScheduleCommand should not be null");
    Assert.notNull(
        command.getRegularIntervalScheduleId(),
        "UnAssignTimeStepFromRegularIntervalScheduleCommand identifier should not be null");
  }
}
