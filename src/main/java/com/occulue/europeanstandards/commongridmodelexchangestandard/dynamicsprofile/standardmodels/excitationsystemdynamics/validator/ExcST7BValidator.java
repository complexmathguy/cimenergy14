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

public class ExcST7BValidator {

  /** default constructor */
  protected ExcST7BValidator() {}

  /** factory method */
  public static ExcST7BValidator getInstance() {
    return new ExcST7BValidator();
  }

  /** handles creation validation for a ExcST7B */
  public void validate(CreateExcST7BCommand excST7B) throws Exception {
    Assert.notNull(excST7B, "CreateExcST7BCommand should not be null");
    //		Assert.isNull( excST7B.getExcST7BId(), "CreateExcST7BCommand identifier should be null" );
  }

  /** handles update validation for a ExcST7B */
  public void validate(UpdateExcST7BCommand excST7B) throws Exception {
    Assert.notNull(excST7B, "UpdateExcST7BCommand should not be null");
    Assert.notNull(excST7B.getExcST7BId(), "UpdateExcST7BCommand identifier should not be null");
  }

  /** handles delete validation for a ExcST7B */
  public void validate(DeleteExcST7BCommand excST7B) throws Exception {
    Assert.notNull(excST7B, "{commandAlias} should not be null");
    Assert.notNull(excST7B.getExcST7BId(), "DeleteExcST7BCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcST7B */
  public void validate(ExcST7BFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcST7BFetchOneSummary should not be null");
    Assert.notNull(summary.getExcST7BId(), "ExcST7BFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Kh validation for a ExcST7B
   *
   * @param command AssignKhToExcST7BCommand
   */
  public void validate(AssignKhToExcST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKhToExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "AssignKhToExcST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKhToExcST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kh validation for a ExcST7B
   *
   * @param command UnAssignKhFromExcST7BCommand
   */
  public void validate(UnAssignKhFromExcST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKhFromExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "UnAssignKhFromExcST7BCommand identifier should not be null");
  }
  /**
   * handles assign Kia validation for a ExcST7B
   *
   * @param command AssignKiaToExcST7BCommand
   */
  public void validate(AssignKiaToExcST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKiaToExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "AssignKiaToExcST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiaToExcST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kia validation for a ExcST7B
   *
   * @param command UnAssignKiaFromExcST7BCommand
   */
  public void validate(UnAssignKiaFromExcST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiaFromExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "UnAssignKiaFromExcST7BCommand identifier should not be null");
  }
  /**
   * handles assign Kl validation for a ExcST7B
   *
   * @param command AssignKlToExcST7BCommand
   */
  public void validate(AssignKlToExcST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKlToExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "AssignKlToExcST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKlToExcST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kl validation for a ExcST7B
   *
   * @param command UnAssignKlFromExcST7BCommand
   */
  public void validate(UnAssignKlFromExcST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKlFromExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "UnAssignKlFromExcST7BCommand identifier should not be null");
  }
  /**
   * handles assign Kpa validation for a ExcST7B
   *
   * @param command AssignKpaToExcST7BCommand
   */
  public void validate(AssignKpaToExcST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKpaToExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "AssignKpaToExcST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpaToExcST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kpa validation for a ExcST7B
   *
   * @param command UnAssignKpaFromExcST7BCommand
   */
  public void validate(UnAssignKpaFromExcST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpaFromExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "UnAssignKpaFromExcST7BCommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcST7B
   *
   * @param command AssignTbToExcST7BCommand
   */
  public void validate(AssignTbToExcST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "AssignTbToExcST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcST7B
   *
   * @param command UnAssignTbFromExcST7BCommand
   */
  public void validate(UnAssignTbFromExcST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "UnAssignTbFromExcST7BCommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcST7B
   *
   * @param command AssignTcToExcST7BCommand
   */
  public void validate(AssignTcToExcST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "AssignTcToExcST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcST7B
   *
   * @param command UnAssignTcFromExcST7BCommand
   */
  public void validate(UnAssignTcFromExcST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "UnAssignTcFromExcST7BCommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcST7B
   *
   * @param command AssignTfToExcST7BCommand
   */
  public void validate(AssignTfToExcST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "AssignTfToExcST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcST7B
   *
   * @param command UnAssignTfFromExcST7BCommand
   */
  public void validate(UnAssignTfFromExcST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "UnAssignTfFromExcST7BCommand identifier should not be null");
  }
  /**
   * handles assign Tg validation for a ExcST7B
   *
   * @param command AssignTgToExcST7BCommand
   */
  public void validate(AssignTgToExcST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignTgToExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "AssignTgToExcST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTgToExcST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Tg validation for a ExcST7B
   *
   * @param command UnAssignTgFromExcST7BCommand
   */
  public void validate(UnAssignTgFromExcST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTgFromExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "UnAssignTgFromExcST7BCommand identifier should not be null");
  }
  /**
   * handles assign Tia validation for a ExcST7B
   *
   * @param command AssignTiaToExcST7BCommand
   */
  public void validate(AssignTiaToExcST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignTiaToExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "AssignTiaToExcST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTiaToExcST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Tia validation for a ExcST7B
   *
   * @param command UnAssignTiaFromExcST7BCommand
   */
  public void validate(UnAssignTiaFromExcST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTiaFromExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "UnAssignTiaFromExcST7BCommand identifier should not be null");
  }
  /**
   * handles assign Ts validation for a ExcST7B
   *
   * @param command AssignTsToExcST7BCommand
   */
  public void validate(AssignTsToExcST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignTsToExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "AssignTsToExcST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTsToExcST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Ts validation for a ExcST7B
   *
   * @param command UnAssignTsFromExcST7BCommand
   */
  public void validate(UnAssignTsFromExcST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTsFromExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "UnAssignTsFromExcST7BCommand identifier should not be null");
  }
  /**
   * handles assign Vmax validation for a ExcST7B
   *
   * @param command AssignVmaxToExcST7BCommand
   */
  public void validate(AssignVmaxToExcST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVmaxToExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "AssignVmaxToExcST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmaxToExcST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Vmax validation for a ExcST7B
   *
   * @param command UnAssignVmaxFromExcST7BCommand
   */
  public void validate(UnAssignVmaxFromExcST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVmaxFromExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "UnAssignVmaxFromExcST7BCommand identifier should not be null");
  }
  /**
   * handles assign Vmin validation for a ExcST7B
   *
   * @param command AssignVminToExcST7BCommand
   */
  public void validate(AssignVminToExcST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVminToExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "AssignVminToExcST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVminToExcST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Vmin validation for a ExcST7B
   *
   * @param command UnAssignVminFromExcST7BCommand
   */
  public void validate(UnAssignVminFromExcST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVminFromExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "UnAssignVminFromExcST7BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcST7B
   *
   * @param command AssignVrmaxToExcST7BCommand
   */
  public void validate(AssignVrmaxToExcST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "AssignVrmaxToExcST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcST7B
   *
   * @param command UnAssignVrmaxFromExcST7BCommand
   */
  public void validate(UnAssignVrmaxFromExcST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "UnAssignVrmaxFromExcST7BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcST7B
   *
   * @param command AssignVrminToExcST7BCommand
   */
  public void validate(AssignVrminToExcST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "AssignVrminToExcST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcST7B
   *
   * @param command UnAssignVrminFromExcST7BCommand
   */
  public void validate(UnAssignVrminFromExcST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcST7BCommand should not be null");
    Assert.notNull(
        command.getExcST7BId(), "UnAssignVrminFromExcST7BCommand identifier should not be null");
  }
}
