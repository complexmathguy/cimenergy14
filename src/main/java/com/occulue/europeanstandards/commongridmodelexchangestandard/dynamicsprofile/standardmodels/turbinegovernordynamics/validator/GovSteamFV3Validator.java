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

public class GovSteamFV3Validator {

  /** default constructor */
  protected GovSteamFV3Validator() {}

  /** factory method */
  public static GovSteamFV3Validator getInstance() {
    return new GovSteamFV3Validator();
  }

  /** handles creation validation for a GovSteamFV3 */
  public void validate(CreateGovSteamFV3Command govSteamFV3) throws Exception {
    Assert.notNull(govSteamFV3, "CreateGovSteamFV3Command should not be null");
    //		Assert.isNull( govSteamFV3.getGovSteamFV3Id(), "CreateGovSteamFV3Command identifier should
    // be null" );
  }

  /** handles update validation for a GovSteamFV3 */
  public void validate(UpdateGovSteamFV3Command govSteamFV3) throws Exception {
    Assert.notNull(govSteamFV3, "UpdateGovSteamFV3Command should not be null");
    Assert.notNull(
        govSteamFV3.getGovSteamFV3Id(), "UpdateGovSteamFV3Command identifier should not be null");
  }

  /** handles delete validation for a GovSteamFV3 */
  public void validate(DeleteGovSteamFV3Command govSteamFV3) throws Exception {
    Assert.notNull(govSteamFV3, "{commandAlias} should not be null");
    Assert.notNull(
        govSteamFV3.getGovSteamFV3Id(), "DeleteGovSteamFV3Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovSteamFV3 */
  public void validate(GovSteamFV3FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovSteamFV3FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovSteamFV3Id(), "GovSteamFV3FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign K validation for a GovSteamFV3
   *
   * @param command AssignKToGovSteamFV3Command
   */
  public void validate(AssignKToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignKToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignKToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign K validation for a GovSteamFV3
   *
   * @param command UnAssignKFromGovSteamFV3Command
   */
  public void validate(UnAssignKFromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignKFromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignKFromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign K1 validation for a GovSteamFV3
   *
   * @param command AssignK1ToGovSteamFV3Command
   */
  public void validate(AssignK1ToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignK1ToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignK1ToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK1ToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign K1 validation for a GovSteamFV3
   *
   * @param command UnAssignK1FromGovSteamFV3Command
   */
  public void validate(UnAssignK1FromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignK1FromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignK1FromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign K2 validation for a GovSteamFV3
   *
   * @param command AssignK2ToGovSteamFV3Command
   */
  public void validate(AssignK2ToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignK2ToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignK2ToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK2ToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign K2 validation for a GovSteamFV3
   *
   * @param command UnAssignK2FromGovSteamFV3Command
   */
  public void validate(UnAssignK2FromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignK2FromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignK2FromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign K3 validation for a GovSteamFV3
   *
   * @param command AssignK3ToGovSteamFV3Command
   */
  public void validate(AssignK3ToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignK3ToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignK3ToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK3ToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign K3 validation for a GovSteamFV3
   *
   * @param command UnAssignK3FromGovSteamFV3Command
   */
  public void validate(UnAssignK3FromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignK3FromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignK3FromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovSteamFV3
   *
   * @param command AssignMwbaseToGovSteamFV3Command
   */
  public void validate(AssignMwbaseToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "AssignMwbaseToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovSteamFV3
   *
   * @param command UnAssignMwbaseFromGovSteamFV3Command
   */
  public void validate(UnAssignMwbaseFromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignMwbaseFromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign Pmax validation for a GovSteamFV3
   *
   * @param command AssignPmaxToGovSteamFV3Command
   */
  public void validate(AssignPmaxToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignPmaxToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignPmaxToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign Pmax validation for a GovSteamFV3
   *
   * @param command UnAssignPmaxFromGovSteamFV3Command
   */
  public void validate(UnAssignPmaxFromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxFromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignPmaxFromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign Pmin validation for a GovSteamFV3
   *
   * @param command AssignPminToGovSteamFV3Command
   */
  public void validate(AssignPminToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignPminToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignPminToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPminToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign Pmin validation for a GovSteamFV3
   *
   * @param command UnAssignPminFromGovSteamFV3Command
   */
  public void validate(UnAssignPminFromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignPminFromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignPminFromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign Prmax validation for a GovSteamFV3
   *
   * @param command AssignPrmaxToGovSteamFV3Command
   */
  public void validate(AssignPrmaxToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignPrmaxToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "AssignPrmaxToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPrmaxToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign Prmax validation for a GovSteamFV3
   *
   * @param command UnAssignPrmaxFromGovSteamFV3Command
   */
  public void validate(UnAssignPrmaxFromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignPrmaxFromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignPrmaxFromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign T1 validation for a GovSteamFV3
   *
   * @param command AssignT1ToGovSteamFV3Command
   */
  public void validate(AssignT1ToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignT1ToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignT1ToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a GovSteamFV3
   *
   * @param command UnAssignT1FromGovSteamFV3Command
   */
  public void validate(UnAssignT1FromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignT1FromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign T2 validation for a GovSteamFV3
   *
   * @param command AssignT2ToGovSteamFV3Command
   */
  public void validate(AssignT2ToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignT2ToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignT2ToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a GovSteamFV3
   *
   * @param command UnAssignT2FromGovSteamFV3Command
   */
  public void validate(UnAssignT2FromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignT2FromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign T3 validation for a GovSteamFV3
   *
   * @param command AssignT3ToGovSteamFV3Command
   */
  public void validate(AssignT3ToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignT3ToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignT3ToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a GovSteamFV3
   *
   * @param command UnAssignT3FromGovSteamFV3Command
   */
  public void validate(UnAssignT3FromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignT3FromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign T4 validation for a GovSteamFV3
   *
   * @param command AssignT4ToGovSteamFV3Command
   */
  public void validate(AssignT4ToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignT4ToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignT4ToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a GovSteamFV3
   *
   * @param command UnAssignT4FromGovSteamFV3Command
   */
  public void validate(UnAssignT4FromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignT4FromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign T5 validation for a GovSteamFV3
   *
   * @param command AssignT5ToGovSteamFV3Command
   */
  public void validate(AssignT5ToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignT5ToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignT5ToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5ToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a GovSteamFV3
   *
   * @param command UnAssignT5FromGovSteamFV3Command
   */
  public void validate(UnAssignT5FromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignT5FromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign T6 validation for a GovSteamFV3
   *
   * @param command AssignT6ToGovSteamFV3Command
   */
  public void validate(AssignT6ToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignT6ToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignT6ToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT6ToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a GovSteamFV3
   *
   * @param command UnAssignT6FromGovSteamFV3Command
   */
  public void validate(UnAssignT6FromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignT6FromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign Ta validation for a GovSteamFV3
   *
   * @param command AssignTaToGovSteamFV3Command
   */
  public void validate(AssignTaToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignTaToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignTaToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a GovSteamFV3
   *
   * @param command UnAssignTaFromGovSteamFV3Command
   */
  public void validate(UnAssignTaFromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignTaFromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign Tb validation for a GovSteamFV3
   *
   * @param command AssignTbToGovSteamFV3Command
   */
  public void validate(AssignTbToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignTbToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignTbToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a GovSteamFV3
   *
   * @param command UnAssignTbFromGovSteamFV3Command
   */
  public void validate(UnAssignTbFromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignTbFromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign Tc validation for a GovSteamFV3
   *
   * @param command AssignTcToGovSteamFV3Command
   */
  public void validate(AssignTcToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignTcToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignTcToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a GovSteamFV3
   *
   * @param command UnAssignTcFromGovSteamFV3Command
   */
  public void validate(UnAssignTcFromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignTcFromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign Uc validation for a GovSteamFV3
   *
   * @param command AssignUcToGovSteamFV3Command
   */
  public void validate(AssignUcToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignUcToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignUcToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUcToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign Uc validation for a GovSteamFV3
   *
   * @param command UnAssignUcFromGovSteamFV3Command
   */
  public void validate(UnAssignUcFromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignUcFromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignUcFromGovSteamFV3Command identifier should not be null");
  }
  /**
   * handles assign Uo validation for a GovSteamFV3
   *
   * @param command AssignUoToGovSteamFV3Command
   */
  public void validate(AssignUoToGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "AssignUoToGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(), "AssignUoToGovSteamFV3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignUoToGovSteamFV3Command assignment should not be null");
  }

  /**
   * handles unassign Uo validation for a GovSteamFV3
   *
   * @param command UnAssignUoFromGovSteamFV3Command
   */
  public void validate(UnAssignUoFromGovSteamFV3Command command) throws Exception {
    Assert.notNull(command, "UnAssignUoFromGovSteamFV3Command should not be null");
    Assert.notNull(
        command.getGovSteamFV3Id(),
        "UnAssignUoFromGovSteamFV3Command identifier should not be null");
  }
}
