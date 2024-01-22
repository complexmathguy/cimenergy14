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
 * Implements Spring Controller command CQRS processing for entity GovSteamFV2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamFV2")
public class GovSteamFV2CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovSteamFV2. if not key provided, calls create, otherwise calls save
   *
   * @param GovSteamFV2 govSteamFV2
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovSteamFV2Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().createGovSteamFV2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovSteamFV2. if no key provided, calls create, otherwise calls save
   *
   * @param GovSteamFV2 govSteamFV2
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovSteamFV2Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovSteamFV2Command
      // -----------------------------------------------
      completableFuture =
          GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().updateGovSteamFV2(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovSteamFV2Controller:update() - successfully update GovSteamFV2 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovSteamFV2 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govSteamFV2Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovSteamFV2Command command = new DeleteGovSteamFV2Command(govSteamFV2Id);

    try {
      GovSteamFV2BusinessDelegate delegate = GovSteamFV2BusinessDelegate.getGovSteamFV2Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovSteamFV2 with key " + command.getGovSteamFV2Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Dt on GovSteamFV2
   *
   * @param command AssignDtToGovSteamFV2Command
   */
  @PutMapping("/assignDt")
  public void assignDt(@RequestBody AssignDtToGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().assignDt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dt", exc);
    }
  }

  /**
   * unassign Dt on GovSteamFV2
   *
   * @param command UnAssignDtFromGovSteamFV2Command
   */
  @PutMapping("/unAssignDt")
  public void unAssignDt(@RequestBody(required = true) UnAssignDtFromGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().unAssignDt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dt", exc);
    }
  }

  /**
   * save K on GovSteamFV2
   *
   * @param command AssignKToGovSteamFV2Command
   */
  @PutMapping("/assignK")
  public void assignK(@RequestBody AssignKToGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().assignK(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K", exc);
    }
  }

  /**
   * unassign K on GovSteamFV2
   *
   * @param command UnAssignKFromGovSteamFV2Command
   */
  @PutMapping("/unAssignK")
  public void unAssignK(@RequestBody(required = true) UnAssignKFromGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().unAssignK(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K", exc);
    }
  }

  /**
   * save Mwbase on GovSteamFV2
   *
   * @param command AssignMwbaseToGovSteamFV2Command
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovSteamFV2
   *
   * @param command UnAssignMwbaseFromGovSteamFV2Command
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save R on GovSteamFV2
   *
   * @param command AssignRToGovSteamFV2Command
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on GovSteamFV2
   *
   * @param command UnAssignRFromGovSteamFV2Command
   */
  @PutMapping("/unAssignR")
  public void unAssignR(@RequestBody(required = true) UnAssignRFromGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  /**
   * save T1 on GovSteamFV2
   *
   * @param command AssignT1ToGovSteamFV2Command
   */
  @PutMapping("/assignT1")
  public void assignT1(@RequestBody AssignT1ToGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().assignT1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T1", exc);
    }
  }

  /**
   * unassign T1 on GovSteamFV2
   *
   * @param command UnAssignT1FromGovSteamFV2Command
   */
  @PutMapping("/unAssignT1")
  public void unAssignT1(@RequestBody(required = true) UnAssignT1FromGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().unAssignT1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T1", exc);
    }
  }

  /**
   * save T3 on GovSteamFV2
   *
   * @param command AssignT3ToGovSteamFV2Command
   */
  @PutMapping("/assignT3")
  public void assignT3(@RequestBody AssignT3ToGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().assignT3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign T3", exc);
    }
  }

  /**
   * unassign T3 on GovSteamFV2
   *
   * @param command UnAssignT3FromGovSteamFV2Command
   */
  @PutMapping("/unAssignT3")
  public void unAssignT3(@RequestBody(required = true) UnAssignT3FromGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().unAssignT3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign T3", exc);
    }
  }

  /**
   * save Ta on GovSteamFV2
   *
   * @param command AssignTaToGovSteamFV2Command
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on GovSteamFV2
   *
   * @param command UnAssignTaFromGovSteamFV2Command
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tb on GovSteamFV2
   *
   * @param command AssignTbToGovSteamFV2Command
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on GovSteamFV2
   *
   * @param command UnAssignTbFromGovSteamFV2Command
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tc on GovSteamFV2
   *
   * @param command AssignTcToGovSteamFV2Command
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on GovSteamFV2
   *
   * @param command UnAssignTcFromGovSteamFV2Command
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Ti on GovSteamFV2
   *
   * @param command AssignTiToGovSteamFV2Command
   */
  @PutMapping("/assignTi")
  public void assignTi(@RequestBody AssignTiToGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().assignTi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ti", exc);
    }
  }

  /**
   * unassign Ti on GovSteamFV2
   *
   * @param command UnAssignTiFromGovSteamFV2Command
   */
  @PutMapping("/unAssignTi")
  public void unAssignTi(@RequestBody(required = true) UnAssignTiFromGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().unAssignTi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ti", exc);
    }
  }

  /**
   * save Tt on GovSteamFV2
   *
   * @param command AssignTtToGovSteamFV2Command
   */
  @PutMapping("/assignTt")
  public void assignTt(@RequestBody AssignTtToGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().assignTt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tt", exc);
    }
  }

  /**
   * unassign Tt on GovSteamFV2
   *
   * @param command UnAssignTtFromGovSteamFV2Command
   */
  @PutMapping("/unAssignTt")
  public void unAssignTt(@RequestBody(required = true) UnAssignTtFromGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().unAssignTt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tt", exc);
    }
  }

  /**
   * save Vmax on GovSteamFV2
   *
   * @param command AssignVmaxToGovSteamFV2Command
   */
  @PutMapping("/assignVmax")
  public void assignVmax(@RequestBody AssignVmaxToGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().assignVmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmax", exc);
    }
  }

  /**
   * unassign Vmax on GovSteamFV2
   *
   * @param command UnAssignVmaxFromGovSteamFV2Command
   */
  @PutMapping("/unAssignVmax")
  public void unAssignVmax(
      @RequestBody(required = true) UnAssignVmaxFromGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().unAssignVmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmax", exc);
    }
  }

  /**
   * save Vmin on GovSteamFV2
   *
   * @param command AssignVminToGovSteamFV2Command
   */
  @PutMapping("/assignVmin")
  public void assignVmin(@RequestBody AssignVminToGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().assignVmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vmin", exc);
    }
  }

  /**
   * unassign Vmin on GovSteamFV2
   *
   * @param command UnAssignVminFromGovSteamFV2Command
   */
  @PutMapping("/unAssignVmin")
  public void unAssignVmin(
      @RequestBody(required = true) UnAssignVminFromGovSteamFV2Command command) {
    try {
      GovSteamFV2BusinessDelegate.getGovSteamFV2Instance().unAssignVmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovSteamFV2 govSteamFV2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovSteamFV2CommandRestController.class.getName());
}
