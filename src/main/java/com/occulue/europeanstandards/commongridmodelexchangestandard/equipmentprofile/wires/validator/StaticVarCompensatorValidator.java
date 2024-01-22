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

public class StaticVarCompensatorValidator {

  /** default constructor */
  protected StaticVarCompensatorValidator() {}

  /** factory method */
  public static StaticVarCompensatorValidator getInstance() {
    return new StaticVarCompensatorValidator();
  }

  /** handles creation validation for a StaticVarCompensator */
  public void validate(CreateStaticVarCompensatorCommand staticVarCompensator) throws Exception {
    Assert.notNull(staticVarCompensator, "CreateStaticVarCompensatorCommand should not be null");
    //		Assert.isNull( staticVarCompensator.getStaticVarCompensatorId(),
    // "CreateStaticVarCompensatorCommand identifier should be null" );
  }

  /** handles update validation for a StaticVarCompensator */
  public void validate(UpdateStaticVarCompensatorCommand staticVarCompensator) throws Exception {
    Assert.notNull(staticVarCompensator, "UpdateStaticVarCompensatorCommand should not be null");
    Assert.notNull(
        staticVarCompensator.getStaticVarCompensatorId(),
        "UpdateStaticVarCompensatorCommand identifier should not be null");
  }

  /** handles delete validation for a StaticVarCompensator */
  public void validate(DeleteStaticVarCompensatorCommand staticVarCompensator) throws Exception {
    Assert.notNull(staticVarCompensator, "{commandAlias} should not be null");
    Assert.notNull(
        staticVarCompensator.getStaticVarCompensatorId(),
        "DeleteStaticVarCompensatorCommand identifier should not be null");
  }

  /** handles fetchOne validation for a StaticVarCompensator */
  public void validate(StaticVarCompensatorFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "StaticVarCompensatorFetchOneSummary should not be null");
    Assert.notNull(
        summary.getStaticVarCompensatorId(),
        "StaticVarCompensatorFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign CapacitiveRating validation for a StaticVarCompensator
   *
   * @param command AssignCapacitiveRatingToStaticVarCompensatorCommand
   */
  public void validate(AssignCapacitiveRatingToStaticVarCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignCapacitiveRatingToStaticVarCompensatorCommand should not be null");
    Assert.notNull(
        command.getStaticVarCompensatorId(),
        "AssignCapacitiveRatingToStaticVarCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignCapacitiveRatingToStaticVarCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign CapacitiveRating validation for a StaticVarCompensator
   *
   * @param command UnAssignCapacitiveRatingFromStaticVarCompensatorCommand
   */
  public void validate(UnAssignCapacitiveRatingFromStaticVarCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignCapacitiveRatingFromStaticVarCompensatorCommand should not be null");
    Assert.notNull(
        command.getStaticVarCompensatorId(),
        "UnAssignCapacitiveRatingFromStaticVarCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign InductiveRating validation for a StaticVarCompensator
   *
   * @param command AssignInductiveRatingToStaticVarCompensatorCommand
   */
  public void validate(AssignInductiveRatingToStaticVarCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignInductiveRatingToStaticVarCompensatorCommand should not be null");
    Assert.notNull(
        command.getStaticVarCompensatorId(),
        "AssignInductiveRatingToStaticVarCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignInductiveRatingToStaticVarCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign InductiveRating validation for a StaticVarCompensator
   *
   * @param command UnAssignInductiveRatingFromStaticVarCompensatorCommand
   */
  public void validate(UnAssignInductiveRatingFromStaticVarCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignInductiveRatingFromStaticVarCompensatorCommand should not be null");
    Assert.notNull(
        command.getStaticVarCompensatorId(),
        "UnAssignInductiveRatingFromStaticVarCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign Slope validation for a StaticVarCompensator
   *
   * @param command AssignSlopeToStaticVarCompensatorCommand
   */
  public void validate(AssignSlopeToStaticVarCompensatorCommand command) throws Exception {
    Assert.notNull(command, "AssignSlopeToStaticVarCompensatorCommand should not be null");
    Assert.notNull(
        command.getStaticVarCompensatorId(),
        "AssignSlopeToStaticVarCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSlopeToStaticVarCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign Slope validation for a StaticVarCompensator
   *
   * @param command UnAssignSlopeFromStaticVarCompensatorCommand
   */
  public void validate(UnAssignSlopeFromStaticVarCompensatorCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSlopeFromStaticVarCompensatorCommand should not be null");
    Assert.notNull(
        command.getStaticVarCompensatorId(),
        "UnAssignSlopeFromStaticVarCompensatorCommand identifier should not be null");
  }
  /**
   * handles assign VoltageSetPoint validation for a StaticVarCompensator
   *
   * @param command AssignVoltageSetPointToStaticVarCompensatorCommand
   */
  public void validate(AssignVoltageSetPointToStaticVarCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignVoltageSetPointToStaticVarCompensatorCommand should not be null");
    Assert.notNull(
        command.getStaticVarCompensatorId(),
        "AssignVoltageSetPointToStaticVarCompensatorCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVoltageSetPointToStaticVarCompensatorCommand assignment should not be null");
  }

  /**
   * handles unassign VoltageSetPoint validation for a StaticVarCompensator
   *
   * @param command UnAssignVoltageSetPointFromStaticVarCompensatorCommand
   */
  public void validate(UnAssignVoltageSetPointFromStaticVarCompensatorCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVoltageSetPointFromStaticVarCompensatorCommand should not be null");
    Assert.notNull(
        command.getStaticVarCompensatorId(),
        "UnAssignVoltageSetPointFromStaticVarCompensatorCommand identifier should not be null");
  }
}
