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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class UnderexcLimX2Validator {

  /** default constructor */
  protected UnderexcLimX2Validator() {}

  /** factory method */
  public static UnderexcLimX2Validator getInstance() {
    return new UnderexcLimX2Validator();
  }

  /** handles creation validation for a UnderexcLimX2 */
  public void validate(CreateUnderexcLimX2Command underexcLimX2) throws Exception {
    Assert.notNull(underexcLimX2, "CreateUnderexcLimX2Command should not be null");
    //		Assert.isNull( underexcLimX2.getUnderexcLimX2Id(), "CreateUnderexcLimX2Command identifier
    // should be null" );
  }

  /** handles update validation for a UnderexcLimX2 */
  public void validate(UpdateUnderexcLimX2Command underexcLimX2) throws Exception {
    Assert.notNull(underexcLimX2, "UpdateUnderexcLimX2Command should not be null");
    Assert.notNull(
        underexcLimX2.getUnderexcLimX2Id(),
        "UpdateUnderexcLimX2Command identifier should not be null");
  }

  /** handles delete validation for a UnderexcLimX2 */
  public void validate(DeleteUnderexcLimX2Command underexcLimX2) throws Exception {
    Assert.notNull(underexcLimX2, "{commandAlias} should not be null");
    Assert.notNull(
        underexcLimX2.getUnderexcLimX2Id(),
        "DeleteUnderexcLimX2Command identifier should not be null");
  }

  /** handles fetchOne validation for a UnderexcLimX2 */
  public void validate(UnderexcLimX2FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "UnderexcLimX2FetchOneSummary should not be null");
    Assert.notNull(
        summary.getUnderexcLimX2Id(), "UnderexcLimX2FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Kf2 validation for a UnderexcLimX2
   *
   * @param command AssignKf2ToUnderexcLimX2Command
   */
  public void validate(AssignKf2ToUnderexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignKf2ToUnderexcLimX2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX2Id(),
        "AssignKf2ToUnderexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKf2ToUnderexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign Kf2 validation for a UnderexcLimX2
   *
   * @param command UnAssignKf2FromUnderexcLimX2Command
   */
  public void validate(UnAssignKf2FromUnderexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKf2FromUnderexcLimX2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX2Id(),
        "UnAssignKf2FromUnderexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign Km validation for a UnderexcLimX2
   *
   * @param command AssignKmToUnderexcLimX2Command
   */
  public void validate(AssignKmToUnderexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignKmToUnderexcLimX2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX2Id(),
        "AssignKmToUnderexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKmToUnderexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign Km validation for a UnderexcLimX2
   *
   * @param command UnAssignKmFromUnderexcLimX2Command
   */
  public void validate(UnAssignKmFromUnderexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKmFromUnderexcLimX2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX2Id(),
        "UnAssignKmFromUnderexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign Melmax validation for a UnderexcLimX2
   *
   * @param command AssignMelmaxToUnderexcLimX2Command
   */
  public void validate(AssignMelmaxToUnderexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignMelmaxToUnderexcLimX2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX2Id(),
        "AssignMelmaxToUnderexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMelmaxToUnderexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign Melmax validation for a UnderexcLimX2
   *
   * @param command UnAssignMelmaxFromUnderexcLimX2Command
   */
  public void validate(UnAssignMelmaxFromUnderexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignMelmaxFromUnderexcLimX2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX2Id(),
        "UnAssignMelmaxFromUnderexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign Qo validation for a UnderexcLimX2
   *
   * @param command AssignQoToUnderexcLimX2Command
   */
  public void validate(AssignQoToUnderexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignQoToUnderexcLimX2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX2Id(),
        "AssignQoToUnderexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQoToUnderexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign Qo validation for a UnderexcLimX2
   *
   * @param command UnAssignQoFromUnderexcLimX2Command
   */
  public void validate(UnAssignQoFromUnderexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignQoFromUnderexcLimX2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX2Id(),
        "UnAssignQoFromUnderexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign R validation for a UnderexcLimX2
   *
   * @param command AssignRToUnderexcLimX2Command
   */
  public void validate(AssignRToUnderexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignRToUnderexcLimX2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX2Id(),
        "AssignRToUnderexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRToUnderexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign R validation for a UnderexcLimX2
   *
   * @param command UnAssignRFromUnderexcLimX2Command
   */
  public void validate(UnAssignRFromUnderexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignRFromUnderexcLimX2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX2Id(),
        "UnAssignRFromUnderexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign Tf2 validation for a UnderexcLimX2
   *
   * @param command AssignTf2ToUnderexcLimX2Command
   */
  public void validate(AssignTf2ToUnderexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignTf2ToUnderexcLimX2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX2Id(),
        "AssignTf2ToUnderexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf2ToUnderexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign Tf2 validation for a UnderexcLimX2
   *
   * @param command UnAssignTf2FromUnderexcLimX2Command
   */
  public void validate(UnAssignTf2FromUnderexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTf2FromUnderexcLimX2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX2Id(),
        "UnAssignTf2FromUnderexcLimX2Command identifier should not be null");
  }
  /**
   * handles assign Tm validation for a UnderexcLimX2
   *
   * @param command AssignTmToUnderexcLimX2Command
   */
  public void validate(AssignTmToUnderexcLimX2Command command) throws Exception {
    Assert.notNull(command, "AssignTmToUnderexcLimX2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX2Id(),
        "AssignTmToUnderexcLimX2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTmToUnderexcLimX2Command assignment should not be null");
  }

  /**
   * handles unassign Tm validation for a UnderexcLimX2
   *
   * @param command UnAssignTmFromUnderexcLimX2Command
   */
  public void validate(UnAssignTmFromUnderexcLimX2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTmFromUnderexcLimX2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX2Id(),
        "UnAssignTmFromUnderexcLimX2Command identifier should not be null");
  }
}
