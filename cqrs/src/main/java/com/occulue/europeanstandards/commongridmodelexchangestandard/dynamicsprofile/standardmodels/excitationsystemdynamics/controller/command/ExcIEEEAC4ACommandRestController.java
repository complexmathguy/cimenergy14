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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC4A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC4A")
public class ExcIEEEAC4ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEAC4A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC4A excIEEEAC4A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEAC4ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().createExcIEEEAC4A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEAC4A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC4A excIEEEAC4A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEAC4ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEAC4ACommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().updateExcIEEEAC4A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEAC4AController:update() - successfully update ExcIEEEAC4A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEAC4A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEAC4AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEAC4ACommand command = new DeleteExcIEEEAC4ACommand(excIEEEAC4AId);

    try {
      ExcIEEEAC4ABusinessDelegate delegate = ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEAC4A with key " + command.getExcIEEEAC4AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ka on ExcIEEEAC4A
   *
   * @param command AssignKaToExcIEEEAC4ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcIEEEAC4A
   *
   * @param command UnAssignKaFromExcIEEEAC4ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcIEEEAC4A
   *
   * @param command AssignKcToExcIEEEAC4ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcIEEEAC4A
   *
   * @param command UnAssignKcFromExcIEEEAC4ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Ta on ExcIEEEAC4A
   *
   * @param command AssignTaToExcIEEEAC4ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcIEEEAC4A
   *
   * @param command UnAssignTaFromExcIEEEAC4ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcIEEEAC4A
   *
   * @param command AssignTbToExcIEEEAC4ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcIEEEAC4A
   *
   * @param command UnAssignTbFromExcIEEEAC4ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcIEEEAC4A
   *
   * @param command AssignTcToExcIEEEAC4ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcIEEEAC4A
   *
   * @param command UnAssignTcFromExcIEEEAC4ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Vimax on ExcIEEEAC4A
   *
   * @param command AssignVimaxToExcIEEEAC4ACommand
   */
  @PutMapping("/assignVimax")
  public void assignVimax(@RequestBody AssignVimaxToExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().assignVimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimax", exc);
    }
  }

  /**
   * unassign Vimax on ExcIEEEAC4A
   *
   * @param command UnAssignVimaxFromExcIEEEAC4ACommand
   */
  @PutMapping("/unAssignVimax")
  public void unAssignVimax(
      @RequestBody(required = true) UnAssignVimaxFromExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().unAssignVimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimax", exc);
    }
  }

  /**
   * save Vimin on ExcIEEEAC4A
   *
   * @param command AssignViminToExcIEEEAC4ACommand
   */
  @PutMapping("/assignVimin")
  public void assignVimin(@RequestBody AssignViminToExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().assignVimin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimin", exc);
    }
  }

  /**
   * unassign Vimin on ExcIEEEAC4A
   *
   * @param command UnAssignViminFromExcIEEEAC4ACommand
   */
  @PutMapping("/unAssignVimin")
  public void unAssignVimin(
      @RequestBody(required = true) UnAssignViminFromExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().unAssignVimin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimin", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEAC4A
   *
   * @param command AssignVrmaxToExcIEEEAC4ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEAC4A
   *
   * @param command UnAssignVrmaxFromExcIEEEAC4ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEAC4A
   *
   * @param command AssignVrminToExcIEEEAC4ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEAC4A
   *
   * @param command UnAssignVrminFromExcIEEEAC4ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEAC4ACommand command) {
    try {
      ExcIEEEAC4ABusinessDelegate.getExcIEEEAC4AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEAC4A excIEEEAC4A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEAC4ACommandRestController.class.getName());
}
