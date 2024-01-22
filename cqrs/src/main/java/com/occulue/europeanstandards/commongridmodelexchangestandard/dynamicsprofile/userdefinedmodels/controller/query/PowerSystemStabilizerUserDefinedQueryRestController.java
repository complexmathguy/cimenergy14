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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity PowerSystemStabilizerUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PowerSystemStabilizerUserDefined")
public class PowerSystemStabilizerUserDefinedQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a PowerSystemStabilizerUserDefined using a UUID
   *
   * @param UUID powerSystemStabilizerUserDefinedId
   * @return PowerSystemStabilizerUserDefined
   */
  @GetMapping("/load")
  public PowerSystemStabilizerUserDefined load(
      @RequestParam(required = true) UUID powerSystemStabilizerUserDefinedId) {
    PowerSystemStabilizerUserDefined entity = null;

    try {
      entity =
          PowerSystemStabilizerUserDefinedBusinessDelegate
              .getPowerSystemStabilizerUserDefinedInstance()
              .getPowerSystemStabilizerUserDefined(
                  new PowerSystemStabilizerUserDefinedFetchOneSummary(
                      powerSystemStabilizerUserDefinedId));
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "failed to load PowerSystemStabilizerUserDefined using Id "
              + powerSystemStabilizerUserDefinedId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all PowerSystemStabilizerUserDefined business objects
   *
   * @return Set<PowerSystemStabilizerUserDefined>
   */
  @GetMapping("/")
  public List<PowerSystemStabilizerUserDefined> loadAll() {
    List<PowerSystemStabilizerUserDefined> powerSystemStabilizerUserDefinedList = null;

    try {
      // load the PowerSystemStabilizerUserDefined
      powerSystemStabilizerUserDefinedList =
          PowerSystemStabilizerUserDefinedBusinessDelegate
              .getPowerSystemStabilizerUserDefinedInstance()
              .getAllPowerSystemStabilizerUserDefined();

      if (powerSystemStabilizerUserDefinedList != null)
        LOGGER.log(Level.INFO, "successfully loaded all PowerSystemStabilizerUserDefineds");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all PowerSystemStabilizerUserDefineds ", exc);
      return null;
    }

    return powerSystemStabilizerUserDefinedList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PowerSystemStabilizerUserDefined powerSystemStabilizerUserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(PowerSystemStabilizerUserDefinedQueryRestController.class.getName());
}
