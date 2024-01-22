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

public class WindTurbineType3or4IECValidator {

  /** default constructor */
  protected WindTurbineType3or4IECValidator() {}

  /** factory method */
  public static WindTurbineType3or4IECValidator getInstance() {
    return new WindTurbineType3or4IECValidator();
  }

  /** handles creation validation for a WindTurbineType3or4IEC */
  public void validate(CreateWindTurbineType3or4IECCommand windTurbineType3or4IEC)
      throws Exception {
    Assert.notNull(
        windTurbineType3or4IEC, "CreateWindTurbineType3or4IECCommand should not be null");
    //		Assert.isNull( windTurbineType3or4IEC.getWindTurbineType3or4IECId(),
    // "CreateWindTurbineType3or4IECCommand identifier should be null" );
  }

  /** handles update validation for a WindTurbineType3or4IEC */
  public void validate(UpdateWindTurbineType3or4IECCommand windTurbineType3or4IEC)
      throws Exception {
    Assert.notNull(
        windTurbineType3or4IEC, "UpdateWindTurbineType3or4IECCommand should not be null");
    Assert.notNull(
        windTurbineType3or4IEC.getWindTurbineType3or4IECId(),
        "UpdateWindTurbineType3or4IECCommand identifier should not be null");
  }

  /** handles delete validation for a WindTurbineType3or4IEC */
  public void validate(DeleteWindTurbineType3or4IECCommand windTurbineType3or4IEC)
      throws Exception {
    Assert.notNull(windTurbineType3or4IEC, "{commandAlias} should not be null");
    Assert.notNull(
        windTurbineType3or4IEC.getWindTurbineType3or4IECId(),
        "DeleteWindTurbineType3or4IECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindTurbineType3or4IEC */
  public void validate(WindTurbineType3or4IECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindTurbineType3or4IECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindTurbineType3or4IECId(),
        "WindTurbineType3or4IECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign WindTurbineType3or4IEC validation for a WindTurbineType3or4IEC
   *
   * @param command AssignWindTurbineType3or4IECToWindTurbineType3or4IECCommand
   */
  public void validate(AssignWindTurbineType3or4IECToWindTurbineType3or4IECCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignWindTurbineType3or4IECToWindTurbineType3or4IECCommand should not be null");
    Assert.notNull(
        command.getWindTurbineType3or4IECId(),
        "AssignWindTurbineType3or4IECToWindTurbineType3or4IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignWindTurbineType3or4IECToWindTurbineType3or4IECCommand assignment should not be null");
  }

  /**
   * handles unassign WindTurbineType3or4IEC validation for a WindTurbineType3or4IEC
   *
   * @param command UnAssignWindTurbineType3or4IECFromWindTurbineType3or4IECCommand
   */
  public void validate(UnAssignWindTurbineType3or4IECFromWindTurbineType3or4IECCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignWindTurbineType3or4IECFromWindTurbineType3or4IECCommand should not be null");
    Assert.notNull(
        command.getWindTurbineType3or4IECId(),
        "UnAssignWindTurbineType3or4IECFromWindTurbineType3or4IECCommand identifier should not be null");
  }
}
