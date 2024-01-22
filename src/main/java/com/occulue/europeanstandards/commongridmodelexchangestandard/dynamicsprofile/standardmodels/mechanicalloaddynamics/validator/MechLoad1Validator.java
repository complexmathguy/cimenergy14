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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.mechanicalloaddynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class MechLoad1Validator {

  /** default constructor */
  protected MechLoad1Validator() {}

  /** factory method */
  public static MechLoad1Validator getInstance() {
    return new MechLoad1Validator();
  }

  /** handles creation validation for a MechLoad1 */
  public void validate(CreateMechLoad1Command mechLoad1) throws Exception {
    Assert.notNull(mechLoad1, "CreateMechLoad1Command should not be null");
    //		Assert.isNull( mechLoad1.getMechLoad1Id(), "CreateMechLoad1Command identifier should be
    // null" );
  }

  /** handles update validation for a MechLoad1 */
  public void validate(UpdateMechLoad1Command mechLoad1) throws Exception {
    Assert.notNull(mechLoad1, "UpdateMechLoad1Command should not be null");
    Assert.notNull(
        mechLoad1.getMechLoad1Id(), "UpdateMechLoad1Command identifier should not be null");
  }

  /** handles delete validation for a MechLoad1 */
  public void validate(DeleteMechLoad1Command mechLoad1) throws Exception {
    Assert.notNull(mechLoad1, "{commandAlias} should not be null");
    Assert.notNull(
        mechLoad1.getMechLoad1Id(), "DeleteMechLoad1Command identifier should not be null");
  }

  /** handles fetchOne validation for a MechLoad1 */
  public void validate(MechLoad1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "MechLoad1FetchOneSummary should not be null");
    Assert.notNull(
        summary.getMechLoad1Id(), "MechLoad1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign A validation for a MechLoad1
   *
   * @param command AssignAToMechLoad1Command
   */
  public void validate(AssignAToMechLoad1Command command) throws Exception {
    Assert.notNull(command, "AssignAToMechLoad1Command should not be null");
    Assert.notNull(
        command.getMechLoad1Id(), "AssignAToMechLoad1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAToMechLoad1Command assignment should not be null");
  }

  /**
   * handles unassign A validation for a MechLoad1
   *
   * @param command UnAssignAFromMechLoad1Command
   */
  public void validate(UnAssignAFromMechLoad1Command command) throws Exception {
    Assert.notNull(command, "UnAssignAFromMechLoad1Command should not be null");
    Assert.notNull(
        command.getMechLoad1Id(), "UnAssignAFromMechLoad1Command identifier should not be null");
  }
  /**
   * handles assign B validation for a MechLoad1
   *
   * @param command AssignBToMechLoad1Command
   */
  public void validate(AssignBToMechLoad1Command command) throws Exception {
    Assert.notNull(command, "AssignBToMechLoad1Command should not be null");
    Assert.notNull(
        command.getMechLoad1Id(), "AssignBToMechLoad1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBToMechLoad1Command assignment should not be null");
  }

  /**
   * handles unassign B validation for a MechLoad1
   *
   * @param command UnAssignBFromMechLoad1Command
   */
  public void validate(UnAssignBFromMechLoad1Command command) throws Exception {
    Assert.notNull(command, "UnAssignBFromMechLoad1Command should not be null");
    Assert.notNull(
        command.getMechLoad1Id(), "UnAssignBFromMechLoad1Command identifier should not be null");
  }
  /**
   * handles assign D validation for a MechLoad1
   *
   * @param command AssignDToMechLoad1Command
   */
  public void validate(AssignDToMechLoad1Command command) throws Exception {
    Assert.notNull(command, "AssignDToMechLoad1Command should not be null");
    Assert.notNull(
        command.getMechLoad1Id(), "AssignDToMechLoad1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDToMechLoad1Command assignment should not be null");
  }

  /**
   * handles unassign D validation for a MechLoad1
   *
   * @param command UnAssignDFromMechLoad1Command
   */
  public void validate(UnAssignDFromMechLoad1Command command) throws Exception {
    Assert.notNull(command, "UnAssignDFromMechLoad1Command should not be null");
    Assert.notNull(
        command.getMechLoad1Id(), "UnAssignDFromMechLoad1Command identifier should not be null");
  }
  /**
   * handles assign E validation for a MechLoad1
   *
   * @param command AssignEToMechLoad1Command
   */
  public void validate(AssignEToMechLoad1Command command) throws Exception {
    Assert.notNull(command, "AssignEToMechLoad1Command should not be null");
    Assert.notNull(
        command.getMechLoad1Id(), "AssignEToMechLoad1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEToMechLoad1Command assignment should not be null");
  }

  /**
   * handles unassign E validation for a MechLoad1
   *
   * @param command UnAssignEFromMechLoad1Command
   */
  public void validate(UnAssignEFromMechLoad1Command command) throws Exception {
    Assert.notNull(command, "UnAssignEFromMechLoad1Command should not be null");
    Assert.notNull(
        command.getMechLoad1Id(), "UnAssignEFromMechLoad1Command identifier should not be null");
  }
}
