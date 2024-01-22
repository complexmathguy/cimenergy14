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

public class ExcIEEEAC8BValidator {

  /** default constructor */
  protected ExcIEEEAC8BValidator() {}

  /** factory method */
  public static ExcIEEEAC8BValidator getInstance() {
    return new ExcIEEEAC8BValidator();
  }

  /** handles creation validation for a ExcIEEEAC8B */
  public void validate(CreateExcIEEEAC8BCommand excIEEEAC8B) throws Exception {
    Assert.notNull(excIEEEAC8B, "CreateExcIEEEAC8BCommand should not be null");
    //		Assert.isNull( excIEEEAC8B.getExcIEEEAC8BId(), "CreateExcIEEEAC8BCommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEAC8B */
  public void validate(UpdateExcIEEEAC8BCommand excIEEEAC8B) throws Exception {
    Assert.notNull(excIEEEAC8B, "UpdateExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        excIEEEAC8B.getExcIEEEAC8BId(), "UpdateExcIEEEAC8BCommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEAC8B */
  public void validate(DeleteExcIEEEAC8BCommand excIEEEAC8B) throws Exception {
    Assert.notNull(excIEEEAC8B, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEAC8B.getExcIEEEAC8BId(), "DeleteExcIEEEAC8BCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEAC8B */
  public void validate(ExcIEEEAC8BFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEAC8BFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEAC8BId(), "ExcIEEEAC8BFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ka validation for a ExcIEEEAC8B
   *
   * @param command AssignKaToExcIEEEAC8BCommand
   */
  public void validate(AssignKaToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(), "AssignKaToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcIEEEAC8B
   *
   * @param command UnAssignKaFromExcIEEEAC8BCommand
   */
  public void validate(UnAssignKaFromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignKaFromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcIEEEAC8B
   *
   * @param command AssignKcToExcIEEEAC8BCommand
   */
  public void validate(AssignKcToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(), "AssignKcToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcIEEEAC8B
   *
   * @param command UnAssignKcFromExcIEEEAC8BCommand
   */
  public void validate(UnAssignKcFromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignKcFromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a ExcIEEEAC8B
   *
   * @param command AssignKdToExcIEEEAC8BCommand
   */
  public void validate(AssignKdToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignKdToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(), "AssignKdToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a ExcIEEEAC8B
   *
   * @param command UnAssignKdFromExcIEEEAC8BCommand
   */
  public void validate(UnAssignKdFromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignKdFromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Kdr validation for a ExcIEEEAC8B
   *
   * @param command AssignKdrToExcIEEEAC8BCommand
   */
  public void validate(AssignKdrToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignKdrToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(), "AssignKdrToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdrToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Kdr validation for a ExcIEEEAC8B
   *
   * @param command UnAssignKdrFromExcIEEEAC8BCommand
   */
  public void validate(UnAssignKdrFromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdrFromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignKdrFromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcIEEEAC8B
   *
   * @param command AssignKeToExcIEEEAC8BCommand
   */
  public void validate(AssignKeToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(), "AssignKeToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcIEEEAC8B
   *
   * @param command UnAssignKeFromExcIEEEAC8BCommand
   */
  public void validate(UnAssignKeFromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignKeFromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Kir validation for a ExcIEEEAC8B
   *
   * @param command AssignKirToExcIEEEAC8BCommand
   */
  public void validate(AssignKirToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignKirToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(), "AssignKirToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKirToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Kir validation for a ExcIEEEAC8B
   *
   * @param command UnAssignKirFromExcIEEEAC8BCommand
   */
  public void validate(UnAssignKirFromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKirFromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignKirFromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Kpr validation for a ExcIEEEAC8B
   *
   * @param command AssignKprToExcIEEEAC8BCommand
   */
  public void validate(AssignKprToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignKprToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(), "AssignKprToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKprToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Kpr validation for a ExcIEEEAC8B
   *
   * @param command UnAssignKprFromExcIEEEAC8BCommand
   */
  public void validate(UnAssignKprFromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKprFromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignKprFromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Seve1 validation for a ExcIEEEAC8B
   *
   * @param command AssignSeve1ToExcIEEEAC8BCommand
   */
  public void validate(AssignSeve1ToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignSeve1ToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "AssignSeve1ToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve1ToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Seve1 validation for a ExcIEEEAC8B
   *
   * @param command UnAssignSeve1FromExcIEEEAC8BCommand
   */
  public void validate(UnAssignSeve1FromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve1FromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignSeve1FromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Seve2 validation for a ExcIEEEAC8B
   *
   * @param command AssignSeve2ToExcIEEEAC8BCommand
   */
  public void validate(AssignSeve2ToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignSeve2ToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "AssignSeve2ToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve2ToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Seve2 validation for a ExcIEEEAC8B
   *
   * @param command UnAssignSeve2FromExcIEEEAC8BCommand
   */
  public void validate(UnAssignSeve2FromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve2FromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignSeve2FromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcIEEEAC8B
   *
   * @param command AssignTaToExcIEEEAC8BCommand
   */
  public void validate(AssignTaToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(), "AssignTaToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcIEEEAC8B
   *
   * @param command UnAssignTaFromExcIEEEAC8BCommand
   */
  public void validate(UnAssignTaFromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignTaFromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Tdr validation for a ExcIEEEAC8B
   *
   * @param command AssignTdrToExcIEEEAC8BCommand
   */
  public void validate(AssignTdrToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignTdrToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(), "AssignTdrToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdrToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Tdr validation for a ExcIEEEAC8B
   *
   * @param command UnAssignTdrFromExcIEEEAC8BCommand
   */
  public void validate(UnAssignTdrFromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdrFromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignTdrFromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcIEEEAC8B
   *
   * @param command AssignTeToExcIEEEAC8BCommand
   */
  public void validate(AssignTeToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(), "AssignTeToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcIEEEAC8B
   *
   * @param command UnAssignTeFromExcIEEEAC8BCommand
   */
  public void validate(UnAssignTeFromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignTeFromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Ve1 validation for a ExcIEEEAC8B
   *
   * @param command AssignVe1ToExcIEEEAC8BCommand
   */
  public void validate(AssignVe1ToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVe1ToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(), "AssignVe1ToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe1ToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Ve1 validation for a ExcIEEEAC8B
   *
   * @param command UnAssignVe1FromExcIEEEAC8BCommand
   */
  public void validate(UnAssignVe1FromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe1FromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignVe1FromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Ve2 validation for a ExcIEEEAC8B
   *
   * @param command AssignVe2ToExcIEEEAC8BCommand
   */
  public void validate(AssignVe2ToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVe2ToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(), "AssignVe2ToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe2ToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Ve2 validation for a ExcIEEEAC8B
   *
   * @param command UnAssignVe2FromExcIEEEAC8BCommand
   */
  public void validate(UnAssignVe2FromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe2FromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignVe2FromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Vemin validation for a ExcIEEEAC8B
   *
   * @param command AssignVeminToExcIEEEAC8BCommand
   */
  public void validate(AssignVeminToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVeminToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "AssignVeminToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVeminToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Vemin validation for a ExcIEEEAC8B
   *
   * @param command UnAssignVeminFromExcIEEEAC8BCommand
   */
  public void validate(UnAssignVeminFromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVeminFromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignVeminFromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Vfemax validation for a ExcIEEEAC8B
   *
   * @param command AssignVfemaxToExcIEEEAC8BCommand
   */
  public void validate(AssignVfemaxToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVfemaxToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "AssignVfemaxToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVfemaxToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Vfemax validation for a ExcIEEEAC8B
   *
   * @param command UnAssignVfemaxFromExcIEEEAC8BCommand
   */
  public void validate(UnAssignVfemaxFromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVfemaxFromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignVfemaxFromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEAC8B
   *
   * @param command AssignVrmaxToExcIEEEAC8BCommand
   */
  public void validate(AssignVrmaxToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "AssignVrmaxToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEAC8B
   *
   * @param command UnAssignVrmaxFromExcIEEEAC8BCommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignVrmaxFromExcIEEEAC8BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEAC8B
   *
   * @param command AssignVrminToExcIEEEAC8BCommand
   */
  public void validate(AssignVrminToExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "AssignVrminToExcIEEEAC8BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEAC8BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEAC8B
   *
   * @param command UnAssignVrminFromExcIEEEAC8BCommand
   */
  public void validate(UnAssignVrminFromExcIEEEAC8BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEAC8BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC8BId(),
        "UnAssignVrminFromExcIEEEAC8BCommand identifier should not be null");
  }
}
