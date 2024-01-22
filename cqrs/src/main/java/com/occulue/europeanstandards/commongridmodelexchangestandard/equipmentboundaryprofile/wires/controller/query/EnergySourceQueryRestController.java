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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity EnergySource.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EnergySource")
public class EnergySourceQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a EnergySource using a UUID
   *
   * @param UUID energySourceId
   * @return EnergySource
   */
  @GetMapping("/load")
  public EnergySource load(@RequestParam(required = true) UUID energySourceId) {
    EnergySource entity = null;

    try {
      entity =
          EnergySourceBusinessDelegate.getEnergySourceInstance()
              .getEnergySource(new EnergySourceFetchOneSummary(energySourceId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load EnergySource using Id " + energySourceId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all EnergySource business objects
   *
   * @return Set<EnergySource>
   */
  @GetMapping("/")
  public List<EnergySource> loadAll() {
    List<EnergySource> energySourceList = null;

    try {
      // load the EnergySource
      energySourceList =
          EnergySourceBusinessDelegate.getEnergySourceInstance().getAllEnergySource();

      if (energySourceList != null) LOGGER.log(Level.INFO, "successfully loaded all EnergySources");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all EnergySources ", exc);
      return null;
    }

    return energySourceList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected EnergySource energySource = null;
  private static final Logger LOGGER =
      Logger.getLogger(EnergySourceQueryRestController.class.getName());
}
