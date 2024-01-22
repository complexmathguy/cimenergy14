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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity ACDCConverter.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ACDCConverter")
public class ACDCConverterQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a ACDCConverter using a UUID
   *
   * @param UUID aCDCConverterId
   * @return ACDCConverter
   */
  @GetMapping("/load")
  public ACDCConverter load(@RequestParam(required = true) UUID aCDCConverterId) {
    ACDCConverter entity = null;

    try {
      entity =
          ACDCConverterBusinessDelegate.getACDCConverterInstance()
              .getACDCConverter(new ACDCConverterFetchOneSummary(aCDCConverterId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load ACDCConverter using Id " + aCDCConverterId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all ACDCConverter business objects
   *
   * @return Set<ACDCConverter>
   */
  @GetMapping("/")
  public List<ACDCConverter> loadAll() {
    List<ACDCConverter> aCDCConverterList = null;

    try {
      // load the ACDCConverter
      aCDCConverterList =
          ACDCConverterBusinessDelegate.getACDCConverterInstance().getAllACDCConverter();

      if (aCDCConverterList != null)
        LOGGER.log(Level.INFO, "successfully loaded all ACDCConverters");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all ACDCConverters ", exc);
      return null;
    }

    return aCDCConverterList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ACDCConverter aCDCConverter = null;
  private static final Logger LOGGER =
      Logger.getLogger(ACDCConverterQueryRestController.class.getName());
}
