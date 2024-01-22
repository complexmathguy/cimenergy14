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
 * Implements Spring Controller command CQRS processing for entity TapChanger.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/TapChanger")
public class TapChangerCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a TapChanger. if not key provided, calls create, otherwise calls save
   *
   * @param TapChanger tapChanger
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateTapChangerCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          TapChangerBusinessDelegate.getTapChangerInstance().createTapChanger(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a TapChanger. if no key provided, calls create, otherwise calls save
   *
   * @param TapChanger tapChanger
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateTapChangerCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateTapChangerCommand
      // -----------------------------------------------
      completableFuture =
          TapChangerBusinessDelegate.getTapChangerInstance().updateTapChanger(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "TapChangerController:update() - successfully update TapChanger - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a TapChanger entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID tapChangerId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteTapChangerCommand command = new DeleteTapChangerCommand(tapChangerId);

    try {
      TapChangerBusinessDelegate delegate = TapChangerBusinessDelegate.getTapChangerInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted TapChanger with key " + command.getTapChangerId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save HighStep on TapChanger
   *
   * @param command AssignHighStepToTapChangerCommand
   */
  @PutMapping("/assignHighStep")
  public void assignHighStep(@RequestBody AssignHighStepToTapChangerCommand command) {
    try {
      TapChangerBusinessDelegate.getTapChangerInstance().assignHighStep(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign HighStep", exc);
    }
  }

  /**
   * unassign HighStep on TapChanger
   *
   * @param command UnAssignHighStepFromTapChangerCommand
   */
  @PutMapping("/unAssignHighStep")
  public void unAssignHighStep(
      @RequestBody(required = true) UnAssignHighStepFromTapChangerCommand command) {
    try {
      TapChangerBusinessDelegate.getTapChangerInstance().unAssignHighStep(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign HighStep", exc);
    }
  }

  /**
   * save LowStep on TapChanger
   *
   * @param command AssignLowStepToTapChangerCommand
   */
  @PutMapping("/assignLowStep")
  public void assignLowStep(@RequestBody AssignLowStepToTapChangerCommand command) {
    try {
      TapChangerBusinessDelegate.getTapChangerInstance().assignLowStep(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign LowStep", exc);
    }
  }

  /**
   * unassign LowStep on TapChanger
   *
   * @param command UnAssignLowStepFromTapChangerCommand
   */
  @PutMapping("/unAssignLowStep")
  public void unAssignLowStep(
      @RequestBody(required = true) UnAssignLowStepFromTapChangerCommand command) {
    try {
      TapChangerBusinessDelegate.getTapChangerInstance().unAssignLowStep(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign LowStep", exc);
    }
  }

  /**
   * save LtcFlag on TapChanger
   *
   * @param command AssignLtcFlagToTapChangerCommand
   */
  @PutMapping("/assignLtcFlag")
  public void assignLtcFlag(@RequestBody AssignLtcFlagToTapChangerCommand command) {
    try {
      TapChangerBusinessDelegate.getTapChangerInstance().assignLtcFlag(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign LtcFlag", exc);
    }
  }

  /**
   * unassign LtcFlag on TapChanger
   *
   * @param command UnAssignLtcFlagFromTapChangerCommand
   */
  @PutMapping("/unAssignLtcFlag")
  public void unAssignLtcFlag(
      @RequestBody(required = true) UnAssignLtcFlagFromTapChangerCommand command) {
    try {
      TapChangerBusinessDelegate.getTapChangerInstance().unAssignLtcFlag(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign LtcFlag", exc);
    }
  }

  /**
   * save NeutralStep on TapChanger
   *
   * @param command AssignNeutralStepToTapChangerCommand
   */
  @PutMapping("/assignNeutralStep")
  public void assignNeutralStep(@RequestBody AssignNeutralStepToTapChangerCommand command) {
    try {
      TapChangerBusinessDelegate.getTapChangerInstance().assignNeutralStep(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NeutralStep", exc);
    }
  }

  /**
   * unassign NeutralStep on TapChanger
   *
   * @param command UnAssignNeutralStepFromTapChangerCommand
   */
  @PutMapping("/unAssignNeutralStep")
  public void unAssignNeutralStep(
      @RequestBody(required = true) UnAssignNeutralStepFromTapChangerCommand command) {
    try {
      TapChangerBusinessDelegate.getTapChangerInstance().unAssignNeutralStep(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NeutralStep", exc);
    }
  }

  /**
   * save NeutralU on TapChanger
   *
   * @param command AssignNeutralUToTapChangerCommand
   */
  @PutMapping("/assignNeutralU")
  public void assignNeutralU(@RequestBody AssignNeutralUToTapChangerCommand command) {
    try {
      TapChangerBusinessDelegate.getTapChangerInstance().assignNeutralU(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NeutralU", exc);
    }
  }

  /**
   * unassign NeutralU on TapChanger
   *
   * @param command UnAssignNeutralUFromTapChangerCommand
   */
  @PutMapping("/unAssignNeutralU")
  public void unAssignNeutralU(
      @RequestBody(required = true) UnAssignNeutralUFromTapChangerCommand command) {
    try {
      TapChangerBusinessDelegate.getTapChangerInstance().unAssignNeutralU(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NeutralU", exc);
    }
  }

  /**
   * save NormalStep on TapChanger
   *
   * @param command AssignNormalStepToTapChangerCommand
   */
  @PutMapping("/assignNormalStep")
  public void assignNormalStep(@RequestBody AssignNormalStepToTapChangerCommand command) {
    try {
      TapChangerBusinessDelegate.getTapChangerInstance().assignNormalStep(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NormalStep", exc);
    }
  }

  /**
   * unassign NormalStep on TapChanger
   *
   * @param command UnAssignNormalStepFromTapChangerCommand
   */
  @PutMapping("/unAssignNormalStep")
  public void unAssignNormalStep(
      @RequestBody(required = true) UnAssignNormalStepFromTapChangerCommand command) {
    try {
      TapChangerBusinessDelegate.getTapChangerInstance().unAssignNormalStep(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NormalStep", exc);
    }
  }

  /**
   * save TapChanger on TapChanger
   *
   * @param command AssignTapChangerToTapChangerCommand
   */
  @PutMapping("/addToTapChanger")
  public void addToTapChanger(
      @RequestBody(required = true) AssignTapChangerToTapChangerCommand command) {
    try {
      TapChangerBusinessDelegate.getTapChangerInstance().addToTapChanger(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set TapChanger", exc);
    }
  }

  /**
   * remove TapChanger on TapChanger
   *
   * @param command RemoveTapChangerFromTapChangerCommand
   */
  @PutMapping("/removeFromTapChanger")
  public void removeFromTapChanger(
      @RequestBody(required = true) RemoveTapChangerFromTapChangerCommand command) {
    try {
      TapChangerBusinessDelegate.getTapChangerInstance().removeFromTapChanger(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set TapChanger", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected TapChanger tapChanger = null;
  private static final Logger LOGGER =
      Logger.getLogger(TapChangerCommandRestController.class.getName());
}
