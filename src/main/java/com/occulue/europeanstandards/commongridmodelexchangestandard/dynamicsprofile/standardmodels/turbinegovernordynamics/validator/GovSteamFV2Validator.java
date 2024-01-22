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

public class GovSteamFV2Validator {

  /** default constructor */
  protected GovSteamFV2Validator() {}

  /** factory method */
  public static GovSteamFV2Validator getInstance() {
    return new GovSteamFV2Validator();
  }

  /** handles creation validation for a GovSteamFV2 */
  public void validate(CreateGovSteamFV2Command govSteamFV2) throws Exception {
    Assert.notNull(govSteamFV2, "CreateGovSteamFV2Command should not be null");
    //		Assert.isNull( govSteamFV2.getGovSteamFV2Id(), "CreateGovSteamFV2Command identifier should
    // be null" );
  }

  /** handles update validation for a GovSteamFV2 */
  public void validate(UpdateGovSteamFV2Command govSteamFV2) throws Exception {
    Assert.notNull(govSteamFV2, "UpdateGovSteamFV2Command should not be null");
    Assert.notNull(
        govSteamFV2.getGovSteamFV2Id(), "UpdateGovSteamFV2Command identifier should not be null");
  }

  /** handles delete validation for a GovSteamFV2 */
  public void validate(DeleteGovSteamFV2Command govSteamFV2) throws Exception {
    Assert.notNull(govSteamFV2, "{commandAlias} should not be null");
    Assert.notNull(
        govSteamFV2.getGovSteamFV2Id(), "DeleteGovSteamFV2Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovSteamFV2 */
  public void validate(GovSteamFV2FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovSteamFV2FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovSteamFV2Id(), "GovSteamFV2FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Dt validation for a GovSteamFV2
   *
   * @param command AssignDtToGovSteamFV2Command
   */
  public void validate(AssignDtToGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "AssignDtToGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(), "AssignDtToGovSteamFV2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDtToGovSteamFV2Command assignment should not be null");
  }

  /**
   * handles unassign Dt validation for a GovSteamFV2
   *
   * @param command UnAssignDtFromGovSteamFV2Command
   */
  public void validate(UnAssignDtFromGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "UnAssignDtFromGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(),
        "UnAssignDtFromGovSteamFV2Command identifier should not be null");
  }
  /**
   * handles assign K validation for a GovSteamFV2
   *
   * @param command AssignKToGovSteamFV2Command
   */
  public void validate(AssignKToGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "AssignKToGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(), "AssignKToGovSteamFV2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKToGovSteamFV2Command assignment should not be null");
  }

  /**
   * handles unassign K validation for a GovSteamFV2
   *
   * @param command UnAssignKFromGovSteamFV2Command
   */
  public void validate(UnAssignKFromGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKFromGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(),
        "UnAssignKFromGovSteamFV2Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovSteamFV2
   *
   * @param command AssignMwbaseToGovSteamFV2Command
   */
  public void validate(AssignMwbaseToGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(),
        "AssignMwbaseToGovSteamFV2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovSteamFV2Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovSteamFV2
   *
   * @param command UnAssignMwbaseFromGovSteamFV2Command
   */
  public void validate(UnAssignMwbaseFromGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(),
        "UnAssignMwbaseFromGovSteamFV2Command identifier should not be null");
  }
  /**
   * handles assign R validation for a GovSteamFV2
   *
   * @param command AssignRToGovSteamFV2Command
   */
  public void validate(AssignRToGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "AssignRToGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(), "AssignRToGovSteamFV2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRToGovSteamFV2Command assignment should not be null");
  }

  /**
   * handles unassign R validation for a GovSteamFV2
   *
   * @param command UnAssignRFromGovSteamFV2Command
   */
  public void validate(UnAssignRFromGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "UnAssignRFromGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(),
        "UnAssignRFromGovSteamFV2Command identifier should not be null");
  }
  /**
   * handles assign T1 validation for a GovSteamFV2
   *
   * @param command AssignT1ToGovSteamFV2Command
   */
  public void validate(AssignT1ToGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "AssignT1ToGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(), "AssignT1ToGovSteamFV2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToGovSteamFV2Command assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a GovSteamFV2
   *
   * @param command UnAssignT1FromGovSteamFV2Command
   */
  public void validate(UnAssignT1FromGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(),
        "UnAssignT1FromGovSteamFV2Command identifier should not be null");
  }
  /**
   * handles assign T3 validation for a GovSteamFV2
   *
   * @param command AssignT3ToGovSteamFV2Command
   */
  public void validate(AssignT3ToGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "AssignT3ToGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(), "AssignT3ToGovSteamFV2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToGovSteamFV2Command assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a GovSteamFV2
   *
   * @param command UnAssignT3FromGovSteamFV2Command
   */
  public void validate(UnAssignT3FromGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(),
        "UnAssignT3FromGovSteamFV2Command identifier should not be null");
  }
  /**
   * handles assign Ta validation for a GovSteamFV2
   *
   * @param command AssignTaToGovSteamFV2Command
   */
  public void validate(AssignTaToGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "AssignTaToGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(), "AssignTaToGovSteamFV2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToGovSteamFV2Command assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a GovSteamFV2
   *
   * @param command UnAssignTaFromGovSteamFV2Command
   */
  public void validate(UnAssignTaFromGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(),
        "UnAssignTaFromGovSteamFV2Command identifier should not be null");
  }
  /**
   * handles assign Tb validation for a GovSteamFV2
   *
   * @param command AssignTbToGovSteamFV2Command
   */
  public void validate(AssignTbToGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "AssignTbToGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(), "AssignTbToGovSteamFV2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToGovSteamFV2Command assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a GovSteamFV2
   *
   * @param command UnAssignTbFromGovSteamFV2Command
   */
  public void validate(UnAssignTbFromGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(),
        "UnAssignTbFromGovSteamFV2Command identifier should not be null");
  }
  /**
   * handles assign Tc validation for a GovSteamFV2
   *
   * @param command AssignTcToGovSteamFV2Command
   */
  public void validate(AssignTcToGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "AssignTcToGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(), "AssignTcToGovSteamFV2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToGovSteamFV2Command assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a GovSteamFV2
   *
   * @param command UnAssignTcFromGovSteamFV2Command
   */
  public void validate(UnAssignTcFromGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(),
        "UnAssignTcFromGovSteamFV2Command identifier should not be null");
  }
  /**
   * handles assign Ti validation for a GovSteamFV2
   *
   * @param command AssignTiToGovSteamFV2Command
   */
  public void validate(AssignTiToGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "AssignTiToGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(), "AssignTiToGovSteamFV2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTiToGovSteamFV2Command assignment should not be null");
  }

  /**
   * handles unassign Ti validation for a GovSteamFV2
   *
   * @param command UnAssignTiFromGovSteamFV2Command
   */
  public void validate(UnAssignTiFromGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTiFromGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(),
        "UnAssignTiFromGovSteamFV2Command identifier should not be null");
  }
  /**
   * handles assign Tt validation for a GovSteamFV2
   *
   * @param command AssignTtToGovSteamFV2Command
   */
  public void validate(AssignTtToGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "AssignTtToGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(), "AssignTtToGovSteamFV2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTtToGovSteamFV2Command assignment should not be null");
  }

  /**
   * handles unassign Tt validation for a GovSteamFV2
   *
   * @param command UnAssignTtFromGovSteamFV2Command
   */
  public void validate(UnAssignTtFromGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTtFromGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(),
        "UnAssignTtFromGovSteamFV2Command identifier should not be null");
  }
  /**
   * handles assign Vmax validation for a GovSteamFV2
   *
   * @param command AssignVmaxToGovSteamFV2Command
   */
  public void validate(AssignVmaxToGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "AssignVmaxToGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(), "AssignVmaxToGovSteamFV2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVmaxToGovSteamFV2Command assignment should not be null");
  }

  /**
   * handles unassign Vmax validation for a GovSteamFV2
   *
   * @param command UnAssignVmaxFromGovSteamFV2Command
   */
  public void validate(UnAssignVmaxFromGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVmaxFromGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(),
        "UnAssignVmaxFromGovSteamFV2Command identifier should not be null");
  }
  /**
   * handles assign Vmin validation for a GovSteamFV2
   *
   * @param command AssignVminToGovSteamFV2Command
   */
  public void validate(AssignVminToGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "AssignVminToGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(), "AssignVminToGovSteamFV2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVminToGovSteamFV2Command assignment should not be null");
  }

  /**
   * handles unassign Vmin validation for a GovSteamFV2
   *
   * @param command UnAssignVminFromGovSteamFV2Command
   */
  public void validate(UnAssignVminFromGovSteamFV2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVminFromGovSteamFV2Command should not be null");
    Assert.notNull(
        command.getGovSteamFV2Id(),
        "UnAssignVminFromGovSteamFV2Command identifier should not be null");
  }
}
