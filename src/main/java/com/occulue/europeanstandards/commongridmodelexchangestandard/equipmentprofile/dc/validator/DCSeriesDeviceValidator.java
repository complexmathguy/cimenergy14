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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DCSeriesDeviceValidator {

  /** default constructor */
  protected DCSeriesDeviceValidator() {}

  /** factory method */
  public static DCSeriesDeviceValidator getInstance() {
    return new DCSeriesDeviceValidator();
  }

  /** handles creation validation for a DCSeriesDevice */
  public void validate(CreateDCSeriesDeviceCommand dCSeriesDevice) throws Exception {
    Assert.notNull(dCSeriesDevice, "CreateDCSeriesDeviceCommand should not be null");
    //		Assert.isNull( dCSeriesDevice.getDCSeriesDeviceId(), "CreateDCSeriesDeviceCommand identifier
    // should be null" );
  }

  /** handles update validation for a DCSeriesDevice */
  public void validate(UpdateDCSeriesDeviceCommand dCSeriesDevice) throws Exception {
    Assert.notNull(dCSeriesDevice, "UpdateDCSeriesDeviceCommand should not be null");
    Assert.notNull(
        dCSeriesDevice.getDCSeriesDeviceId(),
        "UpdateDCSeriesDeviceCommand identifier should not be null");
  }

  /** handles delete validation for a DCSeriesDevice */
  public void validate(DeleteDCSeriesDeviceCommand dCSeriesDevice) throws Exception {
    Assert.notNull(dCSeriesDevice, "{commandAlias} should not be null");
    Assert.notNull(
        dCSeriesDevice.getDCSeriesDeviceId(),
        "DeleteDCSeriesDeviceCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DCSeriesDevice */
  public void validate(DCSeriesDeviceFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DCSeriesDeviceFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDCSeriesDeviceId(),
        "DCSeriesDeviceFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Inductance validation for a DCSeriesDevice
   *
   * @param command AssignInductanceToDCSeriesDeviceCommand
   */
  public void validate(AssignInductanceToDCSeriesDeviceCommand command) throws Exception {
    Assert.notNull(command, "AssignInductanceToDCSeriesDeviceCommand should not be null");
    Assert.notNull(
        command.getDCSeriesDeviceId(),
        "AssignInductanceToDCSeriesDeviceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignInductanceToDCSeriesDeviceCommand assignment should not be null");
  }

  /**
   * handles unassign Inductance validation for a DCSeriesDevice
   *
   * @param command UnAssignInductanceFromDCSeriesDeviceCommand
   */
  public void validate(UnAssignInductanceFromDCSeriesDeviceCommand command) throws Exception {
    Assert.notNull(command, "UnAssignInductanceFromDCSeriesDeviceCommand should not be null");
    Assert.notNull(
        command.getDCSeriesDeviceId(),
        "UnAssignInductanceFromDCSeriesDeviceCommand identifier should not be null");
  }
  /**
   * handles assign RatedUdc validation for a DCSeriesDevice
   *
   * @param command AssignRatedUdcToDCSeriesDeviceCommand
   */
  public void validate(AssignRatedUdcToDCSeriesDeviceCommand command) throws Exception {
    Assert.notNull(command, "AssignRatedUdcToDCSeriesDeviceCommand should not be null");
    Assert.notNull(
        command.getDCSeriesDeviceId(),
        "AssignRatedUdcToDCSeriesDeviceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRatedUdcToDCSeriesDeviceCommand assignment should not be null");
  }

  /**
   * handles unassign RatedUdc validation for a DCSeriesDevice
   *
   * @param command UnAssignRatedUdcFromDCSeriesDeviceCommand
   */
  public void validate(UnAssignRatedUdcFromDCSeriesDeviceCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRatedUdcFromDCSeriesDeviceCommand should not be null");
    Assert.notNull(
        command.getDCSeriesDeviceId(),
        "UnAssignRatedUdcFromDCSeriesDeviceCommand identifier should not be null");
  }
  /**
   * handles assign Resistance validation for a DCSeriesDevice
   *
   * @param command AssignResistanceToDCSeriesDeviceCommand
   */
  public void validate(AssignResistanceToDCSeriesDeviceCommand command) throws Exception {
    Assert.notNull(command, "AssignResistanceToDCSeriesDeviceCommand should not be null");
    Assert.notNull(
        command.getDCSeriesDeviceId(),
        "AssignResistanceToDCSeriesDeviceCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignResistanceToDCSeriesDeviceCommand assignment should not be null");
  }

  /**
   * handles unassign Resistance validation for a DCSeriesDevice
   *
   * @param command UnAssignResistanceFromDCSeriesDeviceCommand
   */
  public void validate(UnAssignResistanceFromDCSeriesDeviceCommand command) throws Exception {
    Assert.notNull(command, "UnAssignResistanceFromDCSeriesDeviceCommand should not be null");
    Assert.notNull(
        command.getDCSeriesDeviceId(),
        "UnAssignResistanceFromDCSeriesDeviceCommand identifier should not be null");
  }
}
