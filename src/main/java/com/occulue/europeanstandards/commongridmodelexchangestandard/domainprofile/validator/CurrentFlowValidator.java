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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class CurrentFlowValidator {

  /** default constructor */
  protected CurrentFlowValidator() {}

  /** factory method */
  public static CurrentFlowValidator getInstance() {
    return new CurrentFlowValidator();
  }

  /** handles creation validation for a CurrentFlow */
  public void validate(CreateCurrentFlowCommand currentFlow) throws Exception {
    Assert.notNull(currentFlow, "CreateCurrentFlowCommand should not be null");
    //		Assert.isNull( currentFlow.getCurrentFlowId(), "CreateCurrentFlowCommand identifier should
    // be null" );
  }

  /** handles update validation for a CurrentFlow */
  public void validate(UpdateCurrentFlowCommand currentFlow) throws Exception {
    Assert.notNull(currentFlow, "UpdateCurrentFlowCommand should not be null");
    Assert.notNull(
        currentFlow.getCurrentFlowId(), "UpdateCurrentFlowCommand identifier should not be null");
  }

  /** handles delete validation for a CurrentFlow */
  public void validate(DeleteCurrentFlowCommand currentFlow) throws Exception {
    Assert.notNull(currentFlow, "{commandAlias} should not be null");
    Assert.notNull(
        currentFlow.getCurrentFlowId(), "DeleteCurrentFlowCommand identifier should not be null");
  }

  /** handles fetchOne validation for a CurrentFlow */
  public void validate(CurrentFlowFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "CurrentFlowFetchOneSummary should not be null");
    Assert.notNull(
        summary.getCurrentFlowId(), "CurrentFlowFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a CurrentFlow
   *
   * @param command AssignValueToCurrentFlowCommand
   */
  public void validate(AssignValueToCurrentFlowCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToCurrentFlowCommand should not be null");
    Assert.notNull(
        command.getCurrentFlowId(),
        "AssignValueToCurrentFlowCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToCurrentFlowCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a CurrentFlow
   *
   * @param command UnAssignValueFromCurrentFlowCommand
   */
  public void validate(UnAssignValueFromCurrentFlowCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromCurrentFlowCommand should not be null");
    Assert.notNull(
        command.getCurrentFlowId(),
        "UnAssignValueFromCurrentFlowCommand identifier should not be null");
  }
}
