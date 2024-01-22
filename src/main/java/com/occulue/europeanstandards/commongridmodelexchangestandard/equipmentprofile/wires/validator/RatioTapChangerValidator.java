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

public class RatioTapChangerValidator {

  /** default constructor */
  protected RatioTapChangerValidator() {}

  /** factory method */
  public static RatioTapChangerValidator getInstance() {
    return new RatioTapChangerValidator();
  }

  /** handles creation validation for a RatioTapChanger */
  public void validate(CreateRatioTapChangerCommand ratioTapChanger) throws Exception {
    Assert.notNull(ratioTapChanger, "CreateRatioTapChangerCommand should not be null");
    //		Assert.isNull( ratioTapChanger.getRatioTapChangerId(), "CreateRatioTapChangerCommand
    // identifier should be null" );
  }

  /** handles update validation for a RatioTapChanger */
  public void validate(UpdateRatioTapChangerCommand ratioTapChanger) throws Exception {
    Assert.notNull(ratioTapChanger, "UpdateRatioTapChangerCommand should not be null");
    Assert.notNull(
        ratioTapChanger.getRatioTapChangerId(),
        "UpdateRatioTapChangerCommand identifier should not be null");
  }

  /** handles delete validation for a RatioTapChanger */
  public void validate(DeleteRatioTapChangerCommand ratioTapChanger) throws Exception {
    Assert.notNull(ratioTapChanger, "{commandAlias} should not be null");
    Assert.notNull(
        ratioTapChanger.getRatioTapChangerId(),
        "DeleteRatioTapChangerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a RatioTapChanger */
  public void validate(RatioTapChangerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "RatioTapChangerFetchOneSummary should not be null");
    Assert.notNull(
        summary.getRatioTapChangerId(),
        "RatioTapChangerFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign StepVoltageIncrement validation for a RatioTapChanger
   *
   * @param command AssignStepVoltageIncrementToRatioTapChangerCommand
   */
  public void validate(AssignStepVoltageIncrementToRatioTapChangerCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignStepVoltageIncrementToRatioTapChangerCommand should not be null");
    Assert.notNull(
        command.getRatioTapChangerId(),
        "AssignStepVoltageIncrementToRatioTapChangerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignStepVoltageIncrementToRatioTapChangerCommand assignment should not be null");
  }

  /**
   * handles unassign StepVoltageIncrement validation for a RatioTapChanger
   *
   * @param command UnAssignStepVoltageIncrementFromRatioTapChangerCommand
   */
  public void validate(UnAssignStepVoltageIncrementFromRatioTapChangerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignStepVoltageIncrementFromRatioTapChangerCommand should not be null");
    Assert.notNull(
        command.getRatioTapChangerId(),
        "UnAssignStepVoltageIncrementFromRatioTapChangerCommand identifier should not be null");
  }
  /**
   * handles assign RatioTapChanger validation for a RatioTapChanger
   *
   * @param command AssignRatioTapChangerToRatioTapChangerCommand
   */
  public void validate(AssignRatioTapChangerToRatioTapChangerCommand command) throws Exception {
    Assert.notNull(command, "AssignRatioTapChangerToRatioTapChangerCommand should not be null");
    Assert.notNull(
        command.getRatioTapChangerId(),
        "AssignRatioTapChangerToRatioTapChangerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRatioTapChangerToRatioTapChangerCommand assignment should not be null");
  }

  /**
   * handles unassign RatioTapChanger validation for a RatioTapChanger
   *
   * @param command UnAssignRatioTapChangerFromRatioTapChangerCommand
   */
  public void validate(UnAssignRatioTapChangerFromRatioTapChangerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRatioTapChangerFromRatioTapChangerCommand should not be null");
    Assert.notNull(
        command.getRatioTapChangerId(),
        "UnAssignRatioTapChangerFromRatioTapChangerCommand identifier should not be null");
  }
}
