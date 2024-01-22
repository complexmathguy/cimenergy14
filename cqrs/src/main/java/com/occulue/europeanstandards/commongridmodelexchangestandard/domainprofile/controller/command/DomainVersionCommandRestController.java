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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity DomainVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DomainVersion")
public class DomainVersionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DomainVersion. if not key provided, calls create, otherwise calls save
   *
   * @param DomainVersion domainVersion
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDomainVersionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          DomainVersionBusinessDelegate.getDomainVersionInstance().createDomainVersion(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DomainVersion. if no key provided, calls create, otherwise calls save
   *
   * @param DomainVersion domainVersion
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDomainVersionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDomainVersionCommand
      // -----------------------------------------------
      completableFuture =
          DomainVersionBusinessDelegate.getDomainVersionInstance().updateDomainVersion(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DomainVersionController:update() - successfully update DomainVersion - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DomainVersion entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID domainVersionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDomainVersionCommand command = new DeleteDomainVersionCommand(domainVersionId);

    try {
      DomainVersionBusinessDelegate delegate =
          DomainVersionBusinessDelegate.getDomainVersionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted DomainVersion with key " + command.getDomainVersionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BaseUML on DomainVersion
   *
   * @param command AssignBaseUMLToDomainVersionCommand
   */
  @PutMapping("/assignBaseUML")
  public void assignBaseUML(@RequestBody AssignBaseUMLToDomainVersionCommand command) {
    try {
      DomainVersionBusinessDelegate.getDomainVersionInstance().assignBaseUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseUML", exc);
    }
  }

  /**
   * unassign BaseUML on DomainVersion
   *
   * @param command UnAssignBaseUMLFromDomainVersionCommand
   */
  @PutMapping("/unAssignBaseUML")
  public void unAssignBaseUML(
      @RequestBody(required = true) UnAssignBaseUMLFromDomainVersionCommand command) {
    try {
      DomainVersionBusinessDelegate.getDomainVersionInstance().unAssignBaseUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseUML", exc);
    }
  }

  /**
   * save Date on DomainVersion
   *
   * @param command AssignDateToDomainVersionCommand
   */
  @PutMapping("/assignDate")
  public void assignDate(@RequestBody AssignDateToDomainVersionCommand command) {
    try {
      DomainVersionBusinessDelegate.getDomainVersionInstance().assignDate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Date", exc);
    }
  }

  /**
   * unassign Date on DomainVersion
   *
   * @param command UnAssignDateFromDomainVersionCommand
   */
  @PutMapping("/unAssignDate")
  public void unAssignDate(
      @RequestBody(required = true) UnAssignDateFromDomainVersionCommand command) {
    try {
      DomainVersionBusinessDelegate.getDomainVersionInstance().unAssignDate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Date", exc);
    }
  }

  /**
   * save EntsoeUML on DomainVersion
   *
   * @param command AssignEntsoeUMLToDomainVersionCommand
   */
  @PutMapping("/assignEntsoeUML")
  public void assignEntsoeUML(@RequestBody AssignEntsoeUMLToDomainVersionCommand command) {
    try {
      DomainVersionBusinessDelegate.getDomainVersionInstance().assignEntsoeUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeUML", exc);
    }
  }

  /**
   * unassign EntsoeUML on DomainVersion
   *
   * @param command UnAssignEntsoeUMLFromDomainVersionCommand
   */
  @PutMapping("/unAssignEntsoeUML")
  public void unAssignEntsoeUML(
      @RequestBody(required = true) UnAssignEntsoeUMLFromDomainVersionCommand command) {
    try {
      DomainVersionBusinessDelegate.getDomainVersionInstance().unAssignEntsoeUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeUML", exc);
    }
  }

  /**
   * save Version on DomainVersion
   *
   * @param command AssignVersionToDomainVersionCommand
   */
  @PutMapping("/assignVersion")
  public void assignVersion(@RequestBody AssignVersionToDomainVersionCommand command) {
    try {
      DomainVersionBusinessDelegate.getDomainVersionInstance().assignVersion(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Version", exc);
    }
  }

  /**
   * unassign Version on DomainVersion
   *
   * @param command UnAssignVersionFromDomainVersionCommand
   */
  @PutMapping("/unAssignVersion")
  public void unAssignVersion(
      @RequestBody(required = true) UnAssignVersionFromDomainVersionCommand command) {
    try {
      DomainVersionBusinessDelegate.getDomainVersionInstance().unAssignVersion(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Version", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DomainVersion domainVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(DomainVersionCommandRestController.class.getName());
}
