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

public class ExcST2AValidator {

  /** default constructor */
  protected ExcST2AValidator() {}

  /** factory method */
  public static ExcST2AValidator getInstance() {
    return new ExcST2AValidator();
  }

  /** handles creation validation for a ExcST2A */
  public void validate(CreateExcST2ACommand excST2A) throws Exception {
    Assert.notNull(excST2A, "CreateExcST2ACommand should not be null");
    //		Assert.isNull( excST2A.getExcST2AId(), "CreateExcST2ACommand identifier should be null" );
  }

  /** handles update validation for a ExcST2A */
  public void validate(UpdateExcST2ACommand excST2A) throws Exception {
    Assert.notNull(excST2A, "UpdateExcST2ACommand should not be null");
    Assert.notNull(excST2A.getExcST2AId(), "UpdateExcST2ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcST2A */
  public void validate(DeleteExcST2ACommand excST2A) throws Exception {
    Assert.notNull(excST2A, "{commandAlias} should not be null");
    Assert.notNull(excST2A.getExcST2AId(), "DeleteExcST2ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcST2A */
  public void validate(ExcST2AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcST2AFetchOneSummary should not be null");
    Assert.notNull(summary.getExcST2AId(), "ExcST2AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efdmax validation for a ExcST2A
   *
   * @param command AssignEfdmaxToExcST2ACommand
   */
  public void validate(AssignEfdmaxToExcST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfdmaxToExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "AssignEfdmaxToExcST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdmaxToExcST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Efdmax validation for a ExcST2A
   *
   * @param command UnAssignEfdmaxFromExcST2ACommand
   */
  public void validate(UnAssignEfdmaxFromExcST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdmaxFromExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "UnAssignEfdmaxFromExcST2ACommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcST2A
   *
   * @param command AssignKaToExcST2ACommand
   */
  public void validate(AssignKaToExcST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "AssignKaToExcST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcST2A
   *
   * @param command UnAssignKaFromExcST2ACommand
   */
  public void validate(UnAssignKaFromExcST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "UnAssignKaFromExcST2ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcST2A
   *
   * @param command AssignKcToExcST2ACommand
   */
  public void validate(AssignKcToExcST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "AssignKcToExcST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcST2A
   *
   * @param command UnAssignKcFromExcST2ACommand
   */
  public void validate(UnAssignKcFromExcST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "UnAssignKcFromExcST2ACommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcST2A
   *
   * @param command AssignKeToExcST2ACommand
   */
  public void validate(AssignKeToExcST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "AssignKeToExcST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcST2A
   *
   * @param command UnAssignKeFromExcST2ACommand
   */
  public void validate(UnAssignKeFromExcST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "UnAssignKeFromExcST2ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcST2A
   *
   * @param command AssignKfToExcST2ACommand
   */
  public void validate(AssignKfToExcST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "AssignKfToExcST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcST2A
   *
   * @param command UnAssignKfFromExcST2ACommand
   */
  public void validate(UnAssignKfFromExcST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "UnAssignKfFromExcST2ACommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a ExcST2A
   *
   * @param command AssignKiToExcST2ACommand
   */
  public void validate(AssignKiToExcST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKiToExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "AssignKiToExcST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToExcST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a ExcST2A
   *
   * @param command UnAssignKiFromExcST2ACommand
   */
  public void validate(UnAssignKiFromExcST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "UnAssignKiFromExcST2ACommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a ExcST2A
   *
   * @param command AssignKpToExcST2ACommand
   */
  public void validate(AssignKpToExcST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignKpToExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "AssignKpToExcST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToExcST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a ExcST2A
   *
   * @param command UnAssignKpFromExcST2ACommand
   */
  public void validate(UnAssignKpFromExcST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "UnAssignKpFromExcST2ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcST2A
   *
   * @param command AssignTaToExcST2ACommand
   */
  public void validate(AssignTaToExcST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "AssignTaToExcST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcST2A
   *
   * @param command UnAssignTaFromExcST2ACommand
   */
  public void validate(UnAssignTaFromExcST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "UnAssignTaFromExcST2ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcST2A
   *
   * @param command AssignTbToExcST2ACommand
   */
  public void validate(AssignTbToExcST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "AssignTbToExcST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcST2A
   *
   * @param command UnAssignTbFromExcST2ACommand
   */
  public void validate(UnAssignTbFromExcST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "UnAssignTbFromExcST2ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcST2A
   *
   * @param command AssignTcToExcST2ACommand
   */
  public void validate(AssignTcToExcST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "AssignTcToExcST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcST2A
   *
   * @param command UnAssignTcFromExcST2ACommand
   */
  public void validate(UnAssignTcFromExcST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "UnAssignTcFromExcST2ACommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcST2A
   *
   * @param command AssignTeToExcST2ACommand
   */
  public void validate(AssignTeToExcST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "AssignTeToExcST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcST2A
   *
   * @param command UnAssignTeFromExcST2ACommand
   */
  public void validate(UnAssignTeFromExcST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "UnAssignTeFromExcST2ACommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcST2A
   *
   * @param command AssignTfToExcST2ACommand
   */
  public void validate(AssignTfToExcST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "AssignTfToExcST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcST2A
   *
   * @param command UnAssignTfFromExcST2ACommand
   */
  public void validate(UnAssignTfFromExcST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "UnAssignTfFromExcST2ACommand identifier should not be null");
  }
  /**
   * handles assign Uelin validation for a ExcST2A
   *
   * @param command AssignUelinToExcST2ACommand
   */
  public void validate(AssignUelinToExcST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignUelinToExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "AssignUelinToExcST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUelinToExcST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Uelin validation for a ExcST2A
   *
   * @param command UnAssignUelinFromExcST2ACommand
   */
  public void validate(UnAssignUelinFromExcST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignUelinFromExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "UnAssignUelinFromExcST2ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcST2A
   *
   * @param command AssignVrmaxToExcST2ACommand
   */
  public void validate(AssignVrmaxToExcST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "AssignVrmaxToExcST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcST2A
   *
   * @param command UnAssignVrmaxFromExcST2ACommand
   */
  public void validate(UnAssignVrmaxFromExcST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "UnAssignVrmaxFromExcST2ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcST2A
   *
   * @param command AssignVrminToExcST2ACommand
   */
  public void validate(AssignVrminToExcST2ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "AssignVrminToExcST2ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcST2ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcST2A
   *
   * @param command UnAssignVrminFromExcST2ACommand
   */
  public void validate(UnAssignVrminFromExcST2ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcST2ACommand should not be null");
    Assert.notNull(
        command.getExcST2AId(), "UnAssignVrminFromExcST2ACommand identifier should not be null");
  }
}
