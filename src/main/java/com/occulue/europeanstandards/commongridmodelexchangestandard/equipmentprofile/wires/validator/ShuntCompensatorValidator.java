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

public class ShuntCompensatorValidator {

  /** default constructor */
  protected ShuntCompensatorValidator() {}

  /** factory method */
  public static ShuntCompensatorValidator getInstance() {
    return new ShuntCompensatorValidator();
  }

  /** handles creation validation for a ShuntCompensator */
  public void validate(CreateShuntCompensatorCommand shuntCompensator) throws Exception {
    Assert.notNull(shuntCompensator, "CreateShuntCompensatorCommand should not be null");
    //		Assert.isNull( shuntCompensator.getShuntCompensatorId(), "CreateShuntCompensatorCommand
    // identifier should be null" );
  }

  /** handles update validation for a ShuntCompensator */
  public void validate(UpdateShuntCompensatorCommand shuntCompensator) throws Exception {
    Assert.notNull(shuntCompensator, "UpdateShuntCompensatorCommand should not be null");
    Assert.notNull(
        shuntCompensator.getShuntCompensatorId(),
        "UpdateShuntCompensatorCommand identifier should not be null");
  }

  /** handles delete validation for a ShuntCompensator */
  public void validate(DeleteShuntCompensatorCommand shuntCompensator) throws Exception {
    Assert.notNull(shuntCompensator, "{commandAlias} should not be null");
    Assert.notNull(
        shuntCompensator.getShuntCompensatorId(),
        "DeleteShuntCompensatorCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ShuntCompensator */
  public void validate(ShuntCompensatorFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ShuntCompensatorFetchOneSummary should not be null");
    Assert.notNull(
        summary.getShuntCompensatorId(),
        "ShuntCompensatorFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign AVRDelay validation for a ShuntCompensator
   *
   * @param command AssignAVRDelayToShuntCompensatorCommand
   */
  public void validate(AssignAVRDelayToShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignAVRDelayToShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "AssignAVRDelayToShuntCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignAVRDelayToShuntCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign AVRDelay validation for a ShuntCompensator
   *
   * @param command UnAssignAVRDelayFromShuntCompensatorCommand
   */
  public void validate(UnAssignAVRDelayFromShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAVRDelayFromShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "UnAssignAVRDelayFromShuntCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign Grounded validation for a ShuntCompensator
   *
   * @param command AssignGroundedToShuntCompensatorCommand
   */
  public void validate(AssignGroundedToShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignGroundedToShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "AssignGroundedToShuntCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignGroundedToShuntCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign Grounded validation for a ShuntCompensator
   *
   * @param command UnAssignGroundedFromShuntCompensatorCommand
   */
  public void validate(UnAssignGroundedFromShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGroundedFromShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "UnAssignGroundedFromShuntCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign MaximumSections validation for a ShuntCompensator
   *
   * @param command AssignMaximumSectionsToShuntCompensatorCommand
   */
  public void validate(AssignMaximumSectionsToShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignMaximumSectionsToShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "AssignMaximumSectionsToShuntCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaximumSectionsToShuntCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign MaximumSections validation for a ShuntCompensator
   *
   * @param command UnAssignMaximumSectionsFromShuntCompensatorCommand
   */
  public void validate(UnAssignMaximumSectionsFromShuntCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignMaximumSectionsFromShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "UnAssignMaximumSectionsFromShuntCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign NomU validation for a ShuntCompensator
   *
   * @param command AssignNomUToShuntCompensatorCommand
   */
  public void validate(AssignNomUToShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignNomUToShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "AssignNomUToShuntCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNomUToShuntCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign NomU validation for a ShuntCompensator
   *
   * @param command UnAssignNomUFromShuntCompensatorCommand
   */
  public void validate(UnAssignNomUFromShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNomUFromShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "UnAssignNomUFromShuntCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign NormalSections validation for a ShuntCompensator
   *
   * @param command AssignNormalSectionsToShuntCompensatorCommand
   */
  public void validate(AssignNormalSectionsToShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignNormalSectionsToShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "AssignNormalSectionsToShuntCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNormalSectionsToShuntCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign NormalSections validation for a ShuntCompensator
   *
   * @param command UnAssignNormalSectionsFromShuntCompensatorCommand
   */
  public void validate(UnAssignNormalSectionsFromShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNormalSectionsFromShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "UnAssignNormalSectionsFromShuntCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign SwitchOnCount validation for a ShuntCompensator
   *
   * @param command AssignSwitchOnCountToShuntCompensatorCommand
   */
  public void validate(AssignSwitchOnCountToShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignSwitchOnCountToShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "AssignSwitchOnCountToShuntCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSwitchOnCountToShuntCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign SwitchOnCount validation for a ShuntCompensator
   *
   * @param command UnAssignSwitchOnCountFromShuntCompensatorCommand
   */
  public void validate(UnAssignSwitchOnCountFromShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSwitchOnCountFromShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "UnAssignSwitchOnCountFromShuntCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign SwitchOnDate validation for a ShuntCompensator
   *
   * @param command AssignSwitchOnDateToShuntCompensatorCommand
   */
  public void validate(AssignSwitchOnDateToShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignSwitchOnDateToShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "AssignSwitchOnDateToShuntCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSwitchOnDateToShuntCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign SwitchOnDate validation for a ShuntCompensator
   *
   * @param command UnAssignSwitchOnDateFromShuntCompensatorCommand
   */
  public void validate(UnAssignSwitchOnDateFromShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSwitchOnDateFromShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "UnAssignSwitchOnDateFromShuntCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign VoltageSensitivity validation for a ShuntCompensator
   *
   * @param command AssignVoltageSensitivityToShuntCompensatorCommand
   */
  public void validate(AssignVoltageSensitivityToShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignVoltageSensitivityToShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "AssignVoltageSensitivityToShuntCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVoltageSensitivityToShuntCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign VoltageSensitivity validation for a ShuntCompensator
   *
   * @param command UnAssignVoltageSensitivityFromShuntCompensatorCommand
   */
  public void validate(UnAssignVoltageSensitivityFromShuntCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVoltageSensitivityFromShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getShuntCompensatorId(),
        "UnAssignVoltageSensitivityFromShuntCompensatorCommand identifier should not be null");
  }
}
