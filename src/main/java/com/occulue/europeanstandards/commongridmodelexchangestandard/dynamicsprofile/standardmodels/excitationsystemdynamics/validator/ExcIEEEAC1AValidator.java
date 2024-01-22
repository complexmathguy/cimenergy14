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

public class ExcIEEEAC1AValidator {

  /** default constructor */
  protected ExcIEEEAC1AValidator() {}

  /** factory method */
  public static ExcIEEEAC1AValidator getInstance() {
    return new ExcIEEEAC1AValidator();
  }

  /** handles creation validation for a ExcIEEEAC1A */
  public void validate(CreateExcIEEEAC1ACommand excIEEEAC1A) throws Exception {
    Assert.notNull(excIEEEAC1A, "CreateExcIEEEAC1ACommand should not be null");
    //		Assert.isNull( excIEEEAC1A.getExcIEEEAC1AId(), "CreateExcIEEEAC1ACommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEAC1A */
  public void validate(UpdateExcIEEEAC1ACommand excIEEEAC1A) throws Exception {
    Assert.notNull(excIEEEAC1A, "UpdateExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        excIEEEAC1A.getExcIEEEAC1AId(), "UpdateExcIEEEAC1ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEAC1A */
  public void validate(DeleteExcIEEEAC1ACommand excIEEEAC1A) throws Exception {
    Assert.notNull(excIEEEAC1A, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEAC1A.getExcIEEEAC1AId(), "DeleteExcIEEEAC1ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEAC1A */
  public void validate(ExcIEEEAC1AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEAC1AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEAC1AId(), "ExcIEEEAC1AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ka validation for a ExcIEEEAC1A
   *
   * @param command AssignKaToExcIEEEAC1ACommand
   */
  public void validate(AssignKaToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(), "AssignKaToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcIEEEAC1A
   *
   * @param command UnAssignKaFromExcIEEEAC1ACommand
   */
  public void validate(UnAssignKaFromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignKaFromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcIEEEAC1A
   *
   * @param command AssignKcToExcIEEEAC1ACommand
   */
  public void validate(AssignKcToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(), "AssignKcToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcIEEEAC1A
   *
   * @param command UnAssignKcFromExcIEEEAC1ACommand
   */
  public void validate(UnAssignKcFromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignKcFromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a ExcIEEEAC1A
   *
   * @param command AssignKdToExcIEEEAC1ACommand
   */
  public void validate(AssignKdToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKdToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(), "AssignKdToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a ExcIEEEAC1A
   *
   * @param command UnAssignKdFromExcIEEEAC1ACommand
   */
  public void validate(UnAssignKdFromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignKdFromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcIEEEAC1A
   *
   * @param command AssignKeToExcIEEEAC1ACommand
   */
  public void validate(AssignKeToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(), "AssignKeToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcIEEEAC1A
   *
   * @param command UnAssignKeFromExcIEEEAC1ACommand
   */
  public void validate(UnAssignKeFromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignKeFromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcIEEEAC1A
   *
   * @param command AssignKfToExcIEEEAC1ACommand
   */
  public void validate(AssignKfToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(), "AssignKfToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcIEEEAC1A
   *
   * @param command UnAssignKfFromExcIEEEAC1ACommand
   */
  public void validate(UnAssignKfFromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignKfFromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Seve1 validation for a ExcIEEEAC1A
   *
   * @param command AssignSeve1ToExcIEEEAC1ACommand
   */
  public void validate(AssignSeve1ToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve1ToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "AssignSeve1ToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve1ToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve1 validation for a ExcIEEEAC1A
   *
   * @param command UnAssignSeve1FromExcIEEEAC1ACommand
   */
  public void validate(UnAssignSeve1FromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve1FromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignSeve1FromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Seve2 validation for a ExcIEEEAC1A
   *
   * @param command AssignSeve2ToExcIEEEAC1ACommand
   */
  public void validate(AssignSeve2ToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve2ToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "AssignSeve2ToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve2ToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve2 validation for a ExcIEEEAC1A
   *
   * @param command UnAssignSeve2FromExcIEEEAC1ACommand
   */
  public void validate(UnAssignSeve2FromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve2FromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignSeve2FromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcIEEEAC1A
   *
   * @param command AssignTaToExcIEEEAC1ACommand
   */
  public void validate(AssignTaToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(), "AssignTaToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcIEEEAC1A
   *
   * @param command UnAssignTaFromExcIEEEAC1ACommand
   */
  public void validate(UnAssignTaFromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignTaFromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcIEEEAC1A
   *
   * @param command AssignTbToExcIEEEAC1ACommand
   */
  public void validate(AssignTbToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(), "AssignTbToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcIEEEAC1A
   *
   * @param command UnAssignTbFromExcIEEEAC1ACommand
   */
  public void validate(UnAssignTbFromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignTbFromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcIEEEAC1A
   *
   * @param command AssignTcToExcIEEEAC1ACommand
   */
  public void validate(AssignTcToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(), "AssignTcToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcIEEEAC1A
   *
   * @param command UnAssignTcFromExcIEEEAC1ACommand
   */
  public void validate(UnAssignTcFromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignTcFromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcIEEEAC1A
   *
   * @param command AssignTeToExcIEEEAC1ACommand
   */
  public void validate(AssignTeToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(), "AssignTeToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcIEEEAC1A
   *
   * @param command UnAssignTeFromExcIEEEAC1ACommand
   */
  public void validate(UnAssignTeFromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignTeFromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcIEEEAC1A
   *
   * @param command AssignTfToExcIEEEAC1ACommand
   */
  public void validate(AssignTfToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(), "AssignTfToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcIEEEAC1A
   *
   * @param command UnAssignTfFromExcIEEEAC1ACommand
   */
  public void validate(UnAssignTfFromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignTfFromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vamax validation for a ExcIEEEAC1A
   *
   * @param command AssignVamaxToExcIEEEAC1ACommand
   */
  public void validate(AssignVamaxToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVamaxToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "AssignVamaxToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVamaxToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamax validation for a ExcIEEEAC1A
   *
   * @param command UnAssignVamaxFromExcIEEEAC1ACommand
   */
  public void validate(UnAssignVamaxFromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVamaxFromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignVamaxFromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vamin validation for a ExcIEEEAC1A
   *
   * @param command AssignVaminToExcIEEEAC1ACommand
   */
  public void validate(AssignVaminToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVaminToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "AssignVaminToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVaminToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamin validation for a ExcIEEEAC1A
   *
   * @param command UnAssignVaminFromExcIEEEAC1ACommand
   */
  public void validate(UnAssignVaminFromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVaminFromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignVaminFromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ve1 validation for a ExcIEEEAC1A
   *
   * @param command AssignVe1ToExcIEEEAC1ACommand
   */
  public void validate(AssignVe1ToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe1ToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(), "AssignVe1ToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe1ToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve1 validation for a ExcIEEEAC1A
   *
   * @param command UnAssignVe1FromExcIEEEAC1ACommand
   */
  public void validate(UnAssignVe1FromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe1FromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignVe1FromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ve2 validation for a ExcIEEEAC1A
   *
   * @param command AssignVe2ToExcIEEEAC1ACommand
   */
  public void validate(AssignVe2ToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe2ToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(), "AssignVe2ToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe2ToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve2 validation for a ExcIEEEAC1A
   *
   * @param command UnAssignVe2FromExcIEEEAC1ACommand
   */
  public void validate(UnAssignVe2FromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe2FromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignVe2FromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEAC1A
   *
   * @param command AssignVrmaxToExcIEEEAC1ACommand
   */
  public void validate(AssignVrmaxToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "AssignVrmaxToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEAC1A
   *
   * @param command UnAssignVrmaxFromExcIEEEAC1ACommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignVrmaxFromExcIEEEAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEAC1A
   *
   * @param command AssignVrminToExcIEEEAC1ACommand
   */
  public void validate(AssignVrminToExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "AssignVrminToExcIEEEAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEAC1A
   *
   * @param command UnAssignVrminFromExcIEEEAC1ACommand
   */
  public void validate(UnAssignVrminFromExcIEEEAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEAC1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC1AId(),
        "UnAssignVrminFromExcIEEEAC1ACommand identifier should not be null");
  }
}
