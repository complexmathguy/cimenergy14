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

public class ExcIEEEAC7BValidator {

  /** default constructor */
  protected ExcIEEEAC7BValidator() {}

  /** factory method */
  public static ExcIEEEAC7BValidator getInstance() {
    return new ExcIEEEAC7BValidator();
  }

  /** handles creation validation for a ExcIEEEAC7B */
  public void validate(CreateExcIEEEAC7BCommand excIEEEAC7B) throws Exception {
    Assert.notNull(excIEEEAC7B, "CreateExcIEEEAC7BCommand should not be null");
    //		Assert.isNull( excIEEEAC7B.getExcIEEEAC7BId(), "CreateExcIEEEAC7BCommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEAC7B */
  public void validate(UpdateExcIEEEAC7BCommand excIEEEAC7B) throws Exception {
    Assert.notNull(excIEEEAC7B, "UpdateExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        excIEEEAC7B.getExcIEEEAC7BId(), "UpdateExcIEEEAC7BCommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEAC7B */
  public void validate(DeleteExcIEEEAC7BCommand excIEEEAC7B) throws Exception {
    Assert.notNull(excIEEEAC7B, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEAC7B.getExcIEEEAC7BId(), "DeleteExcIEEEAC7BCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEAC7B */
  public void validate(ExcIEEEAC7BFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEAC7BFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEAC7BId(), "ExcIEEEAC7BFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Kc validation for a ExcIEEEAC7B
   *
   * @param command AssignKcToExcIEEEAC7BCommand
   */
  public void validate(AssignKcToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignKcToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcIEEEAC7B
   *
   * @param command UnAssignKcFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignKcFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignKcFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a ExcIEEEAC7B
   *
   * @param command AssignKdToExcIEEEAC7BCommand
   */
  public void validate(AssignKdToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKdToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignKdToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a ExcIEEEAC7B
   *
   * @param command UnAssignKdFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignKdFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignKdFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Kdr validation for a ExcIEEEAC7B
   *
   * @param command AssignKdrToExcIEEEAC7BCommand
   */
  public void validate(AssignKdrToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKdrToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignKdrToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdrToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kdr validation for a ExcIEEEAC7B
   *
   * @param command UnAssignKdrFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignKdrFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdrFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignKdrFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcIEEEAC7B
   *
   * @param command AssignKeToExcIEEEAC7BCommand
   */
  public void validate(AssignKeToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignKeToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcIEEEAC7B
   *
   * @param command UnAssignKeFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignKeFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignKeFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Kf1 validation for a ExcIEEEAC7B
   *
   * @param command AssignKf1ToExcIEEEAC7BCommand
   */
  public void validate(AssignKf1ToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKf1ToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignKf1ToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKf1ToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kf1 validation for a ExcIEEEAC7B
   *
   * @param command UnAssignKf1FromExcIEEEAC7BCommand
   */
  public void validate(UnAssignKf1FromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKf1FromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignKf1FromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Kf2 validation for a ExcIEEEAC7B
   *
   * @param command AssignKf2ToExcIEEEAC7BCommand
   */
  public void validate(AssignKf2ToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKf2ToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignKf2ToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKf2ToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kf2 validation for a ExcIEEEAC7B
   *
   * @param command UnAssignKf2FromExcIEEEAC7BCommand
   */
  public void validate(UnAssignKf2FromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKf2FromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignKf2FromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Kf3 validation for a ExcIEEEAC7B
   *
   * @param command AssignKf3ToExcIEEEAC7BCommand
   */
  public void validate(AssignKf3ToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKf3ToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignKf3ToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKf3ToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kf3 validation for a ExcIEEEAC7B
   *
   * @param command UnAssignKf3FromExcIEEEAC7BCommand
   */
  public void validate(UnAssignKf3FromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKf3FromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignKf3FromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Kia validation for a ExcIEEEAC7B
   *
   * @param command AssignKiaToExcIEEEAC7BCommand
   */
  public void validate(AssignKiaToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKiaToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignKiaToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiaToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kia validation for a ExcIEEEAC7B
   *
   * @param command UnAssignKiaFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignKiaFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiaFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignKiaFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Kir validation for a ExcIEEEAC7B
   *
   * @param command AssignKirToExcIEEEAC7BCommand
   */
  public void validate(AssignKirToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKirToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignKirToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKirToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kir validation for a ExcIEEEAC7B
   *
   * @param command UnAssignKirFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignKirFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKirFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignKirFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Kl validation for a ExcIEEEAC7B
   *
   * @param command AssignKlToExcIEEEAC7BCommand
   */
  public void validate(AssignKlToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKlToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignKlToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKlToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kl validation for a ExcIEEEAC7B
   *
   * @param command UnAssignKlFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignKlFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKlFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignKlFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a ExcIEEEAC7B
   *
   * @param command AssignKpToExcIEEEAC7BCommand
   */
  public void validate(AssignKpToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKpToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignKpToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a ExcIEEEAC7B
   *
   * @param command UnAssignKpFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignKpFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignKpFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Kpa validation for a ExcIEEEAC7B
   *
   * @param command AssignKpaToExcIEEEAC7BCommand
   */
  public void validate(AssignKpaToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKpaToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignKpaToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpaToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kpa validation for a ExcIEEEAC7B
   *
   * @param command UnAssignKpaFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignKpaFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpaFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignKpaFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Kpr validation for a ExcIEEEAC7B
   *
   * @param command AssignKprToExcIEEEAC7BCommand
   */
  public void validate(AssignKprToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKprToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignKprToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKprToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kpr validation for a ExcIEEEAC7B
   *
   * @param command UnAssignKprFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignKprFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKprFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignKprFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Seve1 validation for a ExcIEEEAC7B
   *
   * @param command AssignSeve1ToExcIEEEAC7BCommand
   */
  public void validate(AssignSeve1ToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignSeve1ToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "AssignSeve1ToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve1ToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Seve1 validation for a ExcIEEEAC7B
   *
   * @param command UnAssignSeve1FromExcIEEEAC7BCommand
   */
  public void validate(UnAssignSeve1FromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve1FromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignSeve1FromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Seve2 validation for a ExcIEEEAC7B
   *
   * @param command AssignSeve2ToExcIEEEAC7BCommand
   */
  public void validate(AssignSeve2ToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignSeve2ToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "AssignSeve2ToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSeve2ToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Seve2 validation for a ExcIEEEAC7B
   *
   * @param command UnAssignSeve2FromExcIEEEAC7BCommand
   */
  public void validate(UnAssignSeve2FromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSeve2FromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignSeve2FromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Tdr validation for a ExcIEEEAC7B
   *
   * @param command AssignTdrToExcIEEEAC7BCommand
   */
  public void validate(AssignTdrToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignTdrToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignTdrToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdrToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Tdr validation for a ExcIEEEAC7B
   *
   * @param command UnAssignTdrFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignTdrFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdrFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignTdrFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcIEEEAC7B
   *
   * @param command AssignTeToExcIEEEAC7BCommand
   */
  public void validate(AssignTeToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignTeToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcIEEEAC7B
   *
   * @param command UnAssignTeFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignTeFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignTeFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcIEEEAC7B
   *
   * @param command AssignTfToExcIEEEAC7BCommand
   */
  public void validate(AssignTfToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignTfToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcIEEEAC7B
   *
   * @param command UnAssignTfFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignTfFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignTfFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Vamax validation for a ExcIEEEAC7B
   *
   * @param command AssignVamaxToExcIEEEAC7BCommand
   */
  public void validate(AssignVamaxToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVamaxToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "AssignVamaxToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVamaxToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Vamax validation for a ExcIEEEAC7B
   *
   * @param command UnAssignVamaxFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignVamaxFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVamaxFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignVamaxFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Vamin validation for a ExcIEEEAC7B
   *
   * @param command AssignVaminToExcIEEEAC7BCommand
   */
  public void validate(AssignVaminToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVaminToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "AssignVaminToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVaminToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Vamin validation for a ExcIEEEAC7B
   *
   * @param command UnAssignVaminFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignVaminFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVaminFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignVaminFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Ve1 validation for a ExcIEEEAC7B
   *
   * @param command AssignVe1ToExcIEEEAC7BCommand
   */
  public void validate(AssignVe1ToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVe1ToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignVe1ToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe1ToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Ve1 validation for a ExcIEEEAC7B
   *
   * @param command UnAssignVe1FromExcIEEEAC7BCommand
   */
  public void validate(UnAssignVe1FromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe1FromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignVe1FromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Ve2 validation for a ExcIEEEAC7B
   *
   * @param command AssignVe2ToExcIEEEAC7BCommand
   */
  public void validate(AssignVe2ToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVe2ToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(), "AssignVe2ToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVe2ToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Ve2 validation for a ExcIEEEAC7B
   *
   * @param command UnAssignVe2FromExcIEEEAC7BCommand
   */
  public void validate(UnAssignVe2FromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVe2FromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignVe2FromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Vemin validation for a ExcIEEEAC7B
   *
   * @param command AssignVeminToExcIEEEAC7BCommand
   */
  public void validate(AssignVeminToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVeminToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "AssignVeminToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVeminToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Vemin validation for a ExcIEEEAC7B
   *
   * @param command UnAssignVeminFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignVeminFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVeminFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignVeminFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Vfemax validation for a ExcIEEEAC7B
   *
   * @param command AssignVfemaxToExcIEEEAC7BCommand
   */
  public void validate(AssignVfemaxToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVfemaxToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "AssignVfemaxToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVfemaxToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Vfemax validation for a ExcIEEEAC7B
   *
   * @param command UnAssignVfemaxFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignVfemaxFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVfemaxFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignVfemaxFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEAC7B
   *
   * @param command AssignVrmaxToExcIEEEAC7BCommand
   */
  public void validate(AssignVrmaxToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "AssignVrmaxToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEAC7B
   *
   * @param command UnAssignVrmaxFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignVrmaxFromExcIEEEAC7BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEAC7B
   *
   * @param command AssignVrminToExcIEEEAC7BCommand
   */
  public void validate(AssignVrminToExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "AssignVrminToExcIEEEAC7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEAC7BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEAC7B
   *
   * @param command UnAssignVrminFromExcIEEEAC7BCommand
   */
  public void validate(UnAssignVrminFromExcIEEEAC7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEAC7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC7BId(),
        "UnAssignVrminFromExcIEEEAC7BCommand identifier should not be null");
  }
}
