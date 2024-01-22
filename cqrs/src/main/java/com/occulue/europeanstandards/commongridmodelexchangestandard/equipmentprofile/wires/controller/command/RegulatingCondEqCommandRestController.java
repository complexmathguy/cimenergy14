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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity RegulatingCondEq.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/RegulatingCondEq")
public class RegulatingCondEqCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a RegulatingCondEq. if not key provided, calls create, otherwise calls save
   *
   * @param RegulatingCondEq regulatingCondEq
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateRegulatingCondEqCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance()
              .createRegulatingCondEq(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a RegulatingCondEq. if no key provided, calls create, otherwise calls save
   *
   * @param RegulatingCondEq regulatingCondEq
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateRegulatingCondEqCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateRegulatingCondEqCommand
      // -----------------------------------------------
      completableFuture =
          RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance()
              .updateRegulatingCondEq(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "RegulatingCondEqController:update() - successfully update RegulatingCondEq - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a RegulatingCondEq entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID regulatingCondEqId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteRegulatingCondEqCommand command = new DeleteRegulatingCondEqCommand(regulatingCondEqId);

    try {
      RegulatingCondEqBusinessDelegate delegate =
          RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted RegulatingCondEq with key " + command.getRegulatingCondEqId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save RegulatingCondEq on RegulatingCondEq
   *
   * @param command AssignRegulatingCondEqToRegulatingCondEqCommand
   */
  @PutMapping("/addToRegulatingCondEq")
  public void addToRegulatingCondEq(
      @RequestBody(required = true) AssignRegulatingCondEqToRegulatingCondEqCommand command) {
    try {
      RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance().addToRegulatingCondEq(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set RegulatingCondEq", exc);
    }
  }

  /**
   * remove RegulatingCondEq on RegulatingCondEq
   *
   * @param command RemoveRegulatingCondEqFromRegulatingCondEqCommand
   */
  @PutMapping("/removeFromRegulatingCondEq")
  public void removeFromRegulatingCondEq(
      @RequestBody(required = true) RemoveRegulatingCondEqFromRegulatingCondEqCommand command) {
    try {
      RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance()
          .removeFromRegulatingCondEq(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set RegulatingCondEq", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected RegulatingCondEq regulatingCondEq = null;
  private static final Logger LOGGER =
      Logger.getLogger(RegulatingCondEqCommandRestController.class.getName());
}
