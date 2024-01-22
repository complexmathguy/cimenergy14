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

public class PssPTIST1Validator {

  /** default constructor */
  protected PssPTIST1Validator() {}

  /** factory method */
  public static PssPTIST1Validator getInstance() {
    return new PssPTIST1Validator();
  }

  /** handles creation validation for a PssPTIST1 */
  public void validate(CreatePssPTIST1Command pssPTIST1) throws Exception {
    Assert.notNull(pssPTIST1, "CreatePssPTIST1Command should not be null");
    //		Assert.isNull( pssPTIST1.getPssPTIST1Id(), "CreatePssPTIST1Command identifier should be
    // null" );
  }

  /** handles update validation for a PssPTIST1 */
  public void validate(UpdatePssPTIST1Command pssPTIST1) throws Exception {
    Assert.notNull(pssPTIST1, "UpdatePssPTIST1Command should not be null");
    Assert.notNull(
        pssPTIST1.getPssPTIST1Id(), "UpdatePssPTIST1Command identifier should not be null");
  }

  /** handles delete validation for a PssPTIST1 */
  public void validate(DeletePssPTIST1Command pssPTIST1) throws Exception {
    Assert.notNull(pssPTIST1, "{commandAlias} should not be null");
    Assert.notNull(
        pssPTIST1.getPssPTIST1Id(), "DeletePssPTIST1Command identifier should not be null");
  }

  /** handles fetchOne validation for a PssPTIST1 */
  public void validate(PssPTIST1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PssPTIST1FetchOneSummary should not be null");
    Assert.notNull(
        summary.getPssPTIST1Id(), "PssPTIST1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Dtc validation for a PssPTIST1
   *
   * @param command AssignDtcToPssPTIST1Command
   */
  public void validate(AssignDtcToPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "AssignDtcToPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "AssignDtcToPssPTIST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDtcToPssPTIST1Command assignment should not be null");
  }

  /**
   * handles unassign Dtc validation for a PssPTIST1
   *
   * @param command UnAssignDtcFromPssPTIST1Command
   */
  public void validate(UnAssignDtcFromPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignDtcFromPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "UnAssignDtcFromPssPTIST1Command identifier should not be null");
  }
  /**
   * handles assign Dtf validation for a PssPTIST1
   *
   * @param command AssignDtfToPssPTIST1Command
   */
  public void validate(AssignDtfToPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "AssignDtfToPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "AssignDtfToPssPTIST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDtfToPssPTIST1Command assignment should not be null");
  }

  /**
   * handles unassign Dtf validation for a PssPTIST1
   *
   * @param command UnAssignDtfFromPssPTIST1Command
   */
  public void validate(UnAssignDtfFromPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignDtfFromPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "UnAssignDtfFromPssPTIST1Command identifier should not be null");
  }
  /**
   * handles assign Dtp validation for a PssPTIST1
   *
   * @param command AssignDtpToPssPTIST1Command
   */
  public void validate(AssignDtpToPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "AssignDtpToPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "AssignDtpToPssPTIST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDtpToPssPTIST1Command assignment should not be null");
  }

  /**
   * handles unassign Dtp validation for a PssPTIST1
   *
   * @param command UnAssignDtpFromPssPTIST1Command
   */
  public void validate(UnAssignDtpFromPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignDtpFromPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "UnAssignDtpFromPssPTIST1Command identifier should not be null");
  }
  /**
   * handles assign K validation for a PssPTIST1
   *
   * @param command AssignKToPssPTIST1Command
   */
  public void validate(AssignKToPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "AssignKToPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "AssignKToPssPTIST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKToPssPTIST1Command assignment should not be null");
  }

  /**
   * handles unassign K validation for a PssPTIST1
   *
   * @param command UnAssignKFromPssPTIST1Command
   */
  public void validate(UnAssignKFromPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKFromPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "UnAssignKFromPssPTIST1Command identifier should not be null");
  }
  /**
   * handles assign M validation for a PssPTIST1
   *
   * @param command AssignMToPssPTIST1Command
   */
  public void validate(AssignMToPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "AssignMToPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "AssignMToPssPTIST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMToPssPTIST1Command assignment should not be null");
  }

  /**
   * handles unassign M validation for a PssPTIST1
   *
   * @param command UnAssignMFromPssPTIST1Command
   */
  public void validate(UnAssignMFromPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignMFromPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "UnAssignMFromPssPTIST1Command identifier should not be null");
  }
  /**
   * handles assign T1 validation for a PssPTIST1
   *
   * @param command AssignT1ToPssPTIST1Command
   */
  public void validate(AssignT1ToPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "AssignT1ToPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "AssignT1ToPssPTIST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToPssPTIST1Command assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a PssPTIST1
   *
   * @param command UnAssignT1FromPssPTIST1Command
   */
  public void validate(UnAssignT1FromPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "UnAssignT1FromPssPTIST1Command identifier should not be null");
  }
  /**
   * handles assign T2 validation for a PssPTIST1
   *
   * @param command AssignT2ToPssPTIST1Command
   */
  public void validate(AssignT2ToPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "AssignT2ToPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "AssignT2ToPssPTIST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToPssPTIST1Command assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a PssPTIST1
   *
   * @param command UnAssignT2FromPssPTIST1Command
   */
  public void validate(UnAssignT2FromPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "UnAssignT2FromPssPTIST1Command identifier should not be null");
  }
  /**
   * handles assign T3 validation for a PssPTIST1
   *
   * @param command AssignT3ToPssPTIST1Command
   */
  public void validate(AssignT3ToPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "AssignT3ToPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "AssignT3ToPssPTIST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToPssPTIST1Command assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a PssPTIST1
   *
   * @param command UnAssignT3FromPssPTIST1Command
   */
  public void validate(UnAssignT3FromPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "UnAssignT3FromPssPTIST1Command identifier should not be null");
  }
  /**
   * handles assign T4 validation for a PssPTIST1
   *
   * @param command AssignT4ToPssPTIST1Command
   */
  public void validate(AssignT4ToPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "AssignT4ToPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "AssignT4ToPssPTIST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToPssPTIST1Command assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a PssPTIST1
   *
   * @param command UnAssignT4FromPssPTIST1Command
   */
  public void validate(UnAssignT4FromPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "UnAssignT4FromPssPTIST1Command identifier should not be null");
  }
  /**
   * handles assign Tf validation for a PssPTIST1
   *
   * @param command AssignTfToPssPTIST1Command
   */
  public void validate(AssignTfToPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "AssignTfToPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "AssignTfToPssPTIST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToPssPTIST1Command assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a PssPTIST1
   *
   * @param command UnAssignTfFromPssPTIST1Command
   */
  public void validate(UnAssignTfFromPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "UnAssignTfFromPssPTIST1Command identifier should not be null");
  }
  /**
   * handles assign Tp validation for a PssPTIST1
   *
   * @param command AssignTpToPssPTIST1Command
   */
  public void validate(AssignTpToPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "AssignTpToPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "AssignTpToPssPTIST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpToPssPTIST1Command assignment should not be null");
  }

  /**
   * handles unassign Tp validation for a PssPTIST1
   *
   * @param command UnAssignTpFromPssPTIST1Command
   */
  public void validate(UnAssignTpFromPssPTIST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTpFromPssPTIST1Command should not be null");
    Assert.notNull(
        command.getPssPTIST1Id(), "UnAssignTpFromPssPTIST1Command identifier should not be null");
  }
}
