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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class PssSKValidator {

  /** default constructor */
  protected PssSKValidator() {}

  /** factory method */
  public static PssSKValidator getInstance() {
    return new PssSKValidator();
  }

  /** handles creation validation for a PssSK */
  public void validate(CreatePssSKCommand pssSK) throws Exception {
    Assert.notNull(pssSK, "CreatePssSKCommand should not be null");
    //		Assert.isNull( pssSK.getPssSKId(), "CreatePssSKCommand identifier should be null" );
  }

  /** handles update validation for a PssSK */
  public void validate(UpdatePssSKCommand pssSK) throws Exception {
    Assert.notNull(pssSK, "UpdatePssSKCommand should not be null");
    Assert.notNull(pssSK.getPssSKId(), "UpdatePssSKCommand identifier should not be null");
  }

  /** handles delete validation for a PssSK */
  public void validate(DeletePssSKCommand pssSK) throws Exception {
    Assert.notNull(pssSK, "{commandAlias} should not be null");
    Assert.notNull(pssSK.getPssSKId(), "DeletePssSKCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PssSK */
  public void validate(PssSKFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PssSKFetchOneSummary should not be null");
    Assert.notNull(summary.getPssSKId(), "PssSKFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign K1 validation for a PssSK
   *
   * @param command AssignK1ToPssSKCommand
   */
  public void validate(AssignK1ToPssSKCommand command) throws Exception {
    Assert.notNull(command, "AssignK1ToPssSKCommand should not be null");
    Assert.notNull(command.getPssSKId(), "AssignK1ToPssSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignK1ToPssSKCommand assignment should not be null");
  }

  /**
   * handles unassign K1 validation for a PssSK
   *
   * @param command UnAssignK1FromPssSKCommand
   */
  public void validate(UnAssignK1FromPssSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK1FromPssSKCommand should not be null");
    Assert.notNull(
        command.getPssSKId(), "UnAssignK1FromPssSKCommand identifier should not be null");
  }
  /**
   * handles assign K2 validation for a PssSK
   *
   * @param command AssignK2ToPssSKCommand
   */
  public void validate(AssignK2ToPssSKCommand command) throws Exception {
    Assert.notNull(command, "AssignK2ToPssSKCommand should not be null");
    Assert.notNull(command.getPssSKId(), "AssignK2ToPssSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignK2ToPssSKCommand assignment should not be null");
  }

  /**
   * handles unassign K2 validation for a PssSK
   *
   * @param command UnAssignK2FromPssSKCommand
   */
  public void validate(UnAssignK2FromPssSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK2FromPssSKCommand should not be null");
    Assert.notNull(
        command.getPssSKId(), "UnAssignK2FromPssSKCommand identifier should not be null");
  }
  /**
   * handles assign K3 validation for a PssSK
   *
   * @param command AssignK3ToPssSKCommand
   */
  public void validate(AssignK3ToPssSKCommand command) throws Exception {
    Assert.notNull(command, "AssignK3ToPssSKCommand should not be null");
    Assert.notNull(command.getPssSKId(), "AssignK3ToPssSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignK3ToPssSKCommand assignment should not be null");
  }

  /**
   * handles unassign K3 validation for a PssSK
   *
   * @param command UnAssignK3FromPssSKCommand
   */
  public void validate(UnAssignK3FromPssSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK3FromPssSKCommand should not be null");
    Assert.notNull(
        command.getPssSKId(), "UnAssignK3FromPssSKCommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a PssSK
   *
   * @param command AssignT1ToPssSKCommand
   */
  public void validate(AssignT1ToPssSKCommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToPssSKCommand should not be null");
    Assert.notNull(command.getPssSKId(), "AssignT1ToPssSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT1ToPssSKCommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a PssSK
   *
   * @param command UnAssignT1FromPssSKCommand
   */
  public void validate(UnAssignT1FromPssSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromPssSKCommand should not be null");
    Assert.notNull(
        command.getPssSKId(), "UnAssignT1FromPssSKCommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a PssSK
   *
   * @param command AssignT2ToPssSKCommand
   */
  public void validate(AssignT2ToPssSKCommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToPssSKCommand should not be null");
    Assert.notNull(command.getPssSKId(), "AssignT2ToPssSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT2ToPssSKCommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a PssSK
   *
   * @param command UnAssignT2FromPssSKCommand
   */
  public void validate(UnAssignT2FromPssSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromPssSKCommand should not be null");
    Assert.notNull(
        command.getPssSKId(), "UnAssignT2FromPssSKCommand identifier should not be null");
  }
  /**
   * handles assign T3 validation for a PssSK
   *
   * @param command AssignT3ToPssSKCommand
   */
  public void validate(AssignT3ToPssSKCommand command) throws Exception {
    Assert.notNull(command, "AssignT3ToPssSKCommand should not be null");
    Assert.notNull(command.getPssSKId(), "AssignT3ToPssSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT3ToPssSKCommand assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a PssSK
   *
   * @param command UnAssignT3FromPssSKCommand
   */
  public void validate(UnAssignT3FromPssSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromPssSKCommand should not be null");
    Assert.notNull(
        command.getPssSKId(), "UnAssignT3FromPssSKCommand identifier should not be null");
  }
  /**
   * handles assign T4 validation for a PssSK
   *
   * @param command AssignT4ToPssSKCommand
   */
  public void validate(AssignT4ToPssSKCommand command) throws Exception {
    Assert.notNull(command, "AssignT4ToPssSKCommand should not be null");
    Assert.notNull(command.getPssSKId(), "AssignT4ToPssSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT4ToPssSKCommand assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a PssSK
   *
   * @param command UnAssignT4FromPssSKCommand
   */
  public void validate(UnAssignT4FromPssSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromPssSKCommand should not be null");
    Assert.notNull(
        command.getPssSKId(), "UnAssignT4FromPssSKCommand identifier should not be null");
  }
  /**
   * handles assign T5 validation for a PssSK
   *
   * @param command AssignT5ToPssSKCommand
   */
  public void validate(AssignT5ToPssSKCommand command) throws Exception {
    Assert.notNull(command, "AssignT5ToPssSKCommand should not be null");
    Assert.notNull(command.getPssSKId(), "AssignT5ToPssSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT5ToPssSKCommand assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a PssSK
   *
   * @param command UnAssignT5FromPssSKCommand
   */
  public void validate(UnAssignT5FromPssSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromPssSKCommand should not be null");
    Assert.notNull(
        command.getPssSKId(), "UnAssignT5FromPssSKCommand identifier should not be null");
  }
  /**
   * handles assign T6 validation for a PssSK
   *
   * @param command AssignT6ToPssSKCommand
   */
  public void validate(AssignT6ToPssSKCommand command) throws Exception {
    Assert.notNull(command, "AssignT6ToPssSKCommand should not be null");
    Assert.notNull(command.getPssSKId(), "AssignT6ToPssSKCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT6ToPssSKCommand assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a PssSK
   *
   * @param command UnAssignT6FromPssSKCommand
   */
  public void validate(UnAssignT6FromPssSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromPssSKCommand should not be null");
    Assert.notNull(
        command.getPssSKId(), "UnAssignT6FromPssSKCommand identifier should not be null");
  }
  /**
   * handles assign Vsmax validation for a PssSK
   *
   * @param command AssignVsmaxToPssSKCommand
   */
  public void validate(AssignVsmaxToPssSKCommand command) throws Exception {
    Assert.notNull(command, "AssignVsmaxToPssSKCommand should not be null");
    Assert.notNull(command.getPssSKId(), "AssignVsmaxToPssSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsmaxToPssSKCommand assignment should not be null");
  }

  /**
   * handles unassign Vsmax validation for a PssSK
   *
   * @param command UnAssignVsmaxFromPssSKCommand
   */
  public void validate(UnAssignVsmaxFromPssSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsmaxFromPssSKCommand should not be null");
    Assert.notNull(
        command.getPssSKId(), "UnAssignVsmaxFromPssSKCommand identifier should not be null");
  }
  /**
   * handles assign Vsmin validation for a PssSK
   *
   * @param command AssignVsminToPssSKCommand
   */
  public void validate(AssignVsminToPssSKCommand command) throws Exception {
    Assert.notNull(command, "AssignVsminToPssSKCommand should not be null");
    Assert.notNull(command.getPssSKId(), "AssignVsminToPssSKCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsminToPssSKCommand assignment should not be null");
  }

  /**
   * handles unassign Vsmin validation for a PssSK
   *
   * @param command UnAssignVsminFromPssSKCommand
   */
  public void validate(UnAssignVsminFromPssSKCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsminFromPssSKCommand should not be null");
    Assert.notNull(
        command.getPssSKId(), "UnAssignVsminFromPssSKCommand identifier should not be null");
  }
}
