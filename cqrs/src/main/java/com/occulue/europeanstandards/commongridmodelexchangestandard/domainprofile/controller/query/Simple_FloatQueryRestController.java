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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity Simple_Float.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Simple_Float")
public class Simple_FloatQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a Simple_Float using a UUID
   *
   * @param UUID simple_FloatId
   * @return Simple_Float
   */
  @GetMapping("/load")
  public Simple_Float load(@RequestParam(required = true) UUID simple_FloatId) {
    Simple_Float entity = null;

    try {
      entity =
          Simple_FloatBusinessDelegate.getSimple_FloatInstance()
              .getSimple_Float(new Simple_FloatFetchOneSummary(simple_FloatId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load Simple_Float using Id " + simple_FloatId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all Simple_Float business objects
   *
   * @return Set<Simple_Float>
   */
  @GetMapping("/")
  public List<Simple_Float> loadAll() {
    List<Simple_Float> simple_FloatList = null;

    try {
      // load the Simple_Float
      simple_FloatList =
          Simple_FloatBusinessDelegate.getSimple_FloatInstance().getAllSimple_Float();

      if (simple_FloatList != null) LOGGER.log(Level.INFO, "successfully loaded all Simple_Floats");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all Simple_Floats ", exc);
      return null;
    }

    return simple_FloatList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Simple_Float simple_Float = null;
  private static final Logger LOGGER =
      Logger.getLogger(Simple_FloatQueryRestController.class.getName());
}
