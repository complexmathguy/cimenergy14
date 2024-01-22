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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class GeneratingUnitValidator {

  /** default constructor */
  protected GeneratingUnitValidator() {}

  /** factory method */
  public static GeneratingUnitValidator getInstance() {
    return new GeneratingUnitValidator();
  }

  /** handles creation validation for a GeneratingUnit */
  public void validate(CreateGeneratingUnitCommand generatingUnit) throws Exception {
    Assert.notNull(generatingUnit, "CreateGeneratingUnitCommand should not be null");
    //		Assert.isNull( generatingUnit.getGeneratingUnitId(), "CreateGeneratingUnitCommand identifier
    // should be null" );
  }

  /** handles update validation for a GeneratingUnit */
  public void validate(UpdateGeneratingUnitCommand generatingUnit) throws Exception {
    Assert.notNull(generatingUnit, "UpdateGeneratingUnitCommand should not be null");
    Assert.notNull(
        generatingUnit.getGeneratingUnitId(),
        "UpdateGeneratingUnitCommand identifier should not be null");
  }

  /** handles delete validation for a GeneratingUnit */
  public void validate(DeleteGeneratingUnitCommand generatingUnit) throws Exception {
    Assert.notNull(generatingUnit, "{commandAlias} should not be null");
    Assert.notNull(
        generatingUnit.getGeneratingUnitId(),
        "DeleteGeneratingUnitCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GeneratingUnit */
  public void validate(GeneratingUnitFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GeneratingUnitFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGeneratingUnitId(),
        "GeneratingUnitFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign GovernorSCD validation for a GeneratingUnit
   *
   * @param command AssignGovernorSCDToGeneratingUnitCommand
   */
  public void validate(AssignGovernorSCDToGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "AssignGovernorSCDToGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "AssignGovernorSCDToGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignGovernorSCDToGeneratingUnitCommand assignment should not be null");
  }

  /**
   * handles unassign GovernorSCD validation for a GeneratingUnit
   *
   * @param command UnAssignGovernorSCDFromGeneratingUnitCommand
   */
  public void validate(UnAssignGovernorSCDFromGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGovernorSCDFromGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "UnAssignGovernorSCDFromGeneratingUnitCommand identifier should not be null");
  }
  /**
   * handles assign InitialP validation for a GeneratingUnit
   *
   * @param command AssignInitialPToGeneratingUnitCommand
   */
  public void validate(AssignInitialPToGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "AssignInitialPToGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "AssignInitialPToGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignInitialPToGeneratingUnitCommand assignment should not be null");
  }

  /**
   * handles unassign InitialP validation for a GeneratingUnit
   *
   * @param command UnAssignInitialPFromGeneratingUnitCommand
   */
  public void validate(UnAssignInitialPFromGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignInitialPFromGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "UnAssignInitialPFromGeneratingUnitCommand identifier should not be null");
  }
  /**
   * handles assign LongPF validation for a GeneratingUnit
   *
   * @param command AssignLongPFToGeneratingUnitCommand
   */
  public void validate(AssignLongPFToGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "AssignLongPFToGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "AssignLongPFToGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignLongPFToGeneratingUnitCommand assignment should not be null");
  }

  /**
   * handles unassign LongPF validation for a GeneratingUnit
   *
   * @param command UnAssignLongPFFromGeneratingUnitCommand
   */
  public void validate(UnAssignLongPFFromGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLongPFFromGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "UnAssignLongPFFromGeneratingUnitCommand identifier should not be null");
  }
  /**
   * handles assign MaximumAllowableSpinningReserve validation for a GeneratingUnit
   *
   * @param command AssignMaximumAllowableSpinningReserveToGeneratingUnitCommand
   */
  public void validate(AssignMaximumAllowableSpinningReserveToGeneratingUnitCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignMaximumAllowableSpinningReserveToGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "AssignMaximumAllowableSpinningReserveToGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaximumAllowableSpinningReserveToGeneratingUnitCommand assignment should not be null");
  }

  /**
   * handles unassign MaximumAllowableSpinningReserve validation for a GeneratingUnit
   *
   * @param command UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitCommand
   */
  public void validate(UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitCommand identifier should not be null");
  }
  /**
   * handles assign MaxOperatingP validation for a GeneratingUnit
   *
   * @param command AssignMaxOperatingPToGeneratingUnitCommand
   */
  public void validate(AssignMaxOperatingPToGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "AssignMaxOperatingPToGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "AssignMaxOperatingPToGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxOperatingPToGeneratingUnitCommand assignment should not be null");
  }

  /**
   * handles unassign MaxOperatingP validation for a GeneratingUnit
   *
   * @param command UnAssignMaxOperatingPFromGeneratingUnitCommand
   */
  public void validate(UnAssignMaxOperatingPFromGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMaxOperatingPFromGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "UnAssignMaxOperatingPFromGeneratingUnitCommand identifier should not be null");
  }
  /**
   * handles assign MinOperatingP validation for a GeneratingUnit
   *
   * @param command AssignMinOperatingPToGeneratingUnitCommand
   */
  public void validate(AssignMinOperatingPToGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "AssignMinOperatingPToGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "AssignMinOperatingPToGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMinOperatingPToGeneratingUnitCommand assignment should not be null");
  }

  /**
   * handles unassign MinOperatingP validation for a GeneratingUnit
   *
   * @param command UnAssignMinOperatingPFromGeneratingUnitCommand
   */
  public void validate(UnAssignMinOperatingPFromGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMinOperatingPFromGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "UnAssignMinOperatingPFromGeneratingUnitCommand identifier should not be null");
  }
  /**
   * handles assign NominalP validation for a GeneratingUnit
   *
   * @param command AssignNominalPToGeneratingUnitCommand
   */
  public void validate(AssignNominalPToGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "AssignNominalPToGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "AssignNominalPToGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNominalPToGeneratingUnitCommand assignment should not be null");
  }

  /**
   * handles unassign NominalP validation for a GeneratingUnit
   *
   * @param command UnAssignNominalPFromGeneratingUnitCommand
   */
  public void validate(UnAssignNominalPFromGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNominalPFromGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "UnAssignNominalPFromGeneratingUnitCommand identifier should not be null");
  }
  /**
   * handles assign RatedGrossMaxP validation for a GeneratingUnit
   *
   * @param command AssignRatedGrossMaxPToGeneratingUnitCommand
   */
  public void validate(AssignRatedGrossMaxPToGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "AssignRatedGrossMaxPToGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "AssignRatedGrossMaxPToGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRatedGrossMaxPToGeneratingUnitCommand assignment should not be null");
  }

  /**
   * handles unassign RatedGrossMaxP validation for a GeneratingUnit
   *
   * @param command UnAssignRatedGrossMaxPFromGeneratingUnitCommand
   */
  public void validate(UnAssignRatedGrossMaxPFromGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRatedGrossMaxPFromGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "UnAssignRatedGrossMaxPFromGeneratingUnitCommand identifier should not be null");
  }
  /**
   * handles assign RatedGrossMinP validation for a GeneratingUnit
   *
   * @param command AssignRatedGrossMinPToGeneratingUnitCommand
   */
  public void validate(AssignRatedGrossMinPToGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "AssignRatedGrossMinPToGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "AssignRatedGrossMinPToGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRatedGrossMinPToGeneratingUnitCommand assignment should not be null");
  }

  /**
   * handles unassign RatedGrossMinP validation for a GeneratingUnit
   *
   * @param command UnAssignRatedGrossMinPFromGeneratingUnitCommand
   */
  public void validate(UnAssignRatedGrossMinPFromGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRatedGrossMinPFromGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "UnAssignRatedGrossMinPFromGeneratingUnitCommand identifier should not be null");
  }
  /**
   * handles assign RatedNetMaxP validation for a GeneratingUnit
   *
   * @param command AssignRatedNetMaxPToGeneratingUnitCommand
   */
  public void validate(AssignRatedNetMaxPToGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "AssignRatedNetMaxPToGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "AssignRatedNetMaxPToGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRatedNetMaxPToGeneratingUnitCommand assignment should not be null");
  }

  /**
   * handles unassign RatedNetMaxP validation for a GeneratingUnit
   *
   * @param command UnAssignRatedNetMaxPFromGeneratingUnitCommand
   */
  public void validate(UnAssignRatedNetMaxPFromGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRatedNetMaxPFromGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "UnAssignRatedNetMaxPFromGeneratingUnitCommand identifier should not be null");
  }
  /**
   * handles assign ShortPF validation for a GeneratingUnit
   *
   * @param command AssignShortPFToGeneratingUnitCommand
   */
  public void validate(AssignShortPFToGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "AssignShortPFToGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "AssignShortPFToGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignShortPFToGeneratingUnitCommand assignment should not be null");
  }

  /**
   * handles unassign ShortPF validation for a GeneratingUnit
   *
   * @param command UnAssignShortPFFromGeneratingUnitCommand
   */
  public void validate(UnAssignShortPFFromGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignShortPFFromGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "UnAssignShortPFFromGeneratingUnitCommand identifier should not be null");
  }
  /**
   * handles assign StartupCost validation for a GeneratingUnit
   *
   * @param command AssignStartupCostToGeneratingUnitCommand
   */
  public void validate(AssignStartupCostToGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "AssignStartupCostToGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "AssignStartupCostToGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignStartupCostToGeneratingUnitCommand assignment should not be null");
  }

  /**
   * handles unassign StartupCost validation for a GeneratingUnit
   *
   * @param command UnAssignStartupCostFromGeneratingUnitCommand
   */
  public void validate(UnAssignStartupCostFromGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignStartupCostFromGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "UnAssignStartupCostFromGeneratingUnitCommand identifier should not be null");
  }
  /**
   * handles assign TotalEfficiency validation for a GeneratingUnit
   *
   * @param command AssignTotalEfficiencyToGeneratingUnitCommand
   */
  public void validate(AssignTotalEfficiencyToGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "AssignTotalEfficiencyToGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "AssignTotalEfficiencyToGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTotalEfficiencyToGeneratingUnitCommand assignment should not be null");
  }

  /**
   * handles unassign TotalEfficiency validation for a GeneratingUnit
   *
   * @param command UnAssignTotalEfficiencyFromGeneratingUnitCommand
   */
  public void validate(UnAssignTotalEfficiencyFromGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTotalEfficiencyFromGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "UnAssignTotalEfficiencyFromGeneratingUnitCommand identifier should not be null");
  }
  /**
   * handles assign VariableCost validation for a GeneratingUnit
   *
   * @param command AssignVariableCostToGeneratingUnitCommand
   */
  public void validate(AssignVariableCostToGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "AssignVariableCostToGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "AssignVariableCostToGeneratingUnitCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVariableCostToGeneratingUnitCommand assignment should not be null");
  }

  /**
   * handles unassign VariableCost validation for a GeneratingUnit
   *
   * @param command UnAssignVariableCostFromGeneratingUnitCommand
   */
  public void validate(UnAssignVariableCostFromGeneratingUnitCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVariableCostFromGeneratingUnitCommand should not be null");
    Assert.notNull(
        command.getGeneratingUnitId(),
        "UnAssignVariableCostFromGeneratingUnitCommand identifier should not be null");
  }
}
