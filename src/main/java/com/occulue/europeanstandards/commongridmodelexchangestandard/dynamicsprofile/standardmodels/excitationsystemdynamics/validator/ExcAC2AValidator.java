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

public class ExcAC2AValidator {

  /** default constructor */
  protected ExcAC2AValidator() {}

  /** factory method */
  public static ExcAC2AValidator getInstance() {
    return new ExcAC2AValidator();
  }

  /** handles creation validation for a ExcAC2A */
  public void validate(CreateExcAC2ACommand excAC2A) throws Exception {
    Assert.notNull(excAC2A, "CreateExcAC2ACommand should not be null");
    //		Assert.isNull( excAC2A.getExcAC2AId(), "CreateExcAC2ACommand identifier should be null" );
  }

  /** handles update validation for a ExcAC2A */
  public void validate(UpdateExcAC2ACommand excAC2A) throws Exception {
    Assert.notNull(excAC2A, "UpdateExcAC2ACommand should not be null");
    Assert.notNull(excAC2A.getExcAC2AId(), "UpdateExcAC2ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcAC2A */
  public void validate(DeleteExcAC2ACommand excAC2A) throws Exception {
    Assert.notNull(excAC2A, "{commandAlias} should not be null");
    Assert.notNull(excAC2A.getExcAC2AId(), "DeleteExcAC2ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcAC2A */
  public void validate(ExcAC2AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcAC2AFetchOneSummary should not be null");
    Assert.notNull(summary.getExcAC2AId(), "ExcAC2AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Hvgate validation for a ExcAC2A
   *
   * @param command AssignHvgateToExcAC2ACommand
   */
  public void validate(AssignHvgateToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignHvgateToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignHvgateToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignHvgateToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Hvgate validation for a ExcAC2A
   *
   * @param command UnAssignHvgateFromExcAC2ACommand
   */
  public void validate(UnAssignHvgateFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignHvgateFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignHvgateFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcAC2A
   *
   * @param command AssignKaToExcAC2ACommand
   */
  public void validate(AssignKaToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignKaToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcAC2A
   *
   * @param command UnAssignKaFromExcAC2ACommand
   */
  public void validate(UnAssignKaFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignKaFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Kb validation for a ExcAC2A
   *
   * @param command AssignKbToExcAC2ACommand
   */
  public void validate(AssignKbToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKbToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignKbToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKbToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kb validation for a ExcAC2A
   *
   * @param command UnAssignKbFromExcAC2ACommand
   */
  public void validate(UnAssignKbFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKbFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignKbFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Kb1 validation for a ExcAC2A
   *
   * @param command AssignKb1ToExcAC2ACommand
   */
  public void validate(AssignKb1ToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKb1ToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignKb1ToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKb1ToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kb1 validation for a ExcAC2A
   *
   * @param command UnAssignKb1FromExcAC2ACommand
   */
  public void validate(UnAssignKb1FromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKb1FromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignKb1FromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcAC2A
   *
   * @param command AssignKcToExcAC2ACommand
   */
  public void validate(AssignKcToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignKcToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcAC2A
   *
   * @param command UnAssignKcFromExcAC2ACommand
   */
  public void validate(UnAssignKcFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignKcFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a ExcAC2A
   *
   * @param command AssignKdToExcAC2ACommand
   */
  public void validate(AssignKdToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKdToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignKdToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a ExcAC2A
   *
   * @param command UnAssignKdFromExcAC2ACommand
   */
  public void validate(UnAssignKdFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignKdFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcAC2A
   *
   * @param command AssignKeToExcAC2ACommand
   */
  public void validate(AssignKeToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignKeToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcAC2A
   *
   * @param command UnAssignKeFromExcAC2ACommand
   */
  public void validate(UnAssignKeFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignKeFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcAC2A
   *
   * @param command AssignKfToExcAC2ACommand
   */
  public void validate(AssignKfToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignKfToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcAC2A
   *
   * @param command UnAssignKfFromExcAC2ACommand
   */
  public void validate(UnAssignKfFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignKfFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Kh validation for a ExcAC2A
   *
   * @param command AssignKhToExcAC2ACommand
   */
  public void validate(AssignKhToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKhToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignKhToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKhToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kh validation for a ExcAC2A
   *
   * @param command UnAssignKhFromExcAC2ACommand
   */
  public void validate(UnAssignKhFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKhFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignKhFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Kl validation for a ExcAC2A
   *
   * @param command AssignKlToExcAC2ACommand
   */
  public void validate(AssignKlToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKlToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignKlToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKlToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kl validation for a ExcAC2A
   *
   * @param command UnAssignKlFromExcAC2ACommand
   */
  public void validate(UnAssignKlFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKlFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignKlFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Kl1 validation for a ExcAC2A
   *
   * @param command AssignKl1ToExcAC2ACommand
   */
  public void validate(AssignKl1ToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKl1ToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignKl1ToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKl1ToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kl1 validation for a ExcAC2A
   *
   * @param command UnAssignKl1FromExcAC2ACommand
   */
  public void validate(UnAssignKl1FromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKl1FromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignKl1FromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ks validation for a ExcAC2A
   *
   * @param command AssignKsToExcAC2ACommand
   */
  public void validate(AssignKsToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKsToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignKsToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKsToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ks validation for a ExcAC2A
   *
   * @param command UnAssignKsFromExcAC2ACommand
   */
  public void validate(UnAssignKsFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKsFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignKsFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Lvgate validation for a ExcAC2A
   *
   * @param command AssignLvgateToExcAC2ACommand
   */
  public void validate(AssignLvgateToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignLvgateToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignLvgateToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLvgateToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Lvgate validation for a ExcAC2A
   *
   * @param command UnAssignLvgateFromExcAC2ACommand
   */
  public void validate(UnAssignLvgateFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignLvgateFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignLvgateFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Seve1 validation for a ExcAC2A
   *
   * @param command AssignSeve1ToExcAC2ACommand
   */
  public void validate(AssignSeve1ToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve1ToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignSeve1ToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve1ToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve1 validation for a ExcAC2A
   *
   * @param command UnAssignSeve1FromExcAC2ACommand
   */
  public void validate(UnAssignSeve1FromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve1FromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignSeve1FromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Seve2 validation for a ExcAC2A
   *
   * @param command AssignSeve2ToExcAC2ACommand
   */
  public void validate(AssignSeve2ToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve2ToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignSeve2ToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve2ToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve2 validation for a ExcAC2A
   *
   * @param command UnAssignSeve2FromExcAC2ACommand
   */
  public void validate(UnAssignSeve2FromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve2FromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignSeve2FromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcAC2A
   *
   * @param command AssignTaToExcAC2ACommand
   */
  public void validate(AssignTaToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignTaToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcAC2A
   *
   * @param command UnAssignTaFromExcAC2ACommand
   */
  public void validate(UnAssignTaFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignTaFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcAC2A
   *
   * @param command AssignTbToExcAC2ACommand
   */
  public void validate(AssignTbToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignTbToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcAC2A
   *
   * @param command UnAssignTbFromExcAC2ACommand
   */
  public void validate(UnAssignTbFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignTbFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcAC2A
   *
   * @param command AssignTcToExcAC2ACommand
   */
  public void validate(AssignTcToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignTcToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcAC2A
   *
   * @param command UnAssignTcFromExcAC2ACommand
   */
  public void validate(UnAssignTcFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignTcFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcAC2A
   *
   * @param command AssignTeToExcAC2ACommand
   */
  public void validate(AssignTeToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignTeToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcAC2A
   *
   * @param command UnAssignTeFromExcAC2ACommand
   */
  public void validate(UnAssignTeFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignTeFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcAC2A
   *
   * @param command AssignTfToExcAC2ACommand
   */
  public void validate(AssignTfToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignTfToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcAC2A
   *
   * @param command UnAssignTfFromExcAC2ACommand
   */
  public void validate(UnAssignTfFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignTfFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vamax validation for a ExcAC2A
   *
   * @param command AssignVamaxToExcAC2ACommand
   */
  public void validate(AssignVamaxToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVamaxToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignVamaxToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVamaxToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamax validation for a ExcAC2A
   *
   * @param command UnAssignVamaxFromExcAC2ACommand
   */
  public void validate(UnAssignVamaxFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVamaxFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignVamaxFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vamin validation for a ExcAC2A
   *
   * @param command AssignVaminToExcAC2ACommand
   */
  public void validate(AssignVaminToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVaminToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignVaminToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVaminToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamin validation for a ExcAC2A
   *
   * @param command UnAssignVaminFromExcAC2ACommand
   */
  public void validate(UnAssignVaminFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVaminFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignVaminFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ve1 validation for a ExcAC2A
   *
   * @param command AssignVe1ToExcAC2ACommand
   */
  public void validate(AssignVe1ToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe1ToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignVe1ToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe1ToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve1 validation for a ExcAC2A
   *
   * @param command UnAssignVe1FromExcAC2ACommand
   */
  public void validate(UnAssignVe1FromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe1FromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignVe1FromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ve2 validation for a ExcAC2A
   *
   * @param command AssignVe2ToExcAC2ACommand
   */
  public void validate(AssignVe2ToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe2ToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignVe2ToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe2ToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve2 validation for a ExcAC2A
   *
   * @param command UnAssignVe2FromExcAC2ACommand
   */
  public void validate(UnAssignVe2FromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe2FromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignVe2FromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vfemax validation for a ExcAC2A
   *
   * @param command AssignVfemaxToExcAC2ACommand
   */
  public void validate(AssignVfemaxToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVfemaxToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignVfemaxToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVfemaxToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vfemax validation for a ExcAC2A
   *
   * @param command UnAssignVfemaxFromExcAC2ACommand
   */
  public void validate(UnAssignVfemaxFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVfemaxFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignVfemaxFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vlr validation for a ExcAC2A
   *
   * @param command AssignVlrToExcAC2ACommand
   */
  public void validate(AssignVlrToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVlrToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignVlrToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVlrToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vlr validation for a ExcAC2A
   *
   * @param command UnAssignVlrFromExcAC2ACommand
   */
  public void validate(UnAssignVlrFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVlrFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignVlrFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcAC2A
   *
   * @param command AssignVrmaxToExcAC2ACommand
   */
  public void validate(AssignVrmaxToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignVrmaxToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcAC2A
   *
   * @param command UnAssignVrmaxFromExcAC2ACommand
   */
  public void validate(UnAssignVrmaxFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignVrmaxFromExcAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcAC2A
   *
   * @param command AssignVrminToExcAC2ACommand
   */
  public void validate(AssignVrminToExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "AssignVrminToExcAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcAC2A
   *
   * @param command UnAssignVrminFromExcAC2ACommand
   */
  public void validate(UnAssignVrminFromExcAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcAC2ACommand should not be null");
    Assert.notNull(
        command.getExcAC2AId(), "UnAssignVrminFromExcAC2ACommand identifier should not be null");
  }
}
