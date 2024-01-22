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

public class ExcIEEEST1AValidator {

  /** default constructor */
  protected ExcIEEEST1AValidator() {}

  /** factory method */
  public static ExcIEEEST1AValidator getInstance() {
    return new ExcIEEEST1AValidator();
  }

  /** handles creation validation for a ExcIEEEST1A */
  public void validate(CreateExcIEEEST1ACommand excIEEEST1A) throws Exception {
    Assert.notNull(excIEEEST1A, "CreateExcIEEEST1ACommand should not be null");
    //		Assert.isNull( excIEEEST1A.getExcIEEEST1AId(), "CreateExcIEEEST1ACommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEST1A */
  public void validate(UpdateExcIEEEST1ACommand excIEEEST1A) throws Exception {
    Assert.notNull(excIEEEST1A, "UpdateExcIEEEST1ACommand should not be null");
    Assert.notNull(
        excIEEEST1A.getExcIEEEST1AId(), "UpdateExcIEEEST1ACommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEST1A */
  public void validate(DeleteExcIEEEST1ACommand excIEEEST1A) throws Exception {
    Assert.notNull(excIEEEST1A, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEST1A.getExcIEEEST1AId(), "DeleteExcIEEEST1ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEST1A */
  public void validate(ExcIEEEST1AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEST1AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEST1AId(), "ExcIEEEST1AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ilr validation for a ExcIEEEST1A
   *
   * @param command AssignIlrToExcIEEEST1ACommand
   */
  public void validate(AssignIlrToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignIlrToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(), "AssignIlrToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIlrToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ilr validation for a ExcIEEEST1A
   *
   * @param command UnAssignIlrFromExcIEEEST1ACommand
   */
  public void validate(UnAssignIlrFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignIlrFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignIlrFromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcIEEEST1A
   *
   * @param command AssignKaToExcIEEEST1ACommand
   */
  public void validate(AssignKaToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(), "AssignKaToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcIEEEST1A
   *
   * @param command UnAssignKaFromExcIEEEST1ACommand
   */
  public void validate(UnAssignKaFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignKaFromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcIEEEST1A
   *
   * @param command AssignKcToExcIEEEST1ACommand
   */
  public void validate(AssignKcToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(), "AssignKcToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcIEEEST1A
   *
   * @param command UnAssignKcFromExcIEEEST1ACommand
   */
  public void validate(UnAssignKcFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignKcFromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcIEEEST1A
   *
   * @param command AssignKfToExcIEEEST1ACommand
   */
  public void validate(AssignKfToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(), "AssignKfToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcIEEEST1A
   *
   * @param command UnAssignKfFromExcIEEEST1ACommand
   */
  public void validate(UnAssignKfFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignKfFromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Klr validation for a ExcIEEEST1A
   *
   * @param command AssignKlrToExcIEEEST1ACommand
   */
  public void validate(AssignKlrToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKlrToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(), "AssignKlrToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKlrToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Klr validation for a ExcIEEEST1A
   *
   * @param command UnAssignKlrFromExcIEEEST1ACommand
   */
  public void validate(UnAssignKlrFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKlrFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignKlrFromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Pssin validation for a ExcIEEEST1A
   *
   * @param command AssignPssinToExcIEEEST1ACommand
   */
  public void validate(AssignPssinToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignPssinToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "AssignPssinToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPssinToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Pssin validation for a ExcIEEEST1A
   *
   * @param command UnAssignPssinFromExcIEEEST1ACommand
   */
  public void validate(UnAssignPssinFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignPssinFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignPssinFromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcIEEEST1A
   *
   * @param command AssignTaToExcIEEEST1ACommand
   */
  public void validate(AssignTaToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTaToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(), "AssignTaToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcIEEEST1A
   *
   * @param command UnAssignTaFromExcIEEEST1ACommand
   */
  public void validate(UnAssignTaFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignTaFromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcIEEEST1A
   *
   * @param command AssignTbToExcIEEEST1ACommand
   */
  public void validate(AssignTbToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(), "AssignTbToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcIEEEST1A
   *
   * @param command UnAssignTbFromExcIEEEST1ACommand
   */
  public void validate(UnAssignTbFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignTbFromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Tb1 validation for a ExcIEEEST1A
   *
   * @param command AssignTb1ToExcIEEEST1ACommand
   */
  public void validate(AssignTb1ToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTb1ToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(), "AssignTb1ToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTb1ToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tb1 validation for a ExcIEEEST1A
   *
   * @param command UnAssignTb1FromExcIEEEST1ACommand
   */
  public void validate(UnAssignTb1FromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTb1FromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignTb1FromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcIEEEST1A
   *
   * @param command AssignTcToExcIEEEST1ACommand
   */
  public void validate(AssignTcToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(), "AssignTcToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcIEEEST1A
   *
   * @param command UnAssignTcFromExcIEEEST1ACommand
   */
  public void validate(UnAssignTcFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignTcFromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Tc1 validation for a ExcIEEEST1A
   *
   * @param command AssignTc1ToExcIEEEST1ACommand
   */
  public void validate(AssignTc1ToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTc1ToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(), "AssignTc1ToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTc1ToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tc1 validation for a ExcIEEEST1A
   *
   * @param command UnAssignTc1FromExcIEEEST1ACommand
   */
  public void validate(UnAssignTc1FromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTc1FromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignTc1FromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcIEEEST1A
   *
   * @param command AssignTfToExcIEEEST1ACommand
   */
  public void validate(AssignTfToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(), "AssignTfToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcIEEEST1A
   *
   * @param command UnAssignTfFromExcIEEEST1ACommand
   */
  public void validate(UnAssignTfFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignTfFromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Vamax validation for a ExcIEEEST1A
   *
   * @param command AssignVamaxToExcIEEEST1ACommand
   */
  public void validate(AssignVamaxToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVamaxToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "AssignVamaxToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVamaxToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamax validation for a ExcIEEEST1A
   *
   * @param command UnAssignVamaxFromExcIEEEST1ACommand
   */
  public void validate(UnAssignVamaxFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVamaxFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignVamaxFromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Vamin validation for a ExcIEEEST1A
   *
   * @param command AssignVaminToExcIEEEST1ACommand
   */
  public void validate(AssignVaminToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVaminToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "AssignVaminToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVaminToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vamin validation for a ExcIEEEST1A
   *
   * @param command UnAssignVaminFromExcIEEEST1ACommand
   */
  public void validate(UnAssignVaminFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVaminFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignVaminFromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Vimax validation for a ExcIEEEST1A
   *
   * @param command AssignVimaxToExcIEEEST1ACommand
   */
  public void validate(AssignVimaxToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVimaxToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "AssignVimaxToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVimaxToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vimax validation for a ExcIEEEST1A
   *
   * @param command UnAssignVimaxFromExcIEEEST1ACommand
   */
  public void validate(UnAssignVimaxFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVimaxFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignVimaxFromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Vimin validation for a ExcIEEEST1A
   *
   * @param command AssignViminToExcIEEEST1ACommand
   */
  public void validate(AssignViminToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignViminToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "AssignViminToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignViminToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vimin validation for a ExcIEEEST1A
   *
   * @param command UnAssignViminFromExcIEEEST1ACommand
   */
  public void validate(UnAssignViminFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignViminFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignViminFromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEST1A
   *
   * @param command AssignVrmaxToExcIEEEST1ACommand
   */
  public void validate(AssignVrmaxToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "AssignVrmaxToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEST1A
   *
   * @param command UnAssignVrmaxFromExcIEEEST1ACommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignVrmaxFromExcIEEEST1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEST1A
   *
   * @param command AssignVrminToExcIEEEST1ACommand
   */
  public void validate(AssignVrminToExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "AssignVrminToExcIEEEST1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEST1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEST1A
   *
   * @param command UnAssignVrminFromExcIEEEST1ACommand
   */
  public void validate(UnAssignVrminFromExcIEEEST1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEST1ACommand should not be null");
    Assert.notNull(
        command.getExcIEEEST1AId(),
        "UnAssignVrminFromExcIEEEST1ACommand identifier should not be null");
  }
}
