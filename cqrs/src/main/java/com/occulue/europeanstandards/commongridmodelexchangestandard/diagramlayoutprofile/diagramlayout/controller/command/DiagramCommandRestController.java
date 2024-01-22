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
package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity Diagram.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Diagram")
public class DiagramCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Diagram. if not key provided, calls create, otherwise calls save
   *
   * @param Diagram diagram
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDiagramCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = DiagramBusinessDelegate.getDiagramInstance().createDiagram(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Diagram. if no key provided, calls create, otherwise calls save
   *
   * @param Diagram diagram
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDiagramCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDiagramCommand
      // -----------------------------------------------
      completableFuture = DiagramBusinessDelegate.getDiagramInstance().updateDiagram(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DiagramController:update() - successfully update Diagram - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Diagram entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID diagramId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDiagramCommand command = new DeleteDiagramCommand(diagramId);

    try {
      DiagramBusinessDelegate delegate = DiagramBusinessDelegate.getDiagramInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(Level.WARNING, "Successfully deleted Diagram with key " + command.getDiagramId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save X1InitialView on Diagram
   *
   * @param command AssignX1InitialViewToDiagramCommand
   */
  @PutMapping("/assignX1InitialView")
  public void assignX1InitialView(@RequestBody AssignX1InitialViewToDiagramCommand command) {
    try {
      DiagramBusinessDelegate.getDiagramInstance().assignX1InitialView(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X1InitialView", exc);
    }
  }

  /**
   * unassign X1InitialView on Diagram
   *
   * @param command UnAssignX1InitialViewFromDiagramCommand
   */
  @PutMapping("/unAssignX1InitialView")
  public void unAssignX1InitialView(
      @RequestBody(required = true) UnAssignX1InitialViewFromDiagramCommand command) {
    try {
      DiagramBusinessDelegate.getDiagramInstance().unAssignX1InitialView(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X1InitialView", exc);
    }
  }

  /**
   * save X2InitialView on Diagram
   *
   * @param command AssignX2InitialViewToDiagramCommand
   */
  @PutMapping("/assignX2InitialView")
  public void assignX2InitialView(@RequestBody AssignX2InitialViewToDiagramCommand command) {
    try {
      DiagramBusinessDelegate.getDiagramInstance().assignX2InitialView(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign X2InitialView", exc);
    }
  }

  /**
   * unassign X2InitialView on Diagram
   *
   * @param command UnAssignX2InitialViewFromDiagramCommand
   */
  @PutMapping("/unAssignX2InitialView")
  public void unAssignX2InitialView(
      @RequestBody(required = true) UnAssignX2InitialViewFromDiagramCommand command) {
    try {
      DiagramBusinessDelegate.getDiagramInstance().unAssignX2InitialView(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign X2InitialView", exc);
    }
  }

  /**
   * save Y1InitialView on Diagram
   *
   * @param command AssignY1InitialViewToDiagramCommand
   */
  @PutMapping("/assignY1InitialView")
  public void assignY1InitialView(@RequestBody AssignY1InitialViewToDiagramCommand command) {
    try {
      DiagramBusinessDelegate.getDiagramInstance().assignY1InitialView(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Y1InitialView", exc);
    }
  }

  /**
   * unassign Y1InitialView on Diagram
   *
   * @param command UnAssignY1InitialViewFromDiagramCommand
   */
  @PutMapping("/unAssignY1InitialView")
  public void unAssignY1InitialView(
      @RequestBody(required = true) UnAssignY1InitialViewFromDiagramCommand command) {
    try {
      DiagramBusinessDelegate.getDiagramInstance().unAssignY1InitialView(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Y1InitialView", exc);
    }
  }

  /**
   * save Y2InitialView on Diagram
   *
   * @param command AssignY2InitialViewToDiagramCommand
   */
  @PutMapping("/assignY2InitialView")
  public void assignY2InitialView(@RequestBody AssignY2InitialViewToDiagramCommand command) {
    try {
      DiagramBusinessDelegate.getDiagramInstance().assignY2InitialView(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Y2InitialView", exc);
    }
  }

  /**
   * unassign Y2InitialView on Diagram
   *
   * @param command UnAssignY2InitialViewFromDiagramCommand
   */
  @PutMapping("/unAssignY2InitialView")
  public void unAssignY2InitialView(
      @RequestBody(required = true) UnAssignY2InitialViewFromDiagramCommand command) {
    try {
      DiagramBusinessDelegate.getDiagramInstance().unAssignY2InitialView(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Y2InitialView", exc);
    }
  }

  /**
   * save Diagram on Diagram
   *
   * @param command AssignDiagramToDiagramCommand
   */
  @PutMapping("/addToDiagram")
  public void addToDiagram(@RequestBody(required = true) AssignDiagramToDiagramCommand command) {
    try {
      DiagramBusinessDelegate.getDiagramInstance().addToDiagram(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set Diagram", exc);
    }
  }

  /**
   * remove Diagram on Diagram
   *
   * @param command RemoveDiagramFromDiagramCommand
   */
  @PutMapping("/removeFromDiagram")
  public void removeFromDiagram(
      @RequestBody(required = true) RemoveDiagramFromDiagramCommand command) {
    try {
      DiagramBusinessDelegate.getDiagramInstance().removeFromDiagram(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set Diagram", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Diagram diagram = null;
  private static final Logger LOGGER =
      Logger.getLogger(DiagramCommandRestController.class.getName());
}
