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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity ConformLoad.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ConformLoad")
public class ConformLoadQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a ConformLoad using a UUID
   *
   * @param UUID conformLoadId
   * @return ConformLoad
   */
  @GetMapping("/load")
  public ConformLoad load(@RequestParam(required = true) UUID conformLoadId) {
    ConformLoad entity = null;

    try {
      entity =
          ConformLoadBusinessDelegate.getConformLoadInstance()
              .getConformLoad(new ConformLoadFetchOneSummary(conformLoadId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load ConformLoad using Id " + conformLoadId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all ConformLoad business objects
   *
   * @return Set<ConformLoad>
   */
  @GetMapping("/")
  public List<ConformLoad> loadAll() {
    List<ConformLoad> conformLoadList = null;

    try {
      // load the ConformLoad
      conformLoadList = ConformLoadBusinessDelegate.getConformLoadInstance().getAllConformLoad();

      if (conformLoadList != null) LOGGER.log(Level.INFO, "successfully loaded all ConformLoads");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all ConformLoads ", exc);
      return null;
    }

    return conformLoadList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ConformLoad conformLoad = null;
  private static final Logger LOGGER =
      Logger.getLogger(ConformLoadQueryRestController.class.getName());
}
