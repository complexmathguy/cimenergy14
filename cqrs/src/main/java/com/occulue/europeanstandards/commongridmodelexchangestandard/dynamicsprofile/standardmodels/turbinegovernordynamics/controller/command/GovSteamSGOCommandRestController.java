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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity GovSteamSGO.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamSGO")
public class GovSteamSGOCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovSteamSGO. if not key provided, calls create, otherwise calls save
   *
   * @param GovSteamSGO govSteamSGO
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovSteamSGOCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().createGovSteamSGO(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovSteamSGO. if no key provided, calls create, otherwise calls save
   *
   * @param GovSteamSGO govSteamSGO
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovSteamSGOCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovSteamSGOCommand
      // -----------------------------------------------
      completableFuture =
          GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().updateGovSteamSGO(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovSteamSGOController:update() - successfully update GovSteamSGO - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovSteamSGO entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govSteamSGOId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovSteamSGOCommand command = new DeleteGovSteamSGOCommand(govSteamSGOId);

    try {
      GovSteamSGOBusinessDelegate delegate = GovSteamSGOBusinessDelegate.getGovSteamSGOInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovSteamSGO with key " + command.getGovSteamSGOId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save K1 on GovSteamSGO
   *
   * @param command AssignK1ToGovSteamSGOCommand
   */
  @PutMapping("/assignK1")
  public void assignK1(@RequestBody AssignK1ToGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().assignK1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1", exc);
    }
  }

  /**
   * unassign K1 on GovSteamSGO
   *
   * @param command UnAssignK1FromGovSteamSGOCommand
   */
  @PutMapping("/unAssignK1")
  public void unAssignK1(@RequestBody(required = true) UnAssignK1FromGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().unAssignK1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1", exc);
    }
  }

  /**
   * save K2 on GovSteamSGO
   *
   * @param command AssignK2ToGovSteamSGOCommand
   */
  @PutMapping("/assignK2")
  public void assignK2(@RequestBody AssignK2ToGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().assignK2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K2", exc);
    }
  }

  /**
   * unassign K2 on GovSteamSGO
   *
   * @param command UnAssignK2FromGovSteamSGOCommand
   */
  @PutMapping("/unAssignK2")
  public void unAssignK2(@RequestBody(required = true) UnAssignK2FromGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().unAssignK2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K2", exc);
    }
  }

  /**
   * save K3 on GovSteamSGO
   *
   * @param command AssignK3ToGovSteamSGOCommand
   */
  @PutMapping("/assignK3")
  public void assignK3(@RequestBody AssignK3ToGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().assignK3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K3", exc);
    }
  }

  /**
   * unassign K3 on GovSteamSGO
   *
   * @param command UnAssignK3FromGovSteamSGOCommand
   */
  @PutMapping("/unAssignK3")
  public void unAssignK3(@RequestBody(required = true) UnAssignK3FromGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().unAssignK3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K3", exc);
    }
  }

  /**
   * save Mwbase on GovSteamSGO
   *
   * @param command AssignMwbaseToGovSteamSGOCommand
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovSteamSGO
   *
   * @param command UnAssignMwbaseFromGovSteamSGOCommand
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pmax on GovSteamSGO
   *
   * @param command AssignPmaxToGovSteamSGOCommand
   */
  @PutMapping("/assignPmax")
  public void assignPmax(@RequestBody AssignPmaxToGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().assignPmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmax", exc);
    }
  }

  /**
   * unassign Pmax on GovSteamSGO
   *
   * @param command UnAssignPmaxFromGovSteamSGOCommand
   */
  @PutMapping("/unAssignPmax")
  public void unAssignPmax(
      @RequestBody(required = true) UnAssignPmaxFromGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().unAssignPmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmax", exc);
    }
  }

  /**
   * save Pmin on GovSteamSGO
   *
   * @param command AssignPminToGovSteamSGOCommand
   */
  @PutMapping("/assignPmin")
  public void assignPmin(@RequestBody AssignPminToGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().assignPmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmin", exc);
    }
  }

  /**
   * unassign Pmin on GovSteamSGO
   *
   * @param command UnAssignPminFromGovSteamSGOCommand
   */
  @PutMapping("/unAssignPmin")
  public void unAssignPmin(
      @RequestBody(required = true) UnAssignPminFromGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().unAssignPmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmin", exc);
    }
  }

  /**
   * save T1 on GovSteamSGO
   *
   * @param command AssignT1ToGovSteamSGOCommand
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on GovSteamSGO
   *
   * @param command UnAssignT1FromGovSteamSGOCommand
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on GovSteamSGO
   *
   * @param command AssignT2ToGovSteamSGOCommand
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on GovSteamSGO
   *
   * @param command UnAssignT2FromGovSteamSGOCommand
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on GovSteamSGO
   *
   * @param command AssignT3ToGovSteamSGOCommand
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on GovSteamSGO
   *
   * @param command UnAssignT3FromGovSteamSGOCommand
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on GovSteamSGO
   *
   * @param command AssignT4ToGovSteamSGOCommand
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on GovSteamSGO
   *
   * @param command UnAssignT4FromGovSteamSGOCommand
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on GovSteamSGO
   *
   * @param command AssignT5ToGovSteamSGOCommand
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on GovSteamSGO
   *
   * @param command UnAssignT5FromGovSteamSGOCommand
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save T6 on GovSteamSGO
   *
   * @param command AssignT6ToGovSteamSGOCommand
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on GovSteamSGO
   *
   * @param command UnAssignT6FromGovSteamSGOCommand
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromGovSteamSGOCommand command) {
    try {
      GovSteamSGOBusinessDelegate.getGovSteamSGOInstance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovSteamSGO govSteamSGO = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovSteamSGOCommandRestController.class.getName());
}
