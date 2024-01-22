package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyprofile.aggregate;

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
 * Aggregate handler for TopologyVersion as outlined for the CQRS pattern, all write
 * responsibilities related to TopologyVersion are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class TopologyVersionAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public TopologyVersionAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public TopologyVersionAggregate(CreateTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handling command CreateTopologyVersionCommand");
    CreateTopologyVersionEvent event =
        new CreateTopologyVersionEvent(command.getTopologyVersionId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateTopologyVersionCommand command) throws Exception {
    LOGGER.info("handling command UpdateTopologyVersionCommand");
    UpdateTopologyVersionEvent event =
        new UpdateTopologyVersionEvent(
            command.getTopologyVersionId(),
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
  public void handle(DeleteTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handling command DeleteTopologyVersionCommand");
    apply(new DeleteTopologyVersionEvent(command.getTopologyVersionId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBaseUMLToTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseUMLToTopologyVersionCommand");

    if (baseUML != null && baseUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseUMLToTopologyVersionEvent(
            command.getTopologyVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseUMLFromTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseUMLFromTopologyVersionCommand");

    if (baseUML == null) throw new ProcessingException("BaseUML already has nothing assigned.");

    apply(new UnAssignBaseUMLFromTopologyVersionEvent(command.getTopologyVersionId()));
  }

  @CommandHandler
  public void handle(AssignBaseURIToTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseURIToTopologyVersionCommand");

    if (baseURI != null && baseURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseURIToTopologyVersionEvent(
            command.getTopologyVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseURIFromTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBaseURIFromTopologyVersionCommand");

    if (baseURI == null) throw new ProcessingException("BaseURI already has nothing assigned.");

    apply(new UnAssignBaseURIFromTopologyVersionEvent(command.getTopologyVersionId()));
  }

  @CommandHandler
  public void handle(AssignDateToTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignDateToTopologyVersionCommand");

    if (date != null && date.getDateProxyId() == command.getAssignment().getDateProxyId())
      throw new ProcessingException(
          "Date already assigned with id " + command.getAssignment().getDateProxyId());

    apply(
        new AssignDateToTopologyVersionEvent(
            command.getTopologyVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDateFromTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDateFromTopologyVersionCommand");

    if (date == null) throw new ProcessingException("Date already has nothing assigned.");

    apply(new UnAssignDateFromTopologyVersionEvent(command.getTopologyVersionId()));
  }

  @CommandHandler
  public void handle(AssignDifferenceModelURIToTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignDifferenceModelURIToTopologyVersionCommand");

    if (differenceModelURI != null
        && differenceModelURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "DifferenceModelURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignDifferenceModelURIToTopologyVersionEvent(
            command.getTopologyVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDifferenceModelURIFromTopologyVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignDifferenceModelURIFromTopologyVersionCommand");

    if (differenceModelURI == null)
      throw new ProcessingException("DifferenceModelURI already has nothing assigned.");

    apply(new UnAssignDifferenceModelURIFromTopologyVersionEvent(command.getTopologyVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeUMLToTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeUMLToTopologyVersionCommand");

    if (entsoeUML != null
        && entsoeUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeUMLToTopologyVersionEvent(
            command.getTopologyVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeUMLFromTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeUMLFromTopologyVersionCommand");

    if (entsoeUML == null) throw new ProcessingException("EntsoeUML already has nothing assigned.");

    apply(new UnAssignEntsoeUMLFromTopologyVersionEvent(command.getTopologyVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeURIToTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignEntsoeURIToTopologyVersionCommand");

    if (entsoeURI != null
        && entsoeURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeURIToTopologyVersionEvent(
            command.getTopologyVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeURIFromTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeURIFromTopologyVersionCommand");

    if (entsoeURI == null) throw new ProcessingException("EntsoeURI already has nothing assigned.");

    apply(new UnAssignEntsoeURIFromTopologyVersionEvent(command.getTopologyVersionId()));
  }

  @CommandHandler
  public void handle(AssignModelDescriptionURIToTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignModelDescriptionURIToTopologyVersionCommand");

    if (modelDescriptionURI != null
        && modelDescriptionURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ModelDescriptionURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignModelDescriptionURIToTopologyVersionEvent(
            command.getTopologyVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignModelDescriptionURIFromTopologyVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignModelDescriptionURIFromTopologyVersionCommand");

    if (modelDescriptionURI == null)
      throw new ProcessingException("ModelDescriptionURI already has nothing assigned.");

    apply(new UnAssignModelDescriptionURIFromTopologyVersionEvent(command.getTopologyVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceRDFToTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignNamespaceRDFToTopologyVersionCommand");

    if (namespaceRDF != null
        && namespaceRDF.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceRDF already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceRDFToTopologyVersionEvent(
            command.getTopologyVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceRDFFromTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceRDFFromTopologyVersionCommand");

    if (namespaceRDF == null)
      throw new ProcessingException("NamespaceRDF already has nothing assigned.");

    apply(new UnAssignNamespaceRDFFromTopologyVersionEvent(command.getTopologyVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceUMLToTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignNamespaceUMLToTopologyVersionCommand");

    if (namespaceUML != null
        && namespaceUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceUMLToTopologyVersionEvent(
            command.getTopologyVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceUMLFromTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceUMLFromTopologyVersionCommand");

    if (namespaceUML == null)
      throw new ProcessingException("NamespaceUML already has nothing assigned.");

    apply(new UnAssignNamespaceUMLFromTopologyVersionEvent(command.getTopologyVersionId()));
  }

  @CommandHandler
  public void handle(AssignShortNameToTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignShortNameToTopologyVersionCommand");

    if (shortName != null
        && shortName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ShortName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignShortNameToTopologyVersionEvent(
            command.getTopologyVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignShortNameFromTopologyVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignShortNameFromTopologyVersionCommand");

    if (shortName == null) throw new ProcessingException("ShortName already has nothing assigned.");

    apply(new UnAssignShortNameFromTopologyVersionEvent(command.getTopologyVersionId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateTopologyVersionEvent event) {
    LOGGER.info("Event sourcing CreateTopologyVersionEvent");
    this.topologyVersionId = event.getTopologyVersionId();
  }

  @EventSourcingHandler
  void on(UpdateTopologyVersionEvent event) {
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
  void on(AssignBaseUMLToTopologyVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseUMLToTopologyVersionEvent");
    this.baseUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseUMLFromTopologyVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseUMLFromTopologyVersionEvent");
    this.baseUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBaseURIToTopologyVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseURIToTopologyVersionEvent");
    this.baseURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseURIFromTopologyVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseURIFromTopologyVersionEvent");
    this.baseURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDateToTopologyVersionEvent event) {
    LOGGER.info("Event sourcing AssignDateToTopologyVersionEvent");
    this.date = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDateFromTopologyVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDateFromTopologyVersionEvent");
    this.date = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDifferenceModelURIToTopologyVersionEvent event) {
    LOGGER.info("Event sourcing AssignDifferenceModelURIToTopologyVersionEvent");
    this.differenceModelURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDifferenceModelURIFromTopologyVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDifferenceModelURIFromTopologyVersionEvent");
    this.differenceModelURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeUMLToTopologyVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeUMLToTopologyVersionEvent");
    this.entsoeUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeUMLFromTopologyVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeUMLFromTopologyVersionEvent");
    this.entsoeUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeURIToTopologyVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeURIToTopologyVersionEvent");
    this.entsoeURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeURIFromTopologyVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeURIFromTopologyVersionEvent");
    this.entsoeURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignModelDescriptionURIToTopologyVersionEvent event) {
    LOGGER.info("Event sourcing AssignModelDescriptionURIToTopologyVersionEvent");
    this.modelDescriptionURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignModelDescriptionURIFromTopologyVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignModelDescriptionURIFromTopologyVersionEvent");
    this.modelDescriptionURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceRDFToTopologyVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceRDFToTopologyVersionEvent");
    this.namespaceRDF = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceRDFFromTopologyVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceRDFFromTopologyVersionEvent");
    this.namespaceRDF = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceUMLToTopologyVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceUMLToTopologyVersionEvent");
    this.namespaceUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceUMLFromTopologyVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceUMLFromTopologyVersionEvent");
    this.namespaceUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignShortNameToTopologyVersionEvent event) {
    LOGGER.info("Event sourcing AssignShortNameToTopologyVersionEvent");
    this.shortName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignShortNameFromTopologyVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignShortNameFromTopologyVersionEvent");
    this.shortName = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID topologyVersionId;

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

  private static final Logger LOGGER = Logger.getLogger(TopologyVersionAggregate.class.getName());
}
