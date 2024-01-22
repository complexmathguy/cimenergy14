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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class VAdjIEEEValidator {

  /** default constructor */
  protected VAdjIEEEValidator() {}

  /** factory method */
  public static VAdjIEEEValidator getInstance() {
    return new VAdjIEEEValidator();
  }

  /** handles creation validation for a VAdjIEEE */
  public void validate(CreateVAdjIEEECommand vAdjIEEE) throws Exception {
    Assert.notNull(vAdjIEEE, "CreateVAdjIEEECommand should not be null");
    //		Assert.isNull( vAdjIEEE.getVAdjIEEEId(), "CreateVAdjIEEECommand identifier should be null"
    // );
  }

  /** handles update validation for a VAdjIEEE */
  public void validate(UpdateVAdjIEEECommand vAdjIEEE) throws Exception {
    Assert.notNull(vAdjIEEE, "UpdateVAdjIEEECommand should not be null");
    Assert.notNull(vAdjIEEE.getVAdjIEEEId(), "UpdateVAdjIEEECommand identifier should not be null");
  }

  /** handles delete validation for a VAdjIEEE */
  public void validate(DeleteVAdjIEEECommand vAdjIEEE) throws Exception {
    Assert.notNull(vAdjIEEE, "{commandAlias} should not be null");
    Assert.notNull(vAdjIEEE.getVAdjIEEEId(), "DeleteVAdjIEEECommand identifier should not be null");
  }

  /** handles fetchOne validation for a VAdjIEEE */
  public void validate(VAdjIEEEFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "VAdjIEEEFetchOneSummary should not be null");
    Assert.notNull(
        summary.getVAdjIEEEId(), "VAdjIEEEFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Adjslew validation for a VAdjIEEE
   *
   * @param command AssignAdjslewToVAdjIEEECommand
   */
  public void validate(AssignAdjslewToVAdjIEEECommand command) throws Exception {
    Assert.notNull(command, "AssignAdjslewToVAdjIEEECommand should not be null");
    Assert.notNull(
        command.getVAdjIEEEId(), "AssignAdjslewToVAdjIEEECommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAdjslewToVAdjIEEECommand assignment should not be null");
  }

  /**
   * handles unassign Adjslew validation for a VAdjIEEE
   *
   * @param command UnAssignAdjslewFromVAdjIEEECommand
   */
  public void validate(UnAssignAdjslewFromVAdjIEEECommand command) throws Exception {
    Assert.notNull(command, "UnAssignAdjslewFromVAdjIEEECommand should not be null");
    Assert.notNull(
        command.getVAdjIEEEId(),
        "UnAssignAdjslewFromVAdjIEEECommand identifier should not be null");
  }
  /**
   * handles assign Taoff validation for a VAdjIEEE
   *
   * @param command AssignTaoffToVAdjIEEECommand
   */
  public void validate(AssignTaoffToVAdjIEEECommand command) throws Exception {
    Assert.notNull(command, "AssignTaoffToVAdjIEEECommand should not be null");
    Assert.notNull(
        command.getVAdjIEEEId(), "AssignTaoffToVAdjIEEECommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaoffToVAdjIEEECommand assignment should not be null");
  }

  /**
   * handles unassign Taoff validation for a VAdjIEEE
   *
   * @param command UnAssignTaoffFromVAdjIEEECommand
   */
  public void validate(UnAssignTaoffFromVAdjIEEECommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaoffFromVAdjIEEECommand should not be null");
    Assert.notNull(
        command.getVAdjIEEEId(), "UnAssignTaoffFromVAdjIEEECommand identifier should not be null");
  }
  /**
   * handles assign Taon validation for a VAdjIEEE
   *
   * @param command AssignTaonToVAdjIEEECommand
   */
  public void validate(AssignTaonToVAdjIEEECommand command) throws Exception {
    Assert.notNull(command, "AssignTaonToVAdjIEEECommand should not be null");
    Assert.notNull(
        command.getVAdjIEEEId(), "AssignTaonToVAdjIEEECommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaonToVAdjIEEECommand assignment should not be null");
  }

  /**
   * handles unassign Taon validation for a VAdjIEEE
   *
   * @param command UnAssignTaonFromVAdjIEEECommand
   */
  public void validate(UnAssignTaonFromVAdjIEEECommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaonFromVAdjIEEECommand should not be null");
    Assert.notNull(
        command.getVAdjIEEEId(), "UnAssignTaonFromVAdjIEEECommand identifier should not be null");
  }
  /**
   * handles assign Vadjf validation for a VAdjIEEE
   *
   * @param command AssignVadjfToVAdjIEEECommand
   */
  public void validate(AssignVadjfToVAdjIEEECommand command) throws Exception {
    Assert.notNull(command, "AssignVadjfToVAdjIEEECommand should not be null");
    Assert.notNull(
        command.getVAdjIEEEId(), "AssignVadjfToVAdjIEEECommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVadjfToVAdjIEEECommand assignment should not be null");
  }

  /**
   * handles unassign Vadjf validation for a VAdjIEEE
   *
   * @param command UnAssignVadjfFromVAdjIEEECommand
   */
  public void validate(UnAssignVadjfFromVAdjIEEECommand command) throws Exception {
    Assert.notNull(command, "UnAssignVadjfFromVAdjIEEECommand should not be null");
    Assert.notNull(
        command.getVAdjIEEEId(), "UnAssignVadjfFromVAdjIEEECommand identifier should not be null");
  }
  /**
   * handles assign Vadjmax validation for a VAdjIEEE
   *
   * @param command AssignVadjmaxToVAdjIEEECommand
   */
  public void validate(AssignVadjmaxToVAdjIEEECommand command) throws Exception {
    Assert.notNull(command, "AssignVadjmaxToVAdjIEEECommand should not be null");
    Assert.notNull(
        command.getVAdjIEEEId(), "AssignVadjmaxToVAdjIEEECommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVadjmaxToVAdjIEEECommand assignment should not be null");
  }

  /**
   * handles unassign Vadjmax validation for a VAdjIEEE
   *
   * @param command UnAssignVadjmaxFromVAdjIEEECommand
   */
  public void validate(UnAssignVadjmaxFromVAdjIEEECommand command) throws Exception {
    Assert.notNull(command, "UnAssignVadjmaxFromVAdjIEEECommand should not be null");
    Assert.notNull(
        command.getVAdjIEEEId(),
        "UnAssignVadjmaxFromVAdjIEEECommand identifier should not be null");
  }
  /**
   * handles assign Vadjmin validation for a VAdjIEEE
   *
   * @param command AssignVadjminToVAdjIEEECommand
   */
  public void validate(AssignVadjminToVAdjIEEECommand command) throws Exception {
    Assert.notNull(command, "AssignVadjminToVAdjIEEECommand should not be null");
    Assert.notNull(
        command.getVAdjIEEEId(), "AssignVadjminToVAdjIEEECommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVadjminToVAdjIEEECommand assignment should not be null");
  }

  /**
   * handles unassign Vadjmin validation for a VAdjIEEE
   *
   * @param command UnAssignVadjminFromVAdjIEEECommand
   */
  public void validate(UnAssignVadjminFromVAdjIEEECommand command) throws Exception {
    Assert.notNull(command, "UnAssignVadjminFromVAdjIEEECommand should not be null");
    Assert.notNull(
        command.getVAdjIEEEId(),
        "UnAssignVadjminFromVAdjIEEECommand identifier should not be null");
  }
}
