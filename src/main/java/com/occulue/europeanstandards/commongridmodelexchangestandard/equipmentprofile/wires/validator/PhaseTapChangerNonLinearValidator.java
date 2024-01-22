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

public class PhaseTapChangerNonLinearValidator {

  /** default constructor */
  protected PhaseTapChangerNonLinearValidator() {}

  /** factory method */
  public static PhaseTapChangerNonLinearValidator getInstance() {
    return new PhaseTapChangerNonLinearValidator();
  }

  /** handles creation validation for a PhaseTapChangerNonLinear */
  public void validate(CreatePhaseTapChangerNonLinearCommand phaseTapChangerNonLinear)
      throws Exception {
    Assert.notNull(
        phaseTapChangerNonLinear, "CreatePhaseTapChangerNonLinearCommand should not be null");
    //		Assert.isNull( phaseTapChangerNonLinear.getPhaseTapChangerNonLinearId(),
    // "CreatePhaseTapChangerNonLinearCommand identifier should be null" );
  }

  /** handles update validation for a PhaseTapChangerNonLinear */
  public void validate(UpdatePhaseTapChangerNonLinearCommand phaseTapChangerNonLinear)
      throws Exception {
    Assert.notNull(
        phaseTapChangerNonLinear, "UpdatePhaseTapChangerNonLinearCommand should not be null");
    Assert.notNull(
        phaseTapChangerNonLinear.getPhaseTapChangerNonLinearId(),
        "UpdatePhaseTapChangerNonLinearCommand identifier should not be null");
  }

  /** handles delete validation for a PhaseTapChangerNonLinear */
  public void validate(DeletePhaseTapChangerNonLinearCommand phaseTapChangerNonLinear)
      throws Exception {
    Assert.notNull(phaseTapChangerNonLinear, "{commandAlias} should not be null");
    Assert.notNull(
        phaseTapChangerNonLinear.getPhaseTapChangerNonLinearId(),
        "DeletePhaseTapChangerNonLinearCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PhaseTapChangerNonLinear */
  public void validate(PhaseTapChangerNonLinearFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PhaseTapChangerNonLinearFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPhaseTapChangerNonLinearId(),
        "PhaseTapChangerNonLinearFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign VoltageStepIncrement validation for a PhaseTapChangerNonLinear
   *
   * @param command AssignVoltageStepIncrementToPhaseTapChangerNonLinearCommand
   */
  public void validate(AssignVoltageStepIncrementToPhaseTapChangerNonLinearCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignVoltageStepIncrementToPhaseTapChangerNonLinearCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerNonLinearId(),
        "AssignVoltageStepIncrementToPhaseTapChangerNonLinearCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVoltageStepIncrementToPhaseTapChangerNonLinearCommand assignment should not be null");
  }

  /**
   * handles unassign VoltageStepIncrement validation for a PhaseTapChangerNonLinear
   *
   * @param command UnAssignVoltageStepIncrementFromPhaseTapChangerNonLinearCommand
   */
  public void validate(UnAssignVoltageStepIncrementFromPhaseTapChangerNonLinearCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignVoltageStepIncrementFromPhaseTapChangerNonLinearCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerNonLinearId(),
        "UnAssignVoltageStepIncrementFromPhaseTapChangerNonLinearCommand identifier should not be null");
  }
  /**
   * handles assign XMax validation for a PhaseTapChangerNonLinear
   *
   * @param command AssignXMaxToPhaseTapChangerNonLinearCommand
   */
  public void validate(AssignXMaxToPhaseTapChangerNonLinearCommand command) throws Exception {
    Assert.notNull(command, "AssignXMaxToPhaseTapChangerNonLinearCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerNonLinearId(),
        "AssignXMaxToPhaseTapChangerNonLinearCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXMaxToPhaseTapChangerNonLinearCommand assignment should not be null");
  }

  /**
   * handles unassign XMax validation for a PhaseTapChangerNonLinear
   *
   * @param command UnAssignXMaxFromPhaseTapChangerNonLinearCommand
   */
  public void validate(UnAssignXMaxFromPhaseTapChangerNonLinearCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXMaxFromPhaseTapChangerNonLinearCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerNonLinearId(),
        "UnAssignXMaxFromPhaseTapChangerNonLinearCommand identifier should not be null");
  }
  /**
   * handles assign XMin validation for a PhaseTapChangerNonLinear
   *
   * @param command AssignXMinToPhaseTapChangerNonLinearCommand
   */
  public void validate(AssignXMinToPhaseTapChangerNonLinearCommand command) throws Exception {
    Assert.notNull(command, "AssignXMinToPhaseTapChangerNonLinearCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerNonLinearId(),
        "AssignXMinToPhaseTapChangerNonLinearCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXMinToPhaseTapChangerNonLinearCommand assignment should not be null");
  }

  /**
   * handles unassign XMin validation for a PhaseTapChangerNonLinear
   *
   * @param command UnAssignXMinFromPhaseTapChangerNonLinearCommand
   */
  public void validate(UnAssignXMinFromPhaseTapChangerNonLinearCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXMinFromPhaseTapChangerNonLinearCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerNonLinearId(),
        "UnAssignXMinFromPhaseTapChangerNonLinearCommand identifier should not be null");
  }
}
