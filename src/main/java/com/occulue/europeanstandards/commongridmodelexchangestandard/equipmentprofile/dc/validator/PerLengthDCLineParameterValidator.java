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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class PerLengthDCLineParameterValidator {

  /** default constructor */
  protected PerLengthDCLineParameterValidator() {}

  /** factory method */
  public static PerLengthDCLineParameterValidator getInstance() {
    return new PerLengthDCLineParameterValidator();
  }

  /** handles creation validation for a PerLengthDCLineParameter */
  public void validate(CreatePerLengthDCLineParameterCommand perLengthDCLineParameter)
      throws Exception {
    Assert.notNull(
        perLengthDCLineParameter, "CreatePerLengthDCLineParameterCommand should not be null");
    //		Assert.isNull( perLengthDCLineParameter.getPerLengthDCLineParameterId(),
    // "CreatePerLengthDCLineParameterCommand identifier should be null" );
  }

  /** handles update validation for a PerLengthDCLineParameter */
  public void validate(UpdatePerLengthDCLineParameterCommand perLengthDCLineParameter)
      throws Exception {
    Assert.notNull(
        perLengthDCLineParameter, "UpdatePerLengthDCLineParameterCommand should not be null");
    Assert.notNull(
        perLengthDCLineParameter.getPerLengthDCLineParameterId(),
        "UpdatePerLengthDCLineParameterCommand identifier should not be null");
  }

  /** handles delete validation for a PerLengthDCLineParameter */
  public void validate(DeletePerLengthDCLineParameterCommand perLengthDCLineParameter)
      throws Exception {
    Assert.notNull(perLengthDCLineParameter, "{commandAlias} should not be null");
    Assert.notNull(
        perLengthDCLineParameter.getPerLengthDCLineParameterId(),
        "DeletePerLengthDCLineParameterCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PerLengthDCLineParameter */
  public void validate(PerLengthDCLineParameterFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PerLengthDCLineParameterFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPerLengthDCLineParameterId(),
        "PerLengthDCLineParameterFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Capacitance validation for a PerLengthDCLineParameter
   *
   * @param command AssignCapacitanceToPerLengthDCLineParameterCommand
   */
  public void validate(AssignCapacitanceToPerLengthDCLineParameterCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignCapacitanceToPerLengthDCLineParameterCommand should not be null");
    Assert.notNull(
        command.getPerLengthDCLineParameterId(),
        "AssignCapacitanceToPerLengthDCLineParameterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignCapacitanceToPerLengthDCLineParameterCommand assignment should not be null");
  }

  /**
   * handles unassign Capacitance validation for a PerLengthDCLineParameter
   *
   * @param command UnAssignCapacitanceFromPerLengthDCLineParameterCommand
   */
  public void validate(UnAssignCapacitanceFromPerLengthDCLineParameterCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignCapacitanceFromPerLengthDCLineParameterCommand should not be null");
    Assert.notNull(
        command.getPerLengthDCLineParameterId(),
        "UnAssignCapacitanceFromPerLengthDCLineParameterCommand identifier should not be null");
  }
  /**
   * handles assign Inductance validation for a PerLengthDCLineParameter
   *
   * @param command AssignInductanceToPerLengthDCLineParameterCommand
   */
  public void validate(AssignInductanceToPerLengthDCLineParameterCommand command) throws Exception {
    Assert.notNull(command, "AssignInductanceToPerLengthDCLineParameterCommand should not be null");
    Assert.notNull(
        command.getPerLengthDCLineParameterId(),
        "AssignInductanceToPerLengthDCLineParameterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignInductanceToPerLengthDCLineParameterCommand assignment should not be null");
  }

  /**
   * handles unassign Inductance validation for a PerLengthDCLineParameter
   *
   * @param command UnAssignInductanceFromPerLengthDCLineParameterCommand
   */
  public void validate(UnAssignInductanceFromPerLengthDCLineParameterCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignInductanceFromPerLengthDCLineParameterCommand should not be null");
    Assert.notNull(
        command.getPerLengthDCLineParameterId(),
        "UnAssignInductanceFromPerLengthDCLineParameterCommand identifier should not be null");
  }
  /**
   * handles assign Resistance validation for a PerLengthDCLineParameter
   *
   * @param command AssignResistanceToPerLengthDCLineParameterCommand
   */
  public void validate(AssignResistanceToPerLengthDCLineParameterCommand command) throws Exception {
    Assert.notNull(command, "AssignResistanceToPerLengthDCLineParameterCommand should not be null");
    Assert.notNull(
        command.getPerLengthDCLineParameterId(),
        "AssignResistanceToPerLengthDCLineParameterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignResistanceToPerLengthDCLineParameterCommand assignment should not be null");
  }

  /**
   * handles unassign Resistance validation for a PerLengthDCLineParameter
   *
   * @param command UnAssignResistanceFromPerLengthDCLineParameterCommand
   */
  public void validate(UnAssignResistanceFromPerLengthDCLineParameterCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignResistanceFromPerLengthDCLineParameterCommand should not be null");
    Assert.notNull(
        command.getPerLengthDCLineParameterId(),
        "UnAssignResistanceFromPerLengthDCLineParameterCommand identifier should not be null");
  }
}
