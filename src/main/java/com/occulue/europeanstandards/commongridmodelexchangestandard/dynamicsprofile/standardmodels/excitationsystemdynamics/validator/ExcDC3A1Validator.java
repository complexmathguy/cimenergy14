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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class ExcDC3A1Validator {

  /** default constructor */
  protected ExcDC3A1Validator() {}

  /** factory method */
  public static ExcDC3A1Validator getInstance() {
    return new ExcDC3A1Validator();
  }

  /** handles creation validation for a ExcDC3A1 */
  public void validate(CreateExcDC3A1Command excDC3A1) throws Exception {
    Assert.notNull(excDC3A1, "CreateExcDC3A1Command should not be null");
    //		Assert.isNull( excDC3A1.getExcDC3A1Id(), "CreateExcDC3A1Command identifier should be null"
    // );
  }

  /** handles update validation for a ExcDC3A1 */
  public void validate(UpdateExcDC3A1Command excDC3A1) throws Exception {
    Assert.notNull(excDC3A1, "UpdateExcDC3A1Command should not be null");
    Assert.notNull(excDC3A1.getExcDC3A1Id(), "UpdateExcDC3A1Command identifier should not be null");
  }

  /** handles delete validation for a ExcDC3A1 */
  public void validate(DeleteExcDC3A1Command excDC3A1) throws Exception {
    Assert.notNull(excDC3A1, "{commandAlias} should not be null");
    Assert.notNull(excDC3A1.getExcDC3A1Id(), "DeleteExcDC3A1Command identifier should not be null");
  }

  /** handles fetchOne validation for a ExcDC3A1 */
  public void validate(ExcDC3A1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcDC3A1FetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcDC3A1Id(), "ExcDC3A1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Exclim validation for a ExcDC3A1
   *
   * @param command AssignExclimToExcDC3A1Command
   */
  public void validate(AssignExclimToExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "AssignExclimToExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "AssignExclimToExcDC3A1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignExclimToExcDC3A1Command assignment should not be null");
  }

  /**
   * handles unassign Exclim validation for a ExcDC3A1
   *
   * @param command UnAssignExclimFromExcDC3A1Command
   */
  public void validate(UnAssignExclimFromExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "UnAssignExclimFromExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "UnAssignExclimFromExcDC3A1Command identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcDC3A1
   *
   * @param command AssignKaToExcDC3A1Command
   */
  public void validate(AssignKaToExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "AssignKaToExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "AssignKaToExcDC3A1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcDC3A1Command assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcDC3A1
   *
   * @param command UnAssignKaFromExcDC3A1Command
   */
  public void validate(UnAssignKaFromExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "UnAssignKaFromExcDC3A1Command identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcDC3A1
   *
   * @param command AssignKeToExcDC3A1Command
   */
  public void validate(AssignKeToExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "AssignKeToExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "AssignKeToExcDC3A1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcDC3A1Command assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcDC3A1
   *
   * @param command UnAssignKeFromExcDC3A1Command
   */
  public void validate(UnAssignKeFromExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "UnAssignKeFromExcDC3A1Command identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcDC3A1
   *
   * @param command AssignKfToExcDC3A1Command
   */
  public void validate(AssignKfToExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "AssignKfToExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "AssignKfToExcDC3A1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcDC3A1Command assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcDC3A1
   *
   * @param command UnAssignKfFromExcDC3A1Command
   */
  public void validate(UnAssignKfFromExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "UnAssignKfFromExcDC3A1Command identifier should not be null");
  }
  /**
   * handles assign Ki validation for a ExcDC3A1
   *
   * @param command AssignKiToExcDC3A1Command
   */
  public void validate(AssignKiToExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "AssignKiToExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "AssignKiToExcDC3A1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToExcDC3A1Command assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a ExcDC3A1
   *
   * @param command UnAssignKiFromExcDC3A1Command
   */
  public void validate(UnAssignKiFromExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "UnAssignKiFromExcDC3A1Command identifier should not be null");
  }
  /**
   * handles assign Kp validation for a ExcDC3A1
   *
   * @param command AssignKpToExcDC3A1Command
   */
  public void validate(AssignKpToExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "AssignKpToExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "AssignKpToExcDC3A1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToExcDC3A1Command assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a ExcDC3A1
   *
   * @param command UnAssignKpFromExcDC3A1Command
   */
  public void validate(UnAssignKpFromExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "UnAssignKpFromExcDC3A1Command identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcDC3A1
   *
   * @param command AssignTaToExcDC3A1Command
   */
  public void validate(AssignTaToExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "AssignTaToExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "AssignTaToExcDC3A1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcDC3A1Command assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcDC3A1
   *
   * @param command UnAssignTaFromExcDC3A1Command
   */
  public void validate(UnAssignTaFromExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "UnAssignTaFromExcDC3A1Command identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcDC3A1
   *
   * @param command AssignTeToExcDC3A1Command
   */
  public void validate(AssignTeToExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "AssignTeToExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "AssignTeToExcDC3A1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcDC3A1Command assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcDC3A1
   *
   * @param command UnAssignTeFromExcDC3A1Command
   */
  public void validate(UnAssignTeFromExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "UnAssignTeFromExcDC3A1Command identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcDC3A1
   *
   * @param command AssignTfToExcDC3A1Command
   */
  public void validate(AssignTfToExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "AssignTfToExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "AssignTfToExcDC3A1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcDC3A1Command assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcDC3A1
   *
   * @param command UnAssignTfFromExcDC3A1Command
   */
  public void validate(UnAssignTfFromExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "UnAssignTfFromExcDC3A1Command identifier should not be null");
  }
  /**
   * handles assign Vb1max validation for a ExcDC3A1
   *
   * @param command AssignVb1maxToExcDC3A1Command
   */
  public void validate(AssignVb1maxToExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "AssignVb1maxToExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "AssignVb1maxToExcDC3A1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVb1maxToExcDC3A1Command assignment should not be null");
  }

  /**
   * handles unassign Vb1max validation for a ExcDC3A1
   *
   * @param command UnAssignVb1maxFromExcDC3A1Command
   */
  public void validate(UnAssignVb1maxFromExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVb1maxFromExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "UnAssignVb1maxFromExcDC3A1Command identifier should not be null");
  }
  /**
   * handles assign Vblim validation for a ExcDC3A1
   *
   * @param command AssignVblimToExcDC3A1Command
   */
  public void validate(AssignVblimToExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "AssignVblimToExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "AssignVblimToExcDC3A1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVblimToExcDC3A1Command assignment should not be null");
  }

  /**
   * handles unassign Vblim validation for a ExcDC3A1
   *
   * @param command UnAssignVblimFromExcDC3A1Command
   */
  public void validate(UnAssignVblimFromExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVblimFromExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "UnAssignVblimFromExcDC3A1Command identifier should not be null");
  }
  /**
   * handles assign Vbmax validation for a ExcDC3A1
   *
   * @param command AssignVbmaxToExcDC3A1Command
   */
  public void validate(AssignVbmaxToExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "AssignVbmaxToExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "AssignVbmaxToExcDC3A1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVbmaxToExcDC3A1Command assignment should not be null");
  }

  /**
   * handles unassign Vbmax validation for a ExcDC3A1
   *
   * @param command UnAssignVbmaxFromExcDC3A1Command
   */
  public void validate(UnAssignVbmaxFromExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVbmaxFromExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "UnAssignVbmaxFromExcDC3A1Command identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcDC3A1
   *
   * @param command AssignVrmaxToExcDC3A1Command
   */
  public void validate(AssignVrmaxToExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "AssignVrmaxToExcDC3A1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcDC3A1Command assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcDC3A1
   *
   * @param command UnAssignVrmaxFromExcDC3A1Command
   */
  public void validate(UnAssignVrmaxFromExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "UnAssignVrmaxFromExcDC3A1Command identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcDC3A1
   *
   * @param command AssignVrminToExcDC3A1Command
   */
  public void validate(AssignVrminToExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "AssignVrminToExcDC3A1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcDC3A1Command assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcDC3A1
   *
   * @param command UnAssignVrminFromExcDC3A1Command
   */
  public void validate(UnAssignVrminFromExcDC3A1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcDC3A1Command should not be null");
    Assert.notNull(
        command.getExcDC3A1Id(), "UnAssignVrminFromExcDC3A1Command identifier should not be null");
  }
}
