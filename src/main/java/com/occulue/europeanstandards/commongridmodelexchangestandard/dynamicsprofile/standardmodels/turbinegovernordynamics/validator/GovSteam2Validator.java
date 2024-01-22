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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class GovSteam2Validator {

  /** default constructor */
  protected GovSteam2Validator() {}

  /** factory method */
  public static GovSteam2Validator getInstance() {
    return new GovSteam2Validator();
  }

  /** handles creation validation for a GovSteam2 */
  public void validate(CreateGovSteam2Command govSteam2) throws Exception {
    Assert.notNull(govSteam2, "CreateGovSteam2Command should not be null");
    //		Assert.isNull( govSteam2.getGovSteam2Id(), "CreateGovSteam2Command identifier should be
    // null" );
  }

  /** handles update validation for a GovSteam2 */
  public void validate(UpdateGovSteam2Command govSteam2) throws Exception {
    Assert.notNull(govSteam2, "UpdateGovSteam2Command should not be null");
    Assert.notNull(
        govSteam2.getGovSteam2Id(), "UpdateGovSteam2Command identifier should not be null");
  }

  /** handles delete validation for a GovSteam2 */
  public void validate(DeleteGovSteam2Command govSteam2) throws Exception {
    Assert.notNull(govSteam2, "{commandAlias} should not be null");
    Assert.notNull(
        govSteam2.getGovSteam2Id(), "DeleteGovSteam2Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovSteam2 */
  public void validate(GovSteam2FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovSteam2FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovSteam2Id(), "GovSteam2FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Dbf validation for a GovSteam2
   *
   * @param command AssignDbfToGovSteam2Command
   */
  public void validate(AssignDbfToGovSteam2Command command) throws Exception {
    Assert.notNull(command, "AssignDbfToGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "AssignDbfToGovSteam2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDbfToGovSteam2Command assignment should not be null");
  }

  /**
   * handles unassign Dbf validation for a GovSteam2
   *
   * @param command UnAssignDbfFromGovSteam2Command
   */
  public void validate(UnAssignDbfFromGovSteam2Command command) throws Exception {
    Assert.notNull(command, "UnAssignDbfFromGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "UnAssignDbfFromGovSteam2Command identifier should not be null");
  }
  /**
   * handles assign K validation for a GovSteam2
   *
   * @param command AssignKToGovSteam2Command
   */
  public void validate(AssignKToGovSteam2Command command) throws Exception {
    Assert.notNull(command, "AssignKToGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "AssignKToGovSteam2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKToGovSteam2Command assignment should not be null");
  }

  /**
   * handles unassign K validation for a GovSteam2
   *
   * @param command UnAssignKFromGovSteam2Command
   */
  public void validate(UnAssignKFromGovSteam2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKFromGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "UnAssignKFromGovSteam2Command identifier should not be null");
  }
  /**
   * handles assign Mnef validation for a GovSteam2
   *
   * @param command AssignMnefToGovSteam2Command
   */
  public void validate(AssignMnefToGovSteam2Command command) throws Exception {
    Assert.notNull(command, "AssignMnefToGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "AssignMnefToGovSteam2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMnefToGovSteam2Command assignment should not be null");
  }

  /**
   * handles unassign Mnef validation for a GovSteam2
   *
   * @param command UnAssignMnefFromGovSteam2Command
   */
  public void validate(UnAssignMnefFromGovSteam2Command command) throws Exception {
    Assert.notNull(command, "UnAssignMnefFromGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "UnAssignMnefFromGovSteam2Command identifier should not be null");
  }
  /**
   * handles assign Mxef validation for a GovSteam2
   *
   * @param command AssignMxefToGovSteam2Command
   */
  public void validate(AssignMxefToGovSteam2Command command) throws Exception {
    Assert.notNull(command, "AssignMxefToGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "AssignMxefToGovSteam2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMxefToGovSteam2Command assignment should not be null");
  }

  /**
   * handles unassign Mxef validation for a GovSteam2
   *
   * @param command UnAssignMxefFromGovSteam2Command
   */
  public void validate(UnAssignMxefFromGovSteam2Command command) throws Exception {
    Assert.notNull(command, "UnAssignMxefFromGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "UnAssignMxefFromGovSteam2Command identifier should not be null");
  }
  /**
   * handles assign Pmax validation for a GovSteam2
   *
   * @param command AssignPmaxToGovSteam2Command
   */
  public void validate(AssignPmaxToGovSteam2Command command) throws Exception {
    Assert.notNull(command, "AssignPmaxToGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "AssignPmaxToGovSteam2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxToGovSteam2Command assignment should not be null");
  }

  /**
   * handles unassign Pmax validation for a GovSteam2
   *
   * @param command UnAssignPmaxFromGovSteam2Command
   */
  public void validate(UnAssignPmaxFromGovSteam2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxFromGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "UnAssignPmaxFromGovSteam2Command identifier should not be null");
  }
  /**
   * handles assign Pmin validation for a GovSteam2
   *
   * @param command AssignPminToGovSteam2Command
   */
  public void validate(AssignPminToGovSteam2Command command) throws Exception {
    Assert.notNull(command, "AssignPminToGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "AssignPminToGovSteam2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPminToGovSteam2Command assignment should not be null");
  }

  /**
   * handles unassign Pmin validation for a GovSteam2
   *
   * @param command UnAssignPminFromGovSteam2Command
   */
  public void validate(UnAssignPminFromGovSteam2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPminFromGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "UnAssignPminFromGovSteam2Command identifier should not be null");
  }
  /**
   * handles assign T1 validation for a GovSteam2
   *
   * @param command AssignT1ToGovSteam2Command
   */
  public void validate(AssignT1ToGovSteam2Command command) throws Exception {
    Assert.notNull(command, "AssignT1ToGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "AssignT1ToGovSteam2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToGovSteam2Command assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a GovSteam2
   *
   * @param command UnAssignT1FromGovSteam2Command
   */
  public void validate(UnAssignT1FromGovSteam2Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "UnAssignT1FromGovSteam2Command identifier should not be null");
  }
  /**
   * handles assign T2 validation for a GovSteam2
   *
   * @param command AssignT2ToGovSteam2Command
   */
  public void validate(AssignT2ToGovSteam2Command command) throws Exception {
    Assert.notNull(command, "AssignT2ToGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "AssignT2ToGovSteam2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToGovSteam2Command assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a GovSteam2
   *
   * @param command UnAssignT2FromGovSteam2Command
   */
  public void validate(UnAssignT2FromGovSteam2Command command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromGovSteam2Command should not be null");
    Assert.notNull(
        command.getGovSteam2Id(), "UnAssignT2FromGovSteam2Command identifier should not be null");
  }
}
