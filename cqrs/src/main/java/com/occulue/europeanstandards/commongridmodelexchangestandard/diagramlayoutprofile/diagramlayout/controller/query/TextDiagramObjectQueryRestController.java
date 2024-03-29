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
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.controller.query;

import com.occulue.api.*;
import com.occulue.controller.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Implements Spring Controller query CQRS processing for entity TextDiagramObject.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TextDiagramObject")
public class TextDiagramObjectQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a TextDiagramObject using a UUID
   *
   * @param UUID textDiagramObjectId
   * @return TextDiagramObject
   */
  @GetMapping("/load")
  public TextDiagramObject load(@RequestParam(required = true) UUID textDiagramObjectId) {
    TextDiagramObject entity = null;

    try {
      entity =
          TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance()
              .getTextDiagramObject(new TextDiagramObjectFetchOneSummary(textDiagramObjectId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load TextDiagramObject using Id " + textDiagramObjectId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all TextDiagramObject business objects
   *
   * @return Set<TextDiagramObject>
   */
  @GetMapping("/")
  public List<TextDiagramObject> loadAll() {
    List<TextDiagramObject> textDiagramObjectList = null;

    try {
      // load the TextDiagramObject
      textDiagramObjectList =
          TextDiagramObjectBusinessDelegate.getTextDiagramObjectInstance()
              .getAllTextDiagramObject();

      if (textDiagramObjectList != null)
        LOGGER.log(Level.INFO, "successfully loaded all TextDiagramObjects");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all TextDiagramObjects ", exc);
      return null;
    }

    return textDiagramObjectList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected TextDiagramObject textDiagramObject = null;
  private static final Logger LOGGER =
      Logger.getLogger(TextDiagramObjectQueryRestController.class.getName());
}
