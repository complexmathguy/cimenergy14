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

public class PowerTransformerValidator {

  /** default constructor */
  protected PowerTransformerValidator() {}

  /** factory method */
  public static PowerTransformerValidator getInstance() {
    return new PowerTransformerValidator();
  }

  /** handles creation validation for a PowerTransformer */
  public void validate(CreatePowerTransformerCommand powerTransformer) throws Exception {
    Assert.notNull(powerTransformer, "CreatePowerTransformerCommand should not be null");
    //		Assert.isNull( powerTransformer.getPowerTransformerId(), "CreatePowerTransformerCommand
    // identifier should be null" );
  }

  /** handles update validation for a PowerTransformer */
  public void validate(UpdatePowerTransformerCommand powerTransformer) throws Exception {
    Assert.notNull(powerTransformer, "UpdatePowerTransformerCommand should not be null");
    Assert.notNull(
        powerTransformer.getPowerTransformerId(),
        "UpdatePowerTransformerCommand identifier should not be null");
  }

  /** handles delete validation for a PowerTransformer */
  public void validate(DeletePowerTransformerCommand powerTransformer) throws Exception {
    Assert.notNull(powerTransformer, "{commandAlias} should not be null");
    Assert.notNull(
        powerTransformer.getPowerTransformerId(),
        "DeletePowerTransformerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PowerTransformer */
  public void validate(PowerTransformerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PowerTransformerFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPowerTransformerId(),
        "PowerTransformerFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BeforeShCircuitHighestOperatingCurrent validation for a PowerTransformer
   *
   * @param command AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerCommand
   */
  public void validate(
      AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerId(),
        "AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBeforeShCircuitHighestOperatingCurrentToPowerTransformerCommand assignment should not be null");
  }

  /**
   * handles unassign BeforeShCircuitHighestOperatingCurrent validation for a PowerTransformer
   *
   * @param command UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerCommand
   */
  public void validate(
      UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerId(),
        "UnAssignBeforeShCircuitHighestOperatingCurrentFromPowerTransformerCommand identifier should not be null");
  }
  /**
   * handles assign BeforeShCircuitHighestOperatingVoltage validation for a PowerTransformer
   *
   * @param command AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerCommand
   */
  public void validate(
      AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerId(),
        "AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBeforeShCircuitHighestOperatingVoltageToPowerTransformerCommand assignment should not be null");
  }

  /**
   * handles unassign BeforeShCircuitHighestOperatingVoltage validation for a PowerTransformer
   *
   * @param command UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerCommand
   */
  public void validate(
      UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerId(),
        "UnAssignBeforeShCircuitHighestOperatingVoltageFromPowerTransformerCommand identifier should not be null");
  }
  /**
   * handles assign BeforeShortCircuitAnglePf validation for a PowerTransformer
   *
   * @param command AssignBeforeShortCircuitAnglePfToPowerTransformerCommand
   */
  public void validate(AssignBeforeShortCircuitAnglePfToPowerTransformerCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignBeforeShortCircuitAnglePfToPowerTransformerCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerId(),
        "AssignBeforeShortCircuitAnglePfToPowerTransformerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBeforeShortCircuitAnglePfToPowerTransformerCommand assignment should not be null");
  }

  /**
   * handles unassign BeforeShortCircuitAnglePf validation for a PowerTransformer
   *
   * @param command UnAssignBeforeShortCircuitAnglePfFromPowerTransformerCommand
   */
  public void validate(UnAssignBeforeShortCircuitAnglePfFromPowerTransformerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignBeforeShortCircuitAnglePfFromPowerTransformerCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerId(),
        "UnAssignBeforeShortCircuitAnglePfFromPowerTransformerCommand identifier should not be null");
  }
  /**
   * handles assign HighSideMinOperatingU validation for a PowerTransformer
   *
   * @param command AssignHighSideMinOperatingUToPowerTransformerCommand
   */
  public void validate(AssignHighSideMinOperatingUToPowerTransformerCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignHighSideMinOperatingUToPowerTransformerCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerId(),
        "AssignHighSideMinOperatingUToPowerTransformerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignHighSideMinOperatingUToPowerTransformerCommand assignment should not be null");
  }

  /**
   * handles unassign HighSideMinOperatingU validation for a PowerTransformer
   *
   * @param command UnAssignHighSideMinOperatingUFromPowerTransformerCommand
   */
  public void validate(UnAssignHighSideMinOperatingUFromPowerTransformerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignHighSideMinOperatingUFromPowerTransformerCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerId(),
        "UnAssignHighSideMinOperatingUFromPowerTransformerCommand identifier should not be null");
  }
  /**
   * handles assign PartOfGeneratorUnitFlag validation for a PowerTransformer
   *
   * @param command AssignPartOfGeneratorUnitFlagToPowerTransformerCommand
   */
  public void validate(AssignPartOfGeneratorUnitFlagToPowerTransformerCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignPartOfGeneratorUnitFlagToPowerTransformerCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerId(),
        "AssignPartOfGeneratorUnitFlagToPowerTransformerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPartOfGeneratorUnitFlagToPowerTransformerCommand assignment should not be null");
  }

  /**
   * handles unassign PartOfGeneratorUnitFlag validation for a PowerTransformer
   *
   * @param command UnAssignPartOfGeneratorUnitFlagFromPowerTransformerCommand
   */
  public void validate(UnAssignPartOfGeneratorUnitFlagFromPowerTransformerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignPartOfGeneratorUnitFlagFromPowerTransformerCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerId(),
        "UnAssignPartOfGeneratorUnitFlagFromPowerTransformerCommand identifier should not be null");
  }
  /**
   * handles assign OperationalValuesConsidered validation for a PowerTransformer
   *
   * @param command AssignOperationalValuesConsideredToPowerTransformerCommand
   */
  public void validate(AssignOperationalValuesConsideredToPowerTransformerCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignOperationalValuesConsideredToPowerTransformerCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerId(),
        "AssignOperationalValuesConsideredToPowerTransformerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOperationalValuesConsideredToPowerTransformerCommand assignment should not be null");
  }

  /**
   * handles unassign OperationalValuesConsidered validation for a PowerTransformer
   *
   * @param command UnAssignOperationalValuesConsideredFromPowerTransformerCommand
   */
  public void validate(UnAssignOperationalValuesConsideredFromPowerTransformerCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignOperationalValuesConsideredFromPowerTransformerCommand should not be null");
    Assert.notNull(
        command.getPowerTransformerId(),
        "UnAssignOperationalValuesConsideredFromPowerTransformerCommand identifier should not be null");
  }
}
