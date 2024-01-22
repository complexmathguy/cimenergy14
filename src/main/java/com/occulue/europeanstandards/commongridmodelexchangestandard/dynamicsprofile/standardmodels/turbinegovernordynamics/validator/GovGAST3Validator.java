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

public class GovGAST3Validator {

  /** default constructor */
  protected GovGAST3Validator() {}

  /** factory method */
  public static GovGAST3Validator getInstance() {
    return new GovGAST3Validator();
  }

  /** handles creation validation for a GovGAST3 */
  public void validate(CreateGovGAST3Command govGAST3) throws Exception {
    Assert.notNull(govGAST3, "CreateGovGAST3Command should not be null");
    //		Assert.isNull( govGAST3.getGovGAST3Id(), "CreateGovGAST3Command identifier should be null"
    // );
  }

  /** handles update validation for a GovGAST3 */
  public void validate(UpdateGovGAST3Command govGAST3) throws Exception {
    Assert.notNull(govGAST3, "UpdateGovGAST3Command should not be null");
    Assert.notNull(govGAST3.getGovGAST3Id(), "UpdateGovGAST3Command identifier should not be null");
  }

  /** handles delete validation for a GovGAST3 */
  public void validate(DeleteGovGAST3Command govGAST3) throws Exception {
    Assert.notNull(govGAST3, "{commandAlias} should not be null");
    Assert.notNull(govGAST3.getGovGAST3Id(), "DeleteGovGAST3Command identifier should not be null");
  }

