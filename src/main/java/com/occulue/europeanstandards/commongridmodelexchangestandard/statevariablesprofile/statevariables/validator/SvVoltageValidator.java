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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class SvVoltageValidator {

  /** default constructor */
  protected SvVoltageValidator() {}

  /** factory method */
  public static SvVoltageValidator getInstance() {
    return new SvVoltageValidator();
  }

  /** handles creation validation for a SvVoltage */
  public void validate(CreateSvVoltageCommand svVoltage) throws Exception {
    Assert.notNull(svVoltage, "CreateSvVoltageCommand should not be null");
    //		Assert.isNull( svVoltage.getSvVoltageId(), "CreateSvVoltageCommand identifier should be
    // null" );
  }

  /** handles update validation for a SvVoltage */
  public void validate(UpdateSvVoltageCommand svVoltage) throws Exception {
    Assert.notNull(svVoltage, "UpdateSvVoltageCommand should not be null");
    Assert.notNull(
        svVoltage.getSvVoltageId(), "UpdateSvVoltageCommand identifier should not be null");
  }

  /** handles delete validation for a SvVoltage */
  public void validate(DeleteSvVoltageCommand svVoltage) throws Exception {
    Assert.notNull(svVoltage, "{commandAlias} should not be null");
    Assert.notNull(
        svVoltage.getSvVoltageId(), "DeleteSvVoltageCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SvVoltage */
  public void validate(SvVoltageFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SvVoltageFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSvVoltageId(), "SvVoltageFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Angle validation for a SvVoltage
   *
   * @param command AssignAngleToSvVoltageCommand
   */
  public void validate(AssignAngleToSvVoltageCommand command) throws Exception {
    Assert.notNull(command, "AssignAngleToSvVoltageCommand should not be null");
    Assert.notNull(
        command.getSvVoltageId(), "AssignAngleToSvVoltageCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAngleToSvVoltageCommand assignment should not be null");
  }

  /**
   * handles unassign Angle validation for a SvVoltage
   *
   * @param command UnAssignAngleFromSvVoltageCommand
   */
  public void validate(UnAssignAngleFromSvVoltageCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAngleFromSvVoltageCommand should not be null");
    Assert.notNull(
        command.getSvVoltageId(),
        "UnAssignAngleFromSvVoltageCommand identifier should not be null");
  }
  /**
   * handles assign V validation for a SvVoltage
   *
   * @param command AssignVToSvVoltageCommand
   */
  public void validate(AssignVToSvVoltageCommand command) throws Exception {
    Assert.notNull(command, "AssignVToSvVoltageCommand should not be null");
    Assert.notNull(
        command.getSvVoltageId(), "AssignVToSvVoltageCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVToSvVoltageCommand assignment should not be null");
  }

  /**
   * handles unassign V validation for a SvVoltage
   *
   * @param command UnAssignVFromSvVoltageCommand
   */
  public void validate(UnAssignVFromSvVoltageCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVFromSvVoltageCommand should not be null");
    Assert.notNull(
        command.getSvVoltageId(), "UnAssignVFromSvVoltageCommand identifier should not be null");
  }
  /**
   * handles assign SvVoltage validation for a SvVoltage
   *
   * @param command AssignSvVoltageToSvVoltageCommand
   */
  public void validate(AssignSvVoltageToSvVoltageCommand command) throws Exception {
    Assert.notNull(command, "AssignSvVoltageToSvVoltageCommand should not be null");
    Assert.notNull(
        command.getSvVoltageId(),
        "AssignSvVoltageToSvVoltageCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSvVoltageToSvVoltageCommand assignment should not be null");
  }

  /**
   * handles unassign SvVoltage validation for a SvVoltage
   *
   * @param command UnAssignSvVoltageFromSvVoltageCommand
   */
  public void validate(UnAssignSvVoltageFromSvVoltageCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSvVoltageFromSvVoltageCommand should not be null");
    Assert.notNull(
        command.getSvVoltageId(),
        "UnAssignSvVoltageFromSvVoltageCommand identifier should not be null");
  }
}
