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
 * Implements Spring Controller command CQRS processing for entity ExcST7B.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/ExcST7B")
public class ExcST7BCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a ExcST7B. if not key provided, calls create, otherwise calls save
   *
   * @param ExcST7B excST7B
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateExcST7BCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ExcST7BBusinessDelegate.getExcST7BInstance().createExcST7B(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a ExcST7B. if no key provided, calls create, otherwise calls save
   *
   * @param ExcST7B excST7B
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateExcST7BCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateExcST7BCommand
      // -----------------------------------------------
      completableFuture = ExcST7BBusinessDelegate.getExcST7BInstance().updateExcST7B(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ExcST7BController:update() - successfully update ExcST7B - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a ExcST7B entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID excST7BId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteExcST7BCommand command = new DeleteExcST7BCommand(excST7BId);

    try {
      ExcST7BBusinessDelegate delegate = ExcST7BBusinessDelegate.getExcST7BInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted ExcST7B with key " + command.getExcST7BId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Kh on ExcST7B
   *
   * @param command AssignKhToExcST7BCommand
   */
  @PutMapping("/assignKh")
  public void assignKh(@RequestBody AssignKhToExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().assignKh(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kh", exc);
    }
  }

  /**
   * unassign Kh on ExcST7B
   *
   * @param command UnAssignKhFromExcST7BCommand
   */
  @PutMapping("/unAssignKh")
  public void unAssignKh(@RequestBody(required = true) UnAssignKhFromExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().unAssignKh(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kh", exc);
    }
  }

  /**
   * save Kia on ExcST7B
   *
   * @param command AssignKiaToExcST7BCommand
   */
  @PutMapping("/assignKia")
  public void assignKia(@RequestBody AssignKiaToExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().assignKia(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kia", exc);
    }
  }

  /**
   * unassign Kia on ExcST7B
   *
   * @param command UnAssignKiaFromExcST7BCommand
   */
  @PutMapping("/unAssignKia")
  public void unAssignKia(@RequestBody(required = true) UnAssignKiaFromExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().unAssignKia(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kia", exc);
    }
  }

  /**
   * save Kl on ExcST7B
   *
   * @param command AssignKlToExcST7BCommand
   */
  @PutMapping("/assignKl")
  public void assignKl(@RequestBody AssignKlToExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().assignKl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kl", exc);
    }
  }

  /**
   * unassign Kl on ExcST7B
   *
   * @param command UnAssignKlFromExcST7BCommand
   */
  @PutMapping("/unAssignKl")
  public void unAssignKl(@RequestBody(required = true) UnAssignKlFromExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().unAssignKl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kl", exc);
    }
  }

  /**
   * save Kpa on ExcST7B
   *
   * @param command AssignKpaToExcST7BCommand
   */
  @PutMapping("/assignKpa")
  public void assignKpa(@RequestBody AssignKpaToExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().assignKpa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpa", exc);
    }
  }

  /**
   * unassign Kpa on ExcST7B
   *
   * @param command UnAssignKpaFromExcST7BCommand
   */
  @PutMapping("/unAssignKpa")
  public void unAssignKpa(@RequestBody(required = true) UnAssignKpaFromExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().unAssignKpa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpa", exc);
    }
  }

  /**
   * save Tb on ExcST7B
   *
   * @param command AssignTbToExcST7BCommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on ExcST7B
   *
   * @param command UnAssignTbFromExcST7BCommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on ExcST7B
   *
   * @param command AssignTcToExcST7BCommand
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on ExcST7B
   *
   * @param command UnAssignTcFromExcST7BCommand
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Tf on ExcST7B
   *
   * @param command AssignTfToExcST7BCommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on ExcST7B
   *
   * @param command UnAssignTfFromExcST7BCommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Tg on ExcST7B
   *
   * @param command AssignTgToExcST7BCommand
   */
  @PutMapping("/assignTg")
  public void assignTg(@RequestBody AssignTgToExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().assignTg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tg", exc);
    }
  }

  /**
   * unassign Tg on ExcST7B
   *
   * @param command UnAssignTgFromExcST7BCommand
   */
  @PutMapping("/unAssignTg")
  public void unAssignTg(@RequestBody(required = true) UnAssignTgFromExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().unAssignTg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tg", exc);
    }
  }

  /**
   * save Tia on ExcST7B
   *
   * @param command AssignTiaToExcST7BCommand
   */
  @PutMapping("/assignTia")
  public void assignTia(@RequestBody AssignTiaToExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().assignTia(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tia", exc);
    }
  }

  /**
   * unassign Tia on ExcST7B
   *
   * @param command UnAssignTiaFromExcST7BCommand
   */
  @PutMapping("/unAssignTia")
  public void unAssignTia(@RequestBody(required = true) UnAssignTiaFromExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().unAssignTia(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tia", exc);
    }
  }

  /**
   * save Ts on ExcST7B
   *
   * @param command AssignTsToExcST7BCommand
   */
  @PutMapping("/assignTs")
  public void assignTs(@RequestBody AssignTsToExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().assignTs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ts", exc);
    }
  }

  /**
   * unassign Ts on ExcST7B
   *
   * @param command UnAssignTsFromExcST7BCommand
   */
  @PutMapping("/unAssignTs")
  public void unAssignTs(@RequestBody(required = true) UnAssignTsFromExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().unAssignTs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ts", exc);
    }
  }

  /**
   * save Vmax on ExcST7B
   *
   * @param command AssignVmaxToExcST7BCommand
   */
  @PutMapping("/assignVmax")
  public void assignVmax(@RequestBody AssignVmaxToExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().assignVmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmax", exc);
    }
  }

  /**
   * unassign Vmax on ExcST7B
   *
   * @param command UnAssignVmaxFromExcST7BCommand
   */
  @PutMapping("/unAssignVmax")
  public void unAssignVmax(@RequestBody(required = true) UnAssignVmaxFromExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().unAssignVmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmax", exc);
    }
  }

  /**
   * save Vmin on ExcST7B
   *
   * @param command AssignVminToExcST7BCommand
   */
  @PutMapping("/assignVmin")
  public void assignVmin(@RequestBody AssignVminToExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().assignVmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmin", exc);
    }
  }

  /**
   * unassign Vmin on ExcST7B
   *
   * @param command UnAssignVminFromExcST7BCommand
   */
  @PutMapping("/unAssignVmin")
  public void unAssignVmin(@RequestBody(required = true) UnAssignVminFromExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().unAssignVmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmin", exc);
    }
  }

  /**
   * save Vrmax on ExcST7B
   *
   * @param command AssignVrmaxToExcST7BCommand
   */
  @PutMapping("/assignVrmax")
  public void assignVrmax(@RequestBody AssignVrmaxToExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().assignVrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmax", exc);
    }
  }

  /**
   * unassign Vrmax on ExcST7B
   *
   * @param command UnAssignVrmaxFromExcST7BCommand
   */
  @PutMapping("/unAssignVrmax")
  public void unAssignVrmax(@RequestBody(required = true) UnAssignVrmaxFromExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().unAssignVrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmax", exc);
    }
  }

  /**
   * save Vrmin on ExcST7B
   *
   * @param command AssignVrminToExcST7BCommand
   */
  @PutMapping("/assignVrmin")
  public void assignVrmin(@RequestBody AssignVrminToExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().assignVrmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vrmin", exc);
    }
  }

  /**
   * unassign Vrmin on ExcST7B
   *
   * @param command UnAssignVrminFromExcST7BCommand
   */
  @PutMapping("/unAssignVrmin")
  public void unAssignVrmin(@RequestBody(required = true) UnAssignVrminFromExcST7BCommand command) {
    try {
      ExcST7BBusinessDelegate.getExcST7BInstance().unAssignVrmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vrmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected ExcST7B excST7B = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcST7BCommandRestController.class.getName());
}
