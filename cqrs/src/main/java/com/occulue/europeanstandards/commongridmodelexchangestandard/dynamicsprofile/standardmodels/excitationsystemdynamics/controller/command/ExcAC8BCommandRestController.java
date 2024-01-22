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
 * Implements Spring Controller command CQRS processing for entity ExcAC8B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAC8B")
public class ExcAC8BCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcAC8B. if not key provided, calls create, otherwise calls save
   *
   * @param ExcAC8B excAC8B
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcAC8BCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcAC8BBusinessDelegate.getExcAC8BInstance().createExcAC8B(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcAC8B. if no key provided, calls create, otherwise calls save
   *
   * @param ExcAC8B excAC8B
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcAC8BCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcAC8BCommand
      // -----------------------------------------------
      completableFuture = ExcAC8BBusinessDelegate.getExcAC8BInstance().updateExcAC8B(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcAC8BController:update() - successfully update ExcAC8B - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcAC8B entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excAC8BId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcAC8BCommand command = new DeleteExcAC8BCommand(excAC8BId);

    try {
      ExcAC8BBusinessDelegate delegate = ExcAC8BBusinessDelegate.getExcAC8BInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcAC8B with key " + command.getExcAC8BId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Inlim on ExcAC8B
   *
   * @param command AssignInlimToExcAC8BCommand
   */
  @PutMapping("/assignInlim")
  public void assignInlim(@RequestBody AssignInlimToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignInlim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Inlim", exc);
    }
  }

  /**
   * unassign Inlim on ExcAC8B
   *
   * @param command UnAssignInlimFromExcAC8BCommand
   */
  @PutMapping("/unAssignInlim")
  public void unAssignInlim(@RequestBody(required = true) UnAssignInlimFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignInlim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Inlim", exc);
    }
  }

  /**
   * save Ka on ExcAC8B
   *
   * @param command AssignKaToExcAC8BCommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcAC8B
   *
   * @param command UnAssignKaFromExcAC8BCommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcAC8B
   *
   * @param command AssignKcToExcAC8BCommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcAC8B
   *
   * @param command UnAssignKcFromExcAC8BCommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kd on ExcAC8B
   *
   * @param command AssignKdToExcAC8BCommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on ExcAC8B
   *
   * @param command UnAssignKdFromExcAC8BCommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Kdr on ExcAC8B
   *
   * @param command AssignKdrToExcAC8BCommand
   */
  @PutMapping("/assignKdr")
  public void assignKdr(@RequestBody AssignKdrToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignKdr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kdr", exc);
    }
  }

  /**
   * unassign Kdr on ExcAC8B
   *
   * @param command UnAssignKdrFromExcAC8BCommand
   */
  @PutMapping("/unAssignKdr")
  public void unAssignKdr(@RequestBody(required = true) UnAssignKdrFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignKdr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kdr", exc);
    }
  }

  /**
   * save Ke on ExcAC8B
   *
   * @param command AssignKeToExcAC8BCommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcAC8B
   *
   * @param command UnAssignKeFromExcAC8BCommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kir on ExcAC8B
   *
   * @param command AssignKirToExcAC8BCommand
   */
  @PutMapping("/assignKir")
  public void assignKir(@RequestBody AssignKirToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignKir(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kir", exc);
    }
  }

  /**
   * unassign Kir on ExcAC8B
   *
   * @param command UnAssignKirFromExcAC8BCommand
   */
  @PutMapping("/unAssignKir")
  public void unAssignKir(@RequestBody(required = true) UnAssignKirFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignKir(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kir", exc);
    }
  }

  /**
   * save Kpr on ExcAC8B
   *
   * @param command AssignKprToExcAC8BCommand
   */
  @PutMapping("/assignKpr")
  public void assignKpr(@RequestBody AssignKprToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignKpr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpr", exc);
    }
  }

  /**
   * unassign Kpr on ExcAC8B
   *
   * @param command UnAssignKprFromExcAC8BCommand
   */
  @PutMapping("/unAssignKpr")
  public void unAssignKpr(@RequestBody(required = true) UnAssignKprFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignKpr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpr", exc);
    }
  }

  /**
   * save Ks on ExcAC8B
   *
   * @param command AssignKsToExcAC8BCommand
   */
  @PutMapping("/assignKs")
  public void assignKs(@RequestBody AssignKsToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignKs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks", exc);
    }
  }

  /**
   * unassign Ks on ExcAC8B
   *
   * @param command UnAssignKsFromExcAC8BCommand
   */
  @PutMapping("/unAssignKs")
  public void unAssignKs(@RequestBody(required = true) UnAssignKsFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignKs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks", exc);
    }
  }

  /**
   * save Pidlim on ExcAC8B
   *
   * @param command AssignPidlimToExcAC8BCommand
   */
  @PutMapping("/assignPidlim")
  public void assignPidlim(@RequestBody AssignPidlimToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignPidlim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pidlim", exc);
    }
  }

  /**
   * unassign Pidlim on ExcAC8B
   *
   * @param command UnAssignPidlimFromExcAC8BCommand
   */
  @PutMapping("/unAssignPidlim")
  public void unAssignPidlim(
      @RequestBody(required = true) UnAssignPidlimFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignPidlim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pidlim", exc);
    }
  }

  /**
   * save Seve1 on ExcAC8B
   *
   * @param command AssignSeve1ToExcAC8BCommand
   */
  @PutMapping("/assignSeve1")
  public void assignSeve1(@RequestBody AssignSeve1ToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignSeve1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve1", exc);
    }
  }

  /**
   * unassign Seve1 on ExcAC8B
   *
   * @param command UnAssignSeve1FromExcAC8BCommand
   */
  @PutMapping("/unAssignSeve1")
  public void unAssignSeve1(@RequestBody(required = true) UnAssignSeve1FromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignSeve1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve1", exc);
    }
  }

  /**
   * save Seve2 on ExcAC8B
   *
   * @param command AssignSeve2ToExcAC8BCommand
   */
  @PutMapping("/assignSeve2")
  public void assignSeve2(@RequestBody AssignSeve2ToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignSeve2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve2", exc);
    }
  }

  /**
   * unassign Seve2 on ExcAC8B
   *
   * @param command UnAssignSeve2FromExcAC8BCommand
   */
  @PutMapping("/unAssignSeve2")
  public void unAssignSeve2(@RequestBody(required = true) UnAssignSeve2FromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignSeve2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve2", exc);
    }
  }

  /**
   * save Ta on ExcAC8B
   *
   * @param command AssignTaToExcAC8BCommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcAC8B
   *
   * @param command UnAssignTaFromExcAC8BCommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tdr on ExcAC8B
   *
   * @param command AssignTdrToExcAC8BCommand
   */
  @PutMapping("/assignTdr")
  public void assignTdr(@RequestBody AssignTdrToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignTdr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tdr", exc);
    }
  }

  /**
   * unassign Tdr on ExcAC8B
   *
   * @param command UnAssignTdrFromExcAC8BCommand
   */
  @PutMapping("/unAssignTdr")
  public void unAssignTdr(@RequestBody(required = true) UnAssignTdrFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignTdr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tdr", exc);
    }
  }

  /**
   * save Te on ExcAC8B
   *
   * @param command AssignTeToExcAC8BCommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcAC8B
   *
   * @param command UnAssignTeFromExcAC8BCommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Telim on ExcAC8B
   *
   * @param command AssignTelimToExcAC8BCommand
   */
  @PutMapping("/assignTelim")
  public void assignTelim(@RequestBody AssignTelimToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignTelim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Telim", exc);
    }
  }

  /**
   * unassign Telim on ExcAC8B
   *
   * @param command UnAssignTelimFromExcAC8BCommand
   */
  @PutMapping("/unAssignTelim")
  public void unAssignTelim(@RequestBody(required = true) UnAssignTelimFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignTelim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Telim", exc);
    }
  }

  /**
   * save Ve1 on ExcAC8B
   *
   * @param command AssignVe1ToExcAC8BCommand
   */
  @PutMapping("/assignVe1")
  public void assignVe1(@RequestBody AssignVe1ToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignVe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve1", exc);
    }
  }

  /**
   * unassign Ve1 on ExcAC8B
   *
   * @param command UnAssignVe1FromExcAC8BCommand
   */
  @PutMapping("/unAssignVe1")
  public void unAssignVe1(@RequestBody(required = true) UnAssignVe1FromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignVe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve1", exc);
    }
  }

  /**
   * save Ve2 on ExcAC8B
   *
   * @param command AssignVe2ToExcAC8BCommand
   */
  @PutMapping("/assignVe2")
  public void assignVe2(@RequestBody AssignVe2ToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignVe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve2", exc);
    }
  }

  /**
   * unassign Ve2 on ExcAC8B
   *
   * @param command UnAssignVe2FromExcAC8BCommand
   */
  @PutMapping("/unAssignVe2")
  public void unAssignVe2(@RequestBody(required = true) UnAssignVe2FromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignVe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve2", exc);
    }
  }

  /**
   * save Vemin on ExcAC8B
   *
   * @param command AssignVeminToExcAC8BCommand
   */
  @PutMapping("/assignVemin")
  public void assignVemin(@RequestBody AssignVeminToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignVemin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vemin", exc);
    }
  }

  /**
   * unassign Vemin on ExcAC8B
   *
   * @param command UnAssignVeminFromExcAC8BCommand
   */
  @PutMapping("/unAssignVemin")
  public void unAssignVemin(@RequestBody(required = true) UnAssignVeminFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignVemin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vemin", exc);
    }
  }

  /**
   * save Vfemax on ExcAC8B
   *
   * @param command AssignVfemaxToExcAC8BCommand
   */
  @PutMapping("/assignVfemax")
  public void assignVfemax(@RequestBody AssignVfemaxToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignVfemax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vfemax", exc);
    }
  }

  /**
   * unassign Vfemax on ExcAC8B
   *
   * @param command UnAssignVfemaxFromExcAC8BCommand
   */
  @PutMapping("/unAssignVfemax")
  public void unAssignVfemax(
      @RequestBody(required = true) UnAssignVfemaxFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignVfemax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vfemax", exc);
    }
  }

  /**
   * save Vimax on ExcAC8B
   *
   * @param command AssignVimaxToExcAC8BCommand
   */
  @PutMapping("/assignVimax")
  public void assignVimax(@RequestBody AssignVimaxToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignVimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimax", exc);
    }
  }

  /**
   * unassign Vimax on ExcAC8B
   *
   * @param command UnAssignVimaxFromExcAC8BCommand
   */
  @PutMapping("/unAssignVimax")
  public void unAssignVimax(@RequestBody(required = true) UnAssignVimaxFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignVimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimax", exc);
    }
  }

  /**
   * save Vimin on ExcAC8B
   *
   * @param command AssignViminToExcAC8BCommand
   */
  @PutMapping("/assignVimin")
  public void assignVimin(@RequestBody AssignViminToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignVimin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vimin", exc);
    }
  }

  /**
   * unassign Vimin on ExcAC8B
   *
   * @param command UnAssignViminFromExcAC8BCommand
   */
  @PutMapping("/unAssignVimin")
  public void unAssignVimin(@RequestBody(required = true) UnAssignViminFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignVimin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vimin", exc);
    }
  }

  /**
   * save Vpidmax on ExcAC8B
   *
   * @param command AssignVpidmaxToExcAC8BCommand
   */
  @PutMapping("/assignVpidmax")
  public void assignVpidmax(@RequestBody AssignVpidmaxToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignVpidmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vpidmax", exc);
    }
  }

  /**
   * unassign Vpidmax on ExcAC8B
   *
   * @param command UnAssignVpidmaxFromExcAC8BCommand
   */
  @PutMapping("/unAssignVpidmax")
  public void unAssignVpidmax(
      @RequestBody(required = true) UnAssignVpidmaxFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignVpidmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vpidmax", exc);
    }
  }

  /**
   * save Vpidmin on ExcAC8B
   *
   * @param command AssignVpidminToExcAC8BCommand
   */
  @PutMapping("/assignVpidmin")
  public void assignVpidmin(@RequestBody AssignVpidminToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignVpidmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vpidmin", exc);
    }
  }

  /**
   * unassign Vpidmin on ExcAC8B
   *
   * @param command UnAssignVpidminFromExcAC8BCommand
   */
  @PutMapping("/unAssignVpidmin")
  public void unAssignVpidmin(
      @RequestBody(required = true) UnAssignVpidminFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignVpidmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vpidmin", exc);
    }
  }

  /**
   * save Vrmax on ExcAC8B
   *
   * @param command AssignVrmaxToExcAC8BCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcAC8B
   *
   * @param command UnAssignVrmaxFromExcAC8BCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcAC8B
   *
   * @param command AssignVrminToExcAC8BCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcAC8B
   *
   * @param command UnAssignVrminFromExcAC8BCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  /**
   * save Vtmult on ExcAC8B
   *
   * @param command AssignVtmultToExcAC8BCommand
   */
  @PutMapping("/assignVtmult")
  public void assignVtmult(@RequestBody AssignVtmultToExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().assignVtmult(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vtmult", exc);
    }
  }

  /**
   * unassign Vtmult on ExcAC8B
   *
   * @param command UnAssignVtmultFromExcAC8BCommand
   */
  @PutMapping("/unAssignVtmult")
  public void unAssignVtmult(
      @RequestBody(required = true) UnAssignVtmultFromExcAC8BCommand command) {
    try {
      ExcAC8BBusinessDelegate.getExcAC8BInstance().unAssignVtmult(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vtmult", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcAC8B excAC8B = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcAC8BCommandRestController.class.getName());
}
