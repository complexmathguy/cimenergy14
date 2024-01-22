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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class ControlValidator {

  /** default constructor */
  protected ControlValidator() {}

  /** factory method */
  public static ControlValidator getInstance() {
    return new ControlValidator();
  }

  /** handles creation validation for a Control */
  public void validate(CreateControlCommand control) throws Exception {
    Assert.notNull(control, "CreateControlCommand should not be null");
    //		Assert.isNull( control.getControlId(), "CreateControlCommand identifier should be null" );
  }

  /** handles update validation for a Control */
  public void validate(UpdateControlCommand control) throws Exception {
    Assert.notNull(control, "UpdateControlCommand should not be null");
    Assert.notNull(control.getControlId(), "UpdateControlCommand identifier should not be null");
  }

  /** handles delete validation for a Control */
  public void validate(DeleteControlCommand control) throws Exception {
    Assert.notNull(control, "{commandAlias} should not be null");
    Assert.notNull(control.getControlId(), "DeleteControlCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Control */
  public void validate(ControlFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ControlFetchOneSummary should not be null");
    Assert.notNull(summary.getControlId(), "ControlFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign ControlType validation for a Control
   *
   * @param command AssignControlTypeToControlCommand
   */
  public void validate(AssignControlTypeToControlCommand command) throws Exception {
    Assert.notNull(command, "AssignControlTypeToControlCommand should not be null");
    Assert.notNull(
        command.getControlId(), "AssignControlTypeToControlCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignControlTypeToControlCommand assignment should not be null");
  }

  /**
   * handles unassign ControlType validation for a Control
   *
   * @param command UnAssignControlTypeFromControlCommand
   */
  public void validate(UnAssignControlTypeFromControlCommand command) throws Exception {
    Assert.notNull(command, "UnAssignControlTypeFromControlCommand should not be null");
    Assert.notNull(
        command.getControlId(),
        "UnAssignControlTypeFromControlCommand identifier should not be null");
  }
  /**
   * handles assign OperationInProgress validation for a Control
   *
   * @param command AssignOperationInProgressToControlCommand
   */
  public void validate(AssignOperationInProgressToControlCommand command) throws Exception {
    Assert.notNull(command, "AssignOperationInProgressToControlCommand should not be null");
    Assert.notNull(
        command.getControlId(),
        "AssignOperationInProgressToControlCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOperationInProgressToControlCommand assignment should not be null");
  }

  /**
   * handles unassign OperationInProgress validation for a Control
   *
   * @param command UnAssignOperationInProgressFromControlCommand
   */
  public void validate(UnAssignOperationInProgressFromControlCommand command) throws Exception {
    Assert.notNull(command, "UnAssignOperationInProgressFromControlCommand should not be null");
    Assert.notNull(
        command.getControlId(),
        "UnAssignOperationInProgressFromControlCommand identifier should not be null");
  }
  /**
   * handles assign TimeStamp validation for a Control
   *
   * @param command AssignTimeStampToControlCommand
   */
  public void validate(AssignTimeStampToControlCommand command) throws Exception {
    Assert.notNull(command, "AssignTimeStampToControlCommand should not be null");
    Assert.notNull(
        command.getControlId(), "AssignTimeStampToControlCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTimeStampToControlCommand assignment should not be null");
  }

  /**
   * handles unassign TimeStamp validation for a Control
   *
   * @param command UnAssignTimeStampFromControlCommand
   */
  public void validate(UnAssignTimeStampFromControlCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTimeStampFromControlCommand should not be null");
    Assert.notNull(
        command.getControlId(),
        "UnAssignTimeStampFromControlCommand identifier should not be null");
  }

  /**
   * handles add to Controls validation for a Control
   *
   * @param command AssignControlsToControlCommand
   */
  public void validate(AssignControlsToControlCommand command) throws Exception {
    Assert.notNull(command, "AssignControlsToControlCommand should not be null");
    Assert.notNull(
        command.getControlId(), "AssignControlsToControlCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(), "AssignControlsToControlCommand addTo attribute should not be null");
  }

  /**
   * handles remove from Controls validation for a Control
   *
   * @param command RemoveControlsFromControlCommand
   */
  public void validate(RemoveControlsFromControlCommand command) throws Exception {
    Assert.notNull(command, "RemoveControlsFromControlCommand should not be null");
    Assert.notNull(
        command.getControlId(), "RemoveControlsFromControlCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveControlsFromControlCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getControlId(),
        "RemoveControlsFromControlCommand removeFrom attribubte identifier should not be null");
  }
}
