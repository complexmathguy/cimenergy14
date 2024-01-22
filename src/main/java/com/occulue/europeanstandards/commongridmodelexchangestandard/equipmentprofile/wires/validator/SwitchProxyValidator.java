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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class SwitchProxyValidator {

  /** default constructor */
  protected SwitchProxyValidator() {}

  /** factory method */
  public static SwitchProxyValidator getInstance() {
    return new SwitchProxyValidator();
  }

  /** handles creation validation for a SwitchProxy */
  public void validate(CreateSwitchProxyCommand switchProxy) throws Exception {
    Assert.notNull(switchProxy, "CreateSwitchProxyCommand should not be null");
    //		Assert.isNull( switchProxy.getSwitchProxyId(), "CreateSwitchProxyCommand identifier should
    // be null" );
  }

  /** handles update validation for a SwitchProxy */
  public void validate(UpdateSwitchProxyCommand switchProxy) throws Exception {
    Assert.notNull(switchProxy, "UpdateSwitchProxyCommand should not be null");
    Assert.notNull(
        switchProxy.getSwitchProxyId(), "UpdateSwitchProxyCommand identifier should not be null");
  }

  /** handles delete validation for a SwitchProxy */
  public void validate(DeleteSwitchProxyCommand switchProxy) throws Exception {
    Assert.notNull(switchProxy, "{commandAlias} should not be null");
    Assert.notNull(
        switchProxy.getSwitchProxyId(), "DeleteSwitchProxyCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SwitchProxy */
  public void validate(SwitchProxyFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SwitchProxyFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSwitchProxyId(), "SwitchProxyFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign NormalOpen validation for a SwitchProxy
   *
   * @param command AssignNormalOpenToSwitchProxyCommand
   */
  public void validate(AssignNormalOpenToSwitchProxyCommand command) throws Exception {
    Assert.notNull(command, "AssignNormalOpenToSwitchProxyCommand should not be null");
    Assert.notNull(
        command.getSwitchProxyId(),
        "AssignNormalOpenToSwitchProxyCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNormalOpenToSwitchProxyCommand assignment should not be null");
  }

  /**
   * handles unassign NormalOpen validation for a SwitchProxy
   *
   * @param command UnAssignNormalOpenFromSwitchProxyCommand
   */
  public void validate(UnAssignNormalOpenFromSwitchProxyCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNormalOpenFromSwitchProxyCommand should not be null");
    Assert.notNull(
        command.getSwitchProxyId(),
        "UnAssignNormalOpenFromSwitchProxyCommand identifier should not be null");
  }
  /**
   * handles assign RatedCurrent validation for a SwitchProxy
   *
   * @param command AssignRatedCurrentToSwitchProxyCommand
   */
  public void validate(AssignRatedCurrentToSwitchProxyCommand command) throws Exception {
    Assert.notNull(command, "AssignRatedCurrentToSwitchProxyCommand should not be null");
    Assert.notNull(
        command.getSwitchProxyId(),
        "AssignRatedCurrentToSwitchProxyCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRatedCurrentToSwitchProxyCommand assignment should not be null");
  }

  /**
   * handles unassign RatedCurrent validation for a SwitchProxy
   *
   * @param command UnAssignRatedCurrentFromSwitchProxyCommand
   */
  public void validate(UnAssignRatedCurrentFromSwitchProxyCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRatedCurrentFromSwitchProxyCommand should not be null");
    Assert.notNull(
        command.getSwitchProxyId(),
        "UnAssignRatedCurrentFromSwitchProxyCommand identifier should not be null");
  }
  /**
   * handles assign Retained validation for a SwitchProxy
   *
   * @param command AssignRetainedToSwitchProxyCommand
   */
  public void validate(AssignRetainedToSwitchProxyCommand command) throws Exception {
    Assert.notNull(command, "AssignRetainedToSwitchProxyCommand should not be null");
    Assert.notNull(
        command.getSwitchProxyId(),
        "AssignRetainedToSwitchProxyCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRetainedToSwitchProxyCommand assignment should not be null");
  }

  /**
   * handles unassign Retained validation for a SwitchProxy
   *
   * @param command UnAssignRetainedFromSwitchProxyCommand
   */
  public void validate(UnAssignRetainedFromSwitchProxyCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRetainedFromSwitchProxyCommand should not be null");
    Assert.notNull(
        command.getSwitchProxyId(),
        "UnAssignRetainedFromSwitchProxyCommand identifier should not be null");
  }
}
