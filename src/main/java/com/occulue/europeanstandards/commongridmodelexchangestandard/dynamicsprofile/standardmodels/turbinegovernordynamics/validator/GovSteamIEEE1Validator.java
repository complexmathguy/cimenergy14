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

public class GovSteamIEEE1Validator {

  /** default constructor */
  protected GovSteamIEEE1Validator() {}

  /** factory method */
  public static GovSteamIEEE1Validator getInstance() {
    return new GovSteamIEEE1Validator();
  }

  /** handles creation validation for a GovSteamIEEE1 */
  public void validate(CreateGovSteamIEEE1Command govSteamIEEE1) throws Exception {
    Assert.notNull(govSteamIEEE1, "CreateGovSteamIEEE1Command should not be null");
    //		Assert.isNull( govSteamIEEE1.getGovSteamIEEE1Id(), "CreateGovSteamIEEE1Command identifier
    // should be null" );
  }

  /** handles update validation for a GovSteamIEEE1 */
  public void validate(UpdateGovSteamIEEE1Command govSteamIEEE1) throws Exception {
    Assert.notNull(govSteamIEEE1, "UpdateGovSteamIEEE1Command should not be null");
    Assert.notNull(
        govSteamIEEE1.getGovSteamIEEE1Id(),
        "UpdateGovSteamIEEE1Command identifier should not be null");
  }

