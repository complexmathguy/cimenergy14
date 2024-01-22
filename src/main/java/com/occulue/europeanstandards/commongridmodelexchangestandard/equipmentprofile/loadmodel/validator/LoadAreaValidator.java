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

public class LoadAreaValidator {

  /** default constructor */
  protected LoadAreaValidator() {}

  /** factory method */
  public static LoadAreaValidator getInstance() {
    return new LoadAreaValidator();
  }

  /** handles creation validation for a LoadArea */
  public void validate(CreateLoadAreaCommand loadArea) throws Exception {
    Assert.notNull(loadArea, "CreateLoadAreaCommand should not be null");
    //		Assert.isNull( loadArea.getLoadAreaId(), "CreateLoadAreaCommand identifier should be null"
    // );
  }

  /** handles update validation for a LoadArea */
  public void validate(UpdateLoadAreaCommand loadArea) throws Exception {
    Assert.notNull(loadArea, "UpdateLoadAreaCommand should not be null");
    Assert.notNull(loadArea.getLoadAreaId(), "UpdateLoadAreaCommand identifier should not be null");
  }

  /** handles delete validation for a LoadArea */
  public void validate(DeleteLoadAreaCommand loadArea) throws Exception {
    Assert.notNull(loadArea, "{commandAlias} should not be null");
    Assert.notNull(loadArea.getLoadAreaId(), "DeleteLoadAreaCommand identifier should not be null");
  }

  /** handles fetchOne validation for a LoadArea */
  public void validate(LoadAreaFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "LoadAreaFetchOneSummary should not be null");
    Assert.notNull(
        summary.getLoadAreaId(), "LoadAreaFetchOneSummary identifier should not be null");
  }
}
