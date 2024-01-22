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

public class GovHydroFrancisValidator {

  /** default constructor */
  protected GovHydroFrancisValidator() {}

  /** factory method */
  public static GovHydroFrancisValidator getInstance() {
    return new GovHydroFrancisValidator();
  }

  /** handles creation validation for a GovHydroFrancis */
  public void validate(CreateGovHydroFrancisCommand govHydroFrancis) throws Exception {
    Assert.notNull(govHydroFrancis, "CreateGovHydroFrancisCommand should not be null");
    //		Assert.isNull( govHydroFrancis.getGovHydroFrancisId(), "CreateGovHydroFrancisCommand
    // identifier should be null" );
  }

  /** handles update validation for a GovHydroFrancis */
  public void validate(UpdateGovHydroFrancisCommand govHydroFrancis) throws Exception {
    Assert.notNull(govHydroFrancis, "UpdateGovHydroFrancisCommand should not be null");
    Assert.notNull(
        govHydroFrancis.getGovHydroFrancisId(),
        "UpdateGovHydroFrancisCommand identifier should not be null");
  }

  /** handles delete validation for a GovHydroFrancis */
  public void validate(DeleteGovHydroFrancisCommand govHydroFrancis) throws Exception {
    Assert.notNull(govHydroFrancis, "{commandAlias} should not be null");
    Assert.notNull(
        govHydroFrancis.getGovHydroFrancisId(),
        "DeleteGovHydroFrancisCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GovHydroFrancis */
  public void validate(GovHydroFrancisFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovHydroFrancisFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovHydroFrancisId(),
        "GovHydroFrancisFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Am validation for a GovHydroFrancis
   *
   * @param command AssignAmToGovHydroFrancisCommand
   */
  public void validate(AssignAmToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignAmToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignAmToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAmToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Am validation for a GovHydroFrancis
   *
   * @param command UnAssignAmFromGovHydroFrancisCommand
   */
  public void validate(UnAssignAmFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAmFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignAmFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Av0 validation for a GovHydroFrancis
   *
   * @param command AssignAv0ToGovHydroFrancisCommand
   */
  public void validate(AssignAv0ToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignAv0ToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignAv0ToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAv0ToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Av0 validation for a GovHydroFrancis
   *
   * @param command UnAssignAv0FromGovHydroFrancisCommand
   */
  public void validate(UnAssignAv0FromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAv0FromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignAv0FromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Av1 validation for a GovHydroFrancis
   *
   * @param command AssignAv1ToGovHydroFrancisCommand
   */
  public void validate(AssignAv1ToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignAv1ToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignAv1ToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAv1ToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Av1 validation for a GovHydroFrancis
   *
   * @param command UnAssignAv1FromGovHydroFrancisCommand
   */
  public void validate(UnAssignAv1FromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAv1FromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignAv1FromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Bp validation for a GovHydroFrancis
   *
   * @param command AssignBpToGovHydroFrancisCommand
   */
  public void validate(AssignBpToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignBpToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignBpToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBpToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Bp validation for a GovHydroFrancis
   *
   * @param command UnAssignBpFromGovHydroFrancisCommand
   */
  public void validate(UnAssignBpFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBpFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignBpFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Db1 validation for a GovHydroFrancis
   *
   * @param command AssignDb1ToGovHydroFrancisCommand
   */
  public void validate(AssignDb1ToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignDb1ToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignDb1ToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb1ToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Db1 validation for a GovHydroFrancis
   *
   * @param command UnAssignDb1FromGovHydroFrancisCommand
   */
  public void validate(UnAssignDb1FromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDb1FromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignDb1FromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Etamax validation for a GovHydroFrancis
   *
   * @param command AssignEtamaxToGovHydroFrancisCommand
   */
  public void validate(AssignEtamaxToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignEtamaxToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignEtamaxToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEtamaxToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Etamax validation for a GovHydroFrancis
   *
   * @param command UnAssignEtamaxFromGovHydroFrancisCommand
   */
  public void validate(UnAssignEtamaxFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEtamaxFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignEtamaxFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign H1 validation for a GovHydroFrancis
   *
   * @param command AssignH1ToGovHydroFrancisCommand
   */
  public void validate(AssignH1ToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignH1ToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignH1ToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignH1ToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign H1 validation for a GovHydroFrancis
   *
   * @param command UnAssignH1FromGovHydroFrancisCommand
   */
  public void validate(UnAssignH1FromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignH1FromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignH1FromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign H2 validation for a GovHydroFrancis
   *
   * @param command AssignH2ToGovHydroFrancisCommand
   */
  public void validate(AssignH2ToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignH2ToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignH2ToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignH2ToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign H2 validation for a GovHydroFrancis
   *
   * @param command UnAssignH2FromGovHydroFrancisCommand
   */
  public void validate(UnAssignH2FromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignH2FromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignH2FromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Hn validation for a GovHydroFrancis
   *
   * @param command AssignHnToGovHydroFrancisCommand
   */
  public void validate(AssignHnToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignHnToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignHnToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignHnToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Hn validation for a GovHydroFrancis
   *
   * @param command UnAssignHnFromGovHydroFrancisCommand
   */
  public void validate(UnAssignHnFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignHnFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignHnFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a GovHydroFrancis
   *
   * @param command AssignKcToGovHydroFrancisCommand
   */
  public void validate(AssignKcToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignKcToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignKcToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a GovHydroFrancis
   *
   * @param command UnAssignKcFromGovHydroFrancisCommand
   */
  public void validate(UnAssignKcFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignKcFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Kg validation for a GovHydroFrancis
   *
   * @param command AssignKgToGovHydroFrancisCommand
   */
  public void validate(AssignKgToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignKgToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignKgToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKgToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Kg validation for a GovHydroFrancis
   *
   * @param command UnAssignKgFromGovHydroFrancisCommand
   */
  public void validate(UnAssignKgFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKgFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignKgFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Kt validation for a GovHydroFrancis
   *
   * @param command AssignKtToGovHydroFrancisCommand
   */
  public void validate(AssignKtToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignKtToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignKtToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKtToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Kt validation for a GovHydroFrancis
   *
   * @param command UnAssignKtFromGovHydroFrancisCommand
   */
  public void validate(UnAssignKtFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKtFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignKtFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Qc0 validation for a GovHydroFrancis
   *
   * @param command AssignQc0ToGovHydroFrancisCommand
   */
  public void validate(AssignQc0ToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignQc0ToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignQc0ToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQc0ToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Qc0 validation for a GovHydroFrancis
   *
   * @param command UnAssignQc0FromGovHydroFrancisCommand
   */
  public void validate(UnAssignQc0FromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQc0FromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignQc0FromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Qn validation for a GovHydroFrancis
   *
   * @param command AssignQnToGovHydroFrancisCommand
   */
  public void validate(AssignQnToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignQnToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignQnToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQnToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Qn validation for a GovHydroFrancis
   *
   * @param command UnAssignQnFromGovHydroFrancisCommand
   */
  public void validate(UnAssignQnFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQnFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignQnFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a GovHydroFrancis
   *
   * @param command AssignTaToGovHydroFrancisCommand
   */
  public void validate(AssignTaToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignTaToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignTaToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a GovHydroFrancis
   *
   * @param command UnAssignTaFromGovHydroFrancisCommand
   */
  public void validate(UnAssignTaFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignTaFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Td validation for a GovHydroFrancis
   *
   * @param command AssignTdToGovHydroFrancisCommand
   */
  public void validate(AssignTdToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignTdToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignTdToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Td validation for a GovHydroFrancis
   *
   * @param command UnAssignTdFromGovHydroFrancisCommand
   */
  public void validate(UnAssignTdFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignTdFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Ts validation for a GovHydroFrancis
   *
   * @param command AssignTsToGovHydroFrancisCommand
   */
  public void validate(AssignTsToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignTsToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignTsToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTsToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Ts validation for a GovHydroFrancis
   *
   * @param command UnAssignTsFromGovHydroFrancisCommand
   */
  public void validate(UnAssignTsFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTsFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignTsFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Twnc validation for a GovHydroFrancis
   *
   * @param command AssignTwncToGovHydroFrancisCommand
   */
  public void validate(AssignTwncToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignTwncToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignTwncToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTwncToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Twnc validation for a GovHydroFrancis
   *
   * @param command UnAssignTwncFromGovHydroFrancisCommand
   */
  public void validate(UnAssignTwncFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTwncFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignTwncFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Twng validation for a GovHydroFrancis
   *
   * @param command AssignTwngToGovHydroFrancisCommand
   */
  public void validate(AssignTwngToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignTwngToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignTwngToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTwngToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Twng validation for a GovHydroFrancis
   *
   * @param command UnAssignTwngFromGovHydroFrancisCommand
   */
  public void validate(UnAssignTwngFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTwngFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignTwngFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Tx validation for a GovHydroFrancis
   *
   * @param command AssignTxToGovHydroFrancisCommand
   */
  public void validate(AssignTxToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignTxToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignTxToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTxToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Tx validation for a GovHydroFrancis
   *
   * @param command UnAssignTxFromGovHydroFrancisCommand
   */
  public void validate(UnAssignTxFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTxFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignTxFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Va validation for a GovHydroFrancis
   *
   * @param command AssignVaToGovHydroFrancisCommand
   */
  public void validate(AssignVaToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignVaToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignVaToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVaToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Va validation for a GovHydroFrancis
   *
   * @param command UnAssignVaFromGovHydroFrancisCommand
   */
  public void validate(UnAssignVaFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVaFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignVaFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Valvmax validation for a GovHydroFrancis
   *
   * @param command AssignValvmaxToGovHydroFrancisCommand
   */
  public void validate(AssignValvmaxToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignValvmaxToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignValvmaxToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValvmaxToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Valvmax validation for a GovHydroFrancis
   *
   * @param command UnAssignValvmaxFromGovHydroFrancisCommand
   */
  public void validate(UnAssignValvmaxFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValvmaxFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignValvmaxFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Valvmin validation for a GovHydroFrancis
   *
   * @param command AssignValvminToGovHydroFrancisCommand
   */
  public void validate(AssignValvminToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignValvminToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignValvminToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValvminToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Valvmin validation for a GovHydroFrancis
   *
   * @param command UnAssignValvminFromGovHydroFrancisCommand
   */
  public void validate(UnAssignValvminFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValvminFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignValvminFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Vc validation for a GovHydroFrancis
   *
   * @param command AssignVcToGovHydroFrancisCommand
   */
  public void validate(AssignVcToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignVcToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignVcToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVcToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Vc validation for a GovHydroFrancis
   *
   * @param command UnAssignVcFromGovHydroFrancisCommand
   */
  public void validate(UnAssignVcFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVcFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignVcFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign WaterTunnelSurgeChamberSimulation validation for a GovHydroFrancis
   *
   * @param command AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisCommand
   */
  public void validate(AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign WaterTunnelSurgeChamberSimulation validation for a GovHydroFrancis
   *
   * @param command UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisCommand
   */
  public void validate(UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisCommand identifier should not be null");
  }
  /**
   * handles assign Zsfc validation for a GovHydroFrancis
   *
   * @param command AssignZsfcToGovHydroFrancisCommand
   */
  public void validate(AssignZsfcToGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "AssignZsfcToGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "AssignZsfcToGovHydroFrancisCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignZsfcToGovHydroFrancisCommand assignment should not be null");
  }

  /**
   * handles unassign Zsfc validation for a GovHydroFrancis
   *
   * @param command UnAssignZsfcFromGovHydroFrancisCommand
   */
  public void validate(UnAssignZsfcFromGovHydroFrancisCommand command) throws Exception {
    Assert.notNull(command, "UnAssignZsfcFromGovHydroFrancisCommand should not be null");
    Assert.notNull(
        command.getGovHydroFrancisId(),
        "UnAssignZsfcFromGovHydroFrancisCommand identifier should not be null");
  }
}
