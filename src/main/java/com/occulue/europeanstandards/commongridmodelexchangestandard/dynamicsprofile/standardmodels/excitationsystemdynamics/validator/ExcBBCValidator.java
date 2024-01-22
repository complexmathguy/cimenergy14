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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class ExcBBCValidator {

  /** default constructor */
  protected ExcBBCValidator() {}

  /** factory method */
  public static ExcBBCValidator getInstance() {
    return new ExcBBCValidator();
  }

  /** handles creation validation for a ExcBBC */
  public void validate(CreateExcBBCCommand excBBC) throws Exception {
    Assert.notNull(excBBC, "CreateExcBBCCommand should not be null");
    //		Assert.isNull( excBBC.getExcBBCId(), "CreateExcBBCCommand identifier should be null" );
  }

  /** handles update validation for a ExcBBC */
  public void validate(UpdateExcBBCCommand excBBC) throws Exception {
    Assert.notNull(excBBC, "UpdateExcBBCCommand should not be null");
    Assert.notNull(excBBC.getExcBBCId(), "UpdateExcBBCCommand identifier should not be null");
  }

  /** handles delete validation for a ExcBBC */
  public void validate(DeleteExcBBCCommand excBBC) throws Exception {
    Assert.notNull(excBBC, "{commandAlias} should not be null");
    Assert.notNull(excBBC.getExcBBCId(), "DeleteExcBBCCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcBBC */
  public void validate(ExcBBCFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcBBCFetchOneSummary should not be null");
    Assert.notNull(summary.getExcBBCId(), "ExcBBCFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efdmax validation for a ExcBBC
   *
   * @param command AssignEfdmaxToExcBBCCommand
   */
  public void validate(AssignEfdmaxToExcBBCCommand command) throws Exception {
    Assert.notNull(command, "AssignEfdmaxToExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "AssignEfdmaxToExcBBCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdmaxToExcBBCCommand assignment should not be null");
  }

  /**
   * handles unassign Efdmax validation for a ExcBBC
   *
   * @param command UnAssignEfdmaxFromExcBBCCommand
   */
  public void validate(UnAssignEfdmaxFromExcBBCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdmaxFromExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "UnAssignEfdmaxFromExcBBCCommand identifier should not be null");
  }
  /**
   * handles assign Efdmin validation for a ExcBBC
   *
   * @param command AssignEfdminToExcBBCCommand
   */
  public void validate(AssignEfdminToExcBBCCommand command) throws Exception {
    Assert.notNull(command, "AssignEfdminToExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "AssignEfdminToExcBBCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdminToExcBBCCommand assignment should not be null");
  }

  /**
   * handles unassign Efdmin validation for a ExcBBC
   *
   * @param command UnAssignEfdminFromExcBBCCommand
   */
  public void validate(UnAssignEfdminFromExcBBCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdminFromExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "UnAssignEfdminFromExcBBCCommand identifier should not be null");
  }
  /**
   * handles assign K validation for a ExcBBC
   *
   * @param command AssignKToExcBBCCommand
   */
  public void validate(AssignKToExcBBCCommand command) throws Exception {
    Assert.notNull(command, "AssignKToExcBBCCommand should not be null");
    Assert.notNull(command.getExcBBCId(), "AssignKToExcBBCCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKToExcBBCCommand assignment should not be null");
  }

  /**
   * handles unassign K validation for a ExcBBC
   *
   * @param command UnAssignKFromExcBBCCommand
   */
  public void validate(UnAssignKFromExcBBCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKFromExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "UnAssignKFromExcBBCCommand identifier should not be null");
  }
  /**
   * handles assign SwitchIt validation for a ExcBBC
   *
   * @param command AssignSwitchItToExcBBCCommand
   */
  public void validate(AssignSwitchItToExcBBCCommand command) throws Exception {
    Assert.notNull(command, "AssignSwitchItToExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "AssignSwitchItToExcBBCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSwitchItToExcBBCCommand assignment should not be null");
  }

  /**
   * handles unassign SwitchIt validation for a ExcBBC
   *
   * @param command UnAssignSwitchItFromExcBBCCommand
   */
  public void validate(UnAssignSwitchItFromExcBBCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSwitchItFromExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "UnAssignSwitchItFromExcBBCCommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a ExcBBC
   *
   * @param command AssignT1ToExcBBCCommand
   */
  public void validate(AssignT1ToExcBBCCommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToExcBBCCommand should not be null");
    Assert.notNull(command.getExcBBCId(), "AssignT1ToExcBBCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToExcBBCCommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a ExcBBC
   *
   * @param command UnAssignT1FromExcBBCCommand
   */
  public void validate(UnAssignT1FromExcBBCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "UnAssignT1FromExcBBCCommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a ExcBBC
   *
   * @param command AssignT2ToExcBBCCommand
   */
  public void validate(AssignT2ToExcBBCCommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToExcBBCCommand should not be null");
    Assert.notNull(command.getExcBBCId(), "AssignT2ToExcBBCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToExcBBCCommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a ExcBBC
   *
   * @param command UnAssignT2FromExcBBCCommand
   */
  public void validate(UnAssignT2FromExcBBCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "UnAssignT2FromExcBBCCommand identifier should not be null");
  }
  /**
   * handles assign T3 validation for a ExcBBC
   *
   * @param command AssignT3ToExcBBCCommand
   */
  public void validate(AssignT3ToExcBBCCommand command) throws Exception {
    Assert.notNull(command, "AssignT3ToExcBBCCommand should not be null");
    Assert.notNull(command.getExcBBCId(), "AssignT3ToExcBBCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToExcBBCCommand assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a ExcBBC
   *
   * @param command UnAssignT3FromExcBBCCommand
   */
  public void validate(UnAssignT3FromExcBBCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "UnAssignT3FromExcBBCCommand identifier should not be null");
  }
  /**
   * handles assign T4 validation for a ExcBBC
   *
   * @param command AssignT4ToExcBBCCommand
   */
  public void validate(AssignT4ToExcBBCCommand command) throws Exception {
    Assert.notNull(command, "AssignT4ToExcBBCCommand should not be null");
    Assert.notNull(command.getExcBBCId(), "AssignT4ToExcBBCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToExcBBCCommand assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a ExcBBC
   *
   * @param command UnAssignT4FromExcBBCCommand
   */
  public void validate(UnAssignT4FromExcBBCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "UnAssignT4FromExcBBCCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcBBC
   *
   * @param command AssignVrmaxToExcBBCCommand
   */
  public void validate(AssignVrmaxToExcBBCCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "AssignVrmaxToExcBBCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcBBCCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcBBC
   *
   * @param command UnAssignVrmaxFromExcBBCCommand
   */
  public void validate(UnAssignVrmaxFromExcBBCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "UnAssignVrmaxFromExcBBCCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcBBC
   *
   * @param command AssignVrminToExcBBCCommand
   */
  public void validate(AssignVrminToExcBBCCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "AssignVrminToExcBBCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcBBCCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcBBC
   *
   * @param command UnAssignVrminFromExcBBCCommand
   */
  public void validate(UnAssignVrminFromExcBBCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "UnAssignVrminFromExcBBCCommand identifier should not be null");
  }
  /**
   * handles assign Xe validation for a ExcBBC
   *
   * @param command AssignXeToExcBBCCommand
   */
  public void validate(AssignXeToExcBBCCommand command) throws Exception {
    Assert.notNull(command, "AssignXeToExcBBCCommand should not be null");
    Assert.notNull(command.getExcBBCId(), "AssignXeToExcBBCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXeToExcBBCCommand assignment should not be null");
  }

  /**
   * handles unassign Xe validation for a ExcBBC
   *
   * @param command UnAssignXeFromExcBBCCommand
   */
  public void validate(UnAssignXeFromExcBBCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXeFromExcBBCCommand should not be null");
    Assert.notNull(
        command.getExcBBCId(), "UnAssignXeFromExcBBCCommand identifier should not be null");
  }
}
