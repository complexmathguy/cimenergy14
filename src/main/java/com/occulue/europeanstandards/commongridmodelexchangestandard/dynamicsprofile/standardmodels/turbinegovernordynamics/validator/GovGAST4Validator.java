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

public class GovGAST4Validator {

  /** default constructor */
  protected GovGAST4Validator() {}

  /** factory method */
  public static GovGAST4Validator getInstance() {
    return new GovGAST4Validator();
  }

  /** handles creation validation for a GovGAST4 */
  public void validate(CreateGovGAST4Command govGAST4) throws Exception {
    Assert.notNull(govGAST4, "CreateGovGAST4Command should not be null");
    //		Assert.isNull( govGAST4.getGovGAST4Id(), "CreateGovGAST4Command identifier should be null"
    // );
  }

  /** handles update validation for a GovGAST4 */
  public void validate(UpdateGovGAST4Command govGAST4) throws Exception {
    Assert.notNull(govGAST4, "UpdateGovGAST4Command should not be null");
    Assert.notNull(govGAST4.getGovGAST4Id(), "UpdateGovGAST4Command identifier should not be null");
  }

  /** handles delete validation for a GovGAST4 */
  public void validate(DeleteGovGAST4Command govGAST4) throws Exception {
    Assert.notNull(govGAST4, "{commandAlias} should not be null");
    Assert.notNull(govGAST4.getGovGAST4Id(), "DeleteGovGAST4Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovGAST4 */
  public void validate(GovGAST4FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovGAST4FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovGAST4Id(), "GovGAST4FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Bp validation for a GovGAST4
   *
   * @param command AssignBpToGovGAST4Command
   */
  public void validate(AssignBpToGovGAST4Command command) throws Exception {
    Assert.notNull(command, "AssignBpToGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "AssignBpToGovGAST4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBpToGovGAST4Command assignment should not be null");
  }

  /**
   * handles unassign Bp validation for a GovGAST4
   *
   * @param command UnAssignBpFromGovGAST4Command
   */
  public void validate(UnAssignBpFromGovGAST4Command command) throws Exception {
    Assert.notNull(command, "UnAssignBpFromGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "UnAssignBpFromGovGAST4Command identifier should not be null");
  }
  /**
   * handles assign Ktm validation for a GovGAST4
   *
   * @param command AssignKtmToGovGAST4Command
   */
  public void validate(AssignKtmToGovGAST4Command command) throws Exception {
    Assert.notNull(command, "AssignKtmToGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "AssignKtmToGovGAST4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKtmToGovGAST4Command assignment should not be null");
  }

  /**
   * handles unassign Ktm validation for a GovGAST4
   *
   * @param command UnAssignKtmFromGovGAST4Command
   */
  public void validate(UnAssignKtmFromGovGAST4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKtmFromGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "UnAssignKtmFromGovGAST4Command identifier should not be null");
  }
  /**
   * handles assign Mnef validation for a GovGAST4
   *
   * @param command AssignMnefToGovGAST4Command
   */
  public void validate(AssignMnefToGovGAST4Command command) throws Exception {
    Assert.notNull(command, "AssignMnefToGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "AssignMnefToGovGAST4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMnefToGovGAST4Command assignment should not be null");
  }

  /**
   * handles unassign Mnef validation for a GovGAST4
   *
   * @param command UnAssignMnefFromGovGAST4Command
   */
  public void validate(UnAssignMnefFromGovGAST4Command command) throws Exception {
    Assert.notNull(command, "UnAssignMnefFromGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "UnAssignMnefFromGovGAST4Command identifier should not be null");
  }
  /**
   * handles assign Mxef validation for a GovGAST4
   *
   * @param command AssignMxefToGovGAST4Command
   */
  public void validate(AssignMxefToGovGAST4Command command) throws Exception {
    Assert.notNull(command, "AssignMxefToGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "AssignMxefToGovGAST4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMxefToGovGAST4Command assignment should not be null");
  }

  /**
   * handles unassign Mxef validation for a GovGAST4
   *
   * @param command UnAssignMxefFromGovGAST4Command
   */
  public void validate(UnAssignMxefFromGovGAST4Command command) throws Exception {
    Assert.notNull(command, "UnAssignMxefFromGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "UnAssignMxefFromGovGAST4Command identifier should not be null");
  }
  /**
   * handles assign Rymn validation for a GovGAST4
   *
   * @param command AssignRymnToGovGAST4Command
   */
  public void validate(AssignRymnToGovGAST4Command command) throws Exception {
    Assert.notNull(command, "AssignRymnToGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "AssignRymnToGovGAST4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRymnToGovGAST4Command assignment should not be null");
  }

  /**
   * handles unassign Rymn validation for a GovGAST4
   *
   * @param command UnAssignRymnFromGovGAST4Command
   */
  public void validate(UnAssignRymnFromGovGAST4Command command) throws Exception {
    Assert.notNull(command, "UnAssignRymnFromGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "UnAssignRymnFromGovGAST4Command identifier should not be null");
  }
  /**
   * handles assign Rymx validation for a GovGAST4
   *
   * @param command AssignRymxToGovGAST4Command
   */
  public void validate(AssignRymxToGovGAST4Command command) throws Exception {
    Assert.notNull(command, "AssignRymxToGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "AssignRymxToGovGAST4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRymxToGovGAST4Command assignment should not be null");
  }

  /**
   * handles unassign Rymx validation for a GovGAST4
   *
   * @param command UnAssignRymxFromGovGAST4Command
   */
  public void validate(UnAssignRymxFromGovGAST4Command command) throws Exception {
    Assert.notNull(command, "UnAssignRymxFromGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "UnAssignRymxFromGovGAST4Command identifier should not be null");
  }
  /**
   * handles assign Ta validation for a GovGAST4
   *
   * @param command AssignTaToGovGAST4Command
   */
  public void validate(AssignTaToGovGAST4Command command) throws Exception {
    Assert.notNull(command, "AssignTaToGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "AssignTaToGovGAST4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToGovGAST4Command assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a GovGAST4
   *
   * @param command UnAssignTaFromGovGAST4Command
   */
  public void validate(UnAssignTaFromGovGAST4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "UnAssignTaFromGovGAST4Command identifier should not be null");
  }
  /**
   * handles assign Tc validation for a GovGAST4
   *
   * @param command AssignTcToGovGAST4Command
   */
  public void validate(AssignTcToGovGAST4Command command) throws Exception {
    Assert.notNull(command, "AssignTcToGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "AssignTcToGovGAST4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToGovGAST4Command assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a GovGAST4
   *
   * @param command UnAssignTcFromGovGAST4Command
   */
  public void validate(UnAssignTcFromGovGAST4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "UnAssignTcFromGovGAST4Command identifier should not be null");
  }
  /**
   * handles assign Tcm validation for a GovGAST4
   *
   * @param command AssignTcmToGovGAST4Command
   */
  public void validate(AssignTcmToGovGAST4Command command) throws Exception {
    Assert.notNull(command, "AssignTcmToGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "AssignTcmToGovGAST4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcmToGovGAST4Command assignment should not be null");
  }

  /**
   * handles unassign Tcm validation for a GovGAST4
   *
   * @param command UnAssignTcmFromGovGAST4Command
   */
  public void validate(UnAssignTcmFromGovGAST4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTcmFromGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "UnAssignTcmFromGovGAST4Command identifier should not be null");
  }
  /**
   * handles assign Tm validation for a GovGAST4
   *
   * @param command AssignTmToGovGAST4Command
   */
  public void validate(AssignTmToGovGAST4Command command) throws Exception {
    Assert.notNull(command, "AssignTmToGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "AssignTmToGovGAST4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTmToGovGAST4Command assignment should not be null");
  }

  /**
   * handles unassign Tm validation for a GovGAST4
   *
   * @param command UnAssignTmFromGovGAST4Command
   */
  public void validate(UnAssignTmFromGovGAST4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTmFromGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "UnAssignTmFromGovGAST4Command identifier should not be null");
  }
  /**
   * handles assign Tv validation for a GovGAST4
   *
   * @param command AssignTvToGovGAST4Command
   */
  public void validate(AssignTvToGovGAST4Command command) throws Exception {
    Assert.notNull(command, "AssignTvToGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "AssignTvToGovGAST4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTvToGovGAST4Command assignment should not be null");
  }

  /**
   * handles unassign Tv validation for a GovGAST4
   *
   * @param command UnAssignTvFromGovGAST4Command
   */
  public void validate(UnAssignTvFromGovGAST4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTvFromGovGAST4Command should not be null");
    Assert.notNull(
        command.getGovGAST4Id(), "UnAssignTvFromGovGAST4Command identifier should not be null");
  }
}
