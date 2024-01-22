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

public class WindTurbineType4aIECValidator {

  /** default constructor */
  protected WindTurbineType4aIECValidator() {}

  /** factory method */
  public static WindTurbineType4aIECValidator getInstance() {
    return new WindTurbineType4aIECValidator();
  }

  /** handles creation validation for a WindTurbineType4aIEC */
  public void validate(CreateWindTurbineType4aIECCommand windTurbineType4aIEC) throws Exception {
    Assert.notNull(windTurbineType4aIEC, "CreateWindTurbineType4aIECCommand should not be null");
    //		Assert.isNull( windTurbineType4aIEC.getWindTurbineType4aIECId(),
    // "CreateWindTurbineType4aIECCommand identifier should be null" );
  }

  /** handles update validation for a WindTurbineType4aIEC */
  public void validate(UpdateWindTurbineType4aIECCommand windTurbineType4aIEC) throws Exception {
    Assert.notNull(windTurbineType4aIEC, "UpdateWindTurbineType4aIECCommand should not be null");
    Assert.notNull(
        windTurbineType4aIEC.getWindTurbineType4aIECId(),
        "UpdateWindTurbineType4aIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindTurbineType4aIEC */
  public void validate(DeleteWindTurbineType4aIECCommand windTurbineType4aIEC) throws Exception {
    Assert.notNull(windTurbineType4aIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windTurbineType4aIEC.getWindTurbineType4aIECId(),
        "DeleteWindTurbineType4aIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindTurbineType4aIEC */
  public void validate(WindTurbineType4aIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindTurbineType4aIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindTurbineType4aIECId(),
        "WindTurbineType4aIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign WindTurbineType4aIEC validation for a WindTurbineType4aIEC
   *
   * @param command AssignWindTurbineType4aIECToWindTurbineType4aIECCommand
   */
  public void validate(AssignWindTurbineType4aIECToWindTurbineType4aIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignWindTurbineType4aIECToWindTurbineType4aIECCommand should not be null");
    Assert.notNull(
        command.getWindTurbineType4aIECId(),
        "AssignWindTurbineType4aIECToWindTurbineType4aIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignWindTurbineType4aIECToWindTurbineType4aIECCommand assignment should not be null");
  }

  /**
   * handles unassign WindTurbineType4aIEC validation for a WindTurbineType4aIEC
   *
   * @param command UnAssignWindTurbineType4aIECFromWindTurbineType4aIECCommand
   */
  public void validate(UnAssignWindTurbineType4aIECFromWindTurbineType4aIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignWindTurbineType4aIECFromWindTurbineType4aIECCommand should not be null");
    Assert.notNull(
        command.getWindTurbineType4aIECId(),
        "UnAssignWindTurbineType4aIECFromWindTurbineType4aIECCommand identifier should not be null");
  }
}
