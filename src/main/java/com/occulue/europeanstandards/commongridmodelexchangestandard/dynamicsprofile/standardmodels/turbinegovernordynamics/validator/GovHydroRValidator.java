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

public class GovHydroRValidator {

  /** default constructor */
  protected GovHydroRValidator() {}

  /** factory method */
  public static GovHydroRValidator getInstance() {
    return new GovHydroRValidator();
  }

  /** handles creation validation for a GovHydroR */
  public void validate(CreateGovHydroRCommand govHydroR) throws Exception {
    Assert.notNull(govHydroR, "CreateGovHydroRCommand should not be null");
    //		Assert.isNull( govHydroR.getGovHydroRId(), "CreateGovHydroRCommand identifier should be
    // null" );
  }

  /** handles update validation for a GovHydroR */
  public void validate(UpdateGovHydroRCommand govHydroR) throws Exception {
    Assert.notNull(govHydroR, "UpdateGovHydroRCommand should not be null");
    Assert.notNull(
        govHydroR.getGovHydroRId(), "UpdateGovHydroRCommand identifier should not be null");
  }

  /** handles delete validation for a GovHydroR */
  public void validate(DeleteGovHydroRCommand govHydroR) throws Exception {
    Assert.notNull(govHydroR, "{commandAlias} should not be null");
    Assert.notNull(
        govHydroR.getGovHydroRId(), "DeleteGovHydroRCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GovHydroR */
  public void validate(GovHydroRFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovHydroRFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovHydroRId(), "GovHydroRFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign At validation for a GovHydroR
   *
   * @param command AssignAtToGovHydroRCommand
   */
  public void validate(AssignAtToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignAtToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignAtToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAtToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign At validation for a GovHydroR
   *
   * @param command UnAssignAtFromGovHydroRCommand
   */
  public void validate(UnAssignAtFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAtFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignAtFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Db1 validation for a GovHydroR
   *
   * @param command AssignDb1ToGovHydroRCommand
   */
  public void validate(AssignDb1ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignDb1ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignDb1ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb1ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Db1 validation for a GovHydroR
   *
   * @param command UnAssignDb1FromGovHydroRCommand
   */
  public void validate(UnAssignDb1FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDb1FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignDb1FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Db2 validation for a GovHydroR
   *
   * @param command AssignDb2ToGovHydroRCommand
   */
  public void validate(AssignDb2ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignDb2ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignDb2ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb2ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Db2 validation for a GovHydroR
   *
   * @param command UnAssignDb2FromGovHydroRCommand
   */
  public void validate(UnAssignDb2FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDb2FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignDb2FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Dturb validation for a GovHydroR
   *
   * @param command AssignDturbToGovHydroRCommand
   */
  public void validate(AssignDturbToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignDturbToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignDturbToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDturbToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Dturb validation for a GovHydroR
   *
   * @param command UnAssignDturbFromGovHydroRCommand
   */
  public void validate(UnAssignDturbFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDturbFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(),
        "UnAssignDturbFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Eps validation for a GovHydroR
   *
   * @param command AssignEpsToGovHydroRCommand
   */
  public void validate(AssignEpsToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignEpsToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignEpsToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEpsToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Eps validation for a GovHydroR
   *
   * @param command UnAssignEpsFromGovHydroRCommand
   */
  public void validate(UnAssignEpsFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEpsFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignEpsFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Gmax validation for a GovHydroR
   *
   * @param command AssignGmaxToGovHydroRCommand
   */
  public void validate(AssignGmaxToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignGmaxToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignGmaxToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGmaxToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Gmax validation for a GovHydroR
   *
   * @param command UnAssignGmaxFromGovHydroRCommand
   */
  public void validate(UnAssignGmaxFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGmaxFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignGmaxFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Gmin validation for a GovHydroR
   *
   * @param command AssignGminToGovHydroRCommand
   */
  public void validate(AssignGminToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignGminToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignGminToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGminToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Gmin validation for a GovHydroR
   *
   * @param command UnAssignGminFromGovHydroRCommand
   */
  public void validate(UnAssignGminFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGminFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignGminFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Gv1 validation for a GovHydroR
   *
   * @param command AssignGv1ToGovHydroRCommand
   */
  public void validate(AssignGv1ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignGv1ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignGv1ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv1ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Gv1 validation for a GovHydroR
   *
   * @param command UnAssignGv1FromGovHydroRCommand
   */
  public void validate(UnAssignGv1FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv1FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignGv1FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Gv2 validation for a GovHydroR
   *
   * @param command AssignGv2ToGovHydroRCommand
   */
  public void validate(AssignGv2ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignGv2ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignGv2ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv2ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Gv2 validation for a GovHydroR
   *
   * @param command UnAssignGv2FromGovHydroRCommand
   */
  public void validate(UnAssignGv2FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv2FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignGv2FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Gv3 validation for a GovHydroR
   *
   * @param command AssignGv3ToGovHydroRCommand
   */
  public void validate(AssignGv3ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignGv3ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignGv3ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv3ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Gv3 validation for a GovHydroR
   *
   * @param command UnAssignGv3FromGovHydroRCommand
   */
  public void validate(UnAssignGv3FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv3FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignGv3FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Gv4 validation for a GovHydroR
   *
   * @param command AssignGv4ToGovHydroRCommand
   */
  public void validate(AssignGv4ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignGv4ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignGv4ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv4ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Gv4 validation for a GovHydroR
   *
   * @param command UnAssignGv4FromGovHydroRCommand
   */
  public void validate(UnAssignGv4FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv4FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignGv4FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Gv5 validation for a GovHydroR
   *
   * @param command AssignGv5ToGovHydroRCommand
   */
  public void validate(AssignGv5ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignGv5ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignGv5ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv5ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Gv5 validation for a GovHydroR
   *
   * @param command UnAssignGv5FromGovHydroRCommand
   */
  public void validate(UnAssignGv5FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv5FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignGv5FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Gv6 validation for a GovHydroR
   *
   * @param command AssignGv6ToGovHydroRCommand
   */
  public void validate(AssignGv6ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignGv6ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignGv6ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv6ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Gv6 validation for a GovHydroR
   *
   * @param command UnAssignGv6FromGovHydroRCommand
   */
  public void validate(UnAssignGv6FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv6FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignGv6FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign H0 validation for a GovHydroR
   *
   * @param command AssignH0ToGovHydroRCommand
   */
  public void validate(AssignH0ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignH0ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignH0ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignH0ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign H0 validation for a GovHydroR
   *
   * @param command UnAssignH0FromGovHydroRCommand
   */
  public void validate(UnAssignH0FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignH0FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignH0FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign InputSignal validation for a GovHydroR
   *
   * @param command AssignInputSignalToGovHydroRCommand
   */
  public void validate(AssignInputSignalToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignInputSignalToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(),
        "AssignInputSignalToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignInputSignalToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign InputSignal validation for a GovHydroR
   *
   * @param command UnAssignInputSignalFromGovHydroRCommand
   */
  public void validate(UnAssignInputSignalFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignInputSignalFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(),
        "UnAssignInputSignalFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Kg validation for a GovHydroR
   *
   * @param command AssignKgToGovHydroRCommand
   */
  public void validate(AssignKgToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignKgToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignKgToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKgToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Kg validation for a GovHydroR
   *
   * @param command UnAssignKgFromGovHydroRCommand
   */
  public void validate(UnAssignKgFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKgFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignKgFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a GovHydroR
   *
   * @param command AssignKiToGovHydroRCommand
   */
  public void validate(AssignKiToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignKiToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignKiToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a GovHydroR
   *
   * @param command UnAssignKiFromGovHydroRCommand
   */
  public void validate(UnAssignKiFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignKiFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovHydroR
   *
   * @param command AssignMwbaseToGovHydroRCommand
   */
  public void validate(AssignMwbaseToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignMwbaseToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovHydroR
   *
   * @param command UnAssignMwbaseFromGovHydroRCommand
   */
  public void validate(UnAssignMwbaseFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(),
        "UnAssignMwbaseFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Pgv1 validation for a GovHydroR
   *
   * @param command AssignPgv1ToGovHydroRCommand
   */
  public void validate(AssignPgv1ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv1ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignPgv1ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv1ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv1 validation for a GovHydroR
   *
   * @param command UnAssignPgv1FromGovHydroRCommand
   */
  public void validate(UnAssignPgv1FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv1FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignPgv1FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Pgv2 validation for a GovHydroR
   *
   * @param command AssignPgv2ToGovHydroRCommand
   */
  public void validate(AssignPgv2ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv2ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignPgv2ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv2ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv2 validation for a GovHydroR
   *
   * @param command UnAssignPgv2FromGovHydroRCommand
   */
  public void validate(UnAssignPgv2FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv2FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignPgv2FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Pgv3 validation for a GovHydroR
   *
   * @param command AssignPgv3ToGovHydroRCommand
   */
  public void validate(AssignPgv3ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv3ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignPgv3ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv3ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv3 validation for a GovHydroR
   *
   * @param command UnAssignPgv3FromGovHydroRCommand
   */
  public void validate(UnAssignPgv3FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv3FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignPgv3FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Pgv4 validation for a GovHydroR
   *
   * @param command AssignPgv4ToGovHydroRCommand
   */
  public void validate(AssignPgv4ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv4ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignPgv4ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv4ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv4 validation for a GovHydroR
   *
   * @param command UnAssignPgv4FromGovHydroRCommand
   */
  public void validate(UnAssignPgv4FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv4FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignPgv4FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Pgv5 validation for a GovHydroR
   *
   * @param command AssignPgv5ToGovHydroRCommand
   */
  public void validate(AssignPgv5ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv5ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignPgv5ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv5ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv5 validation for a GovHydroR
   *
   * @param command UnAssignPgv5FromGovHydroRCommand
   */
  public void validate(UnAssignPgv5FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv5FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignPgv5FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Pgv6 validation for a GovHydroR
   *
   * @param command AssignPgv6ToGovHydroRCommand
   */
  public void validate(AssignPgv6ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv6ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignPgv6ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv6ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv6 validation for a GovHydroR
   *
   * @param command UnAssignPgv6FromGovHydroRCommand
   */
  public void validate(UnAssignPgv6FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv6FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignPgv6FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Pmax validation for a GovHydroR
   *
   * @param command AssignPmaxToGovHydroRCommand
   */
  public void validate(AssignPmaxToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignPmaxToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignPmaxToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Pmax validation for a GovHydroR
   *
   * @param command UnAssignPmaxFromGovHydroRCommand
   */
  public void validate(UnAssignPmaxFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignPmaxFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Pmin validation for a GovHydroR
   *
   * @param command AssignPminToGovHydroRCommand
   */
  public void validate(AssignPminToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignPminToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignPminToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPminToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Pmin validation for a GovHydroR
   *
   * @param command UnAssignPminFromGovHydroRCommand
   */
  public void validate(UnAssignPminFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPminFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignPminFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Qnl validation for a GovHydroR
   *
   * @param command AssignQnlToGovHydroRCommand
   */
  public void validate(AssignQnlToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignQnlToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignQnlToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQnlToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Qnl validation for a GovHydroR
   *
   * @param command UnAssignQnlFromGovHydroRCommand
   */
  public void validate(UnAssignQnlFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQnlFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignQnlFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign R validation for a GovHydroR
   *
   * @param command AssignRToGovHydroRCommand
   */
  public void validate(AssignRToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignRToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignRToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign R validation for a GovHydroR
   *
   * @param command UnAssignRFromGovHydroRCommand
   */
  public void validate(UnAssignRFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignRFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a GovHydroR
   *
   * @param command AssignT1ToGovHydroRCommand
   */
  public void validate(AssignT1ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignT1ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a GovHydroR
   *
   * @param command UnAssignT1FromGovHydroRCommand
   */
  public void validate(UnAssignT1FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignT1FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a GovHydroR
   *
   * @param command AssignT2ToGovHydroRCommand
   */
  public void validate(AssignT2ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignT2ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a GovHydroR
   *
   * @param command UnAssignT2FromGovHydroRCommand
   */
  public void validate(UnAssignT2FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignT2FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign T3 validation for a GovHydroR
   *
   * @param command AssignT3ToGovHydroRCommand
   */
  public void validate(AssignT3ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignT3ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignT3ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a GovHydroR
   *
   * @param command UnAssignT3FromGovHydroRCommand
   */
  public void validate(UnAssignT3FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignT3FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign T4 validation for a GovHydroR
   *
   * @param command AssignT4ToGovHydroRCommand
   */
  public void validate(AssignT4ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignT4ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignT4ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a GovHydroR
   *
   * @param command UnAssignT4FromGovHydroRCommand
   */
  public void validate(UnAssignT4FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignT4FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign T5 validation for a GovHydroR
   *
   * @param command AssignT5ToGovHydroRCommand
   */
  public void validate(AssignT5ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignT5ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignT5ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a GovHydroR
   *
   * @param command UnAssignT5FromGovHydroRCommand
   */
  public void validate(UnAssignT5FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignT5FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign T6 validation for a GovHydroR
   *
   * @param command AssignT6ToGovHydroRCommand
   */
  public void validate(AssignT6ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignT6ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignT6ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT6ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a GovHydroR
   *
   * @param command UnAssignT6FromGovHydroRCommand
   */
  public void validate(UnAssignT6FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignT6FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign T7 validation for a GovHydroR
   *
   * @param command AssignT7ToGovHydroRCommand
   */
  public void validate(AssignT7ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignT7ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignT7ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT7ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign T7 validation for a GovHydroR
   *
   * @param command UnAssignT7FromGovHydroRCommand
   */
  public void validate(UnAssignT7FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT7FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignT7FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign T8 validation for a GovHydroR
   *
   * @param command AssignT8ToGovHydroRCommand
   */
  public void validate(AssignT8ToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignT8ToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignT8ToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT8ToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign T8 validation for a GovHydroR
   *
   * @param command UnAssignT8FromGovHydroRCommand
   */
  public void validate(UnAssignT8FromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT8FromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignT8FromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Td validation for a GovHydroR
   *
   * @param command AssignTdToGovHydroRCommand
   */
  public void validate(AssignTdToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignTdToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignTdToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Td validation for a GovHydroR
   *
   * @param command UnAssignTdFromGovHydroRCommand
   */
  public void validate(UnAssignTdFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignTdFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Tp validation for a GovHydroR
   *
   * @param command AssignTpToGovHydroRCommand
   */
  public void validate(AssignTpToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignTpToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignTpToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Tp validation for a GovHydroR
   *
   * @param command UnAssignTpFromGovHydroRCommand
   */
  public void validate(UnAssignTpFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignTpFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Tt validation for a GovHydroR
   *
   * @param command AssignTtToGovHydroRCommand
   */
  public void validate(AssignTtToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignTtToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignTtToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTtToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Tt validation for a GovHydroR
   *
   * @param command UnAssignTtFromGovHydroRCommand
   */
  public void validate(UnAssignTtFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTtFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignTtFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Tw validation for a GovHydroR
   *
   * @param command AssignTwToGovHydroRCommand
   */
  public void validate(AssignTwToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignTwToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignTwToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTwToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Tw validation for a GovHydroR
   *
   * @param command UnAssignTwFromGovHydroRCommand
   */
  public void validate(UnAssignTwFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTwFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "UnAssignTwFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Velcl validation for a GovHydroR
   *
   * @param command AssignVelclToGovHydroRCommand
   */
  public void validate(AssignVelclToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignVelclToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignVelclToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVelclToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Velcl validation for a GovHydroR
   *
   * @param command UnAssignVelclFromGovHydroRCommand
   */
  public void validate(UnAssignVelclFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVelclFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(),
        "UnAssignVelclFromGovHydroRCommand identifier should not be null");
  }
  /**
   * handles assign Velop validation for a GovHydroR
   *
   * @param command AssignVelopToGovHydroRCommand
   */
  public void validate(AssignVelopToGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "AssignVelopToGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(), "AssignVelopToGovHydroRCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVelopToGovHydroRCommand assignment should not be null");
  }

  /**
   * handles unassign Velop validation for a GovHydroR
   *
   * @param command UnAssignVelopFromGovHydroRCommand
   */
  public void validate(UnAssignVelopFromGovHydroRCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVelopFromGovHydroRCommand should not be null");
    Assert.notNull(
        command.getGovHydroRId(),
        "UnAssignVelopFromGovHydroRCommand identifier should not be null");
  }
}
