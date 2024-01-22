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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class TapScheduleValidator {

  /** default constructor */
  protected TapScheduleValidator() {}

  /** factory method */
  public static TapScheduleValidator getInstance() {
    return new TapScheduleValidator();
  }

  /** handles creation validation for a TapSchedule */
  public void validate(CreateTapScheduleCommand tapSchedule) throws Exception {
    Assert.notNull(tapSchedule, "CreateTapScheduleCommand should not be null");
    //		Assert.isNull( tapSchedule.getTapScheduleId(), "CreateTapScheduleCommand identifier should
    // be null" );
  }

  /** handles update validation for a TapSchedule */
  public void validate(UpdateTapScheduleCommand tapSchedule) throws Exception {
    Assert.notNull(tapSchedule, "UpdateTapScheduleCommand should not be null");
    Assert.notNull(
        tapSchedule.getTapScheduleId(), "UpdateTapScheduleCommand identifier should not be null");
  }

  /** handles delete validation for a TapSchedule */
  public void validate(DeleteTapScheduleCommand tapSchedule) throws Exception {
    Assert.notNull(tapSchedule, "{commandAlias} should not be null");
    Assert.notNull(
        tapSchedule.getTapScheduleId(), "DeleteTapScheduleCommand identifier should not be null");
  }

  /** handles fetchOne validation for a TapSchedule */
  public void validate(TapScheduleFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TapScheduleFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTapScheduleId(), "TapScheduleFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to TapSchedules validation for a TapSchedule
   *
   * @param command AssignTapSchedulesToTapScheduleCommand
   */
  public void validate(AssignTapSchedulesToTapScheduleCommand command) throws Exception {
    Assert.notNull(command, "AssignTapSchedulesToTapScheduleCommand should not be null");
    Assert.notNull(
        command.getTapScheduleId(),
        "AssignTapSchedulesToTapScheduleCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignTapSchedulesToTapScheduleCommand addTo attribute should not be null");
  }

  /**
   * handles remove from TapSchedules validation for a TapSchedule
   *
   * @param command RemoveTapSchedulesFromTapScheduleCommand
   */
  public void validate(RemoveTapSchedulesFromTapScheduleCommand command) throws Exception {
    Assert.notNull(command, "RemoveTapSchedulesFromTapScheduleCommand should not be null");
    Assert.notNull(
        command.getTapScheduleId(),
        "RemoveTapSchedulesFromTapScheduleCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveTapSchedulesFromTapScheduleCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getTapScheduleId(),
        "RemoveTapSchedulesFromTapScheduleCommand removeFrom attribubte identifier should not be null");
  }
}
