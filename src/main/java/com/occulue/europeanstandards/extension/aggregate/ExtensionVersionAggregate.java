package com.occulue.europeanstandards.extension.aggregate;

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
 * Aggregate handler for ExtensionVersion as outlined for the CQRS pattern, all write
 * responsibilities related to ExtensionVersion are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExtensionVersionAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExtensionVersionAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExtensionVersionAggregate(CreateExtensionVersionCommand command) throws Exception {
    LOGGER.info("Handling command CreateExtensionVersionCommand");
    CreateExtensionVersionEvent event =
        new CreateExtensionVersionEvent(command.getExtensionVersionId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExtensionVersionCommand command) throws Exception {
    LOGGER.info("handling command UpdateExtensionVersionCommand");
    UpdateExtensionVersionEvent event =
        new UpdateExtensionVersionEvent(
            command.getExtensionVersionId(), command.getDate(), command.getNamespaceURI());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExtensionVersionCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExtensionVersionCommand");
    apply(new DeleteExtensionVersionEvent(command.getExtensionVersionId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDateToExtensionVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignDateToExtensionVersionCommand");

    if (date != null && date.getDateProxyId() == command.getAssignment().getDateProxyId())
      throw new ProcessingException(
          "Date already assigned with id " + command.getAssignment().getDateProxyId());

    apply(
        new AssignDateToExtensionVersionEvent(
            command.getExtensionVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDateFromExtensionVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDateFromExtensionVersionCommand");

    if (date == null) throw new ProcessingException("Date already has nothing assigned.");

    apply(new UnAssignDateFromExtensionVersionEvent(command.getExtensionVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceURIToExtensionVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignNamespaceURIToExtensionVersionCommand");

    if (namespaceURI != null
        && namespaceURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceURIToExtensionVersionEvent(
            command.getExtensionVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceURIFromExtensionVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceURIFromExtensionVersionCommand");

    if (namespaceURI == null)
      throw new ProcessingException("NamespaceURI already has nothing assigned.");

    apply(new UnAssignNamespaceURIFromExtensionVersionEvent(command.getExtensionVersionId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExtensionVersionEvent event) {
    LOGGER.info("Event sourcing CreateExtensionVersionEvent");
    this.extensionVersionId = event.getExtensionVersionId();
  }

  @EventSourcingHandler
  void on(UpdateExtensionVersionEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.date = event.getDate();
    this.namespaceURI = event.getNamespaceURI();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDateToExtensionVersionEvent event) {
    LOGGER.info("Event sourcing AssignDateToExtensionVersionEvent");
    this.date = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDateFromExtensionVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDateFromExtensionVersionEvent");
    this.date = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceURIToExtensionVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceURIToExtensionVersionEvent");
    this.namespaceURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceURIFromExtensionVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceURIFromExtensionVersionEvent");
    this.namespaceURI = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID extensionVersionId;

  private DateProxy date = null;
  private StringProxy namespaceURI = null;

  private static final Logger LOGGER = Logger.getLogger(ExtensionVersionAggregate.class.getName());
}
