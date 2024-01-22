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

public class GovHydroWPIDValidator {

  /** default constructor */
  protected GovHydroWPIDValidator() {}

  /** factory method */
  public static GovHydroWPIDValidator getInstance() {
    return new GovHydroWPIDValidator();
  }

  /** handles creation validation for a GovHydroWPID */
  public void validate(CreateGovHydroWPIDCommand govHydroWPID) throws Exception {
    Assert.notNull(govHydroWPID, "CreateGovHydroWPIDCommand should not be null");
    //		Assert.isNull( govHydroWPID.getGovHydroWPIDId(), "CreateGovHydroWPIDCommand identifier
    // should be null" );
  }

  /** handles update validation for a GovHydroWPID */
  public void validate(UpdateGovHydroWPIDCommand govHydroWPID) throws Exception {
    Assert.notNull(govHydroWPID, "UpdateGovHydroWPIDCommand should not be null");
    Assert.notNull(
        govHydroWPID.getGovHydroWPIDId(),
        "UpdateGovHydroWPIDCommand identifier should not be null");
  }

  /** handles delete validation for a GovHydroWPID */
  public void validate(DeleteGovHydroWPIDCommand govHydroWPID) throws Exception {
    Assert.notNull(govHydroWPID, "{commandAlias} should not be null");
    Assert.notNull(
        govHydroWPID.getGovHydroWPIDId(),
        "DeleteGovHydroWPIDCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GovHydroWPID */
  public void validate(GovHydroWPIDFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovHydroWPIDFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovHydroWPIDId(), "GovHydroWPIDFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign D validation for a GovHydroWPID
   *
   * @param command AssignDToGovHydroWPIDCommand
   */
  public void validate(AssignDToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignDToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(), "AssignDToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign D validation for a GovHydroWPID
   *
   * @param command UnAssignDFromGovHydroWPIDCommand
   */
  public void validate(UnAssignDFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignDFromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Gatmax validation for a GovHydroWPID
   *
   * @param command AssignGatmaxToGovHydroWPIDCommand
   */
  public void validate(AssignGatmaxToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignGatmaxToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "AssignGatmaxToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGatmaxToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Gatmax validation for a GovHydroWPID
   *
   * @param command UnAssignGatmaxFromGovHydroWPIDCommand
   */
  public void validate(UnAssignGatmaxFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGatmaxFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignGatmaxFromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Gatmin validation for a GovHydroWPID
   *
   * @param command AssignGatminToGovHydroWPIDCommand
   */
  public void validate(AssignGatminToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignGatminToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "AssignGatminToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGatminToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Gatmin validation for a GovHydroWPID
   *
   * @param command UnAssignGatminFromGovHydroWPIDCommand
   */
  public void validate(UnAssignGatminFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGatminFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignGatminFromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Gv1 validation for a GovHydroWPID
   *
   * @param command AssignGv1ToGovHydroWPIDCommand
   */
  public void validate(AssignGv1ToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignGv1ToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "AssignGv1ToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv1ToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Gv1 validation for a GovHydroWPID
   *
   * @param command UnAssignGv1FromGovHydroWPIDCommand
   */
  public void validate(UnAssignGv1FromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv1FromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignGv1FromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Gv2 validation for a GovHydroWPID
   *
   * @param command AssignGv2ToGovHydroWPIDCommand
   */
  public void validate(AssignGv2ToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignGv2ToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "AssignGv2ToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv2ToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Gv2 validation for a GovHydroWPID
   *
   * @param command UnAssignGv2FromGovHydroWPIDCommand
   */
  public void validate(UnAssignGv2FromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv2FromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignGv2FromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Gv3 validation for a GovHydroWPID
   *
   * @param command AssignGv3ToGovHydroWPIDCommand
   */
  public void validate(AssignGv3ToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignGv3ToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "AssignGv3ToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv3ToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Gv3 validation for a GovHydroWPID
   *
   * @param command UnAssignGv3FromGovHydroWPIDCommand
   */
  public void validate(UnAssignGv3FromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv3FromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignGv3FromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a GovHydroWPID
   *
   * @param command AssignKdToGovHydroWPIDCommand
   */
  public void validate(AssignKdToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignKdToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(), "AssignKdToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a GovHydroWPID
   *
   * @param command UnAssignKdFromGovHydroWPIDCommand
   */
  public void validate(UnAssignKdFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignKdFromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a GovHydroWPID
   *
   * @param command AssignKiToGovHydroWPIDCommand
   */
  public void validate(AssignKiToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignKiToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(), "AssignKiToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a GovHydroWPID
   *
   * @param command UnAssignKiFromGovHydroWPIDCommand
   */
  public void validate(UnAssignKiFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignKiFromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a GovHydroWPID
   *
   * @param command AssignKpToGovHydroWPIDCommand
   */
  public void validate(AssignKpToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignKpToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(), "AssignKpToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a GovHydroWPID
   *
   * @param command UnAssignKpFromGovHydroWPIDCommand
   */
  public void validate(UnAssignKpFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignKpFromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovHydroWPID
   *
   * @param command AssignMwbaseToGovHydroWPIDCommand
   */
  public void validate(AssignMwbaseToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "AssignMwbaseToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovHydroWPID
   *
   * @param command UnAssignMwbaseFromGovHydroWPIDCommand
   */
  public void validate(UnAssignMwbaseFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignMwbaseFromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Pgv1 validation for a GovHydroWPID
   *
   * @param command AssignPgv1ToGovHydroWPIDCommand
   */
  public void validate(AssignPgv1ToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv1ToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "AssignPgv1ToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv1ToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv1 validation for a GovHydroWPID
   *
   * @param command UnAssignPgv1FromGovHydroWPIDCommand
   */
  public void validate(UnAssignPgv1FromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv1FromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignPgv1FromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Pgv2 validation for a GovHydroWPID
   *
   * @param command AssignPgv2ToGovHydroWPIDCommand
   */
  public void validate(AssignPgv2ToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv2ToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "AssignPgv2ToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv2ToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv2 validation for a GovHydroWPID
   *
   * @param command UnAssignPgv2FromGovHydroWPIDCommand
   */
  public void validate(UnAssignPgv2FromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv2FromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignPgv2FromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Pgv3 validation for a GovHydroWPID
   *
   * @param command AssignPgv3ToGovHydroWPIDCommand
   */
  public void validate(AssignPgv3ToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv3ToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "AssignPgv3ToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv3ToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv3 validation for a GovHydroWPID
   *
   * @param command UnAssignPgv3FromGovHydroWPIDCommand
   */
  public void validate(UnAssignPgv3FromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv3FromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignPgv3FromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Pmax validation for a GovHydroWPID
   *
   * @param command AssignPmaxToGovHydroWPIDCommand
   */
  public void validate(AssignPmaxToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignPmaxToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "AssignPmaxToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Pmax validation for a GovHydroWPID
   *
   * @param command UnAssignPmaxFromGovHydroWPIDCommand
   */
  public void validate(UnAssignPmaxFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignPmaxFromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Pmin validation for a GovHydroWPID
   *
   * @param command AssignPminToGovHydroWPIDCommand
   */
  public void validate(AssignPminToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignPminToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "AssignPminToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPminToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Pmin validation for a GovHydroWPID
   *
   * @param command UnAssignPminFromGovHydroWPIDCommand
   */
  public void validate(UnAssignPminFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPminFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignPminFromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Reg validation for a GovHydroWPID
   *
   * @param command AssignRegToGovHydroWPIDCommand
   */
  public void validate(AssignRegToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignRegToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "AssignRegToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRegToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Reg validation for a GovHydroWPID
   *
   * @param command UnAssignRegFromGovHydroWPIDCommand
   */
  public void validate(UnAssignRegFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRegFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignRegFromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a GovHydroWPID
   *
   * @param command AssignTaToGovHydroWPIDCommand
   */
  public void validate(AssignTaToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignTaToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(), "AssignTaToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a GovHydroWPID
   *
   * @param command UnAssignTaFromGovHydroWPIDCommand
   */
  public void validate(UnAssignTaFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignTaFromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a GovHydroWPID
   *
   * @param command AssignTbToGovHydroWPIDCommand
   */
  public void validate(AssignTbToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignTbToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(), "AssignTbToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a GovHydroWPID
   *
   * @param command UnAssignTbFromGovHydroWPIDCommand
   */
  public void validate(UnAssignTbFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignTbFromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Treg validation for a GovHydroWPID
   *
   * @param command AssignTregToGovHydroWPIDCommand
   */
  public void validate(AssignTregToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignTregToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "AssignTregToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTregToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Treg validation for a GovHydroWPID
   *
   * @param command UnAssignTregFromGovHydroWPIDCommand
   */
  public void validate(UnAssignTregFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTregFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignTregFromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Tw validation for a GovHydroWPID
   *
   * @param command AssignTwToGovHydroWPIDCommand
   */
  public void validate(AssignTwToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignTwToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(), "AssignTwToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTwToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Tw validation for a GovHydroWPID
   *
   * @param command UnAssignTwFromGovHydroWPIDCommand
   */
  public void validate(UnAssignTwFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTwFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignTwFromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Velmax validation for a GovHydroWPID
   *
   * @param command AssignVelmaxToGovHydroWPIDCommand
   */
  public void validate(AssignVelmaxToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignVelmaxToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "AssignVelmaxToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVelmaxToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Velmax validation for a GovHydroWPID
   *
   * @param command UnAssignVelmaxFromGovHydroWPIDCommand
   */
  public void validate(UnAssignVelmaxFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVelmaxFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignVelmaxFromGovHydroWPIDCommand identifier should not be null");
  }
  /**
   * handles assign Velmin validation for a GovHydroWPID
   *
   * @param command AssignVelminToGovHydroWPIDCommand
   */
  public void validate(AssignVelminToGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "AssignVelminToGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "AssignVelminToGovHydroWPIDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVelminToGovHydroWPIDCommand assignment should not be null");
  }

  /**
   * handles unassign Velmin validation for a GovHydroWPID
   *
   * @param command UnAssignVelminFromGovHydroWPIDCommand
   */
  public void validate(UnAssignVelminFromGovHydroWPIDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVelminFromGovHydroWPIDCommand should not be null");
    Assert.notNull(
        command.getGovHydroWPIDId(),
        "UnAssignVelminFromGovHydroWPIDCommand identifier should not be null");
  }
}
