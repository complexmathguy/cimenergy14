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

public class ExcCZValidator {

  /** default constructor */
  protected ExcCZValidator() {}

  /** factory method */
  public static ExcCZValidator getInstance() {
    return new ExcCZValidator();
  }

  /** handles creation validation for a ExcCZ */
  public void validate(CreateExcCZCommand excCZ) throws Exception {
    Assert.notNull(excCZ, "CreateExcCZCommand should not be null");
    //		Assert.isNull( excCZ.getExcCZId(), "CreateExcCZCommand identifier should be null" );
  }

  /** handles update validation for a ExcCZ */
  public void validate(UpdateExcCZCommand excCZ) throws Exception {
    Assert.notNull(excCZ, "UpdateExcCZCommand should not be null");
    Assert.notNull(excCZ.getExcCZId(), "UpdateExcCZCommand identifier should not be null");
  }

  /** handles delete validation for a ExcCZ */
  public void validate(DeleteExcCZCommand excCZ) throws Exception {
    Assert.notNull(excCZ, "{commandAlias} should not be null");
    Assert.notNull(excCZ.getExcCZId(), "DeleteExcCZCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcCZ */
  public void validate(ExcCZFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcCZFetchOneSummary should not be null");
    Assert.notNull(summary.getExcCZId(), "ExcCZFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efdmax validation for a ExcCZ
   *
   * @param command AssignEfdmaxToExcCZCommand
   */
  public void validate(AssignEfdmaxToExcCZCommand command) throws Exception {
    Assert.notNull(command, "AssignEfdmaxToExcCZCommand should not be null");
    Assert.notNull(
        command.getExcCZId(), "AssignEfdmaxToExcCZCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdmaxToExcCZCommand assignment should not be null");
  }

  /**
   * handles unassign Efdmax validation for a ExcCZ
   *
   * @param command UnAssignEfdmaxFromExcCZCommand
   */
  public void validate(UnAssignEfdmaxFromExcCZCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdmaxFromExcCZCommand should not be null");
    Assert.notNull(
        command.getExcCZId(), "UnAssignEfdmaxFromExcCZCommand identifier should not be null");
  }
  /**
   * handles assign Efdmin validation for a ExcCZ
   *
   * @param command AssignEfdminToExcCZCommand
   */
  public void validate(AssignEfdminToExcCZCommand command) throws Exception {
    Assert.notNull(command, "AssignEfdminToExcCZCommand should not be null");
    Assert.notNull(
        command.getExcCZId(), "AssignEfdminToExcCZCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdminToExcCZCommand assignment should not be null");
  }

  /**
   * handles unassign Efdmin validation for a ExcCZ
   *
   * @param command UnAssignEfdminFromExcCZCommand
   */
  public void validate(UnAssignEfdminFromExcCZCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdminFromExcCZCommand should not be null");
    Assert.notNull(
        command.getExcCZId(), "UnAssignEfdminFromExcCZCommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcCZ
   *
   * @param command AssignKaToExcCZCommand
   */
  public void validate(AssignKaToExcCZCommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcCZCommand should not be null");
    Assert.notNull(command.getExcCZId(), "AssignKaToExcCZCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKaToExcCZCommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcCZ
   *
   * @param command UnAssignKaFromExcCZCommand
   */
  public void validate(UnAssignKaFromExcCZCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcCZCommand should not be null");
    Assert.notNull(
        command.getExcCZId(), "UnAssignKaFromExcCZCommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcCZ
   *
   * @param command AssignKeToExcCZCommand
   */
  public void validate(AssignKeToExcCZCommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcCZCommand should not be null");
    Assert.notNull(command.getExcCZId(), "AssignKeToExcCZCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKeToExcCZCommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcCZ
   *
   * @param command UnAssignKeFromExcCZCommand
   */
  public void validate(UnAssignKeFromExcCZCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcCZCommand should not be null");
    Assert.notNull(
        command.getExcCZId(), "UnAssignKeFromExcCZCommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a ExcCZ
   *
   * @param command AssignKpToExcCZCommand
   */
  public void validate(AssignKpToExcCZCommand command) throws Exception {
    Assert.notNull(command, "AssignKpToExcCZCommand should not be null");
    Assert.notNull(command.getExcCZId(), "AssignKpToExcCZCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKpToExcCZCommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a ExcCZ
   *
   * @param command UnAssignKpFromExcCZCommand
   */
  public void validate(UnAssignKpFromExcCZCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromExcCZCommand should not be null");
    Assert.notNull(
        command.getExcCZId(), "UnAssignKpFromExcCZCommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcCZ
   *
   * @param command AssignTaToExcCZCommand
   */
  public void validate(AssignTaToExcCZCommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcCZCommand should not be null");
    Assert.notNull(command.getExcCZId(), "AssignTaToExcCZCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTaToExcCZCommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcCZ
   *
   * @param command UnAssignTaFromExcCZCommand
   */
  public void validate(UnAssignTaFromExcCZCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcCZCommand should not be null");
    Assert.notNull(
        command.getExcCZId(), "UnAssignTaFromExcCZCommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcCZ
   *
   * @param command AssignTcToExcCZCommand
   */
  public void validate(AssignTcToExcCZCommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcCZCommand should not be null");
    Assert.notNull(command.getExcCZId(), "AssignTcToExcCZCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTcToExcCZCommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcCZ
   *
   * @param command UnAssignTcFromExcCZCommand
   */
  public void validate(UnAssignTcFromExcCZCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcCZCommand should not be null");
    Assert.notNull(
        command.getExcCZId(), "UnAssignTcFromExcCZCommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcCZ
   *
   * @param command AssignTeToExcCZCommand
   */
  public void validate(AssignTeToExcCZCommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcCZCommand should not be null");
    Assert.notNull(command.getExcCZId(), "AssignTeToExcCZCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTeToExcCZCommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcCZ
   *
   * @param command UnAssignTeFromExcCZCommand
   */
  public void validate(UnAssignTeFromExcCZCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcCZCommand should not be null");
    Assert.notNull(
        command.getExcCZId(), "UnAssignTeFromExcCZCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcCZ
   *
   * @param command AssignVrmaxToExcCZCommand
   */
  public void validate(AssignVrmaxToExcCZCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcCZCommand should not be null");
    Assert.notNull(command.getExcCZId(), "AssignVrmaxToExcCZCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcCZCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcCZ
   *
   * @param command UnAssignVrmaxFromExcCZCommand
   */
  public void validate(UnAssignVrmaxFromExcCZCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcCZCommand should not be null");
    Assert.notNull(
        command.getExcCZId(), "UnAssignVrmaxFromExcCZCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcCZ
   *
   * @param command AssignVrminToExcCZCommand
   */
  public void validate(AssignVrminToExcCZCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcCZCommand should not be null");
    Assert.notNull(command.getExcCZId(), "AssignVrminToExcCZCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcCZCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcCZ
   *
   * @param command UnAssignVrminFromExcCZCommand
   */
  public void validate(UnAssignVrminFromExcCZCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcCZCommand should not be null");
    Assert.notNull(
        command.getExcCZId(), "UnAssignVrminFromExcCZCommand identifier should not be null");
  }
}
