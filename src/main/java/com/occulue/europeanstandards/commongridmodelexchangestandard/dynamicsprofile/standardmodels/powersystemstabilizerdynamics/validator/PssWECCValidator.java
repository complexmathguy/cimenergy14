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

public class PssWECCValidator {

  /** default constructor */
  protected PssWECCValidator() {}

  /** factory method */
  public static PssWECCValidator getInstance() {
    return new PssWECCValidator();
  }

  /** handles creation validation for a PssWECC */
  public void validate(CreatePssWECCCommand pssWECC) throws Exception {
    Assert.notNull(pssWECC, "CreatePssWECCCommand should not be null");
    //		Assert.isNull( pssWECC.getPssWECCId(), "CreatePssWECCCommand identifier should be null" );
  }

  /** handles update validation for a PssWECC */
  public void validate(UpdatePssWECCCommand pssWECC) throws Exception {
    Assert.notNull(pssWECC, "UpdatePssWECCCommand should not be null");
    Assert.notNull(pssWECC.getPssWECCId(), "UpdatePssWECCCommand identifier should not be null");
  }

  /** handles delete validation for a PssWECC */
  public void validate(DeletePssWECCCommand pssWECC) throws Exception {
    Assert.notNull(pssWECC, "{commandAlias} should not be null");
    Assert.notNull(pssWECC.getPssWECCId(), "DeletePssWECCCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PssWECC */
  public void validate(PssWECCFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PssWECCFetchOneSummary should not be null");
    Assert.notNull(summary.getPssWECCId(), "PssWECCFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign K1 validation for a PssWECC
   *
   * @param command AssignK1ToPssWECCCommand
   */
  public void validate(AssignK1ToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignK1ToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignK1ToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK1ToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign K1 validation for a PssWECC
   *
   * @param command UnAssignK1FromPssWECCCommand
   */
  public void validate(UnAssignK1FromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK1FromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignK1FromPssWECCCommand identifier should not be null");
  }
  /**
   * handles assign K2 validation for a PssWECC
   *
   * @param command AssignK2ToPssWECCCommand
   */
  public void validate(AssignK2ToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignK2ToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignK2ToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK2ToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign K2 validation for a PssWECC
   *
   * @param command UnAssignK2FromPssWECCCommand
   */
  public void validate(UnAssignK2FromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK2FromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignK2FromPssWECCCommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a PssWECC
   *
   * @param command AssignT1ToPssWECCCommand
   */
  public void validate(AssignT1ToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignT1ToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a PssWECC
   *
   * @param command UnAssignT1FromPssWECCCommand
   */
  public void validate(UnAssignT1FromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignT1FromPssWECCCommand identifier should not be null");
  }
  /**
   * handles assign T10 validation for a PssWECC
   *
   * @param command AssignT10ToPssWECCCommand
   */
  public void validate(AssignT10ToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignT10ToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignT10ToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT10ToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign T10 validation for a PssWECC
   *
   * @param command UnAssignT10FromPssWECCCommand
   */
  public void validate(UnAssignT10FromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT10FromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignT10FromPssWECCCommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a PssWECC
   *
   * @param command AssignT2ToPssWECCCommand
   */
  public void validate(AssignT2ToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignT2ToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a PssWECC
   *
   * @param command UnAssignT2FromPssWECCCommand
   */
  public void validate(UnAssignT2FromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignT2FromPssWECCCommand identifier should not be null");
  }
  /**
   * handles assign T3 validation for a PssWECC
   *
   * @param command AssignT3ToPssWECCCommand
   */
  public void validate(AssignT3ToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignT3ToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignT3ToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a PssWECC
   *
   * @param command UnAssignT3FromPssWECCCommand
   */
  public void validate(UnAssignT3FromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignT3FromPssWECCCommand identifier should not be null");
  }
  /**
   * handles assign T4 validation for a PssWECC
   *
   * @param command AssignT4ToPssWECCCommand
   */
  public void validate(AssignT4ToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignT4ToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignT4ToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a PssWECC
   *
   * @param command UnAssignT4FromPssWECCCommand
   */
  public void validate(UnAssignT4FromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignT4FromPssWECCCommand identifier should not be null");
  }
  /**
   * handles assign T5 validation for a PssWECC
   *
   * @param command AssignT5ToPssWECCCommand
   */
  public void validate(AssignT5ToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignT5ToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignT5ToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5ToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a PssWECC
   *
   * @param command UnAssignT5FromPssWECCCommand
   */
  public void validate(UnAssignT5FromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignT5FromPssWECCCommand identifier should not be null");
  }
  /**
   * handles assign T6 validation for a PssWECC
   *
   * @param command AssignT6ToPssWECCCommand
   */
  public void validate(AssignT6ToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignT6ToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignT6ToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT6ToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a PssWECC
   *
   * @param command UnAssignT6FromPssWECCCommand
   */
  public void validate(UnAssignT6FromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignT6FromPssWECCCommand identifier should not be null");
  }
  /**
   * handles assign T7 validation for a PssWECC
   *
   * @param command AssignT7ToPssWECCCommand
   */
  public void validate(AssignT7ToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignT7ToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignT7ToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT7ToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign T7 validation for a PssWECC
   *
   * @param command UnAssignT7FromPssWECCCommand
   */
  public void validate(UnAssignT7FromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT7FromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignT7FromPssWECCCommand identifier should not be null");
  }
  /**
   * handles assign T8 validation for a PssWECC
   *
   * @param command AssignT8ToPssWECCCommand
   */
  public void validate(AssignT8ToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignT8ToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignT8ToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT8ToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign T8 validation for a PssWECC
   *
   * @param command UnAssignT8FromPssWECCCommand
   */
  public void validate(UnAssignT8FromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT8FromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignT8FromPssWECCCommand identifier should not be null");
  }
  /**
   * handles assign T9 validation for a PssWECC
   *
   * @param command AssignT9ToPssWECCCommand
   */
  public void validate(AssignT9ToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignT9ToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignT9ToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT9ToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign T9 validation for a PssWECC
   *
   * @param command UnAssignT9FromPssWECCCommand
   */
  public void validate(UnAssignT9FromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT9FromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignT9FromPssWECCCommand identifier should not be null");
  }
  /**
   * handles assign Vcl validation for a PssWECC
   *
   * @param command AssignVclToPssWECCCommand
   */
  public void validate(AssignVclToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignVclToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignVclToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVclToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign Vcl validation for a PssWECC
   *
   * @param command UnAssignVclFromPssWECCCommand
   */
  public void validate(UnAssignVclFromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVclFromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignVclFromPssWECCCommand identifier should not be null");
  }
  /**
   * handles assign Vcu validation for a PssWECC
   *
   * @param command AssignVcuToPssWECCCommand
   */
  public void validate(AssignVcuToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignVcuToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignVcuToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVcuToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign Vcu validation for a PssWECC
   *
   * @param command UnAssignVcuFromPssWECCCommand
   */
  public void validate(UnAssignVcuFromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVcuFromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignVcuFromPssWECCCommand identifier should not be null");
  }
  /**
   * handles assign Vsmax validation for a PssWECC
   *
   * @param command AssignVsmaxToPssWECCCommand
   */
  public void validate(AssignVsmaxToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignVsmaxToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignVsmaxToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsmaxToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign Vsmax validation for a PssWECC
   *
   * @param command UnAssignVsmaxFromPssWECCCommand
   */
  public void validate(UnAssignVsmaxFromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsmaxFromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignVsmaxFromPssWECCCommand identifier should not be null");
  }
  /**
   * handles assign Vsmin validation for a PssWECC
   *
   * @param command AssignVsminToPssWECCCommand
   */
  public void validate(AssignVsminToPssWECCCommand command) throws Exception {
    Assert.notNull(command, "AssignVsminToPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "AssignVsminToPssWECCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsminToPssWECCCommand assignment should not be null");
  }

  /**
   * handles unassign Vsmin validation for a PssWECC
   *
   * @param command UnAssignVsminFromPssWECCCommand
   */
  public void validate(UnAssignVsminFromPssWECCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsminFromPssWECCCommand should not be null");
    Assert.notNull(
        command.getPssWECCId(), "UnAssignVsminFromPssWECCCommand identifier should not be null");
  }
}
