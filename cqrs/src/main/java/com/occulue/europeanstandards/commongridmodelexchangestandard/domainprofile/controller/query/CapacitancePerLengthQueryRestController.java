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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity CapacitancePerLength.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/CapacitancePerLength")
public class CapacitancePerLengthQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a CapacitancePerLength using a UUID
   *
   * @param UUID capacitancePerLengthId
   * @return CapacitancePerLength
   */
  @GetMapping("/load")
  public CapacitancePerLength load(@RequestParam(required = true) UUID capacitancePerLengthId) {
    CapacitancePerLength entity = null;

    try {
      entity =
          CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance()
              .getCapacitancePerLength(
                  new CapacitancePerLengthFetchOneSummary(capacitancePerLengthId));
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING, "failed to load CapacitancePerLength using Id " + capacitancePerLengthId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all CapacitancePerLength business objects
   *
   * @return Set<CapacitancePerLength>
   */
  @GetMapping("/")
  public List<CapacitancePerLength> loadAll() {
    List<CapacitancePerLength> capacitancePerLengthList = null;

    try {
      // load the CapacitancePerLength
      capacitancePerLengthList =
          CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance()
              .getAllCapacitancePerLength();

      if (capacitancePerLengthList != null)
        LOGGER.log(Level.INFO, "successfully loaded all CapacitancePerLengths");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all CapacitancePerLengths ", exc);
      return null;
    }

    return capacitancePerLengthList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected CapacitancePerLength capacitancePerLength = null;
  private static final Logger LOGGER =
      Logger.getLogger(CapacitancePerLengthQueryRestController.class.getName());
}
