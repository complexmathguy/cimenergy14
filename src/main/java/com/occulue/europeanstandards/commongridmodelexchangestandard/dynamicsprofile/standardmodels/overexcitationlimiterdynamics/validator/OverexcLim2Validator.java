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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class OverexcLim2Validator {

  /** default constructor */
  protected OverexcLim2Validator() {}

  /** factory method */
  public static OverexcLim2Validator getInstance() {
    return new OverexcLim2Validator();
  }

  /** handles creation validation for a OverexcLim2 */
  public void validate(CreateOverexcLim2Command overexcLim2) throws Exception {
    Assert.notNull(overexcLim2, "CreateOverexcLim2Command should not be null");
    //		Assert.isNull( overexcLim2.getOverexcLim2Id(), "CreateOverexcLim2Command identifier should
    // be null" );
  }

  /** handles update validation for a OverexcLim2 */
  public void validate(UpdateOverexcLim2Command overexcLim2) throws Exception {
    Assert.notNull(overexcLim2, "UpdateOverexcLim2Command should not be null");
    Assert.notNull(
        overexcLim2.getOverexcLim2Id(), "UpdateOverexcLim2Command identifier should not be null");
  }

  /** handles delete validation for a OverexcLim2 */
  public void validate(DeleteOverexcLim2Command overexcLim2) throws Exception {
    Assert.notNull(overexcLim2, "{commandAlias} should not be null");
    Assert.notNull(
        overexcLim2.getOverexcLim2Id(), "DeleteOverexcLim2Command identifier should not be null");
  }

  /** handles fetchOne validation for a OverexcLim2 */
  public void validate(OverexcLim2FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "OverexcLim2FetchOneSummary should not be null");
    Assert.notNull(
        summary.getOverexcLim2Id(), "OverexcLim2FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ifdlim validation for a OverexcLim2
   *
   * @param command AssignIfdlimToOverexcLim2Command
   */
  public void validate(AssignIfdlimToOverexcLim2Command command) throws Exception {
    Assert.notNull(command, "AssignIfdlimToOverexcLim2Command should not be null");
    Assert.notNull(
        command.getOverexcLim2Id(),
        "AssignIfdlimToOverexcLim2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIfdlimToOverexcLim2Command assignment should not be null");
  }

  /**
   * handles unassign Ifdlim validation for a OverexcLim2
   *
   * @param command UnAssignIfdlimFromOverexcLim2Command
   */
  public void validate(UnAssignIfdlimFromOverexcLim2Command command) throws Exception {
    Assert.notNull(command, "UnAssignIfdlimFromOverexcLim2Command should not be null");
    Assert.notNull(
        command.getOverexcLim2Id(),
        "UnAssignIfdlimFromOverexcLim2Command identifier should not be null");
  }
  /**
   * handles assign Koi validation for a OverexcLim2
   *
   * @param command AssignKoiToOverexcLim2Command
   */
  public void validate(AssignKoiToOverexcLim2Command command) throws Exception {
    Assert.notNull(command, "AssignKoiToOverexcLim2Command should not be null");
    Assert.notNull(
        command.getOverexcLim2Id(), "AssignKoiToOverexcLim2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKoiToOverexcLim2Command assignment should not be null");
  }

  /**
   * handles unassign Koi validation for a OverexcLim2
   *
   * @param command UnAssignKoiFromOverexcLim2Command
   */
  public void validate(UnAssignKoiFromOverexcLim2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKoiFromOverexcLim2Command should not be null");
    Assert.notNull(
        command.getOverexcLim2Id(),
        "UnAssignKoiFromOverexcLim2Command identifier should not be null");
  }
  /**
   * handles assign Voimax validation for a OverexcLim2
   *
   * @param command AssignVoimaxToOverexcLim2Command
   */
  public void validate(AssignVoimaxToOverexcLim2Command command) throws Exception {
    Assert.notNull(command, "AssignVoimaxToOverexcLim2Command should not be null");
    Assert.notNull(
        command.getOverexcLim2Id(),
        "AssignVoimaxToOverexcLim2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVoimaxToOverexcLim2Command assignment should not be null");
  }

  /**
   * handles unassign Voimax validation for a OverexcLim2
   *
   * @param command UnAssignVoimaxFromOverexcLim2Command
   */
  public void validate(UnAssignVoimaxFromOverexcLim2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVoimaxFromOverexcLim2Command should not be null");
    Assert.notNull(
        command.getOverexcLim2Id(),
        "UnAssignVoimaxFromOverexcLim2Command identifier should not be null");
  }
  /**
   * handles assign Voimin validation for a OverexcLim2
   *
   * @param command AssignVoiminToOverexcLim2Command
   */
  public void validate(AssignVoiminToOverexcLim2Command command) throws Exception {
    Assert.notNull(command, "AssignVoiminToOverexcLim2Command should not be null");
    Assert.notNull(
        command.getOverexcLim2Id(),
        "AssignVoiminToOverexcLim2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVoiminToOverexcLim2Command assignment should not be null");
  }

  /**
   * handles unassign Voimin validation for a OverexcLim2
   *
   * @param command UnAssignVoiminFromOverexcLim2Command
   */
  public void validate(UnAssignVoiminFromOverexcLim2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVoiminFromOverexcLim2Command should not be null");
    Assert.notNull(
        command.getOverexcLim2Id(),
        "UnAssignVoiminFromOverexcLim2Command identifier should not be null");
  }
}
