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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class LoadMotorValidator {

  /** default constructor */
  protected LoadMotorValidator() {}

  /** factory method */
  public static LoadMotorValidator getInstance() {
    return new LoadMotorValidator();
  }

  /** handles creation validation for a LoadMotor */
  public void validate(CreateLoadMotorCommand loadMotor) throws Exception {
    Assert.notNull(loadMotor, "CreateLoadMotorCommand should not be null");
    //		Assert.isNull( loadMotor.getLoadMotorId(), "CreateLoadMotorCommand identifier should be
    // null" );
  }

  /** handles update validation for a LoadMotor */
  public void validate(UpdateLoadMotorCommand loadMotor) throws Exception {
    Assert.notNull(loadMotor, "UpdateLoadMotorCommand should not be null");
    Assert.notNull(
        loadMotor.getLoadMotorId(), "UpdateLoadMotorCommand identifier should not be null");
  }

  /** handles delete validation for a LoadMotor */
  public void validate(DeleteLoadMotorCommand loadMotor) throws Exception {
    Assert.notNull(loadMotor, "{commandAlias} should not be null");
    Assert.notNull(
        loadMotor.getLoadMotorId(), "DeleteLoadMotorCommand identifier should not be null");
  }

  /** handles fetchOne validation for a LoadMotor */
  public void validate(LoadMotorFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "LoadMotorFetchOneSummary should not be null");
    Assert.notNull(
        summary.getLoadMotorId(), "LoadMotorFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign D validation for a LoadMotor
   *
   * @param command AssignDToLoadMotorCommand
   */
  public void validate(AssignDToLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "AssignDToLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "AssignDToLoadMotorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDToLoadMotorCommand assignment should not be null");
  }

  /**
   * handles unassign D validation for a LoadMotor
   *
   * @param command UnAssignDFromLoadMotorCommand
   */
  public void validate(UnAssignDFromLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDFromLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "UnAssignDFromLoadMotorCommand identifier should not be null");
  }
  /**
   * handles assign H validation for a LoadMotor
   *
   * @param command AssignHToLoadMotorCommand
   */
  public void validate(AssignHToLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "AssignHToLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "AssignHToLoadMotorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignHToLoadMotorCommand assignment should not be null");
  }

  /**
   * handles unassign H validation for a LoadMotor
   *
   * @param command UnAssignHFromLoadMotorCommand
   */
  public void validate(UnAssignHFromLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignHFromLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "UnAssignHFromLoadMotorCommand identifier should not be null");
  }
  /**
   * handles assign Lfac validation for a LoadMotor
   *
   * @param command AssignLfacToLoadMotorCommand
   */
  public void validate(AssignLfacToLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "AssignLfacToLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "AssignLfacToLoadMotorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLfacToLoadMotorCommand assignment should not be null");
  }

  /**
   * handles unassign Lfac validation for a LoadMotor
   *
   * @param command UnAssignLfacFromLoadMotorCommand
   */
  public void validate(UnAssignLfacFromLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLfacFromLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "UnAssignLfacFromLoadMotorCommand identifier should not be null");
  }
  /**
   * handles assign Lp validation for a LoadMotor
   *
   * @param command AssignLpToLoadMotorCommand
   */
  public void validate(AssignLpToLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "AssignLpToLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "AssignLpToLoadMotorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLpToLoadMotorCommand assignment should not be null");
  }

  /**
   * handles unassign Lp validation for a LoadMotor
   *
   * @param command UnAssignLpFromLoadMotorCommand
   */
  public void validate(UnAssignLpFromLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLpFromLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "UnAssignLpFromLoadMotorCommand identifier should not be null");
  }
  /**
   * handles assign Lpp validation for a LoadMotor
   *
   * @param command AssignLppToLoadMotorCommand
   */
  public void validate(AssignLppToLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "AssignLppToLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "AssignLppToLoadMotorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLppToLoadMotorCommand assignment should not be null");
  }

  /**
   * handles unassign Lpp validation for a LoadMotor
   *
   * @param command UnAssignLppFromLoadMotorCommand
   */
  public void validate(UnAssignLppFromLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLppFromLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "UnAssignLppFromLoadMotorCommand identifier should not be null");
  }
  /**
   * handles assign Ls validation for a LoadMotor
   *
   * @param command AssignLsToLoadMotorCommand
   */
  public void validate(AssignLsToLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "AssignLsToLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "AssignLsToLoadMotorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLsToLoadMotorCommand assignment should not be null");
  }

  /**
   * handles unassign Ls validation for a LoadMotor
   *
   * @param command UnAssignLsFromLoadMotorCommand
   */
  public void validate(UnAssignLsFromLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLsFromLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "UnAssignLsFromLoadMotorCommand identifier should not be null");
  }
  /**
   * handles assign Pfrac validation for a LoadMotor
   *
   * @param command AssignPfracToLoadMotorCommand
   */
  public void validate(AssignPfracToLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "AssignPfracToLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "AssignPfracToLoadMotorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPfracToLoadMotorCommand assignment should not be null");
  }

  /**
   * handles unassign Pfrac validation for a LoadMotor
   *
   * @param command UnAssignPfracFromLoadMotorCommand
   */
  public void validate(UnAssignPfracFromLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPfracFromLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(),
        "UnAssignPfracFromLoadMotorCommand identifier should not be null");
  }
  /**
   * handles assign Ra validation for a LoadMotor
   *
   * @param command AssignRaToLoadMotorCommand
   */
  public void validate(AssignRaToLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "AssignRaToLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "AssignRaToLoadMotorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRaToLoadMotorCommand assignment should not be null");
  }

  /**
   * handles unassign Ra validation for a LoadMotor
   *
   * @param command UnAssignRaFromLoadMotorCommand
   */
  public void validate(UnAssignRaFromLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRaFromLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "UnAssignRaFromLoadMotorCommand identifier should not be null");
  }
  /**
   * handles assign Tbkr validation for a LoadMotor
   *
   * @param command AssignTbkrToLoadMotorCommand
   */
  public void validate(AssignTbkrToLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "AssignTbkrToLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "AssignTbkrToLoadMotorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbkrToLoadMotorCommand assignment should not be null");
  }

  /**
   * handles unassign Tbkr validation for a LoadMotor
   *
   * @param command UnAssignTbkrFromLoadMotorCommand
   */
  public void validate(UnAssignTbkrFromLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbkrFromLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "UnAssignTbkrFromLoadMotorCommand identifier should not be null");
  }
  /**
   * handles assign Tpo validation for a LoadMotor
   *
   * @param command AssignTpoToLoadMotorCommand
   */
  public void validate(AssignTpoToLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "AssignTpoToLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "AssignTpoToLoadMotorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpoToLoadMotorCommand assignment should not be null");
  }

  /**
   * handles unassign Tpo validation for a LoadMotor
   *
   * @param command UnAssignTpoFromLoadMotorCommand
   */
  public void validate(UnAssignTpoFromLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpoFromLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "UnAssignTpoFromLoadMotorCommand identifier should not be null");
  }
  /**
   * handles assign Tppo validation for a LoadMotor
   *
   * @param command AssignTppoToLoadMotorCommand
   */
  public void validate(AssignTppoToLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "AssignTppoToLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "AssignTppoToLoadMotorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTppoToLoadMotorCommand assignment should not be null");
  }

  /**
   * handles unassign Tppo validation for a LoadMotor
   *
   * @param command UnAssignTppoFromLoadMotorCommand
   */
  public void validate(UnAssignTppoFromLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTppoFromLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "UnAssignTppoFromLoadMotorCommand identifier should not be null");
  }
  /**
   * handles assign Tv validation for a LoadMotor
   *
   * @param command AssignTvToLoadMotorCommand
   */
  public void validate(AssignTvToLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "AssignTvToLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "AssignTvToLoadMotorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTvToLoadMotorCommand assignment should not be null");
  }

  /**
   * handles unassign Tv validation for a LoadMotor
   *
   * @param command UnAssignTvFromLoadMotorCommand
   */
  public void validate(UnAssignTvFromLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTvFromLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "UnAssignTvFromLoadMotorCommand identifier should not be null");
  }
  /**
   * handles assign Vt validation for a LoadMotor
   *
   * @param command AssignVtToLoadMotorCommand
   */
  public void validate(AssignVtToLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "AssignVtToLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "AssignVtToLoadMotorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVtToLoadMotorCommand assignment should not be null");
  }

  /**
   * handles unassign Vt validation for a LoadMotor
   *
   * @param command UnAssignVtFromLoadMotorCommand
   */
  public void validate(UnAssignVtFromLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVtFromLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(), "UnAssignVtFromLoadMotorCommand identifier should not be null");
  }
  /**
   * handles assign LoadMotor validation for a LoadMotor
   *
   * @param command AssignLoadMotorToLoadMotorCommand
   */
  public void validate(AssignLoadMotorToLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "AssignLoadMotorToLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(),
        "AssignLoadMotorToLoadMotorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLoadMotorToLoadMotorCommand assignment should not be null");
  }

  /**
   * handles unassign LoadMotor validation for a LoadMotor
   *
   * @param command UnAssignLoadMotorFromLoadMotorCommand
   */
  public void validate(UnAssignLoadMotorFromLoadMotorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLoadMotorFromLoadMotorCommand should not be null");
    Assert.notNull(
        command.getLoadMotorId(),
        "UnAssignLoadMotorFromLoadMotorCommand identifier should not be null");
  }
}
