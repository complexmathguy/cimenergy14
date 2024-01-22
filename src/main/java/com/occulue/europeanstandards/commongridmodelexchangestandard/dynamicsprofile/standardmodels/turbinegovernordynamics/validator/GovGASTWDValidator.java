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

public class GovGASTWDValidator {

  /** default constructor */
  protected GovGASTWDValidator() {}

  /** factory method */
  public static GovGASTWDValidator getInstance() {
    return new GovGASTWDValidator();
  }

  /** handles creation validation for a GovGASTWD */
  public void validate(CreateGovGASTWDCommand govGASTWD) throws Exception {
    Assert.notNull(govGASTWD, "CreateGovGASTWDCommand should not be null");
    //		Assert.isNull( govGASTWD.getGovGASTWDId(), "CreateGovGASTWDCommand identifier should be
    // null" );
  }

  /** handles update validation for a GovGASTWD */
  public void validate(UpdateGovGASTWDCommand govGASTWD) throws Exception {
    Assert.notNull(govGASTWD, "UpdateGovGASTWDCommand should not be null");
    Assert.notNull(
        govGASTWD.getGovGASTWDId(), "UpdateGovGASTWDCommand identifier should not be null");
  }

  /** handles delete validation for a GovGASTWD */
  public void validate(DeleteGovGASTWDCommand govGASTWD) throws Exception {
    Assert.notNull(govGASTWD, "{commandAlias} should not be null");
    Assert.notNull(
        govGASTWD.getGovGASTWDId(), "DeleteGovGASTWDCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GovGASTWD */
  public void validate(GovGASTWDFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovGASTWDFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovGASTWDId(), "GovGASTWDFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign A validation for a GovGASTWD
   *
   * @param command AssignAToGovGASTWDCommand
   */
  public void validate(AssignAToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignAToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignAToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign A validation for a GovGASTWD
   *
   * @param command UnAssignAFromGovGASTWDCommand
   */
  public void validate(UnAssignAFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignAFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Af1 validation for a GovGASTWD
   *
   * @param command AssignAf1ToGovGASTWDCommand
   */
  public void validate(AssignAf1ToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignAf1ToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignAf1ToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAf1ToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Af1 validation for a GovGASTWD
   *
   * @param command UnAssignAf1FromGovGASTWDCommand
   */
  public void validate(UnAssignAf1FromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAf1FromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignAf1FromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Af2 validation for a GovGASTWD
   *
   * @param command AssignAf2ToGovGASTWDCommand
   */
  public void validate(AssignAf2ToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignAf2ToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignAf2ToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAf2ToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Af2 validation for a GovGASTWD
   *
   * @param command UnAssignAf2FromGovGASTWDCommand
   */
  public void validate(UnAssignAf2FromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAf2FromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignAf2FromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign B validation for a GovGASTWD
   *
   * @param command AssignBToGovGASTWDCommand
   */
  public void validate(AssignBToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignBToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignBToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign B validation for a GovGASTWD
   *
   * @param command UnAssignBFromGovGASTWDCommand
   */
  public void validate(UnAssignBFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignBFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Bf1 validation for a GovGASTWD
   *
   * @param command AssignBf1ToGovGASTWDCommand
   */
  public void validate(AssignBf1ToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignBf1ToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignBf1ToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBf1ToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Bf1 validation for a GovGASTWD
   *
   * @param command UnAssignBf1FromGovGASTWDCommand
   */
  public void validate(UnAssignBf1FromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBf1FromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignBf1FromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Bf2 validation for a GovGASTWD
   *
   * @param command AssignBf2ToGovGASTWDCommand
   */
  public void validate(AssignBf2ToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignBf2ToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignBf2ToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBf2ToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Bf2 validation for a GovGASTWD
   *
   * @param command UnAssignBf2FromGovGASTWDCommand
   */
  public void validate(UnAssignBf2FromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBf2FromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignBf2FromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign C validation for a GovGASTWD
   *
   * @param command AssignCToGovGASTWDCommand
   */
  public void validate(AssignCToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignCToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignCToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignCToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign C validation for a GovGASTWD
   *
   * @param command UnAssignCFromGovGASTWDCommand
   */
  public void validate(UnAssignCFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignCFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignCFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Cf2 validation for a GovGASTWD
   *
   * @param command AssignCf2ToGovGASTWDCommand
   */
  public void validate(AssignCf2ToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignCf2ToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignCf2ToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignCf2ToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Cf2 validation for a GovGASTWD
   *
   * @param command UnAssignCf2FromGovGASTWDCommand
   */
  public void validate(UnAssignCf2FromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignCf2FromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignCf2FromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Ecr validation for a GovGASTWD
   *
   * @param command AssignEcrToGovGASTWDCommand
   */
  public void validate(AssignEcrToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignEcrToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignEcrToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEcrToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Ecr validation for a GovGASTWD
   *
   * @param command UnAssignEcrFromGovGASTWDCommand
   */
  public void validate(UnAssignEcrFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEcrFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignEcrFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Etd validation for a GovGASTWD
   *
   * @param command AssignEtdToGovGASTWDCommand
   */
  public void validate(AssignEtdToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignEtdToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignEtdToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEtdToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Etd validation for a GovGASTWD
   *
   * @param command UnAssignEtdFromGovGASTWDCommand
   */
  public void validate(UnAssignEtdFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEtdFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignEtdFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign K3 validation for a GovGASTWD
   *
   * @param command AssignK3ToGovGASTWDCommand
   */
  public void validate(AssignK3ToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignK3ToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignK3ToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK3ToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign K3 validation for a GovGASTWD
   *
   * @param command UnAssignK3FromGovGASTWDCommand
   */
  public void validate(UnAssignK3FromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK3FromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignK3FromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign K4 validation for a GovGASTWD
   *
   * @param command AssignK4ToGovGASTWDCommand
   */
  public void validate(AssignK4ToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignK4ToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignK4ToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK4ToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign K4 validation for a GovGASTWD
   *
   * @param command UnAssignK4FromGovGASTWDCommand
   */
  public void validate(UnAssignK4FromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK4FromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignK4FromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign K5 validation for a GovGASTWD
   *
   * @param command AssignK5ToGovGASTWDCommand
   */
  public void validate(AssignK5ToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignK5ToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignK5ToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK5ToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign K5 validation for a GovGASTWD
   *
   * @param command UnAssignK5FromGovGASTWDCommand
   */
  public void validate(UnAssignK5FromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK5FromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignK5FromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign K6 validation for a GovGASTWD
   *
   * @param command AssignK6ToGovGASTWDCommand
   */
  public void validate(AssignK6ToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignK6ToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignK6ToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK6ToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign K6 validation for a GovGASTWD
   *
   * @param command UnAssignK6FromGovGASTWDCommand
   */
  public void validate(UnAssignK6FromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK6FromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignK6FromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a GovGASTWD
   *
   * @param command AssignKdToGovGASTWDCommand
   */
  public void validate(AssignKdToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignKdToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignKdToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a GovGASTWD
   *
   * @param command UnAssignKdFromGovGASTWDCommand
   */
  public void validate(UnAssignKdFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignKdFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Kdroop validation for a GovGASTWD
   *
   * @param command AssignKdroopToGovGASTWDCommand
   */
  public void validate(AssignKdroopToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignKdroopToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignKdroopToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdroopToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Kdroop validation for a GovGASTWD
   *
   * @param command UnAssignKdroopFromGovGASTWDCommand
   */
  public void validate(UnAssignKdroopFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdroopFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(),
        "UnAssignKdroopFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a GovGASTWD
   *
   * @param command AssignKfToGovGASTWDCommand
   */
  public void validate(AssignKfToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignKfToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignKfToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a GovGASTWD
   *
   * @param command UnAssignKfFromGovGASTWDCommand
   */
  public void validate(UnAssignKfFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignKfFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a GovGASTWD
   *
   * @param command AssignKiToGovGASTWDCommand
   */
  public void validate(AssignKiToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignKiToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignKiToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a GovGASTWD
   *
   * @param command UnAssignKiFromGovGASTWDCommand
   */
  public void validate(UnAssignKiFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignKiFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a GovGASTWD
   *
   * @param command AssignKpToGovGASTWDCommand
   */
  public void validate(AssignKpToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignKpToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignKpToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a GovGASTWD
   *
   * @param command UnAssignKpFromGovGASTWDCommand
   */
  public void validate(UnAssignKpFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignKpFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovGASTWD
   *
   * @param command AssignMwbaseToGovGASTWDCommand
   */
  public void validate(AssignMwbaseToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignMwbaseToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovGASTWD
   *
   * @param command UnAssignMwbaseFromGovGASTWDCommand
   */
  public void validate(UnAssignMwbaseFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(),
        "UnAssignMwbaseFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign T validation for a GovGASTWD
   *
   * @param command AssignTToGovGASTWDCommand
   */
  public void validate(AssignTToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignTToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignTToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign T validation for a GovGASTWD
   *
   * @param command UnAssignTFromGovGASTWDCommand
   */
  public void validate(UnAssignTFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignTFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign T3 validation for a GovGASTWD
   *
   * @param command AssignT3ToGovGASTWDCommand
   */
  public void validate(AssignT3ToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignT3ToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignT3ToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a GovGASTWD
   *
   * @param command UnAssignT3FromGovGASTWDCommand
   */
  public void validate(UnAssignT3FromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignT3FromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign T4 validation for a GovGASTWD
   *
   * @param command AssignT4ToGovGASTWDCommand
   */
  public void validate(AssignT4ToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignT4ToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignT4ToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a GovGASTWD
   *
   * @param command UnAssignT4FromGovGASTWDCommand
   */
  public void validate(UnAssignT4FromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignT4FromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign T5 validation for a GovGASTWD
   *
   * @param command AssignT5ToGovGASTWDCommand
   */
  public void validate(AssignT5ToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignT5ToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignT5ToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5ToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a GovGASTWD
   *
   * @param command UnAssignT5FromGovGASTWDCommand
   */
  public void validate(UnAssignT5FromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignT5FromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Tc validation for a GovGASTWD
   *
   * @param command AssignTcToGovGASTWDCommand
   */
  public void validate(AssignTcToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignTcToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignTcToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a GovGASTWD
   *
   * @param command UnAssignTcFromGovGASTWDCommand
   */
  public void validate(UnAssignTcFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignTcFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Tcd validation for a GovGASTWD
   *
   * @param command AssignTcdToGovGASTWDCommand
   */
  public void validate(AssignTcdToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignTcdToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignTcdToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcdToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Tcd validation for a GovGASTWD
   *
   * @param command UnAssignTcdFromGovGASTWDCommand
   */
  public void validate(UnAssignTcdFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTcdFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignTcdFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Td validation for a GovGASTWD
   *
   * @param command AssignTdToGovGASTWDCommand
   */
  public void validate(AssignTdToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignTdToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignTdToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Td validation for a GovGASTWD
   *
   * @param command UnAssignTdFromGovGASTWDCommand
   */
  public void validate(UnAssignTdFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignTdFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a GovGASTWD
   *
   * @param command AssignTfToGovGASTWDCommand
   */
  public void validate(AssignTfToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignTfToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignTfToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a GovGASTWD
   *
   * @param command UnAssignTfFromGovGASTWDCommand
   */
  public void validate(UnAssignTfFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignTfFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Tmax validation for a GovGASTWD
   *
   * @param command AssignTmaxToGovGASTWDCommand
   */
  public void validate(AssignTmaxToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignTmaxToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignTmaxToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTmaxToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Tmax validation for a GovGASTWD
   *
   * @param command UnAssignTmaxFromGovGASTWDCommand
   */
  public void validate(UnAssignTmaxFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTmaxFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignTmaxFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Tmin validation for a GovGASTWD
   *
   * @param command AssignTminToGovGASTWDCommand
   */
  public void validate(AssignTminToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignTminToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignTminToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTminToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Tmin validation for a GovGASTWD
   *
   * @param command UnAssignTminFromGovGASTWDCommand
   */
  public void validate(UnAssignTminFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTminFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignTminFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Tr validation for a GovGASTWD
   *
   * @param command AssignTrToGovGASTWDCommand
   */
  public void validate(AssignTrToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignTrToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignTrToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTrToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Tr validation for a GovGASTWD
   *
   * @param command UnAssignTrFromGovGASTWDCommand
   */
  public void validate(UnAssignTrFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTrFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignTrFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Trate validation for a GovGASTWD
   *
   * @param command AssignTrateToGovGASTWDCommand
   */
  public void validate(AssignTrateToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignTrateToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignTrateToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTrateToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Trate validation for a GovGASTWD
   *
   * @param command UnAssignTrateFromGovGASTWDCommand
   */
  public void validate(UnAssignTrateFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTrateFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(),
        "UnAssignTrateFromGovGASTWDCommand identifier should not be null");
  }
  /**
   * handles assign Tt validation for a GovGASTWD
   *
   * @param command AssignTtToGovGASTWDCommand
   */
  public void validate(AssignTtToGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "AssignTtToGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "AssignTtToGovGASTWDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTtToGovGASTWDCommand assignment should not be null");
  }

  /**
   * handles unassign Tt validation for a GovGASTWD
   *
   * @param command UnAssignTtFromGovGASTWDCommand
   */
  public void validate(UnAssignTtFromGovGASTWDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTtFromGovGASTWDCommand should not be null");
    Assert.notNull(
        command.getGovGASTWDId(), "UnAssignTtFromGovGASTWDCommand identifier should not be null");
  }
}
