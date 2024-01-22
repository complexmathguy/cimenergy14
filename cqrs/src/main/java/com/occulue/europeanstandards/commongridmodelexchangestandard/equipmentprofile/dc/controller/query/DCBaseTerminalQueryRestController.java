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
 * Implements Spring Controller query CQRS processing for entity DCBaseTerminal.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCBaseTerminal")
public class DCBaseTerminalQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a DCBaseTerminal using a UUID
   *
   * @param UUID dCBaseTerminalId
   * @return DCBaseTerminal
   */
  @GetMapping("/load")
  public DCBaseTerminal load(@RequestParam(required = true) UUID dCBaseTerminalId) {
    DCBaseTerminal entity = null;

    try {
      entity =
          DCBaseTerminalBusinessDelegate.getDCBaseTerminalInstance()
              .getDCBaseTerminal(new DCBaseTerminalFetchOneSummary(dCBaseTerminalId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load DCBaseTerminal using Id " + dCBaseTerminalId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all DCBaseTerminal business objects
   *
   * @return Set<DCBaseTerminal>
   */
  @GetMapping("/")
  public List<DCBaseTerminal> loadAll() {
    List<DCBaseTerminal> dCBaseTerminalList = null;

    try {
      // load the DCBaseTerminal
      dCBaseTerminalList =
          DCBaseTerminalBusinessDelegate.getDCBaseTerminalInstance().getAllDCBaseTerminal();

      if (dCBaseTerminalList != null)
        LOGGER.log(Level.INFO, "successfully loaded all DCBaseTerminals");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all DCBaseTerminals ", exc);
      return null;
    }

    return dCBaseTerminalList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DCBaseTerminal dCBaseTerminal = null;
  private static final Logger LOGGER =
      Logger.getLogger(DCBaseTerminalQueryRestController.class.getName());
}
