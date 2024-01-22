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
 * Implements Spring Controller command CQRS processing for entity GovSteamFV3.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamFV3")
public class GovSteamFV3CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovSteamFV3. if not key provided, calls create, otherwise calls save
   *
   * @param GovSteamFV3 govSteamFV3
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovSteamFV3Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().createGovSteamFV3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovSteamFV3. if no key provided, calls create, otherwise calls save
   *
   * @param GovSteamFV3 govSteamFV3
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovSteamFV3Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovSteamFV3Command
      // -----------------------------------------------
      completableFuture =
          GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().updateGovSteamFV3(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovSteamFV3Controller:update() - successfully update GovSteamFV3 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovSteamFV3 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govSteamFV3Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovSteamFV3Command command = new DeleteGovSteamFV3Command(govSteamFV3Id);

    try {
      GovSteamFV3BusinessDelegate delegate = GovSteamFV3BusinessDelegate.getGovSteamFV3Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovSteamFV3 with key " + command.getGovSteamFV3Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save K on GovSteamFV3
   *
   * @param command AssignKToGovSteamFV3Command
   */
  @PutMapping("/assignK")
  public void assignK(@RequestBody AssignKToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K", exc);
    }
  }

  /**
   * unassign K on GovSteamFV3
   *
   * @param command UnAssignKFromGovSteamFV3Command
   */
  @PutMapping("/unAssignK")
  public void unAssignK(@RequestBody(required = true) UnAssignKFromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignK(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K", exc);
    }
  }

  /**
   * save K1 on GovSteamFV3
   *
   * @param command AssignK1ToGovSteamFV3Command
   */
  @PutMapping("/assignK1")
  public void assignK1(@RequestBody AssignK1ToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignK1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1", exc);
    }
  }

  /**
   * unassign K1 on GovSteamFV3
   *
   * @param command UnAssignK1FromGovSteamFV3Command
   */
  @PutMapping("/unAssignK1")
  public void unAssignK1(@RequestBody(required = true) UnAssignK1FromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignK1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1", exc);
    }
  }

  /**
   * save K2 on GovSteamFV3
   *
   * @param command AssignK2ToGovSteamFV3Command
   */
  @PutMapping("/assignK2")
  public void assignK2(@RequestBody AssignK2ToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignK2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K2", exc);
    }
  }

  /**
   * unassign K2 on GovSteamFV3
   *
   * @param command UnAssignK2FromGovSteamFV3Command
   */
  @PutMapping("/unAssignK2")
  public void unAssignK2(@RequestBody(required = true) UnAssignK2FromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignK2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K2", exc);
    }
  }

  /**
   * save K3 on GovSteamFV3
   *
   * @param command AssignK3ToGovSteamFV3Command
   */
  @PutMapping("/assignK3")
  public void assignK3(@RequestBody AssignK3ToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignK3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K3", exc);
    }
  }

  /**
   * unassign K3 on GovSteamFV3
   *
   * @param command UnAssignK3FromGovSteamFV3Command
   */
  @PutMapping("/unAssignK3")
  public void unAssignK3(@RequestBody(required = true) UnAssignK3FromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignK3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K3", exc);
    }
  }

  /**
   * save Mwbase on GovSteamFV3
   *
   * @param command AssignMwbaseToGovSteamFV3Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovSteamFV3
   *
   * @param command UnAssignMwbaseFromGovSteamFV3Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pmax on GovSteamFV3
   *
   * @param command AssignPmaxToGovSteamFV3Command
   */
  @PutMapping("/assignPmax")
  public void assignPmax(@RequestBody AssignPmaxToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignPmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmax", exc);
    }
  }

  /**
   * unassign Pmax on GovSteamFV3
   *
   * @param command UnAssignPmaxFromGovSteamFV3Command
   */
  @PutMapping("/unAssignPmax")
  public void unAssignPmax(
      @RequestBody(required = true) UnAssignPmaxFromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignPmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmax", exc);
    }
  }

  /**
   * save Pmin on GovSteamFV3
   *
   * @param command AssignPminToGovSteamFV3Command
   */
  @PutMapping("/assignPmin")
  public void assignPmin(@RequestBody AssignPminToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignPmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmin", exc);
    }
  }

  /**
   * unassign Pmin on GovSteamFV3
   *
   * @param command UnAssignPminFromGovSteamFV3Command
   */
  @PutMapping("/unAssignPmin")
  public void unAssignPmin(
      @RequestBody(required = true) UnAssignPminFromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignPmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmin", exc);
    }
  }

  /**
   * save Prmax on GovSteamFV3
   *
   * @param command AssignPrmaxToGovSteamFV3Command
   */
  @PutMapping("/assignPrmax")
  public void assignPrmax(@RequestBody AssignPrmaxToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignPrmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Prmax", exc);
    }
  }

  /**
   * unassign Prmax on GovSteamFV3
   *
   * @param command UnAssignPrmaxFromGovSteamFV3Command
   */
  @PutMapping("/unAssignPrmax")
  public void unAssignPrmax(
      @RequestBody(required = true) UnAssignPrmaxFromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignPrmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Prmax", exc);
    }
  }

  /**
   * save T1 on GovSteamFV3
   *
   * @param command AssignT1ToGovSteamFV3Command
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on GovSteamFV3
   *
   * @param command UnAssignT1FromGovSteamFV3Command
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on GovSteamFV3
   *
   * @param command AssignT2ToGovSteamFV3Command
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on GovSteamFV3
   *
   * @param command UnAssignT2FromGovSteamFV3Command
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on GovSteamFV3
   *
   * @param command AssignT3ToGovSteamFV3Command
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on GovSteamFV3
   *
   * @param command UnAssignT3FromGovSteamFV3Command
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on GovSteamFV3
   *
   * @param command AssignT4ToGovSteamFV3Command
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on GovSteamFV3
   *
   * @param command UnAssignT4FromGovSteamFV3Command
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on GovSteamFV3
   *
   * @param command AssignT5ToGovSteamFV3Command
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on GovSteamFV3
   *
   * @param command UnAssignT5FromGovSteamFV3Command
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save T6 on GovSteamFV3
   *
   * @param command AssignT6ToGovSteamFV3Command
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on GovSteamFV3
   *
   * @param command UnAssignT6FromGovSteamFV3Command
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  /**
   * save Ta on GovSteamFV3
   *
   * @param command AssignTaToGovSteamFV3Command
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on GovSteamFV3
   *
   * @param command UnAssignTaFromGovSteamFV3Command
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on GovSteamFV3
   *
   * @param command AssignTbToGovSteamFV3Command
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on GovSteamFV3
   *
   * @param command UnAssignTbFromGovSteamFV3Command
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on GovSteamFV3
   *
   * @param command AssignTcToGovSteamFV3Command
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on GovSteamFV3
   *
   * @param command UnAssignTcFromGovSteamFV3Command
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Uc on GovSteamFV3
   *
   * @param command AssignUcToGovSteamFV3Command
   */
  @PutMapping("/assignUc")
  public void assignUc(@RequestBody AssignUcToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignUc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uc", exc);
    }
  }

  /**
   * unassign Uc on GovSteamFV3
   *
   * @param command UnAssignUcFromGovSteamFV3Command
   */
  @PutMapping("/unAssignUc")
  public void unAssignUc(@RequestBody(required = true) UnAssignUcFromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignUc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uc", exc);
    }
  }

  /**
   * save Uo on GovSteamFV3
   *
   * @param command AssignUoToGovSteamFV3Command
   */
  @PutMapping("/assignUo")
  public void assignUo(@RequestBody AssignUoToGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().assignUo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uo", exc);
    }
  }

  /**
   * unassign Uo on GovSteamFV3
   *
   * @param command UnAssignUoFromGovSteamFV3Command
   */
  @PutMapping("/unAssignUo")
  public void unAssignUo(@RequestBody(required = true) UnAssignUoFromGovSteamFV3Command command) {
    try {
      GovSteamFV3BusinessDelegate.getGovSteamFV3Instance().unAssignUo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uo", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovSteamFV3 govSteamFV3 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovSteamFV3CommandRestController.class.getName());
}
