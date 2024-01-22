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

public class ExcAVR2Validator {

  /** default constructor */
  protected ExcAVR2Validator() {}

  /** factory method */
  public static ExcAVR2Validator getInstance() {
    return new ExcAVR2Validator();
  }

  /** handles creation validation for a ExcAVR2 */
  public void validate(CreateExcAVR2Command excAVR2) throws Exception {
    Assert.notNull(excAVR2, "CreateExcAVR2Command should not be null");
    //		Assert.isNull( excAVR2.getExcAVR2Id(), "CreateExcAVR2Command identifier should be null" );
  }

  /** handles update validation for a ExcAVR2 */
  public void validate(UpdateExcAVR2Command excAVR2) throws Exception {
    Assert.notNull(excAVR2, "UpdateExcAVR2Command should not be null");
    Assert.notNull(excAVR2.getExcAVR2Id(), "UpdateExcAVR2Command identifier should not be null");
  }

  /** handles delete validation for a ExcAVR2 */
  public void validate(DeleteExcAVR2Command excAVR2) throws Exception {
    Assert.notNull(excAVR2, "{commandAlias} should not be null");
    Assert.notNull(excAVR2.getExcAVR2Id(), "DeleteExcAVR2Command identifier should not be null");
  }

  /** handles fetchOne validation for a ExcAVR2 */
  public void validate(ExcAVR2FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcAVR2FetchOneSummary should not be null");
    Assert.notNull(summary.getExcAVR2Id(), "ExcAVR2FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign E1 validation for a ExcAVR2
   *
   * @param command AssignE1ToExcAVR2Command
   */
  public void validate(AssignE1ToExcAVR2Command command) throws Exception {
    Assert.notNull(command, "AssignE1ToExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "AssignE1ToExcAVR2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignE1ToExcAVR2Command assignment should not be null");
  }

  /**
   * handles unassign E1 validation for a ExcAVR2
   *
   * @param command UnAssignE1FromExcAVR2Command
   */
  public void validate(UnAssignE1FromExcAVR2Command command) throws Exception {
    Assert.notNull(command, "UnAssignE1FromExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "UnAssignE1FromExcAVR2Command identifier should not be null");
  }
  /**
   * handles assign E2 validation for a ExcAVR2
   *
   * @param command AssignE2ToExcAVR2Command
   */
  public void validate(AssignE2ToExcAVR2Command command) throws Exception {
    Assert.notNull(command, "AssignE2ToExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "AssignE2ToExcAVR2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignE2ToExcAVR2Command assignment should not be null");
  }

  /**
   * handles unassign E2 validation for a ExcAVR2
   *
   * @param command UnAssignE2FromExcAVR2Command
   */
  public void validate(UnAssignE2FromExcAVR2Command command) throws Exception {
    Assert.notNull(command, "UnAssignE2FromExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "UnAssignE2FromExcAVR2Command identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcAVR2
   *
   * @param command AssignKaToExcAVR2Command
   */
  public void validate(AssignKaToExcAVR2Command command) throws Exception {
    Assert.notNull(command, "AssignKaToExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "AssignKaToExcAVR2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcAVR2Command assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcAVR2
   *
   * @param command UnAssignKaFromExcAVR2Command
   */
  public void validate(UnAssignKaFromExcAVR2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "UnAssignKaFromExcAVR2Command identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcAVR2
   *
   * @param command AssignKfToExcAVR2Command
   */
  public void validate(AssignKfToExcAVR2Command command) throws Exception {
    Assert.notNull(command, "AssignKfToExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "AssignKfToExcAVR2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcAVR2Command assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcAVR2
   *
   * @param command UnAssignKfFromExcAVR2Command
   */
  public void validate(UnAssignKfFromExcAVR2Command command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "UnAssignKfFromExcAVR2Command identifier should not be null");
  }
  /**
   * handles assign Se1 validation for a ExcAVR2
   *
   * @param command AssignSe1ToExcAVR2Command
   */
  public void validate(AssignSe1ToExcAVR2Command command) throws Exception {
    Assert.notNull(command, "AssignSe1ToExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "AssignSe1ToExcAVR2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSe1ToExcAVR2Command assignment should not be null");
  }

  /**
   * handles unassign Se1 validation for a ExcAVR2
   *
   * @param command UnAssignSe1FromExcAVR2Command
   */
  public void validate(UnAssignSe1FromExcAVR2Command command) throws Exception {
    Assert.notNull(command, "UnAssignSe1FromExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "UnAssignSe1FromExcAVR2Command identifier should not be null");
  }
  /**
   * handles assign Se2 validation for a ExcAVR2
   *
   * @param command AssignSe2ToExcAVR2Command
   */
  public void validate(AssignSe2ToExcAVR2Command command) throws Exception {
    Assert.notNull(command, "AssignSe2ToExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "AssignSe2ToExcAVR2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSe2ToExcAVR2Command assignment should not be null");
  }

  /**
   * handles unassign Se2 validation for a ExcAVR2
   *
   * @param command UnAssignSe2FromExcAVR2Command
   */
  public void validate(UnAssignSe2FromExcAVR2Command command) throws Exception {
    Assert.notNull(command, "UnAssignSe2FromExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "UnAssignSe2FromExcAVR2Command identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcAVR2
   *
   * @param command AssignTaToExcAVR2Command
   */
  public void validate(AssignTaToExcAVR2Command command) throws Exception {
    Assert.notNull(command, "AssignTaToExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "AssignTaToExcAVR2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcAVR2Command assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcAVR2
   *
   * @param command UnAssignTaFromExcAVR2Command
   */
  public void validate(UnAssignTaFromExcAVR2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "UnAssignTaFromExcAVR2Command identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcAVR2
   *
   * @param command AssignTbToExcAVR2Command
   */
  public void validate(AssignTbToExcAVR2Command command) throws Exception {
    Assert.notNull(command, "AssignTbToExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "AssignTbToExcAVR2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcAVR2Command assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcAVR2
   *
   * @param command UnAssignTbFromExcAVR2Command
   */
  public void validate(UnAssignTbFromExcAVR2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "UnAssignTbFromExcAVR2Command identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcAVR2
   *
   * @param command AssignTeToExcAVR2Command
   */
  public void validate(AssignTeToExcAVR2Command command) throws Exception {
    Assert.notNull(command, "AssignTeToExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "AssignTeToExcAVR2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcAVR2Command assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcAVR2
   *
   * @param command UnAssignTeFromExcAVR2Command
   */
  public void validate(UnAssignTeFromExcAVR2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "UnAssignTeFromExcAVR2Command identifier should not be null");
  }
  /**
   * handles assign Tf1 validation for a ExcAVR2
   *
   * @param command AssignTf1ToExcAVR2Command
   */
  public void validate(AssignTf1ToExcAVR2Command command) throws Exception {
    Assert.notNull(command, "AssignTf1ToExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "AssignTf1ToExcAVR2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf1ToExcAVR2Command assignment should not be null");
  }

  /**
   * handles unassign Tf1 validation for a ExcAVR2
   *
   * @param command UnAssignTf1FromExcAVR2Command
   */
  public void validate(UnAssignTf1FromExcAVR2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTf1FromExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "UnAssignTf1FromExcAVR2Command identifier should not be null");
  }
  /**
   * handles assign Tf2 validation for a ExcAVR2
   *
   * @param command AssignTf2ToExcAVR2Command
   */
  public void validate(AssignTf2ToExcAVR2Command command) throws Exception {
    Assert.notNull(command, "AssignTf2ToExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "AssignTf2ToExcAVR2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf2ToExcAVR2Command assignment should not be null");
  }

  /**
   * handles unassign Tf2 validation for a ExcAVR2
   *
   * @param command UnAssignTf2FromExcAVR2Command
   */
  public void validate(UnAssignTf2FromExcAVR2Command command) throws Exception {
    Assert.notNull(command, "UnAssignTf2FromExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "UnAssignTf2FromExcAVR2Command identifier should not be null");
  }
  /**
   * handles assign Vrmn validation for a ExcAVR2
   *
   * @param command AssignVrmnToExcAVR2Command
   */
  public void validate(AssignVrmnToExcAVR2Command command) throws Exception {
    Assert.notNull(command, "AssignVrmnToExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "AssignVrmnToExcAVR2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmnToExcAVR2Command assignment should not be null");
  }

  /**
   * handles unassign Vrmn validation for a ExcAVR2
   *
   * @param command UnAssignVrmnFromExcAVR2Command
   */
  public void validate(UnAssignVrmnFromExcAVR2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVrmnFromExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "UnAssignVrmnFromExcAVR2Command identifier should not be null");
  }
  /**
   * handles assign Vrmx validation for a ExcAVR2
   *
   * @param command AssignVrmxToExcAVR2Command
   */
  public void validate(AssignVrmxToExcAVR2Command command) throws Exception {
    Assert.notNull(command, "AssignVrmxToExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "AssignVrmxToExcAVR2Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmxToExcAVR2Command assignment should not be null");
  }

  /**
   * handles unassign Vrmx validation for a ExcAVR2
   *
   * @param command UnAssignVrmxFromExcAVR2Command
   */
  public void validate(UnAssignVrmxFromExcAVR2Command command) throws Exception {
    Assert.notNull(command, "UnAssignVrmxFromExcAVR2Command should not be null");
    Assert.notNull(
        command.getExcAVR2Id(), "UnAssignVrmxFromExcAVR2Command identifier should not be null");
  }
}
