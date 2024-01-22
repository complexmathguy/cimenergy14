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
 * Implements Spring Controller query CQRS processing for entity DCSeriesDevice.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DCSeriesDevice")
public class DCSeriesDeviceQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a DCSeriesDevice using a UUID
   *
   * @param UUID dCSeriesDeviceId
   * @return DCSeriesDevice
   */
  @GetMapping("/load")
  public DCSeriesDevice load(@RequestParam(required = true) UUID dCSeriesDeviceId) {
    DCSeriesDevice entity = null;

    try {
      entity =
          DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance()
              .getDCSeriesDevice(new DCSeriesDeviceFetchOneSummary(dCSeriesDeviceId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load DCSeriesDevice using Id " + dCSeriesDeviceId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all DCSeriesDevice business objects
   *
   * @return Set<DCSeriesDevice>
   */
  @GetMapping("/")
  public List<DCSeriesDevice> loadAll() {
    List<DCSeriesDevice> dCSeriesDeviceList = null;

    try {
      // load the DCSeriesDevice
      dCSeriesDeviceList =
          DCSeriesDeviceBusinessDelegate.getDCSeriesDeviceInstance().getAllDCSeriesDevice();

      if (dCSeriesDeviceList != null)
        LOGGER.log(Level.INFO, "successfully loaded all DCSeriesDevices");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all DCSeriesDevices ", exc);
      return null;
    }

    return dCSeriesDeviceList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DCSeriesDevice dCSeriesDevice = null;
  private static final Logger LOGGER =
      Logger.getLogger(DCSeriesDeviceQueryRestController.class.getName());
}
