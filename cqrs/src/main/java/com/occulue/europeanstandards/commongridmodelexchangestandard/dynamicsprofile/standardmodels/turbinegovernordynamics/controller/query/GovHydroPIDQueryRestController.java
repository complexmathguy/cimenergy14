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
 * Implements Spring Controller query CQRS processing for entity GovHydroPID.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroPID")
public class GovHydroPIDQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a GovHydroPID using a UUID
   *
   * @param UUID govHydroPIDId
   * @return GovHydroPID
   */
  @GetMapping("/load")
  public GovHydroPID load(@RequestParam(required = true) UUID govHydroPIDId) {
    GovHydroPID entity = null;

    try {
      entity =
          GovHydroPIDBusinessDelegate.getGovHydroPIDInstance()
              .getGovHydroPID(new GovHydroPIDFetchOneSummary(govHydroPIDId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load GovHydroPID using Id " + govHydroPIDId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all GovHydroPID business objects
   *
   * @return Set<GovHydroPID>
   */
  @GetMapping("/")
  public List<GovHydroPID> loadAll() {
    List<GovHydroPID> govHydroPIDList = null;

    try {
      // load the GovHydroPID
      govHydroPIDList = GovHydroPIDBusinessDelegate.getGovHydroPIDInstance().getAllGovHydroPID();

      if (govHydroPIDList != null) LOGGER.log(Level.INFO, "successfully loaded all GovHydroPIDs");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all GovHydroPIDs ", exc);
      return null;
    }

    return govHydroPIDList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydroPID govHydroPID = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroPIDQueryRestController.class.getName());
}
