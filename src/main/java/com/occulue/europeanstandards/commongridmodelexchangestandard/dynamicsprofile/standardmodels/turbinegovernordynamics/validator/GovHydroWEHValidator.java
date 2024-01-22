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

public class GovHydroWEHValidator {

  /** default constructor */
  protected GovHydroWEHValidator() {}

  /** factory method */
  public static GovHydroWEHValidator getInstance() {
    return new GovHydroWEHValidator();
  }

  /** handles creation validation for a GovHydroWEH */
  public void validate(CreateGovHydroWEHCommand govHydroWEH) throws Exception {
    Assert.notNull(govHydroWEH, "CreateGovHydroWEHCommand should not be null");
    //		Assert.isNull( govHydroWEH.getGovHydroWEHId(), "CreateGovHydroWEHCommand identifier should
    // be null" );
  }

  /** handles update validation for a GovHydroWEH */
  public void validate(UpdateGovHydroWEHCommand govHydroWEH) throws Exception {
    Assert.notNull(govHydroWEH, "UpdateGovHydroWEHCommand should not be null");
    Assert.notNull(
        govHydroWEH.getGovHydroWEHId(), "UpdateGovHydroWEHCommand identifier should not be null");
  }

  /** handles delete validation for a GovHydroWEH */
  public void validate(DeleteGovHydroWEHCommand govHydroWEH) throws Exception {
    Assert.notNull(govHydroWEH, "{commandAlias} should not be null");
    Assert.notNull(
        govHydroWEH.getGovHydroWEHId(), "DeleteGovHydroWEHCommand identifier should not be null");
  }

