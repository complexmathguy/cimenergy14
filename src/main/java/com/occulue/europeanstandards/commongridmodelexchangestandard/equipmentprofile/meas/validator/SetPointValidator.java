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

public class SetPointValidator {

  /** default constructor */
  protected SetPointValidator() {}

  /** factory method */
  public static SetPointValidator getInstance() {
    return new SetPointValidator();
  }

  /** handles creation validation for a SetPoint */
  public void validate(CreateSetPointCommand setPoint) throws Exception {
    Assert.notNull(setPoint, "CreateSetPointCommand should not be null");
    //		Assert.isNull( setPoint.getSetPointId(), "CreateSetPointCommand identifier should be null"
    // );
  }

  /** handles update validation for a SetPoint */
  public void validate(UpdateSetPointCommand setPoint) throws Exception {
    Assert.notNull(setPoint, "UpdateSetPointCommand should not be null");
    Assert.notNull(setPoint.getSetPointId(), "UpdateSetPointCommand identifier should not be null");
  }

  /** handles delete validation for a SetPoint */
  public void validate(DeleteSetPointCommand setPoint) throws Exception {
    Assert.notNull(setPoint, "{commandAlias} should not be null");
    Assert.notNull(setPoint.getSetPointId(), "DeleteSetPointCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SetPoint */
  public void validate(SetPointFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SetPointFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSetPointId(), "SetPointFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign NormalValue validation for a SetPoint
   *
   * @param command AssignNormalValueToSetPointCommand
   */
  public void validate(AssignNormalValueToSetPointCommand command) throws Exception {
    Assert.notNull(command, "AssignNormalValueToSetPointCommand should not be null");
    Assert.notNull(
        command.getSetPointId(),
        "AssignNormalValueToSetPointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNormalValueToSetPointCommand assignment should not be null");
  }

  /**
   * handles unassign NormalValue validation for a SetPoint
   *
   * @param command UnAssignNormalValueFromSetPointCommand
   */
  public void validate(UnAssignNormalValueFromSetPointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNormalValueFromSetPointCommand should not be null");
    Assert.notNull(
        command.getSetPointId(),
        "UnAssignNormalValueFromSetPointCommand identifier should not be null");
  }
  /**
   * handles assign Value validation for a SetPoint
   *
   * @param command AssignValueToSetPointCommand
   */
  public void validate(AssignValueToSetPointCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToSetPointCommand should not be null");
    Assert.notNull(
        command.getSetPointId(), "AssignValueToSetPointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToSetPointCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a SetPoint
   *
   * @param command UnAssignValueFromSetPointCommand
   */
  public void validate(UnAssignValueFromSetPointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromSetPointCommand should not be null");
    Assert.notNull(
        command.getSetPointId(), "UnAssignValueFromSetPointCommand identifier should not be null");
  }
}
