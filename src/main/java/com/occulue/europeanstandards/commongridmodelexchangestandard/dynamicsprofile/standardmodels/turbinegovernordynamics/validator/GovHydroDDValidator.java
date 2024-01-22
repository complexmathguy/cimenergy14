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

public class GovHydroDDValidator {

  /** default constructor */
  protected GovHydroDDValidator() {}

  /** factory method */
  public static GovHydroDDValidator getInstance() {
    return new GovHydroDDValidator();
  }

  /** handles creation validation for a GovHydroDD */
  public void validate(CreateGovHydroDDCommand govHydroDD) throws Exception {
    Assert.notNull(govHydroDD, "CreateGovHydroDDCommand should not be null");
    //		Assert.isNull( govHydroDD.getGovHydroDDId(), "CreateGovHydroDDCommand identifier should be
    // null" );
  }

  /** handles update validation for a GovHydroDD */
  public void validate(UpdateGovHydroDDCommand govHydroDD) throws Exception {
    Assert.notNull(govHydroDD, "UpdateGovHydroDDCommand should not be null");
    Assert.notNull(
        govHydroDD.getGovHydroDDId(), "UpdateGovHydroDDCommand identifier should not be null");
  }

  /** handles delete validation for a GovHydroDD */
  public void validate(DeleteGovHydroDDCommand govHydroDD) throws Exception {
    Assert.notNull(govHydroDD, "{commandAlias} should not be null");
    Assert.notNull(
        govHydroDD.getGovHydroDDId(), "DeleteGovHydroDDCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GovHydroDD */
  public void validate(GovHydroDDFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovHydroDDFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovHydroDDId(), "GovHydroDDFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Aturb validation for a GovHydroDD
   *
   * @param command AssignAturbToGovHydroDDCommand
   */
  public void validate(AssignAturbToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignAturbToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignAturbToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAturbToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Aturb validation for a GovHydroDD
   *
   * @param command UnAssignAturbFromGovHydroDDCommand
   */
  public void validate(UnAssignAturbFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAturbFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignAturbFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Bturb validation for a GovHydroDD
   *
   * @param command AssignBturbToGovHydroDDCommand
   */
  public void validate(AssignBturbToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignBturbToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignBturbToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBturbToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Bturb validation for a GovHydroDD
   *
   * @param command UnAssignBturbFromGovHydroDDCommand
   */
  public void validate(UnAssignBturbFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBturbFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignBturbFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Db1 validation for a GovHydroDD
   *
   * @param command AssignDb1ToGovHydroDDCommand
   */
  public void validate(AssignDb1ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignDb1ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignDb1ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb1ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Db1 validation for a GovHydroDD
   *
   * @param command UnAssignDb1FromGovHydroDDCommand
   */
  public void validate(UnAssignDb1FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDb1FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignDb1FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Db2 validation for a GovHydroDD
   *
   * @param command AssignDb2ToGovHydroDDCommand
   */
  public void validate(AssignDb2ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignDb2ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignDb2ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb2ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Db2 validation for a GovHydroDD
   *
   * @param command UnAssignDb2FromGovHydroDDCommand
   */
  public void validate(UnAssignDb2FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDb2FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignDb2FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Eps validation for a GovHydroDD
   *
   * @param command AssignEpsToGovHydroDDCommand
   */
  public void validate(AssignEpsToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignEpsToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignEpsToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEpsToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Eps validation for a GovHydroDD
   *
   * @param command UnAssignEpsFromGovHydroDDCommand
   */
  public void validate(UnAssignEpsFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEpsFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignEpsFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Gmax validation for a GovHydroDD
   *
   * @param command AssignGmaxToGovHydroDDCommand
   */
  public void validate(AssignGmaxToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignGmaxToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignGmaxToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGmaxToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Gmax validation for a GovHydroDD
   *
   * @param command UnAssignGmaxFromGovHydroDDCommand
   */
  public void validate(UnAssignGmaxFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGmaxFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignGmaxFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Gmin validation for a GovHydroDD
   *
   * @param command AssignGminToGovHydroDDCommand
   */
  public void validate(AssignGminToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignGminToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignGminToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGminToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Gmin validation for a GovHydroDD
   *
   * @param command UnAssignGminFromGovHydroDDCommand
   */
  public void validate(UnAssignGminFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGminFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignGminFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Gv1 validation for a GovHydroDD
   *
   * @param command AssignGv1ToGovHydroDDCommand
   */
  public void validate(AssignGv1ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignGv1ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignGv1ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv1ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Gv1 validation for a GovHydroDD
   *
   * @param command UnAssignGv1FromGovHydroDDCommand
   */
  public void validate(UnAssignGv1FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv1FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignGv1FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Gv2 validation for a GovHydroDD
   *
   * @param command AssignGv2ToGovHydroDDCommand
   */
  public void validate(AssignGv2ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignGv2ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignGv2ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv2ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Gv2 validation for a GovHydroDD
   *
   * @param command UnAssignGv2FromGovHydroDDCommand
   */
  public void validate(UnAssignGv2FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv2FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignGv2FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Gv3 validation for a GovHydroDD
   *
   * @param command AssignGv3ToGovHydroDDCommand
   */
  public void validate(AssignGv3ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignGv3ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignGv3ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv3ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Gv3 validation for a GovHydroDD
   *
   * @param command UnAssignGv3FromGovHydroDDCommand
   */
  public void validate(UnAssignGv3FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv3FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignGv3FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Gv4 validation for a GovHydroDD
   *
   * @param command AssignGv4ToGovHydroDDCommand
   */
  public void validate(AssignGv4ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignGv4ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignGv4ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv4ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Gv4 validation for a GovHydroDD
   *
   * @param command UnAssignGv4FromGovHydroDDCommand
   */
  public void validate(UnAssignGv4FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv4FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignGv4FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Gv5 validation for a GovHydroDD
   *
   * @param command AssignGv5ToGovHydroDDCommand
   */
  public void validate(AssignGv5ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignGv5ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignGv5ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv5ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Gv5 validation for a GovHydroDD
   *
   * @param command UnAssignGv5FromGovHydroDDCommand
   */
  public void validate(UnAssignGv5FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv5FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignGv5FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Gv6 validation for a GovHydroDD
   *
   * @param command AssignGv6ToGovHydroDDCommand
   */
  public void validate(AssignGv6ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignGv6ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignGv6ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv6ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Gv6 validation for a GovHydroDD
   *
   * @param command UnAssignGv6FromGovHydroDDCommand
   */
  public void validate(UnAssignGv6FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv6FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignGv6FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign InputSignal validation for a GovHydroDD
   *
   * @param command AssignInputSignalToGovHydroDDCommand
   */
  public void validate(AssignInputSignalToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignInputSignalToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "AssignInputSignalToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignInputSignalToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign InputSignal validation for a GovHydroDD
   *
   * @param command UnAssignInputSignalFromGovHydroDDCommand
   */
  public void validate(UnAssignInputSignalFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignInputSignalFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignInputSignalFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign K1 validation for a GovHydroDD
   *
   * @param command AssignK1ToGovHydroDDCommand
   */
  public void validate(AssignK1ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignK1ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignK1ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK1ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign K1 validation for a GovHydroDD
   *
   * @param command UnAssignK1FromGovHydroDDCommand
   */
  public void validate(UnAssignK1FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK1FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "UnAssignK1FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign K2 validation for a GovHydroDD
   *
   * @param command AssignK2ToGovHydroDDCommand
   */
  public void validate(AssignK2ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignK2ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignK2ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK2ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign K2 validation for a GovHydroDD
   *
   * @param command UnAssignK2FromGovHydroDDCommand
   */
  public void validate(UnAssignK2FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK2FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "UnAssignK2FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Kg validation for a GovHydroDD
   *
   * @param command AssignKgToGovHydroDDCommand
   */
  public void validate(AssignKgToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignKgToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignKgToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKgToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Kg validation for a GovHydroDD
   *
   * @param command UnAssignKgFromGovHydroDDCommand
   */
  public void validate(UnAssignKgFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKgFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "UnAssignKgFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a GovHydroDD
   *
   * @param command AssignKiToGovHydroDDCommand
   */
  public void validate(AssignKiToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignKiToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignKiToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a GovHydroDD
   *
   * @param command UnAssignKiFromGovHydroDDCommand
   */
  public void validate(UnAssignKiFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "UnAssignKiFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovHydroDD
   *
   * @param command AssignMwbaseToGovHydroDDCommand
   */
  public void validate(AssignMwbaseToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignMwbaseToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovHydroDD
   *
   * @param command UnAssignMwbaseFromGovHydroDDCommand
   */
  public void validate(UnAssignMwbaseFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignMwbaseFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Pgv1 validation for a GovHydroDD
   *
   * @param command AssignPgv1ToGovHydroDDCommand
   */
  public void validate(AssignPgv1ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv1ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignPgv1ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv1ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv1 validation for a GovHydroDD
   *
   * @param command UnAssignPgv1FromGovHydroDDCommand
   */
  public void validate(UnAssignPgv1FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv1FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignPgv1FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Pgv2 validation for a GovHydroDD
   *
   * @param command AssignPgv2ToGovHydroDDCommand
   */
  public void validate(AssignPgv2ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv2ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignPgv2ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv2ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv2 validation for a GovHydroDD
   *
   * @param command UnAssignPgv2FromGovHydroDDCommand
   */
  public void validate(UnAssignPgv2FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv2FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignPgv2FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Pgv3 validation for a GovHydroDD
   *
   * @param command AssignPgv3ToGovHydroDDCommand
   */
  public void validate(AssignPgv3ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv3ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignPgv3ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv3ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv3 validation for a GovHydroDD
   *
   * @param command UnAssignPgv3FromGovHydroDDCommand
   */
  public void validate(UnAssignPgv3FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv3FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignPgv3FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Pgv4 validation for a GovHydroDD
   *
   * @param command AssignPgv4ToGovHydroDDCommand
   */
  public void validate(AssignPgv4ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv4ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignPgv4ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv4ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv4 validation for a GovHydroDD
   *
   * @param command UnAssignPgv4FromGovHydroDDCommand
   */
  public void validate(UnAssignPgv4FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv4FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignPgv4FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Pgv5 validation for a GovHydroDD
   *
   * @param command AssignPgv5ToGovHydroDDCommand
   */
  public void validate(AssignPgv5ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv5ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignPgv5ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv5ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv5 validation for a GovHydroDD
   *
   * @param command UnAssignPgv5FromGovHydroDDCommand
   */
  public void validate(UnAssignPgv5FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv5FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignPgv5FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Pgv6 validation for a GovHydroDD
   *
   * @param command AssignPgv6ToGovHydroDDCommand
   */
  public void validate(AssignPgv6ToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignPgv6ToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignPgv6ToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPgv6ToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Pgv6 validation for a GovHydroDD
   *
   * @param command UnAssignPgv6FromGovHydroDDCommand
   */
  public void validate(UnAssignPgv6FromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPgv6FromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignPgv6FromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Pmax validation for a GovHydroDD
   *
   * @param command AssignPmaxToGovHydroDDCommand
   */
  public void validate(AssignPmaxToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignPmaxToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignPmaxToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Pmax validation for a GovHydroDD
   *
   * @param command UnAssignPmaxFromGovHydroDDCommand
   */
  public void validate(UnAssignPmaxFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignPmaxFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Pmin validation for a GovHydroDD
   *
   * @param command AssignPminToGovHydroDDCommand
   */
  public void validate(AssignPminToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignPminToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignPminToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPminToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Pmin validation for a GovHydroDD
   *
   * @param command UnAssignPminFromGovHydroDDCommand
   */
  public void validate(UnAssignPminFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPminFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignPminFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign R validation for a GovHydroDD
   *
   * @param command AssignRToGovHydroDDCommand
   */
  public void validate(AssignRToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignRToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignRToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign R validation for a GovHydroDD
   *
   * @param command UnAssignRFromGovHydroDDCommand
   */
  public void validate(UnAssignRFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "UnAssignRFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Td validation for a GovHydroDD
   *
   * @param command AssignTdToGovHydroDDCommand
   */
  public void validate(AssignTdToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignTdToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignTdToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Td validation for a GovHydroDD
   *
   * @param command UnAssignTdFromGovHydroDDCommand
   */
  public void validate(UnAssignTdFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "UnAssignTdFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a GovHydroDD
   *
   * @param command AssignTfToGovHydroDDCommand
   */
  public void validate(AssignTfToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignTfToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignTfToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a GovHydroDD
   *
   * @param command UnAssignTfFromGovHydroDDCommand
   */
  public void validate(UnAssignTfFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "UnAssignTfFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Tp validation for a GovHydroDD
   *
   * @param command AssignTpToGovHydroDDCommand
   */
  public void validate(AssignTpToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignTpToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignTpToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Tp validation for a GovHydroDD
   *
   * @param command UnAssignTpFromGovHydroDDCommand
   */
  public void validate(UnAssignTpFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "UnAssignTpFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Tt validation for a GovHydroDD
   *
   * @param command AssignTtToGovHydroDDCommand
   */
  public void validate(AssignTtToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignTtToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignTtToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTtToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Tt validation for a GovHydroDD
   *
   * @param command UnAssignTtFromGovHydroDDCommand
   */
  public void validate(UnAssignTtFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTtFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "UnAssignTtFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Tturb validation for a GovHydroDD
   *
   * @param command AssignTturbToGovHydroDDCommand
   */
  public void validate(AssignTturbToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignTturbToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignTturbToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTturbToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Tturb validation for a GovHydroDD
   *
   * @param command UnAssignTturbFromGovHydroDDCommand
   */
  public void validate(UnAssignTturbFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTturbFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignTturbFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Velcl validation for a GovHydroDD
   *
   * @param command AssignVelclToGovHydroDDCommand
   */
  public void validate(AssignVelclToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignVelclToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignVelclToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVelclToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Velcl validation for a GovHydroDD
   *
   * @param command UnAssignVelclFromGovHydroDDCommand
   */
  public void validate(UnAssignVelclFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVelclFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignVelclFromGovHydroDDCommand identifier should not be null");
  }
  /**
   * handles assign Velop validation for a GovHydroDD
   *
   * @param command AssignVelopToGovHydroDDCommand
   */
  public void validate(AssignVelopToGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "AssignVelopToGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(), "AssignVelopToGovHydroDDCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVelopToGovHydroDDCommand assignment should not be null");
  }

  /**
   * handles unassign Velop validation for a GovHydroDD
   *
   * @param command UnAssignVelopFromGovHydroDDCommand
   */
  public void validate(UnAssignVelopFromGovHydroDDCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVelopFromGovHydroDDCommand should not be null");
    Assert.notNull(
        command.getGovHydroDDId(),
        "UnAssignVelopFromGovHydroDDCommand identifier should not be null");
  }
}
