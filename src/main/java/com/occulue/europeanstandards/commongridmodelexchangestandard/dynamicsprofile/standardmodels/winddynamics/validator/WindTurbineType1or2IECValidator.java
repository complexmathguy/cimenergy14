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

public class WindTurbineType1or2IECValidator {

  /** default constructor */
  protected WindTurbineType1or2IECValidator() {}

  /** factory method */
  public static WindTurbineType1or2IECValidator getInstance() {
    return new WindTurbineType1or2IECValidator();
  }

  /** handles creation validation for a WindTurbineType1or2IEC */
  public void validate(CreateWindTurbineType1or2IECCommand windTurbineType1or2IEC)
      throws Exception {
    Assert.notNull(
        windTurbineType1or2IEC, "CreateWindTurbineType1or2IECCommand should not be null");
    //		Assert.isNull( windTurbineType1or2IEC.getWindTurbineType1or2IECId(),
    // "CreateWindTurbineType1or2IECCommand identifier should be null" );
  }

  /** handles update validation for a WindTurbineType1or2IEC */
  public void validate(UpdateWindTurbineType1or2IECCommand windTurbineType1or2IEC)
      throws Exception {
    Assert.notNull(
        windTurbineType1or2IEC, "UpdateWindTurbineType1or2IECCommand should not be null");
    Assert.notNull(
        windTurbineType1or2IEC.getWindTurbineType1or2IECId(),
        "UpdateWindTurbineType1or2IECCommand identifier should not be null");
  }

  /** handles delete validation for a WindTurbineType1or2IEC */
  public void validate(DeleteWindTurbineType1or2IECCommand windTurbineType1or2IEC)
      throws Exception {
    Assert.notNull(windTurbineType1or2IEC, "{commandAlias} should not be null");
    Assert.notNull(
        windTurbineType1or2IEC.getWindTurbineType1or2IECId(),
        "DeleteWindTurbineType1or2IECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindTurbineType1or2IEC */
  public void validate(WindTurbineType1or2IECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindTurbineType1or2IECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindTurbineType1or2IECId(),
        "WindTurbineType1or2IECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign WindTurbineType1or2IEC validation for a WindTurbineType1or2IEC
   *
   * @param command AssignWindTurbineType1or2IECToWindTurbineType1or2IECCommand
   */
  public void validate(AssignWindTurbineType1or2IECToWindTurbineType1or2IECCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignWindTurbineType1or2IECToWindTurbineType1or2IECCommand should not be null");
    Assert.notNull(
        command.getWindTurbineType1or2IECId(),
        "AssignWindTurbineType1or2IECToWindTurbineType1or2IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignWindTurbineType1or2IECToWindTurbineType1or2IECCommand assignment should not be null");
  }

  /**
   * handles unassign WindTurbineType1or2IEC validation for a WindTurbineType1or2IEC
   *
   * @param command UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECCommand
   */
  public void validate(UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECCommand should not be null");
    Assert.notNull(
        command.getWindTurbineType1or2IECId(),
        "UnAssignWindTurbineType1or2IECFromWindTurbineType1or2IECCommand identifier should not be null");
  }
}
