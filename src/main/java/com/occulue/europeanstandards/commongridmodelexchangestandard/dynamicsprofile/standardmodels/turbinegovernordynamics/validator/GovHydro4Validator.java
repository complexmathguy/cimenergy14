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

public class GovHydro4Validator {

  /** default constructor */
  protected GovHydro4Validator() {}

  /** factory method */
  public static GovHydro4Validator getInstance() {
    return new GovHydro4Validator();
  }

  /** handles creation validation for a GovHydro4 */
  public void validate(CreateGovHydro4Command govHydro4) throws Exception {
    Assert.notNull(govHydro4, "CreateGovHydro4Command should not be null");
    //		Assert.isNull( govHydro4.getGovHydro4Id(), "CreateGovHydro4Command identifier should be
    // null" );
  }

  /** handles update validation for a GovHydro4 */
  public void validate(UpdateGovHydro4Command govHydro4) throws Exception {
    Assert.notNull(govHydro4, "UpdateGovHydro4Command should not be null");
    Assert.notNull(
        govHydro4.getGovHydro4Id(), "UpdateGovHydro4Command identifier should not be null");
  }

  /** handles delete validation for a GovHydro4 */
  public void validate(DeleteGovHydro4Command govHydro4) throws Exception {
    Assert.notNull(govHydro4, "{commandAlias} should not be null");
    Assert.notNull(
        govHydro4.getGovHydro4Id(), "DeleteGovHydro4Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovHydro4 */
  public void validate(GovHydro4FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovHydro4FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovHydro4Id(), "GovHydro4FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign At validation for a GovHydro4
   *
   * @param command AssignAtToGovHydro4Command
   */
  public void validate(AssignAtToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignAtToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignAtToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAtToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign At validation for a GovHydro4
   *
   * @param command UnAssignAtFromGovHydro4Command
   */
  public void validate(UnAssignAtFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignAtFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignAtFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Bgv0 validation for a GovHydro4
   *
   * @param command AssignBgv0ToGovHydro4Command
   */
  public void validate(AssignBgv0ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignBgv0ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignBgv0ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBgv0ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Bgv0 validation for a GovHydro4
   *
   * @param command UnAssignBgv0FromGovHydro4Command
   */
  public void validate(UnAssignBgv0FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignBgv0FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignBgv0FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Bgv1 validation for a GovHydro4
   *
   * @param command AssignBgv1ToGovHydro4Command
   */
  public void validate(AssignBgv1ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignBgv1ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignBgv1ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBgv1ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Bgv1 validation for a GovHydro4
   *
   * @param command UnAssignBgv1FromGovHydro4Command
   */
  public void validate(UnAssignBgv1FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignBgv1FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignBgv1FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Bgv2 validation for a GovHydro4
   *
   * @param command AssignBgv2ToGovHydro4Command
   */
  public void validate(AssignBgv2ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignBgv2ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignBgv2ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBgv2ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Bgv2 validation for a GovHydro4
   *
   * @param command UnAssignBgv2FromGovHydro4Command
   */
  public void validate(UnAssignBgv2FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignBgv2FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignBgv2FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Bgv3 validation for a GovHydro4
   *
   * @param command AssignBgv3ToGovHydro4Command
   */
  public void validate(AssignBgv3ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignBgv3ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignBgv3ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBgv3ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Bgv3 validation for a GovHydro4
   *
   * @param command UnAssignBgv3FromGovHydro4Command
   */
  public void validate(UnAssignBgv3FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignBgv3FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignBgv3FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Bgv4 validation for a GovHydro4
   *
   * @param command AssignBgv4ToGovHydro4Command
   */
  public void validate(AssignBgv4ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignBgv4ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignBgv4ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBgv4ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Bgv4 validation for a GovHydro4
   *
   * @param command UnAssignBgv4FromGovHydro4Command
   */
  public void validate(UnAssignBgv4FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignBgv4FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignBgv4FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Bgv5 validation for a GovHydro4
   *
   * @param command AssignBgv5ToGovHydro4Command
   */
  public void validate(AssignBgv5ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignBgv5ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignBgv5ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBgv5ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Bgv5 validation for a GovHydro4
   *
   * @param command UnAssignBgv5FromGovHydro4Command
   */
  public void validate(UnAssignBgv5FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignBgv5FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignBgv5FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Bmax validation for a GovHydro4
   *
   * @param command AssignBmaxToGovHydro4Command
   */
  public void validate(AssignBmaxToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignBmaxToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignBmaxToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBmaxToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Bmax validation for a GovHydro4
   *
   * @param command UnAssignBmaxFromGovHydro4Command
   */
  public void validate(UnAssignBmaxFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignBmaxFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignBmaxFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Db1 validation for a GovHydro4
   *
   * @param command AssignDb1ToGovHydro4Command
   */
  public void validate(AssignDb1ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignDb1ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignDb1ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb1ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Db1 validation for a GovHydro4
   *
   * @param command UnAssignDb1FromGovHydro4Command
   */
  public void validate(UnAssignDb1FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignDb1FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignDb1FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Db2 validation for a GovHydro4
   *
   * @param command AssignDb2ToGovHydro4Command
   */
  public void validate(AssignDb2ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignDb2ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignDb2ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb2ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Db2 validation for a GovHydro4
   *
   * @param command UnAssignDb2FromGovHydro4Command
   */
  public void validate(UnAssignDb2FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignDb2FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignDb2FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Dturb validation for a GovHydro4
   *
   * @param command AssignDturbToGovHydro4Command
   */
  public void validate(AssignDturbToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignDturbToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignDturbToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDturbToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Dturb validation for a GovHydro4
   *
   * @param command UnAssignDturbFromGovHydro4Command
   */
  public void validate(UnAssignDturbFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignDturbFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(),
        "UnAssignDturbFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Eps validation for a GovHydro4
   *
   * @param command AssignEpsToGovHydro4Command
   */
  public void validate(AssignEpsToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignEpsToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignEpsToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEpsToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Eps validation for a GovHydro4
   *
   * @param command UnAssignEpsFromGovHydro4Command
   */
  public void validate(UnAssignEpsFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignEpsFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignEpsFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Gmax validation for a GovHydro4
   *
   * @param command AssignGmaxToGovHydro4Command
   */
  public void validate(AssignGmaxToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignGmaxToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignGmaxToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGmaxToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Gmax validation for a GovHydro4
   *
   * @param command UnAssignGmaxFromGovHydro4Command
   */
  public void validate(UnAssignGmaxFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignGmaxFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignGmaxFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Gmin validation for a GovHydro4
   *
   * @param command AssignGminToGovHydro4Command
   */
  public void validate(AssignGminToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignGminToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignGminToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGminToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Gmin validation for a GovHydro4
   *
   * @param command UnAssignGminFromGovHydro4Command
   */
  public void validate(UnAssignGminFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignGminFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignGminFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Gv0 validation for a GovHydro4
   *
   * @param command AssignGv0ToGovHydro4Command
   */
  public void validate(AssignGv0ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignGv0ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignGv0ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv0ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Gv0 validation for a GovHydro4
   *
   * @param command UnAssignGv0FromGovHydro4Command
   */
  public void validate(UnAssignGv0FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv0FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignGv0FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Gv1 validation for a GovHydro4
   *
   * @param command AssignGv1ToGovHydro4Command
   */
  public void validate(AssignGv1ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignGv1ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignGv1ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv1ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Gv1 validation for a GovHydro4
   *
   * @param command UnAssignGv1FromGovHydro4Command
   */
  public void validate(UnAssignGv1FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv1FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignGv1FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Gv2 validation for a GovHydro4
   *
   * @param command AssignGv2ToGovHydro4Command
   */
  public void validate(AssignGv2ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignGv2ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignGv2ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv2ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Gv2 validation for a GovHydro4
   *
   * @param command UnAssignGv2FromGovHydro4Command
   */
  public void validate(UnAssignGv2FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv2FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignGv2FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Gv3 validation for a GovHydro4
   *
   * @param command AssignGv3ToGovHydro4Command
   */
  public void validate(AssignGv3ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignGv3ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignGv3ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv3ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Gv3 validation for a GovHydro4
   *
   * @param command UnAssignGv3FromGovHydro4Command
   */
  public void validate(UnAssignGv3FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv3FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignGv3FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Gv4 validation for a GovHydro4
   *
   * @param command AssignGv4ToGovHydro4Command
   */
  public void validate(AssignGv4ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignGv4ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignGv4ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv4ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Gv4 validation for a GovHydro4
   *
   * @param command UnAssignGv4FromGovHydro4Command
   */
  public void validate(UnAssignGv4FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv4FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignGv4FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Gv5 validation for a GovHydro4
   *
   * @param command AssignGv5ToGovHydro4Command
   */
  public void validate(AssignGv5ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignGv5ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignGv5ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv5ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Gv5 validation for a GovHydro4
   *
   * @param command UnAssignGv5FromGovHydro4Command
   */
  public void validate(UnAssignGv5FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignGv5FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignGv5FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Hdam validation for a GovHydro4
   *
   * @param command AssignHdamToGovHydro4Command
   */
  public void validate(AssignHdamToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignHdamToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignHdamToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignHdamToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Hdam validation for a GovHydro4
   *
   * @param command UnAssignHdamFromGovHydro4Command
   */
  public void validate(UnAssignHdamFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignHdamFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignHdamFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovHydro4
   *
   * @param command AssignMwbaseToGovHydro4Command
   */
  public void validate(AssignMwbaseToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignMwbaseToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovHydro4
   *
   * @param command UnAssignMwbaseFromGovHydro4Command
   */
  public void validate(UnAssignMwbaseFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(),
        "UnAssignMwbaseFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Pgv0 validation for a GovHydro4
   *
   * @param command AssignPgv0ToGovHydro4Command
   */
  public void validate(AssignPgv0ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignPgv0ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignPgv0ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv0ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Pgv0 validation for a GovHydro4
   *
   * @param command UnAssignPgv0FromGovHydro4Command
   */
  public void validate(UnAssignPgv0FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv0FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignPgv0FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Pgv1 validation for a GovHydro4
   *
   * @param command AssignPgv1ToGovHydro4Command
   */
  public void validate(AssignPgv1ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignPgv1ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignPgv1ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv1ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Pgv1 validation for a GovHydro4
   *
   * @param command UnAssignPgv1FromGovHydro4Command
   */
  public void validate(UnAssignPgv1FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv1FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignPgv1FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Pgv2 validation for a GovHydro4
   *
   * @param command AssignPgv2ToGovHydro4Command
   */
  public void validate(AssignPgv2ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignPgv2ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignPgv2ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv2ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Pgv2 validation for a GovHydro4
   *
   * @param command UnAssignPgv2FromGovHydro4Command
   */
  public void validate(UnAssignPgv2FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv2FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignPgv2FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Pgv3 validation for a GovHydro4
   *
   * @param command AssignPgv3ToGovHydro4Command
   */
  public void validate(AssignPgv3ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignPgv3ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignPgv3ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv3ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Pgv3 validation for a GovHydro4
   *
   * @param command UnAssignPgv3FromGovHydro4Command
   */
  public void validate(UnAssignPgv3FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv3FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignPgv3FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Pgv4 validation for a GovHydro4
   *
   * @param command AssignPgv4ToGovHydro4Command
   */
  public void validate(AssignPgv4ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignPgv4ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignPgv4ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv4ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Pgv4 validation for a GovHydro4
   *
   * @param command UnAssignPgv4FromGovHydro4Command
   */
  public void validate(UnAssignPgv4FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv4FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignPgv4FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Pgv5 validation for a GovHydro4
   *
   * @param command AssignPgv5ToGovHydro4Command
   */
  public void validate(AssignPgv5ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignPgv5ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignPgv5ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv5ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Pgv5 validation for a GovHydro4
   *
   * @param command UnAssignPgv5FromGovHydro4Command
   */
  public void validate(UnAssignPgv5FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignPgv5FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignPgv5FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Qn1 validation for a GovHydro4
   *
   * @param command AssignQn1ToGovHydro4Command
   */
  public void validate(AssignQn1ToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignQn1ToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignQn1ToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQn1ToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Qn1 validation for a GovHydro4
   *
   * @param command UnAssignQn1FromGovHydro4Command
   */
  public void validate(UnAssignQn1FromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignQn1FromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignQn1FromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Rperm validation for a GovHydro4
   *
   * @param command AssignRpermToGovHydro4Command
   */
  public void validate(AssignRpermToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignRpermToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignRpermToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRpermToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Rperm validation for a GovHydro4
   *
   * @param command UnAssignRpermFromGovHydro4Command
   */
  public void validate(UnAssignRpermFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignRpermFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(),
        "UnAssignRpermFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Rtemp validation for a GovHydro4
   *
   * @param command AssignRtempToGovHydro4Command
   */
  public void validate(AssignRtempToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignRtempToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignRtempToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRtempToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Rtemp validation for a GovHydro4
   *
   * @param command UnAssignRtempFromGovHydro4Command
   */
  public void validate(UnAssignRtempFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignRtempFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(),
        "UnAssignRtempFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Tblade validation for a GovHydro4
   *
   * @param command AssignTbladeToGovHydro4Command
   */
  public void validate(AssignTbladeToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignTbladeToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignTbladeToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbladeToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Tblade validation for a GovHydro4
   *
   * @param command UnAssignTbladeFromGovHydro4Command
   */
  public void validate(UnAssignTbladeFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTbladeFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(),
        "UnAssignTbladeFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Tg validation for a GovHydro4
   *
   * @param command AssignTgToGovHydro4Command
   */
  public void validate(AssignTgToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignTgToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignTgToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTgToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Tg validation for a GovHydro4
   *
   * @param command UnAssignTgFromGovHydro4Command
   */
  public void validate(UnAssignTgFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTgFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignTgFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Tp validation for a GovHydro4
   *
   * @param command AssignTpToGovHydro4Command
   */
  public void validate(AssignTpToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignTpToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignTpToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Tp validation for a GovHydro4
   *
   * @param command UnAssignTpFromGovHydro4Command
   */
  public void validate(UnAssignTpFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTpFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignTpFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Tr validation for a GovHydro4
   *
   * @param command AssignTrToGovHydro4Command
   */
  public void validate(AssignTrToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignTrToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignTrToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTrToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Tr validation for a GovHydro4
   *
   * @param command UnAssignTrFromGovHydro4Command
   */
  public void validate(UnAssignTrFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTrFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignTrFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Tw validation for a GovHydro4
   *
   * @param command AssignTwToGovHydro4Command
   */
  public void validate(AssignTwToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignTwToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignTwToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTwToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Tw validation for a GovHydro4
   *
   * @param command UnAssignTwFromGovHydro4Command
   */
  public void validate(UnAssignTwFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTwFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignTwFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Uc validation for a GovHydro4
   *
   * @param command AssignUcToGovHydro4Command
   */
  public void validate(AssignUcToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignUcToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignUcToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUcToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Uc validation for a GovHydro4
   *
   * @param command UnAssignUcFromGovHydro4Command
   */
  public void validate(UnAssignUcFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignUcFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignUcFromGovHydro4Command identifier should not be null");
  }
  /**
   * handles assign Uo validation for a GovHydro4
   *
   * @param command AssignUoToGovHydro4Command
   */
  public void validate(AssignUoToGovHydro4Command command) throws Exception {
    Assert.notNull(command, "AssignUoToGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "AssignUoToGovHydro4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUoToGovHydro4Command assignment should not be null");
  }

  /**
   * handles unassign Uo validation for a GovHydro4
   *
   * @param command UnAssignUoFromGovHydro4Command
   */
  public void validate(UnAssignUoFromGovHydro4Command command) throws Exception {
    Assert.notNull(command, "UnAssignUoFromGovHydro4Command should not be null");
    Assert.notNull(
        command.getGovHydro4Id(), "UnAssignUoFromGovHydro4Command identifier should not be null");
  }
}