  /** handles fetchOne validation for a GovGAST3 */
  public void validate(GovGAST3FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovGAST3FetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovGAST3Id(), "GovGAST3FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Bca validation for a GovGAST3
   *
   * @param command AssignBcaToGovGAST3Command
   */
  public void validate(AssignBcaToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignBcaToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignBcaToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBcaToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Bca validation for a GovGAST3
   *
   * @param command UnAssignBcaFromGovGAST3Command
   */
  public void validate(UnAssignBcaFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignBcaFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignBcaFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Bp validation for a GovGAST3
   *
   * @param command AssignBpToGovGAST3Command
   */
  public void validate(AssignBpToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignBpToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignBpToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBpToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Bp validation for a GovGAST3
   *
   * @param command UnAssignBpFromGovGAST3Command
   */
  public void validate(UnAssignBpFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignBpFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignBpFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Dtc validation for a GovGAST3
   *
   * @param command AssignDtcToGovGAST3Command
   */
  public void validate(AssignDtcToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignDtcToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignDtcToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDtcToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Dtc validation for a GovGAST3
   *
   * @param command UnAssignDtcFromGovGAST3Command
   */
  public void validate(UnAssignDtcFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignDtcFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignDtcFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Ka validation for a GovGAST3
   *
   * @param command AssignKaToGovGAST3Command
   */
  public void validate(AssignKaToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignKaToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignKaToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a GovGAST3
   *
   * @param command UnAssignKaFromGovGAST3Command
   */
  public void validate(UnAssignKaFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignKaFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Kac validation for a GovGAST3
   *
   * @param command AssignKacToGovGAST3Command
   */
  public void validate(AssignKacToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignKacToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignKacToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKacToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Kac validation for a GovGAST3
   *
   * @param command UnAssignKacFromGovGAST3Command
   */
  public void validate(UnAssignKacFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignKacFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignKacFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Kca validation for a GovGAST3
   *
   * @param command AssignKcaToGovGAST3Command
   */
  public void validate(AssignKcaToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignKcaToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignKcaToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcaToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Kca validation for a GovGAST3
   *
   * @param command UnAssignKcaFromGovGAST3Command
   */
  public void validate(UnAssignKcaFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignKcaFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignKcaFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Ksi validation for a GovGAST3
   *
   * @param command AssignKsiToGovGAST3Command
   */
  public void validate(AssignKsiToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignKsiToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignKsiToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKsiToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Ksi validation for a GovGAST3
   *
   * @param command UnAssignKsiFromGovGAST3Command
   */
  public void validate(UnAssignKsiFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignKsiFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignKsiFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Ky validation for a GovGAST3
   *
   * @param command AssignKyToGovGAST3Command
   */
  public void validate(AssignKyToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignKyToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignKyToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKyToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Ky validation for a GovGAST3
   *
   * @param command UnAssignKyFromGovGAST3Command
   */
  public void validate(UnAssignKyFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignKyFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignKyFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Mnef validation for a GovGAST3
   *
   * @param command AssignMnefToGovGAST3Command
   */
  public void validate(AssignMnefToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignMnefToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignMnefToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMnefToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Mnef validation for a GovGAST3
   *
   * @param command UnAssignMnefFromGovGAST3Command
   */
  public void validate(UnAssignMnefFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignMnefFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignMnefFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Mxef validation for a GovGAST3
   *
   * @param command AssignMxefToGovGAST3Command
   */
  public void validate(AssignMxefToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignMxefToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignMxefToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMxefToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Mxef validation for a GovGAST3
   *
   * @param command UnAssignMxefFromGovGAST3Command
   */
  public void validate(UnAssignMxefFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignMxefFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignMxefFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Rcmn validation for a GovGAST3
   *
   * @param command AssignRcmnToGovGAST3Command
   */
  public void validate(AssignRcmnToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignRcmnToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignRcmnToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRcmnToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Rcmn validation for a GovGAST3
   *
   * @param command UnAssignRcmnFromGovGAST3Command
   */
  public void validate(UnAssignRcmnFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignRcmnFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignRcmnFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Rcmx validation for a GovGAST3
   *
   * @param command AssignRcmxToGovGAST3Command
   */
  public void validate(AssignRcmxToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignRcmxToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignRcmxToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRcmxToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Rcmx validation for a GovGAST3
   *
   * @param command UnAssignRcmxFromGovGAST3Command
   */
  public void validate(UnAssignRcmxFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignRcmxFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignRcmxFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Tac validation for a GovGAST3
   *
   * @param command AssignTacToGovGAST3Command
   */
  public void validate(AssignTacToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignTacToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignTacToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTacToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Tac validation for a GovGAST3
   *
   * @param command UnAssignTacFromGovGAST3Command
   */
  public void validate(UnAssignTacFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTacFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignTacFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Tc validation for a GovGAST3
   *
   * @param command AssignTcToGovGAST3Command
   */
  public void validate(AssignTcToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignTcToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignTcToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTcToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Tc validation for a GovGAST3
   *
   * @param command UnAssignTcFromGovGAST3Command
   */
  public void validate(UnAssignTcFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTcFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignTcFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Td validation for a GovGAST3
   *
   * @param command AssignTdToGovGAST3Command
   */
  public void validate(AssignTdToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignTdToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignTdToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Td validation for a GovGAST3
   *
   * @param command UnAssignTdFromGovGAST3Command
   */
  public void validate(UnAssignTdFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTdFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignTdFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Tfen validation for a GovGAST3
   *
   * @param command AssignTfenToGovGAST3Command
   */
  public void validate(AssignTfenToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignTfenToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignTfenToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfenToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Tfen validation for a GovGAST3
   *
   * @param command UnAssignTfenFromGovGAST3Command
   */
  public void validate(UnAssignTfenFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTfenFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignTfenFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Tg validation for a GovGAST3
   *
   * @param command AssignTgToGovGAST3Command
   */
  public void validate(AssignTgToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignTgToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignTgToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTgToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Tg validation for a GovGAST3
   *
   * @param command UnAssignTgFromGovGAST3Command
   */
  public void validate(UnAssignTgFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTgFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignTgFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Tsi validation for a GovGAST3
   *
   * @param command AssignTsiToGovGAST3Command
   */
  public void validate(AssignTsiToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignTsiToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignTsiToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTsiToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Tsi validation for a GovGAST3
   *
   * @param command UnAssignTsiFromGovGAST3Command
   */
  public void validate(UnAssignTsiFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTsiFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignTsiFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Tt validation for a GovGAST3
   *
   * @param command AssignTtToGovGAST3Command
   */
  public void validate(AssignTtToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignTtToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignTtToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTtToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Tt validation for a GovGAST3
   *
   * @param command UnAssignTtFromGovGAST3Command
   */
  public void validate(UnAssignTtFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTtFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignTtFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Ttc validation for a GovGAST3
   *
   * @param command AssignTtcToGovGAST3Command
   */
  public void validate(AssignTtcToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignTtcToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignTtcToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTtcToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Ttc validation for a GovGAST3
   *
   * @param command UnAssignTtcFromGovGAST3Command
   */
  public void validate(UnAssignTtcFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTtcFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignTtcFromGovGAST3Command identifier should not be null");
  }
  /**
   * handles assign Ty validation for a GovGAST3
   *
   * @param command AssignTyToGovGAST3Command
   */
  public void validate(AssignTyToGovGAST3Command command) throws Exception {
    Assert.notNull(command, "AssignTyToGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "AssignTyToGovGAST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTyToGovGAST3Command assignment should not be null");
  }

  /**
   * handles unassign Ty validation for a GovGAST3
   *
   * @param command UnAssignTyFromGovGAST3Command
   */
  public void validate(UnAssignTyFromGovGAST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTyFromGovGAST3Command should not be null");
    Assert.notNull(
        command.getGovGAST3Id(), "UnAssignTyFromGovGAST3Command identifier should not be null");
  }
}
