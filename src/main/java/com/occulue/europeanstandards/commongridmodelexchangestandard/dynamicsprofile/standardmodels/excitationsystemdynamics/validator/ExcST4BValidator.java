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

public class ExcST4BValidator {

  /** default constructor */
  protected ExcST4BValidator() {}

  /** factory method */
  public static ExcST4BValidator getInstance() {
    return new ExcST4BValidator();
  }

  /** handles creation validation for a ExcST4B */
  public void validate(CreateExcST4BCommand excST4B) throws Exception {
    Assert.notNull(excST4B, "CreateExcST4BCommand should not be null");
    //		Assert.isNull( excST4B.getExcST4BId(), "CreateExcST4BCommand identifier should be null" );
  }

  /** handles update validation for a ExcST4B */
  public void validate(UpdateExcST4BCommand excST4B) throws Exception {
    Assert.notNull(excST4B, "UpdateExcST4BCommand should not be null");
    Assert.notNull(excST4B.getExcST4BId(), "UpdateExcST4BCommand identifier should not be null");
  }

  /** handles delete validation for a ExcST4B */
  public void validate(DeleteExcST4BCommand excST4B) throws Exception {
    Assert.notNull(excST4B, "{commandAlias} should not be null");
    Assert.notNull(excST4B.getExcST4BId(), "DeleteExcST4BCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcST4B */
  public void validate(ExcST4BFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcST4BFetchOneSummary should not be null");
    Assert.notNull(summary.getExcST4BId(), "ExcST4BFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Kc validation for a ExcST4B
   *
   * @param command AssignKcToExcST4BCommand
   */
  public void validate(AssignKcToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignKcToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcST4B
   *
   * @param command UnAssignKcFromExcST4BCommand
   */
  public void validate(UnAssignKcFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignKcFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Kg validation for a ExcST4B
   *
   * @param command AssignKgToExcST4BCommand
   */
  public void validate(AssignKgToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKgToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignKgToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKgToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kg validation for a ExcST4B
   *
   * @param command UnAssignKgFromExcST4BCommand
   */
  public void validate(UnAssignKgFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKgFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignKgFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a ExcST4B
   *
   * @param command AssignKiToExcST4BCommand
   */
  public void validate(AssignKiToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKiToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignKiToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a ExcST4B
   *
   * @param command UnAssignKiFromExcST4BCommand
   */
  public void validate(UnAssignKiFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignKiFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Kim validation for a ExcST4B
   *
   * @param command AssignKimToExcST4BCommand
   */
  public void validate(AssignKimToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKimToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignKimToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKimToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kim validation for a ExcST4B
   *
   * @param command UnAssignKimFromExcST4BCommand
   */
  public void validate(UnAssignKimFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKimFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignKimFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Kir validation for a ExcST4B
   *
   * @param command AssignKirToExcST4BCommand
   */
  public void validate(AssignKirToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKirToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignKirToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKirToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kir validation for a ExcST4B
   *
   * @param command UnAssignKirFromExcST4BCommand
   */
  public void validate(UnAssignKirFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKirFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignKirFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a ExcST4B
   *
   * @param command AssignKpToExcST4BCommand
   */
  public void validate(AssignKpToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKpToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignKpToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a ExcST4B
   *
   * @param command UnAssignKpFromExcST4BCommand
   */
  public void validate(UnAssignKpFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignKpFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Kpm validation for a ExcST4B
   *
   * @param command AssignKpmToExcST4BCommand
   */
  public void validate(AssignKpmToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKpmToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignKpmToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpmToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kpm validation for a ExcST4B
   *
   * @param command UnAssignKpmFromExcST4BCommand
   */
  public void validate(UnAssignKpmFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpmFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignKpmFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Kpr validation for a ExcST4B
   *
   * @param command AssignKprToExcST4BCommand
   */
  public void validate(AssignKprToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignKprToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignKprToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKprToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Kpr validation for a ExcST4B
   *
   * @param command UnAssignKprFromExcST4BCommand
   */
  public void validate(UnAssignKprFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKprFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignKprFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Lvgate validation for a ExcST4B
   *
   * @param command AssignLvgateToExcST4BCommand
   */
  public void validate(AssignLvgateToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignLvgateToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignLvgateToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLvgateToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Lvgate validation for a ExcST4B
   *
   * @param command UnAssignLvgateFromExcST4BCommand
   */
  public void validate(UnAssignLvgateFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLvgateFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignLvgateFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcST4B
   *
   * @param command AssignTaToExcST4BCommand
   */
  public void validate(AssignTaToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignTaToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcST4B
   *
   * @param command UnAssignTaFromExcST4BCommand
   */
  public void validate(UnAssignTaFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignTaFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Thetap validation for a ExcST4B
   *
   * @param command AssignThetapToExcST4BCommand
   */
  public void validate(AssignThetapToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignThetapToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignThetapToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignThetapToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Thetap validation for a ExcST4B
   *
   * @param command UnAssignThetapFromExcST4BCommand
   */
  public void validate(UnAssignThetapFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignThetapFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignThetapFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Uel validation for a ExcST4B
   *
   * @param command AssignUelToExcST4BCommand
   */
  public void validate(AssignUelToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignUelToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignUelToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUelToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Uel validation for a ExcST4B
   *
   * @param command UnAssignUelFromExcST4BCommand
   */
  public void validate(UnAssignUelFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUelFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignUelFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Vbmax validation for a ExcST4B
   *
   * @param command AssignVbmaxToExcST4BCommand
   */
  public void validate(AssignVbmaxToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVbmaxToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignVbmaxToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVbmaxToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vbmax validation for a ExcST4B
   *
   * @param command UnAssignVbmaxFromExcST4BCommand
   */
  public void validate(UnAssignVbmaxFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVbmaxFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignVbmaxFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Vgmax validation for a ExcST4B
   *
   * @param command AssignVgmaxToExcST4BCommand
   */
  public void validate(AssignVgmaxToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVgmaxToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignVgmaxToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVgmaxToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vgmax validation for a ExcST4B
   *
   * @param command UnAssignVgmaxFromExcST4BCommand
   */
  public void validate(UnAssignVgmaxFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVgmaxFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignVgmaxFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Vmmax validation for a ExcST4B
   *
   * @param command AssignVmmaxToExcST4BCommand
   */
  public void validate(AssignVmmaxToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVmmaxToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignVmmaxToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmmaxToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vmmax validation for a ExcST4B
   *
   * @param command UnAssignVmmaxFromExcST4BCommand
   */
  public void validate(UnAssignVmmaxFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVmmaxFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignVmmaxFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Vmmin validation for a ExcST4B
   *
   * @param command AssignVmminToExcST4BCommand
   */
  public void validate(AssignVmminToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVmminToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignVmminToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmminToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vmmin validation for a ExcST4B
   *
   * @param command UnAssignVmminFromExcST4BCommand
   */
  public void validate(UnAssignVmminFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVmminFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignVmminFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcST4B
   *
   * @param command AssignVrmaxToExcST4BCommand
   */
  public void validate(AssignVrmaxToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignVrmaxToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcST4B
   *
   * @param command UnAssignVrmaxFromExcST4BCommand
   */
  public void validate(UnAssignVrmaxFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignVrmaxFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcST4B
   *
   * @param command AssignVrminToExcST4BCommand
   */
  public void validate(AssignVrminToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignVrminToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcST4B
   *
   * @param command UnAssignVrminFromExcST4BCommand
   */
  public void validate(UnAssignVrminFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignVrminFromExcST4BCommand identifier should not be null");
  }
  /**
   * handles assign Xl validation for a ExcST4B
   *
   * @param command AssignXlToExcST4BCommand
   */
  public void validate(AssignXlToExcST4BCommand command) throws Exception {
    Assert.notNull(command, "AssignXlToExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "AssignXlToExcST4BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXlToExcST4BCommand assignment should not be null");
  }

  /**
   * handles unassign Xl validation for a ExcST4B
   *
   * @param command UnAssignXlFromExcST4BCommand
   */
  public void validate(UnAssignXlFromExcST4BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXlFromExcST4BCommand should not be null");
    Assert.notNull(
        command.getExcST4BId(), "UnAssignXlFromExcST4BCommand identifier should not be null");
  }
}
