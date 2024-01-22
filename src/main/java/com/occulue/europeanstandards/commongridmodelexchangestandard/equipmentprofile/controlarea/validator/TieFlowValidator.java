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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.controlarea.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class TieFlowValidator {

  /** default constructor */
  protected TieFlowValidator() {}

  /** factory method */
  public static TieFlowValidator getInstance() {
    return new TieFlowValidator();
  }

  /** handles creation validation for a TieFlow */
  public void validate(CreateTieFlowCommand tieFlow) throws Exception {
    Assert.notNull(tieFlow, "CreateTieFlowCommand should not be null");
    //		Assert.isNull( tieFlow.getTieFlowId(), "CreateTieFlowCommand identifier should be null" );
  }

  /** handles update validation for a TieFlow */
  public void validate(UpdateTieFlowCommand tieFlow) throws Exception {
    Assert.notNull(tieFlow, "UpdateTieFlowCommand should not be null");
    Assert.notNull(tieFlow.getTieFlowId(), "UpdateTieFlowCommand identifier should not be null");
  }

  /** handles delete validation for a TieFlow */
  public void validate(DeleteTieFlowCommand tieFlow) throws Exception {
    Assert.notNull(tieFlow, "{commandAlias} should not be null");
    Assert.notNull(tieFlow.getTieFlowId(), "DeleteTieFlowCommand identifier should not be null");
  }

  /** handles fetchOne validation for a TieFlow */
  public void validate(TieFlowFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TieFlowFetchOneSummary should not be null");
    Assert.notNull(summary.getTieFlowId(), "TieFlowFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign PositiveFlowIn validation for a TieFlow
   *
   * @param command AssignPositiveFlowInToTieFlowCommand
   */
  public void validate(AssignPositiveFlowInToTieFlowCommand command) throws Exception {
    Assert.notNull(command, "AssignPositiveFlowInToTieFlowCommand should not be null");
    Assert.notNull(
        command.getTieFlowId(),
        "AssignPositiveFlowInToTieFlowCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPositiveFlowInToTieFlowCommand assignment should not be null");
  }

  /**
   * handles unassign PositiveFlowIn validation for a TieFlow
   *
   * @param command UnAssignPositiveFlowInFromTieFlowCommand
   */
  public void validate(UnAssignPositiveFlowInFromTieFlowCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPositiveFlowInFromTieFlowCommand should not be null");
    Assert.notNull(
        command.getTieFlowId(),
        "UnAssignPositiveFlowInFromTieFlowCommand identifier should not be null");
  }

  /**
   * handles add to TieFlow validation for a TieFlow
   *
   * @param command AssignTieFlowToTieFlowCommand
   */
  public void validate(AssignTieFlowToTieFlowCommand command) throws Exception {
    Assert.notNull(command, "AssignTieFlowToTieFlowCommand should not be null");
    Assert.notNull(
        command.getTieFlowId(), "AssignTieFlowToTieFlowCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(), "AssignTieFlowToTieFlowCommand addTo attribute should not be null");
  }

  /**
   * handles remove from TieFlow validation for a TieFlow
   *
   * @param command RemoveTieFlowFromTieFlowCommand
   */
  public void validate(RemoveTieFlowFromTieFlowCommand command) throws Exception {
    Assert.notNull(command, "RemoveTieFlowFromTieFlowCommand should not be null");
    Assert.notNull(
        command.getTieFlowId(), "RemoveTieFlowFromTieFlowCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveTieFlowFromTieFlowCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getTieFlowId(),
        "RemoveTieFlowFromTieFlowCommand removeFrom attribubte identifier should not be null");
  }
}
