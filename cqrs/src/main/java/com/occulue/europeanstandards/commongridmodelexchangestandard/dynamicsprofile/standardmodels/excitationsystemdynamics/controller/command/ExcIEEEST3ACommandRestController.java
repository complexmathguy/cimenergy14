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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEST3A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST3A")
public class ExcIEEEST3ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEST3A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEST3A excIEEEST3A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEST3ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().createExcIEEEST3A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEST3A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEST3A excIEEEST3A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEST3ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEST3ACommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().updateExcIEEEST3A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEST3AController:update() - successfully update ExcIEEEST3A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEST3A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEST3AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEST3ACommand command = new DeleteExcIEEEST3ACommand(excIEEEST3AId);

    try {
      ExcIEEEST3ABusinessDelegate delegate = ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEST3A with key " + command.getExcIEEEST3AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ka on ExcIEEEST3A
   *
   * @param command AssignKaToExcIEEEST3ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcIEEEST3A
   *
   * @param command UnAssignKaFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcIEEEST3A
   *
   * @param command AssignKcToExcIEEEST3ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcIEEEST3A
   *
   * @param command UnAssignKcFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kg on ExcIEEEST3A
   *
   * @param command AssignKgToExcIEEEST3ACommand
   */
  @PutMapping("/assignKg")
  public void assignKg(@RequestBody AssignKgToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignKg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kg", exc);
    }
  }

  /**
   * unassign Kg on ExcIEEEST3A
   *
   * @param command UnAssignKgFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignKg")
  public void unAssignKg(@RequestBody(required = true) UnAssignKgFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignKg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kg", exc);
    }
  }

  /**
   * save Ki on ExcIEEEST3A
   *
   * @param command AssignKiToExcIEEEST3ACommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on ExcIEEEST3A
   *
   * @param command UnAssignKiFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Km on ExcIEEEST3A
   *
   * @param command AssignKmToExcIEEEST3ACommand
   */
  @PutMapping("/assignKm")
  public void assignKm(@RequestBody AssignKmToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignKm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Km", exc);
    }
  }

  /**
   * unassign Km on ExcIEEEST3A
   *
   * @param command UnAssignKmFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignKm")
  public void unAssignKm(@RequestBody(required = true) UnAssignKmFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignKm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Km", exc);
    }
  }

  /**
   * save Kp on ExcIEEEST3A
   *
   * @param command AssignKpToExcIEEEST3ACommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on ExcIEEEST3A
   *
   * @param command UnAssignKpFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Ta on ExcIEEEST3A
   *
   * @param command AssignTaToExcIEEEST3ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcIEEEST3A
   *
   * @param command UnAssignTaFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcIEEEST3A
   *
   * @param command AssignTbToExcIEEEST3ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcIEEEST3A
   *
   * @param command UnAssignTbFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcIEEEST3A
   *
   * @param command AssignTcToExcIEEEST3ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcIEEEST3A
   *
   * @param command UnAssignTcFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Thetap on ExcIEEEST3A
   *
   * @param command AssignThetapToExcIEEEST3ACommand
   */
  @PutMapping("/assignThetap")
  public void assignThetap(@RequestBody AssignThetapToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignThetap(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Thetap", exc);
    }
  }

  /**
   * unassign Thetap on ExcIEEEST3A
   *
   * @param command UnAssignThetapFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignThetap")
  public void unAssignThetap(
      @RequestBody(required = true) UnAssignThetapFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignThetap(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Thetap", exc);
    }
  }

  /**
   * save Tm on ExcIEEEST3A
   *
   * @param command AssignTmToExcIEEEST3ACommand
   */
  @PutMapping("/assignTm")
  public void assignTm(@RequestBody AssignTmToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignTm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tm", exc);
    }
  }

  /**
   * unassign Tm on ExcIEEEST3A
   *
   * @param command UnAssignTmFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignTm")
  public void unAssignTm(@RequestBody(required = true) UnAssignTmFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignTm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tm", exc);
    }
  }

  /**
   * save Vbmax on ExcIEEEST3A
   *
   * @param command AssignVbmaxToExcIEEEST3ACommand
   */
  @PutMapping("/assignVbmax")
  public void assignVbmax(@RequestBody AssignVbmaxToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignVbmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vbmax", exc);
    }
  }

  /**
   * unassign Vbmax on ExcIEEEST3A
   *
   * @param command UnAssignVbmaxFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignVbmax")
  public void unAssignVbmax(
      @RequestBody(required = true) UnAssignVbmaxFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignVbmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vbmax", exc);
    }
  }

  /**
   * save Vgmax on ExcIEEEST3A
   *
   * @param command AssignVgmaxToExcIEEEST3ACommand
   */
  @PutMapping("/assignVgmax")
  public void assignVgmax(@RequestBody AssignVgmaxToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignVgmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vgmax", exc);
    }
  }

  /**
   * unassign Vgmax on ExcIEEEST3A
   *
   * @param command UnAssignVgmaxFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignVgmax")
  public void unAssignVgmax(
      @RequestBody(required = true) UnAssignVgmaxFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignVgmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vgmax", exc);
    }
  }

  /**
   * save Vimax on ExcIEEEST3A
   *
   * @param command AssignVimaxToExcIEEEST3ACommand
   */
  @PutMapping("/assignVimax")
  public void assignVimax(@RequestBody AssignVimaxToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignVimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimax", exc);
    }
  }

  /**
   * unassign Vimax on ExcIEEEST3A
   *
   * @param command UnAssignVimaxFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignVimax")
  public void unAssignVimax(
      @RequestBody(required = true) UnAssignVimaxFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignVimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimax", exc);
    }
  }

  /**
   * save Vimin on ExcIEEEST3A
   *
   * @param command AssignViminToExcIEEEST3ACommand
   */
  @PutMapping("/assignVimin")
  public void assignVimin(@RequestBody AssignViminToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignVimin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimin", exc);
    }
  }

  /**
   * unassign Vimin on ExcIEEEST3A
   *
   * @param command UnAssignViminFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignVimin")
  public void unAssignVimin(
      @RequestBody(required = true) UnAssignViminFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignVimin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimin", exc);
    }
  }

  /**
   * save Vmmax on ExcIEEEST3A
   *
   * @param command AssignVmmaxToExcIEEEST3ACommand
   */
  @PutMapping("/assignVmmax")
  public void assignVmmax(@RequestBody AssignVmmaxToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignVmmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmmax", exc);
    }
  }

  /**
   * unassign Vmmax on ExcIEEEST3A
   *
   * @param command UnAssignVmmaxFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignVmmax")
  public void unAssignVmmax(
      @RequestBody(required = true) UnAssignVmmaxFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignVmmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmmax", exc);
    }
  }

  /**
   * save Vmmin on ExcIEEEST3A
   *
   * @param command AssignVmminToExcIEEEST3ACommand
   */
  @PutMapping("/assignVmmin")
  public void assignVmmin(@RequestBody AssignVmminToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignVmmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmmin", exc);
    }
  }

  /**
   * unassign Vmmin on ExcIEEEST3A
   *
   * @param command UnAssignVmminFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignVmmin")
  public void unAssignVmmin(
      @RequestBody(required = true) UnAssignVmminFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignVmmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmmin", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEST3A
   *
   * @param command AssignVrmaxToExcIEEEST3ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEST3A
   *
   * @param command UnAssignVrmaxFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEST3A
   *
   * @param command AssignVrminToExcIEEEST3ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEST3A
   *
   * @param command UnAssignVrminFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  /**
   * save Xl on ExcIEEEST3A
   *
   * @param command AssignXlToExcIEEEST3ACommand
   */
  @PutMapping("/assignXl")
  public void assignXl(@RequestBody AssignXlToExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().assignXl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xl", exc);
    }
  }

  /**
   * unassign Xl on ExcIEEEST3A
   *
   * @param command UnAssignXlFromExcIEEEST3ACommand
   */
  @PutMapping("/unAssignXl")
  public void unAssignXl(@RequestBody(required = true) UnAssignXlFromExcIEEEST3ACommand command) {
    try {
      ExcIEEEST3ABusinessDelegate.getExcIEEEST3AInstance().unAssignXl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xl", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEST3A excIEEEST3A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEST3ACommandRestController.class.getName());
}
