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
 * Implements Spring Controller query CQRS processing for entity DiagramObjectStyle.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiagramObjectStyle")
public class DiagramObjectStyleQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a DiagramObjectStyle using a UUID
   *
   * @param UUID diagramObjectStyleId
   * @return DiagramObjectStyle
   */
  @GetMapping("/load")
  public DiagramObjectStyle load(@RequestParam(required = true) UUID diagramObjectStyleId) {
    DiagramObjectStyle entity = null;

    try {
      entity =
          DiagramObjectStyleBusinessDelegate.getDiagramObjectStyleInstance()
              .getDiagramObjectStyle(new DiagramObjectStyleFetchOneSummary(diagramObjectStyleId));
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING, "failed to load DiagramObjectStyle using Id " + diagramObjectStyleId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all DiagramObjectStyle business objects
   *
   * @return Set<DiagramObjectStyle>
   */
  @GetMapping("/")
  public List<DiagramObjectStyle> loadAll() {
    List<DiagramObjectStyle> diagramObjectStyleList = null;

    try {
      // load the DiagramObjectStyle
      diagramObjectStyleList =
          DiagramObjectStyleBusinessDelegate.getDiagramObjectStyleInstance()
              .getAllDiagramObjectStyle();

      if (diagramObjectStyleList != null)
        LOGGER.log(Level.INFO, "successfully loaded all DiagramObjectStyles");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all DiagramObjectStyles ", exc);
      return null;
    }

    return diagramObjectStyleList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DiagramObjectStyle diagramObjectStyle = null;
  private static final Logger LOGGER =
      Logger.getLogger(DiagramObjectStyleQueryRestController.class.getName());
}
