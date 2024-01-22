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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype1dynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class PFVArType1IEEEPFControllerValidator {

  /** default constructor */
  protected PFVArType1IEEEPFControllerValidator() {}

  /** factory method */
  public static PFVArType1IEEEPFControllerValidator getInstance() {
    return new PFVArType1IEEEPFControllerValidator();
  }

  /** handles creation validation for a PFVArType1IEEEPFController */
  public void validate(CreatePFVArType1IEEEPFControllerCommand pFVArType1IEEEPFController)
      throws Exception {
    Assert.notNull(
        pFVArType1IEEEPFController, "CreatePFVArType1IEEEPFControllerCommand should not be null");
    //		Assert.isNull( pFVArType1IEEEPFController.getPFVArType1IEEEPFControllerId(),
    // "CreatePFVArType1IEEEPFControllerCommand identifier should be null" );
  }

  /** handles update validation for a PFVArType1IEEEPFController */
  public void validate(UpdatePFVArType1IEEEPFControllerCommand pFVArType1IEEEPFController)
      throws Exception {
    Assert.notNull(
        pFVArType1IEEEPFController, "UpdatePFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        pFVArType1IEEEPFController.getPFVArType1IEEEPFControllerId(),
        "UpdatePFVArType1IEEEPFControllerCommand identifier should not be null");
  }

  /** handles delete validation for a PFVArType1IEEEPFController */
  public void validate(DeletePFVArType1IEEEPFControllerCommand pFVArType1IEEEPFController)
      throws Exception {
    Assert.notNull(pFVArType1IEEEPFController, "{commandAlias} should not be null");
    Assert.notNull(
        pFVArType1IEEEPFController.getPFVArType1IEEEPFControllerId(),
        "DeletePFVArType1IEEEPFControllerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PFVArType1IEEEPFController */
  public void validate(PFVArType1IEEEPFControllerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PFVArType1IEEEPFControllerFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPFVArType1IEEEPFControllerId(),
        "PFVArType1IEEEPFControllerFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ovex validation for a PFVArType1IEEEPFController
   *
   * @param command AssignOvexToPFVArType1IEEEPFControllerCommand
   */
  public void validate(AssignOvexToPFVArType1IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignOvexToPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "AssignOvexToPFVArType1IEEEPFControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOvexToPFVArType1IEEEPFControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Ovex validation for a PFVArType1IEEEPFController
   *
   * @param command UnAssignOvexFromPFVArType1IEEEPFControllerCommand
   */
  public void validate(UnAssignOvexFromPFVArType1IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignOvexFromPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "UnAssignOvexFromPFVArType1IEEEPFControllerCommand identifier should not be null");
  }
  /**
   * handles assign Tpfc validation for a PFVArType1IEEEPFController
   *
   * @param command AssignTpfcToPFVArType1IEEEPFControllerCommand
   */
  public void validate(AssignTpfcToPFVArType1IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignTpfcToPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "AssignTpfcToPFVArType1IEEEPFControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTpfcToPFVArType1IEEEPFControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Tpfc validation for a PFVArType1IEEEPFController
   *
   * @param command UnAssignTpfcFromPFVArType1IEEEPFControllerCommand
   */
  public void validate(UnAssignTpfcFromPFVArType1IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpfcFromPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "UnAssignTpfcFromPFVArType1IEEEPFControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vitmin validation for a PFVArType1IEEEPFController
   *
   * @param command AssignVitminToPFVArType1IEEEPFControllerCommand
   */
  public void validate(AssignVitminToPFVArType1IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVitminToPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "AssignVitminToPFVArType1IEEEPFControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVitminToPFVArType1IEEEPFControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vitmin validation for a PFVArType1IEEEPFController
   *
   * @param command UnAssignVitminFromPFVArType1IEEEPFControllerCommand
   */
  public void validate(UnAssignVitminFromPFVArType1IEEEPFControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVitminFromPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "UnAssignVitminFromPFVArType1IEEEPFControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vpf validation for a PFVArType1IEEEPFController
   *
   * @param command AssignVpfToPFVArType1IEEEPFControllerCommand
   */
  public void validate(AssignVpfToPFVArType1IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVpfToPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "AssignVpfToPFVArType1IEEEPFControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVpfToPFVArType1IEEEPFControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vpf validation for a PFVArType1IEEEPFController
   *
   * @param command UnAssignVpfFromPFVArType1IEEEPFControllerCommand
   */
  public void validate(UnAssignVpfFromPFVArType1IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVpfFromPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "UnAssignVpfFromPFVArType1IEEEPFControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vpfcbw validation for a PFVArType1IEEEPFController
   *
   * @param command AssignVpfcbwToPFVArType1IEEEPFControllerCommand
   */
  public void validate(AssignVpfcbwToPFVArType1IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVpfcbwToPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "AssignVpfcbwToPFVArType1IEEEPFControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVpfcbwToPFVArType1IEEEPFControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vpfcbw validation for a PFVArType1IEEEPFController
   *
   * @param command UnAssignVpfcbwFromPFVArType1IEEEPFControllerCommand
   */
  public void validate(UnAssignVpfcbwFromPFVArType1IEEEPFControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVpfcbwFromPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "UnAssignVpfcbwFromPFVArType1IEEEPFControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vpfref validation for a PFVArType1IEEEPFController
   *
   * @param command AssignVpfrefToPFVArType1IEEEPFControllerCommand
   */
  public void validate(AssignVpfrefToPFVArType1IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVpfrefToPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "AssignVpfrefToPFVArType1IEEEPFControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVpfrefToPFVArType1IEEEPFControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vpfref validation for a PFVArType1IEEEPFController
   *
   * @param command UnAssignVpfrefFromPFVArType1IEEEPFControllerCommand
   */
  public void validate(UnAssignVpfrefFromPFVArType1IEEEPFControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVpfrefFromPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "UnAssignVpfrefFromPFVArType1IEEEPFControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vvtmax validation for a PFVArType1IEEEPFController
   *
   * @param command AssignVvtmaxToPFVArType1IEEEPFControllerCommand
   */
  public void validate(AssignVvtmaxToPFVArType1IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVvtmaxToPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "AssignVvtmaxToPFVArType1IEEEPFControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVvtmaxToPFVArType1IEEEPFControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vvtmax validation for a PFVArType1IEEEPFController
   *
   * @param command UnAssignVvtmaxFromPFVArType1IEEEPFControllerCommand
   */
  public void validate(UnAssignVvtmaxFromPFVArType1IEEEPFControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVvtmaxFromPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "UnAssignVvtmaxFromPFVArType1IEEEPFControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vvtmin validation for a PFVArType1IEEEPFController
   *
   * @param command AssignVvtminToPFVArType1IEEEPFControllerCommand
   */
  public void validate(AssignVvtminToPFVArType1IEEEPFControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVvtminToPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "AssignVvtminToPFVArType1IEEEPFControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVvtminToPFVArType1IEEEPFControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vvtmin validation for a PFVArType1IEEEPFController
   *
   * @param command UnAssignVvtminFromPFVArType1IEEEPFControllerCommand
   */
  public void validate(UnAssignVvtminFromPFVArType1IEEEPFControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVvtminFromPFVArType1IEEEPFControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEPFControllerId(),
        "UnAssignVvtminFromPFVArType1IEEEPFControllerCommand identifier should not be null");
  }
}
