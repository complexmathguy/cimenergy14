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

public class PssIEEE3BValidator {

  /** default constructor */
  protected PssIEEE3BValidator() {}

  /** factory method */
  public static PssIEEE3BValidator getInstance() {
    return new PssIEEE3BValidator();
  }

  /** handles creation validation for a PssIEEE3B */
  public void validate(CreatePssIEEE3BCommand pssIEEE3B) throws Exception {
    Assert.notNull(pssIEEE3B, "CreatePssIEEE3BCommand should not be null");
    //		Assert.isNull( pssIEEE3B.getPssIEEE3BId(), "CreatePssIEEE3BCommand identifier should be
    // null" );
  }

  /** handles update validation for a PssIEEE3B */
  public void validate(UpdatePssIEEE3BCommand pssIEEE3B) throws Exception {
    Assert.notNull(pssIEEE3B, "UpdatePssIEEE3BCommand should not be null");
    Assert.notNull(
        pssIEEE3B.getPssIEEE3BId(), "UpdatePssIEEE3BCommand identifier should not be null");
  }

  /** handles delete validation for a PssIEEE3B */
  public void validate(DeletePssIEEE3BCommand pssIEEE3B) throws Exception {
    Assert.notNull(pssIEEE3B, "{commandAlias} should not be null");
    Assert.notNull(
        pssIEEE3B.getPssIEEE3BId(), "DeletePssIEEE3BCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PssIEEE3B */
  public void validate(PssIEEE3BFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PssIEEE3BFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPssIEEE3BId(), "PssIEEE3BFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign A1 validation for a PssIEEE3B
   *
   * @param command AssignA1ToPssIEEE3BCommand
   */
  public void validate(AssignA1ToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignA1ToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignA1ToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA1ToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign A1 validation for a PssIEEE3B
   *
   * @param command UnAssignA1FromPssIEEE3BCommand
   */
  public void validate(UnAssignA1FromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignA1FromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "UnAssignA1FromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign A2 validation for a PssIEEE3B
   *
   * @param command AssignA2ToPssIEEE3BCommand
   */
  public void validate(AssignA2ToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignA2ToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignA2ToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA2ToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign A2 validation for a PssIEEE3B
   *
   * @param command UnAssignA2FromPssIEEE3BCommand
   */
  public void validate(UnAssignA2FromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignA2FromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "UnAssignA2FromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign A3 validation for a PssIEEE3B
   *
   * @param command AssignA3ToPssIEEE3BCommand
   */
  public void validate(AssignA3ToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignA3ToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignA3ToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA3ToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign A3 validation for a PssIEEE3B
   *
   * @param command UnAssignA3FromPssIEEE3BCommand
   */
  public void validate(UnAssignA3FromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignA3FromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "UnAssignA3FromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign A4 validation for a PssIEEE3B
   *
   * @param command AssignA4ToPssIEEE3BCommand
   */
  public void validate(AssignA4ToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignA4ToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignA4ToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA4ToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign A4 validation for a PssIEEE3B
   *
   * @param command UnAssignA4FromPssIEEE3BCommand
   */
  public void validate(UnAssignA4FromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignA4FromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "UnAssignA4FromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign A5 validation for a PssIEEE3B
   *
   * @param command AssignA5ToPssIEEE3BCommand
   */
  public void validate(AssignA5ToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignA5ToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignA5ToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA5ToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign A5 validation for a PssIEEE3B
   *
   * @param command UnAssignA5FromPssIEEE3BCommand
   */
  public void validate(UnAssignA5FromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignA5FromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "UnAssignA5FromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign A6 validation for a PssIEEE3B
   *
   * @param command AssignA6ToPssIEEE3BCommand
   */
  public void validate(AssignA6ToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignA6ToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignA6ToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA6ToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign A6 validation for a PssIEEE3B
   *
   * @param command UnAssignA6FromPssIEEE3BCommand
   */
  public void validate(UnAssignA6FromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignA6FromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "UnAssignA6FromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign A7 validation for a PssIEEE3B
   *
   * @param command AssignA7ToPssIEEE3BCommand
   */
  public void validate(AssignA7ToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignA7ToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignA7ToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA7ToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign A7 validation for a PssIEEE3B
   *
   * @param command UnAssignA7FromPssIEEE3BCommand
   */
  public void validate(UnAssignA7FromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignA7FromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "UnAssignA7FromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign A8 validation for a PssIEEE3B
   *
   * @param command AssignA8ToPssIEEE3BCommand
   */
  public void validate(AssignA8ToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignA8ToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignA8ToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA8ToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign A8 validation for a PssIEEE3B
   *
   * @param command UnAssignA8FromPssIEEE3BCommand
   */
  public void validate(UnAssignA8FromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignA8FromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "UnAssignA8FromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign Ks1 validation for a PssIEEE3B
   *
   * @param command AssignKs1ToPssIEEE3BCommand
   */
  public void validate(AssignKs1ToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignKs1ToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignKs1ToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKs1ToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign Ks1 validation for a PssIEEE3B
   *
   * @param command UnAssignKs1FromPssIEEE3BCommand
   */
  public void validate(UnAssignKs1FromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKs1FromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "UnAssignKs1FromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign Ks2 validation for a PssIEEE3B
   *
   * @param command AssignKs2ToPssIEEE3BCommand
   */
  public void validate(AssignKs2ToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignKs2ToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignKs2ToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKs2ToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign Ks2 validation for a PssIEEE3B
   *
   * @param command UnAssignKs2FromPssIEEE3BCommand
   */
  public void validate(UnAssignKs2FromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKs2FromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "UnAssignKs2FromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a PssIEEE3B
   *
   * @param command AssignT1ToPssIEEE3BCommand
   */
  public void validate(AssignT1ToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignT1ToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a PssIEEE3B
   *
   * @param command UnAssignT1FromPssIEEE3BCommand
   */
  public void validate(UnAssignT1FromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "UnAssignT1FromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a PssIEEE3B
   *
   * @param command AssignT2ToPssIEEE3BCommand
   */
  public void validate(AssignT2ToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignT2ToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a PssIEEE3B
   *
   * @param command UnAssignT2FromPssIEEE3BCommand
   */
  public void validate(UnAssignT2FromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "UnAssignT2FromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign Tw1 validation for a PssIEEE3B
   *
   * @param command AssignTw1ToPssIEEE3BCommand
   */
  public void validate(AssignTw1ToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignTw1ToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignTw1ToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTw1ToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign Tw1 validation for a PssIEEE3B
   *
   * @param command UnAssignTw1FromPssIEEE3BCommand
   */
  public void validate(UnAssignTw1FromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTw1FromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "UnAssignTw1FromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign Tw2 validation for a PssIEEE3B
   *
   * @param command AssignTw2ToPssIEEE3BCommand
   */
  public void validate(AssignTw2ToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignTw2ToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignTw2ToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTw2ToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign Tw2 validation for a PssIEEE3B
   *
   * @param command UnAssignTw2FromPssIEEE3BCommand
   */
  public void validate(UnAssignTw2FromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTw2FromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "UnAssignTw2FromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign Tw3 validation for a PssIEEE3B
   *
   * @param command AssignTw3ToPssIEEE3BCommand
   */
  public void validate(AssignTw3ToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignTw3ToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignTw3ToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTw3ToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign Tw3 validation for a PssIEEE3B
   *
   * @param command UnAssignTw3FromPssIEEE3BCommand
   */
  public void validate(UnAssignTw3FromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTw3FromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "UnAssignTw3FromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign Vstmax validation for a PssIEEE3B
   *
   * @param command AssignVstmaxToPssIEEE3BCommand
   */
  public void validate(AssignVstmaxToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignVstmaxToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignVstmaxToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVstmaxToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign Vstmax validation for a PssIEEE3B
   *
   * @param command UnAssignVstmaxFromPssIEEE3BCommand
   */
  public void validate(UnAssignVstmaxFromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVstmaxFromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(),
        "UnAssignVstmaxFromPssIEEE3BCommand identifier should not be null");
  }
  /**
   * handles assign Vstmin validation for a PssIEEE3B
   *
   * @param command AssignVstminToPssIEEE3BCommand
   */
  public void validate(AssignVstminToPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "AssignVstminToPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(), "AssignVstminToPssIEEE3BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVstminToPssIEEE3BCommand assignment should not be null");
  }

  /**
   * handles unassign Vstmin validation for a PssIEEE3B
   *
   * @param command UnAssignVstminFromPssIEEE3BCommand
   */
  public void validate(UnAssignVstminFromPssIEEE3BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVstminFromPssIEEE3BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE3BId(),
        "UnAssignVstminFromPssIEEE3BCommand identifier should not be null");
  }
}
