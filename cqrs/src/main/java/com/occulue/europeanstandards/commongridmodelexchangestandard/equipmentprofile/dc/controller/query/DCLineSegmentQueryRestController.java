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
 * Implements Spring Controller query CQRS processing for entity DCLineSegment.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCLineSegment")
public class DCLineSegmentQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a DCLineSegment using a UUID
   *
   * @param UUID dCLineSegmentId
   * @return DCLineSegment
   */
  @GetMapping("/load")
  public DCLineSegment load(@RequestParam(required = true) UUID dCLineSegmentId) {
    DCLineSegment entity = null;

    try {
      entity =
          DCLineSegmentBusinessDelegate.getDCLineSegmentInstance()
              .getDCLineSegment(new DCLineSegmentFetchOneSummary(dCLineSegmentId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load DCLineSegment using Id " + dCLineSegmentId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all DCLineSegment business objects
   *
   * @return Set<DCLineSegment>
   */
  @GetMapping("/")
  public List<DCLineSegment> loadAll() {
    List<DCLineSegment> dCLineSegmentList = null;

    try {
      // load the DCLineSegment
      dCLineSegmentList =
          DCLineSegmentBusinessDelegate.getDCLineSegmentInstance().getAllDCLineSegment();

      if (dCLineSegmentList != null)
        LOGGER.log(Level.INFO, "successfully loaded all DCLineSegments");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all DCLineSegments ", exc);
      return null;
    }

    return dCLineSegmentList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DCLineSegment dCLineSegment = null;
  private static final Logger LOGGER =
      Logger.getLogger(DCLineSegmentQueryRestController.class.getName());
}
