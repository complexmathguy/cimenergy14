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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.asynchronousmachinedynamics.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity
 * AsynchronousMachineTimeConstantReactance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/AsynchronousMachineTimeConstantReactance")
public class AsynchronousMachineTimeConstantReactanceQueryRestController
    extends BaseSpringRestController {

  /**
   * Handles loading a AsynchronousMachineTimeConstantReactance using a UUID
   *
   * @param UUID asynchronousMachineTimeConstantReactanceId
   * @return AsynchronousMachineTimeConstantReactance
   */
  @GetMapping("/load")
  public AsynchronousMachineTimeConstantReactance load(
      @RequestParam(required = true) UUID asynchronousMachineTimeConstantReactanceId) {
    AsynchronousMachineTimeConstantReactance entity = null;

    try {
      entity =
          AsynchronousMachineTimeConstantReactanceBusinessDelegate
              .getAsynchronousMachineTimeConstantReactanceInstance()
              .getAsynchronousMachineTimeConstantReactance(
                  new AsynchronousMachineTimeConstantReactanceFetchOneSummary(
                      asynchronousMachineTimeConstantReactanceId));
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "failed to load AsynchronousMachineTimeConstantReactance using Id "
              + asynchronousMachineTimeConstantReactanceId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all AsynchronousMachineTimeConstantReactance business objects
   *
   * @return Set<AsynchronousMachineTimeConstantReactance>
   */
  @GetMapping("/")
  public List<AsynchronousMachineTimeConstantReactance> loadAll() {
    List<AsynchronousMachineTimeConstantReactance> asynchronousMachineTimeConstantReactanceList =
        null;

    try {
      // load the AsynchronousMachineTimeConstantReactance
      asynchronousMachineTimeConstantReactanceList =
          AsynchronousMachineTimeConstantReactanceBusinessDelegate
              .getAsynchronousMachineTimeConstantReactanceInstance()
              .getAllAsynchronousMachineTimeConstantReactance();

      if (asynchronousMachineTimeConstantReactanceList != null)
        LOGGER.log(Level.INFO, "successfully loaded all AsynchronousMachineTimeConstantReactances");
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING, "failed to load all AsynchronousMachineTimeConstantReactances ", exc);
      return null;
    }

    return asynchronousMachineTimeConstantReactanceList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected AsynchronousMachineTimeConstantReactance asynchronousMachineTimeConstantReactance =
      null;
  private static final Logger LOGGER =
      Logger.getLogger(AsynchronousMachineTimeConstantReactanceQueryRestController.class.getName());
}
