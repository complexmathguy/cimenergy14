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
 * Implements Spring Controller command CQRS processing for entity ExcHU.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcHU")
public class ExcHUCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcHU. if not key provided, calls create, otherwise calls save
   *
   * @param ExcHU excHU
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(@RequestBody(required = true) CreateExcHUCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcHUBusinessDelegate.getExcHUInstance().createExcHU(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcHU. if no key provided, calls create, otherwise calls save
   *
   * @param ExcHU excHU
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(@RequestBody(required = true) UpdateExcHUCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcHUCommand
      // -----------------------------------------------
      completableFuture = ExcHUBusinessDelegate.getExcHUInstance().updateExcHU(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcHUController:update() - successfully update ExcHU - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcHU entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excHUId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcHUCommand command = new DeleteExcHUCommand(excHUId);

    try {
      ExcHUBusinessDelegate delegate = ExcHUBusinessDelegate.getExcHUInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcHU with key " + command.getExcHUId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ae on ExcHU
   *
   * @param command AssignAeToExcHUCommand
   */
  @PutMapping("/assignAe")
  public void assignAe(@RequestBody AssignAeToExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().assignAe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ae", exc);
    }
  }

  /**
   * unassign Ae on ExcHU
   *
   * @param command UnAssignAeFromExcHUCommand
   */
  @PutMapping("/unAssignAe")
  public void unAssignAe(@RequestBody(required = true) UnAssignAeFromExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().unAssignAe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ae", exc);
    }
  }

  /**
   * save Ai on ExcHU
   *
   * @param command AssignAiToExcHUCommand
   */
  @PutMapping("/assignAi")
  public void assignAi(@RequestBody AssignAiToExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().assignAi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ai", exc);
    }
  }

  /**
   * unassign Ai on ExcHU
   *
   * @param command UnAssignAiFromExcHUCommand
   */
  @PutMapping("/unAssignAi")
  public void unAssignAi(@RequestBody(required = true) UnAssignAiFromExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().unAssignAi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ai", exc);
    }
  }

  /**
   * save Atr on ExcHU
   *
   * @param command AssignAtrToExcHUCommand
   */
  @PutMapping("/assignAtr")
  public void assignAtr(@RequestBody AssignAtrToExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().assignAtr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Atr", exc);
    }
  }

  /**
   * unassign Atr on ExcHU
   *
   * @param command UnAssignAtrFromExcHUCommand
   */
  @PutMapping("/unAssignAtr")
  public void unAssignAtr(@RequestBody(required = true) UnAssignAtrFromExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().unAssignAtr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Atr", exc);
    }
  }

  /**
   * save Emax on ExcHU
   *
   * @param command AssignEmaxToExcHUCommand
   */
  @PutMapping("/assignEmax")
  public void assignEmax(@RequestBody AssignEmaxToExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().assignEmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Emax", exc);
    }
  }

  /**
   * unassign Emax on ExcHU
   *
   * @param command UnAssignEmaxFromExcHUCommand
   */
  @PutMapping("/unAssignEmax")
  public void unAssignEmax(@RequestBody(required = true) UnAssignEmaxFromExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().unAssignEmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Emax", exc);
    }
  }

  /**
   * save Emin on ExcHU
   *
   * @param command AssignEminToExcHUCommand
   */
  @PutMapping("/assignEmin")
  public void assignEmin(@RequestBody AssignEminToExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().assignEmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Emin", exc);
    }
  }

  /**
   * unassign Emin on ExcHU
   *
   * @param command UnAssignEminFromExcHUCommand
   */
  @PutMapping("/unAssignEmin")
  public void unAssignEmin(@RequestBody(required = true) UnAssignEminFromExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().unAssignEmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Emin", exc);
    }
  }

  /**
   * save Imax on ExcHU
   *
   * @param command AssignImaxToExcHUCommand
   */
  @PutMapping("/assignImax")
  public void assignImax(@RequestBody AssignImaxToExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().assignImax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Imax", exc);
    }
  }

  /**
   * unassign Imax on ExcHU
   *
   * @param command UnAssignImaxFromExcHUCommand
   */
  @PutMapping("/unAssignImax")
  public void unAssignImax(@RequestBody(required = true) UnAssignImaxFromExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().unAssignImax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Imax", exc);
    }
  }

  /**
   * save Imin on ExcHU
   *
   * @param command AssignIminToExcHUCommand
   */
  @PutMapping("/assignImin")
  public void assignImin(@RequestBody AssignIminToExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().assignImin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Imin", exc);
    }
  }

  /**
   * unassign Imin on ExcHU
   *
   * @param command UnAssignIminFromExcHUCommand
   */
  @PutMapping("/unAssignImin")
  public void unAssignImin(@RequestBody(required = true) UnAssignIminFromExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().unAssignImin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Imin", exc);
    }
  }

  /**
   * save Ke on ExcHU
   *
   * @param command AssignKeToExcHUCommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on ExcHU
   *
   * @param command UnAssignKeFromExcHUCommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Ki on ExcHU
   *
   * @param command AssignKiToExcHUCommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on ExcHU
   *
   * @param command UnAssignKiFromExcHUCommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Te on ExcHU
   *
   * @param command AssignTeToExcHUCommand
   */
  @PutMapping("/assignTe")
  public void assignTe(@RequestBody AssignTeToExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().assignTe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Te", exc);
    }
  }

  /**
   * unassign Te on ExcHU
   *
   * @param command UnAssignTeFromExcHUCommand
   */
  @PutMapping("/unAssignTe")
  public void unAssignTe(@RequestBody(required = true) UnAssignTeFromExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().unAssignTe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Te", exc);
    }
  }

  /**
   * save Ti on ExcHU
   *
   * @param command AssignTiToExcHUCommand
   */
  @PutMapping("/assignTi")
  public void assignTi(@RequestBody AssignTiToExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().assignTi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti", exc);
    }
  }

  /**
   * unassign Ti on ExcHU
   *
   * @param command UnAssignTiFromExcHUCommand
   */
  @PutMapping("/unAssignTi")
  public void unAssignTi(@RequestBody(required = true) UnAssignTiFromExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().unAssignTi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti", exc);
    }
  }

  /**
   * save Tr on ExcHU
   *
   * @param command AssignTrToExcHUCommand
   */
  @PutMapping("/assignTr")
  public void assignTr(@RequestBody AssignTrToExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().assignTr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tr", exc);
    }
  }

  /**
   * unassign Tr on ExcHU
   *
   * @param command UnAssignTrFromExcHUCommand
   */
  @PutMapping("/unAssignTr")
  public void unAssignTr(@RequestBody(required = true) UnAssignTrFromExcHUCommand command) {
    try {
      ExcHUBusinessDelegate.getExcHUInstance().unAssignTr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tr", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcHU excHU = null;
  private static final Logger LOGGER = Logger.getLogger(ExcHUCommandRestController.class.getName());
}
