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

public class SwitchScheduleValidator {

  /** default constructor */
  protected SwitchScheduleValidator() {}

  /** factory method */
  public static SwitchScheduleValidator getInstance() {
    return new SwitchScheduleValidator();
  }

  /** handles creation validation for a SwitchSchedule */
  public void validate(CreateSwitchScheduleCommand switchSchedule) throws Exception {
    Assert.notNull(switchSchedule, "CreateSwitchScheduleCommand should not be null");
    //		Assert.isNull( switchSchedule.getSwitchScheduleId(), "CreateSwitchScheduleCommand identifier
    // should be null" );
  }

  /** handles update validation for a SwitchSchedule */
  public void validate(UpdateSwitchScheduleCommand switchSchedule) throws Exception {
    Assert.notNull(switchSchedule, "UpdateSwitchScheduleCommand should not be null");
    Assert.notNull(
        switchSchedule.getSwitchScheduleId(),
        "UpdateSwitchScheduleCommand identifier should not be null");
  }

  /** handles delete validation for a SwitchSchedule */
  public void validate(DeleteSwitchScheduleCommand switchSchedule) throws Exception {
    Assert.notNull(switchSchedule, "{commandAlias} should not be null");
    Assert.notNull(
        switchSchedule.getSwitchScheduleId(),
        "DeleteSwitchScheduleCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SwitchSchedule */
  public void validate(SwitchScheduleFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SwitchScheduleFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSwitchScheduleId(),
        "SwitchScheduleFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to SwitchSchedules validation for a SwitchSchedule
   *
   * @param command AssignSwitchSchedulesToSwitchScheduleCommand
   */
  public void validate(AssignSwitchSchedulesToSwitchScheduleCommand command) throws Exception {
    Assert.notNull(command, "AssignSwitchSchedulesToSwitchScheduleCommand should not be null");
    Assert.notNull(
        command.getSwitchScheduleId(),
        "AssignSwitchSchedulesToSwitchScheduleCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignSwitchSchedulesToSwitchScheduleCommand addTo attribute should not be null");
  }

  /**
   * handles remove from SwitchSchedules validation for a SwitchSchedule
   *
   * @param command RemoveSwitchSchedulesFromSwitchScheduleCommand
   */
  public void validate(RemoveSwitchSchedulesFromSwitchScheduleCommand command) throws Exception {
    Assert.notNull(command, "RemoveSwitchSchedulesFromSwitchScheduleCommand should not be null");
    Assert.notNull(
        command.getSwitchScheduleId(),
        "RemoveSwitchSchedulesFromSwitchScheduleCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveSwitchSchedulesFromSwitchScheduleCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getSwitchScheduleId(),
        "RemoveSwitchSchedulesFromSwitchScheduleCommand removeFrom attribubte identifier should not be null");
  }
}
