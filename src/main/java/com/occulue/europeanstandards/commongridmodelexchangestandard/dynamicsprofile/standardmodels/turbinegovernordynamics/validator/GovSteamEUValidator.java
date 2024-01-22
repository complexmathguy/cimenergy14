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

public class GovSteamEUValidator {

  /** default constructor */
  protected GovSteamEUValidator() {}

  /** factory method */
  public static GovSteamEUValidator getInstance() {
    return new GovSteamEUValidator();
  }

  /** handles creation validation for a GovSteamEU */
  public void validate(CreateGovSteamEUCommand govSteamEU) throws Exception {
    Assert.notNull(govSteamEU, "CreateGovSteamEUCommand should not be null");
    //		Assert.isNull( govSteamEU.getGovSteamEUId(), "CreateGovSteamEUCommand identifier should be
    // null" );
  }

  /** handles update validation for a GovSteamEU */
  public void validate(UpdateGovSteamEUCommand govSteamEU) throws Exception {
    Assert.notNull(govSteamEU, "UpdateGovSteamEUCommand should not be null");
    Assert.notNull(
        govSteamEU.getGovSteamEUId(), "UpdateGovSteamEUCommand identifier should not be null");
  }

  /** handles delete validation for a GovSteamEU */
  public void validate(DeleteGovSteamEUCommand govSteamEU) throws Exception {
    Assert.notNull(govSteamEU, "{commandAlias} should not be null");
    Assert.notNull(
        govSteamEU.getGovSteamEUId(), "DeleteGovSteamEUCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GovSteamEU */
  public void validate(GovSteamEUFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovSteamEUFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovSteamEUId(), "GovSteamEUFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Chc validation for a GovSteamEU
   *
   * @param command AssignChcToGovSteamEUCommand
   */
  public void validate(AssignChcToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignChcToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignChcToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignChcToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Chc validation for a GovSteamEU
   *
   * @param command UnAssignChcFromGovSteamEUCommand
   */
  public void validate(UnAssignChcFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignChcFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignChcFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Cho validation for a GovSteamEU
   *
   * @param command AssignChoToGovSteamEUCommand
   */
  public void validate(AssignChoToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignChoToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignChoToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignChoToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Cho validation for a GovSteamEU
   *
   * @param command UnAssignChoFromGovSteamEUCommand
   */
  public void validate(UnAssignChoFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignChoFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignChoFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Cic validation for a GovSteamEU
   *
   * @param command AssignCicToGovSteamEUCommand
   */
  public void validate(AssignCicToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignCicToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignCicToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignCicToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Cic validation for a GovSteamEU
   *
   * @param command UnAssignCicFromGovSteamEUCommand
   */
  public void validate(UnAssignCicFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignCicFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignCicFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Cio validation for a GovSteamEU
   *
   * @param command AssignCioToGovSteamEUCommand
   */
  public void validate(AssignCioToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignCioToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignCioToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignCioToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Cio validation for a GovSteamEU
   *
   * @param command UnAssignCioFromGovSteamEUCommand
   */
  public void validate(UnAssignCioFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignCioFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignCioFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Db1 validation for a GovSteamEU
   *
   * @param command AssignDb1ToGovSteamEUCommand
   */
  public void validate(AssignDb1ToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignDb1ToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignDb1ToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb1ToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Db1 validation for a GovSteamEU
   *
   * @param command UnAssignDb1FromGovSteamEUCommand
   */
  public void validate(UnAssignDb1FromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDb1FromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignDb1FromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Db2 validation for a GovSteamEU
   *
   * @param command AssignDb2ToGovSteamEUCommand
   */
  public void validate(AssignDb2ToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignDb2ToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignDb2ToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb2ToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Db2 validation for a GovSteamEU
   *
   * @param command UnAssignDb2FromGovSteamEUCommand
   */
  public void validate(UnAssignDb2FromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDb2FromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignDb2FromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Hhpmax validation for a GovSteamEU
   *
   * @param command AssignHhpmaxToGovSteamEUCommand
   */
  public void validate(AssignHhpmaxToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignHhpmaxToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignHhpmaxToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignHhpmaxToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Hhpmax validation for a GovSteamEU
   *
   * @param command UnAssignHhpmaxFromGovSteamEUCommand
   */
  public void validate(UnAssignHhpmaxFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignHhpmaxFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignHhpmaxFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a GovSteamEU
   *
   * @param command AssignKeToGovSteamEUCommand
   */
  public void validate(AssignKeToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignKeToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignKeToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a GovSteamEU
   *
   * @param command UnAssignKeFromGovSteamEUCommand
   */
  public void validate(UnAssignKeFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "UnAssignKeFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Kfcor validation for a GovSteamEU
   *
   * @param command AssignKfcorToGovSteamEUCommand
   */
  public void validate(AssignKfcorToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignKfcorToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignKfcorToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfcorToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Kfcor validation for a GovSteamEU
   *
   * @param command UnAssignKfcorFromGovSteamEUCommand
   */
  public void validate(UnAssignKfcorFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfcorFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignKfcorFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Khp validation for a GovSteamEU
   *
   * @param command AssignKhpToGovSteamEUCommand
   */
  public void validate(AssignKhpToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignKhpToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignKhpToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKhpToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Khp validation for a GovSteamEU
   *
   * @param command UnAssignKhpFromGovSteamEUCommand
   */
  public void validate(UnAssignKhpFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKhpFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignKhpFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Klp validation for a GovSteamEU
   *
   * @param command AssignKlpToGovSteamEUCommand
   */
  public void validate(AssignKlpToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignKlpToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignKlpToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKlpToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Klp validation for a GovSteamEU
   *
   * @param command UnAssignKlpFromGovSteamEUCommand
   */
  public void validate(UnAssignKlpFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKlpFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignKlpFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Kwcor validation for a GovSteamEU
   *
   * @param command AssignKwcorToGovSteamEUCommand
   */
  public void validate(AssignKwcorToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignKwcorToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignKwcorToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKwcorToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Kwcor validation for a GovSteamEU
   *
   * @param command UnAssignKwcorFromGovSteamEUCommand
   */
  public void validate(UnAssignKwcorFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKwcorFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignKwcorFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovSteamEU
   *
   * @param command AssignMwbaseToGovSteamEUCommand
   */
  public void validate(AssignMwbaseToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignMwbaseToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovSteamEU
   *
   * @param command UnAssignMwbaseFromGovSteamEUCommand
   */
  public void validate(UnAssignMwbaseFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignMwbaseFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Pmax validation for a GovSteamEU
   *
   * @param command AssignPmaxToGovSteamEUCommand
   */
  public void validate(AssignPmaxToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignPmaxToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignPmaxToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Pmax validation for a GovSteamEU
   *
   * @param command UnAssignPmaxFromGovSteamEUCommand
   */
  public void validate(UnAssignPmaxFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignPmaxFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Prhmax validation for a GovSteamEU
   *
   * @param command AssignPrhmaxToGovSteamEUCommand
   */
  public void validate(AssignPrhmaxToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignPrhmaxToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignPrhmaxToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPrhmaxToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Prhmax validation for a GovSteamEU
   *
   * @param command UnAssignPrhmaxFromGovSteamEUCommand
   */
  public void validate(UnAssignPrhmaxFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPrhmaxFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignPrhmaxFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Simx validation for a GovSteamEU
   *
   * @param command AssignSimxToGovSteamEUCommand
   */
  public void validate(AssignSimxToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignSimxToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignSimxToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSimxToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Simx validation for a GovSteamEU
   *
   * @param command UnAssignSimxFromGovSteamEUCommand
   */
  public void validate(UnAssignSimxFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSimxFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignSimxFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a GovSteamEU
   *
   * @param command AssignTbToGovSteamEUCommand
   */
  public void validate(AssignTbToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignTbToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignTbToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a GovSteamEU
   *
   * @param command UnAssignTbFromGovSteamEUCommand
   */
  public void validate(UnAssignTbFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "UnAssignTbFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Tdp validation for a GovSteamEU
   *
   * @param command AssignTdpToGovSteamEUCommand
   */
  public void validate(AssignTdpToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignTdpToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignTdpToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdpToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Tdp validation for a GovSteamEU
   *
   * @param command UnAssignTdpFromGovSteamEUCommand
   */
  public void validate(UnAssignTdpFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdpFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignTdpFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Ten validation for a GovSteamEU
   *
   * @param command AssignTenToGovSteamEUCommand
   */
  public void validate(AssignTenToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignTenToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignTenToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTenToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Ten validation for a GovSteamEU
   *
   * @param command UnAssignTenFromGovSteamEUCommand
   */
  public void validate(UnAssignTenFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTenFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignTenFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Tf validation for a GovSteamEU
   *
   * @param command AssignTfToGovSteamEUCommand
   */
  public void validate(AssignTfToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignTfToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignTfToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a GovSteamEU
   *
   * @param command UnAssignTfFromGovSteamEUCommand
   */
  public void validate(UnAssignTfFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "UnAssignTfFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Tfp validation for a GovSteamEU
   *
   * @param command AssignTfpToGovSteamEUCommand
   */
  public void validate(AssignTfpToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignTfpToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignTfpToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfpToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Tfp validation for a GovSteamEU
   *
   * @param command UnAssignTfpFromGovSteamEUCommand
   */
  public void validate(UnAssignTfpFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTfpFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignTfpFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Thp validation for a GovSteamEU
   *
   * @param command AssignThpToGovSteamEUCommand
   */
  public void validate(AssignThpToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignThpToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignThpToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignThpToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Thp validation for a GovSteamEU
   *
   * @param command UnAssignThpFromGovSteamEUCommand
   */
  public void validate(UnAssignThpFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignThpFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignThpFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Tip validation for a GovSteamEU
   *
   * @param command AssignTipToGovSteamEUCommand
   */
  public void validate(AssignTipToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignTipToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignTipToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTipToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Tip validation for a GovSteamEU
   *
   * @param command UnAssignTipFromGovSteamEUCommand
   */
  public void validate(UnAssignTipFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTipFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignTipFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Tlp validation for a GovSteamEU
   *
   * @param command AssignTlpToGovSteamEUCommand
   */
  public void validate(AssignTlpToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignTlpToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignTlpToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTlpToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Tlp validation for a GovSteamEU
   *
   * @param command UnAssignTlpFromGovSteamEUCommand
   */
  public void validate(UnAssignTlpFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTlpFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignTlpFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Tp validation for a GovSteamEU
   *
   * @param command AssignTpToGovSteamEUCommand
   */
  public void validate(AssignTpToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignTpToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignTpToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Tp validation for a GovSteamEU
   *
   * @param command UnAssignTpFromGovSteamEUCommand
   */
  public void validate(UnAssignTpFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "UnAssignTpFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Trh validation for a GovSteamEU
   *
   * @param command AssignTrhToGovSteamEUCommand
   */
  public void validate(AssignTrhToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignTrhToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignTrhToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTrhToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Trh validation for a GovSteamEU
   *
   * @param command UnAssignTrhFromGovSteamEUCommand
   */
  public void validate(UnAssignTrhFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTrhFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignTrhFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Tvhp validation for a GovSteamEU
   *
   * @param command AssignTvhpToGovSteamEUCommand
   */
  public void validate(AssignTvhpToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignTvhpToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignTvhpToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTvhpToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Tvhp validation for a GovSteamEU
   *
   * @param command UnAssignTvhpFromGovSteamEUCommand
   */
  public void validate(UnAssignTvhpFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTvhpFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignTvhpFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Tvip validation for a GovSteamEU
   *
   * @param command AssignTvipToGovSteamEUCommand
   */
  public void validate(AssignTvipToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignTvipToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignTvipToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTvipToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Tvip validation for a GovSteamEU
   *
   * @param command UnAssignTvipFromGovSteamEUCommand
   */
  public void validate(UnAssignTvipFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTvipFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignTvipFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Tw validation for a GovSteamEU
   *
   * @param command AssignTwToGovSteamEUCommand
   */
  public void validate(AssignTwToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignTwToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignTwToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTwToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Tw validation for a GovSteamEU
   *
   * @param command UnAssignTwFromGovSteamEUCommand
   */
  public void validate(UnAssignTwFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTwFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "UnAssignTwFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Wfmax validation for a GovSteamEU
   *
   * @param command AssignWfmaxToGovSteamEUCommand
   */
  public void validate(AssignWfmaxToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignWfmaxToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignWfmaxToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignWfmaxToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Wfmax validation for a GovSteamEU
   *
   * @param command UnAssignWfmaxFromGovSteamEUCommand
   */
  public void validate(UnAssignWfmaxFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignWfmaxFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignWfmaxFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Wfmin validation for a GovSteamEU
   *
   * @param command AssignWfminToGovSteamEUCommand
   */
  public void validate(AssignWfminToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignWfminToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignWfminToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignWfminToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Wfmin validation for a GovSteamEU
   *
   * @param command UnAssignWfminFromGovSteamEUCommand
   */
  public void validate(UnAssignWfminFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignWfminFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignWfminFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Wmax1 validation for a GovSteamEU
   *
   * @param command AssignWmax1ToGovSteamEUCommand
   */
  public void validate(AssignWmax1ToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignWmax1ToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignWmax1ToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignWmax1ToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Wmax1 validation for a GovSteamEU
   *
   * @param command UnAssignWmax1FromGovSteamEUCommand
   */
  public void validate(UnAssignWmax1FromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignWmax1FromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignWmax1FromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Wmax2 validation for a GovSteamEU
   *
   * @param command AssignWmax2ToGovSteamEUCommand
   */
  public void validate(AssignWmax2ToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignWmax2ToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignWmax2ToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignWmax2ToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Wmax2 validation for a GovSteamEU
   *
   * @param command UnAssignWmax2FromGovSteamEUCommand
   */
  public void validate(UnAssignWmax2FromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignWmax2FromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignWmax2FromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Wwmax validation for a GovSteamEU
   *
   * @param command AssignWwmaxToGovSteamEUCommand
   */
  public void validate(AssignWwmaxToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignWwmaxToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignWwmaxToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignWwmaxToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Wwmax validation for a GovSteamEU
   *
   * @param command UnAssignWwmaxFromGovSteamEUCommand
   */
  public void validate(UnAssignWwmaxFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignWwmaxFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignWwmaxFromGovSteamEUCommand identifier should not be null");
  }
  /**
   * handles assign Wwmin validation for a GovSteamEU
   *
   * @param command AssignWwminToGovSteamEUCommand
   */
  public void validate(AssignWwminToGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "AssignWwminToGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(), "AssignWwminToGovSteamEUCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignWwminToGovSteamEUCommand assignment should not be null");
  }

  /**
   * handles unassign Wwmin validation for a GovSteamEU
   *
   * @param command UnAssignWwminFromGovSteamEUCommand
   */
  public void validate(UnAssignWwminFromGovSteamEUCommand command) throws Exception {
    Assert.notNull(command, "UnAssignWwminFromGovSteamEUCommand should not be null");
    Assert.notNull(
        command.getGovSteamEUId(),
        "UnAssignWwminFromGovSteamEUCommand identifier should not be null");
  }
}
