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
 * Implements Spring Controller query CQRS processing for entity RotatingMachine.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RotatingMachine")
public class RotatingMachineQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a RotatingMachine using a UUID
   *
   * @param UUID rotatingMachineId
   * @return RotatingMachine
   */
  @GetMapping("/load")
  public RotatingMachine load(@RequestParam(required = true) UUID rotatingMachineId) {
    RotatingMachine entity = null;

    try {
      entity =
          RotatingMachineBusinessDelegate.getRotatingMachineInstance()
              .getRotatingMachine(new RotatingMachineFetchOneSummary(rotatingMachineId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load RotatingMachine using Id " + rotatingMachineId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all RotatingMachine business objects
   *
   * @return Set<RotatingMachine>
   */
  @GetMapping("/")
  public List<RotatingMachine> loadAll() {
    List<RotatingMachine> rotatingMachineList = null;

    try {
      // load the RotatingMachine
      rotatingMachineList =
          RotatingMachineBusinessDelegate.getRotatingMachineInstance().getAllRotatingMachine();

      if (rotatingMachineList != null)
        LOGGER.log(Level.INFO, "successfully loaded all RotatingMachines");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all RotatingMachines ", exc);
      return null;
    }

    return rotatingMachineList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected RotatingMachine rotatingMachine = null;
  private static final Logger LOGGER =
      Logger.getLogger(RotatingMachineQueryRestController.class.getName());
}
