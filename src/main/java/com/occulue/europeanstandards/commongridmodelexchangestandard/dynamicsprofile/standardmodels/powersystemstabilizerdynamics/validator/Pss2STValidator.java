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

public class Pss2STValidator {

  /** default constructor */
  protected Pss2STValidator() {}

  /** factory method */
  public static Pss2STValidator getInstance() {
    return new Pss2STValidator();
  }

  /** handles creation validation for a Pss2ST */
  public void validate(CreatePss2STCommand pss2ST) throws Exception {
    Assert.notNull(pss2ST, "CreatePss2STCommand should not be null");
    //		Assert.isNull( pss2ST.getPss2STId(), "CreatePss2STCommand identifier should be null" );
  }

  /** handles update validation for a Pss2ST */
  public void validate(UpdatePss2STCommand pss2ST) throws Exception {
    Assert.notNull(pss2ST, "UpdatePss2STCommand should not be null");
    Assert.notNull(pss2ST.getPss2STId(), "UpdatePss2STCommand identifier should not be null");
  }

  /** handles delete validation for a Pss2ST */
  public void validate(DeletePss2STCommand pss2ST) throws Exception {
    Assert.notNull(pss2ST, "{commandAlias} should not be null");
    Assert.notNull(pss2ST.getPss2STId(), "DeletePss2STCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Pss2ST */
  public void validate(Pss2STFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "Pss2STFetchOneSummary should not be null");
    Assert.notNull(summary.getPss2STId(), "Pss2STFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign K1 validation for a Pss2ST
   *
   * @param command AssignK1ToPss2STCommand
   */
  public void validate(AssignK1ToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignK1ToPss2STCommand should not be null");
    Assert.notNull(command.getPss2STId(), "AssignK1ToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK1ToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign K1 validation for a Pss2ST
   *
   * @param command UnAssignK1FromPss2STCommand
   */
  public void validate(UnAssignK1FromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK1FromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignK1FromPss2STCommand identifier should not be null");
  }
  /**
   * handles assign K2 validation for a Pss2ST
   *
   * @param command AssignK2ToPss2STCommand
   */
  public void validate(AssignK2ToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignK2ToPss2STCommand should not be null");
    Assert.notNull(command.getPss2STId(), "AssignK2ToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK2ToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign K2 validation for a Pss2ST
   *
   * @param command UnAssignK2FromPss2STCommand
   */
  public void validate(UnAssignK2FromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK2FromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignK2FromPss2STCommand identifier should not be null");
  }
  /**
   * handles assign Lsmax validation for a Pss2ST
   *
   * @param command AssignLsmaxToPss2STCommand
   */
  public void validate(AssignLsmaxToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignLsmaxToPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "AssignLsmaxToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLsmaxToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign Lsmax validation for a Pss2ST
   *
   * @param command UnAssignLsmaxFromPss2STCommand
   */
  public void validate(UnAssignLsmaxFromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLsmaxFromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignLsmaxFromPss2STCommand identifier should not be null");
  }
  /**
   * handles assign Lsmin validation for a Pss2ST
   *
   * @param command AssignLsminToPss2STCommand
   */
  public void validate(AssignLsminToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignLsminToPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "AssignLsminToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLsminToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign Lsmin validation for a Pss2ST
   *
   * @param command UnAssignLsminFromPss2STCommand
   */
  public void validate(UnAssignLsminFromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLsminFromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignLsminFromPss2STCommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a Pss2ST
   *
   * @param command AssignT1ToPss2STCommand
   */
  public void validate(AssignT1ToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToPss2STCommand should not be null");
    Assert.notNull(command.getPss2STId(), "AssignT1ToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a Pss2ST
   *
   * @param command UnAssignT1FromPss2STCommand
   */
  public void validate(UnAssignT1FromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignT1FromPss2STCommand identifier should not be null");
  }
  /**
   * handles assign T10 validation for a Pss2ST
   *
   * @param command AssignT10ToPss2STCommand
   */
  public void validate(AssignT10ToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignT10ToPss2STCommand should not be null");
    Assert.notNull(command.getPss2STId(), "AssignT10ToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT10ToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign T10 validation for a Pss2ST
   *
   * @param command UnAssignT10FromPss2STCommand
   */
  public void validate(UnAssignT10FromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT10FromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignT10FromPss2STCommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a Pss2ST
   *
   * @param command AssignT2ToPss2STCommand
   */
  public void validate(AssignT2ToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToPss2STCommand should not be null");
    Assert.notNull(command.getPss2STId(), "AssignT2ToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a Pss2ST
   *
   * @param command UnAssignT2FromPss2STCommand
   */
  public void validate(UnAssignT2FromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignT2FromPss2STCommand identifier should not be null");
  }
  /**
   * handles assign T3 validation for a Pss2ST
   *
   * @param command AssignT3ToPss2STCommand
   */
  public void validate(AssignT3ToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignT3ToPss2STCommand should not be null");
    Assert.notNull(command.getPss2STId(), "AssignT3ToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a Pss2ST
   *
   * @param command UnAssignT3FromPss2STCommand
   */
  public void validate(UnAssignT3FromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignT3FromPss2STCommand identifier should not be null");
  }
  /**
   * handles assign T4 validation for a Pss2ST
   *
   * @param command AssignT4ToPss2STCommand
   */
  public void validate(AssignT4ToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignT4ToPss2STCommand should not be null");
    Assert.notNull(command.getPss2STId(), "AssignT4ToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a Pss2ST
   *
   * @param command UnAssignT4FromPss2STCommand
   */
  public void validate(UnAssignT4FromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignT4FromPss2STCommand identifier should not be null");
  }
  /**
   * handles assign T5 validation for a Pss2ST
   *
   * @param command AssignT5ToPss2STCommand
   */
  public void validate(AssignT5ToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignT5ToPss2STCommand should not be null");
    Assert.notNull(command.getPss2STId(), "AssignT5ToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5ToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a Pss2ST
   *
   * @param command UnAssignT5FromPss2STCommand
   */
  public void validate(UnAssignT5FromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignT5FromPss2STCommand identifier should not be null");
  }
  /**
   * handles assign T6 validation for a Pss2ST
   *
   * @param command AssignT6ToPss2STCommand
   */
  public void validate(AssignT6ToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignT6ToPss2STCommand should not be null");
    Assert.notNull(command.getPss2STId(), "AssignT6ToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT6ToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a Pss2ST
   *
   * @param command UnAssignT6FromPss2STCommand
   */
  public void validate(UnAssignT6FromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignT6FromPss2STCommand identifier should not be null");
  }
  /**
   * handles assign T7 validation for a Pss2ST
   *
   * @param command AssignT7ToPss2STCommand
   */
  public void validate(AssignT7ToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignT7ToPss2STCommand should not be null");
    Assert.notNull(command.getPss2STId(), "AssignT7ToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT7ToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign T7 validation for a Pss2ST
   *
   * @param command UnAssignT7FromPss2STCommand
   */
  public void validate(UnAssignT7FromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT7FromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignT7FromPss2STCommand identifier should not be null");
  }
  /**
   * handles assign T8 validation for a Pss2ST
   *
   * @param command AssignT8ToPss2STCommand
   */
  public void validate(AssignT8ToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignT8ToPss2STCommand should not be null");
    Assert.notNull(command.getPss2STId(), "AssignT8ToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT8ToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign T8 validation for a Pss2ST
   *
   * @param command UnAssignT8FromPss2STCommand
   */
  public void validate(UnAssignT8FromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT8FromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignT8FromPss2STCommand identifier should not be null");
  }
  /**
   * handles assign T9 validation for a Pss2ST
   *
   * @param command AssignT9ToPss2STCommand
   */
  public void validate(AssignT9ToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignT9ToPss2STCommand should not be null");
    Assert.notNull(command.getPss2STId(), "AssignT9ToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT9ToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign T9 validation for a Pss2ST
   *
   * @param command UnAssignT9FromPss2STCommand
   */
  public void validate(UnAssignT9FromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT9FromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignT9FromPss2STCommand identifier should not be null");
  }
  /**
   * handles assign Vcl validation for a Pss2ST
   *
   * @param command AssignVclToPss2STCommand
   */
  public void validate(AssignVclToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignVclToPss2STCommand should not be null");
    Assert.notNull(command.getPss2STId(), "AssignVclToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVclToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign Vcl validation for a Pss2ST
   *
   * @param command UnAssignVclFromPss2STCommand
   */
  public void validate(UnAssignVclFromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVclFromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignVclFromPss2STCommand identifier should not be null");
  }
  /**
   * handles assign Vcu validation for a Pss2ST
   *
   * @param command AssignVcuToPss2STCommand
   */
  public void validate(AssignVcuToPss2STCommand command) throws Exception {
    Assert.notNull(command, "AssignVcuToPss2STCommand should not be null");
    Assert.notNull(command.getPss2STId(), "AssignVcuToPss2STCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVcuToPss2STCommand assignment should not be null");
  }

  /**
   * handles unassign Vcu validation for a Pss2ST
   *
   * @param command UnAssignVcuFromPss2STCommand
   */
  public void validate(UnAssignVcuFromPss2STCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVcuFromPss2STCommand should not be null");
    Assert.notNull(
        command.getPss2STId(), "UnAssignVcuFromPss2STCommand identifier should not be null");
  }
}
