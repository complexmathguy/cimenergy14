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

public class ExcPICValidator {

  /** default constructor */
  protected ExcPICValidator() {}

  /** factory method */
  public static ExcPICValidator getInstance() {
    return new ExcPICValidator();
  }

  /** handles creation validation for a ExcPIC */
  public void validate(CreateExcPICCommand excPIC) throws Exception {
    Assert.notNull(excPIC, "CreateExcPICCommand should not be null");
    //		Assert.isNull( excPIC.getExcPICId(), "CreateExcPICCommand identifier should be null" );
  }

  /** handles update validation for a ExcPIC */
  public void validate(UpdateExcPICCommand excPIC) throws Exception {
    Assert.notNull(excPIC, "UpdateExcPICCommand should not be null");
    Assert.notNull(excPIC.getExcPICId(), "UpdateExcPICCommand identifier should not be null");
  }

  /** handles delete validation for a ExcPIC */
  public void validate(DeleteExcPICCommand excPIC) throws Exception {
    Assert.notNull(excPIC, "{commandAlias} should not be null");
    Assert.notNull(excPIC.getExcPICId(), "DeleteExcPICCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcPIC */
  public void validate(ExcPICFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcPICFetchOneSummary should not be null");
    Assert.notNull(summary.getExcPICId(), "ExcPICFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign E1 validation for a ExcPIC
   *
   * @param command AssignE1ToExcPICCommand
   */
  public void validate(AssignE1ToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignE1ToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignE1ToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignE1ToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign E1 validation for a ExcPIC
   *
   * @param command UnAssignE1FromExcPICCommand
   */
  public void validate(UnAssignE1FromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignE1FromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignE1FromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign E2 validation for a ExcPIC
   *
   * @param command AssignE2ToExcPICCommand
   */
  public void validate(AssignE2ToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignE2ToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignE2ToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignE2ToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign E2 validation for a ExcPIC
   *
   * @param command UnAssignE2FromExcPICCommand
   */
  public void validate(UnAssignE2FromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignE2FromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignE2FromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Efdmax validation for a ExcPIC
   *
   * @param command AssignEfdmaxToExcPICCommand
   */
  public void validate(AssignEfdmaxToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignEfdmaxToExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "AssignEfdmaxToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdmaxToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Efdmax validation for a ExcPIC
   *
   * @param command UnAssignEfdmaxFromExcPICCommand
   */
  public void validate(UnAssignEfdmaxFromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdmaxFromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignEfdmaxFromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Efdmin validation for a ExcPIC
   *
   * @param command AssignEfdminToExcPICCommand
   */
  public void validate(AssignEfdminToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignEfdminToExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "AssignEfdminToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignEfdminToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Efdmin validation for a ExcPIC
   *
   * @param command UnAssignEfdminFromExcPICCommand
   */
  public void validate(UnAssignEfdminFromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignEfdminFromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignEfdminFromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Ka validation for a ExcPIC
   *
   * @param command AssignKaToExcPICCommand
   */
  public void validate(AssignKaToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignKaToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignKaToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcPIC
   *
   * @param command UnAssignKaFromExcPICCommand
   */
  public void validate(UnAssignKaFromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignKaFromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Kc validation for a ExcPIC
   *
   * @param command AssignKcToExcPICCommand
   */
  public void validate(AssignKcToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignKcToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcPIC
   *
   * @param command UnAssignKcFromExcPICCommand
   */
  public void validate(UnAssignKcFromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignKcFromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Ke validation for a ExcPIC
   *
   * @param command AssignKeToExcPICCommand
   */
  public void validate(AssignKeToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignKeToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignKeToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKeToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Ke validation for a ExcPIC
   *
   * @param command UnAssignKeFromExcPICCommand
   */
  public void validate(UnAssignKeFromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKeFromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignKeFromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Kf validation for a ExcPIC
   *
   * @param command AssignKfToExcPICCommand
   */
  public void validate(AssignKfToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignKfToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignKfToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKfToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a ExcPIC
   *
   * @param command UnAssignKfFromExcPICCommand
   */
  public void validate(UnAssignKfFromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignKfFromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a ExcPIC
   *
   * @param command AssignKiToExcPICCommand
   */
  public void validate(AssignKiToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignKiToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignKiToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a ExcPIC
   *
   * @param command UnAssignKiFromExcPICCommand
   */
  public void validate(UnAssignKiFromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignKiFromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a ExcPIC
   *
   * @param command AssignKpToExcPICCommand
   */
  public void validate(AssignKpToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignKpToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignKpToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a ExcPIC
   *
   * @param command UnAssignKpFromExcPICCommand
   */
  public void validate(UnAssignKpFromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignKpFromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Se1 validation for a ExcPIC
   *
   * @param command AssignSe1ToExcPICCommand
   */
  public void validate(AssignSe1ToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignSe1ToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignSe1ToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSe1ToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Se1 validation for a ExcPIC
   *
   * @param command UnAssignSe1FromExcPICCommand
   */
  public void validate(UnAssignSe1FromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSe1FromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignSe1FromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Se2 validation for a ExcPIC
   *
   * @param command AssignSe2ToExcPICCommand
   */
  public void validate(AssignSe2ToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignSe2ToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignSe2ToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignSe2ToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Se2 validation for a ExcPIC
   *
   * @param command UnAssignSe2FromExcPICCommand
   */
  public void validate(UnAssignSe2FromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignSe2FromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignSe2FromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Ta1 validation for a ExcPIC
   *
   * @param command AssignTa1ToExcPICCommand
   */
  public void validate(AssignTa1ToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignTa1ToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignTa1ToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTa1ToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Ta1 validation for a ExcPIC
   *
   * @param command UnAssignTa1FromExcPICCommand
   */
  public void validate(UnAssignTa1FromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTa1FromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignTa1FromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Ta2 validation for a ExcPIC
   *
   * @param command AssignTa2ToExcPICCommand
   */
  public void validate(AssignTa2ToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignTa2ToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignTa2ToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTa2ToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Ta2 validation for a ExcPIC
   *
   * @param command UnAssignTa2FromExcPICCommand
   */
  public void validate(UnAssignTa2FromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTa2FromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignTa2FromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Ta3 validation for a ExcPIC
   *
   * @param command AssignTa3ToExcPICCommand
   */
  public void validate(AssignTa3ToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignTa3ToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignTa3ToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTa3ToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Ta3 validation for a ExcPIC
   *
   * @param command UnAssignTa3FromExcPICCommand
   */
  public void validate(UnAssignTa3FromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTa3FromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignTa3FromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Ta4 validation for a ExcPIC
   *
   * @param command AssignTa4ToExcPICCommand
   */
  public void validate(AssignTa4ToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignTa4ToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignTa4ToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTa4ToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Ta4 validation for a ExcPIC
   *
   * @param command UnAssignTa4FromExcPICCommand
   */
  public void validate(UnAssignTa4FromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTa4FromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignTa4FromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Te validation for a ExcPIC
   *
   * @param command AssignTeToExcPICCommand
   */
  public void validate(AssignTeToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignTeToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignTeToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTeToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Te validation for a ExcPIC
   *
   * @param command UnAssignTeFromExcPICCommand
   */
  public void validate(UnAssignTeFromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeFromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignTeFromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Tf1 validation for a ExcPIC
   *
   * @param command AssignTf1ToExcPICCommand
   */
  public void validate(AssignTf1ToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignTf1ToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignTf1ToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf1ToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Tf1 validation for a ExcPIC
   *
   * @param command UnAssignTf1FromExcPICCommand
   */
  public void validate(UnAssignTf1FromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTf1FromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignTf1FromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Tf2 validation for a ExcPIC
   *
   * @param command AssignTf2ToExcPICCommand
   */
  public void validate(AssignTf2ToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignTf2ToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignTf2ToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTf2ToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Tf2 validation for a ExcPIC
   *
   * @param command UnAssignTf2FromExcPICCommand
   */
  public void validate(UnAssignTf2FromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTf2FromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignTf2FromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Vr1 validation for a ExcPIC
   *
   * @param command AssignVr1ToExcPICCommand
   */
  public void validate(AssignVr1ToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignVr1ToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignVr1ToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVr1ToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Vr1 validation for a ExcPIC
   *
   * @param command UnAssignVr1FromExcPICCommand
   */
  public void validate(UnAssignVr1FromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVr1FromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignVr1FromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Vr2 validation for a ExcPIC
   *
   * @param command AssignVr2ToExcPICCommand
   */
  public void validate(AssignVr2ToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignVr2ToExcPICCommand should not be null");
    Assert.notNull(command.getExcPICId(), "AssignVr2ToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVr2ToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Vr2 validation for a ExcPIC
   *
   * @param command UnAssignVr2FromExcPICCommand
   */
  public void validate(UnAssignVr2FromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVr2FromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignVr2FromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcPIC
   *
   * @param command AssignVrmaxToExcPICCommand
   */
  public void validate(AssignVrmaxToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "AssignVrmaxToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcPIC
   *
   * @param command UnAssignVrmaxFromExcPICCommand
   */
  public void validate(UnAssignVrmaxFromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignVrmaxFromExcPICCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcPIC
   *
   * @param command AssignVrminToExcPICCommand
   */
  public void validate(AssignVrminToExcPICCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "AssignVrminToExcPICCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcPICCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcPIC
   *
   * @param command UnAssignVrminFromExcPICCommand
   */
  public void validate(UnAssignVrminFromExcPICCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcPICCommand should not be null");
    Assert.notNull(
        command.getExcPICId(), "UnAssignVrminFromExcPICCommand identifier should not be null");
  }
}
