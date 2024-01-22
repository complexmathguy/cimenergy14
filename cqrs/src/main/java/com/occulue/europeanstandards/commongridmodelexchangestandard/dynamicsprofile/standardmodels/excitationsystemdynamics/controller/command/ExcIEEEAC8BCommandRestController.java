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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC8B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC8B")
public class ExcIEEEAC8BCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEAC8B. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC8B excIEEEAC8B
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEAC8BCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().createExcIEEEAC8B(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEAC8B. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC8B excIEEEAC8B
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEAC8BCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEAC8BCommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().updateExcIEEEAC8B(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEAC8BController:update() - successfully update ExcIEEEAC8B - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEAC8B entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEAC8BId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEAC8BCommand command = new DeleteExcIEEEAC8BCommand(excIEEEAC8BId);

    try {
      ExcIEEEAC8BBusinessDelegate delegate = ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEAC8B with key " + command.getExcIEEEAC8BId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ka on ExcIEEEAC8B
   *
   * @param command AssignKaToExcIEEEAC8BCommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcIEEEAC8B
   *
   * @param command UnAssignKaFromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcIEEEAC8B
   *
   * @param command AssignKcToExcIEEEAC8BCommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcIEEEAC8B
   *
   * @param command UnAssignKcFromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kd on ExcIEEEAC8B
   *
   * @param command AssignKdToExcIEEEAC8BCommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on ExcIEEEAC8B
   *
   * @param command UnAssignKdFromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Kdr on ExcIEEEAC8B
   *
   * @param command AssignKdrToExcIEEEAC8BCommand
   */
  @PutMapping("/assignKdr")
  public void assignKdr(@RequestBody AssignKdrToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignKdr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kdr", exc);
    }
  }

  /**
   * unassign Kdr on ExcIEEEAC8B
   *
   * @param command UnAssignKdrFromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignKdr")
  public void unAssignKdr(@RequestBody(required = true) UnAssignKdrFromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignKdr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kdr", exc);
    }
  }

  /**
   * save Ke on ExcIEEEAC8B
   *
   * @param command AssignKeToExcIEEEAC8BCommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcIEEEAC8B
   *
   * @param command UnAssignKeFromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kir on ExcIEEEAC8B
   *
   * @param command AssignKirToExcIEEEAC8BCommand
   */
  @PutMapping("/assignKir")
  public void assignKir(@RequestBody AssignKirToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignKir(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kir", exc);
    }
  }

  /**
   * unassign Kir on ExcIEEEAC8B
   *
   * @param command UnAssignKirFromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignKir")
  public void unAssignKir(@RequestBody(required = true) UnAssignKirFromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignKir(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kir", exc);
    }
  }

  /**
   * save Kpr on ExcIEEEAC8B
   *
   * @param command AssignKprToExcIEEEAC8BCommand
   */
  @PutMapping("/assignKpr")
  public void assignKpr(@RequestBody AssignKprToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignKpr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpr", exc);
    }
  }

  /**
   * unassign Kpr on ExcIEEEAC8B
   *
   * @param command UnAssignKprFromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignKpr")
  public void unAssignKpr(@RequestBody(required = true) UnAssignKprFromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignKpr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpr", exc);
    }
  }

  /**
   * save Seve1 on ExcIEEEAC8B
   *
   * @param command AssignSeve1ToExcIEEEAC8BCommand
   */
  @PutMapping("/assignSeve1")
  public void assignSeve1(@RequestBody AssignSeve1ToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignSeve1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve1", exc);
    }
  }

  /**
   * unassign Seve1 on ExcIEEEAC8B
   *
   * @param command UnAssignSeve1FromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignSeve1")
  public void unAssignSeve1(
      @RequestBody(required = true) UnAssignSeve1FromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignSeve1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve1", exc);
    }
  }

  /**
   * save Seve2 on ExcIEEEAC8B
   *
   * @param command AssignSeve2ToExcIEEEAC8BCommand
   */
  @PutMapping("/assignSeve2")
  public void assignSeve2(@RequestBody AssignSeve2ToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignSeve2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve2", exc);
    }
  }

  /**
   * unassign Seve2 on ExcIEEEAC8B
   *
   * @param command UnAssignSeve2FromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignSeve2")
  public void unAssignSeve2(
      @RequestBody(required = true) UnAssignSeve2FromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignSeve2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve2", exc);
    }
  }

  /**
   * save Ta on ExcIEEEAC8B
   *
   * @param command AssignTaToExcIEEEAC8BCommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcIEEEAC8B
   *
   * @param command UnAssignTaFromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tdr on ExcIEEEAC8B
   *
   * @param command AssignTdrToExcIEEEAC8BCommand
   */
  @PutMapping("/assignTdr")
  public void assignTdr(@RequestBody AssignTdrToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignTdr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tdr", exc);
    }
  }

  /**
   * unassign Tdr on ExcIEEEAC8B
   *
   * @param command UnAssignTdrFromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignTdr")
  public void unAssignTdr(@RequestBody(required = true) UnAssignTdrFromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignTdr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tdr", exc);
    }
  }

  /**
   * save Te on ExcIEEEAC8B
   *
   * @param command AssignTeToExcIEEEAC8BCommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcIEEEAC8B
   *
   * @param command UnAssignTeFromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Ve1 on ExcIEEEAC8B
   *
   * @param command AssignVe1ToExcIEEEAC8BCommand
   */
  @PutMapping("/assignVe1")
  public void assignVe1(@RequestBody AssignVe1ToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignVe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve1", exc);
    }
  }

  /**
   * unassign Ve1 on ExcIEEEAC8B
   *
   * @param command UnAssignVe1FromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignVe1")
  public void unAssignVe1(@RequestBody(required = true) UnAssignVe1FromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignVe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve1", exc);
    }
  }

  /**
   * save Ve2 on ExcIEEEAC8B
   *
   * @param command AssignVe2ToExcIEEEAC8BCommand
   */
  @PutMapping("/assignVe2")
  public void assignVe2(@RequestBody AssignVe2ToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignVe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve2", exc);
    }
  }

  /**
   * unassign Ve2 on ExcIEEEAC8B
   *
   * @param command UnAssignVe2FromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignVe2")
  public void unAssignVe2(@RequestBody(required = true) UnAssignVe2FromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignVe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve2", exc);
    }
  }

  /**
   * save Vemin on ExcIEEEAC8B
   *
   * @param command AssignVeminToExcIEEEAC8BCommand
   */
  @PutMapping("/assignVemin")
  public void assignVemin(@RequestBody AssignVeminToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignVemin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vemin", exc);
    }
  }

  /**
   * unassign Vemin on ExcIEEEAC8B
   *
   * @param command UnAssignVeminFromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignVemin")
  public void unAssignVemin(
      @RequestBody(required = true) UnAssignVeminFromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignVemin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vemin", exc);
    }
  }

  /**
   * save Vfemax on ExcIEEEAC8B
   *
   * @param command AssignVfemaxToExcIEEEAC8BCommand
   */
  @PutMapping("/assignVfemax")
  public void assignVfemax(@RequestBody AssignVfemaxToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignVfemax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vfemax", exc);
    }
  }

  /**
   * unassign Vfemax on ExcIEEEAC8B
   *
   * @param command UnAssignVfemaxFromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignVfemax")
  public void unAssignVfemax(
      @RequestBody(required = true) UnAssignVfemaxFromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignVfemax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vfemax", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEAC8B
   *
   * @param command AssignVrmaxToExcIEEEAC8BCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEAC8B
   *
   * @param command UnAssignVrmaxFromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEAC8B
   *
   * @param command AssignVrminToExcIEEEAC8BCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEAC8B
   *
   * @param command UnAssignVrminFromExcIEEEAC8BCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEAC8BCommand command) {
    try {
      ExcIEEEAC8BBusinessDelegate.getExcIEEEAC8BInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEAC8B excIEEEAC8B = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEAC8BCommandRestController.class.getName());
}
