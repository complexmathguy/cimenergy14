package com.occulue.europeanstandards.commongridmodelexchangestandard.steadystatehypothesisprofile.aggregate;

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
 * Aggregate handler for SteadyStateHypothesisVersion as outlined for the CQRS pattern, all write
 * responsibilities related to SteadyStateHypothesisVersion are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SteadyStateHypothesisVersionAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SteadyStateHypothesisVersionAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SteadyStateHypothesisVersionAggregate(CreateSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateSteadyStateHypothesisVersionCommand");
    CreateSteadyStateHypothesisVersionEvent event =
        new CreateSteadyStateHypothesisVersionEvent(command.getSteadyStateHypothesisVersionId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSteadyStateHypothesisVersionCommand command) throws Exception {
    LOGGER.info("handling command UpdateSteadyStateHypothesisVersionCommand");
    UpdateSteadyStateHypothesisVersionEvent event =
        new UpdateSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId(),
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
  public void handle(DeleteSteadyStateHypothesisVersionCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSteadyStateHypothesisVersionCommand");
    apply(new DeleteSteadyStateHypothesisVersionEvent(command.getSteadyStateHypothesisVersionId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBaseUMLToSteadyStateHypothesisVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseUMLToSteadyStateHypothesisVersionCommand");

    if (baseUML != null && baseUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseUMLToSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseUMLFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignBaseUMLFromSteadyStateHypothesisVersionCommand");

    if (baseUML == null) throw new ProcessingException("BaseUML already has nothing assigned.");

    apply(
        new UnAssignBaseUMLFromSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId()));
  }

  @CommandHandler
  public void handle(AssignBaseURIToSteadyStateHypothesisVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignBaseURIToSteadyStateHypothesisVersionCommand");

    if (baseURI != null && baseURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "BaseURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignBaseURIToSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBaseURIFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignBaseURIFromSteadyStateHypothesisVersionCommand");

    if (baseURI == null) throw new ProcessingException("BaseURI already has nothing assigned.");

    apply(
        new UnAssignBaseURIFromSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId()));
  }

  @CommandHandler
  public void handle(AssignDateToSteadyStateHypothesisVersionCommand command) throws Exception {
    LOGGER.info("Handling command AssignDateToSteadyStateHypothesisVersionCommand");

    if (date != null && date.getDateProxyId() == command.getAssignment().getDateProxyId())
      throw new ProcessingException(
          "Date already assigned with id " + command.getAssignment().getDateProxyId());

    apply(
        new AssignDateToSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDateFromSteadyStateHypothesisVersionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDateFromSteadyStateHypothesisVersionCommand");

    if (date == null) throw new ProcessingException("Date already has nothing assigned.");

    apply(
        new UnAssignDateFromSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId()));
  }

  @CommandHandler
  public void handle(AssignDifferenceModelURIToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignDifferenceModelURIToSteadyStateHypothesisVersionCommand");

    if (differenceModelURI != null
        && differenceModelURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "DifferenceModelURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignDifferenceModelURIToSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionCommand");

    if (differenceModelURI == null)
      throw new ProcessingException("DifferenceModelURI already has nothing assigned.");

    apply(
        new UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeUMLToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignEntsoeUMLToSteadyStateHypothesisVersionCommand");

    if (entsoeUML != null
        && entsoeUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeUMLToSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeUMLFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeUMLFromSteadyStateHypothesisVersionCommand");

    if (entsoeUML == null) throw new ProcessingException("EntsoeUML already has nothing assigned.");

    apply(
        new UnAssignEntsoeUMLFromSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId()));
  }

  @CommandHandler
  public void handle(AssignEntsoeURIToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignEntsoeURIToSteadyStateHypothesisVersionCommand");

    if (entsoeURI != null
        && entsoeURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "EntsoeURI already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignEntsoeURIToSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEntsoeURIFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignEntsoeURIFromSteadyStateHypothesisVersionCommand");

    if (entsoeURI == null) throw new ProcessingException("EntsoeURI already has nothing assigned.");

    apply(
        new UnAssignEntsoeURIFromSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId()));
  }

  @CommandHandler
  public void handle(AssignModelDescriptionURIToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignModelDescriptionURIToSteadyStateHypothesisVersionCommand");

    if (modelDescriptionURI != null
        && modelDescriptionURI.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ModelDescriptionURI already assigned with id "
              + command.getAssignment().getStringProxyId());

    apply(
        new AssignModelDescriptionURIToSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionCommand");

    if (modelDescriptionURI == null)
      throw new ProcessingException("ModelDescriptionURI already has nothing assigned.");

    apply(
        new UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceRDFToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignNamespaceRDFToSteadyStateHypothesisVersionCommand");

    if (namespaceRDF != null
        && namespaceRDF.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceRDF already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceRDFToSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceRDFFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceRDFFromSteadyStateHypothesisVersionCommand");

    if (namespaceRDF == null)
      throw new ProcessingException("NamespaceRDF already has nothing assigned.");

    apply(
        new UnAssignNamespaceRDFFromSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId()));
  }

  @CommandHandler
  public void handle(AssignNamespaceUMLToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignNamespaceUMLToSteadyStateHypothesisVersionCommand");

    if (namespaceUML != null
        && namespaceUML.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "NamespaceUML already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignNamespaceUMLToSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNamespaceUMLFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignNamespaceUMLFromSteadyStateHypothesisVersionCommand");

    if (namespaceUML == null)
      throw new ProcessingException("NamespaceUML already has nothing assigned.");

    apply(
        new UnAssignNamespaceUMLFromSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId()));
  }

  @CommandHandler
  public void handle(AssignShortNameToSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignShortNameToSteadyStateHypothesisVersionCommand");

    if (shortName != null
        && shortName.getStringProxyId() == command.getAssignment().getStringProxyId())
      throw new ProcessingException(
          "ShortName already assigned with id " + command.getAssignment().getStringProxyId());

    apply(
        new AssignShortNameToSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignShortNameFromSteadyStateHypothesisVersionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignShortNameFromSteadyStateHypothesisVersionCommand");

    if (shortName == null) throw new ProcessingException("ShortName already has nothing assigned.");

    apply(
        new UnAssignShortNameFromSteadyStateHypothesisVersionEvent(
            command.getSteadyStateHypothesisVersionId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing CreateSteadyStateHypothesisVersionEvent");
    this.steadyStateHypothesisVersionId = event.getSteadyStateHypothesisVersionId();
  }

  @EventSourcingHandler
  void on(UpdateSteadyStateHypothesisVersionEvent event) {
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
  void on(AssignBaseUMLToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseUMLToSteadyStateHypothesisVersionEvent");
    this.baseUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseUMLFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseUMLFromSteadyStateHypothesisVersionEvent");
    this.baseUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBaseURIToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing AssignBaseURIToSteadyStateHypothesisVersionEvent");
    this.baseURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBaseURIFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignBaseURIFromSteadyStateHypothesisVersionEvent");
    this.baseURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDateToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing AssignDateToSteadyStateHypothesisVersionEvent");
    this.date = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDateFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDateFromSteadyStateHypothesisVersionEvent");
    this.date = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDifferenceModelURIToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing AssignDifferenceModelURIToSteadyStateHypothesisVersionEvent");
    this.differenceModelURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignDifferenceModelURIFromSteadyStateHypothesisVersionEvent");
    this.differenceModelURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeUMLToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeUMLToSteadyStateHypothesisVersionEvent");
    this.entsoeUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeUMLFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeUMLFromSteadyStateHypothesisVersionEvent");
    this.entsoeUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEntsoeURIToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing AssignEntsoeURIToSteadyStateHypothesisVersionEvent");
    this.entsoeURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEntsoeURIFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignEntsoeURIFromSteadyStateHypothesisVersionEvent");
    this.entsoeURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignModelDescriptionURIToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing AssignModelDescriptionURIToSteadyStateHypothesisVersionEvent");
    this.modelDescriptionURI = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignModelDescriptionURIFromSteadyStateHypothesisVersionEvent");
    this.modelDescriptionURI = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceRDFToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceRDFToSteadyStateHypothesisVersionEvent");
    this.namespaceRDF = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceRDFFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceRDFFromSteadyStateHypothesisVersionEvent");
    this.namespaceRDF = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNamespaceUMLToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing AssignNamespaceUMLToSteadyStateHypothesisVersionEvent");
    this.namespaceUML = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNamespaceUMLFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignNamespaceUMLFromSteadyStateHypothesisVersionEvent");
    this.namespaceUML = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignShortNameToSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing AssignShortNameToSteadyStateHypothesisVersionEvent");
    this.shortName = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignShortNameFromSteadyStateHypothesisVersionEvent event) {
    LOGGER.info("Event sourcing UnAssignShortNameFromSteadyStateHypothesisVersionEvent");
    this.shortName = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID steadyStateHypothesisVersionId;

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
      Logger.getLogger(SteadyStateHypothesisVersionAggregate.class.getName());
}
