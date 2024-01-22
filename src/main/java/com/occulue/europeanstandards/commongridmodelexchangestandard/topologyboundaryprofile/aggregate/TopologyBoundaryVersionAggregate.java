package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.aggregate;

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
 * Aggregate handler for TopologyBoundaryVersion as outlined for the CQRS pattern, all write
 * responsibilities related to TopologyBoundaryVersion are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class TopologyBoundaryVersionAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public TopologyBoundaryVersionAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public TopologyBoundaryVersionAggregate(CreateTopologyBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateTopologyBoundaryVersionCommand");
    CreateTopologyBoundaryVersionEvent event =
        new CreateTopologyBoundaryVersionEvent(command.getTopologyBoundaryVersionId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("handling command UpdateTopologyBoundaryVersionCommand");
    UpdateTopologyBoundaryVersionEvent event =
        new UpdateTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId(),
            command.getBaseUML(),
            command.getBaseURI(),
            command.getDate(),
            command.getDifferenceModelURI(),
            command.getEntsoeUML(),
            command.getEntsoeURI(),
            command.getModelDescriptionURI(),
            command.getNamespaceRDF(),
            command.getNamespaceUML(),
            command.getShortName());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command DeleteTopologyBoundaryVersionCommand");
    apply(new DeleteTopologyBoundaryVersionEvent(command.getTopologyBoundaryVersionId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBaseUMLToTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseUMLToTopologyBoundaryVersionCommand");

    if (baseUML != null && baseUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseUMLToTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseUMLFromTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseUMLFromTopologyBoundaryVersionCommand");

    if (baseUML == null) throw new ProcessingException("BaseUML already has nothing assigned.");

    apply(
        new UnAssignBaseUMLFromTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignBaseURIToTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseURIToTopologyBoundaryVersionCommand");

    if (baseURI != null && baseURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseURIToTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseURIFromTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseURIFromTopologyBoundaryVersionCommand");

    if (baseURI == null) throw new ProcessingException("BaseURI already has nothing assigned.");

    apply(
        new UnAssignBaseURIFromTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignDateToTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignDateToTopologyBoundaryVersionCommand");

    if (date != null && date.getDateProxyId() == command.getAssignment().getDateProxyId())
      throw new ProcessingException(
          "Date already assigned with id " + command.getAssignment().getDateProxyId());

    apply(
        new AssignDateToTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDateFromTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDateFromTopologyBoundaryVersionCommand");

    if (date == null) throw new ProcessingException("Date already has nothing assigned.");

    apply(new UnAssignDateFromTopologyBoundaryVersionEvent(command.getTopologyBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignDifferenceModelURIToTopologyBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignDifferenceModelURIToTopologyBoundaryVersionCommand");

    if (differenceModelURI != null
        && differenceModelURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "DifferenceModelURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignDifferenceModelURIToTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDifferenceModelURIFromTopologyBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignDifferenceModelURIFromTopologyBoundaryVersionCommand");

    if (differenceModelURI == null)
      throw new ProcessingException("DifferenceModelURI already has nothing assigned.");

    apply(
        new UnAssignDifferenceModelURIFromTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeUMLToTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeUMLToTopologyBoundaryVersionCommand");

    if (entsoeUML != null
        && entsoeUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeUMLToTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeUMLFromTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeUMLFromTopologyBoundaryVersionCommand");

    if (entsoeUML == null) throw new ProcessingException("EntsoeUML already has nothing assigned.");

    apply(
        new UnAssignEntsoeUMLFromTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeURIToTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeURIToTopologyBoundaryVersionCommand");

    if (entsoeURI != null
        && entsoeURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeURIToTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeURIFromTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeURIFromTopologyBoundaryVersionCommand");

    if (entsoeURI == null) throw new ProcessingException("EntsoeURI already has nothing assigned.");

    apply(
        new UnAssignEntsoeURIFromTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignModelDescriptionURIToTopologyBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignModelDescriptionURIToTopologyBoundaryVersionCommand");

    if (modelDescriptionURI != null
        && modelDescriptionURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ModelDescriptionURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignModelDescriptionURIToTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignModelDescriptionURIFromTopologyBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignModelDescriptionURIFromTopologyBoundaryVersionCommand");

    if (modelDescriptionURI == null)
      throw new ProcessingException("ModelDescriptionURI already has nothing assigned.");

    apply(
        new UnAssignModelDescriptionURIFromTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceRDFToTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignNamespaceRDFToTopologyBoundaryVersionCommand");

    if (namespaceRDF != null
        && namespaceRDF.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceRDF already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceRDFToTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceRDFFromTopologyBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceRDFFromTopologyBoundaryVersionCommand");

    if (namespaceRDF == null)
      throw new ProcessingException("NamespaceRDF already has nothing assigned.");

    apply(
        new UnAssignNamespaceRDFFromTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceUMLToTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignNamespaceUMLToTopologyBoundaryVersionCommand");

    if (namespaceUML != null
        && namespaceUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceUMLToTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceUMLFromTopologyBoundaryVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceUMLFromTopologyBoundaryVersionCommand");

    if (namespaceUML == null)
      throw new ProcessingException("NamespaceUML already has nothing assigned.");

    apply(
        new UnAssignNamespaceUMLFromTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId()));
  }

  @CommandHandler
  public void handle(AssignShortNameToTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignShortNameToTopologyBoundaryVersionCommand");

    if (shortName != null
        && shortName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ShortName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignShortNameToTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignShortNameFromTopologyBoundaryVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignShortNameFromTopologyBoundaryVersionCommand");

    if (shortName == null) throw new ProcessingException("ShortName already has nothing assigned.");

    apply(
        new UnAssignShortNameFromTopologyBoundaryVersionEvent(
            command.getTopologyBoundaryVersionId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing CreateTopologyBoundaryVersionEvent");
    this.topologyBoundaryVersionId = event.getTopologyBoundaryVersionId();
  }

  @EventSourcingHandler
  void on(UpdateTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.baseUML = event.getBaseUML();
    this.baseURI = event.getBaseURI();
    this.date = event.getDate();
    this.differenceModelURI = event.getDifferenceModelURI();
    this.entsoeUML = event.getEntsoeUML();
    this.entsoeURI = event.getEntsoeURI();
    this.modelDescriptionURI = event.getModelDescriptionURI();
    this.namespaceRDF = event.getNamespaceRDF();
    this.namespaceUML = event.getNamespaceUML();
    this.shortName = event.getShortName();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBaseUMLToTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseUMLToTopologyBoundaryVersionEvent");
    this.baseUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseUMLFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseUMLFromTopologyBoundaryVersionEvent");
    this.baseUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBaseURIToTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseURIToTopologyBoundaryVersionEvent");
    this.baseURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseURIFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseURIFromTopologyBoundaryVersionEvent");
    this.baseURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDateToTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignDateToTopologyBoundaryVersionEvent");
    this.date = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDateFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDateFromTopologyBoundaryVersionEvent");
    this.date = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDifferenceModelURIToTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignDifferenceModelURIToTopologyBoundaryVersionEvent");
    this.differenceModelURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDifferenceModelURIFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDifferenceModelURIFromTopologyBoundaryVersionEvent");
    this.differenceModelURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeUMLToTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeUMLToTopologyBoundaryVersionEvent");
    this.entsoeUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeUMLFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeUMLFromTopologyBoundaryVersionEvent");
    this.entsoeUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeURIToTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeURIToTopologyBoundaryVersionEvent");
    this.entsoeURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeURIFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeURIFromTopologyBoundaryVersionEvent");
    this.entsoeURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignModelDescriptionURIToTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignModelDescriptionURIToTopologyBoundaryVersionEvent");
    this.modelDescriptionURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignModelDescriptionURIFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignModelDescriptionURIFromTopologyBoundaryVersionEvent");
    this.modelDescriptionURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceRDFToTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceRDFToTopologyBoundaryVersionEvent");
    this.namespaceRDF = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceRDFFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceRDFFromTopologyBoundaryVersionEvent");
    this.namespaceRDF = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceUMLToTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceUMLToTopologyBoundaryVersionEvent");
    this.namespaceUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceUMLFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceUMLFromTopologyBoundaryVersionEvent");
    this.namespaceUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignShortNameToTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing AssignShortNameToTopologyBoundaryVersionEvent");
    this.shortName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignShortNameFromTopologyBoundaryVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignShortNameFromTopologyBoundaryVersionEvent");
    this.shortName = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID topologyBoundaryVersionId;

  private StringProxy baseUML = null;
  private StringProxy baseURI = null;
  private DateProxy date = null;
  private StringProxy differenceModelURI = null;
  private StringProxy entsoeUML = null;
  private StringProxy entsoeURI = null;
  private StringProxy modelDescriptionURI = null;
  private StringProxy namespaceRDF = null;
  private StringProxy namespaceUML = null;
  private StringProxy shortName = null;

  private static final Logger LOGGER =
      Logger.getLogger(TopologyBoundaryVersionAggregate.class.getName());
}
