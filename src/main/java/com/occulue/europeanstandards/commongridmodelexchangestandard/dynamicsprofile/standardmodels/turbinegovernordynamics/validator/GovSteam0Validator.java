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

public class GovSteam0Validator {

  /** default constructor */
  protected GovSteam0Validator() {}

  /** factory method */
  public static GovSteam0Validator getInstance() {
    return new GovSteam0Validator();
  }

  /** handles creation validation for a GovSteam0 */
  public void validate(CreateGovSteam0Command govSteam0) throws Exception {
    Assert.notNull(govSteam0, "CreateGovSteam0Command should not be null");
    //		Assert.isNull( govSteam0.getGovSteam0Id(), "CreateGovSteam0Command identifier should be
    // null" );
  }

  /** handles update validation for a GovSteam0 */
  public void validate(UpdateGovSteam0Command govSteam0) throws Exception {
    Assert.notNull(govSteam0, "UpdateGovSteam0Command should not be null");
    Assert.notNull(
        govSteam0.getGovSteam0Id(), "UpdateGovSteam0Command identifier should not be null");
  }

  /** handles delete validation for a GovSteam0 */
  public void validate(DeleteGovSteam0Command govSteam0) throws Exception {
    Assert.notNull(govSteam0, "{commandAlias} should not be null");
    Assert.notNull(
        govSteam0.getGovSteam0Id(), "DeleteGovSteam0Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovSteam0 */
  public void validate(GovSteam0FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovSteam0FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovSteam0Id(), "GovSteam0FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Dt validation for a GovSteam0
   *
   * @param command AssignDtToGovSteam0Command
   */
  public void validate(AssignDtToGovSteam0Command command) throws Exception {
    Assert.notNull(command, "AssignDtToGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(), "AssignDtToGovSteam0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDtToGovSteam0Command assignment should not be null");
  }

  /**
   * handles unassign Dt validation for a GovSteam0
   *
   * @param command UnAssignDtFromGovSteam0Command
   */
  public void validate(UnAssignDtFromGovSteam0Command command) throws Exception {
    Assert.notNull(command, "UnAssignDtFromGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(), "UnAssignDtFromGovSteam0Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovSteam0
   *
   * @param command AssignMwbaseToGovSteam0Command
   */
  public void validate(AssignMwbaseToGovSteam0Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(), "AssignMwbaseToGovSteam0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovSteam0Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovSteam0
   *
   * @param command UnAssignMwbaseFromGovSteam0Command
   */
  public void validate(UnAssignMwbaseFromGovSteam0Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(),
        "UnAssignMwbaseFromGovSteam0Command identifier should not be null");
  }
  /**
   * handles assign R validation for a GovSteam0
   *
   * @param command AssignRToGovSteam0Command
   */
  public void validate(AssignRToGovSteam0Command command) throws Exception {
    Assert.notNull(command, "AssignRToGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(), "AssignRToGovSteam0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRToGovSteam0Command assignment should not be null");
  }

  /**
   * handles unassign R validation for a GovSteam0
   *
   * @param command UnAssignRFromGovSteam0Command
   */
  public void validate(UnAssignRFromGovSteam0Command command) throws Exception {
    Assert.notNull(command, "UnAssignRFromGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(), "UnAssignRFromGovSteam0Command identifier should not be null");
  }
  /**
   * handles assign T1 validation for a GovSteam0
   *
   * @param command AssignT1ToGovSteam0Command
   */
  public void validate(AssignT1ToGovSteam0Command command) throws Exception {
    Assert.notNull(command, "AssignT1ToGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(), "AssignT1ToGovSteam0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToGovSteam0Command assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a GovSteam0
   *
   * @param command UnAssignT1FromGovSteam0Command
   */
  public void validate(UnAssignT1FromGovSteam0Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(), "UnAssignT1FromGovSteam0Command identifier should not be null");
  }
  /**
   * handles assign T2 validation for a GovSteam0
   *
   * @param command AssignT2ToGovSteam0Command
   */
  public void validate(AssignT2ToGovSteam0Command command) throws Exception {
    Assert.notNull(command, "AssignT2ToGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(), "AssignT2ToGovSteam0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToGovSteam0Command assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a GovSteam0
   *
   * @param command UnAssignT2FromGovSteam0Command
   */
  public void validate(UnAssignT2FromGovSteam0Command command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(), "UnAssignT2FromGovSteam0Command identifier should not be null");
  }
  /**
   * handles assign T3 validation for a GovSteam0
   *
   * @param command AssignT3ToGovSteam0Command
   */
  public void validate(AssignT3ToGovSteam0Command command) throws Exception {
    Assert.notNull(command, "AssignT3ToGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(), "AssignT3ToGovSteam0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToGovSteam0Command assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a GovSteam0
   *
   * @param command UnAssignT3FromGovSteam0Command
   */
  public void validate(UnAssignT3FromGovSteam0Command command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(), "UnAssignT3FromGovSteam0Command identifier should not be null");
  }
  /**
   * handles assign Vmax validation for a GovSteam0
   *
   * @param command AssignVmaxToGovSteam0Command
   */
  public void validate(AssignVmaxToGovSteam0Command command) throws Exception {
    Assert.notNull(command, "AssignVmaxToGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(), "AssignVmaxToGovSteam0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmaxToGovSteam0Command assignment should not be null");
  }

  /**
   * handles unassign Vmax validation for a GovSteam0
   *
   * @param command UnAssignVmaxFromGovSteam0Command
   */
  public void validate(UnAssignVmaxFromGovSteam0Command command) throws Exception {
    Assert.notNull(command, "UnAssignVmaxFromGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(), "UnAssignVmaxFromGovSteam0Command identifier should not be null");
  }
  /**
   * handles assign Vmin validation for a GovSteam0
   *
   * @param command AssignVminToGovSteam0Command
   */
  public void validate(AssignVminToGovSteam0Command command) throws Exception {
    Assert.notNull(command, "AssignVminToGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(), "AssignVminToGovSteam0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVminToGovSteam0Command assignment should not be null");
  }

  /**
   * handles unassign Vmin validation for a GovSteam0
   *
   * @param command UnAssignVminFromGovSteam0Command
   */
  public void validate(UnAssignVminFromGovSteam0Command command) throws Exception {
    Assert.notNull(command, "UnAssignVminFromGovSteam0Command should not be null");
    Assert.notNull(
        command.getGovSteam0Id(), "UnAssignVminFromGovSteam0Command identifier should not be null");
  }
}
