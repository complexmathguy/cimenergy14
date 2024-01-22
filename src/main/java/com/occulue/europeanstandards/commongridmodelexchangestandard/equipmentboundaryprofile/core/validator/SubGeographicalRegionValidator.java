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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class SubGeographicalRegionValidator {

  /** default constructor */
  protected SubGeographicalRegionValidator() {}

  /** factory method */
  public static SubGeographicalRegionValidator getInstance() {
    return new SubGeographicalRegionValidator();
  }

  /** handles creation validation for a SubGeographicalRegion */
  public void validate(CreateSubGeographicalRegionCommand subGeographicalRegion) throws Exception {
    Assert.notNull(subGeographicalRegion, "CreateSubGeographicalRegionCommand should not be null");
    //		Assert.isNull( subGeographicalRegion.getSubGeographicalRegionId(),
    // "CreateSubGeographicalRegionCommand identifier should be null" );
  }

  /** handles update validation for a SubGeographicalRegion */
  public void validate(UpdateSubGeographicalRegionCommand subGeographicalRegion) throws Exception {
    Assert.notNull(subGeographicalRegion, "UpdateSubGeographicalRegionCommand should not be null");
    Assert.notNull(
        subGeographicalRegion.getSubGeographicalRegionId(),
        "UpdateSubGeographicalRegionCommand identifier should not be null");
  }

  /** handles delete validation for a SubGeographicalRegion */
  public void validate(DeleteSubGeographicalRegionCommand subGeographicalRegion) throws Exception {
    Assert.notNull(subGeographicalRegion, "{commandAlias} should not be null");
    Assert.notNull(
        subGeographicalRegion.getSubGeographicalRegionId(),
        "DeleteSubGeographicalRegionCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SubGeographicalRegion */
  public void validate(SubGeographicalRegionFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SubGeographicalRegionFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSubGeographicalRegionId(),
        "SubGeographicalRegionFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to Regions validation for a SubGeographicalRegion
   *
   * @param command AssignRegionsToSubGeographicalRegionCommand
   */
  public void validate(AssignRegionsToSubGeographicalRegionCommand command) throws Exception {
    Assert.notNull(command, "AssignRegionsToSubGeographicalRegionCommand should not be null");
    Assert.notNull(
        command.getSubGeographicalRegionId(),
        "AssignRegionsToSubGeographicalRegionCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(),
        "AssignRegionsToSubGeographicalRegionCommand addTo attribute should not be null");
  }

  /**
   * handles remove from Regions validation for a SubGeographicalRegion
   *
   * @param command RemoveRegionsFromSubGeographicalRegionCommand
   */
  public void validate(RemoveRegionsFromSubGeographicalRegionCommand command) throws Exception {
    Assert.notNull(command, "RemoveRegionsFromSubGeographicalRegionCommand should not be null");
    Assert.notNull(
        command.getSubGeographicalRegionId(),
        "RemoveRegionsFromSubGeographicalRegionCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveRegionsFromSubGeographicalRegionCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getSubGeographicalRegionId(),
        "RemoveRegionsFromSubGeographicalRegionCommand removeFrom attribubte identifier should not be null");
  }
}
