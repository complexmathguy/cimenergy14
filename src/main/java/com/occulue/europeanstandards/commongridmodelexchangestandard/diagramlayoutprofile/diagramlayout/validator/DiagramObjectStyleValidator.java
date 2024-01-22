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

public class DiagramObjectStyleValidator {

  /** default constructor */
  protected DiagramObjectStyleValidator() {}

  /** factory method */
  public static DiagramObjectStyleValidator getInstance() {
    return new DiagramObjectStyleValidator();
  }

  /** handles creation validation for a DiagramObjectStyle */
  public void validate(CreateDiagramObjectStyleCommand diagramObjectStyle) throws Exception {
    Assert.notNull(diagramObjectStyle, "CreateDiagramObjectStyleCommand should not be null");
    //		Assert.isNull( diagramObjectStyle.getDiagramObjectStyleId(),
    // "CreateDiagramObjectStyleCommand identifier should be null" );
  }

  /** handles update validation for a DiagramObjectStyle */
  public void validate(UpdateDiagramObjectStyleCommand diagramObjectStyle) throws Exception {
    Assert.notNull(diagramObjectStyle, "UpdateDiagramObjectStyleCommand should not be null");
    Assert.notNull(
        diagramObjectStyle.getDiagramObjectStyleId(),
        "UpdateDiagramObjectStyleCommand identifier should not be null");
  }

  /** handles delete validation for a DiagramObjectStyle */
  public void validate(DeleteDiagramObjectStyleCommand diagramObjectStyle) throws Exception {
    Assert.notNull(diagramObjectStyle, "{commandAlias} should not be null");
    Assert.notNull(
        diagramObjectStyle.getDiagramObjectStyleId(),
        "DeleteDiagramObjectStyleCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DiagramObjectStyle */
  public void validate(DiagramObjectStyleFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DiagramObjectStyleFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDiagramObjectStyleId(),
        "DiagramObjectStyleFetchOneSummary identifier should not be null");
  }
}
