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

public class ExcOEX3TValidator {

  /** default constructor */
  protected ExcOEX3TValidator() {}

  /** factory method */
  public static ExcOEX3TValidator getInstance() {
    return new ExcOEX3TValidator();
  }

  /** handles creation validation for a ExcOEX3T */
  public void validate(CreateExcOEX3TCommand excOEX3T) throws Exception {
    Assert.notNull(excOEX3T, "CreateExcOEX3TCommand should not be null");
    //		Assert.isNull( excOEX3T.getExcOEX3TId(), "CreateExcOEX3TCommand identifier should be null"
    // );
  }

  /** handles update validation for a ExcOEX3T */
  public void validate(UpdateExcOEX3TCommand excOEX3T) throws Exception {
    Assert.notNull(excOEX3T, "UpdateExcOEX3TCommand should not be null");
    Assert.notNull(excOEX3T.getExcOEX3TId(), "UpdateExcOEX3TCommand identifier should not be null");
  }

  /** handles delete validation for a ExcOEX3T */
  public void validate(DeleteExcOEX3TCommand excOEX3T) throws Exception {
    Assert.notNull(excOEX3T, "{commandAlias} should not be null");
    Assert.notNull(excOEX3T.getExcOEX3TId(), "DeleteExcOEX3TCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcOEX3T */
  public void validate(ExcOEX3TFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcOEX3TFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcOEX3TId(), "ExcOEX3TFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign E1 validation for a ExcOEX3T
   *
   * @param command AssignE1ToExcOEX3TCommand
   */
  public void validate(AssignE1ToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignE1ToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignE1ToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignE1ToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign E1 validation for a ExcOEX3T
   *
   * @param command UnAssignE1FromExcOEX3TCommand
   */
  public void validate(UnAssignE1FromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignE1FromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignE1FromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign E2 validation for a ExcOEX3T
   *
   * @param command AssignE2ToExcOEX3TCommand
   */
  public void validate(AssignE2ToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignE2ToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignE2ToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignE2ToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign E2 validation for a ExcOEX3T
   *
   * @param command UnAssignE2FromExcOEX3TCommand
   */
  public void validate(UnAssignE2FromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignE2FromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignE2FromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcOEX3T
   *
   * @param command AssignKaToExcOEX3TCommand
   */
  public void validate(AssignKaToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignKaToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcOEX3T
   *
   * @param command UnAssignKaFromExcOEX3TCommand
   */
  public void validate(UnAssignKaFromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignKaFromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcOEX3T
   *
   * @param command AssignKcToExcOEX3TCommand
   */
  public void validate(AssignKcToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignKcToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcOEX3T
   *
   * @param command UnAssignKcFromExcOEX3TCommand
   */
  public void validate(UnAssignKcFromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignKcFromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a ExcOEX3T
   *
   * @param command AssignKdToExcOEX3TCommand
   */
  public void validate(AssignKdToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignKdToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignKdToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a ExcOEX3T
   *
   * @param command UnAssignKdFromExcOEX3TCommand
   */
  public void validate(UnAssignKdFromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignKdFromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcOEX3T
   *
   * @param command AssignKeToExcOEX3TCommand
   */
  public void validate(AssignKeToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignKeToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcOEX3T
   *
   * @param command UnAssignKeFromExcOEX3TCommand
   */
  public void validate(UnAssignKeFromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignKeFromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcOEX3T
   *
   * @param command AssignKfToExcOEX3TCommand
   */
  public void validate(AssignKfToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignKfToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcOEX3T
   *
   * @param command UnAssignKfFromExcOEX3TCommand
   */
  public void validate(UnAssignKfFromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignKfFromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign See1 validation for a ExcOEX3T
   *
   * @param command AssignSee1ToExcOEX3TCommand
   */
  public void validate(AssignSee1ToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignSee1ToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignSee1ToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSee1ToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign See1 validation for a ExcOEX3T
   *
   * @param command UnAssignSee1FromExcOEX3TCommand
   */
  public void validate(UnAssignSee1FromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSee1FromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignSee1FromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign See2 validation for a ExcOEX3T
   *
   * @param command AssignSee2ToExcOEX3TCommand
   */
  public void validate(AssignSee2ToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignSee2ToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignSee2ToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSee2ToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign See2 validation for a ExcOEX3T
   *
   * @param command UnAssignSee2FromExcOEX3TCommand
   */
  public void validate(UnAssignSee2FromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSee2FromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignSee2FromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a ExcOEX3T
   *
   * @param command AssignT1ToExcOEX3TCommand
   */
  public void validate(AssignT1ToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignT1ToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a ExcOEX3T
   *
   * @param command UnAssignT1FromExcOEX3TCommand
   */
  public void validate(UnAssignT1FromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignT1FromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a ExcOEX3T
   *
   * @param command AssignT2ToExcOEX3TCommand
   */
  public void validate(AssignT2ToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignT2ToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a ExcOEX3T
   *
   * @param command UnAssignT2FromExcOEX3TCommand
   */
  public void validate(UnAssignT2FromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignT2FromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign T3 validation for a ExcOEX3T
   *
   * @param command AssignT3ToExcOEX3TCommand
   */
  public void validate(AssignT3ToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignT3ToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignT3ToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a ExcOEX3T
   *
   * @param command UnAssignT3FromExcOEX3TCommand
   */
  public void validate(UnAssignT3FromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignT3FromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign T4 validation for a ExcOEX3T
   *
   * @param command AssignT4ToExcOEX3TCommand
   */
  public void validate(AssignT4ToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignT4ToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignT4ToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a ExcOEX3T
   *
   * @param command UnAssignT4FromExcOEX3TCommand
   */
  public void validate(UnAssignT4FromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignT4FromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign T5 validation for a ExcOEX3T
   *
   * @param command AssignT5ToExcOEX3TCommand
   */
  public void validate(AssignT5ToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignT5ToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignT5ToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5ToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a ExcOEX3T
   *
   * @param command UnAssignT5FromExcOEX3TCommand
   */
  public void validate(UnAssignT5FromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignT5FromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign T6 validation for a ExcOEX3T
   *
   * @param command AssignT6ToExcOEX3TCommand
   */
  public void validate(AssignT6ToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignT6ToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignT6ToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT6ToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a ExcOEX3T
   *
   * @param command UnAssignT6FromExcOEX3TCommand
   */
  public void validate(UnAssignT6FromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignT6FromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcOEX3T
   *
   * @param command AssignTeToExcOEX3TCommand
   */
  public void validate(AssignTeToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignTeToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcOEX3T
   *
   * @param command UnAssignTeFromExcOEX3TCommand
   */
  public void validate(UnAssignTeFromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignTeFromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcOEX3T
   *
   * @param command AssignTfToExcOEX3TCommand
   */
  public void validate(AssignTfToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignTfToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcOEX3T
   *
   * @param command UnAssignTfFromExcOEX3TCommand
   */
  public void validate(UnAssignTfFromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignTfFromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcOEX3T
   *
   * @param command AssignVrmaxToExcOEX3TCommand
   */
  public void validate(AssignVrmaxToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignVrmaxToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcOEX3T
   *
   * @param command UnAssignVrmaxFromExcOEX3TCommand
   */
  public void validate(UnAssignVrmaxFromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignVrmaxFromExcOEX3TCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcOEX3T
   *
   * @param command AssignVrminToExcOEX3TCommand
   */
  public void validate(AssignVrminToExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "AssignVrminToExcOEX3TCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcOEX3TCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcOEX3T
   *
   * @param command UnAssignVrminFromExcOEX3TCommand
   */
  public void validate(UnAssignVrminFromExcOEX3TCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcOEX3TCommand should not be null");
    Assert.notNull(
        command.getExcOEX3TId(), "UnAssignVrminFromExcOEX3TCommand identifier should not be null");
  }
}
