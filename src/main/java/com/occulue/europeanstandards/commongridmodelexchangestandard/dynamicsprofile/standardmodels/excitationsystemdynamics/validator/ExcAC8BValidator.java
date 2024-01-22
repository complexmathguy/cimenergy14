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

public class ExcAC8BValidator {

  /** default constructor */
  protected ExcAC8BValidator() {}

  /** factory method */
  public static ExcAC8BValidator getInstance() {
    return new ExcAC8BValidator();
  }

  /** handles creation validation for a ExcAC8B */
  public void validate(CreateExcAC8BCommand excAC8B) throws Exception {
    Assert.notNull(excAC8B, "CreateExcAC8BCommand should not be null");
    //		Assert.isNull( excAC8B.getExcAC8BId(), "CreateExcAC8BCommand identifier should be null" );
  }

  /** handles update validation for a ExcAC8B */
  public void validate(UpdateExcAC8BCommand excAC8B) throws Exception {
    Assert.notNull(excAC8B, "UpdateExcAC8BCommand should not be null");
    Assert.notNull(excAC8B.getExcAC8BId(), "UpdateExcAC8BCommand identifier should not be null");
  }

  /** handles delete validation for a ExcAC8B */
  public void validate(DeleteExcAC8BCommand excAC8B) throws Exception {
    Assert.notNull(excAC8B, "{commandAlias} should not be null");
    Assert.notNull(excAC8B.getExcAC8BId(), "DeleteExcAC8BCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcAC8B */
  public void validate(ExcAC8BFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcAC8BFetchOneSummary should not be null");
    Assert.notNull(summary.getExcAC8BId(), "ExcAC8BFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Inlim validation for a ExcAC8B
   *
   * @param command AssignInlimToExcAC8BCommand
   */
  public void validate(AssignInlimToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignInlimToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignInlimToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignInlimToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Inlim validation for a ExcAC8B
   *
   * @param command UnAssignInlimFromExcAC8BCommand
   */
  public void validate(UnAssignInlimFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignInlimFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignInlimFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcAC8B
   *
   * @param command AssignKaToExcAC8BCommand
   */
  public void validate(AssignKaToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignKaToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcAC8B
   *
   * @param command UnAssignKaFromExcAC8BCommand
   */
  public void validate(UnAssignKaFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignKaFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcAC8B
   *
   * @param command AssignKcToExcAC8BCommand
   */
  public void validate(AssignKcToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignKcToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcAC8B
   *
   * @param command UnAssignKcFromExcAC8BCommand
   */
  public void validate(UnAssignKcFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignKcFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a ExcAC8B
   *
   * @param command AssignKdToExcAC8BCommand
   */
  public void validate(AssignKdToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignKdToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignKdToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a ExcAC8B
   *
   * @param command UnAssignKdFromExcAC8BCommand
   */
  public void validate(UnAssignKdFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignKdFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Kdr validation for a ExcAC8B
   *
   * @param command AssignKdrToExcAC8BCommand
   */
  public void validate(AssignKdrToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignKdrToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignKdrToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdrToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Kdr validation for a ExcAC8B
   *
   * @param command UnAssignKdrFromExcAC8BCommand
   */
  public void validate(UnAssignKdrFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdrFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignKdrFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcAC8B
   *
   * @param command AssignKeToExcAC8BCommand
   */
  public void validate(AssignKeToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignKeToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcAC8B
   *
   * @param command UnAssignKeFromExcAC8BCommand
   */
  public void validate(UnAssignKeFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignKeFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Kir validation for a ExcAC8B
   *
   * @param command AssignKirToExcAC8BCommand
   */
  public void validate(AssignKirToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignKirToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignKirToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKirToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Kir validation for a ExcAC8B
   *
   * @param command UnAssignKirFromExcAC8BCommand
   */
  public void validate(UnAssignKirFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKirFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignKirFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Kpr validation for a ExcAC8B
   *
   * @param command AssignKprToExcAC8BCommand
   */
  public void validate(AssignKprToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignKprToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignKprToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKprToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Kpr validation for a ExcAC8B
   *
   * @param command UnAssignKprFromExcAC8BCommand
   */
  public void validate(UnAssignKprFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKprFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignKprFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Ks validation for a ExcAC8B
   *
   * @param command AssignKsToExcAC8BCommand
   */
  public void validate(AssignKsToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignKsToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignKsToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKsToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Ks validation for a ExcAC8B
   *
   * @param command UnAssignKsFromExcAC8BCommand
   */
  public void validate(UnAssignKsFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKsFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignKsFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Pidlim validation for a ExcAC8B
   *
   * @param command AssignPidlimToExcAC8BCommand
   */
  public void validate(AssignPidlimToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignPidlimToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignPidlimToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPidlimToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Pidlim validation for a ExcAC8B
   *
   * @param command UnAssignPidlimFromExcAC8BCommand
   */
  public void validate(UnAssignPidlimFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPidlimFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignPidlimFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Seve1 validation for a ExcAC8B
   *
   * @param command AssignSeve1ToExcAC8BCommand
   */
  public void validate(AssignSeve1ToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignSeve1ToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignSeve1ToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve1ToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Seve1 validation for a ExcAC8B
   *
   * @param command UnAssignSeve1FromExcAC8BCommand
   */
  public void validate(UnAssignSeve1FromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve1FromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignSeve1FromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Seve2 validation for a ExcAC8B
   *
   * @param command AssignSeve2ToExcAC8BCommand
   */
  public void validate(AssignSeve2ToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignSeve2ToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignSeve2ToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve2ToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Seve2 validation for a ExcAC8B
   *
   * @param command UnAssignSeve2FromExcAC8BCommand
   */
  public void validate(UnAssignSeve2FromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve2FromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignSeve2FromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcAC8B
   *
   * @param command AssignTaToExcAC8BCommand
   */
  public void validate(AssignTaToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignTaToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcAC8B
   *
   * @param command UnAssignTaFromExcAC8BCommand
   */
  public void validate(UnAssignTaFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignTaFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Tdr validation for a ExcAC8B
   *
   * @param command AssignTdrToExcAC8BCommand
   */
  public void validate(AssignTdrToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignTdrToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignTdrToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdrToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Tdr validation for a ExcAC8B
   *
   * @param command UnAssignTdrFromExcAC8BCommand
   */
  public void validate(UnAssignTdrFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdrFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignTdrFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcAC8B
   *
   * @param command AssignTeToExcAC8BCommand
   */
  public void validate(AssignTeToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignTeToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcAC8B
   *
   * @param command UnAssignTeFromExcAC8BCommand
   */
  public void validate(UnAssignTeFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignTeFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Telim validation for a ExcAC8B
   *
   * @param command AssignTelimToExcAC8BCommand
   */
  public void validate(AssignTelimToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignTelimToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignTelimToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTelimToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Telim validation for a ExcAC8B
   *
   * @param command UnAssignTelimFromExcAC8BCommand
   */
  public void validate(UnAssignTelimFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTelimFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignTelimFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Ve1 validation for a ExcAC8B
   *
   * @param command AssignVe1ToExcAC8BCommand
   */
  public void validate(AssignVe1ToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVe1ToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignVe1ToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe1ToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Ve1 validation for a ExcAC8B
   *
   * @param command UnAssignVe1FromExcAC8BCommand
   */
  public void validate(UnAssignVe1FromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe1FromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignVe1FromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Ve2 validation for a ExcAC8B
   *
   * @param command AssignVe2ToExcAC8BCommand
   */
  public void validate(AssignVe2ToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVe2ToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignVe2ToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe2ToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Ve2 validation for a ExcAC8B
   *
   * @param command UnAssignVe2FromExcAC8BCommand
   */
  public void validate(UnAssignVe2FromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe2FromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignVe2FromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Vemin validation for a ExcAC8B
   *
   * @param command AssignVeminToExcAC8BCommand
   */
  public void validate(AssignVeminToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVeminToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignVeminToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVeminToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Vemin validation for a ExcAC8B
   *
   * @param command UnAssignVeminFromExcAC8BCommand
   */
  public void validate(UnAssignVeminFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVeminFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignVeminFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Vfemax validation for a ExcAC8B
   *
   * @param command AssignVfemaxToExcAC8BCommand
   */
  public void validate(AssignVfemaxToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVfemaxToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignVfemaxToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVfemaxToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Vfemax validation for a ExcAC8B
   *
   * @param command UnAssignVfemaxFromExcAC8BCommand
   */
  public void validate(UnAssignVfemaxFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVfemaxFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignVfemaxFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Vimax validation for a ExcAC8B
   *
   * @param command AssignVimaxToExcAC8BCommand
   */
  public void validate(AssignVimaxToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVimaxToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignVimaxToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVimaxToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Vimax validation for a ExcAC8B
   *
   * @param command UnAssignVimaxFromExcAC8BCommand
   */
  public void validate(UnAssignVimaxFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVimaxFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignVimaxFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Vimin validation for a ExcAC8B
   *
   * @param command AssignViminToExcAC8BCommand
   */
  public void validate(AssignViminToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignViminToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignViminToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignViminToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Vimin validation for a ExcAC8B
   *
   * @param command UnAssignViminFromExcAC8BCommand
   */
  public void validate(UnAssignViminFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignViminFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignViminFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Vpidmax validation for a ExcAC8B
   *
   * @param command AssignVpidmaxToExcAC8BCommand
   */
  public void validate(AssignVpidmaxToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVpidmaxToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignVpidmaxToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVpidmaxToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Vpidmax validation for a ExcAC8B
   *
   * @param command UnAssignVpidmaxFromExcAC8BCommand
   */
  public void validate(UnAssignVpidmaxFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVpidmaxFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignVpidmaxFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Vpidmin validation for a ExcAC8B
   *
   * @param command AssignVpidminToExcAC8BCommand
   */
  public void validate(AssignVpidminToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVpidminToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignVpidminToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVpidminToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Vpidmin validation for a ExcAC8B
   *
   * @param command UnAssignVpidminFromExcAC8BCommand
   */
  public void validate(UnAssignVpidminFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVpidminFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignVpidminFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcAC8B
   *
   * @param command AssignVrmaxToExcAC8BCommand
   */
  public void validate(AssignVrmaxToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignVrmaxToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcAC8B
   *
   * @param command UnAssignVrmaxFromExcAC8BCommand
   */
  public void validate(UnAssignVrmaxFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignVrmaxFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcAC8B
   *
   * @param command AssignVrminToExcAC8BCommand
   */
  public void validate(AssignVrminToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignVrminToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcAC8B
   *
   * @param command UnAssignVrminFromExcAC8BCommand
   */
  public void validate(UnAssignVrminFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignVrminFromExcAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Vtmult validation for a ExcAC8B
   *
   * @param command AssignVtmultToExcAC8BCommand
   */
  public void validate(AssignVtmultToExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVtmultToExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "AssignVtmultToExcAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVtmultToExcAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Vtmult validation for a ExcAC8B
   *
   * @param command UnAssignVtmultFromExcAC8BCommand
   */
  public void validate(UnAssignVtmultFromExcAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVtmultFromExcAC8BCommand should not be null");
    Assert.notNull(
        command.getExcAC8BId(), "UnAssignVtmultFromExcAC8BCommand identifier should not be null");
  }
}
