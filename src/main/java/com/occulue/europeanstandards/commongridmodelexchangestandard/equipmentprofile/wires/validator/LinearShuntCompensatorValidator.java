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

public class LinearShuntCompensatorValidator {

  /** default constructor */
  protected LinearShuntCompensatorValidator() {}

  /** factory method */
  public static LinearShuntCompensatorValidator getInstance() {
    return new LinearShuntCompensatorValidator();
  }

  /** handles creation validation for a LinearShuntCompensator */
  public void validate(CreateLinearShuntCompensatorCommand linearShuntCompensator)
      throws Exception {
    Assert.notNull(
        linearShuntCompensator, "CreateLinearShuntCompensatorCommand should not be null");
    //		Assert.isNull( linearShuntCompensator.getLinearShuntCompensatorId(),
    // "CreateLinearShuntCompensatorCommand identifier should be null" );
  }

  /** handles update validation for a LinearShuntCompensator */
  public void validate(UpdateLinearShuntCompensatorCommand linearShuntCompensator)
      throws Exception {
    Assert.notNull(
        linearShuntCompensator, "UpdateLinearShuntCompensatorCommand should not be null");
    Assert.notNull(
        linearShuntCompensator.getLinearShuntCompensatorId(),
        "UpdateLinearShuntCompensatorCommand identifier should not be null");
  }

  /** handles delete validation for a LinearShuntCompensator */
  public void validate(DeleteLinearShuntCompensatorCommand linearShuntCompensator)
      throws Exception {
    Assert.notNull(linearShuntCompensator, "{commandAlias} should not be null");
    Assert.notNull(
        linearShuntCompensator.getLinearShuntCompensatorId(),
        "DeleteLinearShuntCompensatorCommand identifier should not be null");
  }

  /** handles fetchOne validation for a LinearShuntCompensator */
  public void validate(LinearShuntCompensatorFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "LinearShuntCompensatorFetchOneSummary should not be null");
    Assert.notNull(
        summary.getLinearShuntCompensatorId(),
        "LinearShuntCompensatorFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign B0PerSection validation for a LinearShuntCompensator
   *
   * @param command AssignB0PerSectionToLinearShuntCompensatorCommand
   */
  public void validate(AssignB0PerSectionToLinearShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignB0PerSectionToLinearShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getLinearShuntCompensatorId(),
        "AssignB0PerSectionToLinearShuntCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignB0PerSectionToLinearShuntCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign B0PerSection validation for a LinearShuntCompensator
   *
   * @param command UnAssignB0PerSectionFromLinearShuntCompensatorCommand
   */
  public void validate(UnAssignB0PerSectionFromLinearShuntCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignB0PerSectionFromLinearShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getLinearShuntCompensatorId(),
        "UnAssignB0PerSectionFromLinearShuntCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign BPerSection validation for a LinearShuntCompensator
   *
   * @param command AssignBPerSectionToLinearShuntCompensatorCommand
   */
  public void validate(AssignBPerSectionToLinearShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignBPerSectionToLinearShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getLinearShuntCompensatorId(),
        "AssignBPerSectionToLinearShuntCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBPerSectionToLinearShuntCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign BPerSection validation for a LinearShuntCompensator
   *
   * @param command UnAssignBPerSectionFromLinearShuntCompensatorCommand
   */
  public void validate(UnAssignBPerSectionFromLinearShuntCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignBPerSectionFromLinearShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getLinearShuntCompensatorId(),
        "UnAssignBPerSectionFromLinearShuntCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign G0PerSection validation for a LinearShuntCompensator
   *
   * @param command AssignG0PerSectionToLinearShuntCompensatorCommand
   */
  public void validate(AssignG0PerSectionToLinearShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignG0PerSectionToLinearShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getLinearShuntCompensatorId(),
        "AssignG0PerSectionToLinearShuntCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignG0PerSectionToLinearShuntCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign G0PerSection validation for a LinearShuntCompensator
   *
   * @param command UnAssignG0PerSectionFromLinearShuntCompensatorCommand
   */
  public void validate(UnAssignG0PerSectionFromLinearShuntCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignG0PerSectionFromLinearShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getLinearShuntCompensatorId(),
        "UnAssignG0PerSectionFromLinearShuntCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign GPerSection validation for a LinearShuntCompensator
   *
   * @param command AssignGPerSectionToLinearShuntCompensatorCommand
   */
  public void validate(AssignGPerSectionToLinearShuntCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignGPerSectionToLinearShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getLinearShuntCompensatorId(),
        "AssignGPerSectionToLinearShuntCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignGPerSectionToLinearShuntCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign GPerSection validation for a LinearShuntCompensator
   *
   * @param command UnAssignGPerSectionFromLinearShuntCompensatorCommand
   */
  public void validate(UnAssignGPerSectionFromLinearShuntCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignGPerSectionFromLinearShuntCompensatorCommand should not be null");
    Assert.notNull(
        command.getLinearShuntCompensatorId(),
        "UnAssignGPerSectionFromLinearShuntCompensatorCommand identifier should not be null");
  }
}
