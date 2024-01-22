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

public class WindGenTurbineType3bIECValidator {

  /** default constructor */
  protected WindGenTurbineType3bIECValidator() {}

  /** factory method */
  public static WindGenTurbineType3bIECValidator getInstance() {
    return new WindGenTurbineType3bIECValidator();
  }

  /** handles creation validation for a WindGenTurbineType3bIEC */
  public void validate(CreateWindGenTurbineType3bIECCommand windGenTurbineType3bIEC)
      throws Exception {
    Assert.notNull(
        windGenTurbineType3bIEC, "CreateWindGenTurbineType3bIECCommand should not be null");
    //		Assert.isNull( windGenTurbineType3bIEC.getWindGenTurbineType3bIECId(),
    // "CreateWindGenTurbineType3bIECCommand identifier should be null" );
  }

  /** handles update validation for a WindGenTurbineType3bIEC */
  public void validate(UpdateWindGenTurbineType3bIECCommand windGenTurbineType3bIEC)
      throws Exception {
    Assert.notNull(
        windGenTurbineType3bIEC, "UpdateWindGenTurbineType3bIECCommand should not be null");
    Assert.notNull(
        windGenTurbineType3bIEC.getWindGenTurbineType3bIECId(),
        "UpdateWindGenTurbineType3bIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindGenTurbineType3bIEC */
  public void validate(DeleteWindGenTurbineType3bIECCommand windGenTurbineType3bIEC)
      throws Exception {
    Assert.notNull(windGenTurbineType3bIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windGenTurbineType3bIEC.getWindGenTurbineType3bIECId(),
        "DeleteWindGenTurbineType3bIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindGenTurbineType3bIEC */
  public void validate(WindGenTurbineType3bIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindGenTurbineType3bIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindGenTurbineType3bIECId(),
        "WindGenTurbineType3bIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Fducw validation for a WindGenTurbineType3bIEC
   *
   * @param command AssignFducwToWindGenTurbineType3bIECCommand
   */
  public void validate(AssignFducwToWindGenTurbineType3bIECCommand command) throws Exception {
    Assert.notNull(command, "AssignFducwToWindGenTurbineType3bIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3bIECId(),
        "AssignFducwToWindGenTurbineType3bIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignFducwToWindGenTurbineType3bIECCommand assignment should not be null");
  }

  /**
   * handles unassign Fducw validation for a WindGenTurbineType3bIEC
   *
   * @param command UnAssignFducwFromWindGenTurbineType3bIECCommand
   */
  public void validate(UnAssignFducwFromWindGenTurbineType3bIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFducwFromWindGenTurbineType3bIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3bIECId(),
        "UnAssignFducwFromWindGenTurbineType3bIECCommand identifier should not be null");
  }
  /**
   * handles assign Mwtcwp validation for a WindGenTurbineType3bIEC
   *
   * @param command AssignMwtcwpToWindGenTurbineType3bIECCommand
   */
  public void validate(AssignMwtcwpToWindGenTurbineType3bIECCommand command) throws Exception {
    Assert.notNull(command, "AssignMwtcwpToWindGenTurbineType3bIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3bIECId(),
        "AssignMwtcwpToWindGenTurbineType3bIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMwtcwpToWindGenTurbineType3bIECCommand assignment should not be null");
  }

  /**
   * handles unassign Mwtcwp validation for a WindGenTurbineType3bIEC
   *
   * @param command UnAssignMwtcwpFromWindGenTurbineType3bIECCommand
   */
  public void validate(UnAssignMwtcwpFromWindGenTurbineType3bIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMwtcwpFromWindGenTurbineType3bIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3bIECId(),
        "UnAssignMwtcwpFromWindGenTurbineType3bIECCommand identifier should not be null");
  }
  /**
   * handles assign Tg validation for a WindGenTurbineType3bIEC
   *
   * @param command AssignTgToWindGenTurbineType3bIECCommand
   */
  public void validate(AssignTgToWindGenTurbineType3bIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTgToWindGenTurbineType3bIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3bIECId(),
        "AssignTgToWindGenTurbineType3bIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTgToWindGenTurbineType3bIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tg validation for a WindGenTurbineType3bIEC
   *
   * @param command UnAssignTgFromWindGenTurbineType3bIECCommand
   */
  public void validate(UnAssignTgFromWindGenTurbineType3bIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTgFromWindGenTurbineType3bIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3bIECId(),
        "UnAssignTgFromWindGenTurbineType3bIECCommand identifier should not be null");
  }
  /**
   * handles assign Two validation for a WindGenTurbineType3bIEC
   *
   * @param command AssignTwoToWindGenTurbineType3bIECCommand
   */
  public void validate(AssignTwoToWindGenTurbineType3bIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTwoToWindGenTurbineType3bIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3bIECId(),
        "AssignTwoToWindGenTurbineType3bIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTwoToWindGenTurbineType3bIECCommand assignment should not be null");
  }

  /**
   * handles unassign Two validation for a WindGenTurbineType3bIEC
   *
   * @param command UnAssignTwoFromWindGenTurbineType3bIECCommand
   */
  public void validate(UnAssignTwoFromWindGenTurbineType3bIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTwoFromWindGenTurbineType3bIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3bIECId(),
        "UnAssignTwoFromWindGenTurbineType3bIECCommand identifier should not be null");
  }
  /**
   * handles assign Xs validation for a WindGenTurbineType3bIEC
   *
   * @param command AssignXsToWindGenTurbineType3bIECCommand
   */
  public void validate(AssignXsToWindGenTurbineType3bIECCommand command) throws Exception {
    Assert.notNull(command, "AssignXsToWindGenTurbineType3bIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3bIECId(),
        "AssignXsToWindGenTurbineType3bIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXsToWindGenTurbineType3bIECCommand assignment should not be null");
  }

  /**
   * handles unassign Xs validation for a WindGenTurbineType3bIEC
   *
   * @param command UnAssignXsFromWindGenTurbineType3bIECCommand
   */
  public void validate(UnAssignXsFromWindGenTurbineType3bIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXsFromWindGenTurbineType3bIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3bIECId(),
        "UnAssignXsFromWindGenTurbineType3bIECCommand identifier should not be null");
  }
}
