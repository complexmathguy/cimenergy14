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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity DynamicsVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DynamicsVersion")
public class DynamicsVersionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a DynamicsVersion. if not key provided, calls create, otherwise calls save
   *
   * @param DynamicsVersion dynamicsVersion
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDynamicsVersionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          DynamicsVersionBusinessDelegate.getDynamicsVersionInstance()
              .createDynamicsVersion(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a DynamicsVersion. if no key provided, calls create, otherwise calls save
   *
   * @param DynamicsVersion dynamicsVersion
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDynamicsVersionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDynamicsVersionCommand
      // -----------------------------------------------
      completableFuture =
          DynamicsVersionBusinessDelegate.getDynamicsVersionInstance()
              .updateDynamicsVersion(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DynamicsVersionController:update() - successfully update DynamicsVersion - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a DynamicsVersion entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID dynamicsVersionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDynamicsVersionCommand command = new DeleteDynamicsVersionCommand(dynamicsVersionId);

    try {
      DynamicsVersionBusinessDelegate delegate =
          DynamicsVersionBusinessDelegate.getDynamicsVersionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted DynamicsVersion with key " + command.getDynamicsVersionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save BaseUML on DynamicsVersion
   *
   * @param command AssignBaseUMLToDynamicsVersionCommand
   */
  @PutMapping("/assignBaseUML")
  public void assignBaseUML(@RequestBody AssignBaseUMLToDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().assignBaseUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseUML", exc);
    }
  }

  /**
   * unassign BaseUML on DynamicsVersion
   *
   * @param command UnAssignBaseUMLFromDynamicsVersionCommand
   */
  @PutMapping("/unAssignBaseUML")
  public void unAssignBaseUML(
      @RequestBody(required = true) UnAssignBaseUMLFromDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().unAssignBaseUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseUML", exc);
    }
  }

  /**
   * save BaseURI on DynamicsVersion
   *
   * @param command AssignBaseURIToDynamicsVersionCommand
   */
  @PutMapping("/assignBaseURI")
  public void assignBaseURI(@RequestBody AssignBaseURIToDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().assignBaseURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign BaseURI", exc);
    }
  }

  /**
   * unassign BaseURI on DynamicsVersion
   *
   * @param command UnAssignBaseURIFromDynamicsVersionCommand
   */
  @PutMapping("/unAssignBaseURI")
  public void unAssignBaseURI(
      @RequestBody(required = true) UnAssignBaseURIFromDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().unAssignBaseURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign BaseURI", exc);
    }
  }

  /**
   * save Date on DynamicsVersion
   *
   * @param command AssignDateToDynamicsVersionCommand
   */
  @PutMapping("/assignDate")
  public void assignDate(@RequestBody AssignDateToDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().assignDate(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Date", exc);
    }
  }

  /**
   * unassign Date on DynamicsVersion
   *
   * @param command UnAssignDateFromDynamicsVersionCommand
   */
  @PutMapping("/unAssignDate")
  public void unAssignDate(
      @RequestBody(required = true) UnAssignDateFromDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().unAssignDate(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Date", exc);
    }
  }

  /**
   * save DifferenceModelURI on DynamicsVersion
   *
   * @param command AssignDifferenceModelURIToDynamicsVersionCommand
   */
  @PutMapping("/assignDifferenceModelURI")
  public void assignDifferenceModelURI(
      @RequestBody AssignDifferenceModelURIToDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance()
          .assignDifferenceModelURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign DifferenceModelURI", exc);
    }
  }

  /**
   * unassign DifferenceModelURI on DynamicsVersion
   *
   * @param command UnAssignDifferenceModelURIFromDynamicsVersionCommand
   */
  @PutMapping("/unAssignDifferenceModelURI")
  public void unAssignDifferenceModelURI(
      @RequestBody(required = true) UnAssignDifferenceModelURIFromDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance()
          .unAssignDifferenceModelURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign DifferenceModelURI", exc);
    }
  }

  /**
   * save EntsoeUML on DynamicsVersion
   *
   * @param command AssignEntsoeUMLToDynamicsVersionCommand
   */
  @PutMapping("/assignEntsoeUML")
  public void assignEntsoeUML(@RequestBody AssignEntsoeUMLToDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().assignEntsoeUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeUML", exc);
    }
  }

  /**
   * unassign EntsoeUML on DynamicsVersion
   *
   * @param command UnAssignEntsoeUMLFromDynamicsVersionCommand
   */
  @PutMapping("/unAssignEntsoeUML")
  public void unAssignEntsoeUML(
      @RequestBody(required = true) UnAssignEntsoeUMLFromDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().unAssignEntsoeUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeUML", exc);
    }
  }

  /**
   * save EntsoeURI on DynamicsVersion
   *
   * @param command AssignEntsoeURIToDynamicsVersionCommand
   */
  @PutMapping("/assignEntsoeURI")
  public void assignEntsoeURI(@RequestBody AssignEntsoeURIToDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().assignEntsoeURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign EntsoeURI", exc);
    }
  }

  /**
   * unassign EntsoeURI on DynamicsVersion
   *
   * @param command UnAssignEntsoeURIFromDynamicsVersionCommand
   */
  @PutMapping("/unAssignEntsoeURI")
  public void unAssignEntsoeURI(
      @RequestBody(required = true) UnAssignEntsoeURIFromDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().unAssignEntsoeURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign EntsoeURI", exc);
    }
  }

  /**
   * save ModelDescriptionURI on DynamicsVersion
   *
   * @param command AssignModelDescriptionURIToDynamicsVersionCommand
   */
  @PutMapping("/assignModelDescriptionURI")
  public void assignModelDescriptionURI(
      @RequestBody AssignModelDescriptionURIToDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance()
          .assignModelDescriptionURI(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ModelDescriptionURI", exc);
    }
  }

  /**
   * unassign ModelDescriptionURI on DynamicsVersion
   *
   * @param command UnAssignModelDescriptionURIFromDynamicsVersionCommand
   */
  @PutMapping("/unAssignModelDescriptionURI")
  public void unAssignModelDescriptionURI(
      @RequestBody(required = true) UnAssignModelDescriptionURIFromDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance()
          .unAssignModelDescriptionURI(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ModelDescriptionURI", exc);
    }
  }

  /**
   * save NamespaceRDF on DynamicsVersion
   *
   * @param command AssignNamespaceRDFToDynamicsVersionCommand
   */
  @PutMapping("/assignNamespaceRDF")
  public void assignNamespaceRDF(@RequestBody AssignNamespaceRDFToDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().assignNamespaceRDF(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceRDF", exc);
    }
  }

  /**
   * unassign NamespaceRDF on DynamicsVersion
   *
   * @param command UnAssignNamespaceRDFFromDynamicsVersionCommand
   */
  @PutMapping("/unAssignNamespaceRDF")
  public void unAssignNamespaceRDF(
      @RequestBody(required = true) UnAssignNamespaceRDFFromDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().unAssignNamespaceRDF(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceRDF", exc);
    }
  }

  /**
   * save NamespaceUML on DynamicsVersion
   *
   * @param command AssignNamespaceUMLToDynamicsVersionCommand
   */
  @PutMapping("/assignNamespaceUML")
  public void assignNamespaceUML(@RequestBody AssignNamespaceUMLToDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().assignNamespaceUML(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign NamespaceUML", exc);
    }
  }

  /**
   * unassign NamespaceUML on DynamicsVersion
   *
   * @param command UnAssignNamespaceUMLFromDynamicsVersionCommand
   */
  @PutMapping("/unAssignNamespaceUML")
  public void unAssignNamespaceUML(
      @RequestBody(required = true) UnAssignNamespaceUMLFromDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().unAssignNamespaceUML(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign NamespaceUML", exc);
    }
  }

  /**
   * save ShortName on DynamicsVersion
   *
   * @param command AssignShortNameToDynamicsVersionCommand
   */
  @PutMapping("/assignShortName")
  public void assignShortName(@RequestBody AssignShortNameToDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().assignShortName(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign ShortName", exc);
    }
  }

  /**
   * unassign ShortName on DynamicsVersion
   *
   * @param command UnAssignShortNameFromDynamicsVersionCommand
   */
  @PutMapping("/unAssignShortName")
  public void unAssignShortName(
      @RequestBody(required = true) UnAssignShortNameFromDynamicsVersionCommand command) {
    try {
      DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().unAssignShortName(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign ShortName", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DynamicsVersion dynamicsVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(DynamicsVersionCommandRestController.class.getName());
}
