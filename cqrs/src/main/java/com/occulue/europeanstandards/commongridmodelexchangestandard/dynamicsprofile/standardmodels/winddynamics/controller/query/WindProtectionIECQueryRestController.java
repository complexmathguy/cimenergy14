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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity WindProtectionIEC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindProtectionIEC")
public class WindProtectionIECQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a WindProtectionIEC using a UUID
   *
   * @param UUID windProtectionIECId
   * @return WindProtectionIEC
   */
  @GetMapping("/load")
  public WindProtectionIEC load(@RequestParam(required = true) UUID windProtectionIECId) {
    WindProtectionIEC entity = null;

    try {
      entity =
          WindProtectionIECBusinessDelegate.getWindProtectionIECInstance()
              .getWindProtectionIEC(new WindProtectionIECFetchOneSummary(windProtectionIECId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load WindProtectionIEC using Id " + windProtectionIECId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all WindProtectionIEC business objects
   *
   * @return Set<WindProtectionIEC>
   */
  @GetMapping("/")
  public List<WindProtectionIEC> loadAll() {
    List<WindProtectionIEC> windProtectionIECList = null;

    try {
      // load the WindProtectionIEC
      windProtectionIECList =
          WindProtectionIECBusinessDelegate.getWindProtectionIECInstance()
              .getAllWindProtectionIEC();

      if (windProtectionIECList != null)
        LOGGER.log(Level.INFO, "successfully loaded all WindProtectionIECs");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all WindProtectionIECs ", exc);
      return null;
    }

    return windProtectionIECList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindProtectionIEC windProtectionIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindProtectionIECQueryRestController.class.getName());
}
