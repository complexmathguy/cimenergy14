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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class RegularTimePointValidator {

  /** default constructor */
  protected RegularTimePointValidator() {}

  /** factory method */
  public static RegularTimePointValidator getInstance() {
    return new RegularTimePointValidator();
  }

  /** handles creation validation for a RegularTimePoint */
  public void validate(CreateRegularTimePointCommand regularTimePoint) throws Exception {
    Assert.notNull(regularTimePoint, "CreateRegularTimePointCommand should not be null");
    //		Assert.isNull( regularTimePoint.getRegularTimePointId(), "CreateRegularTimePointCommand
    // identifier should be null" );
  }

  /** handles update validation for a RegularTimePoint */
  public void validate(UpdateRegularTimePointCommand regularTimePoint) throws Exception {
    Assert.notNull(regularTimePoint, "UpdateRegularTimePointCommand should not be null");
    Assert.notNull(
        regularTimePoint.getRegularTimePointId(),
        "UpdateRegularTimePointCommand identifier should not be null");
  }

  /** handles delete validation for a RegularTimePoint */
  public void validate(DeleteRegularTimePointCommand regularTimePoint) throws Exception {
    Assert.notNull(regularTimePoint, "{commandAlias} should not be null");
    Assert.notNull(
        regularTimePoint.getRegularTimePointId(),
        "DeleteRegularTimePointCommand identifier should not be null");
  }

  /** handles fetchOne validation for a RegularTimePoint */
  public void validate(RegularTimePointFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "RegularTimePointFetchOneSummary should not be null");
    Assert.notNull(
        summary.getRegularTimePointId(),
        "RegularTimePointFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign SequenceNumber validation for a RegularTimePoint
   *
   * @param command AssignSequenceNumberToRegularTimePointCommand
   */
  public void validate(AssignSequenceNumberToRegularTimePointCommand command) throws Exception {
    Assert.notNull(command, "AssignSequenceNumberToRegularTimePointCommand should not be null");
    Assert.notNull(
        command.getRegularTimePointId(),
        "AssignSequenceNumberToRegularTimePointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSequenceNumberToRegularTimePointCommand assignment should not be null");
  }

  /**
   * handles unassign SequenceNumber validation for a RegularTimePoint
   *
   * @param command UnAssignSequenceNumberFromRegularTimePointCommand
   */
  public void validate(UnAssignSequenceNumberFromRegularTimePointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSequenceNumberFromRegularTimePointCommand should not be null");
    Assert.notNull(
        command.getRegularTimePointId(),
        "UnAssignSequenceNumberFromRegularTimePointCommand identifier should not be null");
  }
  /**
   * handles assign Value1 validation for a RegularTimePoint
   *
   * @param command AssignValue1ToRegularTimePointCommand
   */
  public void validate(AssignValue1ToRegularTimePointCommand command) throws Exception {
    Assert.notNull(command, "AssignValue1ToRegularTimePointCommand should not be null");
    Assert.notNull(
        command.getRegularTimePointId(),
        "AssignValue1ToRegularTimePointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValue1ToRegularTimePointCommand assignment should not be null");
  }

  /**
   * handles unassign Value1 validation for a RegularTimePoint
   *
   * @param command UnAssignValue1FromRegularTimePointCommand
   */
  public void validate(UnAssignValue1FromRegularTimePointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValue1FromRegularTimePointCommand should not be null");
    Assert.notNull(
        command.getRegularTimePointId(),
        "UnAssignValue1FromRegularTimePointCommand identifier should not be null");
  }
  /**
   * handles assign Value2 validation for a RegularTimePoint
   *
   * @param command AssignValue2ToRegularTimePointCommand
   */
  public void validate(AssignValue2ToRegularTimePointCommand command) throws Exception {
    Assert.notNull(command, "AssignValue2ToRegularTimePointCommand should not be null");
    Assert.notNull(
        command.getRegularTimePointId(),
        "AssignValue2ToRegularTimePointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValue2ToRegularTimePointCommand assignment should not be null");
  }

  /**
   * handles unassign Value2 validation for a RegularTimePoint
   *
   * @param command UnAssignValue2FromRegularTimePointCommand
   */
  public void validate(UnAssignValue2FromRegularTimePointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValue2FromRegularTimePointCommand should not be null");
    Assert.notNull(
        command.getRegularTimePointId(),
        "UnAssignValue2FromRegularTimePointCommand identifier should not be null");
  }

  /**
   * handles add to TimePoints validation for a RegularTimePoint
   *
   * @param command AssignTimePointsToRegularTimePointCommand
   */
  public void validate(AssignTimePointsToRegularTimePointCommand command) throws Exception {
    Assert.notNull(command, "AssignTimePointsToRegularTimePointCommand should not be null");
    Assert.notNull(
        command.getRegularTimePointId(),
        "AssignTimePointsToRegularTimePointCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignTimePointsToRegularTimePointCommand addTo attribute should not be null");
  }

  /**
   * handles remove from TimePoints validation for a RegularTimePoint
   *
   * @param command RemoveTimePointsFromRegularTimePointCommand
   */
  public void validate(RemoveTimePointsFromRegularTimePointCommand command) throws Exception {
    Assert.notNull(command, "RemoveTimePointsFromRegularTimePointCommand should not be null");
    Assert.notNull(
        command.getRegularTimePointId(),
        "RemoveTimePointsFromRegularTimePointCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveTimePointsFromRegularTimePointCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getRegularTimePointId(),
        "RemoveTimePointsFromRegularTimePointCommand removeFrom attribubte identifier should not be null");
  }
}
