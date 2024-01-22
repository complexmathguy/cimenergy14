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

public class SvTapStepValidator {

  /** default constructor */
  protected SvTapStepValidator() {}

  /** factory method */
  public static SvTapStepValidator getInstance() {
    return new SvTapStepValidator();
  }

  /** handles creation validation for a SvTapStep */
  public void validate(CreateSvTapStepCommand svTapStep) throws Exception {
    Assert.notNull(svTapStep, "CreateSvTapStepCommand should not be null");
    //		Assert.isNull( svTapStep.getSvTapStepId(), "CreateSvTapStepCommand identifier should be
    // null" );
  }

  /** handles update validation for a SvTapStep */
  public void validate(UpdateSvTapStepCommand svTapStep) throws Exception {
    Assert.notNull(svTapStep, "UpdateSvTapStepCommand should not be null");
    Assert.notNull(
        svTapStep.getSvTapStepId(), "UpdateSvTapStepCommand identifier should not be null");
  }

  /** handles delete validation for a SvTapStep */
  public void validate(DeleteSvTapStepCommand svTapStep) throws Exception {
    Assert.notNull(svTapStep, "{commandAlias} should not be null");
    Assert.notNull(
        svTapStep.getSvTapStepId(), "DeleteSvTapStepCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SvTapStep */
  public void validate(SvTapStepFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SvTapStepFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSvTapStepId(), "SvTapStepFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Position validation for a SvTapStep
   *
   * @param command AssignPositionToSvTapStepCommand
   */
  public void validate(AssignPositionToSvTapStepCommand command) throws Exception {
    Assert.notNull(command, "AssignPositionToSvTapStepCommand should not be null");
    Assert.notNull(
        command.getSvTapStepId(), "AssignPositionToSvTapStepCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPositionToSvTapStepCommand assignment should not be null");
  }

  /**
   * handles unassign Position validation for a SvTapStep
   *
   * @param command UnAssignPositionFromSvTapStepCommand
   */
  public void validate(UnAssignPositionFromSvTapStepCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPositionFromSvTapStepCommand should not be null");
    Assert.notNull(
        command.getSvTapStepId(),
        "UnAssignPositionFromSvTapStepCommand identifier should not be null");
  }
  /**
   * handles assign SvTapStep validation for a SvTapStep
   *
   * @param command AssignSvTapStepToSvTapStepCommand
   */
  public void validate(AssignSvTapStepToSvTapStepCommand command) throws Exception {
    Assert.notNull(command, "AssignSvTapStepToSvTapStepCommand should not be null");
    Assert.notNull(
        command.getSvTapStepId(),
        "AssignSvTapStepToSvTapStepCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSvTapStepToSvTapStepCommand assignment should not be null");
  }

  /**
   * handles unassign SvTapStep validation for a SvTapStep
   *
   * @param command UnAssignSvTapStepFromSvTapStepCommand
   */
  public void validate(UnAssignSvTapStepFromSvTapStepCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSvTapStepFromSvTapStepCommand should not be null");
    Assert.notNull(
        command.getSvTapStepId(),
        "UnAssignSvTapStepFromSvTapStepCommand identifier should not be null");
  }
}
