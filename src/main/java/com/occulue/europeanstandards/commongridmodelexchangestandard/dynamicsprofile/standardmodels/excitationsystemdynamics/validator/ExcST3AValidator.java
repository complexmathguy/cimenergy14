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

public class ExcST3AValidator {

  /** default constructor */
  protected ExcST3AValidator() {}

  /** factory method */
  public static ExcST3AValidator getInstance() {
    return new ExcST3AValidator();
  }

  /** handles creation validation for a ExcST3A */
  public void validate(CreateExcST3ACommand excST3A) throws Exception {
    Assert.notNull(excST3A, "CreateExcST3ACommand should not be null");
    //		Assert.isNull( excST3A.getExcST3AId(), "CreateExcST3ACommand identifier should be null" );
  }

  /** handles update validation for a ExcST3A */
  public void validate(UpdateExcST3ACommand excST3A) throws Exception {
    Assert.notNull(excST3A, "UpdateExcST3ACommand should not be null");
    Assert.notNull(excST3A.getExcST3AId(), "UpdateExcST3ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcST3A */
  public void validate(DeleteExcST3ACommand excST3A) throws Exception {
    Assert.notNull(excST3A, "{commandAlias} should not be null");
    Assert.notNull(excST3A.getExcST3AId(), "DeleteExcST3ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcST3A */
  public void validate(ExcST3AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcST3AFetchOneSummary should not be null");
    Assert.notNull(summary.getExcST3AId(), "ExcST3AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efdmax validation for a ExcST3A
   *
   * @param command AssignEfdmaxToExcST3ACommand
   */
  public void validate(AssignEfdmaxToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignEfdmaxToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignEfdmaxToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdmaxToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Efdmax validation for a ExcST3A
   *
   * @param command UnAssignEfdmaxFromExcST3ACommand
   */
  public void validate(UnAssignEfdmaxFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdmaxFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignEfdmaxFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcST3A
   *
   * @param command AssignKcToExcST3ACommand
   */
  public void validate(AssignKcToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignKcToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcST3A
   *
   * @param command UnAssignKcFromExcST3ACommand
   */
  public void validate(UnAssignKcFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignKcFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Kg validation for a ExcST3A
   *
   * @param command AssignKgToExcST3ACommand
   */
  public void validate(AssignKgToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKgToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignKgToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKgToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kg validation for a ExcST3A
   *
   * @param command UnAssignKgFromExcST3ACommand
   */
  public void validate(UnAssignKgFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKgFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignKgFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a ExcST3A
   *
   * @param command AssignKiToExcST3ACommand
   */
  public void validate(AssignKiToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKiToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignKiToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a ExcST3A
   *
   * @param command UnAssignKiFromExcST3ACommand
   */
  public void validate(UnAssignKiFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignKiFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Kj validation for a ExcST3A
   *
   * @param command AssignKjToExcST3ACommand
   */
  public void validate(AssignKjToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKjToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignKjToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKjToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kj validation for a ExcST3A
   *
   * @param command UnAssignKjFromExcST3ACommand
   */
  public void validate(UnAssignKjFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKjFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignKjFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Km validation for a ExcST3A
   *
   * @param command AssignKmToExcST3ACommand
   */
  public void validate(AssignKmToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKmToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignKmToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKmToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Km validation for a ExcST3A
   *
   * @param command UnAssignKmFromExcST3ACommand
   */
  public void validate(UnAssignKmFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKmFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignKmFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a ExcST3A
   *
   * @param command AssignKpToExcST3ACommand
   */
  public void validate(AssignKpToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKpToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignKpToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a ExcST3A
   *
   * @param command UnAssignKpFromExcST3ACommand
   */
  public void validate(UnAssignKpFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignKpFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Ks validation for a ExcST3A
   *
   * @param command AssignKsToExcST3ACommand
   */
  public void validate(AssignKsToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKsToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignKsToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKsToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ks validation for a ExcST3A
   *
   * @param command UnAssignKsFromExcST3ACommand
   */
  public void validate(UnAssignKsFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKsFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignKsFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Ks1 validation for a ExcST3A
   *
   * @param command AssignKs1ToExcST3ACommand
   */
  public void validate(AssignKs1ToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignKs1ToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignKs1ToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKs1ToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Ks1 validation for a ExcST3A
   *
   * @param command UnAssignKs1FromExcST3ACommand
   */
  public void validate(UnAssignKs1FromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKs1FromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignKs1FromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcST3A
   *
   * @param command AssignTbToExcST3ACommand
   */
  public void validate(AssignTbToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignTbToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcST3A
   *
   * @param command UnAssignTbFromExcST3ACommand
   */
  public void validate(UnAssignTbFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignTbFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcST3A
   *
   * @param command AssignTcToExcST3ACommand
   */
  public void validate(AssignTcToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignTcToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcST3A
   *
   * @param command UnAssignTcFromExcST3ACommand
   */
  public void validate(UnAssignTcFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignTcFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Thetap validation for a ExcST3A
   *
   * @param command AssignThetapToExcST3ACommand
   */
  public void validate(AssignThetapToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignThetapToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignThetapToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignThetapToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Thetap validation for a ExcST3A
   *
   * @param command UnAssignThetapFromExcST3ACommand
   */
  public void validate(UnAssignThetapFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignThetapFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignThetapFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Tm validation for a ExcST3A
   *
   * @param command AssignTmToExcST3ACommand
   */
  public void validate(AssignTmToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignTmToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignTmToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTmToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Tm validation for a ExcST3A
   *
   * @param command UnAssignTmFromExcST3ACommand
   */
  public void validate(UnAssignTmFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTmFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignTmFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Vbmax validation for a ExcST3A
   *
   * @param command AssignVbmaxToExcST3ACommand
   */
  public void validate(AssignVbmaxToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVbmaxToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignVbmaxToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVbmaxToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vbmax validation for a ExcST3A
   *
   * @param command UnAssignVbmaxFromExcST3ACommand
   */
  public void validate(UnAssignVbmaxFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVbmaxFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignVbmaxFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Vgmax validation for a ExcST3A
   *
   * @param command AssignVgmaxToExcST3ACommand
   */
  public void validate(AssignVgmaxToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVgmaxToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignVgmaxToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVgmaxToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vgmax validation for a ExcST3A
   *
   * @param command UnAssignVgmaxFromExcST3ACommand
   */
  public void validate(UnAssignVgmaxFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVgmaxFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignVgmaxFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Vimax validation for a ExcST3A
   *
   * @param command AssignVimaxToExcST3ACommand
   */
  public void validate(AssignVimaxToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVimaxToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignVimaxToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVimaxToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vimax validation for a ExcST3A
   *
   * @param command UnAssignVimaxFromExcST3ACommand
   */
  public void validate(UnAssignVimaxFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVimaxFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignVimaxFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Vimin validation for a ExcST3A
   *
   * @param command AssignViminToExcST3ACommand
   */
  public void validate(AssignViminToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignViminToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignViminToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignViminToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vimin validation for a ExcST3A
   *
   * @param command UnAssignViminFromExcST3ACommand
   */
  public void validate(UnAssignViminFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignViminFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignViminFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcST3A
   *
   * @param command AssignVrmaxToExcST3ACommand
   */
  public void validate(AssignVrmaxToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignVrmaxToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcST3A
   *
   * @param command UnAssignVrmaxFromExcST3ACommand
   */
  public void validate(UnAssignVrmaxFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignVrmaxFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcST3A
   *
   * @param command AssignVrminToExcST3ACommand
   */
  public void validate(AssignVrminToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignVrminToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcST3A
   *
   * @param command UnAssignVrminFromExcST3ACommand
   */
  public void validate(UnAssignVrminFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignVrminFromExcST3ACommand identifier should not be null");
  }
  /**
   * handles assign Xl validation for a ExcST3A
   *
   * @param command AssignXlToExcST3ACommand
   */
  public void validate(AssignXlToExcST3ACommand command) throws Exception {
    Assert.notNull(command, "AssignXlToExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "AssignXlToExcST3ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXlToExcST3ACommand assignment should not be null");
  }

  /**
   * handles unassign Xl validation for a ExcST3A
   *
   * @param command UnAssignXlFromExcST3ACommand
   */
  public void validate(UnAssignXlFromExcST3ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignXlFromExcST3ACommand should not be null");
    Assert.notNull(
        command.getExcST3AId(), "UnAssignXlFromExcST3ACommand identifier should not be null");
  }
}
