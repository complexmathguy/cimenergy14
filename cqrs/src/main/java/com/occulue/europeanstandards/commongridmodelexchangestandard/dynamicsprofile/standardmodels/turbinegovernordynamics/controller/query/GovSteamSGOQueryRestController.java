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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity GovSteamSGO.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamSGO")
public class GovSteamSGOQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a GovSteamSGO using a UUID
   *
   * @param UUID govSteamSGOId
   * @return GovSteamSGO
   */
  @GetMapping("/load")
  public GovSteamSGO load(@RequestParam(required = true) UUID govSteamSGOId) {
    GovSteamSGO entity = null;

    try {
      entity =
          GovSteamSGOBusinessDelegate.getGovSteamSGOInstance()
              .getGovSteamSGO(new GovSteamSGOFetchOneSummary(govSteamSGOId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load GovSteamSGO using Id " + govSteamSGOId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all GovSteamSGO business objects
   *
   * @return Set<GovSteamSGO>
   */
  @GetMapping("/")
  public List<GovSteamSGO> loadAll() {
    List<GovSteamSGO> govSteamSGOList = null;

    try {
      // load the GovSteamSGO
      govSteamSGOList = GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().getAllGovSteamSGO();

      if (govSteamSGOList != null) LOGGER.log(Level.INFO, "successfully loaded all GovSteamSGOs");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all GovSteamSGOs ", exc);
      return null;
    }

    return govSteamSGOList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovSteamSGO govSteamSGO = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovSteamSGOQueryRestController.class.getName());
}
