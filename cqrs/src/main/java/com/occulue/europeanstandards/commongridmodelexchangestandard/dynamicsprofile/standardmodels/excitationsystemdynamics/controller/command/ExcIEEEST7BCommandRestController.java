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
 * Implements Spring Controller command CQRS processing for entity ExcIEEEST7B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcIEEEST7B")
public class ExcIEEEST7BCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcIEEEST7B. if not key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEST7B excIEEEST7B
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcIEEEST7BCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().createExcIEEEST7B(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcIEEEST7B. if no key provided, calls create, otherwise calls save
   *
   * @param ExcIEEEST7B excIEEEST7B
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcIEEEST7BCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcIEEEST7BCommand
      // -----------------------------------------------
      completableFuture =
          ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().updateExcIEEEST7B(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcIEEEST7BController:update() - successfully update ExcIEEEST7B - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcIEEEST7B entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excIEEEST7BId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcIEEEST7BCommand command = new DeleteExcIEEEST7BCommand(excIEEEST7BId);

    try {
      ExcIEEEST7BBusinessDelegate delegate = ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted ExcIEEEST7B with key " + command.getExcIEEEST7BId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Kh on ExcIEEEST7B
   *
   * @param command AssignKhToExcIEEEST7BCommand
   */
  @PutMapping("/assignKh")
  public void assignKh(@RequestBody AssignKhToExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().assignKh(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kh", exc);
    }
  }

  /**
   * unassign Kh on ExcIEEEST7B
   *
   * @param command UnAssignKhFromExcIEEEST7BCommand
   */
  @PutMapping("/unAssignKh")
  public void unAssignKh(@RequestBody(required = true) UnAssignKhFromExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().unAssignKh(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kh", exc);
    }
  }

  /**
   * save Kia on ExcIEEEST7B
   *
   * @param command AssignKiaToExcIEEEST7BCommand
   */
  @PutMapping("/assignKia")
  public void assignKia(@RequestBody AssignKiaToExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().assignKia(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kia", exc);
    }
  }

  /**
   * unassign Kia on ExcIEEEST7B
   *
   * @param command UnAssignKiaFromExcIEEEST7BCommand
   */
  @PutMapping("/unAssignKia")
  public void unAssignKia(@RequestBody(required = true) UnAssignKiaFromExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().unAssignKia(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kia", exc);
    }
  }

  /**
   * save Kl on ExcIEEEST7B
   *
   * @param command AssignKlToExcIEEEST7BCommand
   */
  @PutMapping("/assignKl")
  public void assignKl(@RequestBody AssignKlToExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().assignKl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kl", exc);
    }
  }

  /**
   * unassign Kl on ExcIEEEST7B
   *
   * @param command UnAssignKlFromExcIEEEST7BCommand
   */
  @PutMapping("/unAssignKl")
  public void unAssignKl(@RequestBody(required = true) UnAssignKlFromExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().unAssignKl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kl", exc);
    }
  }

  /**
   * save Kpa on ExcIEEEST7B
   *
   * @param command AssignKpaToExcIEEEST7BCommand
   */
  @PutMapping("/assignKpa")
  public void assignKpa(@RequestBody AssignKpaToExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().assignKpa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpa", exc);
    }
  }

  /**
   * unassign Kpa on ExcIEEEST7B
   *
   * @param command UnAssignKpaFromExcIEEEST7BCommand
   */
  @PutMapping("/unAssignKpa")
  public void unAssignKpa(@RequestBody(required = true) UnAssignKpaFromExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().unAssignKpa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpa", exc);
    }
  }

  /**
   * save Tb on ExcIEEEST7B
   *
   * @param command AssignTbToExcIEEEST7BCommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcIEEEST7B
   *
   * @param command UnAssignTbFromExcIEEEST7BCommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcIEEEST7B
   *
   * @param command AssignTcToExcIEEEST7BCommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcIEEEST7B
   *
   * @param command UnAssignTcFromExcIEEEST7BCommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Tf on ExcIEEEST7B
   *
   * @param command AssignTfToExcIEEEST7BCommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcIEEEST7B
   *
   * @param command UnAssignTfFromExcIEEEST7BCommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Tg on ExcIEEEST7B
   *
   * @param command AssignTgToExcIEEEST7BCommand
   */
  @PutMapping("/assignTg")
  public void assignTg(@RequestBody AssignTgToExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().assignTg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tg", exc);
    }
  }

  /**
   * unassign Tg on ExcIEEEST7B
   *
   * @param command UnAssignTgFromExcIEEEST7BCommand
   */
  @PutMapping("/unAssignTg")
  public void unAssignTg(@RequestBody(required = true) UnAssignTgFromExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().unAssignTg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tg", exc);
    }
  }

  /**
   * save Tia on ExcIEEEST7B
   *
   * @param command AssignTiaToExcIEEEST7BCommand
   */
  @PutMapping("/assignTia")
  public void assignTia(@RequestBody AssignTiaToExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().assignTia(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tia", exc);
    }
  }

  /**
   * unassign Tia on ExcIEEEST7B
   *
   * @param command UnAssignTiaFromExcIEEEST7BCommand
   */
  @PutMapping("/unAssignTia")
  public void unAssignTia(@RequestBody(required = true) UnAssignTiaFromExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().unAssignTia(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tia", exc);
    }
  }

  /**
   * save Vmax on ExcIEEEST7B
   *
   * @param command AssignVmaxToExcIEEEST7BCommand
   */
  @PutMapping("/assignVmax")
  public void assignVmax(@RequestBody AssignVmaxToExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().assignVmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmax", exc);
    }
  }

  /**
   * unassign Vmax on ExcIEEEST7B
   *
   * @param command UnAssignVmaxFromExcIEEEST7BCommand
   */
  @PutMapping("/unAssignVmax")
  public void unAssignVmax(
      @RequestBody(required = true) UnAssignVmaxFromExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().unAssignVmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmax", exc);
    }
  }

  /**
   * save Vmin on ExcIEEEST7B
   *
   * @param command AssignVminToExcIEEEST7BCommand
   */
  @PutMapping("/assignVmin")
  public void assignVmin(@RequestBody AssignVminToExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().assignVmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmin", exc);
    }
  }

  /**
   * unassign Vmin on ExcIEEEST7B
   *
   * @param command UnAssignVminFromExcIEEEST7BCommand
   */
  @PutMapping("/unAssignVmin")
  public void unAssignVmin(
      @RequestBody(required = true) UnAssignVminFromExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().unAssignVmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmin", exc);
    }
  }

  /**
   * save Vrmax on ExcIEEEST7B
   *
   * @param command AssignVrmaxToExcIEEEST7BCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcIEEEST7B
   *
   * @param command UnAssignVrmaxFromExcIEEEST7BCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(
      @RequestBody(required = true) UnAssignVrmaxFromExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcIEEEST7B
   *
   * @param command AssignVrminToExcIEEEST7BCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcIEEEST7B
   *
   * @param command UnAssignVrminFromExcIEEEST7BCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(
      @RequestBody(required = true) UnAssignVrminFromExcIEEEST7BCommand command) {
    try {
      ExcIEEEST7BBusinessDelegate.getExcIEEEST7BInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcIEEEST7B excIEEEST7B = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcIEEEST7BCommandRestController.class.getName());
}
