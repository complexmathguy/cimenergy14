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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype1dynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity PFVArType1IEEEVArController.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArType1IEEEVArController")
public class PFVArType1IEEEVArControllerCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PFVArType1IEEEVArController. if not key provided, calls create, otherwise
   * calls save
   *
   * @param PFVArType1IEEEVArController pFVArType1IEEEVArController
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePFVArType1IEEEVArControllerCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
              .createPFVArType1IEEEVArController(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PFVArType1IEEEVArController. if no key provided, calls create, otherwise
   * calls save
   *
   * @param PFVArType1IEEEVArController pFVArType1IEEEVArController
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePFVArType1IEEEVArControllerCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePFVArType1IEEEVArControllerCommand
      // -----------------------------------------------
      completableFuture =
          PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
              .updatePFVArType1IEEEVArController(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PFVArType1IEEEVArControllerController:update() - successfully update PFVArType1IEEEVArController - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PFVArType1IEEEVArController entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID pFVArType1IEEEVArControllerId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePFVArType1IEEEVArControllerCommand command =
        new DeletePFVArType1IEEEVArControllerCommand(pFVArType1IEEEVArControllerId);

    try {
      PFVArType1IEEEVArControllerBusinessDelegate delegate =
          PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PFVArType1IEEEVArController with key "
              + command.getPFVArType1IEEEVArControllerId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Tvarc on PFVArType1IEEEVArController
   *
   * @param command AssignTvarcToPFVArType1IEEEVArControllerCommand
   */
  @PutMapping("/assignTvarc")
  public void assignTvarc(@RequestBody AssignTvarcToPFVArType1IEEEVArControllerCommand command) {
    try {
      PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
          .assignTvarc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tvarc", exc);
    }
  }

  /**
   * unassign Tvarc on PFVArType1IEEEVArController
   *
   * @param command UnAssignTvarcFromPFVArType1IEEEVArControllerCommand
   */
  @PutMapping("/unAssignTvarc")
  public void unAssignTvarc(
      @RequestBody(required = true) UnAssignTvarcFromPFVArType1IEEEVArControllerCommand command) {
    try {
      PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
          .unAssignTvarc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tvarc", exc);
    }
  }

  /**
   * save Vvar on PFVArType1IEEEVArController
   *
   * @param command AssignVvarToPFVArType1IEEEVArControllerCommand
   */
  @PutMapping("/assignVvar")
  public void assignVvar(@RequestBody AssignVvarToPFVArType1IEEEVArControllerCommand command) {
    try {
      PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
          .assignVvar(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vvar", exc);
    }
  }

  /**
   * unassign Vvar on PFVArType1IEEEVArController
   *
   * @param command UnAssignVvarFromPFVArType1IEEEVArControllerCommand
   */
  @PutMapping("/unAssignVvar")
  public void unAssignVvar(
      @RequestBody(required = true) UnAssignVvarFromPFVArType1IEEEVArControllerCommand command) {
    try {
      PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
          .unAssignVvar(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vvar", exc);
    }
  }

  /**
   * save Vvarcbw on PFVArType1IEEEVArController
   *
   * @param command AssignVvarcbwToPFVArType1IEEEVArControllerCommand
   */
  @PutMapping("/assignVvarcbw")
  public void assignVvarcbw(
      @RequestBody AssignVvarcbwToPFVArType1IEEEVArControllerCommand command) {
    try {
      PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
          .assignVvarcbw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vvarcbw", exc);
    }
  }

  /**
   * unassign Vvarcbw on PFVArType1IEEEVArController
   *
   * @param command UnAssignVvarcbwFromPFVArType1IEEEVArControllerCommand
   */
  @PutMapping("/unAssignVvarcbw")
  public void unAssignVvarcbw(
      @RequestBody(required = true) UnAssignVvarcbwFromPFVArType1IEEEVArControllerCommand command) {
    try {
      PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
          .unAssignVvarcbw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vvarcbw", exc);
    }
  }

  /**
   * save Vvarref on PFVArType1IEEEVArController
   *
   * @param command AssignVvarrefToPFVArType1IEEEVArControllerCommand
   */
  @PutMapping("/assignVvarref")
  public void assignVvarref(
      @RequestBody AssignVvarrefToPFVArType1IEEEVArControllerCommand command) {
    try {
      PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
          .assignVvarref(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vvarref", exc);
    }
  }

  /**
   * unassign Vvarref on PFVArType1IEEEVArController
   *
   * @param command UnAssignVvarrefFromPFVArType1IEEEVArControllerCommand
   */
  @PutMapping("/unAssignVvarref")
  public void unAssignVvarref(
      @RequestBody(required = true) UnAssignVvarrefFromPFVArType1IEEEVArControllerCommand command) {
    try {
      PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
          .unAssignVvarref(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vvarref", exc);
    }
  }

  /**
   * save Vvtmax on PFVArType1IEEEVArController
   *
   * @param command AssignVvtmaxToPFVArType1IEEEVArControllerCommand
   */
  @PutMapping("/assignVvtmax")
  public void assignVvtmax(@RequestBody AssignVvtmaxToPFVArType1IEEEVArControllerCommand command) {
    try {
      PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
          .assignVvtmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vvtmax", exc);
    }
  }

  /**
   * unassign Vvtmax on PFVArType1IEEEVArController
   *
   * @param command UnAssignVvtmaxFromPFVArType1IEEEVArControllerCommand
   */
  @PutMapping("/unAssignVvtmax")
  public void unAssignVvtmax(
      @RequestBody(required = true) UnAssignVvtmaxFromPFVArType1IEEEVArControllerCommand command) {
    try {
      PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
          .unAssignVvtmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vvtmax", exc);
    }
  }

  /**
   * save Vvtmin on PFVArType1IEEEVArController
   *
   * @param command AssignVvtminToPFVArType1IEEEVArControllerCommand
   */
  @PutMapping("/assignVvtmin")
  public void assignVvtmin(@RequestBody AssignVvtminToPFVArType1IEEEVArControllerCommand command) {
    try {
      PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
          .assignVvtmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vvtmin", exc);
    }
  }

  /**
   * unassign Vvtmin on PFVArType1IEEEVArController
   *
   * @param command UnAssignVvtminFromPFVArType1IEEEVArControllerCommand
   */
  @PutMapping("/unAssignVvtmin")
  public void unAssignVvtmin(
      @RequestBody(required = true) UnAssignVvtminFromPFVArType1IEEEVArControllerCommand command) {
    try {
      PFVArType1IEEEVArControllerBusinessDelegate.getPFVArType1IEEEVArControllerInstance()
          .unAssignVvtmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vvtmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PFVArType1IEEEVArController pFVArType1IEEEVArController = null;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArType1IEEEVArControllerCommandRestController.class.getName());
}
