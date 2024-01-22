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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class PssPTIST3Validator {

  /** default constructor */
  protected PssPTIST3Validator() {}

  /** factory method */
  public static PssPTIST3Validator getInstance() {
    return new PssPTIST3Validator();
  }

  /** handles creation validation for a PssPTIST3 */
  public void validate(CreatePssPTIST3Command pssPTIST3) throws Exception {
    Assert.notNull(pssPTIST3, "CreatePssPTIST3Command should not be null");
    //		Assert.isNull( pssPTIST3.getPssPTIST3Id(), "CreatePssPTIST3Command identifier should be
    // null" );
  }

  /** handles update validation for a PssPTIST3 */
  public void validate(UpdatePssPTIST3Command pssPTIST3) throws Exception {
    Assert.notNull(pssPTIST3, "UpdatePssPTIST3Command should not be null");
    Assert.notNull(
        pssPTIST3.getPssPTIST3Id(), "UpdatePssPTIST3Command identifier should not be null");
  }

  /** handles delete validation for a PssPTIST3 */
  public void validate(DeletePssPTIST3Command pssPTIST3) throws Exception {
    Assert.notNull(pssPTIST3, "{commandAlias} should not be null");
    Assert.notNull(
        pssPTIST3.getPssPTIST3Id(), "DeletePssPTIST3Command identifier should not be null");
  }

  /** handles fetchOne validation for a PssPTIST3 */
  public void validate(PssPTIST3FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PssPTIST3FetchOneSummary should not be null");
    Assert.notNull(
        summary.getPssPTIST3Id(), "PssPTIST3FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign A0 validation for a PssPTIST3
   *
   * @param command AssignA0ToPssPTIST3Command
   */
  public void validate(AssignA0ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignA0ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignA0ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA0ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign A0 validation for a PssPTIST3
   *
   * @param command UnAssignA0FromPssPTIST3Command
   */
  public void validate(UnAssignA0FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignA0FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignA0FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign A1 validation for a PssPTIST3
   *
   * @param command AssignA1ToPssPTIST3Command
   */
  public void validate(AssignA1ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignA1ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignA1ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA1ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign A1 validation for a PssPTIST3
   *
   * @param command UnAssignA1FromPssPTIST3Command
   */
  public void validate(UnAssignA1FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignA1FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignA1FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign A2 validation for a PssPTIST3
   *
   * @param command AssignA2ToPssPTIST3Command
   */
  public void validate(AssignA2ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignA2ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignA2ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA2ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign A2 validation for a PssPTIST3
   *
   * @param command UnAssignA2FromPssPTIST3Command
   */
  public void validate(UnAssignA2FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignA2FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignA2FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign A3 validation for a PssPTIST3
   *
   * @param command AssignA3ToPssPTIST3Command
   */
  public void validate(AssignA3ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignA3ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignA3ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA3ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign A3 validation for a PssPTIST3
   *
   * @param command UnAssignA3FromPssPTIST3Command
   */
  public void validate(UnAssignA3FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignA3FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignA3FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign A4 validation for a PssPTIST3
   *
   * @param command AssignA4ToPssPTIST3Command
   */
  public void validate(AssignA4ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignA4ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignA4ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA4ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign A4 validation for a PssPTIST3
   *
   * @param command UnAssignA4FromPssPTIST3Command
   */
  public void validate(UnAssignA4FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignA4FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignA4FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign A5 validation for a PssPTIST3
   *
   * @param command AssignA5ToPssPTIST3Command
   */
  public void validate(AssignA5ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignA5ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignA5ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignA5ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign A5 validation for a PssPTIST3
   *
   * @param command UnAssignA5FromPssPTIST3Command
   */
  public void validate(UnAssignA5FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignA5FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignA5FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign Al validation for a PssPTIST3
   *
   * @param command AssignAlToPssPTIST3Command
   */
  public void validate(AssignAlToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignAlToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignAlToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAlToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign Al validation for a PssPTIST3
   *
   * @param command UnAssignAlFromPssPTIST3Command
   */
  public void validate(UnAssignAlFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignAlFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignAlFromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign Athres validation for a PssPTIST3
   *
   * @param command AssignAthresToPssPTIST3Command
   */
  public void validate(AssignAthresToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignAthresToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignAthresToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignAthresToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign Athres validation for a PssPTIST3
   *
   * @param command UnAssignAthresFromPssPTIST3Command
   */
  public void validate(UnAssignAthresFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignAthresFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(),
        "UnAssignAthresFromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign B0 validation for a PssPTIST3
   *
   * @param command AssignB0ToPssPTIST3Command
   */
  public void validate(AssignB0ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignB0ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignB0ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignB0ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign B0 validation for a PssPTIST3
   *
   * @param command UnAssignB0FromPssPTIST3Command
   */
  public void validate(UnAssignB0FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignB0FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignB0FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign B1 validation for a PssPTIST3
   *
   * @param command AssignB1ToPssPTIST3Command
   */
  public void validate(AssignB1ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignB1ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignB1ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignB1ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign B1 validation for a PssPTIST3
   *
   * @param command UnAssignB1FromPssPTIST3Command
   */
  public void validate(UnAssignB1FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignB1FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignB1FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign B2 validation for a PssPTIST3
   *
   * @param command AssignB2ToPssPTIST3Command
   */
  public void validate(AssignB2ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignB2ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignB2ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignB2ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign B2 validation for a PssPTIST3
   *
   * @param command UnAssignB2FromPssPTIST3Command
   */
  public void validate(UnAssignB2FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignB2FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignB2FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign B3 validation for a PssPTIST3
   *
   * @param command AssignB3ToPssPTIST3Command
   */
  public void validate(AssignB3ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignB3ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignB3ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignB3ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign B3 validation for a PssPTIST3
   *
   * @param command UnAssignB3FromPssPTIST3Command
   */
  public void validate(UnAssignB3FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignB3FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignB3FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign B4 validation for a PssPTIST3
   *
   * @param command AssignB4ToPssPTIST3Command
   */
  public void validate(AssignB4ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignB4ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignB4ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignB4ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign B4 validation for a PssPTIST3
   *
   * @param command UnAssignB4FromPssPTIST3Command
   */
  public void validate(UnAssignB4FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignB4FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignB4FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign B5 validation for a PssPTIST3
   *
   * @param command AssignB5ToPssPTIST3Command
   */
  public void validate(AssignB5ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignB5ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignB5ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignB5ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign B5 validation for a PssPTIST3
   *
   * @param command UnAssignB5FromPssPTIST3Command
   */
  public void validate(UnAssignB5FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignB5FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignB5FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign Dl validation for a PssPTIST3
   *
   * @param command AssignDlToPssPTIST3Command
   */
  public void validate(AssignDlToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignDlToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignDlToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDlToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign Dl validation for a PssPTIST3
   *
   * @param command UnAssignDlFromPssPTIST3Command
   */
  public void validate(UnAssignDlFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignDlFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignDlFromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign Dtc validation for a PssPTIST3
   *
   * @param command AssignDtcToPssPTIST3Command
   */
  public void validate(AssignDtcToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignDtcToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignDtcToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDtcToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign Dtc validation for a PssPTIST3
   *
   * @param command UnAssignDtcFromPssPTIST3Command
   */
  public void validate(UnAssignDtcFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignDtcFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignDtcFromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign Dtf validation for a PssPTIST3
   *
   * @param command AssignDtfToPssPTIST3Command
   */
  public void validate(AssignDtfToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignDtfToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignDtfToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDtfToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign Dtf validation for a PssPTIST3
   *
   * @param command UnAssignDtfFromPssPTIST3Command
   */
  public void validate(UnAssignDtfFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignDtfFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignDtfFromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign Dtp validation for a PssPTIST3
   *
   * @param command AssignDtpToPssPTIST3Command
   */
  public void validate(AssignDtpToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignDtpToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignDtpToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDtpToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign Dtp validation for a PssPTIST3
   *
   * @param command UnAssignDtpFromPssPTIST3Command
   */
  public void validate(UnAssignDtpFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignDtpFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignDtpFromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign Isw validation for a PssPTIST3
   *
   * @param command AssignIswToPssPTIST3Command
   */
  public void validate(AssignIswToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignIswToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignIswToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIswToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign Isw validation for a PssPTIST3
   *
   * @param command UnAssignIswFromPssPTIST3Command
   */
  public void validate(UnAssignIswFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignIswFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignIswFromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign K validation for a PssPTIST3
   *
   * @param command AssignKToPssPTIST3Command
   */
  public void validate(AssignKToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignKToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignKToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign K validation for a PssPTIST3
   *
   * @param command UnAssignKFromPssPTIST3Command
   */
  public void validate(UnAssignKFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignKFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignKFromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign Lthres validation for a PssPTIST3
   *
   * @param command AssignLthresToPssPTIST3Command
   */
  public void validate(AssignLthresToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignLthresToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignLthresToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignLthresToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign Lthres validation for a PssPTIST3
   *
   * @param command UnAssignLthresFromPssPTIST3Command
   */
  public void validate(UnAssignLthresFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignLthresFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(),
        "UnAssignLthresFromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign M validation for a PssPTIST3
   *
   * @param command AssignMToPssPTIST3Command
   */
  public void validate(AssignMToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignMToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignMToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign M validation for a PssPTIST3
   *
   * @param command UnAssignMFromPssPTIST3Command
   */
  public void validate(UnAssignMFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignMFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignMFromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign Nav validation for a PssPTIST3
   *
   * @param command AssignNavToPssPTIST3Command
   */
  public void validate(AssignNavToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignNavToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignNavToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignNavToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign Nav validation for a PssPTIST3
   *
   * @param command UnAssignNavFromPssPTIST3Command
   */
  public void validate(UnAssignNavFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignNavFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignNavFromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign Ncl validation for a PssPTIST3
   *
   * @param command AssignNclToPssPTIST3Command
   */
  public void validate(AssignNclToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignNclToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignNclToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignNclToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign Ncl validation for a PssPTIST3
   *
   * @param command UnAssignNclFromPssPTIST3Command
   */
  public void validate(UnAssignNclFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignNclFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignNclFromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign Ncr validation for a PssPTIST3
   *
   * @param command AssignNcrToPssPTIST3Command
   */
  public void validate(AssignNcrToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignNcrToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignNcrToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignNcrToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign Ncr validation for a PssPTIST3
   *
   * @param command UnAssignNcrFromPssPTIST3Command
   */
  public void validate(UnAssignNcrFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignNcrFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignNcrFromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign Pmin validation for a PssPTIST3
   *
   * @param command AssignPminToPssPTIST3Command
   */
  public void validate(AssignPminToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignPminToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignPminToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPminToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign Pmin validation for a PssPTIST3
   *
   * @param command UnAssignPminFromPssPTIST3Command
   */
  public void validate(UnAssignPminFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignPminFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignPminFromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign T1 validation for a PssPTIST3
   *
   * @param command AssignT1ToPssPTIST3Command
   */
  public void validate(AssignT1ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignT1ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignT1ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a PssPTIST3
   *
   * @param command UnAssignT1FromPssPTIST3Command
   */
  public void validate(UnAssignT1FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignT1FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign T2 validation for a PssPTIST3
   *
   * @param command AssignT2ToPssPTIST3Command
   */
  public void validate(AssignT2ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignT2ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignT2ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a PssPTIST3
   *
   * @param command UnAssignT2FromPssPTIST3Command
   */
  public void validate(UnAssignT2FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignT2FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign T3 validation for a PssPTIST3
   *
   * @param command AssignT3ToPssPTIST3Command
   */
  public void validate(AssignT3ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignT3ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignT3ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a PssPTIST3
   *
   * @param command UnAssignT3FromPssPTIST3Command
   */
  public void validate(UnAssignT3FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignT3FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign T4 validation for a PssPTIST3
   *
   * @param command AssignT4ToPssPTIST3Command
   */
  public void validate(AssignT4ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignT4ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignT4ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a PssPTIST3
   *
   * @param command UnAssignT4FromPssPTIST3Command
   */
  public void validate(UnAssignT4FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignT4FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign T5 validation for a PssPTIST3
   *
   * @param command AssignT5ToPssPTIST3Command
   */
  public void validate(AssignT5ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignT5ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignT5ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a PssPTIST3
   *
   * @param command UnAssignT5FromPssPTIST3Command
   */
  public void validate(UnAssignT5FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignT5FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign T6 validation for a PssPTIST3
   *
   * @param command AssignT6ToPssPTIST3Command
   */
  public void validate(AssignT6ToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignT6ToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignT6ToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT6ToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a PssPTIST3
   *
   * @param command UnAssignT6FromPssPTIST3Command
   */
  public void validate(UnAssignT6FromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignT6FromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign Tf validation for a PssPTIST3
   *
   * @param command AssignTfToPssPTIST3Command
   */
  public void validate(AssignTfToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignTfToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignTfToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a PssPTIST3
   *
   * @param command UnAssignTfFromPssPTIST3Command
   */
  public void validate(UnAssignTfFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignTfFromPssPTIST3Command identifier should not be null");
  }
  /**
   * handles assign Tp validation for a PssPTIST3
   *
   * @param command AssignTpToPssPTIST3Command
   */
  public void validate(AssignTpToPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "AssignTpToPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "AssignTpToPssPTIST3Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpToPssPTIST3Command assignment should not be null");
  }

  /**
   * handles unassign Tp validation for a PssPTIST3
   *
   * @param command UnAssignTpFromPssPTIST3Command
   */
  public void validate(UnAssignTpFromPssPTIST3Command command) throws Exception {
    Assert.notNull(command, "UnAssignTpFromPssPTIST3Command should not be null");
    Assert.notNull(
        command.getPssPTIST3Id(), "UnAssignTpFromPssPTIST3Command identifier should not be null");
  }
}
