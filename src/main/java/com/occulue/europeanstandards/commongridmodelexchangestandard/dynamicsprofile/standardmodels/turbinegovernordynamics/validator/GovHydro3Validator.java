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

public class GovHydro3Validator {

  /** default constructor */
  protected GovHydro3Validator() {}

  /** factory method */
  public static GovHydro3Validator getInstance() {
    return new GovHydro3Validator();
  }

  /** handles creation validation for a GovHydro3 */
  public void validate(CreateGovHydro3Command govHydro3) throws Exception {
    Assert.notNull(govHydro3, "CreateGovHydro3Command should not be null");
    //		Assert.isNull( govHydro3.getGovHydro3Id(), "CreateGovHydro3Command identifier should be
    // null" );
  }

  /** handles update validation for a GovHydro3 */
  public void validate(UpdateGovHydro3Command govHydro3) throws Exception {
    Assert.notNull(govHydro3, "UpdateGovHydro3Command should not be null");
    Assert.notNull(
        govHydro3.getGovHydro3Id(), "UpdateGovHydro3Command identifier should not be null");
  }

  /** handles delete validation for a GovHydro3 */
  public void validate(DeleteGovHydro3Command govHydro3) throws Exception {
    Assert.notNull(govHydro3, "{commandAlias} should not be null");
    Assert.notNull(
        govHydro3.getGovHydro3Id(), "DeleteGovHydro3Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovHydro3 */
  public void validate(GovHydro3FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovHydro3FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovHydro3Id(), "GovHydro3FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign At validation for a GovHydro3
   *
   * @param command AssignAtToGovHydro3Command
   */
  public void validate(AssignAtToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignAtToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignAtToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAtToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign At validation for a GovHydro3
   *
   * @param command UnAssignAtFromGovHydro3Command
   */
  public void validate(UnAssignAtFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignAtFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignAtFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Db1 validation for a GovHydro3
   *
   * @param command AssignDb1ToGovHydro3Command
   */
  public void validate(AssignDb1ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignDb1ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignDb1ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb1ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Db1 validation for a GovHydro3
   *
   * @param command UnAssignDb1FromGovHydro3Command
   */
  public void validate(UnAssignDb1FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignDb1FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignDb1FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Db2 validation for a GovHydro3
   *
   * @param command AssignDb2ToGovHydro3Command
   */
  public void validate(AssignDb2ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignDb2ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignDb2ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb2ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Db2 validation for a GovHydro3
   *
   * @param command UnAssignDb2FromGovHydro3Command
   */
  public void validate(UnAssignDb2FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignDb2FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignDb2FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Dturb validation for a GovHydro3
   *
   * @param command AssignDturbToGovHydro3Command
   */
  public void validate(AssignDturbToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignDturbToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignDturbToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDturbToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Dturb validation for a GovHydro3
   *
   * @param command UnAssignDturbFromGovHydro3Command
   */
  public void validate(UnAssignDturbFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignDturbFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(),
        "UnAssignDturbFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Eps validation for a GovHydro3
   *
   * @param command AssignEpsToGovHydro3Command
   */
  public void validate(AssignEpsToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignEpsToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignEpsToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEpsToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Eps validation for a GovHydro3
   *
   * @param command UnAssignEpsFromGovHydro3Command
   */
  public void validate(UnAssignEpsFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignEpsFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignEpsFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign GovernorControl validation for a GovHydro3
   *
   * @param command AssignGovernorControlToGovHydro3Command
   */
  public void validate(AssignGovernorControlToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignGovernorControlToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(),
        "AssignGovernorControlToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignGovernorControlToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign GovernorControl validation for a GovHydro3
   *
   * @param command UnAssignGovernorControlFromGovHydro3Command
   */
  public void validate(UnAssignGovernorControlFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignGovernorControlFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(),
        "UnAssignGovernorControlFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Gv1 validation for a GovHydro3
   *
   * @param command AssignGv1ToGovHydro3Command
   */
  public void validate(AssignGv1ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignGv1ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignGv1ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv1ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Gv1 validation for a GovHydro3
   *
   * @param command UnAssignGv1FromGovHydro3Command
   */
  public void validate(UnAssignGv1FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv1FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignGv1FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Gv2 validation for a GovHydro3
   *
   * @param command AssignGv2ToGovHydro3Command
   */
  public void validate(AssignGv2ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignGv2ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignGv2ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv2ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Gv2 validation for a GovHydro3
   *
   * @param command UnAssignGv2FromGovHydro3Command
   */
  public void validate(UnAssignGv2FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv2FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignGv2FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Gv3 validation for a GovHydro3
   *
   * @param command AssignGv3ToGovHydro3Command
   */
  public void validate(AssignGv3ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignGv3ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignGv3ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv3ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Gv3 validation for a GovHydro3
   *
   * @param command UnAssignGv3FromGovHydro3Command
   */
  public void validate(UnAssignGv3FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv3FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignGv3FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Gv4 validation for a GovHydro3
   *
   * @param command AssignGv4ToGovHydro3Command
   */
  public void validate(AssignGv4ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignGv4ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignGv4ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv4ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Gv4 validation for a GovHydro3
   *
   * @param command UnAssignGv4FromGovHydro3Command
   */
  public void validate(UnAssignGv4FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv4FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignGv4FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Gv5 validation for a GovHydro3
   *
   * @param command AssignGv5ToGovHydro3Command
   */
  public void validate(AssignGv5ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignGv5ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignGv5ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv5ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Gv5 validation for a GovHydro3
   *
   * @param command UnAssignGv5FromGovHydro3Command
   */
  public void validate(UnAssignGv5FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv5FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignGv5FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Gv6 validation for a GovHydro3
   *
   * @param command AssignGv6ToGovHydro3Command
   */
  public void validate(AssignGv6ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignGv6ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignGv6ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv6ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Gv6 validation for a GovHydro3
   *
   * @param command UnAssignGv6FromGovHydro3Command
   */
  public void validate(UnAssignGv6FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv6FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignGv6FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign H0 validation for a GovHydro3
   *
   * @param command AssignH0ToGovHydro3Command
   */
  public void validate(AssignH0ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignH0ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignH0ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignH0ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign H0 validation for a GovHydro3
   *
   * @param command UnAssignH0FromGovHydro3Command
   */
  public void validate(UnAssignH0FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignH0FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignH0FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign K1 validation for a GovHydro3
   *
   * @param command AssignK1ToGovHydro3Command
   */
  public void validate(AssignK1ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignK1ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignK1ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK1ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign K1 validation for a GovHydro3
   *
   * @param command UnAssignK1FromGovHydro3Command
   */
  public void validate(UnAssignK1FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignK1FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignK1FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign K2 validation for a GovHydro3
   *
   * @param command AssignK2ToGovHydro3Command
   */
  public void validate(AssignK2ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignK2ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignK2ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK2ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign K2 validation for a GovHydro3
   *
   * @param command UnAssignK2FromGovHydro3Command
   */
  public void validate(UnAssignK2FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignK2FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignK2FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Kg validation for a GovHydro3
   *
   * @param command AssignKgToGovHydro3Command
   */
  public void validate(AssignKgToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignKgToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignKgToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKgToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Kg validation for a GovHydro3
   *
   * @param command UnAssignKgFromGovHydro3Command
   */
  public void validate(UnAssignKgFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignKgFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignKgFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Ki validation for a GovHydro3
   *
   * @param command AssignKiToGovHydro3Command
   */
  public void validate(AssignKiToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignKiToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignKiToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a GovHydro3
   *
   * @param command UnAssignKiFromGovHydro3Command
   */
  public void validate(UnAssignKiFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignKiFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovHydro3
   *
   * @param command AssignMwbaseToGovHydro3Command
   */
  public void validate(AssignMwbaseToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignMwbaseToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovHydro3
   *
   * @param command UnAssignMwbaseFromGovHydro3Command
   */
  public void validate(UnAssignMwbaseFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(),
        "UnAssignMwbaseFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Pgv1 validation for a GovHydro3
   *
   * @param command AssignPgv1ToGovHydro3Command
   */
  public void validate(AssignPgv1ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignPgv1ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignPgv1ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv1ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Pgv1 validation for a GovHydro3
   *
   * @param command UnAssignPgv1FromGovHydro3Command
   */
  public void validate(UnAssignPgv1FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv1FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignPgv1FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Pgv2 validation for a GovHydro3
   *
   * @param command AssignPgv2ToGovHydro3Command
   */
  public void validate(AssignPgv2ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignPgv2ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignPgv2ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv2ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Pgv2 validation for a GovHydro3
   *
   * @param command UnAssignPgv2FromGovHydro3Command
   */
  public void validate(UnAssignPgv2FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv2FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignPgv2FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Pgv3 validation for a GovHydro3
   *
   * @param command AssignPgv3ToGovHydro3Command
   */
  public void validate(AssignPgv3ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignPgv3ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignPgv3ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv3ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Pgv3 validation for a GovHydro3
   *
   * @param command UnAssignPgv3FromGovHydro3Command
   */
  public void validate(UnAssignPgv3FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv3FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignPgv3FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Pgv4 validation for a GovHydro3
   *
   * @param command AssignPgv4ToGovHydro3Command
   */
  public void validate(AssignPgv4ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignPgv4ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignPgv4ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv4ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Pgv4 validation for a GovHydro3
   *
   * @param command UnAssignPgv4FromGovHydro3Command
   */
  public void validate(UnAssignPgv4FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv4FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignPgv4FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Pgv5 validation for a GovHydro3
   *
   * @param command AssignPgv5ToGovHydro3Command
   */
  public void validate(AssignPgv5ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignPgv5ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignPgv5ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv5ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Pgv5 validation for a GovHydro3
   *
   * @param command UnAssignPgv5FromGovHydro3Command
   */
  public void validate(UnAssignPgv5FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv5FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignPgv5FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Pgv6 validation for a GovHydro3
   *
   * @param command AssignPgv6ToGovHydro3Command
   */
  public void validate(AssignPgv6ToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignPgv6ToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignPgv6ToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv6ToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Pgv6 validation for a GovHydro3
   *
   * @param command UnAssignPgv6FromGovHydro3Command
   */
  public void validate(UnAssignPgv6FromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv6FromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignPgv6FromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Pmax validation for a GovHydro3
   *
   * @param command AssignPmaxToGovHydro3Command
   */
  public void validate(AssignPmaxToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignPmaxToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignPmaxToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Pmax validation for a GovHydro3
   *
   * @param command UnAssignPmaxFromGovHydro3Command
   */
  public void validate(UnAssignPmaxFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignPmaxFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Pmin validation for a GovHydro3
   *
   * @param command AssignPminToGovHydro3Command
   */
  public void validate(AssignPminToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignPminToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignPminToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPminToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Pmin validation for a GovHydro3
   *
   * @param command UnAssignPminFromGovHydro3Command
   */
  public void validate(UnAssignPminFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignPminFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignPminFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Qnl validation for a GovHydro3
   *
   * @param command AssignQnlToGovHydro3Command
   */
  public void validate(AssignQnlToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignQnlToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignQnlToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQnlToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Qnl validation for a GovHydro3
   *
   * @param command UnAssignQnlFromGovHydro3Command
   */
  public void validate(UnAssignQnlFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignQnlFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignQnlFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Relec validation for a GovHydro3
   *
   * @param command AssignRelecToGovHydro3Command
   */
  public void validate(AssignRelecToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignRelecToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignRelecToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRelecToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Relec validation for a GovHydro3
   *
   * @param command UnAssignRelecFromGovHydro3Command
   */
  public void validate(UnAssignRelecFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignRelecFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(),
        "UnAssignRelecFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Rgate validation for a GovHydro3
   *
   * @param command AssignRgateToGovHydro3Command
   */
  public void validate(AssignRgateToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignRgateToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignRgateToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRgateToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Rgate validation for a GovHydro3
   *
   * @param command UnAssignRgateFromGovHydro3Command
   */
  public void validate(UnAssignRgateFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignRgateFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(),
        "UnAssignRgateFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Td validation for a GovHydro3
   *
   * @param command AssignTdToGovHydro3Command
   */
  public void validate(AssignTdToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignTdToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignTdToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Td validation for a GovHydro3
   *
   * @param command UnAssignTdFromGovHydro3Command
   */
  public void validate(UnAssignTdFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTdFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignTdFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Tf validation for a GovHydro3
   *
   * @param command AssignTfToGovHydro3Command
   */
  public void validate(AssignTfToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignTfToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignTfToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a GovHydro3
   *
   * @param command UnAssignTfFromGovHydro3Command
   */
  public void validate(UnAssignTfFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignTfFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Tp validation for a GovHydro3
   *
   * @param command AssignTpToGovHydro3Command
   */
  public void validate(AssignTpToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignTpToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignTpToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Tp validation for a GovHydro3
   *
   * @param command UnAssignTpFromGovHydro3Command
   */
  public void validate(UnAssignTpFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTpFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignTpFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Tt validation for a GovHydro3
   *
   * @param command AssignTtToGovHydro3Command
   */
  public void validate(AssignTtToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignTtToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignTtToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTtToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Tt validation for a GovHydro3
   *
   * @param command UnAssignTtFromGovHydro3Command
   */
  public void validate(UnAssignTtFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTtFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignTtFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Tw validation for a GovHydro3
   *
   * @param command AssignTwToGovHydro3Command
   */
  public void validate(AssignTwToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignTwToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignTwToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTwToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Tw validation for a GovHydro3
   *
   * @param command UnAssignTwFromGovHydro3Command
   */
  public void validate(UnAssignTwFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTwFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "UnAssignTwFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Velcl validation for a GovHydro3
   *
   * @param command AssignVelclToGovHydro3Command
   */
  public void validate(AssignVelclToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignVelclToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignVelclToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVelclToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Velcl validation for a GovHydro3
   *
   * @param command UnAssignVelclFromGovHydro3Command
   */
  public void validate(UnAssignVelclFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignVelclFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(),
        "UnAssignVelclFromGovHydro3Command identifier should not be null");
  }
  /**
   * handles assign Velop validation for a GovHydro3
   *
   * @param command AssignVelopToGovHydro3Command
   */
  public void validate(AssignVelopToGovHydro3Command command) throws Exception {
    Assert.notNull(command, "AssignVelopToGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(), "AssignVelopToGovHydro3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVelopToGovHydro3Command assignment should not be null");
  }

  /**
   * handles unassign Velop validation for a GovHydro3
   *
   * @param command UnAssignVelopFromGovHydro3Command
   */
  public void validate(UnAssignVelopFromGovHydro3Command command) throws Exception {
    Assert.notNull(command, "UnAssignVelopFromGovHydro3Command should not be null");
    Assert.notNull(
        command.getGovHydro3Id(),
        "UnAssignVelopFromGovHydro3Command identifier should not be null");
  }
}
