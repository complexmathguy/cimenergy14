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

public class SeriesCompensatorValidator {

  /** default constructor */
  protected SeriesCompensatorValidator() {}

  /** factory method */
  public static SeriesCompensatorValidator getInstance() {
    return new SeriesCompensatorValidator();
  }

  /** handles creation validation for a SeriesCompensator */
  public void validate(CreateSeriesCompensatorCommand seriesCompensator) throws Exception {
    Assert.notNull(seriesCompensator, "CreateSeriesCompensatorCommand should not be null");
    //		Assert.isNull( seriesCompensator.getSeriesCompensatorId(), "CreateSeriesCompensatorCommand
    // identifier should be null" );
  }

  /** handles update validation for a SeriesCompensator */
  public void validate(UpdateSeriesCompensatorCommand seriesCompensator) throws Exception {
    Assert.notNull(seriesCompensator, "UpdateSeriesCompensatorCommand should not be null");
    Assert.notNull(
        seriesCompensator.getSeriesCompensatorId(),
        "UpdateSeriesCompensatorCommand identifier should not be null");
  }

  /** handles delete validation for a SeriesCompensator */
  public void validate(DeleteSeriesCompensatorCommand seriesCompensator) throws Exception {
    Assert.notNull(seriesCompensator, "{commandAlias} should not be null");
    Assert.notNull(
        seriesCompensator.getSeriesCompensatorId(),
        "DeleteSeriesCompensatorCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SeriesCompensator */
  public void validate(SeriesCompensatorFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SeriesCompensatorFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSeriesCompensatorId(),
        "SeriesCompensatorFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign R validation for a SeriesCompensator
   *
   * @param command AssignRToSeriesCompensatorCommand
   */
  public void validate(AssignRToSeriesCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignRToSeriesCompensatorCommand should not be null");
    Assert.notNull(
        command.getSeriesCompensatorId(),
        "AssignRToSeriesCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRToSeriesCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign R validation for a SeriesCompensator
   *
   * @param command UnAssignRFromSeriesCompensatorCommand
   */
  public void validate(UnAssignRFromSeriesCompensatorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRFromSeriesCompensatorCommand should not be null");
    Assert.notNull(
        command.getSeriesCompensatorId(),
        "UnAssignRFromSeriesCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign R0 validation for a SeriesCompensator
   *
   * @param command AssignR0ToSeriesCompensatorCommand
   */
  public void validate(AssignR0ToSeriesCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignR0ToSeriesCompensatorCommand should not be null");
    Assert.notNull(
        command.getSeriesCompensatorId(),
        "AssignR0ToSeriesCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignR0ToSeriesCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign R0 validation for a SeriesCompensator
   *
   * @param command UnAssignR0FromSeriesCompensatorCommand
   */
  public void validate(UnAssignR0FromSeriesCompensatorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignR0FromSeriesCompensatorCommand should not be null");
    Assert.notNull(
        command.getSeriesCompensatorId(),
        "UnAssignR0FromSeriesCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign VaristorPresent validation for a SeriesCompensator
   *
   * @param command AssignVaristorPresentToSeriesCompensatorCommand
   */
  public void validate(AssignVaristorPresentToSeriesCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignVaristorPresentToSeriesCompensatorCommand should not be null");
    Assert.notNull(
        command.getSeriesCompensatorId(),
        "AssignVaristorPresentToSeriesCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVaristorPresentToSeriesCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign VaristorPresent validation for a SeriesCompensator
   *
   * @param command UnAssignVaristorPresentFromSeriesCompensatorCommand
   */
  public void validate(UnAssignVaristorPresentFromSeriesCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVaristorPresentFromSeriesCompensatorCommand should not be null");
    Assert.notNull(
        command.getSeriesCompensatorId(),
        "UnAssignVaristorPresentFromSeriesCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign VaristorRatedCurrent validation for a SeriesCompensator
   *
   * @param command AssignVaristorRatedCurrentToSeriesCompensatorCommand
   */
  public void validate(AssignVaristorRatedCurrentToSeriesCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignVaristorRatedCurrentToSeriesCompensatorCommand should not be null");
    Assert.notNull(
        command.getSeriesCompensatorId(),
        "AssignVaristorRatedCurrentToSeriesCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVaristorRatedCurrentToSeriesCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign VaristorRatedCurrent validation for a SeriesCompensator
   *
   * @param command UnAssignVaristorRatedCurrentFromSeriesCompensatorCommand
   */
  public void validate(UnAssignVaristorRatedCurrentFromSeriesCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVaristorRatedCurrentFromSeriesCompensatorCommand should not be null");
    Assert.notNull(
        command.getSeriesCompensatorId(),
        "UnAssignVaristorRatedCurrentFromSeriesCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign VaristorVoltageThreshold validation for a SeriesCompensator
   *
   * @param command AssignVaristorVoltageThresholdToSeriesCompensatorCommand
   */
  public void validate(AssignVaristorVoltageThresholdToSeriesCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignVaristorVoltageThresholdToSeriesCompensatorCommand should not be null");
    Assert.notNull(
        command.getSeriesCompensatorId(),
        "AssignVaristorVoltageThresholdToSeriesCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVaristorVoltageThresholdToSeriesCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign VaristorVoltageThreshold validation for a SeriesCompensator
   *
   * @param command UnAssignVaristorVoltageThresholdFromSeriesCompensatorCommand
   */
  public void validate(UnAssignVaristorVoltageThresholdFromSeriesCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVaristorVoltageThresholdFromSeriesCompensatorCommand should not be null");
    Assert.notNull(
        command.getSeriesCompensatorId(),
        "UnAssignVaristorVoltageThresholdFromSeriesCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign X validation for a SeriesCompensator
   *
   * @param command AssignXToSeriesCompensatorCommand
   */
  public void validate(AssignXToSeriesCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignXToSeriesCompensatorCommand should not be null");
    Assert.notNull(
        command.getSeriesCompensatorId(),
        "AssignXToSeriesCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXToSeriesCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign X validation for a SeriesCompensator
   *
   * @param command UnAssignXFromSeriesCompensatorCommand
   */
  public void validate(UnAssignXFromSeriesCompensatorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXFromSeriesCompensatorCommand should not be null");
    Assert.notNull(
        command.getSeriesCompensatorId(),
        "UnAssignXFromSeriesCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign X0 validation for a SeriesCompensator
   *
   * @param command AssignX0ToSeriesCompensatorCommand
   */
  public void validate(AssignX0ToSeriesCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignX0ToSeriesCompensatorCommand should not be null");
    Assert.notNull(
        command.getSeriesCompensatorId(),
        "AssignX0ToSeriesCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignX0ToSeriesCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign X0 validation for a SeriesCompensator
   *
   * @param command UnAssignX0FromSeriesCompensatorCommand
   */
  public void validate(UnAssignX0FromSeriesCompensatorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignX0FromSeriesCompensatorCommand should not be null");
    Assert.notNull(
        command.getSeriesCompensatorId(),
        "UnAssignX0FromSeriesCompensatorCommand identifier should not be null");
  }
}
