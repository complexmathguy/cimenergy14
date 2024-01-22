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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class PFVArType2IEEEVArControllerValidator {

  /** default constructor */
  protected PFVArType2IEEEVArControllerValidator() {}

  /** factory method */
  public static PFVArType2IEEEVArControllerValidator getInstance() {
    return new PFVArType2IEEEVArControllerValidator();
  }

  /** handles creation validation for a PFVArType2IEEEVArController */
  public void validate(CreatePFVArType2IEEEVArControllerCommand pFVArType2IEEEVArController)
      throws Exception {
    Assert.notNull(
        pFVArType2IEEEVArController, "CreatePFVArType2IEEEVArControllerCommand should not be null");
    //		Assert.isNull( pFVArType2IEEEVArController.getPFVArType2IEEEVArControllerId(),
    // "CreatePFVArType2IEEEVArControllerCommand identifier should be null" );
  }

  /** handles update validation for a PFVArType2IEEEVArController */
  public void validate(UpdatePFVArType2IEEEVArControllerCommand pFVArType2IEEEVArController)
      throws Exception {
    Assert.notNull(
        pFVArType2IEEEVArController, "UpdatePFVArType2IEEEVArControllerCommand should not be null");
    Assert.notNull(
        pFVArType2IEEEVArController.getPFVArType2IEEEVArControllerId(),
        "UpdatePFVArType2IEEEVArControllerCommand identifier should not be null");
  }

  /** handles delete validation for a PFVArType2IEEEVArController */
  public void validate(DeletePFVArType2IEEEVArControllerCommand pFVArType2IEEEVArController)
      throws Exception {
    Assert.notNull(pFVArType2IEEEVArController, "{commandAlias} should not be null");
    Assert.notNull(
        pFVArType2IEEEVArController.getPFVArType2IEEEVArControllerId(),
        "DeletePFVArType2IEEEVArControllerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PFVArType2IEEEVArController */
  public void validate(PFVArType2IEEEVArControllerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PFVArType2IEEEVArControllerFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPFVArType2IEEEVArControllerId(),
        "PFVArType2IEEEVArControllerFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Exlon validation for a PFVArType2IEEEVArController
   *
   * @param command AssignExlonToPFVArType2IEEEVArControllerCommand
   */
  public void validate(AssignExlonToPFVArType2IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignExlonToPFVArType2IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEVArControllerId(),
        "AssignExlonToPFVArType2IEEEVArControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignExlonToPFVArType2IEEEVArControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Exlon validation for a PFVArType2IEEEVArController
   *
   * @param command UnAssignExlonFromPFVArType2IEEEVArControllerCommand
   */
  public void validate(UnAssignExlonFromPFVArType2IEEEVArControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignExlonFromPFVArType2IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEVArControllerId(),
        "UnAssignExlonFromPFVArType2IEEEVArControllerCommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a PFVArType2IEEEVArController
   *
   * @param command AssignKiToPFVArType2IEEEVArControllerCommand
   */
  public void validate(AssignKiToPFVArType2IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignKiToPFVArType2IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEVArControllerId(),
        "AssignKiToPFVArType2IEEEVArControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKiToPFVArType2IEEEVArControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a PFVArType2IEEEVArController
   *
   * @param command UnAssignKiFromPFVArType2IEEEVArControllerCommand
   */
  public void validate(UnAssignKiFromPFVArType2IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromPFVArType2IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEVArControllerId(),
        "UnAssignKiFromPFVArType2IEEEVArControllerCommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a PFVArType2IEEEVArController
   *
   * @param command AssignKpToPFVArType2IEEEVArControllerCommand
   */
  public void validate(AssignKpToPFVArType2IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignKpToPFVArType2IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEVArControllerId(),
        "AssignKpToPFVArType2IEEEVArControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKpToPFVArType2IEEEVArControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a PFVArType2IEEEVArController
   *
   * @param command UnAssignKpFromPFVArType2IEEEVArControllerCommand
   */
  public void validate(UnAssignKpFromPFVArType2IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromPFVArType2IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEVArControllerId(),
        "UnAssignKpFromPFVArType2IEEEVArControllerCommand identifier should not be null");
  }
  /**
   * handles assign Qref validation for a PFVArType2IEEEVArController
   *
   * @param command AssignQrefToPFVArType2IEEEVArControllerCommand
   */
  public void validate(AssignQrefToPFVArType2IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignQrefToPFVArType2IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEVArControllerId(),
        "AssignQrefToPFVArType2IEEEVArControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignQrefToPFVArType2IEEEVArControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Qref validation for a PFVArType2IEEEVArController
   *
   * @param command UnAssignQrefFromPFVArType2IEEEVArControllerCommand
   */
  public void validate(UnAssignQrefFromPFVArType2IEEEVArControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignQrefFromPFVArType2IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEVArControllerId(),
        "UnAssignQrefFromPFVArType2IEEEVArControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vclmt validation for a PFVArType2IEEEVArController
   *
   * @param command AssignVclmtToPFVArType2IEEEVArControllerCommand
   */
  public void validate(AssignVclmtToPFVArType2IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVclmtToPFVArType2IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEVArControllerId(),
        "AssignVclmtToPFVArType2IEEEVArControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVclmtToPFVArType2IEEEVArControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vclmt validation for a PFVArType2IEEEVArController
   *
   * @param command UnAssignVclmtFromPFVArType2IEEEVArControllerCommand
   */
  public void validate(UnAssignVclmtFromPFVArType2IEEEVArControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVclmtFromPFVArType2IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEVArControllerId(),
        "UnAssignVclmtFromPFVArType2IEEEVArControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vref validation for a PFVArType2IEEEVArController
   *
   * @param command AssignVrefToPFVArType2IEEEVArControllerCommand
   */
  public void validate(AssignVrefToPFVArType2IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVrefToPFVArType2IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEVArControllerId(),
        "AssignVrefToPFVArType2IEEEVArControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVrefToPFVArType2IEEEVArControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vref validation for a PFVArType2IEEEVArController
   *
   * @param command UnAssignVrefFromPFVArType2IEEEVArControllerCommand
   */
  public void validate(UnAssignVrefFromPFVArType2IEEEVArControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVrefFromPFVArType2IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEVArControllerId(),
        "UnAssignVrefFromPFVArType2IEEEVArControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vs validation for a PFVArType2IEEEVArController
   *
   * @param command AssignVsToPFVArType2IEEEVArControllerCommand
   */
  public void validate(AssignVsToPFVArType2IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVsToPFVArType2IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEVArControllerId(),
        "AssignVsToPFVArType2IEEEVArControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVsToPFVArType2IEEEVArControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vs validation for a PFVArType2IEEEVArController
   *
   * @param command UnAssignVsFromPFVArType2IEEEVArControllerCommand
   */
  public void validate(UnAssignVsFromPFVArType2IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsFromPFVArType2IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEVArControllerId(),
        "UnAssignVsFromPFVArType2IEEEVArControllerCommand identifier should not be null");
  }
}
