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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity Pss1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Pss1A")
public class Pss1AQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a Pss1A using a UUID
   *
   * @param UUID pss1AId
   * @return Pss1A
   */
  @GetMapping("/load")
  public Pss1A load(@RequestParam(required = true) UUID pss1AId) {
    Pss1A entity = null;

    try {
      entity = Pss1ABusinessDelegate.getPss1AInstance().getPss1A(new Pss1AFetchOneSummary(pss1AId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load Pss1A using Id " + pss1AId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all Pss1A business objects
   *
   * @return Set<Pss1A>
   */
  @GetMapping("/")
  public List<Pss1A> loadAll() {
    List<Pss1A> pss1AList = null;

    try {
      // load the Pss1A
      pss1AList = Pss1ABusinessDelegate.getPss1AInstance().getAllPss1A();

      if (pss1AList != null) LOGGER.log(Level.INFO, "successfully loaded all Pss1As");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all Pss1As ", exc);
      return null;
    }

    return pss1AList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Pss1A pss1A = null;
  private static final Logger LOGGER = Logger.getLogger(Pss1AQueryRestController.class.getName());
}
