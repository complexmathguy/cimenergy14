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

public class OverexcLimX1Validator {

  /** default constructor */
  protected OverexcLimX1Validator() {}

  /** factory method */
  public static OverexcLimX1Validator getInstance() {
    return new OverexcLimX1Validator();
  }

  /** handles creation validation for a OverexcLimX1 */
  public void validate(CreateOverexcLimX1Command overexcLimX1) throws Exception {
    Assert.notNull(overexcLimX1, "CreateOverexcLimX1Command should not be null");
    //		Assert.isNull( overexcLimX1.getOverexcLimX1Id(), "CreateOverexcLimX1Command identifier
    // should be null" );
  }

  /** handles update validation for a OverexcLimX1 */
  public void validate(UpdateOverexcLimX1Command overexcLimX1) throws Exception {
    Assert.notNull(overexcLimX1, "UpdateOverexcLimX1Command should not be null");
    Assert.notNull(
        overexcLimX1.getOverexcLimX1Id(),
        "UpdateOverexcLimX1Command identifier should not be null");
  }

  /** handles delete validation for a OverexcLimX1 */
  public void validate(DeleteOverexcLimX1Command overexcLimX1) throws Exception {
    Assert.notNull(overexcLimX1, "{commandAlias} should not be null");
    Assert.notNull(
        overexcLimX1.getOverexcLimX1Id(),
        "DeleteOverexcLimX1Command identifier should not be null");
  }

  /** handles fetchOne validation for a OverexcLimX1 */
  public void validate(OverexcLimX1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "OverexcLimX1FetchOneSummary should not be null");
    Assert.notNull(
        summary.getOverexcLimX1Id(), "OverexcLimX1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Efd1 validation for a OverexcLimX1
   *
   * @param command AssignEfd1ToOverexcLimX1Command
   */
  public void validate(AssignEfd1ToOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignEfd1ToOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "AssignEfd1ToOverexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd1ToOverexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign Efd1 validation for a OverexcLimX1
   *
   * @param command UnAssignEfd1FromOverexcLimX1Command
   */
  public void validate(UnAssignEfd1FromOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignEfd1FromOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "UnAssignEfd1FromOverexcLimX1Command identifier should not be null");
  }
  /**
   * handles assign Efd2 validation for a OverexcLimX1
   *
   * @param command AssignEfd2ToOverexcLimX1Command
   */
  public void validate(AssignEfd2ToOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignEfd2ToOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "AssignEfd2ToOverexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd2ToOverexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign Efd2 validation for a OverexcLimX1
   *
   * @param command UnAssignEfd2FromOverexcLimX1Command
   */
  public void validate(UnAssignEfd2FromOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignEfd2FromOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "UnAssignEfd2FromOverexcLimX1Command identifier should not be null");
  }
  /**
   * handles assign Efd3 validation for a OverexcLimX1
   *
   * @param command AssignEfd3ToOverexcLimX1Command
   */
  public void validate(AssignEfd3ToOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignEfd3ToOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "AssignEfd3ToOverexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfd3ToOverexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign Efd3 validation for a OverexcLimX1
   *
   * @param command UnAssignEfd3FromOverexcLimX1Command
   */
  public void validate(UnAssignEfd3FromOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignEfd3FromOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "UnAssignEfd3FromOverexcLimX1Command identifier should not be null");
  }
  /**
   * handles assign Efddes validation for a OverexcLimX1
   *
   * @param command AssignEfddesToOverexcLimX1Command
   */
  public void validate(AssignEfddesToOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignEfddesToOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "AssignEfddesToOverexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfddesToOverexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign Efddes validation for a OverexcLimX1
   *
   * @param command UnAssignEfddesFromOverexcLimX1Command
   */
  public void validate(UnAssignEfddesFromOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignEfddesFromOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "UnAssignEfddesFromOverexcLimX1Command identifier should not be null");
  }
  /**
   * handles assign Efdrated validation for a OverexcLimX1
   *
   * @param command AssignEfdratedToOverexcLimX1Command
   */
  public void validate(AssignEfdratedToOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignEfdratedToOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "AssignEfdratedToOverexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEfdratedToOverexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign Efdrated validation for a OverexcLimX1
   *
   * @param command UnAssignEfdratedFromOverexcLimX1Command
   */
  public void validate(UnAssignEfdratedFromOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignEfdratedFromOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "UnAssignEfdratedFromOverexcLimX1Command identifier should not be null");
  }
  /**
   * handles assign Kmx validation for a OverexcLimX1
   *
   * @param command AssignKmxToOverexcLimX1Command
   */
  public void validate(AssignKmxToOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignKmxToOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "AssignKmxToOverexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKmxToOverexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign Kmx validation for a OverexcLimX1
   *
   * @param command UnAssignKmxFromOverexcLimX1Command
   */
  public void validate(UnAssignKmxFromOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKmxFromOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "UnAssignKmxFromOverexcLimX1Command identifier should not be null");
  }
  /**
   * handles assign T1 validation for a OverexcLimX1
   *
   * @param command AssignT1ToOverexcLimX1Command
   */
  public void validate(AssignT1ToOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignT1ToOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(), "AssignT1ToOverexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToOverexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a OverexcLimX1
   *
   * @param command UnAssignT1FromOverexcLimX1Command
   */
  public void validate(UnAssignT1FromOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "UnAssignT1FromOverexcLimX1Command identifier should not be null");
  }
  /**
   * handles assign T2 validation for a OverexcLimX1
   *
   * @param command AssignT2ToOverexcLimX1Command
   */
  public void validate(AssignT2ToOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignT2ToOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(), "AssignT2ToOverexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToOverexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a OverexcLimX1
   *
   * @param command UnAssignT2FromOverexcLimX1Command
   */
  public void validate(UnAssignT2FromOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "UnAssignT2FromOverexcLimX1Command identifier should not be null");
  }
  /**
   * handles assign T3 validation for a OverexcLimX1
   *
   * @param command AssignT3ToOverexcLimX1Command
   */
  public void validate(AssignT3ToOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignT3ToOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(), "AssignT3ToOverexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToOverexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a OverexcLimX1
   *
   * @param command UnAssignT3FromOverexcLimX1Command
   */
  public void validate(UnAssignT3FromOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "UnAssignT3FromOverexcLimX1Command identifier should not be null");
  }
  /**
   * handles assign Vlow validation for a OverexcLimX1
   *
   * @param command AssignVlowToOverexcLimX1Command
   */
  public void validate(AssignVlowToOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignVlowToOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "AssignVlowToOverexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVlowToOverexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign Vlow validation for a OverexcLimX1
   *
   * @param command UnAssignVlowFromOverexcLimX1Command
   */
  public void validate(UnAssignVlowFromOverexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVlowFromOverexcLimX1Command should not be null");
    Assert.notNull(
        command.getOverexcLimX1Id(),
        "UnAssignVlowFromOverexcLimX1Command identifier should not be null");
  }
}
