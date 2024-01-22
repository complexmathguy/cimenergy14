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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.controller.command;

import com.occulue.api.*;
import com.occulue.command.*;
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
 * Implements Spring Controller command CQRS processing for entity SynchronousMachine.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SynchronousMachine")
public class SynchronousMachineCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a SynchronousMachine. if not key provided, calls create, otherwise calls save
   *
   * @param SynchronousMachine synchronousMachine
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateSynchronousMachineCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
              .createSynchronousMachine(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a SynchronousMachine. if no key provided, calls create, otherwise calls save
   *
   * @param SynchronousMachine synchronousMachine
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateSynchronousMachineCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateSynchronousMachineCommand
      // -----------------------------------------------
      completableFuture =
          SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
              .updateSynchronousMachine(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "SynchronousMachineController:update() - successfully update SynchronousMachine - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a SynchronousMachine entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID synchronousMachineId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteSynchronousMachineCommand command =
        new DeleteSynchronousMachineCommand(synchronousMachineId);

    try {
      SynchronousMachineBusinessDelegate delegate =
          SynchronousMachineBusinessDelegate.getSynchronousMachineInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted SynchronousMachine with key " + command.getSynchronousMachineId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Earthing on SynchronousMachine
   *
   * @param command AssignEarthingToSynchronousMachineCommand
   */
  @PutMapping("/assignEarthing")
  public void assignEarthing(@RequestBody AssignEarthingToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().assignEarthing(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Earthing", exc);
    }
  }

  /**
   * unassign Earthing on SynchronousMachine
   *
   * @param command UnAssignEarthingFromSynchronousMachineCommand
   */
  @PutMapping("/unAssignEarthing")
  public void unAssignEarthing(
      @RequestBody(required = true) UnAssignEarthingFromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().unAssignEarthing(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Earthing", exc);
    }
  }

  /**
   * save EarthingStarPointR on SynchronousMachine
   *
   * @param command AssignEarthingStarPointRToSynchronousMachineCommand
   */
  @PutMapping("/assignEarthingStarPointR")
  public void assignEarthingStarPointR(
      @RequestBody AssignEarthingStarPointRToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
          .assignEarthingStarPointR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EarthingStarPointR", exc);
    }
  }

  /**
   * unassign EarthingStarPointR on SynchronousMachine
   *
   * @param command UnAssignEarthingStarPointRFromSynchronousMachineCommand
   */
  @PutMapping("/unAssignEarthingStarPointR")
  public void unAssignEarthingStarPointR(
      @RequestBody(required = true)
          UnAssignEarthingStarPointRFromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
          .unAssignEarthingStarPointR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EarthingStarPointR", exc);
    }
  }

  /**
   * save EarthingStarPointX on SynchronousMachine
   *
   * @param command AssignEarthingStarPointXToSynchronousMachineCommand
   */
  @PutMapping("/assignEarthingStarPointX")
  public void assignEarthingStarPointX(
      @RequestBody AssignEarthingStarPointXToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
          .assignEarthingStarPointX(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EarthingStarPointX", exc);
    }
  }

  /**
   * unassign EarthingStarPointX on SynchronousMachine
   *
   * @param command UnAssignEarthingStarPointXFromSynchronousMachineCommand
   */
  @PutMapping("/unAssignEarthingStarPointX")
  public void unAssignEarthingStarPointX(
      @RequestBody(required = true)
          UnAssignEarthingStarPointXFromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
          .unAssignEarthingStarPointX(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EarthingStarPointX", exc);
    }
  }

  /**
   * save Ikk on SynchronousMachine
   *
   * @param command AssignIkkToSynchronousMachineCommand
   */
  @PutMapping("/assignIkk")
  public void assignIkk(@RequestBody AssignIkkToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().assignIkk(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ikk", exc);
    }
  }

  /**
   * unassign Ikk on SynchronousMachine
   *
   * @param command UnAssignIkkFromSynchronousMachineCommand
   */
  @PutMapping("/unAssignIkk")
  public void unAssignIkk(
      @RequestBody(required = true) UnAssignIkkFromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().unAssignIkk(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ikk", exc);
    }
  }

  /**
   * save MaxQ on SynchronousMachine
   *
   * @param command AssignMaxQToSynchronousMachineCommand
   */
  @PutMapping("/assignMaxQ")
  public void assignMaxQ(@RequestBody AssignMaxQToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().assignMaxQ(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MaxQ", exc);
    }
  }

  /**
   * unassign MaxQ on SynchronousMachine
   *
   * @param command UnAssignMaxQFromSynchronousMachineCommand
   */
  @PutMapping("/unAssignMaxQ")
  public void unAssignMaxQ(
      @RequestBody(required = true) UnAssignMaxQFromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().unAssignMaxQ(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MaxQ", exc);
    }
  }

  /**
   * save MinQ on SynchronousMachine
   *
   * @param command AssignMinQToSynchronousMachineCommand
   */
  @PutMapping("/assignMinQ")
  public void assignMinQ(@RequestBody AssignMinQToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().assignMinQ(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MinQ", exc);
    }
  }

  /**
   * unassign MinQ on SynchronousMachine
   *
   * @param command UnAssignMinQFromSynchronousMachineCommand
   */
  @PutMapping("/unAssignMinQ")
  public void unAssignMinQ(
      @RequestBody(required = true) UnAssignMinQFromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().unAssignMinQ(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MinQ", exc);
    }
  }

  /**
   * save Mu on SynchronousMachine
   *
   * @param command AssignMuToSynchronousMachineCommand
   */
  @PutMapping("/assignMu")
  public void assignMu(@RequestBody AssignMuToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().assignMu(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mu", exc);
    }
  }

  /**
   * unassign Mu on SynchronousMachine
   *
   * @param command UnAssignMuFromSynchronousMachineCommand
   */
  @PutMapping("/unAssignMu")
  public void unAssignMu(
      @RequestBody(required = true) UnAssignMuFromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().unAssignMu(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mu", exc);
    }
  }

  /**
   * save QPercent on SynchronousMachine
   *
   * @param command AssignQPercentToSynchronousMachineCommand
   */
  @PutMapping("/assignQPercent")
  public void assignQPercent(@RequestBody AssignQPercentToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().assignQPercent(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign QPercent", exc);
    }
  }

  /**
   * unassign QPercent on SynchronousMachine
   *
   * @param command UnAssignQPercentFromSynchronousMachineCommand
   */
  @PutMapping("/unAssignQPercent")
  public void unAssignQPercent(
      @RequestBody(required = true) UnAssignQPercentFromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().unAssignQPercent(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign QPercent", exc);
    }
  }

  /**
   * save R on SynchronousMachine
   *
   * @param command AssignRToSynchronousMachineCommand
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on SynchronousMachine
   *
   * @param command UnAssignRFromSynchronousMachineCommand
   */
  @PutMapping("/unAssignR")
  public void unAssignR(
      @RequestBody(required = true) UnAssignRFromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save R0 on SynchronousMachine
   *
   * @param command AssignR0ToSynchronousMachineCommand
   */
  @PutMapping("/assignR0")
  public void assignR0(@RequestBody AssignR0ToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().assignR0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R0", exc);
    }
  }

  /**
   * unassign R0 on SynchronousMachine
   *
   * @param command UnAssignR0FromSynchronousMachineCommand
   */
  @PutMapping("/unAssignR0")
  public void unAssignR0(
      @RequestBody(required = true) UnAssignR0FromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().unAssignR0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R0", exc);
    }
  }

  /**
   * save R2 on SynchronousMachine
   *
   * @param command AssignR2ToSynchronousMachineCommand
   */
  @PutMapping("/assignR2")
  public void assignR2(@RequestBody AssignR2ToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().assignR2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R2", exc);
    }
  }

  /**
   * unassign R2 on SynchronousMachine
   *
   * @param command UnAssignR2FromSynchronousMachineCommand
   */
  @PutMapping("/unAssignR2")
  public void unAssignR2(
      @RequestBody(required = true) UnAssignR2FromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().unAssignR2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R2", exc);
    }
  }

  /**
   * save SatDirectSubtransX on SynchronousMachine
   *
   * @param command AssignSatDirectSubtransXToSynchronousMachineCommand
   */
  @PutMapping("/assignSatDirectSubtransX")
  public void assignSatDirectSubtransX(
      @RequestBody AssignSatDirectSubtransXToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
          .assignSatDirectSubtransX(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SatDirectSubtransX", exc);
    }
  }

  /**
   * unassign SatDirectSubtransX on SynchronousMachine
   *
   * @param command UnAssignSatDirectSubtransXFromSynchronousMachineCommand
   */
  @PutMapping("/unAssignSatDirectSubtransX")
  public void unAssignSatDirectSubtransX(
      @RequestBody(required = true)
          UnAssignSatDirectSubtransXFromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
          .unAssignSatDirectSubtransX(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SatDirectSubtransX", exc);
    }
  }

  /**
   * save SatDirectSyncX on SynchronousMachine
   *
   * @param command AssignSatDirectSyncXToSynchronousMachineCommand
   */
  @PutMapping("/assignSatDirectSyncX")
  public void assignSatDirectSyncX(
      @RequestBody AssignSatDirectSyncXToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
          .assignSatDirectSyncX(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SatDirectSyncX", exc);
    }
  }

  /**
   * unassign SatDirectSyncX on SynchronousMachine
   *
   * @param command UnAssignSatDirectSyncXFromSynchronousMachineCommand
   */
  @PutMapping("/unAssignSatDirectSyncX")
  public void unAssignSatDirectSyncX(
      @RequestBody(required = true) UnAssignSatDirectSyncXFromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
          .unAssignSatDirectSyncX(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SatDirectSyncX", exc);
    }
  }

  /**
   * save SatDirectTransX on SynchronousMachine
   *
   * @param command AssignSatDirectTransXToSynchronousMachineCommand
   */
  @PutMapping("/assignSatDirectTransX")
  public void assignSatDirectTransX(
      @RequestBody AssignSatDirectTransXToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
          .assignSatDirectTransX(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SatDirectTransX", exc);
    }
  }

  /**
   * unassign SatDirectTransX on SynchronousMachine
   *
   * @param command UnAssignSatDirectTransXFromSynchronousMachineCommand
   */
  @PutMapping("/unAssignSatDirectTransX")
  public void unAssignSatDirectTransX(
      @RequestBody(required = true) UnAssignSatDirectTransXFromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
          .unAssignSatDirectTransX(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SatDirectTransX", exc);
    }
  }

  /**
   * save VoltageRegulationRange on SynchronousMachine
   *
   * @param command AssignVoltageRegulationRangeToSynchronousMachineCommand
   */
  @PutMapping("/assignVoltageRegulationRange")
  public void assignVoltageRegulationRange(
      @RequestBody AssignVoltageRegulationRangeToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
          .assignVoltageRegulationRange(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign VoltageRegulationRange", exc);
    }
  }

  /**
   * unassign VoltageRegulationRange on SynchronousMachine
   *
   * @param command UnAssignVoltageRegulationRangeFromSynchronousMachineCommand
   */
  @PutMapping("/unAssignVoltageRegulationRange")
  public void unAssignVoltageRegulationRange(
      @RequestBody(required = true)
          UnAssignVoltageRegulationRangeFromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
          .unAssignVoltageRegulationRange(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign VoltageRegulationRange", exc);
    }
  }

  /**
   * save X0 on SynchronousMachine
   *
   * @param command AssignX0ToSynchronousMachineCommand
   */
  @PutMapping("/assignX0")
  public void assignX0(@RequestBody AssignX0ToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().assignX0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X0", exc);
    }
  }

  /**
   * unassign X0 on SynchronousMachine
   *
   * @param command UnAssignX0FromSynchronousMachineCommand
   */
  @PutMapping("/unAssignX0")
  public void unAssignX0(
      @RequestBody(required = true) UnAssignX0FromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().unAssignX0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X0", exc);
    }
  }

  /**
   * save X2 on SynchronousMachine
   *
   * @param command AssignX2ToSynchronousMachineCommand
   */
  @PutMapping("/assignX2")
  public void assignX2(@RequestBody AssignX2ToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().assignX2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X2", exc);
    }
  }

  /**
   * unassign X2 on SynchronousMachine
   *
   * @param command UnAssignX2FromSynchronousMachineCommand
   */
  @PutMapping("/unAssignX2")
  public void unAssignX2(
      @RequestBody(required = true) UnAssignX2FromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance().unAssignX2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X2", exc);
    }
  }

  /**
   * save InitiallyUsedBySynchronousMachines on SynchronousMachine
   *
   * @param command AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineCommand
   */
  @PutMapping("/addToInitiallyUsedBySynchronousMachines")
  public void addToInitiallyUsedBySynchronousMachines(
      @RequestBody(required = true)
          AssignInitiallyUsedBySynchronousMachinesToSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
          .addToInitiallyUsedBySynchronousMachines(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set InitiallyUsedBySynchronousMachines", exc);
    }
  }

  /**
   * remove InitiallyUsedBySynchronousMachines on SynchronousMachine
   *
   * @param command RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineCommand
   */
  @PutMapping("/removeFromInitiallyUsedBySynchronousMachines")
  public void removeFromInitiallyUsedBySynchronousMachines(
      @RequestBody(required = true)
          RemoveInitiallyUsedBySynchronousMachinesFromSynchronousMachineCommand command) {
    try {
      SynchronousMachineBusinessDelegate.getSynchronousMachineInstance()
          .removeFromInitiallyUsedBySynchronousMachines(command);
    } catch (Exception exc) {
      LOGGER.log(
          Level.WARNING, "Failed to remove from Set InitiallyUsedBySynchronousMachines", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SynchronousMachine synchronousMachine = null;
  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineCommandRestController.class.getName());
}
