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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class VolumeFlowRateValidator {

  /** default constructor */
  protected VolumeFlowRateValidator() {}

  /** factory method */
  public static VolumeFlowRateValidator getInstance() {
    return new VolumeFlowRateValidator();
  }

  /** handles creation validation for a VolumeFlowRate */
  public void validate(CreateVolumeFlowRateCommand volumeFlowRate) throws Exception {
    Assert.notNull(volumeFlowRate, "CreateVolumeFlowRateCommand should not be null");
    //		Assert.isNull( volumeFlowRate.getVolumeFlowRateId(), "CreateVolumeFlowRateCommand identifier
    // should be null" );
  }

  /** handles update validation for a VolumeFlowRate */
  public void validate(UpdateVolumeFlowRateCommand volumeFlowRate) throws Exception {
    Assert.notNull(volumeFlowRate, "UpdateVolumeFlowRateCommand should not be null");
    Assert.notNull(
        volumeFlowRate.getVolumeFlowRateId(),
        "UpdateVolumeFlowRateCommand identifier should not be null");
  }

  /** handles delete validation for a VolumeFlowRate */
  public void validate(DeleteVolumeFlowRateCommand volumeFlowRate) throws Exception {
    Assert.notNull(volumeFlowRate, "{commandAlias} should not be null");
    Assert.notNull(
        volumeFlowRate.getVolumeFlowRateId(),
        "DeleteVolumeFlowRateCommand identifier should not be null");
  }

  /** handles fetchOne validation for a VolumeFlowRate */
  public void validate(VolumeFlowRateFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "VolumeFlowRateFetchOneSummary should not be null");
    Assert.notNull(
        summary.getVolumeFlowRateId(),
        "VolumeFlowRateFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a VolumeFlowRate
   *
   * @param command AssignValueToVolumeFlowRateCommand
   */
  public void validate(AssignValueToVolumeFlowRateCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToVolumeFlowRateCommand should not be null");
    Assert.notNull(
        command.getVolumeFlowRateId(),
        "AssignValueToVolumeFlowRateCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignValueToVolumeFlowRateCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a VolumeFlowRate
   *
   * @param command UnAssignValueFromVolumeFlowRateCommand
   */
  public void validate(UnAssignValueFromVolumeFlowRateCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromVolumeFlowRateCommand should not be null");
    Assert.notNull(
        command.getVolumeFlowRateId(),
        "UnAssignValueFromVolumeFlowRateCommand identifier should not be null");
  }
}
