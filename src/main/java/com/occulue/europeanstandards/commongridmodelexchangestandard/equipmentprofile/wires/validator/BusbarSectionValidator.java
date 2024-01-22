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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class BusbarSectionValidator {

  /** default constructor */
  protected BusbarSectionValidator() {}

  /** factory method */
  public static BusbarSectionValidator getInstance() {
    return new BusbarSectionValidator();
  }

  /** handles creation validation for a BusbarSection */
  public void validate(CreateBusbarSectionCommand busbarSection) throws Exception {
    Assert.notNull(busbarSection, "CreateBusbarSectionCommand should not be null");
    //		Assert.isNull( busbarSection.getBusbarSectionId(), "CreateBusbarSectionCommand identifier
    // should be null" );
  }

  /** handles update validation for a BusbarSection */
  public void validate(UpdateBusbarSectionCommand busbarSection) throws Exception {
    Assert.notNull(busbarSection, "UpdateBusbarSectionCommand should not be null");
    Assert.notNull(
        busbarSection.getBusbarSectionId(),
        "UpdateBusbarSectionCommand identifier should not be null");
  }

  /** handles delete validation for a BusbarSection */
  public void validate(DeleteBusbarSectionCommand busbarSection) throws Exception {
    Assert.notNull(busbarSection, "{commandAlias} should not be null");
    Assert.notNull(
        busbarSection.getBusbarSectionId(),
        "DeleteBusbarSectionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a BusbarSection */
  public void validate(BusbarSectionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "BusbarSectionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getBusbarSectionId(), "BusbarSectionFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign IpMax validation for a BusbarSection
   *
   * @param command AssignIpMaxToBusbarSectionCommand
   */
  public void validate(AssignIpMaxToBusbarSectionCommand command) throws Exception {
    Assert.notNull(command, "AssignIpMaxToBusbarSectionCommand should not be null");
    Assert.notNull(
        command.getBusbarSectionId(),
        "AssignIpMaxToBusbarSectionCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIpMaxToBusbarSectionCommand assignment should not be null");
  }

  /**
   * handles unassign IpMax validation for a BusbarSection
   *
   * @param command UnAssignIpMaxFromBusbarSectionCommand
   */
  public void validate(UnAssignIpMaxFromBusbarSectionCommand command) throws Exception {
    Assert.notNull(command, "UnAssignIpMaxFromBusbarSectionCommand should not be null");
    Assert.notNull(
        command.getBusbarSectionId(),
        "UnAssignIpMaxFromBusbarSectionCommand identifier should not be null");
  }
}
