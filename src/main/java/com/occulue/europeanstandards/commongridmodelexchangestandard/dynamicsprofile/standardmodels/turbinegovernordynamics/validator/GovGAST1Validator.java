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

public class GovGAST1Validator {

  /** default constructor */
  protected GovGAST1Validator() {}

  /** factory method */
  public static GovGAST1Validator getInstance() {
    return new GovGAST1Validator();
  }

  /** handles creation validation for a GovGAST1 */
  public void validate(CreateGovGAST1Command govGAST1) throws Exception {
    Assert.notNull(govGAST1, "CreateGovGAST1Command should not be null");
    //		Assert.isNull( govGAST1.getGovGAST1Id(), "CreateGovGAST1Command identifier should be null"
    // );
  }

  /** handles update validation for a GovGAST1 */
  public void validate(UpdateGovGAST1Command govGAST1) throws Exception {
    Assert.notNull(govGAST1, "UpdateGovGAST1Command should not be null");
    Assert.notNull(govGAST1.getGovGAST1Id(), "UpdateGovGAST1Command identifier should not be null");
  }

  /** handles delete validation for a GovGAST1 */
  public void validate(DeleteGovGAST1Command govGAST1) throws Exception {
    Assert.notNull(govGAST1, "{commandAlias} should not be null");
    Assert.notNull(govGAST1.getGovGAST1Id(), "DeleteGovGAST1Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovGAST1 */
  public void validate(GovGAST1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovGAST1FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovGAST1Id(), "GovGAST1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign A validation for a GovGAST1
   *
   * @param command AssignAToGovGAST1Command
   */
  public void validate(AssignAToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignAToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignAToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign A validation for a GovGAST1
   *
   * @param command UnAssignAFromGovGAST1Command
   */
  public void validate(UnAssignAFromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignAFromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignAFromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign B validation for a GovGAST1
   *
   * @param command AssignBToGovGAST1Command
   */
  public void validate(AssignBToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignBToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignBToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign B validation for a GovGAST1
   *
   * @param command UnAssignBFromGovGAST1Command
   */
  public void validate(UnAssignBFromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignBFromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignBFromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Db1 validation for a GovGAST1
   *
   * @param command AssignDb1ToGovGAST1Command
   */
  public void validate(AssignDb1ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignDb1ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignDb1ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb1ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Db1 validation for a GovGAST1
   *
   * @param command UnAssignDb1FromGovGAST1Command
   */
  public void validate(UnAssignDb1FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignDb1FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignDb1FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Db2 validation for a GovGAST1
   *
   * @param command AssignDb2ToGovGAST1Command
   */
  public void validate(AssignDb2ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignDb2ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignDb2ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb2ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Db2 validation for a GovGAST1
   *
   * @param command UnAssignDb2FromGovGAST1Command
   */
  public void validate(UnAssignDb2FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignDb2FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignDb2FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Eps validation for a GovGAST1
   *
   * @param command AssignEpsToGovGAST1Command
   */
  public void validate(AssignEpsToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignEpsToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignEpsToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEpsToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Eps validation for a GovGAST1
   *
   * @param command UnAssignEpsFromGovGAST1Command
   */
  public void validate(UnAssignEpsFromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignEpsFromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignEpsFromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Fidle validation for a GovGAST1
   *
   * @param command AssignFidleToGovGAST1Command
   */
  public void validate(AssignFidleToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignFidleToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignFidleToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFidleToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Fidle validation for a GovGAST1
   *
   * @param command UnAssignFidleFromGovGAST1Command
   */
  public void validate(UnAssignFidleFromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignFidleFromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignFidleFromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Gv1 validation for a GovGAST1
   *
   * @param command AssignGv1ToGovGAST1Command
   */
  public void validate(AssignGv1ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignGv1ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignGv1ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv1ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Gv1 validation for a GovGAST1
   *
   * @param command UnAssignGv1FromGovGAST1Command
   */
  public void validate(UnAssignGv1FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv1FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignGv1FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Gv2 validation for a GovGAST1
   *
   * @param command AssignGv2ToGovGAST1Command
   */
  public void validate(AssignGv2ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignGv2ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignGv2ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv2ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Gv2 validation for a GovGAST1
   *
   * @param command UnAssignGv2FromGovGAST1Command
   */
  public void validate(UnAssignGv2FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv2FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignGv2FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Gv3 validation for a GovGAST1
   *
   * @param command AssignGv3ToGovGAST1Command
   */
  public void validate(AssignGv3ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignGv3ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignGv3ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv3ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Gv3 validation for a GovGAST1
   *
   * @param command UnAssignGv3FromGovGAST1Command
   */
  public void validate(UnAssignGv3FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv3FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignGv3FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Gv4 validation for a GovGAST1
   *
   * @param command AssignGv4ToGovGAST1Command
   */
  public void validate(AssignGv4ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignGv4ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignGv4ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv4ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Gv4 validation for a GovGAST1
   *
   * @param command UnAssignGv4FromGovGAST1Command
   */
  public void validate(UnAssignGv4FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv4FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignGv4FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Gv5 validation for a GovGAST1
   *
   * @param command AssignGv5ToGovGAST1Command
   */
  public void validate(AssignGv5ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignGv5ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignGv5ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv5ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Gv5 validation for a GovGAST1
   *
   * @param command UnAssignGv5FromGovGAST1Command
   */
  public void validate(UnAssignGv5FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv5FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignGv5FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Gv6 validation for a GovGAST1
   *
   * @param command AssignGv6ToGovGAST1Command
   */
  public void validate(AssignGv6ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignGv6ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignGv6ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv6ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Gv6 validation for a GovGAST1
   *
   * @param command UnAssignGv6FromGovGAST1Command
   */
  public void validate(UnAssignGv6FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv6FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignGv6FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Ka validation for a GovGAST1
   *
   * @param command AssignKaToGovGAST1Command
   */
  public void validate(AssignKaToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignKaToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignKaToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a GovGAST1
   *
   * @param command UnAssignKaFromGovGAST1Command
   */
  public void validate(UnAssignKaFromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignKaFromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Kt validation for a GovGAST1
   *
   * @param command AssignKtToGovGAST1Command
   */
  public void validate(AssignKtToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignKtToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignKtToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKtToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Kt validation for a GovGAST1
   *
   * @param command UnAssignKtFromGovGAST1Command
   */
  public void validate(UnAssignKtFromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKtFromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignKtFromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Lmax validation for a GovGAST1
   *
   * @param command AssignLmaxToGovGAST1Command
   */
  public void validate(AssignLmaxToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignLmaxToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignLmaxToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLmaxToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Lmax validation for a GovGAST1
   *
   * @param command UnAssignLmaxFromGovGAST1Command
   */
  public void validate(UnAssignLmaxFromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignLmaxFromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignLmaxFromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Loadinc validation for a GovGAST1
   *
   * @param command AssignLoadincToGovGAST1Command
   */
  public void validate(AssignLoadincToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignLoadincToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignLoadincToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLoadincToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Loadinc validation for a GovGAST1
   *
   * @param command UnAssignLoadincFromGovGAST1Command
   */
  public void validate(UnAssignLoadincFromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignLoadincFromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(),
        "UnAssignLoadincFromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Ltrate validation for a GovGAST1
   *
   * @param command AssignLtrateToGovGAST1Command
   */
  public void validate(AssignLtrateToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignLtrateToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignLtrateToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLtrateToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Ltrate validation for a GovGAST1
   *
   * @param command UnAssignLtrateFromGovGAST1Command
   */
  public void validate(UnAssignLtrateFromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignLtrateFromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignLtrateFromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovGAST1
   *
   * @param command AssignMwbaseToGovGAST1Command
   */
  public void validate(AssignMwbaseToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignMwbaseToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovGAST1
   *
   * @param command UnAssignMwbaseFromGovGAST1Command
   */
  public void validate(UnAssignMwbaseFromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignMwbaseFromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Pgv1 validation for a GovGAST1
   *
   * @param command AssignPgv1ToGovGAST1Command
   */
  public void validate(AssignPgv1ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignPgv1ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignPgv1ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv1ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Pgv1 validation for a GovGAST1
   *
   * @param command UnAssignPgv1FromGovGAST1Command
   */
  public void validate(UnAssignPgv1FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv1FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignPgv1FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Pgv2 validation for a GovGAST1
   *
   * @param command AssignPgv2ToGovGAST1Command
   */
  public void validate(AssignPgv2ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignPgv2ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignPgv2ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv2ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Pgv2 validation for a GovGAST1
   *
   * @param command UnAssignPgv2FromGovGAST1Command
   */
  public void validate(UnAssignPgv2FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv2FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignPgv2FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Pgv3 validation for a GovGAST1
   *
   * @param command AssignPgv3ToGovGAST1Command
   */
  public void validate(AssignPgv3ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignPgv3ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignPgv3ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv3ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Pgv3 validation for a GovGAST1
   *
   * @param command UnAssignPgv3FromGovGAST1Command
   */
  public void validate(UnAssignPgv3FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv3FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignPgv3FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Pgv4 validation for a GovGAST1
   *
   * @param command AssignPgv4ToGovGAST1Command
   */
  public void validate(AssignPgv4ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignPgv4ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignPgv4ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv4ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Pgv4 validation for a GovGAST1
   *
   * @param command UnAssignPgv4FromGovGAST1Command
   */
  public void validate(UnAssignPgv4FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv4FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignPgv4FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Pgv5 validation for a GovGAST1
   *
   * @param command AssignPgv5ToGovGAST1Command
   */
  public void validate(AssignPgv5ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignPgv5ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignPgv5ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv5ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Pgv5 validation for a GovGAST1
   *
   * @param command UnAssignPgv5FromGovGAST1Command
   */
  public void validate(UnAssignPgv5FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv5FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignPgv5FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Pgv6 validation for a GovGAST1
   *
   * @param command AssignPgv6ToGovGAST1Command
   */
  public void validate(AssignPgv6ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignPgv6ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignPgv6ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv6ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Pgv6 validation for a GovGAST1
   *
   * @param command UnAssignPgv6FromGovGAST1Command
   */
  public void validate(UnAssignPgv6FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv6FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignPgv6FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign R validation for a GovGAST1
   *
   * @param command AssignRToGovGAST1Command
   */
  public void validate(AssignRToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignRToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignRToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign R validation for a GovGAST1
   *
   * @param command UnAssignRFromGovGAST1Command
   */
  public void validate(UnAssignRFromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignRFromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignRFromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Rmax validation for a GovGAST1
   *
   * @param command AssignRmaxToGovGAST1Command
   */
  public void validate(AssignRmaxToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignRmaxToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignRmaxToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRmaxToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Rmax validation for a GovGAST1
   *
   * @param command UnAssignRmaxFromGovGAST1Command
   */
  public void validate(UnAssignRmaxFromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignRmaxFromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignRmaxFromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign T1 validation for a GovGAST1
   *
   * @param command AssignT1ToGovGAST1Command
   */
  public void validate(AssignT1ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignT1ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignT1ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a GovGAST1
   *
   * @param command UnAssignT1FromGovGAST1Command
   */
  public void validate(UnAssignT1FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignT1FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign T2 validation for a GovGAST1
   *
   * @param command AssignT2ToGovGAST1Command
   */
  public void validate(AssignT2ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignT2ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignT2ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a GovGAST1
   *
   * @param command UnAssignT2FromGovGAST1Command
   */
  public void validate(UnAssignT2FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignT2FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign T3 validation for a GovGAST1
   *
   * @param command AssignT3ToGovGAST1Command
   */
  public void validate(AssignT3ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignT3ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignT3ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a GovGAST1
   *
   * @param command UnAssignT3FromGovGAST1Command
   */
  public void validate(UnAssignT3FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignT3FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign T4 validation for a GovGAST1
   *
   * @param command AssignT4ToGovGAST1Command
   */
  public void validate(AssignT4ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignT4ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignT4ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a GovGAST1
   *
   * @param command UnAssignT4FromGovGAST1Command
   */
  public void validate(UnAssignT4FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignT4FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign T5 validation for a GovGAST1
   *
   * @param command AssignT5ToGovGAST1Command
   */
  public void validate(AssignT5ToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignT5ToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignT5ToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5ToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a GovGAST1
   *
   * @param command UnAssignT5FromGovGAST1Command
   */
  public void validate(UnAssignT5FromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignT5FromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Tltr validation for a GovGAST1
   *
   * @param command AssignTltrToGovGAST1Command
   */
  public void validate(AssignTltrToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignTltrToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignTltrToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTltrToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Tltr validation for a GovGAST1
   *
   * @param command UnAssignTltrFromGovGAST1Command
   */
  public void validate(UnAssignTltrFromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTltrFromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignTltrFromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Vmax validation for a GovGAST1
   *
   * @param command AssignVmaxToGovGAST1Command
   */
  public void validate(AssignVmaxToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignVmaxToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignVmaxToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmaxToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Vmax validation for a GovGAST1
   *
   * @param command UnAssignVmaxFromGovGAST1Command
   */
  public void validate(UnAssignVmaxFromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVmaxFromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignVmaxFromGovGAST1Command identifier should not be null");
  }
  /**
   * handles assign Vmin validation for a GovGAST1
   *
   * @param command AssignVminToGovGAST1Command
   */
  public void validate(AssignVminToGovGAST1Command command) throws Exception {
    Assert.notNull(command, "AssignVminToGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "AssignVminToGovGAST1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVminToGovGAST1Command assignment should not be null");
  }

  /**
   * handles unassign Vmin validation for a GovGAST1
   *
   * @param command UnAssignVminFromGovGAST1Command
   */
  public void validate(UnAssignVminFromGovGAST1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVminFromGovGAST1Command should not be null");
    Assert.notNull(
        command.getGovGAST1Id(), "UnAssignVminFromGovGAST1Command identifier should not be null");
  }
}
