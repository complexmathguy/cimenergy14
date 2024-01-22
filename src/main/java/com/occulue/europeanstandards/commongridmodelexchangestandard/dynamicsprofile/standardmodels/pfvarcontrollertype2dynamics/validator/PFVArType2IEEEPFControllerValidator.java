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

public class PFVArType2IEEEPFControllerValidator {

  /** default constructor */
  protected PFVArType2IEEEPFControllerValidator() {}

  /** factory method */
  public static PFVArType2IEEEPFControllerValidator getInstance() {
    return new PFVArType2IEEEPFControllerValidator();
  }

  /** handles creation validation for a PFVArType2IEEEPFController */
  public void validate(CreatePFVArType2IEEEPFControllerCommand pFVArType2IEEEPFController)
      throws Exception {
    Assert.notNull(
        pFVArType2IEEEPFController, "CreatePFVArType2IEEEPFControllerCommand should not be null");
    //		Assert.isNull( pFVArType2IEEEPFController.getPFVArType2IEEEPFControllerId(),
    // "CreatePFVArType2IEEEPFControllerCommand identifier should be null" );
  }

  /** handles update validation for a PFVArType2IEEEPFController */
  public void validate(UpdatePFVArType2IEEEPFControllerCommand pFVArType2IEEEPFController)
      throws Exception {
    Assert.notNull(
        pFVArType2IEEEPFController, "UpdatePFVArType2IEEEPFControllerCommand should not be null");
    Assert.notNull(
        pFVArType2IEEEPFController.getPFVArType2IEEEPFControllerId(),
        "UpdatePFVArType2IEEEPFControllerCommand identifier should not be null");
  }

  /** handles delete validation for a PFVArType2IEEEPFController */
  public void validate(DeletePFVArType2IEEEPFControllerCommand pFVArType2IEEEPFController)
      throws Exception {
    Assert.notNull(pFVArType2IEEEPFController, "{commandAlias} should not be null");
    Assert.notNull(
        pFVArType2IEEEPFController.getPFVArType2IEEEPFControllerId(),
        "DeletePFVArType2IEEEPFControllerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PFVArType2IEEEPFController */
  public void validate(PFVArType2IEEEPFControllerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PFVArType2IEEEPFControllerFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPFVArType2IEEEPFControllerId(),
        "PFVArType2IEEEPFControllerFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Exlon validation for a PFVArType2IEEEPFController
   *
   * @param command AssignExlonToPFVArType2IEEEPFControllerCommand
   */
  public void validate(AssignExlonToPFVArType2IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignExlonToPFVArType2IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEPFControllerId(),
        "AssignExlonToPFVArType2IEEEPFControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignExlonToPFVArType2IEEEPFControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Exlon validation for a PFVArType2IEEEPFController
   *
   * @param command UnAssignExlonFromPFVArType2IEEEPFControllerCommand
   */
  public void validate(UnAssignExlonFromPFVArType2IEEEPFControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignExlonFromPFVArType2IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEPFControllerId(),
        "UnAssignExlonFromPFVArType2IEEEPFControllerCommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a PFVArType2IEEEPFController
   *
   * @param command AssignKiToPFVArType2IEEEPFControllerCommand
   */
  public void validate(AssignKiToPFVArType2IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignKiToPFVArType2IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEPFControllerId(),
        "AssignKiToPFVArType2IEEEPFControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKiToPFVArType2IEEEPFControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a PFVArType2IEEEPFController
   *
   * @param command UnAssignKiFromPFVArType2IEEEPFControllerCommand
   */
  public void validate(UnAssignKiFromPFVArType2IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromPFVArType2IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEPFControllerId(),
        "UnAssignKiFromPFVArType2IEEEPFControllerCommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a PFVArType2IEEEPFController
   *
   * @param command AssignKpToPFVArType2IEEEPFControllerCommand
   */
  public void validate(AssignKpToPFVArType2IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignKpToPFVArType2IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEPFControllerId(),
        "AssignKpToPFVArType2IEEEPFControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKpToPFVArType2IEEEPFControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a PFVArType2IEEEPFController
   *
   * @param command UnAssignKpFromPFVArType2IEEEPFControllerCommand
   */
  public void validate(UnAssignKpFromPFVArType2IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromPFVArType2IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEPFControllerId(),
        "UnAssignKpFromPFVArType2IEEEPFControllerCommand identifier should not be null");
  }
  /**
   * handles assign Pfref validation for a PFVArType2IEEEPFController
   *
   * @param command AssignPfrefToPFVArType2IEEEPFControllerCommand
   */
  public void validate(AssignPfrefToPFVArType2IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignPfrefToPFVArType2IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEPFControllerId(),
        "AssignPfrefToPFVArType2IEEEPFControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPfrefToPFVArType2IEEEPFControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Pfref validation for a PFVArType2IEEEPFController
   *
   * @param command UnAssignPfrefFromPFVArType2IEEEPFControllerCommand
   */
  public void validate(UnAssignPfrefFromPFVArType2IEEEPFControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignPfrefFromPFVArType2IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEPFControllerId(),
        "UnAssignPfrefFromPFVArType2IEEEPFControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vclmt validation for a PFVArType2IEEEPFController
   *
   * @param command AssignVclmtToPFVArType2IEEEPFControllerCommand
   */
  public void validate(AssignVclmtToPFVArType2IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVclmtToPFVArType2IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEPFControllerId(),
        "AssignVclmtToPFVArType2IEEEPFControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVclmtToPFVArType2IEEEPFControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vclmt validation for a PFVArType2IEEEPFController
   *
   * @param command UnAssignVclmtFromPFVArType2IEEEPFControllerCommand
   */
  public void validate(UnAssignVclmtFromPFVArType2IEEEPFControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVclmtFromPFVArType2IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEPFControllerId(),
        "UnAssignVclmtFromPFVArType2IEEEPFControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vref validation for a PFVArType2IEEEPFController
   *
   * @param command AssignVrefToPFVArType2IEEEPFControllerCommand
   */
  public void validate(AssignVrefToPFVArType2IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVrefToPFVArType2IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEPFControllerId(),
        "AssignVrefToPFVArType2IEEEPFControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVrefToPFVArType2IEEEPFControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vref validation for a PFVArType2IEEEPFController
   *
   * @param command UnAssignVrefFromPFVArType2IEEEPFControllerCommand
   */
  public void validate(UnAssignVrefFromPFVArType2IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrefFromPFVArType2IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEPFControllerId(),
        "UnAssignVrefFromPFVArType2IEEEPFControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vs validation for a PFVArType2IEEEPFController
   *
   * @param command AssignVsToPFVArType2IEEEPFControllerCommand
   */
  public void validate(AssignVsToPFVArType2IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVsToPFVArType2IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEPFControllerId(),
        "AssignVsToPFVArType2IEEEPFControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVsToPFVArType2IEEEPFControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vs validation for a PFVArType2IEEEPFController
   *
   * @param command UnAssignVsFromPFVArType2IEEEPFControllerCommand
   */
  public void validate(UnAssignVsFromPFVArType2IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVsFromPFVArType2IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType2IEEEPFControllerId(),
        "UnAssignVsFromPFVArType2IEEEPFControllerCommand identifier should not be null");
  }
}
