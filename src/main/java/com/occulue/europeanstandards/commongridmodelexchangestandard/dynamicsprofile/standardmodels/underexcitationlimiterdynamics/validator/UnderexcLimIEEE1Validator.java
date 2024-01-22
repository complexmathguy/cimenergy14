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

public class UnderexcLimIEEE1Validator {

  /** default constructor */
  protected UnderexcLimIEEE1Validator() {}

  /** factory method */
  public static UnderexcLimIEEE1Validator getInstance() {
    return new UnderexcLimIEEE1Validator();
  }

  /** handles creation validation for a UnderexcLimIEEE1 */
  public void validate(CreateUnderexcLimIEEE1Command underexcLimIEEE1) throws Exception {
    Assert.notNull(underexcLimIEEE1, "CreateUnderexcLimIEEE1Command should not be null");
    //		Assert.isNull( underexcLimIEEE1.getUnderexcLimIEEE1Id(), "CreateUnderexcLimIEEE1Command
    // identifier should be null" );
  }

  /** handles update validation for a UnderexcLimIEEE1 */
  public void validate(UpdateUnderexcLimIEEE1Command underexcLimIEEE1) throws Exception {
    Assert.notNull(underexcLimIEEE1, "UpdateUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        underexcLimIEEE1.getUnderexcLimIEEE1Id(),
        "UpdateUnderexcLimIEEE1Command identifier should not be null");
  }

  /** handles delete validation for a UnderexcLimIEEE1 */
  public void validate(DeleteUnderexcLimIEEE1Command underexcLimIEEE1) throws Exception {
    Assert.notNull(underexcLimIEEE1, "{commandAlias} should not be null");
    Assert.notNull(
        underexcLimIEEE1.getUnderexcLimIEEE1Id(),
        "DeleteUnderexcLimIEEE1Command identifier should not be null");
  }

