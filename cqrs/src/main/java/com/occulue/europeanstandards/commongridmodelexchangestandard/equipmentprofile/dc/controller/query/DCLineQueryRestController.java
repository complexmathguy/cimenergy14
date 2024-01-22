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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity DCLine.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCLine")
public class DCLineQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a DCLine using a UUID
   *
   * @param UUID dCLineId
   * @return DCLine
   */
  @GetMapping("/load")
  public DCLine load(@RequestParam(required = true) UUID dCLineId) {
    DCLine entity = null;

    try {
      entity =
          DCLineBusinessDelegate.getDCLineInstance().getDCLine(new DCLineFetchOneSummary(dCLineId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load DCLine using Id " + dCLineId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all DCLine business objects
   *
   * @return Set<DCLine>
   */
  @GetMapping("/")
  public List<DCLine> loadAll() {
    List<DCLine> dCLineList = null;

    try {
      // load the DCLine
      dCLineList = DCLineBusinessDelegate.getDCLineInstance().getAllDCLine();

      if (dCLineList != null) LOGGER.log(Level.INFO, "successfully loaded all DCLines");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all DCLines ", exc);
      return null;
    }

    return dCLineList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DCLine dCLine = null;
  private static final Logger LOGGER = Logger.getLogger(DCLineQueryRestController.class.getName());
}
