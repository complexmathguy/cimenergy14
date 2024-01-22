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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class WindProtectionIECValidator {

  /** default constructor */
  protected WindProtectionIECValidator() {}

  /** factory method */
  public static WindProtectionIECValidator getInstance() {
    return new WindProtectionIECValidator();
  }

  /** handles creation validation for a WindProtectionIEC */
  public void validate(CreateWindProtectionIECCommand windProtectionIEC) throws Exception {
    Assert.notNull(windProtectionIEC, "CreateWindProtectionIECCommand should not be null");
    //		Assert.isNull( windProtectionIEC.getWindProtectionIECId(), "CreateWindProtectionIECCommand
    // identifier should be null" );
  }

  /** handles update validation for a WindProtectionIEC */
  public void validate(UpdateWindProtectionIECCommand windProtectionIEC) throws Exception {
    Assert.notNull(windProtectionIEC, "UpdateWindProtectionIECCommand should not be null");
    Assert.notNull(
        windProtectionIEC.getWindProtectionIECId(),
        "UpdateWindProtectionIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindProtectionIEC */
  public void validate(DeleteWindProtectionIECCommand windProtectionIEC) throws Exception {
    Assert.notNull(windProtectionIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windProtectionIEC.getWindProtectionIECId(),
        "DeleteWindProtectionIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindProtectionIEC */
  public void validate(WindProtectionIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindProtectionIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindProtectionIECId(),
        "WindProtectionIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Fover validation for a WindProtectionIEC
   *
   * @param command AssignFoverToWindProtectionIECCommand
   */
  public void validate(AssignFoverToWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "AssignFoverToWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "AssignFoverToWindProtectionIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignFoverToWindProtectionIECCommand assignment should not be null");
  }

  /**
   * handles unassign Fover validation for a WindProtectionIEC
   *
   * @param command UnAssignFoverFromWindProtectionIECCommand
   */
  public void validate(UnAssignFoverFromWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFoverFromWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "UnAssignFoverFromWindProtectionIECCommand identifier should not be null");
  }
  /**
   * handles assign Funder validation for a WindProtectionIEC
   *
   * @param command AssignFunderToWindProtectionIECCommand
   */
  public void validate(AssignFunderToWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "AssignFunderToWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "AssignFunderToWindProtectionIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignFunderToWindProtectionIECCommand assignment should not be null");
  }

  /**
   * handles unassign Funder validation for a WindProtectionIEC
   *
   * @param command UnAssignFunderFromWindProtectionIECCommand
   */
  public void validate(UnAssignFunderFromWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFunderFromWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "UnAssignFunderFromWindProtectionIECCommand identifier should not be null");
  }
  /**
   * handles assign Tfover validation for a WindProtectionIEC
   *
   * @param command AssignTfoverToWindProtectionIECCommand
   */
  public void validate(AssignTfoverToWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTfoverToWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "AssignTfoverToWindProtectionIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTfoverToWindProtectionIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tfover validation for a WindProtectionIEC
   *
   * @param command UnAssignTfoverFromWindProtectionIECCommand
   */
  public void validate(UnAssignTfoverFromWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfoverFromWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "UnAssignTfoverFromWindProtectionIECCommand identifier should not be null");
  }
  /**
   * handles assign Tfunder validation for a WindProtectionIEC
   *
   * @param command AssignTfunderToWindProtectionIECCommand
   */
  public void validate(AssignTfunderToWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTfunderToWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "AssignTfunderToWindProtectionIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTfunderToWindProtectionIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tfunder validation for a WindProtectionIEC
   *
   * @param command UnAssignTfunderFromWindProtectionIECCommand
   */
  public void validate(UnAssignTfunderFromWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfunderFromWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "UnAssignTfunderFromWindProtectionIECCommand identifier should not be null");
  }
  /**
   * handles assign Tuover validation for a WindProtectionIEC
   *
   * @param command AssignTuoverToWindProtectionIECCommand
   */
  public void validate(AssignTuoverToWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTuoverToWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "AssignTuoverToWindProtectionIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTuoverToWindProtectionIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tuover validation for a WindProtectionIEC
   *
   * @param command UnAssignTuoverFromWindProtectionIECCommand
   */
  public void validate(UnAssignTuoverFromWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTuoverFromWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "UnAssignTuoverFromWindProtectionIECCommand identifier should not be null");
  }
  /**
   * handles assign Tuunder validation for a WindProtectionIEC
   *
   * @param command AssignTuunderToWindProtectionIECCommand
   */
  public void validate(AssignTuunderToWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTuunderToWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "AssignTuunderToWindProtectionIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTuunderToWindProtectionIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tuunder validation for a WindProtectionIEC
   *
   * @param command UnAssignTuunderFromWindProtectionIECCommand
   */
  public void validate(UnAssignTuunderFromWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTuunderFromWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "UnAssignTuunderFromWindProtectionIECCommand identifier should not be null");
  }
  /**
   * handles assign Uover validation for a WindProtectionIEC
   *
   * @param command AssignUoverToWindProtectionIECCommand
   */
  public void validate(AssignUoverToWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "AssignUoverToWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "AssignUoverToWindProtectionIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignUoverToWindProtectionIECCommand assignment should not be null");
  }

  /**
   * handles unassign Uover validation for a WindProtectionIEC
   *
   * @param command UnAssignUoverFromWindProtectionIECCommand
   */
  public void validate(UnAssignUoverFromWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUoverFromWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "UnAssignUoverFromWindProtectionIECCommand identifier should not be null");
  }
  /**
   * handles assign Uunder validation for a WindProtectionIEC
   *
   * @param command AssignUunderToWindProtectionIECCommand
   */
  public void validate(AssignUunderToWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "AssignUunderToWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "AssignUunderToWindProtectionIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignUunderToWindProtectionIECCommand assignment should not be null");
  }

  /**
   * handles unassign Uunder validation for a WindProtectionIEC
   *
   * @param command UnAssignUunderFromWindProtectionIECCommand
   */
  public void validate(UnAssignUunderFromWindProtectionIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUunderFromWindProtectionIECCommand should not be null");
    Assert.notNull(
        command.getWindProtectionIECId(),
        "UnAssignUunderFromWindProtectionIECCommand identifier should not be null");
  }
}
