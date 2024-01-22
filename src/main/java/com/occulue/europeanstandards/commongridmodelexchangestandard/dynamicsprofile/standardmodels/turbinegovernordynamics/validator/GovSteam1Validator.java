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

public class GovSteam1Validator {

  /** default constructor */
  protected GovSteam1Validator() {}

  /** factory method */
  public static GovSteam1Validator getInstance() {
    return new GovSteam1Validator();
  }

  /** handles creation validation for a GovSteam1 */
  public void validate(CreateGovSteam1Command govSteam1) throws Exception {
    Assert.notNull(govSteam1, "CreateGovSteam1Command should not be null");
    //		Assert.isNull( govSteam1.getGovSteam1Id(), "CreateGovSteam1Command identifier should be
    // null" );
  }

  /** handles update validation for a GovSteam1 */
  public void validate(UpdateGovSteam1Command govSteam1) throws Exception {
    Assert.notNull(govSteam1, "UpdateGovSteam1Command should not be null");
    Assert.notNull(
        govSteam1.getGovSteam1Id(), "UpdateGovSteam1Command identifier should not be null");
  }

  /** handles delete validation for a GovSteam1 */
  public void validate(DeleteGovSteam1Command govSteam1) throws Exception {
    Assert.notNull(govSteam1, "{commandAlias} should not be null");
    Assert.notNull(
        govSteam1.getGovSteam1Id(), "DeleteGovSteam1Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovSteam1 */
  public void validate(GovSteam1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovSteam1FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovSteam1Id(), "GovSteam1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Db1 validation for a GovSteam1
   *
   * @param command AssignDb1ToGovSteam1Command
   */
  public void validate(AssignDb1ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignDb1ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignDb1ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb1ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Db1 validation for a GovSteam1
   *
   * @param command UnAssignDb1FromGovSteam1Command
   */
  public void validate(UnAssignDb1FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignDb1FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignDb1FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Db2 validation for a GovSteam1
   *
   * @param command AssignDb2ToGovSteam1Command
   */
  public void validate(AssignDb2ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignDb2ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignDb2ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb2ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Db2 validation for a GovSteam1
   *
   * @param command UnAssignDb2FromGovSteam1Command
   */
  public void validate(UnAssignDb2FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignDb2FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignDb2FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Eps validation for a GovSteam1
   *
   * @param command AssignEpsToGovSteam1Command
   */
  public void validate(AssignEpsToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignEpsToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignEpsToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEpsToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Eps validation for a GovSteam1
   *
   * @param command UnAssignEpsFromGovSteam1Command
   */
  public void validate(UnAssignEpsFromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignEpsFromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignEpsFromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Gv1 validation for a GovSteam1
   *
   * @param command AssignGv1ToGovSteam1Command
   */
  public void validate(AssignGv1ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignGv1ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignGv1ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv1ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Gv1 validation for a GovSteam1
   *
   * @param command UnAssignGv1FromGovSteam1Command
   */
  public void validate(UnAssignGv1FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv1FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignGv1FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Gv2 validation for a GovSteam1
   *
   * @param command AssignGv2ToGovSteam1Command
   */
  public void validate(AssignGv2ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignGv2ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignGv2ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv2ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Gv2 validation for a GovSteam1
   *
   * @param command UnAssignGv2FromGovSteam1Command
   */
  public void validate(UnAssignGv2FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv2FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignGv2FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Gv3 validation for a GovSteam1
   *
   * @param command AssignGv3ToGovSteam1Command
   */
  public void validate(AssignGv3ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignGv3ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignGv3ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv3ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Gv3 validation for a GovSteam1
   *
   * @param command UnAssignGv3FromGovSteam1Command
   */
  public void validate(UnAssignGv3FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv3FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignGv3FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Gv4 validation for a GovSteam1
   *
   * @param command AssignGv4ToGovSteam1Command
   */
  public void validate(AssignGv4ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignGv4ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignGv4ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv4ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Gv4 validation for a GovSteam1
   *
   * @param command UnAssignGv4FromGovSteam1Command
   */
  public void validate(UnAssignGv4FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv4FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignGv4FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Gv5 validation for a GovSteam1
   *
   * @param command AssignGv5ToGovSteam1Command
   */
  public void validate(AssignGv5ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignGv5ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignGv5ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv5ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Gv5 validation for a GovSteam1
   *
   * @param command UnAssignGv5FromGovSteam1Command
   */
  public void validate(UnAssignGv5FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv5FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignGv5FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Gv6 validation for a GovSteam1
   *
   * @param command AssignGv6ToGovSteam1Command
   */
  public void validate(AssignGv6ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignGv6ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignGv6ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv6ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Gv6 validation for a GovSteam1
   *
   * @param command UnAssignGv6FromGovSteam1Command
   */
  public void validate(UnAssignGv6FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv6FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignGv6FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign K validation for a GovSteam1
   *
   * @param command AssignKToGovSteam1Command
   */
  public void validate(AssignKToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignKToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignKToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign K validation for a GovSteam1
   *
   * @param command UnAssignKFromGovSteam1Command
   */
  public void validate(UnAssignKFromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKFromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignKFromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign K1 validation for a GovSteam1
   *
   * @param command AssignK1ToGovSteam1Command
   */
  public void validate(AssignK1ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignK1ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignK1ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK1ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign K1 validation for a GovSteam1
   *
   * @param command UnAssignK1FromGovSteam1Command
   */
  public void validate(UnAssignK1FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK1FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignK1FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign K2 validation for a GovSteam1
   *
   * @param command AssignK2ToGovSteam1Command
   */
  public void validate(AssignK2ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignK2ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignK2ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK2ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign K2 validation for a GovSteam1
   *
   * @param command UnAssignK2FromGovSteam1Command
   */
  public void validate(UnAssignK2FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK2FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignK2FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign K3 validation for a GovSteam1
   *
   * @param command AssignK3ToGovSteam1Command
   */
  public void validate(AssignK3ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignK3ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignK3ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK3ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign K3 validation for a GovSteam1
   *
   * @param command UnAssignK3FromGovSteam1Command
   */
  public void validate(UnAssignK3FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK3FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignK3FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign K4 validation for a GovSteam1
   *
   * @param command AssignK4ToGovSteam1Command
   */
  public void validate(AssignK4ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignK4ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignK4ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK4ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign K4 validation for a GovSteam1
   *
   * @param command UnAssignK4FromGovSteam1Command
   */
  public void validate(UnAssignK4FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK4FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignK4FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign K5 validation for a GovSteam1
   *
   * @param command AssignK5ToGovSteam1Command
   */
  public void validate(AssignK5ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignK5ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignK5ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK5ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign K5 validation for a GovSteam1
   *
   * @param command UnAssignK5FromGovSteam1Command
   */
  public void validate(UnAssignK5FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK5FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignK5FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign K6 validation for a GovSteam1
   *
   * @param command AssignK6ToGovSteam1Command
   */
  public void validate(AssignK6ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignK6ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignK6ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK6ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign K6 validation for a GovSteam1
   *
   * @param command UnAssignK6FromGovSteam1Command
   */
  public void validate(UnAssignK6FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK6FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignK6FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign K7 validation for a GovSteam1
   *
   * @param command AssignK7ToGovSteam1Command
   */
  public void validate(AssignK7ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignK7ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignK7ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK7ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign K7 validation for a GovSteam1
   *
   * @param command UnAssignK7FromGovSteam1Command
   */
  public void validate(UnAssignK7FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK7FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignK7FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign K8 validation for a GovSteam1
   *
   * @param command AssignK8ToGovSteam1Command
   */
  public void validate(AssignK8ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignK8ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignK8ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK8ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign K8 validation for a GovSteam1
   *
   * @param command UnAssignK8FromGovSteam1Command
   */
  public void validate(UnAssignK8FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignK8FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignK8FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovSteam1
   *
   * @param command AssignMwbaseToGovSteam1Command
   */
  public void validate(AssignMwbaseToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignMwbaseToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovSteam1
   *
   * @param command UnAssignMwbaseFromGovSteam1Command
   */
  public void validate(UnAssignMwbaseFromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(),
        "UnAssignMwbaseFromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Pgv1 validation for a GovSteam1
   *
   * @param command AssignPgv1ToGovSteam1Command
   */
  public void validate(AssignPgv1ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignPgv1ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignPgv1ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv1ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Pgv1 validation for a GovSteam1
   *
   * @param command UnAssignPgv1FromGovSteam1Command
   */
  public void validate(UnAssignPgv1FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv1FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignPgv1FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Pgv2 validation for a GovSteam1
   *
   * @param command AssignPgv2ToGovSteam1Command
   */
  public void validate(AssignPgv2ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignPgv2ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignPgv2ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv2ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Pgv2 validation for a GovSteam1
   *
   * @param command UnAssignPgv2FromGovSteam1Command
   */
  public void validate(UnAssignPgv2FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv2FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignPgv2FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Pgv3 validation for a GovSteam1
   *
   * @param command AssignPgv3ToGovSteam1Command
   */
  public void validate(AssignPgv3ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignPgv3ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignPgv3ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv3ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Pgv3 validation for a GovSteam1
   *
   * @param command UnAssignPgv3FromGovSteam1Command
   */
  public void validate(UnAssignPgv3FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv3FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignPgv3FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Pgv4 validation for a GovSteam1
   *
   * @param command AssignPgv4ToGovSteam1Command
   */
  public void validate(AssignPgv4ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignPgv4ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignPgv4ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv4ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Pgv4 validation for a GovSteam1
   *
   * @param command UnAssignPgv4FromGovSteam1Command
   */
  public void validate(UnAssignPgv4FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv4FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignPgv4FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Pgv5 validation for a GovSteam1
   *
   * @param command AssignPgv5ToGovSteam1Command
   */
  public void validate(AssignPgv5ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignPgv5ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignPgv5ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv5ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Pgv5 validation for a GovSteam1
   *
   * @param command UnAssignPgv5FromGovSteam1Command
   */
  public void validate(UnAssignPgv5FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv5FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignPgv5FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Pgv6 validation for a GovSteam1
   *
   * @param command AssignPgv6ToGovSteam1Command
   */
  public void validate(AssignPgv6ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignPgv6ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignPgv6ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv6ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Pgv6 validation for a GovSteam1
   *
   * @param command UnAssignPgv6FromGovSteam1Command
   */
  public void validate(UnAssignPgv6FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv6FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignPgv6FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Pmax validation for a GovSteam1
   *
   * @param command AssignPmaxToGovSteam1Command
   */
  public void validate(AssignPmaxToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignPmaxToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignPmaxToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Pmax validation for a GovSteam1
   *
   * @param command UnAssignPmaxFromGovSteam1Command
   */
  public void validate(UnAssignPmaxFromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxFromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignPmaxFromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Pmin validation for a GovSteam1
   *
   * @param command AssignPminToGovSteam1Command
   */
  public void validate(AssignPminToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignPminToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignPminToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPminToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Pmin validation for a GovSteam1
   *
   * @param command UnAssignPminFromGovSteam1Command
   */
  public void validate(UnAssignPminFromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPminFromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignPminFromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Sdb1 validation for a GovSteam1
   *
   * @param command AssignSdb1ToGovSteam1Command
   */
  public void validate(AssignSdb1ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignSdb1ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignSdb1ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSdb1ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Sdb1 validation for a GovSteam1
   *
   * @param command UnAssignSdb1FromGovSteam1Command
   */
  public void validate(UnAssignSdb1FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignSdb1FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignSdb1FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Sdb2 validation for a GovSteam1
   *
   * @param command AssignSdb2ToGovSteam1Command
   */
  public void validate(AssignSdb2ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignSdb2ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignSdb2ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSdb2ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Sdb2 validation for a GovSteam1
   *
   * @param command UnAssignSdb2FromGovSteam1Command
   */
  public void validate(UnAssignSdb2FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignSdb2FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignSdb2FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign T1 validation for a GovSteam1
   *
   * @param command AssignT1ToGovSteam1Command
   */
  public void validate(AssignT1ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignT1ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignT1ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a GovSteam1
   *
   * @param command UnAssignT1FromGovSteam1Command
   */
  public void validate(UnAssignT1FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignT1FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign T2 validation for a GovSteam1
   *
   * @param command AssignT2ToGovSteam1Command
   */
  public void validate(AssignT2ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignT2ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignT2ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a GovSteam1
   *
   * @param command UnAssignT2FromGovSteam1Command
   */
  public void validate(UnAssignT2FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignT2FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign T3 validation for a GovSteam1
   *
   * @param command AssignT3ToGovSteam1Command
   */
  public void validate(AssignT3ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignT3ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignT3ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a GovSteam1
   *
   * @param command UnAssignT3FromGovSteam1Command
   */
  public void validate(UnAssignT3FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignT3FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign T4 validation for a GovSteam1
   *
   * @param command AssignT4ToGovSteam1Command
   */
  public void validate(AssignT4ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignT4ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignT4ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a GovSteam1
   *
   * @param command UnAssignT4FromGovSteam1Command
   */
  public void validate(UnAssignT4FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignT4FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign T5 validation for a GovSteam1
   *
   * @param command AssignT5ToGovSteam1Command
   */
  public void validate(AssignT5ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignT5ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignT5ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a GovSteam1
   *
   * @param command UnAssignT5FromGovSteam1Command
   */
  public void validate(UnAssignT5FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignT5FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign T6 validation for a GovSteam1
   *
   * @param command AssignT6ToGovSteam1Command
   */
  public void validate(AssignT6ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignT6ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignT6ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT6ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a GovSteam1
   *
   * @param command UnAssignT6FromGovSteam1Command
   */
  public void validate(UnAssignT6FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignT6FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign T7 validation for a GovSteam1
   *
   * @param command AssignT7ToGovSteam1Command
   */
  public void validate(AssignT7ToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignT7ToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignT7ToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT7ToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign T7 validation for a GovSteam1
   *
   * @param command UnAssignT7FromGovSteam1Command
   */
  public void validate(UnAssignT7FromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT7FromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignT7FromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Uc validation for a GovSteam1
   *
   * @param command AssignUcToGovSteam1Command
   */
  public void validate(AssignUcToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignUcToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignUcToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUcToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Uc validation for a GovSteam1
   *
   * @param command UnAssignUcFromGovSteam1Command
   */
  public void validate(UnAssignUcFromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignUcFromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignUcFromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Uo validation for a GovSteam1
   *
   * @param command AssignUoToGovSteam1Command
   */
  public void validate(AssignUoToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignUoToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignUoToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUoToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Uo validation for a GovSteam1
   *
   * @param command UnAssignUoFromGovSteam1Command
   */
  public void validate(UnAssignUoFromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignUoFromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "UnAssignUoFromGovSteam1Command identifier should not be null");
  }
  /**
   * handles assign Valve validation for a GovSteam1
   *
   * @param command AssignValveToGovSteam1Command
   */
  public void validate(AssignValveToGovSteam1Command command) throws Exception {
    Assert.notNull(command, "AssignValveToGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(), "AssignValveToGovSteam1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValveToGovSteam1Command assignment should not be null");
  }

  /**
   * handles unassign Valve validation for a GovSteam1
   *
   * @param command UnAssignValveFromGovSteam1Command
   */
  public void validate(UnAssignValveFromGovSteam1Command command) throws Exception {
    Assert.notNull(command, "UnAssignValveFromGovSteam1Command should not be null");
    Assert.notNull(
        command.getGovSteam1Id(),
        "UnAssignValveFromGovSteam1Command identifier should not be null");
  }
}
