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

public class ConformLoadScheduleValidator {

  /** default constructor */
  protected ConformLoadScheduleValidator() {}

  /** factory method */
  public static ConformLoadScheduleValidator getInstance() {
    return new ConformLoadScheduleValidator();
  }

  /** handles creation validation for a ConformLoadSchedule */
  public void validate(CreateConformLoadScheduleCommand conformLoadSchedule) throws Exception {
    Assert.notNull(conformLoadSchedule, "CreateConformLoadScheduleCommand should not be null");
    //		Assert.isNull( conformLoadSchedule.getConformLoadScheduleId(),
    // "CreateConformLoadScheduleCommand identifier should be null" );
  }

  /** handles update validation for a ConformLoadSchedule */
  public void validate(UpdateConformLoadScheduleCommand conformLoadSchedule) throws Exception {
    Assert.notNull(conformLoadSchedule, "UpdateConformLoadScheduleCommand should not be null");
    Assert.notNull(
        conformLoadSchedule.getConformLoadScheduleId(),
        "UpdateConformLoadScheduleCommand identifier should not be null");
  }

  /** handles delete validation for a ConformLoadSchedule */
  public void validate(DeleteConformLoadScheduleCommand conformLoadSchedule) throws Exception {
    Assert.notNull(conformLoadSchedule, "{commandAlias} should not be null");
    Assert.notNull(
        conformLoadSchedule.getConformLoadScheduleId(),
        "DeleteConformLoadScheduleCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ConformLoadSchedule */
  public void validate(ConformLoadScheduleFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ConformLoadScheduleFetchOneSummary should not be null");
    Assert.notNull(
        summary.getConformLoadScheduleId(),
        "ConformLoadScheduleFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to ConformLoadSchedules validation for a ConformLoadSchedule
   *
   * @param command AssignConformLoadSchedulesToConformLoadScheduleCommand
   */
  public void validate(AssignConformLoadSchedulesToConformLoadScheduleCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignConformLoadSchedulesToConformLoadScheduleCommand should not be null");
    Assert.notNull(
        command.getConformLoadScheduleId(),
        "AssignConformLoadSchedulesToConformLoadScheduleCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignConformLoadSchedulesToConformLoadScheduleCommand addTo attribute should not be null");
  }

  /**
   * handles remove from ConformLoadSchedules validation for a ConformLoadSchedule
   *
   * @param command RemoveConformLoadSchedulesFromConformLoadScheduleCommand
   */
  public void validate(RemoveConformLoadSchedulesFromConformLoadScheduleCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveConformLoadSchedulesFromConformLoadScheduleCommand should not be null");
    Assert.notNull(
        command.getConformLoadScheduleId(),
        "RemoveConformLoadSchedulesFromConformLoadScheduleCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveConformLoadSchedulesFromConformLoadScheduleCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getConformLoadScheduleId(),
        "RemoveConformLoadSchedulesFromConformLoadScheduleCommand removeFrom attribubte identifier should not be null");
  }
}
