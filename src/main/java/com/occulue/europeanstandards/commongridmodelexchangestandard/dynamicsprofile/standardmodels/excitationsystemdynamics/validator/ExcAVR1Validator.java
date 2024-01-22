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

public class ExcAVR1Validator {

  /** default constructor */
  protected ExcAVR1Validator() {}

  /** factory method */
  public static ExcAVR1Validator getInstance() {
    return new ExcAVR1Validator();
  }

  /** handles creation validation for a ExcAVR1 */
  public void validate(CreateExcAVR1Command excAVR1) throws Exception {
    Assert.notNull(excAVR1, "CreateExcAVR1Command should not be null");
    //		Assert.isNull( excAVR1.getExcAVR1Id(), "CreateExcAVR1Command identifier should be null" );
  }

  /** handles update validation for a ExcAVR1 */
  public void validate(UpdateExcAVR1Command excAVR1) throws Exception {
    Assert.notNull(excAVR1, "UpdateExcAVR1Command should not be null");
    Assert.notNull(excAVR1.getExcAVR1Id(), "UpdateExcAVR1Command identifier should not be null");
  }

  /** handles delete validation for a ExcAVR1 */
  public void validate(DeleteExcAVR1Command excAVR1) throws Exception {
    Assert.notNull(excAVR1, "{commandAlias} should not be null");
    Assert.notNull(excAVR1.getExcAVR1Id(), "DeleteExcAVR1Command identifier should not be null");
  }

