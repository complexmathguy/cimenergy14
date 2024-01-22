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
 * Implements Spring Controller command CQRS processing for entity GovSteamFV4.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovSteamFV4")
public class GovSteamFV4CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovSteamFV4. if not key provided, calls create, otherwise calls save
   *
   * @param GovSteamFV4 govSteamFV4
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovSteamFV4Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().createGovSteamFV4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovSteamFV4. if no key provided, calls create, otherwise calls save
   *
   * @param GovSteamFV4 govSteamFV4
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovSteamFV4Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovSteamFV4Command
      // -----------------------------------------------
      completableFuture =
          GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().updateGovSteamFV4(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovSteamFV4Controller:update() - successfully update GovSteamFV4 - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovSteamFV4 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govSteamFV4Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovSteamFV4Command command = new DeleteGovSteamFV4Command(govSteamFV4Id);

    try {
      GovSteamFV4BusinessDelegate delegate = GovSteamFV4BusinessDelegate.getGovSteamFV4Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovSteamFV4 with key " + command.getGovSteamFV4Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Cpsmn on GovSteamFV4
   *
   * @param command AssignCpsmnToGovSteamFV4Command
   */
  @PutMapping("/assignCpsmn")
  public void assignCpsmn(@RequestBody AssignCpsmnToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignCpsmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Cpsmn", exc);
    }
  }

  /**
   * unassign Cpsmn on GovSteamFV4
   *
   * @param command UnAssignCpsmnFromGovSteamFV4Command
   */
  @PutMapping("/unAssignCpsmn")
  public void unAssignCpsmn(
      @RequestBody(required = true) UnAssignCpsmnFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignCpsmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Cpsmn", exc);
    }
  }

  /**
   * save Cpsmx on GovSteamFV4
   *
   * @param command AssignCpsmxToGovSteamFV4Command
   */
  @PutMapping("/assignCpsmx")
  public void assignCpsmx(@RequestBody AssignCpsmxToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignCpsmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Cpsmx", exc);
    }
  }

  /**
   * unassign Cpsmx on GovSteamFV4
   *
   * @param command UnAssignCpsmxFromGovSteamFV4Command
   */
  @PutMapping("/unAssignCpsmx")
  public void unAssignCpsmx(
      @RequestBody(required = true) UnAssignCpsmxFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignCpsmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Cpsmx", exc);
    }
  }

  /**
   * save Crmn on GovSteamFV4
   *
   * @param command AssignCrmnToGovSteamFV4Command
   */
  @PutMapping("/assignCrmn")
  public void assignCrmn(@RequestBody AssignCrmnToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignCrmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Crmn", exc);
    }
  }

  /**
   * unassign Crmn on GovSteamFV4
   *
   * @param command UnAssignCrmnFromGovSteamFV4Command
   */
  @PutMapping("/unAssignCrmn")
  public void unAssignCrmn(
      @RequestBody(required = true) UnAssignCrmnFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignCrmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Crmn", exc);
    }
  }

  /**
   * save Crmx on GovSteamFV4
   *
   * @param command AssignCrmxToGovSteamFV4Command
   */
  @PutMapping("/assignCrmx")
  public void assignCrmx(@RequestBody AssignCrmxToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignCrmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Crmx", exc);
    }
  }

  /**
   * unassign Crmx on GovSteamFV4
   *
   * @param command UnAssignCrmxFromGovSteamFV4Command
   */
  @PutMapping("/unAssignCrmx")
  public void unAssignCrmx(
      @RequestBody(required = true) UnAssignCrmxFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignCrmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Crmx", exc);
    }
  }

  /**
   * save Kdc on GovSteamFV4
   *
   * @param command AssignKdcToGovSteamFV4Command
   */
  @PutMapping("/assignKdc")
  public void assignKdc(@RequestBody AssignKdcToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignKdc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kdc", exc);
    }
  }

  /**
   * unassign Kdc on GovSteamFV4
   *
   * @param command UnAssignKdcFromGovSteamFV4Command
   */
  @PutMapping("/unAssignKdc")
  public void unAssignKdc(@RequestBody(required = true) UnAssignKdcFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignKdc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kdc", exc);
    }
  }

  /**
   * save Kf1 on GovSteamFV4
   *
   * @param command AssignKf1ToGovSteamFV4Command
   */
  @PutMapping("/assignKf1")
  public void assignKf1(@RequestBody AssignKf1ToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignKf1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf1", exc);
    }
  }

  /**
   * unassign Kf1 on GovSteamFV4
   *
   * @param command UnAssignKf1FromGovSteamFV4Command
   */
  @PutMapping("/unAssignKf1")
  public void unAssignKf1(@RequestBody(required = true) UnAssignKf1FromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignKf1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf1", exc);
    }
  }

  /**
   * save Kf3 on GovSteamFV4
   *
   * @param command AssignKf3ToGovSteamFV4Command
   */
  @PutMapping("/assignKf3")
  public void assignKf3(@RequestBody AssignKf3ToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignKf3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kf3", exc);
    }
  }

  /**
   * unassign Kf3 on GovSteamFV4
   *
   * @param command UnAssignKf3FromGovSteamFV4Command
   */
  @PutMapping("/unAssignKf3")
  public void unAssignKf3(@RequestBody(required = true) UnAssignKf3FromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignKf3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kf3", exc);
    }
  }

  /**
   * save Khp on GovSteamFV4
   *
   * @param command AssignKhpToGovSteamFV4Command
   */
  @PutMapping("/assignKhp")
  public void assignKhp(@RequestBody AssignKhpToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignKhp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Khp", exc);
    }
  }

  /**
   * unassign Khp on GovSteamFV4
   *
   * @param command UnAssignKhpFromGovSteamFV4Command
   */
  @PutMapping("/unAssignKhp")
  public void unAssignKhp(@RequestBody(required = true) UnAssignKhpFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignKhp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Khp", exc);
    }
  }

  /**
   * save Kic on GovSteamFV4
   *
   * @param command AssignKicToGovSteamFV4Command
   */
  @PutMapping("/assignKic")
  public void assignKic(@RequestBody AssignKicToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignKic(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kic", exc);
    }
  }

  /**
   * unassign Kic on GovSteamFV4
   *
   * @param command UnAssignKicFromGovSteamFV4Command
   */
  @PutMapping("/unAssignKic")
  public void unAssignKic(@RequestBody(required = true) UnAssignKicFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignKic(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kic", exc);
    }
  }

  /**
   * save Kip on GovSteamFV4
   *
   * @param command AssignKipToGovSteamFV4Command
   */
  @PutMapping("/assignKip")
  public void assignKip(@RequestBody AssignKipToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignKip(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kip", exc);
    }
  }

  /**
   * unassign Kip on GovSteamFV4
   *
   * @param command UnAssignKipFromGovSteamFV4Command
   */
  @PutMapping("/unAssignKip")
  public void unAssignKip(@RequestBody(required = true) UnAssignKipFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignKip(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kip", exc);
    }
  }

  /**
   * save Kit on GovSteamFV4
   *
   * @param command AssignKitToGovSteamFV4Command
   */
  @PutMapping("/assignKit")
  public void assignKit(@RequestBody AssignKitToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignKit(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kit", exc);
    }
  }

  /**
   * unassign Kit on GovSteamFV4
   *
   * @param command UnAssignKitFromGovSteamFV4Command
   */
  @PutMapping("/unAssignKit")
  public void unAssignKit(@RequestBody(required = true) UnAssignKitFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignKit(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kit", exc);
    }
  }

  /**
   * save Kmp1 on GovSteamFV4
   *
   * @param command AssignKmp1ToGovSteamFV4Command
   */
  @PutMapping("/assignKmp1")
  public void assignKmp1(@RequestBody AssignKmp1ToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignKmp1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kmp1", exc);
    }
  }

  /**
   * unassign Kmp1 on GovSteamFV4
   *
   * @param command UnAssignKmp1FromGovSteamFV4Command
   */
  @PutMapping("/unAssignKmp1")
  public void unAssignKmp1(
      @RequestBody(required = true) UnAssignKmp1FromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignKmp1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kmp1", exc);
    }
  }

  /**
   * save Kmp2 on GovSteamFV4
   *
   * @param command AssignKmp2ToGovSteamFV4Command
   */
  @PutMapping("/assignKmp2")
  public void assignKmp2(@RequestBody AssignKmp2ToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignKmp2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kmp2", exc);
    }
  }

  /**
   * unassign Kmp2 on GovSteamFV4
   *
   * @param command UnAssignKmp2FromGovSteamFV4Command
   */
  @PutMapping("/unAssignKmp2")
  public void unAssignKmp2(
      @RequestBody(required = true) UnAssignKmp2FromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignKmp2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kmp2", exc);
    }
  }

  /**
   * save Kpc on GovSteamFV4
   *
   * @param command AssignKpcToGovSteamFV4Command
   */
  @PutMapping("/assignKpc")
  public void assignKpc(@RequestBody AssignKpcToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignKpc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpc", exc);
    }
  }

  /**
   * unassign Kpc on GovSteamFV4
   *
   * @param command UnAssignKpcFromGovSteamFV4Command
   */
  @PutMapping("/unAssignKpc")
  public void unAssignKpc(@RequestBody(required = true) UnAssignKpcFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignKpc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpc", exc);
    }
  }

  /**
   * save Kpp on GovSteamFV4
   *
   * @param command AssignKppToGovSteamFV4Command
   */
  @PutMapping("/assignKpp")
  public void assignKpp(@RequestBody AssignKppToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignKpp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpp", exc);
    }
  }

  /**
   * unassign Kpp on GovSteamFV4
   *
   * @param command UnAssignKppFromGovSteamFV4Command
   */
  @PutMapping("/unAssignKpp")
  public void unAssignKpp(@RequestBody(required = true) UnAssignKppFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignKpp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpp", exc);
    }
  }

  /**
   * save Kpt on GovSteamFV4
   *
   * @param command AssignKptToGovSteamFV4Command
   */
  @PutMapping("/assignKpt")
  public void assignKpt(@RequestBody AssignKptToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignKpt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kpt", exc);
    }
  }

  /**
   * unassign Kpt on GovSteamFV4
   *
   * @param command UnAssignKptFromGovSteamFV4Command
   */
  @PutMapping("/unAssignKpt")
  public void unAssignKpt(@RequestBody(required = true) UnAssignKptFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignKpt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kpt", exc);
    }
  }

  /**
   * save Krc on GovSteamFV4
   *
   * @param command AssignKrcToGovSteamFV4Command
   */
  @PutMapping("/assignKrc")
  public void assignKrc(@RequestBody AssignKrcToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignKrc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Krc", exc);
    }
  }

  /**
   * unassign Krc on GovSteamFV4
   *
   * @param command UnAssignKrcFromGovSteamFV4Command
   */
  @PutMapping("/unAssignKrc")
  public void unAssignKrc(@RequestBody(required = true) UnAssignKrcFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignKrc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Krc", exc);
    }
  }

  /**
   * save Ksh on GovSteamFV4
   *
   * @param command AssignKshToGovSteamFV4Command
   */
  @PutMapping("/assignKsh")
  public void assignKsh(@RequestBody AssignKshToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignKsh(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ksh", exc);
    }
  }

  /**
   * unassign Ksh on GovSteamFV4
   *
   * @param command UnAssignKshFromGovSteamFV4Command
   */
  @PutMapping("/unAssignKsh")
  public void unAssignKsh(@RequestBody(required = true) UnAssignKshFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignKsh(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ksh", exc);
    }
  }

  /**
   * save Lpi on GovSteamFV4
   *
   * @param command AssignLpiToGovSteamFV4Command
   */
  @PutMapping("/assignLpi")
  public void assignLpi(@RequestBody AssignLpiToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignLpi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Lpi", exc);
    }
  }

  /**
   * unassign Lpi on GovSteamFV4
   *
   * @param command UnAssignLpiFromGovSteamFV4Command
   */
  @PutMapping("/unAssignLpi")
  public void unAssignLpi(@RequestBody(required = true) UnAssignLpiFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignLpi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Lpi", exc);
    }
  }

  /**
   * save Lps on GovSteamFV4
   *
   * @param command AssignLpsToGovSteamFV4Command
   */
  @PutMapping("/assignLps")
  public void assignLps(@RequestBody AssignLpsToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignLps(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Lps", exc);
    }
  }

  /**
   * unassign Lps on GovSteamFV4
   *
   * @param command UnAssignLpsFromGovSteamFV4Command
   */
  @PutMapping("/unAssignLps")
  public void unAssignLps(@RequestBody(required = true) UnAssignLpsFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignLps(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Lps", exc);
    }
  }

  /**
   * save Mnef on GovSteamFV4
   *
   * @param command AssignMnefToGovSteamFV4Command
   */
  @PutMapping("/assignMnef")
  public void assignMnef(@RequestBody AssignMnefToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignMnef(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mnef", exc);
    }
  }

  /**
   * unassign Mnef on GovSteamFV4
   *
   * @param command UnAssignMnefFromGovSteamFV4Command
   */
  @PutMapping("/unAssignMnef")
  public void unAssignMnef(
      @RequestBody(required = true) UnAssignMnefFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignMnef(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mnef", exc);
    }
  }

  /**
   * save Mxef on GovSteamFV4
   *
   * @param command AssignMxefToGovSteamFV4Command
   */
  @PutMapping("/assignMxef")
  public void assignMxef(@RequestBody AssignMxefToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignMxef(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mxef", exc);
    }
  }

  /**
   * unassign Mxef on GovSteamFV4
   *
   * @param command UnAssignMxefFromGovSteamFV4Command
   */
  @PutMapping("/unAssignMxef")
  public void unAssignMxef(
      @RequestBody(required = true) UnAssignMxefFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignMxef(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mxef", exc);
    }
  }

  /**
   * save Pr1 on GovSteamFV4
   *
   * @param command AssignPr1ToGovSteamFV4Command
   */
  @PutMapping("/assignPr1")
  public void assignPr1(@RequestBody AssignPr1ToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignPr1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pr1", exc);
    }
  }

  /**
   * unassign Pr1 on GovSteamFV4
   *
   * @param command UnAssignPr1FromGovSteamFV4Command
   */
  @PutMapping("/unAssignPr1")
  public void unAssignPr1(@RequestBody(required = true) UnAssignPr1FromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignPr1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pr1", exc);
    }
  }

  /**
   * save Pr2 on GovSteamFV4
   *
   * @param command AssignPr2ToGovSteamFV4Command
   */
  @PutMapping("/assignPr2")
  public void assignPr2(@RequestBody AssignPr2ToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignPr2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pr2", exc);
    }
  }

  /**
   * unassign Pr2 on GovSteamFV4
   *
   * @param command UnAssignPr2FromGovSteamFV4Command
   */
  @PutMapping("/unAssignPr2")
  public void unAssignPr2(@RequestBody(required = true) UnAssignPr2FromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignPr2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pr2", exc);
    }
  }

  /**
   * save Psmn on GovSteamFV4
   *
   * @param command AssignPsmnToGovSteamFV4Command
   */
  @PutMapping("/assignPsmn")
  public void assignPsmn(@RequestBody AssignPsmnToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignPsmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Psmn", exc);
    }
  }

  /**
   * unassign Psmn on GovSteamFV4
   *
   * @param command UnAssignPsmnFromGovSteamFV4Command
   */
  @PutMapping("/unAssignPsmn")
  public void unAssignPsmn(
      @RequestBody(required = true) UnAssignPsmnFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignPsmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Psmn", exc);
    }
  }

  /**
   * save Rsmimn on GovSteamFV4
   *
   * @param command AssignRsmimnToGovSteamFV4Command
   */
  @PutMapping("/assignRsmimn")
  public void assignRsmimn(@RequestBody AssignRsmimnToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignRsmimn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rsmimn", exc);
    }
  }

  /**
   * unassign Rsmimn on GovSteamFV4
   *
   * @param command UnAssignRsmimnFromGovSteamFV4Command
   */
  @PutMapping("/unAssignRsmimn")
  public void unAssignRsmimn(
      @RequestBody(required = true) UnAssignRsmimnFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignRsmimn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rsmimn", exc);
    }
  }

  /**
   * save Rsmimx on GovSteamFV4
   *
   * @param command AssignRsmimxToGovSteamFV4Command
   */
  @PutMapping("/assignRsmimx")
  public void assignRsmimx(@RequestBody AssignRsmimxToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignRsmimx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rsmimx", exc);
    }
  }

  /**
   * unassign Rsmimx on GovSteamFV4
   *
   * @param command UnAssignRsmimxFromGovSteamFV4Command
   */
  @PutMapping("/unAssignRsmimx")
  public void unAssignRsmimx(
      @RequestBody(required = true) UnAssignRsmimxFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignRsmimx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rsmimx", exc);
    }
  }

  /**
   * save Rvgmn on GovSteamFV4
   *
   * @param command AssignRvgmnToGovSteamFV4Command
   */
  @PutMapping("/assignRvgmn")
  public void assignRvgmn(@RequestBody AssignRvgmnToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignRvgmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rvgmn", exc);
    }
  }

  /**
   * unassign Rvgmn on GovSteamFV4
   *
   * @param command UnAssignRvgmnFromGovSteamFV4Command
   */
  @PutMapping("/unAssignRvgmn")
  public void unAssignRvgmn(
      @RequestBody(required = true) UnAssignRvgmnFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignRvgmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rvgmn", exc);
    }
  }

  /**
   * save Rvgmx on GovSteamFV4
   *
   * @param command AssignRvgmxToGovSteamFV4Command
   */
  @PutMapping("/assignRvgmx")
  public void assignRvgmx(@RequestBody AssignRvgmxToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignRvgmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rvgmx", exc);
    }
  }

  /**
   * unassign Rvgmx on GovSteamFV4
   *
   * @param command UnAssignRvgmxFromGovSteamFV4Command
   */
  @PutMapping("/unAssignRvgmx")
  public void unAssignRvgmx(
      @RequestBody(required = true) UnAssignRvgmxFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignRvgmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rvgmx", exc);
    }
  }

  /**
   * save Srmn on GovSteamFV4
   *
   * @param command AssignSrmnToGovSteamFV4Command
   */
  @PutMapping("/assignSrmn")
  public void assignSrmn(@RequestBody AssignSrmnToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignSrmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Srmn", exc);
    }
  }

  /**
   * unassign Srmn on GovSteamFV4
   *
   * @param command UnAssignSrmnFromGovSteamFV4Command
   */
  @PutMapping("/unAssignSrmn")
  public void unAssignSrmn(
      @RequestBody(required = true) UnAssignSrmnFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignSrmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Srmn", exc);
    }
  }

  /**
   * save Srmx on GovSteamFV4
   *
   * @param command AssignSrmxToGovSteamFV4Command
   */
  @PutMapping("/assignSrmx")
  public void assignSrmx(@RequestBody AssignSrmxToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignSrmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Srmx", exc);
    }
  }

  /**
   * unassign Srmx on GovSteamFV4
   *
   * @param command UnAssignSrmxFromGovSteamFV4Command
   */
  @PutMapping("/unAssignSrmx")
  public void unAssignSrmx(
      @RequestBody(required = true) UnAssignSrmxFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignSrmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Srmx", exc);
    }
  }

  /**
   * save Srsmp on GovSteamFV4
   *
   * @param command AssignSrsmpToGovSteamFV4Command
   */
  @PutMapping("/assignSrsmp")
  public void assignSrsmp(@RequestBody AssignSrsmpToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignSrsmp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Srsmp", exc);
    }
  }

  /**
   * unassign Srsmp on GovSteamFV4
   *
   * @param command UnAssignSrsmpFromGovSteamFV4Command
   */
  @PutMapping("/unAssignSrsmp")
  public void unAssignSrsmp(
      @RequestBody(required = true) UnAssignSrsmpFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignSrsmp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Srsmp", exc);
    }
  }

  /**
   * save Svmn on GovSteamFV4
   *
   * @param command AssignSvmnToGovSteamFV4Command
   */
  @PutMapping("/assignSvmn")
  public void assignSvmn(@RequestBody AssignSvmnToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignSvmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Svmn", exc);
    }
  }

  /**
   * unassign Svmn on GovSteamFV4
   *
   * @param command UnAssignSvmnFromGovSteamFV4Command
   */
  @PutMapping("/unAssignSvmn")
  public void unAssignSvmn(
      @RequestBody(required = true) UnAssignSvmnFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignSvmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Svmn", exc);
    }
  }

  /**
   * save Svmx on GovSteamFV4
   *
   * @param command AssignSvmxToGovSteamFV4Command
   */
  @PutMapping("/assignSvmx")
  public void assignSvmx(@RequestBody AssignSvmxToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignSvmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Svmx", exc);
    }
  }

  /**
   * unassign Svmx on GovSteamFV4
   *
   * @param command UnAssignSvmxFromGovSteamFV4Command
   */
  @PutMapping("/unAssignSvmx")
  public void unAssignSvmx(
      @RequestBody(required = true) UnAssignSvmxFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignSvmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Svmx", exc);
    }
  }

  /**
   * save Ta on GovSteamFV4
   *
   * @param command AssignTaToGovSteamFV4Command
   */
  @PutMapping("/assignTa")
  public void assignTa(@RequestBody AssignTaToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignTa(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ta", exc);
    }
  }

  /**
   * unassign Ta on GovSteamFV4
   *
   * @param command UnAssignTaFromGovSteamFV4Command
   */
  @PutMapping("/unAssignTa")
  public void unAssignTa(@RequestBody(required = true) UnAssignTaFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignTa(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ta", exc);
    }
  }

  /**
   * save Tam on GovSteamFV4
   *
   * @param command AssignTamToGovSteamFV4Command
   */
  @PutMapping("/assignTam")
  public void assignTam(@RequestBody AssignTamToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignTam(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tam", exc);
    }
  }

  /**
   * unassign Tam on GovSteamFV4
   *
   * @param command UnAssignTamFromGovSteamFV4Command
   */
  @PutMapping("/unAssignTam")
  public void unAssignTam(@RequestBody(required = true) UnAssignTamFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignTam(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tam", exc);
    }
  }

  /**
   * save Tc on GovSteamFV4
   *
   * @param command AssignTcToGovSteamFV4Command
   */
  @PutMapping("/assignTc")
  public void assignTc(@RequestBody AssignTcToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignTc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tc", exc);
    }
  }

  /**
   * unassign Tc on GovSteamFV4
   *
   * @param command UnAssignTcFromGovSteamFV4Command
   */
  @PutMapping("/unAssignTc")
  public void unAssignTc(@RequestBody(required = true) UnAssignTcFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignTc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tc", exc);
    }
  }

  /**
   * save Tcm on GovSteamFV4
   *
   * @param command AssignTcmToGovSteamFV4Command
   */
  @PutMapping("/assignTcm")
  public void assignTcm(@RequestBody AssignTcmToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignTcm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tcm", exc);
    }
  }

  /**
   * unassign Tcm on GovSteamFV4
   *
   * @param command UnAssignTcmFromGovSteamFV4Command
   */
  @PutMapping("/unAssignTcm")
  public void unAssignTcm(@RequestBody(required = true) UnAssignTcmFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignTcm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tcm", exc);
    }
  }

  /**
   * save Tdc on GovSteamFV4
   *
   * @param command AssignTdcToGovSteamFV4Command
   */
  @PutMapping("/assignTdc")
  public void assignTdc(@RequestBody AssignTdcToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignTdc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tdc", exc);
    }
  }

  /**
   * unassign Tdc on GovSteamFV4
   *
   * @param command UnAssignTdcFromGovSteamFV4Command
   */
  @PutMapping("/unAssignTdc")
  public void unAssignTdc(@RequestBody(required = true) UnAssignTdcFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignTdc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tdc", exc);
    }
  }

  /**
   * save Tf1 on GovSteamFV4
   *
   * @param command AssignTf1ToGovSteamFV4Command
   */
  @PutMapping("/assignTf1")
  public void assignTf1(@RequestBody AssignTf1ToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignTf1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf1", exc);
    }
  }

  /**
   * unassign Tf1 on GovSteamFV4
   *
   * @param command UnAssignTf1FromGovSteamFV4Command
   */
  @PutMapping("/unAssignTf1")
  public void unAssignTf1(@RequestBody(required = true) UnAssignTf1FromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignTf1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf1", exc);
    }
  }

  /**
   * save Tf2 on GovSteamFV4
   *
   * @param command AssignTf2ToGovSteamFV4Command
   */
  @PutMapping("/assignTf2")
  public void assignTf2(@RequestBody AssignTf2ToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignTf2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tf2", exc);
    }
  }

  /**
   * unassign Tf2 on GovSteamFV4
   *
   * @param command UnAssignTf2FromGovSteamFV4Command
   */
  @PutMapping("/unAssignTf2")
  public void unAssignTf2(@RequestBody(required = true) UnAssignTf2FromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignTf2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tf2", exc);
    }
  }

  /**
   * save Thp on GovSteamFV4
   *
   * @param command AssignThpToGovSteamFV4Command
   */
  @PutMapping("/assignThp")
  public void assignThp(@RequestBody AssignThpToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignThp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Thp", exc);
    }
  }

  /**
   * unassign Thp on GovSteamFV4
   *
   * @param command UnAssignThpFromGovSteamFV4Command
   */
  @PutMapping("/unAssignThp")
  public void unAssignThp(@RequestBody(required = true) UnAssignThpFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignThp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Thp", exc);
    }
  }

  /**
   * save Tmp on GovSteamFV4
   *
   * @param command AssignTmpToGovSteamFV4Command
   */
  @PutMapping("/assignTmp")
  public void assignTmp(@RequestBody AssignTmpToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignTmp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tmp", exc);
    }
  }

  /**
   * unassign Tmp on GovSteamFV4
   *
   * @param command UnAssignTmpFromGovSteamFV4Command
   */
  @PutMapping("/unAssignTmp")
  public void unAssignTmp(@RequestBody(required = true) UnAssignTmpFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignTmp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tmp", exc);
    }
  }

  /**
   * save Trh on GovSteamFV4
   *
   * @param command AssignTrhToGovSteamFV4Command
   */
  @PutMapping("/assignTrh")
  public void assignTrh(@RequestBody AssignTrhToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignTrh(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Trh", exc);
    }
  }

  /**
   * unassign Trh on GovSteamFV4
   *
   * @param command UnAssignTrhFromGovSteamFV4Command
   */
  @PutMapping("/unAssignTrh")
  public void unAssignTrh(@RequestBody(required = true) UnAssignTrhFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignTrh(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Trh", exc);
    }
  }

  /**
   * save Tv on GovSteamFV4
   *
   * @param command AssignTvToGovSteamFV4Command
   */
  @PutMapping("/assignTv")
  public void assignTv(@RequestBody AssignTvToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignTv(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tv", exc);
    }
  }

  /**
   * unassign Tv on GovSteamFV4
   *
   * @param command UnAssignTvFromGovSteamFV4Command
   */
  @PutMapping("/unAssignTv")
  public void unAssignTv(@RequestBody(required = true) UnAssignTvFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignTv(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tv", exc);
    }
  }

  /**
   * save Ty on GovSteamFV4
   *
   * @param command AssignTyToGovSteamFV4Command
   */
  @PutMapping("/assignTy")
  public void assignTy(@RequestBody AssignTyToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignTy(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ty", exc);
    }
  }

  /**
   * unassign Ty on GovSteamFV4
   *
   * @param command UnAssignTyFromGovSteamFV4Command
   */
  @PutMapping("/unAssignTy")
  public void unAssignTy(@RequestBody(required = true) UnAssignTyFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignTy(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ty", exc);
    }
  }

  /**
   * save Y on GovSteamFV4
   *
   * @param command AssignYToGovSteamFV4Command
   */
  @PutMapping("/assignY")
  public void assignY(@RequestBody AssignYToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignY(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Y", exc);
    }
  }

  /**
   * unassign Y on GovSteamFV4
   *
   * @param command UnAssignYFromGovSteamFV4Command
   */
  @PutMapping("/unAssignY")
  public void unAssignY(@RequestBody(required = true) UnAssignYFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignY(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Y", exc);
    }
  }

  /**
   * save Yhpmn on GovSteamFV4
   *
   * @param command AssignYhpmnToGovSteamFV4Command
   */
  @PutMapping("/assignYhpmn")
  public void assignYhpmn(@RequestBody AssignYhpmnToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignYhpmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Yhpmn", exc);
    }
  }

  /**
   * unassign Yhpmn on GovSteamFV4
   *
   * @param command UnAssignYhpmnFromGovSteamFV4Command
   */
  @PutMapping("/unAssignYhpmn")
  public void unAssignYhpmn(
      @RequestBody(required = true) UnAssignYhpmnFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignYhpmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Yhpmn", exc);
    }
  }

  /**
   * save Yhpmx on GovSteamFV4
   *
   * @param command AssignYhpmxToGovSteamFV4Command
   */
  @PutMapping("/assignYhpmx")
  public void assignYhpmx(@RequestBody AssignYhpmxToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignYhpmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Yhpmx", exc);
    }
  }

  /**
   * unassign Yhpmx on GovSteamFV4
   *
   * @param command UnAssignYhpmxFromGovSteamFV4Command
   */
  @PutMapping("/unAssignYhpmx")
  public void unAssignYhpmx(
      @RequestBody(required = true) UnAssignYhpmxFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignYhpmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Yhpmx", exc);
    }
  }

  /**
   * save Ympmn on GovSteamFV4
   *
   * @param command AssignYmpmnToGovSteamFV4Command
   */
  @PutMapping("/assignYmpmn")
  public void assignYmpmn(@RequestBody AssignYmpmnToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignYmpmn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ympmn", exc);
    }
  }

  /**
   * unassign Ympmn on GovSteamFV4
   *
   * @param command UnAssignYmpmnFromGovSteamFV4Command
   */
  @PutMapping("/unAssignYmpmn")
  public void unAssignYmpmn(
      @RequestBody(required = true) UnAssignYmpmnFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignYmpmn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ympmn", exc);
    }
  }

  /**
   * save Ympmx on GovSteamFV4
   *
   * @param command AssignYmpmxToGovSteamFV4Command
   */
  @PutMapping("/assignYmpmx")
  public void assignYmpmx(@RequestBody AssignYmpmxToGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().assignYmpmx(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ympmx", exc);
    }
  }

  /**
   * unassign Ympmx on GovSteamFV4
   *
   * @param command UnAssignYmpmxFromGovSteamFV4Command
   */
  @PutMapping("/unAssignYmpmx")
  public void unAssignYmpmx(
      @RequestBody(required = true) UnAssignYmpmxFromGovSteamFV4Command command) {
    try {
      GovSteamFV4BusinessDelegate.getGovSteamFV4Instance().unAssignYmpmx(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ympmx", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovSteamFV4 govSteamFV4 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovSteamFV4CommandRestController.class.getName());
}
