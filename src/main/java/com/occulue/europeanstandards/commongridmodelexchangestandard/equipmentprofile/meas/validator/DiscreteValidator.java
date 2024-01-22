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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DiscreteValidator {

  /** default constructor */
  protected DiscreteValidator() {}

  /** factory method */
  public static DiscreteValidator getInstance() {
    return new DiscreteValidator();
  }

  /** handles creation validation for a Discrete */
  public void validate(CreateDiscreteCommand discrete) throws Exception {
    Assert.notNull(discrete, "CreateDiscreteCommand should not be null");
    //		Assert.isNull( discrete.getDiscreteId(), "CreateDiscreteCommand identifier should be null"
    // );
  }

  /** handles update validation for a Discrete */
  public void validate(UpdateDiscreteCommand discrete) throws Exception {
    Assert.notNull(discrete, "UpdateDiscreteCommand should not be null");
    Assert.notNull(discrete.getDiscreteId(), "UpdateDiscreteCommand identifier should not be null");
  }

  /** handles delete validation for a Discrete */
  public void validate(DeleteDiscreteCommand discrete) throws Exception {
    Assert.notNull(discrete, "{commandAlias} should not be null");
    Assert.notNull(discrete.getDiscreteId(), "DeleteDiscreteCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Discrete */
  public void validate(DiscreteFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DiscreteFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDiscreteId(), "DiscreteFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to Discretes validation for a Discrete
   *
   * @param command AssignDiscretesToDiscreteCommand
   */
  public void validate(AssignDiscretesToDiscreteCommand command) throws Exception {
    Assert.notNull(command, "AssignDiscretesToDiscreteCommand should not be null");
    Assert.notNull(
        command.getDiscreteId(), "AssignDiscretesToDiscreteCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(), "AssignDiscretesToDiscreteCommand addTo attribute should not be null");
  }

  /**
   * handles remove from Discretes validation for a Discrete
   *
   * @param command RemoveDiscretesFromDiscreteCommand
   */
  public void validate(RemoveDiscretesFromDiscreteCommand command) throws Exception {
    Assert.notNull(command, "RemoveDiscretesFromDiscreteCommand should not be null");
    Assert.notNull(
        command.getDiscreteId(),
        "RemoveDiscretesFromDiscreteCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveDiscretesFromDiscreteCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getDiscreteId(),
        "RemoveDiscretesFromDiscreteCommand removeFrom attribubte identifier should not be null");
  }
}
