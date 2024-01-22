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

public class ExcHUValidator {

  /** default constructor */
  protected ExcHUValidator() {}

  /** factory method */
  public static ExcHUValidator getInstance() {
    return new ExcHUValidator();
  }

  /** handles creation validation for a ExcHU */
  public void validate(CreateExcHUCommand excHU) throws Exception {
    Assert.notNull(excHU, "CreateExcHUCommand should not be null");
    //		Assert.isNull( excHU.getExcHUId(), "CreateExcHUCommand identifier should be null" );
  }

  /** handles update validation for a ExcHU */
  public void validate(UpdateExcHUCommand excHU) throws Exception {
    Assert.notNull(excHU, "UpdateExcHUCommand should not be null");
    Assert.notNull(excHU.getExcHUId(), "UpdateExcHUCommand identifier should not be null");
  }

  /** handles delete validation for a ExcHU */
  public void validate(DeleteExcHUCommand excHU) throws Exception {
    Assert.notNull(excHU, "{commandAlias} should not be null");
    Assert.notNull(excHU.getExcHUId(), "DeleteExcHUCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcHU */
  public void validate(ExcHUFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcHUFetchOneSummary should not be null");
    Assert.notNull(summary.getExcHUId(), "ExcHUFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ae validation for a ExcHU
   *
   * @param command AssignAeToExcHUCommand
   */
  public void validate(AssignAeToExcHUCommand command) throws Exception {
    Assert.notNull(command, "AssignAeToExcHUCommand should not be null");
    Assert.notNull(command.getExcHUId(), "AssignAeToExcHUCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignAeToExcHUCommand assignment should not be null");
  }

  /**
   * handles unassign Ae validation for a ExcHU
   *
   * @param command UnAssignAeFromExcHUCommand
   */
  public void validate(UnAssignAeFromExcHUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAeFromExcHUCommand should not be null");
    Assert.notNull(
        command.getExcHUId(), "UnAssignAeFromExcHUCommand identifier should not be null");
  }
  /**
   * handles assign Ai validation for a ExcHU
   *
   * @param command AssignAiToExcHUCommand
   */
  public void validate(AssignAiToExcHUCommand command) throws Exception {
    Assert.notNull(command, "AssignAiToExcHUCommand should not be null");
    Assert.notNull(command.getExcHUId(), "AssignAiToExcHUCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignAiToExcHUCommand assignment should not be null");
  }

  /**
   * handles unassign Ai validation for a ExcHU
   *
   * @param command UnAssignAiFromExcHUCommand
   */
  public void validate(UnAssignAiFromExcHUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAiFromExcHUCommand should not be null");
    Assert.notNull(
        command.getExcHUId(), "UnAssignAiFromExcHUCommand identifier should not be null");
  }
  /**
   * handles assign Atr validation for a ExcHU
   *
   * @param command AssignAtrToExcHUCommand
   */
  public void validate(AssignAtrToExcHUCommand command) throws Exception {
    Assert.notNull(command, "AssignAtrToExcHUCommand should not be null");
    Assert.notNull(command.getExcHUId(), "AssignAtrToExcHUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAtrToExcHUCommand assignment should not be null");
  }

  /**
   * handles unassign Atr validation for a ExcHU
   *
   * @param command UnAssignAtrFromExcHUCommand
   */
  public void validate(UnAssignAtrFromExcHUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAtrFromExcHUCommand should not be null");
    Assert.notNull(
        command.getExcHUId(), "UnAssignAtrFromExcHUCommand identifier should not be null");
  }
  /**
   * handles assign Emax validation for a ExcHU
   *
   * @param command AssignEmaxToExcHUCommand
   */
  public void validate(AssignEmaxToExcHUCommand command) throws Exception {
    Assert.notNull(command, "AssignEmaxToExcHUCommand should not be null");
    Assert.notNull(command.getExcHUId(), "AssignEmaxToExcHUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEmaxToExcHUCommand assignment should not be null");
  }

  /**
   * handles unassign Emax validation for a ExcHU
   *
   * @param command UnAssignEmaxFromExcHUCommand
   */
  public void validate(UnAssignEmaxFromExcHUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEmaxFromExcHUCommand should not be null");
    Assert.notNull(
        command.getExcHUId(), "UnAssignEmaxFromExcHUCommand identifier should not be null");
  }
  /**
   * handles assign Emin validation for a ExcHU
   *
   * @param command AssignEminToExcHUCommand
   */
  public void validate(AssignEminToExcHUCommand command) throws Exception {
    Assert.notNull(command, "AssignEminToExcHUCommand should not be null");
    Assert.notNull(command.getExcHUId(), "AssignEminToExcHUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEminToExcHUCommand assignment should not be null");
  }

  /**
   * handles unassign Emin validation for a ExcHU
   *
   * @param command UnAssignEminFromExcHUCommand
   */
  public void validate(UnAssignEminFromExcHUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEminFromExcHUCommand should not be null");
    Assert.notNull(
        command.getExcHUId(), "UnAssignEminFromExcHUCommand identifier should not be null");
  }
  /**
   * handles assign Imax validation for a ExcHU
   *
   * @param command AssignImaxToExcHUCommand
   */
  public void validate(AssignImaxToExcHUCommand command) throws Exception {
    Assert.notNull(command, "AssignImaxToExcHUCommand should not be null");
    Assert.notNull(command.getExcHUId(), "AssignImaxToExcHUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignImaxToExcHUCommand assignment should not be null");
  }

  /**
   * handles unassign Imax validation for a ExcHU
   *
   * @param command UnAssignImaxFromExcHUCommand
   */
  public void validate(UnAssignImaxFromExcHUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignImaxFromExcHUCommand should not be null");
    Assert.notNull(
        command.getExcHUId(), "UnAssignImaxFromExcHUCommand identifier should not be null");
  }
  /**
   * handles assign Imin validation for a ExcHU
   *
   * @param command AssignIminToExcHUCommand
   */
  public void validate(AssignIminToExcHUCommand command) throws Exception {
    Assert.notNull(command, "AssignIminToExcHUCommand should not be null");
    Assert.notNull(command.getExcHUId(), "AssignIminToExcHUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIminToExcHUCommand assignment should not be null");
  }

  /**
   * handles unassign Imin validation for a ExcHU
   *
   * @param command UnAssignIminFromExcHUCommand
   */
  public void validate(UnAssignIminFromExcHUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignIminFromExcHUCommand should not be null");
    Assert.notNull(
        command.getExcHUId(), "UnAssignIminFromExcHUCommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcHU
   *
   * @param command AssignKeToExcHUCommand
   */
  public void validate(AssignKeToExcHUCommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcHUCommand should not be null");
    Assert.notNull(command.getExcHUId(), "AssignKeToExcHUCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKeToExcHUCommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcHU
   *
   * @param command UnAssignKeFromExcHUCommand
   */
  public void validate(UnAssignKeFromExcHUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcHUCommand should not be null");
    Assert.notNull(
        command.getExcHUId(), "UnAssignKeFromExcHUCommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a ExcHU
   *
   * @param command AssignKiToExcHUCommand
   */
  public void validate(AssignKiToExcHUCommand command) throws Exception {
    Assert.notNull(command, "AssignKiToExcHUCommand should not be null");
    Assert.notNull(command.getExcHUId(), "AssignKiToExcHUCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKiToExcHUCommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a ExcHU
   *
   * @param command UnAssignKiFromExcHUCommand
   */
  public void validate(UnAssignKiFromExcHUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromExcHUCommand should not be null");
    Assert.notNull(
        command.getExcHUId(), "UnAssignKiFromExcHUCommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcHU
   *
   * @param command AssignTeToExcHUCommand
   */
  public void validate(AssignTeToExcHUCommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcHUCommand should not be null");
    Assert.notNull(command.getExcHUId(), "AssignTeToExcHUCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTeToExcHUCommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcHU
   *
   * @param command UnAssignTeFromExcHUCommand
   */
  public void validate(UnAssignTeFromExcHUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcHUCommand should not be null");
    Assert.notNull(
        command.getExcHUId(), "UnAssignTeFromExcHUCommand identifier should not be null");
  }
  /**
   * handles assign Ti validation for a ExcHU
   *
   * @param command AssignTiToExcHUCommand
   */
  public void validate(AssignTiToExcHUCommand command) throws Exception {
    Assert.notNull(command, "AssignTiToExcHUCommand should not be null");
    Assert.notNull(command.getExcHUId(), "AssignTiToExcHUCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTiToExcHUCommand assignment should not be null");
  }

  /**
   * handles unassign Ti validation for a ExcHU
   *
   * @param command UnAssignTiFromExcHUCommand
   */
  public void validate(UnAssignTiFromExcHUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTiFromExcHUCommand should not be null");
    Assert.notNull(
        command.getExcHUId(), "UnAssignTiFromExcHUCommand identifier should not be null");
  }
  /**
   * handles assign Tr validation for a ExcHU
   *
   * @param command AssignTrToExcHUCommand
   */
  public void validate(AssignTrToExcHUCommand command) throws Exception {
    Assert.notNull(command, "AssignTrToExcHUCommand should not be null");
    Assert.notNull(command.getExcHUId(), "AssignTrToExcHUCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTrToExcHUCommand assignment should not be null");
  }

  /**
   * handles unassign Tr validation for a ExcHU
   *
   * @param command UnAssignTrFromExcHUCommand
   */
  public void validate(UnAssignTrFromExcHUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTrFromExcHUCommand should not be null");
    Assert.notNull(
        command.getExcHUId(), "UnAssignTrFromExcHUCommand identifier should not be null");
  }
}
