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

public class AnalogControlValidator {

  /** default constructor */
  protected AnalogControlValidator() {}

  /** factory method */
  public static AnalogControlValidator getInstance() {
    return new AnalogControlValidator();
  }

  /** handles creation validation for a AnalogControl */
  public void validate(CreateAnalogControlCommand analogControl) throws Exception {
    Assert.notNull(analogControl, "CreateAnalogControlCommand should not be null");
    //		Assert.isNull( analogControl.getAnalogControlId(), "CreateAnalogControlCommand identifier
    // should be null" );
  }

  /** handles update validation for a AnalogControl */
  public void validate(UpdateAnalogControlCommand analogControl) throws Exception {
    Assert.notNull(analogControl, "UpdateAnalogControlCommand should not be null");
    Assert.notNull(
        analogControl.getAnalogControlId(),
        "UpdateAnalogControlCommand identifier should not be null");
  }

  /** handles delete validation for a AnalogControl */
  public void validate(DeleteAnalogControlCommand analogControl) throws Exception {
    Assert.notNull(analogControl, "{commandAlias} should not be null");
    Assert.notNull(
        analogControl.getAnalogControlId(),
        "DeleteAnalogControlCommand identifier should not be null");
  }

  /** handles fetchOne validation for a AnalogControl */
  public void validate(AnalogControlFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "AnalogControlFetchOneSummary should not be null");
    Assert.notNull(
        summary.getAnalogControlId(), "AnalogControlFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign MaxValue validation for a AnalogControl
   *
   * @param command AssignMaxValueToAnalogControlCommand
   */
  public void validate(AssignMaxValueToAnalogControlCommand command) throws Exception {
    Assert.notNull(command, "AssignMaxValueToAnalogControlCommand should not be null");
    Assert.notNull(
        command.getAnalogControlId(),
        "AssignMaxValueToAnalogControlCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxValueToAnalogControlCommand assignment should not be null");
  }

  /**
   * handles unassign MaxValue validation for a AnalogControl
   *
   * @param command UnAssignMaxValueFromAnalogControlCommand
   */
  public void validate(UnAssignMaxValueFromAnalogControlCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMaxValueFromAnalogControlCommand should not be null");
    Assert.notNull(
        command.getAnalogControlId(),
        "UnAssignMaxValueFromAnalogControlCommand identifier should not be null");
  }
  /**
   * handles assign MinValue validation for a AnalogControl
   *
   * @param command AssignMinValueToAnalogControlCommand
   */
  public void validate(AssignMinValueToAnalogControlCommand command) throws Exception {
    Assert.notNull(command, "AssignMinValueToAnalogControlCommand should not be null");
    Assert.notNull(
        command.getAnalogControlId(),
        "AssignMinValueToAnalogControlCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMinValueToAnalogControlCommand assignment should not be null");
  }

  /**
   * handles unassign MinValue validation for a AnalogControl
   *
   * @param command UnAssignMinValueFromAnalogControlCommand
   */
  public void validate(UnAssignMinValueFromAnalogControlCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMinValueFromAnalogControlCommand should not be null");
    Assert.notNull(
        command.getAnalogControlId(),
        "UnAssignMinValueFromAnalogControlCommand identifier should not be null");
  }
  /**
   * handles assign AnalogControl validation for a AnalogControl
   *
   * @param command AssignAnalogControlToAnalogControlCommand
   */
  public void validate(AssignAnalogControlToAnalogControlCommand command) throws Exception {
    Assert.notNull(command, "AssignAnalogControlToAnalogControlCommand should not be null");
    Assert.notNull(
        command.getAnalogControlId(),
        "AssignAnalogControlToAnalogControlCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignAnalogControlToAnalogControlCommand assignment should not be null");
  }

  /**
   * handles unassign AnalogControl validation for a AnalogControl
   *
   * @param command UnAssignAnalogControlFromAnalogControlCommand
   */
  public void validate(UnAssignAnalogControlFromAnalogControlCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAnalogControlFromAnalogControlCommand should not be null");
    Assert.notNull(
        command.getAnalogControlId(),
        "UnAssignAnalogControlFromAnalogControlCommand identifier should not be null");
  }
}
