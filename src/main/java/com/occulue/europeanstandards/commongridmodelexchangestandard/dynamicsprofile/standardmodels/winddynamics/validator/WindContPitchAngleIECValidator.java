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

public class WindContPitchAngleIECValidator {

  /** default constructor */
  protected WindContPitchAngleIECValidator() {}

  /** factory method */
  public static WindContPitchAngleIECValidator getInstance() {
    return new WindContPitchAngleIECValidator();
  }

  /** handles creation validation for a WindContPitchAngleIEC */
  public void validate(CreateWindContPitchAngleIECCommand windContPitchAngleIEC) throws Exception {
    Assert.notNull(windContPitchAngleIEC, "CreateWindContPitchAngleIECCommand should not be null");
    //		Assert.isNull( windContPitchAngleIEC.getWindContPitchAngleIECId(),
    // "CreateWindContPitchAngleIECCommand identifier should be null" );
  }

  /** handles update validation for a WindContPitchAngleIEC */
  public void validate(UpdateWindContPitchAngleIECCommand windContPitchAngleIEC) throws Exception {
    Assert.notNull(windContPitchAngleIEC, "UpdateWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        windContPitchAngleIEC.getWindContPitchAngleIECId(),
        "UpdateWindContPitchAngleIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindContPitchAngleIEC */
  public void validate(DeleteWindContPitchAngleIECCommand windContPitchAngleIEC) throws Exception {
    Assert.notNull(windContPitchAngleIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windContPitchAngleIEC.getWindContPitchAngleIECId(),
        "DeleteWindContPitchAngleIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindContPitchAngleIEC */
  public void validate(WindContPitchAngleIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindContPitchAngleIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindContPitchAngleIECId(),
        "WindContPitchAngleIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Dthetamax validation for a WindContPitchAngleIEC
   *
   * @param command AssignDthetamaxToWindContPitchAngleIECCommand
   */
  public void validate(AssignDthetamaxToWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "AssignDthetamaxToWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "AssignDthetamaxToWindContPitchAngleIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDthetamaxToWindContPitchAngleIECCommand assignment should not be null");
  }

  /**
   * handles unassign Dthetamax validation for a WindContPitchAngleIEC
   *
   * @param command UnAssignDthetamaxFromWindContPitchAngleIECCommand
   */
  public void validate(UnAssignDthetamaxFromWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDthetamaxFromWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "UnAssignDthetamaxFromWindContPitchAngleIECCommand identifier should not be null");
  }
  /**
   * handles assign Dthetamin validation for a WindContPitchAngleIEC
   *
   * @param command AssignDthetaminToWindContPitchAngleIECCommand
   */
  public void validate(AssignDthetaminToWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "AssignDthetaminToWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "AssignDthetaminToWindContPitchAngleIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDthetaminToWindContPitchAngleIECCommand assignment should not be null");
  }

  /**
   * handles unassign Dthetamin validation for a WindContPitchAngleIEC
   *
   * @param command UnAssignDthetaminFromWindContPitchAngleIECCommand
   */
  public void validate(UnAssignDthetaminFromWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDthetaminFromWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "UnAssignDthetaminFromWindContPitchAngleIECCommand identifier should not be null");
  }
  /**
   * handles assign Kic validation for a WindContPitchAngleIEC
   *
   * @param command AssignKicToWindContPitchAngleIECCommand
   */
  public void validate(AssignKicToWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKicToWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "AssignKicToWindContPitchAngleIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKicToWindContPitchAngleIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kic validation for a WindContPitchAngleIEC
   *
   * @param command UnAssignKicFromWindContPitchAngleIECCommand
   */
  public void validate(UnAssignKicFromWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKicFromWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "UnAssignKicFromWindContPitchAngleIECCommand identifier should not be null");
  }
  /**
   * handles assign Kiomega validation for a WindContPitchAngleIEC
   *
   * @param command AssignKiomegaToWindContPitchAngleIECCommand
   */
  public void validate(AssignKiomegaToWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKiomegaToWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "AssignKiomegaToWindContPitchAngleIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKiomegaToWindContPitchAngleIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kiomega validation for a WindContPitchAngleIEC
   *
   * @param command UnAssignKiomegaFromWindContPitchAngleIECCommand
   */
  public void validate(UnAssignKiomegaFromWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiomegaFromWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "UnAssignKiomegaFromWindContPitchAngleIECCommand identifier should not be null");
  }
  /**
   * handles assign Kpc validation for a WindContPitchAngleIEC
   *
   * @param command AssignKpcToWindContPitchAngleIECCommand
   */
  public void validate(AssignKpcToWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKpcToWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "AssignKpcToWindContPitchAngleIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKpcToWindContPitchAngleIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kpc validation for a WindContPitchAngleIEC
   *
   * @param command UnAssignKpcFromWindContPitchAngleIECCommand
   */
  public void validate(UnAssignKpcFromWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpcFromWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "UnAssignKpcFromWindContPitchAngleIECCommand identifier should not be null");
  }
  /**
   * handles assign Kpomega validation for a WindContPitchAngleIEC
   *
   * @param command AssignKpomegaToWindContPitchAngleIECCommand
   */
  public void validate(AssignKpomegaToWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKpomegaToWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "AssignKpomegaToWindContPitchAngleIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKpomegaToWindContPitchAngleIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kpomega validation for a WindContPitchAngleIEC
   *
   * @param command UnAssignKpomegaFromWindContPitchAngleIECCommand
   */
  public void validate(UnAssignKpomegaFromWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpomegaFromWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "UnAssignKpomegaFromWindContPitchAngleIECCommand identifier should not be null");
  }
  /**
   * handles assign Kpx validation for a WindContPitchAngleIEC
   *
   * @param command AssignKpxToWindContPitchAngleIECCommand
   */
  public void validate(AssignKpxToWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKpxToWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "AssignKpxToWindContPitchAngleIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKpxToWindContPitchAngleIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kpx validation for a WindContPitchAngleIEC
   *
   * @param command UnAssignKpxFromWindContPitchAngleIECCommand
   */
  public void validate(UnAssignKpxFromWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpxFromWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "UnAssignKpxFromWindContPitchAngleIECCommand identifier should not be null");
  }
  /**
   * handles assign Thetamax validation for a WindContPitchAngleIEC
   *
   * @param command AssignThetamaxToWindContPitchAngleIECCommand
   */
  public void validate(AssignThetamaxToWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "AssignThetamaxToWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "AssignThetamaxToWindContPitchAngleIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignThetamaxToWindContPitchAngleIECCommand assignment should not be null");
  }

  /**
   * handles unassign Thetamax validation for a WindContPitchAngleIEC
   *
   * @param command UnAssignThetamaxFromWindContPitchAngleIECCommand
   */
  public void validate(UnAssignThetamaxFromWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignThetamaxFromWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "UnAssignThetamaxFromWindContPitchAngleIECCommand identifier should not be null");
  }
  /**
   * handles assign Thetamin validation for a WindContPitchAngleIEC
   *
   * @param command AssignThetaminToWindContPitchAngleIECCommand
   */
  public void validate(AssignThetaminToWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "AssignThetaminToWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "AssignThetaminToWindContPitchAngleIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignThetaminToWindContPitchAngleIECCommand assignment should not be null");
  }

  /**
   * handles unassign Thetamin validation for a WindContPitchAngleIEC
   *
   * @param command UnAssignThetaminFromWindContPitchAngleIECCommand
   */
  public void validate(UnAssignThetaminFromWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignThetaminFromWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "UnAssignThetaminFromWindContPitchAngleIECCommand identifier should not be null");
  }
  /**
   * handles assign Ttheta validation for a WindContPitchAngleIEC
   *
   * @param command AssignTthetaToWindContPitchAngleIECCommand
   */
  public void validate(AssignTthetaToWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTthetaToWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "AssignTthetaToWindContPitchAngleIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTthetaToWindContPitchAngleIECCommand assignment should not be null");
  }

  /**
   * handles unassign Ttheta validation for a WindContPitchAngleIEC
   *
   * @param command UnAssignTthetaFromWindContPitchAngleIECCommand
   */
  public void validate(UnAssignTthetaFromWindContPitchAngleIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTthetaFromWindContPitchAngleIECCommand should not be null");
    Assert.notNull(
        command.getWindContPitchAngleIECId(),
        "UnAssignTthetaFromWindContPitchAngleIECCommand identifier should not be null");
  }
}
