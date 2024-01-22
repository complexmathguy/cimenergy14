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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class PositionPointValidator {

  /** default constructor */
  protected PositionPointValidator() {}

  /** factory method */
  public static PositionPointValidator getInstance() {
    return new PositionPointValidator();
  }

  /** handles creation validation for a PositionPoint */
  public void validate(CreatePositionPointCommand positionPoint) throws Exception {
    Assert.notNull(positionPoint, "CreatePositionPointCommand should not be null");
    //		Assert.isNull( positionPoint.getPositionPointId(), "CreatePositionPointCommand identifier
    // should be null" );
  }

  /** handles update validation for a PositionPoint */
  public void validate(UpdatePositionPointCommand positionPoint) throws Exception {
    Assert.notNull(positionPoint, "UpdatePositionPointCommand should not be null");
    Assert.notNull(
        positionPoint.getPositionPointId(),
        "UpdatePositionPointCommand identifier should not be null");
  }

  /** handles delete validation for a PositionPoint */
  public void validate(DeletePositionPointCommand positionPoint) throws Exception {
    Assert.notNull(positionPoint, "{commandAlias} should not be null");
    Assert.notNull(
        positionPoint.getPositionPointId(),
        "DeletePositionPointCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PositionPoint */
  public void validate(PositionPointFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PositionPointFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPositionPointId(), "PositionPointFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign SequenceNumber validation for a PositionPoint
   *
   * @param command AssignSequenceNumberToPositionPointCommand
   */
  public void validate(AssignSequenceNumberToPositionPointCommand command) throws Exception {
    Assert.notNull(command, "AssignSequenceNumberToPositionPointCommand should not be null");
    Assert.notNull(
        command.getPositionPointId(),
        "AssignSequenceNumberToPositionPointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSequenceNumberToPositionPointCommand assignment should not be null");
  }

  /**
   * handles unassign SequenceNumber validation for a PositionPoint
   *
   * @param command UnAssignSequenceNumberFromPositionPointCommand
   */
  public void validate(UnAssignSequenceNumberFromPositionPointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSequenceNumberFromPositionPointCommand should not be null");
    Assert.notNull(
        command.getPositionPointId(),
        "UnAssignSequenceNumberFromPositionPointCommand identifier should not be null");
  }
  /**
   * handles assign XPosition validation for a PositionPoint
   *
   * @param command AssignXPositionToPositionPointCommand
   */
  public void validate(AssignXPositionToPositionPointCommand command) throws Exception {
    Assert.notNull(command, "AssignXPositionToPositionPointCommand should not be null");
    Assert.notNull(
        command.getPositionPointId(),
        "AssignXPositionToPositionPointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXPositionToPositionPointCommand assignment should not be null");
  }

  /**
   * handles unassign XPosition validation for a PositionPoint
   *
   * @param command UnAssignXPositionFromPositionPointCommand
   */
  public void validate(UnAssignXPositionFromPositionPointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXPositionFromPositionPointCommand should not be null");
    Assert.notNull(
        command.getPositionPointId(),
        "UnAssignXPositionFromPositionPointCommand identifier should not be null");
  }
  /**
   * handles assign YPosition validation for a PositionPoint
   *
   * @param command AssignYPositionToPositionPointCommand
   */
  public void validate(AssignYPositionToPositionPointCommand command) throws Exception {
    Assert.notNull(command, "AssignYPositionToPositionPointCommand should not be null");
    Assert.notNull(
        command.getPositionPointId(),
        "AssignYPositionToPositionPointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignYPositionToPositionPointCommand assignment should not be null");
  }

  /**
   * handles unassign YPosition validation for a PositionPoint
   *
   * @param command UnAssignYPositionFromPositionPointCommand
   */
  public void validate(UnAssignYPositionFromPositionPointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignYPositionFromPositionPointCommand should not be null");
    Assert.notNull(
        command.getPositionPointId(),
        "UnAssignYPositionFromPositionPointCommand identifier should not be null");
  }
  /**
   * handles assign ZPosition validation for a PositionPoint
   *
   * @param command AssignZPositionToPositionPointCommand
   */
  public void validate(AssignZPositionToPositionPointCommand command) throws Exception {
    Assert.notNull(command, "AssignZPositionToPositionPointCommand should not be null");
    Assert.notNull(
        command.getPositionPointId(),
        "AssignZPositionToPositionPointCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignZPositionToPositionPointCommand assignment should not be null");
  }

  /**
   * handles unassign ZPosition validation for a PositionPoint
   *
   * @param command UnAssignZPositionFromPositionPointCommand
   */
  public void validate(UnAssignZPositionFromPositionPointCommand command) throws Exception {
    Assert.notNull(command, "UnAssignZPositionFromPositionPointCommand should not be null");
    Assert.notNull(
        command.getPositionPointId(),
        "UnAssignZPositionFromPositionPointCommand identifier should not be null");
  }

  /**
   * handles add to PositionPoints validation for a PositionPoint
   *
   * @param command AssignPositionPointsToPositionPointCommand
   */
  public void validate(AssignPositionPointsToPositionPointCommand command) throws Exception {
    Assert.notNull(command, "AssignPositionPointsToPositionPointCommand should not be null");
    Assert.notNull(
        command.getPositionPointId(),
        "AssignPositionPointsToPositionPointCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignPositionPointsToPositionPointCommand addTo attribute should not be null");
  }

  /**
   * handles remove from PositionPoints validation for a PositionPoint
   *
   * @param command RemovePositionPointsFromPositionPointCommand
   */
  public void validate(RemovePositionPointsFromPositionPointCommand command) throws Exception {
    Assert.notNull(command, "RemovePositionPointsFromPositionPointCommand should not be null");
    Assert.notNull(
        command.getPositionPointId(),
        "RemovePositionPointsFromPositionPointCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemovePositionPointsFromPositionPointCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getPositionPointId(),
        "RemovePositionPointsFromPositionPointCommand removeFrom attribubte identifier should not be null");
  }
}
