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

public class GovHydroIEEE2Validator {

  /** default constructor */
  protected GovHydroIEEE2Validator() {}

  /** factory method */
  public static GovHydroIEEE2Validator getInstance() {
    return new GovHydroIEEE2Validator();
  }

  /** handles creation validation for a GovHydroIEEE2 */
  public void validate(CreateGovHydroIEEE2Command govHydroIEEE2) throws Exception {
    Assert.notNull(govHydroIEEE2, "CreateGovHydroIEEE2Command should not be null");
    //		Assert.isNull( govHydroIEEE2.getGovHydroIEEE2Id(), "CreateGovHydroIEEE2Command identifier
    // should be null" );
  }

  /** handles update validation for a GovHydroIEEE2 */
  public void validate(UpdateGovHydroIEEE2Command govHydroIEEE2) throws Exception {
    Assert.notNull(govHydroIEEE2, "UpdateGovHydroIEEE2Command should not be null");
    Assert.notNull(
        govHydroIEEE2.getGovHydroIEEE2Id(),
        "UpdateGovHydroIEEE2Command identifier should not be null");
  }

  /** handles delete validation for a GovHydroIEEE2 */
  public void validate(DeleteGovHydroIEEE2Command govHydroIEEE2) throws Exception {
    Assert.notNull(govHydroIEEE2, "{commandAlias} should not be null");
    Assert.notNull(
        govHydroIEEE2.getGovHydroIEEE2Id(),
        "DeleteGovHydroIEEE2Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovHydroIEEE2 */
  public void validate(GovHydroIEEE2FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovHydroIEEE2FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovHydroIEEE2Id(), "GovHydroIEEE2FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Aturb validation for a GovHydroIEEE2
   *
   * @param command AssignAturbToGovHydroIEEE2Command
   */
  public void validate(AssignAturbToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignAturbToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignAturbToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAturbToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Aturb validation for a GovHydroIEEE2
   *
   * @param command UnAssignAturbFromGovHydroIEEE2Command
   */
  public void validate(UnAssignAturbFromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignAturbFromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignAturbFromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Bturb validation for a GovHydroIEEE2
   *
   * @param command AssignBturbToGovHydroIEEE2Command
   */
  public void validate(AssignBturbToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignBturbToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignBturbToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBturbToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Bturb validation for a GovHydroIEEE2
   *
   * @param command UnAssignBturbFromGovHydroIEEE2Command
   */
  public void validate(UnAssignBturbFromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignBturbFromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignBturbFromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Gv1 validation for a GovHydroIEEE2
   *
   * @param command AssignGv1ToGovHydroIEEE2Command
   */
  public void validate(AssignGv1ToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignGv1ToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignGv1ToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv1ToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Gv1 validation for a GovHydroIEEE2
   *
   * @param command UnAssignGv1FromGovHydroIEEE2Command
   */
  public void validate(UnAssignGv1FromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv1FromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignGv1FromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Gv2 validation for a GovHydroIEEE2
   *
   * @param command AssignGv2ToGovHydroIEEE2Command
   */
  public void validate(AssignGv2ToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignGv2ToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignGv2ToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv2ToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Gv2 validation for a GovHydroIEEE2
   *
   * @param command UnAssignGv2FromGovHydroIEEE2Command
   */
  public void validate(UnAssignGv2FromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv2FromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignGv2FromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Gv3 validation for a GovHydroIEEE2
   *
   * @param command AssignGv3ToGovHydroIEEE2Command
   */
  public void validate(AssignGv3ToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignGv3ToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignGv3ToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv3ToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Gv3 validation for a GovHydroIEEE2
   *
   * @param command UnAssignGv3FromGovHydroIEEE2Command
   */
  public void validate(UnAssignGv3FromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv3FromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignGv3FromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Gv4 validation for a GovHydroIEEE2
   *
   * @param command AssignGv4ToGovHydroIEEE2Command
   */
  public void validate(AssignGv4ToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignGv4ToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignGv4ToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv4ToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Gv4 validation for a GovHydroIEEE2
   *
   * @param command UnAssignGv4FromGovHydroIEEE2Command
   */
  public void validate(UnAssignGv4FromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv4FromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignGv4FromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Gv5 validation for a GovHydroIEEE2
   *
   * @param command AssignGv5ToGovHydroIEEE2Command
   */
  public void validate(AssignGv5ToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignGv5ToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignGv5ToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv5ToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Gv5 validation for a GovHydroIEEE2
   *
   * @param command UnAssignGv5FromGovHydroIEEE2Command
   */
  public void validate(UnAssignGv5FromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv5FromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignGv5FromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Gv6 validation for a GovHydroIEEE2
   *
   * @param command AssignGv6ToGovHydroIEEE2Command
   */
  public void validate(AssignGv6ToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignGv6ToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignGv6ToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv6ToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Gv6 validation for a GovHydroIEEE2
   *
   * @param command UnAssignGv6FromGovHydroIEEE2Command
   */
  public void validate(UnAssignGv6FromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv6FromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignGv6FromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Kturb validation for a GovHydroIEEE2
   *
   * @param command AssignKturbToGovHydroIEEE2Command
   */
  public void validate(AssignKturbToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignKturbToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignKturbToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKturbToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Kturb validation for a GovHydroIEEE2
   *
   * @param command UnAssignKturbFromGovHydroIEEE2Command
   */
  public void validate(UnAssignKturbFromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKturbFromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignKturbFromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovHydroIEEE2
   *
   * @param command AssignMwbaseToGovHydroIEEE2Command
   */
  public void validate(AssignMwbaseToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignMwbaseToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMwbaseToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovHydroIEEE2
   *
   * @param command UnAssignMwbaseFromGovHydroIEEE2Command
   */
  public void validate(UnAssignMwbaseFromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignMwbaseFromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Pgv1 validation for a GovHydroIEEE2
   *
   * @param command AssignPgv1ToGovHydroIEEE2Command
   */
  public void validate(AssignPgv1ToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignPgv1ToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignPgv1ToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv1ToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Pgv1 validation for a GovHydroIEEE2
   *
   * @param command UnAssignPgv1FromGovHydroIEEE2Command
   */
  public void validate(UnAssignPgv1FromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv1FromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignPgv1FromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Pgv2 validation for a GovHydroIEEE2
   *
   * @param command AssignPgv2ToGovHydroIEEE2Command
   */
  public void validate(AssignPgv2ToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignPgv2ToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignPgv2ToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv2ToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Pgv2 validation for a GovHydroIEEE2
   *
   * @param command UnAssignPgv2FromGovHydroIEEE2Command
   */
  public void validate(UnAssignPgv2FromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv2FromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignPgv2FromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Pgv3 validation for a GovHydroIEEE2
   *
   * @param command AssignPgv3ToGovHydroIEEE2Command
   */
  public void validate(AssignPgv3ToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignPgv3ToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignPgv3ToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv3ToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Pgv3 validation for a GovHydroIEEE2
   *
   * @param command UnAssignPgv3FromGovHydroIEEE2Command
   */
  public void validate(UnAssignPgv3FromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv3FromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignPgv3FromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Pgv4 validation for a GovHydroIEEE2
   *
   * @param command AssignPgv4ToGovHydroIEEE2Command
   */
  public void validate(AssignPgv4ToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignPgv4ToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignPgv4ToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv4ToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Pgv4 validation for a GovHydroIEEE2
   *
   * @param command UnAssignPgv4FromGovHydroIEEE2Command
   */
  public void validate(UnAssignPgv4FromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv4FromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignPgv4FromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Pgv5 validation for a GovHydroIEEE2
   *
   * @param command AssignPgv5ToGovHydroIEEE2Command
   */
  public void validate(AssignPgv5ToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignPgv5ToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignPgv5ToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv5ToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Pgv5 validation for a GovHydroIEEE2
   *
   * @param command UnAssignPgv5FromGovHydroIEEE2Command
   */
  public void validate(UnAssignPgv5FromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv5FromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignPgv5FromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Pgv6 validation for a GovHydroIEEE2
   *
   * @param command AssignPgv6ToGovHydroIEEE2Command
   */
  public void validate(AssignPgv6ToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignPgv6ToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignPgv6ToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv6ToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Pgv6 validation for a GovHydroIEEE2
   *
   * @param command UnAssignPgv6FromGovHydroIEEE2Command
   */
  public void validate(UnAssignPgv6FromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv6FromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignPgv6FromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Pmax validation for a GovHydroIEEE2
   *
   * @param command AssignPmaxToGovHydroIEEE2Command
   */
  public void validate(AssignPmaxToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignPmaxToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignPmaxToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Pmax validation for a GovHydroIEEE2
   *
   * @param command UnAssignPmaxFromGovHydroIEEE2Command
   */
  public void validate(UnAssignPmaxFromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxFromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignPmaxFromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Pmin validation for a GovHydroIEEE2
   *
   * @param command AssignPminToGovHydroIEEE2Command
   */
  public void validate(AssignPminToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignPminToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignPminToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPminToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Pmin validation for a GovHydroIEEE2
   *
   * @param command UnAssignPminFromGovHydroIEEE2Command
   */
  public void validate(UnAssignPminFromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPminFromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignPminFromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Rperm validation for a GovHydroIEEE2
   *
   * @param command AssignRpermToGovHydroIEEE2Command
   */
  public void validate(AssignRpermToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignRpermToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignRpermToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRpermToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Rperm validation for a GovHydroIEEE2
   *
   * @param command UnAssignRpermFromGovHydroIEEE2Command
   */
  public void validate(UnAssignRpermFromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignRpermFromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignRpermFromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Rtemp validation for a GovHydroIEEE2
   *
   * @param command AssignRtempToGovHydroIEEE2Command
   */
  public void validate(AssignRtempToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignRtempToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignRtempToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRtempToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Rtemp validation for a GovHydroIEEE2
   *
   * @param command UnAssignRtempFromGovHydroIEEE2Command
   */
  public void validate(UnAssignRtempFromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignRtempFromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignRtempFromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Tg validation for a GovHydroIEEE2
   *
   * @param command AssignTgToGovHydroIEEE2Command
   */
  public void validate(AssignTgToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignTgToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignTgToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTgToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Tg validation for a GovHydroIEEE2
   *
   * @param command UnAssignTgFromGovHydroIEEE2Command
   */
  public void validate(UnAssignTgFromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTgFromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignTgFromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Tp validation for a GovHydroIEEE2
   *
   * @param command AssignTpToGovHydroIEEE2Command
   */
  public void validate(AssignTpToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignTpToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignTpToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Tp validation for a GovHydroIEEE2
   *
   * @param command UnAssignTpFromGovHydroIEEE2Command
   */
  public void validate(UnAssignTpFromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTpFromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignTpFromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Tr validation for a GovHydroIEEE2
   *
   * @param command AssignTrToGovHydroIEEE2Command
   */
  public void validate(AssignTrToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignTrToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignTrToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTrToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Tr validation for a GovHydroIEEE2
   *
   * @param command UnAssignTrFromGovHydroIEEE2Command
   */
  public void validate(UnAssignTrFromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTrFromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignTrFromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Tw validation for a GovHydroIEEE2
   *
   * @param command AssignTwToGovHydroIEEE2Command
   */
  public void validate(AssignTwToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignTwToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignTwToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTwToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Tw validation for a GovHydroIEEE2
   *
   * @param command UnAssignTwFromGovHydroIEEE2Command
   */
  public void validate(UnAssignTwFromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTwFromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignTwFromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Uc validation for a GovHydroIEEE2
   *
   * @param command AssignUcToGovHydroIEEE2Command
   */
  public void validate(AssignUcToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignUcToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignUcToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUcToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Uc validation for a GovHydroIEEE2
   *
   * @param command UnAssignUcFromGovHydroIEEE2Command
   */
  public void validate(UnAssignUcFromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignUcFromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignUcFromGovHydroIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Uo validation for a GovHydroIEEE2
   *
   * @param command AssignUoToGovHydroIEEE2Command
   */
  public void validate(AssignUoToGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignUoToGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "AssignUoToGovHydroIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUoToGovHydroIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Uo validation for a GovHydroIEEE2
   *
   * @param command UnAssignUoFromGovHydroIEEE2Command
   */
  public void validate(UnAssignUoFromGovHydroIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignUoFromGovHydroIEEE2Command should not be null");
    Assert.notNull(
        command.getGovHydroIEEE2Id(),
        "UnAssignUoFromGovHydroIEEE2Command identifier should not be null");
  }
}
