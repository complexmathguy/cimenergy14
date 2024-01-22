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
 * Implements Spring Controller query CQRS processing for entity ExcSCRX.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcSCRX")
public class ExcSCRXQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a ExcSCRX using a UUID
   *
   * @param UUID excSCRXId
   * @return ExcSCRX
   */
  @GetMapping("/load")
  public ExcSCRX load(@RequestParam(required = true) UUID excSCRXId) {
    ExcSCRX entity = null;

    try {
      entity =
          ExcSCRXBusinessDelegate.getExcSCRXInstance()
              .getExcSCRX(new ExcSCRXFetchOneSummary(excSCRXId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load ExcSCRX using Id " + excSCRXId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all ExcSCRX business objects
   *
   * @return Set<ExcSCRX>
   */
  @GetMapping("/")
  public List<ExcSCRX> loadAll() {
    List<ExcSCRX> excSCRXList = null;

    try {
      // load the ExcSCRX
      excSCRXList = ExcSCRXBusinessDelegate.getExcSCRXInstance().getAllExcSCRX();

      if (excSCRXList != null) LOGGER.log(Level.INFO, "successfully loaded all ExcSCRXs");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all ExcSCRXs ", exc);
      return null;
    }

    return excSCRXList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcSCRX excSCRX = null;
  private static final Logger LOGGER = Logger.getLogger(ExcSCRXQueryRestController.class.getName());
}
