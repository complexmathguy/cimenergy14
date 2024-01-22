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

public class ExcST1AValidator {

  /** default constructor */
  protected ExcST1AValidator() {}

  /** factory method */
  public static ExcST1AValidator getInstance() {
    return new ExcST1AValidator();
  }

  /** handles creation validation for a ExcST1A */
  public void validate(CreateExcST1ACommand excST1A) throws Exception {
    Assert.notNull(excST1A, "CreateExcST1ACommand should not be null");
    //		Assert.isNull( excST1A.getExcST1AId(), "CreateExcST1ACommand identifier should be null" );
  }

  /** handles update validation for a ExcST1A */
  public void validate(UpdateExcST1ACommand excST1A) throws Exception {
    Assert.notNull(excST1A, "UpdateExcST1ACommand should not be null");
    Assert.notNull(excST1A.getExcST1AId(), "UpdateExcST1ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcST1A */
  public void validate(DeleteExcST1ACommand excST1A) throws Exception {
    Assert.notNull(excST1A, "{commandAlias} should not be null");
    Assert.notNull(excST1A.getExcST1AId(), "DeleteExcST1ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcST1A */
  public void validate(ExcST1AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcST1AFetchOneSummary should not be null");
    Assert.notNull(summary.getExcST1AId(), "ExcST1AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ilr validation for a ExcST1A
   *
   * @param command AssignIlrToExcST1ACommand
   */
  public void validate(AssignIlrToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignIlrToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignIlrToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIlrToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ilr validation for a ExcST1A
   *
   * @param command UnAssignIlrFromExcST1ACommand
   */
  public void validate(UnAssignIlrFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignIlrFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignIlrFromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcST1A
   *
   * @param command AssignKaToExcST1ACommand
   */
  public void validate(AssignKaToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignKaToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcST1A
   *
   * @param command UnAssignKaFromExcST1ACommand
   */
  public void validate(UnAssignKaFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignKaFromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcST1A
   *
   * @param command AssignKcToExcST1ACommand
   */
  public void validate(AssignKcToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignKcToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcST1A
   *
   * @param command UnAssignKcFromExcST1ACommand
   */
  public void validate(UnAssignKcFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignKcFromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcST1A
   *
   * @param command AssignKfToExcST1ACommand
   */
  public void validate(AssignKfToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignKfToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcST1A
   *
   * @param command UnAssignKfFromExcST1ACommand
   */
  public void validate(UnAssignKfFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignKfFromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Klr validation for a ExcST1A
   *
   * @param command AssignKlrToExcST1ACommand
   */
  public void validate(AssignKlrToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKlrToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignKlrToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKlrToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Klr validation for a ExcST1A
   *
   * @param command UnAssignKlrFromExcST1ACommand
   */
  public void validate(UnAssignKlrFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKlrFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignKlrFromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcST1A
   *
   * @param command AssignTaToExcST1ACommand
   */
  public void validate(AssignTaToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignTaToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcST1A
   *
   * @param command UnAssignTaFromExcST1ACommand
   */
  public void validate(UnAssignTaFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignTaFromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcST1A
   *
   * @param command AssignTbToExcST1ACommand
   */
  public void validate(AssignTbToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignTbToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcST1A
   *
   * @param command UnAssignTbFromExcST1ACommand
   */
  public void validate(UnAssignTbFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignTbFromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Tb1 validation for a ExcST1A
   *
   * @param command AssignTb1ToExcST1ACommand
   */
  public void validate(AssignTb1ToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTb1ToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignTb1ToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTb1ToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb1 validation for a ExcST1A
   *
   * @param command UnAssignTb1FromExcST1ACommand
   */
  public void validate(UnAssignTb1FromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTb1FromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignTb1FromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcST1A
   *
   * @param command AssignTcToExcST1ACommand
   */
  public void validate(AssignTcToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignTcToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcST1A
   *
   * @param command UnAssignTcFromExcST1ACommand
   */
  public void validate(UnAssignTcFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignTcFromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Tc1 validation for a ExcST1A
   *
   * @param command AssignTc1ToExcST1ACommand
   */
  public void validate(AssignTc1ToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTc1ToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignTc1ToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTc1ToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc1 validation for a ExcST1A
   *
   * @param command UnAssignTc1FromExcST1ACommand
   */
  public void validate(UnAssignTc1FromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTc1FromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignTc1FromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcST1A
   *
   * @param command AssignTfToExcST1ACommand
   */
  public void validate(AssignTfToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignTfToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcST1A
   *
   * @param command UnAssignTfFromExcST1ACommand
   */
  public void validate(UnAssignTfFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignTfFromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Vamax validation for a ExcST1A
   *
   * @param command AssignVamaxToExcST1ACommand
   */
  public void validate(AssignVamaxToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVamaxToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignVamaxToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVamaxToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamax validation for a ExcST1A
   *
   * @param command UnAssignVamaxFromExcST1ACommand
   */
  public void validate(UnAssignVamaxFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVamaxFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignVamaxFromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Vamin validation for a ExcST1A
   *
   * @param command AssignVaminToExcST1ACommand
   */
  public void validate(AssignVaminToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVaminToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignVaminToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVaminToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamin validation for a ExcST1A
   *
   * @param command UnAssignVaminFromExcST1ACommand
   */
  public void validate(UnAssignVaminFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVaminFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignVaminFromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Vimax validation for a ExcST1A
   *
   * @param command AssignVimaxToExcST1ACommand
   */
  public void validate(AssignVimaxToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVimaxToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignVimaxToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVimaxToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vimax validation for a ExcST1A
   *
   * @param command UnAssignVimaxFromExcST1ACommand
   */
  public void validate(UnAssignVimaxFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVimaxFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignVimaxFromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Vimin validation for a ExcST1A
   *
   * @param command AssignViminToExcST1ACommand
   */
  public void validate(AssignViminToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignViminToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignViminToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignViminToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vimin validation for a ExcST1A
   *
   * @param command UnAssignViminFromExcST1ACommand
   */
  public void validate(UnAssignViminFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignViminFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignViminFromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcST1A
   *
   * @param command AssignVrmaxToExcST1ACommand
   */
  public void validate(AssignVrmaxToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignVrmaxToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcST1A
   *
   * @param command UnAssignVrmaxFromExcST1ACommand
   */
  public void validate(UnAssignVrmaxFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignVrmaxFromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcST1A
   *
   * @param command AssignVrminToExcST1ACommand
   */
  public void validate(AssignVrminToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignVrminToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcST1A
   *
   * @param command UnAssignVrminFromExcST1ACommand
   */
  public void validate(UnAssignVrminFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignVrminFromExcST1ACommand identifier should not be null");
  }
  /**
   * handles assign Xe validation for a ExcST1A
   *
   * @param command AssignXeToExcST1ACommand
   */
  public void validate(AssignXeToExcST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignXeToExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "AssignXeToExcST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXeToExcST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Xe validation for a ExcST1A
   *
   * @param command UnAssignXeFromExcST1ACommand
   */
  public void validate(UnAssignXeFromExcST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignXeFromExcST1ACommand should not be null");
    Assert.notNull(
        command.getExcST1AId(), "UnAssignXeFromExcST1ACommand identifier should not be null");
  }
}
