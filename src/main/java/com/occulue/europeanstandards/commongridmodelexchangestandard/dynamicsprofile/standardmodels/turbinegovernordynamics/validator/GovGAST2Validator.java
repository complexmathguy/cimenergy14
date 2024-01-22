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

public class GovGAST2Validator {

  /** default constructor */
  protected GovGAST2Validator() {}

  /** factory method */
  public static GovGAST2Validator getInstance() {
    return new GovGAST2Validator();
  }

  /** handles creation validation for a GovGAST2 */
  public void validate(CreateGovGAST2Command govGAST2) throws Exception {
    Assert.notNull(govGAST2, "CreateGovGAST2Command should not be null");
    //		Assert.isNull( govGAST2.getGovGAST2Id(), "CreateGovGAST2Command identifier should be null"
    // );
  }

  /** handles update validation for a GovGAST2 */
  public void validate(UpdateGovGAST2Command govGAST2) throws Exception {
    Assert.notNull(govGAST2, "UpdateGovGAST2Command should not be null");
    Assert.notNull(govGAST2.getGovGAST2Id(), "UpdateGovGAST2Command identifier should not be null");
  }

  /** handles delete validation for a GovGAST2 */
  public void validate(DeleteGovGAST2Command govGAST2) throws Exception {
    Assert.notNull(govGAST2, "{commandAlias} should not be null");
    Assert.notNull(govGAST2.getGovGAST2Id(), "DeleteGovGAST2Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovGAST2 */
  public void validate(GovGAST2FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovGAST2FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovGAST2Id(), "GovGAST2FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign A validation for a GovGAST2
   *
   * @param command AssignAToGovGAST2Command
   */
  public void validate(AssignAToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignAToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignAToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign A validation for a GovGAST2
   *
   * @param command UnAssignAFromGovGAST2Command
   */
  public void validate(UnAssignAFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignAFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignAFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Af1 validation for a GovGAST2
   *
   * @param command AssignAf1ToGovGAST2Command
   */
  public void validate(AssignAf1ToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignAf1ToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignAf1ToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAf1ToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Af1 validation for a GovGAST2
   *
   * @param command UnAssignAf1FromGovGAST2Command
   */
  public void validate(UnAssignAf1FromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignAf1FromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignAf1FromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Af2 validation for a GovGAST2
   *
   * @param command AssignAf2ToGovGAST2Command
   */
  public void validate(AssignAf2ToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignAf2ToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignAf2ToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAf2ToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Af2 validation for a GovGAST2
   *
   * @param command UnAssignAf2FromGovGAST2Command
   */
  public void validate(UnAssignAf2FromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignAf2FromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignAf2FromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign B validation for a GovGAST2
   *
   * @param command AssignBToGovGAST2Command
   */
  public void validate(AssignBToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignBToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignBToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign B validation for a GovGAST2
   *
   * @param command UnAssignBFromGovGAST2Command
   */
  public void validate(UnAssignBFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignBFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignBFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Bf1 validation for a GovGAST2
   *
   * @param command AssignBf1ToGovGAST2Command
   */
  public void validate(AssignBf1ToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignBf1ToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignBf1ToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBf1ToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Bf1 validation for a GovGAST2
   *
   * @param command UnAssignBf1FromGovGAST2Command
   */
  public void validate(UnAssignBf1FromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignBf1FromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignBf1FromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Bf2 validation for a GovGAST2
   *
   * @param command AssignBf2ToGovGAST2Command
   */
  public void validate(AssignBf2ToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignBf2ToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignBf2ToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBf2ToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Bf2 validation for a GovGAST2
   *
   * @param command UnAssignBf2FromGovGAST2Command
   */
  public void validate(UnAssignBf2FromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignBf2FromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignBf2FromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign C validation for a GovGAST2
   *
   * @param command AssignCToGovGAST2Command
   */
  public void validate(AssignCToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignCToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignCToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignCToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign C validation for a GovGAST2
   *
   * @param command UnAssignCFromGovGAST2Command
   */
  public void validate(UnAssignCFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignCFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignCFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Cf2 validation for a GovGAST2
   *
   * @param command AssignCf2ToGovGAST2Command
   */
  public void validate(AssignCf2ToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignCf2ToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignCf2ToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignCf2ToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Cf2 validation for a GovGAST2
   *
   * @param command UnAssignCf2FromGovGAST2Command
   */
  public void validate(UnAssignCf2FromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignCf2FromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignCf2FromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Ecr validation for a GovGAST2
   *
   * @param command AssignEcrToGovGAST2Command
   */
  public void validate(AssignEcrToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignEcrToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignEcrToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEcrToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Ecr validation for a GovGAST2
   *
   * @param command UnAssignEcrFromGovGAST2Command
   */
  public void validate(UnAssignEcrFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignEcrFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignEcrFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Etd validation for a GovGAST2
   *
   * @param command AssignEtdToGovGAST2Command
   */
  public void validate(AssignEtdToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignEtdToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignEtdToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEtdToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Etd validation for a GovGAST2
   *
   * @param command UnAssignEtdFromGovGAST2Command
   */
  public void validate(UnAssignEtdFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignEtdFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignEtdFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign K3 validation for a GovGAST2
   *
   * @param command AssignK3ToGovGAST2Command
   */
  public void validate(AssignK3ToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignK3ToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignK3ToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK3ToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign K3 validation for a GovGAST2
   *
   * @param command UnAssignK3FromGovGAST2Command
   */
  public void validate(UnAssignK3FromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignK3FromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignK3FromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign K4 validation for a GovGAST2
   *
   * @param command AssignK4ToGovGAST2Command
   */
  public void validate(AssignK4ToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignK4ToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignK4ToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK4ToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign K4 validation for a GovGAST2
   *
   * @param command UnAssignK4FromGovGAST2Command
   */
  public void validate(UnAssignK4FromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignK4FromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignK4FromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign K5 validation for a GovGAST2
   *
   * @param command AssignK5ToGovGAST2Command
   */
  public void validate(AssignK5ToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignK5ToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignK5ToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK5ToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign K5 validation for a GovGAST2
   *
   * @param command UnAssignK5FromGovGAST2Command
   */
  public void validate(UnAssignK5FromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignK5FromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignK5FromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign K6 validation for a GovGAST2
   *
   * @param command AssignK6ToGovGAST2Command
   */
  public void validate(AssignK6ToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignK6ToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignK6ToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK6ToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign K6 validation for a GovGAST2
   *
   * @param command UnAssignK6FromGovGAST2Command
   */
  public void validate(UnAssignK6FromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignK6FromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignK6FromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Kf validation for a GovGAST2
   *
   * @param command AssignKfToGovGAST2Command
   */
  public void validate(AssignKfToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignKfToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignKfToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a GovGAST2
   *
   * @param command UnAssignKfFromGovGAST2Command
   */
  public void validate(UnAssignKfFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignKfFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovGAST2
   *
   * @param command AssignMwbaseToGovGAST2Command
   */
  public void validate(AssignMwbaseToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignMwbaseToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovGAST2
   *
   * @param command UnAssignMwbaseFromGovGAST2Command
   */
  public void validate(UnAssignMwbaseFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignMwbaseFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign T validation for a GovGAST2
   *
   * @param command AssignTToGovGAST2Command
   */
  public void validate(AssignTToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignTToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignTToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign T validation for a GovGAST2
   *
   * @param command UnAssignTFromGovGAST2Command
   */
  public void validate(UnAssignTFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignTFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign T3 validation for a GovGAST2
   *
   * @param command AssignT3ToGovGAST2Command
   */
  public void validate(AssignT3ToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignT3ToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignT3ToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a GovGAST2
   *
   * @param command UnAssignT3FromGovGAST2Command
   */
  public void validate(UnAssignT3FromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignT3FromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign T4 validation for a GovGAST2
   *
   * @param command AssignT4ToGovGAST2Command
   */
  public void validate(AssignT4ToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignT4ToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignT4ToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a GovGAST2
   *
   * @param command UnAssignT4FromGovGAST2Command
   */
  public void validate(UnAssignT4FromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignT4FromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign T5 validation for a GovGAST2
   *
   * @param command AssignT5ToGovGAST2Command
   */
  public void validate(AssignT5ToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignT5ToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignT5ToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5ToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a GovGAST2
   *
   * @param command UnAssignT5FromGovGAST2Command
   */
  public void validate(UnAssignT5FromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignT5FromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Tc validation for a GovGAST2
   *
   * @param command AssignTcToGovGAST2Command
   */
  public void validate(AssignTcToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignTcToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignTcToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a GovGAST2
   *
   * @param command UnAssignTcFromGovGAST2Command
   */
  public void validate(UnAssignTcFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignTcFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Tcd validation for a GovGAST2
   *
   * @param command AssignTcdToGovGAST2Command
   */
  public void validate(AssignTcdToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignTcdToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignTcdToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcdToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Tcd validation for a GovGAST2
   *
   * @param command UnAssignTcdFromGovGAST2Command
   */
  public void validate(UnAssignTcdFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTcdFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignTcdFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Tf validation for a GovGAST2
   *
   * @param command AssignTfToGovGAST2Command
   */
  public void validate(AssignTfToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignTfToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignTfToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a GovGAST2
   *
   * @param command UnAssignTfFromGovGAST2Command
   */
  public void validate(UnAssignTfFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignTfFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Tmax validation for a GovGAST2
   *
   * @param command AssignTmaxToGovGAST2Command
   */
  public void validate(AssignTmaxToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignTmaxToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignTmaxToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTmaxToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Tmax validation for a GovGAST2
   *
   * @param command UnAssignTmaxFromGovGAST2Command
   */
  public void validate(UnAssignTmaxFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTmaxFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignTmaxFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Tmin validation for a GovGAST2
   *
   * @param command AssignTminToGovGAST2Command
   */
  public void validate(AssignTminToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignTminToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignTminToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTminToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Tmin validation for a GovGAST2
   *
   * @param command UnAssignTminFromGovGAST2Command
   */
  public void validate(UnAssignTminFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTminFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignTminFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Tr validation for a GovGAST2
   *
   * @param command AssignTrToGovGAST2Command
   */
  public void validate(AssignTrToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignTrToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignTrToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTrToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Tr validation for a GovGAST2
   *
   * @param command UnAssignTrFromGovGAST2Command
   */
  public void validate(UnAssignTrFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTrFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignTrFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Trate validation for a GovGAST2
   *
   * @param command AssignTrateToGovGAST2Command
   */
  public void validate(AssignTrateToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignTrateToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignTrateToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTrateToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Trate validation for a GovGAST2
   *
   * @param command UnAssignTrateFromGovGAST2Command
   */
  public void validate(UnAssignTrateFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTrateFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignTrateFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Tt validation for a GovGAST2
   *
   * @param command AssignTtToGovGAST2Command
   */
  public void validate(AssignTtToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignTtToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignTtToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTtToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Tt validation for a GovGAST2
   *
   * @param command UnAssignTtFromGovGAST2Command
   */
  public void validate(UnAssignTtFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTtFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignTtFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign W validation for a GovGAST2
   *
   * @param command AssignWToGovGAST2Command
   */
  public void validate(AssignWToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignWToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignWToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignWToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign W validation for a GovGAST2
   *
   * @param command UnAssignWFromGovGAST2Command
   */
  public void validate(UnAssignWFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignWFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignWFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign X validation for a GovGAST2
   *
   * @param command AssignXToGovGAST2Command
   */
  public void validate(AssignXToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignXToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignXToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign X validation for a GovGAST2
   *
   * @param command UnAssignXFromGovGAST2Command
   */
  public void validate(UnAssignXFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignXFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignXFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Y validation for a GovGAST2
   *
   * @param command AssignYToGovGAST2Command
   */
  public void validate(AssignYToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignYToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignYToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignYToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Y validation for a GovGAST2
   *
   * @param command UnAssignYFromGovGAST2Command
   */
  public void validate(UnAssignYFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignYFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignYFromGovGAST2Command identifier should not be null");
  }
  /**
   * handles assign Z validation for a GovGAST2
   *
   * @param command AssignZToGovGAST2Command
   */
  public void validate(AssignZToGovGAST2Command command) throws Exception {
    Assert.notNull(command, "AssignZToGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "AssignZToGovGAST2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignZToGovGAST2Command assignment should not be null");
  }

  /**
   * handles unassign Z validation for a GovGAST2
   *
   * @param command UnAssignZFromGovGAST2Command
   */
  public void validate(UnAssignZFromGovGAST2Command command) throws Exception {
    Assert.notNull(command, "UnAssignZFromGovGAST2Command should not be null");
    Assert.notNull(
        command.getGovGAST2Id(), "UnAssignZFromGovGAST2Command identifier should not be null");
  }
}
