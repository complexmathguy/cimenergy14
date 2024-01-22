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
 * Implements Spring Controller command CQRS processing for entity PowerTransformerEnd.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PowerTransformerEnd")
public class PowerTransformerEndCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PowerTransformerEnd. if not key provided, calls create, otherwise calls save
   *
   * @param PowerTransformerEnd powerTransformerEnd
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePowerTransformerEndCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance()
              .createPowerTransformerEnd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PowerTransformerEnd. if no key provided, calls create, otherwise calls save
   *
   * @param PowerTransformerEnd powerTransformerEnd
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePowerTransformerEndCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePowerTransformerEndCommand
      // -----------------------------------------------
      completableFuture =
          PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance()
              .updatePowerTransformerEnd(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PowerTransformerEndController:update() - successfully update PowerTransformerEnd - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PowerTransformerEnd entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID powerTransformerEndId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePowerTransformerEndCommand command =
        new DeletePowerTransformerEndCommand(powerTransformerEndId);

    try {
      PowerTransformerEndBusinessDelegate delegate =
          PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PowerTransformerEnd with key "
              + command.getPowerTransformerEndId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save B on PowerTransformerEnd
   *
   * @param command AssignBToPowerTransformerEndCommand
   */
  @PutMapping("/assignB")
  public void assignB(@RequestBody AssignBToPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().assignB(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B", exc);
    }
  }

  /**
   * unassign B on PowerTransformerEnd
   *
   * @param command UnAssignBFromPowerTransformerEndCommand
   */
  @PutMapping("/unAssignB")
  public void unAssignB(
      @RequestBody(required = true) UnAssignBFromPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().unAssignB(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B", exc);
    }
  }

  /**
   * save B0 on PowerTransformerEnd
   *
   * @param command AssignB0ToPowerTransformerEndCommand
   */
  @PutMapping("/assignB0")
  public void assignB0(@RequestBody AssignB0ToPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().assignB0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign B0", exc);
    }
  }

  /**
   * unassign B0 on PowerTransformerEnd
   *
   * @param command UnAssignB0FromPowerTransformerEndCommand
   */
  @PutMapping("/unAssignB0")
  public void unAssignB0(
      @RequestBody(required = true) UnAssignB0FromPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().unAssignB0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign B0", exc);
    }
  }

  /**
   * save G on PowerTransformerEnd
   *
   * @param command AssignGToPowerTransformerEndCommand
   */
  @PutMapping("/assignG")
  public void assignG(@RequestBody AssignGToPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().assignG(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign G", exc);
    }
  }

  /**
   * unassign G on PowerTransformerEnd
   *
   * @param command UnAssignGFromPowerTransformerEndCommand
   */
  @PutMapping("/unAssignG")
  public void unAssignG(
      @RequestBody(required = true) UnAssignGFromPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().unAssignG(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign G", exc);
    }
  }

  /**
   * save G0 on PowerTransformerEnd
   *
   * @param command AssignG0ToPowerTransformerEndCommand
   */
  @PutMapping("/assignG0")
  public void assignG0(@RequestBody AssignG0ToPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().assignG0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign G0", exc);
    }
  }

  /**
   * unassign G0 on PowerTransformerEnd
   *
   * @param command UnAssignG0FromPowerTransformerEndCommand
   */
  @PutMapping("/unAssignG0")
  public void unAssignG0(
      @RequestBody(required = true) UnAssignG0FromPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().unAssignG0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign G0", exc);
    }
  }

  /**
   * save PhaseAngleClock on PowerTransformerEnd
   *
   * @param command AssignPhaseAngleClockToPowerTransformerEndCommand
   */
  @PutMapping("/assignPhaseAngleClock")
  public void assignPhaseAngleClock(
      @RequestBody AssignPhaseAngleClockToPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance()
          .assignPhaseAngleClock(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PhaseAngleClock", exc);
    }
  }

  /**
   * unassign PhaseAngleClock on PowerTransformerEnd
   *
   * @param command UnAssignPhaseAngleClockFromPowerTransformerEndCommand
   */
  @PutMapping("/unAssignPhaseAngleClock")
  public void unAssignPhaseAngleClock(
      @RequestBody(required = true) UnAssignPhaseAngleClockFromPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance()
          .unAssignPhaseAngleClock(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PhaseAngleClock", exc);
    }
  }

  /**
   * save R on PowerTransformerEnd
   *
   * @param command AssignRToPowerTransformerEndCommand
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on PowerTransformerEnd
   *
   * @param command UnAssignRFromPowerTransformerEndCommand
   */
  @PutMapping("/unAssignR")
  public void unAssignR(
      @RequestBody(required = true) UnAssignRFromPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save R0 on PowerTransformerEnd
   *
   * @param command AssignR0ToPowerTransformerEndCommand
   */
  @PutMapping("/assignR0")
  public void assignR0(@RequestBody AssignR0ToPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().assignR0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R0", exc);
    }
  }

  /**
   * unassign R0 on PowerTransformerEnd
   *
   * @param command UnAssignR0FromPowerTransformerEndCommand
   */
  @PutMapping("/unAssignR0")
  public void unAssignR0(
      @RequestBody(required = true) UnAssignR0FromPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().unAssignR0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R0", exc);
    }
  }

  /**
   * save RatedS on PowerTransformerEnd
   *
   * @param command AssignRatedSToPowerTransformerEndCommand
   */
  @PutMapping("/assignRatedS")
  public void assignRatedS(@RequestBody AssignRatedSToPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().assignRatedS(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RatedS", exc);
    }
  }

  /**
   * unassign RatedS on PowerTransformerEnd
   *
   * @param command UnAssignRatedSFromPowerTransformerEndCommand
   */
  @PutMapping("/unAssignRatedS")
  public void unAssignRatedS(
      @RequestBody(required = true) UnAssignRatedSFromPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().unAssignRatedS(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RatedS", exc);
    }
  }

  /**
   * save RatedU on PowerTransformerEnd
   *
   * @param command AssignRatedUToPowerTransformerEndCommand
   */
  @PutMapping("/assignRatedU")
  public void assignRatedU(@RequestBody AssignRatedUToPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().assignRatedU(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign RatedU", exc);
    }
  }

  /**
   * unassign RatedU on PowerTransformerEnd
   *
   * @param command UnAssignRatedUFromPowerTransformerEndCommand
   */
  @PutMapping("/unAssignRatedU")
  public void unAssignRatedU(
      @RequestBody(required = true) UnAssignRatedUFromPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().unAssignRatedU(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign RatedU", exc);
    }
  }

  /**
   * save X on PowerTransformerEnd
   *
   * @param command AssignXToPowerTransformerEndCommand
   */
  @PutMapping("/assignX")
  public void assignX(@RequestBody AssignXToPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().assignX(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X", exc);
    }
  }

  /**
   * unassign X on PowerTransformerEnd
   *
   * @param command UnAssignXFromPowerTransformerEndCommand
   */
  @PutMapping("/unAssignX")
  public void unAssignX(
      @RequestBody(required = true) UnAssignXFromPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().unAssignX(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X", exc);
    }
  }

  /**
   * save X0 on PowerTransformerEnd
   *
   * @param command AssignX0ToPowerTransformerEndCommand
   */
  @PutMapping("/assignX0")
  public void assignX0(@RequestBody AssignX0ToPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().assignX0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X0", exc);
    }
  }

  /**
   * unassign X0 on PowerTransformerEnd
   *
   * @param command UnAssignX0FromPowerTransformerEndCommand
   */
  @PutMapping("/unAssignX0")
  public void unAssignX0(
      @RequestBody(required = true) UnAssignX0FromPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance().unAssignX0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X0", exc);
    }
  }

  /**
   * save PowerTransformerEnd on PowerTransformerEnd
   *
   * @param command AssignPowerTransformerEndToPowerTransformerEndCommand
   */
  @PutMapping("/addToPowerTransformerEnd")
  public void addToPowerTransformerEnd(
      @RequestBody(required = true) AssignPowerTransformerEndToPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance()
          .addToPowerTransformerEnd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set PowerTransformerEnd", exc);
    }
  }

  /**
   * remove PowerTransformerEnd on PowerTransformerEnd
   *
   * @param command RemovePowerTransformerEndFromPowerTransformerEndCommand
   */
  @PutMapping("/removeFromPowerTransformerEnd")
  public void removeFromPowerTransformerEnd(
      @RequestBody(required = true)
          RemovePowerTransformerEndFromPowerTransformerEndCommand command) {
    try {
      PowerTransformerEndBusinessDelegate.getPowerTransformerEndInstance()
          .removeFromPowerTransformerEnd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set PowerTransformerEnd", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PowerTransformerEnd powerTransformerEnd = null;
  private static final Logger LOGGER =
      Logger.getLogger(PowerTransformerEndCommandRestController.class.getName());
}
