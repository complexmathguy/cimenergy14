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

public class UnderexcLimX1Validator {

  /** default constructor */
  protected UnderexcLimX1Validator() {}

  /** factory method */
  public static UnderexcLimX1Validator getInstance() {
    return new UnderexcLimX1Validator();
  }

  /** handles creation validation for a UnderexcLimX1 */
  public void validate(CreateUnderexcLimX1Command underexcLimX1) throws Exception {
    Assert.notNull(underexcLimX1, "CreateUnderexcLimX1Command should not be null");
    //		Assert.isNull( underexcLimX1.getUnderexcLimX1Id(), "CreateUnderexcLimX1Command identifier
    // should be null" );
  }

  /** handles update validation for a UnderexcLimX1 */
  public void validate(UpdateUnderexcLimX1Command underexcLimX1) throws Exception {
    Assert.notNull(underexcLimX1, "UpdateUnderexcLimX1Command should not be null");
    Assert.notNull(
        underexcLimX1.getUnderexcLimX1Id(),
        "UpdateUnderexcLimX1Command identifier should not be null");
  }

  /** handles delete validation for a UnderexcLimX1 */
  public void validate(DeleteUnderexcLimX1Command underexcLimX1) throws Exception {
    Assert.notNull(underexcLimX1, "{commandAlias} should not be null");
    Assert.notNull(
        underexcLimX1.getUnderexcLimX1Id(),
        "DeleteUnderexcLimX1Command identifier should not be null");
  }

  /** handles fetchOne validation for a UnderexcLimX1 */
  public void validate(UnderexcLimX1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "UnderexcLimX1FetchOneSummary should not be null");
    Assert.notNull(
        summary.getUnderexcLimX1Id(), "UnderexcLimX1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign K validation for a UnderexcLimX1
   *
   * @param command AssignKToUnderexcLimX1Command
   */
  public void validate(AssignKToUnderexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignKToUnderexcLimX1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX1Id(),
        "AssignKToUnderexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKToUnderexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign K validation for a UnderexcLimX1
   *
   * @param command UnAssignKFromUnderexcLimX1Command
   */
  public void validate(UnAssignKFromUnderexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKFromUnderexcLimX1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX1Id(),
        "UnAssignKFromUnderexcLimX1Command identifier should not be null");
  }
  /**
   * handles assign Kf2 validation for a UnderexcLimX1
   *
   * @param command AssignKf2ToUnderexcLimX1Command
   */
  public void validate(AssignKf2ToUnderexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignKf2ToUnderexcLimX1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX1Id(),
        "AssignKf2ToUnderexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKf2ToUnderexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign Kf2 validation for a UnderexcLimX1
   *
   * @param command UnAssignKf2FromUnderexcLimX1Command
   */
  public void validate(UnAssignKf2FromUnderexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKf2FromUnderexcLimX1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX1Id(),
        "UnAssignKf2FromUnderexcLimX1Command identifier should not be null");
  }
  /**
   * handles assign Km validation for a UnderexcLimX1
   *
   * @param command AssignKmToUnderexcLimX1Command
   */
  public void validate(AssignKmToUnderexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignKmToUnderexcLimX1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX1Id(),
        "AssignKmToUnderexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKmToUnderexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign Km validation for a UnderexcLimX1
   *
   * @param command UnAssignKmFromUnderexcLimX1Command
   */
  public void validate(UnAssignKmFromUnderexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKmFromUnderexcLimX1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX1Id(),
        "UnAssignKmFromUnderexcLimX1Command identifier should not be null");
  }
  /**
   * handles assign Melmax validation for a UnderexcLimX1
   *
   * @param command AssignMelmaxToUnderexcLimX1Command
   */
  public void validate(AssignMelmaxToUnderexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignMelmaxToUnderexcLimX1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX1Id(),
        "AssignMelmaxToUnderexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMelmaxToUnderexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign Melmax validation for a UnderexcLimX1
   *
   * @param command UnAssignMelmaxFromUnderexcLimX1Command
   */
  public void validate(UnAssignMelmaxFromUnderexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignMelmaxFromUnderexcLimX1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX1Id(),
        "UnAssignMelmaxFromUnderexcLimX1Command identifier should not be null");
  }
  /**
   * handles assign Tf2 validation for a UnderexcLimX1
   *
   * @param command AssignTf2ToUnderexcLimX1Command
   */
  public void validate(AssignTf2ToUnderexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignTf2ToUnderexcLimX1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX1Id(),
        "AssignTf2ToUnderexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf2ToUnderexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign Tf2 validation for a UnderexcLimX1
   *
   * @param command UnAssignTf2FromUnderexcLimX1Command
   */
  public void validate(UnAssignTf2FromUnderexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTf2FromUnderexcLimX1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX1Id(),
        "UnAssignTf2FromUnderexcLimX1Command identifier should not be null");
  }
  /**
   * handles assign Tm validation for a UnderexcLimX1
   *
   * @param command AssignTmToUnderexcLimX1Command
   */
  public void validate(AssignTmToUnderexcLimX1Command command) throws Exception {
    Assert.notNull(command, "AssignTmToUnderexcLimX1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX1Id(),
        "AssignTmToUnderexcLimX1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTmToUnderexcLimX1Command assignment should not be null");
  }

  /**
   * handles unassign Tm validation for a UnderexcLimX1
   *
   * @param command UnAssignTmFromUnderexcLimX1Command
   */
  public void validate(UnAssignTmFromUnderexcLimX1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTmFromUnderexcLimX1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimX1Id(),
        "UnAssignTmFromUnderexcLimX1Command identifier should not be null");
  }
}
