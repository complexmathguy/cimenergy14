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
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class DiagramObjectGluePointValidator {

  /** default constructor */
  protected DiagramObjectGluePointValidator() {}

  /** factory method */
  public static DiagramObjectGluePointValidator getInstance() {
    return new DiagramObjectGluePointValidator();
  }

  /** handles creation validation for a DiagramObjectGluePoint */
  public void validate(CreateDiagramObjectGluePointCommand diagramObjectGluePoint)
      throws Exception {
    Assert.notNull(
        diagramObjectGluePoint, "CreateDiagramObjectGluePointCommand should not be null");
    //		Assert.isNull( diagramObjectGluePoint.getDiagramObjectGluePointId(),
    // "CreateDiagramObjectGluePointCommand identifier should be null" );
  }

  /** handles update validation for a DiagramObjectGluePoint */
  public void validate(UpdateDiagramObjectGluePointCommand diagramObjectGluePoint)
      throws Exception {
    Assert.notNull(
        diagramObjectGluePoint, "UpdateDiagramObjectGluePointCommand should not be null");
    Assert.notNull(
        diagramObjectGluePoint.getDiagramObjectGluePointId(),
        "UpdateDiagramObjectGluePointCommand identifier should not be null");
  }

  /** handles delete validation for a DiagramObjectGluePoint */
  public void validate(DeleteDiagramObjectGluePointCommand diagramObjectGluePoint)
      throws Exception {
    Assert.notNull(diagramObjectGluePoint, "{commandAlias} should not be null");
    Assert.notNull(
        diagramObjectGluePoint.getDiagramObjectGluePointId(),
        "DeleteDiagramObjectGluePointCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DiagramObjectGluePoint */
  public void validate(DiagramObjectGluePointFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DiagramObjectGluePointFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDiagramObjectGluePointId(),
        "DiagramObjectGluePointFetchOneSummary identifier should not be null");
  }
}
