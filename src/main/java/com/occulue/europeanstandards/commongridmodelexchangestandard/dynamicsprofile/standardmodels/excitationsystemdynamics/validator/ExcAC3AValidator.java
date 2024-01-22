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

public class ExcAC3AValidator {

  /** default constructor */
  protected ExcAC3AValidator() {}

  /** factory method */
  public static ExcAC3AValidator getInstance() {
    return new ExcAC3AValidator();
  }

  /** handles creation validation for a ExcAC3A */
  public void validate(CreateExcAC3ACommand excAC3A) throws Exception {
    Assert.notNull(excAC3A, "CreateExcAC3ACommand should not be null");
    //		Assert.isNull( excAC3A.getExcAC3AId(), "CreateExcAC3ACommand identifier should be null" );
  }

  /** handles update validation for a ExcAC3A */
  public void validate(UpdateExcAC3ACommand excAC3A) throws Exception {
    Assert.notNull(excAC3A, "UpdateExcAC3ACommand should not be null");
    Assert.notNull(excAC3A.getExcAC3AId(), "UpdateExcAC3ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcAC3A */
  public void validate(DeleteExcAC3ACommand excAC3A) throws Exception {
    Assert.notNull(excAC3A, "{commandAlias} should not be null");
    Assert.notNull(excAC3A.getExcAC3AId(), "DeleteExcAC3ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcAC3A */
  public void validate(ExcAC3AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcAC3AFetchOneSummary should not be null");
    Assert.notNull(summary.getExcAC3AId(), "ExcAC3AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efdn validation for a ExcAC3A
   *
   * @param command AssignEfdnToExcAC3ACommand
   */
  public void validate(AssignEfdnToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfdnToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignEfdnToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdnToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Efdn validation for a ExcAC3A
   *
   * @param command UnAssignEfdnFromExcAC3ACommand
   */
  public void validate(UnAssignEfdnFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdnFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignEfdnFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcAC3A
   *
   * @param command AssignKaToExcAC3ACommand
   */
  public void validate(AssignKaToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignKaToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcAC3A
   *
   * @param command UnAssignKaFromExcAC3ACommand
   */
  public void validate(UnAssignKaFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignKaFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcAC3A
   *
   * @param command AssignKcToExcAC3ACommand
   */
  public void validate(AssignKcToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignKcToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcAC3A
   *
   * @param command UnAssignKcFromExcAC3ACommand
   */
  public void validate(UnAssignKcFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignKcFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a ExcAC3A
   *
   * @param command AssignKdToExcAC3ACommand
   */
  public void validate(AssignKdToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKdToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignKdToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a ExcAC3A
   *
   * @param command UnAssignKdFromExcAC3ACommand
   */
  public void validate(UnAssignKdFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignKdFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcAC3A
   *
   * @param command AssignKeToExcAC3ACommand
   */
  public void validate(AssignKeToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignKeToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcAC3A
   *
   * @param command UnAssignKeFromExcAC3ACommand
   */
  public void validate(UnAssignKeFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignKeFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcAC3A
   *
   * @param command AssignKfToExcAC3ACommand
   */
  public void validate(AssignKfToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignKfToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcAC3A
   *
   * @param command UnAssignKfFromExcAC3ACommand
   */
  public void validate(UnAssignKfFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignKfFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Kf1 validation for a ExcAC3A
   *
   * @param command AssignKf1ToExcAC3ACommand
   */
  public void validate(AssignKf1ToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKf1ToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignKf1ToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKf1ToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf1 validation for a ExcAC3A
   *
   * @param command UnAssignKf1FromExcAC3ACommand
   */
  public void validate(UnAssignKf1FromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKf1FromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignKf1FromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Kf2 validation for a ExcAC3A
   *
   * @param command AssignKf2ToExcAC3ACommand
   */
  public void validate(AssignKf2ToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKf2ToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignKf2ToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKf2ToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf2 validation for a ExcAC3A
   *
   * @param command UnAssignKf2FromExcAC3ACommand
   */
  public void validate(UnAssignKf2FromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKf2FromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignKf2FromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Klv validation for a ExcAC3A
   *
   * @param command AssignKlvToExcAC3ACommand
   */
  public void validate(AssignKlvToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKlvToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignKlvToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKlvToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Klv validation for a ExcAC3A
   *
   * @param command UnAssignKlvFromExcAC3ACommand
   */
  public void validate(UnAssignKlvFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKlvFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignKlvFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Kn validation for a ExcAC3A
   *
   * @param command AssignKnToExcAC3ACommand
   */
  public void validate(AssignKnToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKnToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignKnToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKnToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kn validation for a ExcAC3A
   *
   * @param command UnAssignKnFromExcAC3ACommand
   */
  public void validate(UnAssignKnFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKnFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignKnFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Kr validation for a ExcAC3A
   *
   * @param command AssignKrToExcAC3ACommand
   */
  public void validate(AssignKrToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKrToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignKrToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKrToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kr validation for a ExcAC3A
   *
   * @param command UnAssignKrFromExcAC3ACommand
   */
  public void validate(UnAssignKrFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKrFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignKrFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Ks validation for a ExcAC3A
   *
   * @param command AssignKsToExcAC3ACommand
   */
  public void validate(AssignKsToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKsToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignKsToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKsToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ks validation for a ExcAC3A
   *
   * @param command UnAssignKsFromExcAC3ACommand
   */
  public void validate(UnAssignKsFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKsFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignKsFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Seve1 validation for a ExcAC3A
   *
   * @param command AssignSeve1ToExcAC3ACommand
   */
  public void validate(AssignSeve1ToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve1ToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignSeve1ToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve1ToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve1 validation for a ExcAC3A
   *
   * @param command UnAssignSeve1FromExcAC3ACommand
   */
  public void validate(UnAssignSeve1FromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve1FromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignSeve1FromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Seve2 validation for a ExcAC3A
   *
   * @param command AssignSeve2ToExcAC3ACommand
   */
  public void validate(AssignSeve2ToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve2ToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignSeve2ToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve2ToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve2 validation for a ExcAC3A
   *
   * @param command UnAssignSeve2FromExcAC3ACommand
   */
  public void validate(UnAssignSeve2FromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve2FromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignSeve2FromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcAC3A
   *
   * @param command AssignTaToExcAC3ACommand
   */
  public void validate(AssignTaToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignTaToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcAC3A
   *
   * @param command UnAssignTaFromExcAC3ACommand
   */
  public void validate(UnAssignTaFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignTaFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcAC3A
   *
   * @param command AssignTbToExcAC3ACommand
   */
  public void validate(AssignTbToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignTbToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcAC3A
   *
   * @param command UnAssignTbFromExcAC3ACommand
   */
  public void validate(UnAssignTbFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignTbFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcAC3A
   *
   * @param command AssignTcToExcAC3ACommand
   */
  public void validate(AssignTcToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignTcToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcAC3A
   *
   * @param command UnAssignTcFromExcAC3ACommand
   */
  public void validate(UnAssignTcFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignTcFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcAC3A
   *
   * @param command AssignTeToExcAC3ACommand
   */
  public void validate(AssignTeToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignTeToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcAC3A
   *
   * @param command UnAssignTeFromExcAC3ACommand
   */
  public void validate(UnAssignTeFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignTeFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcAC3A
   *
   * @param command AssignTfToExcAC3ACommand
   */
  public void validate(AssignTfToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignTfToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcAC3A
   *
   * @param command UnAssignTfFromExcAC3ACommand
   */
  public void validate(UnAssignTfFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignTfFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Vamax validation for a ExcAC3A
   *
   * @param command AssignVamaxToExcAC3ACommand
   */
  public void validate(AssignVamaxToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVamaxToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignVamaxToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVamaxToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamax validation for a ExcAC3A
   *
   * @param command UnAssignVamaxFromExcAC3ACommand
   */
  public void validate(UnAssignVamaxFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVamaxFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignVamaxFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Vamin validation for a ExcAC3A
   *
   * @param command AssignVaminToExcAC3ACommand
   */
  public void validate(AssignVaminToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVaminToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignVaminToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVaminToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamin validation for a ExcAC3A
   *
   * @param command UnAssignVaminFromExcAC3ACommand
   */
  public void validate(UnAssignVaminFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVaminFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignVaminFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Ve1 validation for a ExcAC3A
   *
   * @param command AssignVe1ToExcAC3ACommand
   */
  public void validate(AssignVe1ToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe1ToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignVe1ToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe1ToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve1 validation for a ExcAC3A
   *
   * @param command UnAssignVe1FromExcAC3ACommand
   */
  public void validate(UnAssignVe1FromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe1FromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignVe1FromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Ve2 validation for a ExcAC3A
   *
   * @param command AssignVe2ToExcAC3ACommand
   */
  public void validate(AssignVe2ToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe2ToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignVe2ToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe2ToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve2 validation for a ExcAC3A
   *
   * @param command UnAssignVe2FromExcAC3ACommand
   */
  public void validate(UnAssignVe2FromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe2FromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignVe2FromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Vemin validation for a ExcAC3A
   *
   * @param command AssignVeminToExcAC3ACommand
   */
  public void validate(AssignVeminToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVeminToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignVeminToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVeminToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vemin validation for a ExcAC3A
   *
   * @param command UnAssignVeminFromExcAC3ACommand
   */
  public void validate(UnAssignVeminFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVeminFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignVeminFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Vfemax validation for a ExcAC3A
   *
   * @param command AssignVfemaxToExcAC3ACommand
   */
  public void validate(AssignVfemaxToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVfemaxToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignVfemaxToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVfemaxToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vfemax validation for a ExcAC3A
   *
   * @param command UnAssignVfemaxFromExcAC3ACommand
   */
  public void validate(UnAssignVfemaxFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVfemaxFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignVfemaxFromExcAC3ACommand identifier should not be null");
  }
  /**
   * handles assign Vlv validation for a ExcAC3A
   *
   * @param command AssignVlvToExcAC3ACommand
   */
  public void validate(AssignVlvToExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVlvToExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "AssignVlvToExcAC3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVlvToExcAC3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vlv validation for a ExcAC3A
   *
   * @param command UnAssignVlvFromExcAC3ACommand
   */
  public void validate(UnAssignVlvFromExcAC3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVlvFromExcAC3ACommand should not be null");
    Assert.notNull(
        command.getExcAC3AId(), "UnAssignVlvFromExcAC3ACommand identifier should not be null");
  }
}
