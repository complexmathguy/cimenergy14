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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class SeasonDayTypeScheduleValidator {

  /** default constructor */
  protected SeasonDayTypeScheduleValidator() {}

  /** factory method */
  public static SeasonDayTypeScheduleValidator getInstance() {
    return new SeasonDayTypeScheduleValidator();
  }

  /** handles creation validation for a SeasonDayTypeSchedule */
  public void validate(CreateSeasonDayTypeScheduleCommand seasonDayTypeSchedule) throws Exception {
    Assert.notNull(seasonDayTypeSchedule, "CreateSeasonDayTypeScheduleCommand should not be null");
    //		Assert.isNull( seasonDayTypeSchedule.getSeasonDayTypeScheduleId(),
    // "CreateSeasonDayTypeScheduleCommand identifier should be null" );
  }

  /** handles update validation for a SeasonDayTypeSchedule */
  public void validate(UpdateSeasonDayTypeScheduleCommand seasonDayTypeSchedule) throws Exception {
    Assert.notNull(seasonDayTypeSchedule, "UpdateSeasonDayTypeScheduleCommand should not be null");
    Assert.notNull(
        seasonDayTypeSchedule.getSeasonDayTypeScheduleId(),
        "UpdateSeasonDayTypeScheduleCommand identifier should not be null");
  }

  /** handles delete validation for a SeasonDayTypeSchedule */
  public void validate(DeleteSeasonDayTypeScheduleCommand seasonDayTypeSchedule) throws Exception {
    Assert.notNull(seasonDayTypeSchedule, "{commandAlias} should not be null");
    Assert.notNull(
        seasonDayTypeSchedule.getSeasonDayTypeScheduleId(),
        "DeleteSeasonDayTypeScheduleCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SeasonDayTypeSchedule */
  public void validate(SeasonDayTypeScheduleFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SeasonDayTypeScheduleFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSeasonDayTypeScheduleId(),
        "SeasonDayTypeScheduleFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to SeasonDayTypeSchedules validation for a SeasonDayTypeSchedule
   *
   * @param command AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleCommand
   */
  public void validate(AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleCommand should not be null");
    Assert.notNull(
        command.getSeasonDayTypeScheduleId(),
        "AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignSeasonDayTypeSchedulesToSeasonDayTypeScheduleCommand addTo attribute should not be null");
  }

  /**
   * handles remove from SeasonDayTypeSchedules validation for a SeasonDayTypeSchedule
   *
   * @param command RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleCommand
   */
  public void validate(RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleCommand should not be null");
    Assert.notNull(
        command.getSeasonDayTypeScheduleId(),
        "RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getSeasonDayTypeScheduleId(),
        "RemoveSeasonDayTypeSchedulesFromSeasonDayTypeScheduleCommand removeFrom attribubte identifier should not be null");
  }
}
