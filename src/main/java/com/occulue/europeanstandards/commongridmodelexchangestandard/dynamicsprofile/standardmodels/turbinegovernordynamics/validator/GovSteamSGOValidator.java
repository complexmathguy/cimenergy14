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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class GovSteamSGOValidator {

  /** default constructor */
  protected GovSteamSGOValidator() {}

  /** factory method */
  public static GovSteamSGOValidator getInstance() {
    return new GovSteamSGOValidator();
  }

  /** handles creation validation for a GovSteamSGO */
  public void validate(CreateGovSteamSGOCommand govSteamSGO) throws Exception {
    Assert.notNull(govSteamSGO, "CreateGovSteamSGOCommand should not be null");
    //		Assert.isNull( govSteamSGO.getGovSteamSGOId(), "CreateGovSteamSGOCommand identifier should
    // be null" );
  }

  /** handles update validation for a GovSteamSGO */
  public void validate(UpdateGovSteamSGOCommand govSteamSGO) throws Exception {
    Assert.notNull(govSteamSGO, "UpdateGovSteamSGOCommand should not be null");
    Assert.notNull(
        govSteamSGO.getGovSteamSGOId(), "UpdateGovSteamSGOCommand identifier should not be null");
  }

  /** handles delete validation for a GovSteamSGO */
  public void validate(DeleteGovSteamSGOCommand govSteamSGO) throws Exception {
    Assert.notNull(govSteamSGO, "{commandAlias} should not be null");
    Assert.notNull(
        govSteamSGO.getGovSteamSGOId(), "DeleteGovSteamSGOCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GovSteamSGO */
  public void validate(GovSteamSGOFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovSteamSGOFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovSteamSGOId(), "GovSteamSGOFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign K1 validation for a GovSteamSGO
   *
   * @param command AssignK1ToGovSteamSGOCommand
   */
  public void validate(AssignK1ToGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "AssignK1ToGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(), "AssignK1ToGovSteamSGOCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK1ToGovSteamSGOCommand assignment should not be null");
  }

  /**
   * handles unassign K1 validation for a GovSteamSGO
   *
   * @param command UnAssignK1FromGovSteamSGOCommand
   */
  public void validate(UnAssignK1FromGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK1FromGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(),
        "UnAssignK1FromGovSteamSGOCommand identifier should not be null");
  }
  /**
   * handles assign K2 validation for a GovSteamSGO
   *
   * @param command AssignK2ToGovSteamSGOCommand
   */
  public void validate(AssignK2ToGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "AssignK2ToGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(), "AssignK2ToGovSteamSGOCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK2ToGovSteamSGOCommand assignment should not be null");
  }

  /**
   * handles unassign K2 validation for a GovSteamSGO
   *
   * @param command UnAssignK2FromGovSteamSGOCommand
   */
  public void validate(UnAssignK2FromGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK2FromGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(),
        "UnAssignK2FromGovSteamSGOCommand identifier should not be null");
  }
  /**
   * handles assign K3 validation for a GovSteamSGO
   *
   * @param command AssignK3ToGovSteamSGOCommand
   */
  public void validate(AssignK3ToGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "AssignK3ToGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(), "AssignK3ToGovSteamSGOCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK3ToGovSteamSGOCommand assignment should not be null");
  }

  /**
   * handles unassign K3 validation for a GovSteamSGO
   *
   * @param command UnAssignK3FromGovSteamSGOCommand
   */
  public void validate(UnAssignK3FromGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK3FromGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(),
        "UnAssignK3FromGovSteamSGOCommand identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovSteamSGO
   *
   * @param command AssignMwbaseToGovSteamSGOCommand
   */
  public void validate(AssignMwbaseToGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(),
        "AssignMwbaseToGovSteamSGOCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovSteamSGOCommand assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovSteamSGO
   *
   * @param command UnAssignMwbaseFromGovSteamSGOCommand
   */
  public void validate(UnAssignMwbaseFromGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(),
        "UnAssignMwbaseFromGovSteamSGOCommand identifier should not be null");
  }
  /**
   * handles assign Pmax validation for a GovSteamSGO
   *
   * @param command AssignPmaxToGovSteamSGOCommand
   */
  public void validate(AssignPmaxToGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "AssignPmaxToGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(), "AssignPmaxToGovSteamSGOCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxToGovSteamSGOCommand assignment should not be null");
  }

  /**
   * handles unassign Pmax validation for a GovSteamSGO
   *
   * @param command UnAssignPmaxFromGovSteamSGOCommand
   */
  public void validate(UnAssignPmaxFromGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxFromGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(),
        "UnAssignPmaxFromGovSteamSGOCommand identifier should not be null");
  }
  /**
   * handles assign Pmin validation for a GovSteamSGO
   *
   * @param command AssignPminToGovSteamSGOCommand
   */
  public void validate(AssignPminToGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "AssignPminToGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(), "AssignPminToGovSteamSGOCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPminToGovSteamSGOCommand assignment should not be null");
  }

  /**
   * handles unassign Pmin validation for a GovSteamSGO
   *
   * @param command UnAssignPminFromGovSteamSGOCommand
   */
  public void validate(UnAssignPminFromGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPminFromGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(),
        "UnAssignPminFromGovSteamSGOCommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a GovSteamSGO
   *
   * @param command AssignT1ToGovSteamSGOCommand
   */
  public void validate(AssignT1ToGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(), "AssignT1ToGovSteamSGOCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToGovSteamSGOCommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a GovSteamSGO
   *
   * @param command UnAssignT1FromGovSteamSGOCommand
   */
  public void validate(UnAssignT1FromGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(),
        "UnAssignT1FromGovSteamSGOCommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a GovSteamSGO
   *
   * @param command AssignT2ToGovSteamSGOCommand
   */
  public void validate(AssignT2ToGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(), "AssignT2ToGovSteamSGOCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToGovSteamSGOCommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a GovSteamSGO
   *
   * @param command UnAssignT2FromGovSteamSGOCommand
   */
  public void validate(UnAssignT2FromGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(),
        "UnAssignT2FromGovSteamSGOCommand identifier should not be null");
  }
  /**
   * handles assign T3 validation for a GovSteamSGO
   *
   * @param command AssignT3ToGovSteamSGOCommand
   */
  public void validate(AssignT3ToGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "AssignT3ToGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(), "AssignT3ToGovSteamSGOCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToGovSteamSGOCommand assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a GovSteamSGO
   *
   * @param command UnAssignT3FromGovSteamSGOCommand
   */
  public void validate(UnAssignT3FromGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(),
        "UnAssignT3FromGovSteamSGOCommand identifier should not be null");
  }
  /**
   * handles assign T4 validation for a GovSteamSGO
   *
   * @param command AssignT4ToGovSteamSGOCommand
   */
  public void validate(AssignT4ToGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "AssignT4ToGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(), "AssignT4ToGovSteamSGOCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToGovSteamSGOCommand assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a GovSteamSGO
   *
   * @param command UnAssignT4FromGovSteamSGOCommand
   */
  public void validate(UnAssignT4FromGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(),
        "UnAssignT4FromGovSteamSGOCommand identifier should not be null");
  }
  /**
   * handles assign T5 validation for a GovSteamSGO
   *
   * @param command AssignT5ToGovSteamSGOCommand
   */
  public void validate(AssignT5ToGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "AssignT5ToGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(), "AssignT5ToGovSteamSGOCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5ToGovSteamSGOCommand assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a GovSteamSGO
   *
   * @param command UnAssignT5FromGovSteamSGOCommand
   */
  public void validate(UnAssignT5FromGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(),
        "UnAssignT5FromGovSteamSGOCommand identifier should not be null");
  }
  /**
   * handles assign T6 validation for a GovSteamSGO
   *
   * @param command AssignT6ToGovSteamSGOCommand
   */
  public void validate(AssignT6ToGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "AssignT6ToGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(), "AssignT6ToGovSteamSGOCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT6ToGovSteamSGOCommand assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a GovSteamSGO
   *
   * @param command UnAssignT6FromGovSteamSGOCommand
   */
  public void validate(UnAssignT6FromGovSteamSGOCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromGovSteamSGOCommand should not be null");
    Assert.notNull(
        command.getGovSteamSGOId(),
        "UnAssignT6FromGovSteamSGOCommand identifier should not be null");
  }
}
