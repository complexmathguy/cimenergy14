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

public class ExcIEEEAC4AValidator {

  /** default constructor */
  protected ExcIEEEAC4AValidator() {}

  /** factory method */
  public static ExcIEEEAC4AValidator getInstance() {
    return new ExcIEEEAC4AValidator();
  }

  /** handles creation validation for a ExcIEEEAC4A */
  public void validate(CreateExcIEEEAC4ACommand excIEEEAC4A) throws Exception {
    Assert.notNull(excIEEEAC4A, "CreateExcIEEEAC4ACommand should not be null");
    //		Assert.isNull( excIEEEAC4A.getExcIEEEAC4AId(), "CreateExcIEEEAC4ACommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEAC4A */
  public void validate(UpdateExcIEEEAC4ACommand excIEEEAC4A) throws Exception {
    Assert.notNull(excIEEEAC4A, "UpdateExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        excIEEEAC4A.getExcIEEEAC4AId(), "UpdateExcIEEEAC4ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEAC4A */
  public void validate(DeleteExcIEEEAC4ACommand excIEEEAC4A) throws Exception {
    Assert.notNull(excIEEEAC4A, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEAC4A.getExcIEEEAC4AId(), "DeleteExcIEEEAC4ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEAC4A */
  public void validate(ExcIEEEAC4AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEAC4AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEAC4AId(), "ExcIEEEAC4AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ka validation for a ExcIEEEAC4A
   *
   * @param command AssignKaToExcIEEEAC4ACommand
   */
  public void validate(AssignKaToExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(), "AssignKaToExcIEEEAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcIEEEAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcIEEEAC4A
   *
   * @param command UnAssignKaFromExcIEEEAC4ACommand
   */
  public void validate(UnAssignKaFromExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(),
        "UnAssignKaFromExcIEEEAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcIEEEAC4A
   *
   * @param command AssignKcToExcIEEEAC4ACommand
   */
  public void validate(AssignKcToExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(), "AssignKcToExcIEEEAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcIEEEAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcIEEEAC4A
   *
   * @param command UnAssignKcFromExcIEEEAC4ACommand
   */
  public void validate(UnAssignKcFromExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(),
        "UnAssignKcFromExcIEEEAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcIEEEAC4A
   *
   * @param command AssignTaToExcIEEEAC4ACommand
   */
  public void validate(AssignTaToExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(), "AssignTaToExcIEEEAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcIEEEAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcIEEEAC4A
   *
   * @param command UnAssignTaFromExcIEEEAC4ACommand
   */
  public void validate(UnAssignTaFromExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(),
        "UnAssignTaFromExcIEEEAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcIEEEAC4A
   *
   * @param command AssignTbToExcIEEEAC4ACommand
   */
  public void validate(AssignTbToExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(), "AssignTbToExcIEEEAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcIEEEAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcIEEEAC4A
   *
   * @param command UnAssignTbFromExcIEEEAC4ACommand
   */
  public void validate(UnAssignTbFromExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(),
        "UnAssignTbFromExcIEEEAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcIEEEAC4A
   *
   * @param command AssignTcToExcIEEEAC4ACommand
   */
  public void validate(AssignTcToExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(), "AssignTcToExcIEEEAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcIEEEAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcIEEEAC4A
   *
   * @param command UnAssignTcFromExcIEEEAC4ACommand
   */
  public void validate(UnAssignTcFromExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(),
        "UnAssignTcFromExcIEEEAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Vimax validation for a ExcIEEEAC4A
   *
   * @param command AssignVimaxToExcIEEEAC4ACommand
   */
  public void validate(AssignVimaxToExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignVimaxToExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(),
        "AssignVimaxToExcIEEEAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVimaxToExcIEEEAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Vimax validation for a ExcIEEEAC4A
   *
   * @param command UnAssignVimaxFromExcIEEEAC4ACommand
   */
  public void validate(UnAssignVimaxFromExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVimaxFromExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(),
        "UnAssignVimaxFromExcIEEEAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Vimin validation for a ExcIEEEAC4A
   *
   * @param command AssignViminToExcIEEEAC4ACommand
   */
  public void validate(AssignViminToExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignViminToExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(),
        "AssignViminToExcIEEEAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignViminToExcIEEEAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Vimin validation for a ExcIEEEAC4A
   *
   * @param command UnAssignViminFromExcIEEEAC4ACommand
   */
  public void validate(UnAssignViminFromExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignViminFromExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(),
        "UnAssignViminFromExcIEEEAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEAC4A
   *
   * @param command AssignVrmaxToExcIEEEAC4ACommand
   */
  public void validate(AssignVrmaxToExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(),
        "AssignVrmaxToExcIEEEAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEAC4A
   *
   * @param command UnAssignVrmaxFromExcIEEEAC4ACommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(),
        "UnAssignVrmaxFromExcIEEEAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEAC4A
   *
   * @param command AssignVrminToExcIEEEAC4ACommand
   */
  public void validate(AssignVrminToExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(),
        "AssignVrminToExcIEEEAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEAC4A
   *
   * @param command UnAssignVrminFromExcIEEEAC4ACommand
   */
  public void validate(UnAssignVrminFromExcIEEEAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEAC4ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEAC4AId(),
        "UnAssignVrminFromExcIEEEAC4ACommand identifier should not be null");
  }
}
