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

public class GovHydroPeltonValidator {

  /** default constructor */
  protected GovHydroPeltonValidator() {}

  /** factory method */
  public static GovHydroPeltonValidator getInstance() {
    return new GovHydroPeltonValidator();
  }

  /** handles creation validation for a GovHydroPelton */
  public void validate(CreateGovHydroPeltonCommand govHydroPelton) throws Exception {
    Assert.notNull(govHydroPelton, "CreateGovHydroPeltonCommand should not be null");
    //		Assert.isNull( govHydroPelton.getGovHydroPeltonId(), "CreateGovHydroPeltonCommand identifier
    // should be null" );
  }

  /** handles update validation for a GovHydroPelton */
  public void validate(UpdateGovHydroPeltonCommand govHydroPelton) throws Exception {
    Assert.notNull(govHydroPelton, "UpdateGovHydroPeltonCommand should not be null");
    Assert.notNull(
        govHydroPelton.getGovHydroPeltonId(),
        "UpdateGovHydroPeltonCommand identifier should not be null");
  }

  /** handles delete validation for a GovHydroPelton */
  public void validate(DeleteGovHydroPeltonCommand govHydroPelton) throws Exception {
    Assert.notNull(govHydroPelton, "{commandAlias} should not be null");
    Assert.notNull(
        govHydroPelton.getGovHydroPeltonId(),
        "DeleteGovHydroPeltonCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GovHydroPelton */
  public void validate(GovHydroPeltonFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovHydroPeltonFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovHydroPeltonId(),
        "GovHydroPeltonFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Av0 validation for a GovHydroPelton
   *
   * @param command AssignAv0ToGovHydroPeltonCommand
   */
  public void validate(AssignAv0ToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignAv0ToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignAv0ToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAv0ToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Av0 validation for a GovHydroPelton
   *
   * @param command UnAssignAv0FromGovHydroPeltonCommand
   */
  public void validate(UnAssignAv0FromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAv0FromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignAv0FromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Av1 validation for a GovHydroPelton
   *
   * @param command AssignAv1ToGovHydroPeltonCommand
   */
  public void validate(AssignAv1ToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignAv1ToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignAv1ToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAv1ToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Av1 validation for a GovHydroPelton
   *
   * @param command UnAssignAv1FromGovHydroPeltonCommand
   */
  public void validate(UnAssignAv1FromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignAv1FromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignAv1FromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Bp validation for a GovHydroPelton
   *
   * @param command AssignBpToGovHydroPeltonCommand
   */
  public void validate(AssignBpToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignBpToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignBpToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBpToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Bp validation for a GovHydroPelton
   *
   * @param command UnAssignBpFromGovHydroPeltonCommand
   */
  public void validate(UnAssignBpFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBpFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignBpFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Db1 validation for a GovHydroPelton
   *
   * @param command AssignDb1ToGovHydroPeltonCommand
   */
  public void validate(AssignDb1ToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignDb1ToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignDb1ToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb1ToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Db1 validation for a GovHydroPelton
   *
   * @param command UnAssignDb1FromGovHydroPeltonCommand
   */
  public void validate(UnAssignDb1FromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDb1FromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignDb1FromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Db2 validation for a GovHydroPelton
   *
   * @param command AssignDb2ToGovHydroPeltonCommand
   */
  public void validate(AssignDb2ToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignDb2ToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignDb2ToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDb2ToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Db2 validation for a GovHydroPelton
   *
   * @param command UnAssignDb2FromGovHydroPeltonCommand
   */
  public void validate(UnAssignDb2FromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDb2FromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignDb2FromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign H1 validation for a GovHydroPelton
   *
   * @param command AssignH1ToGovHydroPeltonCommand
   */
  public void validate(AssignH1ToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignH1ToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignH1ToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignH1ToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign H1 validation for a GovHydroPelton
   *
   * @param command UnAssignH1FromGovHydroPeltonCommand
   */
  public void validate(UnAssignH1FromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignH1FromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignH1FromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign H2 validation for a GovHydroPelton
   *
   * @param command AssignH2ToGovHydroPeltonCommand
   */
  public void validate(AssignH2ToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignH2ToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignH2ToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignH2ToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign H2 validation for a GovHydroPelton
   *
   * @param command UnAssignH2FromGovHydroPeltonCommand
   */
  public void validate(UnAssignH2FromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignH2FromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignH2FromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Hn validation for a GovHydroPelton
   *
   * @param command AssignHnToGovHydroPeltonCommand
   */
  public void validate(AssignHnToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignHnToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignHnToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignHnToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Hn validation for a GovHydroPelton
   *
   * @param command UnAssignHnFromGovHydroPeltonCommand
   */
  public void validate(UnAssignHnFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignHnFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignHnFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a GovHydroPelton
   *
   * @param command AssignKcToGovHydroPeltonCommand
   */
  public void validate(AssignKcToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignKcToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignKcToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a GovHydroPelton
   *
   * @param command UnAssignKcFromGovHydroPeltonCommand
   */
  public void validate(UnAssignKcFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignKcFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Kg validation for a GovHydroPelton
   *
   * @param command AssignKgToGovHydroPeltonCommand
   */
  public void validate(AssignKgToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignKgToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignKgToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKgToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Kg validation for a GovHydroPelton
   *
   * @param command UnAssignKgFromGovHydroPeltonCommand
   */
  public void validate(UnAssignKgFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKgFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignKgFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Qc0 validation for a GovHydroPelton
   *
   * @param command AssignQc0ToGovHydroPeltonCommand
   */
  public void validate(AssignQc0ToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignQc0ToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignQc0ToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQc0ToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Qc0 validation for a GovHydroPelton
   *
   * @param command UnAssignQc0FromGovHydroPeltonCommand
   */
  public void validate(UnAssignQc0FromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQc0FromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignQc0FromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Qn validation for a GovHydroPelton
   *
   * @param command AssignQnToGovHydroPeltonCommand
   */
  public void validate(AssignQnToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignQnToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignQnToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQnToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Qn validation for a GovHydroPelton
   *
   * @param command UnAssignQnFromGovHydroPeltonCommand
   */
  public void validate(UnAssignQnFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignQnFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignQnFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign SimplifiedPelton validation for a GovHydroPelton
   *
   * @param command AssignSimplifiedPeltonToGovHydroPeltonCommand
   */
  public void validate(AssignSimplifiedPeltonToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignSimplifiedPeltonToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignSimplifiedPeltonToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSimplifiedPeltonToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign SimplifiedPelton validation for a GovHydroPelton
   *
   * @param command UnAssignSimplifiedPeltonFromGovHydroPeltonCommand
   */
  public void validate(UnAssignSimplifiedPeltonFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSimplifiedPeltonFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignSimplifiedPeltonFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign StaticCompensating validation for a GovHydroPelton
   *
   * @param command AssignStaticCompensatingToGovHydroPeltonCommand
   */
  public void validate(AssignStaticCompensatingToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignStaticCompensatingToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignStaticCompensatingToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignStaticCompensatingToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign StaticCompensating validation for a GovHydroPelton
   *
   * @param command UnAssignStaticCompensatingFromGovHydroPeltonCommand
   */
  public void validate(UnAssignStaticCompensatingFromGovHydroPeltonCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignStaticCompensatingFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignStaticCompensatingFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Ta validation for a GovHydroPelton
   *
   * @param command AssignTaToGovHydroPeltonCommand
   */
  public void validate(AssignTaToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignTaToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignTaToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a GovHydroPelton
   *
   * @param command UnAssignTaFromGovHydroPeltonCommand
   */
  public void validate(UnAssignTaFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignTaFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Ts validation for a GovHydroPelton
   *
   * @param command AssignTsToGovHydroPeltonCommand
   */
  public void validate(AssignTsToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignTsToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignTsToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTsToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Ts validation for a GovHydroPelton
   *
   * @param command UnAssignTsFromGovHydroPeltonCommand
   */
  public void validate(UnAssignTsFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTsFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignTsFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Tv validation for a GovHydroPelton
   *
   * @param command AssignTvToGovHydroPeltonCommand
   */
  public void validate(AssignTvToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignTvToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignTvToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTvToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Tv validation for a GovHydroPelton
   *
   * @param command UnAssignTvFromGovHydroPeltonCommand
   */
  public void validate(UnAssignTvFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTvFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignTvFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Twnc validation for a GovHydroPelton
   *
   * @param command AssignTwncToGovHydroPeltonCommand
   */
  public void validate(AssignTwncToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignTwncToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignTwncToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTwncToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Twnc validation for a GovHydroPelton
   *
   * @param command UnAssignTwncFromGovHydroPeltonCommand
   */
  public void validate(UnAssignTwncFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTwncFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignTwncFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Twng validation for a GovHydroPelton
   *
   * @param command AssignTwngToGovHydroPeltonCommand
   */
  public void validate(AssignTwngToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignTwngToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignTwngToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTwngToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Twng validation for a GovHydroPelton
   *
   * @param command UnAssignTwngFromGovHydroPeltonCommand
   */
  public void validate(UnAssignTwngFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTwngFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignTwngFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Tx validation for a GovHydroPelton
   *
   * @param command AssignTxToGovHydroPeltonCommand
   */
  public void validate(AssignTxToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignTxToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignTxToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTxToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Tx validation for a GovHydroPelton
   *
   * @param command UnAssignTxFromGovHydroPeltonCommand
   */
  public void validate(UnAssignTxFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTxFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignTxFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Va validation for a GovHydroPelton
   *
   * @param command AssignVaToGovHydroPeltonCommand
   */
  public void validate(AssignVaToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignVaToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignVaToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVaToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Va validation for a GovHydroPelton
   *
   * @param command UnAssignVaFromGovHydroPeltonCommand
   */
  public void validate(UnAssignVaFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVaFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignVaFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Valvmax validation for a GovHydroPelton
   *
   * @param command AssignValvmaxToGovHydroPeltonCommand
   */
  public void validate(AssignValvmaxToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignValvmaxToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignValvmaxToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValvmaxToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Valvmax validation for a GovHydroPelton
   *
   * @param command UnAssignValvmaxFromGovHydroPeltonCommand
   */
  public void validate(UnAssignValvmaxFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValvmaxFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignValvmaxFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Valvmin validation for a GovHydroPelton
   *
   * @param command AssignValvminToGovHydroPeltonCommand
   */
  public void validate(AssignValvminToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignValvminToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignValvminToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValvminToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Valvmin validation for a GovHydroPelton
   *
   * @param command UnAssignValvminFromGovHydroPeltonCommand
   */
  public void validate(UnAssignValvminFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValvminFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignValvminFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Vav validation for a GovHydroPelton
   *
   * @param command AssignVavToGovHydroPeltonCommand
   */
  public void validate(AssignVavToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignVavToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignVavToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVavToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Vav validation for a GovHydroPelton
   *
   * @param command UnAssignVavFromGovHydroPeltonCommand
   */
  public void validate(UnAssignVavFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVavFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignVavFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Vc validation for a GovHydroPelton
   *
   * @param command AssignVcToGovHydroPeltonCommand
   */
  public void validate(AssignVcToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignVcToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignVcToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVcToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Vc validation for a GovHydroPelton
   *
   * @param command UnAssignVcFromGovHydroPeltonCommand
   */
  public void validate(UnAssignVcFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVcFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignVcFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Vcv validation for a GovHydroPelton
   *
   * @param command AssignVcvToGovHydroPeltonCommand
   */
  public void validate(AssignVcvToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignVcvToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignVcvToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVcvToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Vcv validation for a GovHydroPelton
   *
   * @param command UnAssignVcvFromGovHydroPeltonCommand
   */
  public void validate(UnAssignVcvFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVcvFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignVcvFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign WaterTunnelSurgeChamberSimulation validation for a GovHydroPelton
   *
   * @param command AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonCommand
   */
  public void validate(AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign WaterTunnelSurgeChamberSimulation validation for a GovHydroPelton
   *
   * @param command UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonCommand
   */
  public void validate(UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonCommand command)
      throws Exception {
    Assert.notNull(
        command,
        "UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonCommand identifier should not be null");
  }
  /**
   * handles assign Zsfc validation for a GovHydroPelton
   *
   * @param command AssignZsfcToGovHydroPeltonCommand
   */
  public void validate(AssignZsfcToGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "AssignZsfcToGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "AssignZsfcToGovHydroPeltonCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignZsfcToGovHydroPeltonCommand assignment should not be null");
  }

  /**
   * handles unassign Zsfc validation for a GovHydroPelton
   *
   * @param command UnAssignZsfcFromGovHydroPeltonCommand
   */
  public void validate(UnAssignZsfcFromGovHydroPeltonCommand command) throws Exception {
    Assert.notNull(command, "UnAssignZsfcFromGovHydroPeltonCommand should not be null");
    Assert.notNull(
        command.getGovHydroPeltonId(),
        "UnAssignZsfcFromGovHydroPeltonCommand identifier should not be null");
  }
}
