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

public class WindContCurrLimIECValidator {

  /** default constructor */
  protected WindContCurrLimIECValidator() {}

  /** factory method */
  public static WindContCurrLimIECValidator getInstance() {
    return new WindContCurrLimIECValidator();
  }

  /** handles creation validation for a WindContCurrLimIEC */
  public void validate(CreateWindContCurrLimIECCommand windContCurrLimIEC) throws Exception {
    Assert.notNull(windContCurrLimIEC, "CreateWindContCurrLimIECCommand should not be null");
    //		Assert.isNull( windContCurrLimIEC.getWindContCurrLimIECId(),
    // "CreateWindContCurrLimIECCommand identifier should be null" );
  }

  /** handles update validation for a WindContCurrLimIEC */
  public void validate(UpdateWindContCurrLimIECCommand windContCurrLimIEC) throws Exception {
    Assert.notNull(windContCurrLimIEC, "UpdateWindContCurrLimIECCommand should not be null");
    Assert.notNull(
        windContCurrLimIEC.getWindContCurrLimIECId(),
        "UpdateWindContCurrLimIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindContCurrLimIEC */
  public void validate(DeleteWindContCurrLimIECCommand windContCurrLimIEC) throws Exception {
    Assert.notNull(windContCurrLimIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windContCurrLimIEC.getWindContCurrLimIECId(),
        "DeleteWindContCurrLimIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindContCurrLimIEC */
  public void validate(WindContCurrLimIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindContCurrLimIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindContCurrLimIECId(),
        "WindContCurrLimIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Imax validation for a WindContCurrLimIEC
   *
   * @param command AssignImaxToWindContCurrLimIECCommand
   */
  public void validate(AssignImaxToWindContCurrLimIECCommand command) throws Exception {
    Assert.notNull(command, "AssignImaxToWindContCurrLimIECCommand should not be null");
    Assert.notNull(
        command.getWindContCurrLimIECId(),
        "AssignImaxToWindContCurrLimIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignImaxToWindContCurrLimIECCommand assignment should not be null");
  }

  /**
   * handles unassign Imax validation for a WindContCurrLimIEC
   *
   * @param command UnAssignImaxFromWindContCurrLimIECCommand
   */
  public void validate(UnAssignImaxFromWindContCurrLimIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignImaxFromWindContCurrLimIECCommand should not be null");
    Assert.notNull(
        command.getWindContCurrLimIECId(),
        "UnAssignImaxFromWindContCurrLimIECCommand identifier should not be null");
  }
  /**
   * handles assign Imaxdip validation for a WindContCurrLimIEC
   *
   * @param command AssignImaxdipToWindContCurrLimIECCommand
   */
  public void validate(AssignImaxdipToWindContCurrLimIECCommand command) throws Exception {
    Assert.notNull(command, "AssignImaxdipToWindContCurrLimIECCommand should not be null");
    Assert.notNull(
        command.getWindContCurrLimIECId(),
        "AssignImaxdipToWindContCurrLimIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignImaxdipToWindContCurrLimIECCommand assignment should not be null");
  }

  /**
   * handles unassign Imaxdip validation for a WindContCurrLimIEC
   *
   * @param command UnAssignImaxdipFromWindContCurrLimIECCommand
   */
  public void validate(UnAssignImaxdipFromWindContCurrLimIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignImaxdipFromWindContCurrLimIECCommand should not be null");
    Assert.notNull(
        command.getWindContCurrLimIECId(),
        "UnAssignImaxdipFromWindContCurrLimIECCommand identifier should not be null");
  }
  /**
   * handles assign Mdfslim validation for a WindContCurrLimIEC
   *
   * @param command AssignMdfslimToWindContCurrLimIECCommand
   */
  public void validate(AssignMdfslimToWindContCurrLimIECCommand command) throws Exception {
    Assert.notNull(command, "AssignMdfslimToWindContCurrLimIECCommand should not be null");
    Assert.notNull(
        command.getWindContCurrLimIECId(),
        "AssignMdfslimToWindContCurrLimIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMdfslimToWindContCurrLimIECCommand assignment should not be null");
  }

  /**
   * handles unassign Mdfslim validation for a WindContCurrLimIEC
   *
   * @param command UnAssignMdfslimFromWindContCurrLimIECCommand
   */
  public void validate(UnAssignMdfslimFromWindContCurrLimIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMdfslimFromWindContCurrLimIECCommand should not be null");
    Assert.notNull(
        command.getWindContCurrLimIECId(),
        "UnAssignMdfslimFromWindContCurrLimIECCommand identifier should not be null");
  }
  /**
   * handles assign Mqpri validation for a WindContCurrLimIEC
   *
   * @param command AssignMqpriToWindContCurrLimIECCommand
   */
  public void validate(AssignMqpriToWindContCurrLimIECCommand command) throws Exception {
    Assert.notNull(command, "AssignMqpriToWindContCurrLimIECCommand should not be null");
    Assert.notNull(
        command.getWindContCurrLimIECId(),
        "AssignMqpriToWindContCurrLimIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMqpriToWindContCurrLimIECCommand assignment should not be null");
  }

  /**
   * handles unassign Mqpri validation for a WindContCurrLimIEC
   *
   * @param command UnAssignMqpriFromWindContCurrLimIECCommand
   */
  public void validate(UnAssignMqpriFromWindContCurrLimIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMqpriFromWindContCurrLimIECCommand should not be null");
    Assert.notNull(
        command.getWindContCurrLimIECId(),
        "UnAssignMqpriFromWindContCurrLimIECCommand identifier should not be null");
  }
  /**
   * handles assign Tufilt validation for a WindContCurrLimIEC
   *
   * @param command AssignTufiltToWindContCurrLimIECCommand
   */
  public void validate(AssignTufiltToWindContCurrLimIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTufiltToWindContCurrLimIECCommand should not be null");
    Assert.notNull(
        command.getWindContCurrLimIECId(),
        "AssignTufiltToWindContCurrLimIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTufiltToWindContCurrLimIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tufilt validation for a WindContCurrLimIEC
   *
   * @param command UnAssignTufiltFromWindContCurrLimIECCommand
   */
  public void validate(UnAssignTufiltFromWindContCurrLimIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTufiltFromWindContCurrLimIECCommand should not be null");
    Assert.notNull(
        command.getWindContCurrLimIECId(),
        "UnAssignTufiltFromWindContCurrLimIECCommand identifier should not be null");
  }
}
