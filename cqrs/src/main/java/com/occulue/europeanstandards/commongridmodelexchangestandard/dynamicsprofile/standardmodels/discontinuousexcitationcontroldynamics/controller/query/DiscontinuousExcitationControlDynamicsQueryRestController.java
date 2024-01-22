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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.controller.query;

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
 * DiscontinuousExcitationControlDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiscontinuousExcitationControlDynamics")
public class DiscontinuousExcitationControlDynamicsQueryRestController
    extends BaseSpringRestController {

  /**
   * Handles loading a DiscontinuousExcitationControlDynamics using a UUID
   *
   * @param UUID discontinuousExcitationControlDynamicsId
   * @return DiscontinuousExcitationControlDynamics
   */
  @GetMapping("/load")
  public DiscontinuousExcitationControlDynamics load(
      @RequestParam(required = true) UUID discontinuousExcitationControlDynamicsId) {
    DiscontinuousExcitationControlDynamics entity = null;

    try {
      entity =
          DiscontinuousExcitationControlDynamicsBusinessDelegate
              .getDiscontinuousExcitationControlDynamicsInstance()
              .getDiscontinuousExcitationControlDynamics(
                  new DiscontinuousExcitationControlDynamicsFetchOneSummary(
                      discontinuousExcitationControlDynamicsId));
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "failed to load DiscontinuousExcitationControlDynamics using Id "
              + discontinuousExcitationControlDynamicsId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all DiscontinuousExcitationControlDynamics business objects
   *
   * @return Set<DiscontinuousExcitationControlDynamics>
   */
  @GetMapping("/")
  public List<DiscontinuousExcitationControlDynamics> loadAll() {
    List<DiscontinuousExcitationControlDynamics> discontinuousExcitationControlDynamicsList = null;

    try {
      // load the DiscontinuousExcitationControlDynamics
      discontinuousExcitationControlDynamicsList =
          DiscontinuousExcitationControlDynamicsBusinessDelegate
              .getDiscontinuousExcitationControlDynamicsInstance()
              .getAllDiscontinuousExcitationControlDynamics();

      if (discontinuousExcitationControlDynamicsList != null)
        LOGGER.log(Level.INFO, "successfully loaded all DiscontinuousExcitationControlDynamicss");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all DiscontinuousExcitationControlDynamicss ", exc);
      return null;
    }

    return discontinuousExcitationControlDynamicsList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DiscontinuousExcitationControlDynamics discontinuousExcitationControlDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(DiscontinuousExcitationControlDynamicsQueryRestController.class.getName());
}
