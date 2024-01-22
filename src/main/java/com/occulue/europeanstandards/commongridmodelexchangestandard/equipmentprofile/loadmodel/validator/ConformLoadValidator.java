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

public class ConformLoadValidator {

  /** default constructor */
  protected ConformLoadValidator() {}

  /** factory method */
  public static ConformLoadValidator getInstance() {
    return new ConformLoadValidator();
  }

  /** handles creation validation for a ConformLoad */
  public void validate(CreateConformLoadCommand conformLoad) throws Exception {
    Assert.notNull(conformLoad, "CreateConformLoadCommand should not be null");
    //		Assert.isNull( conformLoad.getConformLoadId(), "CreateConformLoadCommand identifier should
    // be null" );
  }

  /** handles update validation for a ConformLoad */
  public void validate(UpdateConformLoadCommand conformLoad) throws Exception {
    Assert.notNull(conformLoad, "UpdateConformLoadCommand should not be null");
    Assert.notNull(
        conformLoad.getConformLoadId(), "UpdateConformLoadCommand identifier should not be null");
  }

  /** handles delete validation for a ConformLoad */
  public void validate(DeleteConformLoadCommand conformLoad) throws Exception {
    Assert.notNull(conformLoad, "{commandAlias} should not be null");
    Assert.notNull(
        conformLoad.getConformLoadId(), "DeleteConformLoadCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ConformLoad */
  public void validate(ConformLoadFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ConformLoadFetchOneSummary should not be null");
    Assert.notNull(
        summary.getConformLoadId(), "ConformLoadFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to EnergyConsumers validation for a ConformLoad
   *
   * @param command AssignEnergyConsumersToConformLoadCommand
   */
  public void validate(AssignEnergyConsumersToConformLoadCommand command) throws Exception {
    Assert.notNull(command, "AssignEnergyConsumersToConformLoadCommand should not be null");
    Assert.notNull(
        command.getConformLoadId(),
        "AssignEnergyConsumersToConformLoadCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignEnergyConsumersToConformLoadCommand addTo attribute should not be null");
  }

  /**
   * handles remove from EnergyConsumers validation for a ConformLoad
   *
   * @param command RemoveEnergyConsumersFromConformLoadCommand
   */
  public void validate(RemoveEnergyConsumersFromConformLoadCommand command) throws Exception {
    Assert.notNull(command, "RemoveEnergyConsumersFromConformLoadCommand should not be null");
    Assert.notNull(
        command.getConformLoadId(),
        "RemoveEnergyConsumersFromConformLoadCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveEnergyConsumersFromConformLoadCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getConformLoadId(),
        "RemoveEnergyConsumersFromConformLoadCommand removeFrom attribubte identifier should not be null");
  }
}
