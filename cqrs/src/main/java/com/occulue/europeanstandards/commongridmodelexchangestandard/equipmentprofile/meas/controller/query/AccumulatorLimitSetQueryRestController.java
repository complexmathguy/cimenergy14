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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity AccumulatorLimitSet.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AccumulatorLimitSet")
public class AccumulatorLimitSetQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a AccumulatorLimitSet using a UUID
   *
   * @param UUID accumulatorLimitSetId
   * @return AccumulatorLimitSet
   */
  @GetMapping("/load")
  public AccumulatorLimitSet load(@RequestParam(required = true) UUID accumulatorLimitSetId) {
    AccumulatorLimitSet entity = null;

    try {
      entity =
          AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance()
              .getAccumulatorLimitSet(
                  new AccumulatorLimitSetFetchOneSummary(accumulatorLimitSetId));
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING, "failed to load AccumulatorLimitSet using Id " + accumulatorLimitSetId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all AccumulatorLimitSet business objects
   *
   * @return Set<AccumulatorLimitSet>
   */
  @GetMapping("/")
  public List<AccumulatorLimitSet> loadAll() {
    List<AccumulatorLimitSet> accumulatorLimitSetList = null;

    try {
      // load the AccumulatorLimitSet
      accumulatorLimitSetList =
          AccumulatorLimitSetBusinessDelegate.getAccumulatorLimitSetInstance()
              .getAllAccumulatorLimitSet();

      if (accumulatorLimitSetList != null)
        LOGGER.log(Level.INFO, "successfully loaded all AccumulatorLimitSets");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all AccumulatorLimitSets ", exc);
      return null;
    }

    return accumulatorLimitSetList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected AccumulatorLimitSet accumulatorLimitSet = null;
  private static final Logger LOGGER =
      Logger.getLogger(AccumulatorLimitSetQueryRestController.class.getName());
}
