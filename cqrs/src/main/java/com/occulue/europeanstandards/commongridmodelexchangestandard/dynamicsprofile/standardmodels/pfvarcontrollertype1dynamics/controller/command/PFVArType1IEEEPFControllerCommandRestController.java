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
 * Implements Spring Controller command CQRS processing for entity PFVArType1IEEEPFController.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PFVArType1IEEEPFController")
public class PFVArType1IEEEPFControllerCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PFVArType1IEEEPFController. if not key provided, calls create, otherwise calls
   * save
   *
   * @param PFVArType1IEEEPFController pFVArType1IEEEPFController
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePFVArType1IEEEPFControllerCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
              .createPFVArType1IEEEPFController(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PFVArType1IEEEPFController. if no key provided, calls create, otherwise
   * calls save
   *
   * @param PFVArType1IEEEPFController pFVArType1IEEEPFController
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePFVArType1IEEEPFControllerCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePFVArType1IEEEPFControllerCommand
      // -----------------------------------------------
      completableFuture =
          PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
              .updatePFVArType1IEEEPFController(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PFVArType1IEEEPFControllerController:update() - successfully update PFVArType1IEEEPFController - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PFVArType1IEEEPFController entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID pFVArType1IEEEPFControllerId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePFVArType1IEEEPFControllerCommand command =
        new DeletePFVArType1IEEEPFControllerCommand(pFVArType1IEEEPFControllerId);

    try {
      PFVArType1IEEEPFControllerBusinessDelegate delegate =
          PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PFVArType1IEEEPFController with key "
              + command.getPFVArType1IEEEPFControllerId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ovex on PFVArType1IEEEPFController
   *
   * @param command AssignOvexToPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/assignOvex")
  public void assignOvex(@RequestBody AssignOvexToPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .assignOvex(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ovex", exc);
    }
  }

  /**
   * unassign Ovex on PFVArType1IEEEPFController
   *
   * @param command UnAssignOvexFromPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/unAssignOvex")
  public void unAssignOvex(
      @RequestBody(required = true) UnAssignOvexFromPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .unAssignOvex(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ovex", exc);
    }
  }

  /**
   * save Tpfc on PFVArType1IEEEPFController
   *
   * @param command AssignTpfcToPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/assignTpfc")
  public void assignTpfc(@RequestBody AssignTpfcToPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .assignTpfc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpfc", exc);
    }
  }

  /**
   * unassign Tpfc on PFVArType1IEEEPFController
   *
   * @param command UnAssignTpfcFromPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/unAssignTpfc")
  public void unAssignTpfc(
      @RequestBody(required = true) UnAssignTpfcFromPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .unAssignTpfc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpfc", exc);
    }
  }

  /**
   * save Vitmin on PFVArType1IEEEPFController
   *
   * @param command AssignVitminToPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/assignVitmin")
  public void assignVitmin(@RequestBody AssignVitminToPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .assignVitmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vitmin", exc);
    }
  }

  /**
   * unassign Vitmin on PFVArType1IEEEPFController
   *
   * @param command UnAssignVitminFromPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/unAssignVitmin")
  public void unAssignVitmin(
      @RequestBody(required = true) UnAssignVitminFromPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .unAssignVitmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vitmin", exc);
    }
  }

  /**
   * save Vpf on PFVArType1IEEEPFController
   *
   * @param command AssignVpfToPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/assignVpf")
  public void assignVpf(@RequestBody AssignVpfToPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .assignVpf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vpf", exc);
    }
  }

  /**
   * unassign Vpf on PFVArType1IEEEPFController
   *
   * @param command UnAssignVpfFromPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/unAssignVpf")
  public void unAssignVpf(
      @RequestBody(required = true) UnAssignVpfFromPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .unAssignVpf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vpf", exc);
    }
  }

  /**
   * save Vpfcbw on PFVArType1IEEEPFController
   *
   * @param command AssignVpfcbwToPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/assignVpfcbw")
  public void assignVpfcbw(@RequestBody AssignVpfcbwToPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .assignVpfcbw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vpfcbw", exc);
    }
  }

  /**
   * unassign Vpfcbw on PFVArType1IEEEPFController
   *
   * @param command UnAssignVpfcbwFromPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/unAssignVpfcbw")
  public void unAssignVpfcbw(
      @RequestBody(required = true) UnAssignVpfcbwFromPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .unAssignVpfcbw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vpfcbw", exc);
    }
  }

  /**
   * save Vpfref on PFVArType1IEEEPFController
   *
   * @param command AssignVpfrefToPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/assignVpfref")
  public void assignVpfref(@RequestBody AssignVpfrefToPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .assignVpfref(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vpfref", exc);
    }
  }

  /**
   * unassign Vpfref on PFVArType1IEEEPFController
   *
   * @param command UnAssignVpfrefFromPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/unAssignVpfref")
  public void unAssignVpfref(
      @RequestBody(required = true) UnAssignVpfrefFromPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .unAssignVpfref(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vpfref", exc);
    }
  }

  /**
   * save Vvtmax on PFVArType1IEEEPFController
   *
   * @param command AssignVvtmaxToPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/assignVvtmax")
  public void assignVvtmax(@RequestBody AssignVvtmaxToPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .assignVvtmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vvtmax", exc);
    }
  }

  /**
   * unassign Vvtmax on PFVArType1IEEEPFController
   *
   * @param command UnAssignVvtmaxFromPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/unAssignVvtmax")
  public void unAssignVvtmax(
      @RequestBody(required = true) UnAssignVvtmaxFromPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .unAssignVvtmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vvtmax", exc);
    }
  }

  /**
   * save Vvtmin on PFVArType1IEEEPFController
   *
   * @param command AssignVvtminToPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/assignVvtmin")
  public void assignVvtmin(@RequestBody AssignVvtminToPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .assignVvtmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vvtmin", exc);
    }
  }

  /**
   * unassign Vvtmin on PFVArType1IEEEPFController
   *
   * @param command UnAssignVvtminFromPFVArType1IEEEPFControllerCommand
   */
  @PutMapping("/unAssignVvtmin")
  public void unAssignVvtmin(
      @RequestBody(required = true) UnAssignVvtminFromPFVArType1IEEEPFControllerCommand command) {
    try {
      PFVArType1IEEEPFControllerBusinessDelegate.getPFVArType1IEEEPFControllerInstance()
          .unAssignVvtmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vvtmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PFVArType1IEEEPFController pFVArType1IEEEPFController = null;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArType1IEEEPFControllerCommandRestController.class.getName());
}
