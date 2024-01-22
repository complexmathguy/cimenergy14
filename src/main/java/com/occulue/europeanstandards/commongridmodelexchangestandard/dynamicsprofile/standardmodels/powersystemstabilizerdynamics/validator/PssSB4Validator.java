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

public class PssSB4Validator {

  /** default constructor */
  protected PssSB4Validator() {}

  /** factory method */
  public static PssSB4Validator getInstance() {
    return new PssSB4Validator();
  }

  /** handles creation validation for a PssSB4 */
  public void validate(CreatePssSB4Command pssSB4) throws Exception {
    Assert.notNull(pssSB4, "CreatePssSB4Command should not be null");
    //		Assert.isNull( pssSB4.getPssSB4Id(), "CreatePssSB4Command identifier should be null" );
  }

  /** handles update validation for a PssSB4 */
  public void validate(UpdatePssSB4Command pssSB4) throws Exception {
    Assert.notNull(pssSB4, "UpdatePssSB4Command should not be null");
    Assert.notNull(pssSB4.getPssSB4Id(), "UpdatePssSB4Command identifier should not be null");
  }

  /** handles delete validation for a PssSB4 */
  public void validate(DeletePssSB4Command pssSB4) throws Exception {
    Assert.notNull(pssSB4, "{commandAlias} should not be null");
    Assert.notNull(pssSB4.getPssSB4Id(), "DeletePssSB4Command identifier should not be null");
  }

