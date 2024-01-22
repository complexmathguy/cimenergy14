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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class SubstationValidator {

  /** default constructor */
  protected SubstationValidator() {}

  /** factory method */
  public static SubstationValidator getInstance() {
    return new SubstationValidator();
  }

  /** handles creation validation for a Substation */
  public void validate(CreateSubstationCommand substation) throws Exception {
    Assert.notNull(substation, "CreateSubstationCommand should not be null");
    //		Assert.isNull( substation.getSubstationId(), "CreateSubstationCommand identifier should be
    // null" );
  }

  /** handles update validation for a Substation */
  public void validate(UpdateSubstationCommand substation) throws Exception {
    Assert.notNull(substation, "UpdateSubstationCommand should not be null");
    Assert.notNull(
        substation.getSubstationId(), "UpdateSubstationCommand identifier should not be null");
  }

  /** handles delete validation for a Substation */
  public void validate(DeleteSubstationCommand substation) throws Exception {
    Assert.notNull(substation, "{commandAlias} should not be null");
    Assert.notNull(
        substation.getSubstationId(), "DeleteSubstationCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Substation */
  public void validate(SubstationFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SubstationFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSubstationId(), "SubstationFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to Substations validation for a Substation
   *
   * @param command AssignSubstationsToSubstationCommand
   */
  public void validate(AssignSubstationsToSubstationCommand command) throws Exception {
    Assert.notNull(command, "AssignSubstationsToSubstationCommand should not be null");
    Assert.notNull(
        command.getSubstationId(),
        "AssignSubstationsToSubstationCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignSubstationsToSubstationCommand addTo attribute should not be null");
  }

  /**
   * handles remove from Substations validation for a Substation
   *
   * @param command RemoveSubstationsFromSubstationCommand
   */
  public void validate(RemoveSubstationsFromSubstationCommand command) throws Exception {
    Assert.notNull(command, "RemoveSubstationsFromSubstationCommand should not be null");
    Assert.notNull(
        command.getSubstationId(),
        "RemoveSubstationsFromSubstationCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveSubstationsFromSubstationCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getSubstationId(),
        "RemoveSubstationsFromSubstationCommand removeFrom attribubte identifier should not be null");
  }
}
