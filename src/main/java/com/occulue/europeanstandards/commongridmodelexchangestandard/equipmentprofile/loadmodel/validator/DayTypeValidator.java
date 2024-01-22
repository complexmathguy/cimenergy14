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

public class DayTypeValidator {

  /** default constructor */
  protected DayTypeValidator() {}

  /** factory method */
  public static DayTypeValidator getInstance() {
    return new DayTypeValidator();
  }

  /** handles creation validation for a DayType */
  public void validate(CreateDayTypeCommand dayType) throws Exception {
    Assert.notNull(dayType, "CreateDayTypeCommand should not be null");
    //		Assert.isNull( dayType.getDayTypeId(), "CreateDayTypeCommand identifier should be null" );
  }

  /** handles update validation for a DayType */
  public void validate(UpdateDayTypeCommand dayType) throws Exception {
    Assert.notNull(dayType, "UpdateDayTypeCommand should not be null");
    Assert.notNull(dayType.getDayTypeId(), "UpdateDayTypeCommand identifier should not be null");
  }

  /** handles delete validation for a DayType */
  public void validate(DeleteDayTypeCommand dayType) throws Exception {
    Assert.notNull(dayType, "{commandAlias} should not be null");
    Assert.notNull(dayType.getDayTypeId(), "DeleteDayTypeCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DayType */
  public void validate(DayTypeFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DayTypeFetchOneSummary should not be null");
    Assert.notNull(summary.getDayTypeId(), "DayTypeFetchOneSummary identifier should not be null");
  }
}
