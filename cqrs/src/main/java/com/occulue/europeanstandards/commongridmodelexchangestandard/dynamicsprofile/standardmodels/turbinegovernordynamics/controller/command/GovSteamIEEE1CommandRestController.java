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
 * Implements Spring Controller command CQRS processing for entity GovSteamIEEE1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamIEEE1")
public class GovSteamIEEE1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovSteamIEEE1. if not key provided, calls create, otherwise calls save
   *
   * @param GovSteamIEEE1 govSteamIEEE1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovSteamIEEE1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().createGovSteamIEEE1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovSteamIEEE1. if no key provided, calls create, otherwise calls save
   *
   * @param GovSteamIEEE1 govSteamIEEE1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovSteamIEEE1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovSteamIEEE1Command
      // -----------------------------------------------
      completableFuture =
          GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().updateGovSteamIEEE1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovSteamIEEE1Controller:update() - successfully update GovSteamIEEE1 - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovSteamIEEE1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govSteamIEEE1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovSteamIEEE1Command command = new DeleteGovSteamIEEE1Command(govSteamIEEE1Id);

    try {
      GovSteamIEEE1BusinessDelegate delegate =
          GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted GovSteamIEEE1 with key " + command.getGovSteamIEEE1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save K on GovSteamIEEE1
   *
   * @param command AssignKToGovSteamIEEE1Command
   */
  @PutMapping("/assignK")
  public void assignK(@RequestBody AssignKToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K", exc);
    }
  }

  /**
   * unassign K on GovSteamIEEE1
   *
   * @param command UnAssignKFromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignK")
  public void unAssignK(@RequestBody(required = true) UnAssignKFromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignK(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K", exc);
    }
  }

  /**
   * save K1 on GovSteamIEEE1
   *
   * @param command AssignK1ToGovSteamIEEE1Command
   */
  @PutMapping("/assignK1")
  public void assignK1(@RequestBody AssignK1ToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignK1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1", exc);
    }
  }

  /**
   * unassign K1 on GovSteamIEEE1
   *
   * @param command UnAssignK1FromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignK1")
  public void unAssignK1(@RequestBody(required = true) UnAssignK1FromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignK1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1", exc);
    }
  }

  /**
   * save K2 on GovSteamIEEE1
   *
   * @param command AssignK2ToGovSteamIEEE1Command
   */
  @PutMapping("/assignK2")
  public void assignK2(@RequestBody AssignK2ToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignK2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K2", exc);
    }
  }

  /**
   * unassign K2 on GovSteamIEEE1
   *
   * @param command UnAssignK2FromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignK2")
  public void unAssignK2(@RequestBody(required = true) UnAssignK2FromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignK2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K2", exc);
    }
  }

  /**
   * save K3 on GovSteamIEEE1
   *
   * @param command AssignK3ToGovSteamIEEE1Command
   */
  @PutMapping("/assignK3")
  public void assignK3(@RequestBody AssignK3ToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignK3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K3", exc);
    }
  }

  /**
   * unassign K3 on GovSteamIEEE1
   *
   * @param command UnAssignK3FromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignK3")
  public void unAssignK3(@RequestBody(required = true) UnAssignK3FromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignK3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K3", exc);
    }
  }

  /**
   * save K4 on GovSteamIEEE1
   *
   * @param command AssignK4ToGovSteamIEEE1Command
   */
  @PutMapping("/assignK4")
  public void assignK4(@RequestBody AssignK4ToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignK4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K4", exc);
    }
  }

  /**
   * unassign K4 on GovSteamIEEE1
   *
   * @param command UnAssignK4FromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignK4")
  public void unAssignK4(@RequestBody(required = true) UnAssignK4FromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignK4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K4", exc);
    }
  }

  /**
   * save K5 on GovSteamIEEE1
   *
   * @param command AssignK5ToGovSteamIEEE1Command
   */
  @PutMapping("/assignK5")
  public void assignK5(@RequestBody AssignK5ToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignK5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K5", exc);
    }
  }

  /**
   * unassign K5 on GovSteamIEEE1
   *
   * @param command UnAssignK5FromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignK5")
  public void unAssignK5(@RequestBody(required = true) UnAssignK5FromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignK5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K5", exc);
    }
  }

  /**
   * save K6 on GovSteamIEEE1
   *
   * @param command AssignK6ToGovSteamIEEE1Command
   */
  @PutMapping("/assignK6")
  public void assignK6(@RequestBody AssignK6ToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignK6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K6", exc);
    }
  }

  /**
   * unassign K6 on GovSteamIEEE1
   *
   * @param command UnAssignK6FromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignK6")
  public void unAssignK6(@RequestBody(required = true) UnAssignK6FromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignK6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K6", exc);
    }
  }

  /**
   * save K7 on GovSteamIEEE1
   *
   * @param command AssignK7ToGovSteamIEEE1Command
   */
  @PutMapping("/assignK7")
  public void assignK7(@RequestBody AssignK7ToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignK7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K7", exc);
    }
  }

  /**
   * unassign K7 on GovSteamIEEE1
   *
   * @param command UnAssignK7FromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignK7")
  public void unAssignK7(@RequestBody(required = true) UnAssignK7FromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignK7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K7", exc);
    }
  }

  /**
   * save K8 on GovSteamIEEE1
   *
   * @param command AssignK8ToGovSteamIEEE1Command
   */
  @PutMapping("/assignK8")
  public void assignK8(@RequestBody AssignK8ToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignK8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K8", exc);
    }
  }

  /**
   * unassign K8 on GovSteamIEEE1
   *
   * @param command UnAssignK8FromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignK8")
  public void unAssignK8(@RequestBody(required = true) UnAssignK8FromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignK8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K8", exc);
    }
  }

  /**
   * save Mwbase on GovSteamIEEE1
   *
   * @param command AssignMwbaseToGovSteamIEEE1Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovSteamIEEE1
   *
   * @param command UnAssignMwbaseFromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pmax on GovSteamIEEE1
   *
   * @param command AssignPmaxToGovSteamIEEE1Command
   */
  @PutMapping("/assignPmax")
  public void assignPmax(@RequestBody AssignPmaxToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignPmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmax", exc);
    }
  }

  /**
   * unassign Pmax on GovSteamIEEE1
   *
   * @param command UnAssignPmaxFromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignPmax")
  public void unAssignPmax(
      @RequestBody(required = true) UnAssignPmaxFromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignPmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmax", exc);
    }
  }

  /**
   * save Pmin on GovSteamIEEE1
   *
   * @param command AssignPminToGovSteamIEEE1Command
   */
  @PutMapping("/assignPmin")
  public void assignPmin(@RequestBody AssignPminToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignPmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmin", exc);
    }
  }

  /**
   * unassign Pmin on GovSteamIEEE1
   *
   * @param command UnAssignPminFromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignPmin")
  public void unAssignPmin(
      @RequestBody(required = true) UnAssignPminFromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignPmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmin", exc);
    }
  }

  /**
   * save T1 on GovSteamIEEE1
   *
   * @param command AssignT1ToGovSteamIEEE1Command
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on GovSteamIEEE1
   *
   * @param command UnAssignT1FromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T2 on GovSteamIEEE1
   *
   * @param command AssignT2ToGovSteamIEEE1Command
   */
  @PutMapping("/assignT2")
  public void assignT2(@RequestBody AssignT2ToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignT2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T2", exc);
    }
  }

  /**
   * unassign T2 on GovSteamIEEE1
   *
   * @param command UnAssignT2FromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignT2")
  public void unAssignT2(@RequestBody(required = true) UnAssignT2FromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignT2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T2", exc);
    }
  }

  /**
   * save T3 on GovSteamIEEE1
   *
   * @param command AssignT3ToGovSteamIEEE1Command
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on GovSteamIEEE1
   *
   * @param command UnAssignT3FromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save T4 on GovSteamIEEE1
   *
   * @param command AssignT4ToGovSteamIEEE1Command
   */
  @PutMapping("/assignT4")
  public void assignT4(@RequestBody AssignT4ToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignT4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T4", exc);
    }
  }

  /**
   * unassign T4 on GovSteamIEEE1
   *
   * @param command UnAssignT4FromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignT4")
  public void unAssignT4(@RequestBody(required = true) UnAssignT4FromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignT4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T4", exc);
    }
  }

  /**
   * save T5 on GovSteamIEEE1
   *
   * @param command AssignT5ToGovSteamIEEE1Command
   */
  @PutMapping("/assignT5")
  public void assignT5(@RequestBody AssignT5ToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignT5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T5", exc);
    }
  }

  /**
   * unassign T5 on GovSteamIEEE1
   *
   * @param command UnAssignT5FromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignT5")
  public void unAssignT5(@RequestBody(required = true) UnAssignT5FromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignT5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T5", exc);
    }
  }

  /**
   * save T6 on GovSteamIEEE1
   *
   * @param command AssignT6ToGovSteamIEEE1Command
   */
  @PutMapping("/assignT6")
  public void assignT6(@RequestBody AssignT6ToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignT6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T6", exc);
    }
  }

  /**
   * unassign T6 on GovSteamIEEE1
   *
   * @param command UnAssignT6FromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignT6")
  public void unAssignT6(@RequestBody(required = true) UnAssignT6FromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignT6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T6", exc);
    }
  }

  /**
   * save T7 on GovSteamIEEE1
   *
   * @param command AssignT7ToGovSteamIEEE1Command
   */
  @PutMapping("/assignT7")
  public void assignT7(@RequestBody AssignT7ToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignT7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T7", exc);
    }
  }

  /**
   * unassign T7 on GovSteamIEEE1
   *
   * @param command UnAssignT7FromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignT7")
  public void unAssignT7(@RequestBody(required = true) UnAssignT7FromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignT7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T7", exc);
    }
  }

  /**
   * save Uc on GovSteamIEEE1
   *
   * @param command AssignUcToGovSteamIEEE1Command
   */
  @PutMapping("/assignUc")
  public void assignUc(@RequestBody AssignUcToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignUc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uc", exc);
    }
  }

  /**
   * unassign Uc on GovSteamIEEE1
   *
   * @param command UnAssignUcFromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignUc")
  public void unAssignUc(@RequestBody(required = true) UnAssignUcFromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignUc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uc", exc);
    }
  }

  /**
   * save Uo on GovSteamIEEE1
   *
   * @param command AssignUoToGovSteamIEEE1Command
   */
  @PutMapping("/assignUo")
  public void assignUo(@RequestBody AssignUoToGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().assignUo(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Uo", exc);
    }
  }

  /**
   * unassign Uo on GovSteamIEEE1
   *
   * @param command UnAssignUoFromGovSteamIEEE1Command
   */
  @PutMapping("/unAssignUo")
  public void unAssignUo(@RequestBody(required = true) UnAssignUoFromGovSteamIEEE1Command command) {
    try {
      GovSteamIEEE1BusinessDelegate.getGovSteamIEEE1Instance().unAssignUo(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Uo", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovSteamIEEE1 govSteamIEEE1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovSteamIEEE1CommandRestController.class.getName());
}
