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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DCLineValidator {

  /** default constructor */
  protected DCLineValidator() {}

  /** factory method */
  public static DCLineValidator getInstance() {
    return new DCLineValidator();
  }

  /** handles creation validation for a DCLine */
  public void validate(CreateDCLineCommand dCLine) throws Exception {
    Assert.notNull(dCLine, "CreateDCLineCommand should not be null");
    //		Assert.isNull( dCLine.getDCLineId(), "CreateDCLineCommand identifier should be null" );
  }

  /** handles update validation for a DCLine */
  public void validate(UpdateDCLineCommand dCLine) throws Exception {
    Assert.notNull(dCLine, "UpdateDCLineCommand should not be null");
    Assert.notNull(dCLine.getDCLineId(), "UpdateDCLineCommand identifier should not be null");
  }

  /** handles delete validation for a DCLine */
  public void validate(DeleteDCLineCommand dCLine) throws Exception {
    Assert.notNull(dCLine, "{commandAlias} should not be null");
    Assert.notNull(dCLine.getDCLineId(), "DeleteDCLineCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DCLine */
  public void validate(DCLineFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DCLineFetchOneSummary should not be null");
    Assert.notNull(summary.getDCLineId(), "DCLineFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to DCLines validation for a DCLine
   *
   * @param command AssignDCLinesToDCLineCommand
   */
  public void validate(AssignDCLinesToDCLineCommand command) throws Exception {
    Assert.notNull(command, "AssignDCLinesToDCLineCommand should not be null");
    Assert.notNull(
        command.getDCLineId(), "AssignDCLinesToDCLineCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(), "AssignDCLinesToDCLineCommand addTo attribute should not be null");
  }

  /**
   * handles remove from DCLines validation for a DCLine
   *
   * @param command RemoveDCLinesFromDCLineCommand
   */
  public void validate(RemoveDCLinesFromDCLineCommand command) throws Exception {
    Assert.notNull(command, "RemoveDCLinesFromDCLineCommand should not be null");
    Assert.notNull(
        command.getDCLineId(), "RemoveDCLinesFromDCLineCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveDCLinesFromDCLineCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getDCLineId(),
        "RemoveDCLinesFromDCLineCommand removeFrom attribubte identifier should not be null");
  }
}
