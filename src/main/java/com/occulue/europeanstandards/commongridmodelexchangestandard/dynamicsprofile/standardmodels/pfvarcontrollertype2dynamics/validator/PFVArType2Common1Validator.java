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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class PFVArType2Common1Validator {

  /** default constructor */
  protected PFVArType2Common1Validator() {}

  /** factory method */
  public static PFVArType2Common1Validator getInstance() {
    return new PFVArType2Common1Validator();
  }

  /** handles creation validation for a PFVArType2Common1 */
  public void validate(CreatePFVArType2Common1Command pFVArType2Common1) throws Exception {
    Assert.notNull(pFVArType2Common1, "CreatePFVArType2Common1Command should not be null");
    //		Assert.isNull( pFVArType2Common1.getPFVArType2Common1Id(), "CreatePFVArType2Common1Command
    // identifier should be null" );
  }

  /** handles update validation for a PFVArType2Common1 */
  public void validate(UpdatePFVArType2Common1Command pFVArType2Common1) throws Exception {
    Assert.notNull(pFVArType2Common1, "UpdatePFVArType2Common1Command should not be null");
    Assert.notNull(
        pFVArType2Common1.getPFVArType2Common1Id(),
        "UpdatePFVArType2Common1Command identifier should not be null");
  }

  /** handles delete validation for a PFVArType2Common1 */
  public void validate(DeletePFVArType2Common1Command pFVArType2Common1) throws Exception {
    Assert.notNull(pFVArType2Common1, "{commandAlias} should not be null");
    Assert.notNull(
        pFVArType2Common1.getPFVArType2Common1Id(),
        "DeletePFVArType2Common1Command identifier should not be null");
  }

  /** handles fetchOne validation for a PFVArType2Common1 */
  public void validate(PFVArType2Common1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PFVArType2Common1FetchOneSummary should not be null");
    Assert.notNull(
        summary.getPFVArType2Common1Id(),
        "PFVArType2Common1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign J validation for a PFVArType2Common1
   *
   * @param command AssignJToPFVArType2Common1Command
   */
  public void validate(AssignJToPFVArType2Common1Command command) throws Exception {
    Assert.notNull(command, "AssignJToPFVArType2Common1Command should not be null");
    Assert.notNull(
        command.getPFVArType2Common1Id(),
        "AssignJToPFVArType2Common1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignJToPFVArType2Common1Command assignment should not be null");
  }

  /**
   * handles unassign J validation for a PFVArType2Common1
   *
   * @param command UnAssignJFromPFVArType2Common1Command
   */
  public void validate(UnAssignJFromPFVArType2Common1Command command) throws Exception {
    Assert.notNull(command, "UnAssignJFromPFVArType2Common1Command should not be null");
    Assert.notNull(
        command.getPFVArType2Common1Id(),
        "UnAssignJFromPFVArType2Common1Command identifier should not be null");
  }
  /**
   * handles assign Ki validation for a PFVArType2Common1
   *
   * @param command AssignKiToPFVArType2Common1Command
   */
  public void validate(AssignKiToPFVArType2Common1Command command) throws Exception {
    Assert.notNull(command, "AssignKiToPFVArType2Common1Command should not be null");
    Assert.notNull(
        command.getPFVArType2Common1Id(),
        "AssignKiToPFVArType2Common1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKiToPFVArType2Common1Command assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a PFVArType2Common1
   *
   * @param command UnAssignKiFromPFVArType2Common1Command
   */
  public void validate(UnAssignKiFromPFVArType2Common1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromPFVArType2Common1Command should not be null");
    Assert.notNull(
        command.getPFVArType2Common1Id(),
        "UnAssignKiFromPFVArType2Common1Command identifier should not be null");
  }
  /**
   * handles assign Kp validation for a PFVArType2Common1
   *
   * @param command AssignKpToPFVArType2Common1Command
   */
  public void validate(AssignKpToPFVArType2Common1Command command) throws Exception {
    Assert.notNull(command, "AssignKpToPFVArType2Common1Command should not be null");
    Assert.notNull(
        command.getPFVArType2Common1Id(),
        "AssignKpToPFVArType2Common1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKpToPFVArType2Common1Command assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a PFVArType2Common1
   *
   * @param command UnAssignKpFromPFVArType2Common1Command
   */
  public void validate(UnAssignKpFromPFVArType2Common1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromPFVArType2Common1Command should not be null");
    Assert.notNull(
        command.getPFVArType2Common1Id(),
        "UnAssignKpFromPFVArType2Common1Command identifier should not be null");
  }
  /**
   * handles assign Max validation for a PFVArType2Common1
   *
   * @param command AssignMaxToPFVArType2Common1Command
   */
  public void validate(AssignMaxToPFVArType2Common1Command command) throws Exception {
    Assert.notNull(command, "AssignMaxToPFVArType2Common1Command should not be null");
    Assert.notNull(
        command.getPFVArType2Common1Id(),
        "AssignMaxToPFVArType2Common1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxToPFVArType2Common1Command assignment should not be null");
  }

  /**
   * handles unassign Max validation for a PFVArType2Common1
   *
   * @param command UnAssignMaxFromPFVArType2Common1Command
   */
  public void validate(UnAssignMaxFromPFVArType2Common1Command command) throws Exception {
    Assert.notNull(command, "UnAssignMaxFromPFVArType2Common1Command should not be null");
    Assert.notNull(
        command.getPFVArType2Common1Id(),
        "UnAssignMaxFromPFVArType2Common1Command identifier should not be null");
  }
  /**
   * handles assign Ref validation for a PFVArType2Common1
   *
   * @param command AssignRefToPFVArType2Common1Command
   */
  public void validate(AssignRefToPFVArType2Common1Command command) throws Exception {
    Assert.notNull(command, "AssignRefToPFVArType2Common1Command should not be null");
    Assert.notNull(
        command.getPFVArType2Common1Id(),
        "AssignRefToPFVArType2Common1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRefToPFVArType2Common1Command assignment should not be null");
  }

  /**
   * handles unassign Ref validation for a PFVArType2Common1
   *
   * @param command UnAssignRefFromPFVArType2Common1Command
   */
  public void validate(UnAssignRefFromPFVArType2Common1Command command) throws Exception {
    Assert.notNull(command, "UnAssignRefFromPFVArType2Common1Command should not be null");
    Assert.notNull(
        command.getPFVArType2Common1Id(),
        "UnAssignRefFromPFVArType2Common1Command identifier should not be null");
  }
}
