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

public class ExcIEEEAC6AValidator {

  /** default constructor */
  protected ExcIEEEAC6AValidator() {}

  /** factory method */
  public static ExcIEEEAC6AValidator getInstance() {
    return new ExcIEEEAC6AValidator();
  }

  /** handles creation validation for a ExcIEEEAC6A */
  public void validate(CreateExcIEEEAC6ACommand excIEEEAC6A) throws Exception {
    Assert.notNull(excIEEEAC6A, "CreateExcIEEEAC6ACommand should not be null");
    //		Assert.isNull( excIEEEAC6A.getExcIEEEAC6AId(), "CreateExcIEEEAC6ACommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEAC6A */
  public void validate(UpdateExcIEEEAC6ACommand excIEEEAC6A) throws Exception {
    Assert.notNull(excIEEEAC6A, "UpdateExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        excIEEEAC6A.getExcIEEEAC6AId(), "UpdateExcIEEEAC6ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEAC6A */
  public void validate(DeleteExcIEEEAC6ACommand excIEEEAC6A) throws Exception {
    Assert.notNull(excIEEEAC6A, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEAC6A.getExcIEEEAC6AId(), "DeleteExcIEEEAC6ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEAC6A */
  public void validate(ExcIEEEAC6AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEAC6AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEAC6AId(), "ExcIEEEAC6AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ka validation for a ExcIEEEAC6A
   *
   * @param command AssignKaToExcIEEEAC6ACommand
   */
  public void validate(AssignKaToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(), "AssignKaToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcIEEEAC6A
   *
   * @param command UnAssignKaFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignKaFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignKaFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcIEEEAC6A
   *
   * @param command AssignKcToExcIEEEAC6ACommand
   */
  public void validate(AssignKcToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(), "AssignKcToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcIEEEAC6A
   *
   * @param command UnAssignKcFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignKcFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignKcFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a ExcIEEEAC6A
   *
   * @param command AssignKdToExcIEEEAC6ACommand
   */
  public void validate(AssignKdToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignKdToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(), "AssignKdToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a ExcIEEEAC6A
   *
   * @param command UnAssignKdFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignKdFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignKdFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcIEEEAC6A
   *
   * @param command AssignKeToExcIEEEAC6ACommand
   */
  public void validate(AssignKeToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(), "AssignKeToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcIEEEAC6A
   *
   * @param command UnAssignKeFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignKeFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignKeFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Kh validation for a ExcIEEEAC6A
   *
   * @param command AssignKhToExcIEEEAC6ACommand
   */
  public void validate(AssignKhToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignKhToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(), "AssignKhToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKhToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Kh validation for a ExcIEEEAC6A
   *
   * @param command UnAssignKhFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignKhFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKhFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignKhFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Seve1 validation for a ExcIEEEAC6A
   *
   * @param command AssignSeve1ToExcIEEEAC6ACommand
   */
  public void validate(AssignSeve1ToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve1ToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "AssignSeve1ToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve1ToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve1 validation for a ExcIEEEAC6A
   *
   * @param command UnAssignSeve1FromExcIEEEAC6ACommand
   */
  public void validate(UnAssignSeve1FromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve1FromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignSeve1FromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Seve2 validation for a ExcIEEEAC6A
   *
   * @param command AssignSeve2ToExcIEEEAC6ACommand
   */
  public void validate(AssignSeve2ToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve2ToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "AssignSeve2ToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve2ToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve2 validation for a ExcIEEEAC6A
   *
   * @param command UnAssignSeve2FromExcIEEEAC6ACommand
   */
  public void validate(UnAssignSeve2FromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve2FromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignSeve2FromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcIEEEAC6A
   *
   * @param command AssignTaToExcIEEEAC6ACommand
   */
  public void validate(AssignTaToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(), "AssignTaToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcIEEEAC6A
   *
   * @param command UnAssignTaFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignTaFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignTaFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcIEEEAC6A
   *
   * @param command AssignTbToExcIEEEAC6ACommand
   */
  public void validate(AssignTbToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(), "AssignTbToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcIEEEAC6A
   *
   * @param command UnAssignTbFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignTbFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignTbFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcIEEEAC6A
   *
   * @param command AssignTcToExcIEEEAC6ACommand
   */
  public void validate(AssignTcToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(), "AssignTcToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcIEEEAC6A
   *
   * @param command UnAssignTcFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignTcFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignTcFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcIEEEAC6A
   *
   * @param command AssignTeToExcIEEEAC6ACommand
   */
  public void validate(AssignTeToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(), "AssignTeToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcIEEEAC6A
   *
   * @param command UnAssignTeFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignTeFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignTeFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Th validation for a ExcIEEEAC6A
   *
   * @param command AssignThToExcIEEEAC6ACommand
   */
  public void validate(AssignThToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignThToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(), "AssignThToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignThToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Th validation for a ExcIEEEAC6A
   *
   * @param command UnAssignThFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignThFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignThFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignThFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Tj validation for a ExcIEEEAC6A
   *
   * @param command AssignTjToExcIEEEAC6ACommand
   */
  public void validate(AssignTjToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignTjToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(), "AssignTjToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTjToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Tj validation for a ExcIEEEAC6A
   *
   * @param command UnAssignTjFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignTjFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTjFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignTjFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Tk validation for a ExcIEEEAC6A
   *
   * @param command AssignTkToExcIEEEAC6ACommand
   */
  public void validate(AssignTkToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignTkToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(), "AssignTkToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTkToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Tk validation for a ExcIEEEAC6A
   *
   * @param command UnAssignTkFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignTkFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTkFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignTkFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Vamax validation for a ExcIEEEAC6A
   *
   * @param command AssignVamaxToExcIEEEAC6ACommand
   */
  public void validate(AssignVamaxToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVamaxToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "AssignVamaxToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVamaxToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamax validation for a ExcIEEEAC6A
   *
   * @param command UnAssignVamaxFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignVamaxFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVamaxFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignVamaxFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Vamin validation for a ExcIEEEAC6A
   *
   * @param command AssignVaminToExcIEEEAC6ACommand
   */
  public void validate(AssignVaminToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVaminToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "AssignVaminToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVaminToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamin validation for a ExcIEEEAC6A
   *
   * @param command UnAssignVaminFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignVaminFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVaminFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignVaminFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Ve1 validation for a ExcIEEEAC6A
   *
   * @param command AssignVe1ToExcIEEEAC6ACommand
   */
  public void validate(AssignVe1ToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe1ToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(), "AssignVe1ToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe1ToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve1 validation for a ExcIEEEAC6A
   *
   * @param command UnAssignVe1FromExcIEEEAC6ACommand
   */
  public void validate(UnAssignVe1FromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe1FromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignVe1FromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Ve2 validation for a ExcIEEEAC6A
   *
   * @param command AssignVe2ToExcIEEEAC6ACommand
   */
  public void validate(AssignVe2ToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe2ToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(), "AssignVe2ToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe2ToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve2 validation for a ExcIEEEAC6A
   *
   * @param command UnAssignVe2FromExcIEEEAC6ACommand
   */
  public void validate(UnAssignVe2FromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe2FromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignVe2FromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Vfelim validation for a ExcIEEEAC6A
   *
   * @param command AssignVfelimToExcIEEEAC6ACommand
   */
  public void validate(AssignVfelimToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVfelimToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "AssignVfelimToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVfelimToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Vfelim validation for a ExcIEEEAC6A
   *
   * @param command UnAssignVfelimFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignVfelimFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVfelimFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignVfelimFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Vhmax validation for a ExcIEEEAC6A
   *
   * @param command AssignVhmaxToExcIEEEAC6ACommand
   */
  public void validate(AssignVhmaxToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVhmaxToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "AssignVhmaxToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVhmaxToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Vhmax validation for a ExcIEEEAC6A
   *
   * @param command UnAssignVhmaxFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignVhmaxFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVhmaxFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignVhmaxFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEAC6A
   *
   * @param command AssignVrmaxToExcIEEEAC6ACommand
   */
  public void validate(AssignVrmaxToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "AssignVrmaxToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEAC6A
   *
   * @param command UnAssignVrmaxFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignVrmaxFromExcIEEEAC6ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEAC6A
   *
   * @param command AssignVrminToExcIEEEAC6ACommand
   */
  public void validate(AssignVrminToExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "AssignVrminToExcIEEEAC6ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEAC6ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEAC6A
   *
   * @param command UnAssignVrminFromExcIEEEAC6ACommand
   */
  public void validate(UnAssignVrminFromExcIEEEAC6ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEAC6ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC6AId(),
        "UnAssignVrminFromExcIEEEAC6ACommand identifier should not be null");
  }
}
