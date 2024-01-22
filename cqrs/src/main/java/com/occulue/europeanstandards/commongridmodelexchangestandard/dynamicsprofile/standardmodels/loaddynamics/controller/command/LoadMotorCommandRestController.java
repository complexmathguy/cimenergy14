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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity LoadMotor.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadMotor")
public class LoadMotorCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a LoadMotor. if not key provided, calls create, otherwise calls save
   *
   * @param LoadMotor loadMotor
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateLoadMotorCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = LoadMotorBusinessDelegate.getLoadMotorInstance().createLoadMotor(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a LoadMotor. if no key provided, calls create, otherwise calls save
   *
   * @param LoadMotor loadMotor
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateLoadMotorCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateLoadMotorCommand
      // -----------------------------------------------
      completableFuture = LoadMotorBusinessDelegate.getLoadMotorInstance().updateLoadMotor(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "LoadMotorController:update() - successfully update LoadMotor - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a LoadMotor entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID loadMotorId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteLoadMotorCommand command = new DeleteLoadMotorCommand(loadMotorId);

    try {
      LoadMotorBusinessDelegate delegate = LoadMotorBusinessDelegate.getLoadMotorInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted LoadMotor with key " + command.getLoadMotorId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save D on LoadMotor
   *
   * @param command AssignDToLoadMotorCommand
   */
  @PutMapping("/assignD")
  public void assignD(@RequestBody AssignDToLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().assignD(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign D", exc);
    }
  }

  /**
   * unassign D on LoadMotor
   *
   * @param command UnAssignDFromLoadMotorCommand
   */
  @PutMapping("/unAssignD")
  public void unAssignD(@RequestBody(required = true) UnAssignDFromLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().unAssignD(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign D", exc);
    }
  }

  /**
   * save H on LoadMotor
   *
   * @param command AssignHToLoadMotorCommand
   */
  @PutMapping("/assignH")
  public void assignH(@RequestBody AssignHToLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().assignH(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign H", exc);
    }
  }

  /**
   * unassign H on LoadMotor
   *
   * @param command UnAssignHFromLoadMotorCommand
   */
  @PutMapping("/unAssignH")
  public void unAssignH(@RequestBody(required = true) UnAssignHFromLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().unAssignH(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign H", exc);
    }
  }

  /**
   * save Lfac on LoadMotor
   *
   * @param command AssignLfacToLoadMotorCommand
   */
  @PutMapping("/assignLfac")
  public void assignLfac(@RequestBody AssignLfacToLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().assignLfac(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Lfac", exc);
    }
  }

  /**
   * unassign Lfac on LoadMotor
   *
   * @param command UnAssignLfacFromLoadMotorCommand
   */
  @PutMapping("/unAssignLfac")
  public void unAssignLfac(@RequestBody(required = true) UnAssignLfacFromLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().unAssignLfac(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Lfac", exc);
    }
  }

  /**
   * save Lp on LoadMotor
   *
   * @param command AssignLpToLoadMotorCommand
   */
  @PutMapping("/assignLp")
  public void assignLp(@RequestBody AssignLpToLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().assignLp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Lp", exc);
    }
  }

  /**
   * unassign Lp on LoadMotor
   *
   * @param command UnAssignLpFromLoadMotorCommand
   */
  @PutMapping("/unAssignLp")
  public void unAssignLp(@RequestBody(required = true) UnAssignLpFromLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().unAssignLp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Lp", exc);
    }
  }

  /**
   * save Lpp on LoadMotor
   *
   * @param command AssignLppToLoadMotorCommand
   */
  @PutMapping("/assignLpp")
  public void assignLpp(@RequestBody AssignLppToLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().assignLpp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Lpp", exc);
    }
  }

  /**
   * unassign Lpp on LoadMotor
   *
   * @param command UnAssignLppFromLoadMotorCommand
   */
  @PutMapping("/unAssignLpp")
  public void unAssignLpp(@RequestBody(required = true) UnAssignLppFromLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().unAssignLpp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Lpp", exc);
    }
  }

  /**
   * save Ls on LoadMotor
   *
   * @param command AssignLsToLoadMotorCommand
   */
  @PutMapping("/assignLs")
  public void assignLs(@RequestBody AssignLsToLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().assignLs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ls", exc);
    }
  }

  /**
   * unassign Ls on LoadMotor
   *
   * @param command UnAssignLsFromLoadMotorCommand
   */
  @PutMapping("/unAssignLs")
  public void unAssignLs(@RequestBody(required = true) UnAssignLsFromLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().unAssignLs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ls", exc);
    }
  }

  /**
   * save Pfrac on LoadMotor
   *
   * @param command AssignPfracToLoadMotorCommand
   */
  @PutMapping("/assignPfrac")
  public void assignPfrac(@RequestBody AssignPfracToLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().assignPfrac(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pfrac", exc);
    }
  }

  /**
   * unassign Pfrac on LoadMotor
   *
   * @param command UnAssignPfracFromLoadMotorCommand
   */
  @PutMapping("/unAssignPfrac")
  public void unAssignPfrac(
      @RequestBody(required = true) UnAssignPfracFromLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().unAssignPfrac(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pfrac", exc);
    }
  }

  /**
   * save Ra on LoadMotor
   *
   * @param command AssignRaToLoadMotorCommand
   */
  @PutMapping("/assignRa")
  public void assignRa(@RequestBody AssignRaToLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().assignRa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ra", exc);
    }
  }

  /**
   * unassign Ra on LoadMotor
   *
   * @param command UnAssignRaFromLoadMotorCommand
   */
  @PutMapping("/unAssignRa")
  public void unAssignRa(@RequestBody(required = true) UnAssignRaFromLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().unAssignRa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ra", exc);
    }
  }

  /**
   * save Tbkr on LoadMotor
   *
   * @param command AssignTbkrToLoadMotorCommand
   */
  @PutMapping("/assignTbkr")
  public void assignTbkr(@RequestBody AssignTbkrToLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().assignTbkr(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tbkr", exc);
    }
  }

  /**
   * unassign Tbkr on LoadMotor
   *
   * @param command UnAssignTbkrFromLoadMotorCommand
   */
  @PutMapping("/unAssignTbkr")
  public void unAssignTbkr(@RequestBody(required = true) UnAssignTbkrFromLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().unAssignTbkr(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tbkr", exc);
    }
  }

  /**
   * save Tpo on LoadMotor
   *
   * @param command AssignTpoToLoadMotorCommand
   */
  @PutMapping("/assignTpo")
  public void assignTpo(@RequestBody AssignTpoToLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().assignTpo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpo", exc);
    }
  }

  /**
   * unassign Tpo on LoadMotor
   *
   * @param command UnAssignTpoFromLoadMotorCommand
   */
  @PutMapping("/unAssignTpo")
  public void unAssignTpo(@RequestBody(required = true) UnAssignTpoFromLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().unAssignTpo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpo", exc);
    }
  }

  /**
   * save Tppo on LoadMotor
   *
   * @param command AssignTppoToLoadMotorCommand
   */
  @PutMapping("/assignTppo")
  public void assignTppo(@RequestBody AssignTppoToLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().assignTppo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tppo", exc);
    }
  }

  /**
   * unassign Tppo on LoadMotor
   *
   * @param command UnAssignTppoFromLoadMotorCommand
   */
  @PutMapping("/unAssignTppo")
  public void unAssignTppo(@RequestBody(required = true) UnAssignTppoFromLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().unAssignTppo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tppo", exc);
    }
  }

  /**
   * save Tv on LoadMotor
   *
   * @param command AssignTvToLoadMotorCommand
   */
  @PutMapping("/assignTv")
  public void assignTv(@RequestBody AssignTvToLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().assignTv(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tv", exc);
    }
  }

  /**
   * unassign Tv on LoadMotor
   *
   * @param command UnAssignTvFromLoadMotorCommand
   */
  @PutMapping("/unAssignTv")
  public void unAssignTv(@RequestBody(required = true) UnAssignTvFromLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().unAssignTv(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tv", exc);
    }
  }

  /**
   * save Vt on LoadMotor
   *
   * @param command AssignVtToLoadMotorCommand
   */
  @PutMapping("/assignVt")
  public void assignVt(@RequestBody AssignVtToLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().assignVt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vt", exc);
    }
  }

  /**
   * unassign Vt on LoadMotor
   *
   * @param command UnAssignVtFromLoadMotorCommand
   */
  @PutMapping("/unAssignVt")
  public void unAssignVt(@RequestBody(required = true) UnAssignVtFromLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().unAssignVt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vt", exc);
    }
  }

  /**
   * save LoadMotor on LoadMotor
   *
   * @param command AssignLoadMotorToLoadMotorCommand
   */
  @PutMapping("/assignLoadMotor")
  public void assignLoadMotor(@RequestBody AssignLoadMotorToLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().assignLoadMotor(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign LoadMotor", exc);
    }
  }

  /**
   * unassign LoadMotor on LoadMotor
   *
   * @param command UnAssignLoadMotorFromLoadMotorCommand
   */
  @PutMapping("/unAssignLoadMotor")
  public void unAssignLoadMotor(
      @RequestBody(required = true) UnAssignLoadMotorFromLoadMotorCommand command) {
    try {
      LoadMotorBusinessDelegate.getLoadMotorInstance().unAssignLoadMotor(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign LoadMotor", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected LoadMotor loadMotor = null;
  private static final Logger LOGGER =
      Logger.getLogger(LoadMotorCommandRestController.class.getName());
}
