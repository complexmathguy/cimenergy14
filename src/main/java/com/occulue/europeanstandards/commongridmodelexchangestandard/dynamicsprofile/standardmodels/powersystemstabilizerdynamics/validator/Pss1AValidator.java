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

public class Pss1AValidator {

  /** default constructor */
  protected Pss1AValidator() {}

  /** factory method */
  public static Pss1AValidator getInstance() {
    return new Pss1AValidator();
  }

  /** handles creation validation for a Pss1A */
  public void validate(CreatePss1ACommand pss1A) throws Exception {
    Assert.notNull(pss1A, "CreatePss1ACommand should not be null");
    //		Assert.isNull( pss1A.getPss1AId(), "CreatePss1ACommand identifier should be null" );
  }

  /** handles update validation for a Pss1A */
  public void validate(UpdatePss1ACommand pss1A) throws Exception {
    Assert.notNull(pss1A, "UpdatePss1ACommand should not be null");
    Assert.notNull(pss1A.getPss1AId(), "UpdatePss1ACommand identifier should not be null");
  }

  /** handles delete validation for a Pss1A */
  public void validate(DeletePss1ACommand pss1A) throws Exception {
    Assert.notNull(pss1A, "{commandAlias} should not be null");
    Assert.notNull(pss1A.getPss1AId(), "DeletePss1ACommand identifier should not be null");
  }

