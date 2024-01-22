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

public class ExcAVR4Validator {

  /** default constructor */
  protected ExcAVR4Validator() {}

  /** factory method */
  public static ExcAVR4Validator getInstance() {
    return new ExcAVR4Validator();
  }

  /** handles creation validation for a ExcAVR4 */
  public void validate(CreateExcAVR4Command excAVR4) throws Exception {
    Assert.notNull(excAVR4, "CreateExcAVR4Command should not be null");
    //		Assert.isNull( excAVR4.getExcAVR4Id(), "CreateExcAVR4Command identifier should be null" );
  }

  /** handles update validation for a ExcAVR4 */
  public void validate(UpdateExcAVR4Command excAVR4) throws Exception {
    Assert.notNull(excAVR4, "UpdateExcAVR4Command should not be null");
    Assert.notNull(excAVR4.getExcAVR4Id(), "UpdateExcAVR4Command identifier should not be null");
  }

  /** handles delete validation for a ExcAVR4 */
  public void validate(DeleteExcAVR4Command excAVR4) throws Exception {
    Assert.notNull(excAVR4, "{commandAlias} should not be null");
    Assert.notNull(excAVR4.getExcAVR4Id(), "DeleteExcAVR4Command identifier should not be null");
  }

  /** handles fetchOne validation for a ExcAVR4 */
  public void validate(ExcAVR4FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcAVR4FetchOneSummary should not be null");
    Assert.notNull(summary.getExcAVR4Id(), "ExcAVR4FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Imul validation for a ExcAVR4
   *
   * @param command AssignImulToExcAVR4Command
   */
  public void validate(AssignImulToExcAVR4Command command) throws Exception {
    Assert.notNull(command, "AssignImulToExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "AssignImulToExcAVR4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignImulToExcAVR4Command assignment should not be null");
  }

  /**
   * handles unassign Imul validation for a ExcAVR4
   *
   * @param command UnAssignImulFromExcAVR4Command
   */
  public void validate(UnAssignImulFromExcAVR4Command command) throws Exception {
    Assert.notNull(command, "UnAssignImulFromExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "UnAssignImulFromExcAVR4Command identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcAVR4
   *
   * @param command AssignKaToExcAVR4Command
   */
  public void validate(AssignKaToExcAVR4Command command) throws Exception {
    Assert.notNull(command, "AssignKaToExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "AssignKaToExcAVR4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcAVR4Command assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcAVR4
   *
   * @param command UnAssignKaFromExcAVR4Command
   */
  public void validate(UnAssignKaFromExcAVR4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "UnAssignKaFromExcAVR4Command identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcAVR4
   *
   * @param command AssignKeToExcAVR4Command
   */
  public void validate(AssignKeToExcAVR4Command command) throws Exception {
    Assert.notNull(command, "AssignKeToExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "AssignKeToExcAVR4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcAVR4Command assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcAVR4
   *
   * @param command UnAssignKeFromExcAVR4Command
   */
  public void validate(UnAssignKeFromExcAVR4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "UnAssignKeFromExcAVR4Command identifier should not be null");
  }
  /**
   * handles assign Kif validation for a ExcAVR4
   *
   * @param command AssignKifToExcAVR4Command
   */
  public void validate(AssignKifToExcAVR4Command command) throws Exception {
    Assert.notNull(command, "AssignKifToExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "AssignKifToExcAVR4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKifToExcAVR4Command assignment should not be null");
  }

  /**
   * handles unassign Kif validation for a ExcAVR4
   *
   * @param command UnAssignKifFromExcAVR4Command
   */
  public void validate(UnAssignKifFromExcAVR4Command command) throws Exception {
    Assert.notNull(command, "UnAssignKifFromExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "UnAssignKifFromExcAVR4Command identifier should not be null");
  }
  /**
   * handles assign T1 validation for a ExcAVR4
   *
   * @param command AssignT1ToExcAVR4Command
   */
  public void validate(AssignT1ToExcAVR4Command command) throws Exception {
    Assert.notNull(command, "AssignT1ToExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "AssignT1ToExcAVR4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToExcAVR4Command assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a ExcAVR4
   *
   * @param command UnAssignT1FromExcAVR4Command
   */
  public void validate(UnAssignT1FromExcAVR4Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "UnAssignT1FromExcAVR4Command identifier should not be null");
  }
  /**
   * handles assign T1if validation for a ExcAVR4
   *
   * @param command AssignT1ifToExcAVR4Command
   */
  public void validate(AssignT1ifToExcAVR4Command command) throws Exception {
    Assert.notNull(command, "AssignT1ifToExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "AssignT1ifToExcAVR4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ifToExcAVR4Command assignment should not be null");
  }

  /**
   * handles unassign T1if validation for a ExcAVR4
   *
   * @param command UnAssignT1ifFromExcAVR4Command
   */
  public void validate(UnAssignT1ifFromExcAVR4Command command) throws Exception {
    Assert.notNull(command, "UnAssignT1ifFromExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "UnAssignT1ifFromExcAVR4Command identifier should not be null");
  }
  /**
   * handles assign T2 validation for a ExcAVR4
   *
   * @param command AssignT2ToExcAVR4Command
   */
  public void validate(AssignT2ToExcAVR4Command command) throws Exception {
    Assert.notNull(command, "AssignT2ToExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "AssignT2ToExcAVR4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToExcAVR4Command assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a ExcAVR4
   *
   * @param command UnAssignT2FromExcAVR4Command
   */
  public void validate(UnAssignT2FromExcAVR4Command command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "UnAssignT2FromExcAVR4Command identifier should not be null");
  }
  /**
   * handles assign T3 validation for a ExcAVR4
   *
   * @param command AssignT3ToExcAVR4Command
   */
  public void validate(AssignT3ToExcAVR4Command command) throws Exception {
    Assert.notNull(command, "AssignT3ToExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "AssignT3ToExcAVR4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToExcAVR4Command assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a ExcAVR4
   *
   * @param command UnAssignT3FromExcAVR4Command
   */
  public void validate(UnAssignT3FromExcAVR4Command command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "UnAssignT3FromExcAVR4Command identifier should not be null");
  }
  /**
   * handles assign T4 validation for a ExcAVR4
   *
   * @param command AssignT4ToExcAVR4Command
   */
  public void validate(AssignT4ToExcAVR4Command command) throws Exception {
    Assert.notNull(command, "AssignT4ToExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "AssignT4ToExcAVR4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4ToExcAVR4Command assignment should not be null");
  }

  /**
   * handles unassign T4 validation for a ExcAVR4
   *
   * @param command UnAssignT4FromExcAVR4Command
   */
  public void validate(UnAssignT4FromExcAVR4Command command) throws Exception {
    Assert.notNull(command, "UnAssignT4FromExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "UnAssignT4FromExcAVR4Command identifier should not be null");
  }
  /**
   * handles assign Tif validation for a ExcAVR4
   *
   * @param command AssignTifToExcAVR4Command
   */
  public void validate(AssignTifToExcAVR4Command command) throws Exception {
    Assert.notNull(command, "AssignTifToExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "AssignTifToExcAVR4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTifToExcAVR4Command assignment should not be null");
  }

  /**
   * handles unassign Tif validation for a ExcAVR4
   *
   * @param command UnAssignTifFromExcAVR4Command
   */
  public void validate(UnAssignTifFromExcAVR4Command command) throws Exception {
    Assert.notNull(command, "UnAssignTifFromExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "UnAssignTifFromExcAVR4Command identifier should not be null");
  }
  /**
   * handles assign Vfmn validation for a ExcAVR4
   *
   * @param command AssignVfmnToExcAVR4Command
   */
  public void validate(AssignVfmnToExcAVR4Command command) throws Exception {
    Assert.notNull(command, "AssignVfmnToExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "AssignVfmnToExcAVR4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVfmnToExcAVR4Command assignment should not be null");
  }

  /**
   * handles unassign Vfmn validation for a ExcAVR4
   *
   * @param command UnAssignVfmnFromExcAVR4Command
   */
  public void validate(UnAssignVfmnFromExcAVR4Command command) throws Exception {
    Assert.notNull(command, "UnAssignVfmnFromExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "UnAssignVfmnFromExcAVR4Command identifier should not be null");
  }
  /**
   * handles assign Vfmx validation for a ExcAVR4
   *
   * @param command AssignVfmxToExcAVR4Command
   */
  public void validate(AssignVfmxToExcAVR4Command command) throws Exception {
    Assert.notNull(command, "AssignVfmxToExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "AssignVfmxToExcAVR4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVfmxToExcAVR4Command assignment should not be null");
  }

  /**
   * handles unassign Vfmx validation for a ExcAVR4
   *
   * @param command UnAssignVfmxFromExcAVR4Command
   */
  public void validate(UnAssignVfmxFromExcAVR4Command command) throws Exception {
    Assert.notNull(command, "UnAssignVfmxFromExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "UnAssignVfmxFromExcAVR4Command identifier should not be null");
  }
  /**
   * handles assign Vrmn validation for a ExcAVR4
   *
   * @param command AssignVrmnToExcAVR4Command
   */
  public void validate(AssignVrmnToExcAVR4Command command) throws Exception {
    Assert.notNull(command, "AssignVrmnToExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "AssignVrmnToExcAVR4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmnToExcAVR4Command assignment should not be null");
  }

  /**
   * handles unassign Vrmn validation for a ExcAVR4
   *
   * @param command UnAssignVrmnFromExcAVR4Command
   */
  public void validate(UnAssignVrmnFromExcAVR4Command command) throws Exception {
    Assert.notNull(command, "UnAssignVrmnFromExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "UnAssignVrmnFromExcAVR4Command identifier should not be null");
  }
  /**
   * handles assign Vrmx validation for a ExcAVR4
   *
   * @param command AssignVrmxToExcAVR4Command
   */
  public void validate(AssignVrmxToExcAVR4Command command) throws Exception {
    Assert.notNull(command, "AssignVrmxToExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "AssignVrmxToExcAVR4Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmxToExcAVR4Command assignment should not be null");
  }

  /**
   * handles unassign Vrmx validation for a ExcAVR4
   *
   * @param command UnAssignVrmxFromExcAVR4Command
   */
  public void validate(UnAssignVrmxFromExcAVR4Command command) throws Exception {
    Assert.notNull(command, "UnAssignVrmxFromExcAVR4Command should not be null");
    Assert.notNull(
        command.getExcAVR4Id(), "UnAssignVrmxFromExcAVR4Command identifier should not be null");
  }
}
