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

public class GovGASTValidator {

  /** default constructor */
  protected GovGASTValidator() {}

  /** factory method */
  public static GovGASTValidator getInstance() {
    return new GovGASTValidator();
  }

  /** handles creation validation for a GovGAST */
  public void validate(CreateGovGASTCommand govGAST) throws Exception {
    Assert.notNull(govGAST, "CreateGovGASTCommand should not be null");
    //		Assert.isNull( govGAST.getGovGASTId(), "CreateGovGASTCommand identifier should be null" );
  }

  /** handles update validation for a GovGAST */
  public void validate(UpdateGovGASTCommand govGAST) throws Exception {
    Assert.notNull(govGAST, "UpdateGovGASTCommand should not be null");
    Assert.notNull(govGAST.getGovGASTId(), "UpdateGovGASTCommand identifier should not be null");
  }

  /** handles delete validation for a GovGAST */
  public void validate(DeleteGovGASTCommand govGAST) throws Exception {
    Assert.notNull(govGAST, "{commandAlias} should not be null");
    Assert.notNull(govGAST.getGovGASTId(), "DeleteGovGASTCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GovGAST */
  public void validate(GovGASTFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovGASTFetchOneSummary should not be null");
    Assert.notNull(summary.getGovGASTId(), "GovGASTFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign At validation for a GovGAST
   *
   * @param command AssignAtToGovGASTCommand
   */
  public void validate(AssignAtToGovGASTCommand command) throws Exception {
    Assert.notNull(command, "AssignAtToGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "AssignAtToGovGASTCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAtToGovGASTCommand assignment should not be null");
  }

  /**
   * handles unassign At validation for a GovGAST
   *
   * @param command UnAssignAtFromGovGASTCommand
   */
  public void validate(UnAssignAtFromGovGASTCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAtFromGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "UnAssignAtFromGovGASTCommand identifier should not be null");
  }
  /**
   * handles assign Dturb validation for a GovGAST
   *
   * @param command AssignDturbToGovGASTCommand
   */
  public void validate(AssignDturbToGovGASTCommand command) throws Exception {
    Assert.notNull(command, "AssignDturbToGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "AssignDturbToGovGASTCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDturbToGovGASTCommand assignment should not be null");
  }

  /**
   * handles unassign Dturb validation for a GovGAST
   *
   * @param command UnAssignDturbFromGovGASTCommand
   */
  public void validate(UnAssignDturbFromGovGASTCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDturbFromGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "UnAssignDturbFromGovGASTCommand identifier should not be null");
  }
  /**
   * handles assign Kt validation for a GovGAST
   *
   * @param command AssignKtToGovGASTCommand
   */
  public void validate(AssignKtToGovGASTCommand command) throws Exception {
    Assert.notNull(command, "AssignKtToGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "AssignKtToGovGASTCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKtToGovGASTCommand assignment should not be null");
  }

  /**
   * handles unassign Kt validation for a GovGAST
   *
   * @param command UnAssignKtFromGovGASTCommand
   */
  public void validate(UnAssignKtFromGovGASTCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKtFromGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "UnAssignKtFromGovGASTCommand identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovGAST
   *
   * @param command AssignMwbaseToGovGASTCommand
   */
  public void validate(AssignMwbaseToGovGASTCommand command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "AssignMwbaseToGovGASTCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovGASTCommand assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovGAST
   *
   * @param command UnAssignMwbaseFromGovGASTCommand
   */
  public void validate(UnAssignMwbaseFromGovGASTCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "UnAssignMwbaseFromGovGASTCommand identifier should not be null");
  }
  /**
   * handles assign R validation for a GovGAST
   *
   * @param command AssignRToGovGASTCommand
   */
  public void validate(AssignRToGovGASTCommand command) throws Exception {
    Assert.notNull(command, "AssignRToGovGASTCommand should not be null");
    Assert.notNull(command.getGovGASTId(), "AssignRToGovGASTCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRToGovGASTCommand assignment should not be null");
  }

  /**
   * handles unassign R validation for a GovGAST
   *
   * @param command UnAssignRFromGovGASTCommand
   */
  public void validate(UnAssignRFromGovGASTCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRFromGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "UnAssignRFromGovGASTCommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a GovGAST
   *
   * @param command AssignT1ToGovGASTCommand
   */
  public void validate(AssignT1ToGovGASTCommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "AssignT1ToGovGASTCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToGovGASTCommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a GovGAST
   *
   * @param command UnAssignT1FromGovGASTCommand
   */
  public void validate(UnAssignT1FromGovGASTCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "UnAssignT1FromGovGASTCommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a GovGAST
   *
   * @param command AssignT2ToGovGASTCommand
   */
  public void validate(AssignT2ToGovGASTCommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "AssignT2ToGovGASTCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToGovGASTCommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a GovGAST
   *
   * @param command UnAssignT2FromGovGASTCommand
   */
  public void validate(UnAssignT2FromGovGASTCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "UnAssignT2FromGovGASTCommand identifier should not be null");
  }
  /**
   * handles assign T3 validation for a GovGAST
   *
   * @param command AssignT3ToGovGASTCommand
   */
  public void validate(AssignT3ToGovGASTCommand command) throws Exception {
    Assert.notNull(command, "AssignT3ToGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "AssignT3ToGovGASTCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToGovGASTCommand assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a GovGAST
   *
   * @param command UnAssignT3FromGovGASTCommand
   */
  public void validate(UnAssignT3FromGovGASTCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "UnAssignT3FromGovGASTCommand identifier should not be null");
  }
  /**
   * handles assign Vmax validation for a GovGAST
   *
   * @param command AssignVmaxToGovGASTCommand
   */
  public void validate(AssignVmaxToGovGASTCommand command) throws Exception {
    Assert.notNull(command, "AssignVmaxToGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "AssignVmaxToGovGASTCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmaxToGovGASTCommand assignment should not be null");
  }

  /**
   * handles unassign Vmax validation for a GovGAST
   *
   * @param command UnAssignVmaxFromGovGASTCommand
   */
  public void validate(UnAssignVmaxFromGovGASTCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVmaxFromGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "UnAssignVmaxFromGovGASTCommand identifier should not be null");
  }
  /**
   * handles assign Vmin validation for a GovGAST
   *
   * @param command AssignVminToGovGASTCommand
   */
  public void validate(AssignVminToGovGASTCommand command) throws Exception {
    Assert.notNull(command, "AssignVminToGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "AssignVminToGovGASTCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVminToGovGASTCommand assignment should not be null");
  }

  /**
   * handles unassign Vmin validation for a GovGAST
   *
   * @param command UnAssignVminFromGovGASTCommand
   */
  public void validate(UnAssignVminFromGovGASTCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVminFromGovGASTCommand should not be null");
    Assert.notNull(
        command.getGovGASTId(), "UnAssignVminFromGovGASTCommand identifier should not be null");
  }
}
