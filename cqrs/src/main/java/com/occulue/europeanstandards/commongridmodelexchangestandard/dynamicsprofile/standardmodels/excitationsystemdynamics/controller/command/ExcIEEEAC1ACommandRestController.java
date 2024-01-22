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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEAC1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEAC1A")
public class ExcIEEEAC1ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEAC1A. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC1A excIEEEAC1A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEAC1ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().createExcIEEEAC1A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEAC1A. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEAC1A excIEEEAC1A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEAC1ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEAC1ACommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().updateExcIEEEAC1A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEAC1AController:update() - successfully update ExcIEEEAC1A - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEAC1A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEAC1AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEAC1ACommand command = new DeleteExcIEEEAC1ACommand(excIEEEAC1AId);

    try {
      ExcIEEEAC1ABusinessDelegate delegate = ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEAC1A with key " + command.getExcIEEEAC1AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ka on ExcIEEEAC1A
   *
   * @param command AssignKaToExcIEEEAC1ACommand
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on ExcIEEEAC1A
   *
   * @param command UnAssignKaFromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kc on ExcIEEEAC1A
   *
   * @param command AssignKcToExcIEEEAC1ACommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on ExcIEEEAC1A
   *
   * @param command UnAssignKcFromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(@RequestBody(required = true) UnAssignKcFromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kd on ExcIEEEAC1A
   *
   * @param command AssignKdToExcIEEEAC1ACommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on ExcIEEEAC1A
   *
   * @param command UnAssignKdFromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Ke on ExcIEEEAC1A
   *
   * @param command AssignKeToExcIEEEAC1ACommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcIEEEAC1A
   *
   * @param command UnAssignKeFromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kf on ExcIEEEAC1A
   *
   * @param command AssignKfToExcIEEEAC1ACommand
   */
  @PutMapping("/assignKf")
  public void assignKf(@RequestBody AssignKfToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignKf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf", exc);
    }
  }

  /**
   * unassign Kf on ExcIEEEAC1A
   *
   * @param command UnAssignKfFromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignKf")
  public void unAssignKf(@RequestBody(required = true) UnAssignKfFromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignKf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf", exc);
    }
  }

  /**
   * save Seve1 on ExcIEEEAC1A
   *
   * @param command AssignSeve1ToExcIEEEAC1ACommand
   */
  @PutMapping("/assignSeve1")
  public void assignSeve1(@RequestBody AssignSeve1ToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignSeve1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve1", exc);
    }
  }

  /**
   * unassign Seve1 on ExcIEEEAC1A
   *
   * @param command UnAssignSeve1FromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignSeve1")
  public void unAssignSeve1(
      @RequestBody(required = true) UnAssignSeve1FromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignSeve1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve1", exc);
    }
  }

  /**
   * save Seve2 on ExcIEEEAC1A
   *
   * @param command AssignSeve2ToExcIEEEAC1ACommand
   */
  @PutMapping("/assignSeve2")
  public void assignSeve2(@RequestBody AssignSeve2ToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignSeve2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Seve2", exc);
    }
  }

  /**
   * unassign Seve2 on ExcIEEEAC1A
   *
   * @param command UnAssignSeve2FromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignSeve2")
  public void unAssignSeve2(
      @RequestBody(required = true) UnAssignSeve2FromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignSeve2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Seve2", exc);
    }
  }

  /**
   * save Ta on ExcIEEEAC1A
   *
   * @param command AssignTaToExcIEEEAC1ACommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on ExcIEEEAC1A
   *
   * @param command UnAssignTaFromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on ExcIEEEAC1A
   *
   * @param command AssignTbToExcIEEEAC1ACommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcIEEEAC1A
   *
   * @param command UnAssignTbFromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcIEEEAC1A
   *
   * @param command AssignTcToExcIEEEAC1ACommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcIEEEAC1A
   *
   * @param command UnAssignTcFromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Te on ExcIEEEAC1A
   *
   * @param command AssignTeToExcIEEEAC1ACommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcIEEEAC1A
   *
   * @param command UnAssignTeFromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Tf on ExcIEEEAC1A
   *
   * @param command AssignTfToExcIEEEAC1ACommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcIEEEAC1A
   *
   * @param command UnAssignTfFromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Vamax on ExcIEEEAC1A
   *
   * @param command AssignVamaxToExcIEEEAC1ACommand
   */
  @PutMapping("/assignVamax")
  public void assignVamax(@RequestBody AssignVamaxToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignVamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamax", exc);
    }
  }

  /**
   * unassign Vamax on ExcIEEEAC1A
   *
   * @param command UnAssignVamaxFromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignVamax")
  public void unAssignVamax(
      @RequestBody(required = true) UnAssignVamaxFromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignVamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamax", exc);
    }
  }

  /**
   * save Vamin on ExcIEEEAC1A
   *
   * @param command AssignVaminToExcIEEEAC1ACommand
   */
  @PutMapping("/assignVamin")
  public void assignVamin(@RequestBody AssignVaminToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignVamin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamin", exc);
    }
  }

  /**
   * unassign Vamin on ExcIEEEAC1A
   *
   * @param command UnAssignVaminFromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignVamin")
  public void unAssignVamin(
      @RequestBody(required = true) UnAssignVaminFromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignVamin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamin", exc);
    }
  }

  /**
   * save Ve1 on ExcIEEEAC1A
   *
   * @param command AssignVe1ToExcIEEEAC1ACommand
   */
  @PutMapping("/assignVe1")
  public void assignVe1(@RequestBody AssignVe1ToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignVe1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve1", exc);
    }
  }

  /**
   * unassign Ve1 on ExcIEEEAC1A
   *
   * @param command UnAssignVe1FromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignVe1")
  public void unAssignVe1(@RequestBody(required = true) UnAssignVe1FromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignVe1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve1", exc);
    }
  }

  /**
   * save Ve2 on ExcIEEEAC1A
   *
   * @param command AssignVe2ToExcIEEEAC1ACommand
   */
  @PutMapping("/assignVe2")
  public void assignVe2(@RequestBody AssignVe2ToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignVe2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ve2", exc);
    }
  }

  /**
   * unassign Ve2 on ExcIEEEAC1A
   *
   * @param command UnAssignVe2FromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignVe2")
  public void unAssignVe2(@RequestBody(required = true) UnAssignVe2FromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignVe2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ve2", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEAC1A
   *
   * @param command AssignVrmaxToExcIEEEAC1ACommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEAC1A
   *
   * @param command UnAssignVrmaxFromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEAC1A
   *
   * @param command AssignVrminToExcIEEEAC1ACommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEAC1A
   *
   * @param command UnAssignVrminFromExcIEEEAC1ACommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEAC1ACommand command) {
    try {
      ExcIEEEAC1ABusinessDelegate.getExcIEEEAC1AInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEAC1A excIEEEAC1A = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEAC1ACommandRestController.class.getName());
}
