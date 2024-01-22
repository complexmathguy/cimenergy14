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

public class ExcIEEEAC2AValidator {

  /** default constructor */
  protected ExcIEEEAC2AValidator() {}

  /** factory method */
  public static ExcIEEEAC2AValidator getInstance() {
    return new ExcIEEEAC2AValidator();
  }

  /** handles creation validation for a ExcIEEEAC2A */
  public void validate(CreateExcIEEEAC2ACommand excIEEEAC2A) throws Exception {
    Assert.notNull(excIEEEAC2A, "CreateExcIEEEAC2ACommand should not be null");
    //		Assert.isNull( excIEEEAC2A.getExcIEEEAC2AId(), "CreateExcIEEEAC2ACommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEAC2A */
  public void validate(UpdateExcIEEEAC2ACommand excIEEEAC2A) throws Exception {
    Assert.notNull(excIEEEAC2A, "UpdateExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        excIEEEAC2A.getExcIEEEAC2AId(), "UpdateExcIEEEAC2ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEAC2A */
  public void validate(DeleteExcIEEEAC2ACommand excIEEEAC2A) throws Exception {
    Assert.notNull(excIEEEAC2A, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEAC2A.getExcIEEEAC2AId(), "DeleteExcIEEEAC2ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEAC2A */
  public void validate(ExcIEEEAC2AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEAC2AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEAC2AId(), "ExcIEEEAC2AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ka validation for a ExcIEEEAC2A
   *
   * @param command AssignKaToExcIEEEAC2ACommand
   */
  public void validate(AssignKaToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(), "AssignKaToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcIEEEAC2A
   *
   * @param command UnAssignKaFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignKaFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignKaFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Kb validation for a ExcIEEEAC2A
   *
   * @param command AssignKbToExcIEEEAC2ACommand
   */
  public void validate(AssignKbToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKbToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(), "AssignKbToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKbToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kb validation for a ExcIEEEAC2A
   *
   * @param command UnAssignKbFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignKbFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKbFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignKbFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcIEEEAC2A
   *
   * @param command AssignKcToExcIEEEAC2ACommand
   */
  public void validate(AssignKcToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(), "AssignKcToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcIEEEAC2A
   *
   * @param command UnAssignKcFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignKcFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignKcFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a ExcIEEEAC2A
   *
   * @param command AssignKdToExcIEEEAC2ACommand
   */
  public void validate(AssignKdToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKdToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(), "AssignKdToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a ExcIEEEAC2A
   *
   * @param command UnAssignKdFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignKdFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignKdFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcIEEEAC2A
   *
   * @param command AssignKeToExcIEEEAC2ACommand
   */
  public void validate(AssignKeToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(), "AssignKeToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcIEEEAC2A
   *
   * @param command UnAssignKeFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignKeFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignKeFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcIEEEAC2A
   *
   * @param command AssignKfToExcIEEEAC2ACommand
   */
  public void validate(AssignKfToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(), "AssignKfToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcIEEEAC2A
   *
   * @param command UnAssignKfFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignKfFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignKfFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Kh validation for a ExcIEEEAC2A
   *
   * @param command AssignKhToExcIEEEAC2ACommand
   */
  public void validate(AssignKhToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKhToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(), "AssignKhToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKhToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kh validation for a ExcIEEEAC2A
   *
   * @param command UnAssignKhFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignKhFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKhFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignKhFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Seve1 validation for a ExcIEEEAC2A
   *
   * @param command AssignSeve1ToExcIEEEAC2ACommand
   */
  public void validate(AssignSeve1ToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve1ToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "AssignSeve1ToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve1ToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve1 validation for a ExcIEEEAC2A
   *
   * @param command UnAssignSeve1FromExcIEEEAC2ACommand
   */
  public void validate(UnAssignSeve1FromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve1FromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignSeve1FromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Seve2 validation for a ExcIEEEAC2A
   *
   * @param command AssignSeve2ToExcIEEEAC2ACommand
   */
  public void validate(AssignSeve2ToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve2ToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "AssignSeve2ToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve2ToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve2 validation for a ExcIEEEAC2A
   *
   * @param command UnAssignSeve2FromExcIEEEAC2ACommand
   */
  public void validate(UnAssignSeve2FromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve2FromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignSeve2FromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcIEEEAC2A
   *
   * @param command AssignTaToExcIEEEAC2ACommand
   */
  public void validate(AssignTaToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(), "AssignTaToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcIEEEAC2A
   *
   * @param command UnAssignTaFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignTaFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignTaFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcIEEEAC2A
   *
   * @param command AssignTbToExcIEEEAC2ACommand
   */
  public void validate(AssignTbToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(), "AssignTbToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcIEEEAC2A
   *
   * @param command UnAssignTbFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignTbFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignTbFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcIEEEAC2A
   *
   * @param command AssignTcToExcIEEEAC2ACommand
   */
  public void validate(AssignTcToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(), "AssignTcToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcIEEEAC2A
   *
   * @param command UnAssignTcFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignTcFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignTcFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcIEEEAC2A
   *
   * @param command AssignTeToExcIEEEAC2ACommand
   */
  public void validate(AssignTeToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(), "AssignTeToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcIEEEAC2A
   *
   * @param command UnAssignTeFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignTeFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignTeFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcIEEEAC2A
   *
   * @param command AssignTfToExcIEEEAC2ACommand
   */
  public void validate(AssignTfToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(), "AssignTfToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcIEEEAC2A
   *
   * @param command UnAssignTfFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignTfFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignTfFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vamax validation for a ExcIEEEAC2A
   *
   * @param command AssignVamaxToExcIEEEAC2ACommand
   */
  public void validate(AssignVamaxToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVamaxToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "AssignVamaxToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVamaxToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamax validation for a ExcIEEEAC2A
   *
   * @param command UnAssignVamaxFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignVamaxFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVamaxFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignVamaxFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vamin validation for a ExcIEEEAC2A
   *
   * @param command AssignVaminToExcIEEEAC2ACommand
   */
  public void validate(AssignVaminToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVaminToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "AssignVaminToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVaminToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamin validation for a ExcIEEEAC2A
   *
   * @param command UnAssignVaminFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignVaminFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVaminFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignVaminFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ve1 validation for a ExcIEEEAC2A
   *
   * @param command AssignVe1ToExcIEEEAC2ACommand
   */
  public void validate(AssignVe1ToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe1ToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(), "AssignVe1ToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe1ToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve1 validation for a ExcIEEEAC2A
   *
   * @param command UnAssignVe1FromExcIEEEAC2ACommand
   */
  public void validate(UnAssignVe1FromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe1FromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignVe1FromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Ve2 validation for a ExcIEEEAC2A
   *
   * @param command AssignVe2ToExcIEEEAC2ACommand
   */
  public void validate(AssignVe2ToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe2ToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(), "AssignVe2ToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe2ToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve2 validation for a ExcIEEEAC2A
   *
   * @param command UnAssignVe2FromExcIEEEAC2ACommand
   */
  public void validate(UnAssignVe2FromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe2FromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignVe2FromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vfemax validation for a ExcIEEEAC2A
   *
   * @param command AssignVfemaxToExcIEEEAC2ACommand
   */
  public void validate(AssignVfemaxToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVfemaxToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "AssignVfemaxToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVfemaxToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vfemax validation for a ExcIEEEAC2A
   *
   * @param command UnAssignVfemaxFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignVfemaxFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVfemaxFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignVfemaxFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEAC2A
   *
   * @param command AssignVrmaxToExcIEEEAC2ACommand
   */
  public void validate(AssignVrmaxToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "AssignVrmaxToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEAC2A
   *
   * @param command UnAssignVrmaxFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignVrmaxFromExcIEEEAC2ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEAC2A
   *
   * @param command AssignVrminToExcIEEEAC2ACommand
   */
  public void validate(AssignVrminToExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "AssignVrminToExcIEEEAC2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEAC2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEAC2A
   *
   * @param command UnAssignVrminFromExcIEEEAC2ACommand
   */
  public void validate(UnAssignVrminFromExcIEEEAC2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEAC2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC2AId(),
        "UnAssignVrminFromExcIEEEAC2ACommand identifier should not be null");
  }
}
