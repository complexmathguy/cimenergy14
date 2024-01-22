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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class OverexcLimIEEEValidator {

  /** default constructor */
  protected OverexcLimIEEEValidator() {}

  /** factory method */
  public static OverexcLimIEEEValidator getInstance() {
    return new OverexcLimIEEEValidator();
  }

  /** handles creation validation for a OverexcLimIEEE */
  public void validate(CreateOverexcLimIEEECommand overexcLimIEEE) throws Exception {
    Assert.notNull(overexcLimIEEE, "CreateOverexcLimIEEECommand should not be null");
    //		Assert.isNull( overexcLimIEEE.getOverexcLimIEEEId(), "CreateOverexcLimIEEECommand identifier
    // should be null" );
  }

  /** handles update validation for a OverexcLimIEEE */
  public void validate(UpdateOverexcLimIEEECommand overexcLimIEEE) throws Exception {
    Assert.notNull(overexcLimIEEE, "UpdateOverexcLimIEEECommand should not be null");
    Assert.notNull(
        overexcLimIEEE.getOverexcLimIEEEId(),
        "UpdateOverexcLimIEEECommand identifier should not be null");
  }

  /** handles delete validation for a OverexcLimIEEE */
  public void validate(DeleteOverexcLimIEEECommand overexcLimIEEE) throws Exception {
    Assert.notNull(overexcLimIEEE, "{commandAlias} should not be null");
    Assert.notNull(
        overexcLimIEEE.getOverexcLimIEEEId(),
        "DeleteOverexcLimIEEECommand identifier should not be null");
  }

  /** handles fetchOne validation for a OverexcLimIEEE */
  public void validate(OverexcLimIEEEFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "OverexcLimIEEEFetchOneSummary should not be null");
    Assert.notNull(
        summary.getOverexcLimIEEEId(),
        "OverexcLimIEEEFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Hyst validation for a OverexcLimIEEE
   *
   * @param command AssignHystToOverexcLimIEEECommand
   */
  public void validate(AssignHystToOverexcLimIEEECommand command) throws Exception {
    Assert.notNull(command, "AssignHystToOverexcLimIEEECommand should not be null");
    Assert.notNull(
        command.getOverexcLimIEEEId(),
        "AssignHystToOverexcLimIEEECommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignHystToOverexcLimIEEECommand assignment should not be null");
  }

  /**
   * handles unassign Hyst validation for a OverexcLimIEEE
   *
   * @param command UnAssignHystFromOverexcLimIEEECommand
   */
  public void validate(UnAssignHystFromOverexcLimIEEECommand command) throws Exception {
    Assert.notNull(command, "UnAssignHystFromOverexcLimIEEECommand should not be null");
    Assert.notNull(
        command.getOverexcLimIEEEId(),
        "UnAssignHystFromOverexcLimIEEECommand identifier should not be null");
  }
  /**
   * handles assign Ifdlim validation for a OverexcLimIEEE
   *
   * @param command AssignIfdlimToOverexcLimIEEECommand
   */
  public void validate(AssignIfdlimToOverexcLimIEEECommand command) throws Exception {
    Assert.notNull(command, "AssignIfdlimToOverexcLimIEEECommand should not be null");
    Assert.notNull(
        command.getOverexcLimIEEEId(),
        "AssignIfdlimToOverexcLimIEEECommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignIfdlimToOverexcLimIEEECommand assignment should not be null");
  }

  /**
   * handles unassign Ifdlim validation for a OverexcLimIEEE
   *
   * @param command UnAssignIfdlimFromOverexcLimIEEECommand
   */
  public void validate(UnAssignIfdlimFromOverexcLimIEEECommand command) throws Exception {
    Assert.notNull(command, "UnAssignIfdlimFromOverexcLimIEEECommand should not be null");
    Assert.notNull(
        command.getOverexcLimIEEEId(),
        "UnAssignIfdlimFromOverexcLimIEEECommand identifier should not be null");
  }
  /**
   * handles assign Ifdmax validation for a OverexcLimIEEE
   *
   * @param command AssignIfdmaxToOverexcLimIEEECommand
   */
  public void validate(AssignIfdmaxToOverexcLimIEEECommand command) throws Exception {
    Assert.notNull(command, "AssignIfdmaxToOverexcLimIEEECommand should not be null");
    Assert.notNull(
        command.getOverexcLimIEEEId(),
        "AssignIfdmaxToOverexcLimIEEECommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignIfdmaxToOverexcLimIEEECommand assignment should not be null");
  }

  /**
   * handles unassign Ifdmax validation for a OverexcLimIEEE
   *
   * @param command UnAssignIfdmaxFromOverexcLimIEEECommand
   */
  public void validate(UnAssignIfdmaxFromOverexcLimIEEECommand command) throws Exception {
    Assert.notNull(command, "UnAssignIfdmaxFromOverexcLimIEEECommand should not be null");
    Assert.notNull(
        command.getOverexcLimIEEEId(),
        "UnAssignIfdmaxFromOverexcLimIEEECommand identifier should not be null");
  }
  /**
   * handles assign Itfpu validation for a OverexcLimIEEE
   *
   * @param command AssignItfpuToOverexcLimIEEECommand
   */
  public void validate(AssignItfpuToOverexcLimIEEECommand command) throws Exception {
    Assert.notNull(command, "AssignItfpuToOverexcLimIEEECommand should not be null");
    Assert.notNull(
        command.getOverexcLimIEEEId(),
        "AssignItfpuToOverexcLimIEEECommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignItfpuToOverexcLimIEEECommand assignment should not be null");
  }

  /**
   * handles unassign Itfpu validation for a OverexcLimIEEE
   *
   * @param command UnAssignItfpuFromOverexcLimIEEECommand
   */
  public void validate(UnAssignItfpuFromOverexcLimIEEECommand command) throws Exception {
    Assert.notNull(command, "UnAssignItfpuFromOverexcLimIEEECommand should not be null");
    Assert.notNull(
        command.getOverexcLimIEEEId(),
        "UnAssignItfpuFromOverexcLimIEEECommand identifier should not be null");
  }
  /**
   * handles assign Kcd validation for a OverexcLimIEEE
   *
   * @param command AssignKcdToOverexcLimIEEECommand
   */
  public void validate(AssignKcdToOverexcLimIEEECommand command) throws Exception {
    Assert.notNull(command, "AssignKcdToOverexcLimIEEECommand should not be null");
    Assert.notNull(
        command.getOverexcLimIEEEId(),
        "AssignKcdToOverexcLimIEEECommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcdToOverexcLimIEEECommand assignment should not be null");
  }

  /**
   * handles unassign Kcd validation for a OverexcLimIEEE
   *
   * @param command UnAssignKcdFromOverexcLimIEEECommand
   */
  public void validate(UnAssignKcdFromOverexcLimIEEECommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcdFromOverexcLimIEEECommand should not be null");
    Assert.notNull(
        command.getOverexcLimIEEEId(),
        "UnAssignKcdFromOverexcLimIEEECommand identifier should not be null");
  }
  /**
   * handles assign Kramp validation for a OverexcLimIEEE
   *
   * @param command AssignKrampToOverexcLimIEEECommand
   */
  public void validate(AssignKrampToOverexcLimIEEECommand command) throws Exception {
    Assert.notNull(command, "AssignKrampToOverexcLimIEEECommand should not be null");
    Assert.notNull(
        command.getOverexcLimIEEEId(),
        "AssignKrampToOverexcLimIEEECommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKrampToOverexcLimIEEECommand assignment should not be null");
  }

  /**
   * handles unassign Kramp validation for a OverexcLimIEEE
   *
   * @param command UnAssignKrampFromOverexcLimIEEECommand
   */
  public void validate(UnAssignKrampFromOverexcLimIEEECommand command) throws Exception {
    Assert.notNull(command, "UnAssignKrampFromOverexcLimIEEECommand should not be null");
    Assert.notNull(
        command.getOverexcLimIEEEId(),
        "UnAssignKrampFromOverexcLimIEEECommand identifier should not be null");
  }
}
