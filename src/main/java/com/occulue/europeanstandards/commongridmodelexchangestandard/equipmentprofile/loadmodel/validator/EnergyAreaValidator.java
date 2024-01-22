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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class EnergyAreaValidator {

  /** default constructor */
  protected EnergyAreaValidator() {}

  /** factory method */
  public static EnergyAreaValidator getInstance() {
    return new EnergyAreaValidator();
  }

  /** handles creation validation for a EnergyArea */
  public void validate(CreateEnergyAreaCommand energyArea) throws Exception {
    Assert.notNull(energyArea, "CreateEnergyAreaCommand should not be null");
    //		Assert.isNull( energyArea.getEnergyAreaId(), "CreateEnergyAreaCommand identifier should be
    // null" );
  }

  /** handles update validation for a EnergyArea */
  public void validate(UpdateEnergyAreaCommand energyArea) throws Exception {
    Assert.notNull(energyArea, "UpdateEnergyAreaCommand should not be null");
    Assert.notNull(
        energyArea.getEnergyAreaId(), "UpdateEnergyAreaCommand identifier should not be null");
  }

  /** handles delete validation for a EnergyArea */
  public void validate(DeleteEnergyAreaCommand energyArea) throws Exception {
    Assert.notNull(energyArea, "{commandAlias} should not be null");
    Assert.notNull(
        energyArea.getEnergyAreaId(), "DeleteEnergyAreaCommand identifier should not be null");
  }

  /** handles fetchOne validation for a EnergyArea */
  public void validate(EnergyAreaFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "EnergyAreaFetchOneSummary should not be null");
    Assert.notNull(
        summary.getEnergyAreaId(), "EnergyAreaFetchOneSummary identifier should not be null");
  }
}
