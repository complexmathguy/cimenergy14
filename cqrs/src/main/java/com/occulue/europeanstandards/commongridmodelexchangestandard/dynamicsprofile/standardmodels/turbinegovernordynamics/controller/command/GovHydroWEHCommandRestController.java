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
 * Implements Spring Controller command CQRS processing for entity GovHydroWEH.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroWEH")
public class GovHydroWEHCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a GovHydroWEH. if not key provided, calls create, otherwise calls save
   *
   * @param GovHydroWEH govHydroWEH
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateGovHydroWEHCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().createGovHydroWEH(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a GovHydroWEH. if no key provided, calls create, otherwise calls save
   *
   * @param GovHydroWEH govHydroWEH
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateGovHydroWEHCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateGovHydroWEHCommand
      // -----------------------------------------------
      completableFuture =
          GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().updateGovHydroWEH(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "GovHydroWEHController:update() - successfully update GovHydroWEH - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a GovHydroWEH entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID govHydroWEHId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteGovHydroWEHCommand command = new DeleteGovHydroWEHCommand(govHydroWEHId);

    try {
      GovHydroWEHBusinessDelegate delegate = GovHydroWEHBusinessDelegate.getGovHydroWEHInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted GovHydroWEH with key " + command.getGovHydroWEHId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Db on GovHydroWEH
   *
   * @param command AssignDbToGovHydroWEHCommand
   */
  @PutMapping("/assignDb")
  public void assignDb(@RequestBody AssignDbToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignDb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Db", exc);
    }
  }

  /**
   * unassign Db on GovHydroWEH
   *
   * @param command UnAssignDbFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignDb")
  public void unAssignDb(@RequestBody(required = true) UnAssignDbFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignDb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Db", exc);
    }
  }

  /**
   * save Dicn on GovHydroWEH
   *
   * @param command AssignDicnToGovHydroWEHCommand
   */
  @PutMapping("/assignDicn")
  public void assignDicn(@RequestBody AssignDicnToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignDicn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dicn", exc);
    }
  }

  /**
   * unassign Dicn on GovHydroWEH
   *
   * @param command UnAssignDicnFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignDicn")
  public void unAssignDicn(
      @RequestBody(required = true) UnAssignDicnFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignDicn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dicn", exc);
    }
  }

  /**
   * save Dpv on GovHydroWEH
   *
   * @param command AssignDpvToGovHydroWEHCommand
   */
  @PutMapping("/assignDpv")
  public void assignDpv(@RequestBody AssignDpvToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignDpv(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dpv", exc);
    }
  }

  /**
   * unassign Dpv on GovHydroWEH
   *
   * @param command UnAssignDpvFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignDpv")
  public void unAssignDpv(@RequestBody(required = true) UnAssignDpvFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignDpv(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dpv", exc);
    }
  }

  /**
   * save Dturb on GovHydroWEH
   *
   * @param command AssignDturbToGovHydroWEHCommand
   */
  @PutMapping("/assignDturb")
  public void assignDturb(@RequestBody AssignDturbToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignDturb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Dturb", exc);
    }
  }

  /**
   * unassign Dturb on GovHydroWEH
   *
   * @param command UnAssignDturbFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignDturb")
  public void unAssignDturb(
      @RequestBody(required = true) UnAssignDturbFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignDturb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Dturb", exc);
    }
  }

  /**
   * save FeedbackSignal on GovHydroWEH
   *
   * @param command AssignFeedbackSignalToGovHydroWEHCommand
   */
  @PutMapping("/assignFeedbackSignal")
  public void assignFeedbackSignal(@RequestBody AssignFeedbackSignalToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFeedbackSignal(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign FeedbackSignal", exc);
    }
  }

  /**
   * unassign FeedbackSignal on GovHydroWEH
   *
   * @param command UnAssignFeedbackSignalFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFeedbackSignal")
  public void unAssignFeedbackSignal(
      @RequestBody(required = true) UnAssignFeedbackSignalFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFeedbackSignal(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign FeedbackSignal", exc);
    }
  }

  /**
   * save Fl1 on GovHydroWEH
   *
   * @param command AssignFl1ToGovHydroWEHCommand
   */
  @PutMapping("/assignFl1")
  public void assignFl1(@RequestBody AssignFl1ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFl1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fl1", exc);
    }
  }

  /**
   * unassign Fl1 on GovHydroWEH
   *
   * @param command UnAssignFl1FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFl1")
  public void unAssignFl1(@RequestBody(required = true) UnAssignFl1FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFl1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fl1", exc);
    }
  }

  /**
   * save Fl2 on GovHydroWEH
   *
   * @param command AssignFl2ToGovHydroWEHCommand
   */
  @PutMapping("/assignFl2")
  public void assignFl2(@RequestBody AssignFl2ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFl2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fl2", exc);
    }
  }

  /**
   * unassign Fl2 on GovHydroWEH
   *
   * @param command UnAssignFl2FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFl2")
  public void unAssignFl2(@RequestBody(required = true) UnAssignFl2FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFl2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fl2", exc);
    }
  }

  /**
   * save Fl3 on GovHydroWEH
   *
   * @param command AssignFl3ToGovHydroWEHCommand
   */
  @PutMapping("/assignFl3")
  public void assignFl3(@RequestBody AssignFl3ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFl3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fl3", exc);
    }
  }

  /**
   * unassign Fl3 on GovHydroWEH
   *
   * @param command UnAssignFl3FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFl3")
  public void unAssignFl3(@RequestBody(required = true) UnAssignFl3FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFl3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fl3", exc);
    }
  }

  /**
   * save Fl4 on GovHydroWEH
   *
   * @param command AssignFl4ToGovHydroWEHCommand
   */
  @PutMapping("/assignFl4")
  public void assignFl4(@RequestBody AssignFl4ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFl4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fl4", exc);
    }
  }

  /**
   * unassign Fl4 on GovHydroWEH
   *
   * @param command UnAssignFl4FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFl4")
  public void unAssignFl4(@RequestBody(required = true) UnAssignFl4FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFl4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fl4", exc);
    }
  }

  /**
   * save Fl5 on GovHydroWEH
   *
   * @param command AssignFl5ToGovHydroWEHCommand
   */
  @PutMapping("/assignFl5")
  public void assignFl5(@RequestBody AssignFl5ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFl5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fl5", exc);
    }
  }

  /**
   * unassign Fl5 on GovHydroWEH
   *
   * @param command UnAssignFl5FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFl5")
  public void unAssignFl5(@RequestBody(required = true) UnAssignFl5FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFl5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fl5", exc);
    }
  }

  /**
   * save Fp1 on GovHydroWEH
   *
   * @param command AssignFp1ToGovHydroWEHCommand
   */
  @PutMapping("/assignFp1")
  public void assignFp1(@RequestBody AssignFp1ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFp1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fp1", exc);
    }
  }

  /**
   * unassign Fp1 on GovHydroWEH
   *
   * @param command UnAssignFp1FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFp1")
  public void unAssignFp1(@RequestBody(required = true) UnAssignFp1FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFp1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fp1", exc);
    }
  }

  /**
   * save Fp10 on GovHydroWEH
   *
   * @param command AssignFp10ToGovHydroWEHCommand
   */
  @PutMapping("/assignFp10")
  public void assignFp10(@RequestBody AssignFp10ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFp10(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fp10", exc);
    }
  }

  /**
   * unassign Fp10 on GovHydroWEH
   *
   * @param command UnAssignFp10FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFp10")
  public void unAssignFp10(
      @RequestBody(required = true) UnAssignFp10FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFp10(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fp10", exc);
    }
  }

  /**
   * save Fp2 on GovHydroWEH
   *
   * @param command AssignFp2ToGovHydroWEHCommand
   */
  @PutMapping("/assignFp2")
  public void assignFp2(@RequestBody AssignFp2ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFp2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fp2", exc);
    }
  }

  /**
   * unassign Fp2 on GovHydroWEH
   *
   * @param command UnAssignFp2FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFp2")
  public void unAssignFp2(@RequestBody(required = true) UnAssignFp2FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFp2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fp2", exc);
    }
  }

  /**
   * save Fp3 on GovHydroWEH
   *
   * @param command AssignFp3ToGovHydroWEHCommand
   */
  @PutMapping("/assignFp3")
  public void assignFp3(@RequestBody AssignFp3ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFp3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fp3", exc);
    }
  }

  /**
   * unassign Fp3 on GovHydroWEH
   *
   * @param command UnAssignFp3FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFp3")
  public void unAssignFp3(@RequestBody(required = true) UnAssignFp3FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFp3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fp3", exc);
    }
  }

  /**
   * save Fp4 on GovHydroWEH
   *
   * @param command AssignFp4ToGovHydroWEHCommand
   */
  @PutMapping("/assignFp4")
  public void assignFp4(@RequestBody AssignFp4ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFp4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fp4", exc);
    }
  }

  /**
   * unassign Fp4 on GovHydroWEH
   *
   * @param command UnAssignFp4FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFp4")
  public void unAssignFp4(@RequestBody(required = true) UnAssignFp4FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFp4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fp4", exc);
    }
  }

  /**
   * save Fp5 on GovHydroWEH
   *
   * @param command AssignFp5ToGovHydroWEHCommand
   */
  @PutMapping("/assignFp5")
  public void assignFp5(@RequestBody AssignFp5ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFp5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fp5", exc);
    }
  }

  /**
   * unassign Fp5 on GovHydroWEH
   *
   * @param command UnAssignFp5FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFp5")
  public void unAssignFp5(@RequestBody(required = true) UnAssignFp5FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFp5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fp5", exc);
    }
  }

  /**
   * save Fp6 on GovHydroWEH
   *
   * @param command AssignFp6ToGovHydroWEHCommand
   */
  @PutMapping("/assignFp6")
  public void assignFp6(@RequestBody AssignFp6ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFp6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fp6", exc);
    }
  }

  /**
   * unassign Fp6 on GovHydroWEH
   *
   * @param command UnAssignFp6FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFp6")
  public void unAssignFp6(@RequestBody(required = true) UnAssignFp6FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFp6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fp6", exc);
    }
  }

  /**
   * save Fp7 on GovHydroWEH
   *
   * @param command AssignFp7ToGovHydroWEHCommand
   */
  @PutMapping("/assignFp7")
  public void assignFp7(@RequestBody AssignFp7ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFp7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fp7", exc);
    }
  }

  /**
   * unassign Fp7 on GovHydroWEH
   *
   * @param command UnAssignFp7FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFp7")
  public void unAssignFp7(@RequestBody(required = true) UnAssignFp7FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFp7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fp7", exc);
    }
  }

  /**
   * save Fp8 on GovHydroWEH
   *
   * @param command AssignFp8ToGovHydroWEHCommand
   */
  @PutMapping("/assignFp8")
  public void assignFp8(@RequestBody AssignFp8ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFp8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fp8", exc);
    }
  }

  /**
   * unassign Fp8 on GovHydroWEH
   *
   * @param command UnAssignFp8FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFp8")
  public void unAssignFp8(@RequestBody(required = true) UnAssignFp8FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFp8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fp8", exc);
    }
  }

  /**
   * save Fp9 on GovHydroWEH
   *
   * @param command AssignFp9ToGovHydroWEHCommand
   */
  @PutMapping("/assignFp9")
  public void assignFp9(@RequestBody AssignFp9ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignFp9(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Fp9", exc);
    }
  }

  /**
   * unassign Fp9 on GovHydroWEH
   *
   * @param command UnAssignFp9FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignFp9")
  public void unAssignFp9(@RequestBody(required = true) UnAssignFp9FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignFp9(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Fp9", exc);
    }
  }

  /**
   * save Gmax on GovHydroWEH
   *
   * @param command AssignGmaxToGovHydroWEHCommand
   */
  @PutMapping("/assignGmax")
  public void assignGmax(@RequestBody AssignGmaxToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignGmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gmax", exc);
    }
  }

  /**
   * unassign Gmax on GovHydroWEH
   *
   * @param command UnAssignGmaxFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignGmax")
  public void unAssignGmax(
      @RequestBody(required = true) UnAssignGmaxFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignGmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gmax", exc);
    }
  }

  /**
   * save Gmin on GovHydroWEH
   *
   * @param command AssignGminToGovHydroWEHCommand
   */
  @PutMapping("/assignGmin")
  public void assignGmin(@RequestBody AssignGminToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignGmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gmin", exc);
    }
  }

  /**
   * unassign Gmin on GovHydroWEH
   *
   * @param command UnAssignGminFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignGmin")
  public void unAssignGmin(
      @RequestBody(required = true) UnAssignGminFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignGmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gmin", exc);
    }
  }

  /**
   * save Gtmxcl on GovHydroWEH
   *
   * @param command AssignGtmxclToGovHydroWEHCommand
   */
  @PutMapping("/assignGtmxcl")
  public void assignGtmxcl(@RequestBody AssignGtmxclToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignGtmxcl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gtmxcl", exc);
    }
  }

  /**
   * unassign Gtmxcl on GovHydroWEH
   *
   * @param command UnAssignGtmxclFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignGtmxcl")
  public void unAssignGtmxcl(
      @RequestBody(required = true) UnAssignGtmxclFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignGtmxcl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gtmxcl", exc);
    }
  }

  /**
   * save Gtmxop on GovHydroWEH
   *
   * @param command AssignGtmxopToGovHydroWEHCommand
   */
  @PutMapping("/assignGtmxop")
  public void assignGtmxop(@RequestBody AssignGtmxopToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignGtmxop(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gtmxop", exc);
    }
  }

  /**
   * unassign Gtmxop on GovHydroWEH
   *
   * @param command UnAssignGtmxopFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignGtmxop")
  public void unAssignGtmxop(
      @RequestBody(required = true) UnAssignGtmxopFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignGtmxop(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gtmxop", exc);
    }
  }

  /**
   * save Gv1 on GovHydroWEH
   *
   * @param command AssignGv1ToGovHydroWEHCommand
   */
  @PutMapping("/assignGv1")
  public void assignGv1(@RequestBody AssignGv1ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignGv1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv1", exc);
    }
  }

  /**
   * unassign Gv1 on GovHydroWEH
   *
   * @param command UnAssignGv1FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignGv1")
  public void unAssignGv1(@RequestBody(required = true) UnAssignGv1FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignGv1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv1", exc);
    }
  }

  /**
   * save Gv2 on GovHydroWEH
   *
   * @param command AssignGv2ToGovHydroWEHCommand
   */
  @PutMapping("/assignGv2")
  public void assignGv2(@RequestBody AssignGv2ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignGv2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv2", exc);
    }
  }

  /**
   * unassign Gv2 on GovHydroWEH
   *
   * @param command UnAssignGv2FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignGv2")
  public void unAssignGv2(@RequestBody(required = true) UnAssignGv2FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignGv2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv2", exc);
    }
  }

  /**
   * save Gv3 on GovHydroWEH
   *
   * @param command AssignGv3ToGovHydroWEHCommand
   */
  @PutMapping("/assignGv3")
  public void assignGv3(@RequestBody AssignGv3ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignGv3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv3", exc);
    }
  }

  /**
   * unassign Gv3 on GovHydroWEH
   *
   * @param command UnAssignGv3FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignGv3")
  public void unAssignGv3(@RequestBody(required = true) UnAssignGv3FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignGv3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv3", exc);
    }
  }

  /**
   * save Gv4 on GovHydroWEH
   *
   * @param command AssignGv4ToGovHydroWEHCommand
   */
  @PutMapping("/assignGv4")
  public void assignGv4(@RequestBody AssignGv4ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignGv4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv4", exc);
    }
  }

  /**
   * unassign Gv4 on GovHydroWEH
   *
   * @param command UnAssignGv4FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignGv4")
  public void unAssignGv4(@RequestBody(required = true) UnAssignGv4FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignGv4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv4", exc);
    }
  }

  /**
   * save Gv5 on GovHydroWEH
   *
   * @param command AssignGv5ToGovHydroWEHCommand
   */
  @PutMapping("/assignGv5")
  public void assignGv5(@RequestBody AssignGv5ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignGv5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Gv5", exc);
    }
  }

  /**
   * unassign Gv5 on GovHydroWEH
   *
   * @param command UnAssignGv5FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignGv5")
  public void unAssignGv5(@RequestBody(required = true) UnAssignGv5FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignGv5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Gv5", exc);
    }
  }

  /**
   * save Kd on GovHydroWEH
   *
   * @param command AssignKdToGovHydroWEHCommand
   */
  @PutMapping("/assignKd")
  public void assignKd(@RequestBody AssignKdToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignKd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kd", exc);
    }
  }

  /**
   * unassign Kd on GovHydroWEH
   *
   * @param command UnAssignKdFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignKd")
  public void unAssignKd(@RequestBody(required = true) UnAssignKdFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignKd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kd", exc);
    }
  }

  /**
   * save Ki on GovHydroWEH
   *
   * @param command AssignKiToGovHydroWEHCommand
   */
  @PutMapping("/assignKi")
  public void assignKi(@RequestBody AssignKiToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignKi(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ki", exc);
    }
  }

  /**
   * unassign Ki on GovHydroWEH
   *
   * @param command UnAssignKiFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignKi")
  public void unAssignKi(@RequestBody(required = true) UnAssignKiFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignKi(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ki", exc);
    }
  }

  /**
   * save Kp on GovHydroWEH
   *
   * @param command AssignKpToGovHydroWEHCommand
   */
  @PutMapping("/assignKp")
  public void assignKp(@RequestBody AssignKpToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignKp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kp", exc);
    }
  }

  /**
   * unassign Kp on GovHydroWEH
   *
   * @param command UnAssignKpFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignKp")
  public void unAssignKp(@RequestBody(required = true) UnAssignKpFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignKp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kp", exc);
    }
  }

  /**
   * save Mwbase on GovHydroWEH
   *
   * @param command AssignMwbaseToGovHydroWEHCommand
   */
  @PutMapping("/assignMwbase")
  public void assignMwbase(@RequestBody AssignMwbaseToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignMwbase(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Mwbase", exc);
    }
  }

  /**
   * unassign Mwbase on GovHydroWEH
   *
   * @param command UnAssignMwbaseFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignMwbase")
  public void unAssignMwbase(
      @RequestBody(required = true) UnAssignMwbaseFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignMwbase(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Mwbase", exc);
    }
  }

  /**
   * save Pmss1 on GovHydroWEH
   *
   * @param command AssignPmss1ToGovHydroWEHCommand
   */
  @PutMapping("/assignPmss1")
  public void assignPmss1(@RequestBody AssignPmss1ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignPmss1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmss1", exc);
    }
  }

  /**
   * unassign Pmss1 on GovHydroWEH
   *
   * @param command UnAssignPmss1FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignPmss1")
  public void unAssignPmss1(
      @RequestBody(required = true) UnAssignPmss1FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignPmss1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmss1", exc);
    }
  }

  /**
   * save Pmss10 on GovHydroWEH
   *
   * @param command AssignPmss10ToGovHydroWEHCommand
   */
  @PutMapping("/assignPmss10")
  public void assignPmss10(@RequestBody AssignPmss10ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignPmss10(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmss10", exc);
    }
  }

  /**
   * unassign Pmss10 on GovHydroWEH
   *
   * @param command UnAssignPmss10FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignPmss10")
  public void unAssignPmss10(
      @RequestBody(required = true) UnAssignPmss10FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignPmss10(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmss10", exc);
    }
  }

  /**
   * save Pmss2 on GovHydroWEH
   *
   * @param command AssignPmss2ToGovHydroWEHCommand
   */
  @PutMapping("/assignPmss2")
  public void assignPmss2(@RequestBody AssignPmss2ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignPmss2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmss2", exc);
    }
  }

  /**
   * unassign Pmss2 on GovHydroWEH
   *
   * @param command UnAssignPmss2FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignPmss2")
  public void unAssignPmss2(
      @RequestBody(required = true) UnAssignPmss2FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignPmss2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmss2", exc);
    }
  }

  /**
   * save Pmss3 on GovHydroWEH
   *
   * @param command AssignPmss3ToGovHydroWEHCommand
   */
  @PutMapping("/assignPmss3")
  public void assignPmss3(@RequestBody AssignPmss3ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignPmss3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmss3", exc);
    }
  }

  /**
   * unassign Pmss3 on GovHydroWEH
   *
   * @param command UnAssignPmss3FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignPmss3")
  public void unAssignPmss3(
      @RequestBody(required = true) UnAssignPmss3FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignPmss3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmss3", exc);
    }
  }

  /**
   * save Pmss4 on GovHydroWEH
   *
   * @param command AssignPmss4ToGovHydroWEHCommand
   */
  @PutMapping("/assignPmss4")
  public void assignPmss4(@RequestBody AssignPmss4ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignPmss4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmss4", exc);
    }
  }

  /**
   * unassign Pmss4 on GovHydroWEH
   *
   * @param command UnAssignPmss4FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignPmss4")
  public void unAssignPmss4(
      @RequestBody(required = true) UnAssignPmss4FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignPmss4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmss4", exc);
    }
  }

  /**
   * save Pmss5 on GovHydroWEH
   *
   * @param command AssignPmss5ToGovHydroWEHCommand
   */
  @PutMapping("/assignPmss5")
  public void assignPmss5(@RequestBody AssignPmss5ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignPmss5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmss5", exc);
    }
  }

  /**
   * unassign Pmss5 on GovHydroWEH
   *
   * @param command UnAssignPmss5FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignPmss5")
  public void unAssignPmss5(
      @RequestBody(required = true) UnAssignPmss5FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignPmss5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmss5", exc);
    }
  }

  /**
   * save Pmss6 on GovHydroWEH
   *
   * @param command AssignPmss6ToGovHydroWEHCommand
   */
  @PutMapping("/assignPmss6")
  public void assignPmss6(@RequestBody AssignPmss6ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignPmss6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmss6", exc);
    }
  }

  /**
   * unassign Pmss6 on GovHydroWEH
   *
   * @param command UnAssignPmss6FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignPmss6")
  public void unAssignPmss6(
      @RequestBody(required = true) UnAssignPmss6FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignPmss6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmss6", exc);
    }
  }

  /**
   * save Pmss7 on GovHydroWEH
   *
   * @param command AssignPmss7ToGovHydroWEHCommand
   */
  @PutMapping("/assignPmss7")
  public void assignPmss7(@RequestBody AssignPmss7ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignPmss7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmss7", exc);
    }
  }

  /**
   * unassign Pmss7 on GovHydroWEH
   *
   * @param command UnAssignPmss7FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignPmss7")
  public void unAssignPmss7(
      @RequestBody(required = true) UnAssignPmss7FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignPmss7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmss7", exc);
    }
  }

  /**
   * save Pmss8 on GovHydroWEH
   *
   * @param command AssignPmss8ToGovHydroWEHCommand
   */
  @PutMapping("/assignPmss8")
  public void assignPmss8(@RequestBody AssignPmss8ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignPmss8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmss8", exc);
    }
  }

  /**
   * unassign Pmss8 on GovHydroWEH
   *
   * @param command UnAssignPmss8FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignPmss8")
  public void unAssignPmss8(
      @RequestBody(required = true) UnAssignPmss8FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignPmss8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmss8", exc);
    }
  }

  /**
   * save Pmss9 on GovHydroWEH
   *
   * @param command AssignPmss9ToGovHydroWEHCommand
   */
  @PutMapping("/assignPmss9")
  public void assignPmss9(@RequestBody AssignPmss9ToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignPmss9(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Pmss9", exc);
    }
  }

  /**
   * unassign Pmss9 on GovHydroWEH
   *
   * @param command UnAssignPmss9FromGovHydroWEHCommand
   */
  @PutMapping("/unAssignPmss9")
  public void unAssignPmss9(
      @RequestBody(required = true) UnAssignPmss9FromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignPmss9(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Pmss9", exc);
    }
  }

  /**
   * save Rpg on GovHydroWEH
   *
   * @param command AssignRpgToGovHydroWEHCommand
   */
  @PutMapping("/assignRpg")
  public void assignRpg(@RequestBody AssignRpgToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignRpg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rpg", exc);
    }
  }

  /**
   * unassign Rpg on GovHydroWEH
   *
   * @param command UnAssignRpgFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignRpg")
  public void unAssignRpg(@RequestBody(required = true) UnAssignRpgFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignRpg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rpg", exc);
    }
  }

  /**
   * save Rpp on GovHydroWEH
   *
   * @param command AssignRppToGovHydroWEHCommand
   */
  @PutMapping("/assignRpp")
  public void assignRpp(@RequestBody AssignRppToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignRpp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Rpp", exc);
    }
  }

  /**
   * unassign Rpp on GovHydroWEH
   *
   * @param command UnAssignRppFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignRpp")
  public void unAssignRpp(@RequestBody(required = true) UnAssignRppFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignRpp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Rpp", exc);
    }
  }

  /**
   * save Td on GovHydroWEH
   *
   * @param command AssignTdToGovHydroWEHCommand
   */
  @PutMapping("/assignTd")
  public void assignTd(@RequestBody AssignTdToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignTd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Td", exc);
    }
  }

  /**
   * unassign Td on GovHydroWEH
   *
   * @param command UnAssignTdFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignTd")
  public void unAssignTd(@RequestBody(required = true) UnAssignTdFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignTd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Td", exc);
    }
  }

  /**
   * save Tdv on GovHydroWEH
   *
   * @param command AssignTdvToGovHydroWEHCommand
   */
  @PutMapping("/assignTdv")
  public void assignTdv(@RequestBody AssignTdvToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignTdv(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tdv", exc);
    }
  }

  /**
   * unassign Tdv on GovHydroWEH
   *
   * @param command UnAssignTdvFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignTdv")
  public void unAssignTdv(@RequestBody(required = true) UnAssignTdvFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignTdv(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tdv", exc);
    }
  }

  /**
   * save Tg on GovHydroWEH
   *
   * @param command AssignTgToGovHydroWEHCommand
   */
  @PutMapping("/assignTg")
  public void assignTg(@RequestBody AssignTgToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignTg(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tg", exc);
    }
  }

  /**
   * unassign Tg on GovHydroWEH
   *
   * @param command UnAssignTgFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignTg")
  public void unAssignTg(@RequestBody(required = true) UnAssignTgFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignTg(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tg", exc);
    }
  }

  /**
   * save Tp on GovHydroWEH
   *
   * @param command AssignTpToGovHydroWEHCommand
   */
  @PutMapping("/assignTp")
  public void assignTp(@RequestBody AssignTpToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignTp(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tp", exc);
    }
  }

  /**
   * unassign Tp on GovHydroWEH
   *
   * @param command UnAssignTpFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignTp")
  public void unAssignTp(@RequestBody(required = true) UnAssignTpFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignTp(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tp", exc);
    }
  }

  /**
   * save Tpe on GovHydroWEH
   *
   * @param command AssignTpeToGovHydroWEHCommand
   */
  @PutMapping("/assignTpe")
  public void assignTpe(@RequestBody AssignTpeToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignTpe(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tpe", exc);
    }
  }

  /**
   * unassign Tpe on GovHydroWEH
   *
   * @param command UnAssignTpeFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignTpe")
  public void unAssignTpe(@RequestBody(required = true) UnAssignTpeFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignTpe(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tpe", exc);
    }
  }

  /**
   * save Tw on GovHydroWEH
   *
   * @param command AssignTwToGovHydroWEHCommand
   */
  @PutMapping("/assignTw")
  public void assignTw(@RequestBody AssignTwToGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().assignTw(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw", exc);
    }
  }

  /**
   * unassign Tw on GovHydroWEH
   *
   * @param command UnAssignTwFromGovHydroWEHCommand
   */
  @PutMapping("/unAssignTw")
  public void unAssignTw(@RequestBody(required = true) UnAssignTwFromGovHydroWEHCommand command) {
    try {
      GovHydroWEHBusinessDelegate.getGovHydroWEHInstance().unAssignTw(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydroWEH govHydroWEH = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroWEHCommandRestController.class.getName());
}
