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

public class Pss2BValidator {

  /** default constructor */
  protected Pss2BValidator() {}

  /** factory method */
  public static Pss2BValidator getInstance() {
    return new Pss2BValidator();
  }

  /** handles creation validation for a Pss2B */
  public void validate(CreatePss2BCommand pss2B) throws Exception {
    Assert.notNull(pss2B, "CreatePss2BCommand should not be null");
    //		Assert.isNull( pss2B.getPss2BId(), "CreatePss2BCommand identifier should be null" );
  }

  /** handles update validation for a Pss2B */
  public void validate(UpdatePss2BCommand pss2B) throws Exception {
    Assert.notNull(pss2B, "UpdatePss2BCommand should not be null");
    Assert.notNull(pss2B.getPss2BId(), "UpdatePss2BCommand identifier should not be null");
  }

  /** handles delete validation for a Pss2B */
  public void validate(DeletePss2BCommand pss2B) throws Exception {
    Assert.notNull(pss2B, "{commandAlias} should not be null");
    Assert.notNull(pss2B.getPss2BId(), "DeletePss2BCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Pss2B */
  public void validate(Pss2BFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "Pss2BFetchOneSummary should not be null");
    Assert.notNull(summary.getPss2BId(), "Pss2BFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign A validation for a Pss2B
   *
   * @param command AssignAToPss2BCommand
   */
  public void validate(AssignAToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignAToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignAToPss2BCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignAToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign A validation for a Pss2B
   *
   * @param command UnAssignAFromPss2BCommand
   */
  public void validate(UnAssignAFromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAFromPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "UnAssignAFromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Ks1 validation for a Pss2B
   *
   * @param command AssignKs1ToPss2BCommand
   */
  public void validate(AssignKs1ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignKs1ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignKs1ToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKs1ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Ks1 validation for a Pss2B
   *
   * @param command UnAssignKs1FromPss2BCommand
   */
  public void validate(UnAssignKs1FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKs1FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignKs1FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Ks2 validation for a Pss2B
   *
   * @param command AssignKs2ToPss2BCommand
   */
  public void validate(AssignKs2ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignKs2ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignKs2ToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKs2ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Ks2 validation for a Pss2B
   *
   * @param command UnAssignKs2FromPss2BCommand
   */
  public void validate(UnAssignKs2FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKs2FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignKs2FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Ks3 validation for a Pss2B
   *
   * @param command AssignKs3ToPss2BCommand
   */
  public void validate(AssignKs3ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignKs3ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignKs3ToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKs3ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Ks3 validation for a Pss2B
   *
   * @param command UnAssignKs3FromPss2BCommand
   */
  public void validate(UnAssignKs3FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKs3FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignKs3FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Ks4 validation for a Pss2B
   *
   * @param command AssignKs4ToPss2BCommand
   */
  public void validate(AssignKs4ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignKs4ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignKs4ToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKs4ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Ks4 validation for a Pss2B
   *
   * @param command UnAssignKs4FromPss2BCommand
   */
  public void validate(UnAssignKs4FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKs4FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignKs4FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign M validation for a Pss2B
   *
   * @param command AssignMToPss2BCommand
   */
  public void validate(AssignMToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignMToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignMToPss2BCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignMToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign M validation for a Pss2B
   *
   * @param command UnAssignMFromPss2BCommand
   */
  public void validate(UnAssignMFromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMFromPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "UnAssignMFromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign N validation for a Pss2B
   *
   * @param command AssignNToPss2BCommand
   */
  public void validate(AssignNToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignNToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignNToPss2BCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignNToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign N validation for a Pss2B
   *
   * @param command UnAssignNFromPss2BCommand
   */
  public void validate(UnAssignNFromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNFromPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "UnAssignNFromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a Pss2B
   *
   * @param command AssignT1ToPss2BCommand
   */
  public void validate(AssignT1ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignT1ToPss2BCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT1ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a Pss2B
   *
   * @param command UnAssignT1FromPss2BCommand
   */
  public void validate(UnAssignT1FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignT1FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign T10 validation for a Pss2B
   *
   * @param command AssignT10ToPss2BCommand
   */
  public void validate(AssignT10ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT10ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignT10ToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT10ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign T10 validation for a Pss2B
   *
   * @param command UnAssignT10FromPss2BCommand
   */
  public void validate(UnAssignT10FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT10FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignT10FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign T11 validation for a Pss2B
   *
   * @param command AssignT11ToPss2BCommand
   */
  public void validate(AssignT11ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT11ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignT11ToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT11ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign T11 validation for a Pss2B
   *
   * @param command UnAssignT11FromPss2BCommand
   */
  public void validate(UnAssignT11FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT11FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignT11FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a Pss2B
   *
   * @param command AssignT2ToPss2BCommand
   */
  public void validate(AssignT2ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignT2ToPss2BCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT2ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a Pss2B
   *
   * @param command UnAssignT2FromPss2BCommand
   */
  public void validate(UnAssignT2FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignT2FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign T3 validation for a Pss2B
   *
   * @param command AssignT3ToPss2BCommand
   */
  public void validate(AssignT3ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT3ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignT3ToPss2BCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT3ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a Pss2B
   *
   * @param command UnAssignT3FromPss2BCommand
   */
  public void validate(UnAssignT3FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignT3FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign T4 validation for a Pss2B
   *
   * @param command AssignT4ToPss2BCommand
   */
  public void validate(AssignT4ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT4ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignT4ToPss2BCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT4ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a Pss2B
   *
   * @param command UnAssignT4FromPss2BCommand
   */
  public void validate(UnAssignT4FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignT4FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign T6 validation for a Pss2B
   *
   * @param command AssignT6ToPss2BCommand
   */
  public void validate(AssignT6ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT6ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignT6ToPss2BCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT6ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a Pss2B
   *
   * @param command UnAssignT6FromPss2BCommand
   */
  public void validate(UnAssignT6FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignT6FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign T7 validation for a Pss2B
   *
   * @param command AssignT7ToPss2BCommand
   */
  public void validate(AssignT7ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT7ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignT7ToPss2BCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT7ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign T7 validation for a Pss2B
   *
   * @param command UnAssignT7FromPss2BCommand
   */
  public void validate(UnAssignT7FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT7FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignT7FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign T8 validation for a Pss2B
   *
   * @param command AssignT8ToPss2BCommand
   */
  public void validate(AssignT8ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT8ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignT8ToPss2BCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT8ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign T8 validation for a Pss2B
   *
   * @param command UnAssignT8FromPss2BCommand
   */
  public void validate(UnAssignT8FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT8FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignT8FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign T9 validation for a Pss2B
   *
   * @param command AssignT9ToPss2BCommand
   */
  public void validate(AssignT9ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignT9ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignT9ToPss2BCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT9ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign T9 validation for a Pss2B
   *
   * @param command UnAssignT9FromPss2BCommand
   */
  public void validate(UnAssignT9FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT9FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignT9FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a Pss2B
   *
   * @param command AssignTaToPss2BCommand
   */
  public void validate(AssignTaToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignTaToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignTaToPss2BCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTaToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a Pss2B
   *
   * @param command UnAssignTaFromPss2BCommand
   */
  public void validate(UnAssignTaFromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignTaFromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a Pss2B
   *
   * @param command AssignTbToPss2BCommand
   */
  public void validate(AssignTbToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignTbToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignTbToPss2BCommand identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTbToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a Pss2B
   *
   * @param command UnAssignTbFromPss2BCommand
   */
  public void validate(UnAssignTbFromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignTbFromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Tw1 validation for a Pss2B
   *
   * @param command AssignTw1ToPss2BCommand
   */
  public void validate(AssignTw1ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignTw1ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignTw1ToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTw1ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Tw1 validation for a Pss2B
   *
   * @param command UnAssignTw1FromPss2BCommand
   */
  public void validate(UnAssignTw1FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTw1FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignTw1FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Tw2 validation for a Pss2B
   *
   * @param command AssignTw2ToPss2BCommand
   */
  public void validate(AssignTw2ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignTw2ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignTw2ToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTw2ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Tw2 validation for a Pss2B
   *
   * @param command UnAssignTw2FromPss2BCommand
   */
  public void validate(UnAssignTw2FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTw2FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignTw2FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Tw3 validation for a Pss2B
   *
   * @param command AssignTw3ToPss2BCommand
   */
  public void validate(AssignTw3ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignTw3ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignTw3ToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTw3ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Tw3 validation for a Pss2B
   *
   * @param command UnAssignTw3FromPss2BCommand
   */
  public void validate(UnAssignTw3FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTw3FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignTw3FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Tw4 validation for a Pss2B
   *
   * @param command AssignTw4ToPss2BCommand
   */
  public void validate(AssignTw4ToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignTw4ToPss2BCommand should not be null");
    Assert.notNull(command.getPss2BId(), "AssignTw4ToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTw4ToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Tw4 validation for a Pss2B
   *
   * @param command UnAssignTw4FromPss2BCommand
   */
  public void validate(UnAssignTw4FromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTw4FromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignTw4FromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Vsi1max validation for a Pss2B
   *
   * @param command AssignVsi1maxToPss2BCommand
   */
  public void validate(AssignVsi1maxToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignVsi1maxToPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "AssignVsi1maxToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsi1maxToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Vsi1max validation for a Pss2B
   *
   * @param command UnAssignVsi1maxFromPss2BCommand
   */
  public void validate(UnAssignVsi1maxFromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsi1maxFromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignVsi1maxFromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Vsi1min validation for a Pss2B
   *
   * @param command AssignVsi1minToPss2BCommand
   */
  public void validate(AssignVsi1minToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignVsi1minToPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "AssignVsi1minToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsi1minToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Vsi1min validation for a Pss2B
   *
   * @param command UnAssignVsi1minFromPss2BCommand
   */
  public void validate(UnAssignVsi1minFromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsi1minFromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignVsi1minFromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Vsi2max validation for a Pss2B
   *
   * @param command AssignVsi2maxToPss2BCommand
   */
  public void validate(AssignVsi2maxToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignVsi2maxToPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "AssignVsi2maxToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsi2maxToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Vsi2max validation for a Pss2B
   *
   * @param command UnAssignVsi2maxFromPss2BCommand
   */
  public void validate(UnAssignVsi2maxFromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsi2maxFromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignVsi2maxFromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Vsi2min validation for a Pss2B
   *
   * @param command AssignVsi2minToPss2BCommand
   */
  public void validate(AssignVsi2minToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignVsi2minToPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "AssignVsi2minToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsi2minToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Vsi2min validation for a Pss2B
   *
   * @param command UnAssignVsi2minFromPss2BCommand
   */
  public void validate(UnAssignVsi2minFromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsi2minFromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignVsi2minFromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Vstmax validation for a Pss2B
   *
   * @param command AssignVstmaxToPss2BCommand
   */
  public void validate(AssignVstmaxToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignVstmaxToPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "AssignVstmaxToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVstmaxToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Vstmax validation for a Pss2B
   *
   * @param command UnAssignVstmaxFromPss2BCommand
   */
  public void validate(UnAssignVstmaxFromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVstmaxFromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignVstmaxFromPss2BCommand identifier should not be null");
  }
  /**
   * handles assign Vstmin validation for a Pss2B
   *
   * @param command AssignVstminToPss2BCommand
   */
  public void validate(AssignVstminToPss2BCommand command) throws Exception {
    Assert.notNull(command, "AssignVstminToPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "AssignVstminToPss2BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVstminToPss2BCommand assignment should not be null");
  }

  /**
   * handles unassign Vstmin validation for a Pss2B
   *
   * @param command UnAssignVstminFromPss2BCommand
   */
  public void validate(UnAssignVstminFromPss2BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVstminFromPss2BCommand should not be null");
    Assert.notNull(
        command.getPss2BId(), "UnAssignVstminFromPss2BCommand identifier should not be null");
  }
}
