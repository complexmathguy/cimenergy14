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

public class GovSteamFV4Validator {

  /** default constructor */
  protected GovSteamFV4Validator() {}

  /** factory method */
  public static GovSteamFV4Validator getInstance() {
    return new GovSteamFV4Validator();
  }

  /** handles creation validation for a GovSteamFV4 */
  public void validate(CreateGovSteamFV4Command govSteamFV4) throws Exception {
    Assert.notNull(govSteamFV4, "CreateGovSteamFV4Command should not be null");
    //		Assert.isNull( govSteamFV4.getGovSteamFV4Id(), "CreateGovSteamFV4Command identifier should
    // be null" );
  }

  /** handles update validation for a GovSteamFV4 */
  public void validate(UpdateGovSteamFV4Command govSteamFV4) throws Exception {
    Assert.notNull(govSteamFV4, "UpdateGovSteamFV4Command should not be null");
    Assert.notNull(
        govSteamFV4.getGovSteamFV4Id(), "UpdateGovSteamFV4Command identifier should not be null");
  }

  /** handles delete validation for a GovSteamFV4 */
  public void validate(DeleteGovSteamFV4Command govSteamFV4) throws Exception {
    Assert.notNull(govSteamFV4, "{commandAlias} should not be null");
    Assert.notNull(
        govSteamFV4.getGovSteamFV4Id(), "DeleteGovSteamFV4Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovSteamFV4 */
  public void validate(GovSteamFV4FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovSteamFV4FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovSteamFV4Id(), "GovSteamFV4FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Cpsmn validation for a GovSteamFV4
   *
   * @param command AssignCpsmnToGovSteamFV4Command
   */
  public void validate(AssignCpsmnToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignCpsmnToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "AssignCpsmnToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignCpsmnToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Cpsmn validation for a GovSteamFV4
   *
   * @param command UnAssignCpsmnFromGovSteamFV4Command
   */
  public void validate(UnAssignCpsmnFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignCpsmnFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignCpsmnFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Cpsmx validation for a GovSteamFV4
   *
   * @param command AssignCpsmxToGovSteamFV4Command
   */
  public void validate(AssignCpsmxToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignCpsmxToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "AssignCpsmxToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignCpsmxToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Cpsmx validation for a GovSteamFV4
   *
   * @param command UnAssignCpsmxFromGovSteamFV4Command
   */
  public void validate(UnAssignCpsmxFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignCpsmxFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignCpsmxFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Crmn validation for a GovSteamFV4
   *
   * @param command AssignCrmnToGovSteamFV4Command
   */
  public void validate(AssignCrmnToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignCrmnToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignCrmnToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignCrmnToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Crmn validation for a GovSteamFV4
   *
   * @param command UnAssignCrmnFromGovSteamFV4Command
   */
  public void validate(UnAssignCrmnFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignCrmnFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignCrmnFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Crmx validation for a GovSteamFV4
   *
   * @param command AssignCrmxToGovSteamFV4Command
   */
  public void validate(AssignCrmxToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignCrmxToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignCrmxToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignCrmxToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Crmx validation for a GovSteamFV4
   *
   * @param command UnAssignCrmxFromGovSteamFV4Command
   */
  public void validate(UnAssignCrmxFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignCrmxFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignCrmxFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Kdc validation for a GovSteamFV4
   *
   * @param command AssignKdcToGovSteamFV4Command
   */
  public void validate(AssignKdcToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignKdcToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignKdcToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdcToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Kdc validation for a GovSteamFV4
   *
   * @param command UnAssignKdcFromGovSteamFV4Command
   */
  public void validate(UnAssignKdcFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKdcFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignKdcFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Kf1 validation for a GovSteamFV4
   *
   * @param command AssignKf1ToGovSteamFV4Command
   */
  public void validate(AssignKf1ToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignKf1ToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignKf1ToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKf1ToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Kf1 validation for a GovSteamFV4
   *
   * @param command UnAssignKf1FromGovSteamFV4Command
   */
  public void validate(UnAssignKf1FromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKf1FromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignKf1FromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Kf3 validation for a GovSteamFV4
   *
   * @param command AssignKf3ToGovSteamFV4Command
   */
  public void validate(AssignKf3ToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignKf3ToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignKf3ToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKf3ToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Kf3 validation for a GovSteamFV4
   *
   * @param command UnAssignKf3FromGovSteamFV4Command
   */
  public void validate(UnAssignKf3FromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKf3FromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignKf3FromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Khp validation for a GovSteamFV4
   *
   * @param command AssignKhpToGovSteamFV4Command
   */
  public void validate(AssignKhpToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignKhpToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignKhpToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKhpToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Khp validation for a GovSteamFV4
   *
   * @param command UnAssignKhpFromGovSteamFV4Command
   */
  public void validate(UnAssignKhpFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKhpFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignKhpFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Kic validation for a GovSteamFV4
   *
   * @param command AssignKicToGovSteamFV4Command
   */
  public void validate(AssignKicToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignKicToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignKicToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKicToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Kic validation for a GovSteamFV4
   *
   * @param command UnAssignKicFromGovSteamFV4Command
   */
  public void validate(UnAssignKicFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKicFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignKicFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Kip validation for a GovSteamFV4
   *
   * @param command AssignKipToGovSteamFV4Command
   */
  public void validate(AssignKipToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignKipToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignKipToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKipToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Kip validation for a GovSteamFV4
   *
   * @param command UnAssignKipFromGovSteamFV4Command
   */
  public void validate(UnAssignKipFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKipFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignKipFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Kit validation for a GovSteamFV4
   *
   * @param command AssignKitToGovSteamFV4Command
   */
  public void validate(AssignKitToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignKitToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignKitToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKitToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Kit validation for a GovSteamFV4
   *
   * @param command UnAssignKitFromGovSteamFV4Command
   */
  public void validate(UnAssignKitFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKitFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignKitFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Kmp1 validation for a GovSteamFV4
   *
   * @param command AssignKmp1ToGovSteamFV4Command
   */
  public void validate(AssignKmp1ToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignKmp1ToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignKmp1ToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKmp1ToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Kmp1 validation for a GovSteamFV4
   *
   * @param command UnAssignKmp1FromGovSteamFV4Command
   */
  public void validate(UnAssignKmp1FromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKmp1FromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignKmp1FromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Kmp2 validation for a GovSteamFV4
   *
   * @param command AssignKmp2ToGovSteamFV4Command
   */
  public void validate(AssignKmp2ToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignKmp2ToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignKmp2ToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKmp2ToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Kmp2 validation for a GovSteamFV4
   *
   * @param command UnAssignKmp2FromGovSteamFV4Command
   */
  public void validate(UnAssignKmp2FromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKmp2FromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignKmp2FromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Kpc validation for a GovSteamFV4
   *
   * @param command AssignKpcToGovSteamFV4Command
   */
  public void validate(AssignKpcToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignKpcToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignKpcToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpcToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Kpc validation for a GovSteamFV4
   *
   * @param command UnAssignKpcFromGovSteamFV4Command
   */
  public void validate(UnAssignKpcFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKpcFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignKpcFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Kpp validation for a GovSteamFV4
   *
   * @param command AssignKppToGovSteamFV4Command
   */
  public void validate(AssignKppToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignKppToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignKppToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKppToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Kpp validation for a GovSteamFV4
   *
   * @param command UnAssignKppFromGovSteamFV4Command
   */
  public void validate(UnAssignKppFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKppFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignKppFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Kpt validation for a GovSteamFV4
   *
   * @param command AssignKptToGovSteamFV4Command
   */
  public void validate(AssignKptToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignKptToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignKptToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKptToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Kpt validation for a GovSteamFV4
   *
   * @param command UnAssignKptFromGovSteamFV4Command
   */
  public void validate(UnAssignKptFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKptFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignKptFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Krc validation for a GovSteamFV4
   *
   * @param command AssignKrcToGovSteamFV4Command
   */
  public void validate(AssignKrcToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignKrcToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignKrcToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKrcToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Krc validation for a GovSteamFV4
   *
   * @param command UnAssignKrcFromGovSteamFV4Command
   */
  public void validate(UnAssignKrcFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKrcFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignKrcFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Ksh validation for a GovSteamFV4
   *
   * @param command AssignKshToGovSteamFV4Command
   */
  public void validate(AssignKshToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignKshToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignKshToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKshToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Ksh validation for a GovSteamFV4
   *
   * @param command UnAssignKshFromGovSteamFV4Command
   */
  public void validate(UnAssignKshFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKshFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignKshFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Lpi validation for a GovSteamFV4
   *
   * @param command AssignLpiToGovSteamFV4Command
   */
  public void validate(AssignLpiToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignLpiToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignLpiToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLpiToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Lpi validation for a GovSteamFV4
   *
   * @param command UnAssignLpiFromGovSteamFV4Command
   */
  public void validate(UnAssignLpiFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignLpiFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignLpiFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Lps validation for a GovSteamFV4
   *
   * @param command AssignLpsToGovSteamFV4Command
   */
  public void validate(AssignLpsToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignLpsToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignLpsToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLpsToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Lps validation for a GovSteamFV4
   *
   * @param command UnAssignLpsFromGovSteamFV4Command
   */
  public void validate(UnAssignLpsFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignLpsFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignLpsFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Mnef validation for a GovSteamFV4
   *
   * @param command AssignMnefToGovSteamFV4Command
   */
  public void validate(AssignMnefToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignMnefToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignMnefToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMnefToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Mnef validation for a GovSteamFV4
   *
   * @param command UnAssignMnefFromGovSteamFV4Command
   */
  public void validate(UnAssignMnefFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignMnefFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignMnefFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Mxef validation for a GovSteamFV4
   *
   * @param command AssignMxefToGovSteamFV4Command
   */
  public void validate(AssignMxefToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignMxefToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignMxefToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMxefToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Mxef validation for a GovSteamFV4
   *
   * @param command UnAssignMxefFromGovSteamFV4Command
   */
  public void validate(UnAssignMxefFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignMxefFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignMxefFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Pr1 validation for a GovSteamFV4
   *
   * @param command AssignPr1ToGovSteamFV4Command
   */
  public void validate(AssignPr1ToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignPr1ToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignPr1ToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPr1ToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Pr1 validation for a GovSteamFV4
   *
   * @param command UnAssignPr1FromGovSteamFV4Command
   */
  public void validate(UnAssignPr1FromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignPr1FromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignPr1FromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Pr2 validation for a GovSteamFV4
   *
   * @param command AssignPr2ToGovSteamFV4Command
   */
  public void validate(AssignPr2ToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignPr2ToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignPr2ToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPr2ToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Pr2 validation for a GovSteamFV4
   *
   * @param command UnAssignPr2FromGovSteamFV4Command
   */
  public void validate(UnAssignPr2FromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignPr2FromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignPr2FromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Psmn validation for a GovSteamFV4
   *
   * @param command AssignPsmnToGovSteamFV4Command
   */
  public void validate(AssignPsmnToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignPsmnToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignPsmnToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPsmnToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Psmn validation for a GovSteamFV4
   *
   * @param command UnAssignPsmnFromGovSteamFV4Command
   */
  public void validate(UnAssignPsmnFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignPsmnFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignPsmnFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Rsmimn validation for a GovSteamFV4
   *
   * @param command AssignRsmimnToGovSteamFV4Command
   */
  public void validate(AssignRsmimnToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignRsmimnToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "AssignRsmimnToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRsmimnToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Rsmimn validation for a GovSteamFV4
   *
   * @param command UnAssignRsmimnFromGovSteamFV4Command
   */
  public void validate(UnAssignRsmimnFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignRsmimnFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignRsmimnFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Rsmimx validation for a GovSteamFV4
   *
   * @param command AssignRsmimxToGovSteamFV4Command
   */
  public void validate(AssignRsmimxToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignRsmimxToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "AssignRsmimxToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRsmimxToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Rsmimx validation for a GovSteamFV4
   *
   * @param command UnAssignRsmimxFromGovSteamFV4Command
   */
  public void validate(UnAssignRsmimxFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignRsmimxFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignRsmimxFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Rvgmn validation for a GovSteamFV4
   *
   * @param command AssignRvgmnToGovSteamFV4Command
   */
  public void validate(AssignRvgmnToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignRvgmnToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "AssignRvgmnToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRvgmnToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Rvgmn validation for a GovSteamFV4
   *
   * @param command UnAssignRvgmnFromGovSteamFV4Command
   */
  public void validate(UnAssignRvgmnFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignRvgmnFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignRvgmnFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Rvgmx validation for a GovSteamFV4
   *
   * @param command AssignRvgmxToGovSteamFV4Command
   */
  public void validate(AssignRvgmxToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignRvgmxToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "AssignRvgmxToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRvgmxToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Rvgmx validation for a GovSteamFV4
   *
   * @param command UnAssignRvgmxFromGovSteamFV4Command
   */
  public void validate(UnAssignRvgmxFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignRvgmxFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignRvgmxFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Srmn validation for a GovSteamFV4
   *
   * @param command AssignSrmnToGovSteamFV4Command
   */
  public void validate(AssignSrmnToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignSrmnToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignSrmnToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSrmnToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Srmn validation for a GovSteamFV4
   *
   * @param command UnAssignSrmnFromGovSteamFV4Command
   */
  public void validate(UnAssignSrmnFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignSrmnFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignSrmnFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Srmx validation for a GovSteamFV4
   *
   * @param command AssignSrmxToGovSteamFV4Command
   */
  public void validate(AssignSrmxToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignSrmxToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignSrmxToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSrmxToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Srmx validation for a GovSteamFV4
   *
   * @param command UnAssignSrmxFromGovSteamFV4Command
   */
  public void validate(UnAssignSrmxFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignSrmxFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignSrmxFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Srsmp validation for a GovSteamFV4
   *
   * @param command AssignSrsmpToGovSteamFV4Command
   */
  public void validate(AssignSrsmpToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignSrsmpToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "AssignSrsmpToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSrsmpToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Srsmp validation for a GovSteamFV4
   *
   * @param command UnAssignSrsmpFromGovSteamFV4Command
   */
  public void validate(UnAssignSrsmpFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignSrsmpFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignSrsmpFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Svmn validation for a GovSteamFV4
   *
   * @param command AssignSvmnToGovSteamFV4Command
   */
  public void validate(AssignSvmnToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignSvmnToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignSvmnToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSvmnToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Svmn validation for a GovSteamFV4
   *
   * @param command UnAssignSvmnFromGovSteamFV4Command
   */
  public void validate(UnAssignSvmnFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignSvmnFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignSvmnFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Svmx validation for a GovSteamFV4
   *
   * @param command AssignSvmxToGovSteamFV4Command
   */
  public void validate(AssignSvmxToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignSvmxToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignSvmxToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSvmxToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Svmx validation for a GovSteamFV4
   *
   * @param command UnAssignSvmxFromGovSteamFV4Command
   */
  public void validate(UnAssignSvmxFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignSvmxFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignSvmxFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Ta validation for a GovSteamFV4
   *
   * @param command AssignTaToGovSteamFV4Command
   */
  public void validate(AssignTaToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignTaToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignTaToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a GovSteamFV4
   *
   * @param command UnAssignTaFromGovSteamFV4Command
   */
  public void validate(UnAssignTaFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignTaFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Tam validation for a GovSteamFV4
   *
   * @param command AssignTamToGovSteamFV4Command
   */
  public void validate(AssignTamToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignTamToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignTamToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTamToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Tam validation for a GovSteamFV4
   *
   * @param command UnAssignTamFromGovSteamFV4Command
   */
  public void validate(UnAssignTamFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTamFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignTamFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Tc validation for a GovSteamFV4
   *
   * @param command AssignTcToGovSteamFV4Command
   */
  public void validate(AssignTcToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignTcToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignTcToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a GovSteamFV4
   *
   * @param command UnAssignTcFromGovSteamFV4Command
   */
  public void validate(UnAssignTcFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignTcFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Tcm validation for a GovSteamFV4
   *
   * @param command AssignTcmToGovSteamFV4Command
   */
  public void validate(AssignTcmToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignTcmToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignTcmToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcmToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Tcm validation for a GovSteamFV4
   *
   * @param command UnAssignTcmFromGovSteamFV4Command
   */
  public void validate(UnAssignTcmFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTcmFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignTcmFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Tdc validation for a GovSteamFV4
   *
   * @param command AssignTdcToGovSteamFV4Command
   */
  public void validate(AssignTdcToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignTdcToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignTdcToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdcToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Tdc validation for a GovSteamFV4
   *
   * @param command UnAssignTdcFromGovSteamFV4Command
   */
  public void validate(UnAssignTdcFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTdcFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignTdcFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Tf1 validation for a GovSteamFV4
   *
   * @param command AssignTf1ToGovSteamFV4Command
   */
  public void validate(AssignTf1ToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignTf1ToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignTf1ToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf1ToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Tf1 validation for a GovSteamFV4
   *
   * @param command UnAssignTf1FromGovSteamFV4Command
   */
  public void validate(UnAssignTf1FromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTf1FromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignTf1FromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Tf2 validation for a GovSteamFV4
   *
   * @param command AssignTf2ToGovSteamFV4Command
   */
  public void validate(AssignTf2ToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignTf2ToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignTf2ToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf2ToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Tf2 validation for a GovSteamFV4
   *
   * @param command UnAssignTf2FromGovSteamFV4Command
   */
  public void validate(UnAssignTf2FromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTf2FromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignTf2FromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Thp validation for a GovSteamFV4
   *
   * @param command AssignThpToGovSteamFV4Command
   */
  public void validate(AssignThpToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignThpToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignThpToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignThpToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Thp validation for a GovSteamFV4
   *
   * @param command UnAssignThpFromGovSteamFV4Command
   */
  public void validate(UnAssignThpFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignThpFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignThpFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Tmp validation for a GovSteamFV4
   *
   * @param command AssignTmpToGovSteamFV4Command
   */
  public void validate(AssignTmpToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignTmpToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignTmpToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTmpToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Tmp validation for a GovSteamFV4
   *
   * @param command UnAssignTmpFromGovSteamFV4Command
   */
  public void validate(UnAssignTmpFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTmpFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignTmpFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Trh validation for a GovSteamFV4
   *
   * @param command AssignTrhToGovSteamFV4Command
   */
  public void validate(AssignTrhToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignTrhToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignTrhToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTrhToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Trh validation for a GovSteamFV4
   *
   * @param command UnAssignTrhFromGovSteamFV4Command
   */
  public void validate(UnAssignTrhFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTrhFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignTrhFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Tv validation for a GovSteamFV4
   *
   * @param command AssignTvToGovSteamFV4Command
   */
  public void validate(AssignTvToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignTvToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignTvToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTvToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Tv validation for a GovSteamFV4
   *
   * @param command UnAssignTvFromGovSteamFV4Command
   */
  public void validate(UnAssignTvFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTvFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignTvFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Ty validation for a GovSteamFV4
   *
   * @param command AssignTyToGovSteamFV4Command
   */
  public void validate(AssignTyToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignTyToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignTyToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTyToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Ty validation for a GovSteamFV4
   *
   * @param command UnAssignTyFromGovSteamFV4Command
   */
  public void validate(UnAssignTyFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTyFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignTyFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Y validation for a GovSteamFV4
   *
   * @param command AssignYToGovSteamFV4Command
   */
  public void validate(AssignYToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignYToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(), "AssignYToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignYToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Y validation for a GovSteamFV4
   *
   * @param command UnAssignYFromGovSteamFV4Command
   */
  public void validate(UnAssignYFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignYFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignYFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Yhpmn validation for a GovSteamFV4
   *
   * @param command AssignYhpmnToGovSteamFV4Command
   */
  public void validate(AssignYhpmnToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignYhpmnToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "AssignYhpmnToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignYhpmnToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Yhpmn validation for a GovSteamFV4
   *
   * @param command UnAssignYhpmnFromGovSteamFV4Command
   */
  public void validate(UnAssignYhpmnFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignYhpmnFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignYhpmnFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Yhpmx validation for a GovSteamFV4
   *
   * @param command AssignYhpmxToGovSteamFV4Command
   */
  public void validate(AssignYhpmxToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignYhpmxToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "AssignYhpmxToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignYhpmxToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Yhpmx validation for a GovSteamFV4
   *
   * @param command UnAssignYhpmxFromGovSteamFV4Command
   */
  public void validate(UnAssignYhpmxFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignYhpmxFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignYhpmxFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Ympmn validation for a GovSteamFV4
   *
   * @param command AssignYmpmnToGovSteamFV4Command
   */
  public void validate(AssignYmpmnToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignYmpmnToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "AssignYmpmnToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignYmpmnToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Ympmn validation for a GovSteamFV4
   *
   * @param command UnAssignYmpmnFromGovSteamFV4Command
   */
  public void validate(UnAssignYmpmnFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignYmpmnFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignYmpmnFromGovSteamFV4Command identifier should not be null");
  }
  /**
   * handles assign Ympmx validation for a GovSteamFV4
   *
   * @param command AssignYmpmxToGovSteamFV4Command
   */
  public void validate(AssignYmpmxToGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "AssignYmpmxToGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "AssignYmpmxToGovSteamFV4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignYmpmxToGovSteamFV4Command assignment should not be null");
  }

  /**
   * handles unassign Ympmx validation for a GovSteamFV4
   *
   * @param command UnAssignYmpmxFromGovSteamFV4Command
   */
  public void validate(UnAssignYmpmxFromGovSteamFV4Command command) throws Exception {
    Assert.notNull(command, "UnAssignYmpmxFromGovSteamFV4Command should not be null");
    Assert.notNull(
        command.getGovSteamFV4Id(),
        "UnAssignYmpmxFromGovSteamFV4Command identifier should not be null");
  }
}
