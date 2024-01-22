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

public class SubLoadAreaValidator {

  /** default constructor */
  protected SubLoadAreaValidator() {}

  /** factory method */
  public static SubLoadAreaValidator getInstance() {
    return new SubLoadAreaValidator();
  }

  /** handles creation validation for a SubLoadArea */
  public void validate(CreateSubLoadAreaCommand subLoadArea) throws Exception {
    Assert.notNull(subLoadArea, "CreateSubLoadAreaCommand should not be null");
    //		Assert.isNull( subLoadArea.getSubLoadAreaId(), "CreateSubLoadAreaCommand identifier should
    // be null" );
  }

  /** handles update validation for a SubLoadArea */
  public void validate(UpdateSubLoadAreaCommand subLoadArea) throws Exception {
    Assert.notNull(subLoadArea, "UpdateSubLoadAreaCommand should not be null");
    Assert.notNull(
        subLoadArea.getSubLoadAreaId(), "UpdateSubLoadAreaCommand identifier should not be null");
  }

  /** handles delete validation for a SubLoadArea */
  public void validate(DeleteSubLoadAreaCommand subLoadArea) throws Exception {
    Assert.notNull(subLoadArea, "{commandAlias} should not be null");
    Assert.notNull(
        subLoadArea.getSubLoadAreaId(), "DeleteSubLoadAreaCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SubLoadArea */
  public void validate(SubLoadAreaFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SubLoadAreaFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSubLoadAreaId(), "SubLoadAreaFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to SubLoadAreas validation for a SubLoadArea
   *
   * @param command AssignSubLoadAreasToSubLoadAreaCommand
   */
  public void validate(AssignSubLoadAreasToSubLoadAreaCommand command) throws Exception {
    Assert.notNull(command, "AssignSubLoadAreasToSubLoadAreaCommand should not be null");
    Assert.notNull(
        command.getSubLoadAreaId(),
        "AssignSubLoadAreasToSubLoadAreaCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignSubLoadAreasToSubLoadAreaCommand addTo attribute should not be null");
  }

  /**
   * handles remove from SubLoadAreas validation for a SubLoadArea
   *
   * @param command RemoveSubLoadAreasFromSubLoadAreaCommand
   */
  public void validate(RemoveSubLoadAreasFromSubLoadAreaCommand command) throws Exception {
    Assert.notNull(command, "RemoveSubLoadAreasFromSubLoadAreaCommand should not be null");
    Assert.notNull(
        command.getSubLoadAreaId(),
        "RemoveSubLoadAreasFromSubLoadAreaCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveSubLoadAreasFromSubLoadAreaCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getSubLoadAreaId(),
        "RemoveSubLoadAreasFromSubLoadAreaCommand removeFrom attribubte identifier should not be null");
  }
}
