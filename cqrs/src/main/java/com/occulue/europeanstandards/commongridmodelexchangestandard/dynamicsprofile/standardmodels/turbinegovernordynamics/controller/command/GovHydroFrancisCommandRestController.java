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
 * Implements Spring Controller command CQRS processing for entity GovHydroFrancis.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroFrancis")
public class GovHydroFrancisCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovHydroFrancis. if not key provided, calls create, otherwise calls save
   *
   * @param GovHydroFrancis govHydroFrancis
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovHydroFrancisCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance()
              .createGovHydroFrancis(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovHydroFrancis. if no key provided, calls create, otherwise calls save
   *
   * @param GovHydroFrancis govHydroFrancis
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovHydroFrancisCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovHydroFrancisCommand
      // -----------------------------------------------
      completableFuture =
          GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance()
              .updateGovHydroFrancis(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovHydroFrancisController:update() - successfully update GovHydroFrancis - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovHydroFrancis entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govHydroFrancisId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovHydroFrancisCommand command = new DeleteGovHydroFrancisCommand(govHydroFrancisId);

    try {
      GovHydroFrancisBusinessDelegate delegate =
          GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted GovHydroFrancis with key " + command.getGovHydroFrancisId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Am on GovHydroFrancis
   *
   * @param command AssignAmToGovHydroFrancisCommand
   */
  @PutMapping("/assignAm")
  public void assignAm(@RequestBody AssignAmToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignAm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Am", exc);
    }
  }

  /**
   * unassign Am on GovHydroFrancis
   *
   * @param command UnAssignAmFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignAm")
  public void unAssignAm(
      @RequestBody(required = true) UnAssignAmFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignAm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Am", exc);
    }
  }

  /**
   * save Av0 on GovHydroFrancis
   *
   * @param command AssignAv0ToGovHydroFrancisCommand
   */
  @PutMapping("/assignAv0")
  public void assignAv0(@RequestBody AssignAv0ToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignAv0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Av0", exc);
    }
  }

  /**
   * unassign Av0 on GovHydroFrancis
   *
   * @param command UnAssignAv0FromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignAv0")
  public void unAssignAv0(
      @RequestBody(required = true) UnAssignAv0FromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignAv0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Av0", exc);
    }
  }

  /**
   * save Av1 on GovHydroFrancis
   *
   * @param command AssignAv1ToGovHydroFrancisCommand
   */
  @PutMapping("/assignAv1")
  public void assignAv1(@RequestBody AssignAv1ToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignAv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Av1", exc);
    }
  }

  /**
   * unassign Av1 on GovHydroFrancis
   *
   * @param command UnAssignAv1FromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignAv1")
  public void unAssignAv1(
      @RequestBody(required = true) UnAssignAv1FromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignAv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Av1", exc);
    }
  }

  /**
   * save Bp on GovHydroFrancis
   *
   * @param command AssignBpToGovHydroFrancisCommand
   */
  @PutMapping("/assignBp")
  public void assignBp(@RequestBody AssignBpToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignBp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bp", exc);
    }
  }

  /**
   * unassign Bp on GovHydroFrancis
   *
   * @param command UnAssignBpFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignBp")
  public void unAssignBp(
      @RequestBody(required = true) UnAssignBpFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignBp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bp", exc);
    }
  }

  /**
   * save Db1 on GovHydroFrancis
   *
   * @param command AssignDb1ToGovHydroFrancisCommand
   */
  @PutMapping("/assignDb1")
  public void assignDb1(@RequestBody AssignDb1ToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignDb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db1", exc);
    }
  }

  /**
   * unassign Db1 on GovHydroFrancis
   *
   * @param command UnAssignDb1FromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignDb1")
  public void unAssignDb1(
      @RequestBody(required = true) UnAssignDb1FromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignDb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db1", exc);
    }
  }

  /**
   * save Etamax on GovHydroFrancis
   *
   * @param command AssignEtamaxToGovHydroFrancisCommand
   */
  @PutMapping("/assignEtamax")
  public void assignEtamax(@RequestBody AssignEtamaxToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignEtamax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Etamax", exc);
    }
  }

  /**
   * unassign Etamax on GovHydroFrancis
   *
   * @param command UnAssignEtamaxFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignEtamax")
  public void unAssignEtamax(
      @RequestBody(required = true) UnAssignEtamaxFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignEtamax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Etamax", exc);
    }
  }

  /**
   * save H1 on GovHydroFrancis
   *
   * @param command AssignH1ToGovHydroFrancisCommand
   */
  @PutMapping("/assignH1")
  public void assignH1(@RequestBody AssignH1ToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignH1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign H1", exc);
    }
  }

  /**
   * unassign H1 on GovHydroFrancis
   *
   * @param command UnAssignH1FromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignH1")
  public void unAssignH1(
      @RequestBody(required = true) UnAssignH1FromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignH1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign H1", exc);
    }
  }

  /**
   * save H2 on GovHydroFrancis
   *
   * @param command AssignH2ToGovHydroFrancisCommand
   */
  @PutMapping("/assignH2")
  public void assignH2(@RequestBody AssignH2ToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignH2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign H2", exc);
    }
  }

  /**
   * unassign H2 on GovHydroFrancis
   *
   * @param command UnAssignH2FromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignH2")
  public void unAssignH2(
      @RequestBody(required = true) UnAssignH2FromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignH2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign H2", exc);
    }
  }

  /**
   * save Hn on GovHydroFrancis
   *
   * @param command AssignHnToGovHydroFrancisCommand
   */
  @PutMapping("/assignHn")
  public void assignHn(@RequestBody AssignHnToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignHn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Hn", exc);
    }
  }

  /**
   * unassign Hn on GovHydroFrancis
   *
   * @param command UnAssignHnFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignHn")
  public void unAssignHn(
      @RequestBody(required = true) UnAssignHnFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignHn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Hn", exc);
    }
  }

  /**
   * save Kc on GovHydroFrancis
   *
   * @param command AssignKcToGovHydroFrancisCommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on GovHydroFrancis
   *
   * @param command UnAssignKcFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(
      @RequestBody(required = true) UnAssignKcFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kg on GovHydroFrancis
   *
   * @param command AssignKgToGovHydroFrancisCommand
   */
  @PutMapping("/assignKg")
  public void assignKg(@RequestBody AssignKgToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignKg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kg", exc);
    }
  }

  /**
   * unassign Kg on GovHydroFrancis
   *
   * @param command UnAssignKgFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignKg")
  public void unAssignKg(
      @RequestBody(required = true) UnAssignKgFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignKg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kg", exc);
    }
  }

  /**
   * save Kt on GovHydroFrancis
   *
   * @param command AssignKtToGovHydroFrancisCommand
   */
  @PutMapping("/assignKt")
  public void assignKt(@RequestBody AssignKtToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignKt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kt", exc);
    }
  }

  /**
   * unassign Kt on GovHydroFrancis
   *
   * @param command UnAssignKtFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignKt")
  public void unAssignKt(
      @RequestBody(required = true) UnAssignKtFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignKt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kt", exc);
    }
  }

  /**
   * save Qc0 on GovHydroFrancis
   *
   * @param command AssignQc0ToGovHydroFrancisCommand
   */
  @PutMapping("/assignQc0")
  public void assignQc0(@RequestBody AssignQc0ToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignQc0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qc0", exc);
    }
  }

  /**
   * unassign Qc0 on GovHydroFrancis
   *
   * @param command UnAssignQc0FromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignQc0")
  public void unAssignQc0(
      @RequestBody(required = true) UnAssignQc0FromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignQc0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qc0", exc);
    }
  }

  /**
   * save Qn on GovHydroFrancis
   *
   * @param command AssignQnToGovHydroFrancisCommand
   */
  @PutMapping("/assignQn")
  public void assignQn(@RequestBody AssignQnToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignQn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qn", exc);
    }
  }

  /**
   * unassign Qn on GovHydroFrancis
   *
   * @param command UnAssignQnFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignQn")
  public void unAssignQn(
      @RequestBody(required = true) UnAssignQnFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignQn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qn", exc);
    }
  }

  /**
   * save Ta on GovHydroFrancis
   *
   * @param command AssignTaToGovHydroFrancisCommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on GovHydroFrancis
   *
   * @param command UnAssignTaFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(
      @RequestBody(required = true) UnAssignTaFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Td on GovHydroFrancis
   *
   * @param command AssignTdToGovHydroFrancisCommand
   */
  @PutMapping("/assignTd")
  public void assignTd(@RequestBody AssignTdToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignTd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Td", exc);
    }
  }

  /**
   * unassign Td on GovHydroFrancis
   *
   * @param command UnAssignTdFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignTd")
  public void unAssignTd(
      @RequestBody(required = true) UnAssignTdFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignTd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Td", exc);
    }
  }

  /**
   * save Ts on GovHydroFrancis
   *
   * @param command AssignTsToGovHydroFrancisCommand
   */
  @PutMapping("/assignTs")
  public void assignTs(@RequestBody AssignTsToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignTs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ts", exc);
    }
  }

  /**
   * unassign Ts on GovHydroFrancis
   *
   * @param command UnAssignTsFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignTs")
  public void unAssignTs(
      @RequestBody(required = true) UnAssignTsFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignTs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ts", exc);
    }
  }

  /**
   * save Twnc on GovHydroFrancis
   *
   * @param command AssignTwncToGovHydroFrancisCommand
   */
  @PutMapping("/assignTwnc")
  public void assignTwnc(@RequestBody AssignTwncToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignTwnc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Twnc", exc);
    }
  }

  /**
   * unassign Twnc on GovHydroFrancis
   *
   * @param command UnAssignTwncFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignTwnc")
  public void unAssignTwnc(
      @RequestBody(required = true) UnAssignTwncFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignTwnc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Twnc", exc);
    }
  }

  /**
   * save Twng on GovHydroFrancis
   *
   * @param command AssignTwngToGovHydroFrancisCommand
   */
  @PutMapping("/assignTwng")
  public void assignTwng(@RequestBody AssignTwngToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignTwng(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Twng", exc);
    }
  }

  /**
   * unassign Twng on GovHydroFrancis
   *
   * @param command UnAssignTwngFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignTwng")
  public void unAssignTwng(
      @RequestBody(required = true) UnAssignTwngFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignTwng(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Twng", exc);
    }
  }

  /**
   * save Tx on GovHydroFrancis
   *
   * @param command AssignTxToGovHydroFrancisCommand
   */
  @PutMapping("/assignTx")
  public void assignTx(@RequestBody AssignTxToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignTx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tx", exc);
    }
  }

  /**
   * unassign Tx on GovHydroFrancis
   *
   * @param command UnAssignTxFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignTx")
  public void unAssignTx(
      @RequestBody(required = true) UnAssignTxFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignTx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tx", exc);
    }
  }

  /**
   * save Va on GovHydroFrancis
   *
   * @param command AssignVaToGovHydroFrancisCommand
   */
  @PutMapping("/assignVa")
  public void assignVa(@RequestBody AssignVaToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignVa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Va", exc);
    }
  }

  /**
   * unassign Va on GovHydroFrancis
   *
   * @param command UnAssignVaFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignVa")
  public void unAssignVa(
      @RequestBody(required = true) UnAssignVaFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignVa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Va", exc);
    }
  }

  /**
   * save Valvmax on GovHydroFrancis
   *
   * @param command AssignValvmaxToGovHydroFrancisCommand
   */
  @PutMapping("/assignValvmax")
  public void assignValvmax(@RequestBody AssignValvmaxToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignValvmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Valvmax", exc);
    }
  }

  /**
   * unassign Valvmax on GovHydroFrancis
   *
   * @param command UnAssignValvmaxFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignValvmax")
  public void unAssignValvmax(
      @RequestBody(required = true) UnAssignValvmaxFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignValvmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Valvmax", exc);
    }
  }

  /**
   * save Valvmin on GovHydroFrancis
   *
   * @param command AssignValvminToGovHydroFrancisCommand
   */
  @PutMapping("/assignValvmin")
  public void assignValvmin(@RequestBody AssignValvminToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignValvmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Valvmin", exc);
    }
  }

  /**
   * unassign Valvmin on GovHydroFrancis
   *
   * @param command UnAssignValvminFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignValvmin")
  public void unAssignValvmin(
      @RequestBody(required = true) UnAssignValvminFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignValvmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Valvmin", exc);
    }
  }

  /**
   * save Vc on GovHydroFrancis
   *
   * @param command AssignVcToGovHydroFrancisCommand
   */
  @PutMapping("/assignVc")
  public void assignVc(@RequestBody AssignVcToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignVc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vc", exc);
    }
  }

  /**
   * unassign Vc on GovHydroFrancis
   *
   * @param command UnAssignVcFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignVc")
  public void unAssignVc(
      @RequestBody(required = true) UnAssignVcFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignVc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vc", exc);
    }
  }

  /**
   * save WaterTunnelSurgeChamberSimulation on GovHydroFrancis
   *
   * @param command AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisCommand
   */
  @PutMapping("/assignWaterTunnelSurgeChamberSimulation")
  public void assignWaterTunnelSurgeChamberSimulation(
      @RequestBody AssignWaterTunnelSurgeChamberSimulationToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance()
          .assignWaterTunnelSurgeChamberSimulation(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign WaterTunnelSurgeChamberSimulation", exc);
    }
  }

  /**
   * unassign WaterTunnelSurgeChamberSimulation on GovHydroFrancis
   *
   * @param command UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignWaterTunnelSurgeChamberSimulation")
  public void unAssignWaterTunnelSurgeChamberSimulation(
      @RequestBody(required = true)
          UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance()
          .unAssignWaterTunnelSurgeChamberSimulation(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign WaterTunnelSurgeChamberSimulation", exc);
    }
  }

  /**
   * save Zsfc on GovHydroFrancis
   *
   * @param command AssignZsfcToGovHydroFrancisCommand
   */
  @PutMapping("/assignZsfc")
  public void assignZsfc(@RequestBody AssignZsfcToGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().assignZsfc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Zsfc", exc);
    }
  }

  /**
   * unassign Zsfc on GovHydroFrancis
   *
   * @param command UnAssignZsfcFromGovHydroFrancisCommand
   */
  @PutMapping("/unAssignZsfc")
  public void unAssignZsfc(
      @RequestBody(required = true) UnAssignZsfcFromGovHydroFrancisCommand command) {
    try {
      GovHydroFrancisBusinessDelegate.getGovHydroFrancisInstance().unAssignZsfc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Zsfc", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydroFrancis govHydroFrancis = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroFrancisCommandRestController.class.getName());
}
