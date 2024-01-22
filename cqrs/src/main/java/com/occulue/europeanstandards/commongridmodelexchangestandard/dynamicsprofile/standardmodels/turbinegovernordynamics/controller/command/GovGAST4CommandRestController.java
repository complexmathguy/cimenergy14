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
 * Implements Spring Controller command CQRS processing for entity GovGAST4.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovGAST4")
public class GovGAST4CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovGAST4. if not key provided, calls create, otherwise calls save
   *
   * @param GovGAST4 govGAST4
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovGAST4Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = GovGAST4BusinessDelegate.getGovGAST4Instance().createGovGAST4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovGAST4. if no key provided, calls create, otherwise calls save
   *
   * @param GovGAST4 govGAST4
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovGAST4Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovGAST4Command
      // -----------------------------------------------
      completableFuture = GovGAST4BusinessDelegate.getGovGAST4Instance().updateGovGAST4(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovGAST4Controller:update() - successfully update GovGAST4 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovGAST4 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govGAST4Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovGAST4Command command = new DeleteGovGAST4Command(govGAST4Id);

    try {
      GovGAST4BusinessDelegate delegate = GovGAST4BusinessDelegate.getGovGAST4Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovGAST4 with key " + command.getGovGAST4Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Bp on GovGAST4
   *
   * @param command AssignBpToGovGAST4Command
   */
  @PutMapping("/assignBp")
  public void assignBp(@RequestBody AssignBpToGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().assignBp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Bp", exc);
    }
  }

  /**
   * unassign Bp on GovGAST4
   *
   * @param command UnAssignBpFromGovGAST4Command
   */
  @PutMapping("/unAssignBp")
  public void unAssignBp(@RequestBody(required = true) UnAssignBpFromGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().unAssignBp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Bp", exc);
    }
  }

  /**
   * save Ktm on GovGAST4
   *
   * @param command AssignKtmToGovGAST4Command
   */
  @PutMapping("/assignKtm")
  public void assignKtm(@RequestBody AssignKtmToGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().assignKtm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ktm", exc);
    }
  }

  /**
   * unassign Ktm on GovGAST4
   *
   * @param command UnAssignKtmFromGovGAST4Command
   */
  @PutMapping("/unAssignKtm")
  public void unAssignKtm(@RequestBody(required = true) UnAssignKtmFromGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().unAssignKtm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ktm", exc);
    }
  }

  /**
   * save Mnef on GovGAST4
   *
   * @param command AssignMnefToGovGAST4Command
   */
  @PutMapping("/assignMnef")
  public void assignMnef(@RequestBody AssignMnefToGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().assignMnef(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mnef", exc);
    }
  }

  /**
   * unassign Mnef on GovGAST4
   *
   * @param command UnAssignMnefFromGovGAST4Command
   */
  @PutMapping("/unAssignMnef")
  public void unAssignMnef(@RequestBody(required = true) UnAssignMnefFromGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().unAssignMnef(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mnef", exc);
    }
  }

  /**
   * save Mxef on GovGAST4
   *
   * @param command AssignMxefToGovGAST4Command
   */
  @PutMapping("/assignMxef")
  public void assignMxef(@RequestBody AssignMxefToGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().assignMxef(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mxef", exc);
    }
  }

  /**
   * unassign Mxef on GovGAST4
   *
   * @param command UnAssignMxefFromGovGAST4Command
   */
  @PutMapping("/unAssignMxef")
  public void unAssignMxef(@RequestBody(required = true) UnAssignMxefFromGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().unAssignMxef(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mxef", exc);
    }
  }

  /**
   * save Rymn on GovGAST4
   *
   * @param command AssignRymnToGovGAST4Command
   */
  @PutMapping("/assignRymn")
  public void assignRymn(@RequestBody AssignRymnToGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().assignRymn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rymn", exc);
    }
  }

  /**
   * unassign Rymn on GovGAST4
   *
   * @param command UnAssignRymnFromGovGAST4Command
   */
  @PutMapping("/unAssignRymn")
  public void unAssignRymn(@RequestBody(required = true) UnAssignRymnFromGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().unAssignRymn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rymn", exc);
    }
  }

  /**
   * save Rymx on GovGAST4
   *
   * @param command AssignRymxToGovGAST4Command
   */
  @PutMapping("/assignRymx")
  public void assignRymx(@RequestBody AssignRymxToGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().assignRymx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rymx", exc);
    }
  }

  /**
   * unassign Rymx on GovGAST4
   *
   * @param command UnAssignRymxFromGovGAST4Command
   */
  @PutMapping("/unAssignRymx")
  public void unAssignRymx(@RequestBody(required = true) UnAssignRymxFromGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().unAssignRymx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rymx", exc);
    }
  }

  /**
   * save Ta on GovGAST4
   *
   * @param command AssignTaToGovGAST4Command
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on GovGAST4
   *
   * @param command UnAssignTaFromGovGAST4Command
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tc on GovGAST4
   *
   * @param command AssignTcToGovGAST4Command
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on GovGAST4
   *
   * @param command UnAssignTcFromGovGAST4Command
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Tcm on GovGAST4
   *
   * @param command AssignTcmToGovGAST4Command
   */
  @PutMapping("/assignTcm")
  public void assignTcm(@RequestBody AssignTcmToGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().assignTcm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tcm", exc);
    }
  }

  /**
   * unassign Tcm on GovGAST4
   *
   * @param command UnAssignTcmFromGovGAST4Command
   */
  @PutMapping("/unAssignTcm")
  public void unAssignTcm(@RequestBody(required = true) UnAssignTcmFromGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().unAssignTcm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tcm", exc);
    }
  }

  /**
   * save Tm on GovGAST4
   *
   * @param command AssignTmToGovGAST4Command
   */
  @PutMapping("/assignTm")
  public void assignTm(@RequestBody AssignTmToGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().assignTm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tm", exc);
    }
  }

  /**
   * unassign Tm on GovGAST4
   *
   * @param command UnAssignTmFromGovGAST4Command
   */
  @PutMapping("/unAssignTm")
  public void unAssignTm(@RequestBody(required = true) UnAssignTmFromGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().unAssignTm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tm", exc);
    }
  }

  /**
   * save Tv on GovGAST4
   *
   * @param command AssignTvToGovGAST4Command
   */
  @PutMapping("/assignTv")
  public void assignTv(@RequestBody AssignTvToGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().assignTv(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tv", exc);
    }
  }

  /**
   * unassign Tv on GovGAST4
   *
   * @param command UnAssignTvFromGovGAST4Command
   */
  @PutMapping("/unAssignTv")
  public void unAssignTv(@RequestBody(required = true) UnAssignTvFromGovGAST4Command command) {
    try {
      GovGAST4BusinessDelegate.getGovGAST4Instance().unAssignTv(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tv", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovGAST4 govGAST4 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovGAST4CommandRestController.class.getName());
}
