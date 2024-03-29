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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity TapSchedule.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TapSchedule")
public class TapScheduleQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a TapSchedule using a UUID
   *
   * @param UUID tapScheduleId
   * @return TapSchedule
   */
  @GetMapping("/load")
  public TapSchedule load(@RequestParam(required = true) UUID tapScheduleId) {
    TapSchedule entity = null;

    try {
      entity =
          TapScheduleBusinessDelegate.getTapScheduleInstance()
              .getTapSchedule(new TapScheduleFetchOneSummary(tapScheduleId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load TapSchedule using Id " + tapScheduleId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all TapSchedule business objects
   *
   * @return Set<TapSchedule>
   */
  @GetMapping("/")
  public List<TapSchedule> loadAll() {
    List<TapSchedule> tapScheduleList = null;

    try {
      // load the TapSchedule
      tapScheduleList = TapScheduleBusinessDelegate.getTapScheduleInstance().getAllTapSchedule();

      if (tapScheduleList != null) LOGGER.log(Level.INFO, "successfully loaded all TapSchedules");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all TapSchedules ", exc);
      return null;
    }

    return tapScheduleList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected TapSchedule tapSchedule = null;
  private static final Logger LOGGER =
      Logger.getLogger(TapScheduleQueryRestController.class.getName());
}
