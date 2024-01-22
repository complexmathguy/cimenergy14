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

public class TextDiagramObjectValidator {

  /** default constructor */
  protected TextDiagramObjectValidator() {}

  /** factory method */
  public static TextDiagramObjectValidator getInstance() {
    return new TextDiagramObjectValidator();
  }

  /** handles creation validation for a TextDiagramObject */
  public void validate(CreateTextDiagramObjectCommand textDiagramObject) throws Exception {
    Assert.notNull(textDiagramObject, "CreateTextDiagramObjectCommand should not be null");
    //		Assert.isNull( textDiagramObject.getTextDiagramObjectId(), "CreateTextDiagramObjectCommand
    // identifier should be null" );
  }

  /** handles update validation for a TextDiagramObject */
  public void validate(UpdateTextDiagramObjectCommand textDiagramObject) throws Exception {
    Assert.notNull(textDiagramObject, "UpdateTextDiagramObjectCommand should not be null");
    Assert.notNull(
        textDiagramObject.getTextDiagramObjectId(),
        "UpdateTextDiagramObjectCommand identifier should not be null");
  }

  /** handles delete validation for a TextDiagramObject */
  public void validate(DeleteTextDiagramObjectCommand textDiagramObject) throws Exception {
    Assert.notNull(textDiagramObject, "{commandAlias} should not be null");
    Assert.notNull(
        textDiagramObject.getTextDiagramObjectId(),
        "DeleteTextDiagramObjectCommand identifier should not be null");
  }

  /** handles fetchOne validation for a TextDiagramObject */
  public void validate(TextDiagramObjectFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TextDiagramObjectFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTextDiagramObjectId(),
        "TextDiagramObjectFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Text validation for a TextDiagramObject
   *
   * @param command AssignTextToTextDiagramObjectCommand
   */
  public void validate(AssignTextToTextDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "AssignTextToTextDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getTextDiagramObjectId(),
        "AssignTextToTextDiagramObjectCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTextToTextDiagramObjectCommand assignment should not be null");
  }

  /**
   * handles unassign Text validation for a TextDiagramObject
   *
   * @param command UnAssignTextFromTextDiagramObjectCommand
   */
  public void validate(UnAssignTextFromTextDiagramObjectCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTextFromTextDiagramObjectCommand should not be null");
    Assert.notNull(
        command.getTextDiagramObjectId(),
        "UnAssignTextFromTextDiagramObjectCommand identifier should not be null");
  }
}
