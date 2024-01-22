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

public class ExcIEEEST3AValidator {

  /** default constructor */
  protected ExcIEEEST3AValidator() {}

  /** factory method */
  public static ExcIEEEST3AValidator getInstance() {
    return new ExcIEEEST3AValidator();
  }

  /** handles creation validation for a ExcIEEEST3A */
  public void validate(CreateExcIEEEST3ACommand excIEEEST3A) throws Exception {
    Assert.notNull(excIEEEST3A, "CreateExcIEEEST3ACommand should not be null");
    //		Assert.isNull( excIEEEST3A.getExcIEEEST3AId(), "CreateExcIEEEST3ACommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEST3A */
  public void validate(UpdateExcIEEEST3ACommand excIEEEST3A) throws Exception {
    Assert.notNull(excIEEEST3A, "UpdateExcIEEEST3ACommand should not be null");
    Assert.notNull(
        excIEEEST3A.getExcIEEEST3AId(), "UpdateExcIEEEST3ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEST3A */
  public void validate(DeleteExcIEEEST3ACommand excIEEEST3A) throws Exception {
    Assert.notNull(excIEEEST3A, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEST3A.getExcIEEEST3AId(), "DeleteExcIEEEST3ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEST3A */
  public void validate(ExcIEEEST3AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEST3AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEST3AId(), "ExcIEEEST3AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ka validation for a ExcIEEEST3A
   *
   * @param command AssignKaToExcIEEEST3ACommand
   */
  public void validate(AssignKaToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(), "AssignKaToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcIEEEST3A
   *
   * @param command UnAssignKaFromExcIEEEST3ACommand
   */
  public void validate(UnAssignKaFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignKaFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcIEEEST3A
   *
   * @param command AssignKcToExcIEEEST3ACommand
   */
  public void validate(AssignKcToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(), "AssignKcToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcIEEEST3A
   *
   * @param command UnAssignKcFromExcIEEEST3ACommand
   */
  public void validate(UnAssignKcFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignKcFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Kg validation for a ExcIEEEST3A
   *
   * @param command AssignKgToExcIEEEST3ACommand
   */
  public void validate(AssignKgToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKgToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(), "AssignKgToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKgToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kg validation for a ExcIEEEST3A
   *
   * @param command UnAssignKgFromExcIEEEST3ACommand
   */
  public void validate(UnAssignKgFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKgFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignKgFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a ExcIEEEST3A
   *
   * @param command AssignKiToExcIEEEST3ACommand
   */
  public void validate(AssignKiToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKiToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(), "AssignKiToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a ExcIEEEST3A
   *
   * @param command UnAssignKiFromExcIEEEST3ACommand
   */
  public void validate(UnAssignKiFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignKiFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Km validation for a ExcIEEEST3A
   *
   * @param command AssignKmToExcIEEEST3ACommand
   */
  public void validate(AssignKmToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKmToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(), "AssignKmToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKmToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Km validation for a ExcIEEEST3A
   *
   * @param command UnAssignKmFromExcIEEEST3ACommand
   */
  public void validate(UnAssignKmFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKmFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignKmFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a ExcIEEEST3A
   *
   * @param command AssignKpToExcIEEEST3ACommand
   */
  public void validate(AssignKpToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKpToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(), "AssignKpToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a ExcIEEEST3A
   *
   * @param command UnAssignKpFromExcIEEEST3ACommand
   */
  public void validate(UnAssignKpFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignKpFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcIEEEST3A
   *
   * @param command AssignTaToExcIEEEST3ACommand
   */
  public void validate(AssignTaToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(), "AssignTaToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcIEEEST3A
   *
   * @param command UnAssignTaFromExcIEEEST3ACommand
   */
  public void validate(UnAssignTaFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignTaFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcIEEEST3A
   *
   * @param command AssignTbToExcIEEEST3ACommand
   */
  public void validate(AssignTbToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(), "AssignTbToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcIEEEST3A
   *
   * @param command UnAssignTbFromExcIEEEST3ACommand
   */
  public void validate(UnAssignTbFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignTbFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcIEEEST3A
   *
   * @param command AssignTcToExcIEEEST3ACommand
   */
  public void validate(AssignTcToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(), "AssignTcToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcIEEEST3A
   *
   * @param command UnAssignTcFromExcIEEEST3ACommand
   */
  public void validate(UnAssignTcFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignTcFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Thetap validation for a ExcIEEEST3A
   *
   * @param command AssignThetapToExcIEEEST3ACommand
   */
  public void validate(AssignThetapToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignThetapToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "AssignThetapToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignThetapToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Thetap validation for a ExcIEEEST3A
   *
   * @param command UnAssignThetapFromExcIEEEST3ACommand
   */
  public void validate(UnAssignThetapFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignThetapFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignThetapFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Tm validation for a ExcIEEEST3A
   *
   * @param command AssignTmToExcIEEEST3ACommand
   */
  public void validate(AssignTmToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTmToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(), "AssignTmToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTmToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Tm validation for a ExcIEEEST3A
   *
   * @param command UnAssignTmFromExcIEEEST3ACommand
   */
  public void validate(UnAssignTmFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTmFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignTmFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Vbmax validation for a ExcIEEEST3A
   *
   * @param command AssignVbmaxToExcIEEEST3ACommand
   */
  public void validate(AssignVbmaxToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVbmaxToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "AssignVbmaxToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVbmaxToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vbmax validation for a ExcIEEEST3A
   *
   * @param command UnAssignVbmaxFromExcIEEEST3ACommand
   */
  public void validate(UnAssignVbmaxFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVbmaxFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignVbmaxFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Vgmax validation for a ExcIEEEST3A
   *
   * @param command AssignVgmaxToExcIEEEST3ACommand
   */
  public void validate(AssignVgmaxToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVgmaxToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "AssignVgmaxToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVgmaxToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vgmax validation for a ExcIEEEST3A
   *
   * @param command UnAssignVgmaxFromExcIEEEST3ACommand
   */
  public void validate(UnAssignVgmaxFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVgmaxFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignVgmaxFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Vimax validation for a ExcIEEEST3A
   *
   * @param command AssignVimaxToExcIEEEST3ACommand
   */
  public void validate(AssignVimaxToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVimaxToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "AssignVimaxToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVimaxToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vimax validation for a ExcIEEEST3A
   *
   * @param command UnAssignVimaxFromExcIEEEST3ACommand
   */
  public void validate(UnAssignVimaxFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVimaxFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignVimaxFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Vimin validation for a ExcIEEEST3A
   *
   * @param command AssignViminToExcIEEEST3ACommand
   */
  public void validate(AssignViminToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignViminToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "AssignViminToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignViminToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vimin validation for a ExcIEEEST3A
   *
   * @param command UnAssignViminFromExcIEEEST3ACommand
   */
  public void validate(UnAssignViminFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignViminFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignViminFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Vmmax validation for a ExcIEEEST3A
   *
   * @param command AssignVmmaxToExcIEEEST3ACommand
   */
  public void validate(AssignVmmaxToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVmmaxToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "AssignVmmaxToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmmaxToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vmmax validation for a ExcIEEEST3A
   *
   * @param command UnAssignVmmaxFromExcIEEEST3ACommand
   */
  public void validate(UnAssignVmmaxFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVmmaxFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignVmmaxFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Vmmin validation for a ExcIEEEST3A
   *
   * @param command AssignVmminToExcIEEEST3ACommand
   */
  public void validate(AssignVmminToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVmminToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "AssignVmminToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmminToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vmmin validation for a ExcIEEEST3A
   *
   * @param command UnAssignVmminFromExcIEEEST3ACommand
   */
  public void validate(UnAssignVmminFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVmminFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignVmminFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEST3A
   *
   * @param command AssignVrmaxToExcIEEEST3ACommand
   */
  public void validate(AssignVrmaxToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "AssignVrmaxToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEST3A
   *
   * @param command UnAssignVrmaxFromExcIEEEST3ACommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignVrmaxFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEST3A
   *
   * @param command AssignVrminToExcIEEEST3ACommand
   */
  public void validate(AssignVrminToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "AssignVrminToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEST3A
   *
   * @param command UnAssignVrminFromExcIEEEST3ACommand
   */
  public void validate(UnAssignVrminFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignVrminFromExcIEEEST3ACommand identifier should not be null");
  }
  /**
   * handles assign Xl validation for a ExcIEEEST3A
   *
   * @param command AssignXlToExcIEEEST3ACommand
   */
  public void validate(AssignXlToExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignXlToExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(), "AssignXlToExcIEEEST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXlToExcIEEEST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Xl validation for a ExcIEEEST3A
   *
   * @param command UnAssignXlFromExcIEEEST3ACommand
   */
  public void validate(UnAssignXlFromExcIEEEST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignXlFromExcIEEEST3ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST3AId(),
        "UnAssignXlFromExcIEEEST3ACommand identifier should not be null");
  }
}
