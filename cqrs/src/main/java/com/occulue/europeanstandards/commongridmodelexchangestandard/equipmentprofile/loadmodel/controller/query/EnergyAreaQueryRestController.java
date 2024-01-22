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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity EnergyArea.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EnergyArea")
public class EnergyAreaQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a EnergyArea using a UUID
   *
   * @param UUID energyAreaId
   * @return EnergyArea
   */
  @GetMapping("/load")
  public EnergyArea load(@RequestParam(required = true) UUID energyAreaId) {
    EnergyArea entity = null;

    try {
      entity =
          EnergyAreaBusinessDelegate.getEnergyAreaInstance()
              .getEnergyArea(new EnergyAreaFetchOneSummary(energyAreaId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load EnergyArea using Id " + energyAreaId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all EnergyArea business objects
   *
   * @return Set<EnergyArea>
   */
  @GetMapping("/")
  public List<EnergyArea> loadAll() {
    List<EnergyArea> energyAreaList = null;

    try {
      // load the EnergyArea
      energyAreaList = EnergyAreaBusinessDelegate.getEnergyAreaInstance().getAllEnergyArea();

      if (energyAreaList != null) LOGGER.log(Level.INFO, "successfully loaded all EnergyAreas");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all EnergyAreas ", exc);
      return null;
    }

    return energyAreaList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected EnergyArea energyArea = null;
  private static final Logger LOGGER =
      Logger.getLogger(EnergyAreaQueryRestController.class.getName());
}
