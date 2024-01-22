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
 * Implements Spring Controller command CQRS processing for entity PFVArType2IEEEPFController.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArType2IEEEPFController")
public class PFVArType2IEEEPFControllerCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PFVArType2IEEEPFController. if not key provided, calls create, otherwise calls
   * save
   *
   * @param PFVArType2IEEEPFController pFVArType2IEEEPFController
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePFVArType2IEEEPFControllerCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
              .createPFVArType2IEEEPFController(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PFVArType2IEEEPFController. if no key provided, calls create, otherwise
   * calls save
   *
   * @param PFVArType2IEEEPFController pFVArType2IEEEPFController
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePFVArType2IEEEPFControllerCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePFVArType2IEEEPFControllerCommand
      // -----------------------------------------------
      completableFuture =
          PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
              .updatePFVArType2IEEEPFController(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PFVArType2IEEEPFControllerController:update() - successfully update PFVArType2IEEEPFController - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PFVArType2IEEEPFController entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID pFVArType2IEEEPFControllerId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePFVArType2IEEEPFControllerCommand command =
        new DeletePFVArType2IEEEPFControllerCommand(pFVArType2IEEEPFControllerId);

    try {
      PFVArType2IEEEPFControllerBusinessDelegate delegate =
          PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PFVArType2IEEEPFController with key "
              + command.getPFVArType2IEEEPFControllerId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Exlon on PFVArType2IEEEPFController
   *
   * @param command AssignExlonToPFVArType2IEEEPFControllerCommand
   */
  @PutMapping("/assignExlon")
  public void assignExlon(@RequestBody AssignExlonToPFVArType2IEEEPFControllerCommand command) {
    try {
      PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
          .assignExlon(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Exlon", exc);
    }
  }

  /**
   * unassign Exlon on PFVArType2IEEEPFController
   *
   * @param command UnAssignExlonFromPFVArType2IEEEPFControllerCommand
   */
  @PutMapping("/unAssignExlon")
  public void unAssignExlon(
      @RequestBody(required = true) UnAssignExlonFromPFVArType2IEEEPFControllerCommand command) {
    try {
      PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
          .unAssignExlon(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Exlon", exc);
    }
  }

  /**
   * save Ki on PFVArType2IEEEPFController
   *
   * @param command AssignKiToPFVArType2IEEEPFControllerCommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToPFVArType2IEEEPFControllerCommand command) {
    try {
      PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
          .assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on PFVArType2IEEEPFController
   *
   * @param command UnAssignKiFromPFVArType2IEEEPFControllerCommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(
      @RequestBody(required = true) UnAssignKiFromPFVArType2IEEEPFControllerCommand command) {
    try {
      PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
          .unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kp on PFVArType2IEEEPFController
   *
   * @param command AssignKpToPFVArType2IEEEPFControllerCommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToPFVArType2IEEEPFControllerCommand command) {
    try {
      PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
          .assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on PFVArType2IEEEPFController
   *
   * @param command UnAssignKpFromPFVArType2IEEEPFControllerCommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(
      @RequestBody(required = true) UnAssignKpFromPFVArType2IEEEPFControllerCommand command) {
    try {
      PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
          .unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Pfref on PFVArType2IEEEPFController
   *
   * @param command AssignPfrefToPFVArType2IEEEPFControllerCommand
   */
  @PutMapping("/assignPfref")
  public void assignPfref(@RequestBody AssignPfrefToPFVArType2IEEEPFControllerCommand command) {
    try {
      PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
          .assignPfref(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pfref", exc);
    }
  }

  /**
   * unassign Pfref on PFVArType2IEEEPFController
   *
   * @param command UnAssignPfrefFromPFVArType2IEEEPFControllerCommand
   */
  @PutMapping("/unAssignPfref")
  public void unAssignPfref(
      @RequestBody(required = true) UnAssignPfrefFromPFVArType2IEEEPFControllerCommand command) {
    try {
      PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
          .unAssignPfref(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pfref", exc);
    }
  }

  /**
   * save Vclmt on PFVArType2IEEEPFController
   *
   * @param command AssignVclmtToPFVArType2IEEEPFControllerCommand
   */
  @PutMapping("/assignVclmt")
  public void assignVclmt(@RequestBody AssignVclmtToPFVArType2IEEEPFControllerCommand command) {
    try {
      PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
          .assignVclmt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vclmt", exc);
    }
  }

  /**
   * unassign Vclmt on PFVArType2IEEEPFController
   *
   * @param command UnAssignVclmtFromPFVArType2IEEEPFControllerCommand
   */
  @PutMapping("/unAssignVclmt")
  public void unAssignVclmt(
      @RequestBody(required = true) UnAssignVclmtFromPFVArType2IEEEPFControllerCommand command) {
    try {
      PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
          .unAssignVclmt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vclmt", exc);
    }
  }

  /**
   * save Vref on PFVArType2IEEEPFController
   *
   * @param command AssignVrefToPFVArType2IEEEPFControllerCommand
   */
  @PutMapping("/assignVref")
  public void assignVref(@RequestBody AssignVrefToPFVArType2IEEEPFControllerCommand command) {
    try {
      PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
          .assignVref(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vref", exc);
    }
  }

  /**
   * unassign Vref on PFVArType2IEEEPFController
   *
   * @param command UnAssignVrefFromPFVArType2IEEEPFControllerCommand
   */
  @PutMapping("/unAssignVref")
  public void unAssignVref(
      @RequestBody(required = true) UnAssignVrefFromPFVArType2IEEEPFControllerCommand command) {
    try {
      PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
          .unAssignVref(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vref", exc);
    }
  }

  /**
   * save Vs on PFVArType2IEEEPFController
   *
   * @param command AssignVsToPFVArType2IEEEPFControllerCommand
   */
  @PutMapping("/assignVs")
  public void assignVs(@RequestBody AssignVsToPFVArType2IEEEPFControllerCommand command) {
    try {
      PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
          .assignVs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vs", exc);
    }
  }

  /**
   * unassign Vs on PFVArType2IEEEPFController
   *
   * @param command UnAssignVsFromPFVArType2IEEEPFControllerCommand
   */
  @PutMapping("/unAssignVs")
  public void unAssignVs(
      @RequestBody(required = true) UnAssignVsFromPFVArType2IEEEPFControllerCommand command) {
    try {
      PFVArType2IEEEPFControllerBusinessDelegate.getPFVArType2IEEEPFControllerInstance()
          .unAssignVs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vs", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PFVArType2IEEEPFController pFVArType2IEEEPFController = null;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArType2IEEEPFControllerCommandRestController.class.getName());
}
