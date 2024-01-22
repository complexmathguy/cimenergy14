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

public class GovHydro1Validator {

  /** default constructor */
  protected GovHydro1Validator() {}

  /** factory method */
  public static GovHydro1Validator getInstance() {
    return new GovHydro1Validator();
  }

  /** handles creation validation for a GovHydro1 */
  public void validate(CreateGovHydro1Command govHydro1) throws Exception {
    Assert.notNull(govHydro1, "CreateGovHydro1Command should not be null");
    //		Assert.isNull( govHydro1.getGovHydro1Id(), "CreateGovHydro1Command identifier should be
    // null" );
  }

  /** handles update validation for a GovHydro1 */
  public void validate(UpdateGovHydro1Command govHydro1) throws Exception {
    Assert.notNull(govHydro1, "UpdateGovHydro1Command should not be null");
    Assert.notNull(
        govHydro1.getGovHydro1Id(), "UpdateGovHydro1Command identifier should not be null");
  }

  /** handles delete validation for a GovHydro1 */
  public void validate(DeleteGovHydro1Command govHydro1) throws Exception {
    Assert.notNull(govHydro1, "{commandAlias} should not be null");
    Assert.notNull(
        govHydro1.getGovHydro1Id(), "DeleteGovHydro1Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovHydro1 */
  public void validate(GovHydro1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovHydro1FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovHydro1Id(), "GovHydro1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign At validation for a GovHydro1
   *
   * @param command AssignAtToGovHydro1Command
   */
  public void validate(AssignAtToGovHydro1Command command) throws Exception {
    Assert.notNull(command, "AssignAtToGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "AssignAtToGovHydro1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAtToGovHydro1Command assignment should not be null");
  }

  /**
   * handles unassign At validation for a GovHydro1
   *
   * @param command UnAssignAtFromGovHydro1Command
   */
  public void validate(UnAssignAtFromGovHydro1Command command) throws Exception {
    Assert.notNull(command, "UnAssignAtFromGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "UnAssignAtFromGovHydro1Command identifier should not be null");
  }
  /**
   * handles assign Dturb validation for a GovHydro1
   *
   * @param command AssignDturbToGovHydro1Command
   */
  public void validate(AssignDturbToGovHydro1Command command) throws Exception {
    Assert.notNull(command, "AssignDturbToGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "AssignDturbToGovHydro1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDturbToGovHydro1Command assignment should not be null");
  }

  /**
   * handles unassign Dturb validation for a GovHydro1
   *
   * @param command UnAssignDturbFromGovHydro1Command
   */
  public void validate(UnAssignDturbFromGovHydro1Command command) throws Exception {
    Assert.notNull(command, "UnAssignDturbFromGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(),
        "UnAssignDturbFromGovHydro1Command identifier should not be null");
  }
  /**
   * handles assign Gmax validation for a GovHydro1
   *
   * @param command AssignGmaxToGovHydro1Command
   */
  public void validate(AssignGmaxToGovHydro1Command command) throws Exception {
    Assert.notNull(command, "AssignGmaxToGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "AssignGmaxToGovHydro1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGmaxToGovHydro1Command assignment should not be null");
  }

  /**
   * handles unassign Gmax validation for a GovHydro1
   *
   * @param command UnAssignGmaxFromGovHydro1Command
   */
  public void validate(UnAssignGmaxFromGovHydro1Command command) throws Exception {
    Assert.notNull(command, "UnAssignGmaxFromGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "UnAssignGmaxFromGovHydro1Command identifier should not be null");
  }
  /**
   * handles assign Gmin validation for a GovHydro1
   *
   * @param command AssignGminToGovHydro1Command
   */
  public void validate(AssignGminToGovHydro1Command command) throws Exception {
    Assert.notNull(command, "AssignGminToGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "AssignGminToGovHydro1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGminToGovHydro1Command assignment should not be null");
  }

  /**
   * handles unassign Gmin validation for a GovHydro1
   *
   * @param command UnAssignGminFromGovHydro1Command
   */
  public void validate(UnAssignGminFromGovHydro1Command command) throws Exception {
    Assert.notNull(command, "UnAssignGminFromGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "UnAssignGminFromGovHydro1Command identifier should not be null");
  }
  /**
   * handles assign Hdam validation for a GovHydro1
   *
   * @param command AssignHdamToGovHydro1Command
   */
  public void validate(AssignHdamToGovHydro1Command command) throws Exception {
    Assert.notNull(command, "AssignHdamToGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "AssignHdamToGovHydro1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignHdamToGovHydro1Command assignment should not be null");
  }

  /**
   * handles unassign Hdam validation for a GovHydro1
   *
   * @param command UnAssignHdamFromGovHydro1Command
   */
  public void validate(UnAssignHdamFromGovHydro1Command command) throws Exception {
    Assert.notNull(command, "UnAssignHdamFromGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "UnAssignHdamFromGovHydro1Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovHydro1
   *
   * @param command AssignMwbaseToGovHydro1Command
   */
  public void validate(AssignMwbaseToGovHydro1Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "AssignMwbaseToGovHydro1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovHydro1Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovHydro1
   *
   * @param command UnAssignMwbaseFromGovHydro1Command
   */
  public void validate(UnAssignMwbaseFromGovHydro1Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(),
        "UnAssignMwbaseFromGovHydro1Command identifier should not be null");
  }
  /**
   * handles assign Qnl validation for a GovHydro1
   *
   * @param command AssignQnlToGovHydro1Command
   */
  public void validate(AssignQnlToGovHydro1Command command) throws Exception {
    Assert.notNull(command, "AssignQnlToGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "AssignQnlToGovHydro1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQnlToGovHydro1Command assignment should not be null");
  }

  /**
   * handles unassign Qnl validation for a GovHydro1
   *
   * @param command UnAssignQnlFromGovHydro1Command
   */
  public void validate(UnAssignQnlFromGovHydro1Command command) throws Exception {
    Assert.notNull(command, "UnAssignQnlFromGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "UnAssignQnlFromGovHydro1Command identifier should not be null");
  }
  /**
   * handles assign Rperm validation for a GovHydro1
   *
   * @param command AssignRpermToGovHydro1Command
   */
  public void validate(AssignRpermToGovHydro1Command command) throws Exception {
    Assert.notNull(command, "AssignRpermToGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "AssignRpermToGovHydro1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRpermToGovHydro1Command assignment should not be null");
  }

  /**
   * handles unassign Rperm validation for a GovHydro1
   *
   * @param command UnAssignRpermFromGovHydro1Command
   */
  public void validate(UnAssignRpermFromGovHydro1Command command) throws Exception {
    Assert.notNull(command, "UnAssignRpermFromGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(),
        "UnAssignRpermFromGovHydro1Command identifier should not be null");
  }
  /**
   * handles assign Rtemp validation for a GovHydro1
   *
   * @param command AssignRtempToGovHydro1Command
   */
  public void validate(AssignRtempToGovHydro1Command command) throws Exception {
    Assert.notNull(command, "AssignRtempToGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "AssignRtempToGovHydro1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRtempToGovHydro1Command assignment should not be null");
  }

  /**
   * handles unassign Rtemp validation for a GovHydro1
   *
   * @param command UnAssignRtempFromGovHydro1Command
   */
  public void validate(UnAssignRtempFromGovHydro1Command command) throws Exception {
    Assert.notNull(command, "UnAssignRtempFromGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(),
        "UnAssignRtempFromGovHydro1Command identifier should not be null");
  }
  /**
   * handles assign Tf validation for a GovHydro1
   *
   * @param command AssignTfToGovHydro1Command
   */
  public void validate(AssignTfToGovHydro1Command command) throws Exception {
    Assert.notNull(command, "AssignTfToGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "AssignTfToGovHydro1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToGovHydro1Command assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a GovHydro1
   *
   * @param command UnAssignTfFromGovHydro1Command
   */
  public void validate(UnAssignTfFromGovHydro1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "UnAssignTfFromGovHydro1Command identifier should not be null");
  }
  /**
   * handles assign Tg validation for a GovHydro1
   *
   * @param command AssignTgToGovHydro1Command
   */
  public void validate(AssignTgToGovHydro1Command command) throws Exception {
    Assert.notNull(command, "AssignTgToGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "AssignTgToGovHydro1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTgToGovHydro1Command assignment should not be null");
  }

  /**
   * handles unassign Tg validation for a GovHydro1
   *
   * @param command UnAssignTgFromGovHydro1Command
   */
  public void validate(UnAssignTgFromGovHydro1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTgFromGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "UnAssignTgFromGovHydro1Command identifier should not be null");
  }
  /**
   * handles assign Tr validation for a GovHydro1
   *
   * @param command AssignTrToGovHydro1Command
   */
  public void validate(AssignTrToGovHydro1Command command) throws Exception {
    Assert.notNull(command, "AssignTrToGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "AssignTrToGovHydro1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTrToGovHydro1Command assignment should not be null");
  }

  /**
   * handles unassign Tr validation for a GovHydro1
   *
   * @param command UnAssignTrFromGovHydro1Command
   */
  public void validate(UnAssignTrFromGovHydro1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTrFromGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "UnAssignTrFromGovHydro1Command identifier should not be null");
  }
  /**
   * handles assign Tw validation for a GovHydro1
   *
   * @param command AssignTwToGovHydro1Command
   */
  public void validate(AssignTwToGovHydro1Command command) throws Exception {
    Assert.notNull(command, "AssignTwToGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "AssignTwToGovHydro1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTwToGovHydro1Command assignment should not be null");
  }

  /**
   * handles unassign Tw validation for a GovHydro1
   *
   * @param command UnAssignTwFromGovHydro1Command
   */
  public void validate(UnAssignTwFromGovHydro1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTwFromGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "UnAssignTwFromGovHydro1Command identifier should not be null");
  }
  /**
   * handles assign Velm validation for a GovHydro1
   *
   * @param command AssignVelmToGovHydro1Command
   */
  public void validate(AssignVelmToGovHydro1Command command) throws Exception {
    Assert.notNull(command, "AssignVelmToGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "AssignVelmToGovHydro1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVelmToGovHydro1Command assignment should not be null");
  }

  /**
   * handles unassign Velm validation for a GovHydro1
   *
   * @param command UnAssignVelmFromGovHydro1Command
   */
  public void validate(UnAssignVelmFromGovHydro1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVelmFromGovHydro1Command should not be null");
    Assert.notNull(
        command.getGovHydro1Id(), "UnAssignVelmFromGovHydro1Command identifier should not be null");
  }
}
