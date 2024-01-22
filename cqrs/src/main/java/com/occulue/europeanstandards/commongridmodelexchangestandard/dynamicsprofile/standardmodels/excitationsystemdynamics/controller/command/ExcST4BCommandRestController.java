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
 * Implements Spring Controller command CQRS processing for entity ExcST4B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcST4B")
public class ExcST4BCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcST4B. if not key provided, calls create, otherwise calls save
   *
   * @param ExcST4B excST4B
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcST4BCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcST4BBusinessDelegate.getExcST4BInstance().createExcST4B(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcST4B. if no key provided, calls create, otherwise calls save
   *
   * @param ExcST4B excST4B
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcST4BCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcST4BCommand
      // -----------------------------------------------
      completableFuture = ExcST4BBusinessDelegate.getExcST4BInstance().updateExcST4B(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcST4BController:update() - successfully update ExcST4B - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcST4B entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excST4BId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcST4BCommand command = new DeleteExcST4BCommand(excST4BId);

    try {
      ExcST4BBusinessDelegate delegate = ExcST4BBusinessDelegate.getExcST4BInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcST4B with key " + command.getExcST4BId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Kc on ExcST4B
   *
   * @param command AssignKcToExcST4BCommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcST4B
   *
   * @param command UnAssignKcFromExcST4BCommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kg on ExcST4B
   *
   * @param command AssignKgToExcST4BCommand
   */
  @PutMapping("/assignKg")
  public void assignKg(@RequestBody AssignKgToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignKg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kg", exc);
    }
  }

  /**
   * unassign Kg on ExcST4B
   *
   * @param command UnAssignKgFromExcST4BCommand
   */
  @PutMapping("/unAssignKg")
  public void unAssignKg(@RequestBody(required = true) UnAssignKgFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignKg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kg", exc);
    }
  }

  /**
   * save Ki on ExcST4B
   *
   * @param command AssignKiToExcST4BCommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on ExcST4B
   *
   * @param command UnAssignKiFromExcST4BCommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kim on ExcST4B
   *
   * @param command AssignKimToExcST4BCommand
   */
  @PutMapping("/assignKim")
  public void assignKim(@RequestBody AssignKimToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignKim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kim", exc);
    }
  }

  /**
   * unassign Kim on ExcST4B
   *
   * @param command UnAssignKimFromExcST4BCommand
   */
  @PutMapping("/unAssignKim")
  public void unAssignKim(@RequestBody(required = true) UnAssignKimFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignKim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kim", exc);
    }
  }

  /**
   * save Kir on ExcST4B
   *
   * @param command AssignKirToExcST4BCommand
   */
  @PutMapping("/assignKir")
  public void assignKir(@RequestBody AssignKirToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignKir(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kir", exc);
    }
  }

  /**
   * unassign Kir on ExcST4B
   *
   * @param command UnAssignKirFromExcST4BCommand
   */
  @PutMapping("/unAssignKir")
  public void unAssignKir(@RequestBody(required = true) UnAssignKirFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignKir(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kir", exc);
    }
  }

  /**
   * save Kp on ExcST4B
   *
   * @param command AssignKpToExcST4BCommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on ExcST4B
   *
   * @param command UnAssignKpFromExcST4BCommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Kpm on ExcST4B
   *
   * @param command AssignKpmToExcST4BCommand
   */
  @PutMapping("/assignKpm")
  public void assignKpm(@RequestBody AssignKpmToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignKpm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpm", exc);
    }
  }

  /**
   * unassign Kpm on ExcST4B
   *
   * @param command UnAssignKpmFromExcST4BCommand
   */
  @PutMapping("/unAssignKpm")
  public void unAssignKpm(@RequestBody(required = true) UnAssignKpmFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignKpm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpm", exc);
    }
  }

  /**
   * save Kpr on ExcST4B
   *
   * @param command AssignKprToExcST4BCommand
   */
  @PutMapping("/assignKpr")
  public void assignKpr(@RequestBody AssignKprToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignKpr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpr", exc);
    }
  }

  /**
   * unassign Kpr on ExcST4B
   *
   * @param command UnAssignKprFromExcST4BCommand
   */
  @PutMapping("/unAssignKpr")
  public void unAssignKpr(@RequestBody(required = true) UnAssignKprFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignKpr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpr", exc);
    }
  }

  /**
   * save Lvgate on ExcST4B
   *
   * @param command AssignLvgateToExcST4BCommand
   */
  @PutMapping("/assignLvgate")
  public void assignLvgate(@RequestBody AssignLvgateToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignLvgate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Lvgate", exc);
    }
  }

  /**
   * unassign Lvgate on ExcST4B
   *
   * @param command UnAssignLvgateFromExcST4BCommand
   */
  @PutMapping("/unAssignLvgate")
  public void unAssignLvgate(
      @RequestBody(required = true) UnAssignLvgateFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignLvgate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Lvgate", exc);
    }
  }

  /**
   * save Ta on ExcST4B
   *
   * @param command AssignTaToExcST4BCommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcST4B
   *
   * @param command UnAssignTaFromExcST4BCommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Thetap on ExcST4B
   *
   * @param command AssignThetapToExcST4BCommand
   */
  @PutMapping("/assignThetap")
  public void assignThetap(@RequestBody AssignThetapToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignThetap(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Thetap", exc);
    }
  }

  /**
   * unassign Thetap on ExcST4B
   *
   * @param command UnAssignThetapFromExcST4BCommand
   */
  @PutMapping("/unAssignThetap")
  public void unAssignThetap(
      @RequestBody(required = true) UnAssignThetapFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignThetap(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Thetap", exc);
    }
  }

  /**
   * save Uel on ExcST4B
   *
   * @param command AssignUelToExcST4BCommand
   */
  @PutMapping("/assignUel")
  public void assignUel(@RequestBody AssignUelToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignUel(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uel", exc);
    }
  }

  /**
   * unassign Uel on ExcST4B
   *
   * @param command UnAssignUelFromExcST4BCommand
   */
  @PutMapping("/unAssignUel")
  public void unAssignUel(@RequestBody(required = true) UnAssignUelFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignUel(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uel", exc);
    }
  }

  /**
   * save Vbmax on ExcST4B
   *
   * @param command AssignVbmaxToExcST4BCommand
   */
  @PutMapping("/assignVbmax")
  public void assignVbmax(@RequestBody AssignVbmaxToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignVbmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vbmax", exc);
    }
  }

  /**
   * unassign Vbmax on ExcST4B
   *
   * @param command UnAssignVbmaxFromExcST4BCommand
   */
  @PutMapping("/unAssignVbmax")
  public void unAssignVbmax(@RequestBody(required = true) UnAssignVbmaxFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignVbmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vbmax", exc);
    }
  }

  /**
   * save Vgmax on ExcST4B
   *
   * @param command AssignVgmaxToExcST4BCommand
   */
  @PutMapping("/assignVgmax")
  public void assignVgmax(@RequestBody AssignVgmaxToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignVgmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vgmax", exc);
    }
  }

  /**
   * unassign Vgmax on ExcST4B
   *
   * @param command UnAssignVgmaxFromExcST4BCommand
   */
  @PutMapping("/unAssignVgmax")
  public void unAssignVgmax(@RequestBody(required = true) UnAssignVgmaxFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignVgmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vgmax", exc);
    }
  }

  /**
   * save Vmmax on ExcST4B
   *
   * @param command AssignVmmaxToExcST4BCommand
   */
  @PutMapping("/assignVmmax")
  public void assignVmmax(@RequestBody AssignVmmaxToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignVmmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmmax", exc);
    }
  }

  /**
   * unassign Vmmax on ExcST4B
   *
   * @param command UnAssignVmmaxFromExcST4BCommand
   */
  @PutMapping("/unAssignVmmax")
  public void unAssignVmmax(@RequestBody(required = true) UnAssignVmmaxFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignVmmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmmax", exc);
    }
  }

  /**
   * save Vmmin on ExcST4B
   *
   * @param command AssignVmminToExcST4BCommand
   */
  @PutMapping("/assignVmmin")
  public void assignVmmin(@RequestBody AssignVmminToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignVmmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmmin", exc);
    }
  }

  /**
   * unassign Vmmin on ExcST4B
   *
   * @param command UnAssignVmminFromExcST4BCommand
   */
  @PutMapping("/unAssignVmmin")
  public void unAssignVmmin(@RequestBody(required = true) UnAssignVmminFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignVmmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmmin", exc);
    }
  }

  /**
   * save Vrmax on ExcST4B
   *
   * @param command AssignVrmaxToExcST4BCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcST4B
   *
   * @param command UnAssignVrmaxFromExcST4BCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcST4B
   *
   * @param command AssignVrminToExcST4BCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcST4B
   *
   * @param command UnAssignVrminFromExcST4BCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  /**
   * save Xl on ExcST4B
   *
   * @param command AssignXlToExcST4BCommand
   */
  @PutMapping("/assignXl")
  public void assignXl(@RequestBody AssignXlToExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().assignXl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Xl", exc);
    }
  }

  /**
   * unassign Xl on ExcST4B
   *
   * @param command UnAssignXlFromExcST4BCommand
   */
  @PutMapping("/unAssignXl")
  public void unAssignXl(@RequestBody(required = true) UnAssignXlFromExcST4BCommand command) {
    try {
      ExcST4BBusinessDelegate.getExcST4BInstance().unAssignXl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Xl", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcST4B excST4B = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcST4BCommandRestController.class.getName());
}
