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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity WindGenTurbineType3IEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindGenTurbineType3IEC")
public class WindGenTurbineType3IECQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a WindGenTurbineType3IEC using a UUID
   *
   * @param UUID windGenTurbineType3IECId
   * @return WindGenTurbineType3IEC
   */
  @GetMapping("/load")
  public WindGenTurbineType3IEC load(@RequestParam(required = true) UUID windGenTurbineType3IECId) {
    WindGenTurbineType3IEC entity = null;

    try {
      entity =
          WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance()
              .getWindGenTurbineType3IEC(
                  new WindGenTurbineType3IECFetchOneSummary(windGenTurbineType3IECId));
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "failed to load WindGenTurbineType3IEC using Id " + windGenTurbineType3IECId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all WindGenTurbineType3IEC business objects
   *
   * @return Set<WindGenTurbineType3IEC>
   */
  @GetMapping("/")
  public List<WindGenTurbineType3IEC> loadAll() {
    List<WindGenTurbineType3IEC> windGenTurbineType3IECList = null;

    try {
      // load the WindGenTurbineType3IEC
      windGenTurbineType3IECList =
          WindGenTurbineType3IECBusinessDelegate.getWindGenTurbineType3IECInstance()
              .getAllWindGenTurbineType3IEC();

      if (windGenTurbineType3IECList != null)
        LOGGER.log(Level.INFO, "successfully loaded all WindGenTurbineType3IECs");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all WindGenTurbineType3IECs ", exc);
      return null;
    }

    return windGenTurbineType3IECList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindGenTurbineType3IEC windGenTurbineType3IEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType3IECQueryRestController.class.getName());
}
