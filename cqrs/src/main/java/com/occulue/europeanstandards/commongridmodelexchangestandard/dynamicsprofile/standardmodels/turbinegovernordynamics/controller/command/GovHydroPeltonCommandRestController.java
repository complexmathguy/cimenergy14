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
 * Implements Spring Controller command CQRS processing for entity GovHydroPelton.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroPelton")
public class GovHydroPeltonCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovHydroPelton. if not key provided, calls create, otherwise calls save
   *
   * @param GovHydroPelton govHydroPelton
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovHydroPeltonCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().createGovHydroPelton(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovHydroPelton. if no key provided, calls create, otherwise calls save
   *
   * @param GovHydroPelton govHydroPelton
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovHydroPeltonCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovHydroPeltonCommand
      // -----------------------------------------------
      completableFuture =
          GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().updateGovHydroPelton(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovHydroPeltonController:update() - successfully update GovHydroPelton - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovHydroPelton entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govHydroPeltonId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovHydroPeltonCommand command = new DeleteGovHydroPeltonCommand(govHydroPeltonId);

    try {
      GovHydroPeltonBusinessDelegate delegate =
          GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted GovHydroPelton with key " + command.getGovHydroPeltonId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Av0 on GovHydroPelton
   *
   * @param command AssignAv0ToGovHydroPeltonCommand
   */
  @PutMapping("/assignAv0")
  public void assignAv0(@RequestBody AssignAv0ToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignAv0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Av0", exc);
    }
  }

  /**
   * unassign Av0 on GovHydroPelton
   *
   * @param command UnAssignAv0FromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignAv0")
  public void unAssignAv0(
      @RequestBody(required = true) UnAssignAv0FromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignAv0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Av0", exc);
    }
  }

  /**
   * save Av1 on GovHydroPelton
   *
   * @param command AssignAv1ToGovHydroPeltonCommand
   */
  @PutMapping("/assignAv1")
  public void assignAv1(@RequestBody AssignAv1ToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignAv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Av1", exc);
    }
  }

  /**
   * unassign Av1 on GovHydroPelton
   *
   * @param command UnAssignAv1FromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignAv1")
  public void unAssignAv1(
      @RequestBody(required = true) UnAssignAv1FromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignAv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Av1", exc);
    }
  }

  /**
   * save Bp on GovHydroPelton
   *
   * @param command AssignBpToGovHydroPeltonCommand
   */
  @PutMapping("/assignBp")
  public void assignBp(@RequestBody AssignBpToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignBp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bp", exc);
    }
  }

  /**
   * unassign Bp on GovHydroPelton
   *
   * @param command UnAssignBpFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignBp")
  public void unAssignBp(
      @RequestBody(required = true) UnAssignBpFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignBp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bp", exc);
    }
  }

  /**
   * save Db1 on GovHydroPelton
   *
   * @param command AssignDb1ToGovHydroPeltonCommand
   */
  @PutMapping("/assignDb1")
  public void assignDb1(@RequestBody AssignDb1ToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignDb1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db1", exc);
    }
  }

  /**
   * unassign Db1 on GovHydroPelton
   *
   * @param command UnAssignDb1FromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignDb1")
  public void unAssignDb1(
      @RequestBody(required = true) UnAssignDb1FromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignDb1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db1", exc);
    }
  }

  /**
   * save Db2 on GovHydroPelton
   *
   * @param command AssignDb2ToGovHydroPeltonCommand
   */
  @PutMapping("/assignDb2")
  public void assignDb2(@RequestBody AssignDb2ToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignDb2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db2", exc);
    }
  }

  /**
   * unassign Db2 on GovHydroPelton
   *
   * @param command UnAssignDb2FromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignDb2")
  public void unAssignDb2(
      @RequestBody(required = true) UnAssignDb2FromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignDb2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db2", exc);
    }
  }

  /**
   * save H1 on GovHydroPelton
   *
   * @param command AssignH1ToGovHydroPeltonCommand
   */
  @PutMapping("/assignH1")
  public void assignH1(@RequestBody AssignH1ToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignH1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign H1", exc);
    }
  }

  /**
   * unassign H1 on GovHydroPelton
   *
   * @param command UnAssignH1FromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignH1")
  public void unAssignH1(
      @RequestBody(required = true) UnAssignH1FromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignH1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign H1", exc);
    }
  }

  /**
   * save H2 on GovHydroPelton
   *
   * @param command AssignH2ToGovHydroPeltonCommand
   */
  @PutMapping("/assignH2")
  public void assignH2(@RequestBody AssignH2ToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignH2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign H2", exc);
    }
  }

  /**
   * unassign H2 on GovHydroPelton
   *
   * @param command UnAssignH2FromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignH2")
  public void unAssignH2(
      @RequestBody(required = true) UnAssignH2FromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignH2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign H2", exc);
    }
  }

  /**
   * save Hn on GovHydroPelton
   *
   * @param command AssignHnToGovHydroPeltonCommand
   */
  @PutMapping("/assignHn")
  public void assignHn(@RequestBody AssignHnToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignHn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Hn", exc);
    }
  }

  /**
   * unassign Hn on GovHydroPelton
   *
   * @param command UnAssignHnFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignHn")
  public void unAssignHn(
      @RequestBody(required = true) UnAssignHnFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignHn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Hn", exc);
    }
  }

  /**
   * save Kc on GovHydroPelton
   *
   * @param command AssignKcToGovHydroPeltonCommand
   */
  @PutMapping("/assignKc")
  public void assignKc(@RequestBody AssignKcToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignKc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kc", exc);
    }
  }

  /**
   * unassign Kc on GovHydroPelton
   *
   * @param command UnAssignKcFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignKc")
  public void unAssignKc(
      @RequestBody(required = true) UnAssignKcFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignKc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kc", exc);
    }
  }

  /**
   * save Kg on GovHydroPelton
   *
   * @param command AssignKgToGovHydroPeltonCommand
   */
  @PutMapping("/assignKg")
  public void assignKg(@RequestBody AssignKgToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignKg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kg", exc);
    }
  }

  /**
   * unassign Kg on GovHydroPelton
   *
   * @param command UnAssignKgFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignKg")
  public void unAssignKg(
      @RequestBody(required = true) UnAssignKgFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignKg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kg", exc);
    }
  }

  /**
   * save Qc0 on GovHydroPelton
   *
   * @param command AssignQc0ToGovHydroPeltonCommand
   */
  @PutMapping("/assignQc0")
  public void assignQc0(@RequestBody AssignQc0ToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignQc0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qc0", exc);
    }
  }

  /**
   * unassign Qc0 on GovHydroPelton
   *
   * @param command UnAssignQc0FromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignQc0")
  public void unAssignQc0(
      @RequestBody(required = true) UnAssignQc0FromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignQc0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qc0", exc);
    }
  }

  /**
   * save Qn on GovHydroPelton
   *
   * @param command AssignQnToGovHydroPeltonCommand
   */
  @PutMapping("/assignQn")
  public void assignQn(@RequestBody AssignQnToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignQn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Qn", exc);
    }
  }

  /**
   * unassign Qn on GovHydroPelton
   *
   * @param command UnAssignQnFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignQn")
  public void unAssignQn(
      @RequestBody(required = true) UnAssignQnFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignQn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Qn", exc);
    }
  }

  /**
   * save SimplifiedPelton on GovHydroPelton
   *
   * @param command AssignSimplifiedPeltonToGovHydroPeltonCommand
   */
  @PutMapping("/assignSimplifiedPelton")
  public void assignSimplifiedPelton(
      @RequestBody AssignSimplifiedPeltonToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignSimplifiedPelton(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign SimplifiedPelton", exc);
    }
  }

  /**
   * unassign SimplifiedPelton on GovHydroPelton
   *
   * @param command UnAssignSimplifiedPeltonFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignSimplifiedPelton")
  public void unAssignSimplifiedPelton(
      @RequestBody(required = true) UnAssignSimplifiedPeltonFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignSimplifiedPelton(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign SimplifiedPelton", exc);
    }
  }

  /**
   * save StaticCompensating on GovHydroPelton
   *
   * @param command AssignStaticCompensatingToGovHydroPeltonCommand
   */
  @PutMapping("/assignStaticCompensating")
  public void assignStaticCompensating(
      @RequestBody AssignStaticCompensatingToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignStaticCompensating(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign StaticCompensating", exc);
    }
  }

  /**
   * unassign StaticCompensating on GovHydroPelton
   *
   * @param command UnAssignStaticCompensatingFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignStaticCompensating")
  public void unAssignStaticCompensating(
      @RequestBody(required = true) UnAssignStaticCompensatingFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance()
          .unAssignStaticCompensating(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign StaticCompensating", exc);
    }
  }

  /**
   * save Ta on GovHydroPelton
   *
   * @param command AssignTaToGovHydroPeltonCommand
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on GovHydroPelton
   *
   * @param command UnAssignTaFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(
      @RequestBody(required = true) UnAssignTaFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Ts on GovHydroPelton
   *
   * @param command AssignTsToGovHydroPeltonCommand
   */
  @PutMapping("/assignTs")
  public void assignTs(@RequestBody AssignTsToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignTs(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ts", exc);
    }
  }

  /**
   * unassign Ts on GovHydroPelton
   *
   * @param command UnAssignTsFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignTs")
  public void unAssignTs(
      @RequestBody(required = true) UnAssignTsFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignTs(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ts", exc);
    }
  }

  /**
   * save Tv on GovHydroPelton
   *
   * @param command AssignTvToGovHydroPeltonCommand
   */
  @PutMapping("/assignTv")
  public void assignTv(@RequestBody AssignTvToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignTv(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tv", exc);
    }
  }

  /**
   * unassign Tv on GovHydroPelton
   *
   * @param command UnAssignTvFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignTv")
  public void unAssignTv(
      @RequestBody(required = true) UnAssignTvFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignTv(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tv", exc);
    }
  }

  /**
   * save Twnc on GovHydroPelton
   *
   * @param command AssignTwncToGovHydroPeltonCommand
   */
  @PutMapping("/assignTwnc")
  public void assignTwnc(@RequestBody AssignTwncToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignTwnc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Twnc", exc);
    }
  }

  /**
   * unassign Twnc on GovHydroPelton
   *
   * @param command UnAssignTwncFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignTwnc")
  public void unAssignTwnc(
      @RequestBody(required = true) UnAssignTwncFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignTwnc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Twnc", exc);
    }
  }

  /**
   * save Twng on GovHydroPelton
   *
   * @param command AssignTwngToGovHydroPeltonCommand
   */
  @PutMapping("/assignTwng")
  public void assignTwng(@RequestBody AssignTwngToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignTwng(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Twng", exc);
    }
  }

  /**
   * unassign Twng on GovHydroPelton
   *
   * @param command UnAssignTwngFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignTwng")
  public void unAssignTwng(
      @RequestBody(required = true) UnAssignTwngFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignTwng(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Twng", exc);
    }
  }

  /**
   * save Tx on GovHydroPelton
   *
   * @param command AssignTxToGovHydroPeltonCommand
   */
  @PutMapping("/assignTx")
  public void assignTx(@RequestBody AssignTxToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignTx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tx", exc);
    }
  }

  /**
   * unassign Tx on GovHydroPelton
   *
   * @param command UnAssignTxFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignTx")
  public void unAssignTx(
      @RequestBody(required = true) UnAssignTxFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignTx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tx", exc);
    }
  }

  /**
   * save Va on GovHydroPelton
   *
   * @param command AssignVaToGovHydroPeltonCommand
   */
  @PutMapping("/assignVa")
  public void assignVa(@RequestBody AssignVaToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignVa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Va", exc);
    }
  }

  /**
   * unassign Va on GovHydroPelton
   *
   * @param command UnAssignVaFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignVa")
  public void unAssignVa(
      @RequestBody(required = true) UnAssignVaFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignVa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Va", exc);
    }
  }

  /**
   * save Valvmax on GovHydroPelton
   *
   * @param command AssignValvmaxToGovHydroPeltonCommand
   */
  @PutMapping("/assignValvmax")
  public void assignValvmax(@RequestBody AssignValvmaxToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignValvmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Valvmax", exc);
    }
  }

  /**
   * unassign Valvmax on GovHydroPelton
   *
   * @param command UnAssignValvmaxFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignValvmax")
  public void unAssignValvmax(
      @RequestBody(required = true) UnAssignValvmaxFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignValvmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Valvmax", exc);
    }
  }

  /**
   * save Valvmin on GovHydroPelton
   *
   * @param command AssignValvminToGovHydroPeltonCommand
   */
  @PutMapping("/assignValvmin")
  public void assignValvmin(@RequestBody AssignValvminToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignValvmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Valvmin", exc);
    }
  }

  /**
   * unassign Valvmin on GovHydroPelton
   *
   * @param command UnAssignValvminFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignValvmin")
  public void unAssignValvmin(
      @RequestBody(required = true) UnAssignValvminFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignValvmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Valvmin", exc);
    }
  }

  /**
   * save Vav on GovHydroPelton
   *
   * @param command AssignVavToGovHydroPeltonCommand
   */
  @PutMapping("/assignVav")
  public void assignVav(@RequestBody AssignVavToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignVav(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vav", exc);
    }
  }

  /**
   * unassign Vav on GovHydroPelton
   *
   * @param command UnAssignVavFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignVav")
  public void unAssignVav(
      @RequestBody(required = true) UnAssignVavFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignVav(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vav", exc);
    }
  }

  /**
   * save Vc on GovHydroPelton
   *
   * @param command AssignVcToGovHydroPeltonCommand
   */
  @PutMapping("/assignVc")
  public void assignVc(@RequestBody AssignVcToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignVc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vc", exc);
    }
  }

  /**
   * unassign Vc on GovHydroPelton
   *
   * @param command UnAssignVcFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignVc")
  public void unAssignVc(
      @RequestBody(required = true) UnAssignVcFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignVc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vc", exc);
    }
  }

  /**
   * save Vcv on GovHydroPelton
   *
   * @param command AssignVcvToGovHydroPeltonCommand
   */
  @PutMapping("/assignVcv")
  public void assignVcv(@RequestBody AssignVcvToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignVcv(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vcv", exc);
    }
  }

  /**
   * unassign Vcv on GovHydroPelton
   *
   * @param command UnAssignVcvFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignVcv")
  public void unAssignVcv(
      @RequestBody(required = true) UnAssignVcvFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignVcv(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vcv", exc);
    }
  }

  /**
   * save WaterTunnelSurgeChamberSimulation on GovHydroPelton
   *
   * @param command AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonCommand
   */
  @PutMapping("/assignWaterTunnelSurgeChamberSimulation")
  public void assignWaterTunnelSurgeChamberSimulation(
      @RequestBody AssignWaterTunnelSurgeChamberSimulationToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance()
          .assignWaterTunnelSurgeChamberSimulation(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign WaterTunnelSurgeChamberSimulation", exc);
    }
  }

  /**
   * unassign WaterTunnelSurgeChamberSimulation on GovHydroPelton
   *
   * @param command UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignWaterTunnelSurgeChamberSimulation")
  public void unAssignWaterTunnelSurgeChamberSimulation(
      @RequestBody(required = true)
          UnAssignWaterTunnelSurgeChamberSimulationFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance()
          .unAssignWaterTunnelSurgeChamberSimulation(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign WaterTunnelSurgeChamberSimulation", exc);
    }
  }

  /**
   * save Zsfc on GovHydroPelton
   *
   * @param command AssignZsfcToGovHydroPeltonCommand
   */
  @PutMapping("/assignZsfc")
  public void assignZsfc(@RequestBody AssignZsfcToGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().assignZsfc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Zsfc", exc);
    }
  }

  /**
   * unassign Zsfc on GovHydroPelton
   *
   * @param command UnAssignZsfcFromGovHydroPeltonCommand
   */
  @PutMapping("/unAssignZsfc")
  public void unAssignZsfc(
      @RequestBody(required = true) UnAssignZsfcFromGovHydroPeltonCommand command) {
    try {
      GovHydroPeltonBusinessDelegate.getGovHydroPeltonInstance().unAssignZsfc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Zsfc", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydroPelton govHydroPelton = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroPeltonCommandRestController.class.getName());
}
