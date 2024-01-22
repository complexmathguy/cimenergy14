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

public class PhaseTapChangerLinearValidator {

  /** default constructor */
  protected PhaseTapChangerLinearValidator() {}

  /** factory method */
  public static PhaseTapChangerLinearValidator getInstance() {
    return new PhaseTapChangerLinearValidator();
  }

  /** handles creation validation for a PhaseTapChangerLinear */
  public void validate(CreatePhaseTapChangerLinearCommand phaseTapChangerLinear) throws Exception {
    Assert.notNull(phaseTapChangerLinear, "CreatePhaseTapChangerLinearCommand should not be null");
    //		Assert.isNull( phaseTapChangerLinear.getPhaseTapChangerLinearId(),
    // "CreatePhaseTapChangerLinearCommand identifier should be null" );
  }

  /** handles update validation for a PhaseTapChangerLinear */
  public void validate(UpdatePhaseTapChangerLinearCommand phaseTapChangerLinear) throws Exception {
    Assert.notNull(phaseTapChangerLinear, "UpdatePhaseTapChangerLinearCommand should not be null");
    Assert.notNull(
        phaseTapChangerLinear.getPhaseTapChangerLinearId(),
        "UpdatePhaseTapChangerLinearCommand identifier should not be null");
  }

  /** handles delete validation for a PhaseTapChangerLinear */
  public void validate(DeletePhaseTapChangerLinearCommand phaseTapChangerLinear) throws Exception {
    Assert.notNull(phaseTapChangerLinear, "{commandAlias} should not be null");
    Assert.notNull(
        phaseTapChangerLinear.getPhaseTapChangerLinearId(),
        "DeletePhaseTapChangerLinearCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PhaseTapChangerLinear */
  public void validate(PhaseTapChangerLinearFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PhaseTapChangerLinearFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPhaseTapChangerLinearId(),
        "PhaseTapChangerLinearFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign StepPhaseShiftIncrement validation for a PhaseTapChangerLinear
   *
   * @param command AssignStepPhaseShiftIncrementToPhaseTapChangerLinearCommand
   */
  public void validate(AssignStepPhaseShiftIncrementToPhaseTapChangerLinearCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignStepPhaseShiftIncrementToPhaseTapChangerLinearCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerLinearId(),
        "AssignStepPhaseShiftIncrementToPhaseTapChangerLinearCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignStepPhaseShiftIncrementToPhaseTapChangerLinearCommand assignment should not be null");
  }

  /**
   * handles unassign StepPhaseShiftIncrement validation for a PhaseTapChangerLinear
   *
   * @param command UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearCommand
   */
  public void validate(UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerLinearId(),
        "UnAssignStepPhaseShiftIncrementFromPhaseTapChangerLinearCommand identifier should not be null");
  }
  /**
   * handles assign XMax validation for a PhaseTapChangerLinear
   *
   * @param command AssignXMaxToPhaseTapChangerLinearCommand
   */
  public void validate(AssignXMaxToPhaseTapChangerLinearCommand command) throws Exception {
    Assert.notNull(command, "AssignXMaxToPhaseTapChangerLinearCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerLinearId(),
        "AssignXMaxToPhaseTapChangerLinearCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXMaxToPhaseTapChangerLinearCommand assignment should not be null");
  }

  /**
   * handles unassign XMax validation for a PhaseTapChangerLinear
   *
   * @param command UnAssignXMaxFromPhaseTapChangerLinearCommand
   */
  public void validate(UnAssignXMaxFromPhaseTapChangerLinearCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXMaxFromPhaseTapChangerLinearCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerLinearId(),
        "UnAssignXMaxFromPhaseTapChangerLinearCommand identifier should not be null");
  }
  /**
   * handles assign XMin validation for a PhaseTapChangerLinear
   *
   * @param command AssignXMinToPhaseTapChangerLinearCommand
   */
  public void validate(AssignXMinToPhaseTapChangerLinearCommand command) throws Exception {
    Assert.notNull(command, "AssignXMinToPhaseTapChangerLinearCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerLinearId(),
        "AssignXMinToPhaseTapChangerLinearCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXMinToPhaseTapChangerLinearCommand assignment should not be null");
  }

  /**
   * handles unassign XMin validation for a PhaseTapChangerLinear
   *
   * @param command UnAssignXMinFromPhaseTapChangerLinearCommand
   */
  public void validate(UnAssignXMinFromPhaseTapChangerLinearCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXMinFromPhaseTapChangerLinearCommand should not be null");
    Assert.notNull(
        command.getPhaseTapChangerLinearId(),
        "UnAssignXMinFromPhaseTapChangerLinearCommand identifier should not be null");
  }
}
