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
 * Implements Spring Controller command CQRS processing for entity DiscExcContIEEEDEC2A.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DiscExcContIEEEDEC2A")
public class DiscExcContIEEEDEC2ACommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DiscExcContIEEEDEC2A. if not key provided, calls create, otherwise calls save
   *
   * @param DiscExcContIEEEDEC2A discExcContIEEEDEC2A
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDiscExcContIEEEDEC2ACommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance()
              .createDiscExcContIEEEDEC2A(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DiscExcContIEEEDEC2A. if no key provided, calls create, otherwise calls save
   *
   * @param DiscExcContIEEEDEC2A discExcContIEEEDEC2A
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDiscExcContIEEEDEC2ACommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDiscExcContIEEEDEC2ACommand
      // -----------------------------------------------
      completableFuture =
          DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance()
              .updateDiscExcContIEEEDEC2A(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DiscExcContIEEEDEC2AController:update() - successfully update DiscExcContIEEEDEC2A - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DiscExcContIEEEDEC2A entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID discExcContIEEEDEC2AId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDiscExcContIEEEDEC2ACommand command =
        new DeleteDiscExcContIEEEDEC2ACommand(discExcContIEEEDEC2AId);

    try {
      DiscExcContIEEEDEC2ABusinessDelegate delegate =
          DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted DiscExcContIEEEDEC2A with key "
              + command.getDiscExcContIEEEDEC2AId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Td1 on DiscExcContIEEEDEC2A
   *
   * @param command AssignTd1ToDiscExcContIEEEDEC2ACommand
   */
  @PutMapping("/assignTd1")
  public void assignTd1(@RequestBody AssignTd1ToDiscExcContIEEEDEC2ACommand command) {
    try {
      DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().assignTd1(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Td1", exc);
    }
  }

  /**
   * unassign Td1 on DiscExcContIEEEDEC2A
   *
   * @param command UnAssignTd1FromDiscExcContIEEEDEC2ACommand
   */
  @PutMapping("/unAssignTd1")
  public void unAssignTd1(
      @RequestBody(required = true) UnAssignTd1FromDiscExcContIEEEDEC2ACommand command) {
    try {
      DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().unAssignTd1(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Td1", exc);
    }
  }

  /**
   * save Td2 on DiscExcContIEEEDEC2A
   *
   * @param command AssignTd2ToDiscExcContIEEEDEC2ACommand
   */
  @PutMapping("/assignTd2")
  public void assignTd2(@RequestBody AssignTd2ToDiscExcContIEEEDEC2ACommand command) {
    try {
      DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().assignTd2(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Td2", exc);
    }
  }

  /**
   * unassign Td2 on DiscExcContIEEEDEC2A
   *
   * @param command UnAssignTd2FromDiscExcContIEEEDEC2ACommand
   */
  @PutMapping("/unAssignTd2")
  public void unAssignTd2(
      @RequestBody(required = true) UnAssignTd2FromDiscExcContIEEEDEC2ACommand command) {
    try {
      DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().unAssignTd2(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Td2", exc);
    }
  }

  /**
   * save Vdmax on DiscExcContIEEEDEC2A
   *
   * @param command AssignVdmaxToDiscExcContIEEEDEC2ACommand
   */
  @PutMapping("/assignVdmax")
  public void assignVdmax(@RequestBody AssignVdmaxToDiscExcContIEEEDEC2ACommand command) {
    try {
      DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().assignVdmax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vdmax", exc);
    }
  }

  /**
   * unassign Vdmax on DiscExcContIEEEDEC2A
   *
   * @param command UnAssignVdmaxFromDiscExcContIEEEDEC2ACommand
   */
  @PutMapping("/unAssignVdmax")
  public void unAssignVdmax(
      @RequestBody(required = true) UnAssignVdmaxFromDiscExcContIEEEDEC2ACommand command) {
    try {
      DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().unAssignVdmax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vdmax", exc);
    }
  }

  /**
   * save Vdmin on DiscExcContIEEEDEC2A
   *
   * @param command AssignVdminToDiscExcContIEEEDEC2ACommand
   */
  @PutMapping("/assignVdmin")
  public void assignVdmin(@RequestBody AssignVdminToDiscExcContIEEEDEC2ACommand command) {
    try {
      DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().assignVdmin(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vdmin", exc);
    }
  }

  /**
   * unassign Vdmin on DiscExcContIEEEDEC2A
   *
   * @param command UnAssignVdminFromDiscExcContIEEEDEC2ACommand
   */
  @PutMapping("/unAssignVdmin")
  public void unAssignVdmin(
      @RequestBody(required = true) UnAssignVdminFromDiscExcContIEEEDEC2ACommand command) {
    try {
      DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().unAssignVdmin(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vdmin", exc);
    }
  }

  /**
   * save Vk on DiscExcContIEEEDEC2A
   *
   * @param command AssignVkToDiscExcContIEEEDEC2ACommand
   */
  @PutMapping("/assignVk")
  public void assignVk(@RequestBody AssignVkToDiscExcContIEEEDEC2ACommand command) {
    try {
      DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().assignVk(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Vk", exc);
    }
  }

  /**
   * unassign Vk on DiscExcContIEEEDEC2A
   *
   * @param command UnAssignVkFromDiscExcContIEEEDEC2ACommand
   */
  @PutMapping("/unAssignVk")
  public void unAssignVk(
      @RequestBody(required = true) UnAssignVkFromDiscExcContIEEEDEC2ACommand command) {
    try {
      DiscExcContIEEEDEC2ABusinessDelegate.getDiscExcContIEEEDEC2AInstance().unAssignVk(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Vk", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DiscExcContIEEEDEC2A discExcContIEEEDEC2A = null;
  private static final Logger LOGGER =
      Logger.getLogger(DiscExcContIEEEDEC2ACommandRestController.class.getName());
}
