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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity UnderexcLimIEEE1.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcLimIEEE1")
public class UnderexcLimIEEE1CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a UnderexcLimIEEE1. if not key provided, calls create, otherwise calls save
   *
   * @param UnderexcLimIEEE1 underexcLimIEEE1
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateUnderexcLimIEEE1Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance()
              .createUnderexcLimIEEE1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a UnderexcLimIEEE1. if no key provided, calls create, otherwise calls save
   *
   * @param UnderexcLimIEEE1 underexcLimIEEE1
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateUnderexcLimIEEE1Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateUnderexcLimIEEE1Command
      // -----------------------------------------------
      completableFuture =
          UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance()
              .updateUnderexcLimIEEE1(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "UnderexcLimIEEE1Controller:update() - successfully update UnderexcLimIEEE1 - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a UnderexcLimIEEE1 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID underexcLimIEEE1Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteUnderexcLimIEEE1Command command = new DeleteUnderexcLimIEEE1Command(underexcLimIEEE1Id);

    try {
      UnderexcLimIEEE1BusinessDelegate delegate =
          UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted UnderexcLimIEEE1 with key " + command.getUnderexcLimIEEE1Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Kuc on UnderexcLimIEEE1
   *
   * @param command AssignKucToUnderexcLimIEEE1Command
   */
  @PutMapping("/assignKuc")
  public void assignKuc(@RequestBody AssignKucToUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().assignKuc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kuc", exc);
    }
  }

  /**
   * unassign Kuc on UnderexcLimIEEE1
   *
   * @param command UnAssignKucFromUnderexcLimIEEE1Command
   */
  @PutMapping("/unAssignKuc")
  public void unAssignKuc(
      @RequestBody(required = true) UnAssignKucFromUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().unAssignKuc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kuc", exc);
    }
  }

  /**
   * save Kuf on UnderexcLimIEEE1
   *
   * @param command AssignKufToUnderexcLimIEEE1Command
   */
  @PutMapping("/assignKuf")
  public void assignKuf(@RequestBody AssignKufToUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().assignKuf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kuf", exc);
    }
  }

  /**
   * unassign Kuf on UnderexcLimIEEE1
   *
   * @param command UnAssignKufFromUnderexcLimIEEE1Command
   */
  @PutMapping("/unAssignKuf")
  public void unAssignKuf(
      @RequestBody(required = true) UnAssignKufFromUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().unAssignKuf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kuf", exc);
    }
  }

  /**
   * save Kui on UnderexcLimIEEE1
   *
   * @param command AssignKuiToUnderexcLimIEEE1Command
   */
  @PutMapping("/assignKui")
  public void assignKui(@RequestBody AssignKuiToUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().assignKui(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kui", exc);
    }
  }

  /**
   * unassign Kui on UnderexcLimIEEE1
   *
   * @param command UnAssignKuiFromUnderexcLimIEEE1Command
   */
  @PutMapping("/unAssignKui")
  public void unAssignKui(
      @RequestBody(required = true) UnAssignKuiFromUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().unAssignKui(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kui", exc);
    }
  }

  /**
   * save Kul on UnderexcLimIEEE1
   *
   * @param command AssignKulToUnderexcLimIEEE1Command
   */
  @PutMapping("/assignKul")
  public void assignKul(@RequestBody AssignKulToUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().assignKul(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kul", exc);
    }
  }

  /**
   * unassign Kul on UnderexcLimIEEE1
   *
   * @param command UnAssignKulFromUnderexcLimIEEE1Command
   */
  @PutMapping("/unAssignKul")
  public void unAssignKul(
      @RequestBody(required = true) UnAssignKulFromUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().unAssignKul(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kul", exc);
    }
  }

  /**
   * save Kur on UnderexcLimIEEE1
   *
   * @param command AssignKurToUnderexcLimIEEE1Command
   */
  @PutMapping("/assignKur")
  public void assignKur(@RequestBody AssignKurToUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().assignKur(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kur", exc);
    }
  }

  /**
   * unassign Kur on UnderexcLimIEEE1
   *
   * @param command UnAssignKurFromUnderexcLimIEEE1Command
   */
  @PutMapping("/unAssignKur")
  public void unAssignKur(
      @RequestBody(required = true) UnAssignKurFromUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().unAssignKur(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kur", exc);
    }
  }

  /**
   * save Tu1 on UnderexcLimIEEE1
   *
   * @param command AssignTu1ToUnderexcLimIEEE1Command
   */
  @PutMapping("/assignTu1")
  public void assignTu1(@RequestBody AssignTu1ToUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().assignTu1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tu1", exc);
    }
  }

  /**
   * unassign Tu1 on UnderexcLimIEEE1
   *
   * @param command UnAssignTu1FromUnderexcLimIEEE1Command
   */
  @PutMapping("/unAssignTu1")
  public void unAssignTu1(
      @RequestBody(required = true) UnAssignTu1FromUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().unAssignTu1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tu1", exc);
    }
  }

  /**
   * save Tu2 on UnderexcLimIEEE1
   *
   * @param command AssignTu2ToUnderexcLimIEEE1Command
   */
  @PutMapping("/assignTu2")
  public void assignTu2(@RequestBody AssignTu2ToUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().assignTu2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tu2", exc);
    }
  }

  /**
   * unassign Tu2 on UnderexcLimIEEE1
   *
   * @param command UnAssignTu2FromUnderexcLimIEEE1Command
   */
  @PutMapping("/unAssignTu2")
  public void unAssignTu2(
      @RequestBody(required = true) UnAssignTu2FromUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().unAssignTu2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tu2", exc);
    }
  }

  /**
   * save Tu3 on UnderexcLimIEEE1
   *
   * @param command AssignTu3ToUnderexcLimIEEE1Command
   */
  @PutMapping("/assignTu3")
  public void assignTu3(@RequestBody AssignTu3ToUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().assignTu3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tu3", exc);
    }
  }

  /**
   * unassign Tu3 on UnderexcLimIEEE1
   *
   * @param command UnAssignTu3FromUnderexcLimIEEE1Command
   */
  @PutMapping("/unAssignTu3")
  public void unAssignTu3(
      @RequestBody(required = true) UnAssignTu3FromUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().unAssignTu3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tu3", exc);
    }
  }

  /**
   * save Tu4 on UnderexcLimIEEE1
   *
   * @param command AssignTu4ToUnderexcLimIEEE1Command
   */
  @PutMapping("/assignTu4")
  public void assignTu4(@RequestBody AssignTu4ToUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().assignTu4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tu4", exc);
    }
  }

  /**
   * unassign Tu4 on UnderexcLimIEEE1
   *
   * @param command UnAssignTu4FromUnderexcLimIEEE1Command
   */
  @PutMapping("/unAssignTu4")
  public void unAssignTu4(
      @RequestBody(required = true) UnAssignTu4FromUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().unAssignTu4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tu4", exc);
    }
  }

  /**
   * save Vucmax on UnderexcLimIEEE1
   *
   * @param command AssignVucmaxToUnderexcLimIEEE1Command
   */
  @PutMapping("/assignVucmax")
  public void assignVucmax(@RequestBody AssignVucmaxToUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().assignVucmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vucmax", exc);
    }
  }

  /**
   * unassign Vucmax on UnderexcLimIEEE1
   *
   * @param command UnAssignVucmaxFromUnderexcLimIEEE1Command
   */
  @PutMapping("/unAssignVucmax")
  public void unAssignVucmax(
      @RequestBody(required = true) UnAssignVucmaxFromUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().unAssignVucmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vucmax", exc);
    }
  }

  /**
   * save Vuimax on UnderexcLimIEEE1
   *
   * @param command AssignVuimaxToUnderexcLimIEEE1Command
   */
  @PutMapping("/assignVuimax")
  public void assignVuimax(@RequestBody AssignVuimaxToUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().assignVuimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vuimax", exc);
    }
  }

  /**
   * unassign Vuimax on UnderexcLimIEEE1
   *
   * @param command UnAssignVuimaxFromUnderexcLimIEEE1Command
   */
  @PutMapping("/unAssignVuimax")
  public void unAssignVuimax(
      @RequestBody(required = true) UnAssignVuimaxFromUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().unAssignVuimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vuimax", exc);
    }
  }

  /**
   * save Vuimin on UnderexcLimIEEE1
   *
   * @param command AssignVuiminToUnderexcLimIEEE1Command
   */
  @PutMapping("/assignVuimin")
  public void assignVuimin(@RequestBody AssignVuiminToUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().assignVuimin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vuimin", exc);
    }
  }

  /**
   * unassign Vuimin on UnderexcLimIEEE1
   *
   * @param command UnAssignVuiminFromUnderexcLimIEEE1Command
   */
  @PutMapping("/unAssignVuimin")
  public void unAssignVuimin(
      @RequestBody(required = true) UnAssignVuiminFromUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().unAssignVuimin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vuimin", exc);
    }
  }

  /**
   * save Vulmax on UnderexcLimIEEE1
   *
   * @param command AssignVulmaxToUnderexcLimIEEE1Command
   */
  @PutMapping("/assignVulmax")
  public void assignVulmax(@RequestBody AssignVulmaxToUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().assignVulmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vulmax", exc);
    }
  }

  /**
   * unassign Vulmax on UnderexcLimIEEE1
   *
   * @param command UnAssignVulmaxFromUnderexcLimIEEE1Command
   */
  @PutMapping("/unAssignVulmax")
  public void unAssignVulmax(
      @RequestBody(required = true) UnAssignVulmaxFromUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().unAssignVulmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vulmax", exc);
    }
  }

  /**
   * save Vulmin on UnderexcLimIEEE1
   *
   * @param command AssignVulminToUnderexcLimIEEE1Command
   */
  @PutMapping("/assignVulmin")
  public void assignVulmin(@RequestBody AssignVulminToUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().assignVulmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vulmin", exc);
    }
  }

  /**
   * unassign Vulmin on UnderexcLimIEEE1
   *
   * @param command UnAssignVulminFromUnderexcLimIEEE1Command
   */
  @PutMapping("/unAssignVulmin")
  public void unAssignVulmin(
      @RequestBody(required = true) UnAssignVulminFromUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().unAssignVulmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vulmin", exc);
    }
  }

  /**
   * save Vurmax on UnderexcLimIEEE1
   *
   * @param command AssignVurmaxToUnderexcLimIEEE1Command
   */
  @PutMapping("/assignVurmax")
  public void assignVurmax(@RequestBody AssignVurmaxToUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().assignVurmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vurmax", exc);
    }
  }

  /**
   * unassign Vurmax on UnderexcLimIEEE1
   *
   * @param command UnAssignVurmaxFromUnderexcLimIEEE1Command
   */
  @PutMapping("/unAssignVurmax")
  public void unAssignVurmax(
      @RequestBody(required = true) UnAssignVurmaxFromUnderexcLimIEEE1Command command) {
    try {
      UnderexcLimIEEE1BusinessDelegate.getUnderexcLimIEEE1Instance().unAssignVurmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vurmax", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected UnderexcLimIEEE1 underexcLimIEEE1 = null;
  private static final Logger LOGGER =
      Logger.getLogger(UnderexcLimIEEE1CommandRestController.class.getName());
}