  /** handles delete validation for a GovSteamIEEE1 */
  public void validate(DeleteGovSteamIEEE1Command govSteamIEEE1) throws Exception {
    Assert.notNull(govSteamIEEE1, "{commandAlias} should not be null");
    Assert.notNull(
        govSteamIEEE1.getGovSteamIEEE1Id(),
        "DeleteGovSteamIEEE1Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovSteamIEEE1 */
  public void validate(GovSteamIEEE1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovSteamIEEE1FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovSteamIEEE1Id(), "GovSteamIEEE1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign K validation for a GovSteamIEEE1
   *
   * @param command AssignKToGovSteamIEEE1Command
   */
  public void validate(AssignKToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignKToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignKToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign K validation for a GovSteamIEEE1
   *
   * @param command UnAssignKFromGovSteamIEEE1Command
   */
  public void validate(UnAssignKFromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKFromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignKFromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign K1 validation for a GovSteamIEEE1
   *
   * @param command AssignK1ToGovSteamIEEE1Command
   */
  public void validate(AssignK1ToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignK1ToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignK1ToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK1ToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign K1 validation for a GovSteamIEEE1
   *
   * @param command UnAssignK1FromGovSteamIEEE1Command
   */
  public void validate(UnAssignK1FromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK1FromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignK1FromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign K2 validation for a GovSteamIEEE1
   *
   * @param command AssignK2ToGovSteamIEEE1Command
   */
  public void validate(AssignK2ToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignK2ToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignK2ToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK2ToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign K2 validation for a GovSteamIEEE1
   *
   * @param command UnAssignK2FromGovSteamIEEE1Command
   */
  public void validate(UnAssignK2FromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK2FromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignK2FromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign K3 validation for a GovSteamIEEE1
   *
   * @param command AssignK3ToGovSteamIEEE1Command
   */
  public void validate(AssignK3ToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignK3ToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignK3ToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK3ToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign K3 validation for a GovSteamIEEE1
   *
   * @param command UnAssignK3FromGovSteamIEEE1Command
   */
  public void validate(UnAssignK3FromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK3FromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignK3FromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign K4 validation for a GovSteamIEEE1
   *
   * @param command AssignK4ToGovSteamIEEE1Command
   */
  public void validate(AssignK4ToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignK4ToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignK4ToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK4ToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign K4 validation for a GovSteamIEEE1
   *
   * @param command UnAssignK4FromGovSteamIEEE1Command
   */
  public void validate(UnAssignK4FromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK4FromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignK4FromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign K5 validation for a GovSteamIEEE1
   *
   * @param command AssignK5ToGovSteamIEEE1Command
   */
  public void validate(AssignK5ToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignK5ToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignK5ToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK5ToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign K5 validation for a GovSteamIEEE1
   *
   * @param command UnAssignK5FromGovSteamIEEE1Command
   */
  public void validate(UnAssignK5FromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK5FromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignK5FromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign K6 validation for a GovSteamIEEE1
   *
   * @param command AssignK6ToGovSteamIEEE1Command
   */
  public void validate(AssignK6ToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignK6ToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignK6ToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK6ToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign K6 validation for a GovSteamIEEE1
   *
   * @param command UnAssignK6FromGovSteamIEEE1Command
   */
  public void validate(UnAssignK6FromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK6FromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignK6FromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign K7 validation for a GovSteamIEEE1
   *
   * @param command AssignK7ToGovSteamIEEE1Command
   */
  public void validate(AssignK7ToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignK7ToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignK7ToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK7ToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign K7 validation for a GovSteamIEEE1
   *
   * @param command UnAssignK7FromGovSteamIEEE1Command
   */
  public void validate(UnAssignK7FromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK7FromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignK7FromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign K8 validation for a GovSteamIEEE1
   *
   * @param command AssignK8ToGovSteamIEEE1Command
   */
  public void validate(AssignK8ToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignK8ToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignK8ToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK8ToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign K8 validation for a GovSteamIEEE1
   *
   * @param command UnAssignK8FromGovSteamIEEE1Command
   */
  public void validate(UnAssignK8FromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK8FromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignK8FromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovSteamIEEE1
   *
   * @param command AssignMwbaseToGovSteamIEEE1Command
   */
  public void validate(AssignMwbaseToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignMwbaseToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMwbaseToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovSteamIEEE1
   *
   * @param command UnAssignMwbaseFromGovSteamIEEE1Command
   */
  public void validate(UnAssignMwbaseFromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignMwbaseFromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Pmax validation for a GovSteamIEEE1
   *
   * @param command AssignPmaxToGovSteamIEEE1Command
   */
  public void validate(AssignPmaxToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignPmaxToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignPmaxToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Pmax validation for a GovSteamIEEE1
   *
   * @param command UnAssignPmaxFromGovSteamIEEE1Command
   */
  public void validate(UnAssignPmaxFromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxFromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignPmaxFromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Pmin validation for a GovSteamIEEE1
   *
   * @param command AssignPminToGovSteamIEEE1Command
   */
  public void validate(AssignPminToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignPminToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignPminToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPminToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Pmin validation for a GovSteamIEEE1
   *
   * @param command UnAssignPminFromGovSteamIEEE1Command
   */
  public void validate(UnAssignPminFromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPminFromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignPminFromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign T1 validation for a GovSteamIEEE1
   *
   * @param command AssignT1ToGovSteamIEEE1Command
   */
  public void validate(AssignT1ToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignT1ToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignT1ToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a GovSteamIEEE1
   *
   * @param command UnAssignT1FromGovSteamIEEE1Command
   */
  public void validate(UnAssignT1FromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignT1FromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign T2 validation for a GovSteamIEEE1
   *
   * @param command AssignT2ToGovSteamIEEE1Command
   */
  public void validate(AssignT2ToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignT2ToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignT2ToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a GovSteamIEEE1
   *
   * @param command UnAssignT2FromGovSteamIEEE1Command
   */
  public void validate(UnAssignT2FromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignT2FromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign T3 validation for a GovSteamIEEE1
   *
   * @param command AssignT3ToGovSteamIEEE1Command
   */
  public void validate(AssignT3ToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignT3ToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignT3ToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a GovSteamIEEE1
   *
   * @param command UnAssignT3FromGovSteamIEEE1Command
   */
  public void validate(UnAssignT3FromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignT3FromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign T4 validation for a GovSteamIEEE1
   *
   * @param command AssignT4ToGovSteamIEEE1Command
   */
  public void validate(AssignT4ToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignT4ToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignT4ToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a GovSteamIEEE1
   *
   * @param command UnAssignT4FromGovSteamIEEE1Command
   */
  public void validate(UnAssignT4FromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignT4FromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign T5 validation for a GovSteamIEEE1
   *
   * @param command AssignT5ToGovSteamIEEE1Command
   */
  public void validate(AssignT5ToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignT5ToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignT5ToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5ToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a GovSteamIEEE1
   *
   * @param command UnAssignT5FromGovSteamIEEE1Command
   */
  public void validate(UnAssignT5FromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignT5FromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign T6 validation for a GovSteamIEEE1
   *
   * @param command AssignT6ToGovSteamIEEE1Command
   */
  public void validate(AssignT6ToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignT6ToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignT6ToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT6ToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a GovSteamIEEE1
   *
   * @param command UnAssignT6FromGovSteamIEEE1Command
   */
  public void validate(UnAssignT6FromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignT6FromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign T7 validation for a GovSteamIEEE1
   *
   * @param command AssignT7ToGovSteamIEEE1Command
   */
  public void validate(AssignT7ToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignT7ToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignT7ToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT7ToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign T7 validation for a GovSteamIEEE1
   *
   * @param command UnAssignT7FromGovSteamIEEE1Command
   */
  public void validate(UnAssignT7FromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT7FromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignT7FromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Uc validation for a GovSteamIEEE1
   *
   * @param command AssignUcToGovSteamIEEE1Command
   */
  public void validate(AssignUcToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignUcToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignUcToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUcToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Uc validation for a GovSteamIEEE1
   *
   * @param command UnAssignUcFromGovSteamIEEE1Command
   */
  public void validate(UnAssignUcFromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignUcFromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignUcFromGovSteamIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Uo validation for a GovSteamIEEE1
   *
   * @param command AssignUoToGovSteamIEEE1Command
   */
  public void validate(AssignUoToGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignUoToGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "AssignUoToGovSteamIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUoToGovSteamIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Uo validation for a GovSteamIEEE1
   *
   * @param command UnAssignUoFromGovSteamIEEE1Command
   */
  public void validate(UnAssignUoFromGovSteamIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignUoFromGovSteamIEEE1Command should not be null");
    Assert.notNull(
        command.getGovSteamIEEE1Id(),
        "UnAssignUoFromGovSteamIEEE1Command identifier should not be null");
  }
}
