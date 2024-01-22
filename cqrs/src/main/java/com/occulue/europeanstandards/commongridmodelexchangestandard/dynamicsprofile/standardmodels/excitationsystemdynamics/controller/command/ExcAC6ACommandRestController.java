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
 * Implements Spring Controller command CQRS processing for entity ExcAC6A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcAC6A")
public class ExcAC6ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcAC6A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcAC6A excAC6A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcAC6ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcAC6ABusinessDelegate.getExcAC6AInstance().createExcAC6A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcAC6A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcAC6A excAC6A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcAC6ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcAC6ACommand
      // -----------------------------------------------
      completableFuture = ExcAC6ABusinessDelegate.getExcAC6AInstance().updateExcAC6A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcAC6AController:update() - successfully update ExcAC6A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcAC6A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excAC6AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcAC6ACommand command = new DeleteExcAC6ACommand(excAC6AId);

    try {
      ExcAC6ABusinessDelegate delegate = ExcAC6ABusinessDelegate.getExcAC6AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcAC6A with key " + command.getExcAC6AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ka on ExcAC6A
   *
   * @param command AssignKaToExcAC6ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcAC6A
   *
   * @param command UnAssignKaFromExcAC6ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcAC6A
   *
   * @param command AssignKcToExcAC6ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcAC6A
   *
   * @param command UnAssignKcFromExcAC6ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kd on ExcAC6A
   *
   * @param command AssignKdToExcAC6ACommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on ExcAC6A
   *
   * @param command UnAssignKdFromExcAC6ACommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Ke on ExcAC6A
   *
   * @param command AssignKeToExcAC6ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcAC6A
   *
   * @param command UnAssignKeFromExcAC6ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kh on ExcAC6A
   *
   * @param command AssignKhToExcAC6ACommand
   */
  @PutMapping("/assignKh")
  public void assignKh(@RequestBody AssignKhToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignKh(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kh", exc);
    }
  }

  /**
   * unassign Kh on ExcAC6A
   *
   * @param command UnAssignKhFromExcAC6ACommand
   */
  @PutMapping("/unAssignKh")
  public void unAssignKh(@RequestBody(required = true) UnAssignKhFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignKh(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kh", exc);
    }
  }

  /**
   * save Ks on ExcAC6A
   *
   * @param command AssignKsToExcAC6ACommand
   */
  @PutMapping("/assignKs")
  public void assignKs(@RequestBody AssignKsToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignKs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ks", exc);
    }
  }

  /**
   * unassign Ks on ExcAC6A
   *
   * @param command UnAssignKsFromExcAC6ACommand
   */
  @PutMapping("/unAssignKs")
  public void unAssignKs(@RequestBody(required = true) UnAssignKsFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignKs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ks", exc);
    }
  }

  /**
   * save Seve1 on ExcAC6A
   *
   * @param command AssignSeve1ToExcAC6ACommand
   */
  @PutMapping("/assignSeve1")
  public void assignSeve1(@RequestBody AssignSeve1ToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignSeve1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve1", exc);
    }
  }

  /**
   * unassign Seve1 on ExcAC6A
   *
   * @param command UnAssignSeve1FromExcAC6ACommand
   */
  @PutMapping("/unAssignSeve1")
  public void unAssignSeve1(@RequestBody(required = true) UnAssignSeve1FromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignSeve1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve1", exc);
    }
  }

  /**
   * save Seve2 on ExcAC6A
   *
   * @param command AssignSeve2ToExcAC6ACommand
   */
  @PutMapping("/assignSeve2")
  public void assignSeve2(@RequestBody AssignSeve2ToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignSeve2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve2", exc);
    }
  }

  /**
   * unassign Seve2 on ExcAC6A
   *
   * @param command UnAssignSeve2FromExcAC6ACommand
   */
  @PutMapping("/unAssignSeve2")
  public void unAssignSeve2(@RequestBody(required = true) UnAssignSeve2FromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignSeve2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve2", exc);
    }
  }

  /**
   * save Ta on ExcAC6A
   *
   * @param command AssignTaToExcAC6ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcAC6A
   *
   * @param command UnAssignTaFromExcAC6ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcAC6A
   *
   * @param command AssignTbToExcAC6ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcAC6A
   *
   * @param command UnAssignTbFromExcAC6ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcAC6A
   *
   * @param command AssignTcToExcAC6ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcAC6A
   *
   * @param command UnAssignTcFromExcAC6ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcAC6A
   *
   * @param command AssignTeToExcAC6ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcAC6A
   *
   * @param command UnAssignTeFromExcAC6ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Th on ExcAC6A
   *
   * @param command AssignThToExcAC6ACommand
   */
  @PutMapping("/assignTh")
  public void assignTh(@RequestBody AssignThToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignTh(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Th", exc);
    }
  }

  /**
   * unassign Th on ExcAC6A
   *
   * @param command UnAssignThFromExcAC6ACommand
   */
  @PutMapping("/unAssignTh")
  public void unAssignTh(@RequestBody(required = true) UnAssignThFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignTh(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Th", exc);
    }
  }

  /**
   * save Tj on ExcAC6A
   *
   * @param command AssignTjToExcAC6ACommand
   */
  @PutMapping("/assignTj")
  public void assignTj(@RequestBody AssignTjToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignTj(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tj", exc);
    }
  }

  /**
   * unassign Tj on ExcAC6A
   *
   * @param command UnAssignTjFromExcAC6ACommand
   */
  @PutMapping("/unAssignTj")
  public void unAssignTj(@RequestBody(required = true) UnAssignTjFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignTj(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tj", exc);
    }
  }

  /**
   * save Tk on ExcAC6A
   *
   * @param command AssignTkToExcAC6ACommand
   */
  @PutMapping("/assignTk")
  public void assignTk(@RequestBody AssignTkToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignTk(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tk", exc);
    }
  }

  /**
   * unassign Tk on ExcAC6A
   *
   * @param command UnAssignTkFromExcAC6ACommand
   */
  @PutMapping("/unAssignTk")
  public void unAssignTk(@RequestBody(required = true) UnAssignTkFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignTk(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tk", exc);
    }
  }

  /**
   * save Vamax on ExcAC6A
   *
   * @param command AssignVamaxToExcAC6ACommand
   */
  @PutMapping("/assignVamax")
  public void assignVamax(@RequestBody AssignVamaxToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignVamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamax", exc);
    }
  }

  /**
   * unassign Vamax on ExcAC6A
   *
   * @param command UnAssignVamaxFromExcAC6ACommand
   */
  @PutMapping("/unAssignVamax")
  public void unAssignVamax(@RequestBody(required = true) UnAssignVamaxFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignVamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamax", exc);
    }
  }

  /**
   * save Vamin on ExcAC6A
   *
   * @param command AssignVaminToExcAC6ACommand
   */
  @PutMapping("/assignVamin")
  public void assignVamin(@RequestBody AssignVaminToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignVamin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamin", exc);
    }
  }

  /**
   * unassign Vamin on ExcAC6A
   *
   * @param command UnAssignVaminFromExcAC6ACommand
   */
  @PutMapping("/unAssignVamin")
  public void unAssignVamin(@RequestBody(required = true) UnAssignVaminFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignVamin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamin", exc);
    }
  }

  /**
   * save Ve1 on ExcAC6A
   *
   * @param command AssignVe1ToExcAC6ACommand
   */
  @PutMapping("/assignVe1")
  public void assignVe1(@RequestBody AssignVe1ToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignVe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve1", exc);
    }
  }

  /**
   * unassign Ve1 on ExcAC6A
   *
   * @param command UnAssignVe1FromExcAC6ACommand
   */
  @PutMapping("/unAssignVe1")
  public void unAssignVe1(@RequestBody(required = true) UnAssignVe1FromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignVe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve1", exc);
    }
  }

  /**
   * save Ve2 on ExcAC6A
   *
   * @param command AssignVe2ToExcAC6ACommand
   */
  @PutMapping("/assignVe2")
  public void assignVe2(@RequestBody AssignVe2ToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignVe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve2", exc);
    }
  }

  /**
   * unassign Ve2 on ExcAC6A
   *
   * @param command UnAssignVe2FromExcAC6ACommand
   */
  @PutMapping("/unAssignVe2")
  public void unAssignVe2(@RequestBody(required = true) UnAssignVe2FromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignVe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve2", exc);
    }
  }

  /**
   * save Vfelim on ExcAC6A
   *
   * @param command AssignVfelimToExcAC6ACommand
   */
  @PutMapping("/assignVfelim")
  public void assignVfelim(@RequestBody AssignVfelimToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignVfelim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vfelim", exc);
    }
  }

  /**
   * unassign Vfelim on ExcAC6A
   *
   * @param command UnAssignVfelimFromExcAC6ACommand
   */
  @PutMapping("/unAssignVfelim")
  public void unAssignVfelim(
      @RequestBody(required = true) UnAssignVfelimFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignVfelim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vfelim", exc);
    }
  }

  /**
   * save Vhmax on ExcAC6A
   *
   * @param command AssignVhmaxToExcAC6ACommand
   */
  @PutMapping("/assignVhmax")
  public void assignVhmax(@RequestBody AssignVhmaxToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignVhmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vhmax", exc);
    }
  }

  /**
   * unassign Vhmax on ExcAC6A
   *
   * @param command UnAssignVhmaxFromExcAC6ACommand
   */
  @PutMapping("/unAssignVhmax")
  public void unAssignVhmax(@RequestBody(required = true) UnAssignVhmaxFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignVhmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vhmax", exc);
    }
  }

  /**
   * save Vrmax on ExcAC6A
   *
   * @param command AssignVrmaxToExcAC6ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcAC6A
   *
   * @param command UnAssignVrmaxFromExcAC6ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcAC6A
   *
   * @param command AssignVrminToExcAC6ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcAC6A
   *
   * @param command UnAssignVrminFromExcAC6ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcAC6ACommand command) {
    try {
      ExcAC6ABusinessDelegate.getExcAC6AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcAC6A excAC6A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcAC6ACommandRestController.class.getName());
}
