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

public class GovSteamCCValidator {

  /** default constructor */
  protected GovSteamCCValidator() {}

  /** factory method */
  public static GovSteamCCValidator getInstance() {
    return new GovSteamCCValidator();
  }

  /** handles creation validation for a GovSteamCC */
  public void validate(CreateGovSteamCCCommand govSteamCC) throws Exception {
    Assert.notNull(govSteamCC, "CreateGovSteamCCCommand should not be null");
    //		Assert.isNull( govSteamCC.getGovSteamCCId(), "CreateGovSteamCCCommand identifier should be
    // null" );
  }

  /** handles update validation for a GovSteamCC */
  public void validate(UpdateGovSteamCCCommand govSteamCC) throws Exception {
    Assert.notNull(govSteamCC, "UpdateGovSteamCCCommand should not be null");
    Assert.notNull(
        govSteamCC.getGovSteamCCId(), "UpdateGovSteamCCCommand identifier should not be null");
  }

  /** handles delete validation for a GovSteamCC */
  public void validate(DeleteGovSteamCCCommand govSteamCC) throws Exception {
    Assert.notNull(govSteamCC, "{commandAlias} should not be null");
    Assert.notNull(
        govSteamCC.getGovSteamCCId(), "DeleteGovSteamCCCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GovSteamCC */
  public void validate(GovSteamCCFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovSteamCCFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovSteamCCId(), "GovSteamCCFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Dhp validation for a GovSteamCC
   *
   * @param command AssignDhpToGovSteamCCCommand
   */
  public void validate(AssignDhpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignDhpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignDhpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDhpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign Dhp validation for a GovSteamCC
   *
   * @param command UnAssignDhpFromGovSteamCCCommand
   */
  public void validate(UnAssignDhpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDhpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignDhpFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign Dlp validation for a GovSteamCC
   *
   * @param command AssignDlpToGovSteamCCCommand
   */
  public void validate(AssignDlpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignDlpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignDlpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDlpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign Dlp validation for a GovSteamCC
   *
   * @param command UnAssignDlpFromGovSteamCCCommand
   */
  public void validate(UnAssignDlpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDlpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignDlpFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign Fhp validation for a GovSteamCC
   *
   * @param command AssignFhpToGovSteamCCCommand
   */
  public void validate(AssignFhpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignFhpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignFhpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFhpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign Fhp validation for a GovSteamCC
   *
   * @param command UnAssignFhpFromGovSteamCCCommand
   */
  public void validate(UnAssignFhpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFhpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignFhpFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign Flp validation for a GovSteamCC
   *
   * @param command AssignFlpToGovSteamCCCommand
   */
  public void validate(AssignFlpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignFlpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignFlpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFlpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign Flp validation for a GovSteamCC
   *
   * @param command UnAssignFlpFromGovSteamCCCommand
   */
  public void validate(UnAssignFlpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFlpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignFlpFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovSteamCC
   *
   * @param command AssignMwbaseToGovSteamCCCommand
   */
  public void validate(AssignMwbaseToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignMwbaseToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovSteamCC
   *
   * @param command UnAssignMwbaseFromGovSteamCCCommand
   */
  public void validate(UnAssignMwbaseFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignMwbaseFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign Pmaxhp validation for a GovSteamCC
   *
   * @param command AssignPmaxhpToGovSteamCCCommand
   */
  public void validate(AssignPmaxhpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignPmaxhpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignPmaxhpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxhpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign Pmaxhp validation for a GovSteamCC
   *
   * @param command UnAssignPmaxhpFromGovSteamCCCommand
   */
  public void validate(UnAssignPmaxhpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxhpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignPmaxhpFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign Pmaxlp validation for a GovSteamCC
   *
   * @param command AssignPmaxlpToGovSteamCCCommand
   */
  public void validate(AssignPmaxlpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignPmaxlpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignPmaxlpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmaxlpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign Pmaxlp validation for a GovSteamCC
   *
   * @param command UnAssignPmaxlpFromGovSteamCCCommand
   */
  public void validate(UnAssignPmaxlpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmaxlpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignPmaxlpFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign Rhp validation for a GovSteamCC
   *
   * @param command AssignRhpToGovSteamCCCommand
   */
  public void validate(AssignRhpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignRhpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignRhpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRhpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign Rhp validation for a GovSteamCC
   *
   * @param command UnAssignRhpFromGovSteamCCCommand
   */
  public void validate(UnAssignRhpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRhpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignRhpFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign Rlp validation for a GovSteamCC
   *
   * @param command AssignRlpToGovSteamCCCommand
   */
  public void validate(AssignRlpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignRlpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignRlpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRlpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign Rlp validation for a GovSteamCC
   *
   * @param command UnAssignRlpFromGovSteamCCCommand
   */
  public void validate(UnAssignRlpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRlpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignRlpFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign T1hp validation for a GovSteamCC
   *
   * @param command AssignT1hpToGovSteamCCCommand
   */
  public void validate(AssignT1hpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignT1hpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignT1hpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1hpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign T1hp validation for a GovSteamCC
   *
   * @param command UnAssignT1hpFromGovSteamCCCommand
   */
  public void validate(UnAssignT1hpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1hpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignT1hpFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign T1lp validation for a GovSteamCC
   *
   * @param command AssignT1lpToGovSteamCCCommand
   */
  public void validate(AssignT1lpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignT1lpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignT1lpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1lpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign T1lp validation for a GovSteamCC
   *
   * @param command UnAssignT1lpFromGovSteamCCCommand
   */
  public void validate(UnAssignT1lpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1lpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignT1lpFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign T3hp validation for a GovSteamCC
   *
   * @param command AssignT3hpToGovSteamCCCommand
   */
  public void validate(AssignT3hpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignT3hpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignT3hpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3hpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign T3hp validation for a GovSteamCC
   *
   * @param command UnAssignT3hpFromGovSteamCCCommand
   */
  public void validate(UnAssignT3hpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3hpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignT3hpFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign T3lp validation for a GovSteamCC
   *
   * @param command AssignT3lpToGovSteamCCCommand
   */
  public void validate(AssignT3lpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignT3lpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignT3lpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT3lpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign T3lp validation for a GovSteamCC
   *
   * @param command UnAssignT3lpFromGovSteamCCCommand
   */
  public void validate(UnAssignT3lpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT3lpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignT3lpFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign T4hp validation for a GovSteamCC
   *
   * @param command AssignT4hpToGovSteamCCCommand
   */
  public void validate(AssignT4hpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignT4hpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignT4hpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4hpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign T4hp validation for a GovSteamCC
   *
   * @param command UnAssignT4hpFromGovSteamCCCommand
   */
  public void validate(UnAssignT4hpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT4hpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignT4hpFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign T4lp validation for a GovSteamCC
   *
   * @param command AssignT4lpToGovSteamCCCommand
   */
  public void validate(AssignT4lpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignT4lpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignT4lpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT4lpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign T4lp validation for a GovSteamCC
   *
   * @param command UnAssignT4lpFromGovSteamCCCommand
   */
  public void validate(UnAssignT4lpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT4lpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignT4lpFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign T5hp validation for a GovSteamCC
   *
   * @param command AssignT5hpToGovSteamCCCommand
   */
  public void validate(AssignT5hpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignT5hpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignT5hpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5hpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign T5hp validation for a GovSteamCC
   *
   * @param command UnAssignT5hpFromGovSteamCCCommand
   */
  public void validate(UnAssignT5hpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT5hpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignT5hpFromGovSteamCCCommand identifier should not be null");
  }
  /**
   * handles assign T5lp validation for a GovSteamCC
   *
   * @param command AssignT5lpToGovSteamCCCommand
   */
  public void validate(AssignT5lpToGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "AssignT5lpToGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(), "AssignT5lpToGovSteamCCCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT5lpToGovSteamCCCommand assignment should not be null");
  }

  /**
   * handles unassign T5lp validation for a GovSteamCC
   *
   * @param command UnAssignT5lpFromGovSteamCCCommand
   */
  public void validate(UnAssignT5lpFromGovSteamCCCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT5lpFromGovSteamCCCommand should not be null");
    Assert.notNull(
        command.getGovSteamCCId(),
        "UnAssignT5lpFromGovSteamCCCommand identifier should not be null");
  }
}
