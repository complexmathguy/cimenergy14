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

public class NonConformLoadScheduleValidator {

  /** default constructor */
  protected NonConformLoadScheduleValidator() {}

  /** factory method */
  public static NonConformLoadScheduleValidator getInstance() {
    return new NonConformLoadScheduleValidator();
  }

  /** handles creation validation for a NonConformLoadSchedule */
  public void validate(CreateNonConformLoadScheduleCommand nonConformLoadSchedule)
      throws Exception {
    Assert.notNull(
        nonConformLoadSchedule, "CreateNonConformLoadScheduleCommand should not be null");
    //		Assert.isNull( nonConformLoadSchedule.getNonConformLoadScheduleId(),
    // "CreateNonConformLoadScheduleCommand identifier should be null" );
  }

  /** handles update validation for a NonConformLoadSchedule */
  public void validate(UpdateNonConformLoadScheduleCommand nonConformLoadSchedule)
      throws Exception {
    Assert.notNull(
        nonConformLoadSchedule, "UpdateNonConformLoadScheduleCommand should not be null");
    Assert.notNull(
        nonConformLoadSchedule.getNonConformLoadScheduleId(),
        "UpdateNonConformLoadScheduleCommand identifier should not be null");
  }

  /** handles delete validation for a NonConformLoadSchedule */
  public void validate(DeleteNonConformLoadScheduleCommand nonConformLoadSchedule)
      throws Exception {
    Assert.notNull(nonConformLoadSchedule, "{commandAlias} should not be null");
    Assert.notNull(
        nonConformLoadSchedule.getNonConformLoadScheduleId(),
        "DeleteNonConformLoadScheduleCommand identifier should not be null");
  }

  /** handles fetchOne validation for a NonConformLoadSchedule */
  public void validate(NonConformLoadScheduleFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "NonConformLoadScheduleFetchOneSummary should not be null");
    Assert.notNull(
        summary.getNonConformLoadScheduleId(),
        "NonConformLoadScheduleFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to NonConformLoadSchedules validation for a NonConformLoadSchedule
   *
   * @param command AssignNonConformLoadSchedulesToNonConformLoadScheduleCommand
   */
  public void validate(AssignNonConformLoadSchedulesToNonConformLoadScheduleCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignNonConformLoadSchedulesToNonConformLoadScheduleCommand should not be null");
    Assert.notNull(
        command.getNonConformLoadScheduleId(),
        "AssignNonConformLoadSchedulesToNonConformLoadScheduleCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignNonConformLoadSchedulesToNonConformLoadScheduleCommand addTo attribute should not be null");
  }

  /**
   * handles remove from NonConformLoadSchedules validation for a NonConformLoadSchedule
   *
   * @param command RemoveNonConformLoadSchedulesFromNonConformLoadScheduleCommand
   */
  public void validate(RemoveNonConformLoadSchedulesFromNonConformLoadScheduleCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "RemoveNonConformLoadSchedulesFromNonConformLoadScheduleCommand should not be null");
    Assert.notNull(
        command.getNonConformLoadScheduleId(),
        "RemoveNonConformLoadSchedulesFromNonConformLoadScheduleCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveNonConformLoadSchedulesFromNonConformLoadScheduleCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getNonConformLoadScheduleId(),
        "RemoveNonConformLoadSchedulesFromNonConformLoadScheduleCommand removeFrom attribubte identifier should not be null");
  }
}
