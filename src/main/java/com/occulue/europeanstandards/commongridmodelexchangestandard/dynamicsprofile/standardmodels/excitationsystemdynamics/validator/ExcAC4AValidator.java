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

public class ExcAC4AValidator {

  /** default constructor */
  protected ExcAC4AValidator() {}

  /** factory method */
  public static ExcAC4AValidator getInstance() {
    return new ExcAC4AValidator();
  }

  /** handles creation validation for a ExcAC4A */
  public void validate(CreateExcAC4ACommand excAC4A) throws Exception {
    Assert.notNull(excAC4A, "CreateExcAC4ACommand should not be null");
    //		Assert.isNull( excAC4A.getExcAC4AId(), "CreateExcAC4ACommand identifier should be null" );
  }

  /** handles update validation for a ExcAC4A */
  public void validate(UpdateExcAC4ACommand excAC4A) throws Exception {
    Assert.notNull(excAC4A, "UpdateExcAC4ACommand should not be null");
    Assert.notNull(excAC4A.getExcAC4AId(), "UpdateExcAC4ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcAC4A */
  public void validate(DeleteExcAC4ACommand excAC4A) throws Exception {
    Assert.notNull(excAC4A, "{commandAlias} should not be null");
    Assert.notNull(excAC4A.getExcAC4AId(), "DeleteExcAC4ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcAC4A */
  public void validate(ExcAC4AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcAC4AFetchOneSummary should not be null");
    Assert.notNull(summary.getExcAC4AId(), "ExcAC4AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ka validation for a ExcAC4A
   *
   * @param command AssignKaToExcAC4ACommand
   */
  public void validate(AssignKaToExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "AssignKaToExcAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcAC4A
   *
   * @param command UnAssignKaFromExcAC4ACommand
   */
  public void validate(UnAssignKaFromExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "UnAssignKaFromExcAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcAC4A
   *
   * @param command AssignKcToExcAC4ACommand
   */
  public void validate(AssignKcToExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "AssignKcToExcAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcAC4A
   *
   * @param command UnAssignKcFromExcAC4ACommand
   */
  public void validate(UnAssignKcFromExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "UnAssignKcFromExcAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcAC4A
   *
   * @param command AssignTaToExcAC4ACommand
   */
  public void validate(AssignTaToExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "AssignTaToExcAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcAC4A
   *
   * @param command UnAssignTaFromExcAC4ACommand
   */
  public void validate(UnAssignTaFromExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "UnAssignTaFromExcAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcAC4A
   *
   * @param command AssignTbToExcAC4ACommand
   */
  public void validate(AssignTbToExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "AssignTbToExcAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcAC4A
   *
   * @param command UnAssignTbFromExcAC4ACommand
   */
  public void validate(UnAssignTbFromExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "UnAssignTbFromExcAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcAC4A
   *
   * @param command AssignTcToExcAC4ACommand
   */
  public void validate(AssignTcToExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "AssignTcToExcAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcAC4A
   *
   * @param command UnAssignTcFromExcAC4ACommand
   */
  public void validate(UnAssignTcFromExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "UnAssignTcFromExcAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Vimax validation for a ExcAC4A
   *
   * @param command AssignVimaxToExcAC4ACommand
   */
  public void validate(AssignVimaxToExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignVimaxToExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "AssignVimaxToExcAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVimaxToExcAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Vimax validation for a ExcAC4A
   *
   * @param command UnAssignVimaxFromExcAC4ACommand
   */
  public void validate(UnAssignVimaxFromExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVimaxFromExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "UnAssignVimaxFromExcAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Vimin validation for a ExcAC4A
   *
   * @param command AssignViminToExcAC4ACommand
   */
  public void validate(AssignViminToExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignViminToExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "AssignViminToExcAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignViminToExcAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Vimin validation for a ExcAC4A
   *
   * @param command UnAssignViminFromExcAC4ACommand
   */
  public void validate(UnAssignViminFromExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignViminFromExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "UnAssignViminFromExcAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcAC4A
   *
   * @param command AssignVrmaxToExcAC4ACommand
   */
  public void validate(AssignVrmaxToExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "AssignVrmaxToExcAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcAC4A
   *
   * @param command UnAssignVrmaxFromExcAC4ACommand
   */
  public void validate(UnAssignVrmaxFromExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "UnAssignVrmaxFromExcAC4ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcAC4A
   *
   * @param command AssignVrminToExcAC4ACommand
   */
  public void validate(AssignVrminToExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "AssignVrminToExcAC4ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcAC4ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcAC4A
   *
   * @param command UnAssignVrminFromExcAC4ACommand
   */
  public void validate(UnAssignVrminFromExcAC4ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcAC4ACommand should not be null");
    Assert.notNull(
        command.getExcAC4AId(), "UnAssignVrminFromExcAC4ACommand identifier should not be null");
  }
}
