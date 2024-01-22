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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class FossilFuelValidator {

  /** default constructor */
  protected FossilFuelValidator() {}

  /** factory method */
  public static FossilFuelValidator getInstance() {
    return new FossilFuelValidator();
  }

  /** handles creation validation for a FossilFuel */
  public void validate(CreateFossilFuelCommand fossilFuel) throws Exception {
    Assert.notNull(fossilFuel, "CreateFossilFuelCommand should not be null");
    //		Assert.isNull( fossilFuel.getFossilFuelId(), "CreateFossilFuelCommand identifier should be
    // null" );
  }

  /** handles update validation for a FossilFuel */
  public void validate(UpdateFossilFuelCommand fossilFuel) throws Exception {
    Assert.notNull(fossilFuel, "UpdateFossilFuelCommand should not be null");
    Assert.notNull(
        fossilFuel.getFossilFuelId(), "UpdateFossilFuelCommand identifier should not be null");
  }

  /** handles delete validation for a FossilFuel */
  public void validate(DeleteFossilFuelCommand fossilFuel) throws Exception {
    Assert.notNull(fossilFuel, "{commandAlias} should not be null");
    Assert.notNull(
        fossilFuel.getFossilFuelId(), "DeleteFossilFuelCommand identifier should not be null");
  }

  /** handles fetchOne validation for a FossilFuel */
  public void validate(FossilFuelFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "FossilFuelFetchOneSummary should not be null");
    Assert.notNull(
        summary.getFossilFuelId(), "FossilFuelFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to FossilFuels validation for a FossilFuel
   *
   * @param command AssignFossilFuelsToFossilFuelCommand
   */
  public void validate(AssignFossilFuelsToFossilFuelCommand command) throws Exception {
    Assert.notNull(command, "AssignFossilFuelsToFossilFuelCommand should not be null");
    Assert.notNull(
        command.getFossilFuelId(),
        "AssignFossilFuelsToFossilFuelCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignFossilFuelsToFossilFuelCommand addTo attribute should not be null");
  }

  /**
   * handles remove from FossilFuels validation for a FossilFuel
   *
   * @param command RemoveFossilFuelsFromFossilFuelCommand
   */
  public void validate(RemoveFossilFuelsFromFossilFuelCommand command) throws Exception {
    Assert.notNull(command, "RemoveFossilFuelsFromFossilFuelCommand should not be null");
    Assert.notNull(
        command.getFossilFuelId(),
        "RemoveFossilFuelsFromFossilFuelCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveFossilFuelsFromFossilFuelCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getFossilFuelId(),
        "RemoveFossilFuelsFromFossilFuelCommand removeFrom attribubte identifier should not be null");
  }
}
