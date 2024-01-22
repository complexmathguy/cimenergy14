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

public class PssELIN2Validator {

  /** default constructor */
  protected PssELIN2Validator() {}

  /** factory method */
  public static PssELIN2Validator getInstance() {
    return new PssELIN2Validator();
  }

  /** handles creation validation for a PssELIN2 */
  public void validate(CreatePssELIN2Command pssELIN2) throws Exception {
    Assert.notNull(pssELIN2, "CreatePssELIN2Command should not be null");
    //		Assert.isNull( pssELIN2.getPssELIN2Id(), "CreatePssELIN2Command identifier should be null"
    // );
  }

  /** handles update validation for a PssELIN2 */
  public void validate(UpdatePssELIN2Command pssELIN2) throws Exception {
    Assert.notNull(pssELIN2, "UpdatePssELIN2Command should not be null");
    Assert.notNull(pssELIN2.getPssELIN2Id(), "UpdatePssELIN2Command identifier should not be null");
  }

  /** handles delete validation for a PssELIN2 */
  public void validate(DeletePssELIN2Command pssELIN2) throws Exception {
    Assert.notNull(pssELIN2, "{commandAlias} should not be null");
    Assert.notNull(pssELIN2.getPssELIN2Id(), "DeletePssELIN2Command identifier should not be null");
  }

  /** handles fetchOne validation for a PssELIN2 */
  public void validate(PssELIN2FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PssELIN2FetchOneSummary should not be null");
    Assert.notNull(
        summary.getPssELIN2Id(), "PssELIN2FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Apss validation for a PssELIN2
   *
   * @param command AssignApssToPssELIN2Command
   */
  public void validate(AssignApssToPssELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignApssToPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "AssignApssToPssELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignApssToPssELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Apss validation for a PssELIN2
   *
   * @param command UnAssignApssFromPssELIN2Command
   */
  public void validate(UnAssignApssFromPssELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignApssFromPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "UnAssignApssFromPssELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ks1 validation for a PssELIN2
   *
   * @param command AssignKs1ToPssELIN2Command
   */
  public void validate(AssignKs1ToPssELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignKs1ToPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "AssignKs1ToPssELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKs1ToPssELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ks1 validation for a PssELIN2
   *
   * @param command UnAssignKs1FromPssELIN2Command
   */
  public void validate(UnAssignKs1FromPssELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKs1FromPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "UnAssignKs1FromPssELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ks2 validation for a PssELIN2
   *
   * @param command AssignKs2ToPssELIN2Command
   */
  public void validate(AssignKs2ToPssELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignKs2ToPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "AssignKs2ToPssELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKs2ToPssELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ks2 validation for a PssELIN2
   *
   * @param command UnAssignKs2FromPssELIN2Command
   */
  public void validate(UnAssignKs2FromPssELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKs2FromPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "UnAssignKs2FromPssELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ppss validation for a PssELIN2
   *
   * @param command AssignPpssToPssELIN2Command
   */
  public void validate(AssignPpssToPssELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignPpssToPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "AssignPpssToPssELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPpssToPssELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ppss validation for a PssELIN2
   *
   * @param command UnAssignPpssFromPssELIN2Command
   */
  public void validate(UnAssignPpssFromPssELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPpssFromPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "UnAssignPpssFromPssELIN2Command identifier should not be null");
  }
  /**
   * handles assign Psslim validation for a PssELIN2
   *
   * @param command AssignPsslimToPssELIN2Command
   */
  public void validate(AssignPsslimToPssELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignPsslimToPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "AssignPsslimToPssELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPsslimToPssELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Psslim validation for a PssELIN2
   *
   * @param command UnAssignPsslimFromPssELIN2Command
   */
  public void validate(UnAssignPsslimFromPssELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPsslimFromPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "UnAssignPsslimFromPssELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ts1 validation for a PssELIN2
   *
   * @param command AssignTs1ToPssELIN2Command
   */
  public void validate(AssignTs1ToPssELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignTs1ToPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "AssignTs1ToPssELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTs1ToPssELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ts1 validation for a PssELIN2
   *
   * @param command UnAssignTs1FromPssELIN2Command
   */
  public void validate(UnAssignTs1FromPssELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTs1FromPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "UnAssignTs1FromPssELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ts2 validation for a PssELIN2
   *
   * @param command AssignTs2ToPssELIN2Command
   */
  public void validate(AssignTs2ToPssELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignTs2ToPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "AssignTs2ToPssELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTs2ToPssELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ts2 validation for a PssELIN2
   *
   * @param command UnAssignTs2FromPssELIN2Command
   */
  public void validate(UnAssignTs2FromPssELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTs2FromPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "UnAssignTs2FromPssELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ts3 validation for a PssELIN2
   *
   * @param command AssignTs3ToPssELIN2Command
   */
  public void validate(AssignTs3ToPssELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignTs3ToPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "AssignTs3ToPssELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTs3ToPssELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ts3 validation for a PssELIN2
   *
   * @param command UnAssignTs3FromPssELIN2Command
   */
  public void validate(UnAssignTs3FromPssELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTs3FromPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "UnAssignTs3FromPssELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ts4 validation for a PssELIN2
   *
   * @param command AssignTs4ToPssELIN2Command
   */
  public void validate(AssignTs4ToPssELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignTs4ToPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "AssignTs4ToPssELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTs4ToPssELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ts4 validation for a PssELIN2
   *
   * @param command UnAssignTs4FromPssELIN2Command
   */
  public void validate(UnAssignTs4FromPssELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTs4FromPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "UnAssignTs4FromPssELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ts5 validation for a PssELIN2
   *
   * @param command AssignTs5ToPssELIN2Command
   */
  public void validate(AssignTs5ToPssELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignTs5ToPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "AssignTs5ToPssELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTs5ToPssELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ts5 validation for a PssELIN2
   *
   * @param command UnAssignTs5FromPssELIN2Command
   */
  public void validate(UnAssignTs5FromPssELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTs5FromPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "UnAssignTs5FromPssELIN2Command identifier should not be null");
  }
  /**
   * handles assign Ts6 validation for a PssELIN2
   *
   * @param command AssignTs6ToPssELIN2Command
   */
  public void validate(AssignTs6ToPssELIN2Command command) throws Exception {
    Assert.notNull(command, "AssignTs6ToPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "AssignTs6ToPssELIN2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTs6ToPssELIN2Command assignment should not be null");
  }

  /**
   * handles unassign Ts6 validation for a PssELIN2
   *
   * @param command UnAssignTs6FromPssELIN2Command
   */
  public void validate(UnAssignTs6FromPssELIN2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTs6FromPssELIN2Command should not be null");
    Assert.notNull(
        command.getPssELIN2Id(), "UnAssignTs6FromPssELIN2Command identifier should not be null");
  }
}
