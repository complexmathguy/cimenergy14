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
 * Implements Spring Controller query CQRS processing for entity RotationSpeed.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RotationSpeed")
public class RotationSpeedQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a RotationSpeed using a UUID
   *
   * @param UUID rotationSpeedId
   * @return RotationSpeed
   */
  @GetMapping("/load")
  public RotationSpeed load(@RequestParam(required = true) UUID rotationSpeedId) {
    RotationSpeed entity = null;

    try {
      entity =
          RotationSpeedBusinessDelegate.getRotationSpeedInstance()
              .getRotationSpeed(new RotationSpeedFetchOneSummary(rotationSpeedId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load RotationSpeed using Id " + rotationSpeedId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all RotationSpeed business objects
   *
   * @return Set<RotationSpeed>
   */
  @GetMapping("/")
  public List<RotationSpeed> loadAll() {
    List<RotationSpeed> rotationSpeedList = null;

    try {
      // load the RotationSpeed
      rotationSpeedList =
          RotationSpeedBusinessDelegate.getRotationSpeedInstance().getAllRotationSpeed();

      if (rotationSpeedList != null)
        LOGGER.log(Level.INFO, "successfully loaded all RotationSpeeds");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all RotationSpeeds ", exc);
      return null;
    }

    return rotationSpeedList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected RotationSpeed rotationSpeed = null;
  private static final Logger LOGGER =
      Logger.getLogger(RotationSpeedQueryRestController.class.getName());
}