  /** handles fetchOne validation for a PssSB4 */
  public void validate(PssSB4FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PssSB4FetchOneSummary should not be null");
    Assert.notNull(summary.getPssSB4Id(), "PssSB4FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Kx validation for a PssSB4
   *
   * @param command AssignKxToPssSB4Command
   */
  public void validate(AssignKxToPssSB4Command command) throws Exception {
    Assert.notNull(command, "AssignKxToPssSB4Command should not be null");
    Assert.notNull(command.getPssSB4Id(), "AssignKxToPssSB4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKxToPssSB4Command assignment should not be null");
  }

  /**
   * handles unassign Kx validation for a PssSB4
   *
   * @param command UnAssignKxFromPssSB4Command
   */
  public void validate(UnAssignKxFromPssSB4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKxFromPssSB4Command should not be null");
    Assert.notNull(
        command.getPssSB4Id(), "UnAssignKxFromPssSB4Command identifier should not be null");
  }
  /**
   * handles assign Ta validation for a PssSB4
   *
   * @param command AssignTaToPssSB4Command
   */
  public void validate(AssignTaToPssSB4Command command) throws Exception {
    Assert.notNull(command, "AssignTaToPssSB4Command should not be null");
    Assert.notNull(command.getPssSB4Id(), "AssignTaToPssSB4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToPssSB4Command assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a PssSB4
   *
   * @param command UnAssignTaFromPssSB4Command
   */
  public void validate(UnAssignTaFromPssSB4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromPssSB4Command should not be null");
    Assert.notNull(
        command.getPssSB4Id(), "UnAssignTaFromPssSB4Command identifier should not be null");
  }
  /**
   * handles assign Tb validation for a PssSB4
   *
   * @param command AssignTbToPssSB4Command
   */
  public void validate(AssignTbToPssSB4Command command) throws Exception {
    Assert.notNull(command, "AssignTbToPssSB4Command should not be null");
    Assert.notNull(command.getPssSB4Id(), "AssignTbToPssSB4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToPssSB4Command assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a PssSB4
   *
   * @param command UnAssignTbFromPssSB4Command
   */
  public void validate(UnAssignTbFromPssSB4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromPssSB4Command should not be null");
    Assert.notNull(
        command.getPssSB4Id(), "UnAssignTbFromPssSB4Command identifier should not be null");
  }
  /**
   * handles assign Tc validation for a PssSB4
   *
   * @param command AssignTcToPssSB4Command
   */
  public void validate(AssignTcToPssSB4Command command) throws Exception {
    Assert.notNull(command, "AssignTcToPssSB4Command should not be null");
    Assert.notNull(command.getPssSB4Id(), "AssignTcToPssSB4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToPssSB4Command assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a PssSB4
   *
   * @param command UnAssignTcFromPssSB4Command
   */
  public void validate(UnAssignTcFromPssSB4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromPssSB4Command should not be null");
    Assert.notNull(
        command.getPssSB4Id(), "UnAssignTcFromPssSB4Command identifier should not be null");
  }
  /**
   * handles assign Td validation for a PssSB4
   *
   * @param command AssignTdToPssSB4Command
   */
  public void validate(AssignTdToPssSB4Command command) throws Exception {
    Assert.notNull(command, "AssignTdToPssSB4Command should not be null");
    Assert.notNull(command.getPssSB4Id(), "AssignTdToPssSB4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdToPssSB4Command assignment should not be null");
  }

  /**
   * handles unassign Td validation for a PssSB4
   *
   * @param command UnAssignTdFromPssSB4Command
   */
  public void validate(UnAssignTdFromPssSB4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTdFromPssSB4Command should not be null");
    Assert.notNull(
        command.getPssSB4Id(), "UnAssignTdFromPssSB4Command identifier should not be null");
  }
  /**
   * handles assign Te validation for a PssSB4
   *
   * @param command AssignTeToPssSB4Command
   */
  public void validate(AssignTeToPssSB4Command command) throws Exception {
    Assert.notNull(command, "AssignTeToPssSB4Command should not be null");
    Assert.notNull(command.getPssSB4Id(), "AssignTeToPssSB4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToPssSB4Command assignment should not be null");
  }

  /**
   * handles unassign Te validation for a PssSB4
   *
   * @param command UnAssignTeFromPssSB4Command
   */
  public void validate(UnAssignTeFromPssSB4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromPssSB4Command should not be null");
    Assert.notNull(
        command.getPssSB4Id(), "UnAssignTeFromPssSB4Command identifier should not be null");
  }
  /**
   * handles assign Tt validation for a PssSB4
   *
   * @param command AssignTtToPssSB4Command
   */
  public void validate(AssignTtToPssSB4Command command) throws Exception {
    Assert.notNull(command, "AssignTtToPssSB4Command should not be null");
    Assert.notNull(command.getPssSB4Id(), "AssignTtToPssSB4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTtToPssSB4Command assignment should not be null");
  }

  /**
   * handles unassign Tt validation for a PssSB4
   *
   * @param command UnAssignTtFromPssSB4Command
   */
  public void validate(UnAssignTtFromPssSB4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTtFromPssSB4Command should not be null");
    Assert.notNull(
        command.getPssSB4Id(), "UnAssignTtFromPssSB4Command identifier should not be null");
  }
  /**
   * handles assign Tx1 validation for a PssSB4
   *
   * @param command AssignTx1ToPssSB4Command
   */
  public void validate(AssignTx1ToPssSB4Command command) throws Exception {
    Assert.notNull(command, "AssignTx1ToPssSB4Command should not be null");
    Assert.notNull(command.getPssSB4Id(), "AssignTx1ToPssSB4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTx1ToPssSB4Command assignment should not be null");
  }

  /**
   * handles unassign Tx1 validation for a PssSB4
   *
   * @param command UnAssignTx1FromPssSB4Command
   */
  public void validate(UnAssignTx1FromPssSB4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTx1FromPssSB4Command should not be null");
    Assert.notNull(
        command.getPssSB4Id(), "UnAssignTx1FromPssSB4Command identifier should not be null");
  }
  /**
   * handles assign Tx2 validation for a PssSB4
   *
   * @param command AssignTx2ToPssSB4Command
   */
  public void validate(AssignTx2ToPssSB4Command command) throws Exception {
    Assert.notNull(command, "AssignTx2ToPssSB4Command should not be null");
    Assert.notNull(command.getPssSB4Id(), "AssignTx2ToPssSB4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTx2ToPssSB4Command assignment should not be null");
  }

  /**
   * handles unassign Tx2 validation for a PssSB4
   *
   * @param command UnAssignTx2FromPssSB4Command
   */
  public void validate(UnAssignTx2FromPssSB4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTx2FromPssSB4Command should not be null");
    Assert.notNull(
        command.getPssSB4Id(), "UnAssignTx2FromPssSB4Command identifier should not be null");
  }
  /**
   * handles assign Vsmax validation for a PssSB4
   *
   * @param command AssignVsmaxToPssSB4Command
   */
  public void validate(AssignVsmaxToPssSB4Command command) throws Exception {
    Assert.notNull(command, "AssignVsmaxToPssSB4Command should not be null");
    Assert.notNull(
        command.getPssSB4Id(), "AssignVsmaxToPssSB4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsmaxToPssSB4Command assignment should not be null");
  }

  /**
   * handles unassign Vsmax validation for a PssSB4
   *
   * @param command UnAssignVsmaxFromPssSB4Command
   */
  public void validate(UnAssignVsmaxFromPssSB4Command command) throws Exception {
    Assert.notNull(command, "UnAssignVsmaxFromPssSB4Command should not be null");
    Assert.notNull(
        command.getPssSB4Id(), "UnAssignVsmaxFromPssSB4Command identifier should not be null");
  }
  /**
   * handles assign Vsmin validation for a PssSB4
   *
   * @param command AssignVsminToPssSB4Command
   */
  public void validate(AssignVsminToPssSB4Command command) throws Exception {
    Assert.notNull(command, "AssignVsminToPssSB4Command should not be null");
    Assert.notNull(
        command.getPssSB4Id(), "AssignVsminToPssSB4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsminToPssSB4Command assignment should not be null");
  }

  /**
   * handles unassign Vsmin validation for a PssSB4
   *
   * @param command UnAssignVsminFromPssSB4Command
   */
  public void validate(UnAssignVsminFromPssSB4Command command) throws Exception {
    Assert.notNull(command, "UnAssignVsminFromPssSB4Command should not be null");
    Assert.notNull(
        command.getPssSB4Id(), "UnAssignVsminFromPssSB4Command identifier should not be null");
  }
}
