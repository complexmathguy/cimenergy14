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
 * Implements Spring Controller query CQRS processing for entity OverexcitationLimiterUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OverexcitationLimiterUserDefined")
public class OverexcitationLimiterUserDefinedQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a OverexcitationLimiterUserDefined using a UUID
   *
   * @param UUID overexcitationLimiterUserDefinedId
   * @return OverexcitationLimiterUserDefined
   */
  @GetMapping("/load")
  public OverexcitationLimiterUserDefined load(
      @RequestParam(required = true) UUID overexcitationLimiterUserDefinedId) {
    OverexcitationLimiterUserDefined entity = null;

    try {
      entity =
          OverexcitationLimiterUserDefinedBusinessDelegate
              .getOverexcitationLimiterUserDefinedInstance()
              .getOverexcitationLimiterUserDefined(
                  new OverexcitationLimiterUserDefinedFetchOneSummary(
                      overexcitationLimiterUserDefinedId));
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "failed to load OverexcitationLimiterUserDefined using Id "
              + overexcitationLimiterUserDefinedId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all OverexcitationLimiterUserDefined business objects
   *
   * @return Set<OverexcitationLimiterUserDefined>
   */
  @GetMapping("/")
  public List<OverexcitationLimiterUserDefined> loadAll() {
    List<OverexcitationLimiterUserDefined> overexcitationLimiterUserDefinedList = null;

    try {
      // load the OverexcitationLimiterUserDefined
      overexcitationLimiterUserDefinedList =
          OverexcitationLimiterUserDefinedBusinessDelegate
              .getOverexcitationLimiterUserDefinedInstance()
              .getAllOverexcitationLimiterUserDefined();

      if (overexcitationLimiterUserDefinedList != null)
        LOGGER.log(Level.INFO, "successfully loaded all OverexcitationLimiterUserDefineds");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all OverexcitationLimiterUserDefineds ", exc);
      return null;
    }

    return overexcitationLimiterUserDefinedList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected OverexcitationLimiterUserDefined overexcitationLimiterUserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(OverexcitationLimiterUserDefinedQueryRestController.class.getName());
}
