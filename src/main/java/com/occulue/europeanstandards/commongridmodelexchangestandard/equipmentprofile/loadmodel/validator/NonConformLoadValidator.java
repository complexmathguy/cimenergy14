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

public class NonConformLoadValidator {

  /** default constructor */
  protected NonConformLoadValidator() {}

  /** factory method */
  public static NonConformLoadValidator getInstance() {
    return new NonConformLoadValidator();
  }

  /** handles creation validation for a NonConformLoad */
  public void validate(CreateNonConformLoadCommand nonConformLoad) throws Exception {
    Assert.notNull(nonConformLoad, "CreateNonConformLoadCommand should not be null");
    //		Assert.isNull( nonConformLoad.getNonConformLoadId(), "CreateNonConformLoadCommand identifier
    // should be null" );
  }

  /** handles update validation for a NonConformLoad */
  public void validate(UpdateNonConformLoadCommand nonConformLoad) throws Exception {
    Assert.notNull(nonConformLoad, "UpdateNonConformLoadCommand should not be null");
    Assert.notNull(
        nonConformLoad.getNonConformLoadId(),
        "UpdateNonConformLoadCommand identifier should not be null");
  }

  /** handles delete validation for a NonConformLoad */
  public void validate(DeleteNonConformLoadCommand nonConformLoad) throws Exception {
    Assert.notNull(nonConformLoad, "{commandAlias} should not be null");
    Assert.notNull(
        nonConformLoad.getNonConformLoadId(),
        "DeleteNonConformLoadCommand identifier should not be null");
  }

  /** handles fetchOne validation for a NonConformLoad */
  public void validate(NonConformLoadFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "NonConformLoadFetchOneSummary should not be null");
    Assert.notNull(
        summary.getNonConformLoadId(),
        "NonConformLoadFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to EnergyConsumers validation for a NonConformLoad
   *
   * @param command AssignEnergyConsumersToNonConformLoadCommand
   */
  public void validate(AssignEnergyConsumersToNonConformLoadCommand command) throws Exception {
    Assert.notNull(command, "AssignEnergyConsumersToNonConformLoadCommand should not be null");
    Assert.notNull(
        command.getNonConformLoadId(),
        "AssignEnergyConsumersToNonConformLoadCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignEnergyConsumersToNonConformLoadCommand addTo attribute should not be null");
  }

  /**
   * handles remove from EnergyConsumers validation for a NonConformLoad
   *
   * @param command RemoveEnergyConsumersFromNonConformLoadCommand
   */
  public void validate(RemoveEnergyConsumersFromNonConformLoadCommand command) throws Exception {
    Assert.notNull(command, "RemoveEnergyConsumersFromNonConformLoadCommand should not be null");
    Assert.notNull(
        command.getNonConformLoadId(),
        "RemoveEnergyConsumersFromNonConformLoadCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveEnergyConsumersFromNonConformLoadCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getNonConformLoadId(),
        "RemoveEnergyConsumersFromNonConformLoadCommand removeFrom attribubte identifier should not be null");
  }
}
