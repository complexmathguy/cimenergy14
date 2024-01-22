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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class LoadStaticValidator {

  /** default constructor */
  protected LoadStaticValidator() {}

  /** factory method */
  public static LoadStaticValidator getInstance() {
    return new LoadStaticValidator();
  }

  /** handles creation validation for a LoadStatic */
  public void validate(CreateLoadStaticCommand loadStatic) throws Exception {
    Assert.notNull(loadStatic, "CreateLoadStaticCommand should not be null");
    //		Assert.isNull( loadStatic.getLoadStaticId(), "CreateLoadStaticCommand identifier should be
    // null" );
  }

  /** handles update validation for a LoadStatic */
  public void validate(UpdateLoadStaticCommand loadStatic) throws Exception {
    Assert.notNull(loadStatic, "UpdateLoadStaticCommand should not be null");
    Assert.notNull(
        loadStatic.getLoadStaticId(), "UpdateLoadStaticCommand identifier should not be null");
  }

  /** handles delete validation for a LoadStatic */
  public void validate(DeleteLoadStaticCommand loadStatic) throws Exception {
    Assert.notNull(loadStatic, "{commandAlias} should not be null");
    Assert.notNull(
        loadStatic.getLoadStaticId(), "DeleteLoadStaticCommand identifier should not be null");
  }

  /** handles fetchOne validation for a LoadStatic */
  public void validate(LoadStaticFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "LoadStaticFetchOneSummary should not be null");
    Assert.notNull(
        summary.getLoadStaticId(), "LoadStaticFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ep1 validation for a LoadStatic
   *
   * @param command AssignEp1ToLoadStaticCommand
   */
  public void validate(AssignEp1ToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignEp1ToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignEp1ToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEp1ToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Ep1 validation for a LoadStatic
   *
   * @param command UnAssignEp1FromLoadStaticCommand
   */
  public void validate(UnAssignEp1FromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEp1FromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignEp1FromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign Ep2 validation for a LoadStatic
   *
   * @param command AssignEp2ToLoadStaticCommand
   */
  public void validate(AssignEp2ToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignEp2ToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignEp2ToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEp2ToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Ep2 validation for a LoadStatic
   *
   * @param command UnAssignEp2FromLoadStaticCommand
   */
  public void validate(UnAssignEp2FromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEp2FromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignEp2FromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign Ep3 validation for a LoadStatic
   *
   * @param command AssignEp3ToLoadStaticCommand
   */
  public void validate(AssignEp3ToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignEp3ToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignEp3ToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEp3ToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Ep3 validation for a LoadStatic
   *
   * @param command UnAssignEp3FromLoadStaticCommand
   */
  public void validate(UnAssignEp3FromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEp3FromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignEp3FromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign Eq1 validation for a LoadStatic
   *
   * @param command AssignEq1ToLoadStaticCommand
   */
  public void validate(AssignEq1ToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignEq1ToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignEq1ToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEq1ToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Eq1 validation for a LoadStatic
   *
   * @param command UnAssignEq1FromLoadStaticCommand
   */
  public void validate(UnAssignEq1FromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEq1FromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignEq1FromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign Eq2 validation for a LoadStatic
   *
   * @param command AssignEq2ToLoadStaticCommand
   */
  public void validate(AssignEq2ToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignEq2ToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignEq2ToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEq2ToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Eq2 validation for a LoadStatic
   *
   * @param command UnAssignEq2FromLoadStaticCommand
   */
  public void validate(UnAssignEq2FromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEq2FromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignEq2FromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign Eq3 validation for a LoadStatic
   *
   * @param command AssignEq3ToLoadStaticCommand
   */
  public void validate(AssignEq3ToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignEq3ToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignEq3ToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEq3ToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Eq3 validation for a LoadStatic
   *
   * @param command UnAssignEq3FromLoadStaticCommand
   */
  public void validate(UnAssignEq3FromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEq3FromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignEq3FromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign Kp1 validation for a LoadStatic
   *
   * @param command AssignKp1ToLoadStaticCommand
   */
  public void validate(AssignKp1ToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignKp1ToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignKp1ToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKp1ToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Kp1 validation for a LoadStatic
   *
   * @param command UnAssignKp1FromLoadStaticCommand
   */
  public void validate(UnAssignKp1FromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKp1FromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignKp1FromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign Kp2 validation for a LoadStatic
   *
   * @param command AssignKp2ToLoadStaticCommand
   */
  public void validate(AssignKp2ToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignKp2ToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignKp2ToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKp2ToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Kp2 validation for a LoadStatic
   *
   * @param command UnAssignKp2FromLoadStaticCommand
   */
  public void validate(UnAssignKp2FromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKp2FromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignKp2FromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign Kp3 validation for a LoadStatic
   *
   * @param command AssignKp3ToLoadStaticCommand
   */
  public void validate(AssignKp3ToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignKp3ToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignKp3ToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKp3ToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Kp3 validation for a LoadStatic
   *
   * @param command UnAssignKp3FromLoadStaticCommand
   */
  public void validate(UnAssignKp3FromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKp3FromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignKp3FromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign Kp4 validation for a LoadStatic
   *
   * @param command AssignKp4ToLoadStaticCommand
   */
  public void validate(AssignKp4ToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignKp4ToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignKp4ToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKp4ToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Kp4 validation for a LoadStatic
   *
   * @param command UnAssignKp4FromLoadStaticCommand
   */
  public void validate(UnAssignKp4FromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKp4FromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignKp4FromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign Kpf validation for a LoadStatic
   *
   * @param command AssignKpfToLoadStaticCommand
   */
  public void validate(AssignKpfToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignKpfToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignKpfToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpfToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Kpf validation for a LoadStatic
   *
   * @param command UnAssignKpfFromLoadStaticCommand
   */
  public void validate(UnAssignKpfFromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpfFromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignKpfFromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign Kq1 validation for a LoadStatic
   *
   * @param command AssignKq1ToLoadStaticCommand
   */
  public void validate(AssignKq1ToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignKq1ToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignKq1ToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKq1ToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Kq1 validation for a LoadStatic
   *
   * @param command UnAssignKq1FromLoadStaticCommand
   */
  public void validate(UnAssignKq1FromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKq1FromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignKq1FromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign Kq2 validation for a LoadStatic
   *
   * @param command AssignKq2ToLoadStaticCommand
   */
  public void validate(AssignKq2ToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignKq2ToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignKq2ToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKq2ToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Kq2 validation for a LoadStatic
   *
   * @param command UnAssignKq2FromLoadStaticCommand
   */
  public void validate(UnAssignKq2FromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKq2FromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignKq2FromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign Kq3 validation for a LoadStatic
   *
   * @param command AssignKq3ToLoadStaticCommand
   */
  public void validate(AssignKq3ToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignKq3ToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignKq3ToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKq3ToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Kq3 validation for a LoadStatic
   *
   * @param command UnAssignKq3FromLoadStaticCommand
   */
  public void validate(UnAssignKq3FromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKq3FromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignKq3FromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign Kq4 validation for a LoadStatic
   *
   * @param command AssignKq4ToLoadStaticCommand
   */
  public void validate(AssignKq4ToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignKq4ToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignKq4ToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKq4ToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Kq4 validation for a LoadStatic
   *
   * @param command UnAssignKq4FromLoadStaticCommand
   */
  public void validate(UnAssignKq4FromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKq4FromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignKq4FromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign Kqf validation for a LoadStatic
   *
   * @param command AssignKqfToLoadStaticCommand
   */
  public void validate(AssignKqfToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignKqfToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(), "AssignKqfToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKqfToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign Kqf validation for a LoadStatic
   *
   * @param command UnAssignKqfFromLoadStaticCommand
   */
  public void validate(UnAssignKqfFromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKqfFromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignKqfFromLoadStaticCommand identifier should not be null");
  }
  /**
   * handles assign LoadStatic validation for a LoadStatic
   *
   * @param command AssignLoadStaticToLoadStaticCommand
   */
  public void validate(AssignLoadStaticToLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "AssignLoadStaticToLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "AssignLoadStaticToLoadStaticCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignLoadStaticToLoadStaticCommand assignment should not be null");
  }

  /**
   * handles unassign LoadStatic validation for a LoadStatic
   *
   * @param command UnAssignLoadStaticFromLoadStaticCommand
   */
  public void validate(UnAssignLoadStaticFromLoadStaticCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLoadStaticFromLoadStaticCommand should not be null");
    Assert.notNull(
        command.getLoadStaticId(),
        "UnAssignLoadStaticFromLoadStaticCommand identifier should not be null");
  }
}
