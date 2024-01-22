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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity BusbarSection.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/BusbarSection")
public class BusbarSectionQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a BusbarSection using a UUID
   *
   * @param UUID busbarSectionId
   * @return BusbarSection
   */
  @GetMapping("/load")
  public BusbarSection load(@RequestParam(required = true) UUID busbarSectionId) {
    BusbarSection entity = null;

    try {
      entity =
          BusbarSectionBusinessDelegate.getBusbarSectionInstance()
              .getBusbarSection(new BusbarSectionFetchOneSummary(busbarSectionId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load BusbarSection using Id " + busbarSectionId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all BusbarSection business objects
   *
   * @return Set<BusbarSection>
   */
  @GetMapping("/")
  public List<BusbarSection> loadAll() {
    List<BusbarSection> busbarSectionList = null;

    try {
      // load the BusbarSection
      busbarSectionList =
          BusbarSectionBusinessDelegate.getBusbarSectionInstance().getAllBusbarSection();

      if (busbarSectionList != null)
        LOGGER.log(Level.INFO, "successfully loaded all BusbarSections");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all BusbarSections ", exc);
      return null;
    }

    return busbarSectionList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected BusbarSection busbarSection = null;
  private static final Logger LOGGER =
      Logger.getLogger(BusbarSectionQueryRestController.class.getName());
}
