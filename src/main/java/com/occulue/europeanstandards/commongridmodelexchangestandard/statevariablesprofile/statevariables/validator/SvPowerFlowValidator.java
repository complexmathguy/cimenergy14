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

public class SvPowerFlowValidator {

  /** default constructor */
  protected SvPowerFlowValidator() {}

  /** factory method */
  public static SvPowerFlowValidator getInstance() {
    return new SvPowerFlowValidator();
  }

  /** handles creation validation for a SvPowerFlow */
  public void validate(CreateSvPowerFlowCommand svPowerFlow) throws Exception {
    Assert.notNull(svPowerFlow, "CreateSvPowerFlowCommand should not be null");
    //		Assert.isNull( svPowerFlow.getSvPowerFlowId(), "CreateSvPowerFlowCommand identifier should
    // be null" );
  }

  /** handles update validation for a SvPowerFlow */
  public void validate(UpdateSvPowerFlowCommand svPowerFlow) throws Exception {
    Assert.notNull(svPowerFlow, "UpdateSvPowerFlowCommand should not be null");
    Assert.notNull(
        svPowerFlow.getSvPowerFlowId(), "UpdateSvPowerFlowCommand identifier should not be null");
  }

  /** handles delete validation for a SvPowerFlow */
  public void validate(DeleteSvPowerFlowCommand svPowerFlow) throws Exception {
    Assert.notNull(svPowerFlow, "{commandAlias} should not be null");
    Assert.notNull(
        svPowerFlow.getSvPowerFlowId(), "DeleteSvPowerFlowCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SvPowerFlow */
  public void validate(SvPowerFlowFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SvPowerFlowFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSvPowerFlowId(), "SvPowerFlowFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign P validation for a SvPowerFlow
   *
   * @param command AssignPToSvPowerFlowCommand
   */
  public void validate(AssignPToSvPowerFlowCommand command) throws Exception {
    Assert.notNull(command, "AssignPToSvPowerFlowCommand should not be null");
    Assert.notNull(
        command.getSvPowerFlowId(), "AssignPToSvPowerFlowCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPToSvPowerFlowCommand assignment should not be null");
  }

  /**
   * handles unassign P validation for a SvPowerFlow
   *
   * @param command UnAssignPFromSvPowerFlowCommand
   */
  public void validate(UnAssignPFromSvPowerFlowCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPFromSvPowerFlowCommand should not be null");
    Assert.notNull(
        command.getSvPowerFlowId(),
        "UnAssignPFromSvPowerFlowCommand identifier should not be null");
  }
  /**
   * handles assign Q validation for a SvPowerFlow
   *
   * @param command AssignQToSvPowerFlowCommand
   */
  public void validate(AssignQToSvPowerFlowCommand command) throws Exception {
    Assert.notNull(command, "AssignQToSvPowerFlowCommand should not be null");
    Assert.notNull(
        command.getSvPowerFlowId(), "AssignQToSvPowerFlowCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQToSvPowerFlowCommand assignment should not be null");
  }

  /**
   * handles unassign Q validation for a SvPowerFlow
   *
   * @param command UnAssignQFromSvPowerFlowCommand
   */
  public void validate(UnAssignQFromSvPowerFlowCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQFromSvPowerFlowCommand should not be null");
    Assert.notNull(
        command.getSvPowerFlowId(),
        "UnAssignQFromSvPowerFlowCommand identifier should not be null");
  }
  /**
   * handles assign SvPowerFlow validation for a SvPowerFlow
   *
   * @param command AssignSvPowerFlowToSvPowerFlowCommand
   */
  public void validate(AssignSvPowerFlowToSvPowerFlowCommand command) throws Exception {
    Assert.notNull(command, "AssignSvPowerFlowToSvPowerFlowCommand should not be null");
    Assert.notNull(
        command.getSvPowerFlowId(),
        "AssignSvPowerFlowToSvPowerFlowCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSvPowerFlowToSvPowerFlowCommand assignment should not be null");
  }

  /**
   * handles unassign SvPowerFlow validation for a SvPowerFlow
   *
   * @param command UnAssignSvPowerFlowFromSvPowerFlowCommand
   */
  public void validate(UnAssignSvPowerFlowFromSvPowerFlowCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSvPowerFlowFromSvPowerFlowCommand should not be null");
    Assert.notNull(
        command.getSvPowerFlowId(),
        "UnAssignSvPowerFlowFromSvPowerFlowCommand identifier should not be null");
  }
}
