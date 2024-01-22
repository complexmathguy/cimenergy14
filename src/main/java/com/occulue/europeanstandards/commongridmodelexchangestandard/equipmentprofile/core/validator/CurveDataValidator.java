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

public class CurveDataValidator {

  /** default constructor */
  protected CurveDataValidator() {}

  /** factory method */
  public static CurveDataValidator getInstance() {
    return new CurveDataValidator();
  }

  /** handles creation validation for a CurveData */
  public void validate(CreateCurveDataCommand curveData) throws Exception {
    Assert.notNull(curveData, "CreateCurveDataCommand should not be null");
    //		Assert.isNull( curveData.getCurveDataId(), "CreateCurveDataCommand identifier should be
    // null" );
  }

  /** handles update validation for a CurveData */
  public void validate(UpdateCurveDataCommand curveData) throws Exception {
    Assert.notNull(curveData, "UpdateCurveDataCommand should not be null");
    Assert.notNull(
        curveData.getCurveDataId(), "UpdateCurveDataCommand identifier should not be null");
  }

  /** handles delete validation for a CurveData */
  public void validate(DeleteCurveDataCommand curveData) throws Exception {
    Assert.notNull(curveData, "{commandAlias} should not be null");
    Assert.notNull(
        curveData.getCurveDataId(), "DeleteCurveDataCommand identifier should not be null");
  }

  /** handles fetchOne validation for a CurveData */
  public void validate(CurveDataFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "CurveDataFetchOneSummary should not be null");
    Assert.notNull(
        summary.getCurveDataId(), "CurveDataFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Xvalue validation for a CurveData
   *
   * @param command AssignXvalueToCurveDataCommand
   */
  public void validate(AssignXvalueToCurveDataCommand command) throws Exception {
    Assert.notNull(command, "AssignXvalueToCurveDataCommand should not be null");
    Assert.notNull(
        command.getCurveDataId(), "AssignXvalueToCurveDataCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXvalueToCurveDataCommand assignment should not be null");
  }

  /**
   * handles unassign Xvalue validation for a CurveData
   *
   * @param command UnAssignXvalueFromCurveDataCommand
   */
  public void validate(UnAssignXvalueFromCurveDataCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXvalueFromCurveDataCommand should not be null");
    Assert.notNull(
        command.getCurveDataId(),
        "UnAssignXvalueFromCurveDataCommand identifier should not be null");
  }
  /**
   * handles assign Y1value validation for a CurveData
   *
   * @param command AssignY1valueToCurveDataCommand
   */
  public void validate(AssignY1valueToCurveDataCommand command) throws Exception {
    Assert.notNull(command, "AssignY1valueToCurveDataCommand should not be null");
    Assert.notNull(
        command.getCurveDataId(), "AssignY1valueToCurveDataCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignY1valueToCurveDataCommand assignment should not be null");
  }

  /**
   * handles unassign Y1value validation for a CurveData
   *
   * @param command UnAssignY1valueFromCurveDataCommand
   */
  public void validate(UnAssignY1valueFromCurveDataCommand command) throws Exception {
    Assert.notNull(command, "UnAssignY1valueFromCurveDataCommand should not be null");
    Assert.notNull(
        command.getCurveDataId(),
        "UnAssignY1valueFromCurveDataCommand identifier should not be null");
  }
  /**
   * handles assign Y2value validation for a CurveData
   *
   * @param command AssignY2valueToCurveDataCommand
   */
  public void validate(AssignY2valueToCurveDataCommand command) throws Exception {
    Assert.notNull(command, "AssignY2valueToCurveDataCommand should not be null");
    Assert.notNull(
        command.getCurveDataId(), "AssignY2valueToCurveDataCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignY2valueToCurveDataCommand assignment should not be null");
  }

  /**
   * handles unassign Y2value validation for a CurveData
   *
   * @param command UnAssignY2valueFromCurveDataCommand
   */
  public void validate(UnAssignY2valueFromCurveDataCommand command) throws Exception {
    Assert.notNull(command, "UnAssignY2valueFromCurveDataCommand should not be null");
    Assert.notNull(
        command.getCurveDataId(),
        "UnAssignY2valueFromCurveDataCommand identifier should not be null");
  }

  /**
   * handles add to CurveDatas validation for a CurveData
   *
   * @param command AssignCurveDatasToCurveDataCommand
   */
  public void validate(AssignCurveDatasToCurveDataCommand command) throws Exception {
    Assert.notNull(command, "AssignCurveDatasToCurveDataCommand should not be null");
    Assert.notNull(
        command.getCurveDataId(),
        "AssignCurveDatasToCurveDataCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignCurveDatasToCurveDataCommand addTo attribute should not be null");
  }

  /**
   * handles remove from CurveDatas validation for a CurveData
   *
   * @param command RemoveCurveDatasFromCurveDataCommand
   */
  public void validate(RemoveCurveDatasFromCurveDataCommand command) throws Exception {
    Assert.notNull(command, "RemoveCurveDatasFromCurveDataCommand should not be null");
    Assert.notNull(
        command.getCurveDataId(),
        "RemoveCurveDatasFromCurveDataCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveCurveDatasFromCurveDataCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getCurveDataId(),
        "RemoveCurveDatasFromCurveDataCommand removeFrom attribubte identifier should not be null");
  }
}
