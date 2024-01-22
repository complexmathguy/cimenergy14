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

public class ExcSKValidator {

  /** default constructor */
  protected ExcSKValidator() {}

  /** factory method */
  public static ExcSKValidator getInstance() {
    return new ExcSKValidator();
  }

  /** handles creation validation for a ExcSK */
  public void validate(CreateExcSKCommand excSK) throws Exception {
    Assert.notNull(excSK, "CreateExcSKCommand should not be null");
    //		Assert.isNull( excSK.getExcSKId(), "CreateExcSKCommand identifier should be null" );
  }

  /** handles update validation for a ExcSK */
  public void validate(UpdateExcSKCommand excSK) throws Exception {
    Assert.notNull(excSK, "UpdateExcSKCommand should not be null");
    Assert.notNull(excSK.getExcSKId(), "UpdateExcSKCommand identifier should not be null");
  }

  /** handles delete validation for a ExcSK */
  public void validate(DeleteExcSKCommand excSK) throws Exception {
    Assert.notNull(excSK, "{commandAlias} should not be null");
    Assert.notNull(excSK.getExcSKId(), "DeleteExcSKCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcSK */
  public void validate(ExcSKFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcSKFetchOneSummary should not be null");
    Assert.notNull(summary.getExcSKId(), "ExcSKFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efdmax validation for a ExcSK
   *
   * @param command AssignEfdmaxToExcSKCommand
   */
  public void validate(AssignEfdmaxToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignEfdmaxToExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "AssignEfdmaxToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdmaxToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Efdmax validation for a ExcSK
   *
   * @param command UnAssignEfdmaxFromExcSKCommand
   */
  public void validate(UnAssignEfdmaxFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdmaxFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignEfdmaxFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Efdmin validation for a ExcSK
   *
   * @param command AssignEfdminToExcSKCommand
   */
  public void validate(AssignEfdminToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignEfdminToExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "AssignEfdminToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdminToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Efdmin validation for a ExcSK
   *
   * @param command UnAssignEfdminFromExcSKCommand
   */
  public void validate(UnAssignEfdminFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdminFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignEfdminFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Emax validation for a ExcSK
   *
   * @param command AssignEmaxToExcSKCommand
   */
  public void validate(AssignEmaxToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignEmaxToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignEmaxToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEmaxToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Emax validation for a ExcSK
   *
   * @param command UnAssignEmaxFromExcSKCommand
   */
  public void validate(UnAssignEmaxFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEmaxFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignEmaxFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Emin validation for a ExcSK
   *
   * @param command AssignEminToExcSKCommand
   */
  public void validate(AssignEminToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignEminToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignEminToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEminToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Emin validation for a ExcSK
   *
   * @param command UnAssignEminFromExcSKCommand
   */
  public void validate(UnAssignEminFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEminFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignEminFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign K validation for a ExcSK
   *
   * @param command AssignKToExcSKCommand
   */
  public void validate(AssignKToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignKToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignKToExcSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign K validation for a ExcSK
   *
   * @param command UnAssignKFromExcSKCommand
   */
  public void validate(UnAssignKFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKFromExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "UnAssignKFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign K1 validation for a ExcSK
   *
   * @param command AssignK1ToExcSKCommand
   */
  public void validate(AssignK1ToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignK1ToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignK1ToExcSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignK1ToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign K1 validation for a ExcSK
   *
   * @param command UnAssignK1FromExcSKCommand
   */
  public void validate(UnAssignK1FromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK1FromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignK1FromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign K2 validation for a ExcSK
   *
   * @param command AssignK2ToExcSKCommand
   */
  public void validate(AssignK2ToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignK2ToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignK2ToExcSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignK2ToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign K2 validation for a ExcSK
   *
   * @param command UnAssignK2FromExcSKCommand
   */
  public void validate(UnAssignK2FromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK2FromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignK2FromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcSK
   *
   * @param command AssignKcToExcSKCommand
   */
  public void validate(AssignKcToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignKcToExcSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKcToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcSK
   *
   * @param command UnAssignKcFromExcSKCommand
   */
  public void validate(UnAssignKcFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignKcFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Kce validation for a ExcSK
   *
   * @param command AssignKceToExcSKCommand
   */
  public void validate(AssignKceToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignKceToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignKceToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKceToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Kce validation for a ExcSK
   *
   * @param command UnAssignKceFromExcSKCommand
   */
  public void validate(UnAssignKceFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKceFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignKceFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a ExcSK
   *
   * @param command AssignKdToExcSKCommand
   */
  public void validate(AssignKdToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignKdToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignKdToExcSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKdToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a ExcSK
   *
   * @param command UnAssignKdFromExcSKCommand
   */
  public void validate(UnAssignKdFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignKdFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Kgob validation for a ExcSK
   *
   * @param command AssignKgobToExcSKCommand
   */
  public void validate(AssignKgobToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignKgobToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignKgobToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKgobToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Kgob validation for a ExcSK
   *
   * @param command UnAssignKgobFromExcSKCommand
   */
  public void validate(UnAssignKgobFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKgobFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignKgobFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a ExcSK
   *
   * @param command AssignKpToExcSKCommand
   */
  public void validate(AssignKpToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignKpToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignKpToExcSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKpToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a ExcSK
   *
   * @param command UnAssignKpFromExcSKCommand
   */
  public void validate(UnAssignKpFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignKpFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Kqi validation for a ExcSK
   *
   * @param command AssignKqiToExcSKCommand
   */
  public void validate(AssignKqiToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignKqiToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignKqiToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKqiToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Kqi validation for a ExcSK
   *
   * @param command UnAssignKqiFromExcSKCommand
   */
  public void validate(UnAssignKqiFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKqiFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignKqiFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Kqob validation for a ExcSK
   *
   * @param command AssignKqobToExcSKCommand
   */
  public void validate(AssignKqobToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignKqobToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignKqobToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKqobToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Kqob validation for a ExcSK
   *
   * @param command UnAssignKqobFromExcSKCommand
   */
  public void validate(UnAssignKqobFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKqobFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignKqobFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Kqp validation for a ExcSK
   *
   * @param command AssignKqpToExcSKCommand
   */
  public void validate(AssignKqpToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignKqpToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignKqpToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKqpToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Kqp validation for a ExcSK
   *
   * @param command UnAssignKqpFromExcSKCommand
   */
  public void validate(UnAssignKqpFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKqpFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignKqpFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Nq validation for a ExcSK
   *
   * @param command AssignNqToExcSKCommand
   */
  public void validate(AssignNqToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignNqToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignNqToExcSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignNqToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Nq validation for a ExcSK
   *
   * @param command UnAssignNqFromExcSKCommand
   */
  public void validate(UnAssignNqFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNqFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignNqFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Qconoff validation for a ExcSK
   *
   * @param command AssignQconoffToExcSKCommand
   */
  public void validate(AssignQconoffToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignQconoffToExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "AssignQconoffToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQconoffToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Qconoff validation for a ExcSK
   *
   * @param command UnAssignQconoffFromExcSKCommand
   */
  public void validate(UnAssignQconoffFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQconoffFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignQconoffFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Qz validation for a ExcSK
   *
   * @param command AssignQzToExcSKCommand
   */
  public void validate(AssignQzToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignQzToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignQzToExcSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignQzToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Qz validation for a ExcSK
   *
   * @param command UnAssignQzFromExcSKCommand
   */
  public void validate(UnAssignQzFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQzFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignQzFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Remote validation for a ExcSK
   *
   * @param command AssignRemoteToExcSKCommand
   */
  public void validate(AssignRemoteToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignRemoteToExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "AssignRemoteToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRemoteToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Remote validation for a ExcSK
   *
   * @param command UnAssignRemoteFromExcSKCommand
   */
  public void validate(UnAssignRemoteFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRemoteFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignRemoteFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Sbase validation for a ExcSK
   *
   * @param command AssignSbaseToExcSKCommand
   */
  public void validate(AssignSbaseToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignSbaseToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignSbaseToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSbaseToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Sbase validation for a ExcSK
   *
   * @param command UnAssignSbaseFromExcSKCommand
   */
  public void validate(UnAssignSbaseFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSbaseFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignSbaseFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcSK
   *
   * @param command AssignTcToExcSKCommand
   */
  public void validate(AssignTcToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignTcToExcSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTcToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcSK
   *
   * @param command UnAssignTcFromExcSKCommand
   */
  public void validate(UnAssignTcFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignTcFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcSK
   *
   * @param command AssignTeToExcSKCommand
   */
  public void validate(AssignTeToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignTeToExcSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTeToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcSK
   *
   * @param command UnAssignTeFromExcSKCommand
   */
  public void validate(UnAssignTeFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignTeFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Ti validation for a ExcSK
   *
   * @param command AssignTiToExcSKCommand
   */
  public void validate(AssignTiToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignTiToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignTiToExcSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTiToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Ti validation for a ExcSK
   *
   * @param command UnAssignTiFromExcSKCommand
   */
  public void validate(UnAssignTiFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTiFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignTiFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Tp validation for a ExcSK
   *
   * @param command AssignTpToExcSKCommand
   */
  public void validate(AssignTpToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignTpToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignTpToExcSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTpToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Tp validation for a ExcSK
   *
   * @param command UnAssignTpFromExcSKCommand
   */
  public void validate(UnAssignTpFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignTpFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Tr validation for a ExcSK
   *
   * @param command AssignTrToExcSKCommand
   */
  public void validate(AssignTrToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignTrToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignTrToExcSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTrToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Tr validation for a ExcSK
   *
   * @param command UnAssignTrFromExcSKCommand
   */
  public void validate(UnAssignTrFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTrFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignTrFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Uimax validation for a ExcSK
   *
   * @param command AssignUimaxToExcSKCommand
   */
  public void validate(AssignUimaxToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignUimaxToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignUimaxToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUimaxToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Uimax validation for a ExcSK
   *
   * @param command UnAssignUimaxFromExcSKCommand
   */
  public void validate(UnAssignUimaxFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUimaxFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignUimaxFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Uimin validation for a ExcSK
   *
   * @param command AssignUiminToExcSKCommand
   */
  public void validate(AssignUiminToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignUiminToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignUiminToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUiminToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Uimin validation for a ExcSK
   *
   * @param command UnAssignUiminFromExcSKCommand
   */
  public void validate(UnAssignUiminFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUiminFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignUiminFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Urmax validation for a ExcSK
   *
   * @param command AssignUrmaxToExcSKCommand
   */
  public void validate(AssignUrmaxToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignUrmaxToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignUrmaxToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUrmaxToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Urmax validation for a ExcSK
   *
   * @param command UnAssignUrmaxFromExcSKCommand
   */
  public void validate(UnAssignUrmaxFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUrmaxFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignUrmaxFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Urmin validation for a ExcSK
   *
   * @param command AssignUrminToExcSKCommand
   */
  public void validate(AssignUrminToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignUrminToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignUrminToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUrminToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Urmin validation for a ExcSK
   *
   * @param command UnAssignUrminFromExcSKCommand
   */
  public void validate(UnAssignUrminFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUrminFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignUrminFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Vtmax validation for a ExcSK
   *
   * @param command AssignVtmaxToExcSKCommand
   */
  public void validate(AssignVtmaxToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignVtmaxToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignVtmaxToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVtmaxToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Vtmax validation for a ExcSK
   *
   * @param command UnAssignVtmaxFromExcSKCommand
   */
  public void validate(UnAssignVtmaxFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVtmaxFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignVtmaxFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Vtmin validation for a ExcSK
   *
   * @param command AssignVtminToExcSKCommand
   */
  public void validate(AssignVtminToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignVtminToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignVtminToExcSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVtminToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Vtmin validation for a ExcSK
   *
   * @param command UnAssignVtminFromExcSKCommand
   */
  public void validate(UnAssignVtminFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVtminFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignVtminFromExcSKCommand identifier should not be null");
  }
  /**
   * handles assign Yp validation for a ExcSK
   *
   * @param command AssignYpToExcSKCommand
   */
  public void validate(AssignYpToExcSKCommand command) throws Exception {
    Assert.notNull(command, "AssignYpToExcSKCommand should not be null");
    Assert.notNull(command.getExcSKId(), "AssignYpToExcSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignYpToExcSKCommand assignment should not be null");
  }

  /**
   * handles unassign Yp validation for a ExcSK
   *
   * @param command UnAssignYpFromExcSKCommand
   */
  public void validate(UnAssignYpFromExcSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignYpFromExcSKCommand should not be null");
    Assert.notNull(
        command.getExcSKId(), "UnAssignYpFromExcSKCommand identifier should not be null");
  }
}
