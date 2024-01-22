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
 * Implements Spring Controller query CQRS processing for entity Frequency.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Frequency")
public class FrequencyQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a Frequency using a UUID
   *
   * @param UUID frequencyId
   * @return Frequency
   */
  @GetMapping("/load")
  public Frequency load(@RequestParam(required = true) UUID frequencyId) {
    Frequency entity = null;

    try {
      entity =
          FrequencyBusinessDelegate.getFrequencyInstance()
              .getFrequency(new FrequencyFetchOneSummary(frequencyId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load Frequency using Id " + frequencyId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all Frequency business objects
   *
   * @return Set<Frequency>
   */
  @GetMapping("/")
  public List<Frequency> loadAll() {
    List<Frequency> frequencyList = null;

    try {
      // load the Frequency
      frequencyList = FrequencyBusinessDelegate.getFrequencyInstance().getAllFrequency();

      if (frequencyList != null) LOGGER.log(Level.INFO, "successfully loaded all Frequencys");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all Frequencys ", exc);
      return null;
    }

    return frequencyList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Frequency frequency = null;
  private static final Logger LOGGER =
      Logger.getLogger(FrequencyQueryRestController.class.getName());
}