  /** handles fetchOne validation for a ExcAVR1 */
  public void validate(ExcAVR1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcAVR1FetchOneSummary should not be null");
    Assert.notNull(summary.getExcAVR1Id(), "ExcAVR1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign E1 validation for a ExcAVR1
   *
   * @param command AssignE1ToExcAVR1Command
   */
  public void validate(AssignE1ToExcAVR1Command command) throws Exception {
    Assert.notNull(command, "AssignE1ToExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "AssignE1ToExcAVR1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignE1ToExcAVR1Command assignment should not be null");
  }

  /**
   * handles unassign E1 validation for a ExcAVR1
   *
   * @param command UnAssignE1FromExcAVR1Command
   */
  public void validate(UnAssignE1FromExcAVR1Command command) throws Exception {
    Assert.notNull(command, "UnAssignE1FromExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "UnAssignE1FromExcAVR1Command identifier should not be null");
  }
  /**
   * handles assign E2 validation for a ExcAVR1
   *
   * @param command AssignE2ToExcAVR1Command
   */
  public void validate(AssignE2ToExcAVR1Command command) throws Exception {
    Assert.notNull(command, "AssignE2ToExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "AssignE2ToExcAVR1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignE2ToExcAVR1Command assignment should not be null");
  }

  /**
   * handles unassign E2 validation for a ExcAVR1
   *
   * @param command UnAssignE2FromExcAVR1Command
   */
  public void validate(UnAssignE2FromExcAVR1Command command) throws Exception {
    Assert.notNull(command, "UnAssignE2FromExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "UnAssignE2FromExcAVR1Command identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcAVR1
   *
   * @param command AssignKaToExcAVR1Command
   */
  public void validate(AssignKaToExcAVR1Command command) throws Exception {
    Assert.notNull(command, "AssignKaToExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "AssignKaToExcAVR1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcAVR1Command assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcAVR1
   *
   * @param command UnAssignKaFromExcAVR1Command
   */
  public void validate(UnAssignKaFromExcAVR1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "UnAssignKaFromExcAVR1Command identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcAVR1
   *
   * @param command AssignKfToExcAVR1Command
   */
  public void validate(AssignKfToExcAVR1Command command) throws Exception {
    Assert.notNull(command, "AssignKfToExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "AssignKfToExcAVR1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcAVR1Command assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcAVR1
   *
   * @param command UnAssignKfFromExcAVR1Command
   */
  public void validate(UnAssignKfFromExcAVR1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "UnAssignKfFromExcAVR1Command identifier should not be null");
  }
  /**
   * handles assign Se1 validation for a ExcAVR1
   *
   * @param command AssignSe1ToExcAVR1Command
   */
  public void validate(AssignSe1ToExcAVR1Command command) throws Exception {
    Assert.notNull(command, "AssignSe1ToExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "AssignSe1ToExcAVR1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSe1ToExcAVR1Command assignment should not be null");
  }

  /**
   * handles unassign Se1 validation for a ExcAVR1
   *
   * @param command UnAssignSe1FromExcAVR1Command
   */
  public void validate(UnAssignSe1FromExcAVR1Command command) throws Exception {
    Assert.notNull(command, "UnAssignSe1FromExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "UnAssignSe1FromExcAVR1Command identifier should not be null");
  }
  /**
   * handles assign Se2 validation for a ExcAVR1
   *
   * @param command AssignSe2ToExcAVR1Command
   */
  public void validate(AssignSe2ToExcAVR1Command command) throws Exception {
    Assert.notNull(command, "AssignSe2ToExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "AssignSe2ToExcAVR1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSe2ToExcAVR1Command assignment should not be null");
  }

  /**
   * handles unassign Se2 validation for a ExcAVR1
   *
   * @param command UnAssignSe2FromExcAVR1Command
   */
  public void validate(UnAssignSe2FromExcAVR1Command command) throws Exception {
    Assert.notNull(command, "UnAssignSe2FromExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "UnAssignSe2FromExcAVR1Command identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcAVR1
   *
   * @param command AssignTaToExcAVR1Command
   */
  public void validate(AssignTaToExcAVR1Command command) throws Exception {
    Assert.notNull(command, "AssignTaToExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "AssignTaToExcAVR1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcAVR1Command assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcAVR1
   *
   * @param command UnAssignTaFromExcAVR1Command
   */
  public void validate(UnAssignTaFromExcAVR1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "UnAssignTaFromExcAVR1Command identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcAVR1
   *
   * @param command AssignTbToExcAVR1Command
   */
  public void validate(AssignTbToExcAVR1Command command) throws Exception {
    Assert.notNull(command, "AssignTbToExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "AssignTbToExcAVR1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcAVR1Command assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcAVR1
   *
   * @param command UnAssignTbFromExcAVR1Command
   */
  public void validate(UnAssignTbFromExcAVR1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "UnAssignTbFromExcAVR1Command identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcAVR1
   *
   * @param command AssignTeToExcAVR1Command
   */
  public void validate(AssignTeToExcAVR1Command command) throws Exception {
    Assert.notNull(command, "AssignTeToExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "AssignTeToExcAVR1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcAVR1Command assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcAVR1
   *
   * @param command UnAssignTeFromExcAVR1Command
   */
  public void validate(UnAssignTeFromExcAVR1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "UnAssignTeFromExcAVR1Command identifier should not be null");
  }
  /**
   * handles assign Tf validation for a ExcAVR1
   *
   * @param command AssignTfToExcAVR1Command
   */
  public void validate(AssignTfToExcAVR1Command command) throws Exception {
    Assert.notNull(command, "AssignTfToExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "AssignTfToExcAVR1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTfToExcAVR1Command assignment should not be null");
  }

  /**
   * handles unassign Tf validation for a ExcAVR1
   *
   * @param command UnAssignTfFromExcAVR1Command
   */
  public void validate(UnAssignTfFromExcAVR1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTfFromExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "UnAssignTfFromExcAVR1Command identifier should not be null");
  }
  /**
   * handles assign Vrmn validation for a ExcAVR1
   *
   * @param command AssignVrmnToExcAVR1Command
   */
  public void validate(AssignVrmnToExcAVR1Command command) throws Exception {
    Assert.notNull(command, "AssignVrmnToExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "AssignVrmnToExcAVR1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmnToExcAVR1Command assignment should not be null");
  }

  /**
   * handles unassign Vrmn validation for a ExcAVR1
   *
   * @param command UnAssignVrmnFromExcAVR1Command
   */
  public void validate(UnAssignVrmnFromExcAVR1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVrmnFromExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "UnAssignVrmnFromExcAVR1Command identifier should not be null");
  }
  /**
   * handles assign Vrmx validation for a ExcAVR1
   *
   * @param command AssignVrmxToExcAVR1Command
   */
  public void validate(AssignVrmxToExcAVR1Command command) throws Exception {
    Assert.notNull(command, "AssignVrmxToExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "AssignVrmxToExcAVR1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmxToExcAVR1Command assignment should not be null");
  }

  /**
   * handles unassign Vrmx validation for a ExcAVR1
   *
   * @param command UnAssignVrmxFromExcAVR1Command
   */
  public void validate(UnAssignVrmxFromExcAVR1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVrmxFromExcAVR1Command should not be null");
    Assert.notNull(
        command.getExcAVR1Id(), "UnAssignVrmxFromExcAVR1Command identifier should not be null");
  }
}
