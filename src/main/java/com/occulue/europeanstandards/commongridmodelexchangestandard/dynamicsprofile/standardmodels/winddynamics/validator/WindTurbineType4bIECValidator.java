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

public class WindTurbineType4bIECValidator {

  /** default constructor */
  protected WindTurbineType4bIECValidator() {}

  /** factory method */
  public static WindTurbineType4bIECValidator getInstance() {
    return new WindTurbineType4bIECValidator();
  }

  /** handles creation validation for a WindTurbineType4bIEC */
  public void validate(CreateWindTurbineType4bIECCommand windTurbineType4bIEC) throws Exception {
    Assert.notNull(windTurbineType4bIEC, "CreateWindTurbineType4bIECCommand should not be null");
    //		Assert.isNull( windTurbineType4bIEC.getWindTurbineType4bIECId(),
    // "CreateWindTurbineType4bIECCommand identifier should be null" );
  }

  /** handles update validation for a WindTurbineType4bIEC */
  public void validate(UpdateWindTurbineType4bIECCommand windTurbineType4bIEC) throws Exception {
    Assert.notNull(windTurbineType4bIEC, "UpdateWindTurbineType4bIECCommand should not be null");
    Assert.notNull(
        windTurbineType4bIEC.getWindTurbineType4bIECId(),
        "UpdateWindTurbineType4bIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindTurbineType4bIEC */
  public void validate(DeleteWindTurbineType4bIECCommand windTurbineType4bIEC) throws Exception {
    Assert.notNull(windTurbineType4bIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windTurbineType4bIEC.getWindTurbineType4bIECId(),
        "DeleteWindTurbineType4bIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindTurbineType4bIEC */
  public void validate(WindTurbineType4bIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindTurbineType4bIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindTurbineType4bIECId(),
        "WindTurbineType4bIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign WindTurbineType4bIEC validation for a WindTurbineType4bIEC
   *
   * @param command AssignWindTurbineType4bIECToWindTurbineType4bIECCommand
   */
  public void validate(AssignWindTurbineType4bIECToWindTurbineType4bIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignWindTurbineType4bIECToWindTurbineType4bIECCommand should not be null");
    Assert.notNull(
        command.getWindTurbineType4bIECId(),
        "AssignWindTurbineType4bIECToWindTurbineType4bIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignWindTurbineType4bIECToWindTurbineType4bIECCommand assignment should not be null");
  }

  /**
   * handles unassign WindTurbineType4bIEC validation for a WindTurbineType4bIEC
   *
   * @param command UnAssignWindTurbineType4bIECFromWindTurbineType4bIECCommand
   */
  public void validate(UnAssignWindTurbineType4bIECFromWindTurbineType4bIECCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignWindTurbineType4bIECFromWindTurbineType4bIECCommand should not be null");
    Assert.notNull(
        command.getWindTurbineType4bIECId(),
        "UnAssignWindTurbineType4bIECFromWindTurbineType4bIECCommand identifier should not be null");
  }
}
