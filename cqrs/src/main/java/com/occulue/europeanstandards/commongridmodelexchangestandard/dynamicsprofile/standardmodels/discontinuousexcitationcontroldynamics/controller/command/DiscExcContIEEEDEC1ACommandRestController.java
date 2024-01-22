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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity DiscExcContIEEEDEC1A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiscExcContIEEEDEC1A")
public class DiscExcContIEEEDEC1ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DiscExcContIEEEDEC1A. if not key provided, calls create, otherwise calls save
   *
   * @param DiscExcContIEEEDEC1A discExcContIEEEDEC1A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDiscExcContIEEEDEC1ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance()
              .createDiscExcContIEEEDEC1A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DiscExcContIEEEDEC1A. if no key provided, calls create, otherwise calls save
   *
   * @param DiscExcContIEEEDEC1A discExcContIEEEDEC1A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDiscExcContIEEEDEC1ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDiscExcContIEEEDEC1ACommand
      // -----------------------------------------------
      completableFuture =
          DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance()
              .updateDiscExcContIEEEDEC1A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DiscExcContIEEEDEC1AController:update() - successfully update DiscExcContIEEEDEC1A - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DiscExcContIEEEDEC1A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID discExcContIEEEDEC1AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDiscExcContIEEEDEC1ACommand command =
        new DeleteDiscExcContIEEEDEC1ACommand(discExcContIEEEDEC1AId);

    try {
      DiscExcContIEEEDEC1ABusinessDelegate delegate =
          DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted DiscExcContIEEEDEC1A with key "
              + command.getDiscExcContIEEEDEC1AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Esc on DiscExcContIEEEDEC1A
   *
   * @param command AssignEscToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignEsc")
  public void assignEsc(@RequestBody AssignEscToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignEsc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Esc", exc);
    }
  }

  /**
   * unassign Esc on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignEscFromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignEsc")
  public void unAssignEsc(
      @RequestBody(required = true) UnAssignEscFromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignEsc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Esc", exc);
    }
  }

  /**
   * save Kan on DiscExcContIEEEDEC1A
   *
   * @param command AssignKanToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignKan")
  public void assignKan(@RequestBody AssignKanToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignKan(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Kan", exc);
    }
  }

  /**
   * unassign Kan on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignKanFromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignKan")
  public void unAssignKan(
      @RequestBody(required = true) UnAssignKanFromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignKan(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Kan", exc);
    }
  }

  /**
   * save Ketl on DiscExcContIEEEDEC1A
   *
   * @param command AssignKetlToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignKetl")
  public void assignKetl(@RequestBody AssignKetlToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignKetl(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Ketl", exc);
    }
  }

  /**
   * unassign Ketl on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignKetlFromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignKetl")
  public void unAssignKetl(
      @RequestBody(required = true) UnAssignKetlFromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignKetl(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Ketl", exc);
    }
  }

  /**
   * save Tan on DiscExcContIEEEDEC1A
   *
   * @param command AssignTanToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignTan")
  public void assignTan(@RequestBody AssignTanToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignTan(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tan", exc);
    }
  }

  /**
   * unassign Tan on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignTanFromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignTan")
  public void unAssignTan(
      @RequestBody(required = true) UnAssignTanFromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignTan(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tan", exc);
    }
  }

  /**
   * save Td on DiscExcContIEEEDEC1A
   *
   * @param command AssignTdToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignTd")
  public void assignTd(@RequestBody AssignTdToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignTd(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Td", exc);
    }
  }

  /**
   * unassign Td on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignTdFromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignTd")
  public void unAssignTd(
      @RequestBody(required = true) UnAssignTdFromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignTd(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Td", exc);
    }
  }

  /**
   * save Tl1 on DiscExcContIEEEDEC1A
   *
   * @param command AssignTl1ToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignTl1")
  public void assignTl1(@RequestBody AssignTl1ToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignTl1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl1", exc);
    }
  }

  /**
   * unassign Tl1 on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignTl1FromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignTl1")
  public void unAssignTl1(
      @RequestBody(required = true) UnAssignTl1FromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignTl1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl1", exc);
    }
  }

  /**
   * save Tl2 on DiscExcContIEEEDEC1A
   *
   * @param command AssignTl2ToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignTl2")
  public void assignTl2(@RequestBody AssignTl2ToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignTl2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tl2", exc);
    }
  }

  /**
   * unassign Tl2 on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignTl2FromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignTl2")
  public void unAssignTl2(
      @RequestBody(required = true) UnAssignTl2FromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignTl2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tl2", exc);
    }
  }

  /**
   * save Tw5 on DiscExcContIEEEDEC1A
   *
   * @param command AssignTw5ToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignTw5")
  public void assignTw5(@RequestBody AssignTw5ToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignTw5(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Tw5", exc);
    }
  }

  /**
   * unassign Tw5 on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignTw5FromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignTw5")
  public void unAssignTw5(
      @RequestBody(required = true) UnAssignTw5FromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignTw5(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Tw5", exc);
    }
  }

  /**
   * save Value on DiscExcContIEEEDEC1A
   *
   * @param command AssignValueToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignValueFromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  /**
   * save Vanmax on DiscExcContIEEEDEC1A
   *
   * @param command AssignVanmaxToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignVanmax")
  public void assignVanmax(@RequestBody AssignVanmaxToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignVanmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vanmax", exc);
    }
  }

  /**
   * unassign Vanmax on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVanmaxFromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignVanmax")
  public void unAssignVanmax(
      @RequestBody(required = true) UnAssignVanmaxFromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance()
          .unAssignVanmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vanmax", exc);
    }
  }

  /**
   * save Vomax on DiscExcContIEEEDEC1A
   *
   * @param command AssignVomaxToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignVomax")
  public void assignVomax(@RequestBody AssignVomaxToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignVomax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vomax", exc);
    }
  }

  /**
   * unassign Vomax on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVomaxFromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignVomax")
  public void unAssignVomax(
      @RequestBody(required = true) UnAssignVomaxFromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignVomax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vomax", exc);
    }
  }

  /**
   * save Vomin on DiscExcContIEEEDEC1A
   *
   * @param command AssignVominToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignVomin")
  public void assignVomin(@RequestBody AssignVominToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignVomin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vomin", exc);
    }
  }

  /**
   * unassign Vomin on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVominFromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignVomin")
  public void unAssignVomin(
      @RequestBody(required = true) UnAssignVominFromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignVomin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vomin", exc);
    }
  }

  /**
   * save Vsmax on DiscExcContIEEEDEC1A
   *
   * @param command AssignVsmaxToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignVsmax")
  public void assignVsmax(@RequestBody AssignVsmaxToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignVsmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsmax", exc);
    }
  }

  /**
   * unassign Vsmax on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVsmaxFromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignVsmax")
  public void unAssignVsmax(
      @RequestBody(required = true) UnAssignVsmaxFromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignVsmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsmax", exc);
    }
  }

  /**
   * save Vsmin on DiscExcContIEEEDEC1A
   *
   * @param command AssignVsminToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignVsmin")
  public void assignVsmin(@RequestBody AssignVsminToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignVsmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vsmin", exc);
    }
  }

  /**
   * unassign Vsmin on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVsminFromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignVsmin")
  public void unAssignVsmin(
      @RequestBody(required = true) UnAssignVsminFromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignVsmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vsmin", exc);
    }
  }

  /**
   * save Vtc on DiscExcContIEEEDEC1A
   *
   * @param command AssignVtcToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignVtc")
  public void assignVtc(@RequestBody AssignVtcToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignVtc(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vtc", exc);
    }
  }

  /**
   * unassign Vtc on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVtcFromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignVtc")
  public void unAssignVtc(
      @RequestBody(required = true) UnAssignVtcFromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignVtc(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vtc", exc);
    }
  }

  /**
   * save Vtlmt on DiscExcContIEEEDEC1A
   *
   * @param command AssignVtlmtToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignVtlmt")
  public void assignVtlmt(@RequestBody AssignVtlmtToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignVtlmt(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vtlmt", exc);
    }
  }

  /**
   * unassign Vtlmt on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVtlmtFromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignVtlmt")
  public void unAssignVtlmt(
      @RequestBody(required = true) UnAssignVtlmtFromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignVtlmt(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vtlmt", exc);
    }
  }

  /**
   * save Vtm on DiscExcContIEEEDEC1A
   *
   * @param command AssignVtmToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignVtm")
  public void assignVtm(@RequestBody AssignVtmToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignVtm(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vtm", exc);
    }
  }

  /**
   * unassign Vtm on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVtmFromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignVtm")
  public void unAssignVtm(
      @RequestBody(required = true) UnAssignVtmFromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignVtm(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vtm", exc);
    }
  }

  /**
   * save Vtn on DiscExcContIEEEDEC1A
   *
   * @param command AssignVtnToDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/assignVtn")
  public void assignVtn(@RequestBody AssignVtnToDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().assignVtn(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vtn", exc);
    }
  }

  /**
   * unassign Vtn on DiscExcContIEEEDEC1A
   *
   * @param command UnAssignVtnFromDiscExcContIEEEDEC1ACommand
   */
  @PutMapping("/unAssignVtn")
  public void unAssignVtn(
      @RequestBody(required = true) UnAssignVtnFromDiscExcContIEEEDEC1ACommand command) {
    try {
      DiscExcContIEEEDEC1ABusinessDelegate.getDiscExcContIEEEDEC1AInstance().unAssignVtn(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vtn", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DiscExcContIEEEDEC1A discExcContIEEEDEC1A = null;
  private static final Logger LOGGER =
      Logger.getLogger(DiscExcContIEEEDEC1ACommandRestController.class.getName());
}
