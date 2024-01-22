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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity RegularTimePoint.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RegularTimePoint")
public class RegularTimePointQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a RegularTimePoint using a UUID
   *
   * @param UUID regularTimePointId
   * @return RegularTimePoint
   */
  @GetMapping("/load")
  public RegularTimePoint load(@RequestParam(required = true) UUID regularTimePointId) {
    RegularTimePoint entity = null;

    try {
      entity =
          RegularTimePointBusinessDelegate.getRegularTimePointInstance()
              .getRegularTimePoint(new RegularTimePointFetchOneSummary(regularTimePointId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load RegularTimePoint using Id " + regularTimePointId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all RegularTimePoint business objects
   *
   * @return Set<RegularTimePoint>
   */
  @GetMapping("/")
  public List<RegularTimePoint> loadAll() {
    List<RegularTimePoint> regularTimePointList = null;

    try {
      // load the RegularTimePoint
      regularTimePointList =
          RegularTimePointBusinessDelegate.getRegularTimePointInstance().getAllRegularTimePoint();

      if (regularTimePointList != null)
        LOGGER.log(Level.INFO, "successfully loaded all RegularTimePoints");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all RegularTimePoints ", exc);
      return null;
    }

    return regularTimePointList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected RegularTimePoint regularTimePoint = null;
  private static final Logger LOGGER =
      Logger.getLogger(RegularTimePointQueryRestController.class.getName());
}
