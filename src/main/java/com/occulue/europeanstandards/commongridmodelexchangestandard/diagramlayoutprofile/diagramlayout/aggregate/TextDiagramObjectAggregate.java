package com.occulue.europeanstandards.commongridmodelexchangestandard.diagramlayoutprofile.diagramlayout.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * Aggregate handler for TextDiagramObject as outlined for the CQRS pattern, all write
 * responsibilities related to TextDiagramObject are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class TextDiagramObjectAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public TextDiagramObjectAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public TextDiagramObjectAggregate(CreateTextDiagramObjectCommand command) throws Exception {
    LOGGER.info("Handling command CreateTextDiagramObjectCommand");
    CreateTextDiagramObjectEvent event =
        new CreateTextDiagramObjectEvent(command.getTextDiagramObjectId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateTextDiagramObjectCommand command) throws Exception {
    LOGGER.info("handling command UpdateTextDiagramObjectCommand");
    UpdateTextDiagramObjectEvent event =
        new UpdateTextDiagramObjectEvent(command.getTextDiagramObjectId(), command.getText());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteTextDiagramObjectCommand command) throws Exception {
    LOGGER.info("Handling command DeleteTextDiagramObjectCommand");
    apply(new DeleteTextDiagramObjectEvent(command.getTextDiagramObjectId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignTextToTextDiagramObjectCommand command) throws Exception {
    LOGGER.info("Handling command AssignTextToTextDiagramObjectCommand");

    if (text != null && text.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "Text already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignTextToTextDiagramObjectEvent(
            command.getTextDiagramObjectId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTextFromTextDiagramObjectCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTextFromTextDiagramObjectCommand");

    if (text == null) throw new ProcessingException("Text already has nothing assigned.");

    apply(new UnAssignTextFromTextDiagramObjectEvent(command.getTextDiagramObjectId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateTextDiagramObjectEvent event) {
    LOGGER.info("Event sourcing CreateTextDiagramObjectEvent");
    this.textDiagramObjectId = event.getTextDiagramObjectId();
  }

  @EventSourcingHandler
  void on(UpdateTextDiagramObjectEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.text = event.getText();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignTextToTextDiagramObjectEvent event) {
    LOGGER.info("Event sourcing AssignTextToTextDiagramObjectEvent");
    this.text = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTextFromTextDiagramObjectEvent event) {
    LOGGER.info("Event sourcing UnAssignTextFromTextDiagramObjectEvent");
    this.text = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID textDiagramObjectId;

  private StringProxy text = null;

  private static final Logger LOGGER = Logger.getLogger(TextDiagramObjectAggregate.class.getName());
}
