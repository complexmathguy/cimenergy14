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

public class WindPlantIECValidator {

  /** default constructor */
  protected WindPlantIECValidator() {}

  /** factory method */
  public static WindPlantIECValidator getInstance() {
    return new WindPlantIECValidator();
  }

  /** handles creation validation for a WindPlantIEC */
  public void validate(CreateWindPlantIECCommand windPlantIEC) throws Exception {
    Assert.notNull(windPlantIEC, "CreateWindPlantIECCommand should not be null");
    //		Assert.isNull( windPlantIEC.getWindPlantIECId(), "CreateWindPlantIECCommand identifier
    // should be null" );
  }

  /** handles update validation for a WindPlantIEC */
  public void validate(UpdateWindPlantIECCommand windPlantIEC) throws Exception {
    Assert.notNull(windPlantIEC, "UpdateWindPlantIECCommand should not be null");
    Assert.notNull(
        windPlantIEC.getWindPlantIECId(),
        "UpdateWindPlantIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindPlantIEC */
  public void validate(DeleteWindPlantIECCommand windPlantIEC) throws Exception {
    Assert.notNull(windPlantIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windPlantIEC.getWindPlantIECId(),
        "DeleteWindPlantIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindPlantIEC */
  public void validate(WindPlantIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindPlantIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindPlantIECId(), "WindPlantIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign WindPlantIEC validation for a WindPlantIEC
   *
   * @param command AssignWindPlantIECToWindPlantIECCommand
   */
  public void validate(AssignWindPlantIECToWindPlantIECCommand command) throws Exception {
    Assert.notNull(command, "AssignWindPlantIECToWindPlantIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantIECId(),
        "AssignWindPlantIECToWindPlantIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignWindPlantIECToWindPlantIECCommand assignment should not be null");
  }

  /**
   * handles unassign WindPlantIEC validation for a WindPlantIEC
   *
   * @param command UnAssignWindPlantIECFromWindPlantIECCommand
   */
  public void validate(UnAssignWindPlantIECFromWindPlantIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignWindPlantIECFromWindPlantIECCommand should not be null");
    Assert.notNull(
        command.getWindPlantIECId(),
        "UnAssignWindPlantIECFromWindPlantIECCommand identifier should not be null");
  }
}
