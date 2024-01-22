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

public class PssIEEE2BValidator {

  /** default constructor */
  protected PssIEEE2BValidator() {}

  /** factory method */
  public static PssIEEE2BValidator getInstance() {
    return new PssIEEE2BValidator();
  }

  /** handles creation validation for a PssIEEE2B */
  public void validate(CreatePssIEEE2BCommand pssIEEE2B) throws Exception {
    Assert.notNull(pssIEEE2B, "CreatePssIEEE2BCommand should not be null");
    //		Assert.isNull( pssIEEE2B.getPssIEEE2BId(), "CreatePssIEEE2BCommand identifier should be
    // null" );
  }

  /** handles update validation for a PssIEEE2B */
  public void validate(UpdatePssIEEE2BCommand pssIEEE2B) throws Exception {
    Assert.notNull(pssIEEE2B, "UpdatePssIEEE2BCommand should not be null");
    Assert.notNull(
        pssIEEE2B.getPssIEEE2BId(), "UpdatePssIEEE2BCommand identifier should not be null");
  }

  /** handles delete validation for a PssIEEE2B */
  public void validate(DeletePssIEEE2BCommand pssIEEE2B) throws Exception {
    Assert.notNull(pssIEEE2B, "{commandAlias} should not be null");
    Assert.notNull(
        pssIEEE2B.getPssIEEE2BId(), "DeletePssIEEE2BCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PssIEEE2B */
  public void validate(PssIEEE2BFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PssIEEE2BFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPssIEEE2BId(), "PssIEEE2BFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ks1 validation for a PssIEEE2B
   *
   * @param command AssignKs1ToPssIEEE2BCommand
   */
  public void validate(AssignKs1ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignKs1ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignKs1ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKs1ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign Ks1 validation for a PssIEEE2B
   *
   * @param command UnAssignKs1FromPssIEEE2BCommand
   */
  public void validate(UnAssignKs1FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKs1FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignKs1FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign Ks2 validation for a PssIEEE2B
   *
   * @param command AssignKs2ToPssIEEE2BCommand
   */
  public void validate(AssignKs2ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignKs2ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignKs2ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKs2ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign Ks2 validation for a PssIEEE2B
   *
   * @param command UnAssignKs2FromPssIEEE2BCommand
   */
  public void validate(UnAssignKs2FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKs2FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignKs2FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign Ks3 validation for a PssIEEE2B
   *
   * @param command AssignKs3ToPssIEEE2BCommand
   */
  public void validate(AssignKs3ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignKs3ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignKs3ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKs3ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign Ks3 validation for a PssIEEE2B
   *
   * @param command UnAssignKs3FromPssIEEE2BCommand
   */
  public void validate(UnAssignKs3FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKs3FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignKs3FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign M validation for a PssIEEE2B
   *
   * @param command AssignMToPssIEEE2BCommand
   */
  public void validate(AssignMToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignMToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignMToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign M validation for a PssIEEE2B
   *
   * @param command UnAssignMFromPssIEEE2BCommand
   */
  public void validate(UnAssignMFromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMFromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignMFromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign N validation for a PssIEEE2B
   *
   * @param command AssignNToPssIEEE2BCommand
   */
  public void validate(AssignNToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignNToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignNToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignNToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign N validation for a PssIEEE2B
   *
   * @param command UnAssignNFromPssIEEE2BCommand
   */
  public void validate(UnAssignNFromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNFromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignNFromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a PssIEEE2B
   *
   * @param command AssignT1ToPssIEEE2BCommand
   */
  public void validate(AssignT1ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignT1ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a PssIEEE2B
   *
   * @param command UnAssignT1FromPssIEEE2BCommand
   */
  public void validate(UnAssignT1FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignT1FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign T10 validation for a PssIEEE2B
   *
   * @param command AssignT10ToPssIEEE2BCommand
   */
  public void validate(AssignT10ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT10ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignT10ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT10ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign T10 validation for a PssIEEE2B
   *
   * @param command UnAssignT10FromPssIEEE2BCommand
   */
  public void validate(UnAssignT10FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT10FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignT10FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign T11 validation for a PssIEEE2B
   *
   * @param command AssignT11ToPssIEEE2BCommand
   */
  public void validate(AssignT11ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT11ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignT11ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT11ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign T11 validation for a PssIEEE2B
   *
   * @param command UnAssignT11FromPssIEEE2BCommand
   */
  public void validate(UnAssignT11FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT11FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignT11FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a PssIEEE2B
   *
   * @param command AssignT2ToPssIEEE2BCommand
   */
  public void validate(AssignT2ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignT2ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a PssIEEE2B
   *
   * @param command UnAssignT2FromPssIEEE2BCommand
   */
  public void validate(UnAssignT2FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignT2FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign T3 validation for a PssIEEE2B
   *
   * @param command AssignT3ToPssIEEE2BCommand
   */
  public void validate(AssignT3ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT3ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignT3ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a PssIEEE2B
   *
   * @param command UnAssignT3FromPssIEEE2BCommand
   */
  public void validate(UnAssignT3FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignT3FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign T4 validation for a PssIEEE2B
   *
   * @param command AssignT4ToPssIEEE2BCommand
   */
  public void validate(AssignT4ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT4ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignT4ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a PssIEEE2B
   *
   * @param command UnAssignT4FromPssIEEE2BCommand
   */
  public void validate(UnAssignT4FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignT4FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign T6 validation for a PssIEEE2B
   *
   * @param command AssignT6ToPssIEEE2BCommand
   */
  public void validate(AssignT6ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT6ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignT6ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT6ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a PssIEEE2B
   *
   * @param command UnAssignT6FromPssIEEE2BCommand
   */
  public void validate(UnAssignT6FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignT6FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign T7 validation for a PssIEEE2B
   *
   * @param command AssignT7ToPssIEEE2BCommand
   */
  public void validate(AssignT7ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT7ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignT7ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT7ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign T7 validation for a PssIEEE2B
   *
   * @param command UnAssignT7FromPssIEEE2BCommand
   */
  public void validate(UnAssignT7FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT7FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignT7FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign T8 validation for a PssIEEE2B
   *
   * @param command AssignT8ToPssIEEE2BCommand
   */
  public void validate(AssignT8ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT8ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignT8ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT8ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign T8 validation for a PssIEEE2B
   *
   * @param command UnAssignT8FromPssIEEE2BCommand
   */
  public void validate(UnAssignT8FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT8FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignT8FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign T9 validation for a PssIEEE2B
   *
   * @param command AssignT9ToPssIEEE2BCommand
   */
  public void validate(AssignT9ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT9ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignT9ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT9ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign T9 validation for a PssIEEE2B
   *
   * @param command UnAssignT9FromPssIEEE2BCommand
   */
  public void validate(UnAssignT9FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT9FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignT9FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign Tw1 validation for a PssIEEE2B
   *
   * @param command AssignTw1ToPssIEEE2BCommand
   */
  public void validate(AssignTw1ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignTw1ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignTw1ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTw1ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign Tw1 validation for a PssIEEE2B
   *
   * @param command UnAssignTw1FromPssIEEE2BCommand
   */
  public void validate(UnAssignTw1FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTw1FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignTw1FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign Tw2 validation for a PssIEEE2B
   *
   * @param command AssignTw2ToPssIEEE2BCommand
   */
  public void validate(AssignTw2ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignTw2ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignTw2ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTw2ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign Tw2 validation for a PssIEEE2B
   *
   * @param command UnAssignTw2FromPssIEEE2BCommand
   */
  public void validate(UnAssignTw2FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTw2FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignTw2FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign Tw3 validation for a PssIEEE2B
   *
   * @param command AssignTw3ToPssIEEE2BCommand
   */
  public void validate(AssignTw3ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignTw3ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignTw3ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTw3ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign Tw3 validation for a PssIEEE2B
   *
   * @param command UnAssignTw3FromPssIEEE2BCommand
   */
  public void validate(UnAssignTw3FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTw3FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignTw3FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign Tw4 validation for a PssIEEE2B
   *
   * @param command AssignTw4ToPssIEEE2BCommand
   */
  public void validate(AssignTw4ToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignTw4ToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignTw4ToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTw4ToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign Tw4 validation for a PssIEEE2B
   *
   * @param command UnAssignTw4FromPssIEEE2BCommand
   */
  public void validate(UnAssignTw4FromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTw4FromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "UnAssignTw4FromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign Vsi1max validation for a PssIEEE2B
   *
   * @param command AssignVsi1maxToPssIEEE2BCommand
   */
  public void validate(AssignVsi1maxToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignVsi1maxToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignVsi1maxToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsi1maxToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign Vsi1max validation for a PssIEEE2B
   *
   * @param command UnAssignVsi1maxFromPssIEEE2BCommand
   */
  public void validate(UnAssignVsi1maxFromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsi1maxFromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(),
        "UnAssignVsi1maxFromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign Vsi1min validation for a PssIEEE2B
   *
   * @param command AssignVsi1minToPssIEEE2BCommand
   */
  public void validate(AssignVsi1minToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignVsi1minToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignVsi1minToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsi1minToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign Vsi1min validation for a PssIEEE2B
   *
   * @param command UnAssignVsi1minFromPssIEEE2BCommand
   */
  public void validate(UnAssignVsi1minFromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsi1minFromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(),
        "UnAssignVsi1minFromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign Vsi2max validation for a PssIEEE2B
   *
   * @param command AssignVsi2maxToPssIEEE2BCommand
   */
  public void validate(AssignVsi2maxToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignVsi2maxToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignVsi2maxToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsi2maxToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign Vsi2max validation for a PssIEEE2B
   *
   * @param command UnAssignVsi2maxFromPssIEEE2BCommand
   */
  public void validate(UnAssignVsi2maxFromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsi2maxFromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(),
        "UnAssignVsi2maxFromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign Vsi2min validation for a PssIEEE2B
   *
   * @param command AssignVsi2minToPssIEEE2BCommand
   */
  public void validate(AssignVsi2minToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignVsi2minToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignVsi2minToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsi2minToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign Vsi2min validation for a PssIEEE2B
   *
   * @param command UnAssignVsi2minFromPssIEEE2BCommand
   */
  public void validate(UnAssignVsi2minFromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsi2minFromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(),
        "UnAssignVsi2minFromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign Vstmax validation for a PssIEEE2B
   *
   * @param command AssignVstmaxToPssIEEE2BCommand
   */
  public void validate(AssignVstmaxToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignVstmaxToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignVstmaxToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVstmaxToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign Vstmax validation for a PssIEEE2B
   *
   * @param command UnAssignVstmaxFromPssIEEE2BCommand
   */
  public void validate(UnAssignVstmaxFromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVstmaxFromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(),
        "UnAssignVstmaxFromPssIEEE2BCommand identifier should not be null");
  }
  /**
   * handles assign Vstmin validation for a PssIEEE2B
   *
   * @param command AssignVstminToPssIEEE2BCommand
   */
  public void validate(AssignVstminToPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "AssignVstminToPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(), "AssignVstminToPssIEEE2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVstminToPssIEEE2BCommand assignment should not be null");
  }

  /**
   * handles unassign Vstmin validation for a PssIEEE2B
   *
   * @param command UnAssignVstminFromPssIEEE2BCommand
   */
  public void validate(UnAssignVstminFromPssIEEE2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVstminFromPssIEEE2BCommand should not be null");
    Assert.notNull(
        command.getPssIEEE2BId(),
        "UnAssignVstminFromPssIEEE2BCommand identifier should not be null");
  }
}
