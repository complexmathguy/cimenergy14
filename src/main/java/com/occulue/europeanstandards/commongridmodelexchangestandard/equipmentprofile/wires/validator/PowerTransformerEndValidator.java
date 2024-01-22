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

public class PowerTransformerEndValidator {

  /** default constructor */
  protected PowerTransformerEndValidator() {}

  /** factory method */
  public static PowerTransformerEndValidator getInstance() {
    return new PowerTransformerEndValidator();
  }

  /** handles creation validation for a PowerTransformerEnd */
  public void validate(CreatePowerTransformerEndCommand powerTransformerEnd) throws Exception {
    Assert.notNull(powerTransformerEnd, "CreatePowerTransformerEndCommand should not be null");
    //		Assert.isNull( powerTransformerEnd.getPowerTransformerEndId(),
    // "CreatePowerTransformerEndCommand identifier should be null" );
  }

  /** handles update validation for a PowerTransformerEnd */
  public void validate(UpdatePowerTransformerEndCommand powerTransformerEnd) throws Exception {
    Assert.notNull(powerTransformerEnd, "UpdatePowerTransformerEndCommand should not be null");
    Assert.notNull(
        powerTransformerEnd.getPowerTransformerEndId(),
        "UpdatePowerTransformerEndCommand identifier should not be null");
  }

  /** handles delete validation for a PowerTransformerEnd */
  public void validate(DeletePowerTransformerEndCommand powerTransformerEnd) throws Exception {
    Assert.notNull(powerTransformerEnd, "{commandAlias} should not be null");
    Assert.notNull(
        powerTransformerEnd.getPowerTransformerEndId(),
        "DeletePowerTransformerEndCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PowerTransformerEnd */
  public void validate(PowerTransformerEndFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PowerTransformerEndFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPowerTransformerEndId(),
        "PowerTransformerEndFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign B validation for a PowerTransformerEnd
   *
   * @param command AssignBToPowerTransformerEndCommand
   */
  public void validate(AssignBToPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignBToPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "AssignBToPowerTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBToPowerTransformerEndCommand assignment should not be null");
  }

  /**
   * handles unassign B validation for a PowerTransformerEnd
   *
   * @param command UnAssignBFromPowerTransformerEndCommand
   */
  public void validate(UnAssignBFromPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBFromPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "UnAssignBFromPowerTransformerEndCommand identifier should not be null");
  }
  /**
   * handles assign B0 validation for a PowerTransformerEnd
   *
   * @param command AssignB0ToPowerTransformerEndCommand
   */
  public void validate(AssignB0ToPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignB0ToPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "AssignB0ToPowerTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignB0ToPowerTransformerEndCommand assignment should not be null");
  }

