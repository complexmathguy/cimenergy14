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

public class ExcIEEEST7BValidator {

  /** default constructor */
  protected ExcIEEEST7BValidator() {}

  /** factory method */
  public static ExcIEEEST7BValidator getInstance() {
    return new ExcIEEEST7BValidator();
  }

  /** handles creation validation for a ExcIEEEST7B */
  public void validate(CreateExcIEEEST7BCommand excIEEEST7B) throws Exception {
    Assert.notNull(excIEEEST7B, "CreateExcIEEEST7BCommand should not be null");
    //		Assert.isNull( excIEEEST7B.getExcIEEEST7BId(), "CreateExcIEEEST7BCommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEST7B */
  public void validate(UpdateExcIEEEST7BCommand excIEEEST7B) throws Exception {
    Assert.notNull(excIEEEST7B, "UpdateExcIEEEST7BCommand should not be null");
    Assert.notNull(
        excIEEEST7B.getExcIEEEST7BId(), "UpdateExcIEEEST7BCommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEST7B */
  public void validate(DeleteExcIEEEST7BCommand excIEEEST7B) throws Exception {
    Assert.notNull(excIEEEST7B, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEST7B.getExcIEEEST7BId(), "DeleteExcIEEEST7BCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEST7B */
  public void validate(ExcIEEEST7BFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEST7BFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEST7BId(), "ExcIEEEST7BFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Kh validation for a ExcIEEEST7B
   *
   * @param command AssignKhToExcIEEEST7BCommand
   */
  public void validate(AssignKhToExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKhToExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(), "AssignKhToExcIEEEST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKhToExcIEEEST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kh validation for a ExcIEEEST7B
   *
   * @param command UnAssignKhFromExcIEEEST7BCommand
   */
  public void validate(UnAssignKhFromExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKhFromExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(),
        "UnAssignKhFromExcIEEEST7BCommand identifier should not be null");
  }
  /**
   * handles assign Kia validation for a ExcIEEEST7B
   *
   * @param command AssignKiaToExcIEEEST7BCommand
   */
  public void validate(AssignKiaToExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKiaToExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(), "AssignKiaToExcIEEEST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiaToExcIEEEST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kia validation for a ExcIEEEST7B
   *
   * @param command UnAssignKiaFromExcIEEEST7BCommand
   */
  public void validate(UnAssignKiaFromExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiaFromExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(),
        "UnAssignKiaFromExcIEEEST7BCommand identifier should not be null");
  }
  /**
   * handles assign Kl validation for a ExcIEEEST7B
   *
   * @param command AssignKlToExcIEEEST7BCommand
   */
  public void validate(AssignKlToExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKlToExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(), "AssignKlToExcIEEEST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKlToExcIEEEST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kl validation for a ExcIEEEST7B
   *
   * @param command UnAssignKlFromExcIEEEST7BCommand
   */
  public void validate(UnAssignKlFromExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKlFromExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(),
        "UnAssignKlFromExcIEEEST7BCommand identifier should not be null");
  }
  /**
   * handles assign Kpa validation for a ExcIEEEST7B
   *
   * @param command AssignKpaToExcIEEEST7BCommand
   */
  public void validate(AssignKpaToExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignKpaToExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(), "AssignKpaToExcIEEEST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpaToExcIEEEST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Kpa validation for a ExcIEEEST7B
   *
   * @param command UnAssignKpaFromExcIEEEST7BCommand
   */
  public void validate(UnAssignKpaFromExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpaFromExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(),
        "UnAssignKpaFromExcIEEEST7BCommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcIEEEST7B
   *
   * @param command AssignTbToExcIEEEST7BCommand
   */
  public void validate(AssignTbToExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(), "AssignTbToExcIEEEST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcIEEEST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcIEEEST7B
   *
   * @param command UnAssignTbFromExcIEEEST7BCommand
   */
  public void validate(UnAssignTbFromExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(),
        "UnAssignTbFromExcIEEEST7BCommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a ExcIEEEST7B
   *
   * @param command AssignTcToExcIEEEST7BCommand
   */
  public void validate(AssignTcToExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignTcToExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(), "AssignTcToExcIEEEST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToExcIEEEST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a ExcIEEEST7B
   *
   * @param command UnAssignTcFromExcIEEEST7BCommand
   */
  public void validate(UnAssignTcFromExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(),
        "UnAssignTcFromExcIEEEST7BCommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcIEEEST7B
   *
   * @param command AssignTfToExcIEEEST7BCommand
   */
  public void validate(AssignTfToExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignTfToExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(), "AssignTfToExcIEEEST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcIEEEST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcIEEEST7B
   *
   * @param command UnAssignTfFromExcIEEEST7BCommand
   */
  public void validate(UnAssignTfFromExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(),
        "UnAssignTfFromExcIEEEST7BCommand identifier should not be null");
  }
  /**
   * handles assign Tg validation for a ExcIEEEST7B
   *
   * @param command AssignTgToExcIEEEST7BCommand
   */
  public void validate(AssignTgToExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignTgToExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(), "AssignTgToExcIEEEST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTgToExcIEEEST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Tg validation for a ExcIEEEST7B
   *
   * @param command UnAssignTgFromExcIEEEST7BCommand
   */
  public void validate(UnAssignTgFromExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTgFromExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(),
        "UnAssignTgFromExcIEEEST7BCommand identifier should not be null");
  }
  /**
   * handles assign Tia validation for a ExcIEEEST7B
   *
   * @param command AssignTiaToExcIEEEST7BCommand
   */
  public void validate(AssignTiaToExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignTiaToExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(), "AssignTiaToExcIEEEST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTiaToExcIEEEST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Tia validation for a ExcIEEEST7B
   *
   * @param command UnAssignTiaFromExcIEEEST7BCommand
   */
  public void validate(UnAssignTiaFromExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTiaFromExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(),
        "UnAssignTiaFromExcIEEEST7BCommand identifier should not be null");
  }
  /**
   * handles assign Vmax validation for a ExcIEEEST7B
   *
   * @param command AssignVmaxToExcIEEEST7BCommand
   */
  public void validate(AssignVmaxToExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVmaxToExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(), "AssignVmaxToExcIEEEST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmaxToExcIEEEST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Vmax validation for a ExcIEEEST7B
   *
   * @param command UnAssignVmaxFromExcIEEEST7BCommand
   */
  public void validate(UnAssignVmaxFromExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVmaxFromExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(),
        "UnAssignVmaxFromExcIEEEST7BCommand identifier should not be null");
  }
  /**
   * handles assign Vmin validation for a ExcIEEEST7B
   *
   * @param command AssignVminToExcIEEEST7BCommand
   */
  public void validate(AssignVminToExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVminToExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(), "AssignVminToExcIEEEST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVminToExcIEEEST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Vmin validation for a ExcIEEEST7B
   *
   * @param command UnAssignVminFromExcIEEEST7BCommand
   */
  public void validate(UnAssignVminFromExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVminFromExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(),
        "UnAssignVminFromExcIEEEST7BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEST7B
   *
   * @param command AssignVrmaxToExcIEEEST7BCommand
   */
  public void validate(AssignVrmaxToExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(),
        "AssignVrmaxToExcIEEEST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEST7B
   *
   * @param command UnAssignVrmaxFromExcIEEEST7BCommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(),
        "UnAssignVrmaxFromExcIEEEST7BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEST7B
   *
   * @param command AssignVrminToExcIEEEST7BCommand
   */
  public void validate(AssignVrminToExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(),
        "AssignVrminToExcIEEEST7BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEST7BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEST7B
   *
   * @param command UnAssignVrminFromExcIEEEST7BCommand
   */
  public void validate(UnAssignVrminFromExcIEEEST7BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEST7BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST7BId(),
        "UnAssignVrminFromExcIEEEST7BCommand identifier should not be null");
  }
}
