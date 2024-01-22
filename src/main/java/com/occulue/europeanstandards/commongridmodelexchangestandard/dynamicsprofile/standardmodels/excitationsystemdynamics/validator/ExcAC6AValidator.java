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

public class ExcAC6AValidator {

  /** default constructor */
  protected ExcAC6AValidator() {}

  /** factory method */
  public static ExcAC6AValidator getInstance() {
    return new ExcAC6AValidator();
  }

  /** handles creation validation for a ExcAC6A */
  public void validate(CreateExcAC6ACommand excAC6A) throws Exception {
    Assert.notNull(excAC6A, "CreateExcAC6ACommand should not be null");
    //		Assert.isNull( excAC6A.getExcAC6AId(), "CreateExcAC6ACommand identifier should be null" );
  }

  /** handles update validation for a ExcAC6A */
  public void validate(UpdateExcAC6ACommand excAC6A) throws Exception {
    Assert.notNull(excAC6A, "UpdateExcAC6ACommand should not be null");
    Assert.notNull(excAC6A.getExcAC6AId(), "UpdateExcAC6ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcAC6A */
  public void validate(DeleteExcAC6ACommand excAC6A) throws Exception {
    Assert.notNull(excAC6A, "{commandAlias} should not be null");
    Assert.notNull(excAC6A.getExcAC6AId(), "DeleteExcAC6ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcAC6A */
  public void validate(ExcAC6AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcAC6AFetchOneSummary should not be null");
    Assert.notNull(summary.getExcAC6AId(), "ExcAC6AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ka validation for a ExcAC6A
   *
   * @param command AssignKaToExcAC6ACommand
   */
  public void validate(AssignKaToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignKaToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcAC6A
   *
   * @param command UnAssignKaFromExcAC6ACommand
   */
  public void validate(UnAssignKaFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignKaFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcAC6A
   *
   * @param command AssignKcToExcAC6ACommand
   */
  public void validate(AssignKcToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignKcToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcAC6A
   *
   * @param command UnAssignKcFromExcAC6ACommand
   */
  public void validate(UnAssignKcFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignKcFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a ExcAC6A
   *
   * @param command AssignKdToExcAC6ACommand
   */
  public void validate(AssignKdToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignKdToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignKdToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a ExcAC6A
   *
   * @param command UnAssignKdFromExcAC6ACommand
   */
  public void validate(UnAssignKdFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignKdFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcAC6A
   *
   * @param command AssignKeToExcAC6ACommand
   */
  public void validate(AssignKeToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignKeToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcAC6A
   *
   * @param command UnAssignKeFromExcAC6ACommand
   */
  public void validate(UnAssignKeFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignKeFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Kh validation for a ExcAC6A
   *
   * @param command AssignKhToExcAC6ACommand
   */
  public void validate(AssignKhToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignKhToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignKhToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKhToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Kh validation for a ExcAC6A
   *
   * @param command UnAssignKhFromExcAC6ACommand
   */
  public void validate(UnAssignKhFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKhFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignKhFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Ks validation for a ExcAC6A
   *
   * @param command AssignKsToExcAC6ACommand
   */
  public void validate(AssignKsToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignKsToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignKsToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKsToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Ks validation for a ExcAC6A
   *
   * @param command UnAssignKsFromExcAC6ACommand
   */
  public void validate(UnAssignKsFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKsFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignKsFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Seve1 validation for a ExcAC6A
   *
   * @param command AssignSeve1ToExcAC6ACommand
   */
  public void validate(AssignSeve1ToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve1ToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignSeve1ToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve1ToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve1 validation for a ExcAC6A
   *
   * @param command UnAssignSeve1FromExcAC6ACommand
   */
  public void validate(UnAssignSeve1FromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve1FromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignSeve1FromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Seve2 validation for a ExcAC6A
   *
   * @param command AssignSeve2ToExcAC6ACommand
   */
  public void validate(AssignSeve2ToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve2ToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignSeve2ToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve2ToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve2 validation for a ExcAC6A
   *
   * @param command UnAssignSeve2FromExcAC6ACommand
   */
  public void validate(UnAssignSeve2FromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve2FromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignSeve2FromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcAC6A
   *
   * @param command AssignTaToExcAC6ACommand
   */
  public void validate(AssignTaToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignTaToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcAC6A
   *
   * @param command UnAssignTaFromExcAC6ACommand
   */
  public void validate(UnAssignTaFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignTaFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcAC6A
   *
   * @param command AssignTbToExcAC6ACommand
   */
  public void validate(AssignTbToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignTbToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcAC6A
   *
   * @param command UnAssignTbFromExcAC6ACommand
   */
  public void validate(UnAssignTbFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignTbFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcAC6A
   *
   * @param command AssignTcToExcAC6ACommand
   */
  public void validate(AssignTcToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignTcToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcAC6A
   *
   * @param command UnAssignTcFromExcAC6ACommand
   */
  public void validate(UnAssignTcFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignTcFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcAC6A
   *
   * @param command AssignTeToExcAC6ACommand
   */
  public void validate(AssignTeToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignTeToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcAC6A
   *
   * @param command UnAssignTeFromExcAC6ACommand
   */
  public void validate(UnAssignTeFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignTeFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Th validation for a ExcAC6A
   *
   * @param command AssignThToExcAC6ACommand
   */
  public void validate(AssignThToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignThToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignThToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignThToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Th validation for a ExcAC6A
   *
   * @param command UnAssignThFromExcAC6ACommand
   */
  public void validate(UnAssignThFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignThFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignThFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Tj validation for a ExcAC6A
   *
   * @param command AssignTjToExcAC6ACommand
   */
  public void validate(AssignTjToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignTjToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignTjToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTjToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Tj validation for a ExcAC6A
   *
   * @param command UnAssignTjFromExcAC6ACommand
   */
  public void validate(UnAssignTjFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTjFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignTjFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Tk validation for a ExcAC6A
   *
   * @param command AssignTkToExcAC6ACommand
   */
  public void validate(AssignTkToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignTkToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignTkToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTkToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Tk validation for a ExcAC6A
   *
   * @param command UnAssignTkFromExcAC6ACommand
   */
  public void validate(UnAssignTkFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTkFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignTkFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Vamax validation for a ExcAC6A
   *
   * @param command AssignVamaxToExcAC6ACommand
   */
  public void validate(AssignVamaxToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVamaxToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignVamaxToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVamaxToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamax validation for a ExcAC6A
   *
   * @param command UnAssignVamaxFromExcAC6ACommand
   */
  public void validate(UnAssignVamaxFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVamaxFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignVamaxFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Vamin validation for a ExcAC6A
   *
   * @param command AssignVaminToExcAC6ACommand
   */
  public void validate(AssignVaminToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVaminToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignVaminToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVaminToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamin validation for a ExcAC6A
   *
   * @param command UnAssignVaminFromExcAC6ACommand
   */
  public void validate(UnAssignVaminFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVaminFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignVaminFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Ve1 validation for a ExcAC6A
   *
   * @param command AssignVe1ToExcAC6ACommand
   */
  public void validate(AssignVe1ToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe1ToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignVe1ToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe1ToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve1 validation for a ExcAC6A
   *
   * @param command UnAssignVe1FromExcAC6ACommand
   */
  public void validate(UnAssignVe1FromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe1FromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignVe1FromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Ve2 validation for a ExcAC6A
   *
   * @param command AssignVe2ToExcAC6ACommand
   */
  public void validate(AssignVe2ToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe2ToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignVe2ToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe2ToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve2 validation for a ExcAC6A
   *
   * @param command UnAssignVe2FromExcAC6ACommand
   */
  public void validate(UnAssignVe2FromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe2FromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignVe2FromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Vfelim validation for a ExcAC6A
   *
   * @param command AssignVfelimToExcAC6ACommand
   */
  public void validate(AssignVfelimToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVfelimToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignVfelimToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVfelimToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Vfelim validation for a ExcAC6A
   *
   * @param command UnAssignVfelimFromExcAC6ACommand
   */
  public void validate(UnAssignVfelimFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVfelimFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignVfelimFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Vhmax validation for a ExcAC6A
   *
   * @param command AssignVhmaxToExcAC6ACommand
   */
  public void validate(AssignVhmaxToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVhmaxToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignVhmaxToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVhmaxToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Vhmax validation for a ExcAC6A
   *
   * @param command UnAssignVhmaxFromExcAC6ACommand
   */
  public void validate(UnAssignVhmaxFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVhmaxFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignVhmaxFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcAC6A
   *
   * @param command AssignVrmaxToExcAC6ACommand
   */
  public void validate(AssignVrmaxToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignVrmaxToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcAC6A
   *
   * @param command UnAssignVrmaxFromExcAC6ACommand
   */
  public void validate(UnAssignVrmaxFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignVrmaxFromExcAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcAC6A
   *
   * @param command AssignVrminToExcAC6ACommand
   */
  public void validate(AssignVrminToExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "AssignVrminToExcAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcAC6A
   *
   * @param command UnAssignVrminFromExcAC6ACommand
   */
  public void validate(UnAssignVrminFromExcAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcAC6ACommand should not be null");
    Assert.notNull(
        command.getExcAC6AId(), "UnAssignVrminFromExcAC6ACommand identifier should not be null");
  }
}
