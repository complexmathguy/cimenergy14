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
 * Implements Spring Controller command CQRS processing for entity GovSteamEU.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamEU")
public class GovSteamEUCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovSteamEU. if not key provided, calls create, otherwise calls save
   *
   * @param GovSteamEU govSteamEU
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovSteamEUCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovSteamEUBusinessDelegate.getGovSteamEUInstance().createGovSteamEU(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovSteamEU. if no key provided, calls create, otherwise calls save
   *
   * @param GovSteamEU govSteamEU
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovSteamEUCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovSteamEUCommand
      // -----------------------------------------------
      completableFuture =
          GovSteamEUBusinessDelegate.getGovSteamEUInstance().updateGovSteamEU(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovSteamEUController:update() - successfully update GovSteamEU - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovSteamEU entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govSteamEUId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovSteamEUCommand command = new DeleteGovSteamEUCommand(govSteamEUId);

    try {
      GovSteamEUBusinessDelegate delegate = GovSteamEUBusinessDelegate.getGovSteamEUInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovSteamEU with key " + command.getGovSteamEUId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Chc on GovSteamEU
   *
   * @param command AssignChcToGovSteamEUCommand
   */
  @PutMapping("/assignChc")
  public void assignChc(@RequestBody AssignChcToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignChc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Chc", exc);
    }
  }

  /**
   * unassign Chc on GovSteamEU
   *
   * @param command UnAssignChcFromGovSteamEUCommand
   */
  @PutMapping("/unAssignChc")
  public void unAssignChc(@RequestBody(required = true) UnAssignChcFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignChc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Chc", exc);
    }
  }

  /**
   * save Cho on GovSteamEU
   *
   * @param command AssignChoToGovSteamEUCommand
   */
  @PutMapping("/assignCho")
  public void assignCho(@RequestBody AssignChoToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignCho(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Cho", exc);
    }
  }

  /**
   * unassign Cho on GovSteamEU
   *
   * @param command UnAssignChoFromGovSteamEUCommand
   */
  @PutMapping("/unAssignCho")
  public void unAssignCho(@RequestBody(required = true) UnAssignChoFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignCho(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Cho", exc);
    }
  }

  /**
   * save Cic on GovSteamEU
   *
   * @param command AssignCicToGovSteamEUCommand
   */
  @PutMapping("/assignCic")
  public void assignCic(@RequestBody AssignCicToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignCic(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Cic", exc);
    }
  }

  /**
   * unassign Cic on GovSteamEU
   *
   * @param command UnAssignCicFromGovSteamEUCommand
   */
  @PutMapping("/unAssignCic")
  public void unAssignCic(@RequestBody(required = true) UnAssignCicFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignCic(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Cic", exc);
    }
  }

  /**
   * save Cio on GovSteamEU
   *
   * @param command AssignCioToGovSteamEUCommand
   */
  @PutMapping("/assignCio")
  public void assignCio(@RequestBody AssignCioToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignCio(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Cio", exc);
    }
  }

  /**
   * unassign Cio on GovSteamEU
   *
   * @param command UnAssignCioFromGovSteamEUCommand
   */
  @PutMapping("/unAssignCio")
  public void unAssignCio(@RequestBody(required = true) UnAssignCioFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignCio(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Cio", exc);
    }
  }

  /**
   * save Db1 on GovSteamEU
   *
   * @param command AssignDb1ToGovSteamEUCommand
   */
  @PutMapping("/assignDb1")
  public void assignDb1(@RequestBody AssignDb1ToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignDb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db1", exc);
    }
  }

  /**
   * unassign Db1 on GovSteamEU
   *
   * @param command UnAssignDb1FromGovSteamEUCommand
   */
  @PutMapping("/unAssignDb1")
  public void unAssignDb1(@RequestBody(required = true) UnAssignDb1FromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignDb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db1", exc);
    }
  }

  /**
   * save Db2 on GovSteamEU
   *
   * @param command AssignDb2ToGovSteamEUCommand
   */
  @PutMapping("/assignDb2")
  public void assignDb2(@RequestBody AssignDb2ToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignDb2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db2", exc);
    }
  }

  /**
   * unassign Db2 on GovSteamEU
   *
   * @param command UnAssignDb2FromGovSteamEUCommand
   */
  @PutMapping("/unAssignDb2")
  public void unAssignDb2(@RequestBody(required = true) UnAssignDb2FromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignDb2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db2", exc);
    }
  }

  /**
   * save Hhpmax on GovSteamEU
   *
   * @param command AssignHhpmaxToGovSteamEUCommand
   */
  @PutMapping("/assignHhpmax")
  public void assignHhpmax(@RequestBody AssignHhpmaxToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignHhpmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Hhpmax", exc);
    }
  }

  /**
   * unassign Hhpmax on GovSteamEU
   *
   * @param command UnAssignHhpmaxFromGovSteamEUCommand
   */
  @PutMapping("/unAssignHhpmax")
  public void unAssignHhpmax(
      @RequestBody(required = true) UnAssignHhpmaxFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignHhpmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Hhpmax", exc);
    }
  }

  /**
   * save Ke on GovSteamEU
   *
   * @param command AssignKeToGovSteamEUCommand
   */
  @PutMapping("/assignKe")
  public void assignKe(@RequestBody AssignKeToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignKe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ke", exc);
    }
  }

  /**
   * unassign Ke on GovSteamEU
   *
   * @param command UnAssignKeFromGovSteamEUCommand
   */
  @PutMapping("/unAssignKe")
  public void unAssignKe(@RequestBody(required = true) UnAssignKeFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignKe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ke", exc);
    }
  }

  /**
   * save Kfcor on GovSteamEU
   *
   * @param command AssignKfcorToGovSteamEUCommand
   */
  @PutMapping("/assignKfcor")
  public void assignKfcor(@RequestBody AssignKfcorToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignKfcor(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kfcor", exc);
    }
  }

  /**
   * unassign Kfcor on GovSteamEU
   *
   * @param command UnAssignKfcorFromGovSteamEUCommand
   */
  @PutMapping("/unAssignKfcor")
  public void unAssignKfcor(
      @RequestBody(required = true) UnAssignKfcorFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignKfcor(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kfcor", exc);
    }
  }

  /**
   * save Khp on GovSteamEU
   *
   * @param command AssignKhpToGovSteamEUCommand
   */
  @PutMapping("/assignKhp")
  public void assignKhp(@RequestBody AssignKhpToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignKhp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Khp", exc);
    }
  }

  /**
   * unassign Khp on GovSteamEU
   *
   * @param command UnAssignKhpFromGovSteamEUCommand
   */
  @PutMapping("/unAssignKhp")
  public void unAssignKhp(@RequestBody(required = true) UnAssignKhpFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignKhp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Khp", exc);
    }
  }

  /**
   * save Klp on GovSteamEU
   *
   * @param command AssignKlpToGovSteamEUCommand
   */
  @PutMapping("/assignKlp")
  public void assignKlp(@RequestBody AssignKlpToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignKlp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Klp", exc);
    }
  }

  /**
   * unassign Klp on GovSteamEU
   *
   * @param command UnAssignKlpFromGovSteamEUCommand
   */
  @PutMapping("/unAssignKlp")
  public void unAssignKlp(@RequestBody(required = true) UnAssignKlpFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignKlp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Klp", exc);
    }
  }

  /**
   * save Kwcor on GovSteamEU
   *
   * @param command AssignKwcorToGovSteamEUCommand
   */
  @PutMapping("/assignKwcor")
  public void assignKwcor(@RequestBody AssignKwcorToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignKwcor(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kwcor", exc);
    }
  }

  /**
   * unassign Kwcor on GovSteamEU
   *
   * @param command UnAssignKwcorFromGovSteamEUCommand
   */
  @PutMapping("/unAssignKwcor")
  public void unAssignKwcor(
      @RequestBody(required = true) UnAssignKwcorFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignKwcor(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kwcor", exc);
    }
  }

  /**
   * save Mwbase on GovSteamEU
   *
   * @param command AssignMwbaseToGovSteamEUCommand
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovSteamEU
   *
   * @param command UnAssignMwbaseFromGovSteamEUCommand
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pmax on GovSteamEU
   *
   * @param command AssignPmaxToGovSteamEUCommand
   */
  @PutMapping("/assignPmax")
  public void assignPmax(@RequestBody AssignPmaxToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignPmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmax", exc);
    }
  }

  /**
   * unassign Pmax on GovSteamEU
   *
   * @param command UnAssignPmaxFromGovSteamEUCommand
   */
  @PutMapping("/unAssignPmax")
  public void unAssignPmax(
      @RequestBody(required = true) UnAssignPmaxFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignPmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmax", exc);
    }
  }

  /**
   * save Prhmax on GovSteamEU
   *
   * @param command AssignPrhmaxToGovSteamEUCommand
   */
  @PutMapping("/assignPrhmax")
  public void assignPrhmax(@RequestBody AssignPrhmaxToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignPrhmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Prhmax", exc);
    }
  }

  /**
   * unassign Prhmax on GovSteamEU
   *
   * @param command UnAssignPrhmaxFromGovSteamEUCommand
   */
  @PutMapping("/unAssignPrhmax")
  public void unAssignPrhmax(
      @RequestBody(required = true) UnAssignPrhmaxFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignPrhmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Prhmax", exc);
    }
  }

  /**
   * save Simx on GovSteamEU
   *
   * @param command AssignSimxToGovSteamEUCommand
   */
  @PutMapping("/assignSimx")
  public void assignSimx(@RequestBody AssignSimxToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignSimx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Simx", exc);
    }
  }

  /**
   * unassign Simx on GovSteamEU
   *
   * @param command UnAssignSimxFromGovSteamEUCommand
   */
  @PutMapping("/unAssignSimx")
  public void unAssignSimx(
      @RequestBody(required = true) UnAssignSimxFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignSimx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Simx", exc);
    }
  }

  /**
   * save Tb on GovSteamEU
   *
   * @param command AssignTbToGovSteamEUCommand
   */
  @PutMapping("/assignTb")
  public void assignTb(@RequestBody AssignTbToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignTb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tb", exc);
    }
  }

  /**
   * unassign Tb on GovSteamEU
   *
   * @param command UnAssignTbFromGovSteamEUCommand
   */
  @PutMapping("/unAssignTb")
  public void unAssignTb(@RequestBody(required = true) UnAssignTbFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignTb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tb", exc);
    }
  }

  /**
   * save Tdp on GovSteamEU
   *
   * @param command AssignTdpToGovSteamEUCommand
   */
  @PutMapping("/assignTdp")
  public void assignTdp(@RequestBody AssignTdpToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignTdp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tdp", exc);
    }
  }

  /**
   * unassign Tdp on GovSteamEU
   *
   * @param command UnAssignTdpFromGovSteamEUCommand
   */
  @PutMapping("/unAssignTdp")
  public void unAssignTdp(@RequestBody(required = true) UnAssignTdpFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignTdp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tdp", exc);
    }
  }

  /**
   * save Ten on GovSteamEU
   *
   * @param command AssignTenToGovSteamEUCommand
   */
  @PutMapping("/assignTen")
  public void assignTen(@RequestBody AssignTenToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignTen(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ten", exc);
    }
  }

  /**
   * unassign Ten on GovSteamEU
   *
   * @param command UnAssignTenFromGovSteamEUCommand
   */
  @PutMapping("/unAssignTen")
  public void unAssignTen(@RequestBody(required = true) UnAssignTenFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignTen(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ten", exc);
    }
  }

  /**
   * save Tf on GovSteamEU
   *
   * @param command AssignTfToGovSteamEUCommand
   */
  @PutMapping("/assignTf")
  public void assignTf(@RequestBody AssignTfToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignTf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf", exc);
    }
  }

  /**
   * unassign Tf on GovSteamEU
   *
   * @param command UnAssignTfFromGovSteamEUCommand
   */
  @PutMapping("/unAssignTf")
  public void unAssignTf(@RequestBody(required = true) UnAssignTfFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignTf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf", exc);
    }
  }

  /**
   * save Tfp on GovSteamEU
   *
   * @param command AssignTfpToGovSteamEUCommand
   */
  @PutMapping("/assignTfp")
  public void assignTfp(@RequestBody AssignTfpToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignTfp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tfp", exc);
    }
  }

  /**
   * unassign Tfp on GovSteamEU
   *
   * @param command UnAssignTfpFromGovSteamEUCommand
   */
  @PutMapping("/unAssignTfp")
  public void unAssignTfp(@RequestBody(required = true) UnAssignTfpFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignTfp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tfp", exc);
    }
  }

  /**
   * save Thp on GovSteamEU
   *
   * @param command AssignThpToGovSteamEUCommand
   */
  @PutMapping("/assignThp")
  public void assignThp(@RequestBody AssignThpToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignThp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Thp", exc);
    }
  }

  /**
   * unassign Thp on GovSteamEU
   *
   * @param command UnAssignThpFromGovSteamEUCommand
   */
  @PutMapping("/unAssignThp")
  public void unAssignThp(@RequestBody(required = true) UnAssignThpFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignThp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Thp", exc);
    }
  }

  /**
   * save Tip on GovSteamEU
   *
   * @param command AssignTipToGovSteamEUCommand
   */
  @PutMapping("/assignTip")
  public void assignTip(@RequestBody AssignTipToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignTip(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tip", exc);
    }
  }

  /**
   * unassign Tip on GovSteamEU
   *
   * @param command UnAssignTipFromGovSteamEUCommand
   */
  @PutMapping("/unAssignTip")
  public void unAssignTip(@RequestBody(required = true) UnAssignTipFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignTip(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tip", exc);
    }
  }

  /**
   * save Tlp on GovSteamEU
   *
   * @param command AssignTlpToGovSteamEUCommand
   */
  @PutMapping("/assignTlp")
  public void assignTlp(@RequestBody AssignTlpToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignTlp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tlp", exc);
    }
  }

  /**
   * unassign Tlp on GovSteamEU
   *
   * @param command UnAssignTlpFromGovSteamEUCommand
   */
  @PutMapping("/unAssignTlp")
  public void unAssignTlp(@RequestBody(required = true) UnAssignTlpFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignTlp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tlp", exc);
    }
  }

  /**
   * save Tp on GovSteamEU
   *
   * @param command AssignTpToGovSteamEUCommand
   */
  @PutMapping("/assignTp")
  public void assignTp(@RequestBody AssignTpToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignTp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tp", exc);
    }
  }

  /**
   * unassign Tp on GovSteamEU
   *
   * @param command UnAssignTpFromGovSteamEUCommand
   */
  @PutMapping("/unAssignTp")
  public void unAssignTp(@RequestBody(required = true) UnAssignTpFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignTp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tp", exc);
    }
  }

  /**
   * save Trh on GovSteamEU
   *
   * @param command AssignTrhToGovSteamEUCommand
   */
  @PutMapping("/assignTrh")
  public void assignTrh(@RequestBody AssignTrhToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignTrh(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Trh", exc);
    }
  }

  /**
   * unassign Trh on GovSteamEU
   *
   * @param command UnAssignTrhFromGovSteamEUCommand
   */
  @PutMapping("/unAssignTrh")
  public void unAssignTrh(@RequestBody(required = true) UnAssignTrhFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignTrh(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Trh", exc);
    }
  }

  /**
   * save Tvhp on GovSteamEU
   *
   * @param command AssignTvhpToGovSteamEUCommand
   */
  @PutMapping("/assignTvhp")
  public void assignTvhp(@RequestBody AssignTvhpToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignTvhp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tvhp", exc);
    }
  }

  /**
   * unassign Tvhp on GovSteamEU
   *
   * @param command UnAssignTvhpFromGovSteamEUCommand
   */
  @PutMapping("/unAssignTvhp")
  public void unAssignTvhp(
      @RequestBody(required = true) UnAssignTvhpFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignTvhp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tvhp", exc);
    }
  }

  /**
   * save Tvip on GovSteamEU
   *
   * @param command AssignTvipToGovSteamEUCommand
   */
  @PutMapping("/assignTvip")
  public void assignTvip(@RequestBody AssignTvipToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignTvip(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tvip", exc);
    }
  }

  /**
   * unassign Tvip on GovSteamEU
   *
   * @param command UnAssignTvipFromGovSteamEUCommand
   */
  @PutMapping("/unAssignTvip")
  public void unAssignTvip(
      @RequestBody(required = true) UnAssignTvipFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignTvip(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tvip", exc);
    }
  }

  /**
   * save Tw on GovSteamEU
   *
   * @param command AssignTwToGovSteamEUCommand
   */
  @PutMapping("/assignTw")
  public void assignTw(@RequestBody AssignTwToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignTw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw", exc);
    }
  }

  /**
   * unassign Tw on GovSteamEU
   *
   * @param command UnAssignTwFromGovSteamEUCommand
   */
  @PutMapping("/unAssignTw")
  public void unAssignTw(@RequestBody(required = true) UnAssignTwFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignTw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw", exc);
    }
  }

  /**
   * save Wfmax on GovSteamEU
   *
   * @param command AssignWfmaxToGovSteamEUCommand
   */
  @PutMapping("/assignWfmax")
  public void assignWfmax(@RequestBody AssignWfmaxToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignWfmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Wfmax", exc);
    }
  }

  /**
   * unassign Wfmax on GovSteamEU
   *
   * @param command UnAssignWfmaxFromGovSteamEUCommand
   */
  @PutMapping("/unAssignWfmax")
  public void unAssignWfmax(
      @RequestBody(required = true) UnAssignWfmaxFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignWfmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Wfmax", exc);
    }
  }

  /**
   * save Wfmin on GovSteamEU
   *
   * @param command AssignWfminToGovSteamEUCommand
   */
  @PutMapping("/assignWfmin")
  public void assignWfmin(@RequestBody AssignWfminToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignWfmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Wfmin", exc);
    }
  }

  /**
   * unassign Wfmin on GovSteamEU
   *
   * @param command UnAssignWfminFromGovSteamEUCommand
   */
  @PutMapping("/unAssignWfmin")
  public void unAssignWfmin(
      @RequestBody(required = true) UnAssignWfminFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignWfmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Wfmin", exc);
    }
  }

  /**
   * save Wmax1 on GovSteamEU
   *
   * @param command AssignWmax1ToGovSteamEUCommand
   */
  @PutMapping("/assignWmax1")
  public void assignWmax1(@RequestBody AssignWmax1ToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignWmax1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Wmax1", exc);
    }
  }

  /**
   * unassign Wmax1 on GovSteamEU
   *
   * @param command UnAssignWmax1FromGovSteamEUCommand
   */
  @PutMapping("/unAssignWmax1")
  public void unAssignWmax1(
      @RequestBody(required = true) UnAssignWmax1FromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignWmax1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Wmax1", exc);
    }
  }

  /**
   * save Wmax2 on GovSteamEU
   *
   * @param command AssignWmax2ToGovSteamEUCommand
   */
  @PutMapping("/assignWmax2")
  public void assignWmax2(@RequestBody AssignWmax2ToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignWmax2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Wmax2", exc);
    }
  }

  /**
   * unassign Wmax2 on GovSteamEU
   *
   * @param command UnAssignWmax2FromGovSteamEUCommand
   */
  @PutMapping("/unAssignWmax2")
  public void unAssignWmax2(
      @RequestBody(required = true) UnAssignWmax2FromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignWmax2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Wmax2", exc);
    }
  }

  /**
   * save Wwmax on GovSteamEU
   *
   * @param command AssignWwmaxToGovSteamEUCommand
   */
  @PutMapping("/assignWwmax")
  public void assignWwmax(@RequestBody AssignWwmaxToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignWwmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Wwmax", exc);
    }
  }

  /**
   * unassign Wwmax on GovSteamEU
   *
   * @param command UnAssignWwmaxFromGovSteamEUCommand
   */
  @PutMapping("/unAssignWwmax")
  public void unAssignWwmax(
      @RequestBody(required = true) UnAssignWwmaxFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignWwmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Wwmax", exc);
    }
  }

  /**
   * save Wwmin on GovSteamEU
   *
   * @param command AssignWwminToGovSteamEUCommand
   */
  @PutMapping("/assignWwmin")
  public void assignWwmin(@RequestBody AssignWwminToGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().assignWwmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Wwmin", exc);
    }
  }

  /**
   * unassign Wwmin on GovSteamEU
   *
   * @param command UnAssignWwminFromGovSteamEUCommand
   */
  @PutMapping("/unAssignWwmin")
  public void unAssignWwmin(
      @RequestBody(required = true) UnAssignWwminFromGovSteamEUCommand command) {
    try {
      GovSteamEUBusinessDelegate.getGovSteamEUInstance().unAssignWwmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Wwmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovSteamEU govSteamEU = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovSteamEUCommandRestController.class.getName());
}
