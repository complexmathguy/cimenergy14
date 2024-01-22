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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEST4B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST4B")
public class ExcIEEEST4BCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEST4B. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEST4B excIEEEST4B
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEST4BCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().createExcIEEEST4B(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEST4B. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEST4B excIEEEST4B
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEST4BCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEST4BCommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().updateExcIEEEST4B(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEST4BController:update() - successfully update ExcIEEEST4B - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEST4B entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEST4BId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEST4BCommand command = new DeleteExcIEEEST4BCommand(excIEEEST4BId);

    try {
      ExcIEEEST4BBusinessDelegate delegate = ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEST4B with key " + command.getExcIEEEST4BId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Kc on ExcIEEEST4B
   *
   * @param command AssignKcToExcIEEEST4BCommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcIEEEST4B
   *
   * @param command UnAssignKcFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kg on ExcIEEEST4B
   *
   * @param command AssignKgToExcIEEEST4BCommand
   */
  @PutMapping("/assignKg")
  public void assignKg(@RequestBody AssignKgToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignKg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kg", exc);
    }
  }

  /**
   * unassign Kg on ExcIEEEST4B
   *
   * @param command UnAssignKgFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignKg")
  public void unAssignKg(@RequestBody(required = true) UnAssignKgFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignKg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kg", exc);
    }
  }

  /**
   * save Ki on ExcIEEEST4B
   *
   * @param command AssignKiToExcIEEEST4BCommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on ExcIEEEST4B
   *
   * @param command UnAssignKiFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kim on ExcIEEEST4B
   *
   * @param command AssignKimToExcIEEEST4BCommand
   */
  @PutMapping("/assignKim")
  public void assignKim(@RequestBody AssignKimToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignKim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kim", exc);
    }
  }

  /**
   * unassign Kim on ExcIEEEST4B
   *
   * @param command UnAssignKimFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignKim")
  public void unAssignKim(@RequestBody(required = true) UnAssignKimFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignKim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kim", exc);
    }
  }

  /**
   * save Kir on ExcIEEEST4B
   *
   * @param command AssignKirToExcIEEEST4BCommand
   */
  @PutMapping("/assignKir")
  public void assignKir(@RequestBody AssignKirToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignKir(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kir", exc);
    }
  }

  /**
   * unassign Kir on ExcIEEEST4B
   *
   * @param command UnAssignKirFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignKir")
  public void unAssignKir(@RequestBody(required = true) UnAssignKirFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignKir(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kir", exc);
    }
  }

  /**
   * save Kp on ExcIEEEST4B
   *
   * @param command AssignKpToExcIEEEST4BCommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on ExcIEEEST4B
   *
   * @param command UnAssignKpFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Kpm on ExcIEEEST4B
   *
   * @param command AssignKpmToExcIEEEST4BCommand
   */
  @PutMapping("/assignKpm")
  public void assignKpm(@RequestBody AssignKpmToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignKpm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpm", exc);
    }
  }

  /**
   * unassign Kpm on ExcIEEEST4B
   *
   * @param command UnAssignKpmFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignKpm")
  public void unAssignKpm(@RequestBody(required = true) UnAssignKpmFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignKpm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpm", exc);
    }
  }

  /**
   * save Kpr on ExcIEEEST4B
   *
   * @param command AssignKprToExcIEEEST4BCommand
   */
  @PutMapping("/assignKpr")
  public void assignKpr(@RequestBody AssignKprToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignKpr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpr", exc);
    }
  }

  /**
   * unassign Kpr on ExcIEEEST4B
   *
   * @param command UnAssignKprFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignKpr")
  public void unAssignKpr(@RequestBody(required = true) UnAssignKprFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignKpr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpr", exc);
    }
  }

  /**
   * save Ta on ExcIEEEST4B
   *
   * @param command AssignTaToExcIEEEST4BCommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcIEEEST4B
   *
   * @param command UnAssignTaFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Thetap on ExcIEEEST4B
   *
   * @param command AssignThetapToExcIEEEST4BCommand
   */
  @PutMapping("/assignThetap")
  public void assignThetap(@RequestBody AssignThetapToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignThetap(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Thetap", exc);
    }
  }

  /**
   * unassign Thetap on ExcIEEEST4B
   *
   * @param command UnAssignThetapFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignThetap")
  public void unAssignThetap(
      @RequestBody(required = true) UnAssignThetapFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignThetap(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Thetap", exc);
    }
  }

  /**
   * save Vbmax on ExcIEEEST4B
   *
   * @param command AssignVbmaxToExcIEEEST4BCommand
   */
  @PutMapping("/assignVbmax")
  public void assignVbmax(@RequestBody AssignVbmaxToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignVbmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vbmax", exc);
    }
  }

  /**
   * unassign Vbmax on ExcIEEEST4B
   *
   * @param command UnAssignVbmaxFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignVbmax")
  public void unAssignVbmax(
      @RequestBody(required = true) UnAssignVbmaxFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignVbmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vbmax", exc);
    }
  }

  /**
   * save Vmmax on ExcIEEEST4B
   *
   * @param command AssignVmmaxToExcIEEEST4BCommand
   */
  @PutMapping("/assignVmmax")
  public void assignVmmax(@RequestBody AssignVmmaxToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignVmmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmmax", exc);
    }
  }

  /**
   * unassign Vmmax on ExcIEEEST4B
   *
   * @param command UnAssignVmmaxFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignVmmax")
  public void unAssignVmmax(
      @RequestBody(required = true) UnAssignVmmaxFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignVmmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmmax", exc);
    }
  }

  /**
   * save Vmmin on ExcIEEEST4B
   *
   * @param command AssignVmminToExcIEEEST4BCommand
   */
  @PutMapping("/assignVmmin")
  public void assignVmmin(@RequestBody AssignVmminToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignVmmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmmin", exc);
    }
  }

  /**
   * unassign Vmmin on ExcIEEEST4B
   *
   * @param command UnAssignVmminFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignVmmin")
  public void unAssignVmmin(
      @RequestBody(required = true) UnAssignVmminFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignVmmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmmin", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEST4B
   *
   * @param command AssignVrmaxToExcIEEEST4BCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEST4B
   *
   * @param command UnAssignVrmaxFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEST4B
   *
   * @param command AssignVrminToExcIEEEST4BCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEST4B
   *
   * @param command UnAssignVrminFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  /**
   * save Xl on ExcIEEEST4B
   *
   * @param command AssignXlToExcIEEEST4BCommand
   */
  @PutMapping("/assignXl")
  public void assignXl(@RequestBody AssignXlToExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().assignXl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xl", exc);
    }
  }

  /**
   * unassign Xl on ExcIEEEST4B
   *
   * @param command UnAssignXlFromExcIEEEST4BCommand
   */
  @PutMapping("/unAssignXl")
  public void unAssignXl(@RequestBody(required = true) UnAssignXlFromExcIEEEST4BCommand command) {
    try {
      ExcIEEEST4BBusinessDelegate.getExcIEEEST4BInstance().unAssignXl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xl", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEST4B excIEEEST4B = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEST4BCommandRestController.class.getName());
}
