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

public class LoadGenericNonLinearValidator {

  /** default constructor */
  protected LoadGenericNonLinearValidator() {}

  /** factory method */
  public static LoadGenericNonLinearValidator getInstance() {
    return new LoadGenericNonLinearValidator();
  }

  /** handles creation validation for a LoadGenericNonLinear */
  public void validate(CreateLoadGenericNonLinearCommand loadGenericNonLinear) throws Exception {
    Assert.notNull(loadGenericNonLinear, "CreateLoadGenericNonLinearCommand should not be null");
    //		Assert.isNull( loadGenericNonLinear.getLoadGenericNonLinearId(),
    // "CreateLoadGenericNonLinearCommand identifier should be null" );
  }

  /** handles update validation for a LoadGenericNonLinear */
  public void validate(UpdateLoadGenericNonLinearCommand loadGenericNonLinear) throws Exception {
    Assert.notNull(loadGenericNonLinear, "UpdateLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        loadGenericNonLinear.getLoadGenericNonLinearId(),
        "UpdateLoadGenericNonLinearCommand identifier should not be null");
  }

  /** handles delete validation for a LoadGenericNonLinear */
  public void validate(DeleteLoadGenericNonLinearCommand loadGenericNonLinear) throws Exception {
    Assert.notNull(loadGenericNonLinear, "{commandAlias} should not be null");
    Assert.notNull(
        loadGenericNonLinear.getLoadGenericNonLinearId(),
        "DeleteLoadGenericNonLinearCommand identifier should not be null");
  }

  /** handles fetchOne validation for a LoadGenericNonLinear */
  public void validate(LoadGenericNonLinearFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "LoadGenericNonLinearFetchOneSummary should not be null");
    Assert.notNull(
        summary.getLoadGenericNonLinearId(),
        "LoadGenericNonLinearFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Bs validation for a LoadGenericNonLinear
   *
   * @param command AssignBsToLoadGenericNonLinearCommand
   */
  public void validate(AssignBsToLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "AssignBsToLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "AssignBsToLoadGenericNonLinearCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBsToLoadGenericNonLinearCommand assignment should not be null");
  }

  /**
   * handles unassign Bs validation for a LoadGenericNonLinear
   *
   * @param command UnAssignBsFromLoadGenericNonLinearCommand
   */
  public void validate(UnAssignBsFromLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBsFromLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "UnAssignBsFromLoadGenericNonLinearCommand identifier should not be null");
  }
  /**
   * handles assign Bt validation for a LoadGenericNonLinear
   *
   * @param command AssignBtToLoadGenericNonLinearCommand
   */
  public void validate(AssignBtToLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "AssignBtToLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "AssignBtToLoadGenericNonLinearCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBtToLoadGenericNonLinearCommand assignment should not be null");
  }

  /**
   * handles unassign Bt validation for a LoadGenericNonLinear
   *
   * @param command UnAssignBtFromLoadGenericNonLinearCommand
   */
  public void validate(UnAssignBtFromLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBtFromLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "UnAssignBtFromLoadGenericNonLinearCommand identifier should not be null");
  }
  /**
   * handles assign Ls validation for a LoadGenericNonLinear
   *
   * @param command AssignLsToLoadGenericNonLinearCommand
   */
  public void validate(AssignLsToLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "AssignLsToLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "AssignLsToLoadGenericNonLinearCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignLsToLoadGenericNonLinearCommand assignment should not be null");
  }

  /**
   * handles unassign Ls validation for a LoadGenericNonLinear
   *
   * @param command UnAssignLsFromLoadGenericNonLinearCommand
   */
  public void validate(UnAssignLsFromLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLsFromLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "UnAssignLsFromLoadGenericNonLinearCommand identifier should not be null");
  }
  /**
   * handles assign Lt validation for a LoadGenericNonLinear
   *
   * @param command AssignLtToLoadGenericNonLinearCommand
   */
  public void validate(AssignLtToLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "AssignLtToLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "AssignLtToLoadGenericNonLinearCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignLtToLoadGenericNonLinearCommand assignment should not be null");
  }

  /**
   * handles unassign Lt validation for a LoadGenericNonLinear
   *
   * @param command UnAssignLtFromLoadGenericNonLinearCommand
   */
  public void validate(UnAssignLtFromLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "UnAssignLtFromLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "UnAssignLtFromLoadGenericNonLinearCommand identifier should not be null");
  }
  /**
   * handles assign Pt validation for a LoadGenericNonLinear
   *
   * @param command AssignPtToLoadGenericNonLinearCommand
   */
  public void validate(AssignPtToLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "AssignPtToLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "AssignPtToLoadGenericNonLinearCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPtToLoadGenericNonLinearCommand assignment should not be null");
  }

  /**
   * handles unassign Pt validation for a LoadGenericNonLinear
   *
   * @param command UnAssignPtFromLoadGenericNonLinearCommand
   */
  public void validate(UnAssignPtFromLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPtFromLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "UnAssignPtFromLoadGenericNonLinearCommand identifier should not be null");
  }
  /**
   * handles assign Qt validation for a LoadGenericNonLinear
   *
   * @param command AssignQtToLoadGenericNonLinearCommand
   */
  public void validate(AssignQtToLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "AssignQtToLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "AssignQtToLoadGenericNonLinearCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignQtToLoadGenericNonLinearCommand assignment should not be null");
  }

  /**
   * handles unassign Qt validation for a LoadGenericNonLinear
   *
   * @param command UnAssignQtFromLoadGenericNonLinearCommand
   */
  public void validate(UnAssignQtFromLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQtFromLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "UnAssignQtFromLoadGenericNonLinearCommand identifier should not be null");
  }
  /**
   * handles assign Tp validation for a LoadGenericNonLinear
   *
   * @param command AssignTpToLoadGenericNonLinearCommand
   */
  public void validate(AssignTpToLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "AssignTpToLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "AssignTpToLoadGenericNonLinearCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTpToLoadGenericNonLinearCommand assignment should not be null");
  }

  /**
   * handles unassign Tp validation for a LoadGenericNonLinear
   *
   * @param command UnAssignTpFromLoadGenericNonLinearCommand
   */
  public void validate(UnAssignTpFromLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpFromLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "UnAssignTpFromLoadGenericNonLinearCommand identifier should not be null");
  }
  /**
   * handles assign Tq validation for a LoadGenericNonLinear
   *
   * @param command AssignTqToLoadGenericNonLinearCommand
   */
  public void validate(AssignTqToLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "AssignTqToLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "AssignTqToLoadGenericNonLinearCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTqToLoadGenericNonLinearCommand assignment should not be null");
  }

  /**
   * handles unassign Tq validation for a LoadGenericNonLinear
   *
   * @param command UnAssignTqFromLoadGenericNonLinearCommand
   */
  public void validate(UnAssignTqFromLoadGenericNonLinearCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTqFromLoadGenericNonLinearCommand should not be null");
    Assert.notNull(
        command.getLoadGenericNonLinearId(),
        "UnAssignTqFromLoadGenericNonLinearCommand identifier should not be null");
  }
}
