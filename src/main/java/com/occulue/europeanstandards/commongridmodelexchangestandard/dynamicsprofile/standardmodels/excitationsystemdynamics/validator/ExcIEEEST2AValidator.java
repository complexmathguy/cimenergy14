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

public class ExcIEEEST2AValidator {

  /** default constructor */
  protected ExcIEEEST2AValidator() {}

  /** factory method */
  public static ExcIEEEST2AValidator getInstance() {
    return new ExcIEEEST2AValidator();
  }

  /** handles creation validation for a ExcIEEEST2A */
  public void validate(CreateExcIEEEST2ACommand excIEEEST2A) throws Exception {
    Assert.notNull(excIEEEST2A, "CreateExcIEEEST2ACommand should not be null");
    //		Assert.isNull( excIEEEST2A.getExcIEEEST2AId(), "CreateExcIEEEST2ACommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEST2A */
  public void validate(UpdateExcIEEEST2ACommand excIEEEST2A) throws Exception {
    Assert.notNull(excIEEEST2A, "UpdateExcIEEEST2ACommand should not be null");
    Assert.notNull(
        excIEEEST2A.getExcIEEEST2AId(), "UpdateExcIEEEST2ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEST2A */
  public void validate(DeleteExcIEEEST2ACommand excIEEEST2A) throws Exception {
    Assert.notNull(excIEEEST2A, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEST2A.getExcIEEEST2AId(), "DeleteExcIEEEST2ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEST2A */
  public void validate(ExcIEEEST2AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEST2AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEST2AId(), "ExcIEEEST2AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efdmax validation for a ExcIEEEST2A
   *
   * @param command AssignEfdmaxToExcIEEEST2ACommand
   */
  public void validate(AssignEfdmaxToExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfdmaxToExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "AssignEfdmaxToExcIEEEST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdmaxToExcIEEEST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Efdmax validation for a ExcIEEEST2A
   *
   * @param command UnAssignEfdmaxFromExcIEEEST2ACommand
   */
  public void validate(UnAssignEfdmaxFromExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdmaxFromExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "UnAssignEfdmaxFromExcIEEEST2ACommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcIEEEST2A
   *
   * @param command AssignKaToExcIEEEST2ACommand
   */
  public void validate(AssignKaToExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(), "AssignKaToExcIEEEST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcIEEEST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcIEEEST2A
   *
   * @param command UnAssignKaFromExcIEEEST2ACommand
   */
  public void validate(UnAssignKaFromExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "UnAssignKaFromExcIEEEST2ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcIEEEST2A
   *
   * @param command AssignKcToExcIEEEST2ACommand
   */
  public void validate(AssignKcToExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(), "AssignKcToExcIEEEST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcIEEEST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcIEEEST2A
   *
   * @param command UnAssignKcFromExcIEEEST2ACommand
   */
  public void validate(UnAssignKcFromExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "UnAssignKcFromExcIEEEST2ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcIEEEST2A
   *
   * @param command AssignKeToExcIEEEST2ACommand
   */
  public void validate(AssignKeToExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(), "AssignKeToExcIEEEST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcIEEEST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcIEEEST2A
   *
   * @param command UnAssignKeFromExcIEEEST2ACommand
   */
  public void validate(UnAssignKeFromExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "UnAssignKeFromExcIEEEST2ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcIEEEST2A
   *
   * @param command AssignKfToExcIEEEST2ACommand
   */
  public void validate(AssignKfToExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(), "AssignKfToExcIEEEST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcIEEEST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcIEEEST2A
   *
   * @param command UnAssignKfFromExcIEEEST2ACommand
   */
  public void validate(UnAssignKfFromExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "UnAssignKfFromExcIEEEST2ACommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a ExcIEEEST2A
   *
   * @param command AssignKiToExcIEEEST2ACommand
   */
  public void validate(AssignKiToExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKiToExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(), "AssignKiToExcIEEEST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToExcIEEEST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a ExcIEEEST2A
   *
   * @param command UnAssignKiFromExcIEEEST2ACommand
   */
  public void validate(UnAssignKiFromExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "UnAssignKiFromExcIEEEST2ACommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a ExcIEEEST2A
   *
   * @param command AssignKpToExcIEEEST2ACommand
   */
  public void validate(AssignKpToExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKpToExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(), "AssignKpToExcIEEEST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToExcIEEEST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a ExcIEEEST2A
   *
   * @param command UnAssignKpFromExcIEEEST2ACommand
   */
  public void validate(UnAssignKpFromExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "UnAssignKpFromExcIEEEST2ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcIEEEST2A
   *
   * @param command AssignTaToExcIEEEST2ACommand
   */
  public void validate(AssignTaToExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(), "AssignTaToExcIEEEST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcIEEEST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcIEEEST2A
   *
   * @param command UnAssignTaFromExcIEEEST2ACommand
   */
  public void validate(UnAssignTaFromExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "UnAssignTaFromExcIEEEST2ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcIEEEST2A
   *
   * @param command AssignTeToExcIEEEST2ACommand
   */
  public void validate(AssignTeToExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(), "AssignTeToExcIEEEST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcIEEEST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcIEEEST2A
   *
   * @param command UnAssignTeFromExcIEEEST2ACommand
   */
  public void validate(UnAssignTeFromExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "UnAssignTeFromExcIEEEST2ACommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcIEEEST2A
   *
   * @param command AssignTfToExcIEEEST2ACommand
   */
  public void validate(AssignTfToExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(), "AssignTfToExcIEEEST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcIEEEST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcIEEEST2A
   *
   * @param command UnAssignTfFromExcIEEEST2ACommand
   */
  public void validate(UnAssignTfFromExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "UnAssignTfFromExcIEEEST2ACommand identifier should not be null");
  }
  /**
   * handles assign Uelin validation for a ExcIEEEST2A
   *
   * @param command AssignUelinToExcIEEEST2ACommand
   */
  public void validate(AssignUelinToExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignUelinToExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "AssignUelinToExcIEEEST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUelinToExcIEEEST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Uelin validation for a ExcIEEEST2A
   *
   * @param command UnAssignUelinFromExcIEEEST2ACommand
   */
  public void validate(UnAssignUelinFromExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignUelinFromExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "UnAssignUelinFromExcIEEEST2ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEST2A
   *
   * @param command AssignVrmaxToExcIEEEST2ACommand
   */
  public void validate(AssignVrmaxToExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "AssignVrmaxToExcIEEEST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEST2A
   *
   * @param command UnAssignVrmaxFromExcIEEEST2ACommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "UnAssignVrmaxFromExcIEEEST2ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEST2A
   *
   * @param command AssignVrminToExcIEEEST2ACommand
   */
  public void validate(AssignVrminToExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "AssignVrminToExcIEEEST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEST2A
   *
   * @param command UnAssignVrminFromExcIEEEST2ACommand
   */
  public void validate(UnAssignVrminFromExcIEEEST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEST2ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST2AId(),
        "UnAssignVrminFromExcIEEEST2ACommand identifier should not be null");
  }
}
