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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC6A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC6A")
public class ExcIEEEAC6ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEAC6A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC6A excIEEEAC6A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEAC6ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().createExcIEEEAC6A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEAC6A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC6A excIEEEAC6A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEAC6ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEAC6ACommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().updateExcIEEEAC6A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEAC6AController:update() - successfully update ExcIEEEAC6A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEAC6A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEAC6AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEAC6ACommand command = new DeleteExcIEEEAC6ACommand(excIEEEAC6AId);

    try {
      ExcIEEEAC6ABusinessDelegate delegate = ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEAC6A with key " + command.getExcIEEEAC6AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ka on ExcIEEEAC6A
   *
   * @param command AssignKaToExcIEEEAC6ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcIEEEAC6A
   *
   * @param command UnAssignKaFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcIEEEAC6A
   *
   * @param command AssignKcToExcIEEEAC6ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcIEEEAC6A
   *
   * @param command UnAssignKcFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kd on ExcIEEEAC6A
   *
   * @param command AssignKdToExcIEEEAC6ACommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on ExcIEEEAC6A
   *
   * @param command UnAssignKdFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Ke on ExcIEEEAC6A
   *
   * @param command AssignKeToExcIEEEAC6ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcIEEEAC6A
   *
   * @param command UnAssignKeFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kh on ExcIEEEAC6A
   *
   * @param command AssignKhToExcIEEEAC6ACommand
   */
  @PutMapping("/assignKh")
  public void assignKh(@RequestBody AssignKhToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignKh(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kh", exc);
    }
  }

  /**
   * unassign Kh on ExcIEEEAC6A
   *
   * @param command UnAssignKhFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignKh")
  public void unAssignKh(@RequestBody(required = true) UnAssignKhFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignKh(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kh", exc);
    }
  }

  /**
   * save Seve1 on ExcIEEEAC6A
   *
   * @param command AssignSeve1ToExcIEEEAC6ACommand
   */
  @PutMapping("/assignSeve1")
  public void assignSeve1(@RequestBody AssignSeve1ToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignSeve1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve1", exc);
    }
  }

  /**
   * unassign Seve1 on ExcIEEEAC6A
   *
   * @param command UnAssignSeve1FromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignSeve1")
  public void unAssignSeve1(
      @RequestBody(required = true) UnAssignSeve1FromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignSeve1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve1", exc);
    }
  }

  /**
   * save Seve2 on ExcIEEEAC6A
   *
   * @param command AssignSeve2ToExcIEEEAC6ACommand
   */
  @PutMapping("/assignSeve2")
  public void assignSeve2(@RequestBody AssignSeve2ToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignSeve2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve2", exc);
    }
  }

  /**
   * unassign Seve2 on ExcIEEEAC6A
   *
   * @param command UnAssignSeve2FromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignSeve2")
  public void unAssignSeve2(
      @RequestBody(required = true) UnAssignSeve2FromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignSeve2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve2", exc);
    }
  }

  /**
   * save Ta on ExcIEEEAC6A
   *
   * @param command AssignTaToExcIEEEAC6ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcIEEEAC6A
   *
   * @param command UnAssignTaFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcIEEEAC6A
   *
   * @param command AssignTbToExcIEEEAC6ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcIEEEAC6A
   *
   * @param command UnAssignTbFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcIEEEAC6A
   *
   * @param command AssignTcToExcIEEEAC6ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcIEEEAC6A
   *
   * @param command UnAssignTcFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcIEEEAC6A
   *
   * @param command AssignTeToExcIEEEAC6ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcIEEEAC6A
   *
   * @param command UnAssignTeFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Th on ExcIEEEAC6A
   *
   * @param command AssignThToExcIEEEAC6ACommand
   */
  @PutMapping("/assignTh")
  public void assignTh(@RequestBody AssignThToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignTh(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Th", exc);
    }
  }

  /**
   * unassign Th on ExcIEEEAC6A
   *
   * @param command UnAssignThFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignTh")
  public void unAssignTh(@RequestBody(required = true) UnAssignThFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignTh(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Th", exc);
    }
  }

  /**
   * save Tj on ExcIEEEAC6A
   *
   * @param command AssignTjToExcIEEEAC6ACommand
   */
  @PutMapping("/assignTj")
  public void assignTj(@RequestBody AssignTjToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignTj(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tj", exc);
    }
  }

  /**
   * unassign Tj on ExcIEEEAC6A
   *
   * @param command UnAssignTjFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignTj")
  public void unAssignTj(@RequestBody(required = true) UnAssignTjFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignTj(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tj", exc);
    }
  }

  /**
   * save Tk on ExcIEEEAC6A
   *
   * @param command AssignTkToExcIEEEAC6ACommand
   */
  @PutMapping("/assignTk")
  public void assignTk(@RequestBody AssignTkToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignTk(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tk", exc);
    }
  }

  /**
   * unassign Tk on ExcIEEEAC6A
   *
   * @param command UnAssignTkFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignTk")
  public void unAssignTk(@RequestBody(required = true) UnAssignTkFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignTk(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tk", exc);
    }
  }

  /**
   * save Vamax on ExcIEEEAC6A
   *
   * @param command AssignVamaxToExcIEEEAC6ACommand
   */
  @PutMapping("/assignVamax")
  public void assignVamax(@RequestBody AssignVamaxToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignVamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamax", exc);
    }
  }

  /**
   * unassign Vamax on ExcIEEEAC6A
   *
   * @param command UnAssignVamaxFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignVamax")
  public void unAssignVamax(
      @RequestBody(required = true) UnAssignVamaxFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignVamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamax", exc);
    }
  }

  /**
   * save Vamin on ExcIEEEAC6A
   *
   * @param command AssignVaminToExcIEEEAC6ACommand
   */
  @PutMapping("/assignVamin")
  public void assignVamin(@RequestBody AssignVaminToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignVamin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamin", exc);
    }
  }

  /**
   * unassign Vamin on ExcIEEEAC6A
   *
   * @param command UnAssignVaminFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignVamin")
  public void unAssignVamin(
      @RequestBody(required = true) UnAssignVaminFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignVamin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamin", exc);
    }
  }

  /**
   * save Ve1 on ExcIEEEAC6A
   *
   * @param command AssignVe1ToExcIEEEAC6ACommand
   */
  @PutMapping("/assignVe1")
  public void assignVe1(@RequestBody AssignVe1ToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignVe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve1", exc);
    }
  }

  /**
   * unassign Ve1 on ExcIEEEAC6A
   *
   * @param command UnAssignVe1FromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignVe1")
  public void unAssignVe1(@RequestBody(required = true) UnAssignVe1FromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignVe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve1", exc);
    }
  }

  /**
   * save Ve2 on ExcIEEEAC6A
   *
   * @param command AssignVe2ToExcIEEEAC6ACommand
   */
  @PutMapping("/assignVe2")
  public void assignVe2(@RequestBody AssignVe2ToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignVe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve2", exc);
    }
  }

  /**
   * unassign Ve2 on ExcIEEEAC6A
   *
   * @param command UnAssignVe2FromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignVe2")
  public void unAssignVe2(@RequestBody(required = true) UnAssignVe2FromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignVe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve2", exc);
    }
  }

  /**
   * save Vfelim on ExcIEEEAC6A
   *
   * @param command AssignVfelimToExcIEEEAC6ACommand
   */
  @PutMapping("/assignVfelim")
  public void assignVfelim(@RequestBody AssignVfelimToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignVfelim(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vfelim", exc);
    }
  }

  /**
   * unassign Vfelim on ExcIEEEAC6A
   *
   * @param command UnAssignVfelimFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignVfelim")
  public void unAssignVfelim(
      @RequestBody(required = true) UnAssignVfelimFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignVfelim(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vfelim", exc);
    }
  }

  /**
   * save Vhmax on ExcIEEEAC6A
   *
   * @param command AssignVhmaxToExcIEEEAC6ACommand
   */
  @PutMapping("/assignVhmax")
  public void assignVhmax(@RequestBody AssignVhmaxToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignVhmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vhmax", exc);
    }
  }

  /**
   * unassign Vhmax on ExcIEEEAC6A
   *
   * @param command UnAssignVhmaxFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignVhmax")
  public void unAssignVhmax(
      @RequestBody(required = true) UnAssignVhmaxFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignVhmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vhmax", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEAC6A
   *
   * @param command AssignVrmaxToExcIEEEAC6ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEAC6A
   *
   * @param command UnAssignVrmaxFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEAC6A
   *
   * @param command AssignVrminToExcIEEEAC6ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEAC6A
   *
   * @param command UnAssignVrminFromExcIEEEAC6ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEAC6ACommand command) {
    try {
      ExcIEEEAC6ABusinessDelegate.getExcIEEEAC6AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEAC6A excIEEEAC6A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEAC6ACommandRestController.class.getName());
}