  /** handles fetchOne validation for a UnderexcLimIEEE1 */
  public void validate(UnderexcLimIEEE1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "UnderexcLimIEEE1FetchOneSummary should not be null");
    Assert.notNull(
        summary.getUnderexcLimIEEE1Id(),
        "UnderexcLimIEEE1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Kuc validation for a UnderexcLimIEEE1
   *
   * @param command AssignKucToUnderexcLimIEEE1Command
   */
  public void validate(AssignKucToUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignKucToUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "AssignKucToUnderexcLimIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKucToUnderexcLimIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Kuc validation for a UnderexcLimIEEE1
   *
   * @param command UnAssignKucFromUnderexcLimIEEE1Command
   */
  public void validate(UnAssignKucFromUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKucFromUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "UnAssignKucFromUnderexcLimIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Kuf validation for a UnderexcLimIEEE1
   *
   * @param command AssignKufToUnderexcLimIEEE1Command
   */
  public void validate(AssignKufToUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignKufToUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "AssignKufToUnderexcLimIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKufToUnderexcLimIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Kuf validation for a UnderexcLimIEEE1
   *
   * @param command UnAssignKufFromUnderexcLimIEEE1Command
   */
  public void validate(UnAssignKufFromUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKufFromUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "UnAssignKufFromUnderexcLimIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Kui validation for a UnderexcLimIEEE1
   *
   * @param command AssignKuiToUnderexcLimIEEE1Command
   */
  public void validate(AssignKuiToUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignKuiToUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "AssignKuiToUnderexcLimIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKuiToUnderexcLimIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Kui validation for a UnderexcLimIEEE1
   *
   * @param command UnAssignKuiFromUnderexcLimIEEE1Command
   */
  public void validate(UnAssignKuiFromUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKuiFromUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "UnAssignKuiFromUnderexcLimIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Kul validation for a UnderexcLimIEEE1
   *
   * @param command AssignKulToUnderexcLimIEEE1Command
   */
  public void validate(AssignKulToUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignKulToUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "AssignKulToUnderexcLimIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKulToUnderexcLimIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Kul validation for a UnderexcLimIEEE1
   *
   * @param command UnAssignKulFromUnderexcLimIEEE1Command
   */
  public void validate(UnAssignKulFromUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKulFromUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "UnAssignKulFromUnderexcLimIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Kur validation for a UnderexcLimIEEE1
   *
   * @param command AssignKurToUnderexcLimIEEE1Command
   */
  public void validate(AssignKurToUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignKurToUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "AssignKurToUnderexcLimIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKurToUnderexcLimIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Kur validation for a UnderexcLimIEEE1
   *
   * @param command UnAssignKurFromUnderexcLimIEEE1Command
   */
  public void validate(UnAssignKurFromUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKurFromUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "UnAssignKurFromUnderexcLimIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Tu1 validation for a UnderexcLimIEEE1
   *
   * @param command AssignTu1ToUnderexcLimIEEE1Command
   */
  public void validate(AssignTu1ToUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignTu1ToUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "AssignTu1ToUnderexcLimIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTu1ToUnderexcLimIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Tu1 validation for a UnderexcLimIEEE1
   *
   * @param command UnAssignTu1FromUnderexcLimIEEE1Command
   */
  public void validate(UnAssignTu1FromUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTu1FromUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "UnAssignTu1FromUnderexcLimIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Tu2 validation for a UnderexcLimIEEE1
   *
   * @param command AssignTu2ToUnderexcLimIEEE1Command
   */
  public void validate(AssignTu2ToUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignTu2ToUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "AssignTu2ToUnderexcLimIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTu2ToUnderexcLimIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Tu2 validation for a UnderexcLimIEEE1
   *
   * @param command UnAssignTu2FromUnderexcLimIEEE1Command
   */
  public void validate(UnAssignTu2FromUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTu2FromUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "UnAssignTu2FromUnderexcLimIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Tu3 validation for a UnderexcLimIEEE1
   *
   * @param command AssignTu3ToUnderexcLimIEEE1Command
   */
  public void validate(AssignTu3ToUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignTu3ToUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "AssignTu3ToUnderexcLimIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTu3ToUnderexcLimIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Tu3 validation for a UnderexcLimIEEE1
   *
   * @param command UnAssignTu3FromUnderexcLimIEEE1Command
   */
  public void validate(UnAssignTu3FromUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTu3FromUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "UnAssignTu3FromUnderexcLimIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Tu4 validation for a UnderexcLimIEEE1
   *
   * @param command AssignTu4ToUnderexcLimIEEE1Command
   */
  public void validate(AssignTu4ToUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignTu4ToUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "AssignTu4ToUnderexcLimIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTu4ToUnderexcLimIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Tu4 validation for a UnderexcLimIEEE1
   *
   * @param command UnAssignTu4FromUnderexcLimIEEE1Command
   */
  public void validate(UnAssignTu4FromUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTu4FromUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "UnAssignTu4FromUnderexcLimIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Vucmax validation for a UnderexcLimIEEE1
   *
   * @param command AssignVucmaxToUnderexcLimIEEE1Command
   */
  public void validate(AssignVucmaxToUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignVucmaxToUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "AssignVucmaxToUnderexcLimIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVucmaxToUnderexcLimIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Vucmax validation for a UnderexcLimIEEE1
   *
   * @param command UnAssignVucmaxFromUnderexcLimIEEE1Command
   */
  public void validate(UnAssignVucmaxFromUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVucmaxFromUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "UnAssignVucmaxFromUnderexcLimIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Vuimax validation for a UnderexcLimIEEE1
   *
   * @param command AssignVuimaxToUnderexcLimIEEE1Command
   */
  public void validate(AssignVuimaxToUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignVuimaxToUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "AssignVuimaxToUnderexcLimIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVuimaxToUnderexcLimIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Vuimax validation for a UnderexcLimIEEE1
   *
   * @param command UnAssignVuimaxFromUnderexcLimIEEE1Command
   */
  public void validate(UnAssignVuimaxFromUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVuimaxFromUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "UnAssignVuimaxFromUnderexcLimIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Vuimin validation for a UnderexcLimIEEE1
   *
   * @param command AssignVuiminToUnderexcLimIEEE1Command
   */
  public void validate(AssignVuiminToUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignVuiminToUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "AssignVuiminToUnderexcLimIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVuiminToUnderexcLimIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Vuimin validation for a UnderexcLimIEEE1
   *
   * @param command UnAssignVuiminFromUnderexcLimIEEE1Command
   */
  public void validate(UnAssignVuiminFromUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVuiminFromUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "UnAssignVuiminFromUnderexcLimIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Vulmax validation for a UnderexcLimIEEE1
   *
   * @param command AssignVulmaxToUnderexcLimIEEE1Command
   */
  public void validate(AssignVulmaxToUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignVulmaxToUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "AssignVulmaxToUnderexcLimIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVulmaxToUnderexcLimIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Vulmax validation for a UnderexcLimIEEE1
   *
   * @param command UnAssignVulmaxFromUnderexcLimIEEE1Command
   */
  public void validate(UnAssignVulmaxFromUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVulmaxFromUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "UnAssignVulmaxFromUnderexcLimIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Vulmin validation for a UnderexcLimIEEE1
   *
   * @param command AssignVulminToUnderexcLimIEEE1Command
   */
  public void validate(AssignVulminToUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignVulminToUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "AssignVulminToUnderexcLimIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVulminToUnderexcLimIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Vulmin validation for a UnderexcLimIEEE1
   *
   * @param command UnAssignVulminFromUnderexcLimIEEE1Command
   */
  public void validate(UnAssignVulminFromUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVulminFromUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "UnAssignVulminFromUnderexcLimIEEE1Command identifier should not be null");
  }
  /**
   * handles assign Vurmax validation for a UnderexcLimIEEE1
   *
   * @param command AssignVurmaxToUnderexcLimIEEE1Command
   */
  public void validate(AssignVurmaxToUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "AssignVurmaxToUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "AssignVurmaxToUnderexcLimIEEE1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignVurmaxToUnderexcLimIEEE1Command assignment should not be null");
  }

  /**
   * handles unassign Vurmax validation for a UnderexcLimIEEE1
   *
   * @param command UnAssignVurmaxFromUnderexcLimIEEE1Command
   */
  public void validate(UnAssignVurmaxFromUnderexcLimIEEE1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVurmaxFromUnderexcLimIEEE1Command should not be null");
    Assert.notNull(
        command.getUnderexcLimIEEE1Id(),
        "UnAssignVurmaxFromUnderexcLimIEEE1Command identifier should not be null");
  }
}