  /**
   * handles unassign B0 validation for a PowerTransformerEnd
   *
   * @param command UnAssignB0FromPowerTransformerEndCommand
   */
  public void validate(UnAssignB0FromPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "UnAssignB0FromPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "UnAssignB0FromPowerTransformerEndCommand identifier should not be null");
  }
  /**
   * handles assign G validation for a PowerTransformerEnd
   *
   * @param command AssignGToPowerTransformerEndCommand
   */
  public void validate(AssignGToPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignGToPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "AssignGToPowerTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignGToPowerTransformerEndCommand assignment should not be null");
  }

  /**
   * handles unassign G validation for a PowerTransformerEnd
   *
   * @param command UnAssignGFromPowerTransformerEndCommand
   */
  public void validate(UnAssignGFromPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGFromPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "UnAssignGFromPowerTransformerEndCommand identifier should not be null");
  }
  /**
   * handles assign G0 validation for a PowerTransformerEnd
   *
   * @param command AssignG0ToPowerTransformerEndCommand
   */
  public void validate(AssignG0ToPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignG0ToPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "AssignG0ToPowerTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignG0ToPowerTransformerEndCommand assignment should not be null");
  }

  /**
   * handles unassign G0 validation for a PowerTransformerEnd
   *
   * @param command UnAssignG0FromPowerTransformerEndCommand
   */
  public void validate(UnAssignG0FromPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "UnAssignG0FromPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "UnAssignG0FromPowerTransformerEndCommand identifier should not be null");
  }
  /**
   * handles assign PhaseAngleClock validation for a PowerTransformerEnd
   *
   * @param command AssignPhaseAngleClockToPowerTransformerEndCommand
   */
  public void validate(AssignPhaseAngleClockToPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignPhaseAngleClockToPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "AssignPhaseAngleClockToPowerTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPhaseAngleClockToPowerTransformerEndCommand assignment should not be null");
  }

  /**
   * handles unassign PhaseAngleClock validation for a PowerTransformerEnd
   *
   * @param command UnAssignPhaseAngleClockFromPowerTransformerEndCommand
   */
  public void validate(UnAssignPhaseAngleClockFromPowerTransformerEndCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignPhaseAngleClockFromPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "UnAssignPhaseAngleClockFromPowerTransformerEndCommand identifier should not be null");
  }
  /**
   * handles assign R validation for a PowerTransformerEnd
   *
   * @param command AssignRToPowerTransformerEndCommand
   */
  public void validate(AssignRToPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignRToPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "AssignRToPowerTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRToPowerTransformerEndCommand assignment should not be null");
  }

  /**
   * handles unassign R validation for a PowerTransformerEnd
   *
   * @param command UnAssignRFromPowerTransformerEndCommand
   */
  public void validate(UnAssignRFromPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRFromPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "UnAssignRFromPowerTransformerEndCommand identifier should not be null");
  }
  /**
   * handles assign R0 validation for a PowerTransformerEnd
   *
   * @param command AssignR0ToPowerTransformerEndCommand
   */
  public void validate(AssignR0ToPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignR0ToPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "AssignR0ToPowerTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignR0ToPowerTransformerEndCommand assignment should not be null");
  }

  /**
   * handles unassign R0 validation for a PowerTransformerEnd
   *
   * @param command UnAssignR0FromPowerTransformerEndCommand
   */
  public void validate(UnAssignR0FromPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "UnAssignR0FromPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "UnAssignR0FromPowerTransformerEndCommand identifier should not be null");
  }
  /**
   * handles assign RatedS validation for a PowerTransformerEnd
   *
   * @param command AssignRatedSToPowerTransformerEndCommand
   */
  public void validate(AssignRatedSToPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignRatedSToPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "AssignRatedSToPowerTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRatedSToPowerTransformerEndCommand assignment should not be null");
  }

  /**
   * handles unassign RatedS validation for a PowerTransformerEnd
   *
   * @param command UnAssignRatedSFromPowerTransformerEndCommand
   */
  public void validate(UnAssignRatedSFromPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRatedSFromPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "UnAssignRatedSFromPowerTransformerEndCommand identifier should not be null");
  }
  /**
   * handles assign RatedU validation for a PowerTransformerEnd
   *
   * @param command AssignRatedUToPowerTransformerEndCommand
   */
  public void validate(AssignRatedUToPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignRatedUToPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "AssignRatedUToPowerTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRatedUToPowerTransformerEndCommand assignment should not be null");
  }

  /**
   * handles unassign RatedU validation for a PowerTransformerEnd
   *
   * @param command UnAssignRatedUFromPowerTransformerEndCommand
   */
  public void validate(UnAssignRatedUFromPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRatedUFromPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "UnAssignRatedUFromPowerTransformerEndCommand identifier should not be null");
  }
  /**
   * handles assign X validation for a PowerTransformerEnd
   *
   * @param command AssignXToPowerTransformerEndCommand
   */
  public void validate(AssignXToPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignXToPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "AssignXToPowerTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXToPowerTransformerEndCommand assignment should not be null");
  }

  /**
   * handles unassign X validation for a PowerTransformerEnd
   *
   * @param command UnAssignXFromPowerTransformerEndCommand
   */
  public void validate(UnAssignXFromPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXFromPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "UnAssignXFromPowerTransformerEndCommand identifier should not be null");
  }
  /**
   * handles assign X0 validation for a PowerTransformerEnd
   *
   * @param command AssignX0ToPowerTransformerEndCommand
   */
  public void validate(AssignX0ToPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "AssignX0ToPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "AssignX0ToPowerTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignX0ToPowerTransformerEndCommand assignment should not be null");
  }

  /**
   * handles unassign X0 validation for a PowerTransformerEnd
   *
   * @param command UnAssignX0FromPowerTransformerEndCommand
   */
  public void validate(UnAssignX0FromPowerTransformerEndCommand command) throws Exception {
    Assert.notNull(command, "UnAssignX0FromPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "UnAssignX0FromPowerTransformerEndCommand identifier should not be null");
  }

  /**
   * handles add to PowerTransformerEnd validation for a PowerTransformerEnd
   *
   * @param command AssignPowerTransformerEndToPowerTransformerEndCommand
   */
  public void validate(AssignPowerTransformerEndToPowerTransformerEndCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignPowerTransformerEndToPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "AssignPowerTransformerEndToPowerTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignPowerTransformerEndToPowerTransformerEndCommand addTo attribute should not be null");
  }

  /**
   * handles remove from PowerTransformerEnd validation for a PowerTransformerEnd
   *
   * @param command RemovePowerTransformerEndFromPowerTransformerEndCommand
   */
  public void validate(RemovePowerTransformerEndFromPowerTransformerEndCommand command)
      throws Exception {
    Assert.notNull(
        command, "RemovePowerTransformerEndFromPowerTransformerEndCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerEndId(),
        "RemovePowerTransformerEndFromPowerTransformerEndCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemovePowerTransformerEndFromPowerTransformerEndCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getPowerTransformerEndId(),
        "RemovePowerTransformerEndFromPowerTransformerEndCommand removeFrom attribubte identifier should not be null");
  }
}
