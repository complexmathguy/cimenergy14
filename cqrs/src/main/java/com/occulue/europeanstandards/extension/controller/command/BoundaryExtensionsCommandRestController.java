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
package com.occulue.europeanstandards.extension.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity BoundaryExtensions.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/BoundaryExtensions")
public class BoundaryExtensionsCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a BoundaryExtensions. if not key provided, calls create, otherwise calls save
   *
   * @param BoundaryExtensions boundaryExtensions
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateBoundaryExtensionsCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
              .createBoundaryExtensions(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a BoundaryExtensions. if no key provided, calls create, otherwise calls save
   *
   * @param BoundaryExtensions boundaryExtensions
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateBoundaryExtensionsCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateBoundaryExtensionsCommand
      // -----------------------------------------------
      completableFuture =
          BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
              .updateBoundaryExtensions(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "BoundaryExtensionsController:update() - successfully update BoundaryExtensions - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a BoundaryExtensions entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID boundaryExtensionsId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteBoundaryExtensionsCommand command =
        new DeleteBoundaryExtensionsCommand(boundaryExtensionsId);

    try {
      BoundaryExtensionsBusinessDelegate delegate =
          BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted BoundaryExtensions with key " + command.getBoundaryExtensionsId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BoundaryPoint on BoundaryExtensions
   *
   * @param command AssignBoundaryPointToBoundaryExtensionsCommand
   */
  @PutMapping("/assignBoundaryPoint")
  public void assignBoundaryPoint(
      @RequestBody AssignBoundaryPointToBoundaryExtensionsCommand command) {
    try {
      BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
          .assignBoundaryPoint(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BoundaryPoint", exc);
    }
  }

  /**
   * unassign BoundaryPoint on BoundaryExtensions
   *
   * @param command UnAssignBoundaryPointFromBoundaryExtensionsCommand
   */
  @PutMapping("/unAssignBoundaryPoint")
  public void unAssignBoundaryPoint(
      @RequestBody(required = true) UnAssignBoundaryPointFromBoundaryExtensionsCommand command) {
    try {
      BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
          .unAssignBoundaryPoint(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BoundaryPoint", exc);
    }
  }

  /**
   * save FromEndIsoCode on BoundaryExtensions
   *
   * @param command AssignFromEndIsoCodeToBoundaryExtensionsCommand
   */
  @PutMapping("/assignFromEndIsoCode")
  public void assignFromEndIsoCode(
      @RequestBody AssignFromEndIsoCodeToBoundaryExtensionsCommand command) {
    try {
      BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
          .assignFromEndIsoCode(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign FromEndIsoCode", exc);
    }
  }

  /**
   * unassign FromEndIsoCode on BoundaryExtensions
   *
   * @param command UnAssignFromEndIsoCodeFromBoundaryExtensionsCommand
   */
  @PutMapping("/unAssignFromEndIsoCode")
  public void unAssignFromEndIsoCode(
      @RequestBody(required = true) UnAssignFromEndIsoCodeFromBoundaryExtensionsCommand command) {
    try {
      BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
          .unAssignFromEndIsoCode(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign FromEndIsoCode", exc);
    }
  }

  /**
   * save FromEndName on BoundaryExtensions
   *
   * @param command AssignFromEndNameToBoundaryExtensionsCommand
   */
  @PutMapping("/assignFromEndName")
  public void assignFromEndName(@RequestBody AssignFromEndNameToBoundaryExtensionsCommand command) {
    try {
      BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance().assignFromEndName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign FromEndName", exc);
    }
  }

  /**
   * unassign FromEndName on BoundaryExtensions
   *
   * @param command UnAssignFromEndNameFromBoundaryExtensionsCommand
   */
  @PutMapping("/unAssignFromEndName")
  public void unAssignFromEndName(
      @RequestBody(required = true) UnAssignFromEndNameFromBoundaryExtensionsCommand command) {
    try {
      BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
          .unAssignFromEndName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign FromEndName", exc);
    }
  }

  /**
   * save FromEndNameTso on BoundaryExtensions
   *
   * @param command AssignFromEndNameTsoToBoundaryExtensionsCommand
   */
  @PutMapping("/assignFromEndNameTso")
  public void assignFromEndNameTso(
      @RequestBody AssignFromEndNameTsoToBoundaryExtensionsCommand command) {
    try {
      BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
          .assignFromEndNameTso(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign FromEndNameTso", exc);
    }
  }

  /**
   * unassign FromEndNameTso on BoundaryExtensions
   *
   * @param command UnAssignFromEndNameTsoFromBoundaryExtensionsCommand
   */
  @PutMapping("/unAssignFromEndNameTso")
  public void unAssignFromEndNameTso(
      @RequestBody(required = true) UnAssignFromEndNameTsoFromBoundaryExtensionsCommand command) {
    try {
      BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
          .unAssignFromEndNameTso(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign FromEndNameTso", exc);
    }
  }

  /**
   * save ToEndIsoCode on BoundaryExtensions
   *
   * @param command AssignToEndIsoCodeToBoundaryExtensionsCommand
   */
  @PutMapping("/assignToEndIsoCode")
  public void assignToEndIsoCode(
      @RequestBody AssignToEndIsoCodeToBoundaryExtensionsCommand command) {
    try {
      BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
          .assignToEndIsoCode(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ToEndIsoCode", exc);
    }
  }

  /**
   * unassign ToEndIsoCode on BoundaryExtensions
   *
   * @param command UnAssignToEndIsoCodeFromBoundaryExtensionsCommand
   */
  @PutMapping("/unAssignToEndIsoCode")
  public void unAssignToEndIsoCode(
      @RequestBody(required = true) UnAssignToEndIsoCodeFromBoundaryExtensionsCommand command) {
    try {
      BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
          .unAssignToEndIsoCode(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ToEndIsoCode", exc);
    }
  }

  /**
   * save ToEndName on BoundaryExtensions
   *
   * @param command AssignToEndNameToBoundaryExtensionsCommand
   */
  @PutMapping("/assignToEndName")
  public void assignToEndName(@RequestBody AssignToEndNameToBoundaryExtensionsCommand command) {
    try {
      BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance().assignToEndName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ToEndName", exc);
    }
  }

  /**
   * unassign ToEndName on BoundaryExtensions
   *
   * @param command UnAssignToEndNameFromBoundaryExtensionsCommand
   */
  @PutMapping("/unAssignToEndName")
  public void unAssignToEndName(
      @RequestBody(required = true) UnAssignToEndNameFromBoundaryExtensionsCommand command) {
    try {
      BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance().unAssignToEndName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ToEndName", exc);
    }
  }

  /**
   * save ToEndNameTso on BoundaryExtensions
   *
   * @param command AssignToEndNameTsoToBoundaryExtensionsCommand
   */
  @PutMapping("/assignToEndNameTso")
  public void assignToEndNameTso(
      @RequestBody AssignToEndNameTsoToBoundaryExtensionsCommand command) {
    try {
      BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
          .assignToEndNameTso(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ToEndNameTso", exc);
    }
  }

  /**
   * unassign ToEndNameTso on BoundaryExtensions
   *
   * @param command UnAssignToEndNameTsoFromBoundaryExtensionsCommand
   */
  @PutMapping("/unAssignToEndNameTso")
  public void unAssignToEndNameTso(
      @RequestBody(required = true) UnAssignToEndNameTsoFromBoundaryExtensionsCommand command) {
    try {
      BoundaryExtensionsBusinessDelegate.getBoundaryExtensionsInstance()
          .unAssignToEndNameTso(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ToEndNameTso", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected BoundaryExtensions boundaryExtensions = null;
  private static final Logger LOGGER =
      Logger.getLogger(BoundaryExtensionsCommandRestController.class.getName());
}
