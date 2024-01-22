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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class GovHydroPIDValidator {

  /** default constructor */
  protected GovHydroPIDValidator() {}

  /** factory method */
  public static GovHydroPIDValidator getInstance() {
    return new GovHydroPIDValidator();
  }

  /** handles creation validation for a GovHydroPID */
  public void validate(CreateGovHydroPIDCommand govHydroPID) throws Exception {
    Assert.notNull(govHydroPID, "CreateGovHydroPIDCommand should not be null");
    //		Assert.isNull( govHydroPID.getGovHydroPIDId(), "CreateGovHydroPIDCommand identifier should
    // be null" );
  }

  /** handles update validation for a GovHydroPID */
  public void validate(UpdateGovHydroPIDCommand govHydroPID) throws Exception {
    Assert.notNull(govHydroPID, "UpdateGovHydroPIDCommand should not be null");
    Assert.notNull(
        govHydroPID.getGovHydroPIDId(), "UpdateGovHydroPIDCommand identifier should not be null");
  }

  /** handles delete validation for a GovHydroPID */
  public void validate(DeleteGovHydroPIDCommand govHydroPID) throws Exception {
    Assert.notNull(govHydroPID, "{commandAlias} should not be null");
    Assert.notNull(
        govHydroPID.getGovHydroPIDId(), "DeleteGovHydroPIDCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GovHydroPID */
  public void validate(GovHydroPIDFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovHydroPIDFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovHydroPIDId(), "GovHydroPIDFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Aturb validation for a GovHydroPID
   *
   * @param command AssignAturbToGovHydroPIDCommand
   */
  public void validate(AssignAturbToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignAturbToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "AssignAturbToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAturbToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Aturb validation for a GovHydroPID
   *
   * @param command UnAssignAturbFromGovHydroPIDCommand
   */
  public void validate(UnAssignAturbFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAturbFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignAturbFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Bturb validation for a GovHydroPID
   *
   * @param command AssignBturbToGovHydroPIDCommand
   */
  public void validate(AssignBturbToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignBturbToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "AssignBturbToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBturbToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Bturb validation for a GovHydroPID
   *
   * @param command UnAssignBturbFromGovHydroPIDCommand
   */
  public void validate(UnAssignBturbFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBturbFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignBturbFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Db1 validation for a GovHydroPID
   *
   * @param command AssignDb1ToGovHydroPIDCommand
   */
  public void validate(AssignDb1ToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignDb1ToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignDb1ToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb1ToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Db1 validation for a GovHydroPID
   *
   * @param command UnAssignDb1FromGovHydroPIDCommand
   */
  public void validate(UnAssignDb1FromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDb1FromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignDb1FromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Db2 validation for a GovHydroPID
   *
   * @param command AssignDb2ToGovHydroPIDCommand
   */
  public void validate(AssignDb2ToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignDb2ToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignDb2ToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb2ToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Db2 validation for a GovHydroPID
   *
   * @param command UnAssignDb2FromGovHydroPIDCommand
   */
  public void validate(UnAssignDb2FromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDb2FromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignDb2FromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Eps validation for a GovHydroPID
   *
   * @param command AssignEpsToGovHydroPIDCommand
   */
  public void validate(AssignEpsToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignEpsToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignEpsToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEpsToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Eps validation for a GovHydroPID
   *
   * @param command UnAssignEpsFromGovHydroPIDCommand
   */
  public void validate(UnAssignEpsFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEpsFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignEpsFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Gv1 validation for a GovHydroPID
   *
   * @param command AssignGv1ToGovHydroPIDCommand
   */
  public void validate(AssignGv1ToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignGv1ToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignGv1ToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv1ToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Gv1 validation for a GovHydroPID
   *
   * @param command UnAssignGv1FromGovHydroPIDCommand
   */
  public void validate(UnAssignGv1FromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv1FromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignGv1FromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Gv2 validation for a GovHydroPID
   *
   * @param command AssignGv2ToGovHydroPIDCommand
   */
  public void validate(AssignGv2ToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignGv2ToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignGv2ToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv2ToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Gv2 validation for a GovHydroPID
   *
   * @param command UnAssignGv2FromGovHydroPIDCommand
   */
  public void validate(UnAssignGv2FromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv2FromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignGv2FromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Gv3 validation for a GovHydroPID
   *
   * @param command AssignGv3ToGovHydroPIDCommand
   */
  public void validate(AssignGv3ToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignGv3ToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignGv3ToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv3ToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Gv3 validation for a GovHydroPID
   *
   * @param command UnAssignGv3FromGovHydroPIDCommand
   */
  public void validate(UnAssignGv3FromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv3FromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignGv3FromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Gv4 validation for a GovHydroPID
   *
   * @param command AssignGv4ToGovHydroPIDCommand
   */
  public void validate(AssignGv4ToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignGv4ToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignGv4ToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv4ToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Gv4 validation for a GovHydroPID
   *
   * @param command UnAssignGv4FromGovHydroPIDCommand
   */
  public void validate(UnAssignGv4FromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv4FromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignGv4FromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Gv5 validation for a GovHydroPID
   *
   * @param command AssignGv5ToGovHydroPIDCommand
   */
  public void validate(AssignGv5ToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignGv5ToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignGv5ToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv5ToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Gv5 validation for a GovHydroPID
   *
   * @param command UnAssignGv5FromGovHydroPIDCommand
   */
  public void validate(UnAssignGv5FromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv5FromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignGv5FromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Gv6 validation for a GovHydroPID
   *
   * @param command AssignGv6ToGovHydroPIDCommand
   */
  public void validate(AssignGv6ToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignGv6ToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignGv6ToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv6ToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Gv6 validation for a GovHydroPID
   *
   * @param command UnAssignGv6FromGovHydroPIDCommand
   */
  public void validate(UnAssignGv6FromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv6FromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignGv6FromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign InputSignal validation for a GovHydroPID
   *
   * @param command AssignInputSignalToGovHydroPIDCommand
   */
  public void validate(AssignInputSignalToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignInputSignalToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "AssignInputSignalToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignInputSignalToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign InputSignal validation for a GovHydroPID
   *
   * @param command UnAssignInputSignalFromGovHydroPIDCommand
   */
  public void validate(UnAssignInputSignalFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignInputSignalFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignInputSignalFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a GovHydroPID
   *
   * @param command AssignKdToGovHydroPIDCommand
   */
  public void validate(AssignKdToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignKdToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignKdToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a GovHydroPID
   *
   * @param command UnAssignKdFromGovHydroPIDCommand
   */
  public void validate(UnAssignKdFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignKdFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Kg validation for a GovHydroPID
   *
   * @param command AssignKgToGovHydroPIDCommand
   */
  public void validate(AssignKgToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignKgToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignKgToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKgToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Kg validation for a GovHydroPID
   *
   * @param command UnAssignKgFromGovHydroPIDCommand
   */
  public void validate(UnAssignKgFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKgFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignKgFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a GovHydroPID
   *
   * @param command AssignKiToGovHydroPIDCommand
   */
  public void validate(AssignKiToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignKiToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignKiToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a GovHydroPID
   *
   * @param command UnAssignKiFromGovHydroPIDCommand
   */
  public void validate(UnAssignKiFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignKiFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a GovHydroPID
   *
   * @param command AssignKpToGovHydroPIDCommand
   */
  public void validate(AssignKpToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignKpToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignKpToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a GovHydroPID
   *
   * @param command UnAssignKpFromGovHydroPIDCommand
   */
  public void validate(UnAssignKpFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignKpFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovHydroPID
   *
   * @param command AssignMwbaseToGovHydroPIDCommand
   */
  public void validate(AssignMwbaseToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "AssignMwbaseToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovHydroPID
   *
   * @param command UnAssignMwbaseFromGovHydroPIDCommand
   */
  public void validate(UnAssignMwbaseFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignMwbaseFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Pgv1 validation for a GovHydroPID
   *
   * @param command AssignPgv1ToGovHydroPIDCommand
   */
  public void validate(AssignPgv1ToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv1ToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignPgv1ToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv1ToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv1 validation for a GovHydroPID
   *
   * @param command UnAssignPgv1FromGovHydroPIDCommand
   */
  public void validate(UnAssignPgv1FromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv1FromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignPgv1FromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Pgv2 validation for a GovHydroPID
   *
   * @param command AssignPgv2ToGovHydroPIDCommand
   */
  public void validate(AssignPgv2ToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv2ToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignPgv2ToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv2ToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv2 validation for a GovHydroPID
   *
   * @param command UnAssignPgv2FromGovHydroPIDCommand
   */
  public void validate(UnAssignPgv2FromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv2FromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignPgv2FromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Pgv3 validation for a GovHydroPID
   *
   * @param command AssignPgv3ToGovHydroPIDCommand
   */
  public void validate(AssignPgv3ToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv3ToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignPgv3ToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv3ToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv3 validation for a GovHydroPID
   *
   * @param command UnAssignPgv3FromGovHydroPIDCommand
   */
  public void validate(UnAssignPgv3FromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv3FromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignPgv3FromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Pgv4 validation for a GovHydroPID
   *
   * @param command AssignPgv4ToGovHydroPIDCommand
   */
  public void validate(AssignPgv4ToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv4ToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignPgv4ToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv4ToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv4 validation for a GovHydroPID
   *
   * @param command UnAssignPgv4FromGovHydroPIDCommand
   */
  public void validate(UnAssignPgv4FromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv4FromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignPgv4FromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Pgv5 validation for a GovHydroPID
   *
   * @param command AssignPgv5ToGovHydroPIDCommand
   */
  public void validate(AssignPgv5ToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv5ToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignPgv5ToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv5ToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv5 validation for a GovHydroPID
   *
   * @param command UnAssignPgv5FromGovHydroPIDCommand
   */
  public void validate(UnAssignPgv5FromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv5FromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignPgv5FromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Pgv6 validation for a GovHydroPID
   *
   * @param command AssignPgv6ToGovHydroPIDCommand
   */
  public void validate(AssignPgv6ToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv6ToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignPgv6ToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv6ToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv6 validation for a GovHydroPID
   *
   * @param command UnAssignPgv6FromGovHydroPIDCommand
   */
  public void validate(UnAssignPgv6FromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv6FromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignPgv6FromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Pmax validation for a GovHydroPID
   *
   * @param command AssignPmaxToGovHydroPIDCommand
   */
  public void validate(AssignPmaxToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignPmaxToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignPmaxToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Pmax validation for a GovHydroPID
   *
   * @param command UnAssignPmaxFromGovHydroPIDCommand
   */
  public void validate(UnAssignPmaxFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignPmaxFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Pmin validation for a GovHydroPID
   *
   * @param command AssignPminToGovHydroPIDCommand
   */
  public void validate(AssignPminToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignPminToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignPminToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPminToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Pmin validation for a GovHydroPID
   *
   * @param command UnAssignPminFromGovHydroPIDCommand
   */
  public void validate(UnAssignPminFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPminFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignPminFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign R validation for a GovHydroPID
   *
   * @param command AssignRToGovHydroPIDCommand
   */
  public void validate(AssignRToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignRToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignRToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign R validation for a GovHydroPID
   *
   * @param command UnAssignRFromGovHydroPIDCommand
   */
  public void validate(UnAssignRFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignRFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Td validation for a GovHydroPID
   *
   * @param command AssignTdToGovHydroPIDCommand
   */
  public void validate(AssignTdToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignTdToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignTdToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Td validation for a GovHydroPID
   *
   * @param command UnAssignTdFromGovHydroPIDCommand
   */
  public void validate(UnAssignTdFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignTdFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a GovHydroPID
   *
   * @param command AssignTfToGovHydroPIDCommand
   */
  public void validate(AssignTfToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignTfToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignTfToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a GovHydroPID
   *
   * @param command UnAssignTfFromGovHydroPIDCommand
   */
  public void validate(UnAssignTfFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignTfFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Tp validation for a GovHydroPID
   *
   * @param command AssignTpToGovHydroPIDCommand
   */
  public void validate(AssignTpToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignTpToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignTpToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Tp validation for a GovHydroPID
   *
   * @param command UnAssignTpFromGovHydroPIDCommand
   */
  public void validate(UnAssignTpFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignTpFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Tt validation for a GovHydroPID
   *
   * @param command AssignTtToGovHydroPIDCommand
   */
  public void validate(AssignTtToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignTtToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(), "AssignTtToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTtToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Tt validation for a GovHydroPID
   *
   * @param command UnAssignTtFromGovHydroPIDCommand
   */
  public void validate(UnAssignTtFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTtFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignTtFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Tturb validation for a GovHydroPID
   *
   * @param command AssignTturbToGovHydroPIDCommand
   */
  public void validate(AssignTturbToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignTturbToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "AssignTturbToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTturbToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Tturb validation for a GovHydroPID
   *
   * @param command UnAssignTturbFromGovHydroPIDCommand
   */
  public void validate(UnAssignTturbFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTturbFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignTturbFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Velcl validation for a GovHydroPID
   *
   * @param command AssignVelclToGovHydroPIDCommand
   */
  public void validate(AssignVelclToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignVelclToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "AssignVelclToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVelclToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Velcl validation for a GovHydroPID
   *
   * @param command UnAssignVelclFromGovHydroPIDCommand
   */
  public void validate(UnAssignVelclFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVelclFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignVelclFromGovHydroPIDCommand identifier should not be null");
  }
  /**
   * handles assign Velop validation for a GovHydroPID
   *
   * @param command AssignVelopToGovHydroPIDCommand
   */
  public void validate(AssignVelopToGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignVelopToGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "AssignVelopToGovHydroPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVelopToGovHydroPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Velop validation for a GovHydroPID
   *
   * @param command UnAssignVelopFromGovHydroPIDCommand
   */
  public void validate(UnAssignVelopFromGovHydroPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVelopFromGovHydroPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroPIDId(),
        "UnAssignVelopFromGovHydroPIDCommand identifier should not be null");
  }
}
