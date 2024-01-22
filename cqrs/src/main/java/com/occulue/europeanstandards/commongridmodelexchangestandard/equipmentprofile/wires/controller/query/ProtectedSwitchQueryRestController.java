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
 * Implements Spring Controller query CQRS processing for entity ProtectedSwitch.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ProtectedSwitch")
public class ProtectedSwitchQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a ProtectedSwitch using a UUID
   *
   * @param UUID protectedSwitchId
   * @return ProtectedSwitch
   */
  @GetMapping("/load")
  public ProtectedSwitch load(@RequestParam(required = true) UUID protectedSwitchId) {
    ProtectedSwitch entity = null;

    try {
      entity =
          ProtectedSwitchBusinessDelegate.getProtectedSwitchInstance()
              .getProtectedSwitch(new ProtectedSwitchFetchOneSummary(protectedSwitchId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load ProtectedSwitch using Id " + protectedSwitchId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all ProtectedSwitch business objects
   *
   * @return Set<ProtectedSwitch>
   */
  @GetMapping("/")
  public List<ProtectedSwitch> loadAll() {
    List<ProtectedSwitch> protectedSwitchList = null;

    try {
      // load the ProtectedSwitch
      protectedSwitchList =
          ProtectedSwitchBusinessDelegate.getProtectedSwitchInstance().getAllProtectedSwitch();

      if (protectedSwitchList != null)
        LOGGER.log(Level.INFO, "successfully loaded all ProtectedSwitchs");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all ProtectedSwitchs ", exc);
      return null;
    }

    return protectedSwitchList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ProtectedSwitch protectedSwitch = null;
  private static final Logger LOGGER =
      Logger.getLogger(ProtectedSwitchQueryRestController.class.getName());
}
