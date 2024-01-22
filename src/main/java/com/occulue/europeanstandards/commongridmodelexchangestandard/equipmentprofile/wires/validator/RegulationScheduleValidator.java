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

public class RegulationScheduleValidator {

  /** default constructor */
  protected RegulationScheduleValidator() {}

  /** factory method */
  public static RegulationScheduleValidator getInstance() {
    return new RegulationScheduleValidator();
  }

  /** handles creation validation for a RegulationSchedule */
  public void validate(CreateRegulationScheduleCommand regulationSchedule) throws Exception {
    Assert.notNull(regulationSchedule, "CreateRegulationScheduleCommand should not be null");
    //		Assert.isNull( regulationSchedule.getRegulationScheduleId(),
    // "CreateRegulationScheduleCommand identifier should be null" );
  }

  /** handles update validation for a RegulationSchedule */
  public void validate(UpdateRegulationScheduleCommand regulationSchedule) throws Exception {
    Assert.notNull(regulationSchedule, "UpdateRegulationScheduleCommand should not be null");
    Assert.notNull(
        regulationSchedule.getRegulationScheduleId(),
        "UpdateRegulationScheduleCommand identifier should not be null");
  }

  /** handles delete validation for a RegulationSchedule */
  public void validate(DeleteRegulationScheduleCommand regulationSchedule) throws Exception {
    Assert.notNull(regulationSchedule, "{commandAlias} should not be null");
    Assert.notNull(
        regulationSchedule.getRegulationScheduleId(),
        "DeleteRegulationScheduleCommand identifier should not be null");
  }

  /** handles fetchOne validation for a RegulationSchedule */
  public void validate(RegulationScheduleFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "RegulationScheduleFetchOneSummary should not be null");
    Assert.notNull(
        summary.getRegulationScheduleId(),
        "RegulationScheduleFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to RegulationSchedule validation for a RegulationSchedule
   *
   * @param command AssignRegulationScheduleToRegulationScheduleCommand
   */
  public void validate(AssignRegulationScheduleToRegulationScheduleCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignRegulationScheduleToRegulationScheduleCommand should not be null");
    Assert.notNull(
        command.getRegulationScheduleId(),
        "AssignRegulationScheduleToRegulationScheduleCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignRegulationScheduleToRegulationScheduleCommand addTo attribute should not be null");
  }

  /**
   * handles remove from RegulationSchedule validation for a RegulationSchedule
   *
   * @param command RemoveRegulationScheduleFromRegulationScheduleCommand
   */
  public void validate(RemoveRegulationScheduleFromRegulationScheduleCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemoveRegulationScheduleFromRegulationScheduleCommand should not be null");
    Assert.notNull(
        command.getRegulationScheduleId(),
        "RemoveRegulationScheduleFromRegulationScheduleCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveRegulationScheduleFromRegulationScheduleCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getRegulationScheduleId(),
        "RemoveRegulationScheduleFromRegulationScheduleCommand removeFrom attribubte identifier should not be null");
  }
}
