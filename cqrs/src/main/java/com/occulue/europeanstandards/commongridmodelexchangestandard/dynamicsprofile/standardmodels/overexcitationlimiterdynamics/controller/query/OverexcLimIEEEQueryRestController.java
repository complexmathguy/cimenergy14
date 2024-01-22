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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity OverexcLimIEEE.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OverexcLimIEEE")
public class OverexcLimIEEEQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a OverexcLimIEEE using a UUID
   *
   * @param UUID overexcLimIEEEId
   * @return OverexcLimIEEE
   */
  @GetMapping("/load")
  public OverexcLimIEEE load(@RequestParam(required = true) UUID overexcLimIEEEId) {
    OverexcLimIEEE entity = null;

    try {
      entity =
          OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance()
              .getOverexcLimIEEE(new OverexcLimIEEEFetchOneSummary(overexcLimIEEEId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load OverexcLimIEEE using Id " + overexcLimIEEEId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all OverexcLimIEEE business objects
   *
   * @return Set<OverexcLimIEEE>
   */
  @GetMapping("/")
  public List<OverexcLimIEEE> loadAll() {
    List<OverexcLimIEEE> overexcLimIEEEList = null;

    try {
      // load the OverexcLimIEEE
      overexcLimIEEEList =
          OverexcLimIEEEBusinessDelegate.getOverexcLimIEEEInstance().getAllOverexcLimIEEE();

      if (overexcLimIEEEList != null)
        LOGGER.log(Level.INFO, "successfully loaded all OverexcLimIEEEs");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all OverexcLimIEEEs ", exc);
      return null;
    }

    return overexcLimIEEEList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected OverexcLimIEEE overexcLimIEEE = null;
  private static final Logger LOGGER =
      Logger.getLogger(OverexcLimIEEEQueryRestController.class.getName());
}
