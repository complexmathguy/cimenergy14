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

public class GovHydroPID2Validator {

  /** default constructor */
  protected GovHydroPID2Validator() {}

  /** factory method */
  public static GovHydroPID2Validator getInstance() {
    return new GovHydroPID2Validator();
  }

  /** handles creation validation for a GovHydroPID2 */
  public void validate(CreateGovHydroPID2Command govHydroPID2) throws Exception {
    Assert.notNull(govHydroPID2, "CreateGovHydroPID2Command should not be null");
    //		Assert.isNull( govHydroPID2.getGovHydroPID2Id(), "CreateGovHydroPID2Command identifier
    // should be null" );
  }

  /** handles update validation for a GovHydroPID2 */
  public void validate(UpdateGovHydroPID2Command govHydroPID2) throws Exception {
    Assert.notNull(govHydroPID2, "UpdateGovHydroPID2Command should not be null");
    Assert.notNull(
        govHydroPID2.getGovHydroPID2Id(),
        "UpdateGovHydroPID2Command identifier should not be null");
  }

  /** handles delete validation for a GovHydroPID2 */
  public void validate(DeleteGovHydroPID2Command govHydroPID2) throws Exception {
    Assert.notNull(govHydroPID2, "{commandAlias} should not be null");
    Assert.notNull(
        govHydroPID2.getGovHydroPID2Id(),
        "DeleteGovHydroPID2Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovHydroPID2 */
  public void validate(GovHydroPID2FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovHydroPID2FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovHydroPID2Id(), "GovHydroPID2FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Atw validation for a GovHydroPID2
   *
   * @param command AssignAtwToGovHydroPID2Command
   */
  public void validate(AssignAtwToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignAtwToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "AssignAtwToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAtwToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign Atw validation for a GovHydroPID2
   *
   * @param command UnAssignAtwFromGovHydroPID2Command
   */
  public void validate(UnAssignAtwFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignAtwFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignAtwFromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign D validation for a GovHydroPID2
   *
   * @param command AssignDToGovHydroPID2Command
   */
  public void validate(AssignDToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignDToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(), "AssignDToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign D validation for a GovHydroPID2
   *
   * @param command UnAssignDFromGovHydroPID2Command
   */
  public void validate(UnAssignDFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignDFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignDFromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign FeedbackSignal validation for a GovHydroPID2
   *
   * @param command AssignFeedbackSignalToGovHydroPID2Command
   */
  public void validate(AssignFeedbackSignalToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignFeedbackSignalToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "AssignFeedbackSignalToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignFeedbackSignalToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign FeedbackSignal validation for a GovHydroPID2
   *
   * @param command UnAssignFeedbackSignalFromGovHydroPID2Command
   */
  public void validate(UnAssignFeedbackSignalFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignFeedbackSignalFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignFeedbackSignalFromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign G0 validation for a GovHydroPID2
   *
   * @param command AssignG0ToGovHydroPID2Command
   */
  public void validate(AssignG0ToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignG0ToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(), "AssignG0ToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignG0ToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign G0 validation for a GovHydroPID2
   *
   * @param command UnAssignG0FromGovHydroPID2Command
   */
  public void validate(UnAssignG0FromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignG0FromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignG0FromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign G1 validation for a GovHydroPID2
   *
   * @param command AssignG1ToGovHydroPID2Command
   */
  public void validate(AssignG1ToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignG1ToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(), "AssignG1ToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignG1ToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign G1 validation for a GovHydroPID2
   *
   * @param command UnAssignG1FromGovHydroPID2Command
   */
  public void validate(UnAssignG1FromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignG1FromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignG1FromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign G2 validation for a GovHydroPID2
   *
   * @param command AssignG2ToGovHydroPID2Command
   */
  public void validate(AssignG2ToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignG2ToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(), "AssignG2ToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignG2ToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign G2 validation for a GovHydroPID2
   *
   * @param command UnAssignG2FromGovHydroPID2Command
   */
  public void validate(UnAssignG2FromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignG2FromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignG2FromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign Gmax validation for a GovHydroPID2
   *
   * @param command AssignGmaxToGovHydroPID2Command
   */
  public void validate(AssignGmaxToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignGmaxToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "AssignGmaxToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGmaxToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign Gmax validation for a GovHydroPID2
   *
   * @param command UnAssignGmaxFromGovHydroPID2Command
   */
  public void validate(UnAssignGmaxFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignGmaxFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignGmaxFromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign Gmin validation for a GovHydroPID2
   *
   * @param command AssignGminToGovHydroPID2Command
   */
  public void validate(AssignGminToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignGminToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "AssignGminToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGminToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign Gmin validation for a GovHydroPID2
   *
   * @param command UnAssignGminFromGovHydroPID2Command
   */
  public void validate(UnAssignGminFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignGminFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignGminFromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign Kd validation for a GovHydroPID2
   *
   * @param command AssignKdToGovHydroPID2Command
   */
  public void validate(AssignKdToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignKdToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(), "AssignKdToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a GovHydroPID2
   *
   * @param command UnAssignKdFromGovHydroPID2Command
   */
  public void validate(UnAssignKdFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignKdFromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign Ki validation for a GovHydroPID2
   *
   * @param command AssignKiToGovHydroPID2Command
   */
  public void validate(AssignKiToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignKiToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(), "AssignKiToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a GovHydroPID2
   *
   * @param command UnAssignKiFromGovHydroPID2Command
   */
  public void validate(UnAssignKiFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignKiFromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign Kp validation for a GovHydroPID2
   *
   * @param command AssignKpToGovHydroPID2Command
   */
  public void validate(AssignKpToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignKpToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(), "AssignKpToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a GovHydroPID2
   *
   * @param command UnAssignKpFromGovHydroPID2Command
   */
  public void validate(UnAssignKpFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignKpFromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovHydroPID2
   *
   * @param command AssignMwbaseToGovHydroPID2Command
   */
  public void validate(AssignMwbaseToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "AssignMwbaseToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovHydroPID2
   *
   * @param command UnAssignMwbaseFromGovHydroPID2Command
   */
  public void validate(UnAssignMwbaseFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignMwbaseFromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign P1 validation for a GovHydroPID2
   *
   * @param command AssignP1ToGovHydroPID2Command
   */
  public void validate(AssignP1ToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignP1ToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(), "AssignP1ToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignP1ToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign P1 validation for a GovHydroPID2
   *
   * @param command UnAssignP1FromGovHydroPID2Command
   */
  public void validate(UnAssignP1FromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignP1FromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignP1FromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign P2 validation for a GovHydroPID2
   *
   * @param command AssignP2ToGovHydroPID2Command
   */
  public void validate(AssignP2ToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignP2ToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(), "AssignP2ToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignP2ToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign P2 validation for a GovHydroPID2
   *
   * @param command UnAssignP2FromGovHydroPID2Command
   */
  public void validate(UnAssignP2FromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignP2FromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignP2FromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign P3 validation for a GovHydroPID2
   *
   * @param command AssignP3ToGovHydroPID2Command
   */
  public void validate(AssignP3ToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignP3ToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(), "AssignP3ToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignP3ToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign P3 validation for a GovHydroPID2
   *
   * @param command UnAssignP3FromGovHydroPID2Command
   */
  public void validate(UnAssignP3FromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignP3FromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignP3FromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign Rperm validation for a GovHydroPID2
   *
   * @param command AssignRpermToGovHydroPID2Command
   */
  public void validate(AssignRpermToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignRpermToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "AssignRpermToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRpermToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign Rperm validation for a GovHydroPID2
   *
   * @param command UnAssignRpermFromGovHydroPID2Command
   */
  public void validate(UnAssignRpermFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignRpermFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignRpermFromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign Ta validation for a GovHydroPID2
   *
   * @param command AssignTaToGovHydroPID2Command
   */
  public void validate(AssignTaToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignTaToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(), "AssignTaToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a GovHydroPID2
   *
   * @param command UnAssignTaFromGovHydroPID2Command
   */
  public void validate(UnAssignTaFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignTaFromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign Tb validation for a GovHydroPID2
   *
   * @param command AssignTbToGovHydroPID2Command
   */
  public void validate(AssignTbToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignTbToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(), "AssignTbToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a GovHydroPID2
   *
   * @param command UnAssignTbFromGovHydroPID2Command
   */
  public void validate(UnAssignTbFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignTbFromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign Treg validation for a GovHydroPID2
   *
   * @param command AssignTregToGovHydroPID2Command
   */
  public void validate(AssignTregToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignTregToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "AssignTregToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTregToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign Treg validation for a GovHydroPID2
   *
   * @param command UnAssignTregFromGovHydroPID2Command
   */
  public void validate(UnAssignTregFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTregFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignTregFromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign Tw validation for a GovHydroPID2
   *
   * @param command AssignTwToGovHydroPID2Command
   */
  public void validate(AssignTwToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignTwToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(), "AssignTwToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTwToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign Tw validation for a GovHydroPID2
   *
   * @param command UnAssignTwFromGovHydroPID2Command
   */
  public void validate(UnAssignTwFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTwFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignTwFromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign Velmax validation for a GovHydroPID2
   *
   * @param command AssignVelmaxToGovHydroPID2Command
   */
  public void validate(AssignVelmaxToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignVelmaxToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "AssignVelmaxToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVelmaxToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign Velmax validation for a GovHydroPID2
   *
   * @param command UnAssignVelmaxFromGovHydroPID2Command
   */
  public void validate(UnAssignVelmaxFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVelmaxFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignVelmaxFromGovHydroPID2Command identifier should not be null");
  }
  /**
   * handles assign Velmin validation for a GovHydroPID2
   *
   * @param command AssignVelminToGovHydroPID2Command
   */
  public void validate(AssignVelminToGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "AssignVelminToGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "AssignVelminToGovHydroPID2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVelminToGovHydroPID2Command assignment should not be null");
  }

  /**
   * handles unassign Velmin validation for a GovHydroPID2
   *
   * @param command UnAssignVelminFromGovHydroPID2Command
   */
  public void validate(UnAssignVelminFromGovHydroPID2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVelminFromGovHydroPID2Command should not be null");
    Assert.notNull(
        command.getGovHydroPID2Id(),
        "UnAssignVelminFromGovHydroPID2Command identifier should not be null");
  }
}
