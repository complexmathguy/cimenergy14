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

public class ExcIEEEAC3AValidator {

  /** default constructor */
  protected ExcIEEEAC3AValidator() {}

  /** factory method */
  public static ExcIEEEAC3AValidator getInstance() {
    return new ExcIEEEAC3AValidator();
  }

  /** handles creation validation for a ExcIEEEAC3A */
  public void validate(CreateExcIEEEAC3ACommand excIEEEAC3A) throws Exception {
    Assert.notNull(excIEEEAC3A, "CreateExcIEEEAC3ACommand should not be null");
    //		Assert.isNull( excIEEEAC3A.getExcIEEEAC3AId(), "CreateExcIEEEAC3ACommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEAC3A */
  public void validate(UpdateExcIEEEAC3ACommand excIEEEAC3A) throws Exception {
    Assert.notNull(excIEEEAC3A, "UpdateExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        excIEEEAC3A.getExcIEEEAC3AId(), "UpdateExcIEEEAC3ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEAC3A */
  public void validate(DeleteExcIEEEAC3ACommand excIEEEAC3A) throws Exception {
    Assert.notNull(excIEEEAC3A, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEAC3A.getExcIEEEAC3AId(), "DeleteExcIEEEAC3ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEAC3A */
  public void validate(ExcIEEEAC3AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEAC3AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEAC3AId(), "ExcIEEEAC3AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efdn validation for a ExcIEEEAC3A
   *
   * @param command AssignEfdnToExcIEEEAC3ACommand
   */
  public void validate(AssignEfdnToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfdnToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(), "AssignEfdnToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdnToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Efdn validation for a ExcIEEEAC3A
   *
   * @param command UnAssignEfdnFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignEfdnFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdnFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignEfdnFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcIEEEAC3A
   *
   * @param command AssignKaToExcIEEEAC3ACommand
   */
  public void validate(AssignKaToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(), "AssignKaToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcIEEEAC3A
   *
   * @param command UnAssignKaFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignKaFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignKaFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcIEEEAC3A
   *
   * @param command AssignKcToExcIEEEAC3ACommand
   */
  public void validate(AssignKcToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(), "AssignKcToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcIEEEAC3A
   *
   * @param command UnAssignKcFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignKcFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignKcFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a ExcIEEEAC3A
   *
   * @param command AssignKdToExcIEEEAC3ACommand
   */
  public void validate(AssignKdToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKdToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(), "AssignKdToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a ExcIEEEAC3A
   *
   * @param command UnAssignKdFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignKdFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignKdFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcIEEEAC3A
   *
   * @param command AssignKeToExcIEEEAC3ACommand
   */
  public void validate(AssignKeToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(), "AssignKeToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcIEEEAC3A
   *
   * @param command UnAssignKeFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignKeFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignKeFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcIEEEAC3A
   *
   * @param command AssignKfToExcIEEEAC3ACommand
   */
  public void validate(AssignKfToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(), "AssignKfToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcIEEEAC3A
   *
   * @param command UnAssignKfFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignKfFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignKfFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Kn validation for a ExcIEEEAC3A
   *
   * @param command AssignKnToExcIEEEAC3ACommand
   */
  public void validate(AssignKnToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKnToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(), "AssignKnToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKnToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kn validation for a ExcIEEEAC3A
   *
   * @param command UnAssignKnFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignKnFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKnFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignKnFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Kr validation for a ExcIEEEAC3A
   *
   * @param command AssignKrToExcIEEEAC3ACommand
   */
  public void validate(AssignKrToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKrToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(), "AssignKrToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKrToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kr validation for a ExcIEEEAC3A
   *
   * @param command UnAssignKrFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignKrFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKrFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignKrFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Seve1 validation for a ExcIEEEAC3A
   *
   * @param command AssignSeve1ToExcIEEEAC3ACommand
   */
  public void validate(AssignSeve1ToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve1ToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "AssignSeve1ToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve1ToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve1 validation for a ExcIEEEAC3A
   *
   * @param command UnAssignSeve1FromExcIEEEAC3ACommand
   */
  public void validate(UnAssignSeve1FromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve1FromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignSeve1FromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Seve2 validation for a ExcIEEEAC3A
   *
   * @param command AssignSeve2ToExcIEEEAC3ACommand
   */
  public void validate(AssignSeve2ToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve2ToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "AssignSeve2ToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve2ToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve2 validation for a ExcIEEEAC3A
   *
   * @param command UnAssignSeve2FromExcIEEEAC3ACommand
   */
  public void validate(UnAssignSeve2FromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve2FromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignSeve2FromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcIEEEAC3A
   *
   * @param command AssignTaToExcIEEEAC3ACommand
   */
  public void validate(AssignTaToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(), "AssignTaToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcIEEEAC3A
   *
   * @param command UnAssignTaFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignTaFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignTaFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcIEEEAC3A
   *
   * @param command AssignTbToExcIEEEAC3ACommand
   */
  public void validate(AssignTbToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(), "AssignTbToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcIEEEAC3A
   *
   * @param command UnAssignTbFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignTbFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignTbFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcIEEEAC3A
   *
   * @param command AssignTcToExcIEEEAC3ACommand
   */
  public void validate(AssignTcToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(), "AssignTcToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcIEEEAC3A
   *
   * @param command UnAssignTcFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignTcFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignTcFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcIEEEAC3A
   *
   * @param command AssignTeToExcIEEEAC3ACommand
   */
  public void validate(AssignTeToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(), "AssignTeToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcIEEEAC3A
   *
   * @param command UnAssignTeFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignTeFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignTeFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcIEEEAC3A
   *
   * @param command AssignTfToExcIEEEAC3ACommand
   */
  public void validate(AssignTfToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(), "AssignTfToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcIEEEAC3A
   *
   * @param command UnAssignTfFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignTfFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignTfFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Vamax validation for a ExcIEEEAC3A
   *
   * @param command AssignVamaxToExcIEEEAC3ACommand
   */
  public void validate(AssignVamaxToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVamaxToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "AssignVamaxToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVamaxToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamax validation for a ExcIEEEAC3A
   *
   * @param command UnAssignVamaxFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignVamaxFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVamaxFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignVamaxFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Vamin validation for a ExcIEEEAC3A
   *
   * @param command AssignVaminToExcIEEEAC3ACommand
   */
  public void validate(AssignVaminToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVaminToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "AssignVaminToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVaminToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamin validation for a ExcIEEEAC3A
   *
   * @param command UnAssignVaminFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignVaminFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVaminFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignVaminFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Ve1 validation for a ExcIEEEAC3A
   *
   * @param command AssignVe1ToExcIEEEAC3ACommand
   */
  public void validate(AssignVe1ToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe1ToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(), "AssignVe1ToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe1ToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve1 validation for a ExcIEEEAC3A
   *
   * @param command UnAssignVe1FromExcIEEEAC3ACommand
   */
  public void validate(UnAssignVe1FromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe1FromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignVe1FromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Ve2 validation for a ExcIEEEAC3A
   *
   * @param command AssignVe2ToExcIEEEAC3ACommand
   */
  public void validate(AssignVe2ToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe2ToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(), "AssignVe2ToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe2ToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve2 validation for a ExcIEEEAC3A
   *
   * @param command UnAssignVe2FromExcIEEEAC3ACommand
   */
  public void validate(UnAssignVe2FromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe2FromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignVe2FromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Vemin validation for a ExcIEEEAC3A
   *
   * @param command AssignVeminToExcIEEEAC3ACommand
   */
  public void validate(AssignVeminToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVeminToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "AssignVeminToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVeminToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vemin validation for a ExcIEEEAC3A
   *
   * @param command UnAssignVeminFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignVeminFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVeminFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignVeminFromExcIEEEAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Vfemax validation for a ExcIEEEAC3A
   *
   * @param command AssignVfemaxToExcIEEEAC3ACommand
   */
  public void validate(AssignVfemaxToExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVfemaxToExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "AssignVfemaxToExcIEEEAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVfemaxToExcIEEEAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vfemax validation for a ExcIEEEAC3A
   *
   * @param command UnAssignVfemaxFromExcIEEEAC3ACommand
   */
  public void validate(UnAssignVfemaxFromExcIEEEAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVfemaxFromExcIEEEAC3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC3AId(),
        "UnAssignVfemaxFromExcIEEEAC3ACommand identifier should not be null");
  }
}
