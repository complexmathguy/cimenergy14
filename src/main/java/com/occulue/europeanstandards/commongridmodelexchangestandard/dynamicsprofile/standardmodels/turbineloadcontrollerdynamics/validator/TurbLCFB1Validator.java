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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class TurbLCFB1Validator {

  /** default constructor */
  protected TurbLCFB1Validator() {}

  /** factory method */
  public static TurbLCFB1Validator getInstance() {
    return new TurbLCFB1Validator();
  }

  /** handles creation validation for a TurbLCFB1 */
  public void validate(CreateTurbLCFB1Command turbLCFB1) throws Exception {
    Assert.notNull(turbLCFB1, "CreateTurbLCFB1Command should not be null");
    //		Assert.isNull( turbLCFB1.getTurbLCFB1Id(), "CreateTurbLCFB1Command identifier should be
    // null" );
  }

  /** handles update validation for a TurbLCFB1 */
  public void validate(UpdateTurbLCFB1Command turbLCFB1) throws Exception {
    Assert.notNull(turbLCFB1, "UpdateTurbLCFB1Command should not be null");
    Assert.notNull(
        turbLCFB1.getTurbLCFB1Id(), "UpdateTurbLCFB1Command identifier should not be null");
  }

  /** handles delete validation for a TurbLCFB1 */
  public void validate(DeleteTurbLCFB1Command turbLCFB1) throws Exception {
    Assert.notNull(turbLCFB1, "{commandAlias} should not be null");
    Assert.notNull(
        turbLCFB1.getTurbLCFB1Id(), "DeleteTurbLCFB1Command identifier should not be null");
  }

  /** handles fetchOne validation for a TurbLCFB1 */
  public void validate(TurbLCFB1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TurbLCFB1FetchOneSummary should not be null");
    Assert.notNull(
        summary.getTurbLCFB1Id(), "TurbLCFB1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Db validation for a TurbLCFB1
   *
   * @param command AssignDbToTurbLCFB1Command
   */
  public void validate(AssignDbToTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "AssignDbToTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "AssignDbToTurbLCFB1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDbToTurbLCFB1Command assignment should not be null");
  }

  /**
   * handles unassign Db validation for a TurbLCFB1
   *
   * @param command UnAssignDbFromTurbLCFB1Command
   */
  public void validate(UnAssignDbFromTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "UnAssignDbFromTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "UnAssignDbFromTurbLCFB1Command identifier should not be null");
  }
  /**
   * handles assign Emax validation for a TurbLCFB1
   *
   * @param command AssignEmaxToTurbLCFB1Command
   */
  public void validate(AssignEmaxToTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "AssignEmaxToTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "AssignEmaxToTurbLCFB1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEmaxToTurbLCFB1Command assignment should not be null");
  }

  /**
   * handles unassign Emax validation for a TurbLCFB1
   *
   * @param command UnAssignEmaxFromTurbLCFB1Command
   */
  public void validate(UnAssignEmaxFromTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "UnAssignEmaxFromTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "UnAssignEmaxFromTurbLCFB1Command identifier should not be null");
  }
  /**
   * handles assign Fb validation for a TurbLCFB1
   *
   * @param command AssignFbToTurbLCFB1Command
   */
  public void validate(AssignFbToTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "AssignFbToTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "AssignFbToTurbLCFB1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFbToTurbLCFB1Command assignment should not be null");
  }

  /**
   * handles unassign Fb validation for a TurbLCFB1
   *
   * @param command UnAssignFbFromTurbLCFB1Command
   */
  public void validate(UnAssignFbFromTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "UnAssignFbFromTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "UnAssignFbFromTurbLCFB1Command identifier should not be null");
  }
  /**
   * handles assign Fbf validation for a TurbLCFB1
   *
   * @param command AssignFbfToTurbLCFB1Command
   */
  public void validate(AssignFbfToTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "AssignFbfToTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "AssignFbfToTurbLCFB1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFbfToTurbLCFB1Command assignment should not be null");
  }

  /**
   * handles unassign Fbf validation for a TurbLCFB1
   *
   * @param command UnAssignFbfFromTurbLCFB1Command
   */
  public void validate(UnAssignFbfFromTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "UnAssignFbfFromTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "UnAssignFbfFromTurbLCFB1Command identifier should not be null");
  }
  /**
   * handles assign Irmax validation for a TurbLCFB1
   *
   * @param command AssignIrmaxToTurbLCFB1Command
   */
  public void validate(AssignIrmaxToTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "AssignIrmaxToTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "AssignIrmaxToTurbLCFB1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIrmaxToTurbLCFB1Command assignment should not be null");
  }

  /**
   * handles unassign Irmax validation for a TurbLCFB1
   *
   * @param command UnAssignIrmaxFromTurbLCFB1Command
   */
  public void validate(UnAssignIrmaxFromTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "UnAssignIrmaxFromTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(),
        "UnAssignIrmaxFromTurbLCFB1Command identifier should not be null");
  }
  /**
   * handles assign Ki validation for a TurbLCFB1
   *
   * @param command AssignKiToTurbLCFB1Command
   */
  public void validate(AssignKiToTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "AssignKiToTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "AssignKiToTurbLCFB1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToTurbLCFB1Command assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a TurbLCFB1
   *
   * @param command UnAssignKiFromTurbLCFB1Command
   */
  public void validate(UnAssignKiFromTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "UnAssignKiFromTurbLCFB1Command identifier should not be null");
  }
  /**
   * handles assign Kp validation for a TurbLCFB1
   *
   * @param command AssignKpToTurbLCFB1Command
   */
  public void validate(AssignKpToTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "AssignKpToTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "AssignKpToTurbLCFB1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToTurbLCFB1Command assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a TurbLCFB1
   *
   * @param command UnAssignKpFromTurbLCFB1Command
   */
  public void validate(UnAssignKpFromTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "UnAssignKpFromTurbLCFB1Command identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a TurbLCFB1
   *
   * @param command AssignMwbaseToTurbLCFB1Command
   */
  public void validate(AssignMwbaseToTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "AssignMwbaseToTurbLCFB1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToTurbLCFB1Command assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a TurbLCFB1
   *
   * @param command UnAssignMwbaseFromTurbLCFB1Command
   */
  public void validate(UnAssignMwbaseFromTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(),
        "UnAssignMwbaseFromTurbLCFB1Command identifier should not be null");
  }
  /**
   * handles assign Pbf validation for a TurbLCFB1
   *
   * @param command AssignPbfToTurbLCFB1Command
   */
  public void validate(AssignPbfToTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "AssignPbfToTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "AssignPbfToTurbLCFB1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPbfToTurbLCFB1Command assignment should not be null");
  }

  /**
   * handles unassign Pbf validation for a TurbLCFB1
   *
   * @param command UnAssignPbfFromTurbLCFB1Command
   */
  public void validate(UnAssignPbfFromTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPbfFromTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "UnAssignPbfFromTurbLCFB1Command identifier should not be null");
  }
  /**
   * handles assign Pmwset validation for a TurbLCFB1
   *
   * @param command AssignPmwsetToTurbLCFB1Command
   */
  public void validate(AssignPmwsetToTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "AssignPmwsetToTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "AssignPmwsetToTurbLCFB1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmwsetToTurbLCFB1Command assignment should not be null");
  }

  /**
   * handles unassign Pmwset validation for a TurbLCFB1
   *
   * @param command UnAssignPmwsetFromTurbLCFB1Command
   */
  public void validate(UnAssignPmwsetFromTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPmwsetFromTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(),
        "UnAssignPmwsetFromTurbLCFB1Command identifier should not be null");
  }
  /**
   * handles assign SpeedReferenceGovernor validation for a TurbLCFB1
   *
   * @param command AssignSpeedReferenceGovernorToTurbLCFB1Command
   */
  public void validate(AssignSpeedReferenceGovernorToTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "AssignSpeedReferenceGovernorToTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(),
        "AssignSpeedReferenceGovernorToTurbLCFB1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSpeedReferenceGovernorToTurbLCFB1Command assignment should not be null");
  }

  /**
   * handles unassign SpeedReferenceGovernor validation for a TurbLCFB1
   *
   * @param command UnAssignSpeedReferenceGovernorFromTurbLCFB1Command
   */
  public void validate(UnAssignSpeedReferenceGovernorFromTurbLCFB1Command command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignSpeedReferenceGovernorFromTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(),
        "UnAssignSpeedReferenceGovernorFromTurbLCFB1Command identifier should not be null");
  }
  /**
   * handles assign Tpelec validation for a TurbLCFB1
   *
   * @param command AssignTpelecToTurbLCFB1Command
   */
  public void validate(AssignTpelecToTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "AssignTpelecToTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(), "AssignTpelecToTurbLCFB1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpelecToTurbLCFB1Command assignment should not be null");
  }

  /**
   * handles unassign Tpelec validation for a TurbLCFB1
   *
   * @param command UnAssignTpelecFromTurbLCFB1Command
   */
  public void validate(UnAssignTpelecFromTurbLCFB1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTpelecFromTurbLCFB1Command should not be null");
    Assert.notNull(
        command.getTurbLCFB1Id(),
        "UnAssignTpelecFromTurbLCFB1Command identifier should not be null");
  }
}
