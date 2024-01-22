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
 * Implements Spring Controller query CQRS processing for entity RatioTapChangerTable.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RatioTapChangerTable")
public class RatioTapChangerTableQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a RatioTapChangerTable using a UUID
   *
   * @param UUID ratioTapChangerTableId
   * @return RatioTapChangerTable
   */
  @GetMapping("/load")
  public RatioTapChangerTable load(@RequestParam(required = true) UUID ratioTapChangerTableId) {
    RatioTapChangerTable entity = null;

    try {
      entity =
          RatioTapChangerTableBusinessDelegate.getRatioTapChangerTableInstance()
              .getRatioTapChangerTable(
                  new RatioTapChangerTableFetchOneSummary(ratioTapChangerTableId));
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING, "failed to load RatioTapChangerTable using Id " + ratioTapChangerTableId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all RatioTapChangerTable business objects
   *
   * @return Set<RatioTapChangerTable>
   */
  @GetMapping("/")
  public List<RatioTapChangerTable> loadAll() {
    List<RatioTapChangerTable> ratioTapChangerTableList = null;

    try {
      // load the RatioTapChangerTable
      ratioTapChangerTableList =
          RatioTapChangerTableBusinessDelegate.getRatioTapChangerTableInstance()
              .getAllRatioTapChangerTable();

      if (ratioTapChangerTableList != null)
        LOGGER.log(Level.INFO, "successfully loaded all RatioTapChangerTables");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all RatioTapChangerTables ", exc);
      return null;
    }

    return ratioTapChangerTableList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected RatioTapChangerTable ratioTapChangerTable = null;
  private static final Logger LOGGER =
      Logger.getLogger(RatioTapChangerTableQueryRestController.class.getName());
}
