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
 * Implements Spring Controller command CQRS processing for entity UnderexcLimIEEE2.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/UnderexcLimIEEE2")
public class UnderexcLimIEEE2CommandRestController extends BaseSpringRestController {

  /**
   * Handles create a UnderexcLimIEEE2. if not key provided, calls create, otherwise calls save
   *
   * @param UnderexcLimIEEE2 underexcLimIEEE2
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateUnderexcLimIEEE2Command command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance()
              .createUnderexcLimIEEE2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a UnderexcLimIEEE2. if no key provided, calls create, otherwise calls save
   *
   * @param UnderexcLimIEEE2 underexcLimIEEE2
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateUnderexcLimIEEE2Command command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateUnderexcLimIEEE2Command
      // -----------------------------------------------
      completableFuture =
          UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance()
              .updateUnderexcLimIEEE2(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "UnderexcLimIEEE2Controller:update() - successfully update UnderexcLimIEEE2 - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a UnderexcLimIEEE2 entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID underexcLimIEEE2Id) {
    CompletableFuture<Void> completableFuture = null;
    DeleteUnderexcLimIEEE2Command command = new DeleteUnderexcLimIEEE2Command(underexcLimIEEE2Id);

    try {
      UnderexcLimIEEE2BusinessDelegate delegate =
          UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted UnderexcLimIEEE2 with key " + command.getUnderexcLimIEEE2Id());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save K1 on UnderexcLimIEEE2
   *
   * @param command AssignK1ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignK1")
  public void assignK1(@RequestBody AssignK1ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignK1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K1", exc);
    }
  }

  /**
   * unassign K1 on UnderexcLimIEEE2
   *
   * @param command UnAssignK1FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignK1")
  public void unAssignK1(
      @RequestBody(required = true) UnAssignK1FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignK1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K1", exc);
    }
  }

  /**
   * save K2 on UnderexcLimIEEE2
   *
   * @param command AssignK2ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignK2")
  public void assignK2(@RequestBody AssignK2ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignK2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign K2", exc);
    }
  }

  /**
   * unassign K2 on UnderexcLimIEEE2
   *
   * @param command UnAssignK2FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignK2")
  public void unAssignK2(
      @RequestBody(required = true) UnAssignK2FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignK2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign K2", exc);
    }
  }

  /**
   * save Kfb on UnderexcLimIEEE2
   *
   * @param command AssignKfbToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignKfb")
  public void assignKfb(@RequestBody AssignKfbToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignKfb(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kfb", exc);
    }
  }

  /**
   * unassign Kfb on UnderexcLimIEEE2
   *
   * @param command UnAssignKfbFromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignKfb")
  public void unAssignKfb(
      @RequestBody(required = true) UnAssignKfbFromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignKfb(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kfb", exc);
    }
  }

  /**
   * save Kuf on UnderexcLimIEEE2
   *
   * @param command AssignKufToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignKuf")
  public void assignKuf(@RequestBody AssignKufToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignKuf(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kuf", exc);
    }
  }

  /**
   * unassign Kuf on UnderexcLimIEEE2
   *
   * @param command UnAssignKufFromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignKuf")
  public void unAssignKuf(
      @RequestBody(required = true) UnAssignKufFromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignKuf(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kuf", exc);
    }
  }

  /**
   * save Kui on UnderexcLimIEEE2
   *
   * @param command AssignKuiToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignKui")
  public void assignKui(@RequestBody AssignKuiToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignKui(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kui", exc);
    }
  }

  /**
   * unassign Kui on UnderexcLimIEEE2
   *
   * @param command UnAssignKuiFromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignKui")
  public void unAssignKui(
      @RequestBody(required = true) UnAssignKuiFromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignKui(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kui", exc);
    }
  }

  /**
   * save Kul on UnderexcLimIEEE2
   *
   * @param command AssignKulToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignKul")
  public void assignKul(@RequestBody AssignKulToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignKul(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kul", exc);
    }
  }

  /**
   * unassign Kul on UnderexcLimIEEE2
   *
   * @param command UnAssignKulFromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignKul")
  public void unAssignKul(
      @RequestBody(required = true) UnAssignKulFromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignKul(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kul", exc);
    }
  }

  /**
   * save P0 on UnderexcLimIEEE2
   *
   * @param command AssignP0ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignP0")
  public void assignP0(@RequestBody AssignP0ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignP0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P0", exc);
    }
  }

  /**
   * unassign P0 on UnderexcLimIEEE2
   *
   * @param command UnAssignP0FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignP0")
  public void unAssignP0(
      @RequestBody(required = true) UnAssignP0FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignP0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P0", exc);
    }
  }

  /**
   * save P1 on UnderexcLimIEEE2
   *
   * @param command AssignP1ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignP1")
  public void assignP1(@RequestBody AssignP1ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignP1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P1", exc);
    }
  }

  /**
   * unassign P1 on UnderexcLimIEEE2
   *
   * @param command UnAssignP1FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignP1")
  public void unAssignP1(
      @RequestBody(required = true) UnAssignP1FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignP1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P1", exc);
    }
  }

  /**
   * save P10 on UnderexcLimIEEE2
   *
   * @param command AssignP10ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignP10")
  public void assignP10(@RequestBody AssignP10ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignP10(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P10", exc);
    }
  }

  /**
   * unassign P10 on UnderexcLimIEEE2
   *
   * @param command UnAssignP10FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignP10")
  public void unAssignP10(
      @RequestBody(required = true) UnAssignP10FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignP10(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P10", exc);
    }
  }

  /**
   * save P2 on UnderexcLimIEEE2
   *
   * @param command AssignP2ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignP2")
  public void assignP2(@RequestBody AssignP2ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignP2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P2", exc);
    }
  }

  /**
   * unassign P2 on UnderexcLimIEEE2
   *
   * @param command UnAssignP2FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignP2")
  public void unAssignP2(
      @RequestBody(required = true) UnAssignP2FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignP2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P2", exc);
    }
  }

  /**
   * save P3 on UnderexcLimIEEE2
   *
   * @param command AssignP3ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignP3")
  public void assignP3(@RequestBody AssignP3ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignP3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P3", exc);
    }
  }

  /**
   * unassign P3 on UnderexcLimIEEE2
   *
   * @param command UnAssignP3FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignP3")
  public void unAssignP3(
      @RequestBody(required = true) UnAssignP3FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignP3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P3", exc);
    }
  }

  /**
   * save P4 on UnderexcLimIEEE2
   *
   * @param command AssignP4ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignP4")
  public void assignP4(@RequestBody AssignP4ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignP4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P4", exc);
    }
  }

  /**
   * unassign P4 on UnderexcLimIEEE2
   *
   * @param command UnAssignP4FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignP4")
  public void unAssignP4(
      @RequestBody(required = true) UnAssignP4FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignP4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P4", exc);
    }
  }

  /**
   * save P5 on UnderexcLimIEEE2
   *
   * @param command AssignP5ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignP5")
  public void assignP5(@RequestBody AssignP5ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignP5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P5", exc);
    }
  }

  /**
   * unassign P5 on UnderexcLimIEEE2
   *
   * @param command UnAssignP5FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignP5")
  public void unAssignP5(
      @RequestBody(required = true) UnAssignP5FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignP5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P5", exc);
    }
  }

  /**
   * save P6 on UnderexcLimIEEE2
   *
   * @param command AssignP6ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignP6")
  public void assignP6(@RequestBody AssignP6ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignP6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P6", exc);
    }
  }

  /**
   * unassign P6 on UnderexcLimIEEE2
   *
   * @param command UnAssignP6FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignP6")
  public void unAssignP6(
      @RequestBody(required = true) UnAssignP6FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignP6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P6", exc);
    }
  }

  /**
   * save P7 on UnderexcLimIEEE2
   *
   * @param command AssignP7ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignP7")
  public void assignP7(@RequestBody AssignP7ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignP7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P7", exc);
    }
  }

  /**
   * unassign P7 on UnderexcLimIEEE2
   *
   * @param command UnAssignP7FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignP7")
  public void unAssignP7(
      @RequestBody(required = true) UnAssignP7FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignP7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P7", exc);
    }
  }

  /**
   * save P8 on UnderexcLimIEEE2
   *
   * @param command AssignP8ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignP8")
  public void assignP8(@RequestBody AssignP8ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignP8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P8", exc);
    }
  }

  /**
   * unassign P8 on UnderexcLimIEEE2
   *
   * @param command UnAssignP8FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignP8")
  public void unAssignP8(
      @RequestBody(required = true) UnAssignP8FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignP8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P8", exc);
    }
  }

  /**
   * save P9 on UnderexcLimIEEE2
   *
   * @param command AssignP9ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignP9")
  public void assignP9(@RequestBody AssignP9ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignP9(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign P9", exc);
    }
  }

  /**
   * unassign P9 on UnderexcLimIEEE2
   *
   * @param command UnAssignP9FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignP9")
  public void unAssignP9(
      @RequestBody(required = true) UnAssignP9FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignP9(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign P9", exc);
    }
  }

  /**
   * save Q0 on UnderexcLimIEEE2
   *
   * @param command AssignQ0ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignQ0")
  public void assignQ0(@RequestBody AssignQ0ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignQ0(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Q0", exc);
    }
  }

  /**
   * unassign Q0 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ0FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignQ0")
  public void unAssignQ0(
      @RequestBody(required = true) UnAssignQ0FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignQ0(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Q0", exc);
    }
  }

  /**
   * save Q1 on UnderexcLimIEEE2
   *
   * @param command AssignQ1ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignQ1")
  public void assignQ1(@RequestBody AssignQ1ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignQ1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Q1", exc);
    }
  }

  /**
   * unassign Q1 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ1FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignQ1")
  public void unAssignQ1(
      @RequestBody(required = true) UnAssignQ1FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignQ1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Q1", exc);
    }
  }

  /**
   * save Q10 on UnderexcLimIEEE2
   *
   * @param command AssignQ10ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignQ10")
  public void assignQ10(@RequestBody AssignQ10ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignQ10(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Q10", exc);
    }
  }

  /**
   * unassign Q10 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ10FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignQ10")
  public void unAssignQ10(
      @RequestBody(required = true) UnAssignQ10FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignQ10(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Q10", exc);
    }
  }

  /**
   * save Q2 on UnderexcLimIEEE2
   *
   * @param command AssignQ2ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignQ2")
  public void assignQ2(@RequestBody AssignQ2ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignQ2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Q2", exc);
    }
  }

  /**
   * unassign Q2 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ2FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignQ2")
  public void unAssignQ2(
      @RequestBody(required = true) UnAssignQ2FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignQ2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Q2", exc);
    }
  }

  /**
   * save Q3 on UnderexcLimIEEE2
   *
   * @param command AssignQ3ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignQ3")
  public void assignQ3(@RequestBody AssignQ3ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignQ3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Q3", exc);
    }
  }

  /**
   * unassign Q3 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ3FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignQ3")
  public void unAssignQ3(
      @RequestBody(required = true) UnAssignQ3FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignQ3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Q3", exc);
    }
  }

  /**
   * save Q4 on UnderexcLimIEEE2
   *
   * @param command AssignQ4ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignQ4")
  public void assignQ4(@RequestBody AssignQ4ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignQ4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Q4", exc);
    }
  }

  /**
   * unassign Q4 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ4FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignQ4")
  public void unAssignQ4(
      @RequestBody(required = true) UnAssignQ4FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignQ4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Q4", exc);
    }
  }

  /**
   * save Q5 on UnderexcLimIEEE2
   *
   * @param command AssignQ5ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignQ5")
  public void assignQ5(@RequestBody AssignQ5ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignQ5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Q5", exc);
    }
  }

  /**
   * unassign Q5 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ5FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignQ5")
  public void unAssignQ5(
      @RequestBody(required = true) UnAssignQ5FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignQ5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Q5", exc);
    }
  }

  /**
   * save Q6 on UnderexcLimIEEE2
   *
   * @param command AssignQ6ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignQ6")
  public void assignQ6(@RequestBody AssignQ6ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignQ6(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Q6", exc);
    }
  }

  /**
   * unassign Q6 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ6FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignQ6")
  public void unAssignQ6(
      @RequestBody(required = true) UnAssignQ6FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignQ6(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Q6", exc);
    }
  }

  /**
   * save Q7 on UnderexcLimIEEE2
   *
   * @param command AssignQ7ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignQ7")
  public void assignQ7(@RequestBody AssignQ7ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignQ7(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Q7", exc);
    }
  }

  /**
   * unassign Q7 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ7FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignQ7")
  public void unAssignQ7(
      @RequestBody(required = true) UnAssignQ7FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignQ7(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Q7", exc);
    }
  }

  /**
   * save Q8 on UnderexcLimIEEE2
   *
   * @param command AssignQ8ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignQ8")
  public void assignQ8(@RequestBody AssignQ8ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignQ8(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Q8", exc);
    }
  }

  /**
   * unassign Q8 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ8FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignQ8")
  public void unAssignQ8(
      @RequestBody(required = true) UnAssignQ8FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignQ8(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Q8", exc);
    }
  }

  /**
   * save Q9 on UnderexcLimIEEE2
   *
   * @param command AssignQ9ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignQ9")
  public void assignQ9(@RequestBody AssignQ9ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignQ9(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Q9", exc);
    }
  }

  /**
   * unassign Q9 on UnderexcLimIEEE2
   *
   * @param command UnAssignQ9FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignQ9")
  public void unAssignQ9(
      @RequestBody(required = true) UnAssignQ9FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignQ9(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Q9", exc);
    }
  }

  /**
   * save Tu1 on UnderexcLimIEEE2
   *
   * @param command AssignTu1ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignTu1")
  public void assignTu1(@RequestBody AssignTu1ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignTu1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tu1", exc);
    }
  }

  /**
   * unassign Tu1 on UnderexcLimIEEE2
   *
   * @param command UnAssignTu1FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignTu1")
  public void unAssignTu1(
      @RequestBody(required = true) UnAssignTu1FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignTu1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tu1", exc);
    }
  }

  /**
   * save Tu2 on UnderexcLimIEEE2
   *
   * @param command AssignTu2ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignTu2")
  public void assignTu2(@RequestBody AssignTu2ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignTu2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tu2", exc);
    }
  }

  /**
   * unassign Tu2 on UnderexcLimIEEE2
   *
   * @param command UnAssignTu2FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignTu2")
  public void unAssignTu2(
      @RequestBody(required = true) UnAssignTu2FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignTu2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tu2", exc);
    }
  }

  /**
   * save Tu3 on UnderexcLimIEEE2
   *
   * @param command AssignTu3ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignTu3")
  public void assignTu3(@RequestBody AssignTu3ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignTu3(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tu3", exc);
    }
  }

  /**
   * unassign Tu3 on UnderexcLimIEEE2
   *
   * @param command UnAssignTu3FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignTu3")
  public void unAssignTu3(
      @RequestBody(required = true) UnAssignTu3FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignTu3(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tu3", exc);
    }
  }

  /**
   * save Tu4 on UnderexcLimIEEE2
   *
   * @param command AssignTu4ToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignTu4")
  public void assignTu4(@RequestBody AssignTu4ToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignTu4(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tu4", exc);
    }
  }

  /**
   * unassign Tu4 on UnderexcLimIEEE2
   *
   * @param command UnAssignTu4FromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignTu4")
  public void unAssignTu4(
      @RequestBody(required = true) UnAssignTu4FromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignTu4(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tu4", exc);
    }
  }

  /**
   * save Tul on UnderexcLimIEEE2
   *
   * @param command AssignTulToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignTul")
  public void assignTul(@RequestBody AssignTulToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignTul(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tul", exc);
    }
  }

  /**
   * unassign Tul on UnderexcLimIEEE2
   *
   * @param command UnAssignTulFromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignTul")
  public void unAssignTul(
      @RequestBody(required = true) UnAssignTulFromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignTul(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tul", exc);
    }
  }

  /**
   * save Tup on UnderexcLimIEEE2
   *
   * @param command AssignTupToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignTup")
  public void assignTup(@RequestBody AssignTupToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignTup(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tup", exc);
    }
  }

  /**
   * unassign Tup on UnderexcLimIEEE2
   *
   * @param command UnAssignTupFromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignTup")
  public void unAssignTup(
      @RequestBody(required = true) UnAssignTupFromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignTup(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tup", exc);
    }
  }

  /**
   * save Tuq on UnderexcLimIEEE2
   *
   * @param command AssignTuqToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignTuq")
  public void assignTuq(@RequestBody AssignTuqToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignTuq(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tuq", exc);
    }
  }

  /**
   * unassign Tuq on UnderexcLimIEEE2
   *
   * @param command UnAssignTuqFromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignTuq")
  public void unAssignTuq(
      @RequestBody(required = true) UnAssignTuqFromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignTuq(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tuq", exc);
    }
  }

  /**
   * save Tuv on UnderexcLimIEEE2
   *
   * @param command AssignTuvToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignTuv")
  public void assignTuv(@RequestBody AssignTuvToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignTuv(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tuv", exc);
    }
  }

  /**
   * unassign Tuv on UnderexcLimIEEE2
   *
   * @param command UnAssignTuvFromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignTuv")
  public void unAssignTuv(
      @RequestBody(required = true) UnAssignTuvFromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignTuv(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tuv", exc);
    }
  }

  /**
   * save Vuimax on UnderexcLimIEEE2
   *
   * @param command AssignVuimaxToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignVuimax")
  public void assignVuimax(@RequestBody AssignVuimaxToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignVuimax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vuimax", exc);
    }
  }

  /**
   * unassign Vuimax on UnderexcLimIEEE2
   *
   * @param command UnAssignVuimaxFromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignVuimax")
  public void unAssignVuimax(
      @RequestBody(required = true) UnAssignVuimaxFromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignVuimax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vuimax", exc);
    }
  }

  /**
   * save Vuimin on UnderexcLimIEEE2
   *
   * @param command AssignVuiminToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignVuimin")
  public void assignVuimin(@RequestBody AssignVuiminToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignVuimin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vuimin", exc);
    }
  }

  /**
   * unassign Vuimin on UnderexcLimIEEE2
   *
   * @param command UnAssignVuiminFromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignVuimin")
  public void unAssignVuimin(
      @RequestBody(required = true) UnAssignVuiminFromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignVuimin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vuimin", exc);
    }
  }

  /**
   * save Vulmax on UnderexcLimIEEE2
   *
   * @param command AssignVulmaxToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignVulmax")
  public void assignVulmax(@RequestBody AssignVulmaxToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignVulmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vulmax", exc);
    }
  }

  /**
   * unassign Vulmax on UnderexcLimIEEE2
   *
   * @param command UnAssignVulmaxFromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignVulmax")
  public void unAssignVulmax(
      @RequestBody(required = true) UnAssignVulmaxFromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignVulmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vulmax", exc);
    }
  }

  /**
   * save Vulmin on UnderexcLimIEEE2
   *
   * @param command AssignVulminToUnderexcLimIEEE2Command
   */
  @PutMapping("/assignVulmin")
  public void assignVulmin(@RequestBody AssignVulminToUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().assignVulmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vulmin", exc);
    }
  }

  /**
   * unassign Vulmin on UnderexcLimIEEE2
   *
   * @param command UnAssignVulminFromUnderexcLimIEEE2Command
   */
  @PutMapping("/unAssignVulmin")
  public void unAssignVulmin(
      @RequestBody(required = true) UnAssignVulminFromUnderexcLimIEEE2Command command) {
    try {
      UnderexcLimIEEE2BusinessDelegate.getUnderexcLimIEEE2Instance().unAssignVulmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vulmin", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected UnderexcLimIEEE2 underexcLimIEEE2 = null;
  private static final Logger LOGGER =
      Logger.getLogger(UnderexcLimIEEE2CommandRestController.class.getName());
}
