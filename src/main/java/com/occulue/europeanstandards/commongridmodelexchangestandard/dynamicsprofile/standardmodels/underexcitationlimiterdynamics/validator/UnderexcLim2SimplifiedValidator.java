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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class UnderexcLim2SimplifiedValidator {

  /** default constructor */
  protected UnderexcLim2SimplifiedValidator() {}

  /** factory method */
  public static UnderexcLim2SimplifiedValidator getInstance() {
    return new UnderexcLim2SimplifiedValidator();
  }

  /** handles creation validation for a UnderexcLim2Simplified */
  public void validate(CreateUnderexcLim2SimplifiedCommand underexcLim2Simplified)
      throws Exception {
    Assert.notNull(
        underexcLim2Simplified, "CreateUnderexcLim2SimplifiedCommand should not be null");
    //		Assert.isNull( underexcLim2Simplified.getUnderexcLim2SimplifiedId(),
    // "CreateUnderexcLim2SimplifiedCommand identifier should be null" );
  }

  /** handles update validation for a UnderexcLim2Simplified */
  public void validate(UpdateUnderexcLim2SimplifiedCommand underexcLim2Simplified)
      throws Exception {
    Assert.notNull(
        underexcLim2Simplified, "UpdateUnderexcLim2SimplifiedCommand should not be null");
    Assert.notNull(
        underexcLim2Simplified.getUnderexcLim2SimplifiedId(),
        "UpdateUnderexcLim2SimplifiedCommand identifier should not be null");
  }

  /** handles delete validation for a UnderexcLim2Simplified */
  public void validate(DeleteUnderexcLim2SimplifiedCommand underexcLim2Simplified)
      throws Exception {
    Assert.notNull(underexcLim2Simplified, "{commandAlias} should not be null");
    Assert.notNull(
        underexcLim2Simplified.getUnderexcLim2SimplifiedId(),
        "DeleteUnderexcLim2SimplifiedCommand identifier should not be null");
  }

  /** handles fetchOne validation for a UnderexcLim2Simplified */
  public void validate(UnderexcLim2SimplifiedFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "UnderexcLim2SimplifiedFetchOneSummary should not be null");
    Assert.notNull(
        summary.getUnderexcLim2SimplifiedId(),
        "UnderexcLim2SimplifiedFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Kui validation for a UnderexcLim2Simplified
   *
   * @param command AssignKuiToUnderexcLim2SimplifiedCommand
   */
  public void validate(AssignKuiToUnderexcLim2SimplifiedCommand command) throws Exception {
    Assert.notNull(command, "AssignKuiToUnderexcLim2SimplifiedCommand should not be null");
    Assert.notNull(
        command.getUnderexcLim2SimplifiedId(),
        "AssignKuiToUnderexcLim2SimplifiedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKuiToUnderexcLim2SimplifiedCommand assignment should not be null");
  }

  /**
   * handles unassign Kui validation for a UnderexcLim2Simplified
   *
   * @param command UnAssignKuiFromUnderexcLim2SimplifiedCommand
   */
  public void validate(UnAssignKuiFromUnderexcLim2SimplifiedCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKuiFromUnderexcLim2SimplifiedCommand should not be null");
    Assert.notNull(
        command.getUnderexcLim2SimplifiedId(),
        "UnAssignKuiFromUnderexcLim2SimplifiedCommand identifier should not be null");
  }
  /**
   * handles assign P0 validation for a UnderexcLim2Simplified
   *
   * @param command AssignP0ToUnderexcLim2SimplifiedCommand
   */
  public void validate(AssignP0ToUnderexcLim2SimplifiedCommand command) throws Exception {
    Assert.notNull(command, "AssignP0ToUnderexcLim2SimplifiedCommand should not be null");
    Assert.notNull(
        command.getUnderexcLim2SimplifiedId(),
        "AssignP0ToUnderexcLim2SimplifiedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignP0ToUnderexcLim2SimplifiedCommand assignment should not be null");
  }

  /**
   * handles unassign P0 validation for a UnderexcLim2Simplified
   *
   * @param command UnAssignP0FromUnderexcLim2SimplifiedCommand
   */
  public void validate(UnAssignP0FromUnderexcLim2SimplifiedCommand command) throws Exception {
    Assert.notNull(command, "UnAssignP0FromUnderexcLim2SimplifiedCommand should not be null");
    Assert.notNull(
        command.getUnderexcLim2SimplifiedId(),
        "UnAssignP0FromUnderexcLim2SimplifiedCommand identifier should not be null");
  }
  /**
   * handles assign P1 validation for a UnderexcLim2Simplified
   *
   * @param command AssignP1ToUnderexcLim2SimplifiedCommand
   */
  public void validate(AssignP1ToUnderexcLim2SimplifiedCommand command) throws Exception {
    Assert.notNull(command, "AssignP1ToUnderexcLim2SimplifiedCommand should not be null");
    Assert.notNull(
        command.getUnderexcLim2SimplifiedId(),
        "AssignP1ToUnderexcLim2SimplifiedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignP1ToUnderexcLim2SimplifiedCommand assignment should not be null");
  }

  /**
   * handles unassign P1 validation for a UnderexcLim2Simplified
   *
   * @param command UnAssignP1FromUnderexcLim2SimplifiedCommand
   */
  public void validate(UnAssignP1FromUnderexcLim2SimplifiedCommand command) throws Exception {
    Assert.notNull(command, "UnAssignP1FromUnderexcLim2SimplifiedCommand should not be null");
    Assert.notNull(
        command.getUnderexcLim2SimplifiedId(),
        "UnAssignP1FromUnderexcLim2SimplifiedCommand identifier should not be null");
  }
  /**
   * handles assign Q0 validation for a UnderexcLim2Simplified
   *
   * @param command AssignQ0ToUnderexcLim2SimplifiedCommand
   */
  public void validate(AssignQ0ToUnderexcLim2SimplifiedCommand command) throws Exception {
    Assert.notNull(command, "AssignQ0ToUnderexcLim2SimplifiedCommand should not be null");
    Assert.notNull(
        command.getUnderexcLim2SimplifiedId(),
        "AssignQ0ToUnderexcLim2SimplifiedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignQ0ToUnderexcLim2SimplifiedCommand assignment should not be null");
  }

  /**
   * handles unassign Q0 validation for a UnderexcLim2Simplified
   *
   * @param command UnAssignQ0FromUnderexcLim2SimplifiedCommand
   */
  public void validate(UnAssignQ0FromUnderexcLim2SimplifiedCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQ0FromUnderexcLim2SimplifiedCommand should not be null");
    Assert.notNull(
        command.getUnderexcLim2SimplifiedId(),
        "UnAssignQ0FromUnderexcLim2SimplifiedCommand identifier should not be null");
  }
  /**
   * handles assign Q1 validation for a UnderexcLim2Simplified
   *
   * @param command AssignQ1ToUnderexcLim2SimplifiedCommand
   */
  public void validate(AssignQ1ToUnderexcLim2SimplifiedCommand command) throws Exception {
    Assert.notNull(command, "AssignQ1ToUnderexcLim2SimplifiedCommand should not be null");
    Assert.notNull(
        command.getUnderexcLim2SimplifiedId(),
        "AssignQ1ToUnderexcLim2SimplifiedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignQ1ToUnderexcLim2SimplifiedCommand assignment should not be null");
  }

  /**
   * handles unassign Q1 validation for a UnderexcLim2Simplified
   *
   * @param command UnAssignQ1FromUnderexcLim2SimplifiedCommand
   */
  public void validate(UnAssignQ1FromUnderexcLim2SimplifiedCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQ1FromUnderexcLim2SimplifiedCommand should not be null");
    Assert.notNull(
        command.getUnderexcLim2SimplifiedId(),
        "UnAssignQ1FromUnderexcLim2SimplifiedCommand identifier should not be null");
  }
  /**
   * handles assign Vuimax validation for a UnderexcLim2Simplified
   *
   * @param command AssignVuimaxToUnderexcLim2SimplifiedCommand
   */
  public void validate(AssignVuimaxToUnderexcLim2SimplifiedCommand command) throws Exception {
    Assert.notNull(command, "AssignVuimaxToUnderexcLim2SimplifiedCommand should not be null");
    Assert.notNull(
        command.getUnderexcLim2SimplifiedId(),
        "AssignVuimaxToUnderexcLim2SimplifiedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVuimaxToUnderexcLim2SimplifiedCommand assignment should not be null");
  }

  /**
   * handles unassign Vuimax validation for a UnderexcLim2Simplified
   *
   * @param command UnAssignVuimaxFromUnderexcLim2SimplifiedCommand
   */
  public void validate(UnAssignVuimaxFromUnderexcLim2SimplifiedCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVuimaxFromUnderexcLim2SimplifiedCommand should not be null");
    Assert.notNull(
        command.getUnderexcLim2SimplifiedId(),
        "UnAssignVuimaxFromUnderexcLim2SimplifiedCommand identifier should not be null");
  }
  /**
   * handles assign Vuimin validation for a UnderexcLim2Simplified
   *
   * @param command AssignVuiminToUnderexcLim2SimplifiedCommand
   */
  public void validate(AssignVuiminToUnderexcLim2SimplifiedCommand command) throws Exception {
    Assert.notNull(command, "AssignVuiminToUnderexcLim2SimplifiedCommand should not be null");
    Assert.notNull(
        command.getUnderexcLim2SimplifiedId(),
        "AssignVuiminToUnderexcLim2SimplifiedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVuiminToUnderexcLim2SimplifiedCommand assignment should not be null");
  }

  /**
   * handles unassign Vuimin validation for a UnderexcLim2Simplified
   *
   * @param command UnAssignVuiminFromUnderexcLim2SimplifiedCommand
   */
  public void validate(UnAssignVuiminFromUnderexcLim2SimplifiedCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVuiminFromUnderexcLim2SimplifiedCommand should not be null");
    Assert.notNull(
        command.getUnderexcLim2SimplifiedId(),
        "UnAssignVuiminFromUnderexcLim2SimplifiedCommand identifier should not be null");
  }
}
