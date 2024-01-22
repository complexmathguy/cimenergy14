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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity IdentifiedObject.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/IdentifiedObject")
public class IdentifiedObjectCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a IdentifiedObject. if not key provided, calls create, otherwise calls save
   *
   * @param IdentifiedObject identifiedObject
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateIdentifiedObjectCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance()
              .createIdentifiedObject(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a IdentifiedObject. if no key provided, calls create, otherwise calls save
   *
   * @param IdentifiedObject identifiedObject
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateIdentifiedObjectCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateIdentifiedObjectCommand
      // -----------------------------------------------
      completableFuture =
          IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance()
              .updateIdentifiedObject(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "IdentifiedObjectController:update() - successfully update IdentifiedObject - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a IdentifiedObject entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID identifiedObjectId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteIdentifiedObjectCommand command = new DeleteIdentifiedObjectCommand(identifiedObjectId);

    try {
      IdentifiedObjectBusinessDelegate delegate =
          IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted IdentifiedObject with key " + command.getIdentifiedObjectId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Description on IdentifiedObject
   *
   * @param command AssignDescriptionToIdentifiedObjectCommand
   */
  @PutMapping("/assignDescription")
  public void assignDescription(@RequestBody AssignDescriptionToIdentifiedObjectCommand command) {
    try {
      IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().assignDescription(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Description", exc);
    }
  }

  /**
   * unassign Description on IdentifiedObject
   *
   * @param command UnAssignDescriptionFromIdentifiedObjectCommand
   */
  @PutMapping("/unAssignDescription")
  public void unAssignDescription(
      @RequestBody(required = true) UnAssignDescriptionFromIdentifiedObjectCommand command) {
    try {
      IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().unAssignDescription(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Description", exc);
    }
  }

  /**
   * save EnergyIdentCodeEic on IdentifiedObject
   *
   * @param command AssignEnergyIdentCodeEicToIdentifiedObjectCommand
   */
  @PutMapping("/assignEnergyIdentCodeEic")
  public void assignEnergyIdentCodeEic(
      @RequestBody AssignEnergyIdentCodeEicToIdentifiedObjectCommand command) {
    try {
      IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance()
          .assignEnergyIdentCodeEic(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EnergyIdentCodeEic", exc);
    }
  }

  /**
   * unassign EnergyIdentCodeEic on IdentifiedObject
   *
   * @param command UnAssignEnergyIdentCodeEicFromIdentifiedObjectCommand
   */
  @PutMapping("/unAssignEnergyIdentCodeEic")
  public void unAssignEnergyIdentCodeEic(
      @RequestBody(required = true) UnAssignEnergyIdentCodeEicFromIdentifiedObjectCommand command) {
    try {
      IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance()
          .unAssignEnergyIdentCodeEic(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EnergyIdentCodeEic", exc);
    }
  }

  /**
   * save MRID on IdentifiedObject
   *
   * @param command AssignMRIDToIdentifiedObjectCommand
   */
  @PutMapping("/assignMRID")
  public void assignMRID(@RequestBody AssignMRIDToIdentifiedObjectCommand command) {
    try {
      IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().assignMRID(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign MRID", exc);
    }
  }

  /**
   * unassign MRID on IdentifiedObject
   *
   * @param command UnAssignMRIDFromIdentifiedObjectCommand
   */
  @PutMapping("/unAssignMRID")
  public void unAssignMRID(
      @RequestBody(required = true) UnAssignMRIDFromIdentifiedObjectCommand command) {
    try {
      IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().unAssignMRID(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign MRID", exc);
    }
  }

  /**
   * save Name on IdentifiedObject
   *
   * @param command AssignNameToIdentifiedObjectCommand
   */
  @PutMapping("/assignName")
  public void assignName(@RequestBody AssignNameToIdentifiedObjectCommand command) {
    try {
      IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().assignName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Name", exc);
    }
  }

  /**
   * unassign Name on IdentifiedObject
   *
   * @param command UnAssignNameFromIdentifiedObjectCommand
   */
  @PutMapping("/unAssignName")
  public void unAssignName(
      @RequestBody(required = true) UnAssignNameFromIdentifiedObjectCommand command) {
    try {
      IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().unAssignName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Name", exc);
    }
  }

  /**
   * save ShortName on IdentifiedObject
   *
   * @param command AssignShortNameToIdentifiedObjectCommand
   */
  @PutMapping("/assignShortName")
  public void assignShortName(@RequestBody AssignShortNameToIdentifiedObjectCommand command) {
    try {
      IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().assignShortName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ShortName", exc);
    }
  }

  /**
   * unassign ShortName on IdentifiedObject
   *
   * @param command UnAssignShortNameFromIdentifiedObjectCommand
   */
  @PutMapping("/unAssignShortName")
  public void unAssignShortName(
      @RequestBody(required = true) UnAssignShortNameFromIdentifiedObjectCommand command) {
    try {
      IdentifiedObjectBusinessDelegate.getIdentifiedObjectInstance().unAssignShortName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ShortName", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected IdentifiedObject identifiedObject = null;
  private static final Logger LOGGER =
      Logger.getLogger(IdentifiedObjectCommandRestController.class.getName());
}
