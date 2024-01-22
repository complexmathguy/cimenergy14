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

public class WindGenTurbineType3IECValidator {

  /** default constructor */
  protected WindGenTurbineType3IECValidator() {}

  /** factory method */
  public static WindGenTurbineType3IECValidator getInstance() {
    return new WindGenTurbineType3IECValidator();
  }

  /** handles creation validation for a WindGenTurbineType3IEC */
  public void validate(CreateWindGenTurbineType3IECCommand windGenTurbineType3IEC)
      throws Exception {
    Assert.notNull(
        windGenTurbineType3IEC, "CreateWindGenTurbineType3IECCommand should not be null");
    //		Assert.isNull( windGenTurbineType3IEC.getWindGenTurbineType3IECId(),
    // "CreateWindGenTurbineType3IECCommand identifier should be null" );
  }

  /** handles update validation for a WindGenTurbineType3IEC */
  public void validate(UpdateWindGenTurbineType3IECCommand windGenTurbineType3IEC)
      throws Exception {
    Assert.notNull(
        windGenTurbineType3IEC, "UpdateWindGenTurbineType3IECCommand should not be null");
    Assert.notNull(
        windGenTurbineType3IEC.getWindGenTurbineType3IECId(),
        "UpdateWindGenTurbineType3IECCommand identifier should not be null");
  }

  /** handles delete validation for a WindGenTurbineType3IEC */
  public void validate(DeleteWindGenTurbineType3IECCommand windGenTurbineType3IEC)
      throws Exception {
    Assert.notNull(windGenTurbineType3IEC, "{commandAlias} should not be null");
    Assert.notNull(
        windGenTurbineType3IEC.getWindGenTurbineType3IECId(),
        "DeleteWindGenTurbineType3IECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindGenTurbineType3IEC */
  public void validate(WindGenTurbineType3IECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindGenTurbineType3IECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindGenTurbineType3IECId(),
        "WindGenTurbineType3IECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Dipmax validation for a WindGenTurbineType3IEC
   *
   * @param command AssignDipmaxToWindGenTurbineType3IECCommand
   */
  public void validate(AssignDipmaxToWindGenTurbineType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignDipmaxToWindGenTurbineType3IECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3IECId(),
        "AssignDipmaxToWindGenTurbineType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDipmaxToWindGenTurbineType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Dipmax validation for a WindGenTurbineType3IEC
   *
   * @param command UnAssignDipmaxFromWindGenTurbineType3IECCommand
   */
  public void validate(UnAssignDipmaxFromWindGenTurbineType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDipmaxFromWindGenTurbineType3IECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3IECId(),
        "UnAssignDipmaxFromWindGenTurbineType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Diqmax validation for a WindGenTurbineType3IEC
   *
   * @param command AssignDiqmaxToWindGenTurbineType3IECCommand
   */
  public void validate(AssignDiqmaxToWindGenTurbineType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignDiqmaxToWindGenTurbineType3IECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3IECId(),
        "AssignDiqmaxToWindGenTurbineType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDiqmaxToWindGenTurbineType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Diqmax validation for a WindGenTurbineType3IEC
   *
   * @param command UnAssignDiqmaxFromWindGenTurbineType3IECCommand
   */
  public void validate(UnAssignDiqmaxFromWindGenTurbineType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDiqmaxFromWindGenTurbineType3IECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3IECId(),
        "UnAssignDiqmaxFromWindGenTurbineType3IECCommand identifier should not be null");
  }
  /**
   * handles assign WindGenTurbineType3IEC validation for a WindGenTurbineType3IEC
   *
   * @param command AssignWindGenTurbineType3IECToWindGenTurbineType3IECCommand
   */
  public void validate(AssignWindGenTurbineType3IECToWindGenTurbineType3IECCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignWindGenTurbineType3IECToWindGenTurbineType3IECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3IECId(),
        "AssignWindGenTurbineType3IECToWindGenTurbineType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignWindGenTurbineType3IECToWindGenTurbineType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign WindGenTurbineType3IEC validation for a WindGenTurbineType3IEC
   *
   * @param command UnAssignWindGenTurbineType3IECFromWindGenTurbineType3IECCommand
   */
  public void validate(UnAssignWindGenTurbineType3IECFromWindGenTurbineType3IECCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignWindGenTurbineType3IECFromWindGenTurbineType3IECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType3IECId(),
        "UnAssignWindGenTurbineType3IECFromWindGenTurbineType3IECCommand identifier should not be null");
  }
}
