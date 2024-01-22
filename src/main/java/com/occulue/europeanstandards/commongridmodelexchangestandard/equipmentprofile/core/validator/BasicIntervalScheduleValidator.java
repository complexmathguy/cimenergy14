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

public class BasicIntervalScheduleValidator {

  /** default constructor */
  protected BasicIntervalScheduleValidator() {}

  /** factory method */
  public static BasicIntervalScheduleValidator getInstance() {
    return new BasicIntervalScheduleValidator();
  }

  /** handles creation validation for a BasicIntervalSchedule */
  public void validate(CreateBasicIntervalScheduleCommand basicIntervalSchedule) throws Exception {
    Assert.notNull(basicIntervalSchedule, "CreateBasicIntervalScheduleCommand should not be null");
    //		Assert.isNull( basicIntervalSchedule.getBasicIntervalScheduleId(),
    // "CreateBasicIntervalScheduleCommand identifier should be null" );
  }

  /** handles update validation for a BasicIntervalSchedule */
  public void validate(UpdateBasicIntervalScheduleCommand basicIntervalSchedule) throws Exception {
    Assert.notNull(basicIntervalSchedule, "UpdateBasicIntervalScheduleCommand should not be null");
    Assert.notNull(
        basicIntervalSchedule.getBasicIntervalScheduleId(),
        "UpdateBasicIntervalScheduleCommand identifier should not be null");
  }

  /** handles delete validation for a BasicIntervalSchedule */
  public void validate(DeleteBasicIntervalScheduleCommand basicIntervalSchedule) throws Exception {
    Assert.notNull(basicIntervalSchedule, "{commandAlias} should not be null");
    Assert.notNull(
        basicIntervalSchedule.getBasicIntervalScheduleId(),
        "DeleteBasicIntervalScheduleCommand identifier should not be null");
  }

  /** handles fetchOne validation for a BasicIntervalSchedule */
  public void validate(BasicIntervalScheduleFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "BasicIntervalScheduleFetchOneSummary should not be null");
    Assert.notNull(
        summary.getBasicIntervalScheduleId(),
        "BasicIntervalScheduleFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign StartTime validation for a BasicIntervalSchedule
   *
   * @param command AssignStartTimeToBasicIntervalScheduleCommand
   */
  public void validate(AssignStartTimeToBasicIntervalScheduleCommand command) throws Exception {
    Assert.notNull(command, "AssignStartTimeToBasicIntervalScheduleCommand should not be null");
    Assert.notNull(
        command.getBasicIntervalScheduleId(),
        "AssignStartTimeToBasicIntervalScheduleCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignStartTimeToBasicIntervalScheduleCommand assignment should not be null");
  }

  /**
   * handles unassign StartTime validation for a BasicIntervalSchedule
   *
   * @param command UnAssignStartTimeFromBasicIntervalScheduleCommand
   */
  public void validate(UnAssignStartTimeFromBasicIntervalScheduleCommand command) throws Exception {
    Assert.notNull(command, "UnAssignStartTimeFromBasicIntervalScheduleCommand should not be null");
    Assert.notNull(
        command.getBasicIntervalScheduleId(),
        "UnAssignStartTimeFromBasicIntervalScheduleCommand identifier should not be null");
  }
}
