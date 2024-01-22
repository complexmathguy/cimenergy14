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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity PFVArType2Common1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArType2Common1")
public class PFVArType2Common1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PFVArType2Common1. if not key provided, calls create, otherwise calls save
   *
   * @param PFVArType2Common1 pFVArType2Common1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePFVArType2Common1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance()
              .createPFVArType2Common1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PFVArType2Common1. if no key provided, calls create, otherwise calls save
   *
   * @param PFVArType2Common1 pFVArType2Common1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePFVArType2Common1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePFVArType2Common1Command
      // -----------------------------------------------
      completableFuture =
          PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance()
              .updatePFVArType2Common1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PFVArType2Common1Controller:update() - successfully update PFVArType2Common1 - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PFVArType2Common1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID pFVArType2Common1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeletePFVArType2Common1Command command =
        new DeletePFVArType2Common1Command(pFVArType2Common1Id);

    try {
      PFVArType2Common1BusinessDelegate delegate =
          PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PFVArType2Common1 with key " + command.getPFVArType2Common1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save J on PFVArType2Common1
   *
   * @param command AssignJToPFVArType2Common1Command
   */
  @PutMapping("/assignJ")
  public void assignJ(@RequestBody AssignJToPFVArType2Common1Command command) {
    try {
      PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().assignJ(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign J", exc);
    }
  }

  /**
   * unassign J on PFVArType2Common1
   *
   * @param command UnAssignJFromPFVArType2Common1Command
   */
  @PutMapping("/unAssignJ")
  public void unAssignJ(
      @RequestBody(required = true) UnAssignJFromPFVArType2Common1Command command) {
    try {
      PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().unAssignJ(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign J", exc);
    }
  }

  /**
   * save Ki on PFVArType2Common1
   *
   * @param command AssignKiToPFVArType2Common1Command
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToPFVArType2Common1Command command) {
    try {
      PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on PFVArType2Common1
   *
   * @param command UnAssignKiFromPFVArType2Common1Command
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(
      @RequestBody(required = true) UnAssignKiFromPFVArType2Common1Command command) {
    try {
      PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kp on PFVArType2Common1
   *
   * @param command AssignKpToPFVArType2Common1Command
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToPFVArType2Common1Command command) {
    try {
      PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on PFVArType2Common1
   *
   * @param command UnAssignKpFromPFVArType2Common1Command
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(
      @RequestBody(required = true) UnAssignKpFromPFVArType2Common1Command command) {
    try {
      PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Max on PFVArType2Common1
   *
   * @param command AssignMaxToPFVArType2Common1Command
   */
  @PutMapping("/assignMax")
  public void assignMax(@RequestBody AssignMaxToPFVArType2Common1Command command) {
    try {
      PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().assignMax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Max", exc);
    }
  }

  /**
   * unassign Max on PFVArType2Common1
   *
   * @param command UnAssignMaxFromPFVArType2Common1Command
   */
  @PutMapping("/unAssignMax")
  public void unAssignMax(
      @RequestBody(required = true) UnAssignMaxFromPFVArType2Common1Command command) {
    try {
      PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().unAssignMax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Max", exc);
    }
  }

  /**
   * save Ref on PFVArType2Common1
   *
   * @param command AssignRefToPFVArType2Common1Command
   */
  @PutMapping("/assignRef")
  public void assignRef(@RequestBody AssignRefToPFVArType2Common1Command command) {
    try {
      PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().assignRef(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ref", exc);
    }
  }

  /**
   * unassign Ref on PFVArType2Common1
   *
   * @param command UnAssignRefFromPFVArType2Common1Command
   */
  @PutMapping("/unAssignRef")
  public void unAssignRef(
      @RequestBody(required = true) UnAssignRefFromPFVArType2Common1Command command) {
    try {
      PFVArType2Common1BusinessDelegate.getPFVArType2Common1Instance().unAssignRef(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ref", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PFVArType2Common1 pFVArType2Common1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArType2Common1CommandRestController.class.getName());
}