  /** handles fetchOne validation for a Pss1A */
  public void validate(Pss1AFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "Pss1AFetchOneSummary should not be null");
    Assert.notNull(summary.getPss1AId(), "Pss1AFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign A1 validation for a Pss1A
   *
   * @param command AssignA1ToPss1ACommand
   */
  public void validate(AssignA1ToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignA1ToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignA1ToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignA1ToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign A1 validation for a Pss1A
   *
   * @param command UnAssignA1FromPss1ACommand
   */
  public void validate(UnAssignA1FromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignA1FromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignA1FromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign A2 validation for a Pss1A
   *
   * @param command AssignA2ToPss1ACommand
   */
  public void validate(AssignA2ToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignA2ToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignA2ToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignA2ToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign A2 validation for a Pss1A
   *
   * @param command UnAssignA2FromPss1ACommand
   */
  public void validate(UnAssignA2FromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignA2FromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignA2FromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign A3 validation for a Pss1A
   *
   * @param command AssignA3ToPss1ACommand
   */
  public void validate(AssignA3ToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignA3ToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignA3ToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignA3ToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign A3 validation for a Pss1A
   *
   * @param command UnAssignA3FromPss1ACommand
   */
  public void validate(UnAssignA3FromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignA3FromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignA3FromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign A4 validation for a Pss1A
   *
   * @param command AssignA4ToPss1ACommand
   */
  public void validate(AssignA4ToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignA4ToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignA4ToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignA4ToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign A4 validation for a Pss1A
   *
   * @param command UnAssignA4FromPss1ACommand
   */
  public void validate(UnAssignA4FromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignA4FromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignA4FromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign A5 validation for a Pss1A
   *
   * @param command AssignA5ToPss1ACommand
   */
  public void validate(AssignA5ToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignA5ToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignA5ToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignA5ToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign A5 validation for a Pss1A
   *
   * @param command UnAssignA5FromPss1ACommand
   */
  public void validate(UnAssignA5FromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignA5FromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignA5FromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign A6 validation for a Pss1A
   *
   * @param command AssignA6ToPss1ACommand
   */
  public void validate(AssignA6ToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignA6ToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignA6ToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignA6ToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign A6 validation for a Pss1A
   *
   * @param command UnAssignA6FromPss1ACommand
   */
  public void validate(UnAssignA6FromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignA6FromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignA6FromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign A7 validation for a Pss1A
   *
   * @param command AssignA7ToPss1ACommand
   */
  public void validate(AssignA7ToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignA7ToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignA7ToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignA7ToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign A7 validation for a Pss1A
   *
   * @param command UnAssignA7FromPss1ACommand
   */
  public void validate(UnAssignA7FromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignA7FromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignA7FromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign A8 validation for a Pss1A
   *
   * @param command AssignA8ToPss1ACommand
   */
  public void validate(AssignA8ToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignA8ToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignA8ToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignA8ToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign A8 validation for a Pss1A
   *
   * @param command UnAssignA8FromPss1ACommand
   */
  public void validate(UnAssignA8FromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignA8FromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignA8FromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a Pss1A
   *
   * @param command AssignKdToPss1ACommand
   */
  public void validate(AssignKdToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKdToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignKdToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKdToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a Pss1A
   *
   * @param command UnAssignKdFromPss1ACommand
   */
  public void validate(UnAssignKdFromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignKdFromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign Ks validation for a Pss1A
   *
   * @param command AssignKsToPss1ACommand
   */
  public void validate(AssignKsToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignKsToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignKsToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKsToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign Ks validation for a Pss1A
   *
   * @param command UnAssignKsFromPss1ACommand
   */
  public void validate(UnAssignKsFromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignKsFromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignKsFromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a Pss1A
   *
   * @param command AssignT1ToPss1ACommand
   */
  public void validate(AssignT1ToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignT1ToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT1ToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a Pss1A
   *
   * @param command UnAssignT1FromPss1ACommand
   */
  public void validate(UnAssignT1FromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignT1FromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a Pss1A
   *
   * @param command AssignT2ToPss1ACommand
   */
  public void validate(AssignT2ToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignT2ToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT2ToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a Pss1A
   *
   * @param command UnAssignT2FromPss1ACommand
   */
  public void validate(UnAssignT2FromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignT2FromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign T3 validation for a Pss1A
   *
   * @param command AssignT3ToPss1ACommand
   */
  public void validate(AssignT3ToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignT3ToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignT3ToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT3ToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a Pss1A
   *
   * @param command UnAssignT3FromPss1ACommand
   */
  public void validate(UnAssignT3FromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignT3FromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign T4 validation for a Pss1A
   *
   * @param command AssignT4ToPss1ACommand
   */
  public void validate(AssignT4ToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignT4ToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignT4ToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT4ToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a Pss1A
   *
   * @param command UnAssignT4FromPss1ACommand
   */
  public void validate(UnAssignT4FromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignT4FromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign T5 validation for a Pss1A
   *
   * @param command AssignT5ToPss1ACommand
   */
  public void validate(AssignT5ToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignT5ToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignT5ToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT5ToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a Pss1A
   *
   * @param command UnAssignT5FromPss1ACommand
   */
  public void validate(UnAssignT5FromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignT5FromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign T6 validation for a Pss1A
   *
   * @param command AssignT6ToPss1ACommand
   */
  public void validate(AssignT6ToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignT6ToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignT6ToPss1ACommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT6ToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a Pss1A
   *
   * @param command UnAssignT6FromPss1ACommand
   */
  public void validate(UnAssignT6FromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignT6FromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign Tdelay validation for a Pss1A
   *
   * @param command AssignTdelayToPss1ACommand
   */
  public void validate(AssignTdelayToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignTdelayToPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "AssignTdelayToPss1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdelayToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign Tdelay validation for a Pss1A
   *
   * @param command UnAssignTdelayFromPss1ACommand
   */
  public void validate(UnAssignTdelayFromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdelayFromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignTdelayFromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign Vcl validation for a Pss1A
   *
   * @param command AssignVclToPss1ACommand
   */
  public void validate(AssignVclToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVclToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignVclToPss1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVclToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vcl validation for a Pss1A
   *
   * @param command UnAssignVclFromPss1ACommand
   */
  public void validate(UnAssignVclFromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVclFromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignVclFromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign Vcu validation for a Pss1A
   *
   * @param command AssignVcuToPss1ACommand
   */
  public void validate(AssignVcuToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVcuToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignVcuToPss1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVcuToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vcu validation for a Pss1A
   *
   * @param command UnAssignVcuFromPss1ACommand
   */
  public void validate(UnAssignVcuFromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVcuFromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignVcuFromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a Pss1A
   *
   * @param command AssignVrmaxToPss1ACommand
   */
  public void validate(AssignVrmaxToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignVrmaxToPss1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a Pss1A
   *
   * @param command UnAssignVrmaxFromPss1ACommand
   */
  public void validate(UnAssignVrmaxFromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignVrmaxFromPss1ACommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a Pss1A
   *
   * @param command AssignVrminToPss1ACommand
   */
  public void validate(AssignVrminToPss1ACommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToPss1ACommand should not be null");
    Assert.notNull(command.getPss1AId(), "AssignVrminToPss1ACommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToPss1ACommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a Pss1A
   *
   * @param command UnAssignVrminFromPss1ACommand
   */
  public void validate(UnAssignVrminFromPss1ACommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromPss1ACommand should not be null");
    Assert.notNull(
        command.getPss1AId(), "UnAssignVrminFromPss1ACommand identifier should not be null");
  }
}
