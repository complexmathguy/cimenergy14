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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class ExternalNetworkInjectionValidator {

  /** default constructor */
  protected ExternalNetworkInjectionValidator() {}

  /** factory method */
  public static ExternalNetworkInjectionValidator getInstance() {
    return new ExternalNetworkInjectionValidator();
  }

  /** handles creation validation for a ExternalNetworkInjection */
  public void validate(CreateExternalNetworkInjectionCommand externalNetworkInjection)
      throws Exception {
    Assert.notNull(
        externalNetworkInjection, "CreateExternalNetworkInjectionCommand should not be null");
    //		Assert.isNull( externalNetworkInjection.getExternalNetworkInjectionId(),
    // "CreateExternalNetworkInjectionCommand identifier should be null" );
  }

  /** handles update validation for a ExternalNetworkInjection */
  public void validate(UpdateExternalNetworkInjectionCommand externalNetworkInjection)
      throws Exception {
    Assert.notNull(
        externalNetworkInjection, "UpdateExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        externalNetworkInjection.getExternalNetworkInjectionId(),
        "UpdateExternalNetworkInjectionCommand identifier should not be null");
  }

  /** handles delete validation for a ExternalNetworkInjection */
  public void validate(DeleteExternalNetworkInjectionCommand externalNetworkInjection)
      throws Exception {
    Assert.notNull(externalNetworkInjection, "{commandAlias} should not be null");
    Assert.notNull(
        externalNetworkInjection.getExternalNetworkInjectionId(),
        "DeleteExternalNetworkInjectionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExternalNetworkInjection */
  public void validate(ExternalNetworkInjectionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExternalNetworkInjectionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExternalNetworkInjectionId(),
        "ExternalNetworkInjectionFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign GovernorSCD validation for a ExternalNetworkInjection
   *
   * @param command AssignGovernorSCDToExternalNetworkInjectionCommand
   */
  public void validate(AssignGovernorSCDToExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignGovernorSCDToExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "AssignGovernorSCDToExternalNetworkInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignGovernorSCDToExternalNetworkInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign GovernorSCD validation for a ExternalNetworkInjection
   *
   * @param command UnAssignGovernorSCDFromExternalNetworkInjectionCommand
   */
  public void validate(UnAssignGovernorSCDFromExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignGovernorSCDFromExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "UnAssignGovernorSCDFromExternalNetworkInjectionCommand identifier should not be null");
  }
  /**
   * handles assign IkSecond validation for a ExternalNetworkInjection
   *
   * @param command AssignIkSecondToExternalNetworkInjectionCommand
   */
  public void validate(AssignIkSecondToExternalNetworkInjectionCommand command) throws Exception {
    Assert.notNull(command, "AssignIkSecondToExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "AssignIkSecondToExternalNetworkInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignIkSecondToExternalNetworkInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign IkSecond validation for a ExternalNetworkInjection
   *
   * @param command UnAssignIkSecondFromExternalNetworkInjectionCommand
   */
  public void validate(UnAssignIkSecondFromExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignIkSecondFromExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "UnAssignIkSecondFromExternalNetworkInjectionCommand identifier should not be null");
  }
  /**
   * handles assign MaxInitialSymShCCurrent validation for a ExternalNetworkInjection
   *
   * @param command AssignMaxInitialSymShCCurrentToExternalNetworkInjectionCommand
   */
  public void validate(AssignMaxInitialSymShCCurrentToExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignMaxInitialSymShCCurrentToExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "AssignMaxInitialSymShCCurrentToExternalNetworkInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxInitialSymShCCurrentToExternalNetworkInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MaxInitialSymShCCurrent validation for a ExternalNetworkInjection
   *
   * @param command UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionCommand
   */
  public void validate(UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "UnAssignMaxInitialSymShCCurrentFromExternalNetworkInjectionCommand identifier should not be null");
  }
  /**
   * handles assign MaxP validation for a ExternalNetworkInjection
   *
   * @param command AssignMaxPToExternalNetworkInjectionCommand
   */
  public void validate(AssignMaxPToExternalNetworkInjectionCommand command) throws Exception {
    Assert.notNull(command, "AssignMaxPToExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "AssignMaxPToExternalNetworkInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxPToExternalNetworkInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MaxP validation for a ExternalNetworkInjection
   *
   * @param command UnAssignMaxPFromExternalNetworkInjectionCommand
   */
  public void validate(UnAssignMaxPFromExternalNetworkInjectionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMaxPFromExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "UnAssignMaxPFromExternalNetworkInjectionCommand identifier should not be null");
  }
  /**
   * handles assign MaxQ validation for a ExternalNetworkInjection
   *
   * @param command AssignMaxQToExternalNetworkInjectionCommand
   */
  public void validate(AssignMaxQToExternalNetworkInjectionCommand command) throws Exception {
    Assert.notNull(command, "AssignMaxQToExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "AssignMaxQToExternalNetworkInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxQToExternalNetworkInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MaxQ validation for a ExternalNetworkInjection
   *
   * @param command UnAssignMaxQFromExternalNetworkInjectionCommand
   */
  public void validate(UnAssignMaxQFromExternalNetworkInjectionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMaxQFromExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "UnAssignMaxQFromExternalNetworkInjectionCommand identifier should not be null");
  }
  /**
   * handles assign MaxR0ToX0Ratio validation for a ExternalNetworkInjection
   *
   * @param command AssignMaxR0ToX0RatioToExternalNetworkInjectionCommand
   */
  public void validate(AssignMaxR0ToX0RatioToExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignMaxR0ToX0RatioToExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "AssignMaxR0ToX0RatioToExternalNetworkInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxR0ToX0RatioToExternalNetworkInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MaxR0ToX0Ratio validation for a ExternalNetworkInjection
   *
   * @param command UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionCommand
   */
  public void validate(UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "UnAssignMaxR0ToX0RatioFromExternalNetworkInjectionCommand identifier should not be null");
  }
  /**
   * handles assign MaxR1ToX1Ratio validation for a ExternalNetworkInjection
   *
   * @param command AssignMaxR1ToX1RatioToExternalNetworkInjectionCommand
   */
  public void validate(AssignMaxR1ToX1RatioToExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignMaxR1ToX1RatioToExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "AssignMaxR1ToX1RatioToExternalNetworkInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxR1ToX1RatioToExternalNetworkInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MaxR1ToX1Ratio validation for a ExternalNetworkInjection
   *
   * @param command UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionCommand
   */
  public void validate(UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "UnAssignMaxR1ToX1RatioFromExternalNetworkInjectionCommand identifier should not be null");
  }
  /**
   * handles assign MaxZ0ToZ1Ratio validation for a ExternalNetworkInjection
   *
   * @param command AssignMaxZ0ToZ1RatioToExternalNetworkInjectionCommand
   */
  public void validate(AssignMaxZ0ToZ1RatioToExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignMaxZ0ToZ1RatioToExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "AssignMaxZ0ToZ1RatioToExternalNetworkInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxZ0ToZ1RatioToExternalNetworkInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MaxZ0ToZ1Ratio validation for a ExternalNetworkInjection
   *
   * @param command UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionCommand
   */
  public void validate(UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "UnAssignMaxZ0ToZ1RatioFromExternalNetworkInjectionCommand identifier should not be null");
  }
  /**
   * handles assign MinInitialSymShCCurrent validation for a ExternalNetworkInjection
   *
   * @param command AssignMinInitialSymShCCurrentToExternalNetworkInjectionCommand
   */
  public void validate(AssignMinInitialSymShCCurrentToExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignMinInitialSymShCCurrentToExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "AssignMinInitialSymShCCurrentToExternalNetworkInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMinInitialSymShCCurrentToExternalNetworkInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MinInitialSymShCCurrent validation for a ExternalNetworkInjection
   *
   * @param command UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionCommand
   */
  public void validate(UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "UnAssignMinInitialSymShCCurrentFromExternalNetworkInjectionCommand identifier should not be null");
  }
  /**
   * handles assign MinP validation for a ExternalNetworkInjection
   *
   * @param command AssignMinPToExternalNetworkInjectionCommand
   */
  public void validate(AssignMinPToExternalNetworkInjectionCommand command) throws Exception {
    Assert.notNull(command, "AssignMinPToExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "AssignMinPToExternalNetworkInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMinPToExternalNetworkInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MinP validation for a ExternalNetworkInjection
   *
   * @param command UnAssignMinPFromExternalNetworkInjectionCommand
   */
  public void validate(UnAssignMinPFromExternalNetworkInjectionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMinPFromExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "UnAssignMinPFromExternalNetworkInjectionCommand identifier should not be null");
  }
  /**
   * handles assign MinQ validation for a ExternalNetworkInjection
   *
   * @param command AssignMinQToExternalNetworkInjectionCommand
   */
  public void validate(AssignMinQToExternalNetworkInjectionCommand command) throws Exception {
    Assert.notNull(command, "AssignMinQToExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "AssignMinQToExternalNetworkInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMinQToExternalNetworkInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MinQ validation for a ExternalNetworkInjection
   *
   * @param command UnAssignMinQFromExternalNetworkInjectionCommand
   */
  public void validate(UnAssignMinQFromExternalNetworkInjectionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMinQFromExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "UnAssignMinQFromExternalNetworkInjectionCommand identifier should not be null");
  }
  /**
   * handles assign MinR0ToX0Ratio validation for a ExternalNetworkInjection
   *
   * @param command AssignMinR0ToX0RatioToExternalNetworkInjectionCommand
   */
  public void validate(AssignMinR0ToX0RatioToExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignMinR0ToX0RatioToExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "AssignMinR0ToX0RatioToExternalNetworkInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMinR0ToX0RatioToExternalNetworkInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MinR0ToX0Ratio validation for a ExternalNetworkInjection
   *
   * @param command UnAssignMinR0ToX0RatioFromExternalNetworkInjectionCommand
   */
  public void validate(UnAssignMinR0ToX0RatioFromExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignMinR0ToX0RatioFromExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "UnAssignMinR0ToX0RatioFromExternalNetworkInjectionCommand identifier should not be null");
  }
  /**
   * handles assign MinR1ToX1Ratio validation for a ExternalNetworkInjection
   *
   * @param command AssignMinR1ToX1RatioToExternalNetworkInjectionCommand
   */
  public void validate(AssignMinR1ToX1RatioToExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignMinR1ToX1RatioToExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "AssignMinR1ToX1RatioToExternalNetworkInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMinR1ToX1RatioToExternalNetworkInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MinR1ToX1Ratio validation for a ExternalNetworkInjection
   *
   * @param command UnAssignMinR1ToX1RatioFromExternalNetworkInjectionCommand
   */
  public void validate(UnAssignMinR1ToX1RatioFromExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignMinR1ToX1RatioFromExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "UnAssignMinR1ToX1RatioFromExternalNetworkInjectionCommand identifier should not be null");
  }
  /**
   * handles assign MinZ0ToZ1Ratio validation for a ExternalNetworkInjection
   *
   * @param command AssignMinZ0ToZ1RatioToExternalNetworkInjectionCommand
   */
  public void validate(AssignMinZ0ToZ1RatioToExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignMinZ0ToZ1RatioToExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "AssignMinZ0ToZ1RatioToExternalNetworkInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMinZ0ToZ1RatioToExternalNetworkInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign MinZ0ToZ1Ratio validation for a ExternalNetworkInjection
   *
   * @param command UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionCommand
   */
  public void validate(UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "UnAssignMinZ0ToZ1RatioFromExternalNetworkInjectionCommand identifier should not be null");
  }
  /**
   * handles assign VoltageFactor validation for a ExternalNetworkInjection
   *
   * @param command AssignVoltageFactorToExternalNetworkInjectionCommand
   */
  public void validate(AssignVoltageFactorToExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignVoltageFactorToExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "AssignVoltageFactorToExternalNetworkInjectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVoltageFactorToExternalNetworkInjectionCommand assignment should not be null");
  }

  /**
   * handles unassign VoltageFactor validation for a ExternalNetworkInjection
   *
   * @param command UnAssignVoltageFactorFromExternalNetworkInjectionCommand
   */
  public void validate(UnAssignVoltageFactorFromExternalNetworkInjectionCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVoltageFactorFromExternalNetworkInjectionCommand should not be null");
    Assert.notNull(
        command.getExternalNetworkInjectionId(),
        "UnAssignVoltageFactorFromExternalNetworkInjectionCommand identifier should not be null");
  }
}
