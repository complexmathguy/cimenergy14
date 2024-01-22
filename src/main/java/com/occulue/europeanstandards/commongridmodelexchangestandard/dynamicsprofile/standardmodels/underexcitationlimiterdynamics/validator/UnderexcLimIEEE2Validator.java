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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class UnderexcLimIEEE2Validator {

  /** default constructor */
  protected UnderexcLimIEEE2Validator() {}

  /** factory method */
  public static UnderexcLimIEEE2Validator getInstance() {
    return new UnderexcLimIEEE2Validator();
  }

  /** handles creation validation for a UnderexcLimIEEE2 */
  public void validate(CreateUnderexcLimIEEE2Command underexcLimIEEE2) throws Exception {
    Assert.notNull(underexcLimIEEE2, "CreateUnderexcLimIEEE2Command should not be null");
    //		Assert.isNull( underexcLimIEEE2.getUnderexcLimIEEE2Id(), "CreateUnderexcLimIEEE2Command
    // identifier should be null" );
  }

  /** handles update validation for a UnderexcLimIEEE2 */
  public void validate(UpdateUnderexcLimIEEE2Command underexcLimIEEE2) throws Exception {
    Assert.notNull(underexcLimIEEE2, "UpdateUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        underexcLimIEEE2.getUnderexcLimIEEE2Id(),
        "UpdateUnderexcLimIEEE2Command identifier should not be null");
  }

  /** handles delete validation for a UnderexcLimIEEE2 */
  public void validate(DeleteUnderexcLimIEEE2Command underexcLimIEEE2) throws Exception {
    Assert.notNull(underexcLimIEEE2, "{commandAlias} should not be null");
    Assert.notNull(
        underexcLimIEEE2.getUnderexcLimIEEE2Id(),
        "DeleteUnderexcLimIEEE2Command identifier should not be null");
  }

  /** handles fetchOne validation for a UnderexcLimIEEE2 */
  public void validate(UnderexcLimIEEE2FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "UnderexcLimIEEE2FetchOneSummary should not be null");
    Assert.notNull(
        summary.getUnderexcLimIEEE2Id(),
        "UnderexcLimIEEE2FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign K1 validation for a UnderexcLimIEEE2
   *
   * @param command AssignK1ToUnderexcLimIEEE2Command
   */
  public void validate(AssignK1ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignK1ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignK1ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK1ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign K1 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignK1FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignK1FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignK1FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignK1FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign K2 validation for a UnderexcLimIEEE2
   *
   * @param command AssignK2ToUnderexcLimIEEE2Command
   */
  public void validate(AssignK2ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignK2ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignK2ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK2ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign K2 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignK2FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignK2FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignK2FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignK2FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Kfb validation for a UnderexcLimIEEE2
   *
   * @param command AssignKfbToUnderexcLimIEEE2Command
   */
  public void validate(AssignKfbToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignKfbToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignKfbToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKfbToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Kfb validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignKfbFromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignKfbFromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKfbFromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignKfbFromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Kuf validation for a UnderexcLimIEEE2
   *
   * @param command AssignKufToUnderexcLimIEEE2Command
   */
  public void validate(AssignKufToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignKufToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignKufToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKufToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Kuf validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignKufFromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignKufFromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKufFromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignKufFromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Kui validation for a UnderexcLimIEEE2
   *
   * @param command AssignKuiToUnderexcLimIEEE2Command
   */
  public void validate(AssignKuiToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignKuiToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignKuiToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKuiToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Kui validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignKuiFromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignKuiFromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKuiFromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignKuiFromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Kul validation for a UnderexcLimIEEE2
   *
   * @param command AssignKulToUnderexcLimIEEE2Command
   */
  public void validate(AssignKulToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignKulToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignKulToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKulToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Kul validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignKulFromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignKulFromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKulFromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignKulFromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign P0 validation for a UnderexcLimIEEE2
   *
   * @param command AssignP0ToUnderexcLimIEEE2Command
   */
  public void validate(AssignP0ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignP0ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignP0ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignP0ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign P0 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignP0FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignP0FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignP0FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignP0FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign P1 validation for a UnderexcLimIEEE2
   *
   * @param command AssignP1ToUnderexcLimIEEE2Command
   */
  public void validate(AssignP1ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignP1ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignP1ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignP1ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign P1 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignP1FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignP1FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignP1FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignP1FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign P10 validation for a UnderexcLimIEEE2
   *
   * @param command AssignP10ToUnderexcLimIEEE2Command
   */
  public void validate(AssignP10ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignP10ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignP10ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignP10ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign P10 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignP10FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignP10FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignP10FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignP10FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign P2 validation for a UnderexcLimIEEE2
   *
   * @param command AssignP2ToUnderexcLimIEEE2Command
   */
  public void validate(AssignP2ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignP2ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignP2ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignP2ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign P2 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignP2FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignP2FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignP2FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignP2FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign P3 validation for a UnderexcLimIEEE2
   *
   * @param command AssignP3ToUnderexcLimIEEE2Command
   */
  public void validate(AssignP3ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignP3ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignP3ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignP3ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign P3 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignP3FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignP3FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignP3FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignP3FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign P4 validation for a UnderexcLimIEEE2
   *
   * @param command AssignP4ToUnderexcLimIEEE2Command
   */
  public void validate(AssignP4ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignP4ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignP4ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignP4ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign P4 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignP4FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignP4FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignP4FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignP4FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign P5 validation for a UnderexcLimIEEE2
   *
   * @param command AssignP5ToUnderexcLimIEEE2Command
   */
  public void validate(AssignP5ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignP5ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignP5ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignP5ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign P5 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignP5FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignP5FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignP5FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignP5FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign P6 validation for a UnderexcLimIEEE2
   *
   * @param command AssignP6ToUnderexcLimIEEE2Command
   */
  public void validate(AssignP6ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignP6ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignP6ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignP6ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign P6 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignP6FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignP6FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignP6FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignP6FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign P7 validation for a UnderexcLimIEEE2
   *
   * @param command AssignP7ToUnderexcLimIEEE2Command
   */
  public void validate(AssignP7ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignP7ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignP7ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignP7ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign P7 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignP7FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignP7FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignP7FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignP7FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign P8 validation for a UnderexcLimIEEE2
   *
   * @param command AssignP8ToUnderexcLimIEEE2Command
   */
  public void validate(AssignP8ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignP8ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignP8ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignP8ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign P8 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignP8FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignP8FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignP8FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignP8FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign P9 validation for a UnderexcLimIEEE2
   *
   * @param command AssignP9ToUnderexcLimIEEE2Command
   */
  public void validate(AssignP9ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignP9ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignP9ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignP9ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign P9 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignP9FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignP9FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignP9FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignP9FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Q0 validation for a UnderexcLimIEEE2
   *
   * @param command AssignQ0ToUnderexcLimIEEE2Command
   */
  public void validate(AssignQ0ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignQ0ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignQ0ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQ0ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Q0 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignQ0FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignQ0FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignQ0FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignQ0FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Q1 validation for a UnderexcLimIEEE2
   *
   * @param command AssignQ1ToUnderexcLimIEEE2Command
   */
  public void validate(AssignQ1ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignQ1ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignQ1ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQ1ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Q1 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignQ1FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignQ1FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignQ1FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignQ1FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Q10 validation for a UnderexcLimIEEE2
   *
   * @param command AssignQ10ToUnderexcLimIEEE2Command
   */
  public void validate(AssignQ10ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignQ10ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignQ10ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignQ10ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Q10 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignQ10FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignQ10FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignQ10FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignQ10FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Q2 validation for a UnderexcLimIEEE2
   *
   * @param command AssignQ2ToUnderexcLimIEEE2Command
   */
  public void validate(AssignQ2ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignQ2ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignQ2ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQ2ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Q2 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignQ2FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignQ2FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignQ2FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignQ2FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Q3 validation for a UnderexcLimIEEE2
   *
   * @param command AssignQ3ToUnderexcLimIEEE2Command
   */
  public void validate(AssignQ3ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignQ3ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignQ3ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQ3ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Q3 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignQ3FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignQ3FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignQ3FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignQ3FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Q4 validation for a UnderexcLimIEEE2
   *
   * @param command AssignQ4ToUnderexcLimIEEE2Command
   */
  public void validate(AssignQ4ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignQ4ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignQ4ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQ4ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Q4 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignQ4FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignQ4FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignQ4FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignQ4FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Q5 validation for a UnderexcLimIEEE2
   *
   * @param command AssignQ5ToUnderexcLimIEEE2Command
   */
  public void validate(AssignQ5ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignQ5ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignQ5ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQ5ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Q5 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignQ5FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignQ5FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignQ5FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignQ5FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Q6 validation for a UnderexcLimIEEE2
   *
   * @param command AssignQ6ToUnderexcLimIEEE2Command
   */
  public void validate(AssignQ6ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignQ6ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignQ6ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQ6ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Q6 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignQ6FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignQ6FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignQ6FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignQ6FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Q7 validation for a UnderexcLimIEEE2
   *
   * @param command AssignQ7ToUnderexcLimIEEE2Command
   */
  public void validate(AssignQ7ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignQ7ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignQ7ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQ7ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Q7 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignQ7FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignQ7FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignQ7FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignQ7FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Q8 validation for a UnderexcLimIEEE2
   *
   * @param command AssignQ8ToUnderexcLimIEEE2Command
   */
  public void validate(AssignQ8ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignQ8ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignQ8ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQ8ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Q8 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignQ8FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignQ8FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignQ8FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignQ8FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Q9 validation for a UnderexcLimIEEE2
   *
   * @param command AssignQ9ToUnderexcLimIEEE2Command
   */
  public void validate(AssignQ9ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignQ9ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignQ9ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignQ9ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Q9 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignQ9FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignQ9FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignQ9FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignQ9FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Tu1 validation for a UnderexcLimIEEE2
   *
   * @param command AssignTu1ToUnderexcLimIEEE2Command
   */
  public void validate(AssignTu1ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignTu1ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignTu1ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTu1ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Tu1 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignTu1FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignTu1FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTu1FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignTu1FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Tu2 validation for a UnderexcLimIEEE2
   *
   * @param command AssignTu2ToUnderexcLimIEEE2Command
   */
  public void validate(AssignTu2ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignTu2ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignTu2ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTu2ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Tu2 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignTu2FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignTu2FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTu2FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignTu2FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Tu3 validation for a UnderexcLimIEEE2
   *
   * @param command AssignTu3ToUnderexcLimIEEE2Command
   */
  public void validate(AssignTu3ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignTu3ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignTu3ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTu3ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Tu3 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignTu3FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignTu3FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTu3FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignTu3FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Tu4 validation for a UnderexcLimIEEE2
   *
   * @param command AssignTu4ToUnderexcLimIEEE2Command
   */
  public void validate(AssignTu4ToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignTu4ToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignTu4ToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTu4ToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Tu4 validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignTu4FromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignTu4FromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTu4FromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignTu4FromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Tul validation for a UnderexcLimIEEE2
   *
   * @param command AssignTulToUnderexcLimIEEE2Command
   */
  public void validate(AssignTulToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignTulToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignTulToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTulToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Tul validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignTulFromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignTulFromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTulFromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignTulFromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Tup validation for a UnderexcLimIEEE2
   *
   * @param command AssignTupToUnderexcLimIEEE2Command
   */
  public void validate(AssignTupToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignTupToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignTupToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTupToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Tup validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignTupFromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignTupFromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTupFromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignTupFromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Tuq validation for a UnderexcLimIEEE2
   *
   * @param command AssignTuqToUnderexcLimIEEE2Command
   */
  public void validate(AssignTuqToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignTuqToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignTuqToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTuqToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Tuq validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignTuqFromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignTuqFromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTuqFromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignTuqFromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Tuv validation for a UnderexcLimIEEE2
   *
   * @param command AssignTuvToUnderexcLimIEEE2Command
   */
  public void validate(AssignTuvToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignTuvToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignTuvToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTuvToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Tuv validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignTuvFromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignTuvFromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTuvFromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignTuvFromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Vuimax validation for a UnderexcLimIEEE2
   *
   * @param command AssignVuimaxToUnderexcLimIEEE2Command
   */
  public void validate(AssignVuimaxToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignVuimaxToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignVuimaxToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVuimaxToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Vuimax validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignVuimaxFromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignVuimaxFromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVuimaxFromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignVuimaxFromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Vuimin validation for a UnderexcLimIEEE2
   *
   * @param command AssignVuiminToUnderexcLimIEEE2Command
   */
  public void validate(AssignVuiminToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignVuiminToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignVuiminToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVuiminToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Vuimin validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignVuiminFromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignVuiminFromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVuiminFromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignVuiminFromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Vulmax validation for a UnderexcLimIEEE2
   *
   * @param command AssignVulmaxToUnderexcLimIEEE2Command
   */
  public void validate(AssignVulmaxToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignVulmaxToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignVulmaxToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVulmaxToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Vulmax validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignVulmaxFromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignVulmaxFromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVulmaxFromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignVulmaxFromUnderexcLimIEEE2Command identifier should not be null");
  }
  /**
   * handles assign Vulmin validation for a UnderexcLimIEEE2
   *
   * @param command AssignVulminToUnderexcLimIEEE2Command
   */
  public void validate(AssignVulminToUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "AssignVulminToUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "AssignVulminToUnderexcLimIEEE2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVulminToUnderexcLimIEEE2Command assignment should not be null");
  }

  /**
   * handles unassign Vulmin validation for a UnderexcLimIEEE2
   *
   * @param command UnAssignVulminFromUnderexcLimIEEE2Command
   */
  public void validate(UnAssignVulminFromUnderexcLimIEEE2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVulminFromUnderexcLimIEEE2Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE2Id(),
        "UnAssignVulminFromUnderexcLimIEEE2Command identifier should not be null");
  }
}
