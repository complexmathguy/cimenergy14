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

public class PFVArType1IEEEVArControllerValidator {

  /** default constructor */
  protected PFVArType1IEEEVArControllerValidator() {}

  /** factory method */
  public static PFVArType1IEEEVArControllerValidator getInstance() {
    return new PFVArType1IEEEVArControllerValidator();
  }

  /** handles creation validation for a PFVArType1IEEEVArController */
  public void validate(CreatePFVArType1IEEEVArControllerCommand pFVArType1IEEEVArController)
      throws Exception {
    Assert.notNull(
        pFVArType1IEEEVArController, "CreatePFVArType1IEEEVArControllerCommand should not be null");
    //		Assert.isNull( pFVArType1IEEEVArController.getPFVArType1IEEEVArControllerId(),
    // "CreatePFVArType1IEEEVArControllerCommand identifier should be null" );
  }

  /** handles update validation for a PFVArType1IEEEVArController */
  public void validate(UpdatePFVArType1IEEEVArControllerCommand pFVArType1IEEEVArController)
      throws Exception {
    Assert.notNull(
        pFVArType1IEEEVArController, "UpdatePFVArType1IEEEVArControllerCommand should not be null");
    Assert.notNull(
        pFVArType1IEEEVArController.getPFVArType1IEEEVArControllerId(),
        "UpdatePFVArType1IEEEVArControllerCommand identifier should not be null");
  }

  /** handles delete validation for a PFVArType1IEEEVArController */
  public void validate(DeletePFVArType1IEEEVArControllerCommand pFVArType1IEEEVArController)
      throws Exception {
    Assert.notNull(pFVArType1IEEEVArController, "{commandAlias} should not be null");
    Assert.notNull(
        pFVArType1IEEEVArController.getPFVArType1IEEEVArControllerId(),
        "DeletePFVArType1IEEEVArControllerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PFVArType1IEEEVArController */
  public void validate(PFVArType1IEEEVArControllerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PFVArType1IEEEVArControllerFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPFVArType1IEEEVArControllerId(),
        "PFVArType1IEEEVArControllerFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Tvarc validation for a PFVArType1IEEEVArController
   *
   * @param command AssignTvarcToPFVArType1IEEEVArControllerCommand
   */
  public void validate(AssignTvarcToPFVArType1IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignTvarcToPFVArType1IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEVArControllerId(),
        "AssignTvarcToPFVArType1IEEEVArControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTvarcToPFVArType1IEEEVArControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Tvarc validation for a PFVArType1IEEEVArController
   *
   * @param command UnAssignTvarcFromPFVArType1IEEEVArControllerCommand
   */
  public void validate(UnAssignTvarcFromPFVArType1IEEEVArControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignTvarcFromPFVArType1IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEVArControllerId(),
        "UnAssignTvarcFromPFVArType1IEEEVArControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vvar validation for a PFVArType1IEEEVArController
   *
   * @param command AssignVvarToPFVArType1IEEEVArControllerCommand
   */
  public void validate(AssignVvarToPFVArType1IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVvarToPFVArType1IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEVArControllerId(),
        "AssignVvarToPFVArType1IEEEVArControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVvarToPFVArType1IEEEVArControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vvar validation for a PFVArType1IEEEVArController
   *
   * @param command UnAssignVvarFromPFVArType1IEEEVArControllerCommand
   */
  public void validate(UnAssignVvarFromPFVArType1IEEEVArControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVvarFromPFVArType1IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEVArControllerId(),
        "UnAssignVvarFromPFVArType1IEEEVArControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vvarcbw validation for a PFVArType1IEEEVArController
   *
   * @param command AssignVvarcbwToPFVArType1IEEEVArControllerCommand
   */
  public void validate(AssignVvarcbwToPFVArType1IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVvarcbwToPFVArType1IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEVArControllerId(),
        "AssignVvarcbwToPFVArType1IEEEVArControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVvarcbwToPFVArType1IEEEVArControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vvarcbw validation for a PFVArType1IEEEVArController
   *
   * @param command UnAssignVvarcbwFromPFVArType1IEEEVArControllerCommand
   */
  public void validate(UnAssignVvarcbwFromPFVArType1IEEEVArControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVvarcbwFromPFVArType1IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEVArControllerId(),
        "UnAssignVvarcbwFromPFVArType1IEEEVArControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vvarref validation for a PFVArType1IEEEVArController
   *
   * @param command AssignVvarrefToPFVArType1IEEEVArControllerCommand
   */
  public void validate(AssignVvarrefToPFVArType1IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVvarrefToPFVArType1IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEVArControllerId(),
        "AssignVvarrefToPFVArType1IEEEVArControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVvarrefToPFVArType1IEEEVArControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vvarref validation for a PFVArType1IEEEVArController
   *
   * @param command UnAssignVvarrefFromPFVArType1IEEEVArControllerCommand
   */
  public void validate(UnAssignVvarrefFromPFVArType1IEEEVArControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVvarrefFromPFVArType1IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEVArControllerId(),
        "UnAssignVvarrefFromPFVArType1IEEEVArControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vvtmax validation for a PFVArType1IEEEVArController
   *
   * @param command AssignVvtmaxToPFVArType1IEEEVArControllerCommand
   */
  public void validate(AssignVvtmaxToPFVArType1IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVvtmaxToPFVArType1IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEVArControllerId(),
        "AssignVvtmaxToPFVArType1IEEEVArControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVvtmaxToPFVArType1IEEEVArControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vvtmax validation for a PFVArType1IEEEVArController
   *
   * @param command UnAssignVvtmaxFromPFVArType1IEEEVArControllerCommand
   */
  public void validate(UnAssignVvtmaxFromPFVArType1IEEEVArControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVvtmaxFromPFVArType1IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEVArControllerId(),
        "UnAssignVvtmaxFromPFVArType1IEEEVArControllerCommand identifier should not be null");
  }
  /**
   * handles assign Vvtmin validation for a PFVArType1IEEEVArController
   *
   * @param command AssignVvtminToPFVArType1IEEEVArControllerCommand
   */
  public void validate(AssignVvtminToPFVArType1IEEEVArControllerCommand command) throws Exception {
    Assert.notNull(command, "AssignVvtminToPFVArType1IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEVArControllerId(),
        "AssignVvtminToPFVArType1IEEEVArControllerCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVvtminToPFVArType1IEEEVArControllerCommand assignment should not be null");
  }

  /**
   * handles unassign Vvtmin validation for a PFVArType1IEEEVArController
   *
   * @param command UnAssignVvtminFromPFVArType1IEEEVArControllerCommand
   */
  public void validate(UnAssignVvtminFromPFVArType1IEEEVArControllerCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignVvtminFromPFVArType1IEEEVArControllerCommand should not be null");
    Assert.notNull(
        command.getPFVArType1IEEEVArControllerId(),
        "UnAssignVvtminFromPFVArType1IEEEVArControllerCommand identifier should not be null");
  }
}
