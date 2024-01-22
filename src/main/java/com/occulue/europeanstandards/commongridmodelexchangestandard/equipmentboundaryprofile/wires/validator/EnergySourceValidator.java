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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class EnergySourceValidator {

  /** default constructor */
  protected EnergySourceValidator() {}

  /** factory method */
  public static EnergySourceValidator getInstance() {
    return new EnergySourceValidator();
  }

  /** handles creation validation for a EnergySource */
  public void validate(CreateEnergySourceCommand energySource) throws Exception {
    Assert.notNull(energySource, "CreateEnergySourceCommand should not be null");
    //		Assert.isNull( energySource.getEnergySourceId(), "CreateEnergySourceCommand identifier
    // should be null" );
  }

  /** handles update validation for a EnergySource */
  public void validate(UpdateEnergySourceCommand energySource) throws Exception {
    Assert.notNull(energySource, "UpdateEnergySourceCommand should not be null");
    Assert.notNull(
        energySource.getEnergySourceId(),
        "UpdateEnergySourceCommand identifier should not be null");
  }

  /** handles delete validation for a EnergySource */
  public void validate(DeleteEnergySourceCommand energySource) throws Exception {
    Assert.notNull(energySource, "{commandAlias} should not be null");
    Assert.notNull(
        energySource.getEnergySourceId(),
        "DeleteEnergySourceCommand identifier should not be null");
  }

  /** handles fetchOne validation for a EnergySource */
  public void validate(EnergySourceFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "EnergySourceFetchOneSummary should not be null");
    Assert.notNull(
        summary.getEnergySourceId(), "EnergySourceFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to EnergySource validation for a EnergySource
   *
   * @param command AssignEnergySourceToEnergySourceCommand
   */
  public void validate(AssignEnergySourceToEnergySourceCommand command) throws Exception {
    Assert.notNull(command, "AssignEnergySourceToEnergySourceCommand should not be null");
    Assert.notNull(
        command.getEnergySourceId(),
        "AssignEnergySourceToEnergySourceCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignEnergySourceToEnergySourceCommand addTo attribute should not be null");
  }

  /**
   * handles remove from EnergySource validation for a EnergySource
   *
   * @param command RemoveEnergySourceFromEnergySourceCommand
   */
  public void validate(RemoveEnergySourceFromEnergySourceCommand command) throws Exception {
    Assert.notNull(command, "RemoveEnergySourceFromEnergySourceCommand should not be null");
    Assert.notNull(
        command.getEnergySourceId(),
        "RemoveEnergySourceFromEnergySourceCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveEnergySourceFromEnergySourceCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getEnergySourceId(),
        "RemoveEnergySourceFromEnergySourceCommand removeFrom attribubte identifier should not be null");
  }
}
