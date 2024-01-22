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

public class RegulatingControlValidator {

  /** default constructor */
  protected RegulatingControlValidator() {}

  /** factory method */
  public static RegulatingControlValidator getInstance() {
    return new RegulatingControlValidator();
  }

  /** handles creation validation for a RegulatingControl */
  public void validate(CreateRegulatingControlCommand regulatingControl) throws Exception {
    Assert.notNull(regulatingControl, "CreateRegulatingControlCommand should not be null");
    //		Assert.isNull( regulatingControl.getRegulatingControlId(), "CreateRegulatingControlCommand
    // identifier should be null" );
  }

  /** handles update validation for a RegulatingControl */
  public void validate(UpdateRegulatingControlCommand regulatingControl) throws Exception {
    Assert.notNull(regulatingControl, "UpdateRegulatingControlCommand should not be null");
    Assert.notNull(
        regulatingControl.getRegulatingControlId(),
        "UpdateRegulatingControlCommand identifier should not be null");
  }

  /** handles delete validation for a RegulatingControl */
  public void validate(DeleteRegulatingControlCommand regulatingControl) throws Exception {
    Assert.notNull(regulatingControl, "{commandAlias} should not be null");
    Assert.notNull(
        regulatingControl.getRegulatingControlId(),
        "DeleteRegulatingControlCommand identifier should not be null");
  }

  /** handles fetchOne validation for a RegulatingControl */
  public void validate(RegulatingControlFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "RegulatingControlFetchOneSummary should not be null");
    Assert.notNull(
        summary.getRegulatingControlId(),
        "RegulatingControlFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign RegulatingControl validation for a RegulatingControl
   *
   * @param command AssignRegulatingControlToRegulatingControlCommand
   */
  public void validate(AssignRegulatingControlToRegulatingControlCommand command) throws Exception {
    Assert.notNull(command, "AssignRegulatingControlToRegulatingControlCommand should not be null");
    Assert.notNull(
        command.getRegulatingControlId(),
        "AssignRegulatingControlToRegulatingControlCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRegulatingControlToRegulatingControlCommand assignment should not be null");
  }

  /**
   * handles unassign RegulatingControl validation for a RegulatingControl
   *
   * @param command UnAssignRegulatingControlFromRegulatingControlCommand
   */
  public void validate(UnAssignRegulatingControlFromRegulatingControlCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignRegulatingControlFromRegulatingControlCommand should not be null");
    Assert.notNull(
        command.getRegulatingControlId(),
        "UnAssignRegulatingControlFromRegulatingControlCommand identifier should not be null");
  }
}
