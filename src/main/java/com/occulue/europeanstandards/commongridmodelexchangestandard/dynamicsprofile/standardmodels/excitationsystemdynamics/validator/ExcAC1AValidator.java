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

public class ExcAC1AValidator {

  /** default constructor */
  protected ExcAC1AValidator() {}

  /** factory method */
  public static ExcAC1AValidator getInstance() {
    return new ExcAC1AValidator();
  }

  /** handles creation validation for a ExcAC1A */
  public void validate(CreateExcAC1ACommand excAC1A) throws Exception {
    Assert.notNull(excAC1A, "CreateExcAC1ACommand should not be null");
    //		Assert.isNull( excAC1A.getExcAC1AId(), "CreateExcAC1ACommand identifier should be null" );
  }

  /** handles update validation for a ExcAC1A */
  public void validate(UpdateExcAC1ACommand excAC1A) throws Exception {
    Assert.notNull(excAC1A, "UpdateExcAC1ACommand should not be null");
    Assert.notNull(excAC1A.getExcAC1AId(), "UpdateExcAC1ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcAC1A */
  public void validate(DeleteExcAC1ACommand excAC1A) throws Exception {
    Assert.notNull(excAC1A, "{commandAlias} should not be null");
    Assert.notNull(excAC1A.getExcAC1AId(), "DeleteExcAC1ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcAC1A */
  public void validate(ExcAC1AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcAC1AFetchOneSummary should not be null");
    Assert.notNull(summary.getExcAC1AId(), "ExcAC1AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Hvlvgates validation for a ExcAC1A
   *
   * @param command AssignHvlvgatesToExcAC1ACommand
   */
  public void validate(AssignHvlvgatesToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignHvlvgatesToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignHvlvgatesToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignHvlvgatesToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Hvlvgates validation for a ExcAC1A
   *
   * @param command UnAssignHvlvgatesFromExcAC1ACommand
   */
  public void validate(UnAssignHvlvgatesFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignHvlvgatesFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(),
        "UnAssignHvlvgatesFromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcAC1A
   *
   * @param command AssignKaToExcAC1ACommand
   */
  public void validate(AssignKaToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignKaToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcAC1A
   *
   * @param command UnAssignKaFromExcAC1ACommand
   */
  public void validate(UnAssignKaFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignKaFromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcAC1A
   *
   * @param command AssignKcToExcAC1ACommand
   */
  public void validate(AssignKcToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignKcToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcAC1A
   *
   * @param command UnAssignKcFromExcAC1ACommand
   */
  public void validate(UnAssignKcFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignKcFromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a ExcAC1A
   *
   * @param command AssignKdToExcAC1ACommand
   */
  public void validate(AssignKdToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKdToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignKdToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a ExcAC1A
   *
   * @param command UnAssignKdFromExcAC1ACommand
   */
  public void validate(UnAssignKdFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignKdFromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcAC1A
   *
   * @param command AssignKeToExcAC1ACommand
   */
  public void validate(AssignKeToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignKeToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcAC1A
   *
   * @param command UnAssignKeFromExcAC1ACommand
   */
  public void validate(UnAssignKeFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignKeFromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcAC1A
   *
   * @param command AssignKfToExcAC1ACommand
   */
  public void validate(AssignKfToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignKfToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcAC1A
   *
   * @param command UnAssignKfFromExcAC1ACommand
   */
  public void validate(UnAssignKfFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignKfFromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Kf1 validation for a ExcAC1A
   *
   * @param command AssignKf1ToExcAC1ACommand
   */
  public void validate(AssignKf1ToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKf1ToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignKf1ToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKf1ToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf1 validation for a ExcAC1A
   *
   * @param command UnAssignKf1FromExcAC1ACommand
   */
  public void validate(UnAssignKf1FromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKf1FromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignKf1FromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Kf2 validation for a ExcAC1A
   *
   * @param command AssignKf2ToExcAC1ACommand
   */
  public void validate(AssignKf2ToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKf2ToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignKf2ToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKf2ToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf2 validation for a ExcAC1A
   *
   * @param command UnAssignKf2FromExcAC1ACommand
   */
  public void validate(UnAssignKf2FromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKf2FromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignKf2FromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ks validation for a ExcAC1A
   *
   * @param command AssignKsToExcAC1ACommand
   */
  public void validate(AssignKsToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKsToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignKsToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKsToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ks validation for a ExcAC1A
   *
   * @param command UnAssignKsFromExcAC1ACommand
   */
  public void validate(UnAssignKsFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKsFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignKsFromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Seve1 validation for a ExcAC1A
   *
   * @param command AssignSeve1ToExcAC1ACommand
   */
  public void validate(AssignSeve1ToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve1ToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignSeve1ToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve1ToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve1 validation for a ExcAC1A
   *
   * @param command UnAssignSeve1FromExcAC1ACommand
   */
  public void validate(UnAssignSeve1FromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve1FromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignSeve1FromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Seve2 validation for a ExcAC1A
   *
   * @param command AssignSeve2ToExcAC1ACommand
   */
  public void validate(AssignSeve2ToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignSeve2ToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignSeve2ToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve2ToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Seve2 validation for a ExcAC1A
   *
   * @param command UnAssignSeve2FromExcAC1ACommand
   */
  public void validate(UnAssignSeve2FromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve2FromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignSeve2FromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcAC1A
   *
   * @param command AssignTaToExcAC1ACommand
   */
  public void validate(AssignTaToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignTaToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcAC1A
   *
   * @param command UnAssignTaFromExcAC1ACommand
   */
  public void validate(UnAssignTaFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignTaFromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcAC1A
   *
   * @param command AssignTbToExcAC1ACommand
   */
  public void validate(AssignTbToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignTbToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcAC1A
   *
   * @param command UnAssignTbFromExcAC1ACommand
   */
  public void validate(UnAssignTbFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignTbFromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcAC1A
   *
   * @param command AssignTcToExcAC1ACommand
   */
  public void validate(AssignTcToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignTcToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcAC1A
   *
   * @param command UnAssignTcFromExcAC1ACommand
   */
  public void validate(UnAssignTcFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignTcFromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcAC1A
   *
   * @param command AssignTeToExcAC1ACommand
   */
  public void validate(AssignTeToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignTeToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcAC1A
   *
   * @param command UnAssignTeFromExcAC1ACommand
   */
  public void validate(UnAssignTeFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignTeFromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcAC1A
   *
   * @param command AssignTfToExcAC1ACommand
   */
  public void validate(AssignTfToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignTfToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcAC1A
   *
   * @param command UnAssignTfFromExcAC1ACommand
   */
  public void validate(UnAssignTfFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignTfFromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vamax validation for a ExcAC1A
   *
   * @param command AssignVamaxToExcAC1ACommand
   */
  public void validate(AssignVamaxToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVamaxToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignVamaxToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVamaxToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamax validation for a ExcAC1A
   *
   * @param command UnAssignVamaxFromExcAC1ACommand
   */
  public void validate(UnAssignVamaxFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVamaxFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignVamaxFromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vamin validation for a ExcAC1A
   *
   * @param command AssignVaminToExcAC1ACommand
   */
  public void validate(AssignVaminToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVaminToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignVaminToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVaminToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamin validation for a ExcAC1A
   *
   * @param command UnAssignVaminFromExcAC1ACommand
   */
  public void validate(UnAssignVaminFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVaminFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignVaminFromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ve1 validation for a ExcAC1A
   *
   * @param command AssignVe1ToExcAC1ACommand
   */
  public void validate(AssignVe1ToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe1ToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignVe1ToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe1ToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve1 validation for a ExcAC1A
   *
   * @param command UnAssignVe1FromExcAC1ACommand
   */
  public void validate(UnAssignVe1FromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe1FromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignVe1FromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Ve2 validation for a ExcAC1A
   *
   * @param command AssignVe2ToExcAC1ACommand
   */
  public void validate(AssignVe2ToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVe2ToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignVe2ToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe2ToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ve2 validation for a ExcAC1A
   *
   * @param command UnAssignVe2FromExcAC1ACommand
   */
  public void validate(UnAssignVe2FromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe2FromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignVe2FromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcAC1A
   *
   * @param command AssignVrmaxToExcAC1ACommand
   */
  public void validate(AssignVrmaxToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignVrmaxToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcAC1A
   *
   * @param command UnAssignVrmaxFromExcAC1ACommand
   */
  public void validate(UnAssignVrmaxFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignVrmaxFromExcAC1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcAC1A
   *
   * @param command AssignVrminToExcAC1ACommand
   */
  public void validate(AssignVrminToExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "AssignVrminToExcAC1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcAC1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcAC1A
   *
   * @param command UnAssignVrminFromExcAC1ACommand
   */
  public void validate(UnAssignVrminFromExcAC1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcAC1ACommand should not be null");
    Assert.notNull(
        command.getExcAC1AId(), "UnAssignVrminFromExcAC1ACommand identifier should not be null");
  }
}
