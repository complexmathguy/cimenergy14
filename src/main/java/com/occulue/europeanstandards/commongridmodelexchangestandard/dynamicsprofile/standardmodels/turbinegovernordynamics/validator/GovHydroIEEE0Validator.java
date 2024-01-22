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

public class GovHydroIEEE0Validator {

  /** default constructor */
  protected GovHydroIEEE0Validator() {}

  /** factory method */
  public static GovHydroIEEE0Validator getInstance() {
    return new GovHydroIEEE0Validator();
  }

  /** handles creation validation for a GovHydroIEEE0 */
  public void validate(CreateGovHydroIEEE0Command govHydroIEEE0) throws Exception {
    Assert.notNull(govHydroIEEE0, "CreateGovHydroIEEE0Command should not be null");
    //		Assert.isNull( govHydroIEEE0.getGovHydroIEEE0Id(), "CreateGovHydroIEEE0Command identifier
    // should be null" );
  }

  /** handles update validation for a GovHydroIEEE0 */
  public void validate(UpdateGovHydroIEEE0Command govHydroIEEE0) throws Exception {
    Assert.notNull(govHydroIEEE0, "UpdateGovHydroIEEE0Command should not be null");
    Assert.notNull(
        govHydroIEEE0.getGovHydroIEEE0Id(),
        "UpdateGovHydroIEEE0Command identifier should not be null");
  }

  /** handles delete validation for a GovHydroIEEE0 */
  public void validate(DeleteGovHydroIEEE0Command govHydroIEEE0) throws Exception {
    Assert.notNull(govHydroIEEE0, "{commandAlias} should not be null");
    Assert.notNull(
        govHydroIEEE0.getGovHydroIEEE0Id(),
        "DeleteGovHydroIEEE0Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovHydroIEEE0 */
  public void validate(GovHydroIEEE0FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovHydroIEEE0FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovHydroIEEE0Id(), "GovHydroIEEE0FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign K validation for a GovHydroIEEE0
   *
   * @param command AssignKToGovHydroIEEE0Command
   */
  public void validate(AssignKToGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "AssignKToGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "AssignKToGovHydroIEEE0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKToGovHydroIEEE0Command assignment should not be null");
  }

  /**
   * handles unassign K validation for a GovHydroIEEE0
   *
   * @param command UnAssignKFromGovHydroIEEE0Command
   */
  public void validate(UnAssignKFromGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "UnAssignKFromGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "UnAssignKFromGovHydroIEEE0Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovHydroIEEE0
   *
   * @param command AssignMwbaseToGovHydroIEEE0Command
   */
  public void validate(AssignMwbaseToGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "AssignMwbaseToGovHydroIEEE0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMwbaseToGovHydroIEEE0Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovHydroIEEE0
   *
   * @param command UnAssignMwbaseFromGovHydroIEEE0Command
   */
  public void validate(UnAssignMwbaseFromGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "UnAssignMwbaseFromGovHydroIEEE0Command identifier should not be null");
  }
  /**
   * handles assign Pmax validation for a GovHydroIEEE0
   *
   * @param command AssignPmaxToGovHydroIEEE0Command
   */
  public void validate(AssignPmaxToGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "AssignPmaxToGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "AssignPmaxToGovHydroIEEE0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxToGovHydroIEEE0Command assignment should not be null");
  }

  /**
   * handles unassign Pmax validation for a GovHydroIEEE0
   *
   * @param command UnAssignPmaxFromGovHydroIEEE0Command
   */
  public void validate(UnAssignPmaxFromGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxFromGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "UnAssignPmaxFromGovHydroIEEE0Command identifier should not be null");
  }
  /**
   * handles assign Pmin validation for a GovHydroIEEE0
   *
   * @param command AssignPminToGovHydroIEEE0Command
   */
  public void validate(AssignPminToGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "AssignPminToGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "AssignPminToGovHydroIEEE0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPminToGovHydroIEEE0Command assignment should not be null");
  }

  /**
   * handles unassign Pmin validation for a GovHydroIEEE0
   *
   * @param command UnAssignPminFromGovHydroIEEE0Command
   */
  public void validate(UnAssignPminFromGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "UnAssignPminFromGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "UnAssignPminFromGovHydroIEEE0Command identifier should not be null");
  }
  /**
   * handles assign T1 validation for a GovHydroIEEE0
   *
   * @param command AssignT1ToGovHydroIEEE0Command
   */
  public void validate(AssignT1ToGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "AssignT1ToGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "AssignT1ToGovHydroIEEE0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToGovHydroIEEE0Command assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a GovHydroIEEE0
   *
   * @param command UnAssignT1FromGovHydroIEEE0Command
   */
  public void validate(UnAssignT1FromGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "UnAssignT1FromGovHydroIEEE0Command identifier should not be null");
  }
  /**
   * handles assign T2 validation for a GovHydroIEEE0
   *
   * @param command AssignT2ToGovHydroIEEE0Command
   */
  public void validate(AssignT2ToGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "AssignT2ToGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "AssignT2ToGovHydroIEEE0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToGovHydroIEEE0Command assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a GovHydroIEEE0
   *
   * @param command UnAssignT2FromGovHydroIEEE0Command
   */
  public void validate(UnAssignT2FromGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "UnAssignT2FromGovHydroIEEE0Command identifier should not be null");
  }
  /**
   * handles assign T3 validation for a GovHydroIEEE0
   *
   * @param command AssignT3ToGovHydroIEEE0Command
   */
  public void validate(AssignT3ToGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "AssignT3ToGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "AssignT3ToGovHydroIEEE0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToGovHydroIEEE0Command assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a GovHydroIEEE0
   *
   * @param command UnAssignT3FromGovHydroIEEE0Command
   */
  public void validate(UnAssignT3FromGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "UnAssignT3FromGovHydroIEEE0Command identifier should not be null");
  }
  /**
   * handles assign T4 validation for a GovHydroIEEE0
   *
   * @param command AssignT4ToGovHydroIEEE0Command
   */
  public void validate(AssignT4ToGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "AssignT4ToGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "AssignT4ToGovHydroIEEE0Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToGovHydroIEEE0Command assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a GovHydroIEEE0
   *
   * @param command UnAssignT4FromGovHydroIEEE0Command
   */
  public void validate(UnAssignT4FromGovHydroIEEE0Command command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromGovHydroIEEE0Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE0Id(),
        "UnAssignT4FromGovHydroIEEE0Command identifier should not be null");
  }
}
