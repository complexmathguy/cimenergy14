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
 * Implements Spring Controller command CQRS processing for entity ExcAC4A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAC4A")
public class ExcAC4ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcAC4A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcAC4A excAC4A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcAC4ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcAC4ABusinessDelegate.getExcAC4AInstance().createExcAC4A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcAC4A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcAC4A excAC4A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcAC4ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcAC4ACommand
      // -----------------------------------------------
      completableFuture = ExcAC4ABusinessDelegate.getExcAC4AInstance().updateExcAC4A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcAC4AController:update() - successfully update ExcAC4A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcAC4A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excAC4AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcAC4ACommand command = new DeleteExcAC4ACommand(excAC4AId);

    try {
      ExcAC4ABusinessDelegate delegate = ExcAC4ABusinessDelegate.getExcAC4AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcAC4A with key " + command.getExcAC4AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ka on ExcAC4A
   *
   * @param command AssignKaToExcAC4ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcAC4A
   *
   * @param command UnAssignKaFromExcAC4ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcAC4A
   *
   * @param command AssignKcToExcAC4ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcAC4A
   *
   * @param command UnAssignKcFromExcAC4ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Ta on ExcAC4A
   *
   * @param command AssignTaToExcAC4ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcAC4A
   *
   * @param command UnAssignTaFromExcAC4ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcAC4A
   *
   * @param command AssignTbToExcAC4ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcAC4A
   *
   * @param command UnAssignTbFromExcAC4ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcAC4A
   *
   * @param command AssignTcToExcAC4ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcAC4A
   *
   * @param command UnAssignTcFromExcAC4ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Vimax on ExcAC4A
   *
   * @param command AssignVimaxToExcAC4ACommand
   */
  @PutMapping("/assignVimax")
  public void assignVimax(@RequestBody AssignVimaxToExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().assignVimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimax", exc);
    }
  }

  /**
   * unassign Vimax on ExcAC4A
   *
   * @param command UnAssignVimaxFromExcAC4ACommand
   */
  @PutMapping("/unAssignVimax")
  public void unAssignVimax(@RequestBody(required = true) UnAssignVimaxFromExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().unAssignVimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimax", exc);
    }
  }

  /**
   * save Vimin on ExcAC4A
   *
   * @param command AssignViminToExcAC4ACommand
   */
  @PutMapping("/assignVimin")
  public void assignVimin(@RequestBody AssignViminToExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().assignVimin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimin", exc);
    }
  }

  /**
   * unassign Vimin on ExcAC4A
   *
   * @param command UnAssignViminFromExcAC4ACommand
   */
  @PutMapping("/unAssignVimin")
  public void unAssignVimin(@RequestBody(required = true) UnAssignViminFromExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().unAssignVimin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimin", exc);
    }
  }

  /**
   * save Vrmax on ExcAC4A
   *
   * @param command AssignVrmaxToExcAC4ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcAC4A
   *
   * @param command UnAssignVrmaxFromExcAC4ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcAC4A
   *
   * @param command AssignVrminToExcAC4ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcAC4A
   *
   * @param command UnAssignVrminFromExcAC4ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcAC4ACommand command) {
    try {
      ExcAC4ABusinessDelegate.getExcAC4AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcAC4A excAC4A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcAC4ACommandRestController.class.getName());
}
