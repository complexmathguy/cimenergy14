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

public class PhaseTapChangerTableValidator {

  /** default constructor */
  protected PhaseTapChangerTableValidator() {}

  /** factory method */
  public static PhaseTapChangerTableValidator getInstance() {
    return new PhaseTapChangerTableValidator();
  }

  /** handles creation validation for a PhaseTapChangerTable */
  public void validate(CreatePhaseTapChangerTableCommand phaseTapChangerTable) throws Exception {
    Assert.notNull(phaseTapChangerTable, "CreatePhaseTapChangerTableCommand should not be null");
    //		Assert.isNull( phaseTapChangerTable.getPhaseTapChangerTableId(),
    // "CreatePhaseTapChangerTableCommand identifier should be null" );
  }

  /** handles update validation for a PhaseTapChangerTable */
  public void validate(UpdatePhaseTapChangerTableCommand phaseTapChangerTable) throws Exception {
    Assert.notNull(phaseTapChangerTable, "UpdatePhaseTapChangerTableCommand should not be null");
    Assert.notNull(
        phaseTapChangerTable.getPhaseTapChangerTableId(),
        "UpdatePhaseTapChangerTableCommand identifier should not be null");
  }

  /** handles delete validation for a PhaseTapChangerTable */
  public void validate(DeletePhaseTapChangerTableCommand phaseTapChangerTable) throws Exception {
    Assert.notNull(phaseTapChangerTable, "{commandAlias} should not be null");
    Assert.notNull(
        phaseTapChangerTable.getPhaseTapChangerTableId(),
        "DeletePhaseTapChangerTableCommand identifier should not be null");
  }

  /** handles fetchOne validation for a PhaseTapChangerTable */
  public void validate(PhaseTapChangerTableFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "PhaseTapChangerTableFetchOneSummary should not be null");
    Assert.notNull(
        summary.getPhaseTapChangerTableId(),
        "PhaseTapChangerTableFetchOneSummary identifier should not be null");
  }
}
