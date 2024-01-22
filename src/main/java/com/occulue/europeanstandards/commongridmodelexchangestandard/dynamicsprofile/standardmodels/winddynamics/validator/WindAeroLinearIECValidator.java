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

public class WindAeroLinearIECValidator {

  /** default constructor */
  protected WindAeroLinearIECValidator() {}

  /** factory method */
  public static WindAeroLinearIECValidator getInstance() {
    return new WindAeroLinearIECValidator();
  }

  /** handles creation validation for a WindAeroLinearIEC */
  public void validate(CreateWindAeroLinearIECCommand windAeroLinearIEC) throws Exception {
    Assert.notNull(windAeroLinearIEC, "CreateWindAeroLinearIECCommand should not be null");
    //		Assert.isNull( windAeroLinearIEC.getWindAeroLinearIECId(), "CreateWindAeroLinearIECCommand
    // identifier should be null" );
  }

  /** handles update validation for a WindAeroLinearIEC */
  public void validate(UpdateWindAeroLinearIECCommand windAeroLinearIEC) throws Exception {
    Assert.notNull(windAeroLinearIEC, "UpdateWindAeroLinearIECCommand should not be null");
    Assert.notNull(
        windAeroLinearIEC.getWindAeroLinearIECId(),
        "UpdateWindAeroLinearIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindAeroLinearIEC */
  public void validate(DeleteWindAeroLinearIECCommand windAeroLinearIEC) throws Exception {
    Assert.notNull(windAeroLinearIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windAeroLinearIEC.getWindAeroLinearIECId(),
        "DeleteWindAeroLinearIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindAeroLinearIEC */
  public void validate(WindAeroLinearIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindAeroLinearIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindAeroLinearIECId(),
        "WindAeroLinearIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Dpomega validation for a WindAeroLinearIEC
   *
   * @param command AssignDpomegaToWindAeroLinearIECCommand
   */
  public void validate(AssignDpomegaToWindAeroLinearIECCommand command) throws Exception {
    Assert.notNull(command, "AssignDpomegaToWindAeroLinearIECCommand should not be null");
    Assert.notNull(
        command.getWindAeroLinearIECId(),
        "AssignDpomegaToWindAeroLinearIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDpomegaToWindAeroLinearIECCommand assignment should not be null");
  }

  /**
   * handles unassign Dpomega validation for a WindAeroLinearIEC
   *
   * @param command UnAssignDpomegaFromWindAeroLinearIECCommand
   */
  public void validate(UnAssignDpomegaFromWindAeroLinearIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDpomegaFromWindAeroLinearIECCommand should not be null");
    Assert.notNull(
        command.getWindAeroLinearIECId(),
        "UnAssignDpomegaFromWindAeroLinearIECCommand identifier should not be null");
  }
  /**
   * handles assign Dptheta validation for a WindAeroLinearIEC
   *
   * @param command AssignDpthetaToWindAeroLinearIECCommand
   */
  public void validate(AssignDpthetaToWindAeroLinearIECCommand command) throws Exception {
    Assert.notNull(command, "AssignDpthetaToWindAeroLinearIECCommand should not be null");
    Assert.notNull(
        command.getWindAeroLinearIECId(),
        "AssignDpthetaToWindAeroLinearIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDpthetaToWindAeroLinearIECCommand assignment should not be null");
  }

  /**
   * handles unassign Dptheta validation for a WindAeroLinearIEC
   *
   * @param command UnAssignDpthetaFromWindAeroLinearIECCommand
   */
  public void validate(UnAssignDpthetaFromWindAeroLinearIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDpthetaFromWindAeroLinearIECCommand should not be null");
    Assert.notNull(
        command.getWindAeroLinearIECId(),
        "UnAssignDpthetaFromWindAeroLinearIECCommand identifier should not be null");
  }
  /**
   * handles assign Omegazero validation for a WindAeroLinearIEC
   *
   * @param command AssignOmegazeroToWindAeroLinearIECCommand
   */
  public void validate(AssignOmegazeroToWindAeroLinearIECCommand command) throws Exception {
    Assert.notNull(command, "AssignOmegazeroToWindAeroLinearIECCommand should not be null");
    Assert.notNull(
        command.getWindAeroLinearIECId(),
        "AssignOmegazeroToWindAeroLinearIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOmegazeroToWindAeroLinearIECCommand assignment should not be null");
  }

  /**
   * handles unassign Omegazero validation for a WindAeroLinearIEC
   *
   * @param command UnAssignOmegazeroFromWindAeroLinearIECCommand
   */
  public void validate(UnAssignOmegazeroFromWindAeroLinearIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignOmegazeroFromWindAeroLinearIECCommand should not be null");
    Assert.notNull(
        command.getWindAeroLinearIECId(),
        "UnAssignOmegazeroFromWindAeroLinearIECCommand identifier should not be null");
  }
  /**
   * handles assign Pavail validation for a WindAeroLinearIEC
   *
   * @param command AssignPavailToWindAeroLinearIECCommand
   */
  public void validate(AssignPavailToWindAeroLinearIECCommand command) throws Exception {
    Assert.notNull(command, "AssignPavailToWindAeroLinearIECCommand should not be null");
    Assert.notNull(
        command.getWindAeroLinearIECId(),
        "AssignPavailToWindAeroLinearIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPavailToWindAeroLinearIECCommand assignment should not be null");
  }

  /**
   * handles unassign Pavail validation for a WindAeroLinearIEC
   *
   * @param command UnAssignPavailFromWindAeroLinearIECCommand
   */
  public void validate(UnAssignPavailFromWindAeroLinearIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPavailFromWindAeroLinearIECCommand should not be null");
    Assert.notNull(
        command.getWindAeroLinearIECId(),
        "UnAssignPavailFromWindAeroLinearIECCommand identifier should not be null");
  }
  /**
   * handles assign Thetazero validation for a WindAeroLinearIEC
   *
   * @param command AssignThetazeroToWindAeroLinearIECCommand
   */
  public void validate(AssignThetazeroToWindAeroLinearIECCommand command) throws Exception {
    Assert.notNull(command, "AssignThetazeroToWindAeroLinearIECCommand should not be null");
    Assert.notNull(
        command.getWindAeroLinearIECId(),
        "AssignThetazeroToWindAeroLinearIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignThetazeroToWindAeroLinearIECCommand assignment should not be null");
  }

  /**
   * handles unassign Thetazero validation for a WindAeroLinearIEC
   *
   * @param command UnAssignThetazeroFromWindAeroLinearIECCommand
   */
  public void validate(UnAssignThetazeroFromWindAeroLinearIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignThetazeroFromWindAeroLinearIECCommand should not be null");
    Assert.notNull(
        command.getWindAeroLinearIECId(),
        "UnAssignThetazeroFromWindAeroLinearIECCommand identifier should not be null");
  }
}
