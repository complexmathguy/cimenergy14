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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity ExcBBC.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcBBC")
public class ExcBBCCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcBBC. if not key provided, calls create, otherwise calls save
   *
   * @param ExcBBC excBBC
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreateExcBBCCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcBBCBusinessDelegate.getExcBBCInstance().createExcBBC(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcBBC. if no key provided, calls create, otherwise calls save
   *
   * @param ExcBBC excBBC
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdateExcBBCCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcBBCCommand
      // -----------------------------------------------
      completableFuture = ExcBBCBusinessDelegate.getExcBBCInstance().updateExcBBC(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcBBCController:update() - successfully update ExcBBC - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcBBC entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excBBCId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcBBCCommand command = new DeleteExcBBCCommand(excBBCId);

    try {
      ExcBBCBusinessDelegate delegate = ExcBBCBusinessDelegate.getExcBBCInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcBBC with key " + command.getExcBBCId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Efdmax on ExcBBC
   *
   * @param command AssignEfdmaxToExcBBCCommand
   */
  @PutMapping("/assignEfdmax")
  public void assignEfdmax(@RequestBody AssignEfdmaxToExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().assignEfdmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdmax", exc);
    }
  }

  /**
   * unassign Efdmax on ExcBBC
   *
   * @param command UnAssignEfdmaxFromExcBBCCommand
   */
  @PutMapping("/unAssignEfdmax")
  public void unAssignEfdmax(
      @RequestBody(required = true) UnAssignEfdmaxFromExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().unAssignEfdmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdmax", exc);
    }
  }

  /**
   * save Efdmin on ExcBBC
   *
   * @param command AssignEfdminToExcBBCCommand
   */
  @PutMapping("/assignEfdmin")
  public void assignEfdmin(@RequestBody AssignEfdminToExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().assignEfdmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Efdmin", exc);
    }
  }

  /**
   * unassign Efdmin on ExcBBC
   *
   * @param command UnAssignEfdminFromExcBBCCommand
   */
  @PutMapping("/unAssignEfdmin")
  public void unAssignEfdmin(
      @RequestBody(required = true) UnAssignEfdminFromExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().unAssignEfdmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Efdmin", exc);
    }
  }

  /**
   * save K on ExcBBC
   *
   * @param command AssignKToExcBBCCommand
   */
  @PutMapping("/assignK")
  public void assignK(@RequestBody AssignKToExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().assignK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K", exc);
    }
  }

  /**
   * unassign K on ExcBBC
   *
   * @param command UnAssignKFromExcBBCCommand
   */
  @PutMapping("/unAssignK")
  public void unAssignK(@RequestBody(required = true) UnAssignKFromExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().unAssignK(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K", exc);
    }
  }

  /**
   * save SwitchIt on ExcBBC
   *
   * @param command AssignSwitchItToExcBBCCommand
   */
  @PutMapping("/assignSwitchIt")
  public void assignSwitchIt(@RequestBody AssignSwitchItToExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().assignSwitchIt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SwitchIt", exc);
    }
  }

  /**
   * unassign SwitchIt on ExcBBC
   *
   * @param command UnAssignSwitchItFromExcBBCCommand
   */
  @PutMapping("/unAssignSwitchIt")
  public void unAssignSwitchIt(
      @RequestBody(required = true) UnAssignSwitchItFromExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().unAssignSwitchIt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SwitchIt", exc);
    }
  }

  /**
   * save T1 on ExcBBC
   *
   * @param command AssignT1ToExcBBCCommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on ExcBBC
   *
   * @param command UnAssignT1FromExcBBCCommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on ExcBBC
   *
   * @param command AssignT2ToExcBBCCommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on ExcBBC
   *
   * @param command UnAssignT2FromExcBBCCommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on ExcBBC
   *
   * @param command AssignT3ToExcBBCCommand
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on ExcBBC
   *
   * @param command UnAssignT3FromExcBBCCommand
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on ExcBBC
   *
   * @param command AssignT4ToExcBBCCommand
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on ExcBBC
   *
   * @param command UnAssignT4FromExcBBCCommand
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save Vrmax on ExcBBC
   *
   * @param command AssignVrmaxToExcBBCCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcBBC
   *
   * @param command UnAssignVrmaxFromExcBBCCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcBBC
   *
   * @param command AssignVrminToExcBBCCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcBBC
   *
   * @param command UnAssignVrminFromExcBBCCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  /**
   * save Xe on ExcBBC
   *
   * @param command AssignXeToExcBBCCommand
   */
  @PutMapping("/assignXe")
  public void assignXe(@RequestBody AssignXeToExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().assignXe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xe", exc);
    }
  }

  /**
   * unassign Xe on ExcBBC
   *
   * @param command UnAssignXeFromExcBBCCommand
   */
  @PutMapping("/unAssignXe")
  public void unAssignXe(@RequestBody(required = true) UnAssignXeFromExcBBCCommand command) {
    try {
      ExcBBCBusinessDelegate.getExcBBCInstance().unAssignXe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xe", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcBBC excBBC = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcBBCCommandRestController.class.getName());
}
