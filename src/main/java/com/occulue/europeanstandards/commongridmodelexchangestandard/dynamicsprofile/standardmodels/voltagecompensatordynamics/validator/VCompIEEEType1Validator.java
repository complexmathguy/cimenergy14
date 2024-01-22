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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class VCompIEEEType1Validator {

  /** default constructor */
  protected VCompIEEEType1Validator() {}

  /** factory method */
  public static VCompIEEEType1Validator getInstance() {
    return new VCompIEEEType1Validator();
  }

  /** handles creation validation for a VCompIEEEType1 */
  public void validate(CreateVCompIEEEType1Command vCompIEEEType1) throws Exception {
    Assert.notNull(vCompIEEEType1, "CreateVCompIEEEType1Command should not be null");
    //		Assert.isNull( vCompIEEEType1.getVCompIEEEType1Id(), "CreateVCompIEEEType1Command identifier
    // should be null" );
  }

  /** handles update validation for a VCompIEEEType1 */
  public void validate(UpdateVCompIEEEType1Command vCompIEEEType1) throws Exception {
    Assert.notNull(vCompIEEEType1, "UpdateVCompIEEEType1Command should not be null");
    Assert.notNull(
        vCompIEEEType1.getVCompIEEEType1Id(),
        "UpdateVCompIEEEType1Command identifier should not be null");
  }

  /** handles delete validation for a VCompIEEEType1 */
  public void validate(DeleteVCompIEEEType1Command vCompIEEEType1) throws Exception {
    Assert.notNull(vCompIEEEType1, "{commandAlias} should not be null");
    Assert.notNull(
        vCompIEEEType1.getVCompIEEEType1Id(),
        "DeleteVCompIEEEType1Command identifier should not be null");
  }

  /** handles fetchOne validation for a VCompIEEEType1 */
  public void validate(VCompIEEEType1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "VCompIEEEType1FetchOneSummary should not be null");
    Assert.notNull(
        summary.getVCompIEEEType1Id(),
        "VCompIEEEType1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Rc validation for a VCompIEEEType1
   *
   * @param command AssignRcToVCompIEEEType1Command
   */
  public void validate(AssignRcToVCompIEEEType1Command command) throws Exception {
    Assert.notNull(command, "AssignRcToVCompIEEEType1Command should not be null");
    Assert.notNull(
        command.getVCompIEEEType1Id(),
        "AssignRcToVCompIEEEType1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRcToVCompIEEEType1Command assignment should not be null");
  }

  /**
   * handles unassign Rc validation for a VCompIEEEType1
   *
   * @param command UnAssignRcFromVCompIEEEType1Command
   */
  public void validate(UnAssignRcFromVCompIEEEType1Command command) throws Exception {
    Assert.notNull(command, "UnAssignRcFromVCompIEEEType1Command should not be null");
    Assert.notNull(
        command.getVCompIEEEType1Id(),
        "UnAssignRcFromVCompIEEEType1Command identifier should not be null");
  }
  /**
   * handles assign Tr validation for a VCompIEEEType1
   *
   * @param command AssignTrToVCompIEEEType1Command
   */
  public void validate(AssignTrToVCompIEEEType1Command command) throws Exception {
    Assert.notNull(command, "AssignTrToVCompIEEEType1Command should not be null");
    Assert.notNull(
        command.getVCompIEEEType1Id(),
        "AssignTrToVCompIEEEType1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTrToVCompIEEEType1Command assignment should not be null");
  }

  /**
   * handles unassign Tr validation for a VCompIEEEType1
   *
   * @param command UnAssignTrFromVCompIEEEType1Command
   */
  public void validate(UnAssignTrFromVCompIEEEType1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTrFromVCompIEEEType1Command should not be null");
    Assert.notNull(
        command.getVCompIEEEType1Id(),
        "UnAssignTrFromVCompIEEEType1Command identifier should not be null");
  }
  /**
   * handles assign Xc validation for a VCompIEEEType1
   *
   * @param command AssignXcToVCompIEEEType1Command
   */
  public void validate(AssignXcToVCompIEEEType1Command command) throws Exception {
    Assert.notNull(command, "AssignXcToVCompIEEEType1Command should not be null");
    Assert.notNull(
        command.getVCompIEEEType1Id(),
        "AssignXcToVCompIEEEType1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXcToVCompIEEEType1Command assignment should not be null");
  }

  /**
   * handles unassign Xc validation for a VCompIEEEType1
   *
   * @param command UnAssignXcFromVCompIEEEType1Command
   */
  public void validate(UnAssignXcFromVCompIEEEType1Command command) throws Exception {
    Assert.notNull(command, "UnAssignXcFromVCompIEEEType1Command should not be null");
    Assert.notNull(
        command.getVCompIEEEType1Id(),
        "UnAssignXcFromVCompIEEEType1Command identifier should not be null");
  }
}