  /** handles fetchOne validation for a GovHydroWEH */
  public void validate(GovHydroWEHFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "GovHydroWEHFetchOneSummary should not be null");
    Assert.notNull(
        summary.getGovHydroWEHId(), "GovHydroWEHFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Db validation for a GovHydroWEH
   *
   * @param command AssignDbToGovHydroWEHCommand
   */
  public void validate(AssignDbToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignDbToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignDbToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDbToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Db validation for a GovHydroWEH
   *
   * @param command UnAssignDbFromGovHydroWEHCommand
   */
  public void validate(UnAssignDbFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDbFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignDbFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Dicn validation for a GovHydroWEH
   *
   * @param command AssignDicnToGovHydroWEHCommand
   */
  public void validate(AssignDicnToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignDicnToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignDicnToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDicnToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Dicn validation for a GovHydroWEH
   *
   * @param command UnAssignDicnFromGovHydroWEHCommand
   */
  public void validate(UnAssignDicnFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDicnFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignDicnFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Dpv validation for a GovHydroWEH
   *
   * @param command AssignDpvToGovHydroWEHCommand
   */
  public void validate(AssignDpvToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignDpvToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignDpvToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDpvToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Dpv validation for a GovHydroWEH
   *
   * @param command UnAssignDpvFromGovHydroWEHCommand
   */
  public void validate(UnAssignDpvFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDpvFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignDpvFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Dturb validation for a GovHydroWEH
   *
   * @param command AssignDturbToGovHydroWEHCommand
   */
  public void validate(AssignDturbToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignDturbToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "AssignDturbToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDturbToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Dturb validation for a GovHydroWEH
   *
   * @param command UnAssignDturbFromGovHydroWEHCommand
   */
  public void validate(UnAssignDturbFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDturbFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignDturbFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign FeedbackSignal validation for a GovHydroWEH
   *
   * @param command AssignFeedbackSignalToGovHydroWEHCommand
   */
  public void validate(AssignFeedbackSignalToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFeedbackSignalToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "AssignFeedbackSignalToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignFeedbackSignalToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign FeedbackSignal validation for a GovHydroWEH
   *
   * @param command UnAssignFeedbackSignalFromGovHydroWEHCommand
   */
  public void validate(UnAssignFeedbackSignalFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFeedbackSignalFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFeedbackSignalFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Fl1 validation for a GovHydroWEH
   *
   * @param command AssignFl1ToGovHydroWEHCommand
   */
  public void validate(AssignFl1ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFl1ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignFl1ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFl1ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Fl1 validation for a GovHydroWEH
   *
   * @param command UnAssignFl1FromGovHydroWEHCommand
   */
  public void validate(UnAssignFl1FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFl1FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFl1FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Fl2 validation for a GovHydroWEH
   *
   * @param command AssignFl2ToGovHydroWEHCommand
   */
  public void validate(AssignFl2ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFl2ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignFl2ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFl2ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Fl2 validation for a GovHydroWEH
   *
   * @param command UnAssignFl2FromGovHydroWEHCommand
   */
  public void validate(UnAssignFl2FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFl2FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFl2FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Fl3 validation for a GovHydroWEH
   *
   * @param command AssignFl3ToGovHydroWEHCommand
   */
  public void validate(AssignFl3ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFl3ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignFl3ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFl3ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Fl3 validation for a GovHydroWEH
   *
   * @param command UnAssignFl3FromGovHydroWEHCommand
   */
  public void validate(UnAssignFl3FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFl3FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFl3FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Fl4 validation for a GovHydroWEH
   *
   * @param command AssignFl4ToGovHydroWEHCommand
   */
  public void validate(AssignFl4ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFl4ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignFl4ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFl4ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Fl4 validation for a GovHydroWEH
   *
   * @param command UnAssignFl4FromGovHydroWEHCommand
   */
  public void validate(UnAssignFl4FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFl4FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFl4FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Fl5 validation for a GovHydroWEH
   *
   * @param command AssignFl5ToGovHydroWEHCommand
   */
  public void validate(AssignFl5ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFl5ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignFl5ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFl5ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Fl5 validation for a GovHydroWEH
   *
   * @param command UnAssignFl5FromGovHydroWEHCommand
   */
  public void validate(UnAssignFl5FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFl5FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFl5FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Fp1 validation for a GovHydroWEH
   *
   * @param command AssignFp1ToGovHydroWEHCommand
   */
  public void validate(AssignFp1ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFp1ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignFp1ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFp1ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Fp1 validation for a GovHydroWEH
   *
   * @param command UnAssignFp1FromGovHydroWEHCommand
   */
  public void validate(UnAssignFp1FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFp1FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFp1FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Fp10 validation for a GovHydroWEH
   *
   * @param command AssignFp10ToGovHydroWEHCommand
   */
  public void validate(AssignFp10ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFp10ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignFp10ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFp10ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Fp10 validation for a GovHydroWEH
   *
   * @param command UnAssignFp10FromGovHydroWEHCommand
   */
  public void validate(UnAssignFp10FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFp10FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFp10FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Fp2 validation for a GovHydroWEH
   *
   * @param command AssignFp2ToGovHydroWEHCommand
   */
  public void validate(AssignFp2ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFp2ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignFp2ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFp2ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Fp2 validation for a GovHydroWEH
   *
   * @param command UnAssignFp2FromGovHydroWEHCommand
   */
  public void validate(UnAssignFp2FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFp2FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFp2FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Fp3 validation for a GovHydroWEH
   *
   * @param command AssignFp3ToGovHydroWEHCommand
   */
  public void validate(AssignFp3ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFp3ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignFp3ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFp3ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Fp3 validation for a GovHydroWEH
   *
   * @param command UnAssignFp3FromGovHydroWEHCommand
   */
  public void validate(UnAssignFp3FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFp3FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFp3FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Fp4 validation for a GovHydroWEH
   *
   * @param command AssignFp4ToGovHydroWEHCommand
   */
  public void validate(AssignFp4ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFp4ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignFp4ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFp4ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Fp4 validation for a GovHydroWEH
   *
   * @param command UnAssignFp4FromGovHydroWEHCommand
   */
  public void validate(UnAssignFp4FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFp4FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFp4FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Fp5 validation for a GovHydroWEH
   *
   * @param command AssignFp5ToGovHydroWEHCommand
   */
  public void validate(AssignFp5ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFp5ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignFp5ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFp5ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Fp5 validation for a GovHydroWEH
   *
   * @param command UnAssignFp5FromGovHydroWEHCommand
   */
  public void validate(UnAssignFp5FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFp5FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFp5FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Fp6 validation for a GovHydroWEH
   *
   * @param command AssignFp6ToGovHydroWEHCommand
   */
  public void validate(AssignFp6ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFp6ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignFp6ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFp6ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Fp6 validation for a GovHydroWEH
   *
   * @param command UnAssignFp6FromGovHydroWEHCommand
   */
  public void validate(UnAssignFp6FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFp6FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFp6FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Fp7 validation for a GovHydroWEH
   *
   * @param command AssignFp7ToGovHydroWEHCommand
   */
  public void validate(AssignFp7ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFp7ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignFp7ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFp7ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Fp7 validation for a GovHydroWEH
   *
   * @param command UnAssignFp7FromGovHydroWEHCommand
   */
  public void validate(UnAssignFp7FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFp7FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFp7FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Fp8 validation for a GovHydroWEH
   *
   * @param command AssignFp8ToGovHydroWEHCommand
   */
  public void validate(AssignFp8ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFp8ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignFp8ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFp8ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Fp8 validation for a GovHydroWEH
   *
   * @param command UnAssignFp8FromGovHydroWEHCommand
   */
  public void validate(UnAssignFp8FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFp8FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFp8FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Fp9 validation for a GovHydroWEH
   *
   * @param command AssignFp9ToGovHydroWEHCommand
   */
  public void validate(AssignFp9ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignFp9ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignFp9ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignFp9ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Fp9 validation for a GovHydroWEH
   *
   * @param command UnAssignFp9FromGovHydroWEHCommand
   */
  public void validate(UnAssignFp9FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignFp9FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignFp9FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Gmax validation for a GovHydroWEH
   *
   * @param command AssignGmaxToGovHydroWEHCommand
   */
  public void validate(AssignGmaxToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignGmaxToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignGmaxToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGmaxToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Gmax validation for a GovHydroWEH
   *
   * @param command UnAssignGmaxFromGovHydroWEHCommand
   */
  public void validate(UnAssignGmaxFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGmaxFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignGmaxFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Gmin validation for a GovHydroWEH
   *
   * @param command AssignGminToGovHydroWEHCommand
   */
  public void validate(AssignGminToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignGminToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignGminToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGminToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Gmin validation for a GovHydroWEH
   *
   * @param command UnAssignGminFromGovHydroWEHCommand
   */
  public void validate(UnAssignGminFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGminFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignGminFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Gtmxcl validation for a GovHydroWEH
   *
   * @param command AssignGtmxclToGovHydroWEHCommand
   */
  public void validate(AssignGtmxclToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignGtmxclToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "AssignGtmxclToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGtmxclToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Gtmxcl validation for a GovHydroWEH
   *
   * @param command UnAssignGtmxclFromGovHydroWEHCommand
   */
  public void validate(UnAssignGtmxclFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGtmxclFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignGtmxclFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Gtmxop validation for a GovHydroWEH
   *
   * @param command AssignGtmxopToGovHydroWEHCommand
   */
  public void validate(AssignGtmxopToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignGtmxopToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "AssignGtmxopToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGtmxopToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Gtmxop validation for a GovHydroWEH
   *
   * @param command UnAssignGtmxopFromGovHydroWEHCommand
   */
  public void validate(UnAssignGtmxopFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGtmxopFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignGtmxopFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Gv1 validation for a GovHydroWEH
   *
   * @param command AssignGv1ToGovHydroWEHCommand
   */
  public void validate(AssignGv1ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignGv1ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignGv1ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv1ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Gv1 validation for a GovHydroWEH
   *
   * @param command UnAssignGv1FromGovHydroWEHCommand
   */
  public void validate(UnAssignGv1FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv1FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignGv1FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Gv2 validation for a GovHydroWEH
   *
   * @param command AssignGv2ToGovHydroWEHCommand
   */
  public void validate(AssignGv2ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignGv2ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignGv2ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv2ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Gv2 validation for a GovHydroWEH
   *
   * @param command UnAssignGv2FromGovHydroWEHCommand
   */
  public void validate(UnAssignGv2FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv2FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignGv2FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Gv3 validation for a GovHydroWEH
   *
   * @param command AssignGv3ToGovHydroWEHCommand
   */
  public void validate(AssignGv3ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignGv3ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignGv3ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv3ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Gv3 validation for a GovHydroWEH
   *
   * @param command UnAssignGv3FromGovHydroWEHCommand
   */
  public void validate(UnAssignGv3FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv3FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignGv3FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Gv4 validation for a GovHydroWEH
   *
   * @param command AssignGv4ToGovHydroWEHCommand
   */
  public void validate(AssignGv4ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignGv4ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignGv4ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv4ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Gv4 validation for a GovHydroWEH
   *
   * @param command UnAssignGv4FromGovHydroWEHCommand
   */
  public void validate(UnAssignGv4FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv4FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignGv4FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Gv5 validation for a GovHydroWEH
   *
   * @param command AssignGv5ToGovHydroWEHCommand
   */
  public void validate(AssignGv5ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignGv5ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignGv5ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignGv5ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Gv5 validation for a GovHydroWEH
   *
   * @param command UnAssignGv5FromGovHydroWEHCommand
   */
  public void validate(UnAssignGv5FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignGv5FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignGv5FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Kd validation for a GovHydroWEH
   *
   * @param command AssignKdToGovHydroWEHCommand
   */
  public void validate(AssignKdToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignKdToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignKdToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKdToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Kd validation for a GovHydroWEH
   *
   * @param command UnAssignKdFromGovHydroWEHCommand
   */
  public void validate(UnAssignKdFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignKdFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Ki validation for a GovHydroWEH
   *
   * @param command AssignKiToGovHydroWEHCommand
   */
  public void validate(AssignKiToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignKiToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignKiToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKiToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Ki validation for a GovHydroWEH
   *
   * @param command UnAssignKiFromGovHydroWEHCommand
   */
  public void validate(UnAssignKiFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKiFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignKiFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Kp validation for a GovHydroWEH
   *
   * @param command AssignKpToGovHydroWEHCommand
   */
  public void validate(AssignKpToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignKpToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignKpToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Kp validation for a GovHydroWEH
   *
   * @param command UnAssignKpFromGovHydroWEHCommand
   */
  public void validate(UnAssignKpFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKpFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignKpFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Mwbase validation for a GovHydroWEH
   *
   * @param command AssignMwbaseToGovHydroWEHCommand
   */
  public void validate(AssignMwbaseToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignMwbaseToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "AssignMwbaseToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMwbaseToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Mwbase validation for a GovHydroWEH
   *
   * @param command UnAssignMwbaseFromGovHydroWEHCommand
   */
  public void validate(UnAssignMwbaseFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMwbaseFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignMwbaseFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Pmss1 validation for a GovHydroWEH
   *
   * @param command AssignPmss1ToGovHydroWEHCommand
   */
  public void validate(AssignPmss1ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignPmss1ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "AssignPmss1ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmss1ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Pmss1 validation for a GovHydroWEH
   *
   * @param command UnAssignPmss1FromGovHydroWEHCommand
   */
  public void validate(UnAssignPmss1FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmss1FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignPmss1FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Pmss10 validation for a GovHydroWEH
   *
   * @param command AssignPmss10ToGovHydroWEHCommand
   */
  public void validate(AssignPmss10ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignPmss10ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "AssignPmss10ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmss10ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Pmss10 validation for a GovHydroWEH
   *
   * @param command UnAssignPmss10FromGovHydroWEHCommand
   */
  public void validate(UnAssignPmss10FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmss10FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignPmss10FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Pmss2 validation for a GovHydroWEH
   *
   * @param command AssignPmss2ToGovHydroWEHCommand
   */
  public void validate(AssignPmss2ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignPmss2ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "AssignPmss2ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmss2ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Pmss2 validation for a GovHydroWEH
   *
   * @param command UnAssignPmss2FromGovHydroWEHCommand
   */
  public void validate(UnAssignPmss2FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmss2FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignPmss2FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Pmss3 validation for a GovHydroWEH
   *
   * @param command AssignPmss3ToGovHydroWEHCommand
   */
  public void validate(AssignPmss3ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignPmss3ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "AssignPmss3ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmss3ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Pmss3 validation for a GovHydroWEH
   *
   * @param command UnAssignPmss3FromGovHydroWEHCommand
   */
  public void validate(UnAssignPmss3FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmss3FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignPmss3FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Pmss4 validation for a GovHydroWEH
   *
   * @param command AssignPmss4ToGovHydroWEHCommand
   */
  public void validate(AssignPmss4ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignPmss4ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "AssignPmss4ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmss4ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Pmss4 validation for a GovHydroWEH
   *
   * @param command UnAssignPmss4FromGovHydroWEHCommand
   */
  public void validate(UnAssignPmss4FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmss4FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignPmss4FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Pmss5 validation for a GovHydroWEH
   *
   * @param command AssignPmss5ToGovHydroWEHCommand
   */
  public void validate(AssignPmss5ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignPmss5ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "AssignPmss5ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmss5ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Pmss5 validation for a GovHydroWEH
   *
   * @param command UnAssignPmss5FromGovHydroWEHCommand
   */
  public void validate(UnAssignPmss5FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmss5FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignPmss5FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Pmss6 validation for a GovHydroWEH
   *
   * @param command AssignPmss6ToGovHydroWEHCommand
   */
  public void validate(AssignPmss6ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignPmss6ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "AssignPmss6ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmss6ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Pmss6 validation for a GovHydroWEH
   *
   * @param command UnAssignPmss6FromGovHydroWEHCommand
   */
  public void validate(UnAssignPmss6FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmss6FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignPmss6FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Pmss7 validation for a GovHydroWEH
   *
   * @param command AssignPmss7ToGovHydroWEHCommand
   */
  public void validate(AssignPmss7ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignPmss7ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "AssignPmss7ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmss7ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Pmss7 validation for a GovHydroWEH
   *
   * @param command UnAssignPmss7FromGovHydroWEHCommand
   */
  public void validate(UnAssignPmss7FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmss7FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignPmss7FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Pmss8 validation for a GovHydroWEH
   *
   * @param command AssignPmss8ToGovHydroWEHCommand
   */
  public void validate(AssignPmss8ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignPmss8ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "AssignPmss8ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmss8ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Pmss8 validation for a GovHydroWEH
   *
   * @param command UnAssignPmss8FromGovHydroWEHCommand
   */
  public void validate(UnAssignPmss8FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmss8FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignPmss8FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Pmss9 validation for a GovHydroWEH
   *
   * @param command AssignPmss9ToGovHydroWEHCommand
   */
  public void validate(AssignPmss9ToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignPmss9ToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "AssignPmss9ToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPmss9ToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Pmss9 validation for a GovHydroWEH
   *
   * @param command UnAssignPmss9FromGovHydroWEHCommand
   */
  public void validate(UnAssignPmss9FromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPmss9FromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignPmss9FromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Rpg validation for a GovHydroWEH
   *
   * @param command AssignRpgToGovHydroWEHCommand
   */
  public void validate(AssignRpgToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignRpgToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignRpgToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRpgToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Rpg validation for a GovHydroWEH
   *
   * @param command UnAssignRpgFromGovHydroWEHCommand
   */
  public void validate(UnAssignRpgFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRpgFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignRpgFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Rpp validation for a GovHydroWEH
   *
   * @param command AssignRppToGovHydroWEHCommand
   */
  public void validate(AssignRppToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignRppToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignRppToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRppToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Rpp validation for a GovHydroWEH
   *
   * @param command UnAssignRppFromGovHydroWEHCommand
   */
  public void validate(UnAssignRppFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRppFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignRppFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Td validation for a GovHydroWEH
   *
   * @param command AssignTdToGovHydroWEHCommand
   */
  public void validate(AssignTdToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignTdToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignTdToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Td validation for a GovHydroWEH
   *
   * @param command UnAssignTdFromGovHydroWEHCommand
   */
  public void validate(UnAssignTdFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignTdFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Tdv validation for a GovHydroWEH
   *
   * @param command AssignTdvToGovHydroWEHCommand
   */
  public void validate(AssignTdvToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignTdvToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignTdvToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTdvToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Tdv validation for a GovHydroWEH
   *
   * @param command UnAssignTdvFromGovHydroWEHCommand
   */
  public void validate(UnAssignTdvFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdvFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignTdvFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Tg validation for a GovHydroWEH
   *
   * @param command AssignTgToGovHydroWEHCommand
   */
  public void validate(AssignTgToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignTgToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignTgToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTgToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Tg validation for a GovHydroWEH
   *
   * @param command UnAssignTgFromGovHydroWEHCommand
   */
  public void validate(UnAssignTgFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTgFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignTgFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Tp validation for a GovHydroWEH
   *
   * @param command AssignTpToGovHydroWEHCommand
   */
  public void validate(AssignTpToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignTpToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignTpToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Tp validation for a GovHydroWEH
   *
   * @param command UnAssignTpFromGovHydroWEHCommand
   */
  public void validate(UnAssignTpFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignTpFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Tpe validation for a GovHydroWEH
   *
   * @param command AssignTpeToGovHydroWEHCommand
   */
  public void validate(AssignTpeToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignTpeToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignTpeToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTpeToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Tpe validation for a GovHydroWEH
   *
   * @param command UnAssignTpeFromGovHydroWEHCommand
   */
  public void validate(UnAssignTpeFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpeFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignTpeFromGovHydroWEHCommand identifier should not be null");
  }
  /**
   * handles assign Tw validation for a GovHydroWEH
   *
   * @param command AssignTwToGovHydroWEHCommand
   */
  public void validate(AssignTwToGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "AssignTwToGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(), "AssignTwToGovHydroWEHCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTwToGovHydroWEHCommand assignment should not be null");
  }

  /**
   * handles unassign Tw validation for a GovHydroWEH
   *
   * @param command UnAssignTwFromGovHydroWEHCommand
   */
  public void validate(UnAssignTwFromGovHydroWEHCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTwFromGovHydroWEHCommand should not be null");
    Assert.notNull(
        command.getGovHydroWEHId(),
        "UnAssignTwFromGovHydroWEHCommand identifier should not be null");
  }
}
