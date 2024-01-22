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

public class ExcST6BValidator {

  /** default constructor */
  protected ExcST6BValidator() {}

  /** factory method */
  public static ExcST6BValidator getInstance() {
    return new ExcST6BValidator();
  }

  /** handles creation validation for a ExcST6B */
  public void validate(CreateExcST6BCommand excST6B) throws Exception {
    Assert.notNull(excST6B, "CreateExcST6BCommand should not be null");
    //		Assert.isNull( excST6B.getExcST6BId(), "CreateExcST6BCommand identifier should be null" );
  }

  /** handles update validation for a ExcST6B */
  public void validate(UpdateExcST6BCommand excST6B) throws Exception {
    Assert.notNull(excST6B, "UpdateExcST6BCommand should not be null");
    Assert.notNull(excST6B.getExcST6BId(), "UpdateExcST6BCommand identifier should not be null");
  }

  /** handles delete validation for a ExcST6B */
  public void validate(DeleteExcST6BCommand excST6B) throws Exception {
    Assert.notNull(excST6B, "{commandAlias} should not be null");
    Assert.notNull(excST6B.getExcST6BId(), "DeleteExcST6BCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcST6B */
  public void validate(ExcST6BFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcST6BFetchOneSummary should not be null");
    Assert.notNull(summary.getExcST6BId(), "ExcST6BFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ilr validation for a ExcST6B
   *
   * @param command AssignIlrToExcST6BCommand
   */
  public void validate(AssignIlrToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignIlrToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignIlrToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIlrToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Ilr validation for a ExcST6B
   *
   * @param command UnAssignIlrFromExcST6BCommand
   */
  public void validate(UnAssignIlrFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignIlrFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignIlrFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign K1 validation for a ExcST6B
   *
   * @param command AssignK1ToExcST6BCommand
   */
  public void validate(AssignK1ToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignK1ToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignK1ToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK1ToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign K1 validation for a ExcST6B
   *
   * @param command UnAssignK1FromExcST6BCommand
   */
  public void validate(UnAssignK1FromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK1FromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignK1FromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Kcl validation for a ExcST6B
   *
   * @param command AssignKclToExcST6BCommand
   */
  public void validate(AssignKclToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignKclToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignKclToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKclToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Kcl validation for a ExcST6B
   *
   * @param command UnAssignKclFromExcST6BCommand
   */
  public void validate(UnAssignKclFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKclFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignKclFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Kff validation for a ExcST6B
   *
   * @param command AssignKffToExcST6BCommand
   */
  public void validate(AssignKffToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignKffToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignKffToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKffToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Kff validation for a ExcST6B
   *
   * @param command UnAssignKffFromExcST6BCommand
   */
  public void validate(UnAssignKffFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKffFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignKffFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Kg validation for a ExcST6B
   *
   * @param command AssignKgToExcST6BCommand
   */
  public void validate(AssignKgToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignKgToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignKgToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKgToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Kg validation for a ExcST6B
   *
   * @param command UnAssignKgFromExcST6BCommand
   */
  public void validate(UnAssignKgFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKgFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignKgFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Kia validation for a ExcST6B
   *
   * @param command AssignKiaToExcST6BCommand
   */
  public void validate(AssignKiaToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignKiaToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignKiaToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiaToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Kia validation for a ExcST6B
   *
   * @param command UnAssignKiaFromExcST6BCommand
   */
  public void validate(UnAssignKiaFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiaFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignKiaFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Klr validation for a ExcST6B
   *
   * @param command AssignKlrToExcST6BCommand
   */
  public void validate(AssignKlrToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignKlrToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignKlrToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKlrToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Klr validation for a ExcST6B
   *
   * @param command UnAssignKlrFromExcST6BCommand
   */
  public void validate(UnAssignKlrFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKlrFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignKlrFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Km validation for a ExcST6B
   *
   * @param command AssignKmToExcST6BCommand
   */
  public void validate(AssignKmToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignKmToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignKmToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKmToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Km validation for a ExcST6B
   *
   * @param command UnAssignKmFromExcST6BCommand
   */
  public void validate(UnAssignKmFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKmFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignKmFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Kpa validation for a ExcST6B
   *
   * @param command AssignKpaToExcST6BCommand
   */
  public void validate(AssignKpaToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignKpaToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignKpaToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpaToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Kpa validation for a ExcST6B
   *
   * @param command UnAssignKpaFromExcST6BCommand
   */
  public void validate(UnAssignKpaFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpaFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignKpaFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Kvd validation for a ExcST6B
   *
   * @param command AssignKvdToExcST6BCommand
   */
  public void validate(AssignKvdToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignKvdToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignKvdToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKvdToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Kvd validation for a ExcST6B
   *
   * @param command UnAssignKvdFromExcST6BCommand
   */
  public void validate(UnAssignKvdFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKvdFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignKvdFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Tg validation for a ExcST6B
   *
   * @param command AssignTgToExcST6BCommand
   */
  public void validate(AssignTgToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignTgToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignTgToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTgToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Tg validation for a ExcST6B
   *
   * @param command UnAssignTgFromExcST6BCommand
   */
  public void validate(UnAssignTgFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTgFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignTgFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Ts validation for a ExcST6B
   *
   * @param command AssignTsToExcST6BCommand
   */
  public void validate(AssignTsToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignTsToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignTsToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTsToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Ts validation for a ExcST6B
   *
   * @param command UnAssignTsFromExcST6BCommand
   */
  public void validate(UnAssignTsFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTsFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignTsFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Tvd validation for a ExcST6B
   *
   * @param command AssignTvdToExcST6BCommand
   */
  public void validate(AssignTvdToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignTvdToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignTvdToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTvdToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Tvd validation for a ExcST6B
   *
   * @param command UnAssignTvdFromExcST6BCommand
   */
  public void validate(UnAssignTvdFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTvdFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignTvdFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Vamax validation for a ExcST6B
   *
   * @param command AssignVamaxToExcST6BCommand
   */
  public void validate(AssignVamaxToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignVamaxToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignVamaxToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVamaxToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Vamax validation for a ExcST6B
   *
   * @param command UnAssignVamaxFromExcST6BCommand
   */
  public void validate(UnAssignVamaxFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVamaxFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignVamaxFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Vamin validation for a ExcST6B
   *
   * @param command AssignVaminToExcST6BCommand
   */
  public void validate(AssignVaminToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignVaminToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignVaminToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVaminToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Vamin validation for a ExcST6B
   *
   * @param command UnAssignVaminFromExcST6BCommand
   */
  public void validate(UnAssignVaminFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVaminFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignVaminFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Vilim validation for a ExcST6B
   *
   * @param command AssignVilimToExcST6BCommand
   */
  public void validate(AssignVilimToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignVilimToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignVilimToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVilimToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Vilim validation for a ExcST6B
   *
   * @param command UnAssignVilimFromExcST6BCommand
   */
  public void validate(UnAssignVilimFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVilimFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignVilimFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Vimax validation for a ExcST6B
   *
   * @param command AssignVimaxToExcST6BCommand
   */
  public void validate(AssignVimaxToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignVimaxToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignVimaxToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVimaxToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Vimax validation for a ExcST6B
   *
   * @param command UnAssignVimaxFromExcST6BCommand
   */
  public void validate(UnAssignVimaxFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVimaxFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignVimaxFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Vimin validation for a ExcST6B
   *
   * @param command AssignViminToExcST6BCommand
   */
  public void validate(AssignViminToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignViminToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignViminToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignViminToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Vimin validation for a ExcST6B
   *
   * @param command UnAssignViminFromExcST6BCommand
   */
  public void validate(UnAssignViminFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignViminFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignViminFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Vmult validation for a ExcST6B
   *
   * @param command AssignVmultToExcST6BCommand
   */
  public void validate(AssignVmultToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignVmultToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignVmultToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmultToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Vmult validation for a ExcST6B
   *
   * @param command UnAssignVmultFromExcST6BCommand
   */
  public void validate(UnAssignVmultFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVmultFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignVmultFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcST6B
   *
   * @param command AssignVrmaxToExcST6BCommand
   */
  public void validate(AssignVrmaxToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignVrmaxToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcST6B
   *
   * @param command UnAssignVrmaxFromExcST6BCommand
   */
  public void validate(UnAssignVrmaxFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignVrmaxFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcST6B
   *
   * @param command AssignVrminToExcST6BCommand
   */
  public void validate(AssignVrminToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignVrminToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcST6B
   *
   * @param command UnAssignVrminFromExcST6BCommand
   */
  public void validate(UnAssignVrminFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignVrminFromExcST6BCommand identifier should not be null");
  }
  /**
   * handles assign Xc validation for a ExcST6B
   *
   * @param command AssignXcToExcST6BCommand
   */
  public void validate(AssignXcToExcST6BCommand command) throws Exception {
    Assert.notNull(command, "AssignXcToExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "AssignXcToExcST6BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXcToExcST6BCommand assignment should not be null");
  }

  /**
   * handles unassign Xc validation for a ExcST6B
   *
   * @param command UnAssignXcFromExcST6BCommand
   */
  public void validate(UnAssignXcFromExcST6BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXcFromExcST6BCommand should not be null");
    Assert.notNull(
        command.getExcST6BId(), "UnAssignXcFromExcST6BCommand identifier should not be null");
  }
}
