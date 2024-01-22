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

public class GovHydro2Validator {

  /** default constructor */
  protected GovHydro2Validator() {}

  /** factory method */
  public static GovHydro2Validator getInstance() {
    return new GovHydro2Validator();
  }

  /** handles creation validation for a GovHydro2 */
  public void validate(CreateGovHydro2Command govHydro2) throws Exception {
    Assert.notNull(govHydro2, "CreateGovHydro2Command should not be null");
    //		Assert.isNull( govHydro2.getGovHydro2Id(), "CreateGovHydro2Command identifier should be
    // null" );
  }

  /** handles update validation for a GovHydro2 */
  public void validate(UpdateGovHydro2Command govHydro2) throws Exception {
    Assert.notNull(govHydro2, "UpdateGovHydro2Command should not be null");
    Assert.notNull(
        govHydro2.getGovHydro2Id(), "UpdateGovHydro2Command identifier should not be null");
  }

  /** handles delete validation for a GovHydro2 */
  public void validate(DeleteGovHydro2Command govHydro2) throws Exception {
    Assert.notNull(govHydro2, "{commandAlias} should not be null");
    Assert.notNull(
        govHydro2.getGovHydro2Id(), "DeleteGovHydro2Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovHydro2 */
  public void validate(GovHydro2FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovHydro2FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovHydro2Id(), "GovHydro2FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Aturb validation for a GovHydro2
   *
   * @param command AssignAturbToGovHydro2Command
   */
  public void validate(AssignAturbToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignAturbToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignAturbToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAturbToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Aturb validation for a GovHydro2
   *
   * @param command UnAssignAturbFromGovHydro2Command
   */
  public void validate(UnAssignAturbFromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignAturbFromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(),
        "UnAssignAturbFromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Bturb validation for a GovHydro2
   *
   * @param command AssignBturbToGovHydro2Command
   */
  public void validate(AssignBturbToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignBturbToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignBturbToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBturbToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Bturb validation for a GovHydro2
   *
   * @param command UnAssignBturbFromGovHydro2Command
   */
  public void validate(UnAssignBturbFromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignBturbFromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(),
        "UnAssignBturbFromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Db1 validation for a GovHydro2
   *
   * @param command AssignDb1ToGovHydro2Command
   */
  public void validate(AssignDb1ToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignDb1ToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignDb1ToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb1ToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Db1 validation for a GovHydro2
   *
   * @param command UnAssignDb1FromGovHydro2Command
   */
  public void validate(UnAssignDb1FromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignDb1FromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignDb1FromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Db2 validation for a GovHydro2
   *
   * @param command AssignDb2ToGovHydro2Command
   */
  public void validate(AssignDb2ToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignDb2ToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignDb2ToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb2ToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Db2 validation for a GovHydro2
   *
   * @param command UnAssignDb2FromGovHydro2Command
   */
  public void validate(UnAssignDb2FromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignDb2FromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignDb2FromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Eps validation for a GovHydro2
   *
   * @param command AssignEpsToGovHydro2Command
   */
  public void validate(AssignEpsToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignEpsToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignEpsToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEpsToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Eps validation for a GovHydro2
   *
   * @param command UnAssignEpsFromGovHydro2Command
   */
  public void validate(UnAssignEpsFromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignEpsFromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignEpsFromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Gv1 validation for a GovHydro2
   *
   * @param command AssignGv1ToGovHydro2Command
   */
  public void validate(AssignGv1ToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignGv1ToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignGv1ToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv1ToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Gv1 validation for a GovHydro2
   *
   * @param command UnAssignGv1FromGovHydro2Command
   */
  public void validate(UnAssignGv1FromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv1FromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignGv1FromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Gv2 validation for a GovHydro2
   *
   * @param command AssignGv2ToGovHydro2Command
   */
  public void validate(AssignGv2ToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignGv2ToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignGv2ToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv2ToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Gv2 validation for a GovHydro2
   *
   * @param command UnAssignGv2FromGovHydro2Command
   */
  public void validate(UnAssignGv2FromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv2FromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignGv2FromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Gv3 validation for a GovHydro2
   *
   * @param command AssignGv3ToGovHydro2Command
   */
  public void validate(AssignGv3ToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignGv3ToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignGv3ToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv3ToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Gv3 validation for a GovHydro2
   *
   * @param command UnAssignGv3FromGovHydro2Command
   */
  public void validate(UnAssignGv3FromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv3FromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignGv3FromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Gv4 validation for a GovHydro2
   *
   * @param command AssignGv4ToGovHydro2Command
   */
  public void validate(AssignGv4ToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignGv4ToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignGv4ToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv4ToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Gv4 validation for a GovHydro2
   *
   * @param command UnAssignGv4FromGovHydro2Command
   */
  public void validate(UnAssignGv4FromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv4FromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignGv4FromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Gv5 validation for a GovHydro2
   *
   * @param command AssignGv5ToGovHydro2Command
   */
  public void validate(AssignGv5ToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignGv5ToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignGv5ToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv5ToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Gv5 validation for a GovHydro2
   *
   * @param command UnAssignGv5FromGovHydro2Command
   */
  public void validate(UnAssignGv5FromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv5FromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignGv5FromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Gv6 validation for a GovHydro2
   *
   * @param command AssignGv6ToGovHydro2Command
   */
  public void validate(AssignGv6ToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignGv6ToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignGv6ToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv6ToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Gv6 validation for a GovHydro2
   *
   * @param command UnAssignGv6FromGovHydro2Command
   */
  public void validate(UnAssignGv6FromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv6FromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignGv6FromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Kturb validation for a GovHydro2
   *
   * @param command AssignKturbToGovHydro2Command
   */
  public void validate(AssignKturbToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignKturbToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignKturbToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKturbToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Kturb validation for a GovHydro2
   *
   * @param command UnAssignKturbFromGovHydro2Command
   */
  public void validate(UnAssignKturbFromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKturbFromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(),
        "UnAssignKturbFromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovHydro2
   *
   * @param command AssignMwbaseToGovHydro2Command
   */
  public void validate(AssignMwbaseToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignMwbaseToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovHydro2
   *
   * @param command UnAssignMwbaseFromGovHydro2Command
   */
  public void validate(UnAssignMwbaseFromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(),
        "UnAssignMwbaseFromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Pgv1 validation for a GovHydro2
   *
   * @param command AssignPgv1ToGovHydro2Command
   */
  public void validate(AssignPgv1ToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignPgv1ToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignPgv1ToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv1ToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Pgv1 validation for a GovHydro2
   *
   * @param command UnAssignPgv1FromGovHydro2Command
   */
  public void validate(UnAssignPgv1FromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv1FromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignPgv1FromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Pgv2 validation for a GovHydro2
   *
   * @param command AssignPgv2ToGovHydro2Command
   */
  public void validate(AssignPgv2ToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignPgv2ToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignPgv2ToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv2ToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Pgv2 validation for a GovHydro2
   *
   * @param command UnAssignPgv2FromGovHydro2Command
   */
  public void validate(UnAssignPgv2FromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv2FromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignPgv2FromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Pgv3 validation for a GovHydro2
   *
   * @param command AssignPgv3ToGovHydro2Command
   */
  public void validate(AssignPgv3ToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignPgv3ToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignPgv3ToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv3ToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Pgv3 validation for a GovHydro2
   *
   * @param command UnAssignPgv3FromGovHydro2Command
   */
  public void validate(UnAssignPgv3FromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv3FromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignPgv3FromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Pgv4 validation for a GovHydro2
   *
   * @param command AssignPgv4ToGovHydro2Command
   */
  public void validate(AssignPgv4ToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignPgv4ToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignPgv4ToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv4ToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Pgv4 validation for a GovHydro2
   *
   * @param command UnAssignPgv4FromGovHydro2Command
   */
  public void validate(UnAssignPgv4FromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv4FromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignPgv4FromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Pgv5 validation for a GovHydro2
   *
   * @param command AssignPgv5ToGovHydro2Command
   */
  public void validate(AssignPgv5ToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignPgv5ToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignPgv5ToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv5ToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Pgv5 validation for a GovHydro2
   *
   * @param command UnAssignPgv5FromGovHydro2Command
   */
  public void validate(UnAssignPgv5FromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv5FromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignPgv5FromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Pgv6 validation for a GovHydro2
   *
   * @param command AssignPgv6ToGovHydro2Command
   */
  public void validate(AssignPgv6ToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignPgv6ToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignPgv6ToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv6ToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Pgv6 validation for a GovHydro2
   *
   * @param command UnAssignPgv6FromGovHydro2Command
   */
  public void validate(UnAssignPgv6FromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv6FromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignPgv6FromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Pmax validation for a GovHydro2
   *
   * @param command AssignPmaxToGovHydro2Command
   */
  public void validate(AssignPmaxToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignPmaxToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignPmaxToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Pmax validation for a GovHydro2
   *
   * @param command UnAssignPmaxFromGovHydro2Command
   */
  public void validate(UnAssignPmaxFromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxFromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignPmaxFromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Pmin validation for a GovHydro2
   *
   * @param command AssignPminToGovHydro2Command
   */
  public void validate(AssignPminToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignPminToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignPminToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPminToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Pmin validation for a GovHydro2
   *
   * @param command UnAssignPminFromGovHydro2Command
   */
  public void validate(UnAssignPminFromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignPminFromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignPminFromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Rperm validation for a GovHydro2
   *
   * @param command AssignRpermToGovHydro2Command
   */
  public void validate(AssignRpermToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignRpermToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignRpermToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRpermToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Rperm validation for a GovHydro2
   *
   * @param command UnAssignRpermFromGovHydro2Command
   */
  public void validate(UnAssignRpermFromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignRpermFromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(),
        "UnAssignRpermFromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Rtemp validation for a GovHydro2
   *
   * @param command AssignRtempToGovHydro2Command
   */
  public void validate(AssignRtempToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignRtempToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignRtempToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRtempToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Rtemp validation for a GovHydro2
   *
   * @param command UnAssignRtempFromGovHydro2Command
   */
  public void validate(UnAssignRtempFromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignRtempFromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(),
        "UnAssignRtempFromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Tg validation for a GovHydro2
   *
   * @param command AssignTgToGovHydro2Command
   */
  public void validate(AssignTgToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignTgToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignTgToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTgToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Tg validation for a GovHydro2
   *
   * @param command UnAssignTgFromGovHydro2Command
   */
  public void validate(UnAssignTgFromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTgFromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignTgFromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Tp validation for a GovHydro2
   *
   * @param command AssignTpToGovHydro2Command
   */
  public void validate(AssignTpToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignTpToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignTpToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Tp validation for a GovHydro2
   *
   * @param command UnAssignTpFromGovHydro2Command
   */
  public void validate(UnAssignTpFromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTpFromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignTpFromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Tr validation for a GovHydro2
   *
   * @param command AssignTrToGovHydro2Command
   */
  public void validate(AssignTrToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignTrToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignTrToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTrToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Tr validation for a GovHydro2
   *
   * @param command UnAssignTrFromGovHydro2Command
   */
  public void validate(UnAssignTrFromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTrFromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignTrFromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Tw validation for a GovHydro2
   *
   * @param command AssignTwToGovHydro2Command
   */
  public void validate(AssignTwToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignTwToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignTwToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTwToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Tw validation for a GovHydro2
   *
   * @param command UnAssignTwFromGovHydro2Command
   */
  public void validate(UnAssignTwFromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTwFromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignTwFromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Uc validation for a GovHydro2
   *
   * @param command AssignUcToGovHydro2Command
   */
  public void validate(AssignUcToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignUcToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignUcToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUcToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Uc validation for a GovHydro2
   *
   * @param command UnAssignUcFromGovHydro2Command
   */
  public void validate(UnAssignUcFromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignUcFromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignUcFromGovHydro2Command identifier should not be null");
  }
  /**
   * handles assign Uo validation for a GovHydro2
   *
   * @param command AssignUoToGovHydro2Command
   */
  public void validate(AssignUoToGovHydro2Command command) throws Exception {
    Assert.notNull(command, "AssignUoToGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "AssignUoToGovHydro2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUoToGovHydro2Command assignment should not be null");
  }

  /**
   * handles unassign Uo validation for a GovHydro2
   *
   * @param command UnAssignUoFromGovHydro2Command
   */
  public void validate(UnAssignUoFromGovHydro2Command command) throws Exception {
    Assert.notNull(command, "UnAssignUoFromGovHydro2Command should not be null");
    Assert.notNull(
        command.getGovHydro2Id(), "UnAssignUoFromGovHydro2Command identifier should not be null");
  }
}
