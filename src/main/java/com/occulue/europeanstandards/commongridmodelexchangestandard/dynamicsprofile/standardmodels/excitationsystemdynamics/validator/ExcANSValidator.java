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

public class ExcANSValidator {

  /** default constructor */
  protected ExcANSValidator() {}

  /** factory method */
  public static ExcANSValidator getInstance() {
    return new ExcANSValidator();
  }

  /** handles creation validation for a ExcANS */
  public void validate(CreateExcANSCommand excANS) throws Exception {
    Assert.notNull(excANS, "CreateExcANSCommand should not be null");
    //		Assert.isNull( excANS.getExcANSId(), "CreateExcANSCommand identifier should be null" );
  }

  /** handles update validation for a ExcANS */
  public void validate(UpdateExcANSCommand excANS) throws Exception {
    Assert.notNull(excANS, "UpdateExcANSCommand should not be null");
    Assert.notNull(excANS.getExcANSId(), "UpdateExcANSCommand identifier should not be null");
  }

  /** handles delete validation for a ExcANS */
  public void validate(DeleteExcANSCommand excANS) throws Exception {
    Assert.notNull(excANS, "{commandAlias} should not be null");
    Assert.notNull(excANS.getExcANSId(), "DeleteExcANSCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcANS */
  public void validate(ExcANSFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcANSFetchOneSummary should not be null");
    Assert.notNull(summary.getExcANSId(), "ExcANSFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Blint validation for a ExcANS
   *
   * @param command AssignBlintToExcANSCommand
   */
  public void validate(AssignBlintToExcANSCommand command) throws Exception {
    Assert.notNull(command, "AssignBlintToExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "AssignBlintToExcANSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignBlintToExcANSCommand assignment should not be null");
  }

  /**
   * handles unassign Blint validation for a ExcANS
   *
   * @param command UnAssignBlintFromExcANSCommand
   */
  public void validate(UnAssignBlintFromExcANSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignBlintFromExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "UnAssignBlintFromExcANSCommand identifier should not be null");
  }
  /**
   * handles assign Ifmn validation for a ExcANS
   *
   * @param command AssignIfmnToExcANSCommand
   */
  public void validate(AssignIfmnToExcANSCommand command) throws Exception {
    Assert.notNull(command, "AssignIfmnToExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "AssignIfmnToExcANSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIfmnToExcANSCommand assignment should not be null");
  }

  /**
   * handles unassign Ifmn validation for a ExcANS
   *
   * @param command UnAssignIfmnFromExcANSCommand
   */
  public void validate(UnAssignIfmnFromExcANSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignIfmnFromExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "UnAssignIfmnFromExcANSCommand identifier should not be null");
  }
  /**
   * handles assign Ifmx validation for a ExcANS
   *
   * @param command AssignIfmxToExcANSCommand
   */
  public void validate(AssignIfmxToExcANSCommand command) throws Exception {
    Assert.notNull(command, "AssignIfmxToExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "AssignIfmxToExcANSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIfmxToExcANSCommand assignment should not be null");
  }

  /**
   * handles unassign Ifmx validation for a ExcANS
   *
   * @param command UnAssignIfmxFromExcANSCommand
   */
  public void validate(UnAssignIfmxFromExcANSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignIfmxFromExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "UnAssignIfmxFromExcANSCommand identifier should not be null");
  }
  /**
   * handles assign K2 validation for a ExcANS
   *
   * @param command AssignK2ToExcANSCommand
   */
  public void validate(AssignK2ToExcANSCommand command) throws Exception {
    Assert.notNull(command, "AssignK2ToExcANSCommand should not be null");
    Assert.notNull(command.getExcANSId(), "AssignK2ToExcANSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK2ToExcANSCommand assignment should not be null");
  }

  /**
   * handles unassign K2 validation for a ExcANS
   *
   * @param command UnAssignK2FromExcANSCommand
   */
  public void validate(UnAssignK2FromExcANSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK2FromExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "UnAssignK2FromExcANSCommand identifier should not be null");
  }
  /**
   * handles assign K3 validation for a ExcANS
   *
   * @param command AssignK3ToExcANSCommand
   */
  public void validate(AssignK3ToExcANSCommand command) throws Exception {
    Assert.notNull(command, "AssignK3ToExcANSCommand should not be null");
    Assert.notNull(command.getExcANSId(), "AssignK3ToExcANSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignK3ToExcANSCommand assignment should not be null");
  }

  /**
   * handles unassign K3 validation for a ExcANS
   *
   * @param command UnAssignK3FromExcANSCommand
   */
  public void validate(UnAssignK3FromExcANSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignK3FromExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "UnAssignK3FromExcANSCommand identifier should not be null");
  }
  /**
   * handles assign Kce validation for a ExcANS
   *
   * @param command AssignKceToExcANSCommand
   */
  public void validate(AssignKceToExcANSCommand command) throws Exception {
    Assert.notNull(command, "AssignKceToExcANSCommand should not be null");
    Assert.notNull(command.getExcANSId(), "AssignKceToExcANSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKceToExcANSCommand assignment should not be null");
  }

  /**
   * handles unassign Kce validation for a ExcANS
   *
   * @param command UnAssignKceFromExcANSCommand
   */
  public void validate(UnAssignKceFromExcANSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKceFromExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "UnAssignKceFromExcANSCommand identifier should not be null");
  }
  /**
   * handles assign Krvecc validation for a ExcANS
   *
   * @param command AssignKrveccToExcANSCommand
   */
  public void validate(AssignKrveccToExcANSCommand command) throws Exception {
    Assert.notNull(command, "AssignKrveccToExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "AssignKrveccToExcANSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKrveccToExcANSCommand assignment should not be null");
  }

  /**
   * handles unassign Krvecc validation for a ExcANS
   *
   * @param command UnAssignKrveccFromExcANSCommand
   */
  public void validate(UnAssignKrveccFromExcANSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKrveccFromExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "UnAssignKrveccFromExcANSCommand identifier should not be null");
  }
  /**
   * handles assign Kvfif validation for a ExcANS
   *
   * @param command AssignKvfifToExcANSCommand
   */
  public void validate(AssignKvfifToExcANSCommand command) throws Exception {
    Assert.notNull(command, "AssignKvfifToExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "AssignKvfifToExcANSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKvfifToExcANSCommand assignment should not be null");
  }

  /**
   * handles unassign Kvfif validation for a ExcANS
   *
   * @param command UnAssignKvfifFromExcANSCommand
   */
  public void validate(UnAssignKvfifFromExcANSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKvfifFromExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "UnAssignKvfifFromExcANSCommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a ExcANS
   *
   * @param command AssignT1ToExcANSCommand
   */
  public void validate(AssignT1ToExcANSCommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToExcANSCommand should not be null");
    Assert.notNull(command.getExcANSId(), "AssignT1ToExcANSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToExcANSCommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a ExcANS
   *
   * @param command UnAssignT1FromExcANSCommand
   */
  public void validate(UnAssignT1FromExcANSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "UnAssignT1FromExcANSCommand identifier should not be null");
  }
  /**
   * handles assign T2 validation for a ExcANS
   *
   * @param command AssignT2ToExcANSCommand
   */
  public void validate(AssignT2ToExcANSCommand command) throws Exception {
    Assert.notNull(command, "AssignT2ToExcANSCommand should not be null");
    Assert.notNull(command.getExcANSId(), "AssignT2ToExcANSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT2ToExcANSCommand assignment should not be null");
  }

  /**
   * handles unassign T2 validation for a ExcANS
   *
   * @param command UnAssignT2FromExcANSCommand
   */
  public void validate(UnAssignT2FromExcANSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT2FromExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "UnAssignT2FromExcANSCommand identifier should not be null");
  }
  /**
   * handles assign T3 validation for a ExcANS
   *
   * @param command AssignT3ToExcANSCommand
   */
  public void validate(AssignT3ToExcANSCommand command) throws Exception {
    Assert.notNull(command, "AssignT3ToExcANSCommand should not be null");
    Assert.notNull(command.getExcANSId(), "AssignT3ToExcANSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3ToExcANSCommand assignment should not be null");
  }

  /**
   * handles unassign T3 validation for a ExcANS
   *
   * @param command UnAssignT3FromExcANSCommand
   */
  public void validate(UnAssignT3FromExcANSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3FromExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "UnAssignT3FromExcANSCommand identifier should not be null");
  }
  /**
   * handles assign Tb validation for a ExcANS
   *
   * @param command AssignTbToExcANSCommand
   */
  public void validate(AssignTbToExcANSCommand command) throws Exception {
    Assert.notNull(command, "AssignTbToExcANSCommand should not be null");
    Assert.notNull(command.getExcANSId(), "AssignTbToExcANSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTbToExcANSCommand assignment should not be null");
  }

  /**
   * handles unassign Tb validation for a ExcANS
   *
   * @param command UnAssignTbFromExcANSCommand
   */
  public void validate(UnAssignTbFromExcANSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTbFromExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "UnAssignTbFromExcANSCommand identifier should not be null");
  }
  /**
   * handles assign Vrmn validation for a ExcANS
   *
   * @param command AssignVrmnToExcANSCommand
   */
  public void validate(AssignVrmnToExcANSCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmnToExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "AssignVrmnToExcANSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmnToExcANSCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmn validation for a ExcANS
   *
   * @param command UnAssignVrmnFromExcANSCommand
   */
  public void validate(UnAssignVrmnFromExcANSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmnFromExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "UnAssignVrmnFromExcANSCommand identifier should not be null");
  }
  /**
   * handles assign Vrmx validation for a ExcANS
   *
   * @param command AssignVrmxToExcANSCommand
   */
  public void validate(AssignVrmxToExcANSCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmxToExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "AssignVrmxToExcANSCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmxToExcANSCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmx validation for a ExcANS
   *
   * @param command UnAssignVrmxFromExcANSCommand
   */
  public void validate(UnAssignVrmxFromExcANSCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmxFromExcANSCommand should not be null");
    Assert.notNull(
        command.getExcANSId(), "UnAssignVrmxFromExcANSCommand identifier should not be null");
  }
}
