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
 * Implements Spring Controller query CQRS processing for entity AnalogValue.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AnalogValue")
public class AnalogValueQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a AnalogValue using a UUID
   *
   * @param UUID analogValueId
   * @return AnalogValue
   */
  @GetMapping("/load")
  public AnalogValue load(@RequestParam(required = true) UUID analogValueId) {
    AnalogValue entity = null;

    try {
      entity =
          AnalogValueBusinessDelegate.getAnalogValueInstance()
              .getAnalogValue(new AnalogValueFetchOneSummary(analogValueId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load AnalogValue using Id " + analogValueId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all AnalogValue business objects
   *
   * @return Set<AnalogValue>
   */
  @GetMapping("/")
  public List<AnalogValue> loadAll() {
    List<AnalogValue> analogValueList = null;

    try {
      // load the AnalogValue
      analogValueList = AnalogValueBusinessDelegate.getAnalogValueInstance().getAllAnalogValue();

      if (analogValueList != null) LOGGER.log(Level.INFO, "successfully loaded all AnalogValues");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all AnalogValues ", exc);
      return null;
    }

    return analogValueList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected AnalogValue analogValue = null;
  private static final Logger LOGGER =
      Logger.getLogger(AnalogValueQueryRestController.class.getName());
}
