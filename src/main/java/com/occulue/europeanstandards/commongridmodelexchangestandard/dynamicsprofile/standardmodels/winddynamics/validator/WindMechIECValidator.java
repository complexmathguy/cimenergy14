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

public class WindMechIECValidator {

  /** default constructor */
  protected WindMechIECValidator() {}

  /** factory method */
  public static WindMechIECValidator getInstance() {
    return new WindMechIECValidator();
  }

  /** handles creation validation for a WindMechIEC */
  public void validate(CreateWindMechIECCommand windMechIEC) throws Exception {
    Assert.notNull(windMechIEC, "CreateWindMechIECCommand should not be null");
    //		Assert.isNull( windMechIEC.getWindMechIECId(), "CreateWindMechIECCommand identifier should
    // be null" );
  }

  /** handles update validation for a WindMechIEC */
  public void validate(UpdateWindMechIECCommand windMechIEC) throws Exception {
    Assert.notNull(windMechIEC, "UpdateWindMechIECCommand should not be null");
    Assert.notNull(
        windMechIEC.getWindMechIECId(), "UpdateWindMechIECCommand identifier should not be null");
  }

  /** handles delete validation for a WindMechIEC */
  public void validate(DeleteWindMechIECCommand windMechIEC) throws Exception {
    Assert.notNull(windMechIEC, "{commandAlias} should not be null");
    Assert.notNull(
        windMechIEC.getWindMechIECId(), "DeleteWindMechIECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindMechIEC */
  public void validate(WindMechIECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindMechIECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindMechIECId(), "WindMechIECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Cdrt validation for a WindMechIEC
   *
   * @param command AssignCdrtToWindMechIECCommand
   */
  public void validate(AssignCdrtToWindMechIECCommand command) throws Exception {
    Assert.notNull(command, "AssignCdrtToWindMechIECCommand should not be null");
    Assert.notNull(
        command.getWindMechIECId(), "AssignCdrtToWindMechIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignCdrtToWindMechIECCommand assignment should not be null");
  }

  /**
   * handles unassign Cdrt validation for a WindMechIEC
   *
   * @param command UnAssignCdrtFromWindMechIECCommand
   */
  public void validate(UnAssignCdrtFromWindMechIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignCdrtFromWindMechIECCommand should not be null");
    Assert.notNull(
        command.getWindMechIECId(),
        "UnAssignCdrtFromWindMechIECCommand identifier should not be null");
  }
  /**
   * handles assign Hgen validation for a WindMechIEC
   *
   * @param command AssignHgenToWindMechIECCommand
   */
  public void validate(AssignHgenToWindMechIECCommand command) throws Exception {
    Assert.notNull(command, "AssignHgenToWindMechIECCommand should not be null");
    Assert.notNull(
        command.getWindMechIECId(), "AssignHgenToWindMechIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignHgenToWindMechIECCommand assignment should not be null");
  }

  /**
   * handles unassign Hgen validation for a WindMechIEC
   *
   * @param command UnAssignHgenFromWindMechIECCommand
   */
  public void validate(UnAssignHgenFromWindMechIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignHgenFromWindMechIECCommand should not be null");
    Assert.notNull(
        command.getWindMechIECId(),
        "UnAssignHgenFromWindMechIECCommand identifier should not be null");
  }
  /**
   * handles assign Hwtr validation for a WindMechIEC
   *
   * @param command AssignHwtrToWindMechIECCommand
   */
  public void validate(AssignHwtrToWindMechIECCommand command) throws Exception {
    Assert.notNull(command, "AssignHwtrToWindMechIECCommand should not be null");
    Assert.notNull(
        command.getWindMechIECId(), "AssignHwtrToWindMechIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignHwtrToWindMechIECCommand assignment should not be null");
  }

  /**
   * handles unassign Hwtr validation for a WindMechIEC
   *
   * @param command UnAssignHwtrFromWindMechIECCommand
   */
  public void validate(UnAssignHwtrFromWindMechIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignHwtrFromWindMechIECCommand should not be null");
    Assert.notNull(
        command.getWindMechIECId(),
        "UnAssignHwtrFromWindMechIECCommand identifier should not be null");
  }
  /**
   * handles assign Kdrt validation for a WindMechIEC
   *
   * @param command AssignKdrtToWindMechIECCommand
   */
  public void validate(AssignKdrtToWindMechIECCommand command) throws Exception {
    Assert.notNull(command, "AssignKdrtToWindMechIECCommand should not be null");
    Assert.notNull(
        command.getWindMechIECId(), "AssignKdrtToWindMechIECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdrtToWindMechIECCommand assignment should not be null");
  }

  /**
   * handles unassign Kdrt validation for a WindMechIEC
   *
   * @param command UnAssignKdrtFromWindMechIECCommand
   */
  public void validate(UnAssignKdrtFromWindMechIECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdrtFromWindMechIECCommand should not be null");
    Assert.notNull(
        command.getWindMechIECId(),
        "UnAssignKdrtFromWindMechIECCommand identifier should not be null");
  }
}
