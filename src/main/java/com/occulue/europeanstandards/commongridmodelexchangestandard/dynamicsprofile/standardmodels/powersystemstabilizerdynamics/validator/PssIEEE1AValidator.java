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

public class PssIEEE1AValidator {

  /** default constructor */
  protected PssIEEE1AValidator() {}

  /** factory method */
  public static PssIEEE1AValidator getInstance() {
    return new PssIEEE1AValidator();
  }

  /** handles creation validation for a PssIEEE1A */
  public void validate(CreatePssIEEE1ACommand pssIEEE1A) throws Exception {
    Assert.notNull(pssIEEE1A, "CreatePssIEEE1ACommand should not be null");
    //		Assert.isNull( pssIEEE1A.getPssIEEE1AId(), "CreatePssIEEE1ACommand identifier should be
    // null" );
  }

  /** handles update validation for a PssIEEE1A */
  public void validate(UpdatePssIEEE1ACommand pssIEEE1A) throws Exception {
    Assert.notNull(pssIEEE1A, "UpdatePssIEEE1ACommand should not be null");
    Assert.notNull(
        pssIEEE1A.getPssIEEE1AId(), "UpdatePssIEEE1ACommand identifier should not be null");
  }

  /** handles delete validation for a PssIEEE1A */
  public void validate(DeletePssIEEE1ACommand pssIEEE1A) throws Exception {
    Assert.notNull(pssIEEE1A, "{commandAlias} should not be null");
    Assert.notNull(
        pssIEEE1A.getPssIEEE1AId(), "DeletePssIEEE1ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a PssIEEE1A */
  public void validate(PssIEEE1AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PssIEEE1AFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPssIEEE1AId(), "PssIEEE1AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign A1 validation for a PssIEEE1A
   *
   * @param command AssignA1ToPssIEEE1ACommand
   */
  public void validate(AssignA1ToPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "AssignA1ToPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "AssignA1ToPssIEEE1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA1ToPssIEEE1ACommand assignment should not be null");
  }

  /**
   * handles unassign A1 validation for a PssIEEE1A
   *
   * @param command UnAssignA1FromPssIEEE1ACommand
   */
  public void validate(UnAssignA1FromPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignA1FromPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "UnAssignA1FromPssIEEE1ACommand identifier should not be null");
  }
  /**
   * handles assign A2 validation for a PssIEEE1A
   *
   * @param command AssignA2ToPssIEEE1ACommand
   */
  public void validate(AssignA2ToPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "AssignA2ToPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "AssignA2ToPssIEEE1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA2ToPssIEEE1ACommand assignment should not be null");
  }

  /**
   * handles unassign A2 validation for a PssIEEE1A
   *
   * @param command UnAssignA2FromPssIEEE1ACommand
   */
  public void validate(UnAssignA2FromPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignA2FromPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "UnAssignA2FromPssIEEE1ACommand identifier should not be null");
  }
  /**
   * handles assign Ks validation for a PssIEEE1A
   *
   * @param command AssignKsToPssIEEE1ACommand
   */
  public void validate(AssignKsToPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKsToPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "AssignKsToPssIEEE1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKsToPssIEEE1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ks validation for a PssIEEE1A
   *
   * @param command UnAssignKsFromPssIEEE1ACommand
   */
  public void validate(UnAssignKsFromPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKsFromPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "UnAssignKsFromPssIEEE1ACommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a PssIEEE1A
   *
   * @param command AssignT1ToPssIEEE1ACommand
   */
  public void validate(AssignT1ToPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "AssignT1ToPssIEEE1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToPssIEEE1ACommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a PssIEEE1A
   *
   * @param command UnAssignT1FromPssIEEE1ACommand
   */
  public void validate(UnAssignT1FromPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "UnAssignT1FromPssIEEE1ACommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a PssIEEE1A
   *
   * @param command AssignT2ToPssIEEE1ACommand
   */
  public void validate(AssignT2ToPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "AssignT2ToPssIEEE1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToPssIEEE1ACommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a PssIEEE1A
   *
   * @param command UnAssignT2FromPssIEEE1ACommand
   */
  public void validate(UnAssignT2FromPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "UnAssignT2FromPssIEEE1ACommand identifier should not be null");
  }
  /**
   * handles assign T3 validation for a PssIEEE1A
   *
   * @param command AssignT3ToPssIEEE1ACommand
   */
  public void validate(AssignT3ToPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "AssignT3ToPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "AssignT3ToPssIEEE1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToPssIEEE1ACommand assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a PssIEEE1A
   *
   * @param command UnAssignT3FromPssIEEE1ACommand
   */
  public void validate(UnAssignT3FromPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "UnAssignT3FromPssIEEE1ACommand identifier should not be null");
  }
  /**
   * handles assign T4 validation for a PssIEEE1A
   *
   * @param command AssignT4ToPssIEEE1ACommand
   */
  public void validate(AssignT4ToPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "AssignT4ToPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "AssignT4ToPssIEEE1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToPssIEEE1ACommand assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a PssIEEE1A
   *
   * @param command UnAssignT4FromPssIEEE1ACommand
   */
  public void validate(UnAssignT4FromPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "UnAssignT4FromPssIEEE1ACommand identifier should not be null");
  }
  /**
   * handles assign T5 validation for a PssIEEE1A
   *
   * @param command AssignT5ToPssIEEE1ACommand
   */
  public void validate(AssignT5ToPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "AssignT5ToPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "AssignT5ToPssIEEE1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5ToPssIEEE1ACommand assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a PssIEEE1A
   *
   * @param command UnAssignT5FromPssIEEE1ACommand
   */
  public void validate(UnAssignT5FromPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "UnAssignT5FromPssIEEE1ACommand identifier should not be null");
  }
  /**
   * handles assign T6 validation for a PssIEEE1A
   *
   * @param command AssignT6ToPssIEEE1ACommand
   */
  public void validate(AssignT6ToPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "AssignT6ToPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "AssignT6ToPssIEEE1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT6ToPssIEEE1ACommand assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a PssIEEE1A
   *
   * @param command UnAssignT6FromPssIEEE1ACommand
   */
  public void validate(UnAssignT6FromPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "UnAssignT6FromPssIEEE1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a PssIEEE1A
   *
   * @param command AssignVrmaxToPssIEEE1ACommand
   */
  public void validate(AssignVrmaxToPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "AssignVrmaxToPssIEEE1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToPssIEEE1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a PssIEEE1A
   *
   * @param command UnAssignVrmaxFromPssIEEE1ACommand
   */
  public void validate(UnAssignVrmaxFromPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(),
        "UnAssignVrmaxFromPssIEEE1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a PssIEEE1A
   *
   * @param command AssignVrminToPssIEEE1ACommand
   */
  public void validate(AssignVrminToPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(), "AssignVrminToPssIEEE1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToPssIEEE1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a PssIEEE1A
   *
   * @param command UnAssignVrminFromPssIEEE1ACommand
   */
  public void validate(UnAssignVrminFromPssIEEE1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromPssIEEE1ACommand should not be null");
    Assert.notNull(
        command.getPssIEEE1AId(),
        "UnAssignVrminFromPssIEEE1ACommand identifier should not be null");
  }
}
