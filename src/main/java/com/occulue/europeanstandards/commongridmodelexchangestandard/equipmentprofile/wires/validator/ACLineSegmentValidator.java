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

public class ACLineSegmentValidator {

  /** default constructor */
  protected ACLineSegmentValidator() {}

  /** factory method */
  public static ACLineSegmentValidator getInstance() {
    return new ACLineSegmentValidator();
  }

  /** handles creation validation for a ACLineSegment */
  public void validate(CreateACLineSegmentCommand aCLineSegment) throws Exception {
    Assert.notNull(aCLineSegment, "CreateACLineSegmentCommand should not be null");
    //		Assert.isNull( aCLineSegment.getACLineSegmentId(), "CreateACLineSegmentCommand identifier
    // should be null" );
  }

  /** handles update validation for a ACLineSegment */
  public void validate(UpdateACLineSegmentCommand aCLineSegment) throws Exception {
    Assert.notNull(aCLineSegment, "UpdateACLineSegmentCommand should not be null");
    Assert.notNull(
        aCLineSegment.getACLineSegmentId(),
        "UpdateACLineSegmentCommand identifier should not be null");
  }

  /** handles delete validation for a ACLineSegment */
  public void validate(DeleteACLineSegmentCommand aCLineSegment) throws Exception {
    Assert.notNull(aCLineSegment, "{commandAlias} should not be null");
    Assert.notNull(
        aCLineSegment.getACLineSegmentId(),
        "DeleteACLineSegmentCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ACLineSegment */
  public void validate(ACLineSegmentFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ACLineSegmentFetchOneSummary should not be null");
    Assert.notNull(
        summary.getACLineSegmentId(), "ACLineSegmentFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign B0ch validation for a ACLineSegment
   *
   * @param command AssignB0chToACLineSegmentCommand
   */
  public void validate(AssignB0chToACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "AssignB0chToACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "AssignB0chToACLineSegmentCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignB0chToACLineSegmentCommand assignment should not be null");
  }

  /**
   * handles unassign B0ch validation for a ACLineSegment
   *
   * @param command UnAssignB0chFromACLineSegmentCommand
   */
  public void validate(UnAssignB0chFromACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "UnAssignB0chFromACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "UnAssignB0chFromACLineSegmentCommand identifier should not be null");
  }
  /**
   * handles assign Bch validation for a ACLineSegment
   *
   * @param command AssignBchToACLineSegmentCommand
   */
  public void validate(AssignBchToACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "AssignBchToACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "AssignBchToACLineSegmentCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBchToACLineSegmentCommand assignment should not be null");
  }

  /**
   * handles unassign Bch validation for a ACLineSegment
   *
   * @param command UnAssignBchFromACLineSegmentCommand
   */
  public void validate(UnAssignBchFromACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBchFromACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "UnAssignBchFromACLineSegmentCommand identifier should not be null");
  }
  /**
   * handles assign G0ch validation for a ACLineSegment
   *
   * @param command AssignG0chToACLineSegmentCommand
   */
  public void validate(AssignG0chToACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "AssignG0chToACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "AssignG0chToACLineSegmentCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignG0chToACLineSegmentCommand assignment should not be null");
  }

  /**
   * handles unassign G0ch validation for a ACLineSegment
   *
   * @param command UnAssignG0chFromACLineSegmentCommand
   */
  public void validate(UnAssignG0chFromACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "UnAssignG0chFromACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "UnAssignG0chFromACLineSegmentCommand identifier should not be null");
  }
  /**
   * handles assign Gch validation for a ACLineSegment
   *
   * @param command AssignGchToACLineSegmentCommand
   */
  public void validate(AssignGchToACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "AssignGchToACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "AssignGchToACLineSegmentCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGchToACLineSegmentCommand assignment should not be null");
  }

  /**
   * handles unassign Gch validation for a ACLineSegment
   *
   * @param command UnAssignGchFromACLineSegmentCommand
   */
  public void validate(UnAssignGchFromACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGchFromACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "UnAssignGchFromACLineSegmentCommand identifier should not be null");
  }
  /**
   * handles assign R validation for a ACLineSegment
   *
   * @param command AssignRToACLineSegmentCommand
   */
  public void validate(AssignRToACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "AssignRToACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "AssignRToACLineSegmentCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRToACLineSegmentCommand assignment should not be null");
  }

  /**
   * handles unassign R validation for a ACLineSegment
   *
   * @param command UnAssignRFromACLineSegmentCommand
   */
  public void validate(UnAssignRFromACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRFromACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "UnAssignRFromACLineSegmentCommand identifier should not be null");
  }
  /**
   * handles assign R0 validation for a ACLineSegment
   *
   * @param command AssignR0ToACLineSegmentCommand
   */
  public void validate(AssignR0ToACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "AssignR0ToACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "AssignR0ToACLineSegmentCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignR0ToACLineSegmentCommand assignment should not be null");
  }

  /**
   * handles unassign R0 validation for a ACLineSegment
   *
   * @param command UnAssignR0FromACLineSegmentCommand
   */
  public void validate(UnAssignR0FromACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "UnAssignR0FromACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "UnAssignR0FromACLineSegmentCommand identifier should not be null");
  }
  /**
   * handles assign ShortCircuitEndTemperature validation for a ACLineSegment
   *
   * @param command AssignShortCircuitEndTemperatureToACLineSegmentCommand
   */
  public void validate(AssignShortCircuitEndTemperatureToACLineSegmentCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignShortCircuitEndTemperatureToACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "AssignShortCircuitEndTemperatureToACLineSegmentCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignShortCircuitEndTemperatureToACLineSegmentCommand assignment should not be null");
  }

  /**
   * handles unassign ShortCircuitEndTemperature validation for a ACLineSegment
   *
   * @param command UnAssignShortCircuitEndTemperatureFromACLineSegmentCommand
   */
  public void validate(UnAssignShortCircuitEndTemperatureFromACLineSegmentCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignShortCircuitEndTemperatureFromACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "UnAssignShortCircuitEndTemperatureFromACLineSegmentCommand identifier should not be null");
  }
  /**
   * handles assign X validation for a ACLineSegment
   *
   * @param command AssignXToACLineSegmentCommand
   */
  public void validate(AssignXToACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "AssignXToACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "AssignXToACLineSegmentCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXToACLineSegmentCommand assignment should not be null");
  }

  /**
   * handles unassign X validation for a ACLineSegment
   *
   * @param command UnAssignXFromACLineSegmentCommand
   */
  public void validate(UnAssignXFromACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXFromACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "UnAssignXFromACLineSegmentCommand identifier should not be null");
  }
  /**
   * handles assign X0 validation for a ACLineSegment
   *
   * @param command AssignX0ToACLineSegmentCommand
   */
  public void validate(AssignX0ToACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "AssignX0ToACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "AssignX0ToACLineSegmentCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignX0ToACLineSegmentCommand assignment should not be null");
  }

  /**
   * handles unassign X0 validation for a ACLineSegment
   *
   * @param command UnAssignX0FromACLineSegmentCommand
   */
  public void validate(UnAssignX0FromACLineSegmentCommand command) throws Exception {
    Assert.notNull(command, "UnAssignX0FromACLineSegmentCommand should not be null");
    Assert.notNull(
        command.getACLineSegmentId(),
        "UnAssignX0FromACLineSegmentCommand identifier should not be null");
  }
}
