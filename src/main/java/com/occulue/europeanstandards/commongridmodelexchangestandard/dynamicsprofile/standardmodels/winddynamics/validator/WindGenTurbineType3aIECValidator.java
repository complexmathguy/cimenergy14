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

public class WindGenTurbineType3aIECValidator {

  /** default constructor */
  protected WindGenTurbineType3aIECValidator() {}

  /** factory method */
  public static WindGenTurbineType3aIECValidator getInstance() {
    return new WindGenTurbineType3aIECValidator();
  }

  /** handles creation validation for a WindGenTurbineType3aIEC */
  public void validate(CreateWindGenTurbineType3aIECCommand windGenTurbineType3aIEC)
      throws Exception {
    Assert.notNull(
        windGenTurbineType3aIEC, "CreateWindGenTurbineType3aIECCommand should not be null");
    //		Assert.isNull( windGenTurbineType3aIEC.getWindGenTurbineType3aIECId(),
    // "CreateWindGenTurbineType3aIECCommand identifier should be null" );
  }

  /** handles update validation for a WindGenTurbineType3aIEC */
  public void validate(UpdateWindGenTurbineType3aIECCommand windGenTurbineType3aIEC)
      throws Exception {
    Assert.notNull(
        windGenTurbineType3aIEC, "UpdateWindGenTurbineType3aIECCommand should not be null");
    Assert.notNull(
        windGenTurbineType3aIEC.getWindGenTurbineType3aIECId(),
        "UpdateWindGenTurbineType3aIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindGenTurbineType3aIEC */
  public void validate(DeleteWindGenTurbineType3aIECCommand windGenTurbineType3aIEC)
      throws Exception {
    Assert.notNull(windGenTurbineType3aIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windGenTurbineType3aIEC.getWindGenTurbineType3aIECId(),
        "DeleteWindGenTurbineType3aIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindGenTurbineType3aIEC */
  public void validate(WindGenTurbineType3aIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindGenTurbineType3aIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindGenTurbineType3aIECId(),
        "WindGenTurbineType3aIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Kpc validation for a WindGenTurbineType3aIEC
   *
   * @param command AssignKpcToWindGenTurbineType3aIECCommand
   */
  public void validate(AssignKpcToWindGenTurbineType3aIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKpcToWindGenTurbineType3aIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3aIECId(),
        "AssignKpcToWindGenTurbineType3aIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKpcToWindGenTurbineType3aIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kpc validation for a WindGenTurbineType3aIEC
   *
   * @param command UnAssignKpcFromWindGenTurbineType3aIECCommand
   */
  public void validate(UnAssignKpcFromWindGenTurbineType3aIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpcFromWindGenTurbineType3aIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3aIECId(),
        "UnAssignKpcFromWindGenTurbineType3aIECCommand identifier should not be null");
  }
  /**
   * handles assign Tic validation for a WindGenTurbineType3aIEC
   *
   * @param command AssignTicToWindGenTurbineType3aIECCommand
   */
  public void validate(AssignTicToWindGenTurbineType3aIECCommand command) throws Exception {
    Assert.notNull(command, "AssignTicToWindGenTurbineType3aIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3aIECId(),
        "AssignTicToWindGenTurbineType3aIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTicToWindGenTurbineType3aIECCommand assignment should not be null");
  }

  /**
   * handles unassign Tic validation for a WindGenTurbineType3aIEC
   *
   * @param command UnAssignTicFromWindGenTurbineType3aIECCommand
   */
  public void validate(UnAssignTicFromWindGenTurbineType3aIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTicFromWindGenTurbineType3aIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3aIECId(),
        "UnAssignTicFromWindGenTurbineType3aIECCommand identifier should not be null");
  }
  /**
   * handles assign Xs validation for a WindGenTurbineType3aIEC
   *
   * @param command AssignXsToWindGenTurbineType3aIECCommand
   */
  public void validate(AssignXsToWindGenTurbineType3aIECCommand command) throws Exception {
    Assert.notNull(command, "AssignXsToWindGenTurbineType3aIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3aIECId(),
        "AssignXsToWindGenTurbineType3aIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignXsToWindGenTurbineType3aIECCommand assignment should not be null");
  }

  /**
   * handles unassign Xs validation for a WindGenTurbineType3aIEC
   *
   * @param command UnAssignXsFromWindGenTurbineType3aIECCommand
   */
  public void validate(UnAssignXsFromWindGenTurbineType3aIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXsFromWindGenTurbineType3aIECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3aIECId(),
        "UnAssignXsFromWindGenTurbineType3aIECCommand identifier should not be null");
  }
}
