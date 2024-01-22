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

public class PssSHValidator {

  /** default constructor */
  protected PssSHValidator() {}

  /** factory method */
  public static PssSHValidator getInstance() {
    return new PssSHValidator();
  }

  /** handles creation validation for a PssSH */
  public void validate(CreatePssSHCommand pssSH) throws Exception {
    Assert.notNull(pssSH, "CreatePssSHCommand should not be null");
    //		Assert.isNull( pssSH.getPssSHId(), "CreatePssSHCommand identifier should be null" );
  }

  /** handles update validation for a PssSH */
  public void validate(UpdatePssSHCommand pssSH) throws Exception {
    Assert.notNull(pssSH, "UpdatePssSHCommand should not be null");
    Assert.notNull(pssSH.getPssSHId(), "UpdatePssSHCommand identifier should not be null");
  }

  /** handles delete validation for a PssSH */
  public void validate(DeletePssSHCommand pssSH) throws Exception {
    Assert.notNull(pssSH, "{commandAlias} should not be null");
    Assert.notNull(pssSH.getPssSHId(), "DeletePssSHCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PssSH */
  public void validate(PssSHFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PssSHFetchOneSummary should not be null");
    Assert.notNull(summary.getPssSHId(), "PssSHFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign K validation for a PssSH
   *
   * @param command AssignKToPssSHCommand
   */
  public void validate(AssignKToPssSHCommand command) throws Exception {
    Assert.notNull(command, "AssignKToPssSHCommand should not be null");
    Assert.notNull(command.getPssSHId(), "AssignKToPssSHCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKToPssSHCommand assignment should not be null");
  }

  /**
   * handles unassign K validation for a PssSH
   *
   * @param command UnAssignKFromPssSHCommand
   */
  public void validate(UnAssignKFromPssSHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKFromPssSHCommand should not be null");
    Assert.notNull(command.getPssSHId(), "UnAssignKFromPssSHCommand identifier should not be null");
  }
  /**
   * handles assign K0 validation for a PssSH
   *
   * @param command AssignK0ToPssSHCommand
   */
  public void validate(AssignK0ToPssSHCommand command) throws Exception {
    Assert.notNull(command, "AssignK0ToPssSHCommand should not be null");
    Assert.notNull(command.getPssSHId(), "AssignK0ToPssSHCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignK0ToPssSHCommand assignment should not be null");
  }

  /**
   * handles unassign K0 validation for a PssSH
   *
   * @param command UnAssignK0FromPssSHCommand
   */
  public void validate(UnAssignK0FromPssSHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK0FromPssSHCommand should not be null");
    Assert.notNull(
        command.getPssSHId(), "UnAssignK0FromPssSHCommand identifier should not be null");
  }
  /**
   * handles assign K1 validation for a PssSH
   *
   * @param command AssignK1ToPssSHCommand
   */
  public void validate(AssignK1ToPssSHCommand command) throws Exception {
    Assert.notNull(command, "AssignK1ToPssSHCommand should not be null");
    Assert.notNull(command.getPssSHId(), "AssignK1ToPssSHCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignK1ToPssSHCommand assignment should not be null");
  }

  /**
   * handles unassign K1 validation for a PssSH
   *
   * @param command UnAssignK1FromPssSHCommand
   */
  public void validate(UnAssignK1FromPssSHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK1FromPssSHCommand should not be null");
    Assert.notNull(
        command.getPssSHId(), "UnAssignK1FromPssSHCommand identifier should not be null");
  }
  /**
   * handles assign K2 validation for a PssSH
   *
   * @param command AssignK2ToPssSHCommand
   */
  public void validate(AssignK2ToPssSHCommand command) throws Exception {
    Assert.notNull(command, "AssignK2ToPssSHCommand should not be null");
    Assert.notNull(command.getPssSHId(), "AssignK2ToPssSHCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignK2ToPssSHCommand assignment should not be null");
  }

  /**
   * handles unassign K2 validation for a PssSH
   *
   * @param command UnAssignK2FromPssSHCommand
   */
  public void validate(UnAssignK2FromPssSHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK2FromPssSHCommand should not be null");
    Assert.notNull(
        command.getPssSHId(), "UnAssignK2FromPssSHCommand identifier should not be null");
  }
  /**
   * handles assign K3 validation for a PssSH
   *
   * @param command AssignK3ToPssSHCommand
   */
  public void validate(AssignK3ToPssSHCommand command) throws Exception {
    Assert.notNull(command, "AssignK3ToPssSHCommand should not be null");
    Assert.notNull(command.getPssSHId(), "AssignK3ToPssSHCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignK3ToPssSHCommand assignment should not be null");
  }

  /**
   * handles unassign K3 validation for a PssSH
   *
   * @param command UnAssignK3FromPssSHCommand
   */
  public void validate(UnAssignK3FromPssSHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK3FromPssSHCommand should not be null");
    Assert.notNull(
        command.getPssSHId(), "UnAssignK3FromPssSHCommand identifier should not be null");
  }
  /**
   * handles assign K4 validation for a PssSH
   *
   * @param command AssignK4ToPssSHCommand
   */
  public void validate(AssignK4ToPssSHCommand command) throws Exception {
    Assert.notNull(command, "AssignK4ToPssSHCommand should not be null");
    Assert.notNull(command.getPssSHId(), "AssignK4ToPssSHCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignK4ToPssSHCommand assignment should not be null");
  }

  /**
   * handles unassign K4 validation for a PssSH
   *
   * @param command UnAssignK4FromPssSHCommand
   */
  public void validate(UnAssignK4FromPssSHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK4FromPssSHCommand should not be null");
    Assert.notNull(
        command.getPssSHId(), "UnAssignK4FromPssSHCommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a PssSH
   *
   * @param command AssignT1ToPssSHCommand
   */
  public void validate(AssignT1ToPssSHCommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToPssSHCommand should not be null");
    Assert.notNull(command.getPssSHId(), "AssignT1ToPssSHCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT1ToPssSHCommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a PssSH
   *
   * @param command UnAssignT1FromPssSHCommand
   */
  public void validate(UnAssignT1FromPssSHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromPssSHCommand should not be null");
    Assert.notNull(
        command.getPssSHId(), "UnAssignT1FromPssSHCommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a PssSH
   *
   * @param command AssignT2ToPssSHCommand
   */
  public void validate(AssignT2ToPssSHCommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToPssSHCommand should not be null");
    Assert.notNull(command.getPssSHId(), "AssignT2ToPssSHCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT2ToPssSHCommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a PssSH
   *
   * @param command UnAssignT2FromPssSHCommand
   */
  public void validate(UnAssignT2FromPssSHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromPssSHCommand should not be null");
    Assert.notNull(
        command.getPssSHId(), "UnAssignT2FromPssSHCommand identifier should not be null");
  }
  /**
   * handles assign T3 validation for a PssSH
   *
   * @param command AssignT3ToPssSHCommand
   */
  public void validate(AssignT3ToPssSHCommand command) throws Exception {
    Assert.notNull(command, "AssignT3ToPssSHCommand should not be null");
    Assert.notNull(command.getPssSHId(), "AssignT3ToPssSHCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT3ToPssSHCommand assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a PssSH
   *
   * @param command UnAssignT3FromPssSHCommand
   */
  public void validate(UnAssignT3FromPssSHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromPssSHCommand should not be null");
    Assert.notNull(
        command.getPssSHId(), "UnAssignT3FromPssSHCommand identifier should not be null");
  }
  /**
   * handles assign T4 validation for a PssSH
   *
   * @param command AssignT4ToPssSHCommand
   */
  public void validate(AssignT4ToPssSHCommand command) throws Exception {
    Assert.notNull(command, "AssignT4ToPssSHCommand should not be null");
    Assert.notNull(command.getPssSHId(), "AssignT4ToPssSHCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT4ToPssSHCommand assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a PssSH
   *
   * @param command UnAssignT4FromPssSHCommand
   */
  public void validate(UnAssignT4FromPssSHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromPssSHCommand should not be null");
    Assert.notNull(
        command.getPssSHId(), "UnAssignT4FromPssSHCommand identifier should not be null");
  }
  /**
   * handles assign Td validation for a PssSH
   *
   * @param command AssignTdToPssSHCommand
   */
  public void validate(AssignTdToPssSHCommand command) throws Exception {
    Assert.notNull(command, "AssignTdToPssSHCommand should not be null");
    Assert.notNull(command.getPssSHId(), "AssignTdToPssSHCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTdToPssSHCommand assignment should not be null");
  }

  /**
   * handles unassign Td validation for a PssSH
   *
   * @param command UnAssignTdFromPssSHCommand
   */
  public void validate(UnAssignTdFromPssSHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdFromPssSHCommand should not be null");
    Assert.notNull(
        command.getPssSHId(), "UnAssignTdFromPssSHCommand identifier should not be null");
  }
  /**
   * handles assign Vsmax validation for a PssSH
   *
   * @param command AssignVsmaxToPssSHCommand
   */
  public void validate(AssignVsmaxToPssSHCommand command) throws Exception {
    Assert.notNull(command, "AssignVsmaxToPssSHCommand should not be null");
    Assert.notNull(command.getPssSHId(), "AssignVsmaxToPssSHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsmaxToPssSHCommand assignment should not be null");
  }

  /**
   * handles unassign Vsmax validation for a PssSH
   *
   * @param command UnAssignVsmaxFromPssSHCommand
   */
  public void validate(UnAssignVsmaxFromPssSHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsmaxFromPssSHCommand should not be null");
    Assert.notNull(
        command.getPssSHId(), "UnAssignVsmaxFromPssSHCommand identifier should not be null");
  }
  /**
   * handles assign Vsmin validation for a PssSH
   *
   * @param command AssignVsminToPssSHCommand
   */
  public void validate(AssignVsminToPssSHCommand command) throws Exception {
    Assert.notNull(command, "AssignVsminToPssSHCommand should not be null");
    Assert.notNull(command.getPssSHId(), "AssignVsminToPssSHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsminToPssSHCommand assignment should not be null");
  }

  /**
   * handles unassign Vsmin validation for a PssSH
   *
   * @param command UnAssignVsminFromPssSHCommand
   */
  public void validate(UnAssignVsminFromPssSHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsminFromPssSHCommand should not be null");
    Assert.notNull(
        command.getPssSHId(), "UnAssignVsminFromPssSHCommand identifier should not be null");
  }
}
