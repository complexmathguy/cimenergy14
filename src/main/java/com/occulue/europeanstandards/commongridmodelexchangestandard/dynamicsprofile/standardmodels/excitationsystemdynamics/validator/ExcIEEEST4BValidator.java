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

public class ExcIEEEST4BValidator {

  /** default constructor */
  protected ExcIEEEST4BValidator() {}

  /** factory method */
  public static ExcIEEEST4BValidator getInstance() {
    return new ExcIEEEST4BValidator();
  }

  /** handles creation validation for a ExcIEEEST4B */
  public void validate(CreateExcIEEEST4BCommand excIEEEST4B) throws Exception {
    Assert.notNull(excIEEEST4B, "CreateExcIEEEST4BCommand should not be null");
    //		Assert.isNull( excIEEEST4B.getExcIEEEST4BId(), "CreateExcIEEEST4BCommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEST4B */
  public void validate(UpdateExcIEEEST4BCommand excIEEEST4B) throws Exception {
    Assert.notNull(excIEEEST4B, "UpdateExcIEEEST4BCommand should not be null");
    Assert.notNull(
        excIEEEST4B.getExcIEEEST4BId(), "UpdateExcIEEEST4BCommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEST4B */
  public void validate(DeleteExcIEEEST4BCommand excIEEEST4B) throws Exception {
    Assert.notNull(excIEEEST4B, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEST4B.getExcIEEEST4BId(), "DeleteExcIEEEST4BCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEST4B */
  public void validate(ExcIEEEST4BFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEST4BFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEST4BId(), "ExcIEEEST4BFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Kc validation for a ExcIEEEST4B
   *
   * @param command AssignKcToExcIEEEST4BCommand
   */
  public void validate(AssignKcToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(), "AssignKcToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcIEEEST4B
   *
   * @param command UnAssignKcFromExcIEEEST4BCommand
   */
  public void validate(UnAssignKcFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignKcFromExcIEEEST4BCommand identifier should not be null");
  }
  /**
   * handles assign Kg validation for a ExcIEEEST4B
   *
   * @param command AssignKgToExcIEEEST4BCommand
   */
  public void validate(AssignKgToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKgToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(), "AssignKgToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKgToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kg validation for a ExcIEEEST4B
   *
   * @param command UnAssignKgFromExcIEEEST4BCommand
   */
  public void validate(UnAssignKgFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKgFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignKgFromExcIEEEST4BCommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a ExcIEEEST4B
   *
   * @param command AssignKiToExcIEEEST4BCommand
   */
  public void validate(AssignKiToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKiToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(), "AssignKiToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a ExcIEEEST4B
   *
   * @param command UnAssignKiFromExcIEEEST4BCommand
   */
  public void validate(UnAssignKiFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignKiFromExcIEEEST4BCommand identifier should not be null");
  }
  /**
   * handles assign Kim validation for a ExcIEEEST4B
   *
   * @param command AssignKimToExcIEEEST4BCommand
   */
  public void validate(AssignKimToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKimToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(), "AssignKimToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKimToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kim validation for a ExcIEEEST4B
   *
   * @param command UnAssignKimFromExcIEEEST4BCommand
   */
  public void validate(UnAssignKimFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKimFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignKimFromExcIEEEST4BCommand identifier should not be null");
  }
  /**
   * handles assign Kir validation for a ExcIEEEST4B
   *
   * @param command AssignKirToExcIEEEST4BCommand
   */
  public void validate(AssignKirToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKirToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(), "AssignKirToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKirToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kir validation for a ExcIEEEST4B
   *
   * @param command UnAssignKirFromExcIEEEST4BCommand
   */
  public void validate(UnAssignKirFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKirFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignKirFromExcIEEEST4BCommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a ExcIEEEST4B
   *
   * @param command AssignKpToExcIEEEST4BCommand
   */
  public void validate(AssignKpToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKpToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(), "AssignKpToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a ExcIEEEST4B
   *
   * @param command UnAssignKpFromExcIEEEST4BCommand
   */
  public void validate(UnAssignKpFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignKpFromExcIEEEST4BCommand identifier should not be null");
  }
  /**
   * handles assign Kpm validation for a ExcIEEEST4B
   *
   * @param command AssignKpmToExcIEEEST4BCommand
   */
  public void validate(AssignKpmToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKpmToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(), "AssignKpmToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpmToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kpm validation for a ExcIEEEST4B
   *
   * @param command UnAssignKpmFromExcIEEEST4BCommand
   */
  public void validate(UnAssignKpmFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpmFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignKpmFromExcIEEEST4BCommand identifier should not be null");
  }
  /**
   * handles assign Kpr validation for a ExcIEEEST4B
   *
   * @param command AssignKprToExcIEEEST4BCommand
   */
  public void validate(AssignKprToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKprToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(), "AssignKprToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKprToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kpr validation for a ExcIEEEST4B
   *
   * @param command UnAssignKprFromExcIEEEST4BCommand
   */
  public void validate(UnAssignKprFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKprFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignKprFromExcIEEEST4BCommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcIEEEST4B
   *
   * @param command AssignTaToExcIEEEST4BCommand
   */
  public void validate(AssignTaToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(), "AssignTaToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcIEEEST4B
   *
   * @param command UnAssignTaFromExcIEEEST4BCommand
   */
  public void validate(UnAssignTaFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignTaFromExcIEEEST4BCommand identifier should not be null");
  }
  /**
   * handles assign Thetap validation for a ExcIEEEST4B
   *
   * @param command AssignThetapToExcIEEEST4BCommand
   */
  public void validate(AssignThetapToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignThetapToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "AssignThetapToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignThetapToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Thetap validation for a ExcIEEEST4B
   *
   * @param command UnAssignThetapFromExcIEEEST4BCommand
   */
  public void validate(UnAssignThetapFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignThetapFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignThetapFromExcIEEEST4BCommand identifier should not be null");
  }
  /**
   * handles assign Vbmax validation for a ExcIEEEST4B
   *
   * @param command AssignVbmaxToExcIEEEST4BCommand
   */
  public void validate(AssignVbmaxToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVbmaxToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "AssignVbmaxToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVbmaxToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vbmax validation for a ExcIEEEST4B
   *
   * @param command UnAssignVbmaxFromExcIEEEST4BCommand
   */
  public void validate(UnAssignVbmaxFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVbmaxFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignVbmaxFromExcIEEEST4BCommand identifier should not be null");
  }
  /**
   * handles assign Vmmax validation for a ExcIEEEST4B
   *
   * @param command AssignVmmaxToExcIEEEST4BCommand
   */
  public void validate(AssignVmmaxToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVmmaxToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "AssignVmmaxToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmmaxToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vmmax validation for a ExcIEEEST4B
   *
   * @param command UnAssignVmmaxFromExcIEEEST4BCommand
   */
  public void validate(UnAssignVmmaxFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVmmaxFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignVmmaxFromExcIEEEST4BCommand identifier should not be null");
  }
  /**
   * handles assign Vmmin validation for a ExcIEEEST4B
   *
   * @param command AssignVmminToExcIEEEST4BCommand
   */
  public void validate(AssignVmminToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVmminToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "AssignVmminToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmminToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vmmin validation for a ExcIEEEST4B
   *
   * @param command UnAssignVmminFromExcIEEEST4BCommand
   */
  public void validate(UnAssignVmminFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVmminFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignVmminFromExcIEEEST4BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEST4B
   *
   * @param command AssignVrmaxToExcIEEEST4BCommand
   */
  public void validate(AssignVrmaxToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "AssignVrmaxToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEST4B
   *
   * @param command UnAssignVrmaxFromExcIEEEST4BCommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignVrmaxFromExcIEEEST4BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEST4B
   *
   * @param command AssignVrminToExcIEEEST4BCommand
   */
  public void validate(AssignVrminToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "AssignVrminToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEST4B
   *
   * @param command UnAssignVrminFromExcIEEEST4BCommand
   */
  public void validate(UnAssignVrminFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignVrminFromExcIEEEST4BCommand identifier should not be null");
  }
  /**
   * handles assign Xl validation for a ExcIEEEST4B
   *
   * @param command AssignXlToExcIEEEST4BCommand
   */
  public void validate(AssignXlToExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignXlToExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(), "AssignXlToExcIEEEST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXlToExcIEEEST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Xl validation for a ExcIEEEST4B
   *
   * @param command UnAssignXlFromExcIEEEST4BCommand
   */
  public void validate(UnAssignXlFromExcIEEEST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXlFromExcIEEEST4BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST4BId(),
        "UnAssignXlFromExcIEEEST4BCommand identifier should not be null");
  }
}
