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

public class OverexcLimX2Validator {

  /** default constructor */
  protected OverexcLimX2Validator() {}

  /** factory method */
  public static OverexcLimX2Validator getInstance() {
    return new OverexcLimX2Validator();
  }

  /** handles creation validation for a OverexcLimX2 */
  public void validate(CreateOverexcLimX2Command overexcLimX2) throws Exception {
    Assert.notNull(overexcLimX2, "CreateOverexcLimX2Command should not be null");
    //		Assert.isNull( overexcLimX2.getOverexcLimX2Id(), "CreateOverexcLimX2Command identifier
    // should be null" );
  }

  /** handles update validation for a OverexcLimX2 */
  public void validate(UpdateOverexcLimX2Command overexcLimX2) throws Exception {
    Assert.notNull(overexcLimX2, "UpdateOverexcLimX2Command should not be null");
    Assert.notNull(
        overexcLimX2.getOverexcLimX2Id(),
        "UpdateOverexcLimX2Command identifier should not be null");
  }

  /** handles delete validation for a OverexcLimX2 */
  public void validate(DeleteOverexcLimX2Command overexcLimX2) throws Exception {
    Assert.notNull(overexcLimX2, "{commandAlias} should not be null");
    Assert.notNull(
        overexcLimX2.getOverexcLimX2Id(),
        "DeleteOverexcLimX2Command identifier should not be null");
  }

  /** handles fetchOne validation for a OverexcLimX2 */
  public void validate(OverexcLimX2FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "OverexcLimX2FetchOneSummary should not be null");
    Assert.notNull(
        summary.getOverexcLimX2Id(), "OverexcLimX2FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efd1 validation for a OverexcLimX2
   *
   * @param command AssignEfd1ToOverexcLimX2Command
   */
  public void validate(AssignEfd1ToOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignEfd1ToOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "AssignEfd1ToOverexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd1ToOverexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign Efd1 validation for a OverexcLimX2
   *
   * @param command UnAssignEfd1FromOverexcLimX2Command
   */
  public void validate(UnAssignEfd1FromOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignEfd1FromOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "UnAssignEfd1FromOverexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign Efd2 validation for a OverexcLimX2
   *
   * @param command AssignEfd2ToOverexcLimX2Command
   */
  public void validate(AssignEfd2ToOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignEfd2ToOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "AssignEfd2ToOverexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd2ToOverexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign Efd2 validation for a OverexcLimX2
   *
   * @param command UnAssignEfd2FromOverexcLimX2Command
   */
  public void validate(UnAssignEfd2FromOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignEfd2FromOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "UnAssignEfd2FromOverexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign Efd3 validation for a OverexcLimX2
   *
   * @param command AssignEfd3ToOverexcLimX2Command
   */
  public void validate(AssignEfd3ToOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignEfd3ToOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "AssignEfd3ToOverexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd3ToOverexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign Efd3 validation for a OverexcLimX2
   *
   * @param command UnAssignEfd3FromOverexcLimX2Command
   */
  public void validate(UnAssignEfd3FromOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignEfd3FromOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "UnAssignEfd3FromOverexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign Efddes validation for a OverexcLimX2
   *
   * @param command AssignEfddesToOverexcLimX2Command
   */
  public void validate(AssignEfddesToOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignEfddesToOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "AssignEfddesToOverexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfddesToOverexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign Efddes validation for a OverexcLimX2
   *
   * @param command UnAssignEfddesFromOverexcLimX2Command
   */
  public void validate(UnAssignEfddesFromOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignEfddesFromOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "UnAssignEfddesFromOverexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign Efdrated validation for a OverexcLimX2
   *
   * @param command AssignEfdratedToOverexcLimX2Command
   */
  public void validate(AssignEfdratedToOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignEfdratedToOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "AssignEfdratedToOverexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEfdratedToOverexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign Efdrated validation for a OverexcLimX2
   *
   * @param command UnAssignEfdratedFromOverexcLimX2Command
   */
  public void validate(UnAssignEfdratedFromOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignEfdratedFromOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "UnAssignEfdratedFromOverexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign Kmx validation for a OverexcLimX2
   *
   * @param command AssignKmxToOverexcLimX2Command
   */
  public void validate(AssignKmxToOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignKmxToOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "AssignKmxToOverexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKmxToOverexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign Kmx validation for a OverexcLimX2
   *
   * @param command UnAssignKmxFromOverexcLimX2Command
   */
  public void validate(UnAssignKmxFromOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKmxFromOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "UnAssignKmxFromOverexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign M validation for a OverexcLimX2
   *
   * @param command AssignMToOverexcLimX2Command
   */
  public void validate(AssignMToOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignMToOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(), "AssignMToOverexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMToOverexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign M validation for a OverexcLimX2
   *
   * @param command UnAssignMFromOverexcLimX2Command
   */
  public void validate(UnAssignMFromOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignMFromOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "UnAssignMFromOverexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign T1 validation for a OverexcLimX2
   *
   * @param command AssignT1ToOverexcLimX2Command
   */
  public void validate(AssignT1ToOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignT1ToOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(), "AssignT1ToOverexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToOverexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a OverexcLimX2
   *
   * @param command UnAssignT1FromOverexcLimX2Command
   */
  public void validate(UnAssignT1FromOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "UnAssignT1FromOverexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign T2 validation for a OverexcLimX2
   *
   * @param command AssignT2ToOverexcLimX2Command
   */
  public void validate(AssignT2ToOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignT2ToOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(), "AssignT2ToOverexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToOverexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a OverexcLimX2
   *
   * @param command UnAssignT2FromOverexcLimX2Command
   */
  public void validate(UnAssignT2FromOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "UnAssignT2FromOverexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign T3 validation for a OverexcLimX2
   *
   * @param command AssignT3ToOverexcLimX2Command
   */
  public void validate(AssignT3ToOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignT3ToOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(), "AssignT3ToOverexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToOverexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a OverexcLimX2
   *
   * @param command UnAssignT3FromOverexcLimX2Command
   */
  public void validate(UnAssignT3FromOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "UnAssignT3FromOverexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign Vlow validation for a OverexcLimX2
   *
   * @param command AssignVlowToOverexcLimX2Command
   */
  public void validate(AssignVlowToOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignVlowToOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "AssignVlowToOverexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVlowToOverexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign Vlow validation for a OverexcLimX2
   *
   * @param command UnAssignVlowFromOverexcLimX2Command
   */
  public void validate(UnAssignVlowFromOverexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVlowFromOverexcLimX2Command should not be null");
    Assert.notNull(
        command.getOverexcLimX2Id(),
        "UnAssignVlowFromOverexcLimX2Command identifier should not be null");
  }
}
