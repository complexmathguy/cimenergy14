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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class RatioTapChangerTableValidator {

  /** default constructor */
  protected RatioTapChangerTableValidator() {}

  /** factory method */
  public static RatioTapChangerTableValidator getInstance() {
    return new RatioTapChangerTableValidator();
  }

  /** handles creation validation for a RatioTapChangerTable */
  public void validate(CreateRatioTapChangerTableCommand ratioTapChangerTable) throws Exception {
    Assert.notNull(ratioTapChangerTable, "CreateRatioTapChangerTableCommand should not be null");
    //		Assert.isNull( ratioTapChangerTable.getRatioTapChangerTableId(),
    // "CreateRatioTapChangerTableCommand identifier should be null" );
  }

  /** handles update validation for a RatioTapChangerTable */
  public void validate(UpdateRatioTapChangerTableCommand ratioTapChangerTable) throws Exception {
    Assert.notNull(ratioTapChangerTable, "UpdateRatioTapChangerTableCommand should not be null");
    Assert.notNull(
        ratioTapChangerTable.getRatioTapChangerTableId(),
        "UpdateRatioTapChangerTableCommand identifier should not be null");
  }

  /** handles delete validation for a RatioTapChangerTable */
  public void validate(DeleteRatioTapChangerTableCommand ratioTapChangerTable) throws Exception {
    Assert.notNull(ratioTapChangerTable, "{commandAlias} should not be null");
    Assert.notNull(
        ratioTapChangerTable.getRatioTapChangerTableId(),
        "DeleteRatioTapChangerTableCommand identifier should not be null");
  }

  /** handles fetchOne validation for a RatioTapChangerTable */
  public void validate(RatioTapChangerTableFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "RatioTapChangerTableFetchOneSummary should not be null");
    Assert.notNull(
        summary.getRatioTapChangerTableId(),
        "RatioTapChangerTableFetchOneSummary identifier should not be null");
  }
}
