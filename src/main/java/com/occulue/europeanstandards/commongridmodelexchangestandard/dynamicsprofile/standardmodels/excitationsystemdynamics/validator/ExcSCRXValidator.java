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

public class ExcSCRXValidator {

  /** default constructor */
  protected ExcSCRXValidator() {}

  /** factory method */
  public static ExcSCRXValidator getInstance() {
    return new ExcSCRXValidator();
  }

  /** handles creation validation for a ExcSCRX */
  public void validate(CreateExcSCRXCommand excSCRX) throws Exception {
    Assert.notNull(excSCRX, "CreateExcSCRXCommand should not be null");
    //		Assert.isNull( excSCRX.getExcSCRXId(), "CreateExcSCRXCommand identifier should be null" );
  }

  /** handles update validation for a ExcSCRX */
  public void validate(UpdateExcSCRXCommand excSCRX) throws Exception {
    Assert.notNull(excSCRX, "UpdateExcSCRXCommand should not be null");
    Assert.notNull(excSCRX.getExcSCRXId(), "UpdateExcSCRXCommand identifier should not be null");
  }

  /** handles delete validation for a ExcSCRX */
  public void validate(DeleteExcSCRXCommand excSCRX) throws Exception {
    Assert.notNull(excSCRX, "{commandAlias} should not be null");
    Assert.notNull(excSCRX.getExcSCRXId(), "DeleteExcSCRXCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcSCRX */
  public void validate(ExcSCRXFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcSCRXFetchOneSummary should not be null");
    Assert.notNull(summary.getExcSCRXId(), "ExcSCRXFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Cswitch validation for a ExcSCRX
   *
   * @param command AssignCswitchToExcSCRXCommand
   */
  public void validate(AssignCswitchToExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "AssignCswitchToExcSCRXCommand should not be null");
    Assert.notNull(
        command.getExcSCRXId(), "AssignCswitchToExcSCRXCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignCswitchToExcSCRXCommand assignment should not be null");
  }

  /**
   * handles unassign Cswitch validation for a ExcSCRX
   *
   * @param command UnAssignCswitchFromExcSCRXCommand
   */
  public void validate(UnAssignCswitchFromExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "UnAssignCswitchFromExcSCRXCommand should not be null");
    Assert.notNull(
        command.getExcSCRXId(), "UnAssignCswitchFromExcSCRXCommand identifier should not be null");
  }
  /**
   * handles assign Emax validation for a ExcSCRX
   *
   * @param command AssignEmaxToExcSCRXCommand
   */
  public void validate(AssignEmaxToExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "AssignEmaxToExcSCRXCommand should not be null");
    Assert.notNull(
        command.getExcSCRXId(), "AssignEmaxToExcSCRXCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEmaxToExcSCRXCommand assignment should not be null");
  }

  /**
   * handles unassign Emax validation for a ExcSCRX
   *
   * @param command UnAssignEmaxFromExcSCRXCommand
   */
  public void validate(UnAssignEmaxFromExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEmaxFromExcSCRXCommand should not be null");
    Assert.notNull(
        command.getExcSCRXId(), "UnAssignEmaxFromExcSCRXCommand identifier should not be null");
  }
  /**
   * handles assign Emin validation for a ExcSCRX
   *
   * @param command AssignEminToExcSCRXCommand
   */
  public void validate(AssignEminToExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "AssignEminToExcSCRXCommand should not be null");
    Assert.notNull(
        command.getExcSCRXId(), "AssignEminToExcSCRXCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEminToExcSCRXCommand assignment should not be null");
  }

  /**
   * handles unassign Emin validation for a ExcSCRX
   *
   * @param command UnAssignEminFromExcSCRXCommand
   */
  public void validate(UnAssignEminFromExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEminFromExcSCRXCommand should not be null");
    Assert.notNull(
        command.getExcSCRXId(), "UnAssignEminFromExcSCRXCommand identifier should not be null");
  }
  /**
   * handles assign K validation for a ExcSCRX
   *
   * @param command AssignKToExcSCRXCommand
   */
  public void validate(AssignKToExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "AssignKToExcSCRXCommand should not be null");
    Assert.notNull(command.getExcSCRXId(), "AssignKToExcSCRXCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKToExcSCRXCommand assignment should not be null");
  }

  /**
   * handles unassign K validation for a ExcSCRX
   *
   * @param command UnAssignKFromExcSCRXCommand
   */
  public void validate(UnAssignKFromExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKFromExcSCRXCommand should not be null");
    Assert.notNull(
        command.getExcSCRXId(), "UnAssignKFromExcSCRXCommand identifier should not be null");
  }
  /**
   * handles assign Rcrfd validation for a ExcSCRX
   *
   * @param command AssignRcrfdToExcSCRXCommand
   */
  public void validate(AssignRcrfdToExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "AssignRcrfdToExcSCRXCommand should not be null");
    Assert.notNull(
        command.getExcSCRXId(), "AssignRcrfdToExcSCRXCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRcrfdToExcSCRXCommand assignment should not be null");
  }

  /**
   * handles unassign Rcrfd validation for a ExcSCRX
   *
   * @param command UnAssignRcrfdFromExcSCRXCommand
   */
  public void validate(UnAssignRcrfdFromExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRcrfdFromExcSCRXCommand should not be null");
    Assert.notNull(
        command.getExcSCRXId(), "UnAssignRcrfdFromExcSCRXCommand identifier should not be null");
  }
  /**
   * handles assign Tatb validation for a ExcSCRX
   *
   * @param command AssignTatbToExcSCRXCommand
   */
  public void validate(AssignTatbToExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "AssignTatbToExcSCRXCommand should not be null");
    Assert.notNull(
        command.getExcSCRXId(), "AssignTatbToExcSCRXCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTatbToExcSCRXCommand assignment should not be null");
  }

  /**
   * handles unassign Tatb validation for a ExcSCRX
   *
   * @param command UnAssignTatbFromExcSCRXCommand
   */
  public void validate(UnAssignTatbFromExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTatbFromExcSCRXCommand should not be null");
    Assert.notNull(
        command.getExcSCRXId(), "UnAssignTatbFromExcSCRXCommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcSCRX
   *
   * @param command AssignTbToExcSCRXCommand
   */
  public void validate(AssignTbToExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcSCRXCommand should not be null");
    Assert.notNull(
        command.getExcSCRXId(), "AssignTbToExcSCRXCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcSCRXCommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcSCRX
   *
   * @param command UnAssignTbFromExcSCRXCommand
   */
  public void validate(UnAssignTbFromExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcSCRXCommand should not be null");
    Assert.notNull(
        command.getExcSCRXId(), "UnAssignTbFromExcSCRXCommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcSCRX
   *
   * @param command AssignTeToExcSCRXCommand
   */
  public void validate(AssignTeToExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcSCRXCommand should not be null");
    Assert.notNull(
        command.getExcSCRXId(), "AssignTeToExcSCRXCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcSCRXCommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcSCRX
   *
   * @param command UnAssignTeFromExcSCRXCommand
   */
  public void validate(UnAssignTeFromExcSCRXCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcSCRXCommand should not be null");
    Assert.notNull(
        command.getExcSCRXId(), "UnAssignTeFromExcSCRXCommand identifier should not be null");
  }
}
