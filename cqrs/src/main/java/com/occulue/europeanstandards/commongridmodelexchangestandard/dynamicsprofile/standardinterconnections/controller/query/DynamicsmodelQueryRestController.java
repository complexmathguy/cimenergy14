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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardinterconnections.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity Dynamicsmodel.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Dynamicsmodel")
public class DynamicsmodelQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a Dynamicsmodel using a UUID
   *
   * @param UUID dynamicsmodelId
   * @return Dynamicsmodel
   */
  @GetMapping("/load")
  public Dynamicsmodel load(@RequestParam(required = true) UUID dynamicsmodelId) {
    Dynamicsmodel entity = null;

    try {
      entity =
          DynamicsmodelBusinessDelegate.getDynamicsmodelInstance()
              .getDynamicsmodel(new DynamicsmodelFetchOneSummary(dynamicsmodelId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load Dynamicsmodel using Id " + dynamicsmodelId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all Dynamicsmodel business objects
   *
   * @return Set<Dynamicsmodel>
   */
  @GetMapping("/")
  public List<Dynamicsmodel> loadAll() {
    List<Dynamicsmodel> dynamicsmodelList = null;

    try {
      // load the Dynamicsmodel
      dynamicsmodelList =
          DynamicsmodelBusinessDelegate.getDynamicsmodelInstance().getAllDynamicsmodel();

      if (dynamicsmodelList != null)
        LOGGER.log(Level.INFO, "successfully loaded all Dynamicsmodels");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all Dynamicsmodels ", exc);
      return null;
    }

    return dynamicsmodelList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Dynamicsmodel dynamicsmodel = null;
  private static final Logger LOGGER =
      Logger.getLogger(DynamicsmodelQueryRestController.class.getName());
}
