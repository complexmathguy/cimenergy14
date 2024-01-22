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

public class WindGenTurbineType1IECValidator {

  /** default constructor */
  protected WindGenTurbineType1IECValidator() {}

  /** factory method */
  public static WindGenTurbineType1IECValidator getInstance() {
    return new WindGenTurbineType1IECValidator();
  }

  /** handles creation validation for a WindGenTurbineType1IEC */
  public void validate(CreateWindGenTurbineType1IECCommand windGenTurbineType1IEC)
      throws Exception {
    Assert.notNull(
        windGenTurbineType1IEC, "CreateWindGenTurbineType1IECCommand should not be null");
    //		Assert.isNull( windGenTurbineType1IEC.getWindGenTurbineType1IECId(),
    // "CreateWindGenTurbineType1IECCommand identifier should be null" );
  }

  /** handles update validation for a WindGenTurbineType1IEC */
  public void validate(UpdateWindGenTurbineType1IECCommand windGenTurbineType1IEC)
      throws Exception {
    Assert.notNull(
        windGenTurbineType1IEC, "UpdateWindGenTurbineType1IECCommand should not be null");
    Assert.notNull(
        windGenTurbineType1IEC.getWindGenTurbineType1IECId(),
        "UpdateWindGenTurbineType1IECCommand identifier should not be null");
  }

  /** handles delete validation for a WindGenTurbineType1IEC */
  public void validate(DeleteWindGenTurbineType1IECCommand windGenTurbineType1IEC)
      throws Exception {
    Assert.notNull(windGenTurbineType1IEC, "{commandAlias} should not be null");
    Assert.notNull(
        windGenTurbineType1IEC.getWindGenTurbineType1IECId(),
        "DeleteWindGenTurbineType1IECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindGenTurbineType1IEC */
  public void validate(WindGenTurbineType1IECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindGenTurbineType1IECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindGenTurbineType1IECId(),
        "WindGenTurbineType1IECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign WindGenTurbineType1IEC validation for a WindGenTurbineType1IEC
   *
   * @param command AssignWindGenTurbineType1IECToWindGenTurbineType1IECCommand
   */
  public void validate(AssignWindGenTurbineType1IECToWindGenTurbineType1IECCommand command)
      throws Exception {
    Assert.notNull(
        command, "AssignWindGenTurbineType1IECToWindGenTurbineType1IECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType1IECId(),
        "AssignWindGenTurbineType1IECToWindGenTurbineType1IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignWindGenTurbineType1IECToWindGenTurbineType1IECCommand assignment should not be null");
  }

  /**
   * handles unassign WindGenTurbineType1IEC validation for a WindGenTurbineType1IEC
   *
   * @param command UnAssignWindGenTurbineType1IECFromWindGenTurbineType1IECCommand
   */
  public void validate(UnAssignWindGenTurbineType1IECFromWindGenTurbineType1IECCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignWindGenTurbineType1IECFromWindGenTurbineType1IECCommand should not be null");
    Assert.notNull(
        command.getWindGenTurbineType1IECId(),
        "UnAssignWindGenTurbineType1IECFromWindGenTurbineType1IECCommand identifier should not be null");
  }
}
