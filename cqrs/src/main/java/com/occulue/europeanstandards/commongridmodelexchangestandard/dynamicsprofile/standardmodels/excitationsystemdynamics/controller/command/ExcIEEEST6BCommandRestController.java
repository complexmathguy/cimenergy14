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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEST6B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST6B")
public class ExcIEEEST6BCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEST6B. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEST6B excIEEEST6B
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEST6BCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().createExcIEEEST6B(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEST6B. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEST6B excIEEEST6B
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEST6BCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEST6BCommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().updateExcIEEEST6B(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEST6BController:update() - successfully update ExcIEEEST6B - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEST6B entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEST6BId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEST6BCommand command = new DeleteExcIEEEST6BCommand(excIEEEST6BId);

    try {
      ExcIEEEST6BBusinessDelegate delegate = ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEST6B with key " + command.getExcIEEEST6BId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Ilr on ExcIEEEST6B
   *
   * @param command AssignIlrToExcIEEEST6BCommand
   */
  @PutMapping("/assignIlr")
  public void assignIlr(@RequestBody AssignIlrToExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().assignIlr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ilr", exc);
    }
  }

  /**
   * unassign Ilr on ExcIEEEST6B
   *
   * @param command UnAssignIlrFromExcIEEEST6BCommand
   */
  @PutMapping("/unAssignIlr")
  public void unAssignIlr(@RequestBody(required = true) UnAssignIlrFromExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().unAssignIlr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ilr", exc);
    }
  }

  /**
   * save Kci on ExcIEEEST6B
   *
   * @param command AssignKciToExcIEEEST6BCommand
   */
  @PutMapping("/assignKci")
  public void assignKci(@RequestBody AssignKciToExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().assignKci(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kci", exc);
    }
  }

  /**
   * unassign Kci on ExcIEEEST6B
   *
   * @param command UnAssignKciFromExcIEEEST6BCommand
   */
  @PutMapping("/unAssignKci")
  public void unAssignKci(@RequestBody(required = true) UnAssignKciFromExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().unAssignKci(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kci", exc);
    }
  }

  /**
   * save Kff on ExcIEEEST6B
   *
   * @param command AssignKffToExcIEEEST6BCommand
   */
  @PutMapping("/assignKff")
  public void assignKff(@RequestBody AssignKffToExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().assignKff(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kff", exc);
    }
  }

  /**
   * unassign Kff on ExcIEEEST6B
   *
   * @param command UnAssignKffFromExcIEEEST6BCommand
   */
  @PutMapping("/unAssignKff")
  public void unAssignKff(@RequestBody(required = true) UnAssignKffFromExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().unAssignKff(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kff", exc);
    }
  }

  /**
   * save Kg on ExcIEEEST6B
   *
   * @param command AssignKgToExcIEEEST6BCommand
   */
  @PutMapping("/assignKg")
  public void assignKg(@RequestBody AssignKgToExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().assignKg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kg", exc);
    }
  }

  /**
   * unassign Kg on ExcIEEEST6B
   *
   * @param command UnAssignKgFromExcIEEEST6BCommand
   */
  @PutMapping("/unAssignKg")
  public void unAssignKg(@RequestBody(required = true) UnAssignKgFromExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().unAssignKg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kg", exc);
    }
  }

  /**
   * save Kia on ExcIEEEST6B
   *
   * @param command AssignKiaToExcIEEEST6BCommand
   */
  @PutMapping("/assignKia")
  public void assignKia(@RequestBody AssignKiaToExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().assignKia(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kia", exc);
    }
  }

  /**
   * unassign Kia on ExcIEEEST6B
   *
   * @param command UnAssignKiaFromExcIEEEST6BCommand
   */
  @PutMapping("/unAssignKia")
  public void unAssignKia(@RequestBody(required = true) UnAssignKiaFromExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().unAssignKia(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kia", exc);
    }
  }

  /**
   * save Klr on ExcIEEEST6B
   *
   * @param command AssignKlrToExcIEEEST6BCommand
   */
  @PutMapping("/assignKlr")
  public void assignKlr(@RequestBody AssignKlrToExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().assignKlr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Klr", exc);
    }
  }

  /**
   * unassign Klr on ExcIEEEST6B
   *
   * @param command UnAssignKlrFromExcIEEEST6BCommand
   */
  @PutMapping("/unAssignKlr")
  public void unAssignKlr(@RequestBody(required = true) UnAssignKlrFromExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().unAssignKlr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Klr", exc);
    }
  }

  /**
   * save Km on ExcIEEEST6B
   *
   * @param command AssignKmToExcIEEEST6BCommand
   */
  @PutMapping("/assignKm")
  public void assignKm(@RequestBody AssignKmToExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().assignKm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Km", exc);
    }
  }

  /**
   * unassign Km on ExcIEEEST6B
   *
   * @param command UnAssignKmFromExcIEEEST6BCommand
   */
  @PutMapping("/unAssignKm")
  public void unAssignKm(@RequestBody(required = true) UnAssignKmFromExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().unAssignKm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Km", exc);
    }
  }

  /**
   * save Kpa on ExcIEEEST6B
   *
   * @param command AssignKpaToExcIEEEST6BCommand
   */
  @PutMapping("/assignKpa")
  public void assignKpa(@RequestBody AssignKpaToExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().assignKpa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpa", exc);
    }
  }

  /**
   * unassign Kpa on ExcIEEEST6B
   *
   * @param command UnAssignKpaFromExcIEEEST6BCommand
   */
  @PutMapping("/unAssignKpa")
  public void unAssignKpa(@RequestBody(required = true) UnAssignKpaFromExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().unAssignKpa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpa", exc);
    }
  }

  /**
   * save Tg on ExcIEEEST6B
   *
   * @param command AssignTgToExcIEEEST6BCommand
   */
  @PutMapping("/assignTg")
  public void assignTg(@RequestBody AssignTgToExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().assignTg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tg", exc);
    }
  }

  /**
   * unassign Tg on ExcIEEEST6B
   *
   * @param command UnAssignTgFromExcIEEEST6BCommand
   */
  @PutMapping("/unAssignTg")
  public void unAssignTg(@RequestBody(required = true) UnAssignTgFromExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().unAssignTg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tg", exc);
    }
  }

  /**
   * save Vamax on ExcIEEEST6B
   *
   * @param command AssignVamaxToExcIEEEST6BCommand
   */
  @PutMapping("/assignVamax")
  public void assignVamax(@RequestBody AssignVamaxToExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().assignVamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamax", exc);
    }
  }

  /**
   * unassign Vamax on ExcIEEEST6B
   *
   * @param command UnAssignVamaxFromExcIEEEST6BCommand
   */
  @PutMapping("/unAssignVamax")
  public void unAssignVamax(
      @RequestBody(required = true) UnAssignVamaxFromExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().unAssignVamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamax", exc);
    }
  }

  /**
   * save Vamin on ExcIEEEST6B
   *
   * @param command AssignVaminToExcIEEEST6BCommand
   */
  @PutMapping("/assignVamin")
  public void assignVamin(@RequestBody AssignVaminToExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().assignVamin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vamin", exc);
    }
  }

  /**
   * unassign Vamin on ExcIEEEST6B
   *
   * @param command UnAssignVaminFromExcIEEEST6BCommand
   */
  @PutMapping("/unAssignVamin")
  public void unAssignVamin(
      @RequestBody(required = true) UnAssignVaminFromExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().unAssignVamin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vamin", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEST6B
   *
   * @param command AssignVrmaxToExcIEEEST6BCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEST6B
   *
   * @param command UnAssignVrmaxFromExcIEEEST6BCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEST6B
   *
   * @param command AssignVrminToExcIEEEST6BCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEST6B
   *
   * @param command UnAssignVrminFromExcIEEEST6BCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEST6BCommand command) {
    try {
      ExcIEEEST6BBusinessDelegate.getExcIEEEST6BInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEST6B excIEEEST6B = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEST6BCommandRestController.class.getName());
}
