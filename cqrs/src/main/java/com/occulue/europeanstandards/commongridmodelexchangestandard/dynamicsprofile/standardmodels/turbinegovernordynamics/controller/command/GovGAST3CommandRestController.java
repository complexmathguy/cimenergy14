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
 * Implements Spring Controller command CQRS processing for entity GovGAST3.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGAST3")
public class GovGAST3CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovGAST3. if not key provided, calls create, otherwise calls save
   *
   * @param GovGAST3 govGAST3
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovGAST3Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovGAST3BusinessDelegate.getGovGAST3Instance().createGovGAST3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovGAST3. if no key provided, calls create, otherwise calls save
   *
   * @param GovGAST3 govGAST3
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovGAST3Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovGAST3Command
      // -----------------------------------------------
      completableFuture = GovGAST3BusinessDelegate.getGovGAST3Instance().updateGovGAST3(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovGAST3Controller:update() - successfully update GovGAST3 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovGAST3 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govGAST3Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovGAST3Command command = new DeleteGovGAST3Command(govGAST3Id);

    try {
      GovGAST3BusinessDelegate delegate = GovGAST3BusinessDelegate.getGovGAST3Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovGAST3 with key " + command.getGovGAST3Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Bca on GovGAST3
   *
   * @param command AssignBcaToGovGAST3Command
   */
  @PutMapping("/assignBca")
  public void assignBca(@RequestBody AssignBcaToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignBca(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bca", exc);
    }
  }

  /**
   * unassign Bca on GovGAST3
   *
   * @param command UnAssignBcaFromGovGAST3Command
   */
  @PutMapping("/unAssignBca")
  public void unAssignBca(@RequestBody(required = true) UnAssignBcaFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignBca(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bca", exc);
    }
  }

  /**
   * save Bp on GovGAST3
   *
   * @param command AssignBpToGovGAST3Command
   */
  @PutMapping("/assignBp")
  public void assignBp(@RequestBody AssignBpToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignBp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bp", exc);
    }
  }

  /**
   * unassign Bp on GovGAST3
   *
   * @param command UnAssignBpFromGovGAST3Command
   */
  @PutMapping("/unAssignBp")
  public void unAssignBp(@RequestBody(required = true) UnAssignBpFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignBp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bp", exc);
    }
  }

  /**
   * save Dtc on GovGAST3
   *
   * @param command AssignDtcToGovGAST3Command
   */
  @PutMapping("/assignDtc")
  public void assignDtc(@RequestBody AssignDtcToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignDtc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dtc", exc);
    }
  }

  /**
   * unassign Dtc on GovGAST3
   *
   * @param command UnAssignDtcFromGovGAST3Command
   */
  @PutMapping("/unAssignDtc")
  public void unAssignDtc(@RequestBody(required = true) UnAssignDtcFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignDtc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dtc", exc);
    }
  }

  /**
   * save Ka on GovGAST3
   *
   * @param command AssignKaToGovGAST3Command
   */
  @PutMapping("/assignKa")
  public void assignKa(@RequestBody AssignKaToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignKa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ka", exc);
    }
  }

  /**
   * unassign Ka on GovGAST3
   *
   * @param command UnAssignKaFromGovGAST3Command
   */
  @PutMapping("/unAssignKa")
  public void unAssignKa(@RequestBody(required = true) UnAssignKaFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignKa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ka", exc);
    }
  }

  /**
   * save Kac on GovGAST3
   *
   * @param command AssignKacToGovGAST3Command
   */
  @PutMapping("/assignKac")
  public void assignKac(@RequestBody AssignKacToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignKac(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kac", exc);
    }
  }

  /**
   * unassign Kac on GovGAST3
   *
   * @param command UnAssignKacFromGovGAST3Command
   */
  @PutMapping("/unAssignKac")
  public void unAssignKac(@RequestBody(required = true) UnAssignKacFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignKac(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kac", exc);
    }
  }

  /**
   * save Kca on GovGAST3
   *
   * @param command AssignKcaToGovGAST3Command
   */
  @PutMapping("/assignKca")
  public void assignKca(@RequestBody AssignKcaToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignKca(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kca", exc);
    }
  }

  /**
   * unassign Kca on GovGAST3
   *
   * @param command UnAssignKcaFromGovGAST3Command
   */
  @PutMapping("/unAssignKca")
  public void unAssignKca(@RequestBody(required = true) UnAssignKcaFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignKca(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kca", exc);
    }
  }

  /**
   * save Ksi on GovGAST3
   *
   * @param command AssignKsiToGovGAST3Command
   */
  @PutMapping("/assignKsi")
  public void assignKsi(@RequestBody AssignKsiToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignKsi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ksi", exc);
    }
  }

  /**
   * unassign Ksi on GovGAST3
   *
   * @param command UnAssignKsiFromGovGAST3Command
   */
  @PutMapping("/unAssignKsi")
  public void unAssignKsi(@RequestBody(required = true) UnAssignKsiFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignKsi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ksi", exc);
    }
  }

  /**
   * save Ky on GovGAST3
   *
   * @param command AssignKyToGovGAST3Command
   */
  @PutMapping("/assignKy")
  public void assignKy(@RequestBody AssignKyToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignKy(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ky", exc);
    }
  }

  /**
   * unassign Ky on GovGAST3
   *
   * @param command UnAssignKyFromGovGAST3Command
   */
  @PutMapping("/unAssignKy")
  public void unAssignKy(@RequestBody(required = true) UnAssignKyFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignKy(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ky", exc);
    }
  }

  /**
   * save Mnef on GovGAST3
   *
   * @param command AssignMnefToGovGAST3Command
   */
  @PutMapping("/assignMnef")
  public void assignMnef(@RequestBody AssignMnefToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignMnef(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mnef", exc);
    }
  }

  /**
   * unassign Mnef on GovGAST3
   *
   * @param command UnAssignMnefFromGovGAST3Command
   */
  @PutMapping("/unAssignMnef")
  public void unAssignMnef(@RequestBody(required = true) UnAssignMnefFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignMnef(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mnef", exc);
    }
  }

  /**
   * save Mxef on GovGAST3
   *
   * @param command AssignMxefToGovGAST3Command
   */
  @PutMapping("/assignMxef")
  public void assignMxef(@RequestBody AssignMxefToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignMxef(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mxef", exc);
    }
  }

  /**
   * unassign Mxef on GovGAST3
   *
   * @param command UnAssignMxefFromGovGAST3Command
   */
  @PutMapping("/unAssignMxef")
  public void unAssignMxef(@RequestBody(required = true) UnAssignMxefFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignMxef(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mxef", exc);
    }
  }

  /**
   * save Rcmn on GovGAST3
   *
   * @param command AssignRcmnToGovGAST3Command
   */
  @PutMapping("/assignRcmn")
  public void assignRcmn(@RequestBody AssignRcmnToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignRcmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rcmn", exc);
    }
  }

  /**
   * unassign Rcmn on GovGAST3
   *
   * @param command UnAssignRcmnFromGovGAST3Command
   */
  @PutMapping("/unAssignRcmn")
  public void unAssignRcmn(@RequestBody(required = true) UnAssignRcmnFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignRcmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rcmn", exc);
    }
  }

  /**
   * save Rcmx on GovGAST3
   *
   * @param command AssignRcmxToGovGAST3Command
   */
  @PutMapping("/assignRcmx")
  public void assignRcmx(@RequestBody AssignRcmxToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignRcmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rcmx", exc);
    }
  }

  /**
   * unassign Rcmx on GovGAST3
   *
   * @param command UnAssignRcmxFromGovGAST3Command
   */
  @PutMapping("/unAssignRcmx")
  public void unAssignRcmx(@RequestBody(required = true) UnAssignRcmxFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignRcmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rcmx", exc);
    }
  }

  /**
   * save Tac on GovGAST3
   *
   * @param command AssignTacToGovGAST3Command
   */
  @PutMapping("/assignTac")
  public void assignTac(@RequestBody AssignTacToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignTac(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tac", exc);
    }
  }

  /**
   * unassign Tac on GovGAST3
   *
   * @param command UnAssignTacFromGovGAST3Command
   */
  @PutMapping("/unAssignTac")
  public void unAssignTac(@RequestBody(required = true) UnAssignTacFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignTac(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tac", exc);
    }
  }

  /**
   * save Tc on GovGAST3
   *
   * @param command AssignTcToGovGAST3Command
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on GovGAST3
   *
   * @param command UnAssignTcFromGovGAST3Command
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Td on GovGAST3
   *
   * @param command AssignTdToGovGAST3Command
   */
  @PutMapping("/assignTd")
  public void assignTd(@RequestBody AssignTdToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignTd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Td", exc);
    }
  }

  /**
   * unassign Td on GovGAST3
   *
   * @param command UnAssignTdFromGovGAST3Command
   */
  @PutMapping("/unAssignTd")
  public void unAssignTd(@RequestBody(required = true) UnAssignTdFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignTd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Td", exc);
    }
  }

  /**
   * save Tfen on GovGAST3
   *
   * @param command AssignTfenToGovGAST3Command
   */
  @PutMapping("/assignTfen")
  public void assignTfen(@RequestBody AssignTfenToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignTfen(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tfen", exc);
    }
  }

  /**
   * unassign Tfen on GovGAST3
   *
   * @param command UnAssignTfenFromGovGAST3Command
   */
  @PutMapping("/unAssignTfen")
  public void unAssignTfen(@RequestBody(required = true) UnAssignTfenFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignTfen(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tfen", exc);
    }
  }

  /**
   * save Tg on GovGAST3
   *
   * @param command AssignTgToGovGAST3Command
   */
  @PutMapping("/assignTg")
  public void assignTg(@RequestBody AssignTgToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignTg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tg", exc);
    }
  }

  /**
   * unassign Tg on GovGAST3
   *
   * @param command UnAssignTgFromGovGAST3Command
   */
  @PutMapping("/unAssignTg")
  public void unAssignTg(@RequestBody(required = true) UnAssignTgFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignTg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tg", exc);
    }
  }

  /**
   * save Tsi on GovGAST3
   *
   * @param command AssignTsiToGovGAST3Command
   */
  @PutMapping("/assignTsi")
  public void assignTsi(@RequestBody AssignTsiToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignTsi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tsi", exc);
    }
  }

  /**
   * unassign Tsi on GovGAST3
   *
   * @param command UnAssignTsiFromGovGAST3Command
   */
  @PutMapping("/unAssignTsi")
  public void unAssignTsi(@RequestBody(required = true) UnAssignTsiFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignTsi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tsi", exc);
    }
  }

  /**
   * save Tt on GovGAST3
   *
   * @param command AssignTtToGovGAST3Command
   */
  @PutMapping("/assignTt")
  public void assignTt(@RequestBody AssignTtToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignTt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tt", exc);
    }
  }

  /**
   * unassign Tt on GovGAST3
   *
   * @param command UnAssignTtFromGovGAST3Command
   */
  @PutMapping("/unAssignTt")
  public void unAssignTt(@RequestBody(required = true) UnAssignTtFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignTt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tt", exc);
    }
  }

  /**
   * save Ttc on GovGAST3
   *
   * @param command AssignTtcToGovGAST3Command
   */
  @PutMapping("/assignTtc")
  public void assignTtc(@RequestBody AssignTtcToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignTtc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ttc", exc);
    }
  }

  /**
   * unassign Ttc on GovGAST3
   *
   * @param command UnAssignTtcFromGovGAST3Command
   */
  @PutMapping("/unAssignTtc")
  public void unAssignTtc(@RequestBody(required = true) UnAssignTtcFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignTtc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ttc", exc);
    }
  }

  /**
   * save Ty on GovGAST3
   *
   * @param command AssignTyToGovGAST3Command
   */
  @PutMapping("/assignTy")
  public void assignTy(@RequestBody AssignTyToGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().assignTy(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ty", exc);
    }
  }

  /**
   * unassign Ty on GovGAST3
   *
   * @param command UnAssignTyFromGovGAST3Command
   */
  @PutMapping("/unAssignTy")
  public void unAssignTy(@RequestBody(required = true) UnAssignTyFromGovGAST3Command command) {
    try {
      GovGAST3BusinessDelegate.getGovGAST3Instance().unAssignTy(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ty", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovGAST3 govGAST3 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovGAST3CommandRestController.class.getName());
}
