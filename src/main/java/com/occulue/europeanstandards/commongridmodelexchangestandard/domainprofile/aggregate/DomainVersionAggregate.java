package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.aggregate;

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
 * Aggregate handler for DomainVersion as outlined for the CQRS pattern, all write responsibilities
 * related to DomainVersion are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DomainVersionAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DomainVersionAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DomainVersionAggregate(CreateDomainVersionCommand command) throws Exception {
    LOGGER.info("Handling command CreateDomainVersionCommand");
    CreateDomainVersionEvent event = new CreateDomainVersionEvent(command.getDomainVersionId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDomainVersionCommand command) throws Exception {
    LOGGER.info("handling command UpdateDomainVersionCommand");
    UpdateDomainVersionEvent event =
        new UpdateDomainVersionEvent(
            command.getDomainVersionId(),
            command.getBaseUML(),
            command.getDate(),
            command.getEntsoeUML(),
            command.getVersion());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDomainVersionCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDomainVersionCommand");
    apply(new DeleteDomainVersionEvent(command.getDomainVersionId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBaseUMLToDomainVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseUMLToDomainVersionCommand");

    if (baseUML != null && baseUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseUMLToDomainVersionEvent(
            command.getDomainVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseUMLFromDomainVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseUMLFromDomainVersionCommand");

    if (baseUML == null) throw new ProcessingException("BaseUML already has nothing assigned.");

    apply(new UnAssignBaseUMLFromDomainVersionEvent(command.getDomainVersionId()));
  }

  @CommandHandler
  public void handle(AssignDateToDomainVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignDateToDomainVersionCommand");

    if (date != null && date.getDateProxyId() == command.getAssignment().getDateProxyId())
      throw new ProcessingException(
          "Date already assigned with id " + command.getAssignment().getDateProxyId());

    apply(
        new AssignDateToDomainVersionEvent(command.getDomainVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDateFromDomainVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDateFromDomainVersionCommand");

    if (date == null) throw new ProcessingException("Date already has nothing assigned.");

    apply(new UnAssignDateFromDomainVersionEvent(command.getDomainVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeUMLToDomainVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeUMLToDomainVersionCommand");

    if (entsoeUML != null
        && entsoeUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeUMLToDomainVersionEvent(
            command.getDomainVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeUMLFromDomainVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeUMLFromDomainVersionCommand");

    if (entsoeUML == null) throw new ProcessingException("EntsoeUML already has nothing assigned.");

    apply(new UnAssignEntsoeUMLFromDomainVersionEvent(command.getDomainVersionId()));
  }

  @CommandHandler
  public void handle(AssignVersionToDomainVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignVersionToDomainVersionCommand");

    if (version != null && version.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "Version already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignVersionToDomainVersionEvent(
            command.getDomainVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVersionFromDomainVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVersionFromDomainVersionCommand");

    if (version == null) throw new ProcessingException("Version already has nothing assigned.");

    apply(new UnAssignVersionFromDomainVersionEvent(command.getDomainVersionId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDomainVersionEvent event) {
    LOGGER.info("Event sourcing CreateDomainVersionEvent");
    this.domainVersionId = event.getDomainVersionId();
  }

  @EventSourcingHandler
  void on(UpdateDomainVersionEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.baseUML = event.getBaseUML();
    this.date = event.getDate();
    this.entsoeUML = event.getEntsoeUML();
    this.version = event.getVersion();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBaseUMLToDomainVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseUMLToDomainVersionEvent");
    this.baseUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseUMLFromDomainVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseUMLFromDomainVersionEvent");
    this.baseUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDateToDomainVersionEvent event) {
    LOGGER.info("Event sourcing AssignDateToDomainVersionEvent");
    this.date = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDateFromDomainVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDateFromDomainVersionEvent");
    this.date = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeUMLToDomainVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeUMLToDomainVersionEvent");
    this.entsoeUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeUMLFromDomainVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeUMLFromDomainVersionEvent");
    this.entsoeUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVersionToDomainVersionEvent event) {
    LOGGER.info("Event sourcing AssignVersionToDomainVersionEvent");
    this.version = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVersionFromDomainVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignVersionFromDomainVersionEvent");
    this.version = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID domainVersionId;

  private StringProxy baseUML = null;
  private DateProxy date = null;
  private StringProxy entsoeUML = null;
  private StringProxy version = null;

  private static final Logger LOGGER = Logger.getLogger(DomainVersionAggregate.class.getName());
}
