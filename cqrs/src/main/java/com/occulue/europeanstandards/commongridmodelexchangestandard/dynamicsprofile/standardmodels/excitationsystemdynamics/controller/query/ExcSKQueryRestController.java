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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity ExcSK.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcSK")
public class ExcSKQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a ExcSK using a UUID
   *
   * @param UUID excSKId
   * @return ExcSK
   */
  @GetMapping("/load")
  public ExcSK load(@RequestParam(required = true) UUID excSKId) {
    ExcSK entity = null;

    try {
      entity = ExcSKBusinessDelegate.getExcSKInstance().getExcSK(new ExcSKFetchOneSummary(excSKId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load ExcSK using Id " + excSKId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all ExcSK business objects
   *
   * @return Set<ExcSK>
   */
  @GetMapping("/")
  public List<ExcSK> loadAll() {
    List<ExcSK> excSKList = null;

    try {
      // load the ExcSK
      excSKList = ExcSKBusinessDelegate.getExcSKInstance().getAllExcSK();

      if (excSKList != null) LOGGER.log(Level.INFO, "successfully loaded all ExcSKs");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all ExcSKs ", exc);
      return null;
    }

    return excSKList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcSK excSK = null;
  private static final Logger LOGGER = Logger.getLogger(ExcSKQueryRestController.class.getName());
}
